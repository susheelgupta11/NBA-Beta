package org.nba.expert

import org.nba.application.AppStatus
import org.nba.application.ApplicationForm1
import org.nba.application.FormCategory
import org.nba.communication.LetterCommunication
import org.nba.communication.LetterStatus
import org.nba.communication.LetterType
import org.nba.review.AddNote
import org.springframework.security.access.annotation.Secured
@Secured('permitAll')
class SuperAdminController {
	
	def springSecurityService
	def applicationNotingService

	
	def dashboard(){
		
		def csrfPreventionSalt = params.csrfPreventionSalt
		def applicationDetails =  ApplicationForm1.createCriteria().list(params){
			category{
				ne('category', FormCategory.Category.Form_C)
			}
			and {
				currentStatus {
					eq('forwardedUser', springSecurityService?.getCurrentUser()?.username )

				}
			}
		}
		
		def recordRoomApplication = ApplicationForm1.createCriteria().list(params) {
//			category{
//				ne('category', FormCategory.Category.Form_C)
//			}
//			and {
				currentStatus {
					eq('forwardedUser' , 'virtual' )

				}
//			}
			
		}
		
		
	def approvedApplications = ApplicationForm1.createCriteria().list(params){
			currentStatus {
				eq('status', AppStatus.Status.APPROVED)
			}
		}
		
		def rejectedApplications = ApplicationForm1.createCriteria().list(params){
			currentStatus {
				eq('status', AppStatus.Status.REJECTED)
			}
		}
		
		
		[applicationDetails:applicationDetails, recordRoomApplication:recordRoomApplication, approvedApplications:approvedApplications,
			rejectedApplications:rejectedApplications, csrfPreventionSalt:csrfPreventionSalt]
	}
	
	
	def noting(){
		
				def csrfPreventionSalt = params.csrfPreventionSalt
				params.max = Math.min(params.max ? params.int('max') : 10, 100)
				
				if(params.instance == "" || params.instance == null){
		
					flash.message = "Please select an application"
					redirect(action:'dashboard', params:[csrfPreventionSalt:csrfPreventionSalt])
					return;
				}
				
				ApplicationForm1 formDetails = ApplicationForm1.get(params.instance)
		
				def applicationNum = formDetails?.appNumber
				def submittedDate  = formDetails?.submittedOn
				
				println "formDetails"+formDetails.getClass()
		
				println "applicationNum"+applicationNum
				
		//		def viewNoteDetails = AddNote.findAllByFormNumber(applicationNum)
			
					def query = AddNote.where {
					formNumber == applicationNum
				 }
					def commentCount = query.list().size()
					def viewNoteDetails = query.list(params).sort{it.noteDate}.reverse()
				
				String currentLoginUser = springSecurityService?.getCurrentUser()?.username
		
				// if we want to show all the comment other than the current  user
				/*	def c = AddNote.createCriteria()
				 viewNoteDetails = c.list {
				 ne("notedUser", currentLoginUser)
				 }*/
				[viewNoteDetails:viewNoteDetails,formDetails:formDetails, commentCount :commentCount,
					applicationNum:applicationNum,submittedDate:submittedDate,csrfPreventionSalt:csrfPreventionSalt,params:params]
			}
		
		
			def addNote(){
		
				def csrfPreventionSalt = params.csrfPreventionSalt
				def formId = params.instance
				def addNoteInstance = new AddNote()
				
				if(formId == "" || formId == null){
		
					flash.message = "Please select an application"
					redirect(action:'dashboard',params:[csrfPreventionSalt:csrfPreventionSalt])
					return;
				}
		
				def formDetails = ApplicationForm1.get(formId)
		
				def applicationNum = formDetails?.appNumber
				def submittedDate  = formDetails?.submittedOn
				println "formDetails"+formDetails.getClass()
		
				def currentLoginUser = springSecurityService?.getCurrentUser()?.username
				def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()
				
				def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)
		
				[addNoteInstance:addNoteInstance,applicationNum:applicationNum,submittedDate:submittedDate,dropDnValues:dropDnValues,
					formDetails:formDetails,allDataforMatching:allDataforMatching,csrfPreventionSalt:csrfPreventionSalt]
			}
		
		
			def saveNote(){
		
			def csrfPreventionSalt = params.csrfPreventionSalt
			def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()
		
				if(params.applicationInstance == "" || params.applicationInstance == null){
		
					flash.message = "Application Form Number missing"
					render( view: "addNote",  model: [dropDnValues:dropDnValues])
					return
				}
		
				def getAllpdfFile =  request.getFiles('multiFile')
				println "received files are here--------"+getAllpdfFile
				
				def instance = applicationNotingService.addNoteForApplication(params,getAllpdfFile)
				
				redirect(action:'noting', params:[instance:instance,csrfPreventionSalt:csrfPreventionSalt])
			}
			
	
//	def tr5ReceiptIssue(){
//
//		def tr5IssueList = LetterCommunication.where{
//
//	 applicationForm1 == formDetails && 
//	 letterStatus.ltrstatus == LetterStatus.LtrStatus.LETTER_APPROVED && 
//	 letterType.ltrType == LetterType.LtrType.TR5_LETTER
//	 }.list()
//		
//	[tr5IssueList:tr5IssueList]
//	}
//	
	
	
	
	def crystalReport(){
		
	def totalForm = ApplicationForm1.createCriteria().list(params){
		currentStatus {
			eq('status', AppStatus.Status.SUBMITTED)
		}	
	}.size()
	
	def inprocss = ApplicationForm1.createCriteria().list(params){
		currentStatus {
			eq('status', AppStatus.Status.IN_PROCESS)
		}
	}.size()
		
	
	def approved = ApplicationForm1.createCriteria().list(params){
		currentStatus {
			eq('status', AppStatus.Status.APPROVED)
		}
	}.size()
	
	def rejected = ApplicationForm1.createCriteria().list(params){
		currentStatus {
			eq('status', AppStatus.Status.REJECTED)
		}
	}.size()
	
	def labels = [totalForm, inprocss, approved, rejected]
	
	
   [labels:labels]	
	
	}		
}
