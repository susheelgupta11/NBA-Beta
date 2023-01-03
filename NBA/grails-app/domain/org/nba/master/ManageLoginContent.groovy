package org.nba.master

class ManageLoginContent {
	
	String aboutNBA
	String latestUpdate
	String instructions
	String faq
	int rev

    static constraints = {
		aboutNBA nullable:true, blank:true, size: 0..100000
		latestUpdate nullable:true, blank:true, size: 0..100000
		instructions nullable:true, blank:true, size: 0..1000000
		faq nullable:true, blank:true, size: 0..10000000
		rev nullable:true, blank:true
    }
}
