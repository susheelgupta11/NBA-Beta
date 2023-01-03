package org.nba.communication

import org.nba.user.NbaUser

class LetterStatus{
	
	LtrStatus ltrstatus
	NbaUser statusChangedBy
	LetterCommunication letterCommunication
	
	

	static constraints = {
		ltrstatus nullable:true,blank:true
		statusChangedBy nullable:true,blank:true
		letterCommunication nullable:true,blank:true
		
	}
	
	public enum LtrStatus {
		LETTER_CREATED('Created'),LETTER_APPROVED('Approved'),LETTER_SEND('send'),LETTER_RESPONSE('Response')
	
		final String value
	
		private LtrStatus(String value) {
			this.value = value
		}
	
		String toString() {
			value
		}
	}
}
