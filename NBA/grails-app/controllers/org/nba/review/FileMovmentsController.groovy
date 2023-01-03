package org.nba.review
import org.springframework.security.access.annotation.Secured;
import org.nba.review.AddNote;
import org.nba.application.ApplicationForm1;

@Secured('permitAll')
class FileMovmentsController {



	def fileMovment(){
		def formId = params.instance
		if(formId == "" || formId == null){
			
		flash.message = "Please select an application"
		redirect(controller:'dashboard', action:'dashboard')
		return;
		}
		println "params.instance" +params.instance
		def getFormId = params.instance
		def formDetails = ApplicationForm1.get(Long.parseLong(getFormId))
		
		def listInstance = AddNote.findAllByApplicationForm1(formDetails,[sort: "noteDate", order: "desc"])
		println "list ---- "+listInstance
		[applicationList:listInstance,formDetails:formDetails]
	}
	
	
}
