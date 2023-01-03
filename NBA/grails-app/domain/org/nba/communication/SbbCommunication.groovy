package org.nba.communication

import org.nba.application.ApplicationForm1

class SbbCommunication {

	String sendUser
	Date sendDate
	String action
	
	
	static belongsTo = [application:ApplicationForm1]
    static constraints = {
		 sendUser nullable:true,blank:true
		 sendDate nullable:true,blank:true
		 action nullable:true,blank:true
    }
}
