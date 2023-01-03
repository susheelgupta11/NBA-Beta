package org.nba.review

import grails.converters.JSON
import groovy.json.JsonOutput
import grails.plugins.rest.client.RestBuilder
import grails.transaction.Transactional
import groovy.sql.Sql
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.security.cert.X509Certificate
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSession
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import javax.net.ssl.HttpsURLConnection

import org.codehaus.groovy.grails.web.json.JSONObject
import org.hibernate.SessionFactory
import org.nba.application.AppStatus
import org.nba.application.ApplicationForm1
import org.nba.application.FormCategory
import org.nba.application.AppStatus.Status
import org.nba.application.FormCategory.Category
import org.nba.communication.PdfFileAttachment
import org.nba.master.SetMstrData
import org.nba.user.LinkOfficer
import org.nba.user.NbaUser
import org.springframework.context.ApplicationContext
import org.springframework.security.access.annotation.Secured

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.nba.constant.Constants
@Transactional
@Secured('permitAll')
class DashboardController {

	def springSecurityService
	def applicationNotingService
	def apiForCDACITMSToolsService
	def userManagementService
     ApplicationContext applicationContent
	
	SessionFactory sessionFactory;

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index(){
		redirect(action:'dashboard')
	}

	def dashboard(){

		def csrfPreventionSalt = request.getAttribute("csrfPreventionSalt")
		def applicationDetails,inProcessApplications, fullApplicationDetails,commApplication
		

//		params.max = params.max ?: 30
//	    params.offset = params.offset ?: 0

		def message = params.message
		def currentUsrRole = springSecurityService.getPrincipal().getAuthorities()
		def role = currentUsrRole.toString().substring(1, currentUsrRole.toString().length() - 1)
		println "current Role==========" + role

		def currentUser = springSecurityService.getCurrentUser().username
		NbaUser userDetails = NbaUser.findByUsername(currentUser)
		def currentNbaRole = userDetails?.nbaRole?.authority
		println "current Role in NBA User "+currentNbaRole
		
		
		def linkOfficer = LinkOfficer.findByNbaUserTo(userDetails)
		println"checkTime and status for link officer"+linkOfficer?.status+" and time "+linkOfficer?.toDate


		//		List<ApplicationForm1> evenForm = new ArrayList<ApplicationForm1>()
		//		List<ApplicationForm1> oddForm = new ArrayList<ApplicationForm1>()
		//
		//	def applications = ApplicationForm1.createCriteria().list(){
		//			currentStatus {
		//				eq('status', AppStatus.Status.SUBMITTED)
		//			}
		//		}
		//	def formSize = applications.size()
		//
		//
		//		if(formSize<2){
		//			oddForm.add(applications)
		//		}else if(formSize == 2){
		//			oddForm.add(applications.get(0))
		//			evenForm.add(applications.get(1))
		//		}else if(formSize>2){
		//
		//				for(int i=0; i<formSize;i++){
		//				if(formSize % 2 == 0){
		//					evenForm.add(applications.get(i))
		//					formSize--;
		//				}else if(formSize % 2 == 1){
		//					oddForm.add(applications.get(i))
		//					formSize--;
		//				}
		//			}
		//		}
		//		Iterator iit = oddForm.iterator();
		//
		//				while (iit.hasNext()) {
		//					ApplicationForm1 obj = (ApplicationForm1) iit.next();
		//					println "odd number forms"+(obj);
		//				}
		//
		//				Iterator its = evenForm.iterator();
		//
		//						while (its.hasNext()) {
		//							ApplicationForm1 obj = (ApplicationForm1) iit.next();
		//							println "even numbers form"+(obj);
		//						}

		
     
		Sql sql = new Sql(sessionFactory.currentSession.connection())
		
		String commQuery;
		
		if( role =="REVIEW_MEMBER" || currentNbaRole == "REVIEW_MEMBER" ){
			
	      

			String sqlFilePath = grailsAttributes.getApplicationContext().getResource("query/reqApplicationDetails.sql").getFile()

			println "path"+sqlFilePath
			String sqlString = new File(sqlFilePath).text
		
		    applicationDetails = sql.rows(sqlString)
		 
		    commQuery = Constants.COMM_QUERY_REVIEW
		    commApplication = sql.rows(commQuery)
		 
		 println "123"+commApplication

		}else{
		
		String querySyntax = Constants.NBA_QUERY	
		
		applicationDetails = sql.rows(querySyntax).findAll{it.forwarded_user == currentUser};
		
		commQuery = Constants.COMM_QUERY_NBA
		commApplication = sql.rows(commQuery).findAll{it.forwarded_user == currentUser};
		}
		println"LLLL"+applicationDetails
		
		println "123"+commApplication
		
		
		inProcessApplications = ApplicationForm1.createCriteria().list(){

			or{
				currentStatus {
					eq('status', AppStatus.Status.NBA_PENDING)
				}
				currentStatus {
					eq('status', AppStatus.Status.IN_PROCESS)

				}
			}and{
				currentStatus {
					eq('forwardedUser', springSecurityService?.getCurrentUser()?.username)
				}
				currentStatus {
					eq('userCounter', false)
				}
			}
			
		}
		



		def virtualApplications = ApplicationForm1.createCriteria().list(){
			currentStatus {
				eq('status', AppStatus.Status.RECORD_ROOM)
				and{
					eq('changedBy',springSecurityService?.getCurrentUser())
				}
			}

		}

		def recordRoomApplication = ApplicationForm1.createCriteria().list() {

			currentStatus {
				eq('forwardedUser' , 'virtual' )

			}

		}
		def approvedApplications = ApplicationForm1.createCriteria().list(){
			currentStatus {
				eq('status', AppStatus.Status.APPROVED)
			}
		}

		def rejectedApplications = ApplicationForm1.createCriteria().list(){
			currentStatus {
				eq('status', AppStatus.Status.REJECTED)
			}
		}

		println "-------------susheel------inside dashboard controller---"+new Date()


		render(view: "dashboard", model: [applicationDetails:applicationDetails, inProcessApplications:inProcessApplications,commApplication:commApplication,
			currentUser:currentUser,csrfPreventionSalt:csrfPreventionSalt,message:message, virtualApplications:virtualApplications,
			recordRoomApplication:recordRoomApplication,approvedApplications:approvedApplications,rejectedApplications:rejectedApplications])

	}
	def noting(){

		def csrfPreventionSalt = params.csrfPreventionSalt
		def message = params.message

//		params.max = Math.min(params.max ? params.int('max') : 10, 100)

		if(params.instance == "" || params.instance == null){

			flash.message = "Please select an application"
			redirect(action:'dashboard', params:[csrfPreventionSalt:csrfPreventionSalt])
			return;
		}

		ApplicationForm1 formDetails = ApplicationForm1.get(Long.parseLong(params.instance))

		def applicationNum = formDetails?.appNumber
		def submittedDate  = formDetails?.submittedOn

		println "formDetails"+formDetails.getClass()

		println "applicationNum"+applicationNum

		//		def viewNoteDetails = AddNote.findAllByFormNumber(applicationNum)

		def query = AddNote.where { formNumber == applicationNum }
		def commentCount = query.list().size()
		def viewNoteDetails = query.list().sort{it.noteDate}.reverse()

		//		String currentLoginUser = springSecurityService?.getCurrentUser()?.username

		// if we want to show all the comment other than the current  user
		/*	def c = AddNote.createCriteria()
		 viewNoteDetails = c.list {
		 ne("notedUser", currentLoginUser)
		 }*/
		def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()
		def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)

