package org.nba.review

import org.nba.application.ApplicationForm1;

class IprRemark {
	
	String patentDtsRmk
	String foreignPatentRemark
	Boolean foreignPetentChk
	String mtcWithPatentAppRmk
	Boolean mtcWithPatentAppChk
	Boolean bioresourceMtcChk
	String bioresourceMtcRmk
	Boolean dtsCommercializationChk
	String detailsCommercialRmk
	String country
	String financialYr
	String amount
	String remarksA
	String questionRequired
	
	static hasMany = [iprForignPetents:IprForeignPetent,questionAnswers:QuestionAnswer]
    static belongsTo = [applictaionForm1:ApplicationForm1]
	
    static constraints = {
		patentDtsRmk blank:true,nullable:true
		foreignPatentRemark blank:true,  nullable:true
		foreignPetentChk blank:true,nullable:true 
		mtcWithPatentAppRmk blank:true,nullable:true
		mtcWithPatentAppChk blank:true,nullable:true
		bioresourceMtcChk blank:true,nullable:true
		bioresourceMtcRmk blank:true,nullable:true
		dtsCommercializationChk blank:true,nullable:true
		detailsCommercialRmk blank:true,nullable:true
		country blank:true,nullable:true
		financialYr blank:true,nullable:true
		amount blank:true,nullable:true
		remarksA blank:true,nullable:true
		questionRequired blank:true,nullable:true
		applictaionForm1 blank:true,nullable:true
    }
}
