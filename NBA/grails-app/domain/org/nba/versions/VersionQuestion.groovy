package org.nba.versions



class VersionQuestion {

   
	String question

	String questionTooltip
	String questionNo
	int questionOrder
	int answerWordLimit
	String placeholder
	VersionQuestionCategory questionCategory

	static constraints = {
		question nullable:true,blank:true,size: 0..100000
		questionTooltip nullable:true,blank:true
		questionOrder nullable:true,blank:true
		answerWordLimit nullable:true,blank:true
		questionCategory nullable:true,blank:true
		placeholder nullable:true,blank:true
	}
}
