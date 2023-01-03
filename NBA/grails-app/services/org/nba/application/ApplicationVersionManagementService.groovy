package org.nba.application

import grails.transaction.Transactional

import org.nba.resource.BiologicalResource
import org.nba.resource.GeoLocationOfBioResource
import org.nba.resource.GeoLocationOfCommunity
import org.nba.resource.IPRDetail
import org.nba.resource.ThirdParty
import org.nba.versions.SetVersionStatus
import org.nba.versions.VersionAgentProfile
import org.nba.versions.VersionApplicationForm1
import org.nba.versions.VersionBiologicalResource
import org.nba.versions.VersionCompanyProfile
import org.nba.versions.VersionContactDetailsOfRepository
import org.nba.versions.VersionContactPerson
import org.nba.versions.VersionDepositionOfMicroOrganism
import org.nba.versions.VersionFormB
import org.nba.versions.VersionFormBFundingAgency
import org.nba.versions.VersionGeoLocationOfBioResource
import org.nba.versions.VersionGeoLocationOfCommunity
import org.nba.versions.VersionIPRDetail
import org.nba.versions.VersionIndianGovtInst
import org.nba.versions.VersionIndianResearcher
import org.nba.versions.VersionIndividualProfile
import org.nba.versions.VersionResearchDuration
import org.nba.versions.VersionThirdParty
import org.nba.versions.SetVersionStatus.VersionStatus


@Transactional
class ApplicationVersionManagementService {
    
	 def springSecurityService
 
