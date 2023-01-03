package org.nba.userManagement

import groovy.sql.Sql

import org.hibernate.SessionFactory
import org.nba.application.ApplicationForm1
import org.nba.benefits.BenefitSharing
import org.nba.communication.Agenda
import org.nba.communication.AgendaLetterStatus
import org.nba.communication.LetterCommunication
import org.nba.communication.LetterType
import org.nba.master.MstrDocument
import org.nba.user.LinkOfficer
import org.nba.user.NbaUser
import org.nba.user.UserLog
import org.springframework.security.access.annotation.Secured

import com.nba.constant.Constants
@Secured('permitAll')
class LoggedInAsController {
	def springSecurityService
	def simpleCaptchaService
	def nbaUserService
    def grailsApplication
	def userManagementService
	SessionFactory sessionFactory;
	static allowedMethods = [index: "GET", submitApplication: "GET", inbox: "GET"]

		def index() {
		println ("aaaaaaaaaaaaaaaaaaaa")
		if(springSecurityService.currentUser == null || springSecurityService.currentUser == ''){
			redirect(controller:"logout")
		}
		else{
		forward(action:"inbox")
	//		redirect(controller:'dashboard',action:'dashboard')
		}
	}
	

	def submitApplication(){
		if(session != null){
			session.removeAttribute("appFormId")
		}
		println "CURRENT USER %%%%%%%%%%% "+springSecurityService.currentUser
		[currentUser:springSecurityService.currentUser]
	}
	
	
	private String getClientIP() {
		String xfHeader = request.getHeader("X-Forwarded-For");
		if (xfHeader == null) {
			return request.getRemoteAddr();
		}
		return xfHeader.split(",")[0];
	}

	def inbox() {
		def adminUser,applications;
		def csrfPreventionSalt = request.getAttribute("csrfPreventionSalt")

		println "Welcome inside user type selection" + params
		params.max = params.max ?: 10
		params.offset = params.offset ?: 0
		
		def currentUser = springSecurityService.getCurrentUser().username
		NbaUser userDetails = NbaUser.findByUsername(currentUser)
		def currentUsrRole = userDetails?.nbaRole?.authority
		println "current Role in NBA User "+currentUsrRole
		

		// Handle User Log Here ----------------------------------
		
			UserLog  userlogInstance = new UserLog()
		     userlogInstance.name = userDetails?.name
			 userlogInstance.userName = currentUser

			 userlogInstance.ip = getClientIP()
			 
			 userlogInstance.loginTime  = new Date();
			 userlogInstance.save(flush:true)
		
		
		
		
		def roles= springSecurityService.getPrincipal().getAuthorities()
		def role = roles.toString().substring(1, roles.toString().length() - 1)
		println "role in NBA Role"+role

	
		if (roles.size() > 1 && !params?.currentRole) {

			println "to select view action----------------------"
			redirect(action: "selectView")
		} else if (role == 'APPLICANT' || currentUsrRole == 'APPLICANT') {
        redirect(action:'applicantDash', controller:'Applicant', params:[csrfPreventionSalt:csrfPreventionSalt])
		return
		}
		
	    	else if (role == 'SBB' || currentUsrRole == 'SBB') {
			redirect(action:'sbbDashboard', controller:'SBB',params:[csrfPreventionSalt:csrfPreventionSalt])
			return
			}
		
		else if (role == 'EC' || currentUsrRole == 'EC') {
			redirect(action:'expertDash', controller:'ExpertCommittee', params:[csrfPreventionSalt:csrfPreventionSalt])
			return
			}
		
		else if(role == 'ADMIN' || currentUsrRole == 'ADMIN'){
			adminUser = "under adminUser"
//			applications = ApplicationForm1.createCriteria().list(params) {
//				println "@@@@@@@@@@@@@@@@@@ in side admin data"
//				currentStatus {
//					eq('status', AppStatus.Status.SUBMITTED)
//				}
//			}
			
			
			
			String querySyntax = Constants.ADMIN_QUERY;
			
			Sql sql = new Sql(sessionFactory.currentSession.connection())
			applications = sql.rows(querySyntax)

			
		}else {
			
				println "inside different user block " + params
				redirect(controller:"dashboard",action:"dashboard", params:[csrfPreventionSalt:csrfPreventionSalt])
				return
			}

		 [applications : applications,adminUser:adminUser,csrfPreventionSalt:csrfPreventionSalt]
	}
	

	
	def decideForm(){}
	def knowYourFormPart1(){}
	def savePart1  = {
		println "PARAMS are == "+params
		def nationality = params.nationality
		def csrfPreventionSalt = params?.csrfPreventionSalt
		println "csrfPreventionSalt------------------------------"
		if(nationality != null && nationality == 'Indian'){
			redirect(action:"knowYourFormPart2",params:[nationality:nationality, csrfPreventionSalt: csrfPreventionSalt])
		}
		else if(nationality != null && nationality == 'Non-Indian'){
			redirect(action:"knowYourFormPart3",params:[nationality:nationality,csrfPreventionSalt: csrfPreventionSalt])
		}
		else if(nationality != null && nationality == 'NRI'){
			redirect(action:"knowYourFormPart3",params:[nationality:nationality,csrfPreventionSalt: csrfPreventionSalt])
		}
		else if(nationality != null && nationality == 'Body Corporate1'){
			redirect(action:"knowYourFormPart4",params:[nationality:nationality,csrfPreventionSalt: csrfPreventionSalt])
		}
		else if(nationality != null && nationality == 'Body Corporate2'){
			redirect(action:"knowYourFormPart3",params:[nationality:nationality,csrfPreventionSalt: csrfPreventionSalt])
		}
		else if(nationality != null && nationality == 'Body Corporate3'){
			redirect(action:"knowYourFormPart3",params:[nationality:nationality,csrfPreventionSalt: csrfPreventionSalt])
		}
		else if(nationality != null && nationality == 'Body Corporate4'){
			redirect(action:"knowYourFormPart6",params:[nationality:nationality,csrfPreventionSalt: csrfPreventionSalt])
		}
	}
	def knowYourFormPart2(){

		def csrfPreventionSalt = params.csrfPreventionSalt
		def nationality = params.nationality
		[nationality:nationality,csrfPreventionSalt:csrfPreventionSalt]
	}
	def knowYourFormPart3(){
		def csrfPreventionSalt = params.csrfPreventionSalt
		def nationality = params.nationality
		[nationality:nationality,csrfPreventionSalt:csrfPreventionSalt]
	}
	def knowYourFormPart4(){
		def nationality = params.nationality
		[nationality:nationality]
	}
	def knowYourFormPart6(){
		def nationality = params.nationality
		[nationality:nationality]
	}

