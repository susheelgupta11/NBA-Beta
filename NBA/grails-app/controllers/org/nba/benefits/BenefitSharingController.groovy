package org.nba.benefits

import org.nba.application.ApplicationForm1
import org.nba.application.FormCategory
import org.nba.communication.PeriodicFileAttach
import org.springframework.security.access.annotation.Secured
@Secured('permitAll')
class BenefitSharingController {

    def fileUploadService
	def checklistManagementService
	def applicationNotingService
	def mailCommunicationService
	
	List modeOfPayment = ['SBI* Collect','DD','Wire Transfer','Others, pls specify']
	List category = ['Received', 'Return']
	List typeOfSharing = ['(a) Upfront','(b) Benefit sharing','(c) Royalty','(d) others']
	
	def receivedBenefit(){
		
		def getFormInstance	= params.instance
		def csrfPreventionSalt = params.csrfPreventionSalt
		def message = params.message
		def addMore = params.addmore
//		def benefitIns = params.benefitInstance
//		def benefitInstance
//		if(benefitIns != null || "" == benefitIns){
			
//			benefitInstance = BenefitSharing.get(benefitIns as Long)
//		}
		
		
		if(getFormInstance == "" || getFormInstance == null){
		flash.message = "Please select an application"
		redirect(controller:'dashboard', action:'dashboard')
		return;
		}
		
		
		def formDetails = ApplicationForm1.get(getFormInstance as Long)
		def benefitList = BenefitSharing.where{applicationForm1 == formDetails}.list()
		
		def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)
		def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()
		
		[benefitList:benefitList,formDetails:formDetails,message:message,addMore:addMore,typeOfSharing:typeOfSharing,category:category,modeOfPayment:modeOfPayment,
			allDataforMatching:allDataforMatching,dropDnValues:dropDnValues,csrfPreventionSalt:csrfPreventionSalt]
		
		
	}
	

	def saveBenefitDetails(){

		def formInstance = params.formInstance
		def csrfPreventionSalt = params.csrfPreventionSalt
		def message
		def formDetails = ApplicationForm1.get(formInstance as Long)

		def getPdfFiles =  request.getFiles('files[]')
		println"file Size"+getPdfFiles.size()

           if(getPdfFiles.size() > 0){
		 
		 def confirmation = checklistManagementService.fileValidation(getPdfFiles)
		 if(confirmation == "Validate Successfully"){
			 
						 def benefitInstance = new BenefitSharing(appNumber:params.appNumber,transNumber:params.transNumber,amountIn:params.amountIn,
						 tr5ReceiptNumber:params.tr5ReceiptNumber,uploadtr5Receipt:params.uploadtr5Receipt,remarks:params.remarks,
						 modeOfPayment:params.modeOfPayment,category:params.category, typeOfSharing:params.typeOfSharing,bsName:params.bsName)
						 benefitInstance.applicationForm1 = formDetails
						 if(formDetails?.category?.category == FormCategory?.Category?.Form_1)
						 {benefitInstance.formType = "Form I"}
						 else if(formDetails?.category?.category == FormCategory?.Category?.Form_2)
						 {benefitInstance.formType = "Form II"}
						 else if(formDetails?.category?.category == FormCategory?.Category?.Form_3)
						 {benefitInstance.formType = "Form III"}
						 else if(formDetails?.category?.category == FormCategory?.Category?.Form_4)
						 {benefitInstance.formType = "Form IV"}
						 else if(formDetails?.category?.category == FormCategory?.Category?.Form_B)
						 {benefitInstance.formType = "Form B"}
						 def date = Date.parse("dd-MM-yyyy", params.dateBenefit)
						 benefitInstance.dateBenefit = date
			 
						 if(!benefitInstance.save(flush:true)){
							 benefitInstance.errors.allErrors.each {	print it}
			 
						 }else{
							 message = "Benefit Saved Successfully";
							 def uploadFiles = fileUploadService.periodicFilesUpload(getPdfFiles,benefitInstance,formDetails?.appNumber)
							 redirect(action:'receivedBenefit', params:[instance:formDetails?.id,message:message,addmore:true,csrfPreventionSalt:csrfPreventionSalt])
						 }
					 }else if(confirmation != "Validate Successfully"){
			     message = "File is not in proper format";
			    redirect(action:'receivedBenefit', params:[instance:formDetails?.id,message:message,csrfPreventionSalt:csrfPreventionSalt])
		}
		 
		 }else{

			def benefitInstance = new BenefitSharing(appNumber:params.appNumber,transNumber:params.transNumber,amountIn:params.amountIn,
			tr5ReceiptNumber:params.tr5ReceiptNumber,uploadtr5Receipt:params.uploadtr5Receipt,remarks:params.remarks,
			modeOfPayment:params.modeOfPayment,category:params.category, typeOfSharing:params.typeOfSharing,bsName:params.bsName)
			benefitInstance.applicationForm1 = formDetails
			if(formDetails?.category?.category == FormCategory?.Category?.Form_1)
			{benefitInstance.formType = "Form I"}
			else if(formDetails?.category?.category == FormCategory?.Category?.Form_2)
			{benefitInstance.formType = "Form II"}
			else if(formDetails?.category?.category == FormCategory?.Category?.Form_3)
			{benefitInstance.formType = "Form III"}
			else if(formDetails?.category?.category == FormCategory?.Category?.Form_4)
			{benefitInstance.formType = "Form IV"}
			else if(formDetails?.category?.category == FormCategory?.Category?.Form_B)
			{benefitInstance.formType = "Form B"}
			def date = Date.parse("dd-MM-yyyy", params.dateBenefit)
			benefitInstance.dateBenefit = date

			if(!benefitInstance.save(flush:true)){
				benefitInstance.errors.allErrors.each {	print it}

			}else{
				message = "Benefit Saved Successfully";
				redirect(action:'receivedBenefit', params:[instance:formDetails?.id,message:message,addmore:true,csrfPreventionSalt:csrfPreventionSalt])
			}
		} 
	}
	
	
	
	def distribution(){}
	
	
	def forwardApplication(){
		def csrfPreventionSalt = params.csrfPreventionSalt
	   def instance = applicationNotingService.addNoteForApplication(params)
	   String msg = "File forward successfully";
	   if(instance instanceof org.nba.review.AddNote)
	    redirect(action:'noting', controller:'dashboard', params:[message:msg,instance:params.applicationInstance,csrfPreventionSalt:csrfPreventionSalt])
	  return;
	}
	
	
	def showTr5Receipt(){
		
	def csrfPreventionSalt = params.csrfPreventionSalt
	def fileDetails = PeriodicFileAttach.get(Long.parseLong(params.showId))
	def file = new File(fileDetails?.pathUrl)
	response.setContentType("application/pdf")
	response.setHeader("Content-disposition","filename=${file.getName()}")
	response.outputStream << file.newInputStream()
	
	}
}