	def copyContentForVersioning(ApplicationForm1 appDetails, String category,String status) {

		VersionApplicationForm1 versionApplicationInstance = new VersionApplicationForm1()
		
		
		 versionApplicationInstance.answer = appDetails?.answer 
		
		versionApplicationInstance.declarationForm = appDetails?.declarationForm
		versionApplicationInstance.declarationFormName = appDetails?.declarationFormName
		versionApplicationInstance.createdOn = appDetails?.createdOn
		versionApplicationInstance.submittedOn = appDetails?.submittedOn
		
		versionApplicationInstance.feedback = appDetails?.feedback
		versionApplicationInstance.appNumber = appDetails?.appNumber
		versionApplicationInstance.isDeclarationDigitallySigned = appDetails?.isDeclarationDigitallySigned
		versionApplicationInstance.submitCheck = appDetails?.submitCheck
		versionApplicationInstance.selfAuthorizedPerson = appDetails?.selfAuthorizedPerson
		versionApplicationInstance.isNoForTraditional = appDetails?.isNoForTraditional
	
		//form 1 related info
		versionApplicationInstance.traditionalKnowledgeDesc = appDetails?.traditionalKnowledgeDesc
		versionApplicationInstance.purpose = appDetails?.purpose
		 versionApplicationInstance.nature = appDetails?.nature
		 versionApplicationInstance.otherInfo = appDetails?.otherInfo
		 versionApplicationInstance.contactPerson = appDetails?.contactPerson
		 versionApplicationInstance.purposeOfProposal = appDetails?.purposeOfProposal
		 versionApplicationInstance.briefDescription = appDetails?.resultsOfResearch
		 versionApplicationInstance.isRisky = appDetails?.isRisky
		 versionApplicationInstance.instituteParticipation = appDetails?.instituteParticipation
		 versionApplicationInstance.detailsOfInstitute = appDetails?.detailsOfInstitute
		 versionApplicationInstance.letterOfintent = appDetails?.letterOfintent
		 versionApplicationInstance.letterOfIntentName = appDetails?.letterOfIntentName
		 versionApplicationInstance.isBenefitSharing = appDetails?.isBenefitSharing
		 versionApplicationInstance.sharingDoc = appDetails?.sharingDoc
		 versionApplicationInstance.sharingDocName = appDetails?.sharingDocName
		 versionApplicationInstance.riskInvolved = appDetails?.riskInvolved
		 versionApplicationInstance.conditionOfAbs = appDetails?.conditionOfAbs
		 versionApplicationInstance.approvalOfNba = appDetails?.approvalOfNba
		 versionApplicationInstance.recordsWithTheNba = appDetails?.recordsWithTheNba
		 versionApplicationInstance.infromationTrue = appDetails?.infromationTrue
		 versionApplicationInstance.payBenefitSharing = appDetails?.payBenefitSharing
		 versionApplicationInstance.isMonetary = appDetails?.isMonetary
		 versionApplicationInstance.isTradingPurpose = appDetails?.isTradingPurpose

		versionApplicationInstance.resultsOfResearch = appDetails?.resultsOfResearch
		versionApplicationInstance.nbaApprovalFile = appDetails?.nbaApprovalFile
		versionApplicationInstance.nbaApprovalFileName = appDetails?.nbaApprovalFileName
		versionApplicationInstance.bonafideLetter = appDetails?.bonafideLetter
		versionApplicationInstance.bonafideLetterName = appDetails?.bonafideLetterName
		versionApplicationInstance.traditionalKnowledgeSource = appDetails?.traditionalKnowledgeSource
		versionApplicationInstance.useofResearchResults = appDetails?.useofResearchResults
		versionApplicationInstance.benefitsToTheApplicant = appDetails?.benefitsToTheApplicant
		versionApplicationInstance.benefitsToTheIndividualOrOrganization =appDetails?.benefitsToTheIndividualOrOrganization
		versionApplicationInstance.agreementLetter = appDetails?.agreementLetter
		versionApplicationInstance.agreementLetterName = appDetails?.agreementLetterName
		versionApplicationInstance.mouFile = appDetails?.mouFile
		versionApplicationInstance.mouFileName = appDetails?.mouFileName
		versionApplicationInstance.collaborationDetails = appDetails?.collaborationDetails
		versionApplicationInstance.isApprovalOfNbaObtained  = appDetails?.isApprovalOfNbaObtained
		versionApplicationInstance.consentObtained  = appDetails?.consentObtained
		versionApplicationInstance.isResearchParticipation = appDetails?.isResearchParticipation
		versionApplicationInstance.isAgreementOrMou = appDetails?.isAgreementOrMou
		
		 versionApplicationInstance.titleOfIPR = appDetails?.titleOfIPR
		 versionApplicationInstance.abstractOfIPR = appDetails?.abstractOfIPR
		 versionApplicationInstance.applicationNo = appDetails?.applicationNo
		 versionApplicationInstance.dateOfApproval= appDetails?.dateOfApproval
		 versionApplicationInstance.reasonOfDisapproval = appDetails?.reasonOfDisapproval
		 versionApplicationInstance.bioResourcesObtainedFromOutsideIndia = appDetails?.bioResourcesObtainedFromOutsideIndia
		 versionApplicationInstance.approvalOfCountriesObtained =appDetails?.approvalOfCountriesObtained
	     versionApplicationInstance.isIPApplicationFiled = appDetails?.isIPApplicationFiled
		 versionApplicationInstance.isApprovalOfNbaObtainedForm3 =  appDetails?.isApprovalOfNbaObtainedForm3
		 versionApplicationInstance.isBioObtainedOutsideIndia = appDetails?.isBioObtainedOutsideIndia
		 versionApplicationInstance.isApprovalOfCountryObtained =  appDetails?.isApprovalOfCountryObtained 
		 versionApplicationInstance.isRAndDParticipationForm3 = appDetails?.isRAndDParticipationForm3
		 versionApplicationInstance.traditionalKnowledgeUsedInInvention = appDetails?.traditionalKnowledgeUsedInInvention
		 versionApplicationInstance.isTraditionalKnowledgeApplicable = appDetails?.isTraditionalKnowledgeApplicable
		 versionApplicationInstance.reasonOFNotObtainedApproval = appDetails?.reasonOFNotObtainedApproval
		
		 versionApplicationInstance.instituteAddress = appDetails?.instituteAddress
		 versionApplicationInstance.telephone = appDetails?.telephone
		 versionApplicationInstance.fax = appDetails?.fax
		 versionApplicationInstance.website = appDetails?.website
		 versionApplicationInstance.email = appDetails?.email
		 versionApplicationInstance.thirdPartyTransferPurpose = appDetails?.thirdPartyTransferPurpose
		 versionApplicationInstance.benefitsToTheThirdParty = appDetails?.benefitsToTheThirdParty
		
		 versionApplicationInstance.detailsOfBioResOrTradKnow = appDetails?.detailsOfBioResOrTradKnow
		 versionApplicationInstance.isbenefitSharingDetailImplemented = appDetails?.isbenefitSharingDetailImplemented
		 versionApplicationInstance.isIndividualOrEntity = appDetails?.isIndividualOrEntity
		 versionApplicationInstance.purposeOfProposalForm4 = appDetails?.purposeOfProposalForm4
		 versionApplicationInstance.isAgreementBwApplicantAndThirdParty = appDetails?.isAgreementBwApplicantAndThirdParty
		 versionApplicationInstance. benefitMechanism = appDetails?.benefitMechanism
		 versionApplicationInstance.benefitsOutOfThirdPartyTransfer = appDetails?.benefitsOutOfThirdPartyTransfer
		 versionApplicationInstance.mechanismOutOfThirdPartyTransfer = appDetails?.mechanismOutOfThirdPartyTransfer
		 versionApplicationInstance.otherRelevantInfo = appDetails?.otherRelevantInfo
		 versionApplicationInstance.agreementBtwnApplicantAndThirdParty = appDetails?.agreementBtwnApplicantAndThirdParty
		 versionApplicationInstance.agreementBtwnApplicantAndThirdPartyFileName = appDetails?.agreementBtwnApplicantAndThirdPartyFileName
		 versionApplicationInstance.isAddressOfContactPerson = appDetails?.isAddressOfContactPerson
		 versionApplicationInstance.detailsOfIndividualOrOrganisation = appDetails?.detailsOfIndividualOrOrganisation
		 versionApplicationInstance.loginAuthTextEdits = appDetails?.loginAuthTextEdits
		
		
		 versionApplicationInstance.declarationBySupervisorCopy = appDetails?.declarationBySupervisorCopy
		 versionApplicationInstance.declarationBySupervisorCopyFileName = appDetails?.declarationBySupervisorCopyFileName
		 versionApplicationInstance.declarationByRecipientCopy = appDetails?.declarationByRecipientCopy
		 versionApplicationInstance.declarationByRecipientCopyFileName = appDetails?.declarationByRecipientCopyFileName
		 versionApplicationInstance.declarationByApplicantOnNationalityCopy = appDetails?.declarationByApplicantOnNationalityCopy
		 versionApplicationInstance.declarationByApplicantOnNationalityCopyFileName = appDetails?.declarationByApplicantOnNationalityCopyFileName
		
		 versionApplicationInstance.emergencyDetails = appDetails?.emergencyDetails
		 versionApplicationInstance.researchDurationFrom = appDetails?.researchDurationFrom
		 versionApplicationInstance.researchDurationTo = appDetails?.researchDurationTo
		 versionApplicationInstance.typeOfExercise = appDetails?.typeOfExercise
		 versionApplicationInstance.reasonsForSending = appDetails?.reasonsForSending
		 versionApplicationInstance.numOfTimesOfSending = appDetails?.numOfTimesOfSending
		
		 versionApplicationInstance.benefitSharingProofFile = appDetails?.benefitSharingProofFile
		 versionApplicationInstance.benefitSharingProofFilename = appDetails?.benefitSharingProofFilename
		
		

		versionApplicationInstance.submittedBy = appDetails?.submittedBy
		versionApplicationInstance.applicationForm = appDetails
		versionApplicationInstance.verFormType = category
		versionApplicationInstance.verFormStatus = status
		if(!versionApplicationInstance.save(flush:true)){
			versionApplicationInstance.errors.each {print it}
		}
		
		if(appDetails.individualProfiles){
			def saveIndividualDetails = copyIndividualProfileDetails(appDetails, versionApplicationInstance)
		}
        if(appDetails.companyProfiles){
		def saveCompanyDetails = copyCompanyProfileDetails(appDetails, versionApplicationInstance)
		}
		if(appDetails.biologicalResources){
		def saveBiologicalResources = copyBiologicalResourceDetails(appDetails, versionApplicationInstance)
		}
		if(appDetails.indianResearcher){
			def saveIndianResearcher = copyIndianResearcherDetails(appDetails, versionApplicationInstance)
		}
		if(appDetails.indianGovtInst){
			def saveIndianGovtInstitutes = copyIndianGovtInstitutesDetails(appDetails, versionApplicationInstance)
		}
		if(appDetails.thirdParty){
			def saveThirdParty = copyThirdPartyDetails(appDetails, versionApplicationInstance)
		}
		if(appDetails.locations){
			def savegeoCommunity = copyGeoCommunityDetails(appDetails, versionApplicationInstance)
		}
		if(appDetails.iprDetails){
			def saveIprDetails = copyIprDetails(appDetails, versionApplicationInstance)
		}
		if(appDetails.contactPersons){
			def saveContactPerson = copyContactPersonDetails(appDetails, versionApplicationInstance)
		}
		if(appDetails.depostionOfMicroOrganism){
		def saveDepostionOfMicro = copyDepostionOfMicroDetails(appDetails, versionApplicationInstance)	
		}
		if(appDetails.repositoryContactDetails){
			def saveRepositoryContact = copyRepositoryContactdetails(appDetails, versionApplicationInstance)
		}
		if(appDetails.formBFundingAgency){
			def saveFundingAgency = copyFormBFundingAgency(appDetails, versionApplicationInstance)
		}
		if(appDetails.formBItems){
			def saveFormBItems = copyFormBItemDetails(appDetails, versionApplicationInstance)
		}
		if(appDetails.researchDurations){
			appDetails.researchDurations.each { res->
			
				def versionResearchDurationInstance = new VersionResearchDuration();	
				
				 versionResearchDurationInstance.typeOfExercise = res?.typeOfExercise
				 versionResearchDurationInstance.reasonsForSending = res?.reasonsForSending
				 versionResearchDurationInstance.numOfTimesOfSending = res?.numOfTimesOfSending
				 if(!versionResearchDurationInstance.save(flush:true)){versionResearchDurationInstance.errors.each{print it}}
			}

		}
		
		
		return versionApplicationInstance;
	}
	
	

