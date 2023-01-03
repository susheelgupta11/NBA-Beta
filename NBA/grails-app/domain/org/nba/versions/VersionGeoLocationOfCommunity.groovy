package org.nba.versions

class VersionGeoLocationOfCommunity {

    String consentObtained
	String communityKnowledge
	String village
	String town
	String district
	String state
	
	static belongsTo = [appForm:VersionApplicationForm1]
    static constraints = {
		consentObtained nullable:true,blank:true
		communityKnowledge nullable:true,blank:true
		village nullable:true,blank:true
		town nullable:true,blank:true
		district nullable:true,blank:true
		state nullable:true,blank:true
		appForm nullable:true,blank:true
		}
}
