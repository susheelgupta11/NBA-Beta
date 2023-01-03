package org.nba.master

class MstrAppStage {

	Stage stage
	static constraints = {
		stage nullable:true,blank:true
	}
	public enum Stage {
		APPLICATION_CREATED('Application Created'),
		APPLICATION_SUBMITTED('Application Submitted'),
		
		WITH_REVIEW_HEAD('With Review head'),
		WITH_REVIEW_MEMBER('With Review member'),
		VERIFIED_BY_REVIEW_MEMBER('Approved by Review member'),
		APPROVED_BY_REVIEW_HEAD('Approved by Review head'),
		REJECTED_BY_REVIEW_HEAD('Rejected by Revied head'),
		NOT_UP_TO_THE_MARK_BY_REVIEW_HEAD('Not up to the mark by Review head'),
		
		WITH_ACCOUNT_SECTION('With Account Section'),
		WITH_ACC_ASSISTANT_MEMBER('With Account assistant member'),
		VERIFIED_BY_ACC_ASSISTANT_MEMBER('Verified by Account assistant member'),
		APPROVED_BY_ACCOUNT_HEAD('Approved by Account head'),
		NOT_APPROVED_BY_ACCOUNT_HEAD('Not approved by Account head'),

		MODIFICATION_SOUGHT_BY_TOBS('Modification sought by TOBS'),
					
		WITH_LEGAL_HEAD('With Legal head'),
		APPROVED_BY_LEGAL_HEAD('Approved by Legal head'),
		NOT_UP_TO_THE_MARK_BY_LEGAL_HEAD('Not up to the mark by Legal head'),
		WITH_LEGAL_MEMBER('With Legal member'),
		VERIFIED_BY_LEGAL_MEMBER('Approved by Legal member'),
		
		
		WITH_SECRETARY('With Secretary')
		

		final String value

		private Stage(String value) {
			this.value = value
		}

		String toString() {
			value
		}
	}
}
