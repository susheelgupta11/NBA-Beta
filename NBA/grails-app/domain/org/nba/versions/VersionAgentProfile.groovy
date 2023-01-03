package org.nba.versions

class VersionAgentProfile {

    String title
	String profile
	String firstName
	String middleName
	String lastName
	String nationality
	String address1
	String address2
	String address3
	String city
	String province
	String pincode
	String mobile
	String phone
	String email
	byte[] idProof
	String idProofFileName
	byte[] passportCopy
	String passportCopyFileName
	byte[] authorizationLetter
	String authorizationLetterFileName
	boolean isCompanyAgent
	boolean isIndividualAgent
	
	//new fields
	
	String photoIdSelect
	String photoIdNum
	
	

	
	static belongsTo = [applicationForm:VersionApplicationForm1]
    static constraints = {
		
		firstName nullable:true,blank:true
		email nullable:true,blank:true
		address1 nullable:true,blank:true
		lastName nullable:true,blank:true
		mobile nullable:true,blank:true
		middleName nullable:true,blank:true
		address2 nullable:true,blank:true
		address3 nullable:true,blank:true
		title nullable:true,blank:true
		phone nullable:true,blank:true
		idProof nullable:true,blank:true
		idProofFileName nullable:true,blank:true
		passportCopy nullable:true,blank:true
		passportCopyFileName nullable:true,blank:true
		authorizationLetter nullable:true,blank:true
		authorizationLetterFileName nullable:true,blank:true
		isCompanyAgent nullable:true,blank:true
		isIndividualAgent nullable:true,blank:true
		city nullable:true,blank:true
		pincode nullable:true,blank:true
		province nullable:true,blank:true
		applicationForm nullable:true,blank:true
		nationality nullable:true,blank:true
		profile nullable:true,blank:true
		photoIdSelect nullable:true,blank:true
		photoIdNum nullable:true,blank:true
		
		  }
}
