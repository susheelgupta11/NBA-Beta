package org.nba.application

import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap;

import org.nba.application.AgentProfile
import org.nba.application.AppStatus
import org.nba.application.ApplicationForm1
import org.nba.application.CompanyProfile
import org.nba.application.ContactPerson
import org.nba.application.FormCategory
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
import org.nba.application.ContactDetailsOfRepository
import org.nba.application.IndianResearcher
import org.nba.application.IndianGovtInst
import org.nba.application.FormB

import grails.transaction.Transactional

@Transactional
class AppPreviewPdfService {
	
	def applicationMgmtService

	
	def previewForm1(GrailsParameterMap params){
		
		println "inside form 1 preview---"

		def appForm,companyAgentProfile
		def formType = 'Form1'
		def csrfPreventionSalt = params?.csrfPreventionSalt

		appForm = ApplicationForm1.get(params?.appFormId)
		
		if(appForm?.agentProfile?.isCompanyAgent == true){
			companyAgentProfile = appForm?.agentProfile
		}

		def listofFormData=[]
		def listOfLocations = [], listOfCommunityLocations=[], listOfContactPerson=[], listOfCompanyData=[]
		def listOfBioResources
		def agentprofile
		if(appForm != null){
			listofFormData = IndividualProfile.findAllByApplicationForm1(appForm)
			listOfCompanyData = CompanyProfile.findAllByApplicationForm(appForm)
			agentprofile = appForm?.agentProfile
			 listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)
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

		listOfCommunityLocations = GeoLocationOfCommunity.findAllByAppForm(appForm)
		
		listOfContactPerson = ContactPerson.findAllByApplicationForm(appForm)
		
		List entityTypes = ['Government Agency' , 'Institution', 'Company/Industry']
		List purposeList = ['Research', 'Bio-survey and bio-utilization', 'Commercial utilization']
		def natureOfReources = ['Plant', 'Animal', 'Micro-organism']

		def args = [template: "form1pdf2", model:[appForm:appForm,companyAgentProfile:companyAgentProfile,listOfCompanyData:listOfCompanyData,
			entityTypes:entityTypes,formType:formType,bioResourceSize:listOfBioResources?.size(),geoLocationSize:listOfLocations.size(),
			listofFormData:listofFormData,sizeoflist:listofFormData?.size(),agentProfile:agentprofile,listOfLocations:listOfLocations,
				listOfBioResources:listOfBioResources,natureOfReources:natureOfReources,listOfCommunityLocations:listOfCommunityLocations,
				geoLocOfCommSize:listOfCommunityLocations?.size(),listOfContactPerson:listOfContactPerson,contactPersonSize:listOfContactPerson?.size(),
				purposeList:purposeList,quesAnswerMap:quesAnswerMap,quesCategory:quesCategory,csrfPreventionSalt:csrfPreventionSalt
		]]
		
		return args
	}
	
	def previewForm2(GrailsParameterMap params){

		def appForm,companyAgentProfile
		def formType = 'Form2'
		
		appForm = ApplicationForm1.get(params?.id)
		
		if(appForm?.agentProfile?.isCompanyAgent == true){
			companyAgentProfile = appForm?.agentProfile
		}

		def listofFormData=[]
		def listOfLocations = [], listOfCommunityLocations=[], listOfContactPerson=[], listOfCompanyData=[]
		def listOfBioResources
		def agentprofile
		if(appForm != null){
			listofFormData = IndividualProfile.findAllByApplicationForm1(appForm)
			listOfCompanyData = CompanyProfile.findAllByApplicationForm(appForm)
			agentprofile = appForm?.agentProfile
			 listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)
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

		listOfCommunityLocations = GeoLocationOfCommunity.findAllByAppForm(appForm)
		
		listOfContactPerson = ContactPerson.findAllByApplicationForm(appForm)
		
		List entityTypes = ['Government Agency' , 'Institution', 'Company/Industry']
		List purposeList = ['Research', 'Bio-survey and bio-utilization', 'Commercial utilization']
		def natureOfReources = ['Plant', 'Animal', 'Micro-organism']

		def args = [template: "form2pdf2", model:[appForm:appForm,companyAgentProfile:companyAgentProfile,listOfCompanyData:listOfCompanyData,entityTypes:entityTypes,formType:formType,bioResourceSize:listOfBioResources?.size(),geoLocationSize:listOfLocations.size(),
			listofFormData:listofFormData,sizeoflist:listofFormData?.size(),agentProfile:agentprofile,listOfLocations:listOfLocations,
				listOfBioResources:listOfBioResources,natureOfReources:natureOfReources,listOfCommunityLocations:listOfCommunityLocations,
				geoLocOfCommSize:listOfCommunityLocations?.size(),listOfContactPerson:listOfContactPerson,contactPersonSize:listOfContactPerson?.size(),
				purposeList:purposeList,quesAnswerMap:quesAnswerMap,quesCategory:quesCategory
		]]
		
		return args
	}
	