		[allDataforMatching:allDataforMatching,dropDnValues:dropDnValues,viewNoteDetails:viewNoteDetails,formDetails:formDetails, commentCount :commentCount,
			applicationNum:applicationNum,submittedDate:submittedDate,csrfPreventionSalt:csrfPreventionSalt,params:params,messageNote:message]
	}


	def addNote(){

		def csrfPreventionSalt = params.csrfPreventionSalt
		def formId = params.instance
		def message = params.message
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
		formDetails:formDetails,allDataforMatching:allDataforMatching,message:message,linkOfficer:params.linkOfficer,csrfPreventionSalt:csrfPreventionSalt]
	}

	def filter(){

		def filter = {
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
			def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin(params)
			render(template: '/dashboard/commentBox', model: [dropDnValues: dropDnValues])
		}
	}

	def saveNote(){

		def csrfPreventionSalt = params.csrfPreventionSalt
		def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()

		if(params.applicationInstance == "" || params.applicationInstance == null){

			flash.message = "Application Form Number is Missing"
			render( view: "addNote",  model: [dropDnValues:dropDnValues])
			return
		}

		def getAllpdfFile =  request.getFiles('files[]')
		println "received files are here--------"+getAllpdfFile

		ApplicationForm1 appInstance = ApplicationForm1.get(Long.parseLong(params.applicationInstance))
		def applicationNumber = appInstance?.appNumber
		String msg = "File forward successfully";

		if(getAllpdfFile.size() > 0){

			def checkFile = applicationNotingService.checkFileValidation(getAllpdfFile)
			if(checkFile == "Validate Successfully"){
				def instance = applicationNotingService.addNoteForApplication(params)
				if(instance instanceof org.nba.review.AddNote){
					def uploadFile = applicationNotingService.transferFile(getAllpdfFile,applicationNumber,instance)

					if(uploadFile == true){
						redirect(action:'noting', params:[message:msg,instance:params.applicationInstance,csrfPreventionSalt:csrfPreventionSalt])
						return;
					}
				}
			}else{
				redirect(action:'addNote', params:[message:checkFile, instance:params.applicationInstance,csrfPreventionSalt:csrfPreventionSalt])
				return;
			}
		}else{
			def instance = applicationNotingService.addNoteForApplication(params)

			if(instance instanceof org.nba.review.AddNote){
				redirect(action:'noting', params:[message:msg,instance:params.applicationInstance,csrfPreventionSalt:csrfPreventionSalt])
				return;
			}
		}
	}




	def notingFileShow(){
		def csrfPreventionSalt = params.csrfPreventionSalt
		def detailsForFile = PdfFileUpload.get(params?.showId)
		def file = new File(detailsForFile?.pathForFile)
		String fileName = file.getName().toString()
		def fileExt =  fileName.substring(fileName.lastIndexOf("."));
		println "file url is" +file

		if(fileExt == '.pdf'){


			response.setContentType("application/pdf")
			response.setHeader("Content-disposition","filename=${file.getName()}")
			response.outputStream << file.newInputStream()

		}else{
			response.setContentType("APPLICATION/OCTET-STREAM")
			response.setHeader("Content-Disposition", "Attachment;Filename=\"${fileName}\"")
			def fileInputStream = new FileInputStream(file)
			def outputStream = response.getOutputStream()
			byte[] buffer = new byte[4096];
			int len;
			while ((len = fileInputStream.read(buffer)) > 0) {
				outputStream.write(buffer, 0, len);
			}
			response.outputStream << file.newInputStream()
			//   outputStream.flush()
			outputStream.close()
			fileInputStream.close()

		}
	}

	def showPdf(){
		def csrfPreventionSalt = params.csrfPreventionSalt

		def detailsForFile = PdfFileUpload.get(params?.showId)
		def file = new File(detailsForFile?.pathForFile)
		response.setContentType("application/pdf")
		response.setHeader("Content-disposition","filename=${file.getName()}")
		response.outputStream << file.newInputStream()

	}

	def downloadFile(){
		def csrfPreventionSalt = params.csrfPreventionSalt

		def detailsForFile = PdfFileUpload.get(params?.downloadId)
		def file = new File(detailsForFile?.pathForFile)
		response.setContentType("application/octet-stream")
		response.setHeader("Content-disposition", "filename=${file.getName()}")
		response.outputStream << file.newInputStream()
		response.outputStream.flush()


	}

	def communicationShowPdf(){
		def csrfPreventionSalt = params.csrfPreventionSalt
		def detailsForFile = PdfFileAttachment.get(params?.showId)
		def file = new File(detailsForFile?.attachedUrl)
		response.setContentType("application/pdf")
		response.setHeader("Content-disposition","filename=${file.getName()}")
		response.outputStream << file.newInputStream()
	}

	def communicaionDownloadFile(){
		def csrfPreventionSalt = params.csrfPreventionSalt

		def detailsForFile = PdfFileAttachment.get(params?.downloadId)
		def file = new File(detailsForFile?.attachedUrl)
		response.setContentType("application/octet-stream")
		response.setHeader("Content-disposition", "filename=${file.getName()}")
		response.outputStream << file.newInputStream()
		response.outputStream.flush()

	}




	def cdacApi(){

		def formDetails,resp
		def  getInstance = params.instance
		ApplicationForm1 application = ApplicationForm1.get(Long.parseLong(getInstance))

		println"application+++"+application

		RestBuilder rest = new RestBuilder()
		String CDAC_REST_URL = "http://164.100.163.19/NIC/cdac/process"
		"http://localhost:80/NIC/cdac/process"
//		"http://164.100.163.19/NIC/cdac/process"
//	    https://absms.cdacchn.in:3104/apis/f1
//		disableSslVerification()
		if(application?.category?.category == FormCategory?.Category?.Form_1){

			formDetails  = apiForCDACITMSToolsService.restPushDataToCDACITMSToolsForm1(application);
			
//			Gson gson = new Gson();
//			String data = gson.toJson(formDetails);
//			JSONObject json = new JSONObject(data);
			
			      GsonBuilder gsonMapBuilder = new GsonBuilder();
				   Gson gsonObject = gsonMapBuilder.create();
				   String JSONObject = gsonObject.toJson(formDetails);
			
			println "json object"+JSONObject

			

			resp =  rest.post(CDAC_REST_URL) {
				accept "application/json"
//				header 'authorization', "Bearer "+'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoiaXRtc3VzZXIiLCJpYXQiOjE1OTI1NzQ1MDB9.QhFtgvgDtbjet2fEbiWqtZ_nw37nrkyoysVbrkraZjs'
				json JSONObject

			}
			
			println"return parameter"+ resp.status
			
		}

		if(application?.category?.category == FormCategory?.Category?.Form_2){

			formDetails  = apiForCDACITMSToolsService.restPushDataToCDACITMSToolsForm234(application);

			resp =  rest.post(CDAC_REST_URL) {
				accept "application/json"
//				header 'authorization', "Bearer "+'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoiaXRtc3VzZXIiLCJpYXQiOjE1OTI1NzQ1MDB9.QhFtgvgDtbjet2fEbiWqtZ_nw37nrkyoysVbrkraZjs'
				json formDetails

			}
			println"return parameter"+ resp.status
		}

		if(application?.category?.category == FormCategory?.Category?.Form_3){

			formDetails  = apiForCDACITMSToolsService.restPushDataToCDACITMSToolsForm234(application);

			resp =  rest.post(CDAC_REST_URL) {
				accept "application/json"
//				header 'authorization', "Bearer "+'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoiaXRtc3VzZXIiLCJpYXQiOjE1OTI1NzQ1MDB9.QhFtgvgDtbjet2fEbiWqtZ_nw37nrkyoysVbrkraZjs'
				json formDetails

			}
			println"return parameter"+ resp.status
		}

		if(application?.category?.category == FormCategory?.Category?.Form_4){

			formDetails  = apiForCDACITMSToolsService.restPushDataToCDACITMSToolsForm234(application);

			resp =  rest.post(CDAC_REST_URL) {
				accept "application/json"
//				header 'authorization', "Bearer "+'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoiaXRtc3VzZXIiLCJpYXQiOjE1OTI1NzQ1MDB9.QhFtgvgDtbjet2fEbiWqtZ_nw37nrkyoysVbrkraZjs'
				json formDetails
			}
			println"return parameter"+ resp.status
		}
		if(application?.category?.category == FormCategory?.Category?.Form_B){

			formDetails  = apiForCDACITMSToolsService.restPushDataToCDACITMSToolsFormB(application);

			resp =  rest.post(CDAC_REST_URL) {
				accept "application/json"
//				header 'authorization', "Bearer "+'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoiaXRtc3VzZXIiLCJpYXQiOjE1OTI1NzQ1MDB9.QhFtgvgDtbjet2fEbiWqtZ_nw37nrkyoysVbrkraZjs'
				json formDetails

			}
			println"return parameter"+ resp.status

		}
		if(application?.category?.category == FormCategory?.Category?.Form_C){

			formDetails  = apiForCDACITMSToolsService.restPushDataToCDACITMSToolsFormC(application);

			resp =  rest.post(CDAC_REST_URL) {
				accept "application/json"
//				header 'authorization', "Bearer "+'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoiaXRtc3VzZXIiLCJpYXQiOjE1OTI1NzQ1MDB9.QhFtgvgDtbjet2fEbiWqtZ_nw37nrkyoysVbrkraZjs'
				json formDetails
			}
			println"return parameter"+ resp.status

		}

		def result = [formDetails:resp.status]
		println "string Json"+result
		render result as JSON
	}
	
	

	def moveToRecordRoom(){
	
		def formId = params.instance
		def csrfPreventionSalt = params.csrfPreventionSalt
		def firstInstance = SetMstrData.list()
		def actionList = firstInstance[0]?.actions
	
		def formDetails = ApplicationForm1.get(formId as Long)
	
		render template:'/dashboard/recordRoomPopup',model:[formDetails:formDetails,actionList:actionList,linkOfficer:params.linkOfficer]
		}
	
	
