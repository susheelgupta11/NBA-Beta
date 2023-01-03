package org.nba.expert
import grails.plugin.springsecurity.annotation.Secured
import groovy.sql.Sql

import org.hibernate.SessionFactory
import org.nba.application.AppStatus
import org.nba.application.ApplicationForm1
import org.nba.application.CompanyProfile
import org.nba.application.ContactDetailsOfRepository
import org.nba.application.ContactPerson
import org.nba.application.DepositionOfMicroOrganism
import org.nba.application.FormB
import org.nba.application.FormCategory
import org.nba.application.IndianGovtInst
import org.nba.application.IndianResearcher
import org.nba.application.IndividualProfile
import org.nba.communication.ClientLetter
import org.nba.communication.LetterCommunication
import org.nba.communication.LetterStatus
import org.nba.communication.PeriodicFileAttach
import org.nba.communication.PeriodicReport
import org.nba.communication.ResponceLetterStatus
import org.nba.resource.BiologicalResource
import org.nba.resource.GeoLocationOfBioResource
import org.nba.review.AddNote
import asset.pipeline.grails.AssetResourceLocator
import com.nba.constant.Constants

@Secured('permitAll')
class ApplicantController {

	def springSecurityService
	def letterIntegrationService
	def checklistManagementService
	def fileUploadService
	def periodicReportService
	def exportService
	def grailsResourceLocator
	def pdfRenderingService
	def applicationMgmtService
	AssetResourceLocator assetResourceLocator
	def applicationNotingService
	
	SessionFactory sessionFactory;

	def applicantDash(){

		def csrfPreventionSalt = params.csrfPreventionSalt

		def	applicationDetails = ApplicationForm1.createCriteria().list() {

			eq('submittedBy', springSecurityService.currentUser)
			and{
				currentStatus{
					ne('status', AppStatus.Status.PENDING)
					ne('status', AppStatus.Status.NBA_PENDING)
				}
			}
		}


		def	pendingApplication = ApplicationForm1.createCriteria().list() {

			eq('submittedBy', springSecurityService.currentUser)
			and{
				
				currentStatus{
					or{
					eq('status', AppStatus.Status.PENDING)
					eq('status', AppStatus.Status.NBA_PENDING)
					}
				}
			}
		}
		
		println "Pending Application"+pendingApplication
		
		 Sql sql = new Sql(sessionFactory.currentSession.connection())
		 String querySyntax = Constants.COMM_APPLICANT
		
		def notificationApp = sql.rows(querySyntax).findAll{it.received_from == springSecurityService?.getCurrentUser().username};
		
		
		
		
		
		
		println "Notify Application" +notificationApp 
		

		[applicationDetails:applicationDetails,pendingApplication:pendingApplication,
			csrfPreventionSalt:csrfPreventionSalt,notificationApp:notificationApp,params:params]
	}


	def createComment(){

		def csrfPreventionSalt = params.csrfPreventionSalt
		def commId = params.inst
		def message = params.message
		if(commId == '' || commId == null){
		 message ="Please select an application"
			redirect(action:'applicantDash',params:[csrfPreventionSalt:csrfPreventionSalt,message:message])
			return;
		}

		def formDetails = ApplicationForm1.get(commId as Long)
		def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)