	def copyCompanyProfileDetails(ApplicationForm1 appDetails,VersionApplicationForm1 versionApplicationInstance){
		if(appDetails.companyProfiles){
			def companyDetails = CompanyProfile.where {applicationForm == appDetails}.list()

			def versionCompanyInstance = new VersionCompanyProfile()
			companyDetails.each{it->
				versionCompanyInstance.applicationForm = versionApplicationInstance

				versionCompanyInstance.entityName = it?.entityName
				versionCompanyInstance.entityType = it?.entityType
				versionCompanyInstance.nationality = it?.nationality
				versionCompanyInstance.address1 = it?.address1
				versionCompanyInstance.address2 = it?.address2
				versionCompanyInstance.address3 = it?.address3
				versionCompanyInstance.city = it?.city
				versionCompanyInstance.province = it?.province
				versionCompanyInstance.pincode = it?.pincode
				versionCompanyInstance.country = it?.country
				versionCompanyInstance.turnover = it?.turnover
				versionCompanyInstance.mobile = it?.mobile
				versionCompanyInstance.phone = it?.phone
				versionCompanyInstance.email = it?.email
				versionCompanyInstance.website = it?.website
				versionCompanyInstance.registrationDoc = it?.registrationDoc
				versionCompanyInstance.registrationDocName = it?.registrationDocName
				versionCompanyInstance.passportCopy = it?.passportCopy
				versionCompanyInstance.passportCopyFileName = it?.passportCopyFileName
				versionCompanyInstance.authorizationLetter = it?.authorizationLetter
				versionCompanyInstance.authorizationLetterFileName = it?.authorizationLetterFileName

				versionCompanyInstance.title = it?.title
				versionCompanyInstance.firstName = it?.firstName
				versionCompanyInstance.middleName = it?.middleName
				versionCompanyInstance.lastName = it?.lastName
				versionCompanyInstance.designation = it?.designation
				versionCompanyInstance.personMobile = it?.personMobile
				versionCompanyInstance.personEmail = it?.personEmail
				versionCompanyInstance.businessNature = it?.businessNature
				versionCompanyInstance.authRepresentativeIdSelect = it?.authRepresentativeIdSelect
				versionCompanyInstance.idNum = it?.idNum


				if(!versionCompanyInstance.save(flush:true)){
					versionCompanyInstance.errors.each{ println it }
				}
			}
			
			def applicationAgentProfile = appDetails?.agentProfile
			if(applicationAgentProfile != null){
				def versionAgentProfileInstance = new VersionAgentProfile()
				versionAgentProfileInstance.title = applicationAgentProfile?.title
				versionAgentProfileInstance.profile = applicationAgentProfile?.profile
				versionAgentProfileInstance.firstName = applicationAgentProfile?.firstName
				versionAgentProfileInstance.middleName = applicationAgentProfile?.middleName
				versionAgentProfileInstance.lastName = applicationAgentProfile?.lastName
				versionAgentProfileInstance.nationality = applicationAgentProfile?.nationality
				versionAgentProfileInstance.address1 = applicationAgentProfile?.address1
				versionAgentProfileInstance.address2 = applicationAgentProfile?.address2
				versionAgentProfileInstance.address3 = applicationAgentProfile?.address3
				versionAgentProfileInstance.city = applicationAgentProfile?.city
				versionAgentProfileInstance.province = applicationAgentProfile?.province
				versionAgentProfileInstance.pincode = applicationAgentProfile?.pincode
				versionAgentProfileInstance.mobile = applicationAgentProfile?.mobile
				versionAgentProfileInstance.phone = applicationAgentProfile?.phone
				versionAgentProfileInstance.email = applicationAgentProfile?.email
				versionAgentProfileInstance.idProof = applicationAgentProfile?.idProof
				versionAgentProfileInstance.idProofFileName = applicationAgentProfile?.idProofFileName
				versionAgentProfileInstance.passportCopy = applicationAgentProfile?.passportCopy
				versionAgentProfileInstance.passportCopyFileName = applicationAgentProfile?.passportCopyFileName
				versionAgentProfileInstance.authorizationLetter = applicationAgentProfile?.authorizationLetter
				versionAgentProfileInstance.authorizationLetterFileName = applicationAgentProfile?.authorizationLetterFileName
				versionAgentProfileInstance.isCompanyAgent = true

				if(!versionAgentProfileInstance.save(flush:true)){
					versionAgentProfileInstance.errors.each {print it}
				}
				versionApplicationInstance.agentProfile = versionAgentProfileInstance
				if(versionApplicationInstance.save(flush:true)){
					versionApplicationInstance.errors.allErrors.each {print it}
				}
			}
		}
		return versionApplicationInstance
	}

	
	def copyIndividualProfileDetails(ApplicationForm1 appDetails , VersionApplicationForm1 versionApplicationInstance){
		
		if(appDetails?.individualProfiles){
			def individualDetailsInstance = IndividualProfile.where{applicationForm1 == appDetails}.list()
			

			individualDetailsInstance.each{ it->
				
		VersionIndividualProfile versionIndividualInstace = new VersionIndividualProfile()
				
				versionIndividualInstace.profile = it?.profile
				versionIndividualInstace.firstName = it?.firstName
				versionIndividualInstace.middleName = it?.middleName
				versionIndividualInstace.lastName = it?.lastName
				versionIndividualInstace.nationality = it?.nationality
				versionIndividualInstace.address1 = it?.address1
				versionIndividualInstace.address2 = it?.address2
				versionIndividualInstace.address3 = it?.address3
				versionIndividualInstace.city = it?.city
				versionIndividualInstace.province = it?.province
				versionIndividualInstace.pincode = it?.pincode
				versionIndividualInstace.country = it?.country
				versionIndividualInstace.mobile = it?.mobile
				versionIndividualInstace.phone = it?.phone
				versionIndividualInstace.email = it?.email
				versionIndividualInstace.idProof = it?.idProof
				versionIndividualInstace.idProofFileName = it?.idProofFileName
				versionIndividualInstace.passportCopy = it?.passportCopy
				versionIndividualInstace.passportCopyFileName = it?.passportCopyFileName
				versionIndividualInstace.authorizationLetter = it?.authorizationLetter
				versionIndividualInstace.authorizationLetterFileName = it?.authorizationLetterFileName
				versionIndividualInstace.idProofSelect = it?.idProofSelect
				versionIndividualInstace.idNum = it?.idNum
				versionIndividualInstace.passportSelect = it?.passportSelect
				versionIndividualInstace.passportNum = it?.passportNum
				versionIndividualInstace.authorizationSelect = it?.authorizationSelect
				versionIndividualInstace.authorizationNo = it?.authorizationNo
				versionIndividualInstace.applicationForm1 = versionApplicationInstance
				
				if(!versionIndividualInstace.save(flush:true)){
					versionIndividualInstace.errors.allErrors.each {print it}
				}
				
			}
			def applicationAgentProfile = appDetails?.agentProfile
			if(applicationAgentProfile != null){
				def versionAgentProfileInstance = new VersionAgentProfile()
				versionAgentProfileInstance.title = applicationAgentProfile?.title
				versionAgentProfileInstance.profile = applicationAgentProfile?.profile
				versionAgentProfileInstance.firstName = applicationAgentProfile?.firstName
				versionAgentProfileInstance.middleName = applicationAgentProfile?.middleName
				versionAgentProfileInstance.lastName = applicationAgentProfile?.lastName
				versionAgentProfileInstance.nationality = applicationAgentProfile?.nationality
				versionAgentProfileInstance.address1 = applicationAgentProfile?.address1
				versionAgentProfileInstance.address2 = applicationAgentProfile?.address2
				versionAgentProfileInstance.address3 = applicationAgentProfile?.address3
				versionAgentProfileInstance.city = applicationAgentProfile?.city
				versionAgentProfileInstance.province = applicationAgentProfile?.province
				versionAgentProfileInstance.pincode = applicationAgentProfile?.pincode
				versionAgentProfileInstance.mobile = applicationAgentProfile?.mobile
				versionAgentProfileInstance.phone = applicationAgentProfile?.phone
				versionAgentProfileInstance.email = applicationAgentProfile?.email
				versionAgentProfileInstance.idProof = applicationAgentProfile?.idProof
				versionAgentProfileInstance.idProofFileName = applicationAgentProfile?.idProofFileName
				versionAgentProfileInstance.passportCopy = applicationAgentProfile?.passportCopy
				versionAgentProfileInstance.passportCopyFileName = applicationAgentProfile?.passportCopyFileName
				versionAgentProfileInstance.authorizationLetter = applicationAgentProfile?.authorizationLetter
				versionAgentProfileInstance.authorizationLetterFileName = applicationAgentProfile?.authorizationLetterFileName
				versionAgentProfileInstance.isIndividualAgent = true

				if(!versionAgentProfileInstance.save(flush:true)){
					versionAgentProfileInstance.errors.each {print it}
				}
				versionApplicationInstance.agentProfile = versionAgentProfileInstance
				if(versionApplicationInstance.save(flush:true)){
					versionApplicationInstance.errors.allErrors.each {print it}
				}
			}
		}
		return	versionApplicationInstance
	}
	
