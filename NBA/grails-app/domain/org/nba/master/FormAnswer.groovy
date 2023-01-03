package org.nba.master
import org.nba.application.ApplicationForm1

class FormAnswer {
	Question question
	QuestionCategory category
	String answer

	String documentFilename
	byte[] documentFiledata
	//int projectCommentid

	static belongsTo= [applicationForm:ApplicationForm1]
	static constraints = {
		question nullable:true,blank:true
		category nullable:true,blank:true
		answer nullable:true,blank:true,size: 0..100000
		documentFilename nullable:true,blank:true
		documentFiledata nullable:true,blank:true
	}
}
