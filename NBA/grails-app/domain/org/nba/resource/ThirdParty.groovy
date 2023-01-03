package org.nba.resource
import org.nba.application.ApplicationForm1;
class ThirdParty {
	String name
	String addressForComm
	String state
	String pincode
	String country
	String phone
	String fax
	String website
	String email
	boolean isIndividual
	
	static belongsTo = [applicationForm:ApplicationForm1]
    static constraints = {
		name nullable:true,blank:true
		addressForComm nullable:true,blank:true
		state nullable:true,blank:true
		pincode nullable:true,blank:true
		country nullable:true,blank:true
		phone nullable:true,blank:true
		fax nullable:true,blank:true
		website nullable:true,blank:true
		email nullable:true,blank:true
    }
}
