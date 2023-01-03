package org.nba.review

import org.nba.application.ApplicationForm1;

class FormRemark {


	//common fields
 
	String onlineAppNumberRmk
	String nbaRefNumber
	String nbaRefNumberRemark
	String applicantCatgRmk
	String applicantNameContRmk
	String authPersonContRmk
	String attorneyInIndiaContRmk
	String appFormCatgRmk
	String biologicalResRmk
	String question


	Boolean idAndAddress
	String  idAndAddressRemark
	
	
	String locationRmk
	String oralRemark
	String giolocCommunityRmk
	String nameAuthByApplicantRmk
	String assoKnowledgeRmk
	String  nbaApprovalRmk
	String listedInRmk
	String dtsOfNationalInstRmk
	String researchActivitiesRmk
	String benefitSharingRmk
	String technicalInformationRmk
	String sbbBmcRmk
	Boolean benefitSharing
	Boolean technicalInformation
	Boolean sbbBmc
	
	Set<String> gioLocation
	
	Date remkDate
	String remarkUser
	String FormId

	//form 2 extra

	String resConducted
	String resOfReserch
	String consObtained
	String instOrganisation
	String individualOrg
	String intendedUseOfResearch
	String biotechnological
	String seekApproval
	String sbbDropDown
	// form 3 extra

	String commTheInvention
	

	//form 4 extra

	Boolean serialNo
	String serialNumRemk
	Boolean attachedCopyCheck
	String attachedCopy
	String dateOfApprovl
	String benefitSharingAld
	String thirdParty
	String thirdPartyTransfer
	String detailsOfEconomic
	String detailsAnyAgreement
	Boolean agreementCheck
	String agreement
	String proposedMechanism
	String anyOther

//Legal Review Section form 1
	
	String holdingPatternRemark
	String holdingPatternChk
	String letterBoardRemark
	String letterBoardChk
	String sevnRemark
	Boolean sevncheck
	String threeTwoRemark
	Boolean threeTwocheck
    String makingSelection
    String intendedPurpose
    Boolean twoMChk
	String twoMRemark
	String violationRemark
	Boolean violationChk
	String orderRemark
	String orderChk
	String vettingRemark
	String vettingChk
	String twoDRemark
	Boolean twoDChk
	String twoFRemark
	Boolean twoFChk
	String violationSelect
	String additional
	String additionalReview
	String checklistType
	
	//form 2 legal Review
	
	String splObservation
	Boolean isLegalIssueRmk
	String briefDetailOfResearchRmk
	String priorApprovalOfNBA
	String priorApprovalOfNBARmk
	String detailsResearchRmk
	String twoMChkRemark
	String isLegalIssueRemark
	
	//form 3 legal review
	String patentDateRmk
	String patentAlreadyRemk
	String patentAlreadyChk
	String splObservationRmk
	
	//form 4 legal Review
	String purposeForTransBioResRmk
	String dateOfTransBioResRmk
	
// form B technical
	String appltnationality
	Boolean prescribedApplication
	String whetherPrescriedRmk
	String columnFilledRmk
	Boolean columnFilled
	String indinstitueRemk
	String headSuperRemk
	String indinstitueGuideRemk
	String indinstSuperRemk
	String fundingRemk
	String emergencyRemk
	Boolean signedUndertaking
	String signedUndertakingRmk
	
	static hasMany = [questionAnswers:QuestionAnswer,checklistBioresorces:ChecklistBioresource,
		              checklistLocations:ChecklistLocation,checklistContacts:ChecklistContact,gioLocation:String]
	static belongsTo = [applicationForm1:ApplicationForm1]
	
