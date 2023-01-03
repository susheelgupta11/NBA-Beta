package org.nba.userManagement
import grails.plugin.springsecurity.SpringSecurityUtils

import javax.servlet.http.HttpServletResponse

import org.nba.user.UserLog
import org.springframework.security.access.annotation.Secured
@Secured('permitAll')
class LogoutController {

    def springSecurityService

	/**
	 * Index action. Redirects to the Spring security logout uri.
	 */
	def index() {

		if (!request.post && SpringSecurityUtils.getSecurityConfig().logout.postOnly) {
			response.sendError HttpServletResponse.SC_METHOD_NOT_ALLOWED // 405
			return
		}

		// TODO put any pre-logout code here
		
		def currentUser = springSecurityService.getCurrentUser().username
		def userLogInstance = UserLog.findByUserNameAndLogoutTime(currentUser, null)
		println "chktime format"+userLogInstance.logoutTime
		
		userLogInstance.logoutTime = new Date();
		userLogInstance.save(flush:true)
		
		
		redirect uri: SpringSecurityUtils.securityConfig.logout.filterProcessesUrl // '/j_spring_security_logout'
	}
}
