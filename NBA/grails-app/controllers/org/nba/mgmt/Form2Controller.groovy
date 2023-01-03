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
class Form2Controller {

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
	
	def form2Payment = {
	}

	def index() {
		def formType = params.formType
		println "formType == "+formType
		redirect(action:"selectIndividualOrCompany",controller:"applicationManagement",params:[formType:formType])
	}

	def part2 = {
		def formType = params.formType
		println "formType == "+formType

		println "Inside part 2 "+params
		println "CURRENT uSEr "+springSecurityService.currentUser
		def appForm
		flash.message = params?.msg1
		if(params?.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}
		println "appForm == "+appForm
		def listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)
		println "listOfBioResources == "+listOfBioResources

		def resources = ['Stem', 'Seed', 'Fruit', 'Root', 'Leaf', 'DNA', 'Others']
		def accessSources = ['Wild', 'Cultivated', 'Market', 'Trader', 'Repositories', 'Institution', 'Others']
		def quantityList  = ['unit', 'ml', 'kg', 'vials', 'slants','tonne']
		def natureOfReources = ['Plant', 'Animal', 'Micro-organism']

		def newList  = []
		listOfBioResources?.each{
			println "it?.scientificName == "+it?.scientificName.equals(null)
			if(it?.scientificName?.equals(null) == false){
				println "contrins null"
				newList.add(it)
			}
		}
		println "newList deleted "+newList

