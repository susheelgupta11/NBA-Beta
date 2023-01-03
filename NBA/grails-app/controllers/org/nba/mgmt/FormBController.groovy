package org.nba.mgmt
import java.text.SimpleDateFormat
import java.util.regex.*

import org.nba.application.ApplicationForm1
import org.nba.application.FormB
import org.nba.application.FormBFundingAgency
import org.nba.application.FormCategory
import org.nba.application.IndianGovtInst
import org.nba.application.IndianResearcher
import org.nba.common.Country
import org.nba.common.State
import org.nba.master.MstrDocument
import org.nba.resource.BiologicalResource
import org.nba.resource.GeoLocationOfBioResource
import org.nba.user.NbaUserNbaRole
import org.springframework.security.access.annotation.Secured
import org.springframework.util.StringUtils

import com.lowagie.text.pdf.PdfReader

@Secured('permitAll')
class FormBController {

	def springSecurityService
	def applicationMgmtService
	private Pattern pattern;
	private Matcher matcher;
	private Matcher mobmatcher;
	
	static allowedMethods = [save: "POST"]
	//	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	def beforeInterceptor = [action: this.&invokeMeBeforeEveryLoad]
	def afterInterceptor = [action: this.&invokeMeAfterEveryLoad]

	private invokeMeBeforeEveryLoad (model){
		println "In invokeMeBeforeEveryLoad"
		println "Tracing action ${actionUri}"
		def role = NbaUserNbaRole.findByNbaUser(springSecurityService.currentUser)?.nbaRole?.authority
		if (role == 'APPLICANT' || role == 'ADMIN') {
		} else {
			redirect(controller: 'login', action: 'denied')
		}
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

	def index() { }

	def researcherOrGovermentInst = {
		println "CURRENT USER *********************== "+params.currentUser
		println "params.formType"+params.formType
		def formType = params.formType
		println "CURRENT USER///////////////// "+springSecurityService.getCurrentUser()
		[formType:formType]
	}

	def indianResearcher = {

		List listOfCountries = []
		List countryIndiaFromList = []
		listOfCountries = Country.list()
		
		countryIndiaFromList = Country.findAllByCountry('India')
		
		println "countryIndiaFromList =="+countryIndiaFromList
//		println "listOfCountries == "+listOfCountries
		def listOfStates = State.list()


		def listOfIndianResearcher = [],appForm,agentProfile,nationality,profile,agentProfiles,idProofSelect,passportSelect,authorizationSelect, agentPhotoIdSelect, individualProf,addressproof
		println "CURRENT USER == "+springSecurityService.currentUser
		nationality = ['-Select-', 'Indian', 'Non Indian', 'Non-Resident Indian']
//		addressproof= ['-Select-', 'Aadhar Card', 'Driving Licence', 'Passport']
		addressproof= ['-Select-', 'Driving Licence', 'Passport']

		def formType = params.formType
		if(params.formType != ''){
			println " *****  Current User ****  =  "+springSecurityService.currentUser
			println "******* All ApplicationForm1 ******** = "+ApplicationForm1
			println " *****  Form type ****  =  "+params.formType

			if(params?.appFormId != '' || params?.appFormId != null){
				appForm = ApplicationForm1.get(params?.appFormId)
			}
			session.setAttribute('appFormId',appForm?.id)
			println "appForm == "+appForm
		}
		if(appForm != null){
			println "appForm))))))))))))))))))"+appForm
			listOfIndianResearcher = IndianResearcher.findAllByApplicationForm1(appForm)
			println "listOfIndianResearcher == "+listOfIndianResearcher
			println "agentProfile == "+appForm?.agentProfile


			//agentProfile = AgentProfile.findByApplicationFormAndIsIndividualAgent(appForm,true)
		}
		print "...........params?.id......."+params?.id
		def indianResearcher1 = IndianResearcher.get(params?.id)
		print "...........indianresearcher......."+indianResearcher1?.id

		[formType:formType,listOfCountries:listOfCountries,nationality:nationality,appForm:appForm,listOfIndianResearcher:listOfIndianResearcher,indianResearcher1:indianResearcher1,
			listOfStates:listOfStates,addressproof:addressproof,deleteCalled:params.deleteCalled,countryIndiaFromList:countryIndiaFromList]
	}

	def selectResearcherType = {

		def csrfPreventionSalt = params.csrfPreventionSalt
		println "PARAMS ARE selectResearcherType "+params
		def formType = params.formType
		if(params.profile == "1"){
			println " Redirect indianResearcher"+csrfPreventionSalt
			println "form type"+formType
			redirect(action:"indianResearcher",params:[csrfPreventionSalt:csrfPreventionSalt,formType:formType])
		}
		else if(params.profile == "2") {
			redirect(action:"indianGovtInst",params:[csrfPreventionSalt:csrfPreventionSalt,formType:formType])
		}
	}
	def submitIndianResearcher= {
		
//		Pattern pattern;
//		Matcher matcher;
		
		String MOBILE_PATTERN = "[0-9]{10}"; 
		
		println "inside Submit Indian Researcher----------------"
		println "PARAmS are == "+params
		def csrfPreventionSalt = params.csrfPreventionSalt
		//For company profile
		def registrationDocFile,registrationDocFilename,passportFile,passportFilename,authorityLetter,authorityLetterFilename,addressproofLetterDocFile,addressproofLetterDocFilename
		//start
		if(params.addressproofLetter != ''){
			addressproofLetterDocFile = request.getFile('addressproofLetter')
			addressproofLetterDocFilename = "addressproofLetterDoc"



			if (addressproofLetterDocFile != null && addressproofLetterDocFile?.getBytes()?.size() != 0) {
				def file = request?.getFile('addressproofLetter')
				int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
				def nullByteCheck = file.getOriginalFilename().contains('%00')
				if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
					println '====================='
					flash.message = "Wrong format of pdf"
					forward(action: "indianResearcher", params: [msg1: 'Please upload file in pdf document format only!',
						appFormId:params.appFormId])
				}
				if (occurance > 1) {
					println '###################'
					flash.message = "Wrong format of pdf"
					forward(action: "indianResearcher", params: [msg1: 'Please upload file and file must be .pdf document format only!',
						appFormId:params.appFormId])
				}

				try {
					PdfReader pdf = new PdfReader(file.getBytes())
					if(pdf && pdf.pdfVersion){}
					else{
						flash.message = "Wrong format of pdf"
						forward(action: "indianResearcher", params: [msg1: 'Wrong format of pdf!'])
						return
					}
				}catch (Exception e){
					println e.message
					flash.message = "Wrong format of pdf"
					forward(action: "indianResearcher", params: [msg1: 'Wrong format of pdf!'])

				}
			}

		}






		//end

		def category,appForm,existingAppForm

		def formType = params.formType
		if(params.formType  == 'FormB'){
			category = FormCategory.findByCategory(FormCategory.Category.Form_B)
		}
		println "--profile id--- "+params.profileId
		//
		if(params.profileId){
			def existingProfile = IndianResearcher.get(params.profileId)
			println "profileID777777777777777   "+params.profileId
			applicationMgmtService.updateIndianResearcher(params,category,existingProfile,addressproofLetterDocFile,addressproofLetterDocFilename)
			if(params?.appFormId != ''){
				appForm = ApplicationForm1.get(params?.appFormId)
			}
		}
		else{
			if(params?.appFormId != '' || params?.appFormId != null){
				appForm = ApplicationForm1.get(params?.appFormId)
			}
			else if(session.getAttribute("appFormId") != null){
				appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
			}

				appForm = applicationMgmtService.saveIndianResearcher(params,category,appForm,addressproofLetterDocFile,addressproofLetterDocFilename)
				println "inside save indian reseaarcher*****************************"+appForm
//			}
			session["appFormId"] = appForm?.id
			println "--formtype--"+formType+"---formid---"+appForm?.id
		}
		redirect(action:"indianResearcher",params:[csrfPreventionSalt:csrfPreventionSalt,formType:formType,appFormId:appForm?.id])

	}

