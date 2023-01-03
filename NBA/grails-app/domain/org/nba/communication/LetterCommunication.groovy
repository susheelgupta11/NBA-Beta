package org.nba.communication

import java.util.Date;

import org.nba.application.ApplicationForm1
import org.nba.user.NbaUser

class LetterCommunication {

	
	String applicantName
	String formType
	String appNumber
	String emailId
	String ccEmailId
	String messageBody
	String createdBy
	String approvedBy
	String subject
	String letterNumber
	Date createdDate
	Date approvedDate
	NbaUser formApplicant
	
	String bodyPdfName
	String bodyPdfUrl
	
	String sendBy
	Date sendDate

	
	String dynamicLetterNumberNbaIN
	String dynamicLetterNumberNbaOUT
	String dynamicLetterNumberClientIN
	String dynamicLetterNumberClientOUT
	
	
// TR5 Receipt

	
	String tr5DynamicNumber
	String letterNo
	Date   dated
	String sumOfRupees
	String paymentType
	String accountOF
	String paymentOf
	String receiptNo
	String paymentFor
	String moneyInWords
	
 // for Applicant for further use in.... we need to reply on the same letter
		
	String comment
	

	static mapping = {
		messageBody type: 'text'
		comment  type: 'text'
		moneyInWords type: 'text'
		  
	  }


	

static hasOne = [letterStatus: LetterStatus,letterType:LetterType]
static belongsTo  = [applicationForm1:ApplicationForm1]
static hasMany  = [pdfFileAttachments:PdfFileAttachment]
	 
	static constraints = {
		emailId nullable:true,blank:true
		ccEmailId nullable:true,blank:true
		messageBody nullable:true,blank:true
		createdDate nullable:true ,blank:true
		approvedDate nullable:true ,blank:true
		createdBy blank:true , nullable:true
		approvedBy blank:true , nullable:true
		applicationForm1 nullable:true,blank:true
		subject nullable:true, blank: true
		letterNumber nullable:true, blank:true
		applicantName nullable:true, blank:true
		formType nullable:true, blank:true
		appNumber nullable:true, blank:true
		pdfFileAttachments nullable:true, blank:true
		letterStatus nullable:true, blank:true
		letterType nullable:true, blank:true
		formApplicant nullable:true, blank:true
		bodyPdfName nullable:true, blank:true
		bodyPdfUrl nullable:true, blank:true
		sendBy nullable:true, blank:true
	    sendDate nullable:true, blank:true
		tr5DynamicNumber nullable:true, blank:true
		letterNo nullable:true, blank:true
	    dated nullable:true, blank:true
	    sumOfRupees nullable:true, blank:true
	    paymentType nullable:true, blank:true
		accountOF nullable:true, blank:true
		paymentOf nullable:true, blank:true
		receiptNo nullable:true, blank:true
		paymentFor nullable:true, blank:true
		dynamicLetterNumberNbaIN nullable:true, blank:true
	    dynamicLetterNumberNbaOUT nullable:true, blank:true
		dynamicLetterNumberClientIN nullable:true, blank:true
		dynamicLetterNumberClientOUT nullable:true, blank:true
		comment nullable:true, blank:true
		moneyInWords nullable:true, blank:true
		
		
	} 
	

}
