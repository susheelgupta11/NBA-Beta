package org.nba.application

class ContactPerson {
	
	String contactPerson
	String nameOfContactPerson
	String addressOfContactPerson
	String emailOfContactPerson
	String mobileOfContactPerson
	
	static belongsTo = [applicationForm:ApplicationForm1]
    static constraints = {
		contactPerson nullable:true,blank:true
		nameOfContactPerson nullable:true,blank:true
		addressOfContactPerson nullable:true,blank:true
		emailOfContactPerson nullable:true,blank:true
		mobileOfContactPerson nullable:true,blank:true
		applicationForm (nullable:true,blank:true)
		 }
}
