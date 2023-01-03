package org.nba.application

import java.util.Date;

import org.nba.user.NbaUser;

class AppComment {
	
	//Conversation conversation
	//ApplicationForm1 applicationForm
	String comment
	NbaUser senderId
	NbaUser receiverId
	Date commentDate = new Date()
	byte[] file
	String fileName
	String collatedComment
	Integer profId
	String feeSubmitted
	String receiptAttached
	String forwardTo
	String markedStatus
	
	
	
	static belongsTo = [appForm:ApplicationForm1]
	
    static constraints = {
		comment nullable:true,blank:true
		file nullable:true,blank:true
		fileName nullable:true, blank:true
		feeSubmitted nullable:true,blank:true
		receiptAttached nullable:true,blank:true
		forwardTo nullable:true,blank:true
		senderId nullable:true,blank:true
		receiverId nullable:true,blank:true
		appForm nullable:true,blank:true
		commentDate nullable:true,blank:true
		collatedComment nullable:true,blank:true
		profId nullable:true,blank:true
		markedStatus nullable:true,blank:true
    }
}
