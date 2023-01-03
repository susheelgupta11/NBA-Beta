package org.nba.application

import org.nba.common.Country
import org.nba.common.Location

class IndianGovtInst {

//	TitleName title
	String govtInstName
	String profile
//	GenderType gender
//	String firstName
//	String middleName
//	String lastName
//	String nationality
	String address1
	String address2
	String address3
	String samePresentAddress
	String presentAddress1
	String presentAddress2
	String presentAddress3
	String presentCity
	String presentProvince
	String presentPincode
	Country presentCountry
	String presentMobile
	String presentPhone
	String presentEmail
	String city
	String province
	String pincode
	Country country
	String mobile
	String phone
	String email

	byte[] addressproofLetter
	String addressproofLetterFileName
	String addressproofSelect
	String addressproofNo
	
	String authorizationSelect
	String authorizationNo
	String entityName
	String authRepresentativeIdSelect
	String designation
	String idNum
	
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
		govtInstName nullable:true,blank:true
		province nullable:true,blank:true
		mobile nullable:true,blank:true
		phone nullable:true,blank:true
		samePresentAddress nullable:true,blank:true
		address2 nullable:true,blank:true
		address3 nullable:true,blank:true
		applicationForm1 nullable:true,blank:true
		 presentAddress1 nullable:true,blank:true
		 presentAddress2 nullable:true,blank:true
		 presentAddress3 nullable:true,blank:true
		 presentCity nullable:true,blank:true
		 presentProvince nullable:true,blank:true
		 presentPincode nullable:true,blank:true
	     presentCountry nullable:true,blank:true
		 presentMobile nullable:true,blank:true
		 presentPhone nullable:true,blank:true
		 presentEmail nullable:true,blank:true
		profile nullable:true,blank:true
		city nullable:true,blank:true
		pincode nullable:true,blank:true
		addressproofLetter nullable:true,blank:true
	   addressproofLetterFileName nullable:true,blank:true 
		addressproofSelect nullable:true,blank:true 
		addressproofNo nullable:true,blank:true
		entityName nullable:true,blank:true
		authRepresentativeIdSelect nullable:true,blank:true
		designation nullable:true,blank:true
		idNum nullable:true,blank:true
		authorizationSelect nullable:true,blank:true
		authorizationNo nullable:true,blank:true
		
		 }
}