	def savePart2 = {
		println "Inside savePart4 == "+params
		def formNumber,fee,formPart
		def csrfPreventionSalt = params?.csrfPreventionSalt
		formPart = params.formPart
		//7 conditions for Form2
		if(params.nationality == 'Indian' && params.category == 'category1'){
			formNumber = "form2"
			fee = "Rs 5,000/-"
		}
		else if(params.nationality == 'Non-Indian' && params.category == 'category5' ){
			formNumber = "form2"
			fee = "Rs 5,000/-"
		}
		else if(params.nationality == 'NRI' && params.category == 'category5'){
			formNumber = "form2"
			fee = "Rs 5,000/-"
		}
		else if(params.nationality == 'Body Corporate2' && params.category == 'category5' ){
			formNumber = "form2"
			fee = "Rs 5,000/-"
		}
		else if(params.nationality == 'Body Corporate3' && params.category == 'category5'){
			formNumber = "form2"
			fee = "Rs 5,000/-"
		}
		else if(params.nationality == 'Body Corporate1' && params.category == 'category8'){
			formNumber = "form2"
			fee = "Rs 5,000/-"
		}


		// 4 conditions for Form1
		else if(params.nationality == 'Non-Indian' && params.category == 'category4'){
			formNumber = "form1"
			fee = "Rs 10,000/-"
		}
		else if(params.nationality == 'NRI' && params.category == 'category4' ){
			formNumber = "form1"
			fee = "Rs 10,000/-"
		}
		else if(params.nationality == 'Body Corporate2' && params.category == 'category4'){
			formNumber = "form1"
			fee = "Rs 10,000/-"
		}
		else if(params.nationality == 'Body Corporate3' && params.category == 'category4' ){
			formNumber = "form1"
			fee = "Rs 10,000/-"
		}

		// 4 conditions for Form4
		else if(params.nationality == 'Non-Indian' && params.category == 'category7' ){
			formNumber = "form4"
			fee = "Rs 10,000/-"
		}
		else if(params.nationality == 'NRI' && params.category == 'category7'){
			formNumber = "form4"
			fee = "Rs 10,000/-"
		}
		else if(params.nationality == 'Body Corporate2' && params.category == 'category7'){
			formNumber = "form4"
			fee = "Rs 10,000/-"
		}
		else if(params.nationality == 'Body Corporate3' && params.category == 'category7' ){
			formNumber = "form4"
			fee = "Rs 10,000/-"
		}

		// 7 conditions for Form3
		if(params.nationality == 'Indian' && params.category == 'category2' ){
			formNumber = "form3"
			fee = "Rs 500/-"
		}
		else if(params.nationality == 'Non-Indian' && params.category == 'category6' ){
			formNumber = "form3"
			fee = "Rs 500/-"
		}
		else if(params.nationality == 'NRI' && params.category == 'category6' ){
			formNumber = "form3"
			fee = "Rs 500/-"
		}
		else if(params.nationality == 'Body Corporate2' && params.category == 'category6'){
			formNumber = "form3"
			fee = "Rs 500/-"
		}
		else if(params.nationality == 'Body Corporate3' && params.category == 'category6'){
			formNumber = "form3"
			fee = "Rs 500/-"
		}
		else if(params.nationality == 'Body Corporate1' && params.category == 'category9'){
			formNumber = "form3"
			fee = "Rs 500/-"
		}

		println "formNumber == "+formNumber
		println "fee == "+fee
		redirect(action:"knowYourFormPart5",params:[csrfPreventionSalt:csrfPreventionSalt,formNumber:formNumber,fee:fee,formPart:formPart])

	}
	def knowYourFormPart5(){
		println "Inside knowYourFormPart5 == "+params
		def formNumber = params.formNumber
		println "formNumber == "+formNumber
		def csrfPreventionSalt = params.csrfPreventionSalt

		def fee = params.fee
		println "fee == "+fee
		[formNumber:formNumber,fee:fee,csrfPreventionSalt:csrfPreventionSalt]
	}

