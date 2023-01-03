package org.nba.application

import grails.transaction.Transactional
import groovy.sql.Sql

import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap
import org.hibernate.SessionFactory
import org.nba.resource.BiologicalResource
import org.nba.resource.GeoLocationOfBioResource
import org.nba.review.ChecklistBioresource
import org.nba.review.ChecklistContact
import org.nba.review.ChecklistLocation
import org.nba.review.FormRemark
import org.nba.review.QuestionAnswer

import com.nba.constant.Constants

@Transactional
class ApplicationCheckingService {
	def grailsApplication
	def springSecurityService
	SessionFactory sessionFactory;
	
	
	def applicationFormCheckListSave(GrailsParameterMap params,formDetails,formIdCk,counter) {

		def formRemkInstance = new FormRemark(onlineAppNumberRmk:params.appnumber,nbaRefNumber:params.refNumber,nbaRefNumberRemark:params.nbaRefNumberRemark,applicantCatgRmk:params.appltcatg,
		applicantNameContRmk:params.appltname,authPersonContRmk:params.nameandComp,attorneyInIndiaContRmk:params.agent,appFormCatgRmk:params.formCatg,idAndAddressRemark:params.whrIdProof,
		biologicalResRmk:params.resremk,locationRmk:params.locRmk,oralRemark:params.oralKnow,giolocCommunityRmk:params.community,assoKnowledgeRmk:params.proposed,
		nbaApprovalRmk:params.nbaApprovalRmk,listedInRmk:params.ntc,dtsOfNationalInstRmk:params.resAndDev,researchActivitiesRmk:params.carriedOut,benefitSharingRmk:params.bfsh,
		technicalInformationRmk:params.techInfo,sbbBmcRmk:params.sbb,gioLocation:params.gioState,question:params.ques,resConducted:params.resConducted,resOfReserch:params.resOfReserch,consObtained:params.consObtained,
		instOrganisation:params.instOrganisation,individualOrg:params.individualOrg,intendedUseOfResearch:params.intendedUseOfResearch,biotechnological:params.biotechnological,seekApproval:params.seekApproval,
		sbbDropDown:params.sbbDropDown,commTheInvention:params.commTheInvention,serialNumRemk:params.serialNumRemk,attachedCopy:params.attachedCopy, dateOfApprovl:params. dateOfApprovl,benefitSharingAld:params.benefitSharingAld,
		thirdParty:params.thirdParty,thirdPartyTransfer:params.thirdPartyTransfer,detailsOfEconomic:params.detailsOfEconomic,detailsAnyAgreement:params.detailsAnyAgreement,
		agreement:params.agreement,proposedMechanism:params.proposedMechanism,anyOther:params.anyOther,
		//formB
		appltnationality:params.appltnationality,whetherPrescriedRmk:params.whetherPrescriedRmk,
		columnFilledRmk:params.columnFilledRmk,indinstitueRemk:params.indinstitueRemk,headSuperRemk:params.headSuperRemk,
		indinstitueGuideRemk:params.indinstitueGuideRemk,indinstSuperRemk:params.indinstSuperRemk,fundingRemk:params.fundingRemk,
		emergencyRemk:params.emergencyRemk,signedUndertakingRmk:params.signedUndertakingRmk,checklistType:"TECHNICAL")

		if(params.sbbMbs == "true")
			formRemkInstance.sbbBmc = true
		else
			formRemkInstance.sbbBmc = false
		if(params.reqTechInfo == "true")
			formRemkInstance.technicalInformation = true
		else
			formRemkInstance.technicalInformation = false

		if(params.whrIdProofMtc == "true")
			formRemkInstance.idAndAddress = true
		else
			formRemkInstance.idAndAddress = false

		if(params.benefitShr == "true")
			formRemkInstance.benefitSharing = true
		else
			formRemkInstance.benefitSharing = false

		if(params.attachedCopyCheck == "true")
			formRemkInstance.attachedCopyCheck = true
		else
			formRemkInstance.attachedCopyCheck = false

		if(params.agreementCheck == "true")
			formRemkInstance.agreementCheck = true
		else
			formRemkInstance.agreementCheck = false

		if(params.serialNo == "true")
			formRemkInstance.serialNo = true
		else
			formRemkInstance.serialNo = false

		if(params.signedUndertaking == "true")
			formRemkInstance.signedUndertaking = true
		else
			formRemkInstance.signedUndertaking = false

		if(params.columnFilled == "true")
			formRemkInstance.columnFilled = true
		else
			formRemkInstance.columnFilled = false

		if(params.prescribedApplication == "true")
			formRemkInstance.prescribedApplication = true
		else
			formRemkInstance.prescribedApplication = false

		formRemkInstance.applicationForm1 = formDetails
		formRemkInstance.remkDate = new Date()
		formRemkInstance.remarkUser = springSecurityService?.getCurrentUser()?.username
		formRemkInstance.FormId = formIdCk
		if(!formRemkInstance.save(flush:true)){
			formRemkInstance.errors.allErrors.each {print it}
		}
		if(counter != 0){
			for(int i = 1; i <= counter; i++){

				def questionAnswerInstance = new QuestionAnswer();

				def quesVal = params."quesValues${i}"
				def ansVal = params."ansValues${i}"

				if(quesVal != null &&  ansVal != null){
					questionAnswerInstance.question = quesVal;
					questionAnswerInstance.answer  = ansVal;
					questionAnswerInstance.formRemark = formRemkInstance
					if(!questionAnswerInstance.save(flush:true)){
						questionAnswerInstance.errors.allErrors.each {print it}
					}

				}
				else println "Question Value is Empty"
			}
		}
	
		def bioNumber = params.bioResourceNumber?.toInteger()
		
		println "---------"+bioNumber	
		
		if(bioNumber > 1 && (params.resremk != '' || params.resremk != null)){
			
			List bioRmks =  params.chkname
			
			println "000000000000"+bioRmks
			
			bioRmks.eachWithIndex { value,index->
			
				def checklistBioRemerk = new ChecklistBioresource();
				
				checklistBioRemerk.chkname = params.chkname[index]
				checklistBioRemerk.chkscientificName = params.chkscientificName[index]
				checklistBioRemerk.chkcommonName = params.chkcommonName[index]
				checklistBioRemerk.chknature = params.chknature[index]
				checklistBioRemerk.chkbiologicalResource = params.chkbiologicalResource[index]
				checklistBioRemerk.bioRemarks = params.resremk[index]
				
				if(params.chkQuantity)
				checklistBioRemerk.chkQuantity = params.chkQuantity[index]
				
				if(params.chkTotime)
				checklistBioRemerk.chkTotime = params.chkTotime[index]
				
				if(params.chkFromtime)
				checklistBioRemerk.chkFromtime = params.chkFromtime[index]
				
				checklistBioRemerk.formRemark = formRemkInstance
				checklistBioRemerk.save(flush:true)
 
			}
		}else{
		
				formRemkInstance.biologicalResRmk = params.resremk
				
				formRemkInstance.save(flush:true)
		}
		
		
		def locationNumber = params.locationNumber?.toInteger()
		
		println"kkkkkkkk"+locationNumber
		
		if(locationNumber > 1 && (params.locRmk != '' || params.locRmk != null)){
			
           List locRemk = params.locscientificName
		
			locRemk.eachWithIndex  { value,index->
				
				def checklistLocRemerk = new ChecklistLocation()
				
				
				
				checklistLocRemerk.locscientificName = value
				checklistLocRemerk.locsource = params.locsource[index]
				checklistLocRemerk.locstate = params.locstate[index]
				checklistLocRemerk.loctraderContactDetails = params.loctraderContactDetails[index]
				checklistLocRemerk.locationRemark = params.locRmk[index]
                checklistLocRemerk.formRemark = formRemkInstance
				checklistLocRemerk.locvillage = params.locvillage[index]
				checklistLocRemerk.loctown = params.loctown[index]
				checklistLocRemerk.locdistrict = params.locdistrict[index]
				checklistLocRemerk.loctraderName = params.loctraderName[index]
			   
			    checklistLocRemerk.save(flush:true)
			}
		}else{
		def checklistLocRemerk = new ChecklistLocation()
		checklistLocRemerk.locationRemark = params.locRmk
		checklistLocRemerk.save(flush:true)
		}
		
		
		
		def contactNumber = params.contactNumber?.toInteger()
		
		if(contactNumber > 1 && (params.personsAuth != '' || params.personsAuth != null)){
			
		List conRemk = params.contName
		
			conRemk.eachWithIndex  { value,index->
				
				def checklistContRemerk = new ChecklistContact()

				checklistContRemerk.contName = value
				checklistContRemerk.contAdd = params.contAdd[index]
				checklistContRemerk.contMobile = params.contMobile[index]
				checklistContRemerk.contEmail = params.contEmail[index]
				checklistContRemerk.contRemk = params.personsAuth[index]
				checklistContRemerk.formRemark = formRemkInstance
			   
				checklistContRemerk.save(flush:true)
			}
		}else{
		
		formRemkInstance.nameAuthByApplicantRmk = params.personsAuth
		formRemkInstance.save(flush:true)
		}
		
		
		
		
	return formRemkInstance.id;
	}

	
	
	
	
	

