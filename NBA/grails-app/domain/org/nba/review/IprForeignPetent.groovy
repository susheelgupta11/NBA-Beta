package org.nba.review

class IprForeignPetent {
	
	String serialNumber
	String countryTerritoryName
	String patentApplicationNum
	String datePatent
	String statusPatent
	String patentNumAndDateIfGranted
	String remarksPetent

	static belongsTo = [iprRemark:IprRemark]
	
	
    static constraints = {
		
		serialNumber blank:true, nullable:true
		countryTerritoryName blank:true, nullable:true
		patentApplicationNum blank:true, nullable:true
		datePatent blank:true, nullable:true
		statusPatent blank:true, nullable:true
		patentNumAndDateIfGranted blank:true, nullable:true
		remarksPetent blank:true, nullable:true
		iprRemark blank:true, nullable:true
    }
}
