package org.nba.expert
import java.time.LocalDate

import org.nba.application.ApplicationForm1
import org.nba.communication.ClientLetter
import org.nba.communication.LetterCommunication
import org.nba.communication.LetterStatus
import org.nba.communication.LetterType
import org.nba.communication.PdfFileAttachment
import org.nba.communication.ResponceLetterStatus
import org.nba.communication.SBBConsent
import org.nba.user.NbaUser
import org.springframework.security.access.annotation.Secured

import com.nba.constant.Constants

@Secured('permitAll')
class SBBController {

	def springSecurityService
    def applicationNotingService
	def letterIntegrationService
	def checklistManagementService
	def grailsApplication
 
	def sbbDashboard(){
		
		def applicationDetails,applicationSize, inProcessApplications,inprocessSize
		 
		
		def csrfPreventionSalt = params.csrfPreventionSalt
	
		def loginSbb = springSecurityService?.getCurrentUser()?.username 
		applicationDetails = SBBConsent.findAllBySbbUserNameAndResponceStatus(loginSbb , true)?.applicationForm1

		inProcessApplications = SBBConsent.findAllBySbbUserNameAndResponceStatus(loginSbb , false)?.applicationForm1
		
		[applicationDetails:applicationDetails,inProcessApplications:inProcessApplications,csrfPreventionSalt:csrfPreventionSalt]
	}
	
//	def noting(){
//
//		def csrfPreventionSalt = params.csrfPreventionSalt
//		def message = params.message
//
//		params.max = Math.min(params.max ? params.int('max') : 10, 100)
//
//		if(params.instance == "" || params.instance == null){
//
//			flash.message = "Please select an application"
//			redirect(action:'sbbDashboard', params:[csrfPreventionSalt:csrfPreventionSalt])
//			return;
//		}
//
//		ApplicationForm1 formDetails = ApplicationForm1.get(Long.parseLong(params.instance))
//
//		def applicationNum = formDetails?.appNumber
//		def submittedDate  = formDetails?.submittedOn
//
//		println "formDetails"+formDetails.getClass()
//
//		println "applicationNum"+applicationNum
//
//		//		def viewNoteDetails = AddNote.findAllByFormNumber(applicationNum)
//
//		def query = AddNote.where { formNumber == applicationNum }
//		def commentCount = query.list().size()
//		def viewNoteDetails = query.list(params).sort{it.noteDate}.reverse()
//
//
//		def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)
//
//		[allDataforMatching:allDataforMatching,viewNoteDetails:viewNoteDetails,formDetails:formDetails, commentCount :commentCount,
//			applicationNum:applicationNum,submittedDate:submittedDate,csrfPreventionSalt:csrfPreventionSalt,params:params,message:message]
//	}


//	def addComment(){
//
//		def csrfPreventionSalt = params.csrfPreventionSalt
//		def formId = params.instance
//		def message = params.message
//		def addNoteInstance = new AddNote()
//
//
//		if(formId == "" || formId == null){
//
//			flash.message = "Please select an application"
//			redirect(action:'sbbDashboard',params:[csrfPreventionSalt:csrfPreventionSalt])
//			return;
//		}
//
//		def formDetails = ApplicationForm1.get(Long.parseLong(formId))
//
//		def applicationNum = formDetails?.appNumber
//		def submittedDate  = formDetails?.submittedOn
//		println "formDetails"+formDetails.getClass()
//
//		def currentLoginUser = springSecurityService?.getCurrentUser()?.username
//		def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()
//
//		def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)
//
//		[addNoteInstance:addNoteInstance,applicationNum:applicationNum,submittedDate:submittedDate,dropDnValues:dropDnValues,
//			formDetails:formDetails,allDataforMatching:allDataforMatching,message:message,csrfPreventionSalt:csrfPreventionSalt]
//	}
	
	
//	def saveComment(){
//
//		def csrfPreventionSalt = params.csrfPreventionSalt
//		def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()
//
//		if(params.applicationInstance == "" || params.applicationInstance == null){
//
//			flash.message = "Application Form Number missing"
//			render( view: "addComment",  model: [dropDnValues:dropDnValues])
//			return
//		}
//
//		def getAllpdfFile =  request.getFiles('files[]')
//		println "received files are here--------"+getAllpdfFile
//
//		ApplicationForm1 appInstance = ApplicationForm1.get(Long.parseLong(params.applicationInstance))
//		def applicationNumber = appInstance?.appNumber
//		String msg = "File forward successfully";
//
//		if(getAllpdfFile.size() > 0){
//
//			def checkFile = applicationNotingService.checkFileValidation(getAllpdfFile)
//			if(checkFile == "Validate Successfully"){
//				def instance = applicationNotingService.addNoteForApplication(params)
//				if(instance instanceof org.nba.review.AddNote){
//					def uploadFile = applicationNotingService.transferFile(getAllpdfFile,applicationNumber,instance)
//
//					if(uploadFile == true){
//						redirect(action:'noting', params:[message:msg,instance:params.applicationInstance,csrfPreventionSalt:csrfPreventionSalt])
//						return;
//					}
//				}
//			}else{
//				redirect(action:'addComment', params:[message:checkFile, instance:params.applicationInstance,csrfPreventionSalt:csrfPreventionSalt])
//				return;
//			}
//		}else{
//			def instance = applicationNotingService.addNoteForApplication(params)
//
//			if(instance instanceof org.nba.review.AddNote){
//				redirect(action:'noting', params:[message:msg,instance:params.applicationInstance,csrfPreventionSalt:csrfPreventionSalt])
//				return;
//			}
//		}
//	}


def replyDdn =  ['1. Consent given without any reservation','2. Consent given with Conditions/ Reservations','3. Consent not given with reasons']
	