	def copyBiologicalResourceDetails(ApplicationForm1 appDetails, VersionApplicationForm1 versionApplicationInstance){

		def biologicalResourceDetails = BiologicalResource.where {applicationForm == appDetails}.list()


		biologicalResourceDetails.each {it->

			def versionBiologicalResourceInstance = new VersionBiologicalResource()

			versionBiologicalResourceInstance.name = it?.name
			versionBiologicalResourceInstance.commonName = it?.commonName
			versionBiologicalResourceInstance.scientificName = it?.scientificName
			versionBiologicalResourceInstance.nature = it?.nature
			versionBiologicalResourceInstance.biologicalResource = it?.biologicalResource
			versionBiologicalResourceInstance.quantity = it?.quantity
			versionBiologicalResourceInstance.qtyUnit = it?.qtyUnit
			versionBiologicalResourceInstance.source = it?.source

			versionBiologicalResourceInstance.fromTime = it?.fromTime
			versionBiologicalResourceInstance.toTime = it?.toTime
			versionBiologicalResourceInstance.traditionalUse = it?.traditionalUse
			versionBiologicalResourceInstance.accessIntention = it?.accessIntention
			versionBiologicalResourceInstance.bioResouceTraditionalKnowledge = it?.bioResouceTraditionalKnowledge
			versionBiologicalResourceInstance.ratePerUnit = it?.ratePerUnit
			versionBiologicalResourceInstance.stateBiodeversityBoard = it?.stateBiodeversityBoard
			versionBiologicalResourceInstance.prospectiveBuyers = it?.prospectiveBuyers
			versionBiologicalResourceInstance.scientistName = it?.scientistName
			versionBiologicalResourceInstance.applicationForm = versionApplicationInstance

			if(!versionBiologicalResourceInstance.save(flush:true)){
				versionBiologicalResourceInstance.errors.allErrors.each {print it}
			}
			if(it?.locations){
				def giolocationDetails = GeoLocationOfBioResource.where{bioResource == biologicalResourceDetails}.list()
				giolocationDetails.each{its->


					def versionGioLocationInstance = new VersionGeoLocationOfBioResource()

					versionGioLocationInstance.village = its?.village
					versionGioLocationInstance.town = its?.village
					versionGioLocationInstance.district = its?.village
					versionGioLocationInstance.state = its?.village
					versionGioLocationInstance.traderName = its?.village
					versionGioLocationInstance.traderContactDetails = its?.village
					versionGioLocationInstance.source = its?.village
					versionGioLocationInstance.bioResource = versionBiologicalResourceInstance

					if(!versionGioLocationInstance.save()){
						versionGioLocationInstance.errors.allErrors.each{print it}
					}

				}
			}
		}
	return versionApplicationInstance
	}
	
