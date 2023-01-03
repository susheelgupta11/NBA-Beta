package org.nba.communication

import org.nba.application.ApplicationForm1;
import org.nba.user.NbaUser

class SBBConsent {
	
	List localBody
	String appNumber
	String sbbName
	String ddn
	String other
	NbaUser createdBy
	String filePath
	String fileName
	Date consentCreatedDate
	String consentStatus
	
	String sbbUserName
	Boolean responceStatus
	String dynLetterNumber
	String dyOutLetterNumber
	Date letterCreatedDate
	
	
	static hasMany = [localBody:String]
	static belongsTo = [applicationForm1:ApplicationForm1]

    static constraints = {
		
		 localBody blank:null,nullable:true
		 appNumber blank:null,nullable:true
		 sbbName blank:null,nullable:true
		 ddn blank:null,nullable:true
		 other blank:null,nullable:true
		 createdBy blank:null,nullable:true
		 filePath blank:null,nullable:true
		 fileName blank:null,nullable:true
		 consentCreatedDate blank:null,nullable:true 
		 applicationForm1 blank:null,nullable:true
		 consentStatus blank:null,nullable:true
		 sbbUserName blank:null,nullable:true
		 responceStatus nullable:true, blank:true 
		 dynLetterNumber nullable:true, blank:true 
		 letterCreatedDate nullable:true, blank:true 
		 dyOutLetterNumber nullable:true, blank:true
    }
}
