package org.nba.versions

import java.util.Date;

import org.nba.application.ApplicationForm1;
import org.nba.master.QuestionCategory;
import org.nba.user.NbaUser;


class VersionApplicationForm1 {

	String answer
	String verFormType
	String verFormStatus
	//	VersionFormCategory category
	//	QuestionCategory quescategory
	//	VersionQuestion question
	byte[] declarationForm
	String declarationFormName
	NbaUser submittedBy
	VersionAgentProfile agentProfile
	Date createdOn
	String submittedOn
//	VersionAppStatus currentStatus
//	VersionTransaction transaction
	String feedback
	String appNumber
	String isDeclarationDigitallySigned
	boolean submitCheck
	String selfAuthorizedPerson
	String isNoForTraditional

	//form 1 related info
	String traditionalKnowledgeDesc
	String purpose
	String nature
	String otherInfo
	String contactPerson
	String purposeOfProposal
	String briefDescription
	String isRisky
	String instituteParticipation
	String detailsOfInstitute
	byte[] letterOfintent
	String letterOfIntentName
	String isBenefitSharing
	byte[] sharingDoc
	String sharingDocName
	String riskInvolved
	Boolean conditionOfAbs
	Boolean approvalOfNba
	Boolean recordsWithTheNba
	Boolean infromationTrue
	String payBenefitSharing
	String isMonetary
	String isTradingPurpose

	//form 2 related info
	String resultsOfResearch
	byte[] nbaApprovalFile
	String nbaApprovalFileName
	byte[] bonafideLetter
	String bonafideLetterName
	String traditionalKnowledgeSource
	String useofResearchResults
	String benefitsToTheApplicant
	String benefitsToTheIndividualOrOrganization
	byte[] agreementLetter
	String agreementLetterName
	byte[] mouFile
	String mouFileName
	String collaborationDetails
	//newly created for form 2
	String isApprovalOfNbaObtained
	String consentObtained
	String isResearchParticipation
	String isAgreementOrMou

	//form 3
	String titleOfIPR
	String abstractOfIPR
	String applicationNo
	Date dateOfApproval
	String reasonOfDisapproval
	boolean bioResourcesObtainedFromOutsideIndia
	boolean approvalOfCountriesObtained
	
	String isIPApplicationFiled
	String isApprovalOfNbaObtainedForm3
	String isBioObtainedOutsideIndia
	String isApprovalOfCountryObtained
	boolean isRAndDParticipationForm3
	String traditionalKnowledgeUsedInInvention
	String isTraditionalKnowledgeApplicable
	String reasonOFNotObtainedApproval
	
	//form4
	String instituteAddress
	String telephone
	String fax
	String website
	String email
	String thirdPartyTransferPurpose
	String benefitsToTheThirdParty
	//newly created fields for form 4
	String detailsOfBioResOrTradKnow
	String isbenefitSharingDetailImplemented
	boolean isIndividualOrEntity
	String purposeOfProposalForm4
	String isAgreementBwApplicantAndThirdParty
	String benefitMechanism
	String benefitsOutOfThirdPartyTransfer
	String mechanismOutOfThirdPartyTransfer
	String otherRelevantInfo
	byte[] agreementBtwnApplicantAndThirdParty
	String agreementBtwnApplicantAndThirdPartyFileName
	String isAddressOfContactPerson
	String detailsOfIndividualOrOrganisation
//	byte[] digitalSignatureFile
	String loginAuthTextEdits
	
	//Form C part 3
	String depositionPerpose
	Boolean declarationAcceptance
	byte[] undertakingCopy
	String undertakingCopyFileName
	//int countB = 0
	//int countC = 0
	
	//FormBpart4statusHistory
	byte[] declarationBySupervisorCopy
	String declarationBySupervisorCopyFileName
	byte[]declarationByRecipientCopy
	String declarationByRecipientCopyFileName
	byte[] declarationByApplicantOnNationalityCopy
	String declarationByApplicantOnNationalityCopyFileName
	
