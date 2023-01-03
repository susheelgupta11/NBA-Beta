package org.nba.application

import org.nba.common.Country;

class FormB {

	String name
	String supervisorDesignation
	String headOfInstName
	String headOfInstDesignation
	String address1
	String address2
	String address3
	String city
	String state
	String country
	Country country1
	String phone
	String fax
	String mobile
	String supervisorOrHoi
	String contactDetailsOfInstOrOrganization
	String category
	String email
	String pincode
	EntityType type
	String memorandum
	String addressproofSelect
	String addressproofNo
	byte [] addressproofLetter
	byte [] memorandumFile
//	String memorandumFileURL
	
	byte [] sanctionOrderMoUcopy
//	String sanctionOrderMoUcopyURL
	
	String sanctionOrderMoUcopyFileName
	String addressproofLetterFileName
	
	static belongsTo = [appForm:ApplicationForm1]
    static constraints = {
		 name nullable:true,blank:true
		 supervisorDesignation nullable:true,blank:true
		 headOfInstName nullable:true,blank:true
		 headOfInstDesignation nullable:true,blank:true
		 address1 nullable:true,blank:true
		 address2 nullable:true,blank:true
		 address3 nullable:true,blank:true
		 city nullable:true,blank:true
		 state nullable:true,blank:true
		 country nullable:true,blank:true
		 phone nullable:true,blank:true
		 fax nullable:true,blank:true
		 mobile nullable:true,blank:true
		 supervisorOrHoi nullable:true,blank:true
		 contactDetailsOfInstOrOrganization nullable:true,blank:true
		 category nullable:true,blank:true
		 email nullable:true,blank:true
		 pincode nullable:true,blank:true
		 type nullable:true,blank:true
		 memorandum nullable:true,blank:true
		 memorandumFile nullable:true,blank:true
		 sanctionOrderMoUcopy nullable:true,blank:true
		 sanctionOrderMoUcopyFileName nullable:true,blank:true
		 addressproofLetterFileName nullable:true,blank:true
		 addressproofSelect nullable:true,blank:true
		 addressproofNo nullable:true,blank:true
		 addressproofLetter nullable:true,blank:true
		 country1 nullable:true,blank:true
//		 memorandumFileURL nullable:true,blank:true
//		 sanctionOrderMoUcopyURL nullable:true,blank:true
		}
	public enum EntityType {
		Institute('Institute'),Supervisor('Supervisor'),Guiding_Institute('Guiding Institute'),Guiding_Supervisor('Guiding Supervisor'),
		Funding_Agency('Funding Agency')
	
		final String value
	
		private EntityType(String value) {
			this.value = value
		}
	
		String toString() {
			value
		}
	}
}
