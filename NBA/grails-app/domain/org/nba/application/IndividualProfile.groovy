package org.nba.application
import org.nba.common.Country
import org.nba.common.Location

class IndividualProfile {

	TitleName title
	String profile
	GenderType gender
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
	String idProofURL
	
	byte[] passportCopy
	String passportCopyFileName
	String passportURL
	
	byte[] authorizationLetter
	String authorizationLetterFileName
	String authorizationLetterURL
	
	//new fields
	String idProofSelect
	String idNum
	String passportSelect
	String passportNum
	String authorizationSelect
	String authorizationNo
	
	public enum TitleName {
		Mr('Mr'),Ms('Ms'),Mrs('Mrs'),Dr('Dr')

		final String value

		private TitleName(String value) {
			this.value = value
		}

		String toString() { value }

	}
	
	public enum GenderType {
		MALE('MALE'),FEMALE('FEMALE')

		final String value

		private GenderType(String value) {
			this.value = value
		}

		String toString() { value }

	}
	
	static belongsTo = [applicationForm1:ApplicationForm1]
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
		idProofURL nullable:true,blank:true
		passportURL nullable:true,blank:true
		authorizationLetterURL nullable:true,blank:true
		
		 }
}