	String emergencyDetails
	Date researchDurationFrom
	Date researchDurationTo
	String typeOfExercise
	String reasonsForSending
	String numOfTimesOfSending
	
	byte[] benefitSharingProofFile
	String benefitSharingProofFilename

static belongsTo = [applicationForm:ApplicationForm1]
	
	static hasMany = [biologicalResources:VersionBiologicalResource,thirdParty:VersionThirdParty,
		locations:VersionGeoLocationOfCommunity,individualProfiles:VersionIndividualProfile,companyProfiles:VersionCompanyProfile,
		indianResearcher:VersionIndianResearcher,indianGovtInst:VersionIndianGovtInst,iprDetails:VersionIPRDetail,
		contactPersons:VersionContactPerson,statusHistory:VersionAppStatus,depostionOfMicroOrganism:VersionDepositionOfMicroOrganism,
		repositoryContactDetails:VersionContactDetailsOfRepository,formBFundingAgency:VersionFormBFundingAgency,
		formBItems:VersionFormB,researchDurations:VersionResearchDuration,govtInstitutes:VersionIndianGovtInstitution]
	
	
	static constraints = {

		applicationForm nullable:true,blank:true
		//countC nullable:true,blank:true
		reasonOFNotObtainedApproval nullable:true,blank:true,size: 0..100000
		detailsOfIndividualOrOrganisation nullable:true,blank:true,size: 0..100000
		loginAuthTextEdits nullable:true,blank:true,size: 0..100000
		isAddressOfContactPerson nullable:true,blank:true
		agreementBtwnApplicantAndThirdParty nullable:true,blank:true
		isTraditionalKnowledgeApplicable nullable:true,blank:true
		
		appNumber nullable:true,blank:true
		answer nullable:true,blank:true
	//	category nullable:true,blank:true
		otherRelevantInfo nullable:true,blank:true,size: 0..100000
		benefitsOutOfThirdPartyTransfer nullable:true,blank:true,size: 0..100000
		mechanismOutOfThirdPartyTransfer nullable:true,blank:true,size: 0..100000
	//	quescategory nullable:true,blank:true
	//	question nullable:true,blank:true
		declarationForm nullable:true,blank:true
		declarationFormName nullable:true,blank:true
		submittedBy nullable:true,blank:true
		isDeclarationDigitallySigned nullable:true,blank:true
		feedback nullable:true,blank:true,size: 0..100000
		submitCheck nullable:true,blank:true
		selfAuthorizedPerson nullable:true,blank:true
		isNoForTraditional nullable:true,blank:true 
		traditionalKnowledgeUsedInInvention nullable:true,blank:true,size: 0..100000 
		conditionOfAbs nullable:true,blank:true
		
		locations nullable:true,blank:true
		biologicalResources nullable:true,blank:true
		traditionalKnowledgeDesc nullable:true,blank:true,size: 0..100000
		purpose nullable:true,blank:true
		briefDescription nullable:true,blank:true,size: 0..100000
		isRisky nullable:true,blank:true
		instituteParticipation nullable:true,blank:true
		detailsOfInstitute nullable:true,blank:true
		letterOfintent nullable:true,blank:true
		letterOfIntentName nullable:true,blank:true
		isBenefitSharing nullable:true,blank:true
		sharingDoc nullable:true,blank:true
		sharingDocName nullable:true,blank:true
		statusHistory nullable:true,blank:true
	//	currentStatus nullable:true,blank:true
		individualProfiles nullable:true,blank:true
		companyProfiles nullable:true,blank:true
		agentProfile nullable:true,blank:true
		createdOn nullable:true,blank:true
		submittedOn nullable:true,blank:true
		titleOfIPR nullable:true,blank:true
		abstractOfIPR nullable:true,blank:true,size: 0..100000
		resultsOfResearch nullable:true,blank:true,size: 0..100000
		nbaApprovalFile nullable:true,blank:true
		nbaApprovalFileName nullable:true,blank:true
		bonafideLetter nullable:true,blank:true
		bonafideLetterName nullable:true,blank:true
		traditionalKnowledgeSource nullable:true,blank:true
		useofResearchResults nullable:true,blank:true,size: 0..100000
		benefitsToTheApplicant nullable:true,blank:true,size: 0..100000
		benefitsToTheIndividualOrOrganization nullable:true,blank:true,size: 0..100000
		agreementLetter nullable:true,blank:true
		agreementLetterName nullable:true,blank:true
		mouFile nullable:true,blank:true
		mouFileName nullable:true,blank:true
		collaborationDetails nullable:true,blank:true,size: 0..100000
		riskInvolved nullable:true,blank:true,size: 0..100000
		otherInfo nullable:true,blank:true, size: 0..100000
		nature nullable:true,blank:true
		consentObtained nullable:true,blank:true
		purposeOfProposal nullable:true,blank:true
		contactPerson nullable:true,blank:true
		isApprovalOfNbaObtained nullable:true,blank:true
		isResearchParticipation nullable:true,blank:true
		isAgreementOrMou nullable:true,blank:true
		isIPApplicationFiled nullable:true,blank:true
		isApprovalOfNbaObtainedForm3 nullable:true,blank:true
		isBioObtainedOutsideIndia nullable:true,blank:true
		isApprovalOfCountryObtained nullable:true,blank:true
		isRAndDParticipationForm3 nullable:true,blank:true
		detailsOfBioResOrTradKnow nullable:true,blank:true
		isbenefitSharingDetailImplemented nullable:true,blank:true
		isIndividualOrEntity nullable:true,blank:true
		purposeOfProposalForm4 nullable:true,blank:true
		isAgreementBwApplicantAndThirdParty nullable:true,blank:true
		agreementBtwnApplicantAndThirdPartyFileName nullable:true,blank:true
		
		
		applicationNo nullable:true,blank:true
		dateOfApproval nullable:true,blank:true
		reasonOfDisapproval nullable:true,blank:true
		bioResourcesObtainedFromOutsideIndia nullable:true,blank:true
		approvalOfCountriesObtained nullable:true,blank:true

		instituteAddress nullable:true,blank:true
		telephone nullable:true,blank:true
		fax nullable:true,blank:true
		website nullable:true,blank:true
		email nullable:true,blank:true
		thirdPartyTransferPurpose nullable:true,blank:true,size: 0..100000
		benefitsToTheThirdParty  nullable:true,blank:true,size: 0..100000
		contactPersons nullable:true,blank:true
	//	transaction nullable:true,blank:true
		benefitMechanism nullable:true,blank:true,size: 0..100000
//		digitalSignatureFile nullable:true,blank:true
		emergencyDetails nullable:true,blank:true,size: 0..100000
		researchDurationFrom nullable:true,blank:true
		researchDurationTo nullable:true,blank:true
		typeOfExercise nullable:true, blank:true
		reasonsForSending nullable:true, blank:true
		numOfTimesOfSending nullable:true, blank:true
		benefitSharingProofFile nullable:true,blank:true
		benefitSharingProofFilename nullable:true,blank:true
		depositionPerpose nullable:true,blank:true
		declarationAcceptance nullable:true,blank:true
		undertakingCopy nullable:true,blank:true
		undertakingCopyFileName nullable:true,blank:true
		declarationBySupervisorCopy nullable:true,blank:true
		declarationBySupervisorCopyFileName nullable:true,blank:true
		declarationByRecipientCopy nullable:true,blank:true
		declarationByRecipientCopyFileName nullable:true,blank:true
		declarationByApplicantOnNationalityCopy nullable:true,blank:true
		declarationByApplicantOnNationalityCopyFileName nullable:true,blank:true
		approvalOfNba nullable:true,blank:true
		recordsWithTheNba nullable:true,blank:true
		infromationTrue nullable:true,blank:true
		payBenefitSharing nullable:true,blank:true
		isMonetary nullable:true,blank:true
		isTradingPurpose nullable:true,blank:true
		verFormType nullable:true,blank:true
	    verFormStatus nullable:true,blank:true
	}

}
