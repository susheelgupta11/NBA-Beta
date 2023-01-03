package org.nba.review
import grails.converters.JSON
import groovy.sql.Sql

import org.xhtmlrenderer.pdf.ITextRenderer;


import com.nba.constant.Constants

import org.apache.catalina.core.ApplicationHttpRequest;
import org.nba.application.ApplicationForm1
import org.nba.application.FormB
import org.nba.application.FormB.EntityType;
import org.nba.application.FormCategory
import org.nba.common.State
import org.nba.resource.BiologicalResource;
import org.nba.review.AccountRemark;
import org.nba.review.FormRemark;
import org.nba.review.IprForeignPetent;
import org.nba.review.IprRemark;
import org.nba.review.QuestionAnswer;
import org.springframework.core.io.Resource
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.security.access.annotation.Secured
import org.xhtmlrenderer.css.parser.property.PrimitivePropertyBuilders.Color
import org.codehaus.groovy.grails.core.io.ResourceLocator
import org.hibernate.SessionFactory;





@Secured('permitAll')
class ChecklistController {
    
	def grailsApplication
	def springSecurityService
	def applicationNotingService
	def applicationCheckingService
	def assetResourceLocator
    ResourceLocator grailsResourceLocator
	def pdfRenderingService
	SessionFactory sessionFactory;
	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def paymentType = ['Wire Transfer', 'SBI Collect', 'NEFT', 'DEMAND DRAFT', 'Others']
	def sbbList = ['pqr', 'xyz']
	def vioSection = ['Section 3', 'Section 4', 'Section 6','Section 20','Section 7( SBB Purview)']
	  
	
	// Account user checklist
	
	
	def accountMembers(){
		def formId = params.instance
		if(formId == "" || formId == null){

			flash.message = "Please select an application"
			redirect(controller:'dashboard', action:'dashboard')
			return;
		}
		
		println "check constant"+Constants.FILE_FORWARD_MSG 

		def csrfPreventionSalt = params.csrfPreventionSalt
		def formDetails = ApplicationForm1.get(formId)
		def applicationNum = formDetails?.appNumber
		def submittedDate  = formDetails?.submittedOn
		def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)
		def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()