	def applicationFormCheckListUpdate(GrailsParameterMap params, chkForUpdateIns,formDetails,formIdCk){

		def forUpdateInstance = FormRemark.get(chkForUpdateIns)

		forUpdateInstance.onlineAppNumberRmk = params.appnumber
		forUpdateInstance.nbaRefNumber = params.refNumber
		forUpdateInstance.nbaRefNumberRemark = params.nbaRefNumberRemark
		forUpdateInstance.applicantCatgRmk = params.appltcatg
		forUpdateInstance.applicantNameContRmk = params.appltname
		forUpdateInstance.authPersonContRmk = params.nameandComp
		forUpdateInstance.attorneyInIndiaContRmk = params.agent
		forUpdateInstance.appFormCatgRmk = params.formCatg
		forUpdateInstance.idAndAddressRemark = params.whrIdProof
//		forUpdateInstance.biologicalResRmk = params.resremk
//		forUpdateInstance.locationRmk = params.locRmk
		forUpdateInstance.oralRemark = params.oralKnow
		forUpdateInstance.giolocCommunityRmk = params.community
		forUpdateInstance.nameAuthByApplicantRmk = params.personsAuth
		forUpdateInstance.assoKnowledgeRmk = params.proposed
		forUpdateInstance.nbaApprovalRmk = params.nbaApprovalRmk
		forUpdateInstance.listedInRmk = params.ntc
		forUpdateInstance.dtsOfNationalInstRmk = params.resAndDev
		forUpdateInstance.researchActivitiesRmk = params.carriedOut
		forUpdateInstance.benefitSharingRmk = params.bfsh
		forUpdateInstance.technicalInformationRmk = params.techInfo
		forUpdateInstance.sbbBmcRmk = params.sbb
		forUpdateInstance.gioLocation = params.gioState
		forUpdateInstance.question = params.ques
		forUpdateInstance.resConducted = params.resConducted
		forUpdateInstance.resOfReserch = params.resOfReserch
		forUpdateInstance.consObtained = params.consObtained
		forUpdateInstance.instOrganisation = params.instOrganisation
		forUpdateInstance.individualOrg = params.individualOrg
		forUpdateInstance.intendedUseOfResearch = params.intendedUseOfResearch
		forUpdateInstance.biotechnological = params.biotechnological
		forUpdateInstance.seekApproval = params.seekApproval
		forUpdateInstance.sbbDropDown = params.sbbDropDown

		forUpdateInstance.commTheInvention = params.commTheInvention


		forUpdateInstance.serialNumRemk = params.serialNumRemk
		forUpdateInstance.attachedCopy = params.attachedCopy
		forUpdateInstance.dateOfApprovl = params. dateOfApprovl
		forUpdateInstance.benefitSharingAld = params.benefitSharingAld
		forUpdateInstance.thirdParty = params.thirdParty
		forUpdateInstance.thirdPartyTransfer = params.thirdPartyTransfer
		forUpdateInstance.detailsOfEconomic = params.detailsOfEconomic
		forUpdateInstance.detailsAnyAgreement = params.detailsAnyAgreement
		forUpdateInstance.agreement = params.agreement
		forUpdateInstance.proposedMechanism = params.proposedMechanism
		forUpdateInstance.anyOther = params.anyOther
		//FormB
		forUpdateInstance.appltnationality = params.appltnationality
		forUpdateInstance. whetherPrescriedRmk = params.whetherPrescriedRmk
		forUpdateInstance.columnFilledRmk = params.columnFilledRmk
		forUpdateInstance.indinstitueRemk = params.indinstitueRemk
		forUpdateInstance. headSuperRemk = params.headSuperRemk
		forUpdateInstance.indinstitueGuideRemk = params.indinstitueGuideRemk
		forUpdateInstance.indinstSuperRemk = params.indinstSuperRemk
		forUpdateInstance. fundingRemk = params.fundingRemk
		forUpdateInstance.emergencyRemk = params.emergencyRemk
		forUpdateInstance.signedUndertakingRmk = params.signedUndertakingRmk


		forUpdateInstance.remkDate = new Date()
		forUpdateInstance.remarkUser = springSecurityService?.getCurrentUser()?.username
		forUpdateInstance.applicationForm1 = formDetails
		forUpdateInstance.FormId =formIdCk
		


		if(params.sbbMbs == "true")
			forUpdateInstance.sbbBmc = true
		else
			forUpdateInstance.sbbBmc = false

		if(params.reqTechInfo == "true")
			forUpdateInstance.technicalInformation = true
		else
			forUpdateInstance.technicalInformation = false

		if(params.benefitShr == "true")
			forUpdateInstance.benefitSharing = true
		else
			forUpdateInstance.benefitSharing = false

		if(params.whrIdProofMtc == "true")
			forUpdateInstance.idAndAddress = true
		else
			forUpdateInstance.idAndAddress = false

		if(params.attachedCopyCheck == "true")
			forUpdateInstance.attachedCopyCheck = true
		else
			forUpdateInstance.attachedCopyCheck = false

		if(params.agreementCheck == "true")
			forUpdateInstance.agreementCheck = true
		else
			forUpdateInstance.agreementCheck = false

		if(params.serialNo == "true")
			forUpdateInstance.serialNo = true
		else
			forUpdateInstance.serialNo = false
//formB			
			
			if(params.signedUndertaking == "true")
			forUpdateInstance.signedUndertaking = true
		else
			forUpdateInstance.signedUndertaking = false

		if(params.columnFilled == "true")
			forUpdateInstance.columnFilled = true
		else
			forUpdateInstance.columnFilled = false

		if(params.prescribedApplication == "true")
			forUpdateInstance.prescribedApplication = true
		else
			forUpdateInstance.prescribedApplication = false
			

		if(!forUpdateInstance.save(flush:true)){
			forUpdateInstance.errors.allErrors.each {print it}
		}
		return forUpdateInstance.id;
	}


	
	
	
	