	def replyConsent(){
		
		def csrfPreventionSalt = params.csrfPreventionSalt
		def commId = params.instance
		def message = params.message
		
	
		if(commId == '' || commId == null){
			 message ="Please select an application"
		redirect(action:'sbbDashboard',params:[csrfPreventionSalt:csrfPreventionSalt,message:message])
		return;
		}
		
		def currentUser  = springSecurityService.getCurrentUser().username
		def userIns = NbaUser.findByUsername(currentUser)
		String sbbName = userIns.name
	
		def formDetails = ApplicationForm1.get(Long.parseLong(commId))
		
		def sbbPreDetails = SBBConsent.findByAppNumber(formDetails?.appNumber)
		
		[formDetails:formDetails,csrfPreventionSalt:csrfPreventionSalt,message:message,sbbName:sbbName,replyDdn:replyDdn,sbbInstance:sbbPreDetails]
		
	}
	
	def consentTempSave(){
		String rename,message
		def applicationNum = params.formId
		def csrfPreventionSalt = params.csrfPreventionSalt
		def formDetails = ApplicationForm1.get(Long.parseLong(applicationNum))
		String applicationNumber =  formDetails?.appNumber
		
		def sbbInstance = SBBConsent.findByAppNumber(applicationNumber)

		def relevantFile =  request.getFile('filename')
		if(relevantFile != null && relevantFile?.getBytes()?.size() != 0 ){
			

//			def sbbInstance = new SBBConsent()
			
			sbbInstance.sbbName = params.sbbName
			sbbInstance.ddn = params.consentDdn
			sbbInstance.other = params.consentDdnOther
			sbbInstance.createdBy = springSecurityService?.getCurrentUser()
			sbbInstance.consentCreatedDate =  new Date()


			
			if(params.localBMC == ''|| params.localBMC instanceof String ){

				def change = [params.localBMC];
				
				
				sbbInstance.localBody = change as List
			}else{
				sbbInstance.localBody = params.localBMC
			}

			new File(grailsApplication.config.fileForSBBConsent.toString() + File.separatorChar + applicationNumber ).mkdirs()
			def filePath = new File( grailsApplication.config.fileForSBBConsent.toString() + File.separatorChar + applicationNumber + File.separatorChar + relevantFile.getOriginalFilename() )
			def exists = filePath.exists();
			if(exists == true){
				rename = SBBConsent.count().toString()

				filePath = new File( grailsApplication.config.fileForSBBConsent.toString() + File.separatorChar + applicationNumber + File.separatorChar + rename + relevantFile.getOriginalFilename() )
			}
			relevantFile.transferTo(filePath)

			sbbInstance.fileName = relevantFile.getOriginalFilename();
			sbbInstance.filePath = filePath;

			if(!sbbInstance.save(flush:true)){
				sbbInstance.errors.allErrors.each {print it}
			}
			message = "Data temporarily save"
			redirect(action:'showConsent',params:[instance:formDetails.id,sbbInstance:sbbInstance?.id,message:message,csrfPreventionSalt:csrfPreventionSalt])


		}
		else{

			sbbInstance.sbbName = params.sbbName
			sbbInstance.ddn = params.consentDdn
			sbbInstance.other = params.consentDdnOther
			sbbInstance.createdBy = springSecurityService?.getCurrentUser()
			sbbInstance.consentCreatedDate =  new Date()

			if(params.localBMC == ''|| params.localBMC instanceof String ){

				def change = [params.localBMC];
				
				
				sbbInstance.localBody = change as List
			}else{
				sbbInstance.localBody = params.localBMC
			}

			if(!sbbInstance.save(flush:true)){
				sbbInstance.errors.allErrors.each {print it}
			}
			message = "Data temporarily save"
			redirect(action:'showConsent',params:[instance:formDetails.id,sbbInstance:sbbInstance?.id,message:message,csrfPreventionSalt:csrfPreventionSalt])
		}
	}

	
		
def showConsent(){
	def commId = params.instance
	def sbbIns = params.sbbInstance
	def message = params.message
	def csrfPreventionSalt = params.csrfPreventionSalt
	
	def sbbInstance = SBBConsent.get(Long.parseLong(sbbIns))
	def formDetails = ApplicationForm1.get(Long.parseLong(commId))

	render(view:'replyConsent', model:[formDetails:formDetails,csrfPreventionSalt:csrfPreventionSalt,sbbInstance:sbbInstance,message:message,replyDdn:replyDdn,show:'show'])
	}	
	
