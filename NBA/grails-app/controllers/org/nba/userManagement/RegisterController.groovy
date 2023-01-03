package org.nba.userManagement

import grails.converters.JSON
import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.authentication.dao.NullSaltSource
import grails.plugin.springsecurity.ui.*;

import java.text.SimpleDateFormat
import java.util.Date;

import org.apache.ivy.core.settings.Validatable;
import org.nba.master.ManageLoginContent
import org.nba.master.MstrDocument
import org.nba.user.NbaRole
import org.nba.user.NbaUser
import org.nba.user.NbaUserNbaRole
import org.nba.user.RoleEnum
import org.springframework.security.access.annotation.Secured

@Secured(['permitAll'])
class RegisterController extends grails.plugin.springsecurity.ui.RegisterController {

	def saltSource
	def springSecurityUiService
	def springSecurityService
	def simpleCaptchaService
	def csrfPreventionSalt
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		println "inside indexxxxxxxxxx"
		
//		String text = "";
//		String possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//  
//		for (int i = 0; i < 5; i++)
//		  text += possible.charAt((Math.floor(Math.random() * possible.length())).intValue());
//		  
//		  println "text is = "+text
//		
//		session.setAttribute("secret", text);
//		
//		def sec = session.getAttribute("secret");
		
		
		String text = "", text2="", text3="";
		String possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
  
		for (int i = 0; i < 5; i++)
		  text += possible.charAt((Math.floor(Math.random() * possible.length())).intValue());
		  
		  for (int i = 0; i < 4; i++)
		  text2 += possible.charAt((Math.floor(Math.random() * possible.length())).intValue());
		  
		  for (int i = 0; i < 6; i++)
		  text3 += possible.charAt((Math.floor(Math.random() * possible.length())).intValue());
		  
		  println "text above is = "+text
		  //14-19
		  text = text2+text3+text2+text.reverse()+text2+text3
		  println "text below is = "+text
		session.setAttribute("secret", text);
		def sec = session.getAttribute("secret");
		
