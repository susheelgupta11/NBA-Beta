package org.nba.review

class QuestionAnswer {
	
	String question
	String answer
	
	static belongsTo = [formRemark:FormRemark,iprRemark:IprRemark,accountRemark:AccountRemark]
	
    static constraints = {
		question nullable:true, blank:true
		answer nullable:true, blank:true
		formRemark blank:true, nullable:true
		iprRemark blank:true, nullable:true
		accountRemark blank:true, nullable:true
    }
}
