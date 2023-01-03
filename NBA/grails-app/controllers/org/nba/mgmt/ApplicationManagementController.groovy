 package org.nba.mgmt
import grails.converters.JSON
import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse;

import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.security.cert.X509Certificate
import java.text.DateFormat
import java.text.SimpleDateFormat

import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSession
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

import org.nba.application.AgentProfile
import org.nba.application.AppStatus
import org.nba.application.ApplicationForm1
import org.nba.application.CompanyProfile
import org.nba.application.ContactDetailsOfRepository
import org.nba.application.ContactPerson
import org.nba.application.DepositionOfMicroOrganism
import org.nba.application.FormB
import org.nba.application.FormBFundingAgency
import org.nba.application.FormCategory
import org.nba.application.IndianGovtInst
import org.nba.application.IndianResearcher
import org.nba.application.IndividualProfile
import org.nba.common.Country
import org.nba.common.State
import org.nba.master.MstrDocument
import org.nba.master.QuestionCategory
import org.nba.master.Transaction
import org.nba.resource.BiologicalResource
import org.nba.resource.GeoLocationOfBioResource
import org.nba.resource.GeoLocationOfCommunity
import org.nba.user.NbaUserNbaRole
import org.springframework.security.access.annotation.Secured
import org.springframework.util.StringUtils

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.lowagie.text.pdf.PdfReader
import com.nba.constant.RemoteAddress

@Secured('permitAll')
class ApplicationManagementController {
	def springSecurityService
	def applicationMgmtService
	def appPreviewPdfService
	def pdfRenderingService
	def otpService
	def mailService
	def apiForCDACITMSToolsService
	def fileManagementService
	def grailsApplication

	static allowedMethods = [save: "POST"]
	//	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	def beforeInterceptor = [action: this.&invokeMeBeforeEveryLoad]
	def afterInterceptor = [action: this.&invokeMeAfterEveryLoad]

