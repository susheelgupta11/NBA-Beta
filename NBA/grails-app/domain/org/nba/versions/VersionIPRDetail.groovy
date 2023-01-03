package org.nba.versions

import java.util.Date;

class VersionIPRDetail {

   String referenceNumber
	String patentApplicationNo
	Date patentApplicationDate
	String status
	String patentNo
	Date patentDate
	String reasons
	String otherStatus
	String country
	
	static belongsTo = [applicationForm:VersionApplicationForm1]
	//static hasMany = [detailsOfTerritories:Country]
    static constraints = {
		//detailsOfTerritories nullable:true,blank:true
		referenceNumber nullable:true,blank:true
		patentApplicationNo nullable:true,blank:true
		patentApplicationDate nullable:true,blank:true
		status nullable:true,blank:true
		patentNo nullable:true,blank:true
		patentDate nullable:true,blank:true
		reasons nullable:true,blank:true
		otherStatus nullable:true,blank:true
		country nullable:true,blank:true
		applicationForm nullable:true,blank:true
		 }
}
