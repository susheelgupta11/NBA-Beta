package org.nba.user

import java.util.Set;

class NbaRole {

	String authority
	
	static mapping = {
		cache true
	}

	static constraints = {
		authority blank: false, unique: false
	}
	
	Set<NbaUser> getUser() {
		NbaUserNbaRole.findAllByNbaRole(this).collect { it.nbaUser.name }
	}
}

class RoleEnum {
	
		
	
		public enum Role {
			APPLICANT('Applicant'),
			MANAGER('Manager'),
			ADMIN('Admin'),
			TECHNICAL_OFFICER_BS('Technical Officer BS'),
			ACCOUNT_OFFICER('Account Officer'),
			ACCOUNT_ASSISTANT_MEMBER('Account Assistant Member'),
			REVIEW_HEAD('Review Head'),
			LEGAL_HEAD('Legal Head'),
			REVIEW_LEGAL_HEAD('Review Legal Head'),
			TECHNICAL_OFFICER_IPR('Technical Officer IPR'),
			SECRETARY('Secretary'),
			REVIEW_MEMBER('Review Member'),
			REVIEW_LEGAL_MEMBER('Review Legal Member'),
			REVIEW_IPR_MEMBER('Review IPR Member'),
			CHAIRMAN('Chairman'),
			DDO('DDO'),
			SBB('sbb'),
			IPR_MEMBER('Ipr Members'),
			IPR_OFFICER_MEMBER('Ipr Officer Member'),
			IMAGINARY('Imaginary'),
			EC('Expert Committee')
			
			final String value
	
			private Role(String value) {
				this.value = value
			}
			String getKey(){
				name()
			}
	
			String toString() {
				value
			}
		}
	}
	