	private invokeMeBeforeEveryLoad (model){
		println "In invokeMeBeforeEveryLoad"
		println "Tracing action ${actionUri}"
		def role = NbaUserNbaRole.findByNbaUser(springSecurityService.currentUser)?.nbaRole?.authority
//		if (role == 'APPLICANT' || role == 'ADMIN') {
//		} else {
//			redirect(controller: 'login', action: 'denied')
//		}

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

	def selectIndividualOrCompany = {
		println "CURRENT USER == "+params.currentUser
		def formType = params.formType
		println "CURRENT USER "+springSecurityService.getCurrentUser()
		[formType:formType]
	}
	
	
	def depositionOfMicroOrganism={
		
		def listOfDepositionOfMicroOrganism = [],appForm
		def csrfPreventionSalt = params?.csrfPreventionSalt
		List listOfCountries = []
		listOfCountries = Country.findAllByCountry('India')
		def listOfStates = State.list()
		def formType = params.formType
		
		
		if(params.formType != ''){
			

			if(params?.appFormId != '' || params?.appFormId != null){
				appForm = ApplicationForm1.get(params?.appFormId)
			}
			session.setAttribute('appFormId',appForm?.id)
			println "appForm == "+appForm
		}
		if(appForm != null){
			println "appForm))))))))))))))))))"+appForm
			listOfDepositionOfMicroOrganism = DepositionOfMicroOrganism.findAllByApplicationForm1(appForm)
			println "listOfIndianResearcher == "+listOfDepositionOfMicroOrganism

			//agentProfile = AgentProfile.findByApplicationFormAndIsIndividualAgent(appForm,true)
		}
		print "...........params?.id......."+params?.id
		def depositionOfMicroOrganism1 = DepositionOfMicroOrganism.get(params?.id)
		
	
		[formType:formType,appForm:appForm,listOfCountries:listOfCountries,statesList:listOfStates,listOfDepositionOfMicroOrganism:listOfDepositionOfMicroOrganism,
			csrfPreventionSalt:csrfPreventionSalt,depositionOfMicroOrganism1:depositionOfMicroOrganism1]
	}
	
	def deleteDepositionOfMicroOrganism = {
		println "Inside deleteProfile "+params
		def csrfPreventionSalt = params.csrfPreventionSalt
		def depositionOfMicroOrganism,listOfDepositionOfMicroOrganism = [],appForm
		print "--params?.appFormId--"+params?.appFormId
		if(params?.appFormId != '' || params?.appFormId != null){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		else if(session.getAttribute("appFormId") != null){
			appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
		}
		print "--profile id--"+params.profileId
		if(params.profileId != ''){
			depositionOfMicroOrganism = DepositionOfMicroOrganism.get(params.profileId)
			depositionOfMicroOrganism.delete(flush:true)
			flash.message = "Deleted Successfully"

			listOfDepositionOfMicroOrganism = DepositionOfMicroOrganism.findAllByApplicationForm1(appForm)
			println "listOfIndividualProfiles == "+listOfDepositionOfMicroOrganism
			redirect(action: "depositionOfMicroOrganism", id: depositionOfMicroOrganism?.id, params: [csrfPreventionSalt:csrfPreventionSalt,formType: params?.formType,appFormId : appForm?.id, deleteCalled:'deleteCalled'])
			//render(template:"individualProfileGrid",model:[listOfIndividualProfiles:listOfIndividualProfiles])
		}
	}
	def editDepositionOfMicroOrganism = {
		println "Inside editIndividualProfile "+params
		def nationality,appForm,idProofSelect
		def csrfPreventionSalt = params.csrfPreventionSalt
		def depositionOfMicroOrganism = DepositionOfMicroOrganism.get(params.profileId)
		
		def listOfCountries = Country.list()
	
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}
		redirect(action: "depositionOfMicroOrganism", id: depositionOfMicroOrganism?.id, params: [csrfPreventionSalt:csrfPreventionSalt,formType: params?.formType,appFormId:appForm?.id,idProofSelect:idProofSelect])
	}
	
	def submitDepositionOfMicroOrganism= {
			println "submitDepositionOfMicroOrganism----------------"+params.profileId
		println "PARAmS are == "+params
		println "appFormId--.........."+params?.appFormId
		def csrfPreventionSalt = params.csrfPreventionSalt
		//For company profile
		//start
		def category,appForm,existingAppForm
		def formType = params.formType
		
		if(params?.appFormId != ''){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		
		if(params.formType  == 'FormC'){
			category = FormCategory.findByCategory(FormCategory.Category.Form_C)
		}
		if(params.profileId){
			def existingProfile = DepositionOfMicroOrganism.get(params.profileId)
			println "profileID777777777777777"+params.profileId
			applicationMgmtService.updateDepositionOfMicroOrganism(params,category,existingProfile)
			
		}
		else{
//			if(params?.appFormId != '' || params?.appFormId != null){
//				println "appFormId---"
//				appForm = ApplicationForm1.get(params?.appFormId)
//			}
//			else if(session.getAttribute("appFormId") != null){
//				appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
//			}
			appForm = applicationMgmtService.saveDepositionOfMicroOrganism(params,category,appForm)
			println"appform data --"+appForm?.id
			session["appFormId"] = appForm?.id
		}
		
	
		redirect(action:"depositionOfMicroOrganism",params:[csrfPreventionSalt:csrfPreventionSalt,formType:formType,appFormId:appForm?.id])
	}
	
		
	
	
	def submitScientistName= {
	
	println "PARAmS are == "+params
	println "appFormId--"+params?.appFormId
	def csrfPreventionSalt = params.csrfPreventionSalt
	//For company profile
	//start
	def category,appForm,existingAppForm
	def formType = params.formType
	if(params.formType  == 'FormC'){
		category = FormCategory.findByCategory(FormCategory.Category.Form_C)
	}
	if(params.profileId){
		BiologicalResource existingProfile = BiologicalResource.get(params.profileId)
		existingProfile.scientistName=params.scientistName
		if(!existingProfile.save(flush:true)){
			existingProfile.errors.each{ println it }
		}
		println "profileID777777777777777   "+params.profileId
		//applicationMgmtService.updateDepositionOfMicroOrganism(params,category,existingProfile)
		if(params?.appFormId != ''){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
//		render(template:"formCMicroorganismName",model:[csrfPreventionSalt:csrfPreventionSalt,formType:formType,appFormId:appForm?.id])
	}
	else{
		if(params?.appFormId != '' || params?.appFormId != null){
			println "appFormId---"
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		else if(session.getAttribute("appFormId") != null){
			appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
		}
		def microOrgScientistName = new BiologicalResource(scientistName:params.scientistName)
		println "profileID55555"
		appForm.addToBiologicalResources(microOrgScientistName)
		
					if(!microOrgScientistName.save(flush:true)){
						microOrgScientistName.errors.each{ println it }
					}
				
					if(!appForm.save(flush:true)){
						appForm.errors.each{ println it }
					}
	//	appForm = applicationMgmtService.saveDepositionOfMicroOrganism(params,category,appForm)
		println"appform data --"+appForm?.id
		session["appFormId"] = appForm?.id
//		render(template:"formCMicroorganismName",model:[csrfPreventionSalt:csrfPreventionSalt,formType:formType,appFormId:appForm?.id])
	}
	println "before redirect"
	redirect(action:"formCPart2",params:[csrfPreventionSalt:csrfPreventionSalt,formType:formType,appFormId:appForm?.id])
	
}
	
	def deleteScientistName = {
		println "Inside deleteProfile "+params
		def csrfPreventionSalt = params.csrfPreventionSalt
		def microOrganismScientistName,listOfScientistName = [],appForm
		print "--params?.appFormId--"+params?.appFormId
		if(params?.appFormId != '' || params?.appFormId != null){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		else if(session.getAttribute("appFormId") != null){
			appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
		}
		print "--profile id--"+params.profileId
		if(params.profileId != ''){
			microOrganismScientistName = BiologicalResource.get(params.profileId)
			microOrganismScientistName.delete(flush:true)
			flash.message = "Deleted Successfully"

			listOfScientistName = BiologicalResource.findAllByApplicationForm(appForm)
			println "listOfIndividualProfiles == "+listOfScientistName
			redirect(action: "formCPart2", id: microOrganismScientistName?.id, params: [csrfPreventionSalt:csrfPreventionSalt,formType: params?.formType,appFormId : appForm?.id, deleteCalled:'deleteCalled'])
			//render(template:"individualProfileGrid",model:[listOfIndividualProfiles:listOfIndividualProfiles])
		}
	}
	
	def editScientistName = {
		println "Inside ScientistName "+params
		def appForm
		def csrfPreventionSalt = params.csrfPreventionSalt
		def microOrgScientistName = BiologicalResource.get(params.profileId)
		
		def listOfCountries = Country.list()
	
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}
		redirect(action: "formCPart2", id: microOrgScientistName?.id, params: [csrfPreventionSalt:csrfPreventionSalt,formType: params?.formType,appFormId:appForm?.id])
	}
	
	def submitGeolocationMicroOrganism= {
		
		println "PARAmS are == "+params
		
		def csrfPreventionSalt = params.csrfPreventionSalt
		//For company profile
		//start
		def category,appForm,existingAppForm,bioresource,appFormId
		def formType = params.formType
		if(params.formType  == 'FormC'){
			category = FormCategory.findByCategory(FormCategory.Category.Form_C)
			println ""+category
		}
		if(params.profileId){
			GeoLocationOfBioResource existingProfile = GeoLocationOfBioResource.get(params.profileId)
			existingProfile.village=params.village
			existingProfile.town=params.town
			existingProfile.district=params.district
			existingProfile.state=params.state
			existingProfile.source=params.source
			existingProfile.traderName=params.trader
			existingProfile.traderContactDetails=params.traderContactDetails
			if(!existingProfile.save(flush:true)){
				existingProfile.errors.each{ println it }
			}
			println "profileID777777777777777   "+params.profileId
			//applicationMgmtService.updateDepositionOfMicroOrganism(params,category,existingProfile)
			
		}
		else{
			
			 bioresource=BiologicalResource.findByScientistName(params.scientistName)
			 println "bioresource----444----------"+bioresource
			def microOrgGeoLocation = new GeoLocationOfBioResource(source:params.source,village:params.village,traderName:params.trader,traderContactDetails:params.traderContactDetails,town:params.town,district:params.district,state:params.state,bioResource:bioresource)
			println "profileID55555"
		bioresource.addToLocations(microOrgGeoLocation)
			
						if(!microOrgGeoLocation.save(flush:true)){
							microOrgGeoLocation.errors.each{ println it }
						}
					
						
		//	appForm = applicationMgmtService.saveDepositionOfMicroOrganism(params,category,appForm)
			
		}
		def geoLocationlist=[]
		
		appForm = ApplicationForm1.get(params?.appFormId)
	def	listOfScientistName = BiologicalResource.findAllByApplicationForm(appForm)
		
		
	for(bioResorce in listOfScientistName){
				def bioResourceLocations = GeoLocationOfBioResource.findAllByBioResource(bioResorce)
				for(loc in bioResourceLocations){
					geoLocationlist.add(loc)
				}
			}
		
//		if(bioresource!=null) {
//		 geoLocationlist = GeoLocationOfBioResource.findAllByBioResource(bioresource)
//		}
	
	def scientistname=BiologicalResource.findByScientistName(params.scientistName)
		print "scientistname.........."+scientistname
		render(template:"formCMicroorganismGrid",model:[formType:formType,appFormId:params.appFormId,geoLocationlist:geoLocationlist,bioresource:scientistname])
		//
		
		
		
		//redirect(action:"formCPart2",params:[csrfPreventionSalt:csrfPreventionSalt,formType:formType])
	}
	
	
	
	def deleteGeoMicroOrganism = {
		println "Inside deleteProfile "+params
		def csrfPreventionSalt = params.csrfPreventionSalt
		def microOrganismScientistName,listOfScientistName = [],appForm
		print "--params?.appFormId--"+params?.appFormId
		if(params?.appFormId != '' || params?.appFormId != null){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		else if(session.getAttribute("appFormId") != null){
			appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
		}
		print "--profile id--"+params.profileId
		if(params.profileId != ''){
			microOrganismScientistName = GeoLocationOfBioResource.get(params.profileId)
			microOrganismScientistName.delete(flush:true)
			flash.message = "Deleted Successfully"

			//listOfScientistName = GeoLocationOfBioResource.findAllByApplicationForm(appForm)
			println "listOfIndividualProfiles == "+listOfScientistName
		
			redirect(action: "formCPart2", id: microOrganismScientistName?.id, params: [csrfPreventionSalt:csrfPreventionSalt,formType: params?.formType,appFormId : appForm?.id, deleteCalled:'deleteCalled'])
			//render(template:"individualProfileGrid",model:[listOfIndividualProfiles:listOfIndividualProfiles])
		}
	}
	
	def editGeoMicroOrganism= {
		println "Inside ScientistName "+params
		def csrfPreventionSalt = params.csrfPreventionSalt
		def microOrganismScientistName,listOfScientistName = [],appForm,geoLocationlist,geoLocationlist1,scientistName
		
		geoLocationlist1=GeoLocationOfBioResource.get(params.profileId)
		scientistName = BiologicalResource?.get(params?.bioresourceId)
		
		print "--params?.appFormId--"+params?.appFormId
		if(params.formType != ''){
			

			if(params?.appFormId != '' || params?.appFormId != null){
				appForm = ApplicationForm1.get(params?.appFormId)
			}
			session.setAttribute('appFormId',appForm?.id)
			println "appForm == "+appForm
		}
		if(appForm != null){
			println "appForm))))))))))))))))))"+appForm
			listOfScientistName = BiologicalResource.findAllByApplicationForm(appForm)
//			for(bioResorce in listOfScientistName){
//				def bioResourceLocations = GeoLocationOfBioResource.findAllByBioResource(bioResorce)
//				for(loc in bioResourceLocations){
//					geoLocationlist.add(loc)
//				}
//			}
		
			redirect(action: "formCPart2",  params: [csrfPreventionSalt:csrfPreventionSalt,formType: params?.formType,listOfScientistName:listOfScientistName,geoLocationid: geoLocationlist1?.id,
				geoLocationlist:geoLocationlist,appFormId : appForm?.id, scientistNameId:scientistName?.id])
			//render(template:"individualProfileGrid",model:[listOfIndividualProfiles:listOfIndividualProfiles])
		}
		
	}
	def formCPart2={
		println "formCPart2 == "+params
		List locations
		def csrfPreventionSalt = params?.csrfPreventionSalt
		def formType = params.formType
		def listOfScientistName = [],appForm,geoLocationlist=[],templist,scientistNameObj,bioResourceLocations
		def listOfStates = State.list()
		def accessSources = ['Wild', 'Cultivated', 'Market', 'Trader', 'Repositories', 'Institution', 'Others']
		if(params.formType != ''){
			

			if(params?.appFormId != '' || params?.appFormId != null){
				appForm = ApplicationForm1.get(params?.appFormId)
			}
			session.setAttribute('appFormId',appForm?.id)
			println "appForm == "+appForm
		}
		if(appForm != null){
			println "appForm))))))))))))))))))"+appForm
			listOfScientistName = BiologicalResource.findAllByApplicationForm(appForm)
//			scientistNameObj = BiologicalResource.get(params?.scientistNameId)
			
			locations = new ArrayList()
			
			for(bioResorce in listOfScientistName){
				println "bioResourceLocations-------"+bioResorce
				
				bioResourceLocations = GeoLocationOfBioResource?.findAllByBioResource(bioResorce)
				for(loc in bioResourceLocations){
					locations.add(loc)
				}
			}
			println "locations------"+locations

			
			println "listOfIndianResearcher == "+listOfScientistName+".........."+geoLocationlist
			

		}
		def newList = []
		def listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)
		println "listOfBioResources == "+listOfBioResources

		listOfBioResources?.each{
			println "it?.scientistName == "+it?.scientistName
			if(it?.scientistName?.equals(null) == false){
				println "contrins null"
				newList.add(it)
			}
		}
		def geoLocationlist1 = GeoLocationOfBioResource.get(params?.geoLocationid)
		def microOrgaScirntistName = BiologicalResource.get(params?.id)
		println "microOrgaScirntistName----------"+microOrgaScirntistName
		//def geoLocationlist=GeoLocationOfBioResource.get(params?.id)
		println "CURRENT USER "+springSecurityService.getCurrentUser()
		[formType:formType,appForm:appForm,appFormId:params.appFormId,listOfScientistName:listOfScientistName,geoLocationlist1:geoLocationlist1,microOrgaScirntistName:microOrgaScirntistName,deleteCalled:params.deleteCalled,
			listOfStates:listOfStates,geoLocationlist:geoLocationlist,scientistNameObj:scientistNameObj,locations:locations,newList:newList,accessSources:accessSources,csrfPreventionSalt:csrfPreventionSalt]
	}
	def formCPart3={
		println "depositionOfMicroOrganism == "+params.csrfPreventionSalt
		def csrfPreventionSalt = params.csrfPreventionSalt
		List listOfCountries = []
		List listOfForeignCountries = []
		List indianCountries = []
		listOfCountries=Country.list()
		listOfForeignCountries = Country.findAllByCountryNotEqual('India')
		indianCountries = Country.findAllByCountry('India')
		println "---indianCountries---"+indianCountries
		def listOfStates = State.list()
		def appForm,listOfContactDetailsOfRepository,foreignRepo,indianRepo,applicationform,indianRepoForAccession
		if(params.formType != ''){
			

			if(params?.appFormId != '' || params?.appFormId != null){
				appForm = ApplicationForm1.get(params?.appFormId)
			}
			session.setAttribute('appFormId',appForm?.id)
			println "appForm == "+appForm
		}
		if(appForm != null){
			println "appForm))))))))))))))))))"+appForm
			foreignRepo = ContactDetailsOfRepository.findByApplicationForm1AndRepostoryType(appForm,'ForeignRepository')
			indianRepo =  ContactDetailsOfRepository.findByApplicationForm1AndRepostoryType(appForm,'IndianRepository')
//			if(params?.accessionNumber){
				indianRepoForAccession =  ContactDetailsOfRepository.findByApplicationForm1AndIsAccessionNumAllotted(appForm,true)
//			}	
			println "listOfIndianResearcher == "+listOfContactDetailsOfRepository
			 applicationform = ApplicationForm1.get(appForm.id)
			//agentProfile = AgentProfile.findByApplicationFormAndIsIndividualAgent(appForm,true)
		}
		
	
		def formType = params.formType
		println "CURRENT USER "+springSecurityService.getCurrentUser()
		[formType:formType,appForm:appForm,listOfCountries:listOfCountries,listOfForeignCountries:listOfForeignCountries,indianCountries:indianCountries,csrfPreventionSalt:csrfPreventionSalt,
			listOfStates:listOfStates,applicationform:applicationform,foreignRepo:foreignRepo,indianRepo:indianRepo,listOfContactDetailsOfRepository:listOfContactDetailsOfRepository,
			appFormId:params.appFormId,indianRepoForAccession:indianRepoForAccession]
	}


	def submitContactDetailsOfReposatory= {
		println "submitDepositionOfMicroOrganism----------------"+params.profileId
	println "PARAmS are == "+params
	println "appFormId--"+params?.appFormId
	def csrfPreventionSalt = params.csrfPreventionSalt
	//For company profile
	//start
	def category,appForm,existingAppForm
	def formType = params.formType
	if(params.formType  == 'FormC'){
		category = FormCategory.findByCategory(FormCategory.Category.Form_C)
		println ".............."+category
	}
	if(params.profileId){
		def existingProfile = ContactDetailsOfRepository.get(params.profileId)
		println "profileID777777777777777   "+params.profileId
		println ".............."+category
	applicationMgmtService.updateContactDetailsOfReposatory(params,existingProfile)
		/*  update part*/

		
		if(params?.appFormId != ''){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
	}
	else{
		if(params?.appFormId != '' || params?.appFormId != null){
			println "appFormId---"
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		else if(session.getAttribute("appFormId") != null){
			appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
		}
		appForm = applicationMgmtService.saveContactDetailsOfReposatory(params,category,appForm)
		println"appform data --"+appForm?.id
		session["appFormId"] = appForm?.id
	}
	

	redirect(action:"formCPart3",params:[csrfPreventionSalt:csrfPreventionSalt,formType:formType,appFormId:appForm?.id])
}
	
	
	def submitAccessionNumber(){
		println "accessionNumber-----"+params?.formType
		def contactDetailsOfRepositoryObj
		def csrfPreventionSalt = params?.csrfPreventionSalt
		def appForm = ApplicationForm1.get(params?.appFormId)
		
		if(params?.profileId){
			contactDetailsOfRepositoryObj = ContactDetailsOfRepository?.get(params?.profileId)
			contactDetailsOfRepositoryObj?.accessionNumber = params?.accessionNumber
			contactDetailsOfRepositoryObj?.applicationForm1 = appForm
			contactDetailsOfRepositoryObj?.isAccessionNumAllotted = true
		}
		else{
			contactDetailsOfRepositoryObj = new ContactDetailsOfRepository(accessionNumber:params?.accessionNumber,applicationForm1:appForm,isAccessionNumAllotted:true);
		}
		
		if(!contactDetailsOfRepositoryObj.save(flush:true)){
			contactDetailsOfRepositoryObj.errors.each{ println it }
		}
		
		redirect(action:"formCPart3",params:[csrfPreventionSalt:csrfPreventionSalt,formType:params?.formType,appFormId:appForm?.id])
	}

	
	def submitDepositionPerpose= {
		println "submitDepositionOfMicroOrganism----------------"+params.profileId
	println "PARAmS are == "+params
	def csrfPreventionSalt = params.csrfPreventionSalt
	//For company profile
	//start
	def category,appForm,existingAppForm
	def formType = params.formType
	if(params.formType  == 'FormC'){
		category = FormCategory.findByCategory(FormCategory.Category.Form_C)
	}
	if(params?.appFormId != '' || params?.appFormId != null){
		println "appFormId---"
		ApplicationForm1 existingProfile = ApplicationForm1.get(params.appFormId)
		existingProfile.depositionPerpose=params.depositionPerpose
		if(!existingProfile.save(flush:true)){
			existingProfile.errors.each{ println it }
		}
		appForm = ApplicationForm1.get(params?.appFormId)
	}
	
	redirect(action:"formCPart3",params:[csrfPreventionSalt:csrfPreventionSalt,formType:formType,appFormId:appForm?.id])
	}

	def submitDeclarationFormC= {
		println "submitDeclarationFormC----------------"+params.profileId
	println "PARAmS are == "+params
	def undertakingCopy1,undertakingCopyFilename,formType
	formType=params.formType
	def csrfPreventionSalt = params.csrfPreventionSalt
	if(params.undertakingCopy != '' || params.undertakingCopy != null){
		
					undertakingCopy1 = request.getFile('undertakingCopy')
					println "INSIDE ID PROOF "+undertakingCopy1
					undertakingCopyFilename = "UndertakingCopy"
					if (undertakingCopy1 != null && undertakingCopy1?.getBytes()?.size() != 0) {
						def file = request.getFile('undertakingCopy')
						int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
						def nullByteCheck = file.getOriginalFilename().contains('%00')
						if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
							println '====================='
							flash.message = "Wrong format of pdf"
							forward(action: "formCPart4", params: [msg1: 'Please upload file in pdf document format only!',
								appFormId:params.appFormId])
						}
						if (occurance > 1) {
							println '###################'
							flash.message = "Wrong format of pdf"
							forward(action: "formCPart4", params: [msg1: 'Please upload file and file must be .pdf document format only!',
								appFormId:params.appFormId])
						}
		
						try {
							PdfReader pdf = new PdfReader(file.getBytes())
							if(pdf && pdf.pdfVersion){}
							else{
								flash.message = "Wrong format of pdf"
								forward(action: "formCPart4", params: [msg1: 'Wrong format of pdf!'])
								return
							}
						}catch (Exception e){
							println e.message
							flash.message = "Wrong format of pdf"
							forward(action: "formCPart4", params: [msg1: 'Wrong format of pdf!'])
		
						}
					}
				}
	
	
	def appForm = ApplicationForm1.get(params.appFormId)
	
	//appForm.declarationAcceptance= params.declarationAcceptance
	if(undertakingCopy1 != null && undertakingCopy1?.getBytes()?.size() != 0){
		//println "SAVING EDITED FILE IDPROOF "+idProofFile
		
		new File(grailsApplication.config.undertakingCopyFormC.toString() + File.separatorChar +"UND-FOEMC").mkdirs()
		def filePath = new File(grailsApplication.config.undertakingCopyFormC.toString() + File.separatorChar + "UND-FOEMC"+ File.separatorChar + undertakingCopy1?.getOriginalFilename());
	   
		  undertakingCopy1.transferTo(filePath)
		 appForm.undertakingCopyURL = filePath;

//		appForm.undertakingCopy = undertakingCopy1.getBytes()
		appForm.undertakingCopyFileName = undertakingCopyFilename

	}
	
	if(params.radio == 'digital'){
		println "under 1"
		appForm?.isDeclarationDigitallySigned = 'true'
		println "under 11"
	}
	else{
		println "under2"
		appForm?.isDeclarationDigitallySigned = 'notDigital'
		println "under 22"
	}
	
	if(!appForm.save(flush:true)){
		appForm.errors.each{println it}
	}
	
	def applicationform = ApplicationForm1.get(appForm?.id)
	redirect(action:"formCPart4",params:[csrfPreventionSalt:csrfPreventionSalt,applicationform:applicationform,formType:formType,appFormId:appForm?.id])
	}
	
	def formCPart4={
		println "formCPart4............"+params
		def formType = params.formType
		def appFormId=params.appFormId
		def applicationform = ApplicationForm1.get(appFormId)
	//	println "CURRENT USER "+springSecurityService.getCurrentUser()
		[formType:formType,appForm:applicationform,appFormId:appFormId,applicationform:applicationform,listOfNotifications:MstrDocument.list()]
	}

	def showUndertakingFile(long id)
	{
		println"```````````````````````````````show diclration````````````````````````````````````````````"+params

		ByteArrayOutputStream ous = null;
		InputStream ios = null;
		def applicantform= ApplicationForm1.findById(params?.id)
		def transactionId = Transaction?.findById(params?.id)
		def file,filename,appForm,indianResearcher,formB
		def csrfPreventionSalt = params.csrfPreventionSalt
		appForm = ApplicationForm1.findById(params?.appFormId)

		if(params.filename == 'undertakingCopy'){
			if(applicantform?.undertakingCopy){
				file = applicantform?.undertakingCopy
				
			}else if(applicantform?.undertakingCopyURL){
			
			file = new File(applicantform?.undertakingCopyURL)?.getBytes()
			}
			
			filename = applicantform?.undertakingCopyFileName
		}
		if(params?.filename == 'declarationBySupervisorCopy'){
            if(applicantform.declarationBySupervisorCopy){
				file = applicantform.declarationBySupervisorCopy
			}else if(applicantform.declarationBySupervisorCopyURL){
			file = new File(applicantform.declarationBySupervisorCopyURL)?.getBytes()
			}
			
			filename = applicantform?.declarationBySupervisorCopyFileName
		}
		
		if(params?.filename == 'declarationByRecipientCopy'){
			
			if(applicantform.declarationByRecipientCopy){
				file = applicantform.declarationByRecipientCopy
				}else if(applicantform.declarationByRecipientCopyURL){
				
				file = new File(applicantform.declarationByRecipientCopyURL)?.getBytes()
				}
			filename = applicantform?.declarationByRecipientCopyFileName
		}
		if(params?.filename == 'addressproofLetter'){
			indianResearcher = IndianResearcher?.get(params?.id)
			if(indianResearcher?.addressproofLetter){
				file = indianResearcher?.addressproofLetter
			}else if(indianResearcher?.addressproofLetterURL){
				file =new File(indianResearcher?.addressproofLetterURL)?.getBytes()
			}


			filename = indianResearcher?.addressproofLetterFileName
		}
		if(params?.filename == 'sanctionOrderMoUcopy'){
//			formB = FormB?.get(params?.id)
			formB = FormBFundingAgency?.get(params?.id)
			if(formB?.sanctionOrder){
             file = formB?.sanctionOrder

			}else if(formB?.sanctionOrderURL){
				file = new File(formB?.sanctionOrderURL)?.getBytes()
			}
			
			filename = formB?.sanctionOrderMoUcopyFileName
		}
		if(params?.filename == 'declarationByApplicantOnNationalityCopy'){
			print "---0---"
			formB = FormB?.get(params?.id)
			if(applicantform?.declarationByApplicantOnNationalityCopy){

              file = applicantform?.declarationByApplicantOnNationalityCopy

			}else if(applicantform?.declarationByApplicantOnNationalityCopyURL){}

			file = new File(applicantform?.declarationByApplicantOnNationalityCopyURL)?.getBytes()
			
			filename = applicantform?.declarationByApplicantOnNationalityCopyFileName
		}
		

		//println "FILE == "+file
		byte[] DocContent = null;
		DocContent = file
		response.setHeader "Content-disposition", "inline; filename=filename"
		response.contentType = 'application/pdf'
		response.outputStream << DocContent
		response.outputStream.flush()
	}

	def selectProfileType = {

		def csrfPreventionSalt = params.csrfPreventionSalt
		println "PARAMS ARE "+params
		def formType = params.formType
		if(params.profile == "1"){
			redirect(action:"individualProfile",params:[csrfPreventionSalt:csrfPreventionSalt,formType:formType])
		}
		else if(params.profile == "2") {
			redirect(action:"companyProfile",params:[csrfPreventionSalt:csrfPreventionSalt,formType:formType])
		}
	}

	def editAgentProfile = {
		def csrfPreventionSalt = params.csrfPreventionSalt
		println "editAgentProfile == "+params
		def agentProfile,profiles,profile,appForm,agentPhotoIdSelect
		def listOfStates = State.list()
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}
		if(params.agentId != ''){
			agentProfile = AgentProfile.get(params.agentId)
			println "Inside editAgentProfile "+agentProfile
			profile = ['-Select-', 'Attorney', 'Others']
			profiles = ['-Select-', 'Student', 'Researcher', 'Attorney', 'Others']

			agentPhotoIdSelect = [ 'Driving Licence', 'Passport', 'Government ID']

			if(params.company){
				render(template:"editAgentProfile",model:[csrfPreventionSalt:csrfPreventionSalt,agentPhotoIdSelect:agentPhotoIdSelect,appForm:appForm,profile:profile,agentProfile:agentProfile,listOfStates:listOfStates,formType:params.formType])
			}
			else{
				render(template:"editAgentProfile",model:[csrfPreventionSalt:csrfPreventionSalt,appForm:appForm,profiles:profiles,formType:params.formType,agentPhotoIdSelect:agentPhotoIdSelect,listOfStates:listOfStates,agentProfile:agentProfile, editAgentProfile1 : 'editAgentProfile'])
			}
		}
	}

	def deleteAgentProfile = {
		println "Inside deleteAgentProfile "+params
		def existingAgentProfile,profiles
		def csrfPreventionSalt
		if(params.agentId != ''){
			existingAgentProfile = AgentProfile.get(params.agentId)
			def appForm = ApplicationForm1.findByAgentProfile(existingAgentProfile)
			appForm.agentProfile = null
			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}
			if(existingAgentProfile != null){
				existingAgentProfile.delete(flush:true)
			}


			def agentProfile = appForm.agentProfile
			println "print agentProfile "+agentProfile
			redirect(template:"agentProfileGrid",model:[csrfPreventionSalt:csrfPreventionSalt,agentProfile:agentProfile])
		}
	}


	def getNationality = {


		println "jsonObject................"+params?.nationality
		def idProofSelect
		def nationality = params.nationality
		def csrfPreventionSalt = params.csrfPreventionSalt
		if(nationality == "Indian")
//			idProofSelect = ['Driving License','Aadhar Card','Voter Id Card','Government Id']
			idProofSelect = ['Driving License','Voter Id Card','Government Id']
			
		else if(nationality == "Non Indian")
			idProofSelect = ['Driving License','Government Id']
		else if(nationality == "Non-Resident Indian")
//			idProofSelect = ['Driving License','Aadhar Card','Voter Id Card','Government Id']
			
			idProofSelect = ['Driving License','Voter Id Card','Government Id']

		render idProofSelect
		//redirect(action: "individualProfile", params: [idProofSelect: idProofSelect,csrfPreventionSalt:csrfPreventionSalt])
	}

	def individualProfile = {

		println "params.nationalitySelect................................2"+params



		List listOfCountries = []
		listOfCountries = Country.list()
		println "listOfCountries == "+listOfCountries
		def listOfStates = State.list()
		println "CURRENT USER == "+springSecurityService.currentUser
		//find form type
		def appForm
		def csrfPreventionSalt = params.csrfPreventionSalt
		flash.message = params.msg1
		def formType = params.formType
		println "formType == "+formType
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
		println "appForm == "+appForm
		def listOfIndividualProfiles = [],agentProfile,nationality,profile,agentProfiles,idProofSelect,passportSelect,authorizationSelect, agentPhotoIdSelect, individualProf

		def idProofIndian,idProofNonIndian,idProofNRI

		if(params.formType == 'Form1' || params.formType == 'Form4')
			nationality = ['-Select-', 'Non Indian', 'Non-Resident Indian']
		else
			nationality = ['-Select-', 'Indian', 'Non Indian', 'Non-Resident Indian']

		profile = ['-Select-', 'Scientist', 'Student', 'Researcher', 'Others']

		agentProfiles = ['-Select-', 'Student', 'Researcher', 'Attorney', 'Others']

		passportSelect = ['Passport Copy','Driving Licence']

		authorizationSelect = ['Authorization Letter']

		agentPhotoIdSelect = [ 'Driving Licence', 'Passport', 'Government ID']

		if(params?.idProofSelect)
		    idProofSelect = params?.idProofSelect
		
			
			
		println "idProofSelect.........................."+idProofSelect

		//individualProf = IndividualProfile.findByApplicationForm1(appForm)

		//println "individualProfindividualProfindividualProf ...."+individualProf?.nationality
		
		if(params.formType == 'Form2' || params.formType == 'Form3')
//			idProofIndian = ['Driving License', 'Aadhar Card', 'Voter Id Card', 'Government Id']
		idProofIndian = ['Driving License', 'Voter Id Card', 'Government Id']
			
		//idProofNonIndian = ['Driving License', 'Government Id']
		//idProofNRI = ['Driving License', 'Aadhar Card', 'Voter Id Card', 'Government Id']

		if(appForm != null){
			listOfIndividualProfiles = IndividualProfile.findAllByApplicationForm1(appForm)
			println "listOfIndividualProfiles == "+listOfIndividualProfiles
			println "agentProfile == "+appForm?.agentProfile

			if(appForm?.agentProfile?.isIndividualAgent == true){
				agentProfile = appForm?.agentProfile
			}
			//agentProfile = AgentProfile.findByApplicationFormAndIsIndividualAgent(appForm,true)
		}

		def individualProfile1 = IndividualProfile.get(params?.id)
		println "individualProfile1 ============ "+individualProfile1
		[statesList:State.list(),appForm:appForm,formType:formType,nationality:nationality,profile:profile,agentProfiles:agentProfiles,idProofSelect:idProofSelect,
			listOfCountries:listOfCountries,listOfStates:listOfStates,listOfIndividualProfiles:listOfIndividualProfiles,csrfPreventionSalt:csrfPreventionSalt,
			agentProfile:agentProfile,nationality:nationality,individualProfile1:individualProfile1,deleteCalled:params?.deleteCalled,
			passportSelect:passportSelect,authorizationSelect:authorizationSelect,agentPhotoIdSelect:agentPhotoIdSelect,idProofIndian:idProofIndian]
	}

	def fetchCountryCode = {
		println "COUNTRY EXISTS "+params
		if((params.nationality != '') && (params.nationality == 'Indian')){
			def country = Country.findByCountry('India')
			println "country == "+country

			render country as JSON
		}
		else{
			def listOfCountries = []
			listOfCountries = Country.list().remove(Country.findByCountry('India'))
			render listOfCountries as JSON
		}

	}

	def fetchMobileCode(){
		println "Inside fetchMobileCode "+params
		def csrfPreventionSalt = params.csrfPreventionSalt
		def myMap = [:]
		if(params.countryId != ''){
			def country = Country.get(params.countryId)

			//myMap.country = country
			//myMap.csrfPreventionSalt = csrfPreventionSalt
			myMap.put("csrfPreventionSalt",csrfPreventionSalt)
			myMap.put("phonecode",country.phonecode)
			render myMap as JSON
		}

	}

	def submitIndividualFormProfile = {
		println "Inside submitIndividualFormProfile "+params

		def csrfPreventionSalt = params.csrfPreventionSalt
		println "listProfileId-----------"+params.listProfileId

		def idProofFile,idProofFilename,passportFile,passportFilename,authorityLetter,authorityLetterFilename,profileList
		
	if(params.IdProof != '' || params.IdProof != null){

			idProofFile = request.getFile('IdProof')
			println "INSIDE ID PROOF "+idProofFile
			idProofFilename = "IdProof"
			if (idProofFile != null && idProofFile?.getBytes()?.size() != 0) {
				def file = request.getFile('IdProof')
				int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
				def nullByteCheck = file.getOriginalFilename().contains('%00')
				if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
					println '====================='
					flash.message = "Wrong format of pdf"
					forward(action: "individualProfile", params: [msg1: 'Please upload file in pdf document format only!',
						appFormId:params.appFormId])
				}
				if (occurance > 1) {
					println '###################'
					flash.message = "Wrong format of pdf"
					forward(action: "individualProfile", params: [msg1: 'Please upload file and file must be .pdf document format only!',
						appFormId:params.appFormId])
				}

				try {
					PdfReader pdf = new PdfReader(file.getBytes())
					if(pdf && pdf.pdfVersion){}
					else{
						flash.message = "Wrong format of pdf"
						forward(action: "individualProfile", params: [msg1: 'Wrong format of pdf!'])
						return
					}
				}catch (Exception e){
					println e.message
					flash.message = "Wrong format of pdf"
					forward(action: "individualProfile", params: [msg1: 'Wrong format of pdf!'])

				}
			}
		}
		if(params.Passport != '' || params.Passport != null){
			println "INSIDE PASSPORT"
			passportFile = request.getFile('Passport')
			passportFilename = "Passport"
			//if (params.Passport) {
			println "INSIDE PASSPORT vvvvvvvvvvvv"+passportFile?.getBytes()?.size()


			if (passportFile != null && passportFile?.getBytes()?.size() != 0) {
				def file = request.getFile('Passport')
				int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
				def nullByteCheck = file.getOriginalFilename().contains('%00')
				println "INSIDE PASSPORT FILE"+passportFile
				if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
					println '====================='
					flash.message = "Wrong format of pdf"
					forward(action: "individualProfile", params: [msg1: 'Please upload file in pdf document format only!',
						appFormId:params.appFormId])
				}
				if (occurance > 1) {
					println '###################'
					flash.message = "Wrong format of pdf"
					forward(action: "individualProfile", params: [msg1: 'Please upload file and file must be .pdf document format only!',
						appFormId:params.appFormId])

				}

				try {
					PdfReader pdf = new PdfReader(file.getBytes())
					if(pdf && pdf.pdfVersion){}
					else{
						flash.message = "Wrong format of pdf"
						forward(action: "individualProfile", params: [msg1: 'Wrong format of pdf!'])
					}
				}catch (Exception e){
					println e.message
					flash.message = "Wrong format of pdf"
					forward(action: "individualProfile", params: [msg1: 'Wrong format of pdf!'])

				}
			}
		}


		println "INSIDE AuthorityLetter"
		authorityLetter = request.getFile('AuthorityLetter')
		authorityLetterFilename = "AuthorityLetter"
		//if(params.AuthorityLetter != ''){
		if (authorityLetter != null && authorityLetter?.getBytes()?.size() != 0) {
			def file = request.getFile('AuthorityLetter')
			int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
			def nullByteCheck = file.getOriginalFilename().contains('%00')
			if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
				println '====================='
				flash.message = "Wrong format of pdf"
				forward(action: "individualProfile", params: [msg1: 'Please upload file in pdf document format only!',
					appFormId:params.appFormId])
			}
			if (occurance > 1) {
				println '###################'
				flash.message = "Wrong format of pdf"
				forward(action: "individualProfile", params: [msg1: 'Please upload file and file must be .pdf document format only!',
					appFormId:params.appFormId])

			}

			try {
				PdfReader pdf = new PdfReader(file.getBytes())
				if(pdf && pdf.pdfVersion){}
				else{
					flash.message = "Wrong format of pdf"
					forward(action: "individualProfile", params: [msg1: 'Wrong format of pdf!'])
				}
			}catch (Exception e){
				println e.message
				flash.message = "Wrong format of pdf"
				forward(action: "individualProfile", params: [msg1: 'Wrong format of pdf!'])

			}
		}
		//}

		def category,appForm,newAppForm
		def formType = params.formType

		if(params.formType  == 'Form1'){
			category = FormCategory.findByCategory(FormCategory.Category.Form_1)
			println "**** ******* category ****** *****"+category
		}
		else if(params.formType  == 'Form2'){
			category = FormCategory.findByCategory(FormCategory.Category.Form_2)
		}
		else if(params.formType  == 'Form3'){
			category = FormCategory.findByCategory(FormCategory.Category.Form_3)
		}
		else if(params.formType  == 'Form4'){
			category = FormCategory.findByCategory(FormCategory.Category.Form_4)
		}

		// if profile exists
		if(params.profileId){
			def existingProfile = IndividualProfile.get(params.profileId)
			println "check for update-----"+existingProfile
			println "-------------------------under update ACTION------"+params
			String msgg = applicationMgmtService.updateIndividualProfile(params,idProofFile,idProofFilename,passportFile,passportFilename,
					authorityLetter,authorityLetterFilename,category,existingProfile)
			flash.message = msgg
			if(params?.appFormId != ''){
				appForm = ApplicationForm1.get(params?.appFormId)
			}
		}

		else{
			//create new profile
			println "FILE TYPE == "+idProofFile.getClass()
			if(params.appFormId != ''){
				appForm = ApplicationForm1.get(params.appFormId)
			}
			else if(session.getAttribute('appFormId') != null){
				appForm = ApplicationForm1.get(session.getAttribute('appFormId'))
			}
			appForm = applicationMgmtService.saveIndividualProfile(params,idProofFile,idProofFilename,passportFile,passportFilename,
					authorityLetter,authorityLetterFilename,category,appForm)
			session["appFormId"] = newAppForm?.id
			flash.message = "Saved successfully "
		}

		println "*********************** formType = "+formType
		redirect(action:"individualProfile",params:[csrfPreventionSalt:csrfPreventionSalt,formType:formType,appFormId:appForm?.id])
	}