	def copyIndianResearcherDetails(ApplicationForm1 appDetails, VersionApplicationForm1 versionApplicationInstance){
		
		def indianResearcherDetails = IndianResearcher.where{applicationForm1 == appDetails}.list()
		
		indianResearcherDetails.each{it->
		def versionIndianResearcher = new VersionIndianResearcher()
		
		
		versionIndianResearcher.title  = it?.title
		versionIndianResearcher.profile  = it?.profile
		versionIndianResearcher.gender  = it?.gender
		versionIndianResearcher.firstName  = it?.firstName
		versionIndianResearcher.middleName  = it?.middleName
	    versionIndianResearcher.lastName  = it?.lastName
		versionIndianResearcher.nationality  = it?.nationality
		versionIndianResearcher.address1  = it?.address1
		versionIndianResearcher.address2  = it?.address2
		versionIndianResearcher.address3  = it?.address3
		versionIndianResearcher.samePresentAddress  = it?.samePresentAddress
	    versionIndianResearcher.presentAddress1  = it?.presentAddress1
		versionIndianResearcher.presentAddress2  = it?.presentAddress2
		versionIndianResearcher.presentAddress3  = it?.presentAddress3
		versionIndianResearcher.presentCity  = it?.presentCity
		versionIndianResearcher.presentProvince  = it?.presentProvince
		versionIndianResearcher.presentPincode  = it?.presentPincode
		versionIndianResearcher.presentCountry  = it?.presentCountry
		versionIndianResearcher.presentMobile  = it?.presentMobile
		versionIndianResearcher.presentPhone  = it?.presentPhone
		versionIndianResearcher.presentEmail  = it?.presentEmail
		versionIndianResearcher.city  = it?.city
		versionIndianResearcher.province  = it?.province
		versionIndianResearcher.pincode  = it?.pincode
		versionIndianResearcher.country  = it?.country
	
		versionIndianResearcher.mobile  = it?.mobile
		versionIndianResearcher.phone  = it?.phone
		versionIndianResearcher.email  = it?.email
	
		versionIndianResearcher.addressproofLetter  = it?.addressproofLetter
		versionIndianResearcher.addressproofLetterFileName  = it?.addressproofLetterFileName
		versionIndianResearcher.addressproofSelect  = it?.addressproofSelect
		versionIndianResearcher.addressproofNo  = it?.addressproofNo
		
		versionIndianResearcher.authorizationSelect  = it?.authorizationSelect
	    versionIndianResearcher.authorizationNo  = it?.authorizationNo
		versionIndianResearcher.entityName  = it?.entityName
		versionIndianResearcher.authRepresentativeIdSelect  = it?.authRepresentativeIdSelect
		versionIndianResearcher.designation  = it?.designation
		versionIndianResearcher.idNum  = it?.idNum
		
		versionIndianResearcher.applicationForm1 = versionApplicationInstance
		
		if(!versionIndianResearcher.save(flush:true)){
			versionIndianResearcher.errors.allErrors.each {print it}
			
			}
		return versionApplicationInstance
		
		
		}
	}
	