	def notifications = {

		[listOfNotifications:MstrDocument.list(),
			notification5i:MstrDocument.findByDocName('Notification 5.(i)'),
			notification5ii:MstrDocument.findByDocName('Notification 5.(ii)'),
			notification5iii:MstrDocument.findByDocName('Notification 5.(iii)'),
			notificationBihar:MstrDocument.findByDocName('Notification 9.(a- Bihar)'),
			notificationGoa:MstrDocument.findByDocName('Notification 9.(b- Goa)'),
			notificationHimachal:MstrDocument.findByDocName('Notification 9.(c- Himachal Pradesh)'),
			notificationKarnataka:MstrDocument.findByDocName('Notification 9.(d- Karnataka)'),
			notificationKerala:MstrDocument.findByDocName('Notification 9.(e- Kerala)'),
			notificationMadhya:MstrDocument.findByDocName('Notification 9.(f- Madhya Pradesh)'),
			notificationManipur:MstrDocument.findByDocName('Notification 9.(g- Manipur)'),
			notificationMeghalaya:MstrDocument.findByDocName('Notification 9.(h- Meghalaya)'),
			notificationMizoram:MstrDocument.findByDocName('Notification 9.(i- Mizoram)'),
			notificationOrissa:MstrDocument.findByDocName('Notification 9.(j- Orissa)'),
			notificationPunjab:MstrDocument.findByDocName('Notification 9.(k- Punjab)'),
			notificationTamil:MstrDocument.findByDocName('Notification 9.(l- Tamil Nadu)'),
			notificationTripura:MstrDocument.findByDocName('Notification 9.(m- Tripura)'),
			notificationUttar:MstrDocument.findByDocName('Notification 9.(n- Uttar Pradesh)'),
			notificationUttarakhand:MstrDocument.findByDocName('Notification 9.(o- Uttarakhand)'),
			notificationWest:MstrDocument.findByDocName('Notification 9.(p- West Bengal)'),
		]
	}
	def helpDesk = {}

	def showDc(long id)
	{
		println" show doc`"+params?.id

		ByteArrayOutputStream ous = null;
		InputStream ios = null;
		def doc= MstrDocument.get(params?.id)
		def file= doc?.document
		def filename = doc?.docName
		println "FILE == "+doc
		byte[] DocContent = null;
		DocContent = file
		//		response.setHeader "Content-disposition", "inline; filename=filename"
		response.setHeader("Content-disposition", "attachment; filename=DclUndtk.pdf")
		response.contentType = 'application/pdf'
		response.outputStream << DocContent
		response.outputStream.flush()
	}
	

	
	
//	def getIrccData(){
//		
//	def getId = params.id
//	def getIrccData = ApplicationForm1.get(Long.parseLong(getId))	
//	def appNumber = getIrccData.appNumber
//	def result = [data:appNumber] 
//	render result as JSON
//	
//	}
	
