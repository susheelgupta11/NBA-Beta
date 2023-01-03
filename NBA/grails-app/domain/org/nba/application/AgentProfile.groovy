package org.nba.application

import org.nba.application.IndividualProfile.GenderType;
import org.nba.application.IndividualProfile.TitleName;
import org.nba.common.Country;
import org.nba.common.Location;

class AgentProfile {
	TitleName title
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
	String agentIdProofURL
	
	byte[] passportCopy
	String passportCopyFileName
	String agentPassportURL
	
	byte[] authorizationLetter
	String authorizationLetterFileName
	String agentAuthorizationURL
	
	boolean isCompanyAgent
	boolean isIndividualAgent
	
	//new fields
	
	String photoIdSelect
	String photoIdNum
	
	
	public enum TitleName {
		MR('MR'),MS('MS'),MRS('MRS'),DR('DR')

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
	
	static belongsTo = [applicationForm:ApplicationForm1]
    static constraints = {
		
		
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
	
		agentIdProofURL nullable:true,blank:true
	   agentPassportURL nullable:true,blank:true
		agentAuthorizationURL  nullable:true,blank:true
		  }
}