	def receivedConsent(){}
	
	
	
	def createComment(){
		
		def csrfPreventionSalt = params.csrfPreventionSalt
		def commId = params.instance
		if(commId == '' || commId == null){
			def message ="Please select an application"
		redirect(action:'sbbDashboard',params:[csrfPreventionSalt:csrfPreventionSalt,message:message])
		return;
		}
	
		def formDetails = ApplicationForm1.get(commId as Long)
		[formDetails:formDetails, csrfPreventionSalt:csrfPreventionSalt]
	}
	
	def sendToNBA(){
		
				def fileAttachedInstance
				def formId = params.formId
				def csrfPreventionSalt = params.csrfPreventionSalt
				def getAllpdfFile =  request.getFiles('files[]')
				println"file Size"+getAllpdfFile.size()
		
				ApplicationForm1 formDetails = ApplicationForm1.get(Long.parseLong(formId))
		
				if(getAllpdfFile.size() >=1){
		
					def confirmation = checklistManagementService.fileValidation(getAllpdfFile)
		
					if(confirmation == "Validate Successfully"){
		
						def communicationFmtInstance = new ClientLetter()
						
						communicationFmtInstance.bodyContent = params.comment
						communicationFmtInstance.subject = params.subject
						communicationFmtInstance.dynamicLetterNumberClientOUT = letterIntegrationService.getSBBDynLetterNumberApplicantOut(formDetails?.appNumber)
						communicationFmtInstance.dynamicLetterNumberNbaIN = letterIntegrationService.getDynLetterNumberNbaIn(formDetails?.appNumber)
						communicationFmtInstance.letterCreateDate = new Date()
						communicationFmtInstance.letterBy = springSecurityService.getCurrentUser()
						communicationFmtInstance.applicationForm =  formDetails
						
						
						if(!communicationFmtInstance.save(flush:true)){
							
							communicationFmtInstance.errors.allErrors.each {println it}
						}
			
		
						fileAttachedInstance = checklistManagementService.fileAttachmentforEmail(getAllpdfFile,communicationFmtInstance,formDetails?.appNumber)
		
		
						if(fileAttachedInstance == "File upload successfully" || fileAttachedInstance == null   || fileAttachedInstance == ''){
							
							def changeltrStatus = letterIntegrationService.setResponceLetterStatus(communicationFmtInstance?.id,ResponceLetterStatus.LtrStatus.SBB_RESPONSE)
							def communicationStatus = letterIntegrationService.setCommunicationStatusForNBA(formDetails)
							redirect(action:'sendCommunication', params:[instance:formDetails?.id,communicationDetails:communicationFmtInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:fileAttachedInstance])
						}
						else if(fileAttachedInstance != "File upload successfully"){
							redirect(action:'createComment', params:[instance:formDetails?.id,communicationDetails:communicationFmtInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:fileAttachedInstance])
						}
					}else if(confirmation != "Validate Successfully"){
		
						redirect(action:'createComment', params:[instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt,message:confirmation])
					}
				}else{
				def communicationFmtInstance = new ClientLetter()
				
				communicationFmtInstance.bodyContent = params.comment
				communicationFmtInstance.subject = params.subject
				communicationFmtInstance.dynamicLetterNumberClientOUT = letterIntegrationService.getSBBDynLetterNumberApplicantOut(formDetails?.appNumber)
				communicationFmtInstance.dynamicLetterNumberNbaIN = letterIntegrationService.getDynLetterNumberNbaIn(formDetails?.appNumber)
				communicationFmtInstance.letterCreateDate = new Date()
				communicationFmtInstance.letterBy = springSecurityService.getCurrentUser()
				communicationFmtInstance.applicationForm =  formDetails
				
				if(!communicationFmtInstance.save(flush:true)){
					
					communicationFmtInstance.errors.allErrors.each {println it}
				}
		
				def changeltrStatus = letterIntegrationService.setResponceLetterStatus(communicationFmtInstance?.id,ResponceLetterStatus.LtrStatus.SBB_RESPONSE)
				def communicationStatus = letterIntegrationService.setCommunicationStatusForNBA(formDetails)
				redirect(action:'sendCommunication', params:[instance:formDetails?.id,communicationDetails:communicationFmtInstance?.id,csrfPreventionSalt:csrfPreventionSalt,message:"Application Send Successfully"])
				
				}
			}
	
