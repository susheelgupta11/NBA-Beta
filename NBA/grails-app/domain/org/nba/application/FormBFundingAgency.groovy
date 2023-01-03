package org.nba.application

import org.nba.common.Country

class FormBFundingAgency {
	
	String institutionOrganizationName
	String address1
	String address2
	String address3
	Country country
	String state
	String city
	String phone
	String email
	byte[] sanctionOrder
	String sanctionOrderMoUcopyFileName
	String sanctionOrderURL
	
	static belongsTo = [appform:ApplicationForm1]

    static constraints = {
		institutionOrganizationName nullable:true,blank:true
		address1 nullable:true,blank:true
		address2 nullable:true,blank:true
		address3 nullable:true,blank:true
		country nullable:true,blank:true
		state nullable:true,blank:true
		city nullable:true,blank:true
		phone nullable:true,blank:true
		email nullable:true,blank:true
		sanctionOrder nullable:true,blank:true
		sanctionOrderURL nullable:true,blank:true
    }
}
