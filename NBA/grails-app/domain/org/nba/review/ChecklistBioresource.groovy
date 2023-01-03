package org.nba.review

class ChecklistBioresource {
	
	String bioRemarks
		
	String chkname
	String chkcommonName
	String chkscientificName
	String chknature
	String chkbiologicalResource
	String chkQuantity
	String chkTotime
	String chkFromtime
	
	static belongsTo = [formRemark:FormRemark]

    static constraints = {
		bioRemarks nullable:true,blank:true
		chkname nullable:true,blank:true
		chkcommonName nullable:true,blank:true
		chkscientificName nullable:true,blank:true
		chknature nullable:true,blank:true
		chkbiologicalResource nullable:true,blank:true
		chkQuantity nullable:true,blank:true
		chkTotime nullable:true,blank:true
		chkFromtime nullable:true,blank:true
		formRemark nullable:true,blank:true
    }
}
