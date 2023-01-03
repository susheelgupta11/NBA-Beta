package org.nba.resource

import org.nba.review.ChecklistLocation

class GeoLocationOfBioResource {

	//String traditionalUse
	String village
	String town
	String district
	String state
	String traderName
	String traderContactDetails
	String source
	
	static belongsTo = [bioResource:BiologicalResource]
	
    static constraints = {
		//traditionalUse nullable:true,blank:true
		village nullable:true,blank:true
		town nullable:true,blank:true
		district nullable:true,blank:true
		state nullable:true,blank:true
		traderName nullable:true,blank:true
		traderContactDetails nullable:true,blank:true
		bioResource nullable:true,blank:true
		source nullable:true,blank:true
		
	 }
}
