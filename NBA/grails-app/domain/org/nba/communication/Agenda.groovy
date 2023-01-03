package org.nba.communication

import org.nba.application.ApplicationForm1;

class Agenda {
	
	String expertView
	String remarkByNba
	String thirdpartyPurpose
	String quantityeBio
	String gioLoction
	String commonOrScientificName
	String speciesName
	String natureBio
	String applicationFee
	String individualOrEntity
	String formType
	String name
    String address
    String whetherTraditional
	String screeningBiores
	String rareEndemic
	String wildlifeAct
    String restricted
	String originalFile
	String proposal
	String anyOther
	
	String createdBy
	String updatedBy
	String approveBy
	Date createDate
	Date updateDate
	
	Date sendDate
	String appNumber
	
	String recommendationSbb
	
	String approvalNBA
	
	// checklist value added in agenda
	
	String sbbbmc
	String refNo
    String receiptTimeTaken
	String inordinateDelay
	String whetherListNTC
	String alreadyExpEC
	String prescribedApplication
	String  actiontaken 
	
	String meetingName
	String meetingNum
	String fromDate
	String toDate
	String dynamicMeetNum
	
	String agendaPdfName
	String agendaPdfUrl
	String recommendationByNba
	Boolean recoStatus
	
	
	
	static hasOne = [agendaLetterStatus: AgendaLetterStatus]
	
	static belongsTo = [applicationForm1:ApplicationForm1,parentAgenda:ParentAgenda]
    static hasMany = [signature:AgendaSign]
	
//	static mapping = {
//		expertView type: 'text'
//		remarkByNba type: 'text'
//	  }


    static constraints = {
		
		
		expertView  blank:true, nullable:true, size:1..6000
		remarkByNba blank:true, nullable:true, size:1..6000
		recommendationByNba blank:true, nullable:true, size:1..6000
		thirdpartyPurpose blank:true, nullable:true, size:1..1000
		
		quantityeBio blank:true, nullable:true
		commonOrScientificName blank:true, nullable:true
		speciesName blank:true, nullable:true
		natureBio blank:true, nullable:true
		applicationFee blank:true, nullable:true
		individualOrEntity blank:true, nullable:true
		formType blank:true, nullable:true
		expertView blank:true, nullable:true
		remarkByNba blank:true, nullable:true
		name blank:true, nullable:true
		address blank:true, nullable:true
		whetherTraditional blank:true, nullable:true
		screeningBiores  blank:true, nullable:true
		rareEndemic blank:true, nullable:true
		wildlifeAct blank:true, nullable:true
		restricted blank:true, nullable:true
		originalFile blank:true, nullable:true
		proposal blank:true, nullable:true
		anyOther blank:true, nullable:true
		individualOrEntity blank:true, nullable:true
		applicationForm1 blank:true, nullable:true
		agendaLetterStatus blank:true, nullable:true
		createdBy blank:true, nullable:true
		updatedBy blank:true, nullable:true
		createDate blank:true, nullable:true
		sendDate blank:true, nullable:true
		appNumber blank:true, nullable:true
		gioLoction blank:true, nullable:true
		 approveBy blank:true, nullable:true
		 updateDate blank:true, nullable:true
		recommendationSbb blank:true, nullable:true
		sbbbmc blank:true, nullable:true
		refNo blank:true, nullable:true
		receiptTimeTaken blank:true, nullable:true
		inordinateDelay blank:true, nullable:true
		whetherListNTC blank:true, nullable:true
		alreadyExpEC blank:true, nullable:true
		prescribedApplication blank:true, nullable:true
		actiontaken blank:true, nullable:true
		
	    meetingName blank:true, nullable:true
		meetingNum blank:true, nullable:true
		fromDate blank:true, nullable:true
		toDate blank:true, nullable:true
	   dynamicMeetNum blank:true, nullable:true
	   agendaPdfUrl blank:true, nullable:true
	   agendaPdfName blank:true, nullable:true
	   recoStatus blank:true, nullable:true
	   approvalNBA blank:true, nullable:true,size: 0..10000
    }
}
