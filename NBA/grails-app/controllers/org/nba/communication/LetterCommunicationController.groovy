package org.nba.communication

import grails.converters.JSON

import org.nba.application.ApplicationForm1
import org.nba.application.LetterIntegrationService
import org.nba.master.LetterTemplate
import org.springframework.security.access.annotation.Secured

import com.nba.constant.Constants
@Secured('permitAll')

class LetterCommunicationController {

	def applicationNotingService
	def mailCommunicationService
	def springSecurityService
	def pdfRenderingService
	def checklistManagementService
	LetterIntegrationService letterIntegrationService

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	//	def letterTemplates = ['Letter_1', 'Letter_2']


	def createCommunication(){

		def communicationInstance
		def csrfPreventionSalt = params.csrfPreventionSalt
		def formId = params.instance
		def message = params.message
		def communicaationDetails = params.communicationDetails
		if(formId == "" || formId == null){

			flash.message = "Please select an application"
			redirect(controller:'dashboard', action:'dashboard')
			return;
		}

		if(communicaationDetails != null || "" != communicaationDetails){
			communicationInstance = LetterCommunication.get(communicaationDetails as Long)
		}

		def formDetails = ApplicationForm1.get(formId)
		def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)
		def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()

		def ccEmailList = mailCommunicationService.getCCList();

		def toEmail = formDetails?.submittedBy?.email
		def letteTem = letterIntegrationService.letterTempleteDropDn()

