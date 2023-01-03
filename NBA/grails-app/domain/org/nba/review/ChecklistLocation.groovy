package org.nba.review

import org.nba.resource.GeoLocationOfBioResource

class ChecklistLocation {
	
	
	String locscientificName
	String locsource
	String locvillage
	String loctown
	String locdistrict
	String locstate
	String loctraderName
	String loctraderContactDetails
	String locationRemark
	
	
	static belongsTo = [formRemark:FormRemark]

    static constraints = {
		
		locationRemark blank:true,nullable:true
		locsource blank:true,nullable:true
		locstate blank:true,nullable:true
		loctraderContactDetails blank:true,nullable:true
		formRemark blank:true,nullable:true
	    locscientificName  blank:true,nullable:true
		locvillage  blank:true,nullable:true
		loctown  blank:true,nullable:true
		locdistrict  blank:true,nullable:true
	    loctraderName  blank:true,nullable:true
		
		
    }
}
