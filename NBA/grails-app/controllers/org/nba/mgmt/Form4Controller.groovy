package org.nba.mgmt
import com.lowagie.text.pdf.PdfReader
import java.text.SimpleDateFormat
import org.springframework.util.StringUtils
import org.springframework.security.access.annotation.Secured
import org.nba.application.ApplicationForm1
import org.nba.master.MstrDocument
import org.nba.application.FormCategory
import org.nba.master.QuestionCategory
import org.nba.resource.BiologicalResource
import org.nba.resource.GeoLocationOfBioResource
import org.nba.resource.GeoLocationOfCommunity
import org.nba.resource.ThirdParty
import org.nba.common.Country

@Secured('permitAll')
class Form4Controller {
	def springSecurityService
	def applicationMgmtService
	def grailsApplication
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	def beforeInterceptor = [action: this.&invokeMeBeforeEveryLoad]
	def afterInterceptor = [action: this.&invokeMeAfterEveryLoad]

	private invokeMeBeforeEveryLoad (model){
		println "In invokeMeBeforeEveryLoad"
		println "Tracing action ${actionUri}"
		//println "Timestamp is "+Date.getDateTimeString()

	}


	private invokeMeAfterEveryLoad(model) {
		//1.
		def tabStatus
		println "In invokeMeAfterEveryLoad"
		println "Tracing action ${actionUri}"
		println "SESSION CONTENT == " + session
		if(session.getAttribute('appFormId') != null){
			model?.sessionCheck = sessionCheck()
		}
		else{
			//session.setAttribute('appFormId')
			model?.sessionCheck = sessionCheck()
		}
		
		def agent = ApplicationForm1.get(session.getAttribute('appFormId'))?.agentProfile
		println "agentagentagentagentagent###################################################"+agent
		
		if(agent != null){
			tabStatus = applicationMgmtService.findTabsStatus(ApplicationForm1.get(session.getAttribute('appFormId')),agent)
		}
		else if(agent == null){
			tabStatus = applicationMgmtService.findTabsStatus(ApplicationForm1.get(session.getAttribute('appFormId')),null)
		}
		
		println "tabStatus "+tabStatus
		model?.tabStatus = tabStatus
		println "Current model is ${tabStatus}"

	}

	private boolean sessionCheck(){
		def sessionAvailable
		println "SESS CONTENT "+session.getAttribute('appFormId')
		if(session.getAttribute('appFormId') == null){
			sessionAvailable = false
		}
		else{
			sessionAvailable = true
		}
		return sessionAvailable
	}
	
	
	def index() {
		def formType = params.formType
		println "formType == "+formType
		redirect(action:"selectIndividualOrCompany",controller:"applicationManagement",params:[formType:formType])
	}
	def form4Payment={
	}

	def part2 = {
		def formType = params.formType
		println "formType == "+formType
		println "Inside saveConsent "+params

		//1.
		def appForm
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		println "appForm == "+appForm
		//2.
		def listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)
		println "listOfBioResources == "+listOfBioResources

		def resources = ['Stem', 'Seed', 'Fruit', 'Root', 'Leaf','DNA', 'Others']

		def accessSources = ['Wild', 'Cultivated', 'Market', 'Trader', 'Repositories', 'Institution', 'Others']
		def quantityList  = ['unit(s)', 'ml', 'kg', 'vials', 'slants','tonne']
		def natureOfReources = ['Plant', 'Animal', 'Micro-organism']

