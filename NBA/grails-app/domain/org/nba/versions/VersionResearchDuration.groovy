package org.nba.versions

class VersionResearchDuration {

    String typeOfExercise
	String reasonsForSending
	String numOfTimesOfSending
	

    static constraints = {
		typeOfExercise nullable:true, blank:true
		reasonsForSending nullable:true, blank:true
		numOfTimesOfSending nullable:true, blank:true
    }
}
