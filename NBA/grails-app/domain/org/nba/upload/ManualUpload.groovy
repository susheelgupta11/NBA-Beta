package org.nba.upload

import org.nba.application.ApplicationForm1;

class ManualUpload {

	String uploadType

//file details
		
	String classified
	String language
	String type 
	String letterDate
	String mobileNumber
	String fileNumber
	String deliveryMode
	String letterReferenceNumber
	
//contact details
	String name
	String designation
	String address1
	String address2
	String country
	String state
	String city
	String pin	
	
// dynamic pdf
	
	String dyName
	String dyUrl
	
	
// clearance letter	
	String docType
	String date
	String fileName
	String fileUrl
	
	
static belongsTo = [applicationForm1:ApplicationForm1]

    static constraints = {
		
		 uploadType blank:true,nullable:true
		 classified blank:true,nullable:true
		 language  blank:true,nullable:true
		 type  blank:true,nullable:true
		 letterDate  blank:true,nullable:true
		 mobileNumber  blank:true,nullable:true
		 fileNumber  blank:true,nullable:true
		 deliveryMode blank:true,nullable:true
		 letterReferenceNumber blank:true,nullable:true
		
	
		 name       blank:true,nullable:true
		 designation blank:true,nullable:true
		 address1  blank:true,nullable:true
		 address2  blank:true,nullable:true
		 country  blank:true,nullable:true
		 state  blank:true,nullable:true
		 city  blank:true,nullable:true
		 pin  blank:true,nullable:true
		 dyName blank:true,nullable:true
		 dyUrl blank:true,nullable:true
		 
		 docType   blank:true,nullable:true
		 date      blank:true,nullable:true
		 fileName  blank:true,nullable:true
		 fileUrl   blank:true,nullable:true
    } 
}
