package org.nba.master

class SetMstrData {
	
	Set<String> draft
	Set<String> note
	Set<String> submission
	Set<String> actions
	Set<String> priority
	Set<String> status
	Set<String> quries
	
	static hasMany = [
		draft: String,note:String,submission:String,
		actions:String,priority:String,status:String,quries:String]
		

	
    static constraints = {
   
}
}
