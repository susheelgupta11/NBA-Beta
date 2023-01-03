package org.nba.user

class UserLocked {
	
	Integer usercount
	String username
	Date lockedtime
	

    static constraints = {
		
		 usercount nullable:true, blank:true
		 username nullable:true, blank:true
		 lockedtime nullable:true, blank:true
    }
}
