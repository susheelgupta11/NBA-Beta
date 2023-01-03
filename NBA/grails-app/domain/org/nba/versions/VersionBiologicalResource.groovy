package org.nba.versions

import java.util.Date;

class VersionBiologicalResource {

   	String name
	String commonName
	String scientificName
	String nature
	String biologicalResource
	Integer quantity
	String qtyUnit
	String source
	//String timeSpan
	Date fromTime
	Date toTime
	String traditionalUse
	String accessIntention
	String bioResouceTraditionalKnowledge
	String ratePerUnit
	String stateBiodeversityBoard
	String prospectiveBuyers
	String scientistName //for form C
	/*String village
	String town
	String district
	String state
	String traderName
	String traderContactDetails*/
	
	static belongsTo = [applicationForm:VersionApplicationForm1]
	static hasMany = [locations:VersionGeoLocationOfBioResource]
    static constraints = {
		bioResouceTraditionalKnowledge nullable:true,blank:true,size: 0..100000
		commonName nullable:true,blank:true
		scientificName nullable:true,blank:true
		nature nullable:true,blank:true
		quantity nullable:true,blank:true
		qtyUnit nullable:true,blank:true
		source nullable:true,blank:true
		fromTime nullable:true,blank:true
		toTime nullable:true,blank:true
		traditionalUse nullable:true,blank:true
		applicationForm nullable:true,blank:true
		name nullable:true,blank:true
		biologicalResource nullable:true,blank:true
		locations nullable:true,blank:true
		accessIntention nullable:true,blank:true
		ratePerUnit nullable:true,blank:true
		stateBiodeversityBoard nullable:true,blank:true
		prospectiveBuyers nullable:true,blank:true
		scientistName nullable:true,blank:true //for form C
		 }
}
