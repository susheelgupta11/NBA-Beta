package org.nba.master


class Question {

	String question

	String questionTooltip
	String questionNo
	int questionOrder
	int answerWordLimit
	String placeholder
	QuestionCategory questionCategory

	static constraints = {
		question nullable:true,blank:true,size: 0..100000
		questionTooltip nullable:true,blank:true
		questionOrder nullable:true,blank:true
		answerWordLimit nullable:true,blank:true
		questionCategory nullable:true,blank:true
		placeholder nullable:true,blank:true
	}
	
}