		[dropDnValues:dropDnValues,formDetails:formDetails,applicationNum:applicationNum,
			paymentType:paymentType,formId:formId,allDataforMatching:allDataforMatching,submittedDate:submittedDate,csrfPreventionSalt:csrfPreventionSalt]
	}




	def saveAccountNote(){
		String responce = ''

		def csrfPreventionSalt =params.csrfPreventionSalt
		def checkIdForUpdate = params?.accountRemarkInstance
		def getFormId = params?.instance
		def counter = params.counterVal?:'0' as Integer
		

		def formDetails = ApplicationForm1.get(getFormId)

		if(checkIdForUpdate == '' || checkIdForUpdate == null){

			def accountRemarkInstance = new AccountRemark(paymentType:params.pymtType,txnDetailsInOrder:params.txnCofm,mcdWithBakStatement:params.mcdBnk,
			question:params.quest,others:params.remarkPayment,txnDetailsRemark:params.remark,mcdBakStatementRemark:params.remarkBnk,
			trsnsRemark:params.trsnsRemark, paymentRemark:params.paymentRemark, paymentReceivedRemark:params.paymentReceivedRemark, feeRemark:params.feeRemark,applicationForm1:formDetails)


			if(!accountRemarkInstance.save(flush:true))	{
				accountRemarkInstance.errors.allErrors.each {print it}
			}
			
			if(counter != 0){

			for(int i = 1; i <= counter; i++){

				def questionAnswerInstance = new QuestionAnswer();

				def quesVal = params."quesValues${i}"
				def ansVal = params."ansValues${i}"

				if(quesVal != null &&  ansVal != null){
					questionAnswerInstance.question = quesVal;
					questionAnswerInstance.answer  = ansVal;
					questionAnswerInstance.accountRemark = accountRemarkInstance
					if(!questionAnswerInstance.save(flush:true)){
						questionAnswerInstance.errors.allErrors.each {print it}
					}
				}
				else println "Question Value is Empty"
			}
			println "No any question added"
			}
			responce = "Account checklist saved successfully"
			redirect (action:'showAccountData', params :[accountRemarkInstance:accountRemarkInstance?.id, instance:formDetails?.id,message:responce,csrfPreventionSalt:csrfPreventionSalt])
		}
		else if(params.quest != '' || params.pymtType !='' || params.txnCofm != '' || params.mcdBnk != '' || params.remarkPayment != ''
		|| params.remark != ''  || params.remarkBnk != ''  ){

			def existsCheckNote = AccountRemark.get(checkIdForUpdate)

			println "existsCheckNote----------"+params.existsCheckNote

			existsCheckNote.paymentType = params.pymtType
			if(params.txnCofm == "true")
				existsCheckNote.txnDetailsInOrder = true
			else
				existsCheckNote.txnDetailsInOrder = false

			if(params.mcdBnk == "true")
				existsCheckNote.mcdWithBakStatement = true
			else
				existsCheckNote.mcdWithBakStatement = false

			existsCheckNote.question = params.quest
			existsCheckNote.others = params.remarkPayment
			existsCheckNote.txnDetailsRemark = params.remark
			existsCheckNote.mcdBakStatementRemark = params.remarkBnk
			
			existsCheckNote.trsnsRemark = params.trsnsRemark
            existsCheckNote.paymentRemark = params.paymentRemark
            existsCheckNote.paymentReceivedRemark = params.paymentReceivedRemark
            existsCheckNote.feeRemark =params.feeRemark

			if(!existsCheckNote.save(flush:true)){
				existsCheckNote.errors.allErrors.each {print it}
			}
			responce ="Account checklist updated successfully"

			redirect(action:'showAccountData', params:[accountRemarkInstance:existsCheckNote?.id, instance:formDetails?.id,message:responce,csrfPreventionSalt:csrfPreventionSalt] )
		}
	}

	
	
		def showAccountData(){
			def  getFormId = params.instance
			def getAccountId = params.accountRemarkInstance
			def csrfPreventionSalt = params.csrfPreventionSalt
	        def message = params.message
			
			println "account remark class"+getAccountId.getClass()
			println "form id class"+ getFormId.getClass()
	
			def formDetails = ApplicationForm1.get(Long.parseLong(getFormId))
			def accountRemarkInstance = AccountRemark.get(Long.parseLong(getAccountId))
			def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()
			def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)
	
	
			[accountRemarkInstance:accountRemarkInstance ,message:message, paymentType:paymentType,formDetails:formDetails,dropDnValues:dropDnValues,
				allDataforMatching:allDataforMatching,csrfPreventionSalt:csrfPreventionSalt]
		}
	
	
	def saveAccountComment(){

		println"Inside comment Box========"
		println"formId"+params.applicationInstance
		def csrfPreventionSalt = params.csrfPreventionSalt
		
		def formId = params.applicationInstance
		def accountRemarkInstance = params.accountRemarkInstanceComment
		def flag = params.flag
		def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()
		
		
		if(formId == "" || formId == null){

			flash.message = "Application Form Number missing"
			redirect( action: "accountMembers" , params:[instance:formId,csrfPreventionSalt:csrfPreventionSalt])
			return
		}

			def getAllpdfFile =  request.getFiles('files[]')
	     println "received files are here--------"+getAllpdfFile

	ApplicationForm1 appInstance = ApplicationForm1.get(Long.parseLong(params.applicationInstance))
	def applicationNumber = appInstance?.appNumber
	String msg = "File forward successfully";
	
	if(getAllpdfFile.size() > 0){

		def checkFile = applicationNotingService.checkFileValidation(getAllpdfFile)
		if(checkFile == "Validate Successfully"){
			def instance = applicationNotingService.addNoteForApplication(params)
			if(instance instanceof org.nba.review.AddNote){
				def uploadFile = applicationNotingService.transferFile(getAllpdfFile,applicationNumber,instance)

				if(uploadFile == true){
					redirect(action:'noting', controller:'dashboard', params:[message:msg,instance:params.applicationInstance,csrfPreventionSalt:csrfPreventionSalt])
					return;
				}
			}
		}else{
		if(flag =='1'){
			redirect(action:'accountMembers', params:[message:checkFile, instance:params.applicationInstance,csrfPreventionSalt:csrfPreventionSalt])
			return;}else if(flag == '2'){
			
			redirect(action:'showAccountData', params:[message:checkFile,accountRemarkInstance:params.accountRemarkInstance, instance:params.applicationInstance,csrfPreventionSalt:csrfPreventionSalt])
			return;
			}
		}
	}else{
		def instance = applicationNotingService.addNoteForApplication(params)
		
		if(instance instanceof org.nba.review.AddNote){
			redirect(action:'noting', controller:'dashboard', params:[message:msg,instance:params.applicationInstance,csrfPreventionSalt:csrfPreventionSalt])
			return;
		}
	}
}
	

		
	
