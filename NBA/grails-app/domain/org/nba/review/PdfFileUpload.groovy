package org.nba.review


class PdfFileUpload {
	
	String fileName
	String pathForFile
	Date uploadingDate
	
	static belongsTo = [addnote:AddNote]

    static constraints = {
		
		 fileName blank:true,nullable:true
		 pathForFile blank:true,nullable:true
		 uploadingDate blank:true,nullable:true
		 addnote blank:true,nullable:true
		
    }
}
