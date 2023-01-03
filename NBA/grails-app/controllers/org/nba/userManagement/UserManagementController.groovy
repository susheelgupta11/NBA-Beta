package org.nba.userManagement

import org.nba.user.NbaRole
import org.nba.user.NbaUser
import org.nba.user.NbaUserNbaRole


class UserManagementController {

	def springSecurityService
    def index() { }
	
	def manageUser() {
		
		def listOfRolesPerUSer
		
		def csrfPreventionSalt = params?.csrfPreventionSalt
		
		def listOfRoles = NbaUserNbaRole.findAll().unique{ it.nbaUser.username }
		
		def listOfRole,listOfUserRoles
				listOfRole=NbaRole.findAll()
				
				List newListOfUserRoles = new ArrayList();
				newListOfUserRoles.add('ADMIN');
				newListOfUserRoles.add('APPLICANT');
				newListOfUserRoles.add('MANAGER');
				newListOfUserRoles.add('REVIEW_HEAD');
				listOfUserRoles = new ArrayList(listOfRole);
				listOfUserRoles.removeAll(newListOfUserRoles);
		
				println "listOfRole---------"+listOfRole
				println "listOfUserRoles---------"+listOfUserRoles
				
		println "inside manage user action of user management controller"+listOfRoles
		
		[csrfPreventionSalt:csrfPreventionSalt,listOfRoles:listOfRoles, listOfUserRoles:listOfUserRoles,listOfRolesPerUSer:listOfRolesPerUSer]
	}
	
	
	def roleActDeact() {
		
		println "inside roleActDeact..................."+params
		
		if (params?.id) {
			
			def user = NbaUser.findById(params?.id)
			if (user.enabled == true) {
				user.enabled = false
			} else {
				user.enabled = true
			}
			if (!user.save(flush: true)) {
				user.errors.each {
					println it
				}
			}
			println "user.enabled----------- "+user.enabled
			println "user.id----------- "+user.id
		}
		
		
	}
	
	def addRole() {
	
		println "inside addRole action-------------------------------"+params
		
		def nbaRoleobject,nbaRoleID,nbaUserobject,nbaUserID
		def roles,listOfUserRoles,newRole,currentUserRole
		
		def userId = params.userId
		def userRoleId = params.userRoleId
		nbaUserobject = NbaUser.get(userId)
		nbaUserID= nbaUserobject?.id
		
		nbaRoleobject = NbaRole.get(userRoleId)
		nbaRoleID= nbaRoleobject?.id
		
		def csrfPreventionSalt = params?.csrfPreventionSalt
		
		//getting the current user name
		def userObj = NbaUser.get(params?.userId)
		def user = userObj.name
		
		//for getting list of roles assigned to a particular user
		def listOfRolesPerUSer = NbaUserNbaRole.executeQuery("select userrole.nbaRole from NbaUserNbaRole userrole join userrole.nbaUser r where r.name = '${user}'").authority

		//for excluding ADMIN and APPLICANT roles from the list of roles
		roles = NbaRole.findAll().authority
		List rolesExcluded = new ArrayList()
		rolesExcluded.add('ADMIN')
		rolesExcluded.add('APPLICANT')
		rolesExcluded.add('MANAGER')
		rolesExcluded.add('REVIEW_HEAD')
		listOfUserRoles = new ArrayList(roles);
		listOfUserRoles.removeAll(rolesExcluded)           
		
		//getting current user-role for comparing with the added one
		currentUserRole = nbaRoleobject.authority
		
		//creating role entry in NbaUserNbaRole if current user-role is not equal to the one being added
		if(params?.addedRole && currentUserRole != params?.addedRole){
			newRole = params?.addedRole
			def roleAdded = NbaRole.findByAuthority(newRole)
			NbaUserNbaRole.create(nbaUserobject,roleAdded,true)
			flash.message = "Role "+newRole+" added for user "+user+"."
			println "created entries in NbaUserNbaRole................."
		}
		
		[csrfPreventionSalt:csrfPreventionSalt,user:user,listOfUserRoles:listOfUserRoles,userId:userId,userRoleId:userRoleId,listOfRolesPerUser:listOfRolesPerUSer,
		  msg:flash.message,newRole:newRole,currentUserRole:currentUserRole]
	}
	
	
	def deleteRoleForUser(){
		println "inside delete role for user"+params
		def currentUser = NbaUser.findById(params.userId)
		def roleObj = NbaRole.findByAuthority(params.roleToDelete)
		def userRole = NbaUserNbaRole.findWhere(nbaUser:currentUser,nbaRole:roleObj)
		
		userRole.delete(flush:true)
		redirect(action: 'addRole', params:[userId:params.userId,userRoleId:params.userRoleId])
	}
	
	
	def selectTask() {
		println "inside select task---------------------"
		
		def listOfRole,listOfUserRoles
		listOfRole=NbaRole.findAll()
		
		List newListOfUserRoles = new ArrayList();
		newListOfUserRoles.add('ADMIN');
		newListOfUserRoles.add('APPLICANT');
		newListOfUserRoles.add('MANAGER');
		newListOfUserRoles.add('REVIEW_HEAD');
		
		listOfUserRoles = new ArrayList(listOfRole);
		listOfUserRoles.removeAll(newListOfUserRoles);
		
		[listOfUserRoles:listOfUserRoles]
	}
	
	def reviewAndForward1() {
		println "inside review and forward"
	}
	
}
