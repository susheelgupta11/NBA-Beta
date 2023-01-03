package org.nba.versions

import java.util.Date;

import org.nba.application.ApplicationForm1;
import org.nba.application.AppStatus.Status;
import org.nba.user.NbaUser;

class SetVersionStatus {

    NbaUser changedBy
	Date changedOn = new Date()
	VersionStatus versionStatus
	ApplicationForm1 applicationForm1
	
    static constraints = {
		
		versionStatus blank:true,nullable:true
		changedBy blank:true,nullable:true
		changedOn blank:true,nullable:true
    }
	
	public enum VersionStatus {
		RE_SUBMITION('Resubmition'),RE_SUBMISSION_DONE('Done'),
	
		final String value
	
		private VersionStatus(String value) {
			this.value = value
		}
	
		String toString() {
			value
		}
	}
}