	def copyIndianGovtInstitutesDetails(ApplicationForm1 appDetails, VersionApplicationForm1 versionApplicationInstance){
		
		def govtInstituteDetails = IndianGovtInst.where{applicationForm1 == appDetails}.list() 
		govtInstituteDetails.each{it->
		
			def versionGovtInstituteInstance = new VersionIndianGovtInst()
		
		versionGovtInstituteInstance.govtInstName = it?.govtInstName
		versionGovtInstituteInstance.profile = it?.profile
		versionGovtInstituteInstance.address1 = it?.address1
		versionGovtInstituteInstance.address2 = it?.address2
		versionGovtInstituteInstance.address3 = it?.address3
		versionGovtInstituteInstance.samePresentAddress = it?.samePresentAddress
		versionGovtInstituteInstance.presentAddress1 = it?.presentAddress1
		versionGovtInstituteInstance.presentAddress2 = it?.presentAddress2
		versionGovtInstituteInstance.presentAddress3 = it?.presentAddress3
		versionGovtInstituteInstance.presentCity = it?.presentCity
		versionGovtInstituteInstance.presentProvince = it?.presentProvince
		versionGovtInstituteInstance.presentPincode = it?.presentPincode
		versionGovtInstituteInstance.presentCountry = it?.presentCountry
		versionGovtInstituteInstance.presentMobile = it?.presentMobile
		versionGovtInstituteInstance.presentPhone = it?.presentPhone
		versionGovtInstituteInstance.presentEmail = it?.presentEmail
		versionGovtInstituteInstance.city = it?.city
		versionGovtInstituteInstance.province = it?.province
		versionGovtInstituteInstance.pincode = it?.pincode
		versionGovtInstituteInstance.country = it?.country
		versionGovtInstituteInstance.mobile = it?.mobile
		versionGovtInstituteInstance.phone = it?.phone
		versionGovtInstituteInstance.email = it?.email
	
		versionGovtInstituteInstance.addressproofLetter = it?.addressproofLetter
		versionGovtInstituteInstance.addressproofLetterFileName = it?.addressproofLetterFileName
		versionGovtInstituteInstance.addressproofSelect = it?.addressproofSelect
		versionGovtInstituteInstance.addressproofNo = it?.addressproofNo
		
		versionGovtInstituteInstance.authorizationSelect = it?.authorizationSelect
		versionGovtInstituteInstance.authorizationNo = it?.authorizationNo
		versionGovtInstituteInstance.entityName = it?.entityName
		versionGovtInstituteInstance.authRepresentativeIdSelect = it?.authRepresentativeIdSelect
		versionGovtInstituteInstance.designation = it?.designation
		versionGovtInstituteInstance.idNum = it?.idNum
		versionGovtInstituteInstance.applicationForm1 = versionApplicationInstance
			
		if(!versionGovtInstituteInstance.save()){
			versionGovtInstituteInstance.errors.allErrors.each {print it}
			}
		}
	return versionApplicationInstance	
	}
	
	def copyThirdPartyDetails(ApplicationForm1 appDetails, VersionApplicationForm1 versionApplicationInstance){
		def thirdPartyDetails = ThirdParty.where {applicationForm == appDetails}.list()
		if(thirdPartyDetails != null){
			thirdPartyDetails.each {entity->
				
			def versionThirdPartyInstance = new VersionThirdParty()

				versionThirdPartyInstance.name = entity?.name
				versionThirdPartyInstance.addressForComm = entity?.addressForComm
				versionThirdPartyInstance.state = entity?.state
				versionThirdPartyInstance.pincode = entity?.pincode
				versionThirdPartyInstance.country = entity?.country
				versionThirdPartyInstance.phone = entity?.phone
				versionThirdPartyInstance.fax = entity?.fax
				versionThirdPartyInstance.website = entity?.website
				versionThirdPartyInstance.email = entity?.email
				versionThirdPartyInstance.isIndividual = entity?.isIndividual
				versionThirdPartyInstance.applicationForm = versionApplicationInstance

				if(!versionThirdPartyInstance.save(flush:true)){
					versionThirdPartyInstance.errors.allErrors.each {print it}}

			}
		}
		return versionApplicationInstance
	}
	def copyGeoCommunityDetails(ApplicationForm1 appDetails, VersionApplicationForm1 versionApplicationInstance){

		def geoCommunityDetails = GeoLocationOfCommunity.where{appForm == appDetails}.list()
		if(geoCommunityDetails != null){
			geoCommunityDetails.each { geo->
				
				def versiongeoCommunityInstance = new VersionGeoLocationOfCommunity()

				versiongeoCommunityInstance.consentObtained = geo?.consentObtained
				versiongeoCommunityInstance.communityKnowledge = geo?.communityKnowledge
				versiongeoCommunityInstance.village = geo?.village
				versiongeoCommunityInstance.town = geo?.town
				versiongeoCommunityInstance.district = geo?.district
				versiongeoCommunityInstance.state = geo?.state
				
				versiongeoCommunityInstance.appForm = versionApplicationInstance

				if(!versiongeoCommunityInstance.save(flush:true)){
					versiongeoCommunityInstance.errors.allErrors.each {print it}}
			}
		}
		return versionApplicationInstance
	}
	
