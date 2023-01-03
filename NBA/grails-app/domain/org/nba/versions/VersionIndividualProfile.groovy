package org.nba.versions

import org.nba.application.IndividualProfile.GenderType;
import org.nba.application.IndividualProfile.TitleName;
import org.nba.common.Country

class VersionIndividualProfile {

    String title
	String profile
	String gender
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
	Country country
	String mobile
	String phone
	String email
	byte[] idProof
	String idProofFileName
	byte[] passportCopy
	String passportCopyFileName
	byte[] authorizationLetter
	String authorizationLetterFileName
	
	
	String idProofSelect
	String idNum
	String passportSelect
	String passportNum
	String authorizationSelect
	String authorizationNo
	

	
	static belongsTo = [applicationForm1:VersionApplicationForm1]
    static constraints = {
		title nullable:true,blank:true
		middleName nullable:true,blank:true
		province nullable:true,blank:true
		gender nullable:true,blank:true
		phone nullable:true,blank:true
		idProof nullable:true,blank:true
		idProofFileName nullable:true,blank:true
		passportCopy nullable:true,blank:true
		passportCopyFileName nullable:true,blank:true
		authorizationLetter nullable:true,blank:true
		authorizationLetterFileName nullable:true,blank:true
		address2 nullable:true,blank:true
		address3 nullable:true,blank:true
		applicationForm1 nullable:true,blank:true
		profile nullable:true,blank:true
		city nullable:true,blank:true
		pincode nullable:true,blank:true
		idProofSelect nullable:true,blank:true
		idNum nullable:true,blank:true
		passportSelect nullable:true,blank:true
		passportNum nullable:true,blank:true
		authorizationSelect nullable:true,blank:true
		authorizationNo nullable:true,blank:true
		lastName nullable:true,blank:true
		firstName nullable:true,blank:true
		country nullable:true,blank:true
		address1 nullable:true,blank:true
		email nullable:true,blank:true
		mobile nullable:true,blank:true
		nationality nullable:true,blank:true
		
		 }
}
