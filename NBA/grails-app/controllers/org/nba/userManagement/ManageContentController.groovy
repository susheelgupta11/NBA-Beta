package org.nba.userManagement

import org.nba.master.ManageLoginContent
import org.nba.user.NbaUserNbaRole


class ManageContentController {

	def springSecurityService
	def beforeInterceptor = {

		def role = NbaUserNbaRole.findByNbaUser(springSecurityService.currentUser)?.nbaRole?.authority
		if (role == 'ADMIN') {
		} else {
			redirect(controller: 'login', action: 'denied')
		}
	}
	def index() {}


	def adminEdits() {
		
		def abc = session["csrfPreventionSalt"]
		println "abc--"+abc
		
		def csrfPreventionSalt
		
		if(params?.csrfPreventionSalt)
			csrfPreventionSalt = params?.csrfPreventionSalt
		else
			csrfPreventionSalt = session["csrfPreventionSalt"]
		
		
		
		println "inside Admin Edits"+params
		int revision = 0
		def aboutNBA = ManageLoginContent?.findByRev(0)
		println "aboutNBAaboutNBA"+aboutNBA?.aboutNBA
		[aboutNBA:aboutNBA, csrfPreventionSalt:csrfPreventionSalt]
	}
	
	def saveAdminEdits(){
		if(params?.aboutNbaId){
			def saveAboutNBA = ManageLoginContent.get(params?.aboutNbaId)
			saveAboutNBA.aboutNBA = params.aboutUs
			if(!saveAboutNBA.save(flush:true)){
				saveAboutNBA?.errors?.each{ println }
			}
		}
		redirect(action:"adminEdits", params:[])
	}
	
	

	def latestUpdates() {
		println "inside latest updates"+params
//		def csrfPreventionSalt = params?.csrfPreventionSalt
		
		def abc = session["csrfPreventionSalt"]
		println "abc--"+abc
		
		
		def csrfPreventionSalt
		
		if(params?.csrfPreventionSalt)
			csrfPreventionSalt = params?.csrfPreventionSalt
		else
			csrfPreventionSalt = session["csrfPreventionSalt"]
		
		println "----------------================"+csrfPreventionSalt
		int revision = 0
		def latestUpdates = ManageLoginContent?.findByRev(0)

		println "latestUpdateslatestUpdateslatestUpdates"+latestUpdates?.latestUpdate
		[latestUpdates:latestUpdates,csrfPreventionSalt:csrfPreventionSalt]
	}
	
	def saveLatestUpdates(){
		if(params?.latestUpdatesId){
			def saveLatestUpdates = ManageLoginContent?.get(params?.latestUpdatesId)
			saveLatestUpdates?.latestUpdate = params?.latestUpdates
			if(!saveLatestUpdates?.save(flush:true)){
				saveLatestUpdates?.errors?.each{println}
			}
		}
		forward(action:"latestUpdates", params:[])
	}

	def instructionToApplicant(){
		
		def abc = session["csrfPreventionSalt"]
		println "abc--"+abc
		
		
		println "inside latest updates"+params
//		def csrfPreventionSalt = params?.csrfPreventionSalt
		
		def csrfPreventionSalt
		
		if(params?.csrfPreventionSalt)
			csrfPreventionSalt = params?.csrfPreventionSalt
		else
			csrfPreventionSalt = session["csrfPreventionSalt"]
		
		int revision = 0
		def instructions = ManageLoginContent?.findByRev(0)
		
		[instructions:instructions,csrfPreventionSalt:csrfPreventionSalt]
	}
	
	def saveInstructionToApplicant(){
		if(params?.instructionsId){
			def instructionsToApplicant = ManageLoginContent?.get(params?.instructionsId)
			instructionsToApplicant?.instructions = params?.instructionToApplicant
			if(!instructionsToApplicant?.save(flush:true)){
				instructionsToApplicant?.errors?.each{println}
			}
		}
		forward(action:"instructionToApplicant", params:[])
	}

	def faqs() {
		
		def abc = session["csrfPreventionSalt"]
		println "abc--"+abc
		
		
		println "inside faqsssssss"+params
		//		ManageLoginContent faqs = new ManageLoginContent();
		println "inside latest updates"+params
//		def csrfPreventionSalt = params?.csrfPreventionSalt
		
		def csrfPreventionSalt
		
		if(params?.csrfPreventionSalt)
			csrfPreventionSalt = params?.csrfPreventionSalt
		else
			csrfPreventionSalt = session["csrfPreventionSalt"]
			
		int revision = 0
		def faqS = ManageLoginContent?.findByRev(0)

		
		println "faqS=="+faqS.faq


		[faqS:faqS,csrfPreventionSalt:csrfPreventionSalt]
	}
	
	def saveFaqs(){
		if(params?.faqId){
			def faqObj = ManageLoginContent?.get(params?.faqId)
			faqObj?.faq = params?.faqs
			if(!faqObj?.save(flush:true)){
				faqObj?.errors?.each{println}
			}
		}
		forward(action:"faqs", params:[])
	}
}
