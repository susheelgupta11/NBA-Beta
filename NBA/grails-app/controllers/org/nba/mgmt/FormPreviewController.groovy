package org.nba.mgmt
import grails.converters.JSON

import java.text.DateFormat
import java.text.SimpleDateFormat

import org.nba.application.AgentProfile
import org.nba.application.AppStatus
import org.nba.application.ApplicationForm1
import org.nba.application.CompanyProfile
import org.nba.application.ContactPerson
import org.nba.application.FormCategory
import org.nba.application.FormBFundingAgency
import org.nba.application.IndividualProfile
import org.nba.common.Country
import org.nba.common.State
import org.nba.master.MstrDocument
import org.nba.master.Transaction
import org.nba.master.QuestionCategory
import org.nba.resource.BiologicalResource
import org.nba.resource.IPRDetail
import org.nba.resource.ThirdParty
import org.nba.resource.GeoLocationOfBioResource
import org.nba.resource.GeoLocationOfCommunity
import org.springframework.security.access.annotation.Secured
import org.nba.application.DepositionOfMicroOrganism
import org.nba.application.ContactDetailsOfRepository
import org.nba.application.IndianResearcher
import org.nba.application.IndianGovtInst
import org.nba.application.FormB
@Secured('permitAll')
class FormPreviewController {
	def springSecurityService
	def pdfRenderingService
	def applicationMgmtService
	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def previewForm1Info(){
		println "In preview form 1%%%%%%%%%%%%%% "+params

		def appForm,companyAgentProfile
		def formType = 'Form1'
		def csrfPreventionSalt = params?.csrfPreventionSalt

		println " *****  Form type ****  =  "+formType
		println "appFormid through link ################== "+params.id
		
		appForm = ApplicationForm1.get(params?.id)
//		appForm = ApplicationForm1.findBySubmittedByAndCategory(springSecurityService.currentUser,FormCategory.findByCategory(FormCategory.Category.Form_1))
		println " *****  Form1 FormCategory ****  =  "+FormCategory.findByCategory(FormCategory.Category.Form_1)
		
		if(appForm?.agentProfile?.isCompanyAgent == true){
			companyAgentProfile = appForm?.agentProfile
		}
		println "companyAgentProfilecompanyAgentProfile+++"+companyAgentProfile

		def listofFormData=[]
		def listOfLocations = [], listOfCommunityLocations=[], listOfContactPerson=[], listOfCompanyData=[]
		def listOfBioResources
		def agentprofile
		if(appForm != null){
			listofFormData = IndividualProfile.findAllByApplicationForm1(appForm)
			listOfCompanyData = CompanyProfile.findAllByApplicationForm(appForm)
			println "listOfIndividualProfiles == "+listofFormData.size()
			println "agentProfile == "+appForm?.agentProfile
			agentprofile = appForm?.agentProfile
			println "agentProfile size == "+agentprofile
			
			 listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)
			 println "listOfBioResources  == "+listOfBioResources
			for(bioResorce in listOfBioResources){
				def bioResourceLocations = GeoLocationOfBioResource.findAllByBioResource(bioResorce)
				for(loc in bioResourceLocations){
					listOfLocations.add(loc)
					}
			}
			if(params.locationId){
				def geoLocation = GeoLocationOfBioResource.get(params.locationId)
				render(template:"geographicalLocationForm",model:[listOfBioResources:listOfBioResources,geoLocation:geoLocation])
			}
		}
		
		// a. get Question by question Category
		def quesCategory = QuestionCategory.findByCategory(QuestionCategory.Category.Form_1)

		// b. get question answer map from service.
		def quesAnswerMap = applicationMgmtService.getFormQuestionAnswers(appForm, quesCategory)
        println "quesAnswerMap == "+quesAnswerMap

		listOfCommunityLocations = GeoLocationOfCommunity.findAllByAppForm(appForm)
		
		listOfContactPerson = ContactPerson.findAllByApplicationForm(appForm)
		
		
		
		
		List entityTypes = ['Government Agency' , 'Institution', 'Company/Industry']
		List purposeList = ['Research', 'Bio-survey and bio-utilization', 'Commercial utilization']
		def natureOfReources = ['Plant', 'Animal', 'Micro-organism']

