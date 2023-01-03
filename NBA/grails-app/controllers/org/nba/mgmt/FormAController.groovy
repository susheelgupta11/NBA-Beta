package org.nba.mgmt
import org.nba.application.AgentProfile
import org.nba.application.ApplicationForm1
import com.lowagie.text.pdf.PdfReader
import org.nba.application.IndividualProfile
import org.nba.application.CompanyProfile
import org.nba.master.MstrDocument
import org.nba.common.Country
import org.nba.common.State
import org.springframework.util.StringUtils
import org.nba.application.FormCategory
import org.nba.resource.BiologicalResource
import org.nba.resource.GeoLocationOfBioResource
import org.nba.resource.GeoLocationOfCommunity
import org.springframework.security.access.annotation.Secured

@Secured('permitAll')
class FormAController {

	def springSecurityService
	def applicationMgmtService
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
			println ""
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
	
	def form1FormA={
		println "Inside part 4 "+params
		def listOfStates = State.list()
		def appForm
		def newList  = []
		flash.message = params?.msg1
		if(params?.appFormId != '' || params?.appFormId != null){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		else if(session.getAttribute("appFormId") != null){
			appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
		}
		def resources = ['Stem', 'Seed', 'Fruit', 'Root', 'Leaf', 'DNA', 'Others']
		def listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm,[sort: 'scientificName', order: 'asc'])
		println "listOfBioResources == "+listOfBioResources

		listOfBioResources?.each{
			println "it?.scientificName == "+it?.scientificName.equals(null)
			if(it?.scientificName?.equals(null) == false){
				println "contrins null"
				newList.add(it)
			}
		}
	
		
		println "appForm == "+appForm
		def formType = params.formType
		println "formType == "+formType
		def bioResourceEditId=BiologicalResource.get(params.bioResourceEditId)

		// a. get Question by question Category


		// b. get question answer map from service.
	
		[appForm:appForm,resources:resources,listOfBioResources:listOfBioResources,formType:formType,bioResourceEditId:bioResourceEditId,listOfStates:listOfStates]

	}
	
	def saveBioProfile={
		print "...saveBioProfile........"+params
		def csrfPreventionSalt = params.csrfPreventionSalt
		print "...appformid........"+params.appFormId
		def appForm = ApplicationForm1.get(params.appFormId)
		def bioResourceObj = BiologicalResource.get(params.bioResourceInstID)
		println "--appForm---"+appForm
		if(params.ratePerUnit != null || params.stateBiodeversityBoard != null || params.prospectiveBuyers != null)
		{
			print "...checking for null...."
			bioResourceObj.ratePerUnit = params.ratePerUnit
			bioResourceObj.stateBiodeversityBoard= params.stateBiodeversityBoard
			bioResourceObj.prospectiveBuyers= params.prospectiveBuyers
			
		}
		if(!bioResourceObj.save(flush:true)){
			bioResourceObj.error.each{ println it }
		}

		if(!appForm.save(flush:true)){
			appForm.errors.each{println it}
		}
		redirect(action:"form1FormA",params:[csrfPreventionSalt:csrfPreventionSalt,appFormId:params.appFormId,formType:params.formType])
}
	
	def submitFormAUnderTaking={
		print "...submitFormAUnderTaking........"+params
		def csrfPreventionSalt = params.csrfPreventionSalt
		def appForm = ApplicationForm1.get(params.appFormId)
	appForm.conditionOfAbs= params.conditionOfAbs
	appForm.approvalOfNba= params.approvalOfNba
	appForm.recordsWithTheNba= params.recordsWithTheNba
	appForm.infromationTrue= params.infromationTrue
	if(!appForm.save(flush:true)){
		appForm.errors.each{println it}
	}
	
	
	def submitDepositionOfMicroOrganism={
		print "...submitFormAUnderTaking........"+params
		
	}
	redirect(action:"form1FormA",params:[csrfPreventionSalt:csrfPreventionSalt,appFormId:params.appFormId,formType:params.formType])
		}
	
	def editBioProfile={
		
		def csrfPreventionSalt = params.csrfPreventionSalt
		print "...editbioprofile........"+params
		def appForm = ApplicationForm1.get(params.appFormId)
		def bioResourceObj = BiologicalResource.get(params.bioResourceInstID)
		println "--appForm---"+appForm
		def appFormId=params.appFormID
		def formType=params.formType
		def bioResource=params.bioResource
		redirect(action:"form1FormA",params:[csrfPreventionSalt:csrfPreventionSalt,bioResourceEditId:bioResource,appFormId:appFormId,formType:formType])
	
}
	def uploadBenefitSharingProof={
		println "params----"+params
		
		def benefitSharingProof,benefitSharingFileName,appForm
		def csrfPreventionSalt = params?.csrfPreventionSalt
		appForm = ApplicationForm1.get(params.appFormId)
		
		if(params?.benefitSharingProof != '' && params?.benefitSharingProof?.getBytes()?.size() != 0){
			
			benefitSharingProof = request?.getFile('benefitSharingProof')
			benefitSharingFileName = 'Benefit_Sharing_Proof'
			
			appForm?.benefitSharingProofFile = benefitSharingProof?.getBytes()
			appForm?.benefitSharingProofFilename = benefitSharingFileName
			
			if(benefitSharingProof != null && benefitSharingProof?.getBytes()?.size() != 0){
				
				def file = request.getFile('benefitSharingProof')
				int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
				def nullByteCheck = file.getOriginalFilename().contains('%00')
				if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
					println '====================='
					flash.message = "Wrong format of pdf"
					forward(action: "form1FormA", params: [msg1: 'Please upload file in pdf document format only!',
						appFormId:params.appFormId])
				}
				if (occurance > 1) {
					println '###################'
					flash.message = "Wrong format of pdf"
					forward(action: "form1FormA", params: [msg1: 'Please upload file and file must be .pdf document format only!',
						appFormId:params.appFormId])

				}

				try {
					PdfReader pdf = new PdfReader(file.getBytes())
					if(pdf && pdf.pdfVersion){}
					else{
						flash.message = "Wrong format of pdf"
						forward(action: "form1FormA", params: [msg1: 'Wrong format of pdf!',appFormId:params.appFormId])
					}
				}catch (Exception e){
					println e.message
					flash.message = "Wrong format of pdf"
					forward(action: "form1FormA", params: [msg1: 'Wrong format of pdf!',appFormId:params.appFormId])

				}
			
			}
			
		}
		if(!appForm.save(flush:true)){
			appForm.errors.each{ println it }
		}
		redirect(action: "form1FormA", params: [appFormId:params.appFormId,csrfPreventionSalt:csrfPreventionSalt, formType:params?.formType])
	}
	
	def showAppDc(long id){
		
		println"```````````````````````````````show diclration````````````````````````````````````````````"+params

		ByteArrayOutputStream ous = null;
		InputStream ios = null;
		def csrfPreventionSalt = params?.csrfPreventionSalt
		def appForm= ApplicationForm1.findById(id)
		def file,filename
		if(params.filename == 'benefitSharingProof'){
			file = appForm?.benefitSharingProofFile
			filename = appForm?.benefitSharingProofFilename
		}
		

		//println "FILE == "+file
		byte[] DocContent = null;
		DocContent = file
		response.setHeader "Content-disposition", "inline; filename=filename"
		response.contentType = 'application/pdf'
		response.outputStream << DocContent
		response.outputStream.flush()
	
	}
	
	

}