	def saveAgentProfile = {
		//For agent profile
		//1.
		def category,agentProfile,appForm
		def csrfPreventionSalt = params.csrfPreventionSalt
		def formType = params.formType
		println "formType == "+formType
		if(params.formType  == 'Form1'){
			category = FormCategory.findByCategory(FormCategory.Category.Form_1)
		}
		else if(params.formType  == 'Form2'){
			category = FormCategory.findByCategory(FormCategory.Category.Form_2)
		}
		else if(params.formType  == 'Form3'){
			category = FormCategory.findByCategory(FormCategory.Category.Form_3)
		}
		else if(params.formType  == 'Form4'){
			category = FormCategory.findByCategory(FormCategory.Category.Form_4)
		}
		println "Inside saveAgentProfile "+params
		if(params?.appFormId != '' || params?.appFormId != null){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		else if(session.getAttribute("appFormId") != null){
			appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
		}

		if(params.name == 'No' && params.isCompanyProfile == 'true'){
			appForm.isAddressOfContactPerson = 'NoForCompany'
		}
		else if(params.name == 'No' && params.isIndividualProfile == 'true'){
			appForm.isAddressOfContactPerson = 'NoForIndividual'
		}
		else if(params.name == 'Yes'){
			appForm.isAddressOfContactPerson = null
		}


		//3.
		def agentAuthorityFile,agentAuthorityFileName,agentPassportFile,agentPassportFilename
		if(params.agentAuthorityFile != ''){
			agentAuthorityFile = request.getFile('AgentAuthorityLetter')
			agentAuthorityFileName = "AgentAuthorityLetter"
		}
		if(params.AgentPassportFile != ''){
			agentPassportFile = request.getFile('AgentPassportFile')
			agentPassportFilename = "AgentPassportFile"
			if (agentPassportFile != null && agentPassportFile?.getBytes()?.size() != 0) {
				def file = request.getFile('AgentPassportFile')
				int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
				def nullByteCheck = file.getOriginalFilename().contains('%00')
				if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
					println '====================='
					flash.message = "Wrong format of pdf"
					forward(action: "individualProfile", params: [msg1: 'Please upload file in pdf document format only!',
						appFormId:params.appFormId])
				}
				if (occurance > 1) {
					println '###################'
					flash.message = "Wrong format of pdf"
					if(params.isCompanyProfile == 'true'){
						forward(action: "companyProfile", params: [msg1: 'Please upload file and file must be .pdf document format only!',
							appFormId:params.appFormId])
					}
					else if(params.isIndividualProfile == 'true'){
						forward(action: "individualProfile", params: [msg1: 'Please upload file and file must be .pdf document format only!',
							appFormId:params.appFormId])
					}
				}

				try {
					PdfReader pdf = new PdfReader(file.getBytes())
					if(pdf && pdf.pdfVersion){}
					else{
						flash.message = "Wrong format of pdf"
						if(params.isCompanyProfile == 'true'){
							forward(action: "companyProfile", params: [msg1: 'Wrong format of pdf!',appFormId:params.appFormId])
						}
						else if(params.isIndividualProfile == 'true'){
							forward(action: "individualProfile", params: [msg1: 'Wrong format of pdf!',
								appFormId:params.appFormId])
						}
					}
				}catch (Exception e){
					println e.message
					flash.message = "Wrong format of pdf"
					if(params.isCompanyProfile == 'true'){
						forward(action: "companyProfile", params: [msg1: 'Wrong format of pdf!',appFormId:params.appFormId])
					}
					else if(params.isIndividualProfile == 'true'){
						forward(action: "individualProfile", params: [msg1: 'Wrong format of pdf!',
							appFormId:params.appFormId])
					}

				}
			}
		}
		if(params?.agentProfileId){
			println "inside edit option"
			def existingAgentProfile = AgentProfile.get(params.agentProfileId)
			if(session.getAttribute("projectId")){
				appForm = ApplicationForm1.get(session.getAttribute("projectId"))
			}
			println "inside edit option22222...."+appForm
			agentProfile = applicationMgmtService.updateAgentProfile(existingAgentProfile,params,agentAuthorityFile,agentAuthorityFileName,agentPassportFile,
					agentPassportFilename,category,appForm)
		}
		else{
			agentProfile = applicationMgmtService.saveAgentProfile(params,agentAuthorityFile,agentAuthorityFileName,agentPassportFile,
					agentPassportFilename,category,appForm)
		}

		println "cmpny or INDIVIDUAL == "+agentProfile
		if(agentProfile?.isCompanyAgent == true || appForm.isAddressOfContactPerson == 'NoForCompany'){
			redirect(action:"companyProfile",params:[csrfPreventionSalt:csrfPreventionSalt,formType:formType,appFormId:appForm?.id])
		}
		else{
			redirect(action:"individualProfile",params:[csrfPreventionSalt:csrfPreventionSalt, formType:formType,appFormId:appForm?.id])
		}

	}