		[appForm:appForm,companyAgentProfile:companyAgentProfile,listOfCompanyData:listOfCompanyData,entityTypes:entityTypes,formType:formType,bioResourceSize:listOfBioResources?.size(),geoLocationSize:listOfLocations.size(),
			listofFormData:listofFormData,sizeoflist:listofFormData?.size(),agentProfile:agentprofile,listOfLocations:listOfLocations,
				listOfBioResources:listOfBioResources,natureOfReources:natureOfReources,listOfCommunityLocations:listOfCommunityLocations,
				geoLocOfCommSize:listOfCommunityLocations?.size(),listOfContactPerson:listOfContactPerson,contactPersonSize:listOfContactPerson?.size(),
				purposeList:purposeList,quesAnswerMap:quesAnswerMap,quesCategory:quesCategory,csrfPreventionSalt:csrfPreventionSalt
		]
	}
	
	
	def previewFormCInfo(){
		println "In preview form C%%%%%%%%%%%%%% "+params

		def appForm,companyAgentProfile,bioRes,bioResourceLocations
		def formType = 'Form1'
		def csrfPreventionSalt = params?.csrfPreventionSalt
		appForm = ApplicationForm1.get(params?.id)
		def listOfDepositionOfMicroOrganism = DepositionOfMicroOrganism.findAllByApplicationForm1(appForm)
		println " ***** listOfDepositionOfMicroOrganism ****  =  "+listOfDepositionOfMicroOrganism
		
		def listOfScientistName = BiologicalResource.findAllByApplicationForm(appForm)
		
		 bioRes = new ArrayList()
		
		for(bioResorce in listOfScientistName){
			println "bioResourceLocations-------"+bioResorce
			
			bioResourceLocations = GeoLocationOfBioResource?.findAllByBioResource(bioResorce)
			
			bioRes.add(bioResourceLocations)
		}
		
		
		//def listOfContactDetailsOfRepository = ContactDetailsOfRepository.findAllByApplicationForm1AndIsAccessionNumAllotted(appForm,!true)
		
		def listOfContactDetailsOfRepository = ContactDetailsOfRepository.findAllByApplicationForm1(appForm)
		println "listOfContactDetailsOfRepository-1-"+listOfContactDetailsOfRepository
		def listOfContactDetailsOfRepository1 = ContactDetailsOfRepository.findAllByApplicationForm1AndIsAccessionNumAllotted(appForm,true)
		listOfContactDetailsOfRepository.removeAll(listOfContactDetailsOfRepository1)
		
		println "listOfContactDetailsOfRepository-2-"+listOfContactDetailsOfRepository
		
		def accessionNumber = ContactDetailsOfRepository.findByApplicationForm1AndIsAccessionNumAllotted(appForm,true)
		
		def applicationform = ApplicationForm1.get(appForm.id)
		[appForm:appForm,formType:formType,csrfPreventionSalt:csrfPreventionSalt,listOfDepositionOfMicroOrganism:listOfDepositionOfMicroOrganism,listOfScientistName:listOfScientistName,bioRes:bioRes,
			listOfContactDetailsOfRepository:listOfContactDetailsOfRepository,applicationform:applicationform,accessionNumber:accessionNumber
		]
	}
	
	def printCompleteProjectC(){
		println "In preview form C%%%%%%%%%%%%%% "+params
		
				def appForm,companyAgentProfile,bioRes,bioResourceLocations
				def formType = 'Form1'
				def csrfPreventionSalt = params?.csrfPreventionSalt
				appForm = ApplicationForm1.get(params?.id)
				def listOfDepositionOfMicroOrganism = DepositionOfMicroOrganism.findAllByApplicationForm1(appForm)
				println " ***** listOfDepositionOfMicroOrganism ****  =  "+listOfDepositionOfMicroOrganism
				
				def listOfScientistName = BiologicalResource.findAllByApplicationForm(appForm)
				
				 bioRes = new ArrayList()
				
				for(bioResorce in listOfScientistName){
					println "bioResourceLocations-------"+bioResorce
					
					bioResourceLocations = GeoLocationOfBioResource?.findAllByBioResource(bioResorce)
					
					bioRes.add(bioResourceLocations)
				}
				def listOfContactDetailsOfRepository = ContactDetailsOfRepository.findAllByApplicationForm1(appForm)
				println "listOfContactDetailsOfRepository-1-"+listOfContactDetailsOfRepository
				def listOfContactDetailsOfRepository1 = ContactDetailsOfRepository.findAllByApplicationForm1AndIsAccessionNumAllotted(appForm,true)
				listOfContactDetailsOfRepository.removeAll(listOfContactDetailsOfRepository1)
				
				println "listOfContactDetailsOfRepository-2-"+listOfContactDetailsOfRepository
				
				def accessionNumber = ContactDetailsOfRepository.findByApplicationForm1AndIsAccessionNumAllotted(appForm,true)
				def applicationform = ApplicationForm1.get(appForm.id)
				[appForm:appForm,formType:formType,csrfPreventionSalt:csrfPreventionSalt,listOfDepositionOfMicroOrganism:listOfDepositionOfMicroOrganism,listOfScientistName:listOfScientistName,bioRes:bioRes,
					listOfContactDetailsOfRepository:listOfContactDetailsOfRepository,applicationform:applicationform,accessionNumber:accessionNumber
				]
	}
	
	def previewFormBInfo(){
		println "In preview form B%%%%%%%%%%%%%% "+params

		def appForm,companyAgentProfile,bioRes,bioResourceLocations
		def formType = 'FormB'
		def csrfPreventionSalt = params?.csrfPreventionSalt
		appForm = ApplicationForm1.get(params?.id)
		println "appForm == "+appForm
		def listOfIndianResearcher = IndianResearcher.findAllByApplicationForm1(appForm)
		def listOfIndianGovtInst = IndianGovtInst.findAllByApplicationForm1(appForm)
		
		
		println " ***** listOfIndianResearcher ****  =  "+listOfIndianResearcher
		def entity1 = FormB.findByAppFormAndType(appForm,FormB.EntityType.Institute)
		def entity2 = FormB.findByAppFormAndType(appForm,FormB.EntityType.Supervisor)
		def entity3 = FormB.findByAppFormAndType(appForm,FormB.EntityType.Guiding_Institute)
		def entity4 = FormB.findByAppFormAndType(appForm,FormB.EntityType.Guiding_Supervisor)
		def entity5 = FormB.findByAppFormAndType(appForm,FormB.EntityType.Funding_Agency)
		def listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)
		
		println "entity5---------"+entity5
		
		def listOfFundingAgency = FormBFundingAgency?.findAllByAppform(appForm)
		
		def listOfLocations = []
		for(bioResorce in listOfBioResources){
			 bioResourceLocations = GeoLocationOfBioResource.findAllByBioResource(bioResorce)
			for(loc in bioResourceLocations){
				//if(loc.state != null && loc.district != null && loc.town != null && loc.traderName != null && loc.traderContactDetails != null){
				listOfLocations.add(loc)
				//	}
			}
		}
		println "..................name........."
		[appForm:appForm,formType:formType,csrfPreventionSalt:csrfPreventionSalt,listOfIndianResearcher:listOfIndianResearcher,
			entity1:entity1,listOfIndianGovtInst:listOfIndianGovtInst,listOfFundingAgency:listOfFundingAgency,
			entity2:entity2,entity3:entity3,entity4:entity4,entity5:entity5,
			listOfBioResources:listOfBioResources,listOfLocations:listOfLocations]
	}
	
	def printCompleteProjectB = {
		println "In preview form B%%%%%%%%%%%%%% "+params

		def appForm,companyAgentProfile,bioRes,bioResourceLocations
		def formType = 'FormB'
		def csrfPreventionSalt = params?.csrfPreventionSalt
		appForm = ApplicationForm1.get(params?.id)
		println "appForm == "+appForm
		def listOfIndianResearcher = IndianResearcher.findAllByApplicationForm1(appForm)
		def listOfIndianGovtInst = IndianGovtInst.findAllByApplicationForm1(appForm)
		
		
		println " ***** listOfIndianResearcher ****  =  "+listOfIndianResearcher
		def entity1 = FormB.findByAppFormAndType(appForm,FormB.EntityType.Institute)
		def entity2 = FormB.findByAppFormAndType(appForm,FormB.EntityType.Supervisor)
		def entity3 = FormB.findByAppFormAndType(appForm,FormB.EntityType.Guiding_Institute)
		def entity4 = FormB.findByAppFormAndType(appForm,FormB.EntityType.Guiding_Supervisor)
		def entity5 = FormB.findByAppFormAndType(appForm,FormB.EntityType.Funding_Agency)
		def listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)
		
		println "entity5---------"+entity5
		
		def listOfFundingAgency = FormBFundingAgency?.findAllByAppform(appForm)
		
		def listOfLocations = []
		for(bioResorce in listOfBioResources){
			 bioResourceLocations = GeoLocationOfBioResource.findAllByBioResource(bioResorce)
			for(loc in bioResourceLocations){
				//if(loc.state != null && loc.district != null && loc.town != null && loc.traderName != null && loc.traderContactDetails != null){
				listOfLocations.add(loc)
				//	}
			}
		}
		println "..................name........."
		[appForm:appForm,formType:formType,csrfPreventionSalt:csrfPreventionSalt,listOfIndianResearcher:listOfIndianResearcher,
			entity1:entity1,listOfIndianGovtInst:listOfIndianGovtInst,listOfFundingAgency:listOfFundingAgency,
			entity2:entity2,entity3:entity3,entity4:entity4,entity5:entity5,listOfBioResources:listOfBioResources,listOfLocations:listOfLocations]
	}
	
	def createPdf = {
		
		def args,pdf
		
		println "abcd------------"+params
		
		if(params?.formType == 'Form1'){
			args = appPreviewPdfService.previewForm1(params)
		}
		else if(params?.formType == 'Form2'){
			args = appPreviewPdfService.previewForm2(params)
		}
		else if(params?.formType == 'Form3'){
			args = appPreviewPdfService.previewForm3(params)
		}
		else if(params?.formType == 'Form4'){
			args = appPreviewPdfService.previewForm4(params)
		}
		
		pdf = new ByteArrayOutputStream().withStream { outputStream ->
			pdfRenderingService.render(
					args + [controller: this],
					outputStream
			).toByteArray()   // <- parse to byteArray for file render
		}
		
//		FileOutputStream stream = new FileOutputStream("C:/temp/preview.pdf");
//		try {
//			stream.write(pdf);
//		} finally {
//			stream.close();
//		}
//
//		InputStream contentStream
//		try {
//			def file = new File("C:/temp/preview.pdf")
//			response.setHeader "Content-disposition", "attachment; filename=formpreview.pdf"
//			response.setHeader("Content-Length", "file-size")
//			response.setContentType("file-mime-type")
//			contentStream = file.newInputStream()
//			response.outputStream << contentStream
//			webRequest.renderView = false
//		}
//		catch(Exception e){
//			println e
//		}
//		finally{
//			contentStream.close()
//		}
		
//		println "pdf=="+pdf.encodeBase64().toString()
		
		render(file:pdf,contentType: 'application/pdf')
		
	}
	
	def previewForm2Info(){
		println "In preview form 1%%%%%%%%%%%%%% "+params

		def appForm,companyAgentProfile
		def formType = 'Form2'

		println " *****  Form type ****  =  "+formType
		println "appFormid through link ################== "+params.id
		
		appForm = ApplicationForm1.get(params?.id)
//		appForm = ApplicationForm1.findBySubmittedByAndCategory(springSecurityService.currentUser,FormCategory.findByCategory(FormCategory.Category.Form_1))
		println " *****  Form1 FormCategory ****  =  "+FormCategory.findByCategory(FormCategory.Category.Form_1)
		
		if(appForm?.agentProfile?.isCompanyAgent == true){
			companyAgentProfile = appForm?.agentProfile
		}
		println "companyAgentProfilecompanyAgentProfile+++"+companyAgentProfile

		def listofFormData=[]
		def listOfLocations = [], listOfCommunityLocations=[], listOfContactPerson=[], listOfCompanyData=[]
		def listOfBioResources
		def agentprofile
		if(appForm != null){
			listofFormData = IndividualProfile.findAllByApplicationForm1(appForm)
			listOfCompanyData = CompanyProfile.findAllByApplicationForm(appForm)
			println "listOfIndividualProfiles == "+listofFormData.size()
			println "agentProfile == "+appForm?.agentProfile
			agentprofile = appForm?.agentProfile
			println "agentProfile size == "+agentprofile
			 listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)
			 println "listOfBioResources  == "+listOfBioResources
			for(bioResorce in listOfBioResources){
				def bioResourceLocations = GeoLocationOfBioResource.findAllByBioResource(bioResorce)
				for(loc in bioResourceLocations){
					listOfLocations.add(loc)
					}
			}
			if(params.locationId){
				def geoLocation = GeoLocationOfBioResource.get(params.locationId)
				render(template:"geographicalLocationForm",model:[listOfBioResources:listOfBioResources,geoLocation:geoLocation])
			}
		}
		
		// a. get Question by question Category
		def quesCategory = QuestionCategory.findByCategory(QuestionCategory.Category.Form_1)

		// b. get question answer map from service.
		def quesAnswerMap = applicationMgmtService.getFormQuestionAnswers(appForm, quesCategory)
        println "quesAnswerMap == "+quesAnswerMap

		listOfCommunityLocations = GeoLocationOfCommunity.findAllByAppForm(appForm)
		
		listOfContactPerson = ContactPerson.findAllByApplicationForm(appForm)
		
		
		
		
		List entityTypes = ['Government Agency' , 'Institution', 'Company/Industry']
		List purposeList = ['Research', 'Bio-survey and bio-utilization', 'Commercial utilization']
		def natureOfReources = ['Plant', 'Animal', 'Micro-organism']

		[appForm:appForm,companyAgentProfile:companyAgentProfile,listOfCompanyData:listOfCompanyData,entityTypes:entityTypes,formType:formType,bioResourceSize:listOfBioResources?.size(),geoLocationSize:listOfLocations.size(),
			listofFormData:listofFormData,sizeoflist:listofFormData?.size(),agentProfile:agentprofile,listOfLocations:listOfLocations,
				listOfBioResources:listOfBioResources,natureOfReources:natureOfReources,listOfCommunityLocations:listOfCommunityLocations,
				geoLocOfCommSize:listOfCommunityLocations?.size(),listOfContactPerson:listOfContactPerson,contactPersonSize:listOfContactPerson?.size(),
				purposeList:purposeList,quesAnswerMap:quesAnswerMap,quesCategory:quesCategory
		]
	}
	
	def previewForm3Info(){
		println "In preview form 3%%%%%%%%%%%%%% "+params

		def appForm,companyAgentProfile
		def formType = 'Form3'

		println " *****  Form type ****  =  "+formType
		println "appFormid through link ################== "+params.id
		
		appForm = ApplicationForm1.get(params?.id)
//		appForm = ApplicationForm1.findBySubmittedByAndCategory(springSecurityService.currentUser,FormCategory.findByCategory(FormCategory.Category.Form_1))
		println " *****  Form1 FormCategory ****  =  "+FormCategory.findByCategory(FormCategory.Category.Form_1)
		
		if(appForm?.agentProfile?.isCompanyAgent == true){
			companyAgentProfile = appForm?.agentProfile
		}
		println "companyAgentProfilecompanyAgentProfile+++"+companyAgentProfile

		def listofFormData=[]
		def listOfLocations = [], listOfCommunityLocations=[], listOfContactPerson=[], listOfCompanyData=[]
		def listOfBioResources,listOfIPRDetails,listOfTransactionMade
		def agentprofile
		if(appForm != null){
			listofFormData = IndividualProfile.findAllByApplicationForm1(appForm)
			listOfCompanyData = CompanyProfile.findAllByApplicationForm(appForm)
			println "listOfIndividualProfiles == "+listofFormData?.size()
			println "agentProfile == "+appForm?.agentProfile
			agentprofile = appForm?.agentProfile
			println "agentProfile size == "+agentprofile
			 listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)
			 println "listOfBioResources  == "+listOfBioResources
			 
			 listOfIPRDetails = IPRDetail.findAllByApplicationForm(appForm)
			for(bioResorce in listOfBioResources){
				def bioResourceLocations = GeoLocationOfBioResource.findAllByBioResource(bioResorce)
				for(loc in bioResourceLocations){
					listOfLocations.add(loc)
					}
			}
			if(params.locationId){
				def geoLocation = GeoLocationOfBioResource.get(params.locationId)
				render(template:"geographicalLocationForm",model:[listOfBioResources:listOfBioResources,geoLocation:geoLocation])
			}
		}
		
		// a. get Question by question Category
		def quesCategory = QuestionCategory.findByCategory(QuestionCategory.Category.Form_1)

		// b. get question answer map from service.
		def quesAnswerMap = applicationMgmtService.getFormQuestionAnswers(appForm, quesCategory)
		println "quesAnswerMap == "+quesAnswerMap

		listOfCommunityLocations = GeoLocationOfCommunity.findAllByAppForm(appForm)
		
		listOfContactPerson = ContactPerson.findAllByApplicationForm(appForm)
		
		println "contact person"+listOfContactPerson
		