       def tr5Issued(){
		def csrfPreventionSalt = params.csrfPreventionSalt
		
		def tr5ReceiptInstance = LetterCommunication.where {
		letterType.ltrType == LetterType.LtrType.TR5_LETTER
		}.list()
		
		
		[tr5ReceiptInstance:tr5ReceiptInstance,csrfPreventionSalt:csrfPreventionSalt]
	}
	   
	   
	   
	   
	   def tr5DateFilter(){
		   println"inside year search"+params
		   def pattern = "dd-MM-yyyy"
		   def startDate = Date.parse(pattern,params.fromFilter)
		   def endDate = Date.parse(pattern, params.toFilter)
		   println"Start"+startDate
		   println"End"+endDate
		   
		def result = LetterCommunication.createCriteria().list{
			between("dated", startDate,endDate)
			
		}
		render(view:'tr5Issued', model:[tr5ReceiptInstance:result])
		}
	
	   
	   def formType = ['Form 1', 'Form 2', 'Form 3', 'Form 4', 'Form B']
	   List typeOfSharing = ['(a) Upfront','(b) Benefit sharing','(c) Royalty','(d) others']
	   
	   
   def benefitFilter(){
	   println"inside year search"+params
	   def pattern = "dd-MM-yyyy"
	   def startDate = Date.parse(pattern,params.fromFilter)
	   def endDate = Date.parse(pattern, params.toFilter)
	   println"Start"+startDate
	   println"End"+endDate
	   
	def result = BenefitSharing.createCriteria().list{
		between("dateBenefit", startDate,endDate)
		
	}
	render(view:'benefitSharingReceived',formType:formType,typeOfSharing:typeOfSharing, model:[benefitSharingInstance:result])
	}	   
	   
	def benefitSeach(){
		
	    def result
	
		if ( params.fromT && params.typeBenefit)
		result = BenefitSharing.findAllByFormTypeAndTypeOfSharingIlike(wrapSearchParm(params.fromT), wrapSearchParm(params.typeBenefit))
			
		else if (params.fromT)
			result = BenefitSharing.findAllByFormTypeIlike(wrapSearchParm(params.fromT))
			
		else if (params.typeBenefit)
			result = BenefitSharing.findAllByTypeOfSharingIlike(wrapSearchParm(params.typeBenefit))
			
			render(view:'benefitSharingReceived',formType:formType,typeOfSharing:typeOfSharing, model:[benefitSharingInstance:result])
		}      
	   
	
	
	  def benefitSharingReceived(){
		  def csrfPreventionSalt = params.csrfPreventionSalt
//		  FormCategory.Category [] formType = FormCategory.Category.values()
		  
		
		  
		  [benefitSharingInstance:BenefitSharing.list(params), formType:formType,typeOfSharing:typeOfSharing,csrfPreventionSalt:csrfPreventionSalt] 
		   
   
	   }
	   
	  def String wrapSearchParm(value) {
		  '%'+value+'%'
	  }
	  
	  
	   
	def agendaReport(){
		def csrfPreventionSalt = params.csrfPreventionSalt
           println "In Agenda Report"
		def agendaInstance = Agenda.where {
			agendaLetterStatus.agdltrstatus == AgendaLetterStatus.AgendaLtrStatus.LETTER_SEND
		}.list()
		
		render view:'agendaReport', modal:[agendaInstance:agendaInstance,csrfPreventionSalt:csrfPreventionSalt]
	}
	
