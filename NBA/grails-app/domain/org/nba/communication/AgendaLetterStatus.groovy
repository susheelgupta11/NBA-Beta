package org.nba.communication

import org.nba.user.NbaUser

class AgendaLetterStatus {

	AgendaLtrStatus agdltrstatus
	NbaUser statusChangedBy
	Agenda agenda

	static constraints = {
		agdltrstatus nullable:true,blank:true
		statusChangedBy nullable:true,blank:true
		agenda nullable:true,blank:true
		
	}
	
	public enum AgendaLtrStatus {
		LETTER_CREATED('Created'),LETTER_APPROVED('Approved'),LETTER_SEND('send'),LETTER_RESPONSE('Response')
	
		final String value
	
		private AgendaLtrStatus(String value) {
			this.value = value
		}
	
		String toString() {
			value
		}
	}
}