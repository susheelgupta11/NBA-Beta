package org.nba.versions

import java.util.Date;

import org.nba.application.AppStatus.Status;
import org.nba.user.NbaUser;

class VersionAppStatus {

   	NbaUser changedBy
	Date changedOn = new Date()
	Status status
	
	
	static belongsTo = [application:VersionApplicationForm1]
    static constraints = {
	
    }
	public enum Status {
		SUBMITTED('Submitted'),CREATED('Created'),APPROVED('Approved'),PENDING('Pending'),REJECTED('Rejected'),IN_PROCESS('In Process')
	
		final String value
	
		private Status(String value) {
			this.value = value
		}
	
		String toString() {
			value
		}
	}
}
