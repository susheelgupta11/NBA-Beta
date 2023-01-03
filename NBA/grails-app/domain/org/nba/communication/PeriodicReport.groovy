package org.nba.communication

import org.nba.application.ApplicationForm1;

class PeriodicReport {

//for common
	
	String applicationNumber
	String applicantName
	String agreementSignDt
	String place
	String periodFrom
	String periodTo
	//for form 1
	String whetherAccessedBioRes
	String whenBiologicalResearch
	String whenBiologicalResearchTo
	String reserchCarriedOut
	String briefResearchCarried
	String haveYouPublished
	String haveAppliedPatent
	String haveTransferredResults
	String haveTransferredBiological
	
	String fileName
	String pathUrl
	String publishCheck
	String haveAppliedCheck
	String haveTrsCheck
	String trnsBioCheck
	
	
// for form 2
	String 	dtsTransferor 
	String  dtsTransferee
	String  modeOfTransfr
	String  monetBeneftOnTrsf
	String  detsOfbenefitSharing
	
// for form 3	
	String country
	String pan
	String status
	List mods
	String daac
	String feeReceived  
	
	
// for form 4
	
	String haveTransfer
	String haveTrsfCheck
	String dtsQuantityTfr	
	String dbsapAgree
	String dbsapCheck
	
// for pdf
   String dyFileName
   String dyFileURL
   Date generateDate	
 

     static belongsTo = [applicationForm:ApplicationForm1]
	 static hasMany = [periodicFiles:PeriodicFileAttach, mods: String]
	 
	static constraints = {

		applicationNumber nullable:true,blank:true
		applicantName nullable:true,blank:true
		agreementSignDt nullable:true,blank:true
		place nullable:true,blank:true
		periodFrom  nullable:true,blank:true
		periodTo  nullable:true,blank:true
		whetherAccessedBioRes nullable:true,blank:true
		whenBiologicalResearch nullable:true,blank:true
		whenBiologicalResearchTo  nullable:true,blank:true
		reserchCarriedOut nullable:true,blank:true
		briefResearchCarried nullable:true,blank:true
		haveYouPublished nullable:true,blank:true
		haveAppliedPatent nullable:true,blank:true
		haveTransferredResults nullable:true,blank:true
		haveTransferredBiological nullable:true,blank:true
		publishCheck nullable:true,blank:true
		haveAppliedCheck nullable:true,blank:true
		haveTrsCheck nullable:true,blank:true
		trnsBioCheck nullable:true,blank:true
		fileName nullable:true,blank:true
		pathUrl  nullable:true,blank:true
		
		dtsTransferor nullable:true,blank:true
		dtsTransferee nullable:true,blank:true
		modeOfTransfr nullable:true,blank:true
		monetBeneftOnTrsf nullable:true,blank:true
		detsOfbenefitSharing nullable:true,blank:true
		
		country nullable:true,blank:true
		pan nullable:true,blank:true
		status nullable:true,blank:true
		mods nullable:true,blank:true
		daac nullable:true,blank:true
		feeReceived nullable:true,blank:true
		
		
		haveTransfer nullable:true,blank:true
		haveTrsfCheck nullable:true,blank:true
		dtsQuantityTfr nullable:true,blank:true
		dbsapAgree nullable:true,blank:true
		dbsapCheck nullable:true,blank:true
		
		dyFileName nullable:true,blank:true
		dyFileURL nullable:true,blank:true
	    generateDate nullable:true,blank:true
	}
    }

