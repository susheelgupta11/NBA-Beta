package org.nba.review
import java.lang.invoke.DirectMethodHandle.StaticAccessor;

import org.hibernate.type.EnumType;
import org.nba.application.ApplicationForm1;

class AddNote {
  
	String statusUpdate
	String actions
	String priorities
	String forwardMember
	String comments
	String submitForm
	String formNumber
	String notedUser
	Date noteDate
	static hasMany = [pdfFiles:PdfFileUpload]
	static belongsTo = [applicationForm1:ApplicationForm1]
	
//static mapping = {
//	
//	comments type: 'text'
//}



	static constraints = {

		statusUpdate blank:true,nullable:true
		actions blank:true,nullable:true
		priorities blank:true,nullable:true
		submitForm blank:true,nullable:true
		formNumber blank:true,nullable:true
		notedUser  blank:true,nullable:true
		comments blank:true,nullable:true,size: 0..1000000
		noteDate blank:true,nullable:true
		forwardMember blank:true,nullable:true
		applicationForm1 blank:true,nullable:true
		pdfFiles blank:true,nullable:true
	}
	
	
}