// Technical  checklist

	def technicalReview(){

		def csrfPreventionSalt = params.csrfPreventionSalt
		def message = params.message
		def formId = params.instanceId
	
		def formDetails = ApplicationForm1.get(formId)
		def formType = formDetails.category.category.toString()
		def subForm = formType.substring(5)

		def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()
		
		def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)


		def indianInst = FormB.where{
			appForm == formDetails && type == FormB.EntityType.Institute
		}.find();

		def superVisor = FormB.where{
			appForm == formDetails && type == FormB.EntityType.Supervisor
		}.find();

		def guidingIns = FormB.where{
			appForm == formDetails && type == FormB.EntityType.Guiding_Institute
		}.find();

		def guidingSup = FormB.where{
			appForm == formDetails && type == FormB.EntityType.Guiding_Supervisor
		}.find();
	
        def ntcList = applicationCheckingService.ntcDetails(formDetails)

		println "formDetails----date----"+formDetails+"----"+new Date()
		
		[formDetails:formDetails, listOfStates:State.list(),formId:formId,dropDnValues:dropDnValues,subForm:subForm,
			indianInst:indianInst,superVisor:superVisor,guidingIns:guidingIns,guidingSup:guidingSup,message:message,
			rare:ntcList,allDataforMatching:allDataforMatching,sbb:sbbList,formType:formType,csrfPreventionSalt:csrfPreventionSalt]
	}

	
	
	def techFormRemarkSave(){
		def formRemarkSaveInst,responce
		def formIdCk = params.frmId
		def getIdForForm = params.listId
		def chkForUpdate = params.checkInstance
		def formSubType = params.formTpe
		def formType = params.formType
		def csrfPreventionSalt = params.csrfPreventionSalt

		println "formIdck-------"+formIdCk
		println "formType"+formSubType
		println "chkForUpdate"+chkForUpdate
		println "preList-----"+getIdForForm

		def formDetails = ApplicationForm1.get(getIdForForm)

		if(chkForUpdate == null || chkForUpdate == ''){

			def counterStr = params.counterVal ?:'0' as Integer

			println "-------"+counterStr.getClass()
			
			formRemarkSaveInst =  applicationCheckingService.applicationFormCheckListSave(params,formDetails,formIdCk,counterStr)
			responce = "Technical checklist saved successfully"
		}else if(chkForUpdate != null || chkForUpdate != ''){
			formRemarkSaveInst =  applicationCheckingService.applicationFormCheckListUpdate(params, chkForUpdate,formDetails,formIdCk)
			responce = "Technical checklist updated successfully"
		}
		
		redirect (action:'showTechnicalData', params :[formRemkInstance:formRemarkSaveInst,instance:formDetails?.id,message:responce,csrfPreventionSalt:csrfPreventionSalt])
	}

	def showTechnicalData(){
		println "inside technical data show------------"
		def message = params.message
		def csrfPreventionSalt = params.csrfPreventionSalt
		def getTechReviewId = params.formRemkInstance
		def formId = params.instance

		def formDetails = ApplicationForm1.get(Long.parseLong(formId))
		def formRemkInstance = FormRemark.get(Long.parseLong(getTechReviewId))
		def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()
		def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)

		def formType = formDetails?.category?.category
		def subForm = formType?.toString().substring(5)


		def indianInst = FormB.where{
			appForm == formDetails && type == FormB.EntityType.Institute
		}.find();

		def superVisor = FormB.where{
			appForm == formDetails && type == FormB.EntityType.Supervisor
		}.find();

		def guidingIns = FormB.where{
			appForm == formDetails && type == FormB.EntityType.Guiding_Institute
		}.find();

		def guidingSup = FormB.where{
			appForm == formDetails && type == FormB.EntityType.Guiding_Supervisor
		}.find();

	def ntcList = applicationCheckingService.ntcDetails(formDetails)

		[formDetails:formDetails,formId:formId,message:message,formRemkInstance:formRemkInstance,dropDnValues:dropDnValues,listOfStates:State.list(),
			allDataforMatching:allDataforMatching,subForm:subForm,indianInst:indianInst,superVisor:superVisor,
			rare:ntcList,guidingIns:guidingIns,guidingSup:guidingSup,formType:formType,csrfPreventionSalt:csrfPreventionSalt]

	}

	
	def saveTechComment(){

		println"Inside comment Box Tech ========"+params.checkInstance
		println"formId"+params.applicationInstance
		def flag = params.flag

		def csrfPreventionSalt = params.csrfPreventionSalt
		def formType = params.formType

		formType = (formType.length()<2)? "Form"+" "+formType:formType

		def formId = params.applicationInstance
		def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()

		if(formId == "" || formId == null){

			flash.message = "Application Form Number is missing"
			redirect( action: "technicalReview", params:[csrfPreventionSalt:csrfPreventionSalt])
			return
		}


		def getAllpdfFile =  request.getFiles('files[]')
		println "received files are here--------"+getAllpdfFile

		ApplicationForm1 appInstance = ApplicationForm1.get(Long.parseLong(params.applicationInstance))
		def applicationNumber = appInstance?.appNumber
		String msg = "File forward successfully";

		if(getAllpdfFile.size() > 0){

			def checkFile = applicationNotingService.checkFileValidation(getAllpdfFile)
			if(checkFile == "Validate Successfully"){
				def instance = applicationNotingService.addNoteForApplication(params)
				if(instance instanceof org.nba.review.AddNote){
					def uploadFile = applicationNotingService.transferFile(getAllpdfFile,applicationNumber,instance)

					if(uploadFile == true){
						redirect(action:'noting', controller:'dashboard', params:[message:msg,instance:params.applicationInstance,csrfPreventionSalt:csrfPreventionSalt])
						return;
					}
				}
			}else{
				if(flag =='1'){
					redirect(action:'technicalReview', params:[message:checkFile, instance:params.applicationInstance,csrfPreventionSalt:csrfPreventionSalt])
					return;}else if(flag == '2'){

					redirect(action:'showTechnicalData', params:[message:checkFile,accountRemarkInstance:params.accountRemarkInstance, instance:params.applicationInstance,csrfPreventionSalt:csrfPreventionSalt])
					return;
				}
			}
		}else{
			def instance = applicationNotingService.addNoteForApplication(params)

			if(instance instanceof org.nba.review.AddNote){
				redirect(action:'noting', controller:'dashboard', params:[message:msg,instance:params.applicationInstance,csrfPreventionSalt:csrfPreventionSalt])
				return;
			}
		}

	}

	
