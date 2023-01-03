package org.nba.communication

class PdfFileAttachment {

	String attachedUrl
	String pdfName
	Date attachedDate
	
	static belongsTo = [letterCommunication:LetterCommunication,clientLetter:ClientLetter]
	
    static constraints = {
		attachedDate blank:true, nullable:true 
		pdfName blank:true, nullable:true 
		attachedUrl blank:true, nullable:true  
		letterCommunication blank:true, nullable:true
		clientLetter blank:true, nullable:true
    }
}