//		listOfTransactionMade = Transaction.findAllByIsPaymentMade(true)
//		println "list of transactions made..................***********"+listOfTransactionMade
		
		
		List entityTypes = ['Government Agency' , 'Institution', 'Company/Industry']
		List purposeList = ['Research', 'Bio-survey and bio-utilization', 'Commercial utilization']
		def natureOfReources = ['Plant', 'Animal', 'Micro-organism']
        println " just before rendering GSP "+agentprofile
		[listOfIPRDetails:listOfIPRDetails,appForm:appForm,companyAgentProfile:companyAgentProfile,listOfCompanyData:listOfCompanyData,entityTypes:entityTypes,formType:formType,bioResourceSize:listOfBioResources?.size(),geoLocationSize:listOfLocations?.size(),
		 listofFormData:listofFormData,sizeoflist:listofFormData?.size(),agentProfile:agentprofile,listOfLocations:listOfLocations,
		 listOfBioResources:listOfBioResources,natureOfReources:natureOfReources,listOfCommunityLocations:listOfCommunityLocations,
		 geoLocOfCommSize:listOfCommunityLocations?.size(),
		 purposeList:purposeList,quesCategory:quesCategory
		]
	}
	
	def previewForm4Info(){
		println "In preview form 1%%%%%%%%%%%%%% "+params

		def appForm,companyAgentProfile
		def formType = 'Form4'

		println " *****  Form type ****  =  "+formType
		println "appFormid through link ################== "+params.id
		
		appForm = ApplicationForm1.get(params?.id)
//		appForm = ApplicationForm1.findBySubmittedByAndCategory(springSecurityService.currentUser,FormCategory.findByCategory(FormCategory.Category.Form_1))
		println " *****  Form1 FormCategory ****  =  "+FormCategory.findByCategory(FormCategory.Category.Form_1)
		
		if(appForm?.agentProfile?.isCompanyAgent == true){
			companyAgentProfile = appForm?.agentProfile
		}
		println "companyAgentProfilecompanyAgentProfile+++"+companyAgentProfile

		def listofFormData=[],listOfThirdParty=[]
		def listOfLocations = [], listOfCommunityLocations=[], listOfContactPerson=[], listOfCompanyData=[]
		def listOfBioResources
		def agentprofile
		if(appForm != null){
			listofFormData = IndividualProfile.findAllByApplicationForm1(appForm)
			listOfCompanyData = CompanyProfile.findAllByApplicationForm(appForm)
			println "listOfIndividualProfiles == "+listofFormData.size()
			println "agentProfile == "+appForm?.agentProfile
			agentprofile = appForm?.agentProfile
			println "agentProfile size == "+agentprofile
			 listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)
			 println "listOfBioResources  == "+listOfBioResources
			for(bioResorce in listOfBioResources){
				def bioResourceLocations = GeoLocationOfBioResource.findAllByBioResource(bioResorce)
				for(loc in bioResourceLocations){
					listOfLocations.add(loc)
					}
			}
			if(params.locationId){
				def geoLocation = GeoLocationOfBioResource.get(params.locationId)
				render(template:"geographicalLocationForm",model:[listOfBioResources:listOfBioResources,geoLocation:geoLocation])
			}
		}
		
		// a. get Question by question Category
		def quesCategory = QuestionCategory.findByCategory(QuestionCategory.Category.Form_1)

		// b. get question answer map from service.
		def quesAnswerMap = applicationMgmtService.getFormQuestionAnswers(appForm, quesCategory)
		println "quesAnswerMap == "+quesAnswerMap

		listOfCommunityLocations = GeoLocationOfCommunity.findAllByAppForm(appForm)
		
		listOfContactPerson = ContactPerson.findAllByApplicationForm(appForm)
		
		listOfThirdParty = ThirdParty.findAllByApplicationForm(appForm)
		
		
		List entityTypes = ['Government Agency' , 'Institution', 'Company/Industry']
		List purposeList = ['Research', 'Bio-survey and bio-utilization', 'Commercial utilization']
		def natureOfReources = ['Plant', 'Animal', 'Micro-organism']

		[appForm:appForm,companyAgentProfile:companyAgentProfile,listOfCompanyData:listOfCompanyData,entityTypes:entityTypes,formType:formType,bioResourceSize:listOfBioResources?.size(),geoLocationSize:listOfLocations.size(),
			listofFormData:listofFormData,sizeoflist:listofFormData?.size(),agentProfile:agentprofile,listOfLocations:listOfLocations,
				listOfBioResources:listOfBioResources,natureOfReources:natureOfReources,listOfCommunityLocations:listOfCommunityLocations,
				geoLocOfCommSize:listOfCommunityLocations?.size(),listOfContactPerson:listOfContactPerson,contactPersonSize:listOfContactPerson?.size(),
				purposeList:purposeList,quesAnswerMap:quesAnswerMap,quesCategory:quesCategory,listOfThirdParty:listOfThirdParty
		]
	}
	
	def printCompleateProject = {
		println "In preview form 1%%%%%%%%%%%%%% "+params
		
				def appForm,companyAgentProfile
				def formType = 'Form1'
		
				println " *****  Form type ****  =  "+formType
				println "appFormid through link ################== "+params.id
				
				appForm = ApplicationForm1.get(params?.id)
		//		appForm = ApplicationForm1.findBySubmittedByAndCategory(springSecurityService.currentUser,FormCategory.findByCategory(FormCategory.Category.Form_1))
				println " *****  Form1 FormCategory ****  =  "+FormCategory.findByCategory(FormCategory.Category.Form_1)
				
				if(appForm?.agentProfile?.isCompanyAgent == true){
					companyAgentProfile = appForm?.agentProfile
				}
				println "companyAgentProfilecompanyAgentProfile+++"+companyAgentProfile
		
				def listofFormData=[]
				def listOfLocations = [], listOfCommunityLocations=[], listOfContactPerson=[], listOfCompanyData=[]
				def listOfBioResources
				def agentprofile
				if(appForm != null){
					listofFormData = IndividualProfile.findAllByApplicationForm1(appForm)
					listOfCompanyData = CompanyProfile.findAllByApplicationForm(appForm)
					println "listOfIndividualProfiles == "+listofFormData.size()
					println "agentProfile == "+appForm?.agentProfile
					agentprofile = appForm?.agentProfile
					println "agentProfile size == "+agentprofile
					 listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)
					 println "listOfBioResources  == "+listOfBioResources
					for(bioResorce in listOfBioResources){
						def bioResourceLocations = GeoLocationOfBioResource.findAllByBioResource(bioResorce)
						for(loc in bioResourceLocations){
							listOfLocations.add(loc)
							}
					}
					if(params.locationId){
						def geoLocation = GeoLocationOfBioResource.get(params.locationId)
						render(template:"geographicalLocationForm",model:[listOfBioResources:listOfBioResources,geoLocation:geoLocation])
					}
				}
				
				// a. get Question by question Category
				def quesCategory = QuestionCategory.findByCategory(QuestionCategory.Category.Form_1)
		
				// b. get question answer map from service.
				def quesAnswerMap = applicationMgmtService.getFormQuestionAnswers(appForm, quesCategory)
				println "quesAnswerMap == "+quesAnswerMap
		
				listOfCommunityLocations = GeoLocationOfCommunity.findAllByAppForm(appForm)
				
				listOfContactPerson = ContactPerson.findAllByApplicationForm(appForm)
				
				
				
				
				List entityTypes = ['Government Agency' , 'Institution', 'Company/Industry']
				List purposeList = ['Research', 'Bio-survey and bio-utilization', 'Commercial utilization']
				def natureOfReources = ['Plant', 'Animal', 'Micro-organism']
		
				[appForm:appForm,companyAgentProfile:companyAgentProfile,listOfCompanyData:listOfCompanyData,entityTypes:entityTypes,formType:formType,bioResourceSize:listOfBioResources?.size(),geoLocationSize:listOfLocations.size(),
					listofFormData:listofFormData,sizeoflist:listofFormData?.size(),agentProfile:agentprofile,listOfLocations:listOfLocations,
						listOfBioResources:listOfBioResources,natureOfReources:natureOfReources,listOfCommunityLocations:listOfCommunityLocations,
						geoLocOfCommSize:listOfCommunityLocations?.size(),listOfContactPerson:listOfContactPerson,contactPersonSize:listOfContactPerson?.size(),
						purposeList:purposeList,quesAnswerMap:quesAnswerMap,quesCategory:quesCategory
				]
	}
	def printCompleateProject3={
		println "In preview form 1%%%%%%%%%%%%%% "+params
		
				def appForm,companyAgentProfile
				def formType = 'Form3'
		
				println " *****  Form type ****  =  "+formType
				println "appFormid through link ################== "+params.id
				
				appForm = ApplicationForm1.get(params?.id)
		//		appForm = ApplicationForm1.findBySubmittedByAndCategory(springSecurityService.currentUser,FormCategory.findByCategory(FormCategory.Category.Form_1))
				println " *****  Form1 FormCategory ****  =  "+FormCategory.findByCategory(FormCategory.Category.Form_1)
				
				if(appForm?.agentProfile?.isCompanyAgent == true){
					companyAgentProfile = appForm?.agentProfile
				}
				println "companyAgentProfilecompanyAgentProfile+++"+companyAgentProfile
		
				def listofFormData=[]
				def listOfLocations = [], listOfCommunityLocations=[], listOfContactPerson=[], listOfCompanyData=[]
				def listOfBioResources,listOfIPRDetails
				def agentprofile
				if(appForm != null){
					listofFormData = IndividualProfile.findAllByApplicationForm1(appForm)
					listOfCompanyData = CompanyProfile.findAllByApplicationForm(appForm)
					println "listOfIndividualProfiles == "+listofFormData.size()
					println "agentProfile == "+appForm?.agentProfile
					agentprofile = appForm?.agentProfile
					println "agentProfile size == "+agentprofile
					 listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)
					 println "listOfBioResources  == "+listOfBioResources
					 
					 listOfIPRDetails = IPRDetail.findAllByApplicationForm(appForm)
					for(bioResorce in listOfBioResources){
						def bioResourceLocations = GeoLocationOfBioResource.findAllByBioResource(bioResorce)
						for(loc in bioResourceLocations){
							listOfLocations.add(loc)
							}
					}
					if(params.locationId){
						def geoLocation = GeoLocationOfBioResource.get(params.locationId)
						render(template:"geographicalLocationForm",model:[listOfBioResources:listOfBioResources,geoLocation:geoLocation])
					}
				}
				
				// a. get Question by question Category
				def quesCategory = QuestionCategory.findByCategory(QuestionCategory.Category.Form_1)
		
				// b. get question answer map from service.
				def quesAnswerMap = applicationMgmtService.getFormQuestionAnswers(appForm, quesCategory)
				println "quesAnswerMap == "+quesAnswerMap
		
				
			if(appForm.locations){
				listOfCommunityLocations = GeoLocationOfCommunity?.findAllByAppForm(appForm)
				println"listOfCommunityLocations"+listOfCommunityLocations
				}
				
				if(appForm.contactPersons){
				listOfContactPerson = ContactPerson?.findAllByApplicationForm(appForm)
				println"listOfContactPerson"+listOfContactPerson
				}
				
				
				
				
				List entityTypes = ['Government Agency' , 'Institution', 'Company/Industry']
				List purposeList = ['Research', 'Bio-survey and bio-utilization', 'Commercial utilization']
				def natureOfReources = ['Plant', 'Animal', 'Micro-organism']
		
				[listOfIPRDetails:listOfIPRDetails,appForm:appForm,companyAgentProfile:companyAgentProfile,listOfCompanyData:listOfCompanyData,entityTypes:entityTypes,formType:formType,bioResourceSize:listOfBioResources?.size(),geoLocationSize:listOfLocations.size(),
					listofFormData:listofFormData,sizeoflist:listofFormData?.size(),agentProfile:agentprofile,listOfLocations:listOfLocations,
						listOfBioResources:listOfBioResources,natureOfReources:natureOfReources,listOfCommunityLocations:listOfCommunityLocations,
						geoLocOfCommSize:listOfCommunityLocations?.size(),
						purposeList:purposeList,quesAnswerMap:quesAnswerMap,quesCategory:quesCategory
				]
		
		
	}
	def printCompleateProject2={
		println "In preview form 2%%%%%%%%%%%%%% "+params
		
				def appForm,companyAgentProfile
				def formType = 'Form2'
		
				println " *****  Form type ****  =  "+formType
				println "appFormid through link ################== "+params.id
				
				appForm = ApplicationForm1.get(params?.id)
		//		appForm = ApplicationForm1.findBySubmittedByAndCategory(springSecurityService.currentUser,FormCategory.findByCategory(FormCategory.Category.Form_1))
				println " *****  Form1 FormCategory ****  =  "+FormCategory.findByCategory(FormCategory.Category.Form_1)
				
				if(appForm?.agentProfile?.isCompanyAgent == true){
					companyAgentProfile = appForm?.agentProfile
				}
				println "companyAgentProfilecompanyAgentProfile+++"+companyAgentProfile
		
				def listofFormData=[]
				def listOfLocations = [], listOfCommunityLocations=[], listOfContactPerson=[], listOfCompanyData=[]
				def listOfBioResources
				def agentprofile
				if(appForm != null){
					listofFormData = IndividualProfile.findAllByApplicationForm1(appForm)
					listOfCompanyData = CompanyProfile.findAllByApplicationForm(appForm)
					println "listOfIndividualProfiles == "+listofFormData.size()
					println "agentProfile == "+appForm?.agentProfile
					agentprofile = appForm?.agentProfile
					println "agentProfile size == "+agentprofile
					 listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)
					 println "listOfBioResources  == "+listOfBioResources
					for(bioResorce in listOfBioResources){
						def bioResourceLocations = GeoLocationOfBioResource.findAllByBioResource(bioResorce)
						for(loc in bioResourceLocations){
							listOfLocations.add(loc)
							}
					}
					if(params.locationId){
						def geoLocation = GeoLocationOfBioResource.get(params.locationId)
						render(template:"geographicalLocationForm",model:[listOfBioResources:listOfBioResources,geoLocation:geoLocation])
					}
				}
				
				// a. get Question by question Category
				def quesCategory = QuestionCategory.findByCategory(QuestionCategory.Category.Form_1)
		
				// b. get question answer map from service.
				def quesAnswerMap = applicationMgmtService.getFormQuestionAnswers(appForm, quesCategory)
				println "quesAnswerMap == "+quesAnswerMap
		
				listOfCommunityLocations = GeoLocationOfCommunity.findAllByAppForm(appForm)
				
				listOfContactPerson = ContactPerson.findAllByApplicationForm(appForm)
				
				
				
				
				List entityTypes = ['Government Agency' , 'Institution', 'Company/Industry']
				List purposeList = ['Research', 'Bio-survey and bio-utilization', 'Commercial utilization']
				def natureOfReources = ['Plant', 'Animal', 'Micro-organism']
		
				[appForm:appForm,companyAgentProfile:companyAgentProfile,listOfCompanyData:listOfCompanyData,entityTypes:entityTypes,formType:formType,bioResourceSize:listOfBioResources?.size(),geoLocationSize:listOfLocations.size(),
					listofFormData:listofFormData,sizeoflist:listofFormData?.size(),agentProfile:agentprofile,listOfLocations:listOfLocations,
						listOfBioResources:listOfBioResources,natureOfReources:natureOfReources,listOfCommunityLocations:listOfCommunityLocations,
						geoLocOfCommSize:listOfCommunityLocations?.size(),listOfContactPerson:listOfContactPerson,contactPersonSize:listOfContactPerson?.size(),
						purposeList:purposeList,quesAnswerMap:quesAnswerMap,quesCategory:quesCategory
				]
	}
	
	
	def printCompleateProject4={
		println "In preview form 1%%%%%%%%%%%%%% "+params
		
				def appForm,companyAgentProfile
				def formType = 'Form4'
		
				println " *****  Form type ****  =  "+formType
				println "appFormid through link ################== "+params.id
				
				appForm = ApplicationForm1.get(params?.id)
		//		appForm = ApplicationForm1.findBySubmittedByAndCategory(springSecurityService.currentUser,FormCategory.findByCategory(FormCategory.Category.Form_1))
				println " *****  Form1 FormCategory ****  =  "+FormCategory.findByCategory(FormCategory.Category.Form_1)
				
				if(appForm?.agentProfile?.isCompanyAgent == true){
					companyAgentProfile = appForm?.agentProfile
				}
				println "companyAgentProfilecompanyAgentProfile+++"+companyAgentProfile
		
				def listofFormData=[],listOfThirdParty=[]
				def listOfLocations = [], listOfCommunityLocations=[], listOfContactPerson=[], listOfCompanyData=[]
				def listOfBioResources
				def agentprofile
				if(appForm != null){
					listofFormData = IndividualProfile.findAllByApplicationForm1(appForm)
					listOfCompanyData = CompanyProfile.findAllByApplicationForm(appForm)
					println "listOfIndividualProfiles == "+listofFormData.size()
					println "agentProfile == "+appForm?.agentProfile
					agentprofile = appForm?.agentProfile
					println "agentProfile size == "+agentprofile
					 listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)
					 println "listOfBioResources  == "+listOfBioResources
					for(bioResorce in listOfBioResources){
						def bioResourceLocations = GeoLocationOfBioResource.findAllByBioResource(bioResorce)
						for(loc in bioResourceLocations){
							listOfLocations.add(loc)
							}
					}
					if(params.locationId){
						def geoLocation = GeoLocationOfBioResource.get(params.locationId)
						render(template:"geographicalLocationForm",model:[listOfBioResources:listOfBioResources,geoLocation:geoLocation])
					}
				}
				
				// a. get Question by question Category
				def quesCategory = QuestionCategory.findByCategory(QuestionCategory.Category.Form_1)
		
				// b. get question answer map from service.
				def quesAnswerMap = applicationMgmtService.getFormQuestionAnswers(appForm, quesCategory)
				println "quesAnswerMap == "+quesAnswerMap
		
				listOfCommunityLocations = GeoLocationOfCommunity.findAllByAppForm(appForm)
				
				listOfContactPerson = ContactPerson.findAllByApplicationForm(appForm)
				
				listOfThirdParty = ThirdParty.findAllByApplicationForm(appForm)
				
				
				List entityTypes = ['Government Agency' , 'Institution', 'Company/Industry']
				List purposeList = ['Research', 'Bio-survey and bio-utilization', 'Commercial utilization']
				def natureOfReources = ['Plant', 'Animal', 'Micro-organism']
		
				[appForm:appForm,companyAgentProfile:companyAgentProfile,listOfCompanyData:listOfCompanyData,entityTypes:entityTypes,formType:formType,bioResourceSize:listOfBioResources?.size(),geoLocationSize:listOfLocations.size(),
					listofFormData:listofFormData,sizeoflist:listofFormData?.size(),agentProfile:agentprofile,listOfLocations:listOfLocations,
						listOfBioResources:listOfBioResources,natureOfReources:natureOfReources,listOfCommunityLocations:listOfCommunityLocations,
						geoLocOfCommSize:listOfCommunityLocations?.size(),listOfContactPerson:listOfContactPerson,contactPersonSize:listOfContactPerson?.size(),
						purposeList:purposeList,quesAnswerMap:quesAnswerMap,quesCategory:quesCategory,listOfThirdParty:listOfThirdParty
				]
	}
	
	/*def acknowledgement() {

		println "Inside confirmmessagePage == "+params
		def appForm
		List individualProfileList = [], companyProfileList = []
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}

		individualProfileList = IndividualProfile.findAllByApplicationForm1(appForm)
		companyProfileList = CompanyProfile?.findAllByApplicationForm(appForm)

		println "individualProfileList%%%%%%%%%%%%%%%%%%%"+individualProfileList
		println "formType----------"+params.formType
		println "appForm == "+appForm
		[appForm:appForm, formType : params.formType, individualProfileList:individualProfileList, companyProfileList:companyProfileList]

	}*/
	
	def acknowledgement() {
		
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
				[appForm:appForm, formType : params.formType, individualProfileList:individualProfileList, companyProfileList:companyProfileList,listOfDepositionOfMicroOrganism:listOfDepositionOfMicroOrganism,
					foreignRepo:foreignRepo,indianRepo:indianRepo,listOfIndianResearcher:listOfIndianResearcher,listOfIndianGovtInst:listOfIndianGovtInst]
		
			}
	
	def printAcknowledgement() {

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

		println "individualProfileList%%%%%%%%%%%%%%%%%%%"+individualProfileList
		println "formType----------"+params.formType
		println "appForm == "+appForm
		
		def ipAddress = applicationMgmtService.getClientIpAddress(request);
		def email = springSecurityService.getCurrentUser()?.email
		
		[appForm:appForm, formType : params.formType, individualProfileList:individualProfileList, companyProfileList:companyProfileList,listOfDepositionOfMicroOrganism:listOfDepositionOfMicroOrganism,
		foreignRepo:foreignRepo,indianRepo:indianRepo,listOfIndianResearcher:listOfIndianResearcher,listOfIndianGovtInst:listOfIndianGovtInst,ipAddress:ipAddress,email:email]

	}
	
	
}
