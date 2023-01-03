package org.nba.common

class Country {
	
	String country
	String iso
	String name
	String iso3
	int numcode
	String phonecode
	
    static constraints = {
		country nullable:true, blank:true
		iso nullable:true, blank:true
		name nullable:true, blank:true
		iso3 nullable:true, blank:true
		numcode nullable:true, blank:true
		phonecode nullable:true, blank:true
		
		 }
}