	def editIndividualProfile = {
		println "Inside editIndividualProfile "+params
		def nationality,appForm,idProofSelect
		def csrfPreventionSalt = params.csrfPreventionSalt
		def individualProfile = IndividualProfile.get(params.profileId)
		def getNationality = individualProfile?.nationality
		println "inside edit individual profile......"+getNationality
		if(getNationality == "Indian")
//			idProofSelect = ['Driving License','Aadhar Card','Voter Id Card','Government Id']
			idProofSelect = ['Driving License','Voter Id Card','Government Id']
			
		else if(getNationality == "Non Indian")
			idProofSelect = ['Driving License','Government Id']
		else if(getNationality == "Non-Resident Indian")
//			idProofSelect = ['Driving License','Aadhar Card','Voter Id Card','Government Id']
			idProofSelect = ['Driving License','Voter Id Card','Government Id']

		def listOfCountries = Country.list()
		if(params.formType == 'Form1' || params.formType == 'Form4')
			nationality = ['-Select-', 'Non Indian', 'Non-Resident Indian']
		else
			nationality = ['-Select-', 'Indian', 'Non Indian', 'Non-Resident Indian']

		def profile = ['-Select-', 'Scientist', 'Student', 'Researcher', 'Others']
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}
		redirect(action: "individualProfile", id: individualProfile?.id, params: [csrfPreventionSalt:csrfPreventionSalt,formType: params?.formType,appFormId:appForm?.id,idProofSelect:idProofSelect])
	}



	def deleteProfile = {
		println "Inside deleteProfile "+params
		def csrfPreventionSalt = params.csrfPreventionSalt
		def individualProfile,listOfIndividualProfiles = [],appForm
		if(params?.appFormId != '' || params?.appFormId != null){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		else if(session.getAttribute("appFormId") != null){
			appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
		}

		if(params.profileId != ''){
			individualProfile = IndividualProfile.get(params.profileId)
			individualProfile.delete(flush:true)
			flash.message = "Deleted Successfully"

			listOfIndividualProfiles = IndividualProfile.findAllByApplicationForm1(appForm)
			println "listOfIndividualProfiles == "+listOfIndividualProfiles
			redirect(action: "individualProfile", id: individualProfile?.id, params: [csrfPreventionSalt:csrfPreventionSalt,formType: params?.formType,appFormId : appForm?.id, deleteCalled:'deleteCalled'])
			//render(template:"individualProfileGrid",model:[listOfIndividualProfiles:listOfIndividualProfiles])
		}
	}

	def companyProfile = {

		println "INSIDE companyProfile "+params
		def listOfCountries = Country.list()
		def listOfStates = State.list()
		def csrfPreventionSalt = params.csrfPreventionSalt

		//find form type
		def appForm
		def listOfCompanyProfiles = [],agentProfile
		def formType = params.formType
		println "formType == "+formType
		/*if(params.formType){
		 if(params.formType == 'Form1'){
		 appForm = ApplicationForm1.findBySubmittedByAndCategory(springSecurityService.currentUser,FormCategory.findByCategory(FormCategory.Category.Form_1))
		 }
		 else if(params.formType == 'Form2'){
		 appForm = ApplicationForm1.findBySubmittedByAndCategory(springSecurityService.currentUser,FormCategory.findByCategory(FormCategory.Category.Form_2))
		 }
		 else if(params.formType == 'Form3'){
		 appForm = ApplicationForm1.findBySubmittedByAndCategory(springSecurityService.currentUser,FormCategory.findByCategory(FormCategory.Category.Form_3))
		 }
		 else if(params.formType == 'Form4'){
		 appForm = ApplicationForm1.findBySubmittedByAndCategory(springSecurityService.currentUser,FormCategory.findByCategory(FormCategory.Category.Form_4))
		 }
		 }*/
		if(params?.appFormId != '' || params?.appFormId != null){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		session.setAttribute('appFormId',appForm?.id)
		println "appForm == "+appForm
		if(appForm != null){
			listOfCompanyProfiles = CompanyProfile.findAllByApplicationForm(appForm)
			println "listOfCompanyProfiles == "+listOfCompanyProfiles
			println "agentProfile == "+appForm?.agentProfile

			if(appForm?.agentProfile?.isCompanyAgent == true){
				agentProfile = appForm?.agentProfile
			}
			//agentProfile = AgentProfile.findByApplicationFormAndIsIndividualAgent(appForm,true)
		}

		def listOfNature = ['Research', 'Manufacturer', 'Business', 'Trader', 'Others']
		List entityTypes = ['Government Agency' , 'Institution', 'Company/Industry']
		def profile = ['-Select-', 'Attorney', 'Others']

		def authRepresentativeId = ['Passport Copy',  'Driving license']

		def agentPhotoIdSelect = ['Driving Licence', 'Passport', 'Government ID']

		def scheduleAformat = MstrDocument.findByDocName("Authorization Letter")

		def companyProfile1 = CompanyProfile.get(params.id)

		println "companyProfile1 == "+companyProfile1
		[csrfPreventionSalt:csrfPreventionSalt,appForm:appForm,scheduleAformat:scheduleAformat,listOfNature:listOfNature,listOfCountries:listOfCountries,listOfStates:listOfStates,listOfCompanyProfiles:listOfCompanyProfiles,agentPhotoIdSelect:agentPhotoIdSelect,
			entityTypes:entityTypes,agentProfile:agentProfile,formType:formType,companyProfile1:companyProfile1,profiles:profile,company:'company',deleteCompanyCalled:params?.deleteCompanyCalled,authRepresentativeId:authRepresentativeId]
	}

	def submitCompanyProfile = {
		println "inside Submit company profile----------------"
		println "PARAmS are == "+params
		def csrfPreventionSalt = params.csrfPreventionSalt
		//For company profile
		def registrationDocFile,registrationDocFilename,passportFile,passportFilename,authorityLetter,authorityLetterFilename
		if(params.IdProof != ''){
			registrationDocFile = request.getFile('RegistrationDoc')
			registrationDocFilename = "RegistrationDoc"



			if (registrationDocFile != null && registrationDocFile?.getBytes()?.size() != 0) {
				def file = request.getFile('RegistrationDoc')
				int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
				def nullByteCheck = file.getOriginalFilename().contains('%00')
				if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
					println '====================='
					flash.message = "Wrong format of pdf"
					forward(action: "companyProfile", params: [msg1: 'Please upload file in pdf document format only!',
						appFormId:params.appFormId])
				}
				if (occurance > 1) {
					println '###################'
					flash.message = "Wrong format of pdf"
					forward(action: "companyProfile", params: [msg1: 'Please upload file and file must be .pdf document format only!',
						appFormId:params.appFormId])
				}

				try {
					PdfReader pdf = new PdfReader(file.getBytes())
					if(pdf && pdf.pdfVersion){}
					else{
						flash.message = "Wrong format of pdf"
						forward(action: "companyProfile", params: [msg1: 'Wrong format of pdf!'])
						return
					}
				}catch (Exception e){
					println e.message
					flash.message = "Wrong format of pdf"
					forward(action: "companyProfile", params: [msg1: 'Wrong format of pdf!'])

				}
			}

		}
		if(params.Passport != ''){
			passportFile = request.getFile('Passport')
			passportFilename = "Passport"

			if (passportFile != null && passportFile?.getBytes()?.size() != 0) {
				def file = request.getFile('Passport')
				int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
				def nullByteCheck = file.getOriginalFilename().contains('%00')
				if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
					println '====================='
					flash.message = "Wrong format of pdf"
					forward(action: "companyProfile", params: [msg1: 'Please upload file in pdf document format only!',
						appFormId:params.appFormId])
				}
				if (occurance > 1) {
					println '###################'
					flash.message = "Wrong format of pdf"
					forward(action: "companyProfile", params: [msg1: 'Please upload file and file must be .pdf document format only!',
						appFormId:params.appFormId])
				}

				try {
					PdfReader pdf = new PdfReader(file.getBytes())
					if(pdf && pdf.pdfVersion){}
					else{
						flash.message = "Wrong format of pdf"
						forward(action: "companyProfile", params: [msg1: 'Wrong format of pdf!'])
						return
					}
				}catch (Exception e){
					println e.message
					flash.message = "Wrong format of pdf"
					forward(action: "companyProfile", params: [msg1: 'Wrong format of pdf!'])

				}
			}
		}
		if(params.IdProof != ''){
			authorityLetter = request.getFile('AuthorizationLetter')
			authorityLetterFilename = "AuthorizationLetter"

			if (authorityLetter != null && authorityLetter?.getBytes()?.size() != 0) {
				def file = request.getFile('AuthorizationLetter')
				int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
				def nullByteCheck = file.getOriginalFilename().contains('%00')
				if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
					println '====================='
					flash.message = "Wrong format of pdf"
					forward(action: "companyProfile", params: [msg1: 'Please upload file in pdf document format only!',
						appFormId:params.appFormId])
				}
				if (occurance > 1) {
					println '###################'
					flash.message = "Wrong format of pdf"
					forward(action: "companyProfile", params: [msg1: 'Please upload file and file must be .pdf document format only!',
						appFormId:params.appFormId])
				}

				try {
					PdfReader pdf = new PdfReader(file.getBytes())
					if(pdf && pdf.pdfVersion){}
					else{
						flash.message = "Wrong format of pdf"
						forward(action: "companyProfile", params: [msg1: 'Wrong format of pdf!'])
						return
					}
				}catch (Exception e){
					println e.message
					flash.message = "Wrong format of pdf"
					forward(action: "companyProfile", params: [csrfPreventionSalt:csrfPreventionSalt,msg1: 'Wrong format of pdf!'])

				}
			}
		}

		def category,appForm,existingAppForm
		def formType = params.formType
		if(params.formType  == 'Form1'){
			category = FormCategory.findByCategory(FormCategory.Category.Form_1)
		}
		else if(params.formType  == 'Form2'){
			category = FormCategory.findByCategory(FormCategory.Category.Form_2)
		}
		else if(params.formType  == 'Form3'){
			category = FormCategory.findByCategory(FormCategory.Category.Form_3)
		}
		else if(params.formType  == 'Form4'){
			category = FormCategory.findByCategory(FormCategory.Category.Form_4)
		}

		println "profileId1##################"+params.profileId1
		if(params.profileId){
			def existingProfile = CompanyProfile.get(params.profileId)
			println "profileID777777777777777   "+params.profileId
			applicationMgmtService.updateCompanyProfile(params,registrationDocFile,registrationDocFilename,passportFile,passportFilename,
					authorityLetter,authorityLetterFilename,category,existingProfile)
			if(params?.appFormId != ''){
				appForm = ApplicationForm1.get(params?.appFormId)
			}
		}

		else{
			//create new profile
			println "FILE TYPE == "+registrationDocFile.getClass()
			if(params?.appFormId != '' || params?.appFormId != null){
				appForm = ApplicationForm1.get(params?.appFormId)
			}
			else if(session.getAttribute("appFormId") != null){
				appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
			}
			appForm = applicationMgmtService.saveCompanyProfile(params,registrationDocFile,registrationDocFilename,passportFile,passportFilename,
					authorityLetter,authorityLetterFilename,category,appForm)

			session["appFormId"] = appForm?.id
		}

		redirect(action:"companyProfile",params:[csrfPreventionSalt:csrfPreventionSalt,formType:formType,appFormId:appForm?.id])
	}

	def editCompanyProfile = {
		println "Inside editCompanyProfile "+params
		def nationality,appForm
		def csrfPreventionSalt = params.csrfPreventionSalt
		def companyProfile = CompanyProfile.get(params.profileId)
		def listOfCountries = Country.list()
		if(params.formType == 'Form1' || params.formType == 'Form4')
			nationality = ['-Select-', 'Non Indian', 'Non-Resident Indian']
		else
			nationality = ['-Select-', 'Indian', 'Non Indian', 'Non-Resident Indian']

		def listOfNature = ['Research', 'Manufacturer', 'Business', 'Trader', 'Others']
		List entityTypes = ['Government Agency' , 'Institution ', 'Company/Industry']
		def scheduleAformat = MstrDocument.findByDocName("Authorization Letter")
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}
		redirect(action: "companyProfile", id: companyProfile?.id, params:[csrfPreventionSalt:csrfPreventionSalt,formType: params?.formType,appFormId:appForm?.id])
	}

	def deleteCompanyProfile = {
		println "Inside deleteCompanyProfile "+params
		def companyProfile,listOfCompanyProfiles = [],appForm
		def csrfPreventionSalt = params.csrfPreventionSalt
		if(params?.appFormId != '' || params?.appFormId != null){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		else if(session.getAttribute("appFormId") != null){
			appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
		}
		if(params.profileId != ''){
			companyProfile = CompanyProfile.get(params.profileId)
			companyProfile.delete(flush:true)
			flash.message = "Deleted Successfully"

			listOfCompanyProfiles = CompanyProfile.findAllByApplicationForm(appForm)
			println "listOfCompanyProfiles == "+listOfCompanyProfiles
			redirect(action: "companyProfile", id: companyProfile?.id, params: [csrfPreventionSalt:csrfPreventionSalt,formType: params?.formType,appFormId:appForm?.id,deleteCompanyCalled:"deleteCompanyCalled"])
		}
	}


	def showDc(long id)
	{
		println"```````````````````````````````show declaration````````````````````````````````````````````"+params

		ByteArrayOutputStream ous = null;
		InputStream ios = null;
		def companyProfile= CompanyProfile.findById(id)
		def file,filename
		def csrfPreventionSalt = params.csrfPreventionSalt
		if(params.filename == 'registrationDocName'){
			file = companyProfile.registrationDoc
			filename = companyProfile.registrationDocName

		}
		else if(params.filename == 'passportCopy'){
			file = companyProfile.passportCopy
			filename = companyProfile.passportCopyFileName
		}
		else if(params.filename == 'authorizationLetterFileName'){
			file = companyProfile.authorizationLetter
			filename = companyProfile.authorizationLetterFileName
		}


		//println "FILE == "+file
		byte[] DocContent = null;
		DocContent = file
		response.setHeader "Content-disposition", "inline; filename=filename"
		response.contentType = 'application/pdf'
		response.outputStream << DocContent
		response.outputStream.flush()
	}

	def showIndividualDc(long id)
	{
		println"```````````````````````````````show diclration````````````````````````````````````````````"+params

		ByteArrayOutputStream ous = null;
		InputStream ios = null;
		def individualProfile= IndividualProfile.findById(params?.id)
		def transactionId = Transaction?.findById(params?.id)
		def file,filename,appForm
		def csrfPreventionSalt = params.csrfPreventionSalt
		appForm = ApplicationForm1.findById(params?.appFormId)

		if(params.filename == 'idProof'){
			filename = individualProfile.idProofFileName

			if(individualProfile?.idProof){
				file = individualProfile.idProof
//				showOldIndividual(file,filename)

			}else if(individualProfile?.idProofURL){
				file = new File(individualProfile.idProofURL)?.getBytes()
//				showLatestIndividual(file,filename)
			}
		}


		if(params.filename == 'passportCopy'){
			filename = individualProfile.passportCopyFileName
			if(individualProfile.passportCopy){
				file = individualProfile.passportCopy
//				showOldIndividual(file,filename)

			}else if(individualProfile.passportURL){
				file = new File(individualProfile.passportURL)?.getBytes()
//				showLatestIndividual(file,filename)

			}
		}


		if(params.filename == 'authorizationLetter'){
			filename = individualProfile.authorizationLetterFileName
			if(individualProfile.authorizationLetter){file = individualProfile.authorizationLetter
//				showOldIndividual(file,filename)
			
				}else if(individualProfile.authorizationLetterURL){
				file = new File(individualProfile.authorizationLetterURL)?.getBytes()
//				showLatestIndividual(file,filename)
			}
		}

		if(params.filename == 'paymentReceipt'){
			filename = transactionId?.paymentReceiptName

			if(transactionId?.paymentReceipt){
				file = transactionId?.paymentReceipt
//				showOldIndividual(file,filename)

			}else if(transactionId?.paymentReceiptURL){
				file = new File(transactionId?.paymentReceiptURL)?.getBytes()
//				showLatestIndividual(file,filename)
				
//				println"file-path"+file
				
				}
		}
		
		byte[] DocContent = null;
		DocContent = file
		response.setHeader "Content-disposition", "inline; filename=filename"
		response.contentType = 'application/pdf'
		response.outputStream << DocContent
		response.outputStream.flush();
		response.outputSrream.close();
	}
	
	
 
	def showAgentDc(long id)
	{
		println"```````````````````````````````show diclration````````````````````````````````````````````"+params

		ByteArrayOutputStream ous = null;
		InputStream ios = null;
		def agentProfile= AgentProfile.findById(id)
		def file,filename
		def csrfPreventionSalt = params?.csrfPreventionSalt
		if(params.filename == 'passportCopyFileName'){
			file = agentProfile.passportCopy
			filename = agentProfile.passportCopyFileName
		}
		else if(params.filename == 'authorizationLetter'){
			file = agentProfile.authorizationLetter
			filename = agentProfile.authorizationLetterFileName
		}

		//println "FILE == "+file
		byte[] DocContent = null;
		DocContent = file
		response.setHeader "Content-disposition", "inline; filename=filename"
		response.contentType = 'application/pdf'
		response.outputStream << DocContent
		response.outputStream.flush()
	}

	def showAppDc(long id)
	{
		println"```````````````````````````````show diclration````````````````````````````````````````````"+params

		ByteArrayOutputStream ous = null;
		InputStream ios = null;
		def csrfPreventionSalt = params?.csrfPreventionSalt
		def appForm= ApplicationForm1.findById(id)
		def file,filename
		if(params.filename == 'letterOfIntentName'){
			filename = appForm.letterOfIntentName
			
			if(appForm.letterOfintent){
				
				file = appForm?.letterOfintent
				
				byte[] DocContent = null;
				DocContent = file
				response.setHeader "Content-disposition", "inline; filename=filename"
				response.contentType = 'application/pdf'
				response.outputStream << DocContent
				response.outputStream.flush()
				response.getOutputStream().close();
		
				
			}else if(appForm.letterOfIntentURL){
			
			
			
			file = new File(appForm.letterOfIntentURL)
			response.setContentType("application/pdf")
			response.setHeader("Content-disposition","filename= appForm.letterOfIntentName")
			response.outputStream << file.newInputStream()
			response.getOutputStream().close();
			
			
			}
		}
		else if(params.filename == 'sharingDocName'){
			if(appForm.sharingDoc){
			file = appForm.sharingDoc
			filename = appForm.sharingDocName
			byte[] DocContent = null;
			DocContent = file
			response.setHeader "Content-disposition", "inline; filename=filename"
			response.contentType = 'application/pdf'
			response.outputStream << DocContent
			response.outputStream.flush()
			response.getOutputStream().close();
	
		}else if(appForm.sharingDocURL){
			
			
			
			file = new File(appForm.sharingDocURL)
			response.setContentType("application/pdf")
			response.setHeader("Content-disposition","filename= appForm.letterOfIntentName")
			response.outputStream << file.newInputStream()
			response.getOutputStream().close();
			
			
			}
		}
	}

	def form1Part2 = {
		//listOfLocations = GeoLocationOfCommunity.findAllByAppForm(appForm)

		println "Inside part 2------------------------"+params
		def formType = params.formType
		println "formType == "+formType

		println "CURRENT uSEr "+springSecurityService.currentUser
		println "SESSION ++ "+session.getAttribute('appFormId')
		def appForm
		if(params?.appFormId != '' || params?.appFormId != null){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		else if(session.getAttribute("appFormId") != null){
			appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
		}
		println "appForm == "+appForm
		def newList  = []
		def listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)
		println "listOfBioResources == "+listOfBioResources

		listOfBioResources?.each{
			println "it?.scientificName == "+it?.scientificName.equals(null)
			if(it?.scientificName?.equals(null) == false){
				println "contrins null"
				newList.add(it)
			}
		}
		println "newList deleted "+newList
		def resources = ['Stem', 'Seed', 'Fruit', 'Root', 'Leaf', 'DNA', 'Others']
		def accessSources = ['Wild', 'Cultivated', 'Market', 'Trader', 'Repositories', 'Institution', 'Others']
		def quantityList  = ['unit(s)', 'ml', 'kg', 'vials', 'slants','tonne']
		def natureOfReources = ['Plant', 'Animal', 'Micro-organism']

		//fetch geo location rows
		def listOfLocations = []
		for(bioResorce in listOfBioResources){
			def bioResourceLocations = GeoLocationOfBioResource.findAllByBioResource(bioResorce)
			for(loc in bioResourceLocations){
				//if(loc.state != null && loc.district != null && loc.town != null && loc.traderName != null && loc.traderContactDetails != null){
				listOfLocations.add(loc)
				//	}
			}
		}
		println "listOfLocations == "+listOfLocations

		/*if(params.locationId){
		 def geoLocation = GeoLocationOfBioResource.get(params.locationId)
		 println "geoLocation45645 == "+geoLocation
		 render(template:"geographicalLocationForm",model:[listOfBioResources:listOfBioResources,geoLocation:geoLocation,accessSources:accessSources])
		 }
		 else{*/
		[newList:newList,listOfStates:State.list(),quantityList:quantityList,appForm:appForm,natureOfReources:natureOfReources,listOfLocations:listOfLocations,
			listOfBioResources:listOfBioResources,resources:resources,accessSources:accessSources,formType:formType]

		//}
	}

	def editGeoLocation = {
		println "Inside editGeoLocation "+params
		def formType = params.formType
		println "formType == "+formType
		def appForm
		def csrfPreventionSalt = params.csrfPreventionSalt
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}
		//1.
		def newList  = []
		def listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)
		println "listOfBioResources == "+listOfBioResources

		listOfBioResources?.each{
			println "it?.scientificName == "+it?.scientificName.equals(null)
			if(it?.scientificName?.equals(null) == false){
				println "contrins null"
				newList.add(it)
			}
		}

		//2.
		def accessSources = ['Wild', 'Cultivated', 'Market', 'Trader', 'Repositories', 'Institution', 'Others']

		//3.
		if(params.locationId != ''){
			def geoLocation = GeoLocationOfBioResource.get(params.locationId)
			println "geoLocation45645 == "+geoLocation
			render(template:"geographicalLocationForm",model:[csrfPreventionSalt:csrfPreventionSalt,newList:newList,listOfStates:State.list(),formType:formType,listOfBioResources:listOfBioResources,
				geoLocation:geoLocation,bioresource:geoLocation?.bioResource,accessSources:accessSources,appForm:appForm])
		}

	}


	def saveBiologicalResources = {
		println "PARAMS IN  saveBiologicalResources ARE "+params

		try{
			//def bioResource
			def formType = params.formType
			println "formType == "+formType
			def appForm = ApplicationForm1.get(params.appFormId)
			def qty = 0,fromTime,toTime,bioResources,bioResource, associatedBioResource, intendToAccess

			//			def splittedFromDate = params.fromTime.split('/')
			//			println "splittedDate is== "+splittedFromDate
			//
			//			def splittedToDate = (params.toTime).split('/')
			//			println "splittedToDate is ==== "+splittedToDate

			if(params.fromTime != null && params.fromTime != ''){
				SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy")
				fromTime = parser.parse(params.fromTime)
			}
			if(params.toTime != null && params.toTime != '' ){
				SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy")
				toTime = parser.parse(params.toTime)
			}

			if(params.commonName && params.scientificName && params.nature  && params.bioResource){
				println "Hieeeeeeeeeeee 1"
				if(params.quantity && params.quantity != '' || params.quantity != null){
					qty = Integer.parseInt( params.quantity)
				}

				if(params.bioResource == 'Others'){
					bioResources = 'Others- '+(params.pleaseSpecify)
				}else{
					bioResources = params.bioResource
				}

				if(params.accessIntention == 'Both'){
					intendToAccess = 'Biological Resources & Traditional Knowledge'
				}
				else{
					intendToAccess = params.accessIntention
				}

				println "Hieeeeeeeeeeee 2"
				if(params.accessIntention == 'Biological Resources' || params.accessIntention == 'Both'){
					println "Inside FIRST---------@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-----------"
					bioResource = new BiologicalResource(commonName:params.commonName,
					scientificName: params.scientificName,nature: params.nature ,accessIntention:intendToAccess,
					quantity:qty,source: params.source,qtyUnit:params.qtyUnit,fromTime:fromTime,
					toTime:toTime,applicationForm:appForm,traditionalUse:params.traditionalUse,
					bioResouceTraditionalKnowledge : params.bioResouceTraditionalKnowledge,biologicalResource:bioResources)

				}

				if(params.accessIntention == 'Both' && params.traditionalUse != null ){
					println "Inside SECOND---------@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-----------"
					bioResource.traditionalUse = params.traditionalUse
					bioResource.accessIntention = intendToAccess
					bioResource.bioResouceTraditionalKnowledge = params.bioResouceTraditionalKnowledge
					//					if(!bioResource.save(flush:true)){
					//						bioResource.errors.each{println it}
					//					}
				}



				println "reached here "


			}

			//			if(params.accessIntention == 'Associated Knowledge' && params.accessIntention != '' && params.accessIntention != null){
			if(params.accessIntention == 'Associated Knowledge' ){
				println "Inside THIRD---------@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-----------"
				bioResource = new BiologicalResource(applicationForm:appForm)
				if(params.formType == 'Form3' || params.formType == 'Form4' || params.formType == 'Form1' || params.formType == 'Form2'){
					println "ahkjfalf@@@@@@@@@@@@@@@@@@@@@@@@"
					bioResource.nature = params.nature
					bioResource.accessIntention = params.accessIntention
					bioResource.commonName = params.commonName
					bioResource.scientificName = params.scientificName
					bioResource.biologicalResource = bioResources
					if(params.formType == 'Form4' || params.formType == 'Form1'){
						bioResource.quantity = qty
						bioResource.qtyUnit = params.qtyUnit
					}


				}
				bioResource.fromTime = fromTime
				bioResource.toTime = toTime
				bioResource.traditionalUse = params.traditionalUse
				bioResource.accessIntention = params.accessIntention
				bioResource.bioResouceTraditionalKnowledge = params.bioResouceTraditionalKnowledge

			}

			//			}

			appForm.addToBiologicalResources(bioResource)

			if(!bioResource.save(flush:true)){
				bioResource.errors.each{ println it }
			}else {
				//				flash.message = "Saved successfully!"
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
			render(template:"/applicationManagement/biologicalResourcesGrid",model:[appForm:appForm,
				listOfBioResources:listOfBioResources,formType:formType])

		}
		catch(Exception e){
			println "The exception is: "+e
		}

	}

	def editForm1Part2 = {
		println "heeeeeeeeeellllocooocooco 1 "+params
		def csrfPreventionSalt = params.csrfPreventionSalt
		def bioResourceInst = BiologicalResource.get(params?.bioResource)
		println "bioResourceInst == "+bioResourceInst
		def resources = ['Stem', 'Seed', 'Fruit', 'Root', 'Leaf', 'DNA', 'Others']
		def quantityList  = ['unit(s)', 'ml', 'kg', 'vials', 'slants','tonne']
		def natureOfReources = ['Plant', 'Animal', 'Micro-organism']
		println "heeeeeeeeeellllocooocooco2"+bioResourceInst
		render(template:"editForm1Part2", model: [csrfPreventionSalt:csrfPreventionSalt,bioResourceInst:bioResourceInst,
	 natureOfReources:natureOfReources,resources:resources,quantityList:quantityList,formType:params.formType,appFormID:params.appFormID])

	}

	def saveEditForm1Part2(){
		println "SAVE EDIT FORM1 PART2"
		println "inside saveEditForm1Part2 action &&&&&&&& bioResourceInstID-----"+params.formType
		println "params.bioResourceInstID--22--2--2--2-"+params.bioResourceInstID
		def appForm = ApplicationForm1.get(params.appFormID)
		Date fromDate,toDate;
		int quantity = 0;
		def bioResources,intendToAccess
		//		if(params.commonName && params.scientificName && params.nature  && params.bioResource){


		println "date in string format---"+params.fromTime
		if(params.fromTime != null && params.fromTime !='' ){
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy")
			fromDate = format.parse(params.fromTime)
			println "date after parsing---"+fromDate
		}


		if(params.toTime != null && params.toTime != ''){
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy")
			toDate = format.parse(params.toTime)
		}
		if(params.quantity != null & params.quantity != ''){
			quantity = Integer.parseInt(params.quantity)
		}
		if(params.bioResource == 'Others'){
			bioResources = 'Others- '+(params.pleaseSpecify)
		}else{
			bioResources = params.bioResource
		}

		if(params.accessIntention == 'Both'){
			intendToAccess = 'Biological Resources & Traditional Knowledge'
		}
		else{
			intendToAccess = params.accessIntention
		}

		def bioResourceObj = BiologicalResource.get(params.bioResourceInstID)
		bioResourceObj.accessIntention = intendToAccess

		if(params.commonName != null || params.scientificName != null || params.nature != null || bioResources != null || quantity != null)
		{
			bioResourceObj.commonName = params.commonName
			bioResourceObj.scientificName= params.scientificName
			bioResourceObj.nature= params.nature
			bioResourceObj.biologicalResource= bioResources
			bioResourceObj.quantity= quantity
		}
		bioResourceObj.source= params.source
		bioResourceObj.qtyUnit= params.qtyUnit
		bioResourceObj.fromTime= fromDate
		bioResourceObj.toTime= toDate

		if(params.traditionalUse != null)
			bioResourceObj.traditionalUse= params.traditionalUse


		appForm.addToBiologicalResources(bioResourceObj)

		println "just BEFORE save............................................"
		if(!bioResourceObj.save(flush:true)){
			bioResourceObj.error.each{ println it }
		}

		if(!appForm.save(flush:true)){
			appForm.errors.each{println it}
		}

		println "----params.appFormId--- in println--"+params.appFormID



		//		}
		def listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)
		println "listOfBioResources == "+listOfBioResources


		render(template:"biologicalResourcesGrid",model:[appForm:appForm,
			listOfBioResources:listOfBioResources,formType:params.formType])

	}
	

	def saveEditForm1Part3 = {
		def emailContactPerson
		def csrfPreventionSalt = params.csrfPreventionSalt
		def contactPersonObj = ContactPerson.get(params?.contactPersonInstId)

		if(params.emailOfContactPerson != null){
			emailContactPerson = (params.emailOfContactPerson)?.toLowerCase()
		}

		contactPersonObj?.nameOfContactPerson= params?.nameOfContactPerson
		contactPersonObj?.addressOfContactPerson= params?.addressOfContactPerson
		contactPersonObj?.emailOfContactPerson= emailContactPerson
		contactPersonObj?.mobileOfContactPerson= params?.mobileOfContactPerson
		contactPersonObj?.contactPerson = params?.contactPerson

		if(!contactPersonObj.save(flush:true)){
			contactPersonObj.errors.each{println it}
		}
		println "kjfkldjasf................."+params
		def appForm
		if(params?.appId != '' || params?.appId != null){
			appForm = ApplicationForm1.get(params?.appId)
		}
		else if(session.getAttribute("appFormId") != null){
			appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
		}
		println "appForm == "+appForm
		def listOfContactPerson = ContactPerson.findAllByApplicationForm(appForm)
		render(template:"authorizedPersonGrid",model:[csrfPreventionSalt:csrfPreventionSalt,appForm:appForm,listOfContactPerson:listOfContactPerson])
	}

	def deleteBioProfile = {

		println "params >>>>>>> "+params
		def bioResourcesInst,listOfBiologicalResources = [],appForm,csrfPreventionSalt
		def formType = params.formType
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}
		if(params.bioResourceID != ''){
			bioResourcesInst = BiologicalResource.get(params.bioResourceID);
			bioResourcesInst.delete(flush:true)

			listOfBiologicalResources = BiologicalResource.findAllByApplicationForm(appForm)
			println "listOfBiologicalResources == "+listOfBiologicalResources
			render(template:"biologicalResourcesGrid",model:[csrfPreventionSalt:csrfPreventionSalt,appForm:appForm,formType:formType,listOfBioResources:listOfBiologicalResources])
		}
	}

	def geoLocation = {
		println "PARAMS IN geoLocationare are == "+geoLocation

		def appForm
		if(params?.appFormId != '' || params?.appFormId != null){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		else if(session.getAttribute("appFormId") != null){
			appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
		}
		println "appForm == "+appForm
		def listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)
		println "listOfBioResources == "+listOfBioResources

		//fetch all rows
		def listOfLocations = []
		for(bioResorce in listOfBioResources){
			def bioResourceLocations = GeoLocationOfBioResource.findAllByBioResource(bioResorce)
			println "bioResourceLocations == "+bioResourceLocations

			for(loc in bioResourceLocations){
				//if(loc.state != null && loc.district != null && loc.town != null ){
				listOfLocations.add(loc)
				//}
			}
		}
		println "listOfLocations == "+listOfLocations
		[appForm:appForm,listOfLocations:listOfLocations,listOfStates:State.list()]
	}

	/*
	 * if(params.geoLocationId && bioResource){
	 def geoLocation = GeoLocationOfBioResource.get(params.geoLocationId)
	 println "If bio resource instance exists !!!"
	 geoLocation.bioResource=bioResource;
	 if(params.source == "Wild" || params.source?.trim() == "Cultivated" || params.source == "Others"){
	 if(params.village != '' && params.town != '' && params.district != '' && params.state != ''){
	 geoLocation.village= params.village;
	 geoLocation.town= params.town;
	 bioResource.source= params.source;
	 geoLocation.district= params.district;
	 geoLocation.state = params.state;
	 if(!geoLocation.save(flush:true)){
	 geoLocation.errors.each{ println it }
	 }
	 }
	 }
	 if(params.source == "Market" || params.source == "Trader" || params.source == "Repositories" || params.source == "Institution" || params.source == "Others"){
	 if(params.trader != '' && params.traderContactDetails != ''){
	 geoLocation.traderName = params.trader;
	 bioResource.source= params.source;
	 geoLocation.traderContactDetails = params.traderContactDetails;
	 if(!geoLocation.save(flush:true)){
	 geoLocation.errors.each{ println it }
	 }
	 }
	 }
	 bioResource.addToLocations(geoLocation)
	 if(!bioResource.save(flush:true)){
	 bioResource.errors.each{ println it }
	 }
	 }
	 *
	 *
	 *
	 */



	def saveGeoLocation = {
		if(params.geoLocationId){
			println "Inside EEDDIITT geo location"
			println "PARAMS IN SAVE GEO LOCATION ARE "+params
			def appForm = ApplicationForm1.get(params?.appFormId)
			def bioResource = BiologicalResource.get(params?.name)
			println "If bio resource instance exists1 !!!"
			if(bioResource != null){
				println "If bio resource instance exists !!!"

				def geoLocation =  GeoLocationOfBioResource.get(params.geoLocationId)
				geoLocation.bioResource=bioResource;

				if(params.source == "Wild" || params.source?.trim() == "Cultivated"){
					if(params.village != '' && params.town != '' && params.district != '' && params.state != ''){

						geoLocation.village= params.village;
						geoLocation.town= params.town;
						geoLocation.source= params.source;
						geoLocation.district= params.district;
						if(params.state != ''){
							geoLocation.state = State.get(params.state)?.state;
						}
						geoLocation.traderName = null
						geoLocation.traderContactDetails = null

						if(!geoLocation.save(flush:true)){
							geoLocation.errors.each{ println it }
						}
					}
				}
				else if(params.source == "Market" || params.source == "Trader" || params.source == "Repositories" || params.source == "Institution"){

					if(params.trader != '' && params.traderContactDetails != ''){
						geoLocation.traderName = params.trader;
						geoLocation.source= params.source;
						geoLocation.traderContactDetails = params.traderContactDetails;

						geoLocation.village= null
						geoLocation.town= null
						geoLocation.district= null
						geoLocation.state =null
						if(!geoLocation.save(flush:true)){
							geoLocation.errors.each{ println it }
						}
					}
				}

				else if(params.source == "Others"){
					if(params.village != '' && params.town != '' && params.district != ''
					&& params.state != '' && params.trader != '' && params.traderContactDetails != ''){
						geoLocation.village= params.village;
						geoLocation.town= params.town;
						geoLocation.district= params.district;
						geoLocation.source= params.source;
						if(params.state != ''){
							geoLocation.state = State.get(params.state)?.state;
						}
						geoLocation.traderName = params.trader
						geoLocation.traderContactDetails = params.traderContactDetails

						if(!geoLocation.save(flush:true)){
							geoLocation.errors.each{ println it }
						}

					}
				}
				bioResource.addToLocations(geoLocation)
			}
			if(!bioResource.save(flush:true)){
				bioResource.errors.each{ println it }
			}
			println "SAvED BIO RESOURCE in EDIITTTTT "+bioResource

			def listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)

			println "listOfBioResources"+listOfBioResources
			def listOfLocations = []
			for(bioResorce in listOfBioResources){
				def bioResourceLocations = GeoLocationOfBioResource.findAllByBioResource(bioResorce)
				println "bioResourceLocations == "+bioResourceLocations
				for(loc in bioResourceLocations){
					listOfLocations.add(loc)
				}
			}
			println "listOfLocations == "+listOfLocations
			render(template:"geographicalLocationGrid",model:[appForm:appForm,listOfLocations:listOfLocations])

		}
		else{

			println "Inside save geo location"
			println "PARAMS IN SAVE GEO LOCATION ARE "+params
			def appForm = ApplicationForm1.get(params?.appFormId)
			def bioResource = BiologicalResource.get(params?.name)

			if(bioResource != null){
				println "If bio resource instance exists !!!"

				GeoLocationOfBioResource geoLocation = new GeoLocationOfBioResource()
				geoLocation.bioResource=bioResource;

				if(params.source == "Wild" || params.source?.trim() == "Cultivated" || params.source == "Others"){
					if(params.village != '' && params.town != '' && params.district != '' && params.state != ''){

						geoLocation.village= params.village;
						geoLocation.town= params.town;
						geoLocation.source= params.source;
						geoLocation.district= params.district;
						if(params.state != ''){
							geoLocation.state = State.get(params.state)?.state;
						}

						if(!geoLocation.save(flush:true)){
							geoLocation.errors.each{ println it }
						}
					}
				}
				if(params.source == "Market" || params.source == "Trader" || params.source == "Repositories" || params.source == "Institution" || params.source == "Others"){

					if(params.trader != '' && params.traderContactDetails != ''){
						geoLocation.traderName = params.trader;
						geoLocation.source= params.source;
						geoLocation.traderContactDetails = params.traderContactDetails;
						if(!geoLocation.save(flush:true)){
							geoLocation.errors.each{ println it }
						}
					}
				}
				bioResource.addToLocations(geoLocation)
			}
			if(!bioResource.save(flush:true)){
				bioResource.errors.each{ println it }
			}
			println "SAvED geoLocation IS "+geoLocation

			def listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)

			println "listOfBioResources"+listOfBioResources
			def listOfLocations = []
			for(bioResorce in listOfBioResources){
				def bioResourceLocations = GeoLocationOfBioResource.findAllByBioResource(bioResorce)
				println "bioResourceLocations == "+bioResourceLocations
				for(loc in bioResourceLocations){
					listOfLocations.add(loc)
				}
			}
			println "listOfLocations == "+listOfLocations
			render(template:"geographicalLocationGrid",model:[appForm:appForm,listOfLocations:listOfLocations])
		}
	}

	def deleteGeoLocation = {
		println "Inside deleteGeoLocation "+params
		def geoLocation,appForm,formType,csrfPreventionSalt
		if(params?.formType != ''){
			formType = params.formType
		}
		if(params?.appFormId != ''){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		if(params.locationId != ''){
			geoLocation = GeoLocationOfBioResource.get(params.locationId)
			geoLocation.delete(flush:true)

			def listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)

			println "listOfBioResources"+listOfBioResources
			def listOfLocations = []
			for(bioResorce in listOfBioResources){
				def bioResourceLocations = GeoLocationOfBioResource.findAllByBioResource(bioResorce)
				println "bioResourceLocations == "+bioResourceLocations
				for(loc in bioResourceLocations){
					listOfLocations.add(loc)
				}
			}
			println "listOfLocations == "+listOfLocations
			render(template:"geographicalLocationGrid",model:[csrfPreventionSalt:csrfPreventionSalt,appForm:appForm,listOfLocations:listOfLocations])
		}
	}


	def saveDetailedTraditionalKnowledge = {
		println "Inside saveDetailedTraditionalKnowledge "+params

		def formType = params.formType
		println "formType == "+formType

		def appForm,csrfPreventionSalt
		csrfPreventionSalt = params.csrfPreventionSalt
		if(params?.appFormId != '' || params?.appFormId != null){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		else if(session.getAttribute("appFormId") != null){
			appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
		}
		println "appForm == "+appForm


		appForm.nature = params.tradditional

		if(params.tradditional == 'Oral' || params.tradditional == 'Document'){
			appForm?.traditionalKnowledgeDesc = params.traditionalKnowledgeDesc
			appForm?.isNoForTraditional = null
		}
		else if(params.tradditional == 'No'){
			appForm.traditionalKnowledgeDesc = null
		}

		if(!appForm.save(flush:true)){
			appForm.errors.each{ println it }
		}
		println "saved successfully"
		if(params?.formType == 'Form2'){
			redirect(controller:"form2",action:"part3",params:[csrfPreventionSalt:csrfPreventionSalt,formType:formType,appFormId:appForm?.id])
		}
		else if(params?.formType == 'Form1'){
			redirect(action:"form1Part3",params:[csrfPreventionSalt:csrfPreventionSalt,formType:formType,appFormId:appForm?.id])
		}
	}

	def form1Part3 = {
		println "Inside part 3 "+params
		def csrfPreventionSalt = params.csrfPreventionSalt

		if(params.locationId && params.locationId != ''){
			def appForm

			if(params.appFormId != ''){
				appForm = ApplicationForm1.get(params.appFormId)
			}
			def geoLocation = GeoLocationOfCommunity.get(params.locationId)
			render(template:"geoLocationOfCommunityForm",model:[csrfPreventionSalt:csrfPreventionSalt,appForm:appForm,listOfStates:State.list(),geoLocation:geoLocation])
		}
		else{
			def formType = params.formType
			println "formType == "+formType
			println "SESSION CONTENT"+session.getAttribute('appFormId')
			println "CURRENT uSEr "+springSecurityService.currentUser
			def appForm

			if(params.appFormId != ''){
				appForm = ApplicationForm1.get(params.appFormId)
			}
			else if(session.getAttribute('appFormId') != null){
				appForm = ApplicationForm1.get(session.getAttribute('appFormId'))
			}
			println "appForm == "+appForm
			def contactPersons = ContactPerson.findAllByApplicationForm(appForm)
			def listOfCommunityLocations = GeoLocationOfCommunity.findAllByAppForm(appForm)
			println "listOfCommunityLocations == "+listOfCommunityLocations

			//
			List purposeList = ['Research', 'Bio-survey and bio-utilization', 'Commercial utilization']
			def listOfContactPerson = ContactPerson.findAllByApplicationForm(appForm)
			println "*************"+listOfContactPerson

			println "purposeList == "+purposeList
			println "Risk involved "+appForm?.riskInvolved
			[formType:formType,listOfStates:State.list(),appForm:appForm,listOfCommunityLocations:listOfCommunityLocations,purposeList:purposeList,listOfContactPerson:listOfContactPerson,contactPersons:contactPersons,csrfPreventionSalt:csrfPreventionSalt]
		}

	}

	def saveGeoLocationOfCommunity = {
		println "PARAMS IN SAVE GEO LOCATION ARE "+params
		/*if(params.isConsentObtained == ''){
		 flash.message = 'Please select atleat one radio button'
		 }*/

		//1.
		def communityKnowledge, appForm
		if(params.communityKnowledge){
			communityKnowledge = params.communityKnowledge
		}
		else if(params.individualKnowledge){

			communityKnowledge = params.individualKnowledge
		}
		println "INSI 11111"
		//2.
		if(params.appFormId != '')
			appForm = ApplicationForm1.get(params.appFormId)

		println "INSI 2222"

		if(params.geoLocationId && params.geoLocationId != ''){
			println "INSIDE IF CONDITION"
			if(params.village != '' && params.town != '' && params.district != '' && params.state != ''){
				def communityGeoLocationObj = GeoLocationOfCommunity.get(params.geoLocationId)
				println "INSI 3333"
				communityGeoLocationObj.communityKnowledge = communityKnowledge
				communityGeoLocationObj.village = params.village
				communityGeoLocationObj.town = params.town
				communityGeoLocationObj.district = params.district
				communityGeoLocationObj.state = params.state
				communityGeoLocationObj.consentObtained = params.isConsentObtained

				if(!communityGeoLocationObj.save(flush:true)){
					communityGeoLocationObj.errors.each{println it}
				}
			}
			//appForm.consentObtained = params.isConsentObtained

			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}




			//Fetch all rows
			def listOfCommunityLocations = GeoLocationOfCommunity.findAllByAppForm(appForm)
			println "listOfCommunityLocations == "+listOfCommunityLocations
			render(template:"geoLocationOfCommunity",model:[appForm:appForm,listOfCommunityLocations:listOfCommunityLocations])
		}
		else if(params?.isNoForTraditional == 'No'){

			if(params?.isNoForTraditional != null && params?.isNoForTraditional == 'No'){
				appForm?.nature = params?.isNoForTraditional
				appForm?.isNoForTraditional= params?.isNoForTraditional
				appForm?.traditionalKnowledgeDesc = null

			}
			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}
			println "#######@@@@@@@@@@@@@@@@@@@@@@@@@@@"+appForm?.traditionalKnowledgeDesc
		}

		else{
			println "INSIDE ELSE"
			def communityGeoLocation
			if(params.village != '' && params.town != '' && params.district != '' && params.state != ''){
				communityGeoLocation = new GeoLocationOfCommunity(communityKnowledge:communityKnowledge,village: params.village,town: params.town ,
				district: params.district,state:params.state,appForm:appForm)
			}

			if(params.isConsentObtained == 'Community' || params.isConsentObtained == 'Individual' ){
				communityGeoLocation.consentObtained = params.isConsentObtained;
				appForm.isNoForTraditional = null
			}

			//appForm.consentObtained = params.isConsentObtained
			appForm.addToLocations(communityGeoLocation)
			//			appForm.consentObtained = params.isConsentObtained
			//}

			if(!communityGeoLocation.save(flush:true)){
				communityGeoLocation.errors.each{ println it }
			}


			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}

			println "SAvED community location is : "+communityGeoLocation


			//Fetch all rows
			def listOfCommunityLocations = GeoLocationOfCommunity.findAllByAppForm(appForm)
			println "listOfCommunityLocations == "+listOfCommunityLocations
			render(template:"geoLocationOfCommunity",model:[appForm:appForm,listOfCommunityLocations:listOfCommunityLocations])
		}
	}

	def deleteGeoLocationOfCommunity = {
		println "Inside deleteGeoLocationOfCommunity "+params
		def geoLocationOfCommunity,appForm
		if(params.appFormID){
			appForm = ApplicationForm1.get(params.appFormID)
		}
		if(params.locationId != ''){
			geoLocationOfCommunity = GeoLocationOfCommunity.get(params.locationId)
			geoLocationOfCommunity.delete(flush:true)

			def listOfCommunityLocations = GeoLocationOfCommunity.findAllByAppForm(appForm)
			println "listOfCommunityLocations == "+listOfCommunityLocations
			render(template:"geoLocationOfCommunity",model:[appForm:appForm,listOfCommunityLocations:listOfCommunityLocations])
		}
	}

	def deleteAuthorizedPerson = {
		println "Inside deleteAuthorizedPerson "+params
		def contactPersonInst
		def appForm
		if(params?.appFormId != '' || params?.appFormId != null){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		else if(session.getAttribute("appFormId") != null){
			appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
		}
		println "appForm == "+appForm

		if(params.profileId != ''){
			println "Inside deleteAuthorizedPerson1 "
			contactPersonInst = ContactPerson.get(params.profileId)
			println "Inside deleteAuthorizedPerson2 "+contactPersonInst
			contactPersonInst.delete(flush:true)
			println "Inside deleteAuthorizedPerson3 "+contactPersonInst
			def listOfContactPerson = ContactPerson.findAllByApplicationForm(appForm)
			println "listOfCommunityLocations == "+listOfContactPerson
			render(template:"authorizedPersonGrid",model:[listOfContactPerson:listOfContactPerson,appForm:appForm])
			//			redirect(action: "individualProfile", id: individualProfile?.id, params: [formType: params?.formType])
			//render(template:"individualProfileGrid",model:[listOfIndividualProfiles:listOfIndividualProfiles])
		}
	}

	def saveContactperson = {
		println "Inside action saveForm3  "+params
		def emailContactPerson
		def appInstance = ApplicationForm1.findById(params?.appId)

		if(params.emailOfContactPerson != null){
			emailContactPerson = (params.emailOfContactPerson)?.toLowerCase()
		}

		if(params.nameOfContactPerson!= '' && params.addressOfContactPerson != '' && params.mobileOfContactPerson && params.emailOfContactPerson){
			def saveContactPerson = new ContactPerson(nameOfContactPerson:params.nameOfContactPerson,addressOfContactPerson:params.addressOfContactPerson,contactPerson:params.contactPerson,
			mobileOfContactPerson:params.mobileOfContactPerson,emailOfContactPerson:emailContactPerson,applicationForm:appInstance)

			appInstance?.selfAuthorizedPerson = null

			if(!saveContactPerson.save(flush:true)){
				saveContactPerson.errors.each{ println it }
			}

			if(!appInstance.save(flush:true)){
				appInstance.errors.each{println it}
			}

		}
		def listOfContactPerson = ContactPerson.findAllByApplicationForm(appInstance)
		render(template:"authorizedPersonGrid",model:[appForm:appInstance,listOfContactPerson:listOfContactPerson])

	}

	def saveForm3 = {

		println "Inside saveForm3 "+params
		def appForm
		def csrfPreventionSalt = params.csrfPreventionSalt
		if(params?.appFormId != '' || params?.appFormId != null){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		else if(session.getAttribute("appFormId") != null){
			appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
		}
		println "appForm == "+appForm
		if(appForm != null ){
			appForm.briefDescription = params.briefDescription
			//			appForm.riskInvolved = params.riskInvolved
			appForm.purposeOfProposal = params.purpose

			/*if(params?.isNoForTraditional != null && params?.isNoForTraditional == 'No'){
			 appForm?.nature = params?.isNoForTraditional
			 appForm?.isNoForTraditional= params?.isNoForTraditional
			 }*/

			if(params?.selfForAuthorized != null && params?.selfForAuthorized == 'Self'){
				appForm?.selfAuthorizedPerson = params?.selfForAuthorized
			}
			else if(params?.selfForAuthorized != 'Self' ){
				appForm?.selfAuthorizedPerson = null
			}

			println "appForm.purposeOfProposal************"+appForm.purposeOfProposal
			if(params.isRisky == 'Yes'){
				appForm.isRisky = 'true'
			}
			if(params.isRisky == 'No'){
				appForm.isRisky = 'false'
			}

			appForm.riskInvolved = appForm.isRisky == 'true' ? params.riskInvolved : null

			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}

		}
		redirect (action:"form1Part3",params: [csrfPreventionSalt:csrfPreventionSalt,formType: params?.formType,appFormId:appForm?.id])
	}

	def editForm1Part3 = {
		println "PARAMS ARE "+params
		def appForm
		def contactPersonInst = ContactPerson.get(params.profileId)
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}
		render (template: "editForm1Part3", model:[appForm:appForm,contactPersonInst:contactPersonInst] )
	}


	def form1Part4 = {
		println "Inside part 4 "+params
		def appForm
		flash.message = params?.msg1
		if(params?.appFormId != '' || params?.appFormId != null){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		else if(session.getAttribute("appFormId") != null){
			appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
		}
		println "appForm == "+appForm
		def formType = params.formType
		println "formType == "+formType

		// a. get Question by question Category
		def quesCategory = QuestionCategory.findByCategory(QuestionCategory.Category.Form_1)
		println("quesCategory:" + quesCategory)

		// b. get question answer map from service.
		def quesAnswerMap = applicationMgmtService.getFormQuestionAnswers(appForm, quesCategory)
		println "Question Answer MAP == " + quesAnswerMap
		[appForm:appForm,quesAnswerMap:quesAnswerMap,quesCategory:quesCategory,formType:formType]

	}

	def savePart4 = {

		println "inside savePart4 "+params
		def appForm = ApplicationForm1.get(params?.appFormId)
		def formType = params.formType
		def csrfPreventionSalt = params.csrfPreventionSalt
		if(appForm != null){

			//			appForm.instituteParticipation = (params.instituteParticipation == 'Yes') ? 'true' : 'false'

			if(params.instituteParticipation == 'Yes'){
				appForm.instituteParticipation = 'true'
			}
			else if(params.instituteParticipation == 'No'){
				appForm.instituteParticipation = 'false'
			}

			appForm.detailsOfInstitute = appForm.instituteParticipation == 'true' ? params.detailsOfInstitute : null

			def letterOfIntentFile,letterOfIntentFileName,benefitOfSharingDoc,benefitOfSharingDocName
			if(appForm.instituteParticipation == 'true' && params.LetterOfIntent != '' && params.LetterOfIntent?.getBytes()?.size() != 0){
				println "inside LetterOfIntent"
				letterOfIntentFile = request.getFile('LetterOfIntent')
				//				appForm.letterOfintent = letterOfIntentFile.getBytes()
				//				appForm.letterOfIntentName = "LetterOfIntent"
				if (letterOfIntentFile != null && letterOfIntentFile?.getBytes()?.size() != 0) {
					def file = request.getFile('LetterOfIntent')
					int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
					def nullByteCheck = file.getOriginalFilename().contains('%00')
					if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
						println '====================='
						flash.message = "Wrong format of pdf"
						forward(action: "form1Part4", params: [msg1: 'Please upload file in pdf document format only!',
							appFormId:params.appFormId])
					}
					if (occurance > 1) {
						println '###################'
						flash.message = "Wrong format of pdf"
						forward(action: "form1Part4", params: [msg1: 'Please upload file and file must be .pdf document format only!',
							appFormId:params.appFormId])

					}

					try {
						PdfReader pdf = new PdfReader(file.getBytes())
						if(pdf && pdf.pdfVersion){
							
							new File(grailsApplication.config.letterOfIntent.toString() + File.separatorChar +"intent-letter").mkdirs()
							def filePath = new File(grailsApplication.config.letterOfIntent.toString() + File.separatorChar + "intent-letter"+ File.separatorChar + "LetterOfIntent");
						   
							  letterOfIntentFile.transferTo(filePath)
							  appForm.letterOfIntentURL = filePath
							
//							appForm.letterOfintent = letterOfIntentFile.getBytes()
							appForm.letterOfIntentName = "LetterOfIntent"
						}
						else{
							flash.message = "Wrong format of pdf"
							forward(action: "form1Part4", params: [msg1: 'Wrong format of pdf!',appFormId:params.appFormId])
							return
						}
					}catch (Exception e){
						println e.message
						flash.message = "Wrong format of pdf"
						forward(action: "form1Part4", params: [msg1: 'Wrong format of pdf!',appFormId:params.appFormId])

					}
				}
			}
			else if(appForm.instituteParticipation == 'false'){
				appForm.letterOfIntentURL = null
			}


			if(params.isBenefitSharing == 'Yes'){
				appForm.isBenefitSharing = 'true'
			}
			else if(params.isBenefitSharing == 'No'){
				appForm.isBenefitSharing = 'false'
			}
			
			if(params.isBenefitSharing == 'No'){
				if(params?.payBenefitSharing == 'Monetary'){
					appForm?.payBenefitSharing = 'Monetary'
				}
				else if(params?.payBenefitSharing == 'Non-Monetary'){
					appForm?.payBenefitSharing = 'Non-Monetary'
				}
				
				if(params?.isMonetary == 'purchasePrice'){
					appForm?.isMonetary = 'purchasePrice'
					appForm.isTradingPurpose = 'true'
				}
				else if(params?.isMonetary == 'exFactorySale'){
					appForm?.isMonetary = 'exFactorySale'
					appForm.isTradingPurpose = 'false'
				}
			}
			else{
				appForm?.payBenefitSharing = null
				appForm?.isMonetary = null
			}
			
			
			
//			if(params.isTradingPurpose == 'Yes'){
//				appForm.isTradingPurpose = 'true'
//			}
//			else if(params.isTradingPurpose == 'No'){
//				appForm.isTradingPurpose = 'false'
//			}

			if(params.BenefitOfSharingDoc != '' && params?.BenefitOfSharingDoc?.getBytes()?.size() != 0){
				println "inside BenefitOfSharingDoc"
				benefitOfSharingDoc = request.getFile('BenefitOfSharingDoc')
				benefitOfSharingDocName = "BenefitOfSharingDoc"
			

				if (benefitOfSharingDoc != null && benefitOfSharingDoc?.getBytes()?.size() != 0) {
					def file = request.getFile('BenefitOfSharingDoc')
					int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
					def nullByteCheck = file.getOriginalFilename().contains('%00')
					if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
						println '====================='
						flash.message = "Wrong format of pdf"
						forward(action: "form1Part4", params: [msg1: 'Please upload file in pdf document format only!',
							appFormId:params.appFormId])
					}
					if (occurance > 1) {
						println '###################'
						flash.message = "Wrong format of pdf"
						forward(action: "form1Part4", params: [msg1: 'Please upload file and file must be .pdf document format only!',
							appFormId:params.appFormId])

					}

					try {
						PdfReader pdf = new PdfReader(file.getBytes())
						if(pdf && pdf.pdfVersion){
							
							new File(grailsApplication.config.sharingDoc.toString() + File.separatorChar +"doc").mkdirs()
							def filePath = new File(grailsApplication.config.sharingDoc.toString() + File.separatorChar + "doc"+ File.separatorChar + benefitOfSharingDocName);
						   
							  benefitOfSharingDoc.transferTo(filePath)
							  appForm.sharingDocURL = filePath
							
//							appForm.sharingDoc = benefitOfSharingDoc.getBytes()
							appForm.sharingDocName = benefitOfSharingDocName
						}
						else{
							flash.message = "Wrong format of pdf"
							forward(action: "form1Part4", params: [msg1: 'Wrong format of pdf!',appFormId:params.appFormId])
						}
					}catch (Exception e){
						println e.message
						flash.message = "Wrong format of pdf"
						forward(action: "form1Part4", params: [msg1: 'Wrong format of pdf!',appFormId:params.appFormId])

					}
				}
			}
			else if(appForm.isBenefitSharing == 'false'){
				appForm.sharingDocURL = null
			}

			//			appForm.isBenefitSharing = params.isBenefitSharing == 'Yes' ? 'true' : 'false'


			if(params.otherInfo != ''){
				appForm.otherInfo = params.otherInfo
			}

			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}
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

			redirect(action:"form1Part4",params:[csrfPreventionSalt:csrfPreventionSalt,formType:formType,appFormId:appForm?.id])
		}
	}

	def form1Part5 = {

		println "Inside part 5 "+params
		def formType = params.formType
		println "formType == "+formType
		def appForm
		def csrfPreventionSalt = params?.csrfPreventionSalt
		println "SESSIon == "+session.getAttribute('appFormId')
		if(params?.appFormId != '' || params?.appFormId != null){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		else if(session.getAttribute("appFormId") != null){
			appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
		}
		println "appForm == "+appForm


		def declarationForm = MstrDocument.findByDocName("DeclarationForm1")
		[appForm:appForm,formType:formType,declarationForm:declarationForm, declaration:params.declaration,csrfPreventionSalt:csrfPreventionSalt]
	}

	def saveForm1Part5 = {

		println "PARAmS = "+params
		def formType = params.formType
		println "formType == "+formType
		def csrfPreventionSalt = params.csrfPreventionSalt

		println "In  saveForm1Part5 "+params
		def appForm
		if(params?.appFormId != '' || params?.appFormId != null){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		else if(session.getAttribute("appFormId") != null){
			appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
		}
		println "appForm == "+appForm
		def declarationForm,declarationFormName
		if(params.DeclarationForm != ''){
			declarationForm = request.getFile('DeclarationForm')
			declarationFormName = "DeclarationForm"
			if (declarationForm != null && declarationForm?.getBytes()?.size() != 0) {
				def file = request.getFile('DeclarationForm')
				int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
				def nullByteCheck = file.getOriginalFilename().contains('%00')
				if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
					println 'PPPPPPPPPPPP'
					flash.message = "Wrong format of pdf"
					forward(action: "form1Part5", params: [msg1: 'Please upload file in pdf document format only!',
						appFormId:params.appFormId])
				}
				if (occurance > 1) {
					println '###################'
					flash.message = "Wrong format of pdf"
					forward(action: "form1Part5", params: [msg1: 'Please upload file and file must be .pdf document format only!',
						appFormId:params.appFormId])

				}

				try {
					PdfReader pdf = new PdfReader(file.getBytes())
					if(pdf && pdf.pdfVersion){}
					else{
						flash.message = "Wrong format of pdf"
						forward(action: "form1Part5", params: [msg1: 'Wrong format of pdf!',appFormId:params.appFormId])
					}
				}catch (Exception e){
					println e.message
					flash.message = "Wrong format of pdf"
					forward(action: "form1Part5", params: [msg1: 'Wrong format of pdf!',appFormId:params.appFormId])

				}
			}
		}
		if(appForm != null){
			if(declarationForm != null && declarationFormName != null){
				
				new File(grailsApplication.config.declearation.toString() + File.separatorChar +"DEC").mkdirs()
				def filePath = new File(grailsApplication.config.declearation.toString() + File.separatorChar + "DEC"+ File.separatorChar + declarationForm?.getOriginalFilename());
			   
				  declarationForm.transferTo(filePath)
				 appForm.declarationFormURL = filePath;
				 
//				appForm.declarationForm = declarationForm.getBytes()
				appForm.declarationFormName = declarationFormName
				//}
				if(!appForm.save(flush:true)){
					appForm.errors.each{ println it }
				}
			}
			redirect(action:"form1Part5",params:[csrfPreventionSalt:csrfPreventionSalt,formType:formType])
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
		response.contentType = "application/msword"
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

			if(appForm.declarationForm){

				file = appForm.declarationForm
				
			}else if(appForm.declarationFormURL){
				file = new File(appForm.declarationFormUR)?.getBytes()
			}

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



	def confirmmessagePage = {
		
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
				
				RemoteAddress reObj = new RemoteAddress();
				def ipAddress = reObj.getClientIpAddress(request); 
				def email = springSecurityService.getCurrentUser()?.email
				
				[appForm:appForm, formType : params.formType, individualProfileList:individualProfileList, companyProfileList:companyProfileList,listOfDepositionOfMicroOrganism:listOfDepositionOfMicroOrganism,
				  foreignRepo:foreignRepo,indianRepo:indianRepo,listOfIndianResearcher:listOfIndianResearcher,listOfIndianGovtInst:listOfIndianGovtInst,ipAddress:ipAddress,email:email]
		
			}
	
	def form1Payment={
		//1.
		def formType = params.formType
		println "formType == "+formType
		//2.
		def transactionNum
		if(params.transactionId != ''){
			transactionNum = params.transactionId
			println "transactionId == "+transactionNum
		}

		[formType:formType,transactionNum:transactionNum,appFormId:params?.appFormId, appForm : ApplicationForm1.get(params?.appFormId),declaration:params?.declaration]
	}

	def fetchUpdatedBioResources = {
		println "Inside fetchUpdatedBioResources == "+params
		def appForm
		if(params?.appFormId != '' || params?.appFormId != null){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		else if(session.getAttribute("appFormId") != null){
			appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
		}
		println "appForm == "+appForm
		def listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)
		println "listOfBioResources == "+listOfBioResources
	}

	def dateCheck(){
		println "hiiiii "+params
		try{
			def newdate = new Date()

			DateFormat df =new SimpleDateFormat("dd/MM/yyyy")

			String str = "08/01/2016"

			if(params.fromTime && params.toTime){

				def startdate = df.parse(params.fromTime)
				def enddate = df.parse(params.toTime)

				println "Hello "+startdate.compareTo(enddate)
				def msg
				if(startdate.compareTo(enddate) < 0){
					println "hiiiii"

				}
				else{
					msg=[message:"End date cannot be lesser than start date"]
					render msg as JSON
				}
			}
		}

		catch(Exception e){
			println e
		}
	}

	def fetchStates = {
		println "Inside fetchStates "+params

		def csrfPreventionSalt = params.id
		def formType,part
		formType=params.formType
		part=params.part
		print "formType..........."+formType
		if(formType == 'FormB'){
			print "formType..........1."+formType
			if(params.countryId != ''){
				def country = Country.get(params.countryId)?.country

				if(country == 'India'){
					println 'Show states'
					render(template:"states",model:[csrfPreventionSalt:csrfPreventionSalt,statesList:State.list(),formType:formType])

				}
				else{
					println "STATES "
					render(template:"states",model:[csrfPreventionSalt:csrfPreventionSalt,listOfCountries:Country.list(),formType:formType])
				}

			}
		}
		else if(formType == 'FormC'){
			print "formType..........1."+formType
			if(params.countryId != ''){
				def country = Country.get(params.countryId)?.country

				if(country == 'India'){
					println 'Show states'
					render(template:"states",model:[csrfPreventionSalt:csrfPreventionSalt,statesList:State.list(),formType:formType,part:part])

				}
				else{
					println "STATES "
					render(template:"states",model:[csrfPreventionSalt:csrfPreventionSalt,listOfCountries:Country.list(),formType:formType,part:part])
				}

			}
		}
		else if(params.countryId != ''){
			def country = Country.get(params.countryId)?.country

			if(country == 'India'){
				println 'Show states'
				render(template:"states",model:[csrfPreventionSalt:csrfPreventionSalt,statesList:State.list()])

			}
			else{
				println "STATES "
				render(template:"states",model:[csrfPreventionSalt:csrfPreventionSalt,listOfCountries:Country.list()])
			}

		}
	}

	def fetchCountries = {
		println "Inside fetchCountries "+params
		def csrfPreventionSalt = params.csrfPreventionSalt
		def listOfCountries = Country.list()
		listOfCountries.remove(Country.findByCountry('India'))
		println "listOfCountries == "+listOfCountries
		render(template:"countries",model:[csrfPreventionSalt:csrfPreventionSalt,listOfCountries:listOfCountries,selectedCountry:params?.selectedCountry])
	}

	def changeStatus = {

		println "Inside changeStatus "+params
		def appForm
		if(params.appFormId != ''){

			appForm = ApplicationForm1.get(params.appFormId)
			/*def appStatus = applicationMgmtService.changeAppStatus(AppStatus.Status.SUBMITTED,springSecurityService.currentUser,params.appFormId)
			 println "appStatus == "+appStatus*/
		}
		redirect(controller:"loggedInAs",action:"inbox")
	}

	def changeAppStatus = {
		println "Inside changeAppStatus "+params

		//1.
		def appForm,formType,formCategory
		Transaction transaction
		def csrfPreventionSalt = params.csrfPreventionSalt
		if(params.formType != ''){
			formType = params.formType
		}
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId as Long)
		}
		//2.
		if(params.formType == 'Form1'){
			formCategory = FormCategory.Category.Form_1
		}
		else if(params.formType == 'Form2'){
			formCategory = FormCategory.Category.Form_2
		}
		else if(params.formType == 'Form3'){
			formCategory = FormCategory.Category.Form_3
		}
		else if(params.formType == 'Form4'){
			formCategory = FormCategory.Category.Form_4
		}
		println "formCategory == "+formCategory
		//3.
		def listOfTransactionNos = Transaction.findAllByFormTypeAndIsAssigned(formCategory,false)
		println "listOfTransactionNos == "+listOfTransactionNos
		if(listOfTransactionNos != null && listOfTransactionNos.size() > 0){
			transaction = listOfTransactionNos[0]
			println "transaction == "+transaction
			transaction.isAssigned = true
			appForm.transaction = transaction

             if(listOfTransactionNos.size() <= 35){
				 
				 mailService.sendMail {
					 to "support@nbaindia.in","admn.efid@nic.in"
					 from "alert.nic@gov.in"
					 cc "techbs@nba.nic.in", "arpita@nic.in"
					
					 subject "Alert for Transaction number"
					 text 'The transaction number for '+formCategory+'is left only '+ listOfTransactionNos.size() 
				  }
				 
             }

			/*if(params.radio == 'digital'){
			 appForm.isDeclarationDigitallySigned = true
			 }
			 else{
			 appForm.isDeclarationDigitallySigned = false
			 }*/
			if(!transaction.save(flush:true)){
				transaction.errors.each{ println it }
			}
			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}
			println "TRAnsaction obj == "+appForm?.transaction
			redirect(action:"form1Payment",params:[csrfPreventionSalt:csrfPreventionSalt,appFormId:appForm?.id,transactionId:transaction?.transactionId,formType:formType])

		}else{
		println "No transaction number available please add more"
		}

	}

	def form1preview={
		println "form!Preview---"+params
		def formType, appForm
		formType = params.formType
		appForm = ApplicationForm1.get(params?.appFormId)
		[formType:formType, declaration:params.declaration, appForm:appForm]
	}
	
	def formCpreview={
		println "formCPreview---"+params
		def formType, appForm
		formType = params.formType
		appForm = ApplicationForm1.get(params?.appFormId)
		[formType:formType, appForm:appForm]
	}
	
	def formBpreview={
		println "formBPreview---"+params
		def formType, appForm
		formType = params.formType
		appForm = ApplicationForm1.get(params?.appFormId)
		[formType:formType, appForm:appForm]
	}



	def completePayment = {
		println "Inside completePayment "+params
		def appForm,transaction,applicationNum,applicationSubmitted = []
		def csrfPreventionSalt = params.csrfPreventionSalt,appStatus
		List submittedApplication = []
	 
		
		if(params.appFormId != '' || params.appFormId != null){
			appForm = ApplicationForm1.get(params.appFormId)
		}
		println "current date***************"
		
		SimpleDateFormat dateFormat = new SimpleDateFormat('yyyy-MM-dd');
		Date date = new Date();
		String currentDateString = dateFormat.format(date);
		appForm.submittedOn = currentDateString

		println "current date++++++++++++++++++ === "+currentDateString



		println "------------Generating Dynamin application number-----------"

    if(!appForm.appNumber){
	
		println "application number is not exist"
	    def formType = params.formType
        String formCategory = formType.toString().substring(4);
		
        applicationNum = applicationMgmtService.getDynamicApplicationNumber(formCategory,appForm)


//	if(params.formType == 'Form1'){
//			println "111111"
//			if(appCounter < 10){
//				applicationNum = 'INBA'+'1'+ appForm.submittedOn.split('-')[0]+'0000'+appCounter?.toString()
//			}
//			else if(appCounter >= 10 && appCounter < 100){
//				applicationNum = 'INBA'+'1'+ appForm.submittedOn.split('-')[0]+'000'+appCounter?.toString()
//			}
//			else if(appCounter >= 100 && appCounter < 1000){
//				applicationNum = 'INBA'+'1'+ appForm.submittedOn.split('-')[0]+'00'+appCounter?.toString()
//			}
//			else if(appCounter >= 1000 && appCounter < 10000){
//				applicationNum = 'INBA'+'1'+ appForm.submittedOn.split('-')[0]+'0'+appCounter?.toString()
//			}
//			else if(appCounter >= 10000 && appCounter < 100000){
//				applicationNum = 'INBA'+'1'+ appForm.submittedOn.split('-')[0]+appCounter?.toString()
//			}
//  
//	
//			}else if(params.formType == 'Form2'){
//			println "222222"
//			if(appCounter < 10){
//				applicationNum = 'INBA'+'2'+ appForm.submittedOn.split('-')[0]+'0000'+appCounter?.toString()
//			}
//			else if(appCounter >= 10 && appCounter < 100){
//				applicationNum = 'INBA'+'2'+ appForm.submittedOn.split('-')[0]+'000'+appCounter?.toString()
//			}
//			else if(appCounter >= 100 && appCounter < 1000){
//				applicationNum = 'INBA'+'2'+ appForm.submittedOn.split('-')[0]+'00'+appCounter?.toString()
//			}
//			else if(appCounter >= 1000 && appCounter < 10000){
//				applicationNum = 'INBA'+'2'+ appForm.submittedOn.split('-')[0]+'0'+appCounter?.toString()
//			}
//			else if(appCounter >= 10000 && appCounter < 100000){
//				applicationNum = 'INBA'+'2'+ appForm.submittedOn.split('-')[0]+appCounter?.toString()
//			}
//			//			applicationNum = 'INBA'+'2'+ appForm.submittedOn.split('-')[0]+randNum.toString()
//		}
//		else if(params.formType == 'Form3'){
//			println "333333"
//			if(appCounter < 10){
//				applicationNum = 'INBA'+'3'+ appForm.submittedOn.split('-')[0]+'0000'+appCounter?.toString()
//			}
//			else if(appCounter >= 10 && appCounter < 100){
//				applicationNum = 'INBA'+'3'+ appForm.submittedOn.split('-')[0]+'000'+appCounter?.toString()
//			}
//			else if(appCounter >= 100 && appCounter < 1000){
//				applicationNum = 'INBA'+'3'+ appForm.submittedOn.split('-')[0]+'00'+appCounter?.toString()
//			}
//			else if(appCounter >= 1000 && appCounter < 10000){
//				applicationNum = 'INBA'+'3'+ appForm.submittedOn.split('-')[0]+'0'+appCounter?.toString()
//			}
//			else if(appCounter >= 10000 && appCounter < 100000){
//				applicationNum = 'INBA'+'3'+ appForm.submittedOn.split('-')[0]+appCounter?.toString()
//			}
//			//			applicationNum = 'INBA'+'3'+ appForm.submittedOn.split('-')[0]+randNum.toString()
//		}
//		else if(params.formType == 'Form4'){
//			println "4444444"
//			if(appCounter < 10){
//				applicationNum = 'INBA'+'4'+ appForm.submittedOn.split('-')[0]+'0000'+appCounter?.toString()
//			}
//			else if(appCounter >= 10 && appCounter < 100){
//				applicationNum = 'INBA'+'4'+ appForm.submittedOn.split('-')[0]+'000'+appCounter?.toString()
//			}
//			else if(appCounter >= 100 && appCounter < 1000){
//				applicationNum = 'INBA'+'4'+ appForm.submittedOn.split('-')[0]+'00'+appCounter?.toString()
//			}
//			else if(appCounter >= 1000 && appCounter < 10000){
//				applicationNum = 'INBA'+'4'+ appForm.submittedOn.split('-')[0]+'0'+appCounter?.toString()
//			}
//			else if(appCounter >= 10000 && appCounter < 100000){
//				applicationNum = 'INBA'+'4'+ appForm.submittedOn.split('-')[0]+appCounter?.toString()
//			}
//			//			applicationNum = 'INBA'+'4'+ appForm.submittedOn.split('-')[0]+randNum.toString()
//		}
//		else if(params.formType == 'FormC'){
//			println "CCCCCCC"
//			
//			if(appCounter < 10){
//				applicationNum = 'INBA'+'C'+ appForm.submittedOn.split('-')[0]+'0000'+appCounter?.toString()
//			}
//			else if(appCounter >= 10 && appCounter < 100){
//				applicationNum = 'INBA'+'C'+ appForm.submittedOn.split('-')[0]+'000'+appCounter?.toString()
//			}
//			else if(appCounter >= 100 && appCounter < 1000){
//				applicationNum = 'INBA'+'C'+ appForm.submittedOn.split('-')[0]+'00'+appCounter?.toString()
//			}
//			else if(appCounter >= 1000 && appCounter < 10000){
//				applicationNum = 'INBA'+'C'+ appForm.submittedOn.split('-')[0]+'0'+appCounter?.toString()
//			}
//			else if(appCounter >= 10000 && appCounter < 100000){
//				applicationNum = 'INBA'+'C'+ appForm.submittedOn.split('-')[0]+appCounter?.toString()
//			}
//  			applicationNum = 'INBA'+'4'+ appForm.submittedOn.split('-')[0]+randNum.toString()
//		}
//		else if(params.formType == 'FormB'){
//			println "BBBBBBBBBB"
//			
//
//			if(appCounter < 10){
//				applicationNum = 'INBA'+'B'+ appForm.submittedOn.split('-')[0]+'0000'+appCounter?.toString()
//			}
//			else if(appCounter >= 10 && appCounter < 100){
//				applicationNum = 'INBA'+'B'+ appForm.submittedOn.split('-')[0]+'000'+appCounter?.toString()
//			}
//			else if(appCounter >= 100 && appCounter < 1000){
//				applicationNum = 'INBA'+'B'+ appForm.submittedOn.split('-')[0]+'00'+appCounter?.toString()
//			}
//			else if(appCounter >= 1000 && appCounter < 10000){
//				applicationNum = 'INBA'+'B'+ appForm.submittedOn.split('-')[0]+'0'+appCounter?.toString()
//			}
//			else if(appCounter >= 10000 && appCounter < 100000){
//				applicationNum = 'INBA'+'B'+ appForm.submittedOn.split('-')[0]+appCounter?.toString()
//			}
//			
//			//			applicationNum = 'INBA'+'4'+ appForm.submittedOn.split('-')[0]+randNum.toString()
//		}
		println "dynamic application Nummmmmmmmmmmmmmmmmmm "+applicationNum

		 appForm.appNumber = applicationNum
		 appStatus = applicationMgmtService.changeAppStatus(AppStatus.Status.SUBMITTED,springSecurityService.currentUser,params.appFormId)
		 println "setting app status"+ new Date() +" Submitted 5555555555" +appStatus
    
		 }else if(appForm.appNumber){	
		
       appStatus = applicationMgmtService.changeAppStatus(AppStatus.Status.IN_PROCESS,springSecurityService.currentUser,params.appFormId)
	   println "setting app status"+new Date() +"IN-Process6666666666666"appStatus
    }
		
		println "appStatus == "+appStatus
		println "appForm.submittedOn.split()[0]----------"+currentDateString.split('-')[0]
		println "Params Formtype"+params.formType
		
		
		if(params?.formType == 'FormC'){
			
					def args,pdf,indianRepositoryEmail
					
					println "abcd------------"+params
					
						args = appPreviewPdfService.previewFormC(params)
					
					pdf = new ByteArrayOutputStream().withStream { outputStream ->
						pdfRenderingService.render(
								args + [controller: this],
								outputStream
						).toByteArray()   // <- parse to byteArray for file render
					}
					
					 def indianRepositoryObj = ContactDetailsOfRepository?.findByApplicationForm1AndRepostoryType(appForm,'IndianRepository')
					 indianRepositoryEmail = indianRepositoryObj?.email
					 println "indianRepositoryEmail=="+indianRepositoryEmail
					
					//render(file:pdf,contentType: 'application/pdf')
					
					
		//			ByteArrayOutputStream bytes = pdfRenderingService.render(template: "path to template", model: [account:account])
					try{
							sendMail {
										multipart true
										to indianRepositoryEmail
//										from "absefiling.nba@gmail.com"
										from "info.nba@gov.in"
										subject "Abs-efiling Application Form-C"
										html "Please find the attached application Form-C"
										attachBytes "application_formC.pdf", "application/pdf", pdf
										//attachBytes "filename.pdf", "application/pdf", bytes.toByteArray()
									}
				}
				catch(Exception e){
					println "Exception: "+e
				}
		}
		
		
		if(!appForm.save(flush:true)){
			appForm.errors.each{ println it }
		}
		
		
		println "Start data push to GIZ..."+ new Date() 

		def formDetails,resp

		println"application+++"+appForm
		
		try{

		RestBuilder rest = new RestBuilder()
		disableSslVerification()
		if(application?.category?.category == FormCategory?.Category?.Form_1){
			
			println "Inside GIZ form One"

			formDetails  = apiForCDACITMSToolsService.restPushDataToCDACITMSToolsForm1(appForm);
			
//			Gson gson = new Gson();
//			String data = gson.toJson(formDetails);
//			JSONObject json = new JSONObject(data);
			
			       GsonBuilder gsonMapBuilder = new GsonBuilder();
				   Gson gsonObject = gsonMapBuilder.create();
				   String JSONObject = gsonObject.toJson(formDetails);
			
			println "json object"+JSONObject

			resp =  rest.post("https://absms.cdacchn.in:3104/apis/f1") {
				accept "application/json"
				header 'authorization', "Bearer "+'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoiaXRtc3VzZXIiLCJpYXQiOjE1OTI1NzQ1MDB9.QhFtgvgDtbjet2fEbiWqtZ_nw37nrkyoysVbrkraZjs'
				json JSONObject

			}
			
			println"return parameter"+ resp.status
			
		}

		if(application?.category?.category == FormCategory?.Category?.Form_2){
			
			println "Inside GIZ form Two"

			formDetails  = apiForCDACITMSToolsService.restPushDataToCDACITMSToolsForm234(appForm);

			resp =  rest.post("https://absms.cdacchn.in:3104/apis/f1") {
				accept "application/json"
				header 'authorization', "Bearer "+'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoiaXRtc3VzZXIiLCJpYXQiOjE1OTI1NzQ1MDB9.QhFtgvgDtbjet2fEbiWqtZ_nw37nrkyoysVbrkraZjs'
				json formDetails

			}
			println"return parameter"+ resp.status
		}

		if(application?.category?.category == FormCategory?.Category?.Form_3){
			
			println "Inside GIZ form Three"

			formDetails  = apiForCDACITMSToolsService.restPushDataToCDACITMSToolsForm234(appForm);

			resp =  rest.post("https://absms.cdacchn.in:3104/apis/f1") {
				accept "application/json"
				header 'authorization', "Bearer "+'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoiaXRtc3VzZXIiLCJpYXQiOjE1OTI1NzQ1MDB9.QhFtgvgDtbjet2fEbiWqtZ_nw37nrkyoysVbrkraZjs'
				json formDetails

			}
			println"return parameter"+ resp.status
		}

		if(application?.category?.category == FormCategory?.Category?.Form_4){
			
			println "Inside GIZ form Four"

			formDetails  = apiForCDACITMSToolsService.restPushDataToCDACITMSToolsForm234(appForm);

			resp =  rest.post("https://absms.cdacchn.in:3104/apis/f1") {
				accept "application/json"
				header 'authorization', "Bearer "+'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoiaXRtc3VzZXIiLCJpYXQiOjE1OTI1NzQ1MDB9.QhFtgvgDtbjet2fEbiWqtZ_nw37nrkyoysVbrkraZjs'
				json formDetails
			}
			println"return parameter"+ resp.status
		}
		if(application?.category?.category == FormCategory?.Category?.Form_B){
			
			println "Inside GIZ form Bee"

			formDetails  = apiForCDACITMSToolsService.restPushDataToCDACITMSToolsFormB(appForm);

			resp =  rest.post("https://absms.cdacchn.in:3104/apis/f1") {
				accept "application/json"
				header 'authorization', "Bearer "+'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoiaXRtc3VzZXIiLCJpYXQiOjE1OTI1NzQ1MDB9.QhFtgvgDtbjet2fEbiWqtZ_nw37nrkyoysVbrkraZjs'
				json formDetails

			}
			println"return parameter"+ resp.status

		}
		if(application?.category?.category == FormCategory?.Category?.Form_C){
			
			println "Inside GIZ form Cee"

			formDetails  = apiForCDACITMSToolsService.restPushDataToCDACITMSToolsFormC(appForm);

			resp =  rest.post("https://absms.cdacchn.in:3104/apis/f1") {
				accept "application/json"
				header 'authorization', "Bearer "+'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoiaXRtc3VzZXIiLCJpYXQiOjE1OTI1NzQ1MDB9.QhFtgvgDtbjet2fEbiWqtZ_nw37nrkyoysVbrkraZjs'
				json formDetails
			}
			println"return parameter"+ resp.status

		}
		}catch(Exception e){e.printStackTrace()}

		  println "Stop data  sending to GIZ ..."+ new Date()
	
		  redirect(action:"confirmmessagePage",params:[csrfPreventionSalt:csrfPreventionSalt,appFormId:appForm?.id,formType:params?.formType])
	    
	  }
	
	
	
	def saveDeclaration = {

		println "under save declaration "+params
		//		def appForm = ApplicationForm1.get(session.getAttribute('appFormId'))
		def appForm
		def csrfPreventionSalt = params.csrfPreventionSalt
		if(params?.appFormId != '' || params?.appFormId != null){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		else if(session.getAttribute("appFormId") != null){
			appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
		}
		if(params.radio == 'digital'){
			println "under 1"
			appForm?.isDeclarationDigitallySigned = 'true'
			println "under 11"
		}
		else{
			println "under2"
			appForm?.isDeclarationDigitallySigned = 'notDigital'
			println "under 22"
		}

		appForm?.submitCheck = params.submitCheck == 'on' ? true : false

		//		if(params.submitCheck == 'on'){
		//			println "check is checked"
		//			appForm?.submitCheck = true
		//		}
		//		else{
		//			println "check not checked"
		//
		//		}
		

		if(!appForm.save(flush:true)){
			appForm.errors.each{println it}
		}
		println "VALUE OF DIGITAL == "+appForm?.isDeclarationDigitallySigned
		//if(formType == 'Form1')
		redirect(action:"form1Part5",params:[csrfPreventionSalt:csrfPreventionSalt,formType:params.formType,appFormId:appForm?.id, declaration:"declaration"])
		//else if(formType == 'Form4')
		//redirect(action:"part5",controller:"form4",params:[formType:params.formType,appFormId:appForm?.id, declaration:"declaration"])

	}

	def form1feedback = {
		def appForm;
		def csrfPreventionSalt = params.csrfPreventionSalt
		println "Params in feedback are---"+params
		if(params?.appFormId != '' || params?.appFormId != null){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		else if(session.getAttribute("appFormId") != null){
			appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
		}
		println "appForm == "+appForm

		[appForm:appForm,csrfPreventionSalt:csrfPreventionSalt]
	}

	def saveFormFeedback = {
		def appForm
		def csrfPreventionSalt = params.csrfPreventionSalt
		if(params?.appFormId != '' || params?.appFormId != null){
			appForm = ApplicationForm1.get(params?.appFormId)
		}
		else if(session.getAttribute("appFormId") != null){
			appForm = ApplicationForm1.get(session.getAttribute("appFormId"))
		}
		println "appForm == "+appForm
		appForm?.feedback = params.feedback

		if(!appForm?.save(flush:true)){
			appForm?.errors?.each{println it}
		}

		try{
			sendMail {
				to "techbs@nba.nic.in"
//				from "absefiling.nba@gmail.com"
				from "info.nba@gov.in"
				subject "App_Feedback"
				body appForm?.feedback

				flash.message= "Feedback sent"
			}
		}
		catch(Exception e){
			println "Exception: "+e
		}

		redirect(action: 'form1feedback', params: [appFormId:appForm?.id,csrfPreventionSalt:csrfPreventionSalt] )
	}

	def confirmmessagePrintPreview={

	}

	def saveBeforePaymentProcess = {
		println "inside save eeeeeeeeeeeeee"+ params
		def appForm,paymentReceipt,paymentReceiptName
		def csrfPreventionSalt = params.csrfPreventionSalt
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}
		if(params.paymentRefNo != ''){
			println "transaction == "
			println "transaction 11111111== "
			appForm.transaction.isPaymentMade = true
			appForm.transaction.paymentRefNo = params.paymentRefNo
			
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		      Date date = new Date();
		   
			 println"Payment Date is"+(dt.format(date));
			
			 appForm.transaction.paymentDate = dt.parse(dt.format(date))
			
			println "transaction 222222== "+appForm.transaction.paymentRefNo
			
			
			if(params.PaymentReceipt != '' && params.PaymentReceipt?.getBytes()?.size() != 0){
			paymentReceipt = request.getFile('PaymentReceipt')
			paymentReceiptName = "PaymentReceipt"
			
			if (paymentReceipt != null && paymentReceipt?.getBytes()?.size() != 0) {
				def file = request.getFile('PaymentReceipt')
				int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
				def nullByteCheck = file.getOriginalFilename().contains('%00')
				if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
					println 'PPPPPPPPPPPP'
					flash.message = "Wrong format of pdf"
					forward(action: "form1Payment", params: [msg1: 'Please upload file in pdf document format only!',
						appFormId:params.appFormId])
				}
				if (occurance > 1) {
					println '###################'
					flash.message = "Wrong format of pdf"
					forward(action: "form1Payment", params: [msg1: 'Please upload file and file must be .pdf document format only!',
						appFormId:params.appFormId])

				}

				try {
					PdfReader pdf = new PdfReader(file.getBytes())
					if(pdf && pdf.pdfVersion){}
					else{
						flash.message = "Wrong format of pdf"
						forward(action: "form1Payment", params: [msg1: 'Wrong format of pdf!',appFormId:params.appFormId])
					}
				}catch (Exception e){
					println e.message
					flash.message = "Wrong format of pdf"
					forward(action: "form1Payment", params: [msg1: 'Wrong format of pdf!',appFormId:params.appFormId])

				}
			}
			}
			
			
//
//			if(params?.PaymentReceipt != '' && params?.PaymentReceipt?.getBytes()?.size() != 0){
//				paymentReceipt = request.getFile('PaymentReceipt')
//				println "transaction 2223333== "
//				paymentReceiptName = "PaymentReceipt"
			
			new File(grailsApplication.config.paymentReceipt.toString() + File.separatorChar +"payment").mkdirs()
			def filePath = new File(grailsApplication.config.paymentReceipt.toString() + File.separatorChar + "payment"+ File.separatorChar + appForm?.appNumber);
		   
			  paymentReceipt?.transferTo(filePath)
			 appForm.transaction.paymentReceiptURL = filePath;
			
			
			
			
			
//				appForm.transaction.paymentReceipt = paymentReceipt?.getBytes()
				appForm.transaction.paymentReceiptName = paymentReceiptName
//			}

		}
		if(!appForm.save(flush:true)){
			appForm.errors.each{println it}
		}

		redirect(action:"form1Payment",params:[csrfPreventionSalt:csrfPreventionSalt,appFormId:appForm?.id,transactionId:params?.transactionId,formType:params?.formType,declaration:'declaration'])
		//		redirect(action: 'form1Payment', params: [formType:formType,appFormId:appFormId,declaration:'declaration'])
	}

	/*def uploadDigitalSignature = {
	 println "inside Digital Upload"+params
	 def appForm;
	 appForm = ApplicationForm1.get(params.appFormId)
	 } */


	def adminEdits = {
		def csrfPreventionSalt = params.csrfPreventionSalt
		println "inside admin edits action"+params

		[csrfPreventionSalt:csrfPreventionSalt]
	}

	def sendOtp(){
		
		def applicationId = params.formId as Long
		def applicantDetails = ApplicationForm1.get(applicationId)
		
		def username = springSecurityService.getCurrentUser()?.username
		def email = springSecurityService.getCurrentUser()?.email
		
		println "sending email-Id is"+email+"date" +new Date()
        		
		int otp = otpService.generateOTP(username);
		print "otp"+otp
	   def result = [otp:otp]
//		def email = applicantDetails?.submittedBy?.email
		applicantDetails.otpStatus = false
		
		println "44444444"+email
			mailService.sendMail {
				to email
				from "nba.notify@gov.com"
				subject "Online Submission of ABS Application : Electronic Verification Code"
				html g.render(template:'/emailTemplate/otp', model:[otp:otp.toString(),applicationNumber:applicantDetails?.appNumber])
//				text otp.toString()
			}
		
		render result as JSON
	}
	
	def verifyOtp(){

		Integer otpnum;
		def enteredOtp = params.otp
		def formId = params.formId;
		def changeOtpStatus = ApplicationForm1.get(formId as Long)
		try {
			otpnum = enteredOtp as Integer
		}catch(NumberFormatException numberExp){
		
			print numberExp
		}

		final String SUCCESS = "Entered OTP is validated successfully";

		final String FAIL = "Entered OTP is not valid";
		def responce = "";

		def username = springSecurityService.getCurrentUser()?.username

		println"check Integer"+otpnum instanceof Integer

		if(otpnum >= 0 && otpnum instanceof Integer){
			int serverOtp = otpService.getOtp(username);

			if(serverOtp > 0){
				if(otpnum == serverOtp){
					otpService.clearOTP(username);
					
					changeOtpStatus.otpStatus = true
					
					responce = [result:SUCCESS]
					render  responce as JSON
				}else{
					responce = [result:FAIL]
					render  responce as JSON
				}
			}else {
				responce = [result:FAIL]
				render  responce as JSON
			}
		}else {
			responce = [result:FAIL]
			render  responce as JSON
		}
	}

		void disableSslVerification() throws NoSuchAlgorithmException, KeyManagementException{
		// Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = [
			new X509TrustManager(){
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null
				}
				public void checkClientTrusted(X509Certificate[] certs, String authType) {

				}
				public void checkServerTrusted(X509Certificate[] certs, String authType) {

				}
			}
		]

		// Install the all-trusting trust manager
		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		// Create all-trusting host name verifier
		HostnameVerifier allHostsValid = new HostnameVerifier() {
					public boolean verify(String hostname, SSLSession sslSession) {
						return true;
					}
				};
		// Install the all-trusting host verifier
		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	}
}