	def receivedCommunication(){
		
		def formId = params.instance
		def csrfPreventionSalt = params.csrfPreventionSalt
		def message
		
		if(formId == '' || formId == null){
			message = "Please select an application"
		redirect(action:'sbbDashboard', params:[csrfPreventionSalt:csrfPreventionSalt, message:message])
			return;
		}
		def formDetails = ApplicationForm1.get(Long.parseLong(formId))
	def sbbLetter = LetterCommunication.where{
		
		applicationForm1 == formDetails && letterStatus.ltrstatus == LetterStatus.LtrStatus.LETTER_SEND && letterType.ltrType == LetterType.LtrType.SBB_LETTER
		
		}.list()	
		
	 [sbbLetter:sbbLetter,csrfPreventionSalt:csrfPreventionSalt,formDetails:formDetails]	
	}

	def sendCommunication(){
		
		def formId = params.instance
		def csrfPreventionSalt = params.csrfPreventionSalt
		def message = params.message

		if(formId == '' || formId == null){
			message = "Please select an application"
			redirect(action:'sbbDashboard', params:[csrfPreventionSalt:csrfPreventionSalt, message:message])
			return;
		}
		def formDetails = ApplicationForm1.get(Long.parseLong(formId))
		def sbbLetter = ClientLetter.where{

			applicationForm == formDetails && responceletterStatus.ltrstatus == ResponceLetterStatus.LtrStatus.SBB_RESPONSE

		}.list()

		def ssbConsent = SBBConsent.where{
			applicationForm1 == formDetails  && consentStatus == Constants.SBB_CONSENT

		}

		[sbbLetter:sbbLetter,ssbConsent:ssbConsent,csrfPreventionSalt:csrfPreventionSalt,formDetails:formDetails,message:message]

	}
	
