package org.nba.communication

class ParentAgenda {
	
	String  agendaName
	Integer agendaCounter
	Integer agendasentCounter
	Integer recoCounter
	Date meetingDate
	
	static hasMany = [agendasForP:Agenda]
	
    static constraints = {
		agendaName nullable:true,blank:true
		agendaCounter nullable:true,blank:true
		agendasentCounter  nullable:true,blank:true
		meetingDate  nullable:true,blank:true
		recoCounter nullable:true,blank:true
    }
}