		[letterTemplate:letteTem,dropDnValues:dropDnValues,allDataforMatching:allDataforMatching,formDetails:formDetails,
			ccEmailList:ccEmailList,formId:formId,toEmail:toEmail,message:message,communicationInstance:communicationInstance]
	}



	def saveForDraft(){

		println "inside communication approval section"
		def communicationDetails = params.communicationDetails
		def csrfPreventionSalt = params.csrfPreventionSalt
		def formId = params.formId
		def fileAttachedInstance
		ApplicationForm1 formDetails = ApplicationForm1.get(Long.parseLong(formId))

		def getAllpdfFile =  request.getFiles('files[]')
		println"file Size"+getAllpdfFile.size()

		if(communicationDetails == null || "" == communicationDetails){

			if(getAllpdfFile.size() >=1){

				def confirmation = checklistManagementService.fileValidation(getAllpdfFile)

				if(confirmation == "Validate Successfully"){

					def communicationFmtInstance = checklistManagementService.saveCommunication(params, formDetails)

					def changeltrStatus = letterIntegrationService.setLetterStatus(communicationFmtInstance?.id,LetterStatus.LtrStatus.LETTER_CREATED)
					def changeltrType = letterIntegrationService.setLetterType(communicationFmtInstance?.id,LetterType.LtrType.COM_LETTER)


					fileAttachedInstance = checklistManagementService.fileAttachmentforEmail(getAllpdfFile,communicationFmtInstance,formDetails?.appNumber)


					if(fileAttachedInstance == "File upload successfully" || fileAttachedInstance == null   || fileAttachedInstance == ''){

						redirect(action:'draftCommunication', params:[instance:formDetails?.id,communicationDetails:communicationFmtInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:fileAttachedInstance])
					}
					else if(fileAttachedInstance != "File upload successfully"){
						redirect(action:'createCommunication', params:[instance:formDetails?.id,communicationDetails:communicationFmtInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:fileAttachedInstance])
					}
				}else if(confirmation != "Validate Successfully"){

					redirect(action:'createCommunication', params:[instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt,message:confirmation])
				}
			}else{
				fileAttachedInstance = "Draft created successully"
				def communicationFmtInstance = checklistManagementService.saveCommunication(params, formDetails)
				def changeltrStatus = letterIntegrationService.setLetterStatus(communicationFmtInstance?.id,LetterStatus.LtrStatus.LETTER_CREATED)
				def changeltrType = letterIntegrationService.setLetterType(communicationFmtInstance?.id,LetterType.LtrType.COM_LETTER)

				redirect(action:'draftCommunication', params:[instance:formDetails?.id,communicationDetails:communicationFmtInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:fileAttachedInstance])
			}
		}
		else if(communicationDetails != null || "" != communicationDetails){

			def communicationIns = LetterCommunication.get(Long.parseLong(communicationDetails))

			if(getAllpdfFile.size() >= 1){

				def confirmation = checklistManagementService.fileValidation(getAllpdfFile)

				if(confirmation == "Validate Successfully"){

					def communicationFmtInstance = checklistManagementService.updateCommunication(params, communicationIns)

					def changeltrStatus = letterIntegrationService.setLetterStatus(communicationFmtInstance?.id,LetterStatus.LtrStatus.LETTER_CREATED)
					//				 def changeltrType = letterIntegrationService.setLetterType(communicationFmtInstance?.id,LetterType.LtrType.COM_LETTER)


					fileAttachedInstance = checklistManagementService.fileAttachmentforEmail(getAllpdfFile,communicationFmtInstance,formDetails?.appNumber)


					if(fileAttachedInstance == "File upload successfully" || fileAttachedInstance == null   || fileAttachedInstance == ''){

						redirect(action:'draftCommunication', params:[instance:formDetails?.id,communicationDetails:communicationFmtInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:fileAttachedInstance])
					}
					else if(fileAttachedInstance != "File upload successfully"){
						redirect(action:'createCommunication', params:[instance:formDetails?.id,communicationDetails:communicationFmtInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:fileAttachedInstance])
					}
				}else if(confirmation != "Validate Successfully"){

					redirect(action:'createCommunication', params:[instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt,message:confirmation])
				}
			}else{
				fileAttachedInstance = "Draft updated successfully"
				def communicationFmtInstance = checklistManagementService.updateCommunication(params, communicationIns)
				def changeltrStatus = letterIntegrationService.setLetterStatus(communicationFmtInstance?.id,LetterStatus.LtrStatus.LETTER_CREATED)
				//			 def changeltrType = letterIntegrationService.setLetterType(communicationFmtInstance?.id,LetterType.LtrType.COM_LETTER)

				redirect(action:'draftCommunication', params:[instance:formDetails?.id,communicationDetails:communicationFmtInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:fileAttachedInstance])
			}
		}
	}


	def draftCommunication(){

		def csrfPreventionSalt = params.csrfPreventionSalt
		def getInstance = params.instance
		def formId = params.formId
		def message = params.message

		if(getInstance == ''|| getInstance == null){
			flash.message = "Please select an application"
			redirect(controller:'dashboard', action:'dashboard')
			return;
		}


		def formDetails = ApplicationForm1.get(getInstance)
		def draftItem = LetterCommunication.where{

			applicationForm1 == formDetails &&
					letterStatus.ltrstatus == LetterStatus.LtrStatus.LETTER_CREATED &&
					letterType.ltrType == LetterType.LtrType.COM_LETTER

		}.list()

		def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)
		def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()
		
		[draftItem:draftItem,formDetails:formDetails,csrfPreventionSalt:csrfPreventionSalt,message:message,
			allDataforMatching:allDataforMatching,dropDnValues:dropDnValues]

	}

	def sendForApproval(){

		println "inside communication approval section"
		def communicationDetails = params.communicationDetails
		def csrfPreventionSalt = params.csrfPreventionSalt
		def formId = params.formId
		def fileAttachedInstance
		ApplicationForm1 formDetails = ApplicationForm1.get(Long.parseLong(formId))

		def getAllpdfFile =  request.getFiles('files[]')
		println"file Size"+getAllpdfFile.size()

		if(communicationDetails == null || "" == communicationDetails){

			if(getAllpdfFile.size() >=1){

				def confirmation = checklistManagementService.fileValidation(getAllpdfFile)

				if(confirmation == "Validate Successfully"){

					def communicationFmtInstance = checklistManagementService.saveCommunication(params, formDetails)

					def changeltrStatus = letterIntegrationService.setLetterStatus(communicationFmtInstance?.id,LetterStatus.LtrStatus.LETTER_APPROVED)
					def changeltrType = letterIntegrationService.setLetterType(communicationFmtInstance?.id,LetterType.LtrType.COM_LETTER)

					fileAttachedInstance = checklistManagementService.fileAttachmentforEmail(getAllpdfFile,communicationFmtInstance,formDetails?.appNumber)


					if(fileAttachedInstance == "File upload successfully" || fileAttachedInstance == null   || fileAttachedInstance == ''){

						redirect(action:'approveCommunication', params:[instance:formDetails?.id,communicationDetails:communicationFmtInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:fileAttachedInstance])
					}
					else if(fileAttachedInstance != "File upload successfully"){
						redirect(action:'createCommunication', params:[instance:formDetails?.id,communicationDetails:communicationFmtInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:fileAttachedInstance])
					}
				}else if(confirmation != "Validate Successfully"){

					redirect(action:'createCommunication', params:[instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt,message:confirmation])
				}
			}else{
				fileAttachedInstance = "Letter send for approval successully"
				def communicationFmtInstance = checklistManagementService.saveCommunication(params, formDetails)
				def changeltrStatus = letterIntegrationService.setLetterStatus(communicationFmtInstance?.id,LetterStatus.LtrStatus.LETTER_APPROVED)
				def changeltrType = letterIntegrationService.setLetterType(communicationFmtInstance?.id,LetterType.LtrType.COM_LETTER)
				redirect(action:'approveCommunication', params:[instance:formDetails?.id,communicationDetails:communicationFmtInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:fileAttachedInstance])
			}
		}
		else if(communicationDetails != null || "" != communicationDetails){

			def communicationIns = LetterCommunication.get(Long.parseLong(communicationDetails))

			if(getAllpdfFile.size() >= 1){

				def confirmation = checklistManagementService.fileValidation(getAllpdfFile)

				if(confirmation == "Validate Successfully"){

					def communicationFmtInstance = checklistManagementService.updateCommunication(params, communicationIns)

					def changeltrStatus = letterIntegrationService.setLetterStatus(communicationFmtInstance?.id,LetterStatus.LtrStatus.LETTER_APPROVED)

					fileAttachedInstance = checklistManagementService.fileAttachmentforEmail(getAllpdfFile,communicationFmtInstance,formDetails?.appNumber)


					if(fileAttachedInstance == "File upload successfully" || fileAttachedInstance == null   || fileAttachedInstance == ''){

						redirect(action:'approveCommunication', params:[instance:formDetails?.id,communicationDetails:communicationFmtInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:fileAttachedInstance])
					}
					else if(fileAttachedInstance != "File upload successfully"){
						redirect(action:'createCommunication', params:[instance:formDetails?.id,communicationDetails:communicationFmtInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:fileAttachedInstance])
					}
				}else if(confirmation != "Validate Successfully"){

					redirect(action:'createCommunication', params:[instance:formDetails?.id,communicationDetails:communicationIns?.id,csrfPreventionSalt:csrfPreventionSalt,message:confirmation])
				}
			}else{
				fileAttachedInstance = "Letter send for approval successully"
				def communicationFmtInstance = checklistManagementService.updateCommunication(params, communicationIns)
				def changeltrStatus = letterIntegrationService.setLetterStatus(communicationFmtInstance?.id,LetterStatus.LtrStatus.LETTER_APPROVED)
				//			 def changeltrType = letterIntegrationService.setLetterType(communicationFmtInstance?.id,LetterType.LtrType.COM_LETTER)

				redirect(action:'approveCommunication', params:[instance:formDetails?.id,communicationDetails:communicationFmtInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:fileAttachedInstance])
			}
		}
	}

	def editCommunication(){

		def draftInstance  =  params.editId
		def formId = params.formId
		def csrfPreventionSalt = params.csrfPreventionSalt
		def message =  params?.message
		def status  = params.status

		def communicationInstance = LetterCommunication.get(draftInstance as Long)
		def formDetails = ApplicationForm1.get(formId as Long)
		def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)
		def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()

		def ccEmailList = mailCommunicationService.getCCList();

		def toEmail = formDetails?.submittedBy?.email
		def letteTem = letterIntegrationService.letterTempleteDropDn()
		[communicationInstance:communicationInstance,formDetails:formDetails,letterTemplate:letteTem,allDataforMatching:allDataforMatching,
			dropDnValues:dropDnValues,csrfPreventionSalt:csrfPreventionSalt,ccEmailList:ccEmailList,toEmail:toEmail,status:status]

	}


	def approveCommunication(){

		def csrfPreventionSalt = params.csrfPreventionSalt
		def message = params.message
		def getInstance = params.instance
		if(getInstance == ''|| getInstance == null){
			flash.message = "Please select an application"
			redirect(controller:'dashboard', action:'dashboard')
			return;
		}

		def formDetails = ApplicationForm1.get(getInstance)
		def approveItem = LetterCommunication.where{

			applicationForm1 == formDetails &&
					letterStatus.ltrstatus == LetterStatus.LtrStatus.LETTER_APPROVED &&
					letterType.ltrType == LetterType.LtrType.COM_LETTER
		}.list()

		def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)
		def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()

		[approveItem:approveItem,formDetails:formDetails,csrfPreventionSalt:csrfPreventionSalt,message:message,
			allDataforMatching:allDataforMatching,dropDnValues:dropDnValues]
	}
	

		
		
	def sendEmail(){

		String fileAttachedInstance;

		def communicationDetails = params.communicationDetails
		def formId = params.formId
		def csrfPreventionSalt = params.csrfPreventionSalt
		def formDetails = ApplicationForm1.get(Long.parseLong(formId))
		def communicationIns = LetterCommunication.get(Long.parseLong(communicationDetails))

		def getAllpdfFile =  request.getFiles('files[]')

		println"File Size"+getAllpdfFile.size()
		if(getAllpdfFile.size() >=1) {

			def confirmation = checklistManagementService.fileValidation(getAllpdfFile)
			if(confirmation == "Validate Successfully"){

				def communicationInstance = checklistManagementService.updateAndSendCommunication(params, communicationIns)
				def changeltrStatus = letterIntegrationService.setLetterStatus(communicationInstance?.id,LetterStatus.LtrStatus.LETTER_SEND)
				fileAttachedInstance = checklistManagementService.fileAttachmentforEmail(getAllpdfFile,communicationInstance,formDetails?.appNumber)

				if(fileAttachedInstance == "File upload successfully" || fileAttachedInstance == null   || fileAttachedInstance == ''){
					def dynamicBody = letterIntegrationService.dynamicPdfConverter(formDetails,communicationIns, "Communication_Letter");
					def setCommunication = letterIntegrationService.setCommunicationStatusForApplicant(formDetails)
					def sendingMail = mailCommunicationService.sentLetterEmail(communicationInstance)

					redirect(action:'allSentLetters',params:[instance:formDetails?.id,communicationDetails:communicationIns?.id,message:"Letter send successfully",csrfPreventionSalt:csrfPreventionSalt])
				}else if(fileAttachedInstance != "File upload successfully"){

					def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()
					def ccEmailList = mailCommunicationService.getCCList();
					def toEmail = formDetails?.submittedBy?.email

					redirect(action:'editCommunication',params:[editId:communicationDetails,formId:formId,message:fileAttachedInstance,csrfPreventionSalt:csrfPreventionSalt])
				}
			}else if(confirmation == "No file selected"){

				def communicationInstance = checklistManagementService.updateCommunication(params, communicationIns)
				def changeltrStatus = letterIntegrationService.setLetterStatus(communicationInstance?.id,LetterStatus.LtrStatus.LETTER_SEND)
				def dynamicBody = letterIntegrationService.dynamicPdfConverter(formDetails,communicationIns, "Communication_Letter");
				def setCommunication = letterIntegrationService.setCommunicationStatusForApplicant(formDetails)
				def sendingMail = mailCommunicationService.sentLetterEmail(communicationInstance)

				redirect(action:'allSentLetters',params:[instance:formDetails?.id,communicationDetails:communicationIns?.id,message:"Letter send successfully",csrfPreventionSalt:csrfPreventionSalt])
			}

			else if(confirmation != "Validate Successfully"){

				//	  def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()
				//	  def ccEmailList = mailCommunicationService.getCCList();
				//	  def toEmail = formDetails?.submittedBy?.email

				redirect(action:'editCommunication',params:[editId:communicationDetails,formId:formId,message:confirmation,csrfPreventionSalt:csrfPreventionSalt])
			}

		}else{

			def communicationInstance = checklistManagementService.updateAndSendCommunication(params, communicationIns)
			def changeltrStatus = letterIntegrationService.setLetterStatus(communicationInstance?.id,LetterStatus.LtrStatus.LETTER_SEND)
			def dynamicBody = letterIntegrationService.dynamicPdfConverter(formDetails,communicationIns, "Communication_Letter");
			def setCommunication = letterIntegrationService.setCommunicationStatusForApplicant(formDetails)
			def sendingMail = mailCommunicationService.sentLetterEmail(communicationInstance)
			fileAttachedInstance = "Letter send successfully"
			redirect(action:'allSentLetters',params:[instance:formDetails?.id,communicationDetails:communicationIns?.id,message:fileAttachedInstance,csrfPreventionSalt:csrfPreventionSalt])
		}
	}


	//------------------------------------------ TR5 receipt module in letter communication

	def tr5Create(){

		def csrfPreventionSalt = params.csrfPreventionSalt
		def getInstance = params.instance
		def tr5ReceiptInstance = params?.tr5Instance
		def message = params.message
		if(getInstance == '' || getInstance == null){

			flash.message = "Please select an application"
			redirect(controller:'dashboard', action:'dashboard')
			return;
		}
		if(tr5ReceiptInstance != null || "" != tr5ReceiptInstance){

			tr5ReceiptInstance = LetterCommunication.get(tr5ReceiptInstance as Long)
		}

		def formDetails = ApplicationForm1.get(getInstance)

		String formCategory = formDetails?.category?.category
		def eReceipt = checklistManagementService.dynamicEReceiptGenerator(formCategory);

		def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)
		def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()
		def ccEmailList = mailCommunicationService.getCCList();

		println "formDetails"+formDetails
		[formDetails:formDetails,tr5ReceiptInstance:tr5ReceiptInstance,eReceipt:eReceipt,allDataforMatching:allDataforMatching,dropDnValues:dropDnValues,
			csrfPreventionSalt:csrfPreventionSalt,ccEmailList:ccEmailList,message:message]

	}


	def tr5LetterSave(){
		def getInstance = params.instance
		def csrfPreventionSalt = params.csrfPreventionSalt
		def tr5Instance = params.tr5Instance
		def formDetails = ApplicationForm1.get(Long.parseLong(getInstance))

		if(tr5Instance == null || "" == tr5Instance){


			def tr5ReceiptInstance = checklistManagementService.saveCommunication(params, formDetails)
			println "----------"+tr5ReceiptInstance

			def changeltrStatus = letterIntegrationService.setLetterStatus(tr5ReceiptInstance?.id,LetterStatus.LtrStatus.LETTER_CREATED)
			def changeltrType = letterIntegrationService.setLetterType(tr5ReceiptInstance?.id,LetterType.LtrType.TR5_LETTER)

			def getAllpdfFile =  request.getFiles('files[]');
			if(getAllpdfFile.size() >= 1){
				def fileAttachedInstance = checklistManagementService.fileAttachmentforEmail(getAllpdfFile,tr5ReceiptInstance,formDetails?.appNumber)
			}
			def message = "TR5 send to draft successfully"
			redirect(action:'tr5Draft',params:[instance:formDetails?.id,tr5Instance:tr5ReceiptInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:message])
		}
		else if(tr5Instance != null || "" != tr5Instance){
			def tr5Ins = LetterCommunication.get(tr5Instance as Long)
			def tr5ReceiptInstance = checklistManagementService.updateCommunication(params, tr5Ins)

			def changeltrStatus = letterIntegrationService.setLetterStatus(tr5ReceiptInstance?.id,LetterStatus.LtrStatus.LETTER_CREATED)
			def changeltrType = letterIntegrationService.setLetterType(tr5ReceiptInstance?.id,LetterType.LtrType.TR5_LETTER)

			def getAllpdfFile =  request.getFiles('files[]')
			if(getAllpdfFile.size() >= 1){
				def fileAttachedInstance = checklistManagementService.fileAttachmentforEmail(getAllpdfFile,tr5ReceiptInstance,formDetails?.appNumber)
			}

			def message = "TR5 draft update successfully"
			redirect(action:'tr5Draft',params:[instance:formDetails?.id,tr5Instance:tr5ReceiptInstance?.id, csrfPreventionSalt:csrfPreventionSalt,message:message])
		}
	}


	def tr5Draft(){
		def formId = params.instance
		def message = params.message
		if(formId == '' || formId == null){
			flash.message = "Please select an application"
			redirect(controller:'dashboard', action:'dashboard')
			return;
		}

		def csrfPreventionSalt = params.csrfPreventionSalt
		
		def formDetails = ApplicationForm1.get(Long.parseLong(formId))
		def draftItem = LetterCommunication.where{

			applicationForm1 == formDetails &&
					letterStatus.ltrstatus == LetterStatus.LtrStatus.LETTER_CREATED &&
					letterType.ltrType == LetterType.LtrType.TR5_LETTER

		}.list()

		def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)
		def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()
		
		[draftItem:draftItem,formDetails:formDetails,csrfPreventionSalt:csrfPreventionSalt,message:message,
			allDataforMatching:allDataforMatching,dropDnValues:dropDnValues]
	}
	
	
	

	def moveForApproval(){

		def tr5Instance = params.tr5Instance
		def getInstance = params.instance
		def csrfPreventionSalt = params.csrfPreventionSalt

		def formDetails = ApplicationForm1.get(Long.parseLong(getInstance))
		if(tr5Instance == null || "" == tr5Instance){

			def tr5ReceiptInstance = checklistManagementService.saveCommunication(params, formDetails);

			def changeltrStatus = letterIntegrationService.setLetterStatus(tr5ReceiptInstance?.id,LetterStatus.LtrStatus.LETTER_APPROVED)
			def changeltrType = letterIntegrationService.setLetterType(tr5ReceiptInstance?.id,LetterType.LtrType.TR5_LETTER)
			def getAllpdfFile =  request.getFiles('files[]');
			if(getAllpdfFile.size() >= 1){
				def fileAttachedInstance = checklistManagementService.fileAttachmentforEmail(getAllpdfFile,tr5ReceiptInstance,formDetails?.appNumber)
			}
			def message = "TR5 send for approve successfully"
			redirect(action:'tr5Approve',params:[instance:formDetails?.id,tr5Instance:tr5ReceiptInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:message])
		}else if(tr5Instance != null || "" != tr5Instance){

			def tr5Ins = LetterCommunication.get(tr5Instance as Long)
			def tr5ReceiptInstance = checklistManagementService.updateCommunication(params, tr5Ins)

			def changeltrStatus = letterIntegrationService.setLetterStatus(tr5ReceiptInstance?.id,LetterStatus.LtrStatus.LETTER_APPROVED)

			def getAllpdfFile =  request.getFiles('files[]')
			if(getAllpdfFile.size() >= 1){
				def fileAttachedInstance = checklistManagementService.fileAttachmentforEmail(getAllpdfFile,tr5ReceiptInstance,formDetails?.appNumber)
			}
			def message = "TR5 send for approve successfully"
			redirect(action:'tr5Approve',params:[instance:formDetails?.id,tr5Instance:tr5ReceiptInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:message])

		}
	}




	def tr5LetterEdit(){
		def formId = params.instance
		def csrfPreventionSalt = params.csrfPreventionSalt
		def editIns = params.dftIns
		def status = params.status

		if(formId == '' || formId == null){
			flash.message = "Please select an application"
			redirect(controller:'dashboard', action:'dashboard')
			return;
		}
		def tr5ReceiptInstance = LetterCommunication.get(Long.parseLong(editIns))
		def formDetails = ApplicationForm1.get(Long.parseLong(formId))
		def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)
		def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()
		def ccEmailList = mailCommunicationService.getCCList();

		[tr5ReceiptInstance:tr5ReceiptInstance,formDetails:formDetails,allDataforMatching:allDataforMatching,
			dropDnValues:dropDnValues,csrfPreventionSalt:csrfPreventionSalt,ccEmailList:ccEmailList,status:status]

	}


	def tr5Approve(){

		def formId = params.instance
		def message = params.message

		if(formId == '' || formId == null){
			flash.message = "Please select an application"
			redirect(controller:'dashboard', action:'dashboard')
			return;
		}

		def csrfPreventionSalt = params.csrfPreventionSalt
		def formDetails = ApplicationForm1.get(Long.parseLong(formId))

		def approveItem = LetterCommunication.where{

			applicationForm1 == formDetails &&
					letterStatus.ltrstatus == LetterStatus.LtrStatus.LETTER_APPROVED &&
					letterType.ltrType == LetterType.LtrType.TR5_LETTER
		}.list()

		def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)
		def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()

		[approveItem:approveItem,formDetails:formDetails,csrfPreventionSalt:csrfPreventionSalt,message:message,
			allDataforMatching:allDataforMatching,dropDnValues:dropDnValues]
	}


	def tr5ReceiptSent(){
		def sendLtrId = params.tr5Instance
		def getInstance = params?.instance
		def csrfPreventionSalt = params.csrfPreventionSalt
		def formDetails = ApplicationForm1.get(getInstance as Long)

		if(getInstance == '' || getInstance == null){
			flash.message = "Please select an application"
			redirect(controller:'dashboard', action:'dashboard')
			return;
		}
		def letterCommunicationInstance = LetterCommunication.get(sendLtrId as Long)
		def tr5ReceiptInstance = checklistManagementService.updateAndSendCommunication(params, letterCommunicationInstance)


		def changeltrStatus = letterIntegrationService.setLetterStatus(tr5ReceiptInstance?.id,LetterStatus.LtrStatus.LETTER_SEND)

		def getAllpdfFile =  request.getFiles('files[]')
		if(getAllpdfFile.size() >= 1){
			def fileAttachedInstance = checklistManagementService.fileAttachmentforEmail(getAllpdfFile,tr5ReceiptInstance,formDetails?.appNumber)
		}

		def dynamicBody = letterIntegrationService.dynamicPdfConverter(formDetails,letterCommunicationInstance, "TR5_Letter");
		def setCommunication = letterIntegrationService.setCommunicationStatusForApplicant(formDetails)
		def sendingMail = mailCommunicationService.sentTr5Email(tr5ReceiptInstance,formDetails)

		def message = "letter send successfully"
		redirect(action:'allSentLetters',params:[instance:formDetails?.id,tr5Instance:letterCommunicationInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:message])
	}

	//-----------------------------------------------TR5 End---------------------------------------------




	// ------------------------------SBB Letter communication ------------------------------------------------------

	// def letterTemplate = ['Form I Entity Template','Additional Information','Closure','REVIEW TEAM','AGREEMENT']


	def sbbCreate() {
		def sbbConsentInstance;
		def csrfPreventionSalt = params.csrfPreventionSalt
		def formId = params.instance
		def message = params?.message
		def sbbConsentObj = params.sbbConsentInstance
		if(formId == "" || formId == null){

			flash.message = "Please select an application"
			redirect(controller:'dashboard', action:'dashboard')
			return;
		}

		if(sbbConsentObj != null || "" != sbbConsentObj){

			sbbConsentInstance = LetterCommunication.get(sbbConsentObj as Long)
		}

		def formDetails = ApplicationForm1.get(formId)
		def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)
		def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()

		def sbbEmailIds = mailCommunicationService.getSbbEmail()
		def ccUser = mailCommunicationService.getCCList();
		def letteTem = letterIntegrationService.letterTempleteDropDn()

		[dropDnValues:dropDnValues,allDataforMatching:allDataforMatching,formDetails:formDetails,formId:formId,sbbConsentInstance:sbbConsentInstance,
			letterTemplate:letteTem,sbbEmailIds:sbbEmailIds,ccUser:ccUser,message:message]

	}


	def saveSbbLetter(){

		def formId = params.formId
		def csrfPreventionSalt  = params.csrfPreventionSalt
		println "inside save sbb"
		def sbbInstance = params.sbbConsentInstance
		def sbbConsentIns,fileAttachedInstance
		def formDetails = ApplicationForm1.get(Long.parseLong(formId))

		def getAllpdfFile =  request.getFiles('files[]')
		println"file Size"+getAllpdfFile.size()

		if(sbbInstance == null || "" == sbbInstance){

			if(getAllpdfFile.size() >=1){

				def confirmation = checklistManagementService.fileValidation(getAllpdfFile)

				if(confirmation == "Validate Successfully"){

					def sbbConsentObj = checklistManagementService.saveCommunication(params,formDetails);
					def  message = 'Letter move in draft successfully'
					def changeltrStatus = letterIntegrationService.setLetterStatus(sbbConsentObj?.id,LetterStatus.LtrStatus.LETTER_CREATED)
					def changeltrType = letterIntegrationService.setLetterType(sbbConsentObj?.id,LetterType.LtrType.SBB_LETTER)

					fileAttachedInstance = checklistManagementService.fileAttachmentforEmail(getAllpdfFile,sbbConsentObj,formDetails?.appNumber)


					if(fileAttachedInstance == "File upload successfully" || fileAttachedInstance == null   || fileAttachedInstance == ''){



						redirect(action:'sbbDraft', params:[instance:formDetails?.id,sbbConsentInstance:sbbConsentObj?.id,csrfPreventionSalt:csrfPreventionSalt,message:message])
					}

					else if(fileAttachedInstance != "File upload successfully"){
						redirect(action:'sbbCreate', params:[instance:formDetails?.id,sbbConsentInstance:sbbConsentObj?.id,csrfPreventionSalt:csrfPreventionSalt,message:fileAttachedInstance])
					}
				}else if(confirmation != "Validate Successfully"){

					redirect(action:'sbbCreate', params:[instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt,message:confirmation])

				}
//				else if(confirmation != "Validate Successfully"){

//					redirect(action:'createCommunication', params:[instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt,message:confirmation])
//				}
			}else{

				def sbbConsentObj = checklistManagementService.saveCommunication(params,formDetails);
				def  message = 'Letter move in draft successfully'
				def changeltrStatus = letterIntegrationService.setLetterStatus(sbbConsentObj?.id,LetterStatus.LtrStatus.LETTER_CREATED)
				def changeltrType = letterIntegrationService.setLetterType(sbbConsentObj?.id,LetterType.LtrType.SBB_LETTER)

				redirect(action:'sbbDraft', params:[instance:formDetails?.id,sbbConsentInstance:sbbConsentObj?.id,csrfPreventionSalt:csrfPreventionSalt,message:message])
			}

		}else if(sbbInstance != null || "" != sbbInstance){

			if(getAllpdfFile.size() >=1){

				def confirmation = checklistManagementService.fileValidation(getAllpdfFile)

				if(confirmation == "Validate Successfully"){
					sbbConsentIns = LetterCommunication.get(Long.parseLong(sbbInstance))
					def sbbConsentInstance = checklistManagementService.updateCommunication(params,sbbConsentIns)

					def  message = 'Letter updated successfully'
					def changeltrStatus = letterIntegrationService.setLetterStatus(sbbConsentInstance?.id,LetterStatus.LtrStatus.LETTER_CREATED)
					def changeltrType = letterIntegrationService.setLetterType(sbbConsentInstance?.id,LetterType.LtrType.SBB_LETTER)

					fileAttachedInstance = checklistManagementService.fileAttachmentforEmail(getAllpdfFile,sbbConsentInstance,formDetails?.appNumber)


					if(fileAttachedInstance == "File upload successfully" || fileAttachedInstance == null   || fileAttachedInstance == ''){



						redirect(action:'sbbDraft', params:[instance:formDetails?.id,sbbConsentInstance:sbbConsentInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:message])
					}

					else if(fileAttachedInstance != "File upload successfully"){
						redirect(action:'sbbCreate', params:[instance:formDetails?.id,sbbConsentInstance:sbbConsentInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:fileAttachedInstance])
					}
				}else if(confirmation != "Validate Successfully"){

					redirect(action:'sbbCreate', params:[instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt,message:confirmation])

				}
				
//				else if(confirmation != "Validate Successfully"){
//
//					redirect(action:'sbbCreate', params:[instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt,message:confirmation])
//				}
			}else{

				sbbConsentIns = LetterCommunication.get(Long.parseLong(sbbInstance))
				def sbbConsentInstance = checklistManagementService.updateCommunication(params,sbbConsentIns)
				def  message = 'Letter updated successfully'
				def changeltrStatus = letterIntegrationService.setLetterStatus(sbbConsentInstance?.id,LetterStatus.LtrStatus.LETTER_CREATED)

				redirect(action:'sbbDraft',params:[instance:formDetails?.id,sbbConsentInstance:sbbConsentInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:message])

			}
		}
	}

		
	
		def sbbDraft() {
	
			def csrfPreventionSalt = params.csrfPreventionSalt
			def getInstance = params.instance
			def message = params.message
	
			if(getInstance == ''|| getInstance == null){
				flash.message = "Please select an application"
				redirect(controller:'dashboard', action:'dashboard')
				return;
			}
	
			def formDetails = ApplicationForm1.get(getInstance)
	
			def draftItem = LetterCommunication.where{
	
				applicationForm1 == formDetails &&
						letterStatus.ltrstatus == LetterStatus.LtrStatus.LETTER_CREATED &&
						letterType.ltrType == LetterType.LtrType.SBB_LETTER
	
			}.list()
	
			def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)
			def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()
			
			[draftItem:draftItem,formDetails:formDetails,csrfPreventionSalt:csrfPreventionSalt,message:message,
			allDataforMatching:allDataforMatching,dropDnValues:dropDnValues	]
	
		}
	
	
		def editSbbDraftLtr(){
			def draftInstance  =  params.editId
			def formId = params.formId
			def csrfPreventionSalt = params.csrfPreventionSalt
			def status = params.status
			def message = params.message
	
			def sbbConsentInstance = LetterCommunication.get(draftInstance as Long)
			def formDetails = ApplicationForm1.get(formId as Long)
			def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)
			def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()
	
			def sbbEmailIds = mailCommunicationService.getSbbEmail()
			def ccUser = mailCommunicationService.getCCList();
	
			[sbbConsentInstance:sbbConsentInstance,formDetails:formDetails,allDataforMatching:allDataforMatching,
				dropDnValues:dropDnValues,csrfPreventionSalt:csrfPreventionSalt,sbbEmailIds:sbbEmailIds,ccUser:ccUser,status:status,message:message]
	
		}
	
	
	

	def sendForSbbApproval(){
		def formId = params.formId
		def csrfPreventionSalt  = params.csrfPreventionSalt
		println "inside approve sbb"
		def sbbConsentIns,fileAttachedInstance
		def sbbInstance = params.sbbConsentInstance
		def formDetails = ApplicationForm1.get(Long.parseLong(formId))




		def getAllpdfFile =  request.getFiles('files[]')
		println"file Size"+getAllpdfFile.size()

		if(sbbInstance == null || "" == sbbInstance){

			if(getAllpdfFile.size() >=1){

				def confirmation = checklistManagementService.fileValidation(getAllpdfFile)

				if(confirmation == "Validate Successfully"){

					def sbbConsentObj = checklistManagementService.saveCommunication(params, formDetails)
					def message = "Letter move for approval successfully"
					def changeltrStatus = letterIntegrationService.setLetterStatus(sbbConsentObj?.id, LetterStatus.LtrStatus.LETTER_APPROVED)
					def changeltrType = letterIntegrationService.setLetterType(sbbConsentObj?.id,LetterType.LtrType.SBB_LETTER);

					fileAttachedInstance = checklistManagementService.fileAttachmentforEmail(getAllpdfFile,sbbConsentObj,formDetails?.appNumber)


					if(fileAttachedInstance == "File upload successfully" || fileAttachedInstance == null   || fileAttachedInstance == ''){



						redirect(action:'sbbApprove', params:[instance:formDetails?.id,sbbConsentInstance:sbbConsentObj?.id,csrfPreventionSalt:csrfPreventionSalt,message:message])
					}

					else if(fileAttachedInstance != "File upload successfully"){
						redirect(action:'sbbCreate', params:[instance:formDetails?.id,sbbConsentInstance:sbbConsentObj?.id,csrfPreventionSalt:csrfPreventionSalt,message:fileAttachedInstance])
					}
				}else if(confirmation != "Validate Successfully"){

					redirect(action:'sbbCreate', params:[instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt,message:confirmation])

				}
			}else{

				def sbbConsentObj = checklistManagementService.saveCommunication(params, formDetails)
				def message = "Letter move for approval successfully"
				def changeltrStatus = letterIntegrationService.setLetterStatus(sbbConsentObj?.id, LetterStatus.LtrStatus.LETTER_APPROVED)
				def changeltrType = letterIntegrationService.setLetterType(sbbConsentObj?.id,LetterType.LtrType.SBB_LETTER);

				redirect(action:'sbbApprove', params:[instance:formDetails?.id,sbbConsentInstance:sbbConsentObj?.id,csrfPreventionSalt:csrfPreventionSalt,message:message])
			}

		}else if(sbbInstance != null || "" != sbbInstance){

			if(getAllpdfFile.size() >=1){

				def confirmation = checklistManagementService.fileValidation(getAllpdfFile)

				if(confirmation == "Validate Successfully"){


					sbbConsentIns = LetterCommunication.get(Long.parseLong(sbbInstance))
					def sbbConsentInstance = checklistManagementService.updateCommunication(params,sbbConsentIns)
					def message = "Letter move for approval successfully"
					def changeltrStatus = letterIntegrationService.setLetterStatus(sbbConsentIns?.id,LetterStatus.LtrStatus.LETTER_APPROVED)

					fileAttachedInstance = checklistManagementService.fileAttachmentforEmail(getAllpdfFile,sbbConsentInstance,formDetails?.appNumber)


					if(fileAttachedInstance == "File upload successfully" || fileAttachedInstance == null   || fileAttachedInstance == ''){

						redirect(action:'sbbApprove', params:[instance:formDetails?.id,sbbConsentInstance:sbbConsentInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:message])
					}

					else if(fileAttachedInstance != "File upload successfully"){
						redirect(action:'sbbCreate', params:[instance:formDetails?.id,sbbConsentInstance:sbbConsentInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:fileAttachedInstance])
					}
				}else if(confirmation != "Validate Successfully"){

					redirect(action:'sbbCreate', params:[instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt,message:confirmation])

				}
			}else{

				sbbConsentIns = LetterCommunication.get(Long.parseLong(sbbInstance))
				def sbbConsentInstance = checklistManagementService.updateCommunication(params,sbbConsentIns)
				def message = "Letter move for approval successfully"
				def changeltrStatus = letterIntegrationService.setLetterStatus(sbbConsentIns?.id,LetterStatus.LtrStatus.LETTER_APPROVED)

				redirect(action:'sbbApprove',params:[instance:formDetails?.id,sbbConsentInstance:sbbConsentInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:message])

			}
		}
	}


	
	def sbbApprove() {
		
				def csrfPreventionSalt = params.csrfPreventionSalt
		
				def getInstance = params.instance
				if(getInstance == ''|| getInstance == null){
					flash.message = "Please select an application"
					redirect(controller:'dashboard', action:'dashboard')
					return;
				}
		
				def formDetails = ApplicationForm1.get(getInstance)
				def approveItem = LetterCommunication.where{
		
					applicationForm1 == formDetails &&
							letterStatus.ltrstatus == LetterStatus.LtrStatus.LETTER_APPROVED &&
							letterType.ltrType == LetterType.LtrType.SBB_LETTER
				}.list()
		
				def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)
				def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()
				
				[approveItem:approveItem,formDetails:formDetails,csrfPreventionSalt:csrfPreventionSalt,
					allDataforMatching:allDataforMatching,dropDnValues:dropDnValues]
			}
		
		


	def sendSbbLetter(){

		def sbbInstance = params.sbbConsentInstance
		def formId = params.formId
		def csrfPreventionSalt = params.csrfPreventionSalt
		def formDetails = ApplicationForm1.get(Long.parseLong(formId))
		def sbbConsentIns = LetterCommunication.get(Long.parseLong(sbbInstance))

		def checkForSBB = letterIntegrationService.letterExistsToSBB(formDetails,sbbConsentIns)
		if(checkForSBB == Constants.SBB_CONSENT_CONF){
			redirect (action:'editSbbDraftLtr', params:[editId:sbbInstance,formId:formId,status:'true',csrfPreventionSalt:csrfPreventionSalt,message:checkForSBB])
			return;
		} else if(checkForSBB == Constants.SBB_CONSENT_NEW){

			def sbbConsentInstance = checklistManagementService.updateAndSendCommunication(params, sbbConsentIns)
			def sendToSBB = letterIntegrationService.mapSbbValue(formDetails, sbbConsentIns);
			def changeltrStatus = letterIntegrationService.setLetterStatus(sbbConsentInstance?.id,LetterStatus.LtrStatus.LETTER_SEND)
			def dynamicBody = letterIntegrationService.dynamicPdfConverter(formDetails,sbbConsentIns, "SBB_Letter");
			def setCommunication = letterIntegrationService.setCommunicationStatusForApplicant(formDetails)
			def sendingMail = mailCommunicationService.sentSbbLetterEmail(sbbConsentInstance)
			def message = "letter send successfully"
			redirect(action:'allSentLetters',params:[instance:formDetails?.id,sbbConsentInstance:sbbConsentIns?.id,csrfPreventionSalt:csrfPreventionSalt,message:message])
		}
	}

	
	//------------------------------------SBB Letter  Ending---------------------------------


	def allSentLetters(){
		def getFormId = params.instance
		def csrfPreventionSalt = params.csrfPreventionSalt
		def message = params.message

		if(getFormId == "" || getFormId == null){

			flash.message = "Please select an application"
			redirect(controller:'dashboard', action:'dashboard')
			return;
		}

		def formDetails = ApplicationForm1.get(getFormId)
		def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)

		def appLetter = LetterCommunication.where{

			applicationForm1 == formDetails && (letterStatus.ltrstatus == LetterStatus.LtrStatus.LETTER_SEND)
		}.list()

		render(view: "sentLetterDetails", model: [appLetter:appLetter,allDataforMatching:allDataforMatching, formDetails:formDetails,message:message,csrfPreventionSalt:csrfPreventionSalt])
	}



	def communicationFileShow(){
		def csrfPreventionSalt = params.csrfPreventionSalt
		def detailsForFile = PdfFileAttachment.get(params?.showId)
		def file = new File(detailsForFile?.attachedUrl)
		String fileName = file.getName().toString()
		def fileExt =  fileName.substring(fileName.lastIndexOf("."));
		println "file url is" +file

		if(fileExt == '.pdf'){
			response.setContentType("application/pdf")
			response.setHeader("Content-disposition","filename=${file.getName()}")
			response.outputStream << file.newInputStream()

		}else{
			response.setContentType("APPLICATION/OCTET-STREAM")
			response.setHeader("Content-Disposition", "Attachment;Filename=\"${fileName}\"")
			def fileInputStream = new FileInputStream(file)
			def outputStream = response.getOutputStream()
			byte[] buffer = new byte[4096];
			int len;
			while ((len = fileInputStream.read(buffer)) > 0) {
				outputStream.write(buffer, 0, len);
			}
			response.outputStream << file.newInputStream()
			//   outputStream.flush()
			outputStream.close()
			fileInputStream.close()

		}
	}

	def dynamicShowPdf(){

		def csrfPreventionSalt = params.csrfPreventionSalt
		def detailsForFile = LetterCommunication.get(params?.dynamicId)
		def file = new File(detailsForFile?.bodyPdfUrl)
		response.setContentType("application/pdf")
		response.setHeader("Content-disposition","filename=${file.getName()}")
		response.outputStream << file.newInputStream()

	}


	def letterChanged(String categoryId) {
		def csrfPreventionSalt = params.csrfPreventionSalt
		//		def letteTem = letterIntegrationService.letterTempleteDropDn()
		//		def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()

		def bodyContent = LetterTemplate.findByLetterName(categoryId)

		def result = [bodyContent:bodyContent?.templateLetter,]
		println"0000000000"+result
		//		def result = [letterTemplate:letteTem,bodyContent:bodyContent?.templateLetter,dropDnValues:dropDnValues,csrfPreventionSalt:csrfPreventionSalt]
		render result as JSON
	}

	def deleteCommunicationPdf(){

		def getDeleteIns = params.deleteId
		def formId = params.formId
		def csrfPreventionSalt = params.csrfPreventionSalt
		def deletePdfInstance = PdfFileAttachment.get(getDeleteIns as Long)

		LetterCommunication letterId = deletePdfInstance?.letterCommunication

		String fileUrl = deletePdfInstance?.attachedUrl
		def getPdf = new File(fileUrl)

		if(getPdf.exists()){
			if(getPdf.delete()){
				if(!deletePdfInstance.delete(flush:true)){
					deletePdfInstance.errors.allErrors.each {print it}
				}
				redirect(action:'editCommunication',params:[editId:letterId?.id,formId:formId,csrfPreventionSalt:csrfPreventionSalt])
			}else{
				redirect(action:'editCommunication',params:[editId:letterId?.id,formId:formId,csrfPreventionSalt:csrfPreventionSalt,msg:'Pdf not Deteted'])
			}
		}else{
			redirect(action:'editCommunication',params:[editId:letterId?.id,formId:formId,csrfPreventionSalt:csrfPreventionSalt,msg:'Pdf not Found'])

		}
	}



	def forwardApplication(){

		def csrfPreventionSalt = params.csrfPreventionSalt
		def msg = 'File forward successfully'
		def instance = applicationNotingService.addNoteForApplication(params)

		if(instance instanceof org.nba.review.AddNote)
			redirect(action:'noting', controller:'dashboard', params:[message:msg,instance:params.applicationInstance,csrfPreventionSalt:csrfPreventionSalt])
		return;

	}

	def backtDash(){
		redirect(controller:'dashboard',action:'dashboard')
		return
	}


	def receivedCommunication(){
		def getFormId = params.instance
		def csrfPreventionSalt = params.csrfPreventionSalt

		def formDetails = ApplicationForm1.get(getFormId)

		def appLetter = ClientLetter.where{

			applicationForm == formDetails && (responceletterStatus.ltrstatus == ResponceLetterStatus.LtrStatus.SBB_RESPONSE
					|| responceletterStatus.ltrstatus == ResponceLetterStatus.LtrStatus.APPLICANT_RESPONSE)
		}.list()
		
		def ssbConsent = SBBConsent.where{
			applicationForm1 == formDetails  && consentStatus == Constants.SBB_CONSENT

		}
		
		def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)
		def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()

		[appLetter:appLetter,ssbConsent:ssbConsent,allDataforMatching:allDataforMatching, formDetails:formDetails,
			dropDnValues:dropDnValues,csrfPreventionSalt:csrfPreventionSalt]


	}


	def viewCommunication(){
		def csrfPreventionSalt = params.csrfPreventionSalt
		def showId = params.editId
		def  letterDetails = ClientLetter.get(showId as Long)
		render(template:'/common/viewClientLetter',model:[letterDetails:letterDetails])

	}

	def viewLetterDetails(){
		def showId = params.editId
		def csrfPreventionSalt = params.csrfPreventionSalt
		def  letterDetails = LetterCommunication.get(showId as Long)
		render(template:'/common/nbaLetterDetails', model:[letterDetails:letterDetails,appForm1:letterDetails?.applicationForm1])
	}


	//		def getSbbEmailId(String name){
	//
	//			def result = [email:NbaUser.findByName(name)?.email]
	//			render result as JSON
	//
	//		}
}
