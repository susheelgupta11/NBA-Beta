package org.nba.communication
import org.nba.user.NbaUser

class ResponceLetterStatus {

    LtrStatus ltrstatus
	NbaUser statusChangedBy
	ClientLetter clientLetter
	
	

	static constraints = {
		ltrstatus nullable:true,blank:true
		statusChangedBy nullable:true,blank:true
		clientLetter nullable:true,blank:true
		
	}
	
	public enum LtrStatus {
		LETTER_CREATED('Created'),LETTER_APPROVED('Approved'),LETTER_SEND('send'),APPLICANT_RESPONSE('Applicant-Response'),
		SBB_RESPONSE('Sbb-Responce'),SBB_CONSENT('SBB-Consent')
	
		final String value
	
		private LtrStatus(String value) {
			this.value = value
		}
	
		String toString() {
			value
		}
	}
}
