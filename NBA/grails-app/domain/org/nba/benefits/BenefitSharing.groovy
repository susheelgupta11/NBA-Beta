package org.nba.benefits

import org.nba.application.ApplicationForm1
import org.nba.communication.PeriodicFileAttach

class BenefitSharing {
	String bsName
	String appNumber
	String formType
	String transNumber
	String amountIn
	String tr5ReceiptNumber
	String remarks
	String modeOfPayment
	String factorValues
	String category
	String typeOfSharing
	
	Date dateBenefit
	
	static belongsTo = [applicationForm1:ApplicationForm1]
	
	static hasMany = [periodicFiles:PeriodicFileAttach]
  
	  static constraints = {
		
		 bsName blank:true,nullable:true
		appNumber blank:true,nullable:true
		formType blank:true,nullable:true
		transNumber blank:true,nullable:true
		amountIn blank:true,nullable:true
		tr5ReceiptNumber blank:true,nullable:true
		remarks blank:true,nullable:true
		modeOfPayment blank:true,nullable:true
		factorValues blank:true,nullable:true
		category blank:true,nullable:true
		typeOfSharing blank:true,nullable:true
		dateBenefit blank:true,nullable:true
    }
}
