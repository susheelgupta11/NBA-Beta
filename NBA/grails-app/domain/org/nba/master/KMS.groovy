package org.nba.master
import org.nba.application.ApplicationForm1

class KMS {

	
	String title
	String fileUrl
	String fileName
	Date createDate
	
//	static belongsTo = [applicationForm1:ApplicationForm1]
	
    static constraints = {
		
		title nullable:true,blank:true
		fileUrl nullable:true,blank:true
		fileName nullable:true,blank:true
		createDate nullable:true,blank:true
    
	
    }
}