		[command: new RegisterCommand(),secc:sec]
	}

	def newLoginpage(){
	}

	/*def register(RegisterCommand command) {
		println "PARAMS ARE "+command
		println "PARAMS ARE with params"+params



		//1. error checks
		if (command.hasErrors()) {
			println "print command == "+command.password
			command.errors.each{ println it }
			render view: 'index', model: [command: command]
			return
		}

		//		if(simpleCaptchaService.validateCaptcha(params.captcha)==false)
		//		{
		//			println "****************captcha false********************** == "+command
		//			render view: 'index', model: [command: command]
		//			return
		//		}

		def dob
		if(params.dateOfBirth != null && params.dateOfBirth != ''){
			SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy")
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy")
			def dob11 = parser.parse(params.dateOfBirth)
			def dob1 = formatter.format(dob11)
			dob = dob11
		}else{
			dob=params.dateOfBirth
		}

		println"date of birth"+dob
		println"date of birth 2"+params.dateOfBirth

		def location

		//2. Saving User

		String salt = saltSource instanceof NullSaltSource ? null : command.username
		def user = lookupUserClass().newInstance(email: command.email, username: command.username,
		accountLocked: true, enabled: true,password:command.password,
		dateOfBirth:dob ,phone:command.phone, mobile:command.mobile,name:command.name)

		//3.
		if(!user.save(flush:true)){
			user.errors.each{ println "USER NOT SAVED" +it }
		}

		//4.
		def role = NbaRole.findByAuthority(RoleEnum.Role.APPLICANT)
		println "role == "+role

		//5.
		NbaUserNbaRole.create(user,role)
		println "entry created in user_role table "+NbaUserNbaRole.findByNbaUser(user)

		//RegistrationCode registrationCode = springSecurityUiService.register(user, command.password, salt)
		def registrationCode = new RegistrationCode(username: command.username).save()
		println "registrationCode == "+registrationCode
		println "USER OBJECT IS == "+user
		if (registrationCode == null || registrationCode.hasErrors()) {
			// null means problem creating the user
			flash.error = message(code: 'spring.security.ui.register.miscError')
			flash.chainedParams = params
			redirect action: 'index'
			return
		}

		//5. Verfify link for the email
		String url = generateLink('verifyRegistration', [t: registrationCode.token])

		//6. Sending email
		def conf = SpringSecurityUtils.securityConfig
		def body = conf.ui.register.emailBody
		if (body.contains('$')) {
			body = evaluate(body, [user: user, url: url])
		}
		try{
			mailService.sendMail {
				to command.email
				from conf.ui.register.emailFrom
				subject conf.ui.register.emailSubject
				html body.toString()
			}
		}
		catch(Exception e){
			println "Exception in sending email is:"+e
		}

		println "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~all done sucessful~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
		//6.
		render view: 'index', model: [emailSent: true, user:user]
	}*/
	
	
	def register(RegisterCommand command) {
	
	println "PARAMS ARE "+command
	println "PARAMS ARE with params"+params

	//1. error checks
	if (command.hasErrors()) {
		println "print command == "+command.password
		command.errors.each{ println it }
		String text = "", text2="", text3="";
		String possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
  
		for (int i = 0; i < 5; i++)
		  text += possible.charAt((Math.floor(Math.random() * possible.length())).intValue());
		  
		  for (int i = 0; i < 4; i++)
		  text2 += possible.charAt((Math.floor(Math.random() * possible.length())).intValue());
		  
		  for (int i = 0; i < 6; i++)
		  text3 += possible.charAt((Math.floor(Math.random() * possible.length())).intValue());
		  
		  println "text above is = "+text
		  //14-19
		  text = text2+text3+text2+text.reverse()+text2+text3
		  println "text below is = "+text
		session.setAttribute("secret", text);
		def sec = session.getAttribute("secret");
		render view: 'index', model: [command: command,secc:sec]
		return
	}

	//		if(simpleCaptchaService.validateCaptcha(params.captcha)==false)
	//		{
	//			println "****************captcha false********************** == "+command
	//			render view: 'index', model: [command: command]
	//			return
	//		}

	def dob
	if(params.dateOfBirth != null && params.dateOfBirth != ''){
		SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy")
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy")
		def dob11 = parser.parse(params.dateOfBirth)
		def dob1 = formatter.format(dob11)
		dob = dob11
	}else{
		dob=params.dateOfBirth
	}

	println"date of birth"+dob
	println"date of birth 2"+params.dateOfBirth

	def location

	//2. Saving User

	String salt = saltSource instanceof NullSaltSource ? null : command.username
	def user = lookupUserClass().newInstance(email: command.email, username: command.username,
	accountLocked: false, enabled: true,password:command.password,
	dateOfBirth:dob ,phone:command.phone, mobile:command.mobile,name:command.name)

	//3.
	if(!user.save(flush:true)){
		user.errors.each{ println "USER NOT SAVED" +it }
	}

	//4.
	def role = NbaRole.findByAuthority(RoleEnum.Role.APPLICANT)
	println "role == "+role

	//5.
	NbaUserNbaRole.create(user,role)
	println "entry created in user_role table "+NbaUserNbaRole.findByNbaUser(user)

	//RegistrationCode registrationCode = springSecurityUiService.register(user, command.password, salt)
	def registrationCode = new RegistrationCode(username: command.username).save()
	println "registrationCode == "+registrationCode
	println "USER OBJECT IS == "+user
	if (registrationCode == null || registrationCode.hasErrors()) {
		// null means problem creating the user
		flash.error = message(code: 'spring.security.ui.register.miscError')
		flash.chainedParams = params
		redirect action: 'index'
		return
	}

	//5. Verfify link for the email
	String url = generateLink('verifyRegistration', [t: registrationCode.token])

	//6. Sending email
	def conf = SpringSecurityUtils.securityConfig
	def body = conf.ui.register.emailBody
	if (body.contains('$')) {
		body = evaluate(body, [user: user, url: url])
	}
	try{
		mailService.sendMail {
			to command.email
			from conf.ui.register.emailFrom
			subject conf.ui.register.emailSubject
			html body.toString()
		}
	}
	catch(Exception e){
		println "Exception in sending email is:"+e
	}

	println "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~all done sucessful~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
	//6.
	render view: 'index', model: [emailSent: true, user:user]


	}
	


	def verifyRegistration() {

		def conf = SpringSecurityUtils.securityConfig
		String defaultTargetUrl = conf.successHandler.defaultTargetUrl

		String token = params.t

		def registrationCode = token ? RegistrationCode.findByToken(token) : null
		if (!registrationCode) {
			flash.error = message(code: 'spring.security.ui.register.badCode')
			redirect uri: defaultTargetUrl
			return
		}

		def user
		// TODO - to ui service
		RegistrationCode.withTransaction { status ->
			String usernameFieldName = SpringSecurityUtils.securityConfig.userLookup.usernamePropertyName
			user = lookupUserClass().findWhere((usernameFieldName): registrationCode.username)
			if (!user) {
				return
			}
			user.accountLocked = false
			user.save(flush:true)
			def UserRole = lookupUserRoleClass()
			def Role = lookupRoleClass()
			for (roleName in conf.ui.register.defaultRoleNames) {
				UserRole.create user, Role.findByAuthority(roleName)
			}
			registrationCode.delete()
		}

		if (!user) {
			flash.error = message(code: 'spring.security.ui.register.badCode')
			redirect uri: defaultTargetUrl
			return
		}
       println "HIIIIIIII "
//		springSecurityService.reauthenticate user.username
         
		flash.message = message(code: 'spring.security.ui.register.complete')
		println "VERIFYING REGISTRATION"
//		redirect uri: conf.ui.register.postRegisterUrl 
		redirect(controller:"login",action:"auth")
	}

	def checkUserNameAvailability(){

		println "params == " + params.userNameAvailability
		if(params.userNameAvailability){
			def user = NbaUser.findByUsername(params.userNameAvailability)
			println "user == "+user
			def message
			if(user != null){
				message=[msg:"This username already exists. Please choose a different usename"]
			}
			else{
				message=[msg:"This username is valid"]
			}
			render message as JSON
		}
	}

	def userAvailability(){
		println "PRINT PARAMS == "+params
		println "params == " + params.email
		if(params.email && params.mobile){
			def user = MoesUser.findByEmailAndMobileNumber(params.email,params.mobile)
			println "user == "+user
			def data

			if(user != null){
				data = [flag:true]
				data = [user:user]
			}
			else{
				data = [flag:false]
			}
			render data as JSON
		}
	}


	def userDetail(){
		
		println "inside userdetails"
		
		
		
		if(params?.csrfPreventionSalt)
		def	csrfSalt = params?.csrfPreventionSalt
		else
			csrfPreventionSalt = session["csrfPreventionSalt"]
		
		def currentUser = springSecurityService.getCurrentUser()
		
		[currentUser:currentUser,csrfPreventionSalt:csrfPreventionSalt]
	}


	def saveuserDetails(){
		Date dob
		println "in saveuserDetails action--"+params
		println "in saveuserDetails action--"+params?.dateOfBirth
		def csrfSalt = params.csrfPreventionSalt
		
		if(csrfSalt != csrfPreventionSalt){
			flash.message = "Token not matched"
		    redirect (action:'userDetail')
			return;
		}
		
		if(params?.userId !=''){
			
				def user= NbaUser.get(params.userId)
				println "user == "+user
				try{
				if(params.dateOfBirth != ''){
				SimpleDateFormat format = new SimpleDateFormat('dd/MM/yyyy')
				dob = format.parse(params?.dateOfBirth)
				user.dateOfBirth = dob
				}
				}catch(Exception e){e.printStackTrace()}
				
				//user.username = params?.username
				user.name = params?.name
				user.email = params?.email
				user.mobile = params?.mobile
				user.phone = params?.phone

				if(!user?.save(flush:true)){
					user.errors.each{ println it }
				}
				flash.message = "Info. Updated!"

			

			redirect (action: "userDetail", params:[] )
		}

	}

	def forgotPassword() {

		if (!request.post) {
			// show the form
			return
		}

		String username = params.username
		if (!username) {
			flash.error = message(code: 'spring.security.ui.forgotPassword.username.missing')
			redirect (controller: 'login', action: 'auth')
			return
		}

		String usernameFieldName = SpringSecurityUtils.securityConfig.userLookup.usernamePropertyName
		def user = lookupUserClass().findWhere((usernameFieldName): username)
		if (!user) {
			flash.error = message(code: 'spring.security.ui.forgotPassword.user.notFound')
			redirect  (controller: 'login', action: 'auth')
			return
		}

		def registrationCode = new RegistrationCode(username: user."$usernameFieldName")
		registrationCode.save(flush: true)

		String url = generateLink('resetPassword', [t: registrationCode.token])

		def conf = SpringSecurityUtils.securityConfig
		def body = conf.ui.forgotPassword.emailBody
		if (body.contains('$')) {
			body = evaluate(body, [user: user, url: url])
		}
		mailService.sendMail {
			to user.email
			from conf.ui.forgotPassword.emailFrom
			subject conf.ui.forgotPassword.emailSubject
			html body.toString()
		}

		[emailSent: true]
	}
	
	