	static constraints = {
		
		onlineAppNumberRmk blank: true, nullable:true,size:0..2000
		nbaRefNumber blank: true, nullable:true,size:0..2000
		nbaRefNumberRemark blank:true, nullable:true,size:0..2000
		applicantCatgRmk blank: true, nullable:true,size:0..2000
		applicantNameContRmk blank: true, nullable:true,size:0..2000
		authPersonContRmk blank: true, nullable:true,size:0..2000
		attorneyInIndiaContRmk blank: true, nullable:true,size:0..2000
		appFormCatgRmk blank: true, nullable:true,size:0..2000
		idAndAddress blank: true, nullable:true,size:0..2000
		idAndAddressRemark blank: true, nullable:true,size:0..2000
		biologicalResRmk blank: true, nullable:true,size:0..2000
		locationRmk blank: true, nullable:true,size:0..2000
		oralRemark blank: true, nullable:true,size:0..2000
		giolocCommunityRmk blank: true, nullable:true,size:0..2000
		nameAuthByApplicantRmk blank: true, nullable:true,size:0..2000
		assoKnowledgeRmk blank: true, nullable:true,size:0..2000
		nbaApprovalRmk blank: true, nullable:true,size:0..2000
		listedInRmk blank: true, nullable:true,size:0..2000
		dtsOfNationalInstRmk blank: true, nullable:true,size:0..2000
		researchActivitiesRmk blank: true, nullable:true,size:0..2000
		benefitSharingRmk blank: true, nullable:true,size:0..2000
		technicalInformationRmk blank: true, nullable:true,size:0..2000
		sbbBmcRmk blank: true, nullable:true,size:0..2000
		benefitSharing blank: true, nullable:true,size:0..2000
		technicalInformation blank: true, nullable:true,size:0..2000
		sbbBmc blank: true, nullable:true,size:0..2000
		gioLocation blank: true, nullable:true,size:0..2000
		resOfReserch blank: true, nullable:true,size:0..2000
		resConducted blank: true, nullable:true,size:0..2000
		consObtained blank: true, nullable:true,size:0..2000
		instOrganisation blank: true, nullable:true,size:0..2000
		individualOrg blank: true, nullable:true,size:0..2000
		intendedUseOfResearch blank: true, nullable:true,size:0..2000
		biotechnological blank: true, nullable:true,size:0..2000
		seekApproval blank: true, nullable:true,size:0..2000
		sbbDropDown blank: true, nullable:true,size:0..2000
		commTheInvention blank: true, nullable:true,size:0..2000
		serialNo blank: true, nullable:true,size:0..2000
		attachedCopy blank: true, nullable:true,size:0..2000
		dateOfApprovl blank: true, nullable:true,size:0..2000
		benefitSharingAld blank: true, nullable:true,size:0..2000
		thirdParty blank: true, nullable:true,size:0..2000
		thirdPartyTransfer blank: true, nullable:true,size:0..2000
		detailsOfEconomic blank: true, nullable:true,size:0..2000
		detailsAnyAgreement blank: true, nullable:true,size:0..2000
		agreement blank: true, nullable:true,size:0..2000
		proposedMechanism blank: true, nullable:true,size:0..2000
		anyOther blank: true, nullable:true,size:0..2000
		holdingPatternRemark blank: true, nullable:true,size:0..2000
		holdingPatternChk blank: true, nullable:true,size:0..2000
		letterBoardRemark blank: true, nullable:true,size:0..2000
		letterBoardChk blank: true, nullable:true,size:0..2000
		sevnRemark  blank: true, nullable:true,size:0..2000
		sevncheck blank: true, nullable:true,size:0..2000
		threeTwoRemark blank: true, nullable:true,size:0..2000
		threeTwocheck blank: true, nullable:true,size:0..2000
		makingSelection blank: true, nullable:true,size:0..2000
		intendedPurpose blank:true, nullable:true,size:0..2000
		twoMChk blank:true, nullable:true,size:0..2000
		twoMRemark blank:true, nullable:true,size:0..2000
		violationRemark blank:true, nullable:true,size:0..2000
		violationChk blank:true, nullable:true,size:0..2000
		orderRemark blank:true, nullable:true,size:0..2000
		orderChk blank:true, nullable:true,size:0..2000
		vettingRemark blank:true, nullable:true,size:0..2000
		vettingChk blank:true, nullable:true,size:0..2000
		twoDRemark blank:true, nullable:true,size:0..2000
		twoDChk blank:true, nullable:true,size:0..2000
		twoFRemark blank:true, nullable:true,size:0..2000
		twoFChk blank:true, nullable:true,size:0..2000
		violationSelect blank:true, nullable:true,size:0..2000
		additional  blank:true, nullable:true,size:0..2000
		additionalReview blank:true, nullable:true,size:0..2000
		serialNumRemk blank:true, nullable:true,size:0..2000
		attachedCopyCheck blank:true, nullable:true,size:0..2000
		agreementCheck blank:true, nullable:true,size:0..2000
		question blank:true, nullable:true,size:0..2000
		splObservation blank:true, nullable:true,size:0..2000
		isLegalIssueRmk blank:true, nullable:true,size:0..2000
		briefDetailOfResearchRmk blank:true, nullable:true,size:0..2000
		priorApprovalOfNBA blank:true, nullable:true,size:0..2000
		priorApprovalOfNBARmk blank:true, nullable:true,size:0..2000
		patentDateRmk blank:true, nullable:true,size:0..2000
		patentAlreadyRemk blank:true, nullable:true
		patentAlreadyChk blank:true, nullable:true,size:0..2000
		purposeForTransBioResRmk blank:true, nullable:true,size:0..2000
		dateOfTransBioResRmk blank:true, nullable:true,size:0..2000
		
	    applicationForm1 blank:true, nullable:true
	    questionAnswers blank:true, nullable:true
		checklistBioresorces blank:true, nullable:true
		checklistLocations blank:true, nullable:true
		
		 appltnationality blank:true, nullable:true,size:0..2000
		 prescribedApplication blank:true, nullable:true,size:0..2000
		 whetherPrescriedRmk blank:true, nullable:true,size:0..2000
		 columnFilledRmk blank:true, nullable:true,size:0..2000
		 columnFilled blank:true, nullable:true,size:0..2000
		 indinstitueRemk blank:true, nullable:true,size:0..2000
		 headSuperRemk blank:true, nullable:true,size:0..2000
		 indinstitueGuideRemk blank:true, nullable:true,size:0..2000
		 indinstSuperRemk blank:true, nullable:true,size:0..2000
		 fundingRemk blank:true, nullable:true,size:0..2000
		 emergencyRemk blank:true, nullable:true,size:0..2000
		 signedUndertaking blank:true, nullable:true,size:0..2000
		 signedUndertakingRmk blank:true, nullable:true,size:0..2000
		 checklistType blank:true, nullable:true
		 detailsResearchRmk blank:true, nullable:true
		 splObservationRmk blank:true, nullable:true
		 twoMChkRemark blank:true, nullable:true
		 isLegalIssueRemark blank:true,nullable:true
	}
}