	def previewForm3(GrailsParameterMap params){
		def appForm,companyAgentProfile
		def formType = 'Form3'

		appForm = ApplicationForm1.get(params?.id)
		
		if(appForm?.agentProfile?.isCompanyAgent == true){
			companyAgentProfile = appForm?.agentProfile
		}

		def listofFormData=[]
		def listOfLocations = [], listOfCommunityLocations=[], listOfContactPerson=[], listOfCompanyData=[]
		def listOfBioResources,listOfIPRDetails,listOfTransactionMade
		def agentprofile
		if(appForm != null){
			listofFormData = IndividualProfile.findAllByApplicationForm1(appForm)
			listOfCompanyData = CompanyProfile.findAllByApplicationForm(appForm)
			agentprofile = appForm?.agentProfile
			 listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)
			 
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

		listOfCommunityLocations = GeoLocationOfCommunity.findAllByAppForm(appForm)
		
		listOfContactPerson = ContactPerson.findAllByApplicationForm(appForm)
		
		listOfTransactionMade = Transaction.findAllByIsPaymentMade(true)
		
		List entityTypes = ['Government Agency' , 'Institution', 'Company/Industry']
		List purposeList = ['Research', 'Bio-survey and bio-utilization', 'Commercial utilization']
		def natureOfReources = ['Plant', 'Animal', 'Micro-organism']

		def args = [template: "form3pdf2", model:[listOfIPRDetails:listOfIPRDetails,appForm:appForm,companyAgentProfile:companyAgentProfile,listOfCompanyData:listOfCompanyData,entityTypes:entityTypes,formType:formType,bioResourceSize:listOfBioResources?.size(),geoLocationSize:listOfLocations.size(),
			listofFormData:listofFormData,sizeoflist:listofFormData?.size(),agentProfile:agentprofile,listOfLocations:listOfLocations,
				listOfBioResources:listOfBioResources,natureOfReources:natureOfReources,listOfCommunityLocations:listOfCommunityLocations,
				geoLocOfCommSize:listOfCommunityLocations?.size(),
				purposeList:purposeList,quesAnswerMap:quesAnswerMap,quesCategory:quesCategory,listOfTransactionMade:listOfTransactionMade
		]]
		
		return args
	}
	
    def previewForm4(GrailsParameterMap params){
		
		
		println "inside create pdf=="+params
		
		def appForm,companyAgentProfile
		def formType = 'Form4'

		appForm = ApplicationForm1.get(params?.appFormId)
		
		if(appForm?.agentProfile?.isCompanyAgent == true){
			companyAgentProfile = appForm?.agentProfile
		}

		def listofFormData=[],listOfThirdParty=[]
		def listOfLocations = [], listOfCommunityLocations=[], listOfContactPerson=[], listOfCompanyData=[]
		def listOfBioResources
		def agentprofile
		if(appForm != null){
			listofFormData = IndividualProfile.findAllByApplicationForm1(appForm)
			listOfCompanyData = CompanyProfile.findAllByApplicationForm(appForm)
			agentprofile = appForm?.agentProfile
			 listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)
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

		listOfCommunityLocations = GeoLocationOfCommunity.findAllByAppForm(appForm)
		
		listOfContactPerson = ContactPerson.findAllByApplicationForm(appForm)
		
		listOfThirdParty = ThirdParty.findAllByApplicationForm(appForm)
		
		
		List entityTypes = ['Government Agency' , 'Institution', 'Company/Industry']
		List purposeList = ['Research', 'Bio-survey and bio-utilization', 'Commercial utilization']
		def natureOfReources = ['Plant', 'Animal', 'Micro-organism']

		def args = [template: "form4pdf2", model:[appForm:appForm,companyAgentProfile:companyAgentProfile,listOfCompanyData:listOfCompanyData,entityTypes:entityTypes,formType:formType,bioResourceSize:listOfBioResources?.size(),geoLocationSize:listOfLocations.size(),
			listofFormData:listofFormData,sizeoflist:listofFormData?.size(),agentProfile:agentprofile,listOfLocations:listOfLocations,
				listOfBioResources:listOfBioResources,natureOfReources:natureOfReources,listOfCommunityLocations:listOfCommunityLocations,
				geoLocOfCommSize:listOfCommunityLocations?.size(),listOfContactPerson:listOfContactPerson,contactPersonSize:listOfContactPerson?.size(),
				purposeList:purposeList,quesAnswerMap:quesAnswerMap,quesCategory:quesCategory,listOfThirdParty:listOfThirdParty
		]]
		
		return args
		
	}
	
	def previewFormC(GrailsParameterMap params){
		println "In preview form C%%%%%%%%%%%%%% "+params

		def appForm,companyAgentProfile,bioRes,bioResourceLocations
		def formType = 'Form1'
		def csrfPreventionSalt = params?.csrfPreventionSalt
		appForm = ApplicationForm1.get(params?.appFormId)
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
		
		def applicationform = ApplicationForm1.get(appForm?.id)
		def args = [template: "formCpdf", model:[appForm:appForm,formType:formType,csrfPreventionSalt:csrfPreventionSalt,listOfDepositionOfMicroOrganism:listOfDepositionOfMicroOrganism,listOfScientistName:listOfScientistName,bioRes:bioRes,
			listOfContactDetailsOfRepository:listOfContactDetailsOfRepository,applicationform:applicationform,accessionNumber:accessionNumber
		]]
		
		return args
	}
	
}
