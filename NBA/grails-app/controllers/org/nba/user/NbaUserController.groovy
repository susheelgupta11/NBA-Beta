package org.nba.user
import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import grails.transaction.Transactional

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

import org.codehaus.groovy.grails.scaffolding.view.ScaffoldingViewResolver;
import org.springframework.security.access.annotation.Secured

@Secured('permitAll')
class NbaUserController {

    static allowedMethods = [create:"GET",save: "POST", update: "POST"]
	def csrfPreventionSalt

    def index() {
//		def cri = NbaUser.createCriteria()
//		def results = cri.list {
//			eq('accountExpired', false)
//			
//		} 
		
		def csrfSalt = params.csrfPreventionSalt
	    def message = params.message
		csrfPreventionSalt = request.getAttribute("csrfPreventionSalt")
//	 params.max = Math.min(params.max ? params.int('max') : 10, 100)
//	 
//	 params.max = params.max ?: 10
//	 params.offset = params.offset ?: 0
		
		def query = NbaUser.where {
			nbaRole != NbaRole.findByAuthority(RoleEnum.Role.APPLICANT)
		 }
		
//	def results = NbaUser.findAllByAccountExpired(false,[max: 10, order: "desc", offset: 100])

		 def results = query.list()
                                    
        model:[nbaUserInstanceList:results?.sort{a,b-> a.name <=> b.name?:a.dtCreated <=> b.dtCreated},
			 message:message,csrfPreventionSalt:csrfPreventionSalt]
    }
	
	
def create(){
	def message = params.message
	def csrfSalt = params.csrfPreventionSalt
	
	println "old token in create"+csrfPreventionSalt
	println "New token in create"+ csrfSalt
	
	
	if(csrfPreventionSalt != csrfSalt){
		redirect(action:'index', params:[message:'Token not matched',csrfPreventionSalt:csrfPreventionSalt])
		return;
		
		}
	
	def nbaUserInstance = new NbaUser()
	
	def roleList = NbaRole.createCriteria()list{
		ne('authority' , 'APPLICANT')
	}
	
	csrfPreventionSalt = request.getAttribute("csrfPreventionSalt")
	
		[nbaUserInstance:nbaUserInstance,roleList:roleList,message:message,csrfPreventionSalt:csrfPreventionSalt]
	}

  
  @Transactional
    def save() {
		def currentName = params.username
		def csrfSalt = params.csrfPreventionSalt
		
		
		println "Old token in save"+csrfPreventionSalt
		println "New token in save"+ csrfSalt
		
		
		if(csrfPreventionSalt != csrfSalt){
			redirect(action:'create', params:[message:'Token not matched',csrfPreventionSalt:csrfPreventionSalt])
			return;
			
			}
		
		def nameList = NbaUser.createCriteria().list {
		projections {
			property('username') 
			
			}
		}
		
		def emailList = NbaUser.createCriteria().list {
			projections {
				property('email')
				
				}
			}
	
		if(nameList.contains(params.username) || emailList.contains(params.email)){
			
		
		redirect(action:'create', params:[message:'Username or email already exist',csrfPreventionSalt:csrfPreventionSalt])
		return;
		}else{
		
	def nbaUserInstance = new NbaUser(name:params.name,username:params.username,password:params.password,email:params.email,
			                              mobile:params.mobile,phone:params.phone)
	   
    def getNbaRole = NbaRole.get(Long.parseLong(params.nbaRole)) 
		nbaUserInstance.nbaRole = getNbaRole
	
		nbaUserInstance.dateOfBirth = params.dateOfBirth
		
		nbaUserInstance.accountExpired = false
		nbaUserInstance.accountLocked = false
		nbaUserInstance.passwordExpired = false
		nbaUserInstance.dtCreated = new Date()

		 if(!nbaUserInstance.save (flush:true)){
			nbaUserInstance.errors.allErrors.each {print it} 
			redirect(action:'create', params:[message:'user not saved'])
            return
		 }
		 def message = "User save successfully"
		 redirect (action:'index', params:[message:message,csrfPreventionSalt:csrfPreventionSalt])
	}
}

	
	def edit(NbaUser nbaUserInstance) {

		def csrfSalt = params.csrfPreventionSalt
		
		
		println "Old token in save"+csrfPreventionSalt
		println "New token in save"+ csrfSalt
		if(csrfPreventionSalt != csrfSalt){
		redirect(action:'index', params:[message:'Token not matched'])	
		return;
		}
		
		csrfPreventionSalt = request.getAttribute("csrfPreventionSalt")
		
		def roleList = NbaRole.createCriteria()list{ ne('authority' , 'IMAGINARY') }
		
		[nbaUserInstance:nbaUserInstance,roleList:roleList,,csrfPreventionSalt:csrfPreventionSalt]
	}
	
	

	@Transactional
	def update() {
			
		def csrfSalt = params.csrfPreventionSalt
		println "Old token in update"+csrfPreventionSalt
		println "New token in update"+ csrfSalt
		if(csrfPreventionSalt != csrfSalt){
		redirect(action:'index', params:[message:'Token not matched'])	
		return;
		}
		
		csrfPreventionSalt = request.getAttribute("csrfPreventionSalt")
		
		def nbaUserInstance = NbaUser.get(params.id as Long)
		
		if (nbaUserInstance == null) {
			notFound()
			return
		}
		
		nbaUserInstance.name=params.name
		nbaUserInstance.username = params.username
		nbaUserInstance.password = params.password
		nbaUserInstance.email = params.email

		nbaUserInstance.mobile = params.mobile
		nbaUserInstance.phone = params.phone
		nbaUserInstance.dtCreated = new Date()

	    nbaUserInstance.dateOfBirth = params.dateOfBirth
		
		def getNbaRole = NbaRole.get(Long.parseLong(params.nbaRole))
		nbaUserInstance.nbaRole = getNbaRole
		

		if(!nbaUserInstance.save (flush:true)){
			respond nbaUserInstance.errors, view:'edit'
		}
   def message = "User updated successfully"
		redirect (action:'index',params:[message:message])
	}


	def convertMD5(String input){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());

			BigInteger no = new BigInteger(1, messageDigest);

			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		}

		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	def changeUser(){
		
		def status = params.status

		def nbaUserInstanceForDelete = NbaUser.get(params?.id as Long)

		if(status == 'deactivate'){
			nbaUserInstanceForDelete.accountLocked = true
		    nbaUserInstanceForDelete.answer =  nbaUserInstanceForDelete.username
			nbaUserInstanceForDelete.username = "Deactivate"+params?.id
			
		}else if(status == 'activate'){
		
			nbaUserInstanceForDelete.accountLocked = false
		nbaUserInstanceForDelete.username = nbaUserInstanceForDelete.answer
		nbaUserInstanceForDelete.answer = ""
		
		}
		if(!nbaUserInstanceForDelete.save(flush: true)){
			nbaUserInstanceForDelete.errors.allErrors.each {print it}
		}
		def message = "User "+status+" successfully"
		redirect(action:'index',params:[message:message])
	}
	
	def checkUserName(){

		def existCheck = params.value
		def type = params.type
		def result

		def c = NbaUser.createCriteria()
		def requiredList = c.list {projections {property(type) }
		}
		if(requiredList.contains(existCheck)){
		result = [status:false]
		}else{
		result = [status:true]
		}
		println "result" +result
		render result as JSON
	}
	
}