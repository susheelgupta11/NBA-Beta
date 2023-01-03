package org.nba.mgmt

import java.util.Date;

import org.nba.application.AppStatus;
import org.nba.application.ApplicationForm1;
import org.nba.application.FormCategory;
import org.nba.application.IndividualProfile;
import org.nba.master.QuestionCategory;
import org.nba.user.NbaUser;
import org.nba.versions.SetVersionStatus;
import org.nba.versions.VersionAgentProfile;
import org.nba.versions.VersionAppStatus;
import org.nba.versions.VersionApplicationForm1;
import org.nba.versions.VersionFormCategory;
import org.nba.versions.VersionIndividualProfile;
import org.nba.versions.VersionQuestion;
import org.nba.versions.VersionTransaction;
import org.springframework.security.access.annotation.Secured
@Secured('permitAll')
class VersionManagerController {
def applicationVersionManagementService
    def index() { 
		
		def getFormId = params.instance
		def csrfPreventionSalt = params.csrfPreventionSalt
		
		if(getFormId == null || getFormId ==''){
		def	message = "Please select an application"
			redirect(action:'dashboard',controller:'dashboard' , params:[message:message])
			return;
		}
		
		
		def checkFormType = ApplicationForm1.get(getFormId as Long).category.category
		
	
		if(checkFormType == FormCategory.Category.Form_1){
		 
		redirect(action:'formOneVersioning', params:[instance:getFormId,csrfPreventionSalt:csrfPreventionSalt])
		return;
		}
		
		else if(checkFormType == FormCategory.Category.Form_2){
			redirect(action:'formTwoVersioning', params:[instance:getFormId,csrfPreventionSalt:csrfPreventionSalt])
			return;
			}
		else if(checkFormType == FormCategory.Category.Form_3){
			redirect(action:'formThreeVersioning', params:[instance:getFormId,csrfPreventionSalt:csrfPreventionSalt])
			return;
			}
		else if(checkFormType == FormCategory.Category.Form_4){
			redirect(action:'formFourVersioning', params:[instance:getFormId,csrfPreventionSalt:csrfPreventionSalt])
			return;
			}
		else if(checkFormType == FormCategory.Category.Form_B){
			redirect(action:'formBVersioning', params:[instance:getFormId,csrfPreventionSalt:csrfPreventionSalt])
			return;
			}
	}
	
	
	
	
	def formOneVersioning(){
		def formId = params.instance
		def csrfPreventionSalt = params.csrfPreventionSalt
		
		def applicationDetails = ApplicationForm1.get(formId as Long)
		def makingDuplicate = applicationVersionManagementService.copyContentForVersioning(applicationDetails,'Form 1', 'Submitted')
		if(makingDuplicate != null){
		def changeApplicationStatus = applicationVersionManagementService.setVersionStatus(SetVersionStatus.VersionStatus.RE_SUBMITION, AppStatus.Status.NBA_PENDING, applicationDetails)	
		}
		def message = "Application is sent for re-submission"
			redirect(action:'dashboard',controller:'dashboard', params:[message:message])
	}
	def formTwoVersioning(){
		def formId = params.instance
		def csrfPreventionSalt = params.csrfPreventionSalt
		
		def applicationDetails = ApplicationForm1.get(formId as Long)
		def makingDuplicate = applicationVersionManagementService.copyContentForVersioning(applicationDetails,'Form 2', 'Submitted')
		
		if(makingDuplicate != null){
		def changeApplicationStatus = applicationVersionManagementService.setVersionStatus(SetVersionStatus.VersionStatus.RE_SUBMITION, AppStatus.Status.NBA_PENDING, applicationDetails)	
		}
		def message = "Application is sent for re-submission"
			redirect(action:'dashboard',controller:'dashboard', params:[message:message])
	}
	def formThreeVersioning(){
		def formId = params.instance
		def csrfPreventionSalt = params.csrfPreventionSalt
		
		def applicationDetails = ApplicationForm1.get(formId as Long)
		def makingDuplicate = applicationVersionManagementService.copyContentForVersioning(applicationDetails,'Form 3', 'Submitted')
		
		if(makingDuplicate != null){
		def changeApplicationStatus = applicationVersionManagementService.setVersionStatus(SetVersionStatus.VersionStatus.RE_SUBMITION, AppStatus.Status.NBA_PENDING, applicationDetails)	
		}
		def message = "Application is sent for re-submission"
			redirect(action:'dashboard',controller:'dashboard', params:[message:message])
		
	}
	def formFourVersioning(){
		def formId = params.instance
		def csrfPreventionSalt = params.csrfPreventionSalt
		
		def applicationDetails = ApplicationForm1.get(formId as Long)
		def makingDuplicate = applicationVersionManagementService.copyContentForVersioning(applicationDetails,'Form 4', 'Submitted')
		
		if(makingDuplicate != null){
		def changeApplicationStatus = applicationVersionManagementService.setVersionStatus(SetVersionStatus.VersionStatus.RE_SUBMITION, AppStatus.Status.NBA_PENDING, applicationDetails)	
		}
		def message = "Application is sent for re-submission"
			redirect(action:'dashboard',controller:'dashboard', params:[message:message])
	}
	def formBVersioning(){
		def formId = params.instance
		def csrfPreventionSalt = params.csrfPreventionSalt
		
		def applicationDetails = ApplicationForm1.get(formId as Long)
		def makingDuplicate = applicationVersionManagementService.copyContentForVersioning(applicationDetails,'Form B', 'Submitted')
		 
		if(makingDuplicate != null){
		def changeApplicationStatus = applicationVersionManagementService.setVersionStatus(SetVersionStatus.VersionStatus.RE_SUBMITION, AppStatus.Status.NBA_PENDING, applicationDetails)	
		}
		def message = "Application is sent for re-submission"
			redirect(action:'dashboard',controller:'dashboard', params:[message:message])
	}
}
