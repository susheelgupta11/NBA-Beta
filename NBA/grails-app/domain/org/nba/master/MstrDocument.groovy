package org.nba.master

class MstrDocument {

	String docName
	String fileName
	byte [] document
	boolean isActive
	
	static constraints = {
		docName nullable:true, blank:true
		document nullable:true, blank:true
		isActive nullable:true, blank:true
		fileName nullable:true, blank:true
	}
    
}
