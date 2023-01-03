package org.nba.userManagement

import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse

import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.ui.RegistrationCode
import grails.converters.JSON

import org.nba.user.NbaUser;
import org.nba.user.UserLocked
import org.nba.master.MstrDocument
import org.nba.master.ManageLoginContent
import org.springframework.security.access.annotation.Secured
import org.springframework.security.authentication.AccountExpiredException
import org.springframework.security.authentication.CredentialsExpiredException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.LockedException
import org.springframework.security.core.context.SecurityContextHolder as SCH
import org.springframework.security.web.WebAttributes

import grails.plugin.simplecaptcha.SimpleCaptchaService
import groovy.time.TimeCategory;
import groovy.time.TimeDuration

class LoginController extends grails.plugin.springsecurity.LoginController{

	/**
	 * Dependency injection for the authenticationTrustResolver.
	 */
	def authenticationTrustResolver
	def simpleCaptchaService
	
	/**
	 * Dependency injection for the springSecurityService.
	 */
	def springSecurityService
	static allowedMethods = [index: "GET", auth: "GET",validateUser:"POST"]

	/**
	 * Default action; redirects to 'defaultTargetUrl' if logged in, /login/auth otherwise.
	 */
	def index() {
		println "Hello USER 12345678"
		if (springSecurityService.isLoggedIn()) {

			redirect uri: SpringSecurityUtils.securityConfig.successHandler.defaultTargetUrl
		}
		else {
			println "im here"
			redirect action: 'auth', params: params
		}
	}

	/**
	 * Show the login page.
	 */





	def auth() {
		println "going to validate captcha 666 "+params
		println "THIS IS UNDER AUTH"
		def config = SpringSecurityUtils.securityConfig
		println "############################################################################# " + springSecurityService.isLoggedIn()
		if (springSecurityService.isLoggedIn()) {
			println "THIS IS UNDER IF"
			redirect uri: config.successHandler.defaultTargetUrl
			return
		}
		String view = 'auth'
		String postUrl = "${request.contextPath}/login/validateUser"
		
		
		
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
//		session.setAttribute("secret", text.substring(14, 19).reverse());
		
		def sec = session.getAttribute("secret");
		
		
		//render view: view
		render view: view, model: [postUrl: postUrl,doc:MstrDocument.findByDocName('User Manual'),secc:sec,
			rememberMeParameter: config.rememberMe.parameter]
	}
	
	def sec() {
		Map mymap = [:]
		String text = "";
		String possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
  
		for (int i = 0; i < 5; i++)
		  text += possible.charAt((Math.floor(Math.random() * possible.length())).intValue());
		  
		  //println "text is = "+text
		  
		  session.setAttribute("secret", text);
		  
		  mymap.put("sec", text)
		  render mymap as JSON
	}




	
	def validateUser={
		
		println "inside validate user 11111111"+params
		println "Login date" + new Date()
		def pass = springSecurityService.encodePassword(params.j_password)
		println "pass is "+pass
		def config = SpringSecurityUtils.securityConfig
		def user = NbaUser.findByUsernameAndPassword(params.j_username, pass)
		println "user is "+user
		def userExist = NbaUser.findByUsername(params.j_username)
		println "userExist is "+userExist
		println "inside validate user 22222222"
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
//		session.setAttribute("secret", text.substring(14, 19).reverse());
		
		def sec = session.getAttribute("secret");
		
		boolean captchaValid = simpleCaptchaService.validateCaptcha(params.captcha)
		println"@@@@@@@@"+captchaValid
		
		if(params?.captcha && simpleCaptchaService.validateCaptcha(params?.captcha)==false){
			println "inside captcha check 1"
			flash.message = 'Invalid Captcha'
			render view: 'auth', model: [secc:sec]
			return
		}
		//remove the upper case letter captcha and add lower case also-susheel
//		else if(params?.captcha?.equals(params?.captcha?.toUpperCase()) == false){
//			println "inside captcha check 2"
//			flash.message = 'Invalid Captcha'
//			render view: 'auth', model: [sec:sec]
//			return
//		}
		else{
			println "inside else after captcha"
			if(user){
				println "inside user found"
				
			// check locked user 

				if(user.accountLocked == true){
					
					def checktime = UserLocked.findByUsername(params.j_username)
//					TimeDuration duration = TimeCategory.minus(new Date(), checktime.lockedtime)
					
					
					
					
					def currentTime = new Date()
					Date lockedTime= checktime.lockedtime

					def difference=currentTime.getTime()-lockedTime.getTime()
					
					def duration = Math.round(difference/3600000)
					println "duration is"+duration
					
					if(duration <= 24){
						flash.message = 'Your account is locked '
						render view: 'auth', model: [secc:sec]
						return
						
					}else if(duration > 24){
					checktime.usercount = 0
					user.accountLocked = false
					checktime.save(flush:true)
					user.save(flush:true)
					
					}
				}
				
			springSecurityService.reauthenticate(user.username)
			
			println '============= '+springSecurityService.currentUser
			def currentUser = springSecurityService.currentUser
			def userId = currentUser?.id
			
			
			def random
			try {
			
			Random randomGenerator = new Random();
			for (int idx = 1; idx <= 10; ++idx) {
			random = randomGenerator.nextLong() + 9999;
			}
			println '=============.... '+random.toString()
			session.setAttribute("token", random.toString());
			Cookie cookie = new Cookie("tokenid",random.toString())
			cookie.setMaxAge(-1)
			cookie.setPath("/")
//				cookie.setHttpOnly(true);
			response.addCookie(cookie)
			}
			catch (Exception e) {
			println " rendom exception genrate due to" + e
}
			println '============= '+userId
				//Cookie cookie = new Cookie("tokenid",userId?.toString())
			//session.removeAttribute("token")
				
			redirect uri: config.successHandler.defaultTargetUrl
			
		}else if(userExist){
		println "inside else-if in else after captcha"
		int alert = 3;
		UserLocked usrlock = UserLocked.findByUsername(params.j_username)
		if(usrlock){
			
			if(usrlock.usercount < 3){
			
			usrlock.usercount = usrlock.usercount + 1
			alert = alert - usrlock.usercount;
			usrlock.save(flush:true)
			}else{
			
			userExist.accountLocked = true
			usrlock.lockedtime = new Date()
			
			usrlock.save(flush:true)
			userExist.save()
			flash.message = "Your account is locked for 24 hours !"
			render view: 'auth', model: [secc:sec]
			return
			
			}
		}else{
		alert = alert -1;
		UserLocked usrLockIns = new UserLocked()
		usrLockIns.usercount = 1;
		usrLockIns.username = params.j_username;
		usrLockIns.save(flush:true)
		}
		
		
		
		  flash.message = "Wrong username/password you have" +alert+ "attempts left!"
		  render view: 'auth', model: [secc:sec]
		  return
		}else{
		println "inside else in else after captcha"
		  flash.message = "Email/Username or Password is incorrect!"
		  render view: 'auth', model: [secc:sec]
		  return
		}
		}
	}
	
	
	/**
	 * The redirect action for Ajax requests.
	 */
	def authAjax() {
		response.setHeader 'Location', SpringSecurityUtils.securityConfig.auth.ajaxLoginFormUrl
		response.sendError HttpServletResponse.SC_UNAUTHORIZED
	}