	//............................. Linking officer implementation......................Susheel Gupta   

	
  def linkOfficerList ={
		  return [linkOfficerInstance:LinkOfficer.list(),message:params.message]
		   }

	   
  def editLinkOfficer(){
	
	def linkId = params.editId
	def linkOfficerInstance = LinkOfficer.get(linkId as Long)
	render (view:'linkOfficer', model:[linkOfficerInstance:linkOfficerInstance])
	}
  
  
  def deleteOfficer(){
	  
	  def deleteId = params.deleteId
	  def delUser = LinkOfficer.get(deleteId as Long)
	  if(!delUser.delete(flush:true)){
		  
		  delUser.errors.allErrors.each{print it}
		  }
	  redirect(action:'linkOfficerList')
	  }
	   
	 
  
  
    def linkOfficer(){
		def message = params.message
		def linkOfficerIns = params.linkOfficerInstance
		
        def currentUser = NbaUser.findByUsername(springSecurityService.currentUser?.username)?.name 
	
		def linkOfficerInstance = LinkOfficer.get(linkOfficerIns as Long)

		def nbauser = NbaUser.createCriteria().list(){
			projections { property("name")}
			and{
				nbaRole{ 
					and {ne('authority','APPLICANT') 
					     ne('authority','SBB')
					}}
			}
		}
		[nbauser:nbauser,linkOfficerInstance:linkOfficerInstance,message:message,currentUser:currentUser]
	
	}
	
	def setLinkOfficer(){
		String message

		def officerInstance = params.updateInstance

		if(officerInstance == '' || null == officerInstance)
		{
			def roleFrom = NbaUser.findByName(params.userLinkByAdmin)
			def userFrom = LinkOfficer.findByNbaUserFrom(roleFrom)
			println"check user from"+roleFrom

			def roleTo = NbaUser.findByName(params.linkUser)

			def userTo = LinkOfficer.findByNbaUserTo(roleTo)
			println"check user to"+roleTo


			if(userFrom != null || userTo != null){
				message = params.userLinkByAdmin+' or '+params.linkUser+' already linked '
				redirect('action':'linkOfficer', params:[message:message])
				return;

			}else{
				def linkOfficerInstance = new LinkOfficer()
				linkOfficerInstance.fromDate =  params.fromDate
				linkOfficerInstance.toDate = params.toDate
				linkOfficerInstance.reason = params.reason
				linkOfficerInstance.userLink = params.userLink
				linkOfficerInstance.assignDate = new Date();

				linkOfficerInstance.nbaUserFrom = roleFrom
				linkOfficerInstance.nbaUserTo = roleTo

				if(params.status == 'yes'){
					linkOfficerInstance.status = true
					roleFrom.accountExpired = true
					roleFrom.answer = roleFrom?.username
					roleFrom.username = userManagementService.getDynamicString()
					roleFrom.save(flush:true)
				}	

				else if(params.status == 'no'){
					linkOfficerInstance.status = false
				}

				if(!linkOfficerInstance.save(flush:true)){
					linkOfficerInstance.errors.allErrors.each{print it}

				}

				message = 'Link officer created successfully'
				redirect('action':'linkOfficerList', params:[message:message])
			}
		}else if(officerInstance != null || '' != officerInstance){

			def linkOfficerInstance = LinkOfficer.get(officerInstance as Long)
			linkOfficerInstance.fromDate =  params.fromDate
			linkOfficerInstance.toDate = params.toDate
			linkOfficerInstance.reason = params.reason

			if(params.status == 'yes'){
				linkOfficerInstance.status = true
				linkOfficerInstance.nbaUserFrom.accountExpired = true
				linkOfficerInstance.nbaUserFrom.answer = linkOfficerInstance.nbaUserFrom.username
				linkOfficerInstance.nbaUserFrom.username = userManagementService.getDynamicString()
				linkOfficerInstance.nbaUserFrom.save(flush:true)
			}
			else if(params.status == 'no'){
				linkOfficerInstance.status = false
				linkOfficerInstance.nbaUserFrom.accountExpired = false
				linkOfficerInstance.nbaUserFrom.username = linkOfficerInstance.nbaUserFrom.answer
				linkOfficerInstance.nbaUserFrom.answer = ""
				linkOfficerInstance.nbaUserFrom.save(flush:true)
			}

			if(!linkOfficerInstance.save(flush:true)){
				linkOfficerInstance.errors.allErrors.each{print it}

			}

			message = 'Link officer updated successfully'
			redirect('action':'linkOfficerList', params:[message:message])
		}
	}
	
	
	  def recordRoomList(){
		
		  def recordRoomApplication = ApplicationForm1.createCriteria().list() {
			  
						  currentStatus {
							  eq('forwardedUser' , 'virtual' )
			  
						  }
		  }	
		  
		  [recordRoomApplication:recordRoomApplication]
	}
	  
	  

	   def auditLog(){
	 
	 [userLogs:UserLog.list()]
	 }

}