	def copyIprDetails(ApplicationForm1 appDetails, VersionApplicationForm1 versionApplicationInstance){
		def iprDetails = IPRDetail.where {applicationForm == appDetails}.list()
		if(iprDetails != null){
			
			iprDetails.each { ipr->
				
				def versionIprInstance = new VersionIPRDetail()
				
				versionIprInstance.referenceNumber = ipr?.referenceNumber
				versionIprInstance.patentApplicationNo = ipr?.patentApplicationNo
				versionIprInstance.patentApplicationDate = ipr?.patentApplicationDate
				versionIprInstance.status = ipr?.status
				versionIprInstance.patentNo = ipr?.patentNo
				versionIprInstance.patentDate = ipr?.patentDate
				versionIprInstance.reasons = ipr?.reasons
				versionIprInstance.otherStatus = ipr?.otherStatus
				versionIprInstance.country = ipr?.country
				
				versionIprInstance.applicationForm = versionApplicationInstance
				
				if(!versionIprInstance.save(flush:true)){
					versionIprInstance.errors.allErrors.each { print it}
				}
				
			}
		}
		return versionApplicationInstance
	}
	
	def copyContactPersonDetails(ApplicationForm1 appDetails, VersionApplicationForm1 versionApplicationInstance){
		def contactPersonDetails = ContactPerson.where {applicationForm == appDetails}.list()
		if(contactPersonDetails != null){
			contactPersonDetails.each { cont->
				def versionContactPersonInstance = new VersionContactPerson()

				versionContactPersonInstance.contactPerson = cont?.contactPerson
				versionContactPersonInstance.nameOfContactPerson = cont?.nameOfContactPerson
				versionContactPersonInstance.addressOfContactPerson = cont?.addressOfContactPerson
				versionContactPersonInstance.emailOfContactPerson = cont?.emailOfContactPerson
				versionContactPersonInstance.mobileOfContactPerson = cont?.mobileOfContactPerson
				
				versionContactPersonInstance.applicationForm = versionApplicationInstance

				if(!versionContactPersonInstance.save(flush:true)){
					versionContactPersonInstance.errors.allErrors.each {print it}
				}
			}
		}
		return versionApplicationInstance
	}
	
	def copyDepostionOfMicroDetails(ApplicationForm1 appDetails, VersionApplicationForm1 versionApplicationInstance){
		def depostionMicroOrganismDetails = DepositionOfMicroOrganism.where {applicationForm1 == appDetails}.list()
		if(depostionMicroOrganismDetails != null){
			depostionMicroOrganismDetails.each { micro ->

				def versionMicroOrganismInstance = new VersionDepositionOfMicroOrganism()
				versionMicroOrganismInstance.nameOfDepositor = micro?.nameOfDepositor
				versionMicroOrganismInstance.address1 = micro?.address1
				versionMicroOrganismInstance.address2 = micro?.address2
				versionMicroOrganismInstance.address3 = micro?.address3
				versionMicroOrganismInstance.country = micro?.country
				versionMicroOrganismInstance.state = micro?.state
				versionMicroOrganismInstance.city = micro?.city
				versionMicroOrganismInstance.zip = micro?.zip
				versionMicroOrganismInstance.mobile = micro?.mobile
				versionMicroOrganismInstance.phone = micro?.phone
				versionMicroOrganismInstance.email = micro?.email

				versionMicroOrganismInstance.applicationForm1 = versionApplicationInstance

				if(!versionMicroOrganismInstance.save(flush:true)){
					versionMicroOrganismInstance.errors.allErrors.each {print it}
				}

			}
		}
		return versionApplicationInstance
	}
	
	
	def copyRepositoryContactdetails(ApplicationForm1 appDetails, VersionApplicationForm1 versionApplicationInstance){
		def repositoryContactDetails = ContactDetailsOfRepository.where {applicationForm1 == appDetails}.list()

		if(repositoryContactDetails != null){
			repositoryContactDetails.each { repo->

				def versionRepositoryContactDetailsInstance = new VersionContactDetailsOfRepository();

				versionRepositoryContactDetailsInstance.repostoryType = repo?.repostoryType
				versionRepositoryContactDetailsInstance.repostoryName = repo?.repostoryName
				versionRepositoryContactDetailsInstance.address1 = repo?.address1
				versionRepositoryContactDetailsInstance.address2 = repo?.address2
				versionRepositoryContactDetailsInstance.address3 = repo?.address3
				versionRepositoryContactDetailsInstance.country = repo?.country
				versionRepositoryContactDetailsInstance.state = repo?.state
				versionRepositoryContactDetailsInstance.city = repo?.city
				versionRepositoryContactDetailsInstance.zip = repo?.zip
				versionRepositoryContactDetailsInstance.mobile = repo?.mobile
				versionRepositoryContactDetailsInstance.phone = repo?.phone
				versionRepositoryContactDetailsInstance.email = repo?.email
				versionRepositoryContactDetailsInstance.accessionNumber = repo?.accessionNumber
				versionRepositoryContactDetailsInstance.isAccessionNumAllotted = repo?.isAccessionNumAllotted

				versionRepositoryContactDetailsInstance.applicationForm1 = versionApplicationInstance

				if(!versionRepositoryContactDetailsInstance.save(flush:true)){
					versionRepositoryContactDetailsInstance.errors.allErrors.each {print it}
				}
			}
		}
		return versionApplicationInstance
	}
	