	def editIndianResearcher = {
		println "Inside editIndividualProfile "+params
		def nationality,appForm,idProofSelect
		def csrfPreventionSalt = params.csrfPreventionSalt
		def indianResearcher = IndianResearcher.get(params.profileId)
		def getNationality = indianResearcher?.nationality
		println "inside edit individual profile......"+getNationality
		if(getNationality == "Indian")
	//		idProofSelect = ['Driving License', 'Aadhar Card', 'Voter Id Card', 'Government Id']
			idProofSelect = ['Driving License', 'Voter Id Card', 'Government Id']
		else if(getNationality == "Non Indian")
			idProofSelect = ['Driving License', 'Government Id']
		else if(getNationality == "Non-Resident Indian")
//			idProofSelect = ['Driving License', 'Aadhar Card', 'Voter Id Card', 'Government Id']
			idProofSelect = ['Driving License', 'Voter Id Card', 'Government Id']

		def listOfCountries = Country.list()
		if(params.formType == 'Form1' || params.formType == 'Form4')
			nationality = ['-Select-', 'Non Indian', 'Non-Resident Indian']
		else
			nationality = ['-Select-', 'Indian', 'Non Indian', 'Non-Resident Indian']

		def profile = ['-Select-', 'Scientist', 'Student', 'Researcher', 'Others']
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}
		redirect(action: "indianResearcher", id: indianResearcher?.id, params: [csrfPreventionSalt:csrfPreventionSalt,formType: params?.formType,appFormId:appForm?.id,idProofSelect:idProofSelect])
	}

	def deleteIndianReasearcherProfile = {
		println "Inside deleteProfile "+params
		def csrfPreventionSalt = params.csrfPreventionSalt
		def indianResearcher,listOfIndianResearcher = [],appForm
		print "--params?.appFormId--"+params?.appFormId
		if(params?.appFormId != '' || params?.appFormId != null){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		else if(session.getAttribute("appFormId") != null){
			appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
		}
		print "--profile id--"+params.profileId
		if(params.profileId != ''){
			indianResearcher = IndianResearcher.get(params.profileId)
			indianResearcher.delete(flush:true)
			flash.message = "Deleted Successfully"

			listOfIndianResearcher = IndianResearcher.findAllByApplicationForm1(appForm)
			println "listOfIndividualProfiles == "+listOfIndianResearcher
			redirect(action: "indianResearcher", id: indianResearcher?.id, params: [csrfPreventionSalt:csrfPreventionSalt,formType: params?.formType,appFormId : appForm?.id, deleteCalled:'deleteCalled'])
			//render(template:"individualProfileGrid",model:[listOfIndividualProfiles:listOfIndividualProfiles])
		}
	}
	
	def deleteIndianGovtInst = {
		println "Inside deleteProfile "+params
		def csrfPreventionSalt = params.csrfPreventionSalt
		def indianGovtInst,listOfindianGovtInst = [],appForm
		print "--params?.appFormId--"+params?.appFormId
		if(params?.appFormId != '' || params?.appFormId != null){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		else if(session.getAttribute("appFormId") != null){
			appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
		}
		print "--profile id--"+params.profileId
		if(params.profileId != ''){
			indianGovtInst = IndianGovtInst.get(params.profileId)
			indianGovtInst.delete(flush:true)
			flash.message = "Deleted Successfully"

			listOfindianGovtInst = IndianGovtInst.findAllByApplicationForm1(appForm)
			println "listOfIndividualProfiles == "+listOfindianGovtInst
			redirect(action: "indianGovtInst", id: indianGovtInst?.id, params: [csrfPreventionSalt:csrfPreventionSalt,formType: params?.formType,appFormId : appForm?.id, deleteCalled:'deleteCalled'])
			//render(template:"individualProfileGrid",model:[listOfIndividualProfiles:listOfIndividualProfiles])
		}
	}


	def indianGovtInst = {
		def indianGovtInst1
		List listOfCountries = []
		listOfCountries = Country.list()
		println "listOfCountries == "+listOfCountries
		def listOfStates = State.list()


		def listOfIndianGovtInst = [],appForm,agentProfile,nationality,profile,agentProfiles,idProofSelect,passportSelect,authorizationSelect, agentPhotoIdSelect, individualProf,addressproof
		println "CURRENT USER == "+springSecurityService.currentUser
		nationality = ['-Select-', 'Indian', 'Non Indian', 'Non-Resident Indian']
//		addressproof= ['-Select-', 'VoterId Proof', 'Aadhar Card', 'Driving Licence', 'Passport']
		addressproof= ['-Select-', 'VoterId Proof',  'Driving Licence', 'Passport']

		def formType = params.formType
		if(params.formType != ''){
			println " *****  Current User ****  =  "+springSecurityService.currentUser
			println "******* All ApplicationForm1 ******** = "+ApplicationForm1
			println " *****  Form type ****  =  "+params.formType

			if(params?.appFormId != '' || params?.appFormId != null){
				appForm = ApplicationForm1.get(params?.appFormId)
			}
			session.setAttribute('appFormId',appForm?.id)
			println "appForm == "+appForm
		}
		if(appForm != null){
			println "appForm))))))))))))))))))"+appForm
			listOfIndianGovtInst = IndianGovtInst.findAllByApplicationForm1(appForm)
			println "listOfIndianGovtInst == "+listOfIndianGovtInst
			println "agentProfile == "+appForm?.agentProfile


			//agentProfile = AgentProfile.findByApplicationFormAndIsIndividualAgent(appForm,true)
		}
		print "...........params?.id......."+params?.id
		indianGovtInst1 = IndianGovtInst.get(params?.id)
		print "...........indianGovtInst1......."+indianGovtInst1?.id

		[formType:formType,listOfCountries:listOfCountries,nationality:nationality,appForm:appForm,listOfIndianGovtInst:listOfIndianGovtInst,indianGovtInst1:indianGovtInst1,addressproof:addressproof,deleteCalled:params.deleteCalled]
	}

	def editIndianGovtInst = {
		println "Inside editIndianGovtInst "+params
		def nationality,appForm,idProofSelect
		def csrfPreventionSalt = params.csrfPreventionSalt
		def indianGovtInst = IndianGovtInst.get(params.profileId)
		//		def getNationality = indianResearcher?.nationality
		//		println "inside edit individual profile......"+getNationality
		//		if(getNationality == "Indian")
	//	idProofSelect = ['Driving License', 'Aadhar Card', 'Voter Id Card', 'Government Id']
		idProofSelect = ['Driving License', 'Voter Id Card', 'Government Id']
		
		//		else if(getNationality == "Non Indian")
		//			idProofSelect = ['Driving License', 'Government Id']
		//		else if(getNationality == "Non-Resident Indian")
		//			idProofSelect = ['Driving License', 'Aadhar Card', 'Voter Id Card', 'Government Id']

		def listOfCountries = Country.list()
		//		if(params.formType == 'Form1' || params.formType == 'Form4')
		//			nationality = ['-Select-', 'Non Indian', 'Non-Resident Indian']
		//		else
		//			nationality = ['-Select-', 'Indian', 'Non Indian', 'Non-Resident Indian']

		def profile = ['-Select-', 'Scientist', 'Student', 'Researcher', 'Others']
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}
		redirect(action: "indianGovtInst", id: indianGovtInst?.id, params: [csrfPreventionSalt:csrfPreventionSalt,formType: params?.formType,appFormId:appForm?.id,idProofSelect:idProofSelect])
	}

	def submitIndianGovtInst={

		println "inside Submit Indian Researcher----------------"
		println "PARAmS are == "+params
		def csrfPreventionSalt = params.csrfPreventionSalt
		//For company profile
		def registrationDocFile,registrationDocFilename,passportFile,passportFilename,authorityLetter,authorityLetterFilename,addressproofLetterDocFile,addressproofLetterDocFilename
		//start
		if(params.addressproofLetter != ''){
			addressproofLetterDocFile = request.getFile('addressproofLetter')
			addressproofLetterDocFilename = "addressproofLetterDoc"



			if (addressproofLetterDocFile != null && addressproofLetterDocFile?.getBytes()?.size() != 0) {
				def file = request.getFile('addressproofLetter')
				int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
				def nullByteCheck = file.getOriginalFilename().contains('%00')
				if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
					println '====================='
					flash.message = "Wrong format of pdf"
					forward(action: "formBPart3", params: [msg1: 'Please upload file in pdf document format only!',
						appFormId:params.appFormId])
				}
				if (occurance > 1) {
					println '###################'
					flash.message = "Wrong format of pdf"
					forward(action: "formBPart3", params: [msg1: 'Please upload file and file must be .pdf document format only!',
						appFormId:params.appFormId])
				}

				try {
					PdfReader pdf = new PdfReader(file.getBytes())
					if(pdf && pdf.pdfVersion){}
					else{
						flash.message = "Wrong format of pdf"
						forward(action: "formBPart3", params: [msg1: 'Wrong format of pdf!'])
						return
					}
				}catch (Exception e){
					println e.message
					flash.message = "Wrong format of pdf"
					forward(action: "formBPart3", params: [msg1: 'Wrong format of pdf!'])

				}
			}

		}
		//end
		def category,appForm,existingAppForm

		def formType = params.formType
		if(params.formType  == 'FormB'){
			category = FormCategory.findByCategory(FormCategory.Category.Form_B)
		}
		println "--profile id--- "+params.profileId
		//
		if(params.profileId){
			def existingProfile = IndianGovtInst?.get(params.profileId)
			println "profileID777777777777777   "+params.profileId
			applicationMgmtService.updateIndianGovtInst(params,category,existingProfile,addressproofLetterDocFile,addressproofLetterDocFilename)
			if(params?.appFormId != ''){
				appForm = ApplicationForm1.get(params?.appFormId)
			}
		}
		else{
			if(params?.appFormId != '' || params?.appFormId != null){
				appForm = ApplicationForm1.get(params?.appFormId)
			}
			else if(session.getAttribute("appFormId") != null){
				appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
			}

			print "222222"+appForm+"333333333"+category
			//
			appForm = applicationMgmtService.saveIndianGovtInst(params,category,appForm,addressproofLetterDocFile,addressproofLetterDocFilename)
			println "inside save indian reseaarcher*****************************"+appForm

			session["appFormId"] = appForm?.id
			println "--formtype--"+formType+"---formid---"+appForm?.id
		}
		redirect(action:"indianGovtInst",params:[csrfPreventionSalt:csrfPreventionSalt,formType:formType,appFormId:appForm?.id])


	}

	def formBPart2 = {
		println "Form B part 2 "+params
		def appForm =   ApplicationForm1.get(params.appFormId)
		def entity1,entity2

		entity1 = FormB.findByAppFormAndType(appForm,FormB.EntityType.Institute)
		entity2 = FormB.findByAppFormAndType(appForm,FormB.EntityType.Supervisor)
		println "entity1 == "+entity1
		def formType
		if(params.formType){
			formType = params.formType
		}

		def listOfStates = State.list()
		[formType:formType,entity1:entity1,entity2:entity2,appForm:appForm,listOfStates:listOfStates]
	}
	
	
	def saveFormBEntity = {
		
		println "Inside action saveForm3  "+params
		def email,sanctionOrderMoUcopyDocFile,sanctionOrderMoUcopyDocFilename,addressproofLetterFile,addressproofLetterFilename
		
		if(params?.sanctionOrderMoUcopy != '' && params?.sanctionOrderMoUcopy != null){
			sanctionOrderMoUcopyDocFile = request?.getFile('sanctionOrderMoUcopy')
			sanctionOrderMoUcopyDocFilename = "sanctionOrderMoUcopyDoc"



			if (sanctionOrderMoUcopyDocFile != null && sanctionOrderMoUcopyDocFile?.getBytes()?.size() != 0) {
				def file = request.getFile('sanctionOrderMoUcopy')
				int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
				def nullByteCheck = file.getOriginalFilename().contains('%00')
				if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
					println '====================='
					flash.message = "Wrong format of pdf"
					forward(action: "indianResearcher", params: [msg1: 'Please upload file in pdf document format only!',
						appFormId:params.appFormId])
				}
				if (occurance > 1) {
					println '###################'
					flash.message = "Wrong format of pdf"
					forward(action: "indianResearcher", params: [msg1: 'Please upload file and file must be .pdf document format only!',
						appFormId:params.appFormId])
				}

				try {
					PdfReader pdf = new PdfReader(file.getBytes())
					if(pdf && pdf.pdfVersion){}
					else{
						flash.message = "Wrong format of pdf"
						forward(action: "indianResearcher", params: [msg1: 'Wrong format of pdf!'])
						return
					}
				}catch (Exception e){
					println e.message
					flash.message = "Wrong format of pdf"
					forward(action: "indianResearcher", params: [msg1: 'Wrong format of pdf!'])

				}
			}
		}
		
		if(params?.addressproofLetter != '' && params?.addressproofLetter != null){
			addressproofLetterFile = request?.getFile('addressproofLetter')
			addressproofLetterFilename = "Address Proof"



			if (addressproofLetterFile != null && addressproofLetterFile?.getBytes()?.size() != 0) {
				def file = request.getFile('addressproofLetter')
				int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
				def nullByteCheck = file.getOriginalFilename().contains('%00')
				if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
					println '====================='
					flash.message = "Wrong format of pdf"
					forward(action: "formBPart3", params: [msg1: 'Please upload file in pdf document format only!',
						appFormId:params.appFormId])
				}
				if (occurance > 1) {
					println '###################'
					flash.message = "Wrong format of pdf"
					forward(action: "formBPart3", params: [msg1: 'Please upload file and file must be .pdf document format only!',
						appFormId:params.appFormId])
				}

				try {
					PdfReader pdf = new PdfReader(file.getBytes())
					if(pdf && pdf.pdfVersion){}
					else{
						flash.message = "Wrong format of pdf"
						forward(action: "formBPart3", params: [msg1: 'Wrong format of pdf!'])
						return
					}
				}catch (Exception e){
					println e.message
					flash.message = "Wrong format of pdf"
					forward(action: "formBPart3", params: [msg1: 'Wrong format of pdf!'])

				}
			}

		}
		
		def appInstance = ApplicationForm1.get(params?.appFormId)
		def formBEntity = applicationMgmtService.saveFormBEntity(params, appInstance,sanctionOrderMoUcopyDocFile,sanctionOrderMoUcopyDocFilename,addressproofLetterFile,addressproofLetterFilename)
		if(params.part == 'part2'){
			redirect(action:formBPart2,params:[appFormId:appInstance?.id,csrfPreventionSalt:params.csrfPreventionSalt,formType:params?.formType])
		}
		else if(params.part == 'part3'){
			redirect(action:formBPart3,params:[appFormId:appInstance?.id,csrfPreventionSalt:params.csrfPreventionSalt,formType:params?.formType])
		}

	}
	
	def saveFundingAgency(){
		
		def csrfPreventionSalt = params?.csrfPreventionSalt
		def appForm = ApplicationForm1?.get(params?.appFormId)
		
		println "inside save funding agency----"+params
		def sanctionOrderMoUcopyDocFile,sanctionOrderMoUcopyDocFilename,fundingAgencyId,fundingAgencyObj
		if(params?.sanctionOrderMoUcopy != '' && params?.sanctionOrderMoUcopy != null){
			sanctionOrderMoUcopyDocFile = request?.getFile('sanctionOrderMoUcopy')
			sanctionOrderMoUcopyDocFilename = "sanctionOrderMoUcopyDoc"



			if (sanctionOrderMoUcopyDocFile != null && sanctionOrderMoUcopyDocFile?.getBytes()?.size() != 0) {
				def file = request.getFile('sanctionOrderMoUcopy')
				int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
				def nullByteCheck = file.getOriginalFilename().contains('%00')
				if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
					println '====================='
					flash.message = "Wrong format of pdf"
					forward(action: "indianResearcher", params: [msg1: 'Please upload file in pdf document format only!',
						appFormId:params.appFormId])
				}
				if (occurance > 1) {
					println '###################'
					flash.message = "Wrong format of pdf"
					forward(action: "indianResearcher", params: [msg1: 'Please upload file and file must be .pdf document format only!',
						appFormId:params.appFormId])
				}

				try {
					PdfReader pdf = new PdfReader(file.getBytes())
					if(pdf && pdf.pdfVersion){}
					else{
						flash.message = "Wrong format of pdf"
						forward(action: "indianResearcher", params: [msg1: 'Wrong format of pdf!'])
						return
					}
				}catch (Exception e){
					println e.message
					flash.message = "Wrong format of pdf"
					forward(action: "indianResearcher", params: [msg1: 'Wrong format of pdf!'])

				}
			}
		}
		
		if(params?.agencyId){
				fundingAgencyObj = FormBFundingAgency?.get(params?.agencyId);
				fundingAgencyObj.institutionOrganizationName = params?.name
				fundingAgencyObj.address1 = params?.address1
				fundingAgencyObj.address2 = params?.address2
				fundingAgencyObj.address3 = params?.address3
				fundingAgencyObj.country = Country?.get(params?.countryId)
				fundingAgencyObj.state = params?.state
				fundingAgencyObj.city = params?.city
				fundingAgencyObj.phone = params?.phone
				fundingAgencyObj.email = params?.email
				fundingAgencyObj.email = params?.email
				
				new File(grailsApplication.config.fundingAgencyFormB.toString() + File.separatorChar +"FUNDING-FORMB").mkdirs()
				def filePath = new File(grailsApplication.config.fundingAgencyFormB.toString() + File.separatorChar + "FUNDING-FORMB"+ File.separatorChar + sanctionOrderMoUcopyDocFile?.getOriginalFilename());
			   
				  sanctionOrderMoUcopyDocFile.transferTo(filePath)
				 fundingAgencyObj.sanctionOrderURL = filePath;
				
				
//				fundingAgencyObj.sanctionOrder = sanctionOrderMoUcopyDocFile?.getBytes()
				fundingAgencyObj.sanctionOrderMoUcopyFileName = sanctionOrderMoUcopyDocFilename
				fundingAgencyObj.appform = appForm
				fundingAgencyId = fundingAgencyObj?.id
			}
		else{
				fundingAgencyObj = new FormBFundingAgency();
				fundingAgencyObj.institutionOrganizationName = params?.name
				fundingAgencyObj.address1 = params?.address1
				fundingAgencyObj.address2 = params?.address2
				fundingAgencyObj.address3 = params?.address3
				fundingAgencyObj.country = Country?.get(params?.countryId)
				fundingAgencyObj.state = params?.state
				fundingAgencyObj.city = params?.city
				fundingAgencyObj.phone = params?.phone
				fundingAgencyObj.email = params?.email
				fundingAgencyObj.email = params?.email
				
				new File(grailsApplication.config.fundingAgencyFormB.toString() + File.separatorChar +"FUNDING-FORMB").mkdirs()
				def filePath = new File(grailsApplication.config.fundingAgencyFormB.toString() + File.separatorChar + "FUNDING-FORMB"+ File.separatorChar + sanctionOrderMoUcopyDocFile?.getOriginalFilename());
			   
				  sanctionOrderMoUcopyDocFile.transferTo(filePath)
				 fundingAgencyObj.sanctionOrderURL = filePath;
				
				
//				fundingAgencyObj.sanctionOrder = sanctionOrderMoUcopyDocFile?.getBytes()
				fundingAgencyObj.sanctionOrderMoUcopyFileName = sanctionOrderMoUcopyDocFilename
				fundingAgencyObj.appform = appForm
			}
				appForm.addToFormBFundingAgency(fundingAgencyObj)
				if(!fundingAgencyObj?.save(flush:true)){
					fundingAgencyObj?.errors?.each{println it}
				}
		
		redirect(action:"formBPart3",params:[csrfPreventionSalt:csrfPreventionSalt,formType:params?.formType,
											appFormId:appForm?.id,fundingAgencyId:fundingAgencyId])
	}
	
	def deleteFundingAgency(){
		
		def csrfPreventionSalt = params?.csrfPreventionSalt
		def fundingAgencyObj,appForm
		appForm = ApplicationForm1.get(params?.appFormId)
		if(params?.agencyId)
		{
			fundingAgencyObj = FormBFundingAgency?.get(params?.agencyId)
			println "fundingAgencyObj=="+fundingAgencyObj
			fundingAgencyObj.delete(flush:true)
			flash.message = "Deleted Successfully"
			redirect(action: "formBPart3", params: [csrfPreventionSalt:csrfPreventionSalt,formType: params?.formType,
													appFormId : appForm?.id,deletefundingagency:'deletefundingagency'])
		}
	}
	
	
	def formBPart3 = {
		println "Form B part 2 "
		def appForm =   ApplicationForm1.get(params.appFormId)
		def entity1,entity2,entity3,addressproof,recipientAddressProof,fundingAgencyObj
//		addressproof= ['-Select-', 'Aadhar Card', 'Driving Licence', 'Passport']
		addressproof= ['-Select-', 'Driving Licence', 'Passport']
		
		recipientAddressProof = ['-Select-','Government Id','Driving Licence']
		entity1 = FormB.findByAppFormAndType(appForm,FormB.EntityType.Guiding_Institute)
		entity2 = FormB.findByAppFormAndType(appForm,FormB.EntityType.Guiding_Supervisor)
		entity3 = FormB.findByAppFormAndType(appForm,FormB.EntityType.Funding_Agency)
		
		if(params?.agencyId){
			fundingAgencyObj = FormBFundingAgency?.get(params?.agencyId)
		}
		def listOfFundingAgency = FormBFundingAgency?.findAllByAppform(appForm)
		println "listOfFundingAgency--"+listOfFundingAgency
		
		
		def formType
		if(params.formType){
			formType = params.formType
		}

		def listOfStates = State.list()
//		def listOfCountries = Country.list()
		def listOfCountries =Country.findAll()
		[listOfCountries:listOfCountries,formType:formType,addressproof:addressproof,recipientAddressProof:recipientAddressProof,fundingAgencyObj:fundingAgencyObj,
			listOfFundingAgency:listOfFundingAgency,entity1:entity1,entity2:entity2,entity3:entity3,appForm:appForm,listOfStates:listOfStates,part:"part3",
			deletefundingagency:params?.deletefundingagency]
		//def formType
	}
	def saveDescription = {
		println "Inside save decsription == "+params
		def appForm = ApplicationForm1.get(params.appFormId)
		appForm.briefDescription = params.description 
		if(!appForm.save(flush:true)){
			appForm.errors.each{ println it }
		}
		redirect(action:"formBPart3", params:[appFormId:appForm?.id,csrfPreventionSalt:params.csrfPreventionSalt,formType:params?.formType])
	}

	def researchDuration = {
		println "pp"
		println "inside research Duration---"+params
		def emergencyDetails,appForm,durationFrom,durationTo,researchDuration

		if(params.researchDurationFrom != null && params.researchDurationFrom != ''){
			SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy")
			durationFrom = parser.parse(params.researchDurationFrom)
		}
		if(params.researchDurationTo != null && params.researchDurationTo != '' ){
			SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy")
			durationTo = parser.parse(params.researchDurationTo)
		}

		appForm = ApplicationForm1.get(params?.appFormId)
		if(params?.emergencyDetails){
			appForm.emergencyDetails = params?.emergencyDetails
		}
		if(durationFrom && durationTo){
			appForm.researchDurationFrom = durationFrom
			appForm.researchDurationTo = durationTo
			appForm?.typeOfExercise = params?.typeOfExercise
		}
		if(params?.typeOfExercise == 'multipleTime'){
			appForm?.reasonsForSending = params?.reasonsForSending
			appForm?.numOfTimesOfSending = params?.numOfTimesOfSending
		}
		else if(params?.typeOfExercise == 'oneTime'){
			appForm?.reasonsForSending = null
			appForm?.numOfTimesOfSending = null
		}
		
		if(!appForm?.save(flush:true)){

			appForm.errors.each{
				println it
			}
		}

//		researchDuration = new ResearchDuration(typeOfExercise:params?.typeOfExercise,reasonsForSending:params?.reasonsForSending,numOfTimesOfSending:params?.numOfTimesOfSending)
//		
//		if(!researchDuration?.save(flush:true)){
//			researchDuration?.errors?.each{
//				println it
//			}
//		}
		
//		appForm.addToResearchDurations(researchDuration)
	}




	def formBPart4 = {
		println"params----"+params
		def appForm,bioRes


		appForm = ApplicationForm1.get(params?.appFormId)

		def quantityList  = ['unit', 'ml', 'kg', 'vials', 'slants', 'tonne']
		def resources = ['Stem', 'Seed', 'Fruit', 'Root', 'Leaf', 'DNA', 'Others']
		def natureOfReources = ['Plant', 'Animal', 'Micro-organism']
		def accessSources = ['Wild', 'Cultivated', 'Market', 'Trader', 'Repositories', 'Institution', 'Others']

		def listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)
		println "listOfBioResources == "+listOfBioResources

		def newList = []

		listOfBioResources?.each{
			println "it?.scientificName == "+it?.scientificName.equals(null)
			if(it?.scientificName?.equals(null) == false){
				println "contrins null"
				newList.add(it)
			}
		}
		println "newList "+newList

		def listOfLocations = []
		for(bioResorce in listOfBioResources){
			def bioResourceLocations = GeoLocationOfBioResource.findAllByBioResource(bioResorce)
			for(loc in bioResourceLocations){
				//if(loc.state != null && loc.district != null && loc.town != null && loc.traderName != null && loc.traderContactDetails != null){
				listOfLocations.add(loc)
				//	}
			}
		}
		println "params?.bioResourceId----"+params?.bioResourceId

		[formType:params?.formType,appForm:appForm,resources:resources,quantityList:quantityList,natureOfReources:natureOfReources,listOfBioResources:listOfBioResources,
			accessSources:accessSources,newList:newList,listOfStates:State.list(),listOfLocations:listOfLocations]


	}

	def editFormBPart4(){
		println "Inside editFormBPart4 "+params
		def appForm = ApplicationForm1.get(params?.appFormId)
		def bioResource = BiologicalResource.get(params?.bioResourceId)
		def formType = params?.formType

		def quantityList  = ['unit', 'ml', 'kg', 'vials', 'slants', 'tonne']
		def resources = ['Stem', 'Seed', 'Fruit', 'Root', 'Leaf', 'DNA', 'Others']
		def natureOfReources = ['Plant', 'Animal', 'Micro-organism']
		def accessSources = ['Wild', 'Cultivated', 'Market', 'Trader', 'Repositories', 'Institution', 'Others']

		render(template:"bioResourceForm",model:[appForm:appForm,
			bioResource:bioResource,formType:formType,resources:resources,quantityList:quantityList,natureOfReources:natureOfReources,accessSources:accessSources])
	}

	def bioResourceSubmit(){

		println "PARAMS_______"+params
		def appForm
		appForm = ApplicationForm1.get(params.appFormId)

		if(params?.bioResourceId){

			println "abcd----"+params
			def bioRes,intendToAccess,fromTime,toTime,bioResources,bioResource, associatedBioResource
			def qty = 0
			bioRes = BiologicalResource.get(params?.bioResourceId)

			if(params.quantity && params.quantity != '' || params.quantity != null){
				qty = Integer.parseInt( params.quantity)
			}

			if(params.bioResource == 'Others'){
				bioResources = 'Others- '+(params.pleaseSpecify)
			}else{
				bioResources = params.bioResource
			}

			if(params.accessIntention == 'Biological Resources'){
				intendToAccess = 'Carried along for the research'
			}
			else if(params.accessIntention == 'Associated Knowledge'){
				intendToAccess = 'Sent for the Research'
			}
			
			
			if(params.fromTime != null && params.fromTime != ''){
				SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy")
				fromTime = parser.parse(params.fromTime)
			}
			if(params.toTime != null && params.toTime != '' ){
				SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy")
				toTime = parser.parse(params.toTime)
			}

			//if(params.accessIntention == 'Biological Resources' || params.accessIntention == 'Both' || params.accessIntention == 'Associated Knowledge'){
			bioRes.commonName = params.commonName
			bioRes.scientificName = params.scientificName
			bioRes.nature = params.nature
			bioRes.quantity = qty
			bioRes.source = params.source
			bioRes.qtyUnit = params.qtyUnit
			bioRes.accessIntention = intendToAccess
			bioRes.fromTime = fromTime
			bioRes.toTime = toTime
			bioRes.applicationForm = appForm
			bioRes.traditionalUse = params.traditionalUse
			bioRes.bioResouceTraditionalKnowledge = params.bioResouceTraditionalKnowledge
			bioRes.biologicalResource = bioResources
			println "biores-----------"+bioRes
			//}
			appForm.addToBiologicalResources(bioRes)

			if(!bioRes.save(flush:true)){
				bioRes.error.each{ println it }
			}

			if(!appForm.save(flush:true)){
				appForm.errors.each{println it}
			}

			println "----params.appFormId--- in println--"+params.appFormId
			def listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)
			println "listOfBioResources == "+listOfBioResources

			render(template:"bioresourceGrid",model:[appForm:appForm,
				listOfBioResources:listOfBioResources,formType:params.formType])

		}
		else{



			try{
				def intendToAccess,bioResource
				def qty = 0,fromTime,toTime,bioResources, associatedBioResource
				
				def formType = params.formType
				println "formType == "+formType


				if(params.accessIntention == 'Biological Resources'){
						intendToAccess = 'Carried along for the research'
					}
				else if(params.accessIntention == 'Associated Knowledge'){
						intendToAccess = 'Sent for the Research'
					}
				
				println "Hieeeeeeeeeeee 2"+intendToAccess
				
				if(params.fromTime != null && params.fromTime != ''){
					SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy")
					fromTime = parser.parse(params.fromTime)
				}
				if(params.toTime != null && params.toTime != '' ){
					SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy")
					toTime = parser.parse(params.toTime)
				}
				
				if(params.quantity && params.quantity != '' || params.quantity != null){
					qty = Integer.parseInt( params.quantity)
				}

				if(params.bioResource == 'Others'){
					bioResources = 'Others- '+(params.pleaseSpecify)
				}else{
					bioResources = params.bioResource
				}
				
				if(params.accessIntention == 'Biological Resources' || params.accessIntention == 'Associated Knowledge'){
					println "Inside FIRST---------@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-----------"
					
					bioResource = new BiologicalResource(commonName:params.commonName,
					scientificName: params.scientificName,nature: params.nature ,accessIntention:intendToAccess,
					quantity:qty,source: params.source,qtyUnit:params.qtyUnit,fromTime:fromTime,
					toTime:toTime,applicationForm:appForm,traditionalUse:params.traditionalUse,
					bioResouceTraditionalKnowledge : params.bioResouceTraditionalKnowledge,biologicalResource:bioResources)

				appForm.addToBiologicalResources(bioResource)

				if(!bioResource.save(flush:true)){
					bioResource.errors.each{ println it }
				}else {
									flash.message = "Saved successfully!"
				}

				if(!appForm.save(flush:true)){
					appForm.errors.each{println it}
				}else {
					//				flash.message = "Saved successfully!"
				}


				println "SAvED BIO RESOURCE IS "+bioResource

				//Fetch all rows
				def listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)
				println "listOfBioResources == "+listOfBioResources
				render(template:"bioResourceGrid",model:[appForm:appForm,
					listOfBioResources:listOfBioResources,formType:formType])
				}
			}
			catch(Exception e){
				println "The exception is: "+e
			}

		}
	}
	
	
	//form B part 5 submit start
	def submitDeclarationFormB= {
		println "submitDeclarationFormB----------------"+params.profileId
		println "PARAmS are == "+params
		def undertakingCopy1,undertakingCopyFilename,declarationBySupervisorCopy1,declarationBySupervisorCopyFilename
		def declarationByRecipientCopy1,declarationByRecipientCopyFilename,formType,declarationByApplicantOnNationalityCopy1,declarationByApplicantOnNationalityCopyFilename
		formType=params.formType
		def csrfPreventionSalt = params.csrfPreventionSalt
		if(params.undertakingCopy != '' || params.undertakingCopy != null){
				println "upload 1 starting"
			undertakingCopy1 = request.getFile('undertakingCopy')
			println "INSIDE ID PROOF "+undertakingCopy1
			undertakingCopyFilename = "UndertakingCopy"
			if (undertakingCopy1 != null && undertakingCopy1?.getBytes()?.size() != 0) {
				println "upload 1 starting 2"
				def file = request.getFile('undertakingCopy')
				int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
				def nullByteCheck = file.getOriginalFilename().contains('%00')
				if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
					
					flash.message = "Wrong format of pdf"
					forward(action: "formBPart5", params: [msg1: 'Please upload file in pdf document format only!',
						appFormId:params.appFormId])
				}
				if (occurance > 1) {
					println '###################'
					flash.message = "Wrong format of pdf"
					forward(action: "formBPart5", params: [msg1: 'Please upload file and file must be .pdf document format only!',
						appFormId:params.appFormId])
				}

				try {
					PdfReader pdf = new PdfReader(file.getBytes())
					if(pdf && pdf.pdfVersion){}
					else{
						flash.message = "Wrong format of pdf"
						forward(action: "formBPart5", params: [msg1: 'Wrong format of pdf!'])
						return
					}
				}catch (Exception e){
					println e.message
					flash.message = "Wrong format of pdf"
					forward(action: "formBPart5", params: [msg1: 'Wrong format of pdf!'])

				}
			}
		}
		
		
		//upload declaration by applicant on Nationality
		
		if(params.declarationByApplicantOnNationalityCopy != '' || params.declarationByApplicantOnNationalityCopy != null){
			println "upload 1 starting"
		declarationByApplicantOnNationalityCopy1 = request.getFile('declarationByApplicantOnNationalityCopy')
		println "INSIDE ID PROOF "+declarationByApplicantOnNationalityCopy1
		declarationByApplicantOnNationalityCopyFilename = "declarationByApplicantOnNationalityCopy"
		if (declarationByApplicantOnNationalityCopy1 != null && declarationByApplicantOnNationalityCopy1?.getBytes()?.size() != 0) {
			println "upload 1 starting 2"
			def file = request.getFile('declarationByApplicantOnNationalityCopy')
			int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
			def nullByteCheck = file.getOriginalFilename().contains('%00')
			if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
				println "inside 1st chk in 2nd upload"
				flash.message = "Wrong format of pdf"
				forward(action: "formBPart5", params: [msg1: 'Please upload file in pdf document format only!',
					appFormId:params.appFormId])
			}
			if (occurance > 1) {
				println 'println "inside 2nd chk in 2nd upload"'
				flash.message = "Wrong format of pdf"
				forward(action: "formBPart5", params: [msg1: 'Please upload file and file must be .pdf document format only!',
					appFormId:params.appFormId])
			}

			try {
				PdfReader pdf = new PdfReader(file.getBytes())
				println "inside try block in 2nd upload"
				if(pdf && pdf.pdfVersion){}
				else{
					println "inside 2 try block in 2nd upload"
					flash.message = "Wrong format of pdf"
					forward(action: "formBPart5", params: [msg1: 'Wrong format of pdf!'])
					return
				}
			}catch (Exception e){
			println "inside catch block in 2nd upload"
				println e.message
				flash.message = "Wrong format of pdf"
				forward(action: "formBPart5", params: [msg1: 'Wrong format of pdf!'])

			}
		}
	}
		
		
		
