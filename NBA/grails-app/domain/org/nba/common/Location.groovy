package org.nba.common

class Location {

	String country
	String state
	String city
	String pincode
    static constraints = {
		country nullable:true,blank:true
		state nullable:true,blank:true
		city nullable:true,blank:true
		pincode nullable:true,blank:true
		}
}
