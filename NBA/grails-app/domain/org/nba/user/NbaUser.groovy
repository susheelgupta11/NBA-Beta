package org.nba.user

import org.nba.master.MstrSecurityQuestion;

class NbaUser {

	transient springSecurityService

	String name
	String username
	String password
	String email
	String mobile
	String phone
	String dateOfBirth
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
	NbaRole nbaRole
	Date dtCreated 
	
//	boolean multibrowserFlag
	
 

	
//	NbaRole linkOfficer
//	String linkOfficerName
//	Date createdDate
//	Date assignDate
	//Security
	MstrSecurityQuestion question
	String answer
	
    static hasOne = [linkOfficer:LinkOfficer]
	static hasMany = [passHistory:PasswordHistory]
	
	static transients = ['springSecurityService']

	static constraints = {
		name nullable:true, blank:true
		username blank: false, unique: true
		password blank: false
		question nullable:true, blank:true
		answer nullable:true, blank:true
		dateOfBirth nullable:true, blank:true
		nbaRole nullable:true, blank:true
		dtCreated nullable:true, blank:true
		linkOfficer nullable:true, blank:true
		passHistory nullable:true, blank:true
		dtCreated nullable:true, blank:true
//		linkOfficerName nullable:true, blank:true
//		createdDate nullable:true, blank:true
//		assignDate  nullable:true, blank:true
//		multibrowserFlag nullable:true, blank:true
	}

	static mapping = {
		password column: '`password`'
  //  multibrowserFlag  defaultValue: true
			  
	}

	Set<NbaRole> getAuthorities() {
		NbaUserNbaRole.findAllByNbaUser(this).collect { it.nbaRole }
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}
}