	/**
	 * Show denied page.
	 */
	def denied() {
		if (springSecurityService.isLoggedIn() &&
		authenticationTrustResolver.isRememberMe(SCH.context?.authentication)) {
			// have cookie but the page is guarded with IS_AUTHENTICATED_FULLY
			redirect action: 'full', params: params
		}
	}

	/**
	 * Login page for users with a remember-me cookie but accessing a IS_AUTHENTICATED_FULLY page.
	 */
	def full() {
		def config = SpringSecurityUtils.securityConfig
		render view: 'auth', params: params,
		model: [hasCookie: authenticationTrustResolver.isRememberMe(SCH.context?.authentication),
			postUrl: "${request.contextPath}${config.apf.filterProcessesUrl}"]
	}

	/**
	 * Callback after a failed login. Redirects to the auth page with a warning message.
	 */
	def authfail() {

		String msg = ''
		def exception = session[WebAttributes.AUTHENTICATION_EXCEPTION]
		if (exception) {
			if (exception instanceof AccountExpiredException) {
				msg = g.message(code: "springSecurity.errors.login.expired")
			}
			else if (exception instanceof CredentialsExpiredException) {
				msg = g.message(code: "springSecurity.errors.login.passwordExpired")
			}
			else if (exception instanceof DisabledException) {
				msg = g.message(code: "springSecurity.errors.login.disabled")
			}
			else if (exception instanceof LockedException) {
				msg = g.message(code: "springSecurity.errors.login.locked")
			}
			else {
				msg = g.message(code: "springSecurity.errors.login.fail")
			}
		}

		if (springSecurityService.isAjax(request)) {
			render([error: msg] as JSON)
		}
		else {
			flash.message = msg
			redirect action: 'auth', params: params
		}
	}

	/**
	 * The Ajax success redirect url.
	 */
	def ajaxSuccess() {
		render([success: true, username: springSecurityService.authentication.name] as JSON)
	}

	/**
	 * The Ajax denied redirect url.
	 */
	def ajaxDenied() {
		render([error: 'access denied'] as JSON)
	}
	
	

	def error = {

	}
	
	def readMore(){}
	

	def showDc(long id)
	{
		println"show doc"+params?.id

		ByteArrayOutputStream ous = null;
		InputStream ios = null;
		def doc= MstrDocument.get(Long.parseLong(params?.id))
		def file= doc?.document
		def filename = doc?.docName
		println "FILE == "+doc
		byte[] DocContent = null;
		DocContent = file
		response.setContentType("application/pdf");
		response.setHeader "Content-disposition", "inline; filename="+filename
		//response.contentType = 'application/msword'
		response.outputStream << DocContent
		response.outputStream.flush()
		response.outputStream.close()
	}

}