// Legal checklist	
	
	def legalHead(){
		def subForm,nbaReferenceNum
		def csrfPreventionSalt = params.csrfPreventionSalt
		def formId = params.instanceId
		def formType = params.formType
		def message = params.message
		if(formType.toString().length()>2){
			subForm = formType.toString().substring(5)
		}
		else{
			subForm = formType;
		}
		if(formId){
			def formDetails = ApplicationForm1.get(formId)
			def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)
			def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()
            def agent = formDetails?.agentProfile
			
			def indianInst = FormB.where{
				appForm == formDetails && type == FormB.EntityType.Institute
			}.find();

			def superVisor = FormB.where{
				appForm == formDetails && type == FormB.EntityType.Supervisor
			}.find();
			if(formDetails.formremarks.size() > 0){
				nbaReferenceNum = FormRemark.where{applicationForm1 == formDetails}.list().get(0)?.nbaRefNumber;
			}	else{nbaReferenceNum = ''}
			
			
			[formDetails:formDetails,nbaReferenceNum:nbaReferenceNum, agent:agent, formId:formId,subForm:subForm,vioSection:vioSection,dropDnValues:dropDnValues,message:message,
				indianInst:indianInst,superVisor:superVisor,formType:formType,allDataforMatching:allDataforMatching,csrfPreventionSalt:csrfPreventionSalt]
		}
	}

	def legalFormRemarkSave(){
		def legalReivewInstance
		def csrfPreventionSalt = params.csrfPreventionSalt
		def formIdCk = params.frmId
		def getIdForForm = params.listId
		def chkForUpdate = params.checkInstance
		def formSubType = params.formTpe
        String message = "" 
		println "form Id-----"+getIdForForm


		//	FormCategory formCategory = FormCategory.get(getIdForForm)
		def formDetails = ApplicationForm1.get(getIdForForm)


		if(chkForUpdate == '' || chkForUpdate == null){

			def counterStr = params.counterVal?:0 as Integer


			legalReivewInstance =  applicationCheckingService.legalReviewCheckListSave(params, formDetails, formIdCk, counterStr)
			message = 'Legal checklist save successfully'
		}else if(chkForUpdate != '' || chkForUpdate != null){
			legalReivewInstance =  applicationCheckingService.legalReviewCheckListUpdate(params, chkForUpdate, formDetails, formIdCk)
			message = 'Legal checklist update successfully'
		}
		
		redirect (action:'showLegalHeadData', params :[formRemkInstance:legalReivewInstance,instance:formDetails?.id,message:message,csrfPreventionSalt:csrfPreventionSalt])
	}



	def showLegalHeadData(){

		println "inside legal data show------------"
		def csrfPreventionSalt = params.csrfPreventionSalt
		def getlegalHeadId = params.formRemkInstance
		def getFormId = params.instance
        def message = params.message
		def formDetails = ApplicationForm1.get(Long.parseLong(getFormId))
		def formRemkInstance = FormRemark.get(Long.parseLong(getlegalHeadId))

		def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()
		def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)

		def formType = formDetails?.category?.category
		def subForm = formType?.toString().substring(5)

		def indianInst = FormB.where{
			appForm == formDetails && type == FormB.EntityType.Institute
		}.find();

		def superVisor = FormB.where{
			appForm == formDetails && type == FormB.EntityType.Supervisor
		}.find();


		[formDetails:formDetails,formRemkInstance:formRemkInstance,dropDnValues:dropDnValues,listOfStates:State.list(),
			allDataforMatching:allDataforMatching,subForm:subForm,formType:formType,vioSection:vioSection,formId:formDetails?.id,
			indianInst:indianInst,superVisor:superVisor,csrfPreventionSalt:csrfPreventionSalt,message:message]
	}
	
	
	
	def saveLegalComment(){
		
				println"Inside comment Box========"
				println"formId"+params.applicationInstance
				def csrfPreventionSalt = params.csrfPreventionSalt
				def formType = params.formType
				def flag = params.flag
				def formId = params.applicationInstance
				def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()
		
				if(formId == "" || formId == null){
		
					flash.message = "Application Form Number missing"
					redirect( action: "legalHead", params:[csrfPreventionSalt:csrfPreventionSalt])
					return
				}
		
		def getAllpdfFile =  request.getFiles('files[]')
		println "received files are here--------"+getAllpdfFile

		ApplicationForm1 appInstance = ApplicationForm1.get(Long.parseLong(params.applicationInstance))
		def applicationNumber = appInstance?.appNumber
		String msg = "File forward successfully";

		if(getAllpdfFile.size() > 0){

			def checkFile = applicationNotingService.checkFileValidation(getAllpdfFile)
			if(checkFile == "Validate Successfully"){
				def instance = applicationNotingService.addNoteForApplication(params)
				if(instance instanceof org.nba.review.AddNote){
					def uploadFile = applicationNotingService.transferFile(getAllpdfFile,applicationNumber,instance)

					if(uploadFile == true){
						redirect(action:'noting', controller:'dashboard', params:[message:msg,instance:params.applicationInstance,csrfPreventionSalt:csrfPreventionSalt])
						return;
					}
				}
			}else{
				if(flag =='1'){
					redirect(action:'legalHead', params:[message:checkFile, instance:params.applicationInstance,csrfPreventionSalt:csrfPreventionSalt])
					return;}else if(flag == '2'){

					redirect(action:'showLegalHeadData', params:[message:checkFile,accountRemarkInstance:params.accountRemarkInstance, instance:params.applicationInstance,csrfPreventionSalt:csrfPreventionSalt])
					return;
				}
			}
		}else{
			def instance = applicationNotingService.addNoteForApplication(params)

			if(instance instanceof org.nba.review.AddNote){
				redirect(action:'noting', controller:'dashboard', params:[message:msg,instance:params.applicationInstance,csrfPreventionSalt:csrfPreventionSalt])
				return;
			}
		}
			}

	
