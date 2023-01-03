package org.nba.application

import grails.transaction.Transactional

import org.apache.commons.lang.RandomStringUtils
import org.nba.user.NbaUser
import org.nba.user.PasswordHistory

@Transactional
class UserManagementService {
	def springSecurityService

//    def showTobs(List listOfRoles, String roles, GrailsParameterMap params) {
//
//		def applicationsize = ApplicationForm1.createCriteria().list(){
//			if(roles == "TECHNICAL_OFFICER_BS")
//			{
//				currentStatus{
//					eq('status',AppStatus.Status.SUBMITTED)
//					}
//			}
//			else
//				eq('submittedBy',springSecurityService.currentUser)
//		}
//		def applications = ApplicationForm1.createCriteria().list(max: params.max, offset: params.offset){
//			println "@@@@@@@@@@@@@@@@@@"
//			if(roles == "TECHNICAL_OFFICER_BS")
//			{
//				
//				currentStatus{
//					eq('status',AppStatus.Status.SUBMITTED)
//					}
//					order("submittedOn","desc")
//					order("appNumber","desc")
//					
//			}
//			else
//			eq('submittedBy',springSecurityService.currentUser)
//		}
//		def appForm = ApplicationForm1?.get(params.id)
//		println "params.appFormeeeeee"+appForm
//		println "applications == +++++++++++++++++++++++++++++++++++++++++++++"+(applications.sort{it.id})
//		
//		return [applications:applications.sort{it?.appNumber?.substring(10,14)}.reverse(),appForm:appForm,applicationsize:applicationsize]
//		
//    }
	
	public String selectDashboardForRecordRoom(ApplicationForm1 formIns){

		formIns.currentStatus.forwardedUser = springSecurityService.currentUser.username
		formIns.currentStatus.status = AppStatus.Status.IN_PROCESS
		formIns.currentStatus.changedBy = springSecurityService.currentUser
		formIns.currentStatus.userCounter = false

		if(!formIns.save(flush:true)){
			formIns.errors.allErrors.each {print it}
		}

		def message = "Application save to inbox"
		return message;
	}

	
	public  String getDynamicString() {
		String charset = (('A'..'Z') + ('0'..'9')).join()
		Integer length = 10
		String randomString = RandomStringUtils.random(length, charset.toCharArray())
		return randomString;
	}
	
	
	public setPasswordHistory(String pass, String usr){
		
		PasswordHistory passHistory = new PasswordHistory(password:pass,updatedOn: new Date(),
			 user: NbaUser.findByUsername(usr))
		 
		     if(!passHistory.save(flush:true)){
			 
			passHistory.errors.allErrors.each {print it} 
		 }
	}
	
}
