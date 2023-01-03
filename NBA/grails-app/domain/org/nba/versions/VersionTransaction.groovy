package org.nba.versions

import org.nba.user.NbaUser;

class VersionTransaction {

    String transactionId
	String formType
	Double fee
	NbaUser madeBy
	boolean isAssigned
	boolean isPaymentMade
	String paymentReceiptName
	byte[] paymentReceipt
	String paymentRefNo
	Date   paymentDate

//	static belongsTo = [appForm:ApplicationForm1]
    static constraints = {
//		appForm nullable:true,blank:true
		transactionId nullable:true,blank:true
		formType nullable:true,blank:true
		fee nullable:true,blank:true
		madeBy nullable:true,blank:true
		isAssigned nullable:true,blank:true
		isPaymentMade nullable:true,blank:true
		paymentReceipt nullable:true,blank:true
		paymentReceiptName nullable:true,blank:true
		paymentRefNo nullable:true,blank:true
		paymentDate  nullable:true,blank:true
		 }
}