def resetPassword(ResetPasswordCommand command) {

		println "Inside RESET PWD "+command
		String token = params.t

		def registrationCode = token ? RegistrationCode.findByToken(token) : null
		if (!registrationCode) {
			flash.error = message(code: 'spring.security.ui.resetPassword.badCode')
			redirect uri: SpringSecurityUtils.securityConfig.successHandler.defaultTargetUrl
			return
		}

		if (!request.post) {
			return [token: token, command: new ResetPasswordCommand()]
		}

		command.username = registrationCode.username
		command.validate()

		if (command.hasErrors()) {
			return [token: token, command: command]
		}

		String salt = saltSource instanceof NullSaltSource ? null : registrationCode.username
		RegistrationCode.withTransaction { status ->
			String usernameFieldName = SpringSecurityUtils.securityConfig.userLookup.usernamePropertyName
			def user = lookupUserClass().findWhere((usernameFieldName): registrationCode.username)
			user.password = springSecurityUiService.encodePassword(command.password, salt)
			user.save()
			registrationCode.delete()
		}

		/*springSecurityService.reauthenticate registrationCode.username*/

		flash.message = message(code: 'spring.security.ui.resetPassword.success')

		def conf = SpringSecurityUtils.securityConfig
		String postResetUrl = conf.ui.register.postResetUrl ?: conf.successHandler.defaultTargetUrl
		println "POST URL "+postResetUrl
		redirect uri: postResetUrl
		//redirect(controller:"login",action:"auth")
	}

	def forgotUsername(){
		def csrfPreventionSalt = params?.csrfPreventionSalt
		def currentUser = springSecurityService.getCurrentUser()
		println "PARAMS IN FORGOT USERNAME == "+params
		def message
		println "isUserAvailable..........."+params.isUserAvailable
		if(params.isUserAvailable == 'true'){
			[currentUser:currentUser,user:NbaUser.get(params?.userId)]
		}
		else if(params.isUserAvailable == 'false'){
			
			[currentUser:currentUser,message:"No user exists with this email id",isUserAvailable:params.isUserAvailable ]
		}
		else{
			[currentUser:currentUser]
		}
		//redirect(action:"showUserId")
	}

	def showUserId(){
		println "PARAMS == "+params
		def isUserAvailable
		def user
		def csrfPreventionSalt = params.csrfPreventionSalt
		if(params.username != ""){
			user = NbaUser.findByEmail(params.username)
			println "******user***** "+user
			if(user != null){
				isUserAvailable = true
				flash.message = "Your username is-" +user.username
				redirect(controller: 'login', action: 'auth' ,params:[csrfPreventionSalt:csrfPreventionSalt,userId:user?.id,isUserAvailable:isUserAvailable])
			}
			else{
				isUserAvailable = false
				println "isUserAvailable == "+isUserAvailable
				flash.error = "Email does not exist"
				redirect(controller: 'login', action: 'auth' ,params:[isUserAvailable:isUserAvailable,csrfPreventionSalt:csrfPreventionSalt])
			}
			println "isUserAvailable == "+isUserAvailable
			
		}
		

	}

	def changePassword(){
		println "inside changePassword "+params
		
		println "sessioncsrf---"+session["csrfPreventionSalt"]
		
		def csrfPreventionSalt
		
		if(params?.csrfPreventionSalt)
			csrfPreventionSalt = params?.csrfPreventionSalt
		else
			csrfPreventionSalt = session["csrfPreventionSalt"]
		
		String text = "", text2="", text3="";
		String possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
  
		for (int i = 0; i < 5; i++)
		  text += possible.charAt((Math.floor(Math.random() * possible.length())).intValue());
		  
		  for (int i = 0; i < 4; i++)
		  text2 += possible.charAt((Math.floor(Math.random() * possible.length())).intValue());
		  
		  for (int i = 0; i < 6; i++)
		  text3 += possible.charAt((Math.floor(Math.random() * possible.length())).intValue());
		  
		  println "text above is = "+text
		  //14-19
		  text = text2+text3+text2+text.reverse()+text2+text3
		  println "text below is = "+text
		session.setAttribute("secret", text);
		def sec = session.getAttribute("secret");
		
		[currentUser:springSecurityService.getCurrentUser(),message:params.message,csrfPreventionSalt:csrfPreventionSalt,secc:sec]
	}
	def saveChangedPassword(){
		println "PARAMS == "+params
		def message
		def isSuccessMsg
		def csrfPreventionSalt = params?.csrfPreventionSalt
		def user = springSecurityService.currentUser
        println "user == "+user.username
		println "user password==******** "+user.password
		println "params.oldpassword.........."+params.oldPwd
		def oldPassword = springSecurityService.encodePassword(params.oldPwd)
		
		println "oldPasswordoldPassword.............."+oldPassword
		
		if(oldPassword == user.password){
		
		if(params.newPwd == params.confirmNewPwd){
			println"hi true condition apply"
			message = "Your password has been changed successfully."
			isSuccessMsg = true
			user.password = params.newPwd
			println "new password issssssssssssssssss"+user.password
			if(!user.save(flush:true)){
				user.errors.each{ println "ERROR IN SAVING "+it }
			}
			redirect(action:"changePassword",params:[isSuccessMsg:isSuccessMsg,message:message])
//			forward(action:"changePassword",params:[isSuccessMsg:isSuccessMsg,message:message])
		}
		else{
			println"hi false condition apply"
			message = "Passwords & Confirm Password does not match."
			isSuccessMsg = false
			//render(template: "forgatPasswordDiv", model: [message: message, isSuccessMsg:isSuccessMsg,csrfPreventionSalt:csrfPreventionSalt])
			redirect(action:"changePassword",params:[isSuccessMsg:isSuccessMsg,message:message])
//			forward(action:"changePassword",params:[isSuccessMsg:isSuccessMsg,message:message])
			return
		}
		}
		else{
			redirect(action:"changePassword",params:[message: "No such old password !"])
//			forward(action:"changePassword",params:[message: "No such old password !"])
		}

	}

	def emailAvailability(){
		println "PARAMS== "+params
		println "params == " + params.email
		def csrfPreventionSalt = params.csrfPreventionSalt
		if(params.email){
			def user = NbaUser.findByEmail(params.email)
			println "user == "+user
			def emailData

			if(user != null){
				emailData = [flag1:true]
				emailData = [user:user]
			}
			else{
				emailData = [flag1:false]
			}
			render emailData as JSON
		}
	}

	def howToApply = {
		def aboutNBA = ManageLoginContent?.get(params?.aboutNBAId)
		def instructions = aboutNBA?.instructions
		[instructions:instructions]
	}





	def forgotUsername={}
	def faq={
		def faqObj = ManageLoginContent?.get(params?.aboutNBAId)
		def faqS = faqObj?.faq
		[faqS:faqS]
	}
	def knowYourFormPart1(){
	}
	def savePart1  = {
		println "PARAMS are == "+params
		def csrfPreventionSalt = params.csrfPreventionSalt
		def nationality = params.nationality
		if(nationality != null && nationality == 'Indian'){
			redirect(action:"knowYourFormPart2",params:[csrfPreventionSalt:csrfPreventionSalt,nationality:nationality])
		}
		else if(nationality != null && nationality == 'Non-Indian'){
			redirect(action:"knowYourFormPart3",params:[csrfPreventionSalt:csrfPreventionSalt,nationality:nationality])
		}
		else if(nationality != null && nationality == 'NRI'){
			redirect(action:"knowYourFormPart3",params:[csrfPreventionSalt:csrfPreventionSalt,nationality:nationality])
		}
		else if(nationality != null && nationality == 'Body Corporate1'){
			redirect(action:"knowYourFormPart4",params:[csrfPreventionSalt:csrfPreventionSalt,nationality:nationality])
		}
		else if(nationality != null && nationality == 'Body Corporate2'){
			redirect(action:"knowYourFormPart3",params:[csrfPreventionSalt:csrfPreventionSalt,nationality:nationality])
		}
		else if(nationality != null && nationality == 'Body Corporate3'){
			redirect(action:"knowYourFormPart3",params:[csrfPreventionSalt:csrfPreventionSalt,nationality:nationality])
		}
	}
	def knowYourFormPart2(){
		def nationality = params.nationality
		def csrfPreventionSalt = params.csrfPreventionSalt
		[nationality:nationality,csrfPreventionSalt:csrfPreventionSalt]
	}
	def knowYourFormPart3(){
		def csrfPreventionSalt = params.csrfPreventionSalt
		def nationality = params.nationality
		[nationality:nationality,csrfPreventionSalt:csrfPreventionSalt]
	}
	def knowYourFormPart4(){
		def csrfPreventionSalt = params.csrfPreventionSalt
		def nationality = params.nationality
		[nationality:nationality,csrfPreventionSalt:csrfPreventionSalt]
	}

	def savePart2 = {
		println "Inside savePart4 == "+params
		def formNumber,fee,formPart
		def csrfPreventionSalt = params.csrfPreventionSalt
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
		redirect(action:"knowYourFormPart5",params:[formNumber:formNumber,fee:fee,formPart:formPart,csrfPreventionSalt:csrfPreventionSalt])

	}
	def knowYourFormPart5(){
		println "Inside knowYourFormPart5 == "+params
		def formNumber = params.formNumber
		def csrfPreventionSalt = params.csrfPreventionSalt
		println "formNumber == "+formNumber

		def fee = params.fee
		println "fee == "+fee
		[formNumber:formNumber,fee:fee,csrfPreventionSalt:csrfPreventionSalt]
	}

}
class RegisterCommand {


	String username
	String password
	String password2
	String email
	String name
	String mobile
	String phone
	String dateOfBirth

	def grailsApplication

	static constraints = {
		username blank: false, validator: { value, command ->
			if (value) {
				def User = command.grailsApplication.getDomainClass(
						SpringSecurityUtils.securityConfig.userLookup.userDomainClassName).clazz
				if (User.findByUsername(value)) {
					return 'registerCommand.username.unique'
				}
			}
		}
		email blank: false,validator:{ value, command ->
			if (value){
				def User = command.grailsApplication.getDomainClass(SpringSecurityUtils.securityConfig.userLookup.userDomainClassName).clazz
				if (User.findByEmail(value)) {
					return 'validator.messageeeeeee'
				}
			}
		}
		password blank: false, validator: RegisterController.passwordValidator
		password2 validator: RegisterController.password2Validator
		mobile nullable:true, blank:true
		name nullable:true, blank:true
		phone nullable:true, blank:true
		dateOfBirth nullable:true, blank:true


	}
}