//	def saveRecordRoom(){
//		
//    def setRecordRoom = applicationNotingService.recordRoomTransfer(params)
//	if(setRecordRoom == Constants.Record_Room){
//		render template:'/dashboard/recordRoomResponse', model:[message:setRecordRoom]
//		}else{
//		
//		render template:'/dashboard/recordRoomResponse', model:[message:"There are some technical issue"]
//		}
//	} 
	
	def saveRecordRoom(){
		
	def setRecordRoom = applicationNotingService.recordRoomTransfer(params)
	if(setRecordRoom == Constants.Record_Room){
		println"inside successful record room"
		redirect( action:'dashboard', params:[message:setRecordRoom])
		}else{
		println"insude failure record room"
		redirect( action:'dashboard', params:[message:"There are some technical issue"])
		}
	}
	


	def movetoInbox(){
		def formInstance = params.instance
		def formDetails = ApplicationForm1.get(formInstance as Long)
		def revertApp = userManagementService.selectDashboardForRecordRoom(formDetails)
		redirect(action:'dashboard', params:[message:revertApp])
	}





	def setLinkOfficerStatus(){

		String condition = params.condition

		def currentUser = springSecurityService.currentUser.username
		def result = ''
		println "current user"+currentUser
		def getDetails = NbaUser.findByUsername(currentUser)
		def linkedUser = LinkOfficer.findByNbaUserTo(getDetails)

		def linkOfficerDetails = linkedUser?.nbaUserFrom?.username
		println "rrrrrrrrr"+linkOfficerDetails

		if(condition == 'enable'){
			linkedUser.status = true
			linkedUser.nbaUserFrom.accountExpired = true
			linkedUser.nbaUserFrom.answer = linkedUser.nbaUserFrom.username
			linkedUser.nbaUserFrom.username = userManagementService.getDynamicString()
			linkedUser.nbaUserFrom.save(flush:true)
		}else{
			linkedUser.status = false
			linkedUser.nbaUserFrom.accountExpired = false
			linkedUser.nbaUserFrom.username = linkedUser.nbaUserFrom.answer
			linkedUser.nbaUserFrom.answer = ""
			linkedUser.nbaUserFrom.save(flush:true)
		}	
		if(!linkedUser.save(flush:true)){
			linkedUser.errors.allErrors.each{print it}
		}
		result = [status:"Linked officer"+" " +condition+" " + "successfully"]

		println "check result"+result
		render result as JSON
	}


	def linkOfficerDashboard(){

		def applicationDetails

		params.max = Math.min(params.max ? params.int('max') : 10, 100)

		def currentUser = springSecurityService.currentUser.username

		println "current user"+currentUser
		def getDetails = NbaUser.findByUsername(currentUser)
		def linkedUser = LinkOfficer.findByNbaUserTo(getDetails)

		def linkOfficerDetails = linkedUser?.nbaUserFrom
		println "linked user"+linkOfficerDetails


		Sql sql = new Sql(sessionFactory.currentSession.connection())
			String querySyntax = Constants.NBA_QUERY
			
			applicationDetails = sql.rows(querySyntax).findAll{it.forwarded_user == linkOfficerDetails?.answer};
			
			println"LLLL"+applicationDetails
			
		def	inProcessApplications = ApplicationForm1.createCriteria().list(){
	
				or{
					currentStatus {
						eq('status', AppStatus.Status.NBA_PENDING)
					}
					currentStatus {
						eq('status', AppStatus.Status.IN_PROCESS)
	
					}
				}and{
					currentStatus {
						eq('forwardedUser', linkOfficerDetails?.answer)
					}
					currentStatus {
						eq('userCounter', false)
					}
				}
				
			}

		def virtualApplications = ApplicationForm1.createCriteria().list(params){
			currentStatus {
				eq('status', AppStatus.Status.RECORD_ROOM)
				and{ eq('changedBy',linkOfficerDetails) }
			}

		}

		println "-------------susheel------inside link officer dashboard ---"
		render(view: "dashboard", model: [applicationDetails:applicationDetails,inProcessApplications:inProcessApplications,virtualApplications:virtualApplications,linkOfficer:params.linkOfficer])




	}


	def fileStatus(){
		
				def formDetails = ApplicationForm1.findByAppNumber(params.value)
				
				def listInstance = AddNote.findAllByApplicationForm1(formDetails,[sort: "noteDate", order: "desc"])
				println "list ---- "+listInstance
				render  template:'/dashboard/filestatus',model:[applicationList:listInstance,formDetails:formDetails]
				
			}
	
	
	void disableSslVerification() throws NoSuchAlgorithmException, KeyManagementException{
		// Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = [
			new X509TrustManager(){
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null
				}
				public void checkClientTrusted(X509Certificate[] certs, String authType) {

				}
				public void checkServerTrusted(X509Certificate[] certs, String authType) {

				}
			}
		]

		// Install the all-trusting trust manager
		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		// Create all-trusting host name verifier
		HostnameVerifier allHostsValid = new HostnameVerifier() {
					public boolean verify(String hostname, SSLSession sslSession) {
						return true;
					}
				};
		// Install the all-trusting host verifier
		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	}
	
	}