	def viewLetter(){
		def showId = params.editId
		def letterDetails = LetterCommunication.get(showId as Long)
		render(template:'/common/nbaLetter', model:[letterDetails:letterDetails])
		}
	
	
	def fileDetails(){
		def csrfPreventionSalt = params.csrfPreventionSalt
		def detailsForFile = SBBConsent.get(params?.sbbInst)
		def file = new File(detailsForFile?.filePath)
			response.setContentType("application/pdf")
			response.setHeader("Content-disposition","filename=${file.getName()}")
			response.outputStream << file.newInputStream()
			response.outputStream.close()
	}
	
	
	def sbbConsentPrint(){
		
	def csrfPreventionSalt = params.csrfPreventionSalt
	def printInstance = SBBConsent.get(Long.parseLong(params?.sbbInst));
	[printInstance:printInstance]
	
	}
	

def sbbConsentStatus(){
	String rename;
		def formInstance = params.instance
		def csrfPreventionSalt = params.csrfPreventionSalt
		def formDetails = ApplicationForm1.get(Long.parseLong(formInstance))
		def sbbConsentInstance = SBBConsent.get(Long.parseLong(params?.sbbInst))
		sbbConsentInstance.dyOutLetterNumber = consentDyLetterNumber()
		sbbConsentInstance.consentStatus = Constants.SBB_CONSENT
		sbbConsentInstance.consentCreatedDate = new Date()
		sbbConsentInstance.responceStatus = false;
		def communicationStatus = letterIntegrationService.setCommunicationStatusForNBA(formDetails)
		
		def relevantFile =  request.getFile('filename')
		if(relevantFile != null && relevantFile?.getBytes()?.size() != 0 ){
		new File(grailsApplication.config.fileForSBBConsent.toString() + File.separatorChar + formDetails?.appNumber ).mkdirs()
		def filePath = new File( grailsApplication.config.fileForSBBConsent.toString() + File.separatorChar + formDetails?.appNumber + File.separatorChar + relevantFile.getOriginalFilename() )
		def exists = filePath.exists();
		if(exists == true){
			rename = SBBConsent.count().toString()

			filePath = new File( grailsApplication.config.fileForSBBConsent.toString() + File.separatorChar + formDetails?.appNumber + File.separatorChar + rename + relevantFile.getOriginalFilename() )
		}
		relevantFile.transferTo(filePath)
		sbbConsentInstance.fileName = relevantFile.getOriginalFilename();
		sbbConsentInstance.filePath = filePath;
		}

		
		if(!sbbConsentInstance.save(flush:true)){
			sbbConsentInstance.errors.allErrors.each {print it}
		}
		
		redirect(action:'sendCommunication', params:[instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt,message: Constants.SBB_CONSENT])
		
	}

   def consentDyLetterNumber(){
	
	   String dynamicLetterNumber = "", dynamicNumber;
	   
	   
	   def currentUser  = springSecurityService.getCurrentUser().username
	   def 	userIns = NbaUser.findByUsername(currentUser)
	   String sbbName = userIns.name+" " +"Consent Reply"
		  
	   
	   def counter = SBBConsent.findAllBySbbUserName(currentUser)?.size();
   
//		def counter = countletter+1;

		 if(counter >= 1 && counter < 10){
			dynamicNumber = "000"+counter.toString();
		   }else if(counter> 10 && counter < 100){
   
			   dynamicNumber = "00"+counter.toString();
		   }
		   else if(counter > 100 && counter < 1000){
   
			   dynamicNumber = "0"+counter.toString();
		   }
		   else if(counter > 1000 && counter < 10000){
   
			   dynamicNumber = counter.toString();
		   }
	   
	   LocalDate today = LocalDate.now();
	   int month = today.getMonthValue();
	   int currentYear = today.getYear();
	   
	   String subCurrentYear = currentYear.toString().substring(2);
	   
	   int previousYear = Integer.parseInt(subCurrentYear) -1;
	   int nextYear = Integer.parseInt(subCurrentYear) +1;
	  
   
	   if(month >= 4){
		   
		   dynamicLetterNumber = sbbName+"/OT/"+subCurrentYear+"-"+nextYear+"/"+dynamicNumber;
		   
		   }
	   else{
		   dynamicLetterNumber = sbbName+"/OT/"+previousYear+"-"+subCurrentYear+"/"+dynamicNumber;
		   
		   }
		   return dynamicLetterNumber;
	}
   
   def viewConsent(){
	   def csrfPreventionSalt = params.csrfPreventionSalt
	   def showId = params.editId
	   def  sbbInstance = SBBConsent.get(showId as Long)
	   render(template:'/common/viewConsentLetter',model:[sbbInstance:sbbInstance])
	   }
   	
	def sbbFileShows(){
		def csrfPreventionSalt = params.csrfPreventionSalt
		def detailsForFile = SBBConsent.get(params?.showId)
		def file = new File(detailsForFile?.filePath)
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
	
	def dynamicLetterShow(){
		def csrfPreventionSalt = params.csrfPreventionSalt
		def detailsForFile = PdfFileAttachment.get(params?.dynamicId)
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
	
	
	def consentShowPdf(){
		
		def csrfPreventionSalt = params.csrfPreventionSalt
		def detailsForFile = SBBConsent.get(params?.replyId)
		def file = new File(detailsForFile?.filePath)
		response.setContentType("application/pdf")
		response.setHeader("Content-disposition","filename=${file.getName()}")
		response.outputStream << file.newInputStream()
		
	}
}
