package org.nba.application

import grails.transaction.Transactional

import java.time.LocalDate

import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap
import org.nba.communication.LetterCommunication
import org.nba.communication.PdfFileAttachment
import org.springframework.util.StringUtils

import com.lowagie.text.pdf.PdfReader
@Transactional
class ChecklistManagementService {
	
	def springSecurityService
	def grailsApplication
	
     public static boolean validateFileExtn(String fileName){
		
		
		List fileExtensions=["doc", "docx", "pdf"]
		println "--------in the service----------"
//		def extension = fileName?.substring(fileName?.lastIndexOf(".") + 1);
		def fextension = fileName.substring(fileName.indexOf(".")+1);
		return fileExtensions.contains(fextension);
		
		}

	

	public String fileValidation(listOfFiles){
		
				String message
				List attachedFileList = listOfFiles;
				attachedFileList.each { file ->
					String fileName = file.getOriginalFilename().toString();
//					def fSize = file.size
					def fileSize = Math.round(file.size);
					
					println"file Name"+fileName
					
					if(fileName == "" || fileName == null){
						
						message = "No file selected"
						return message;
					}
					
					int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
					println "Occurance"+occurance
					def nullByteCheck = file.getOriginalFilename().contains('%00')
					println "Size of file"+nullByteCheck
					
					if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
						println '====================='
						message = "Wrong format of pdf"
						
					}
					if (occurance > 1) {
						println '###################'
						message = "Wrong format of pdf"
						
					}
		
					try {
						PdfReader pdf = new PdfReader(file.getBytes())
						if(pdf && pdf.pdfVersion){}
						else{
							message = "Wrong format of pdf"
							
						}
					}catch (Exception e){
						println e.message
						message = "Wrong format of pdf"
						
		
					}
				
					
								
					
				boolean validateFile = validateFileExtn(fileName);
			
					println "validate status"+ validateFile
				
				if(validateFile == false && (message != null || message != "")){
				
//				def extension = fileName?.substring(fileName.lastIndexOf("."));
//				message = " File with " +extension+"  are not allowed, upload .pdf/.doc/.docx format only!"
					message = "File validation fail"
				
				}else if(message == "" || message == null){
				message = "Validate Successfully"
				
				}
			}
			return message
		}
	
	def String createTr5Number(String formType){
		
				String tr5Count
		
				def tr5ReceiptCount = 	LetterCommunication.findAllByFormType(formType)
				tr5ReceiptCount = tr5ReceiptCount.size()+1
				if(tr5ReceiptCount < 10){
					tr5Count = '0'+tr5ReceiptCount.toString();
				}else{
					tr5Count = tr5ReceiptCount.toString();
				}
				LocalDate today = LocalDate.now();
				int currentYear = today.getYear();
		
				return 'NBA/TR5/'+currentYear.toString()+'/'+tr5Count
			}
	
	
	
	def fileAttachmentforEmail(pdfAttachedFile, letterInstance, applicationNumber){

		String rename = "", message

		List attachedFileList = pdfAttachedFile;
		attachedFileList.each { file ->

			new File(grailsApplication.config.pdfFileAttachedPath.toString() + File.separatorChar + applicationNumber ).mkdirs()
			def filePath = new File( grailsApplication.config.pdfFileAttachedPath.toString() + File.separatorChar + applicationNumber + File.separatorChar + file.getOriginalFilename() )
			def exists = filePath.exists();
			if(exists == true){
				rename = LetterCommunication.count().toString()
			}

			filePath = new File( grailsApplication.config.pdfFileAttachedPath.toString() + File.separatorChar + applicationNumber + File.separatorChar + rename + file.getOriginalFilename() )

			file.transferTo(filePath)

			def pdfFileAttachInstance  = new PdfFileAttachment()
			
			if(letterInstance instanceof org.nba.communication.LetterCommunication){

				pdfFileAttachInstance.letterCommunication = letterInstance
				
			}else if(letterInstance instanceof org.nba.communication.ClientLetter){
				pdfFileAttachInstance.clientLetter = letterInstance
			}

			pdfFileAttachInstance.pdfName = rename + file.getOriginalFilename()
			pdfFileAttachInstance.attachedUrl = filePath
			pdfFileAttachInstance.attachedDate = new Date()

			if(!pdfFileAttachInstance.save(flush:true)){
				pdfFileAttachInstance.errors.allErrors.each {print it}
			}
			message = "File upload successfully"
		}
		return message;
	}

	
	
	def String dynamicEReceiptGenerator(String formType){
		
				String receiptCount, requirdEReceipt
				println "check Class"+formType.getClass()
				def tr5ReceiptCount = 	LetterCommunication.findAllByFormType(formType)
					tr5ReceiptCount = tr5ReceiptCount.size()+1
				if(tr5ReceiptCount < 10){
					receiptCount = '0'+tr5ReceiptCount.toString();
				}else{
					receiptCount = tr5ReceiptCount.toString();
				}
				LocalDate today = LocalDate.now();
				int month = today.getMonthValue();
				int currentYear = today.getYear();
				
				int previousYear = currentYear - 1;
				int nextYear = currentYear + 1;
				String subCurrentYear = currentYear.toString().substring(2);
		
				if(month >= 4){
		
					requirdEReceipt = receiptCount+'/'+currentYear+'-'+nextYear.toString().substring(2)
				}else{
					requirdEReceipt = receiptCount+'/'+previousYear.toString()+'-'+subCurrentYear
				}
				return requirdEReceipt
			}

	
	
	
	
	public String getDynLetterNumberNbaOut(String appNumber){
	 
	 String dynamicLetterNumber = "", dynamicNumber;
	def counter = LetterCommunication.list().size();

		
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
		
		dynamicLetterNumber = "NBA/OT/"+ appNumber.substring(9)+"/"+subCurrentYear+"-"+nextYear+"/"+dynamicNumber;
		
		}
	else{
		dynamicLetterNumber = "NBA/OT/"+ appNumber.substring(9)+"/"+previousYear+"-"+subCurrentYear+"/"+dynamicNumber;
		
		}
		return dynamicLetterNumber;
	 }
 	
		
	def saveCommunication(GrailsParameterMap params, ApplicationForm1 formDetails){
		
		def letterCommunicationIns = new LetterCommunication(emailId:params.emailId,messageBody:params.body,subject:params.subject,ccEmailId:params.ccEmailId)
		letterCommunicationIns.applicantName = params.name
		letterCommunicationIns.applicationForm1 = formDetails
		letterCommunicationIns.formType = formDetails.category?.category
		letterCommunicationIns.appNumber = formDetails?.appNumber
		letterCommunicationIns.formApplicant = formDetails?.submittedBy
			
		letterCommunicationIns.createdDate = new Date()
		letterCommunicationIns.createdBy = springSecurityService.getCurrentUser().name
		letterCommunicationIns.approvedDate = new Date();
		letterCommunicationIns.approvedBy = springSecurityService.getCurrentUser().name
		letterCommunicationIns.applicationForm1 = formDetails
		
		letterCommunicationIns.letterNo =  params.letterNo
		letterCommunicationIns.dated = params.dated
		letterCommunicationIns.sumOfRupees =  params.sumOfRupees
		letterCommunicationIns.paymentType = params.paymentType
		letterCommunicationIns.accountOF = params.accountOf
		letterCommunicationIns.paymentOf = params.paymentOf
		letterCommunicationIns.receiptNo = params.receiptNo
		
		letterCommunicationIns.paymentFor = params.paymentFor
		letterCommunicationIns.moneyInWords = params.moneyInWords
//		String changeformClass = formDetails?.category?.category
//		letterCommunicationIns.tr5DynamicNumber = createTr5Number(changeformClass)
	
			if(!letterCommunicationIns.save(flush:true)){
				letterCommunicationIns.errors.allErrors.each {print it}
			}
		return letterCommunicationIns
	}
	
	   
	def updateCommunication(GrailsParameterMap params, LetterCommunication letterCommunicationIns){
		
		letterCommunicationIns.emailId = params.emailId
		letterCommunicationIns.ccEmailId = params.ccEmailId
		letterCommunicationIns.messageBody = params.body
		letterCommunicationIns.subject = params.subject
		letterCommunicationIns.approvedDate = new Date()
		letterCommunicationIns.approvedBy = springSecurityService?.getCurrentUser()?.name
		
		letterCommunicationIns.letterNo =  params.letterNo
		letterCommunicationIns.dated = params.dated
		letterCommunicationIns.sumOfRupees =  params.sumOfRupees
		letterCommunicationIns.paymentType = params.paymentType
		letterCommunicationIns.accountOF = params.accountOf
		letterCommunicationIns.paymentOf = params.paymentOf
		letterCommunicationIns.receiptNo = params.receiptNo
		letterCommunicationIns.moneyInWords = params.moneyInWords
		if(!letterCommunicationIns.save(flush:true)){
			letterCommunicationIns.errors.allErrors.each {print it}
		}
		
		return letterCommunicationIns;
	}

	def updateAndSendCommunication(GrailsParameterMap params, LetterCommunication letterCommunicationIns){
		
		letterCommunicationIns.emailId = params.emailId
		letterCommunicationIns.ccEmailId = params.ccEmailId
		letterCommunicationIns.messageBody = params.body
		letterCommunicationIns.subject = params.subject
		letterCommunicationIns.sendDate = new Date()
		letterCommunicationIns.sendBy = springSecurityService?.getCurrentUser()?.name
		
		letterCommunicationIns.letterNo =  params.letterNo
		letterCommunicationIns.dated = params.dated
		letterCommunicationIns.sumOfRupees =  params.sumOfRupees
		letterCommunicationIns.paymentType = params.paymentType
		letterCommunicationIns.accountOF = params.accountOf
		letterCommunicationIns.paymentOf = params.paymentOf
		letterCommunicationIns.receiptNo = params.receiptNo
		letterCommunicationIns.moneyInWords = params.moneyInWords
		
	    String appNumber  = letterCommunicationIns.appNumber
		
		def getDynamicLetterNumOut = getDynLetterNumberNbaOut(appNumber)
		
	    letterCommunicationIns.dynamicLetterNumberNbaOUT = getDynamicLetterNumOut
	    letterCommunicationIns.dynamicLetterNumberClientIN = getDynamicLetterNumOut.replace("OT","IN");

		letterCommunicationIns.dynamicLetterNumberNbaIN = null
	    letterCommunicationIns.dynamicLetterNumberClientOUT = null
		
		if(!letterCommunicationIns.save(flush:true)){
			letterCommunicationIns.errors.allErrors.each {print it}
		}
		
		return letterCommunicationIns;
		
		
	}		
			
}