		//fetch geo location rows
		def listOfLocations = []
		for(bioResorce in listOfBioResources){
			def bioResourceLocations = GeoLocationOfBioResource.findAllByBioResource(bioResorce)
			for(loc in bioResourceLocations){
				if(loc.state != null && loc.district != null && loc.town != null && loc.traderName != null && loc.traderContactDetails != null){
					listOfLocations.add(loc)
				}
			}
		}
		println "listOfLocations == "+listOfLocations
		[listOfLocations:listOfLocations,appForm:appForm,formType:formType,listOfBioResources:listOfBioResources,resources:resources,
			accessSources:accessSources,quantityList:quantityList,natureOfReources:natureOfReources]
	}

	def savePart2 = {
		def formType = params.formType
		println "formType == "+formType
		println "Inside savePart2 "+params
        def csrfPreventionSalt = params.csrfPreventionSalt
		
		//1.
		def appForm
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		//2.
		def nbaApproval,nbaApprovalFileName,mouFile,mouFileName
		if(params.NBAApproval != '' && params.NBAApproval?.getBytes()?.size() != 0){
			nbaApproval = request.getFile('NBAApproval')
			nbaApprovalFileName = "NBAApproval"
//			appForm.nbaApprovalFile = nbaApproval.getBytes()
//			appForm.nbaApprovalFileName = nbaApprovalFileName
			println "!!!!!!!!!!!!!!!!!!!!!!!!!!"
			if (nbaApproval != null && nbaApproval?.getBytes()?.size() != 0) {
				println "@@@@@@@@@@@@@@@@@@@@@@@@@"
				def file = request.getFile('NBAApproval')
				int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
				def nullByteCheck = file.getOriginalFilename().contains('%00')
				if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
					println '====================='
					flash.message = "Wrong format of pdf"
					forward(action: "part2", params: [msg1: 'Please upload file in pdf document format only!',
																 appFormId:params.appFormId])
				}
				if (occurance > 1) {
					println '###################'
					flash.message = "Wrong format of pdf"
					forward(action: "part2", params: [msg1: 'Please upload file and file must be .pdf document format only!',
																 appFormId:params.appFormId])

				}

				try {
					PdfReader pdf = new PdfReader(file.getBytes())
					if(pdf && pdf.pdfVersion){
						new File(grailsApplication.config.nbaApproval.toString() + File.separatorChar +"approval-doc").mkdirs()
						def filePath = new File(grailsApplication.config.nbaApproval.toString() + File.separatorChar + "approval-doc"+ File.separatorChar + file.getOriginalFilename());
					   
						  file.transferTo(filePath)
						 appForm.nbaApprovalFileURL = filePath;
//						appForm.nbaApprovalFile = nbaApproval.getBytes()
						appForm.nbaApprovalFileName = nbaApprovalFileName
					}
					else{
						flash.message = "Wrong format of pdf"
						forward(action: "part2", params: [msg1: 'Wrong format of pdf!',appFormId:params.appFormId])
						return
						}
				}catch (Exception e){
					println e.message
					flash.message = "Wrong format of pdf"
					forward(action: "part2", params: [msg1: 'Wrong format of pdf!',appFormId:params.appFormId])
					return
				}
			}
		}
		
		/*if(params.MOUFile != ''){
		 mouFile = request.getFile('MOUFile')
		 mouFileName = "MOUFile"
		 appForm.mouFile = mouFile.getBytes()
		 appForm.mouFileName = mouFileName
		 }*/
		if(params.applicationNo != '' && params.dateOfApproval != '' && params.traditionalKnowledgeDesc != ''){

			appForm.applicationNo = params.applicationNo

			def formatter = new SimpleDateFormat('dd/MM/yyyy')
			println "DATE == "+formatter.parse(params.dateOfApproval)
			def approvalDate = formatter.parse(params.dateOfApproval)

			appForm.dateOfApproval = approvalDate
			
			if(params.isbenefitSharingDetailImplemented == 'Yes'){
				appForm.isbenefitSharingDetailImplemented = 'true'
			}else if(params.isbenefitSharingDetailImplemented == 'No'){
				appForm.isbenefitSharingDetailImplemented = 'false'
			}
			
			if(params.benefitMechanism != null)
				appForm.benefitMechanism = params.isbenefitSharingDetailImplemented == 'Yes' ? params.benefitMechanism : null
			
			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}
			redirect(action:"part2",params:[csrfPreventionSalt:csrfPreventionSalt,formType:formType,appFormId:appForm?.id])
		}
		
	}
	def showDc(long id){
		println "PARAms are == "+params
		ByteArrayOutputStream ous = null;
		InputStream ios = null;
		def appForm= ApplicationForm1.get(params?.id)
		def file,filename

		if(params.filename == 'nbaApprovalFileName'){
			
			if(params.nbaApprovalPart2 == 'part2'){
				
				if(appForm.nbaApprovalFile){
					
					file = appForm.nbaApprovalFile
					
				} else if(appForm.nbaApprovalFileURL){
				
				file = new File(appForm.nbaApprovalFileURL)?.getBytes()
				}
				
				
			}
			else if(params.nbaApprovalPart3 == 'part3'){
				
				if(appForm.agreementBtwnApplicantAndThirdParty){
					file = appForm.agreementBtwnApplicantAndThirdParty
					
				} else if(appForm.agreementBtwnApplicantAndThirdPartyURL){
				file = new File(appForm.agreementBtwnApplicantAndThirdPartyURL)?.getBytes()
				}
		
			}
			filename = appForm.nbaApprovalFileName
		}
		else if(params.filename == 'mouFileName'){

			if(appForm.mouFile){
				file = appForm.mouFile
			}else if(appForm.mouFileURL){
				file = new File(appForm.mouFileURL)?.getBytes()
			}

			filename = appForm.mouFileName
		}

		//println "FILE == "+file
		byte[] DocContent = null;
		DocContent = file
		response.setHeader "Content-disposition", "inline; filename=filename"
		response.contentType = 'application/pdf'
		response.outputStream << DocContent
		response.outputStream.flush()
	}
	def part3 = {
		def appForm
		println "appFormId.........."+params.appFormId
		if(params.thirdPartyInstId != ''){

			if(params.appFormId != ''){
				appForm = ApplicationForm1.get(params?.appFormId)
			}
			def thirdPartyInst = ThirdParty.get(params.thirdPartyInstId)
			def listOfCountries = Country.list()
			def listOfThirdParty = ThirdParty.findAllByApplicationForm(appForm)
			[listOfCountries:listOfCountries,thirdPartyInst:thirdPartyInst,listOfThirdParty:listOfThirdParty,appForm:appForm,formType:params.formType]
		}

		else{
			println "formtype"+params.formType
			def formType = params.formType
			println "formType == "+formType
			//1.
			if(params.appFormId != ''){
				appForm = ApplicationForm1.get(params?.appFormId)
			}
			//2.
			def purposeList = ['Reasearch', 'Bio-survey and bio-utilization', 'Commercial utilization']

			//3.
			// a. get Question by question Category
			def quesCategory = QuestionCategory.findByCategory(QuestionCategory.Category.Form_4)
			println("quesCategory:" + quesCategory)

			// b. get question answer map from service.
			def quesAnswerMap = applicationMgmtService.getFormQuestionAnswers(appForm, quesCategory)
			println "Question Answer MAP == " + quesAnswerMap

			def listOfCountries = Country.list()

			def listOfThirdParty = ThirdParty.findAllByApplicationForm(appForm)
			[formType:formType,listOfThirdParty:listOfThirdParty,appForm:appForm,purposeList:purposeList,quesCategory:quesCategory,quesAnswerMap:quesAnswerMap,listOfCountries:listOfCountries]
		}
	}

	def savePart3 = {
		def formType = params.formType
		println "formType == "+formType
		println "Inside savePart3 "+params
		def csrfPreventionSalt = params.csrfPreventionSalt

		//1.
		def appForm
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		if(appForm != null){
			appForm.thirdPartyTransferPurpose = params.thirdPartyTransferPurpose
			appForm.benefitsToTheThirdParty = params.benefitsToTheThirdParty
			
			appForm.benefitsOutOfThirdPartyTransfer = params.benefitsOutOfThirdPartyTransfer
			appForm.mechanismOutOfThirdPartyTransfer = params.mechanismOutOfThirdPartyTransfer
			appForm.otherRelevantInfo = params.otherRelevantInfo
			
//			appForm.isAgreementBwApplicantAndThirdParty = params.isAgreementEntered != null && params.isAgreementEntered == 'Yes' ? 'true' : 'false'
			
			if(params.isAgreementEntered != null && params.isAgreementEntered == 'Yes'){
				appForm.isAgreementBwApplicantAndThirdParty = 'true'
			}
			else if(params.isAgreementEntered == 'No'){
				appForm.isAgreementBwApplicantAndThirdParty = 'false'
			}
			
			println "Reached here "
			def nbaApproval,nbaApprovalFileName,file
			if(params.isAgreementEntered == 'Yes' && params.NBAApproval != '' && params.NBAApproval?.getBytes()?.size() != 0){
				nbaApproval = request.getFile('NBAApproval')
				nbaApprovalFileName = "NBAApproval"
//				appForm.agreementBtwnApplicantAndThirdParty = nbaApproval.getBytes()
//				appForm.nbaApprovalFileName = nbaApprovalFileName
				if (nbaApproval != null && nbaApproval?.getBytes()?.size() != 0) {
					file = request.getFile('NBAApproval')
					int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
					def nullByteCheck = file.getOriginalFilename().contains('%00')
					if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
						println '====================='
						flash.message = "Wrong format of pdf"
						forward(action: "part3", params: [msg1: 'Please upload file in pdf document format only!',
																	 appFormId:params.appFormId])
					}
					if (occurance > 1) {
						println '###################'
						flash.message = "Wrong format of pdf"
						forward(action: "part3", params: [msg1: 'Please upload file and file must be .pdf document format only!',
																	 appFormId:params.appFormId])
	
					}
	
					try {
						PdfReader pdf = new PdfReader(file.getBytes())
						if(pdf && pdf.pdfVersion){
							
							new File(grailsApplication.config.agreementBtwnApplicantAndThirdParty.toString() + File.separatorChar +"Agreement").mkdirs()
							def filePath = new File(grailsApplication.config.agreementBtwnApplicantAndThirdParty.toString() + File.separatorChar + "Agreement"+ File.separatorChar + file.getOriginalFilename());
						   
							 file.transferTo(filePath)
							 appForm.agreementBtwnApplicantAndThirdPartyURL = filePath;
							
//							appForm.agreementBtwnApplicantAndThirdParty = nbaApproval.getBytes()
							appForm.agreementBtwnApplicantAndThirdPartyFileName = nbaApprovalFileName
						}
						else{
							flash.message = "Wrong format of pdf"
							forward(action: "part3", params: [msg1: 'Wrong format of pdf!',appFormId:params.appFormId])
							return
							}
					}catch (Exception e){
						println e.message
						flash.message = "Wrong format of pdf"
						forward(action: "part3", params: [msg1: 'Wrong format of pdf!',appFormId:params.appFormId])
						return
					}
				}
			}
			else if(appForm.isAgreementBwApplicantAndThirdParty == 'false'){
				appForm.agreementBtwnApplicantAndThirdParty = null
			}

			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}
			println "Done till here"
			//Saving question answers

			def quesCategory = QuestionCategory.findById(params.quesCategory)

			println "Saving Answers....."

			def questionIdAnswerStringMap = [:]
			params.each {key, value ->
				if (key.startsWith("answer_")) {
					def keyTokens = key.tokenize("_")
					println keyTokens

					def quesId = keyTokens.last()
					println "quesId " + quesId
					def answer = value?.trim()
					println "answer " + answer

					questionIdAnswerStringMap.put(quesId, answer)
					println "Putting in map quesId=" + quesId + " answer=" + answer
				}
			}
			println "questionIdAnswerStringMap=" + questionIdAnswerStringMap

			applicationMgmtService.saveQuestionAnswers(appForm, quesCategory, questionIdAnswerStringMap )

			println "Returned from projectService.saveProjectQuestionAnswers. "

			redirect(action:"part3",params:[csrfPreventionSalt:csrfPreventionSalt,formType:formType,appFormId:appForm?.id])
		}
	}


	def saveThirdParty = {
		println "under save Third Party!!!!!"+params

		def thirdPartyInstUpdate,appForm,thirdPartyInst,thirdpartyEmail
		if(params.email != null){
			thirdpartyEmail = (params.email)?.toLowerCase()
		}
		
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		if(params.thirdPartyInstId != ''){
			thirdPartyInstUpdate = ThirdParty.get(params.thirdPartyInstId)
			
			thirdPartyInstUpdate?.isIndividual = params?.indivOrEntity == 'Individual' ? true : false
			thirdPartyInstUpdate.name = params.detailsOfInstitute
			thirdPartyInstUpdate.addressForComm = params.instituteAddress
			thirdPartyInstUpdate.state = params.state
			thirdPartyInstUpdate.pincode = params.pincode
			if(params.country != ''){
				thirdPartyInstUpdate.country = Country.get(params.country)?.country
			}
			thirdPartyInstUpdate.phone = params.phone
			thirdPartyInstUpdate.fax = params.fax
			thirdPartyInstUpdate.website = params.website
			thirdPartyInstUpdate.email = thirdpartyEmail

			if(!thirdPartyInstUpdate.save(flush:true)){
				thirdPartyInstUpdate.errors.each{println it}
			}
		}

		else{
			thirdPartyInst = new ThirdParty(applicationForm:appForm)
			if(params.indivOrEntity == "Individual"){
				thirdPartyInst.isIndividual = true
			}else{
				thirdPartyInst.isIndividual = false
			}
			thirdPartyInst.name = params.detailsOfInstitute
			thirdPartyInst.addressForComm = params.instituteAddress
			thirdPartyInst.state = params.state
			thirdPartyInst.pincode = params.pincode
			if(params.country != ''){
				thirdPartyInst.country = Country.get(params.country)?.country
			}
			thirdPartyInst.phone = params.phone
			thirdPartyInst.fax = params.fax
			thirdPartyInst.website = params.website
			thirdPartyInst.email = thirdpartyEmail

			if(!thirdPartyInst.save(flush:true)){
				thirdPartyInst.errors.each{println it}
			}
		}
		def listOfThirdParty = ThirdParty.findAllByApplicationForm(appForm)
		render(template:"thirdPartyGrid", model:[formType:params?.formType,listOfThirdParty:listOfThirdParty,appForm:appForm])
//		redirect(action:"part3", params:[formType:params?.formType,listOfThirdParty:listOfThirdParty,appFormId:appForm?.id] )
//		forward(action:"part3",params:[formType:params?.formType,listOfThirdParty:listOfThirdParty,appFormId:appForm?.id])
		}

	def deleteThirdParty = {
		def thirdPartyInst,listOfThirdParty,appForm
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		if(params.thirdPartyInstId != '' && params.thirdPartyInstId != null){
			thirdPartyInst = ThirdParty.get(params.thirdPartyInstId)
			thirdPartyInst.delete(flush:true)

			listOfThirdParty = ThirdParty.findAllByApplicationForm(appForm)
			render(template: "thirdPartyGrid", model : [listOfThirdParty:listOfThirdParty,formType:params?.formType,appForm:appForm])
		}
	}

	def part5 = {
		def formType = params.formType
		println "formType == "+formType
		def appForm
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		def declarationForm = MstrDocument.findByDocName("DeclarationForm4")
		[formType:formType,declarationForm:declarationForm,appForm:appForm]
	}

	def savePart5 = {

		def formType = params.formType
		println "formType == "+formType
		def appForm
		println "In  saveForm1Part5 "+params
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		def declarationForm,declarationFormName
		if(params.DeclarationForm != ''){
			declarationForm = request.getFile('DeclarationForm')
			declarationFormName = "DeclarationForm"
		}
		if(appForm != null){
			appForm.declarationForm = declarationForm.getBytes()
			appForm.declarationFormName = declarationFormName

			if(!appForm.save()){
				appForm.errors.each{ println it }
			}
			redirect(action:"form1Part5",params:[formType:formType,params:[formType:formType,appFormId:appForm?.id]])
		}
	}

	def showDeclarationForm = {
		println"```````````````````````````````show diclration````````````````````````````````````````````"+params

		ByteArrayOutputStream ous = null;
		InputStream ios = null;
		def document= MstrDocument.findById(params.id)
		def file,filename
		if(document != null ){
			file = document.document
			filename = document.docName

		}
		//println "FILE == "+file
		byte[] DocContent = null;
		DocContent = file
		response.setHeader "Content-disposition", "inline; filename="+filename+".docx"
		response.contentType = 'application/msword'
		response.outputStream << DocContent
		response.outputStream.flush()
	}

	def showSignedDeclarationForm = {
		println "PARAms are == "+params
		ByteArrayOutputStream ous = null;
		InputStream ios = null;
		def appForm= ApplicationForm1.get(params?.id)
		def file,filename
		if(params.filename == 'declarationFormName'){
			file = appForm.declarationForm
			filename = appForm.declarationFormName
		}

		//println "FILE == "+file
		byte[] DocContent = null;
		DocContent = file
		response.setHeader "Content-disposition", "inline; filename="+filename
		response.contentType = 'application/vnd.openxmlformats-officedocument.wordprocessingml.document'
		response.outputStream << DocContent
		response.outputStream.flush()
	}
	
	
}