	def legalReviewCheckListSave(GrailsParameterMap params,formDetails,formIdCk,counter){


		def formRemkInstance = new FormRemark(onlineAppNumberRmk:params.onlineAppNumberRmk,nbaRefNumber:params.refNumber,nbaRefNumberRemark:params.nbaRefNumberRemark,
		applicantCatgRmk:params.appltcatg,applicantNameContRmk:params.appltname,authPersonContRmk:params.nameandComp,attorneyInIndiaContRmk:params.agent,
		appFormCatgRmk:params.formCatg,biologicalResRmk:params.resremk,holdingPatternRemark:params.holdingPatternRemark,letterBoardRemark:params.letterBoardRemark,
		sevnRemark:params.sevnRemark,threeTwoRemark:params.threeTwoRemark, intendedPurpose:params.intendedPurpose,
		twoMRemark:params.twoMRemark,violationRemark:params.violationRemark, orderRemark:params.orderRemark, vettingRemark:params.vettingRemark,
		twoDRemark:params.twoDRemark,  twoFRemark:params.twoFRemark, violationSelect:params.select,additional:params.additional, additionalReview:params.additionalReview,
		nbaApprovalRmk:params.nbaApprovalRmk, question:params.ques, splObservation:params.splObservation,
		briefDetailOfResearchRmk:params.briefDetailOfResearchRmk,patentDateRmk:params.patentDateRmk,priorApprovalOfNBARmk:params.priorApprovalOfNBARmk,
		dateOfTransBioResRmk:params.dateOfTransBioResRmk,purposeForTransBioResRmk:params.purposeForTransBioResRmk,
		detailsResearchRmk:params.detailsResearchRmk,patentAlreadyRemk:params.patentAlreadyRemk,splObservationRmk:params.splObservationRmk,
		isLegalIssueRemark:params.isLegalIssueRemark,makingSelection:params.makingSelection,twoMChkRemark:params.twoMChkRemark,
		//formB		
		appltnationality:params.appltnationality,whetherPrescriedRmk:params.whetherPrescriedRmk,indinstitueRemk:params.indinstitueRemk,
		headSuperRemk:params.headSuperRemk,fundingRemk:params.fundingRemk,emergencyRemk:params.emergencyRemk,checklistType:"LEGAL")



		formRemkInstance.applicationForm1 = formDetails
		
		
		
		
		if(params.isLegalIssueRmk == "true"){
			formRemkInstance.isLegalIssueRmk = true
		}
		else if(params.isLegalIssueRmk == "false"){
			formRemkInstance.isLegalIssueRmk = false
		}

		if(params.priorApprovalOfNBA == "true"){
			formRemkInstance.priorApprovalOfNBA = true
		}
		else if(params.priorApprovalOfNBA == "false"){
			formRemkInstance.priorApprovalOfNBA = false
		}
		else if(params.priorApprovalOfNBA == "notAvailable"){
			formRemkInstance.priorApprovalOfNBA = "notAvailable";
		}

		if(params.holdingPatternChk == "true"){
			formRemkInstance.holdingPatternChk = true
		}
		else if (params.holdingPatternChk == "false"){
			formRemkInstance.holdingPatternChk = false
		}
		else if(params.holdingPatternChk == "notAvailable"){
			formRemkInstance.holdingPatternChk = "notAvailable"
		}

		if(params.letterBoardChk == "true"){
			formRemkInstance.letterBoardChk = true
		}
		else if (params.letterBoardChk == "false"){
			formRemkInstance.letterBoardChk = false
		}
		else if(params.letterBoardChk == "notAvailable"){
			formRemkInstance.letterBoardChk = "notAvailable"
		}

		if(params.sevncheck == "true"){
			formRemkInstance.sevncheck = true
		}
		else if(params.sevncheck == "false"){
			formRemkInstance.sevncheck = false
		}

		if(params.threeTwocheck == "true"){
			formRemkInstance.threeTwocheck = true
		}
		else if(params.threeTwocheck == "false"){
			formRemkInstance.threeTwocheck = false
		}

		if(params.twoMChk == "true"){
			formRemkInstance.twoMChk = true
		}
	else if(params.twoMChk == "false"){
			formRemkInstance.twoMChk = false
		}

		if(params.violationChk == "true"){
			formRemkInstance.violationChk = true
		}
	else if(params.violationChk == "false"){
			formRemkInstance.violationChk = false
		}

		if(params.twoDChk == "true"){
			formRemkInstance.twoDChk = true
		}
		else if(params.twoDChk == "false"){
			formRemkInstance.twoDChk = false
		}

		if(params.orderChk == "true"){
			formRemkInstance.orderChk = true
		}
		else if(params.orderChk == "false"){
			formRemkInstance.orderChk = false
		}

		else if(params.orderChk == "needAditionalInfo"){
			formRemkInstance.orderChk = "needAditionalInfo"
		}

		if(params.vettingChk == "true"){
			formRemkInstance.vettingChk = true
		}

	else if(params.vettingChk == "false"){
			formRemkInstance.vettingChk = false
		}
		else if(params.vettingChk == "needAditionalInfo"){
			formRemkInstance.vettingChk = "needAditionalInfo"
		}

		if(params.twoFChk == "true"){
			formRemkInstance.twoFChk = true
		}
		else if(params.twoFChk == "false"){
			formRemkInstance.twoFChk = false
		}
		if(params.patentAlreadyChk == "true"){
			formRemkInstance.patentAlreadyChk = true
		}
		else if(params.patentAlreadyChk == "false"){
			formRemkInstance.patentAlreadyChk = false
		}
		
		else  if(params.patentAlreadyChk == "needAditionalInfo"){
			formRemkInstance.patentAlreadyChk = 'needAditionalInfo'
		}
		
		
		if(params.prescribedApplication == "true")
		formRemkInstance.prescribedApplication = true
	else
		formRemkInstance.prescribedApplication = false

		formRemkInstance.remkDate = new Date()
		formRemkInstance.remarkUser = springSecurityService?.getCurrentUser()?.username
		formRemkInstance.FormId = formIdCk

		if(!formRemkInstance.save(flush:true)){
			formRemkInstance.errors.allErrors.each {print it}
		}

		if(counter != 0){

			for(int i = 1; i <= counter; i++){

				def questionAnswerInstance = new QuestionAnswer();

				def quesVal = params."quesValues${i}"
				def ansVal = params."ansValues${i}"

				if(quesVal != null &&  ansVal != null){
					questionAnswerInstance.question = quesVal;
					questionAnswerInstance.answer  = ansVal;
					questionAnswerInstance.formRemark = formRemkInstance
					if(!questionAnswerInstance.save(flush:true)){
						questionAnswerInstance.errors.allErrors.each {print it}
					}

				}
				else println "Question Value is Empty"
			}
		}
		return formRemkInstance?.id
	}




