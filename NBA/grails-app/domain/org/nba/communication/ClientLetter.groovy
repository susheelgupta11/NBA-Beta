package org.nba.communication

import org.nba.application.ApplicationForm1
import org.nba.user.NbaUser;

class ClientLetter {

	String bodyContent
	String subject
    Date letterCreateDate
	String dynamicLetterNumberNbaIN
	String dynamicLetterNumberClientOUT
    NbaUser letterBy


	static mapping = { bodyContent type: 'text' }
	static belongsTo  = [applicationForm:ApplicationForm1]
	static hasOne = [responceletterStatus: ResponceLetterStatus]
	static hasMany  = [pdfFileAttachments:PdfFileAttachment]


	static constraints = {

		bodyContent nullable:true, blank:true
		subject nullable:true, blank:true
		dynamicLetterNumberNbaIN nullable:true, blank:true
		dynamicLetterNumberClientOUT nullable:true, blank:true
		letterCreateDate nullable:true, blank:true
		letterBy nullable:true, blank:true
		responceletterStatus nullable:true, blank:true
		applicationForm nullable:true, blank:true
		pdfFileAttachments nullable:true, blank:true
	}
}