	def copyFormBFundingAgency(ApplicationForm1 appDetails, VersionApplicationForm1 versionApplicationInstance){
		
		def fundingAgencyDetails = FormBFundingAgency.where {appform == appDetails}.list()
		if(fundingAgencyDetails != null){
			fundingAgencyDetails.each {fund->
				def versionFormBAgencyInstance = new VersionFormBFundingAgency();

				versionFormBAgencyInstance.institutionOrganizationName = fund?.institutionOrganizationName
				versionFormBAgencyInstance.address1 = fund?.address1
				versionFormBAgencyInstance.address2 = fund?.address2
				versionFormBAgencyInstance.address3 = fund?.address3
				versionFormBAgencyInstance.country = fund?.country
				versionFormBAgencyInstance.state = fund?.state
				versionFormBAgencyInstance.city = fund?.city
				versionFormBAgencyInstance.phone = fund?.phone
				versionFormBAgencyInstance.email = fund?.email
				versionFormBAgencyInstance.sanctionOrder = fund?.sanctionOrder
				versionFormBAgencyInstance.sanctionOrderMoUcopyFileName = fund?.sanctionOrderMoUcopyFileName
				versionFormBAgencyInstance.appform = versionApplicationInstance

				if(!versionFormBAgencyInstance.save(flush:true)){
					versionFormBAgencyInstance.errors.allErrors.each {print it}}
			}
		}
		return versionApplicationInstance
	}
	
	
	def copyFormBItemDetails(ApplicationForm1 appDetails, VersionApplicationForm1 versionApplicationInstance){
		def formBItems = FormB.where {appForm == appDetails}.list()
		if(formBItems != null){
			formBItems.each{ items->
				def versionFormBInstance = new VersionFormB();
				
				versionFormBInstance.name = items?.name
				versionFormBInstance.supervisorDesignation = items?.supervisorDesignation
				versionFormBInstance.headOfInstName = items?.headOfInstName
				versionFormBInstance.headOfInstDesignation = items?.headOfInstDesignation
				versionFormBInstance.address1 = items?.address1
				versionFormBInstance.address2 = items?.address2
				versionFormBInstance.address3 = items?.address3
				versionFormBInstance.city = items?.city
				versionFormBInstance.state = items?.state
				versionFormBInstance.country = items?.country
				versionFormBInstance.country1 = items?.country1
				versionFormBInstance.phone = items?.phone
				versionFormBInstance.fax = items?.fax
				versionFormBInstance.mobile = items?.mobile
				versionFormBInstance.supervisorOrHoi = items?.supervisorOrHoi
				versionFormBInstance.contactDetailsOfInstOrOrganization = items?.contactDetailsOfInstOrOrganization
				versionFormBInstance.category = items?.category
				versionFormBInstance.email = items?.email
				versionFormBInstance.pincode = items?.pincode
				versionFormBInstance.type = items?.type
				versionFormBInstance.memorandum = items?.memorandum
				versionFormBInstance.addressproofSelect = items?.addressproofSelect
				versionFormBInstance.addressproofNo = items?.addressproofNo
				versionFormBInstance.addressproofLetter = items?.addressproofLetter
				versionFormBInstance.memorandumFile = items?.memorandumFile
				versionFormBInstance.sanctionOrderMoUcopy = items?.sanctionOrderMoUcopyFileName
				versionFormBInstance.sanctionOrderMoUcopyFileName = items?.name
				versionFormBInstance.addressproofLetterFileName = items?.addressproofLetterFileName
				
				versionFormBInstance.appForm = versionApplicationInstance
				
				if(!versionFormBInstance.save(flush:true)){
					versionFormBInstance.errors.allErrors.each {print it}
				}
				
			}
		} 
		return versionApplicationInstance
	}
	
	
	def setVersionStatus( SetVersionStatus.VersionStatus sts, AppStatus.Status status,ApplicationForm1 applicationInstance){

		def appstatus,setVersionStatus
		 appstatus = AppStatus.where{application == applicationInstance}.find()
		 
		 
		 setVersionStatus = SetVersionStatus.where{applicationForm1 == applicationInstance}.find()
		 

		if(appstatus == null){
			appstatus = new AppStatus(status:status,changedBy:springSecurityService.currentUser,changedOn:new Date(),application:applicationInstance)
		}else{
				
				applicationInstance.currentStatus = appstatus
				appstatus.status = status
				appstatus.changedBy = springSecurityService.currentUser
				appstatus.changedOn = new Date()
				appstatus.forwardedUser = applicationInstance?.submittedBy?.username
				println "forwaord user is applicant now"
		}

		if(setVersionStatus == null){
			setVersionStatus = new SetVersionStatus(changedBy:springSecurityService.currentUser,changedOn:new Date(),
			versionStatus:sts,applicationForm1:applicationInstance)
		}else{

			applicationInstance.setVersionStatus = setVersionStatus
			setVersionStatus.versionStatus = sts
			setVersionStatus.changedBy = springSecurityService.currentUser
			setVersionStatus.changedOn = new  Date()
		}

		if(!applicationInstance.save(flush:true)){
			applicationInstance.errors.each{ println it }
		}
		if(!appstatus.save(flush:true)){
			appstatus.errors.each{ println it }
		}
		if(!setVersionStatus.save(flush:true)){
			setVersionStatus.errors.each{ println it }
		}

	}

}

