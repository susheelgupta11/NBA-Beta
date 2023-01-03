package org.nba.application
import org.nba.common.Country;
import org.nba.common.Location

class CompanyProfile {

	String entityName
	String entityType
//	boolean isRegisteredInIndia
	String nationality
	String address1
	String address2
	String address3
	String city
	String province
	String pincode
	Country country
	Double turnover
	String mobile
	String phone
	String email
	String website
	byte[] registrationDoc
	String registrationDocName
	String registrationDocURL
	
	byte[] passportCopy
	String passportCopyFileName
	String passportCopyURL
	
	byte[] authorizationLetter
	String authorizationLetterFileName
	String authorizationLetterURL
	
	TitleName title
	String firstName
	String middleName
	String lastName
	String designation
	String personMobile
	String personEmail
	String businessNature
	//new fields
	String authRepresentativeIdSelect
	String idNum
	
	public enum TitleName {
		Mr('Mr'),Ms('Ms'),Mrs('Mrs'),Dr('Dr')

		final String value

		private TitleName(String value) {
			this.value = value
		}

		String toString() { value }

	}

	static belongsTo = [applicationForm:ApplicationForm1]
	static constraints = {
//		isRegisteredInIndia nullable:true,blank:true
		authRepresentativeIdSelect nullable:true,blank:true
		idNum nullable:true,blank:true
		phone nullable:true,blank:true
		province nullable:true,blank:true
		website nullable:true,blank:true
		registrationDoc nullable:true,blank:true
		registrationDocName nullable:true,blank:true
		passportCopy nullable:true,blank:true
		passportCopyFileName nullable:true,blank:true
		authorizationLetter nullable:true,blank:true
		authorizationLetterFileName nullable:true,blank:true
		turnover nullable:true,blank:true
		middleName nullable:true,blank:true
		designation nullable:true,blank:true
		city nullable:true,blank:true
		businessNature nullable:true,blank:true
		entityType nullable:true,blank:true
		address3 nullable:true,blank:true
		address2 nullable:true,blank:true
		applicationForm  nullable:true,blank:true
		
		registrationDocURL nullable:true,blank:true
		passportCopyURL nullable:true,blank:true
		authorizationLetterURL blank:true, nullable:true
	
	}	
}
