package org.nba.communication

import org.nba.user.NbaUser

class LetterType {
	
	LtrType ltrType
	LetterCommunication letterCommunication
	NbaUser ltrTypeSetBy
	

    static constraints = {
		
    }
	
	public enum LtrType {
		TR5_LETTER('tr5Letter'),COM_LETTER('comLetter'),SBB_LETTER('sbbLetter')
	
		final String value
	
		private LtrType(String value) {
			this.value = value;
		}
	
		String toString() {
			value
		}
	}
	
	
}