		//fetch geo location rows
		def listOfLocations = []
		for(bioResorce in listOfBioResources){
			def bioResourceLocations = GeoLocationOfBioResource.findAllByBioResource(bioResorce)
			for(loc in bioResourceLocations){
				//if(loc.state != null && loc.district != null && loc.town != null && loc.traderName != null && loc.traderContactDetails != null){
				listOfLocations.add(loc)
				//}
			}
		}
		println "listOfLocations == "+listOfLocations
		[listOfStates:State.list(),newList:newList,listOfLocations:listOfLocations,formType:formType,quantityList:quantityList,appForm:appForm,natureOfReources:natureOfReources,listOfBioResources:listOfBioResources,resources:resources,accessSources:accessSources]
	}

	def saveResearchResults = {
		println "Inside saveResearchResults "

		def formType = params.formType
		println "formType == "+formType
		def csrfPreventionSalt = params.csrfPreventionSalt

		def appForm
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}
		if(params.briefDescription && params.resultsOfResearch){
			appForm.briefDescription = params.briefDescription
			appForm.resultsOfResearch = params.resultsOfResearch

			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it}
			}
			println "saved successfully !!!"
		}

		redirect(action:"part2",params:[csrfPreventionSalt:csrfPreventionSalt,formType:formType,appFormId:appForm?.id])
	}

	def saveNbaApproval = {
		println " Inside saveNbaApproval"+params
		def formType = params.formType
		println "formType == "+formType
		def appForm
		def csrfPreventionSalt = params.csrfPreventionSalt
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}

		def nbaApproval,nbaApprovalFileName

		if(params.isNbaApprovalObt != '' || params.isNbaApprovalObt != null)
			appForm.isApprovalOfNbaObtained = params.isNbaApprovalObt == 'Yes' ? 'true' : 'false'

		if(params.NBAApproval != '' ){
			
		  if( params?.NBAApproval?.getBytes()?.size() != 0){	
			nbaApproval = request.getFile('NBAApproval')
			nbaApprovalFileName = "NBAApproval"
//			appForm.nbaApprovalFile = nbaApproval.getBytes()
//			appForm.nbaApprovalFileName = nbaApprovalFileName
			if (nbaApproval != null && nbaApproval?.getBytes()?.size() != 0) {
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
						
						appForm.nbaApprovalFile = nbaApproval.getBytes()
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

				}
			}
		  }
		  else if(appForm.isApprovalOfNbaObtained == 'false') {
			  appForm.nbaApprovalFile = null
			  }
		  
			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}
			redirect(action:"part2",params:[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:csrfPreventionSalt])
		}
	}

	def showDc(long id){
		println "PARAms are == "+params
		ByteArrayOutputStream ous = null;
		InputStream ios = null;
		def appForm= ApplicationForm1.get(params?.id)
		def file,filename
		def csrfPreventionSalt = params.csrfPreventionSalt
		if(params.filename == 'nbaApprovalFileName'){
           if(appForm.nbaApprovalFile){
              file = appForm.nbaApprovalFile
		   }else if(appForm.nbaApprovalFileURL){
             file = new File(appForm.nbaApprovalFile)?.getBytes()
		   }
			
			filename = appForm.nbaApprovalFileName
		}
		 if(params.filename == 'bonafideLetterName'){
			if(appForm.bonafideLetter){

             file = appForm.bonafideLetter

			}else if(appForm.bonafideLetterURL){
         
		     file = new File(appForm.bonafideLetterURL)?.getBytes()

			}
			
			filename = appForm.bonafideLetterName
		}
		 if(params.filename == 'mouFileName'){
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
		println "inside part3 "+params
		def formType = params.formType
		println "formType == "+formType
		def appForm
		flash.message = params.msg1
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}
		def listOfCommunityLocations = GeoLocationOfCommunity.findAllByAppForm(appForm)
		println "listOfCommunityLocations == "+listOfCommunityLocations
		[listOfCommunityLocations:listOfCommunityLocations,appForm:appForm,formType:formType,listOfStates:State.list()]
	}

	def savePart3 = {
		println "Inside savePart3 "+params
		def formType = params.formType
		println "formType == "+formType
		def csrfPreventionSalt = params.csrfPreventionSalt
		def appForm
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}
		
		if(params.isNoForTraditional != null && params.isNoForTraditional == 'No'){
			appForm.isNoForTraditional = 'No'
			appForm.nature = null
			appForm.traditionalKnowledgeDesc = null
		}
		else{
			appForm.isNoForTraditional = null
		}

		def bonafideLetter,bonafideLetterName
		

		if(appForm != null){

			println "inside saving if---------------"
			appForm.consentObtained = params.group1 == 'Yes' ? 'true' : 'false'
			appForm.isResearchParticipation = params.instituteParticipation == 'Yes' ? 'true' : 'false'
			

			if(params.traditionalKnowledgeSource != '' || params.traditionalKnowledgeSource != null)
				appForm.traditionalKnowledgeSource = params.traditionalKnowledgeSource

			if(params.detailsOfInstitute != '' || params.detailsOfInstitute != null)
				appForm.detailsOfInstitute = params.detailsOfInstitute

				bonafideLetter = request.getFile('BonafideLetter')
				bonafideLetterName = "BonafideLetter"
			if(bonafideLetter != '' && bonafideLetter?.getBytes()?.size() != 0){
					if (bonafideLetter != null && bonafideLetter?.getBytes()?.size() != 0) {
						def file = request.getFile('BonafideLetter')
						int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
						def nullByteCheck = file.getOriginalFilename().contains('%00')
						if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
							println '===================== HIIIIIIIIII'
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
							println "inside try"
							PdfReader pdf = new PdfReader(file.getBytes())
							if(pdf && pdf.pdfVersion){

                          new File(grailsApplication.config.bonafide.toString() + File.separatorChar +"Bona").mkdirs()
	                      def filePath = new File(grailsApplication.config.bonafide.toString() + File.separatorChar + "Bona"+ File.separatorChar + file.getOriginalFilename());
	                     file.transferTo(filePath)
	                     appForm.bonafideLetterURL = filePath;

//						 appForm.bonafideLetter = bonafideLetter.getBytes()
						 appForm.bonafideLetterName = bonafideLetterName
						 println "inside if"
								
						 }else{
								println "inside elseeeeeeeeeeeeeeee"
								flash.message = "Wrong format of pdf"
								forward(action: "part3", params: [msg1: 'Wrong format of pdf!',appFormId:params.appFormId])
							}
						}catch (Exception e){
						println "trtrtrt"
							println e.message
							flash.message = "Wrong format of pdf"
							forward(action: "part3", params: [msg1: 'Wrong format of pdf!',appFormId:params.appFormId])
							return
						}
					}
					
				}

			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}
			redirect(action:"part3",params:[csrfPreventionSalt:csrfPreventionSalt,formType:formType,appFormId:appForm?.id])
		}

	}

	def part4 = {
		def formType = params.formType
		println "formType == "+formType
		def appForm
		flash.message = params?.msg1
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}

		[appForm:appForm,formType:formType]
	}

	def savePart4 = {
		println "In savePart4 "+params
		def formType = params.formType
		println "formType == "+formType
		def csrfPreventionSalt = params.csrfPreventionSalt
		def appForm
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}

		println "appForm == "+appForm
		def agreementLetter,agreementLetterName,mouFile,mouFileName
		//		if(params.AgreementLetter != ''){
		//			agreementLetter = request.getFile('AgreementLetter')
		//			agreementLetterName = "AgreementLetter"
		//		}
		

		if(appForm != null && params.detailsOfIndividualOrOrganisation != null &&
		params.useofResearchResults != null && params.benefitsToTheIndividualOrOrganization != null &&
		params.benefitsToTheApplicant != null ){
			println "HEllooooooooo"+params
			appForm.isAgreementOrMou = params.agreementOrMou == 'Yes' ? 'true' : 'false'
			println "HEllooooooooo22222"+appForm.isAgreementOrMou
			appForm.detailsOfIndividualOrOrganisation = params.detailsOfIndividualOrOrganisation
			appForm.useofResearchResults = params.useofResearchResults
			appForm.benefitsToTheIndividualOrOrganization = params.benefitsToTheIndividualOrOrganization
			appForm.benefitsToTheApplicant = params.benefitsToTheApplicant
			if(params.agreementOrMou == 'Yes')
				appForm.collaborationDetails = params.collaborationDetails
			else
				appForm.collaborationDetails = null
				
			if(params.isBenefitSharing == 'on'){
				appForm.isBenefitSharing = true
			}
			else{
				appForm.isBenefitSharing = false
			}
			//			appForm.agreementLetter = agreementLetter.getBytes()
			//			appForm.agreementLetterName = agreementLetterName
			
			if(params.MouFile != '' && params?.MouFile?.getBytes()?.size() != 0){
				mouFile = request.getFile('MouFile')
				mouFileName = "MouFile"
//				appForm.mouFile = mouFile?.getBytes()
//				appForm.mouFileName = mouFileName
				if (mouFile != null && mouFile?.getBytes()?.size() != 0) {
					def file = request.getFile('MouFile')
					int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
					def nullByteCheck = file.getOriginalFilename().contains('%00')
					if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
						println '====================='
						flash.message = "Wrong format of pdf"
						forward(action: "part4", params: [msg1: 'Please upload file in pdf document format only!',
																	 appFormId:params.appFormId])
					}
					if (occurance > 1) {
						println '###################'
						flash.message = "Wrong format of pdf"
						forward(action: "part4", params: [msg1: 'Please upload file and file must be .pdf document format only!',
																	 appFormId:params.appFormId])
	
					}
	
					try {
						PdfReader pdf = new PdfReader(file.getBytes())
						if(pdf && pdf.pdfVersion){
							
							new File(grailsApplication.config.mouFilePath.toString() + File.separatorChar +"moudoc").mkdirs()
							def filePath = new File(grailsApplication.config.mouFilePath.toString() + File.separatorChar + "moudoc"+ File.separatorChar + file.getOriginalFilename());
						   
							  file.transferTo(filePath)
							 appForm.mouFileURL = filePath;
							
//							appForm.mouFile = mouFile?.getBytes()
							appForm.mouFileName = mouFileName
						}
						else{
							flash.message = "Wrong format of pdf"
							forward(action: "part4", params: [msg1: 'Wrong format of pdf!',appFormId:params.appFormId])
							return
						}
					}catch (Exception e){
						println e.message
						flash.message = "Wrong format of pdf"
						forward(action: "part4", params: [msg1: 'Wrong format of pdf!',appFormId:params.appFormId])
	
					}
				}
			}
			else if(appForm.isAgreementOrMou == 'false'){
				appForm.mouFile = null
			}
			

			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}
			redirect(action:"part4",params:[csrfPreventionSalt:csrfPreventionSalt,formType:formType,appFormId:appForm?.id])
		}

	}

	def part5 = {
		def formType = params.formType
		println "formType == "+formType
		def appForm
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}

		def declarationForm = MstrDocument.findByDocName("DeclarationForm2")
		[formType:formType,declarationForm:declarationForm,appForm:appForm]
	}

	def savePart5 = {

		def formType = params.formType
		println "formType == "+formType

		println "In  saveForm1Part5 "+params
		def appForm
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}

		def declarationForm,declarationFormName
		if(params.DeclarationForm != ''){
			declarationForm = request.getFile('DeclarationForm')
			declarationFormName = "DeclarationForm"
		}
		if(appForm != null){
			appForm.declarationForm = declarationForm.getBytes()
			appForm.declarationFormName = declarationFormName

			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}
			println "saved successfuly"
			redirect(action:"part5",params:[formType:formType])
		}
	}



	def confirmmessagePage = {


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
		response.setHeader "Content-disposition", "inline; filename=filename"
		response.contentType = 'application/vnd.openxmlformats-officedocument.wordprocessingml.document'
		response.outputStream << DocContent
		response.outputStream.flush()
	}

}
