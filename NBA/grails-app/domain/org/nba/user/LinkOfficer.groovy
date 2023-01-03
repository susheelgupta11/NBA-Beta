package org.nba.user

class LinkOfficer {
	

   NbaUser nbaUserTo
   NbaUser nbaUserFrom
   Date fromDate
   Date toDate
   String reason
   Boolean status
   String userLink
   Date assignDate
   
   
    static constraints = {
		
		nbaUserTo blank:true,nullable:true
		fromDate blank:true,nullable:true
		toDate blank:true,nullable:true
		reason blank:true,nullable:true
		status blank:true,nullable:true
		userLink blank:true,nullable:true
		nbaUserFrom blank:true,nullable:true
		assignDate blank:true,nullable:true
    }
	

}