//************************************************* IPR member checklist*********************************************************//	

	def iprRemark(){
		
		
		def csrfPreventionSalt = params.csrfPreventionSalt
		def formId = params.instance
		def message = params.message
		
		if(formId == "" || formId == null){
			flash.message = "Please select an application"
			redirect(action:'dashboard',controller:'dashboard', params:[csrfPreventionSalt:csrfPreventionSalt])
			return;
		}

		def formDetails = ApplicationForm1.get(formId)
		def applicationNum = formDetails?.appNumber
		def submittedDate  = formDetails?.submittedOn

		def iprRemarkInstance = new IprRemark()

		def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)

		def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()

		render (view:'iprRemark', model:[iprRemarkInstance:iprRemarkInstance,dropDnValues:dropDnValues,formDetails:formDetails,applicationNum:applicationNum,
			paymentType:paymentType,formId:formId,allDataforMatching:allDataforMatching,submittedDate:submittedDate,
			message:message,csrfPreventionSalt:csrfPreventionSalt])
	}

	def saveIprReviewDetails(){

		def csrfPreventionSalt = params.csrfPreventionSalt
		def instance = params.formId
		def checkInstanceForUpdate = params.iprInstance
		def formDetails = ApplicationForm1.get(Long.parseLong(instance))
		def counter = params.counterVal?:'0' as Integer
		String message = ""

		println "inside ipr save section------------"
		if(checkInstanceForUpdate == '' || checkInstanceForUpdate == null){

			def iprRemarkInstance = new IprRemark(patentDtsRmk:params.patentDtsRmk,foreignPatentRemark:params.foreignPatentRemark,
			mtcWithPatentAppRmk:params.mtcWithPatentAppRmk,bioresourceMtcRmk:params.bioresourceMtcRmk,
			detailsCommercialRmk:params.detailsCommercialRmk,country:params.country,financialYr:params.financialYr,amount:params.amount,
			remarksA:params.remarksA,questionRequired:params.questionRequired)


			if(params.mtcWithPatentAppChk == 'true'){
				iprRemarkInstance.mtcWithPatentAppChk = true
			}else if(params.mtcWithPatentAppChk == 'false'){
				iprRemarkInstance.mtcWithPatentAppChk =false
			}

			if(params.bioresourceMtcChk == 'true'){
				iprRemarkInstance.bioresourceMtcChk = true
			}else if(params.bioresourceMtcChk == 'false'){
				iprRemarkInstance.bioresourceMtcChk =false
			}

			if(params.dtsCommercializationChk == 'true'){
				iprRemarkInstance.dtsCommercializationChk = true
			}else if(params.dtsCommercializationChk == 'false'){
				iprRemarkInstance.dtsCommercializationChk =false
			}

			if(params.foreignPetentChk == 'true'){
				iprRemarkInstance.foreignPetentChk = true
			}else if(params.foreignPetentChk == 'false'){
				iprRemarkInstance.foreignPetentChk =false
			}
			iprRemarkInstance.applictaionForm1 = formDetails
			if(!iprRemarkInstance.save(flush:true)){
				iprRemarkInstance.errors.allErrors.each{print it}
			}

//			def getQues,getAns;
//
//			if( params.quesValues != '' || params.quesValues !=null){
//				getQues =  params.list('quesValues'); 
//			}
//			if( params.ansValues != '' || params.ansValues != null){
//				getAns = params.list('ansValues');
//			}
//			
//		
//			
//				getQues.eachWithIndex {value, index->
//					def questionAnswersInstance = new QuestionAnswer()
//					questionAnswersInstance.question = value;
//					questionAnswersInstance.answer = getAns[index];
//					questionAnswersInstance.iprRemark = iprRemarkInstance
//
//					if(!questionAnswersInstance.save(flush:true)){
//						questionAnswersInstance.errors.allErrors.each{print it}
//					}
//				}
			
			
			
			if(counter != 0){
				
							for(int i = 1; i <= counter; i++){
				
								def questionAnswerInstance = new QuestionAnswer();
				
								def quesVal = params."quesValues${i}"
								def ansVal = params."ansValues${i}"
				
								if(quesVal != null &&  ansVal != null){
									questionAnswerInstance.question = quesVal;
									questionAnswerInstance.answer  = ansVal;
									questionAnswerInstance.iprRemark = iprRemarkInstance
									if(!questionAnswerInstance.save(flush:true)){
										questionAnswerInstance.errors.allErrors.each {print it}
									}
				
								}
								else println "Question Value is Empty"
							}
						}
			
						def remarksPetent,statusPatent,patentNumAndDateIfGranted,serialNumber,
						             countryTerritoryName,datePatent,patentApplicationNum;
			
						if(params.remarksPetent != '' || params.remarksPetent != null){
							remarksPetent = params.list('remarksPetent')
						}
						if(params.statusPatent != '' || params.statusPatent != null){
							statusPatent = params.list('statusPatent')
						}
						if( params.patentNumAndDateIfGranted != '' || params.patentNumAndDateIfGranted != null){
							patentNumAndDateIfGranted = params.list('patentNumAndDateIfGranted')
						}
						if(params.serialNumber != '' || params.serialNumber != null){
							serialNumber = params.list('serialNumber')
						}
						if(params.countryTerritoryName != '' || params.countryTerritoryName != null){
							countryTerritoryName = params.list('countryTerritoryName')
						}
						if(params.datePatent != '' || params.datePatent != null){
							datePatent = params.list('datePatent')
						}
						if(params.patentApplicationNum != '' || params.patentApplicationNum != null){
							patentApplicationNum = params.list('patentApplicationNum')
						}

			
						serialNumber.eachWithIndex {value, index ->
			
					def iprForeignPetentInstance = new IprForeignPetent()
					
					iprForeignPetentInstance.serialNumber = value
					iprForeignPetentInstance.statusPatent = statusPatent[index]
					iprForeignPetentInstance.patentNumAndDateIfGranted = patentNumAndDateIfGranted[index]
					iprForeignPetentInstance.countryTerritoryName = countryTerritoryName[index]
					iprForeignPetentInstance.datePatent = datePatent[index]
					iprForeignPetentInstance.remarksPetent = remarksPetent[index]
					iprForeignPetentInstance.patentApplicationNum = patentApplicationNum[index]

					iprForeignPetentInstance.iprRemark = iprRemarkInstance
					if(!iprForeignPetentInstance.save(flush:true)){
						iprForeignPetentInstance.errors.allErrors.each {print it}
					}
						}
			message = "IPR checklist save successfully"
			redirect(action:'showIprRemark',params:[iprRemarkInstance:iprRemarkInstance?.id,instance:formDetails?.id,message:message,csrfPreventionSalt:csrfPreventionSalt])
		}
		else if(checkInstanceForUpdate != '' || checkInstanceForUpdate != null){

			def iprRemarkUpdateInstance = IprRemark.get(Long.parseLong(checkInstanceForUpdate));



			iprRemarkUpdateInstance.patentDtsRmk = params.patentDtsRmk
			iprRemarkUpdateInstance.foreignPatentRemark = params.foreignPatentRemark
			iprRemarkUpdateInstance.mtcWithPatentAppRmk = params.mtcWithPatentAppRmk
			iprRemarkUpdateInstance.bioresourceMtcRmk = params.bioresourceMtcRmk
			iprRemarkUpdateInstance.detailsCommercialRmk = params.detailsCommercialRmk
			iprRemarkUpdateInstance.country = params.country
			iprRemarkUpdateInstance.financialYr = params.financialYr
			iprRemarkUpdateInstance.amount = params.amount
			iprRemarkUpdateInstance.remarksA = params.remarksA
			iprRemarkUpdateInstance.questionRequired = params.questionRequired

			if(params.mtcWithPatentAppChk == 'true'){
				iprRemarkUpdateInstance.mtcWithPatentAppChk = true
			}else if(params.mtcWithPatentAppChk == 'false'){
				iprRemarkUpdateInstance.mtcWithPatentAppChk =false
			}

			if(params.bioresourceMtcChk == 'true'){
				iprRemarkUpdateInstance.bioresourceMtcChk = true
			}else if(params.bioresourceMtcChk == 'false'){
				iprRemarkUpdateInstance.bioresourceMtcChk =false
			}

			if(params.dtsCommercializationChk == 'true'){
				iprRemarkUpdateInstance.dtsCommercializationChk = true
			}else if(params.dtsCommercializationChk == 'false'){
				iprRemarkUpdateInstance.dtsCommercializationChk =false
			}

			if(params.foreignPetentChk == 'true'){
				iprRemarkUpdateInstance.foreignPetentChk = true
			}else if(params.foreignPetentChk == 'false'){
				iprRemarkUpdateInstance.foreignPetentChk =false
			}
			if(!iprRemarkUpdateInstance.save(flush:true)){
				iprRemarkUpdateInstance.errors.allErrors.each{print it}
			}
			message = "IPR checklist update successfully"
			redirect(action:'showIprRemark',params:[iprRemarkInstance:iprRemarkUpdateInstance?.id,instance:formDetails?.id,message:message,csrfPreventionSalt:csrfPreventionSalt])
		}
	}
	def showIprRemark(){

		def  getFormId = params.instance
		def getAccountId = params.iprRemarkInstance
		def csrfPreventionSalt = params.csrfPreventionSalt
		def message = params.message

		def formDetails = ApplicationForm1.get(Long.parseLong(getFormId))
		def iprRemarkInstance = IprRemark.get(Long.parseLong(getAccountId))
		def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()
		def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)


		[iprRemarkInstance:iprRemarkInstance ,formDetails:formDetails,dropDnValues:dropDnValues,
			allDataforMatching:allDataforMatching,message:message,csrfPreventionSalt:csrfPreventionSalt]
	}
	

	def saveIprComment(){

		println"Inside comment Box IPR========"
		println"formId"+params.applicationInstance
		def csrfPreventionSalt = params.csrfPreventionSalt
		//		def formType = params.fomType
		def formId = params.applicationInstance
		def iprRemarkInstance = params.iprInstance
		def flag = params.flag

		if(formId == "" || formId == null){

			flash.message = "Application Form Number is missing"
			redirect( action: "iprRemark" , params:[instance:formId,csrfPreventionSalt:csrfPreventionSalt])
			return
		}
		
		
		def getAllpdfFile =  request.getFiles('files[]')
		println "received files are here--------"+getAllpdfFile

		ApplicationForm1 appInstance = ApplicationForm1.get(Long.parseLong(params.applicationInstance))
		def applicationNumber = appInstance?.appNumber
		String msg = "File forward successfully";

		if(getAllpdfFile.size() > 0){

			def checkFile = applicationNotingService.checkFileValidation(getAllpdfFile)
			if(checkFile == "Validate Successfully"){
				def instance = applicationNotingService.addNoteForApplication(params)
				if(instance instanceof org.nba.review.AddNote){
					def uploadFile = applicationNotingService.transferFile(getAllpdfFile,applicationNumber,instance)

					if(uploadFile == true){
						redirect(action:'noting', controller:'dashboard', params:[message:msg,instance:params.applicationInstance,csrfPreventionSalt:csrfPreventionSalt])
						return;
					}
				}
			}else{
				if(flag =='1'){
					redirect(action:'iprRemark', params:[message:checkFile, instance:params.applicationInstance,csrfPreventionSalt:csrfPreventionSalt])
					return;}else if(flag == '2'){

					redirect(action:'showIprRemark', params:[message:checkFile,accountRemarkInstance:params.accountRemarkInstance, instance:params.applicationInstance,csrfPreventionSalt:csrfPreventionSalt])
					return;
				}
			}
		}else{
			def instance = applicationNotingService.addNoteForApplication(params)

			if(instance instanceof org.nba.review.AddNote){
				redirect(action:'noting', controller:'dashboard', params:[message:msg,instance:params.applicationInstance,csrfPreventionSalt:csrfPreventionSalt])
				return;
			}
		}
		
	}




	def technicalCheckList(){
		def getFormId = params.instance
		def csrfPreventionSalt = params.csrfPreventionSalt
		def getRemarkId = params.remark
		def formRemkInstance = FormRemark.get(Long.parseLong(getRemarkId))
		def formDetails = ApplicationForm1.get(Long.parseLong(getFormId))
		def currentUser =  springSecurityService.getCurrentUser()?.username
		def fileName = formDetails?.appNumber+'Tech-Checklist'+'.pdf'
		def formType = formDetails?.category?.category
		
	
		
		def indianInst = FormB.where{
			appForm == formDetails && type == FormB.EntityType.Institute
		}.find();

		def superVisor = FormB.where{
			appForm == formDetails && type == FormB.EntityType.Supervisor
		}.find();

		def guidingIns = FormB.where{
			appForm == formDetails && type == FormB.EntityType.Guiding_Institute
		}.find();

		def guidingSup = FormB.where{
			appForm == formDetails && type == FormB.EntityType.Guiding_Supervisor
		}.find();
		
		if(formType == FormCategory?.Category.Form_1){

			renderPdf(template: "/formReviewPdfs/formRemark1TechPdfGenerator", model: [formRemkInstance: formRemkInstance, filename: fileName,formDetails:formDetails, csrfPreventionSalt:csrfPreventionSalt])
		}else if(formType == FormCategory?.Category.Form_2){

			renderPdf(template: "/formReviewPdfs/formRemark2TechPdfGenerator", model: [formRemkInstance: formRemkInstance, filename: fileName,formDetails:formDetails, csrfPreventionSalt:csrfPreventionSalt])
		}else if(formType == FormCategory?.Category.Form_3){
		
        	renderPdf(template: "/formReviewPdfs/formRemark3TechPdfGenerator", model: [formRemkInstance: formRemkInstance, filename: fileName,formDetails:formDetails, csrfPreventionSalt:csrfPreventionSalt])
		}else if(formType == FormCategory?.Category.Form_4){

			renderPdf(template: "/formReviewPdfs/formRemark4TechPdfGenerator", model: [formRemkInstance: formRemkInstance, filename: fileName,formDetails:formDetails, csrfPreventionSalt:csrfPreventionSalt])

		}else if(formType == FormCategory?.Category.Form_B){
			
	        renderPdf(template: "/formReviewPdfs/formRemarkBTechPdfGenerator", model: [indianInst:indianInst, superVisor:superVisor,guidingIns:guidingIns,guidingSup:guidingSup, formRemkInstance: formRemkInstance,
				      filename: fileName,formDetails:formDetails, csrfPreventionSalt:csrfPreventionSalt])

		}


	}

	def accountCheckList(){

		def csrfPreventionSalt = params.csrfPreventionSalt
		def getApplicationId = params.instance
		def getFormId = params.accountInstance
		def formDetails = ApplicationForm1.get(getApplicationId)
		def accountRemark = AccountRemark.get(getFormId)
		def currentUser =  springSecurityService.getCurrentUser()?.username
		//	def headerImage = grailsApplication.mainContext.getResource("/images/nba_logo.png").file
		//	String applicationPath = new File(request.getSession().getServletContext().getRealPath("/images/nba_logo.png"))
		def filename = formDetails?.appNumber +'Account-Checklist' + '.pdf'
		renderPdf(template: "/formReviewPdfs/accountPdfGenerator", model: ['accountRemark': accountRemark,'formDetails':formDetails,'filename': filename,csrfPreventionSalt:csrfPreventionSalt])
	}


	def legalCheckList(){
		def getFormId = params.instance
		def getRemarkId = params.remark
		def csrfPreventionSalt = params.csrfPreventionSalt
		def formRemkInstance = FormRemark.get(getRemarkId)
		def formDetails = ApplicationForm1.get(getFormId)
		def currentUser =  springSecurityService.getCurrentUser()?.username
		def fileName = formDetails?.appNumber+"Legal-Checklist"+'.pdf'
		def formType = formDetails?.category?.category
		
		
		def indianInst = FormB.where{
			appForm == formDetails && type == FormB.EntityType.Institute
		}.find();

		def superVisor = FormB.where{
			appForm == formDetails && type == FormB.EntityType.Supervisor
		}.find();

		if(formType == FormCategory?.Category.Form_1){

			renderPdf(template: "/formReviewPdfs/formRemark1LegalPdfGenerator", model: [formRemkInstance: formRemkInstance, filename: fileName,formDetails:formDetails, csrfPreventionSalt:csrfPreventionSalt])
		}else if(formType == FormCategory?.Category.Form_2){

			renderPdf(template: "/formReviewPdfs/formRemark2LegalPdfGenerator", model: [formRemkInstance: formRemkInstance, filename: fileName,formDetails:formDetails, csrfPreventionSalt:csrfPreventionSalt])
		}else if(formType == FormCategory?.Category.Form_3){

			renderPdf(template: "/formReviewPdfs/formRemark3LegalPdfGenerator", model: [formRemkInstance: formRemkInstance, filename: fileName,formDetails:formDetails, csrfPreventionSalt:csrfPreventionSalt])
		}else if(formType == FormCategory?.Category.Form_4){

			renderPdf(template: "/formReviewPdfs/formRemark4LegalPdfGenerator", model: [formRemkInstance: formRemkInstance, filename: fileName,formDetails:formDetails, csrfPreventionSalt:csrfPreventionSalt])
		}
		else if(formType == FormCategory?.Category.Form_B){
			
			renderPdf(template: "/formReviewPdfs/formRemarkBLegalPdfGenerator", model: [indianInst:indianInst, superVisor:superVisor, formRemkInstance: formRemkInstance, filename: fileName,formDetails:formDetails, csrfPreventionSalt:csrfPreventionSalt])
					}
	}

	def iprChecklist(){

		def getId = params.id
		def formId = params.instance
		def csrfPreventionSalt = params.csrfPreventionSalt
		
		def formDetails = ApplicationForm1.get(Long.parseLong(formId))
		def iprRemarkInstance = IprRemark.get(Long.parseLong(getId))
		def currentUser =  springSecurityService.getCurrentUser()?.username
		def fileName = formDetails?.appNumber+"IPR-Checklist"+'.pdf'
		
			
		 renderPdf(template: "/formReviewPdfs/iprPdfGenerator", model: [iprRemarkInstance : iprRemarkInstance,formDetails:formDetails],filename: fileName,csrfPreventionSalt:csrfPreventionSalt)

	}
	
