package org.nba.application

import org.nba.user.NbaUser

class AppStatus {

	NbaUser changedBy
	Date changedOn
	Status status
	String statusUpdate
	String priority
	String currentComment
	String forwardedUser
	String sendByUser
	Boolean userCounter
	Date forwardedDate
	Boolean linkOfficerCheck
	
	String actionFor
	String reasonForRecordRoom
	Date fromRecord
	Date toRecord
	Boolean communicationStatus
	Boolean commStatusApplicant
    String currentDesk
	
	static belongsTo = [application:ApplicationForm1]
    static constraints = {
		
		statusUpdate blank:true,nullable:true
		priority blank:true,nullable:true
		currentComment blank:true,nullable:true,size: 0..1000000
		forwardedUser blank:true,nullable:true
		changedOn  blank:true,nullable:true
		userCounter blank:true,nullable:true
		forwardedDate blank:true,nullable:true
		linkOfficerCheck blank:true,nullable:true
		 actionFor  blank:true,nullable:true
		 reasonForRecordRoom blank:true,nullable:true
		 fromRecord blank:true,nullable:true
		 toRecord blank:true,nullable:true
		 sendByUser blank:true,nullable:true
		 communicationStatus blank:true,nullable:true
		 currentDesk blank:true,nullable:true
		 commStatusApplicant blank:true,nullable:true 
    }
	public enum Status {
		SUBMITTED('Submitted'),CREATED('Created'),APPROVED('Approved'),PENDING('Pending'),SBB_RES('SBB-Responded'),
		REJECTED('Rejected'),IN_PROCESS('In Process'),RECORD_ROOM('In Record Room'),NBA_PENDING('Dept. resubmission ')
	
		final String value
	
		private Status(String value) {
			this.value = value
		}
	
		String toString() {
			value
		}
	}
}
