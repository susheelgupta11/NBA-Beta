package org.nba.user

class UserLog {
	
	String name
	String userName
	String ip
	Date loginTime
	Date logoutTime
	

    static constraints = {
		
		name nullable:true,blank:true
		 userName nullable:true,blank:true
		 ip nullable:true,blank:true
		 loginTime nullable:true,blank:true
		 logoutTime nullable:true,blank:true
    }
}