//	def testPdf(){
//
//		
//		String content = g.render(template: "/formReviewPdfs/header", model: [testdata: "Just chicking if pdf is generating at the test server"])
		
		
		
//		File output = new File("web-app/query/PDF/header.pdf");
//		ITextRenderer iTextRenderer = new ITextRenderer();
//		iTextRenderer.setDocumentFromString(content);
//		iTextRenderer.layout();
//		OutputStream os = new FileOutputStream(output);
//		iTextRenderer.createPDF(os);
//		os.flush();
//		os.close();
//	}


	def deleteQuestion(){
		def result
		def getQuesAnsId = params.deleteIns
		def itemForRemove = QuestionAnswer.get(Long.parseLong(getQuesAnsId));
		if (!itemForRemove) {
			result = [status:"Data not found"]

		}
		try {
			itemForRemove.delete(flush: true)
			result = [status: "Question deleted successfully"]
		}
		catch (DataIntegrityViolationException e) {
			println e
		}
		result = [status:"Question deleted Successfully"]
		render result as JSON
	}


	def updateQuestion(){
		def csrfPreventionSalt = params.csrfPreventionSalt
		println "all params"+params
		def getUpdateId = params.updateIns
		def getChangeId = params.id
		//		getChangeId = getChangeId.toString().substring(3);

		def itemForUpdate = QuestionAnswer.get(Long.parseLong(getChangeId));
		itemForUpdate.question = params.quesTextVal
		itemForUpdate.answer = params.ansTextVal
		if(!itemForUpdate.save(flush:true)){
			itemForUpdate.errors.allErrors.each {print it}
		}
		def result = [status :"Updated Successfully"]
		render result as JSON
	}

	def updateQuestionIpr(){
		def getIdForUpdate = params.id
		def quesAnsInstance = QuestionAnswer.get(Long.parseLong(getIdForUpdate));
		quesAnsInstance.question = params.newQues;
		quesAnsInstance.answer = params.newAns;
		if(!quesAnsInstance.save(flush:true)){
			quesAnsInstance.errors.allErrors.each {print it}
		}

		def result = [status :"Updated Successfully"]
		render result as JSON
	}

	def updatePetentIpr(){
		def getIdForUpdate = params.id
		def iprPetentInstanceForUpdate = IprForeignPetent.get(Long.parseLong(getIdForUpdate));
		iprPetentInstanceForUpdate.serialNumber = params.seri;
		iprPetentInstanceForUpdate.countryTerritoryName = params.coun;
		iprPetentInstanceForUpdate.patentApplicationNum = params.appi;
		iprPetentInstanceForUpdate.datePatent = params.date;
		iprPetentInstanceForUpdate.statusPatent = params.stat
		iprPetentInstanceForUpdate.patentNumAndDateIfGranted = params.gran
		iprPetentInstanceForUpdate.remarksPetent = params.remk

		if(!iprPetentInstanceForUpdate.save(flush:true)){
			iprPetentInstanceForUpdate.errors.allErrors.each {print it}
		}
		def result = [status:"Updated Successfully"]
		render result as JSON

	}

	def deletePetent(){
		def getQuesAnsId = params.id
		def itemForRemove = IprForeignPetent.get(Long.parseLong(getQuesAnsId));
		if (!itemForRemove) {
			flash.message = "Data not found"
			return
		}
		try {
			itemForRemove.delete(flush: true)
			flash.message = "Question delete successfully"
		}
		catch (DataIntegrityViolationException e) {
			println e
		}
		def result = [status:"Delete Successfully"]
		render result as JSON
	}



	def cancelRequest(){
		redirect(action:'dashboard',controller:'dashboard')
		return;
	}
	
	def getNtcData(){
		
	def	csrfPreventionSalt = params.csrfPreventionSalt
	Sql sql = new Sql(sessionFactory.currentSession.connection())
	
	String querySyntax = Constants.NTC_QUERY
	
	def ntcDetails = sql.rows(querySyntax)
	
	[ntcDetails:ntcDetails, csrfPreventionSalt:csrfPreventionSalt]
	
	}

}
