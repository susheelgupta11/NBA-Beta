package org.nba.communication

import org.nba.benefits.BenefitSharing;

class PeriodicFileAttach {
	
	String pathUrl
	String fileName
	Date fileDate
	
	static belongsTo = [periodicReport:PeriodicReport,benefitSharing:BenefitSharing]

	
    static constraints = {
		pathUrl nullable:true, blank:true
		fileName nullable:true, blank:true
		fileDate nullable:true, blank:true
		benefitSharing nullable:true, blank:true
		periodicReport nullable:true, blank:true
    }
	
}
