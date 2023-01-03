package org.nba.review


import org.nba.application.ApplicationForm1;

class AccountRemark {
	
	String paymentType
	Boolean txnDetailsInOrder
	Boolean mcdWithBakStatement
	String question
	String txnDetailsRemark
	String mcdBakStatementRemark
	String others
	
	String trsnsRemark
	String paymentRemark
	String paymentReceivedRemark
	String feeRemark
static hasMany = [questionAnswers:QuestionAnswer]
static belongsTo = [applicationForm1:ApplicationForm1]	
	
	String comments
	String templates
	String checkListFileUrl
	String statusUpdate
	String actions
	String forwordTo
	String priority
	

    static constraints = {
	
		checkListFileUrl nullable: true,blank:true,size:0..2000
		statusUpdate nullable:true ,blank:true,size:0..2000
		actions  nullable:true ,blank:true,size:0..2000
		forwordTo nullable:true , blank: true,size:0..2000
		priority blank:true ,nullable: true,size:0..2000
		paymentType blank:true , nullable:true,size:0..2000
		txnDetailsRemark blank:true, nullable:true,size:0..2000
		question blank:true ,nullable:true,size:0..2000
		comments blank: true, nullable:true,size:0..2000
		templates blank:true , nullable:true,size:0..2000
		mcdBakStatementRemark blank:true ,nullable:true,size:0..2000
		others blank:true , nullable:true,size:0..2000
		mcdWithBakStatement  blank:true , nullable:true
		txnDetailsInOrder  blank:true , nullable:true
		
		
		trsnsRemark blank:true , nullable:true,size:0..2000
		paymentRemark blank:true , nullable:true,size:0..2000
		paymentReceivedRemark blank:true , nullable:true,size:0..2000
		feeRemark blank:true , nullable:true ,size:0..2000
		applicationForm1 blank:true , nullable:true
		questionAnswers blank:true, nullable:true
    }
}