	def legalReviewCheckListUpdate(GrailsParameterMap params, chkForUpdateIns,formDetails,formIdCk){

		def forUpdateInstance = FormRemark.get(chkForUpdateIns)

		forUpdateInstance.onlineAppNumberRmk = params.onlineAppNumberRmk
		forUpdateInstance.nbaRefNumber = params.refNumber
		forUpdateInstance.nbaRefNumberRemark = params.nbaRefNumberRemark
		forUpdateInstance.applicantCatgRmk = params.appltcatg
		forUpdateInstance.applicantNameContRmk = params.appltname
		forUpdateInstance.authPersonContRmk = params.nameandComp
		forUpdateInstance.attorneyInIndiaContRmk = params.agent
		forUpdateInstance.appFormCatgRmk = params.formCatg
		forUpdateInstance.biologicalResRmk = params.resremk
		forUpdateInstance.holdingPatternRemark = params.holdingPatternRemark
		forUpdateInstance.detailsResearchRmk = params.detailsResearchRmk
		forUpdateInstance.patentAlreadyRemk = params.patentAlreadyRemk
		forUpdateInstance.splObservationRmk = params.splObservationRmk
		forUpdateInstance.isLegalIssueRemark = params.isLegalIssueRemark
         forUpdateInstance.twoMChkRemark     = params.twoMChkRemark
		
	//form B	
		forUpdateInstance.appltnationality = params.appltnationality
		forUpdateInstance. whetherPrescriedRmk = params.whetherPrescriedRmk
		forUpdateInstance.indinstitueRemk = params.indinstitueRemk
		forUpdateInstance. headSuperRemk = params.headSuperRemk
		forUpdateInstance. fundingRemk = params.fundingRemk
		forUpdateInstance.emergencyRemk = params.emergencyRemk

		forUpdateInstance.letterBoardRemark = params.letterBoardRemark
		forUpdateInstance.threeTwoRemark = params.threeTwoRemark
		forUpdateInstance.makingSelection = params.makingSelection
		forUpdateInstance.intendedPurpose = params.intendedPurpose
		forUpdateInstance.twoMRemark = params.twoMRemark
		forUpdateInstance.violationRemark = params.violationRemark
		forUpdateInstance.orderRemark = params.orderRemark
		forUpdateInstance.vettingRemark = params.vettingRemark
		forUpdateInstance.twoDRemark = params.twoDRemark
		forUpdateInstance.twoFRemark = params.twoFRemark
		forUpdateInstance.violationSelect = params.select
		forUpdateInstance.additional = params.additional
		forUpdateInstance.additionalReview = params.additionalReview
		forUpdateInstance.nbaApprovalRmk = params.nbaApprovalRmk
		forUpdateInstance.question = params.ques
		forUpdateInstance.splObservation = params.splObservation
		
		forUpdateInstance.patentDateRmk = params.patentDateRmk
		forUpdateInstance.briefDetailOfResearchRmk = params.briefDetailOfResearchRmk
		forUpdateInstance.priorApprovalOfNBARmk = params.priorApprovalOfNBARmk
		forUpdateInstance.dateOfTransBioResRmk = params.dateOfTransBioResRmk
		forUpdateInstance.purposeForTransBioResRmk = params.purposeForTransBioResRmk
		forUpdateInstance.remkDate = new Date()
		forUpdateInstance.remarkUser = springSecurityService?.getCurrentUser()?.username
		forUpdateInstance.FormId =formIdCk

		forUpdateInstance.applicationForm1 = formDetails
		
		
		if(params.isLegalIssueRmk == "true"){
			forUpdateInstance.isLegalIssueRmk = true
		}
		if(params.isLegalIssueRmk == "false"){
			forUpdateInstance.isLegalIssueRmk = false
		}
		
		

		if(params.priorApprovalOfNBA == "true"){
			forUpdateInstance.priorApprovalOfNBA = true
		}
		if(params.priorApprovalOfNBA == "false"){
			forUpdateInstance.priorApprovalOfNBA = false
		}
		if(params.priorApprovalOfNBA == "notAvailable"){
			forUpdateInstance.priorApprovalOfNBA = "notAvailable";
		}

		if(params.holdingPatternChk == "true"){

			forUpdateInstance.holdingPatternChk = true
		}
		if(params.holdingPatternChk == "false"){

			forUpdateInstance.holdingPatternChk = false
		}
		if(params.holdingPatternChk == "notAvailable"){
			forUpdateInstance.holdingPatternChk = 'notAvailable'
		}


		if(params.letterBoardChk == "true"){
			forUpdateInstance.letterBoardChk = true
		}
		if(params.letterBoardChk == "false"){
			forUpdateInstance.letterBoardChk = false
		}
		if(params.letterBoardChk == "notAvailable"){
			forUpdateInstance.letterBoardChk = 'notAvailable'
		}
		if(params.sevncheck == "true"){
			forUpdateInstance.sevncheck = true
		}
		if(params.sevncheck == "false"){
			forUpdateInstance.sevncheck = false
		}
		if(params.threeTwocheck == "true"){
			forUpdateInstance.threeTwocheck = true
		}
		if(params.threeTwocheck == "false"){
			forUpdateInstance.threeTwocheck = false
		}
		if(params.twoMChk == "true"){
			forUpdateInstance.twoMChk = true
		}
		if(params.twoMChk == "false"){
			forUpdateInstance.twoMChk = false
		}

		if(params.violationChk == "true"){
			forUpdateInstance.violationChk = true
		}
		if(params.violationChk == "false"){
			forUpdateInstance.violationChk = false
		}

		if(params.twoDChk == "true"){
			forUpdateInstance.twoDChk = true
		}
		if(params.twoDChk == "false"){
			forUpdateInstance.twoDChk = false
		}

		if(params.orderChk == "true"){
			forUpdateInstance.orderChk = true
		}
		if(params.orderChk == "false"){
			forUpdateInstance.orderChk = false
		}
		if(params.orderChk == "needAditionalInfo"){
			forUpdateInstance.orderChk = "needAditionalInfo"
		}

		if(params.vettingChk == "true"){
			forUpdateInstance.vettingChk = true
		}
		if(params.vettingChk == "false"){
			forUpdateInstance.vettingChk = false
		}

		if(params.vettingChk == "needAditionalInfo"){
			forUpdateInstance.vettingChk = "needAditionalInfo"
		}

		if(params.twoFChk == "true"){
			forUpdateInstance.twoFChk = true
		}
		if(params.twoFChk == "false"){
			forUpdateInstance.twoFChk = false
		}
		if(params.patentAlreadyChk == "true"){
			forUpdateInstance.patentAlreadyChk = true
		}
		if(params.patentAlreadyChk == "false"){
			forUpdateInstance.patentAlreadyChk = false
		}
		
		if(params.patentAlreadyChk == "needAditionalInfo"){
			forUpdateInstance.patentAlreadyChk = "needAditionalInfo"
		}

		if(params.prescribedApplication == "true")
		forUpdateInstance.prescribedApplication = true
	else
		forUpdateInstance.prescribedApplication = false
		

		if(!forUpdateInstance.save(flush:true)){
			forUpdateInstance.errors.allErrors.each {print it}
		}
		return 	forUpdateInstance?.id
	}
	
	
	def  ntcDetails( formDetails){

		Sql sql = new Sql(sessionFactory.currentSession.connection())
		String queryNtc = Constants.NTC
		def ntc = sql.rows(queryNtc);

		println"jjj"+ntc

		def bioAll = BiologicalResource.where{applicationForm == formDetails}.list()
		List<String> bio = new ArrayList<String>()
		List<String> part = new ArrayList<String>()

		bioAll.each{
			bio.add(it.scientificName)
		}
		
		bioAll.each{
			part.add(it.biologicalResource)
		}
		
		println"listofbio"+bio
		def rare = null
		for(int i=0; i<bio.size();i++){
			rare = ntc.findAll{it.bio_resource == bio.get(i) && it.part == part.get(i)}

		}

		return rare
	}

}
