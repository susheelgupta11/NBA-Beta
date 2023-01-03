package org.nba.master

class LetterTemplate {
	
	String templateLetter
	String letterName
	Date templateCreationDate
	
	static mapping = {
		templateLetter type: 'text'
	}

    static constraints = {
		templateLetter nullable:true,blank:true,size: 0..65535
		letterName nullable:true,blank:true
		templateCreationDate nullable:true,blank:true
    }
}
