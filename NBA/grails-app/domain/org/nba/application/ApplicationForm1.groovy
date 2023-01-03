package org.nba.application

import org.nba.benefits.BenefitSharing
import org.nba.common.Country
import org.nba.communication.Agenda
import org.nba.communication.ClientLetter
import org.nba.communication.LetterCommunication
import org.nba.communication.PeriodicReport
import org.nba.communication.SBBConsent
import org.nba.communication.SbbCommunication
import org.nba.master.Question
import org.nba.master.QuestionCategory
import org.nba.master.Transaction
import org.nba.resource.BiologicalResource
import org.nba.resource.GeoLocationOfCommunity
import org.nba.resource.IPRDetail
import org.nba.resource.ThirdParty
import org.nba.review.AccountRemark
import org.nba.review.AddNote
import org.nba.review.FormRemark
import org.nba.upload.ManualUpload
import org.nba.user.NbaUser
import org.nba.versions.SetVersionStatus
import org.nba.versions.VersionApplicationForm1

class ApplicationForm1 {

	String answer
	FormCategory category
	QuestionCategory quescategory
	Question question
	
	byte[] declarationForm
	String declarationFormName
	String declarationFormURL
	
	
	NbaUser submittedBy
	AgentProfile agentProfile
	Date createdOn
	String submittedOn
	AppStatus currentStatus
	Transaction transaction
	String feedback
	String appNumber
	String isDeclarationDigitallySigned
	boolean submitCheck
	Boolean otpStatus
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
	String letterOfIntentURL
	
	String isBenefitSharing
	byte[] sharingDoc
	String sharingDocName
	String sharingDocURL
	
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
    String nbaApprovalFileURL

	byte[] bonafideLetter
	String bonafideLetterName
	String bonafideLetterURL

	String traditionalKnowledgeSource
	String useofResearchResults
	String benefitsToTheApplicant
	String benefitsToTheIndividualOrOrganization
	byte[] agreementLetter
	String agreementLetterName
	
	byte[] mouFile
	String mouFileName
    String mouFileURL

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
	//newly created for form 3
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
	String agreementBtwnApplicantAndThirdPartyURL

	String isAddressOfContactPerson
	String detailsOfIndividualOrOrganisation
//	byte[] digitalSignatureFile
	String loginAuthTextEdits
	
	//Form C part 3
	String depositionPerpose
	Boolean declarationAcceptance
	byte[] undertakingCopy
	String undertakingCopyFileName
	String undertakingCopyURL
	//int countB = 0
	//int countC = 0
	
	//FormBpart4
	byte[] declarationBySupervisorCopy
	String declarationBySupervisorCopyFileName
	String declarationBySupervisorCopyURL
	
	byte[]declarationByRecipientCopy
	String declarationByRecipientCopyFileName
	String declarationByRecipientCopyURL
	
	byte[] declarationByApplicantOnNationalityCopy
	String declarationByApplicantOnNationalityCopyFileName
	String declarationByApplicantOnNationalityCopyURL
	
	String emergencyDetails
	Date researchDurationFrom
	Date researchDurationTo
	String typeOfExercise
	String reasonsForSending
	String numOfTimesOfSending
	
	byte[] benefitSharingProofFile
	String benefitSharingProofFilename


  static hasOne = [setVersionStatus:SetVersionStatus,sbbCommunication:SbbCommunication]
	
	static hasMany = [detailsOfTerritories:Country,biologicalResources:BiologicalResource,thirdParty:ThirdParty,locations:GeoLocationOfCommunity,
		individualProfiles:IndividualProfile,companyProfiles:CompanyProfile,indianResearcher:IndianResearcher,indianGovtInst:IndianGovtInst,
		iprDetails:IPRDetail,contactPersons:ContactPerson,statusHistory:AppStatus,depostionOfMicroOrganism:DepositionOfMicroOrganism,
		repositoryContactDetails:ContactDetailsOfRepository,formBFundingAgency:FormBFundingAgency,formBItems:FormB,
		researchDurations:ResearchDuration,govtInstitutes:IndianGovtInstitution,versionApplicationForm1:VersionApplicationForm1,
		
		addnotes:AddNote,formRemarks:FormRemark,accountRemarks:AccountRemark,formremarks:FormRemark,
		agendas:Agenda,benefitSharings:BenefitSharing,periodicreports:PeriodicReport,
		letterCommunications:LetterCommunication,clientLetters:ClientLetter,sbbConsents:SBBConsent,manualUploads:ManualUpload]
	
	
	static constraints = {

		//countB nullable:true,blank:true
		//countC nullable:true,blank:true
		reasonOFNotObtainedApproval nullable:true,blank:true,size: 0..100000
		detailsOfIndividualOrOrganisation nullable:true,blank:true,size: 0..100000
		loginAuthTextEdits nullable:true,blank:true,size: 0..100000
		isAddressOfContactPerson nullable:true,blank:true
		agreementBtwnApplicantAndThirdParty nullable:true,blank:true
		isTraditionalKnowledgeApplicable nullable:true,blank:true
		detailsOfTerritories nullable:true,blank:true
		appNumber nullable:true,blank:true
		answer nullable:true,blank:true
		category nullable:true,blank:true
		otherRelevantInfo nullable:true,blank:true,size: 0..100000
		benefitsOutOfThirdPartyTransfer nullable:true,blank:true,size: 0..100000
		mechanismOutOfThirdPartyTransfer nullable:true,blank:true,size: 0..100000
		quescategory nullable:true,blank:true
		question nullable:true,blank:true
		declarationForm nullable:true,blank:true
		declarationFormName nullable:true,blank:true
		submittedBy nullable:true,blank:true
		isDeclarationDigitallySigned nullable:true,blank:true
		feedback nullable:true,blank:true,size: 0..100000
		submitCheck nullable:true,blank:true
		otpStatus nullable:true,blank:true
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
		currentStatus nullable:true,blank:true
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
		transaction nullable:true,blank:true
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
		setVersionStatus nullable:true,blank:true
		letterCommunications nullable:true,blank:true
		clientLetters nullable:true,blank:true
		sbbConsents nullable:true,blank:true
		sbbCommunication nullable:true,blank:true
		manualUploads  nullable:true,blank:true
		
		letterOfIntentURL  nullable:true,blank:true
		sharingDocURL nullable:true,blank:true
		bonafideLetterURL nullable:true,blank:true
		nbaApprovalFileURL nullable:true,blank:true
		mouFileURL nullable:true,blank:true
		agreementBtwnApplicantAndThirdPartyURL nullable:true,blank:true 
		undertakingCopyURL  nullable:true,blank:true
		declarationBySupervisorCopyURL  nullable:true,blank:true
		declarationByRecipientCopyURL  nullable:true,blank:true
		declarationByApplicantOnNationalityCopyURL nullable:true, blank: true
		declarationFormURL nullable:true, blank: true
	}
	
	
}