//upload 3
		
		if(params.declarationBySupervisorCopy != '' || params.declarationBySupervisorCopy != null){
						println "upload 2 starting"
						declarationBySupervisorCopy1 = request.getFile('declarationBySupervisorCopy')
						println "INSIDE ID PROOF "+declarationBySupervisorCopy1
						declarationBySupervisorCopyFilename = "DeclarationBySupervisorCopy"
						if (declarationBySupervisorCopy1 != null && declarationBySupervisorCopy1?.getBytes()?.size() != 0) {
							println "upload 2 starting 2"
							def file = request.getFile('declarationBySupervisorCopy')
							int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
							def nullByteCheck = file.getOriginalFilename().contains('%00')
							if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
								
								flash.message = "Wrong format of pdf"
								forward(action: "formBPart5", params: [msg1: 'Please upload file in pdf document format only!',
									appFormId:params.appFormId])
							}
							if (occurance > 1) {
								println '###################'
								flash.message = "Wrong format of pdf"
								forward(action: "formBPart5", params: [msg1: 'Please upload file and file must be .pdf document format only!',
									appFormId:params.appFormId])
							}
			
							try {
								PdfReader pdf = new PdfReader(file.getBytes())
								if(pdf && pdf.pdfVersion){}
								else{
									flash.message = "Wrong format of pdf"
									forward(action: "formBPart5", params: [msg1: 'Wrong format of pdf!'])
									return
								}
							}catch (Exception e){
								println e.message
								flash.message = "Wrong format of pdf"
								forward(action: "formBPart5", params: [msg1: 'Wrong format of pdf!'])
			
							}
						}
					}
		//uplaod 4
		if(params.declarationByRecipientCopy != '' || params.declarationByRecipientCopy != null){
						println "upload 3 starting"
						declarationByRecipientCopy1 = request.getFile('declarationByRecipientCopy')
						println "INSIDE ID PROOF "+declarationByRecipientCopy1
						declarationByRecipientCopyFilename = "DeclarationByRecipientCopy"
						if (declarationByRecipientCopy1 != null && declarationByRecipientCopy1?.getBytes()?.size() != 0) {
							println "upload 3 starting 2"
							def file = request.getFile('declarationByRecipientCopy')
							int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
							def nullByteCheck = file.getOriginalFilename().contains('%00')
							if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
								
								flash.message = "Wrong format of pdf"
								forward(action: "formBPart5", params: [msg1: 'Please upload file in pdf document format only!',
									appFormId:params.appFormId])
							}
							if (occurance > 1) {
								println '###################'
								flash.message = "Wrong format of pdf"
								forward(action: "formBPart5", params: [msg1: 'Please upload file and file must be .pdf document format only!',
									appFormId:params.appFormId])
							}
			
							try {
								PdfReader pdf = new PdfReader(file.getBytes())
								if(pdf && pdf.pdfVersion){}
								else{
									flash.message = "Wrong format of pdf"
									forward(action: "formBPart5", params: [msg1: 'Wrong format of pdf!'])
									return
								}
							}catch (Exception e){
								println e.message
								flash.message = "Wrong format of pdf"
								forward(action: "formBPart5", params: [msg1: 'Wrong format of pdf!'])
			
							}
						}
					}
		//end of upload form

		def appForm = ApplicationForm1.get(params.appFormId)

		println ")))))))))))))appForm--"+params
	
		appForm.declarationAcceptance= params.declarationAcceptance
		if(undertakingCopy1 != null && undertakingCopy1?.getBytes()?.size() != 0&&declarationBySupervisorCopy1 != null && declarationBySupervisorCopy1?.getBytes()?.size() != 0&&
			declarationByRecipientCopy1 != null && declarationByRecipientCopy1?.getBytes()?.size() != 0 && declarationByApplicantOnNationalityCopy1 != null && 
			declarationByApplicantOnNationalityCopy1?.getBytes()?.size() != 0){
			//println "SAVING EDITED FILE IDPROOF "+idProofFile
			
			new File(grailsApplication.config.undertakingCopyFormB.toString() + File.separatorChar +"UND-FOEMB").mkdirs()
			def filePath = new File(grailsApplication.config.undertakingCopyFormB.toString() + File.separatorChar + "UND-FOEMB"+ File.separatorChar + undertakingCopy1?.getOriginalFilename());
		   
			  undertakingCopy1.transferTo(filePath)
			 appForm.undertakingCopyURL = filePath;
			 
			 
			 new File(grailsApplication.config.declarationBySupervisorCopyFormB.toString() + File.separatorChar +"SupervisorCopy").mkdirs()
			 def filePath1 = new File(grailsApplication.config.declarationBySupervisorCopyFormB.toString() + File.separatorChar + "SupervisorCopy"+ File.separatorChar +declarationBySupervisorCopy1?.getOriginalFilename() );
			
			   declarationBySupervisorCopy1.transferTo(filePath1)
			  appForm.declarationBySupervisorCopyURL = filePath1;
			  
			  
			  new File(grailsApplication.config.declarationByRecipientCopyFormB.toString() + File.separatorChar +"RecipientCopy").mkdirs()
			  def filePath2 = new File(grailsApplication.config.declarationByRecipientCopyFormB.toString() + File.separatorChar + "RecipientCopy"+ File.separatorChar + declarationByRecipientCopy1?.getOriginalFilename());
			 
				declarationByRecipientCopy1.transferTo(filePath2)
			  appForm.declarationByApplicantOnNationalityCopyURL = filePath2;
			   
			   
			   new File(grailsApplication.config.declarationByApplicantOnNationalityCopyFormB.toString() + File.separatorChar +"NationalityCopy").mkdirs()
			   def filePath3 = new File(grailsApplication.config.declarationByApplicantOnNationalityCopyFormB.toString() + File.separatorChar + "NationalityCopy"+ File.separatorChar + declarationByApplicantOnNationalityCopy1?.getOriginalFilename());
			  
				 declarationByApplicantOnNationalityCopy1.transferTo(filePath3)
				appForm.declarationByApplicantOnNationalityCopyURL = filePath3;
			
			
			
			
			
			
			
			

//			appForm.undertakingCopy = undertakingCopy1.getBytes()
			appForm.undertakingCopyFileName = undertakingCopyFilename
			
//			appForm.declarationBySupervisorCopy = declarationBySupervisorCopy1.getBytes()
			appForm.declarationBySupervisorCopyFileName = declarationBySupervisorCopyFilename
			
//			appForm.declarationByRecipientCopy = declarationByRecipientCopy1.getBytes()
			appForm.declarationByRecipientCopyFileName = declarationByRecipientCopyFilename
			
//			appForm.declarationByApplicantOnNationalityCopy = declarationByApplicantOnNationalityCopy1.getBytes()
			appForm.declarationByApplicantOnNationalityCopyFileName = declarationByApplicantOnNationalityCopyFilename
			
		}
		if(!appForm.save(flush:true)){
			appForm.errors.each{println it}
		}

//		def applicationform = ApplicationForm1.get(appForm?.id)
		redirect(action:"formBPart5",params:[csrfPreventionSalt:csrfPreventionSalt,applicationformId:appForm?.id,formType:formType,appFormId:appForm?.id])
	}

	//form B part 5 submit end

	def formBPart5(){
		def appForm
		if(params?.applicationformId){
			appForm =   ApplicationForm1.get(params.applicationformId)
		}
		else{
			appForm =   ApplicationForm1.get(params.appFormId)
		}
		
		[formType:params.formType,appForm:appForm,listOfNotifications:MstrDocument.list()]
	}
	
	def showUndertakingFile(long id)
	{
		println"```````````````````````````````show diclration````````````````````````````````````````````"+params

		ByteArrayOutputStream ous = null;
		InputStream ios = null;
		def file,filename,appForm,formB
		def csrfPreventionSalt = params.csrfPreventionSalt
		appForm = ApplicationForm1.findById(params?.appFormId)

		
		if(params?.filename == 'addressproofLetter'){
			formB = FormB?.get(params?.id)
			file = formB?.addressproofLetter
			filename = formB?.addressproofLetterFileName
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