		[formDetails:formDetails, csrfPreventionSalt:csrfPreventionSalt,allDataforMatching:allDataforMatching,message:message]
	}


	def sendToNBA(){

		def fileAttachedInstance
		def formId = params.formId
		def csrfPreventionSalt = params.csrfPreventionSalt
		def getAllpdfFile =  request.getFiles('files[]')
		println"file Size"+getAllpdfFile.size()

		ApplicationForm1 formDetails = ApplicationForm1.get(Long.parseLong(formId))

		if(getAllpdfFile.size() >=1){

			def confirmation = checklistManagementService.fileValidation(getAllpdfFile)

			if(confirmation == "Validate Successfully"){

				def communicationFmtInstance = new ClientLetter()

				communicationFmtInstance.bodyContent = params.comment
				communicationFmtInstance.subject = params.subject
				communicationFmtInstance.dynamicLetterNumberClientOUT = letterIntegrationService.getDynLetterNumberApplicantOut(formDetails?.appNumber)
				communicationFmtInstance.dynamicLetterNumberNbaIN = letterIntegrationService.getDynLetterNumberNbaIn(formDetails?.appNumber)
				communicationFmtInstance.letterCreateDate = new Date()
				communicationFmtInstance.letterBy = springSecurityService.getCurrentUser()
				communicationFmtInstance.applicationForm =  formDetails


				if(!communicationFmtInstance.save(flush:true)){

					communicationFmtInstance.errors.allErrors.each {println it}
				}



				fileAttachedInstance = checklistManagementService.fileAttachmentforEmail(getAllpdfFile,communicationFmtInstance,formDetails?.appNumber)


				if(fileAttachedInstance == "File upload successfully" || fileAttachedInstance == null   || fileAttachedInstance == ''){

					def changeltrStatus = letterIntegrationService.setResponceLetterStatus(communicationFmtInstance?.id,ResponceLetterStatus.LtrStatus.APPLICANT_RESPONSE)
					def communicationStatus = letterIntegrationService.setCommunicationStatusForNBA(formDetails)

					redirect(action:'sendClientLetter', params:[inst:formDetails?.id,communicationDetails:communicationFmtInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:fileAttachedInstance])
				}
				else if(fileAttachedInstance != "File upload successfully"){
					redirect(action:'createComment', params:[inst:formDetails?.id,communicationDetails:communicationFmtInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:fileAttachedInstance])
				}
			}else if(confirmation != "Validate Successfully"){

				redirect(action:'createComment', params:[inst:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt,message:confirmation])
			}
		}else{
			def communicationFmtInstance = new ClientLetter()

			communicationFmtInstance.bodyContent = params.comment
			communicationFmtInstance.subject = params.subject
			communicationFmtInstance.dynamicLetterNumberClientOUT = letterIntegrationService.getDynLetterNumberApplicantOut(formDetails?.appNumber)
			communicationFmtInstance.dynamicLetterNumberNbaIN = letterIntegrationService.getDynLetterNumberNbaIn(formDetails?.appNumber)
			communicationFmtInstance.letterCreateDate = new Date()
			communicationFmtInstance.letterBy = springSecurityService.getCurrentUser()
			communicationFmtInstance.applicationForm =  formDetails

			if(!communicationFmtInstance.save(flush:true)){

				communicationFmtInstance.errors.allErrors.each {println it}
			}

			def changeltrStatus = letterIntegrationService.setResponceLetterStatus(communicationFmtInstance?.id,ResponceLetterStatus.LtrStatus.APPLICANT_RESPONSE)
			def communicationStatus = letterIntegrationService.setCommunicationStatusForNBA(formDetails)

			redirect(action:'sendClientLetter', params:[inst:formDetails?.id,communicationDetails:communicationFmtInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:"Application Send Successfully"])

		}
	}

	def sendClientLetter(){

		def formId = params.inst
		def letterId = params.communicationDetails
		def csrfPreventionSalt = params.csrfPreventionSalt

			ApplicationForm1 formDetails = ApplicationForm1.get(formId as Long)
		//		ClientLetter clientLetter  = ClientLetter.get(letterId as Long)

		def clientLetter = ClientLetter.where{
			letterBy == springSecurityService.getCurrentUser() && applicationForm == formDetails
			
			}.list()

		[formDetails:formDetails,clientLetter:clientLetter,csrfPreventionSalt:csrfPreventionSalt]


	}

	def receivedCommunication(){
		def csrfPreventionSalt = params.csrfPreventionSalt
		def instance = params.instance

		if(instance == '' || null == instance){
			redirect(action:'applicantDash', params:[csrfPreventionSalt:csrfPreventionSalt])
			return;
		}



		def formDetails = ApplicationForm1.get(Long.parseLong(instance))

		def receivedLetter = LetterCommunication.where{

			applicationForm1 == formDetails	&& applicationForm1.submittedBy == springSecurityService.getCurrentUser() && letterStatus.ltrstatus == LetterStatus.LtrStatus.LETTER_SEND
		}.list()

		[formDetails:formDetails,receivedLetter:receivedLetter,csrfPreventionSalt:csrfPreventionSalt]

	}

	def viewLetter(){
		def showId = params.editId
		def letterDetails = LetterCommunication.get(showId as Long)
		render(template:'/common/nbaLetter', model:[letterDetails:letterDetails])
	}







	/////////////////////////////////////////Periodic Report Implementation//////////////////////////////////////////



	def createPeriodicReport(){
		def getFormInstance	= params.instance
		def csrfPreventionSalt = params.csrfPreventionSalt
		def act =params.act
		def formDetails = ApplicationForm1.get(getFormInstance as Long)


		[formDetails:formDetails,act:act,csrfPreventionSalt:csrfPreventionSalt]

	}

	def savePeriodicReport(){
		def file
		def  application = params.formId
		def csrfPreventionSalt = params.csrfPreventionSalt
		String act = params.formType
		

		if(params.publishCheck == 'Yes'){
			file = request.getFile('publishFile')
		}

		def applicationNumber = ApplicationForm1.get(application as Long)
		def periodicReportInstance
		def fileUpload = request.getFiles('files[]')
		if(fileUpload.size() >= 1){
			def fileMessage = checklistManagementService.fileValidation(fileUpload);
			if(fileMessage == "Validate Successfully"){
				periodicReportInstance = periodicReportService.savePeriodicReport(params, file, applicationNumber)
				def uploadFiles = fileUploadService.periodicFilesUpload(fileUpload, periodicReportInstance, applicationNumber.appNumber);

				if(uploadFiles == "file Upload Successfully"){
					
					def dynamicPdf = fileUploadService.generatePeriodicReportDynamicPdf(applicationNumber,periodicReportInstance,act)

					redirect(action: "showPeriodicReport", params: [instance:applicationNumber?.id, periodicReportInstance:periodicReportInstance?.id,act:act,message: uploadFiles,csrfPreventionSalt:csrfPreventionSalt])

				}
			}else{
				redirect(action:'createPeriodicReport', params: [message:fileMessage,act:act])

			}
		}else{
			periodicReportInstance = periodicReportService.savePeriodicReport(params,file, applicationNumber)
			def dynamicPdf = fileUploadService.generatePeriodicReportDynamicPdf(applicationNumber,periodicReportInstance,act)
			redirect(action: "showPeriodicReport", params:[instance:applicationNumber?.id,periodicReportInstance:periodicReportInstance?.id,act:act,message: "Record Send successfully",csrfPreventionSalt:csrfPreventionSalt])

		}
	}


	//	def updatePeriodicReport(){
	//		def file
	//		def  application = params.formId
	//		def csrfPreventionSalt = params.csrfPreventionSalt
	//		String act = params.formType
	//
	//		if(params.publishCheck == 'Yes'){
	//			file = request.getFile('publishFile')
	//		}
	//
	//		def applicationNumber = ApplicationForm1.get(application as Long)
	//		def periodicReportInstance
	//		def fileUpload = request.getFiles('files[]')
	//		if(fileUpload.size() >= 1){
	//			def fileMessage = checklistManagementService.fileValidation(fileUpload);
	//			if(fileMessage == "Validate Successfully"){
	//				periodicReportInstance = periodicReportService.updatePeriodicReport(params,file, applicationNumber)
	//				def uploadFiles = fileUploadService.periodicFilesUpload(fileUpload, periodicReportInstance, applicationNumber.appNumber);
	//				if(uploadFiles == "file Upload and Record updated Successfully"){
	//
	//					redirect(action: "showPeriodicReport", params: [instance:applicationNumber?.id, periodicReportInstance:periodicReportInstance?.id,act:act,message: uploadFiles,csrfPreventionSalt:csrfPreventionSalt])
	//
	//				}
	//			}else{
	//				redirect(action:'createPeriodicReport', params: [message:fileMessage,act:act])
	//
	//			}
	//		}else{
	//			periodicReportInstance = periodicReportService.savePeriodicReport(params,file, applicationNumber)
	//			redirect(action: "showPeriodicReport", params:[instance:applicationNumber?.id,periodicReportInstance:periodicReportInstance?.id,act:act,message: "Record Updated successfully",csrfPreventionSalt:csrfPreventionSalt])
	//
	//		}
	//	}




	def showPeriodicReport(){

		def instance = params.instance
		def periodInstance = params.periodicReportInstance
		def csrfPreventionSalt = params.csrfPreventionSalt
		def message = params.message
		String act = params.act
		def periodicReportInstance = PeriodicReport.get(Long.parseLong(periodInstance))
		def formDetails = ApplicationForm1.get(Long.parseLong(instance))

		[periodicReportInstance:periodicReportInstance,formDetails:formDetails, act:act, message:message]
	}


	def showPublishPdf(){
		def csrfPreventionSalt = params.csrfPreventionSalt
		def detailsForFile = PeriodicReport.get(params?.publishId)
		def file = new File(detailsForFile?.pathUrl)
		response.setContentType("application/pdf")
		response.setHeader("Content-disposition","filename=${file.getName()}")
		response.outputStream << file.newInputStream()

	}

	def deletePublishPdf(){
		def getDeleteIns = params.publishId
		def csrfPreventionSalt = params.csrfPreventionSalt
		def formId = params.formId
		def act = params.act
		def deletePdfInstance = PeriodicReport.get(getDeleteIns as Long)

		String fileUrl = deletePdfInstance?.pathUrl
		def getPdf = new File(fileUrl)

		if(getPdf.exists()){
			if(getPdf.delete()){
				if(!deletePdfInstance.delete(flush:true)){
					deletePdfInstance.errors.allErrors.each {print it}
				}
				redirect(action:"showPeriodicReport", params: [instance:formId, periodicReportInstance:getDeleteIns,act:act,message:"File delete successfully",csrfPreventionSalt:csrfPreventionSalt])
			}else{
				redirect(action:"showPeriodicReport", params: [instance:formId, periodicReportInstance:getDeleteIns,act:act,message:"File not found",csrfPreventionSalt:csrfPreventionSalt])
			}
		}else{
			redirect(action:"showPeriodicReport", params: [instance:formId, periodicReportInstance:getDeleteIns,act:act,message:"File not found",csrfPreventionSalt:csrfPreventionSalt])

		}

	}

	def generatePdfForPeriodicReport(){

		//	def formId = params.instance
		def periodicIns = params.periodInstance
		def csrfPreventionSalt = params.csrfPreventionSalt
		def periodicReportInstance = PeriodicReport.get(periodicIns as Long)

		renderPdf(template: "/applicant/form1Periodic", model: [periodicReportInstance: periodicReportInstance])
	}

	def receivedBS(){}


	def deleteApplication(){

		def csrfPreventionSalt = params.csrfPreventionSalt
		def delId = params.instance
		def inst = ApplicationForm1.get(Long.parseLong(delId))

		List<IndividualProfile> individualDetailsForDelete = IndividualProfile.findAllByApplicationForm1(inst)
		individualDetailsForDelete*.delete(flush:true)
		//	 individualDetailsForDelete*.removeFromApplicationForm1(inst)

		List<CompanyProfile> companyDetailsForDelete =  CompanyProfile.findAllByApplicationForm(inst)
		companyDetailsForDelete*.delete(flush:true)
		//    companyDetailsForDelete*.removeFromApplicationForm(inst)

		def agentProfile = inst?.agentProfile
		agentProfile?.discard();
		//	  agentProfile?.delete(flush:true)

		def status = inst?.currentStatus
		status?.discard();
		//	  status?.delete(flush:true)

		def form = inst?.category
		form?.discard();
		//	  form?.delete(flush:true)

		List<DepositionOfMicroOrganism> listOfDepositionOfMicroOrganism = DepositionOfMicroOrganism.findAllByApplicationForm1(inst)

		listOfDepositionOfMicroOrganism*.delete(flush:true);

		List<BiologicalResource> listOfScientistName = BiologicalResource.findAllByApplicationForm(inst)

		for(bioResorce in listOfScientistName){

			List<GeoLocationOfBioResource>	bioResourceLocations = GeoLocationOfBioResource?.findAllByBioResource(bioResorce)

			bioResourceLocations*.delete(flush:true)
			bioResourceLocations*.discard()
		}
		listOfScientistName*.delete(flush:true);
		listOfScientistName*.discard()

		List<ContactDetailsOfRepository> listOfContactDetailsOfRepository = ContactDetailsOfRepository.findAllByApplicationForm1(inst)
		println "deleting Contact Details Of Repository"+listOfContactDetailsOfRepository
		listOfContactDetailsOfRepository*.delete(flush:true)

		List<IndianResearcher> listOfIndianResearcher = IndianResearcher.findAllByApplicationForm1(inst)

		println "deleting listOfIndianResearcher "+listOfIndianResearcher
		listOfIndianResearcher*.delete(flush:true)

		List<IndianGovtInst> listOfIndianGovtInst = IndianGovtInst.findAllByApplicationForm1(inst)

		println "deleting listOfIndianGovtInst "+listOfIndianGovtInst
		listOfIndianGovtInst*.delete(flush:true)

		List<ContactPerson> listOfContactPerson = ContactPerson.findAllByApplicationForm(inst)

		println "deleting listOfContactPerson "+listOfContactPerson
		listOfContactPerson*.delete(flush:true)

		def entity1 = FormB.findByAppFormAndType(inst,FormB.EntityType.Institute)
		entity1?.delete(flush:true)

		def entity2 = FormB.findByAppFormAndType(inst,FormB.EntityType.Supervisor)
		entity2?.delete(flush:true)
		def entity3 = FormB.findByAppFormAndType(inst,FormB.EntityType.Guiding_Institute)
		entity3?.delete(flush:true)
		def entity4 = FormB.findByAppFormAndType(inst,FormB.EntityType.Guiding_Supervisor)
		entity4?.delete(flush:true)
		def entity5 = FormB.findByAppFormAndType(inst,FormB.EntityType.Funding_Agency)
		entity5?.delete(flush:true)

		if(!inst.delete(flush:true)){
			inst.errors.allErrors.each {print it}
		}
		redirect(action:'applicantDash',params:[csrfPreventionSalt:csrfPreventionSalt])
	}

	def acknowledgementDnld(){


		println "Inside confirmmessagePage == "+params
		def appForm,foreignRepo,indianRepo
		List individualProfileList = [], companyProfileList = []
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}

		individualProfileList = IndividualProfile.findAllByApplicationForm1(appForm)
		companyProfileList = CompanyProfile?.findAllByApplicationForm(appForm)
		def listOfDepositionOfMicroOrganism = DepositionOfMicroOrganism.findAllByApplicationForm1(appForm)

		//FormB
		def listOfIndianResearcher = IndianResearcher.findAllByApplicationForm1(appForm)
		def listOfIndianGovtInst = IndianGovtInst.findAllByApplicationForm1(appForm)

		foreignRepo = ContactDetailsOfRepository.findByApplicationForm1AndRepostoryType(appForm,'ForeignRepository')
		indianRepo = ContactDetailsOfRepository.findByApplicationForm1AndRepostoryType(appForm,'IndianRepository')
		println "listOfIndianResearcher%%%%%%%%%%%%%%%%%%%"+listOfIndianResearcher
		println "formType----------"+params.formType
		println "appForm == "+appForm
		def ipAddress = applicationMgmtService.getClientIpAddress(request);

		render (template:"acknowledgementDnld", model:[appForm:appForm, formType : params.formType, individualProfileList:individualProfileList, companyProfileList:companyProfileList,ipAddress:ipAddress,
			listOfDepositionOfMicroOrganism:listOfDepositionOfMicroOrganism,foreignRepo:foreignRepo,indianRepo:indianRepo,listOfIndianResearcher:listOfIndianResearcher,listOfIndianGovtInst:listOfIndianGovtInst])

	}



	def viewApplication(){

		def instance = params.instance
		def csrfPreventionSalt = params.csrfPreventionSalt
		def formDetails  =  ApplicationForm1.get(Long.parseLong(instance))
		if(formDetails?.category?.category == FormCategory.Category.Form_1){
			redirect(action:'previewForm1Info', controller:'FormPreview', params:[fromLogin:"true",appFormId:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt] )
		}
		if(formDetails?.category?.category == FormCategory.Category.Form_2){
			redirect(action:'previewForm2Info', controller:'FormPreview', params:[fromLogin:"true",appFormId:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt] )

		}
		if(formDetails?.category?.category == FormCategory.Category.Form_3){
			redirect(action:'previewForm3Info', controller:'FormPreview', params:[fromLogin:"true",appFormId:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt] )

		}
		if(formDetails?.category?.category == FormCategory.Category.Form_4){
			redirect(action:'previewForm4Info', controller:'FormPreview', params:[fromLogin:"true",appFormId:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt] )

		}
		if(formDetails?.category?.category == FormCategory.Category.Form_B){
			redirect(action:'previewFormBInfo', controller:'FormPreview', params:[fromLogin:"true",appFormId:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt] )

		}
		if(formDetails?.category?.category == FormCategory.Category.Form_C){
			redirect(action:'previewFormCInfo', controller:'FormPreview', params:[fromLogin:"true",appFormId:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt] )

		}
	}


	def fileStatus(){

		def getFormId = params.instance
		def formDetails = ApplicationForm1.get(Long.parseLong(getFormId))

		def listInstance = AddNote.findAllByApplicationForm1(formDetails,[sort: "noteDate", order: "desc"])
		println "list ---- "+listInstance
		render  template:'/applicant/progress',model:[applicationList:listInstance,formDetails:formDetails]

	}
	
     def showPeriodicDynamicPdf(){
		   
		 def csrfPreventionSalt = params.csrfPreventionSalt
		 def detailsForFile = PeriodicReport.get(params?.showId)
		 def file = new File(detailsForFile?.dyFileURL)
		 response.setContentType("application/pdf")
		 response.setHeader("Content-disposition","filename=${file.getName()}")
		 response.outputStream << file.newInputStream()
		   
	   }

}
