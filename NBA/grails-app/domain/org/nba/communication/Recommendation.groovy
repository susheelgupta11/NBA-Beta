package org.nba.communication

class Recommendation {
	
	// recommendation
	
	String meetingNameReco
	String meetingNumberReco
	String purposeReco
	String checkReco
	String filePathReco
	String fileNameReco
	List appNumReco
	
	static hasMany = [appNumReco:String]
	
    static constraints = {
		
	
		 meetingNameReco blank:true, nullable:true
		 meetingNumberReco blank:true, nullable:true
		 purposeReco blank:true, nullable:true
		 checkReco blank:true, nullable:true
		 filePathReco blank:true, nullable:true
		 fileNameReco blank:true, nullable:true
    }
}
