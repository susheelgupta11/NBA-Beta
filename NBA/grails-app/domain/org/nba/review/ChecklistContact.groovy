package org.nba.review

class ChecklistContact {
	
	
	String contName
	String contAdd
	String contMobile
	String contEmail
	String contRemk
	
	static belongsTo = [formRemark:FormRemark]

    static constraints = {
		
		 contName blank:true,nullable:true
		 contAdd blank:true,nullable:true
		 contMobile blank:true,nullable:true
		 contEmail blank:true,nullable:true
		 contRemk blank:true,nullable:true
		 formRemark blank:true,nullable:true
    }
}
