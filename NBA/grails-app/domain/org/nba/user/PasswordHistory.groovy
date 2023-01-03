package org.nba.user

import java.awt.Window.Type;

class PasswordHistory {
	
	String password
	Date updatedOn
	static belongsTo = [user:NbaUser]

    static constraints = {
		password blank: false
		updatedOn nullable:true, blank:true
		user blank: true,nullable:true
    }
}
