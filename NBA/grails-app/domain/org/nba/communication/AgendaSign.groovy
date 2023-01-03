package org.nba.communication

class AgendaSign {
	
	String agendaAction
	String agendaActionBy
	String agendaActionRole
	Date   agendaActionDate
	
	static belongsTo = [agenda:Agenda]

    static constraints = {
		agendaAction blank:true, nullable:true
		agendaActionBy blank:true, nullable:true
		agendaActionRole blank:true, nullable:true
		agendaActionDate blank:true, nullable:true
		agenda blank:true, nullable:true
    }
}
