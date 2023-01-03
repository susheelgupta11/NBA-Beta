package org.nba.versions

import org.nba.common.Country;

class VersionContactDetailsOfRepository {

   	
	String repostoryType
	String repostoryName
	String address1
	String address2
	String address3
	Country country
	String state
	String city
	String zip
	String mobile
	String phone
	String email
	String accessionNumber
	Boolean isAccessionNumAllotted
	
	
	static belongsTo = [applicationForm1:VersionApplicationForm1]
    static constraints = {
		repostoryType nullable:true,blank:true
		repostoryName nullable:true,blank:true
		address1 nullable:true,blank:true
		address2 nullable:true,blank:true
		address3 nullable:true,blank:true
		country nullable:true,blank:true
		state nullable:true,blank:true
		city nullable:true,blank:true
		zip nullable:true,blank:true
		mobile nullable:true,blank:true
		phone nullable:true,blank:true
		email nullable:true,blank:true
		accessionNumber nullable:true,blank:true
		isAccessionNumAllotted nullable:true,blank:true
		 }
}
