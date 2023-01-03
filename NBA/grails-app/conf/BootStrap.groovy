import org.nba.master.Transaction;
import org.nba.user.NbaRole
import org.nba.user.NbaUser
import org.nba.user.NbaUserNbaRole
import org.nba.user.RoleEnum

import javax.servlet.http.HttpServletRequest

//import grails.plugin.springsecurity.SpringSecurityUtils
//import grails.plugin.springsecurity.SecurityFilterPosition

class BootStrap {

//	def authenticationManager
//	def concurrentSessionController
//	def securityContextPersistenceFilter
//	def authenticationProcessingFilter
//	def concurrentSessionControlStrategy
	
	
	def init = { servletContext ->
		
//		authenticationProcessingFilter.sessionAuthenticationStrategy = concurrentSessionControlStrategy
//		
//		SpringSecurityUtils.clientRegisterFilter('concurrencyFilter', SecurityFilterPosition.CONCURRENT_SESSION_FILTER)
		
		
		
//     for audit points secure true
		
//		servletContext.sessionCookieConfig.secure = true
		
//Set time zone as indian 		
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"))
//		TimeZone.setDefault(TimeZone.getTimeZone("IST"))
		
		
		//1. Creating roles
		def role1 = NbaRole.findByAuthority(RoleEnum.Role.APPLICANT) ?: new NbaRole(authority:RoleEnum.Role.APPLICANT).save(failOnError: true)
		def role2 = NbaRole.findByAuthority(RoleEnum.Role.MANAGER) ?: new NbaRole(authority:RoleEnum.Role.MANAGER).save(failOnError: true)
		def role3 = NbaRole.findByAuthority(RoleEnum.Role.ADMIN) ?: new NbaRole(authority:RoleEnum.Role.ADMIN).save(failOnError: true)
		def role4 = NbaRole.findByAuthority(RoleEnum.Role.TECHNICAL_OFFICER_BS) ?: new NbaRole(authority:RoleEnum.Role.TECHNICAL_OFFICER_BS).save(failOnError: true)
		def role5 = NbaRole.findByAuthority(RoleEnum.Role.ACCOUNT_OFFICER) ?: new NbaRole(authority:RoleEnum.Role.ACCOUNT_OFFICER).save(failOnError: true)
		def role6 = NbaRole.findByAuthority(RoleEnum.Role.ACCOUNT_ASSISTANT_MEMBER) ?: new NbaRole(authority:RoleEnum.Role.ACCOUNT_ASSISTANT_MEMBER).save(failOnError: true)
		def role7 = NbaRole.findByAuthority(RoleEnum.Role.REVIEW_HEAD)?: new NbaRole(authority:RoleEnum.Role.REVIEW_HEAD).save(failOnError:true)
		def role8 = NbaRole.findByAuthority(RoleEnum.Role.LEGAL_HEAD) ?: new NbaRole(authority:RoleEnum.Role.LEGAL_HEAD).save(failOnError: true)
		def role9 = NbaRole.findByAuthority(RoleEnum.Role.REVIEW_LEGAL_HEAD) ?: new NbaRole(authority:RoleEnum.Role.REVIEW_LEGAL_HEAD).save(failOnError: true)
		def role10 = NbaRole.findByAuthority(RoleEnum.Role.TECHNICAL_OFFICER_IPR) ?: new NbaRole(authority:RoleEnum.Role.TECHNICAL_OFFICER_IPR).save(failOnError: true)
		def role11 = NbaRole.findByAuthority(RoleEnum.Role.SECRETARY)?:new NbaRole(authority:RoleEnum.Role.SECRETARY).save(failOnError:true)
		def role12= NbaRole.findByAuthority(RoleEnum.Role.REVIEW_MEMBER) ?: new NbaRole(authority:RoleEnum.Role.REVIEW_MEMBER).save(failOnError: true)
		def role13 = NbaRole.findByAuthority(RoleEnum.Role.REVIEW_LEGAL_MEMBER)?:new NbaRole(authority:RoleEnum.Role.REVIEW_LEGAL_MEMBER).save(failOnError:true)
		def role14 = NbaRole.findByAuthority(RoleEnum.Role.REVIEW_IPR_MEMBER)?:new NbaRole(authority:RoleEnum.Role.REVIEW_IPR_MEMBER).save(failOnError:true)
		def role15 = NbaRole.findByAuthority(RoleEnum.Role.CHAIRMAN)?:new NbaRole(authority:RoleEnum.Role.CHAIRMAN).save(failOnError:true)
		
		def role16 = NbaRole.findByAuthority(RoleEnum.Role.DDO)?:new NbaRole(authority:RoleEnum.Role.DDO).save(failOnError:true)
		def role17 = NbaRole.findByAuthority(RoleEnum.Role.SBB)?:new NbaRole(authority:RoleEnum.Role.SBB).save(failOnError:true)
		def role18 = NbaRole.findByAuthority(RoleEnum.Role.IPR_MEMBER)?:new NbaRole(authority:RoleEnum.Role.IPR_MEMBER).save(failOnError:true)
		def role19 = NbaRole.findByAuthority(RoleEnum.Role.IPR_OFFICER_MEMBER)?:new NbaRole(authority:RoleEnum.Role.IPR_OFFICER_MEMBER).save(failOnError:true)
		def role20 = NbaRole.findByAuthority(RoleEnum.Role.IMAGINARY)?:new NbaRole(authority:RoleEnum.Role.IMAGINARY).save(failOnError:true)
		def role21 = NbaRole.findByAuthority(RoleEnum.Role.EC)?:new NbaRole(authority:RoleEnum.Role.EC).save(failOnError:true)
		
		
		//2. Printing roles
		
		println "checking user role...."
		println "done with user role...."
		println "NBA-Beta application starts now...."
		// creating users for first use and implementation
	//1-applicant	
//		def applicant = NbaUser.findByUsername("Applicant")
//		if(!applicant){
//			applicant = new NbaUser(name:"Applicant",username: 'Applicant',password: 'applicant@123',email: "gupta.susheel122@gmail.com",mobile:'8899666666',phone:'2255226622',dateOfBirth: '14-11-1991', enabled: true,accountExpired:false, accountLocked:false,passwordExpired:false)
//			if(!applicant.save()){
//				applicant.errors.each{ println it }
//			}
//			def role = NbaRole.findByAuthority(RoleEnum.Role.APPLICANT)
//			NbaUserNbaRole.create(applicant,role,true)
//		}
		
//2-manager		
		
//		def mgr = NbaUser.findByUsername("Manager")
//		if(!mgr){
//			mgr = new NbaUser(name:"Manager",username: 'Manager',password: 'manager@123',email: "absefiling.nba@gmail.com",mobile:'8899666666',phone:'2255226622',dateOfBirth: 1991-11-14, enabled: true,accountExpired:false, accountLocked:false,passwordExpired:false)
//			if(!mgr.save()){
//				mgr.errors.each{ println it }
//			}
//			def role = NbaRole.findByAuthority(RoleEnum.Role.MANAGER)
//			NbaUserNbaRole.create(mgr,role,true)
//		}
		
//3- Admin		
		
		def userAsSystem =  NbaUser.findByUsername("Admin")
		if(!userAsSystem){
			def newSystemUser = new NbaUser(name:"Admin User", nbaRole:role3, username: 'Admin',password: 'admin@123',email: "susheel.gupta11@gmail.com",mobile:'995851925',phone:'8855996655',dateOfBirth: '14-02-1990', enabled: true,accountExpired:false, accountLocked:false,passwordExpired:false)
			if(!newSystemUser.save()){
				newSystemUser.errors.each{ println it }
			}
			def role = NbaRole.findByAuthority(RoleEnum.Role.ADMIN)
			NbaUserNbaRole.create(newSystemUser,role,true)
		}
		
		
//4-TOBS		
		
//		def tobs = NbaUser.findByUsername("Technical Officer BS")
//		if(!tobs){
//			tobs = new NbaUser(name:"Technical Officer BS",username: 'Technical Officer BS',password: 'tobs@123',email: "absefiling.nba@gmail.com",mobile:'8899666666',phone:'2255226622',dateOfBirth: 1991-11-14, enabled: true,accountExpired:false, accountLocked:false,passwordExpired:false)
//			if(!tobs.save()){
//				tobs.errors.each{ println it }
//			}
//			def role = NbaRole.findByAuthority(RoleEnum.Role.TECHNICAL_OFFICER_BS)
//			NbaUserNbaRole.create(tobs,role,true)
//		}
	
//5-AccOfficer		
		
//		def accountOfficr = NbaUser.findByUsername("Account Officer")
//		if(!accountOfficr){
//			accountOfficr = new NbaUser(name:"Account Officer",username: 'Account Officer',password: 'accoff@123',email: "absefiling.nba@gmail.com",mobile:'8899666666',phone:'2255226622',dateOfBirth: 1991-11-14, enabled: true,accountExpired:false, accountLocked:false,passwordExpired:false)
//			if(!accountOfficr.save()){
//				accountOfficr.errors.each{ println it }
//			}
//			def role = NbaRole.findByAuthority(RoleEnum.Role.ACCOUNT_OFFICER)
//			NbaUserNbaRole.create(accountOfficr,role,true)
//		}
		
//6- AccAssMember
		
//		def accAssMem = NbaUser.findByUsername("Account Assistant Member")
//		if(!accAssMem){
//			accAssMem = new NbaUser(name:"Account Assistant Member",username: 'Account Assistant Member',password: 'accAssMem@123',email: "absefiling.nba@gmail.com",mobile:'8899666666',phone:'2255226622',dateOfBirth: 1991-11-14, enabled: true,accountExpired:false, accountLocked:false,passwordExpired:false)
//			if(!accAssMem.save()){
//				accAssMem.errors.each{ println it }
//			}
//			def role = NbaRole.findByAuthority(RoleEnum.Role.ACCOUNT_ASSISTANT_MEMBER)
//			NbaUserNbaRole.create(accAssMem,role,true)
//		}

//7- Review Head		
		
//		def reviewUser = NbaUser.findByUsername("ReviewHead")
//		if(!reviewUser){
//			reviewUser = new NbaUser(name:"Review Head User",username: 'ReviewHead',password: 'head@123',email: "absefiling.nba@gmail.com",mobile:'8899666666',phone:'2255226622',dateOfBirth: 1991-11-14, enabled: true,accountExpired:false, accountLocked:false,passwordExpired:false)
//			if(!reviewUser.save()){
//				reviewUser.errors.each{ println it }
//			}
//			def role = NbaRole.findByAuthority(RoleEnum.Role.REVIEW_HEAD)
//			NbaUserNbaRole.create(reviewUser,role,true)
//		}
		
//8- Legal Head
		
		
//		def legalHead = NbaUser.findByUsername("Legal Head")
//		if(!legalHead){
//			legalHead = new NbaUser(name:"Legal Head",username: 'Legal Head',password: 'legalHead@123',email: "absefiling.nba@gmail.com",mobile:'8899666666',phone:'2255226622',dateOfBirth: 1991-11-14, enabled: true,accountExpired:false, accountLocked:false,passwordExpired:false)
//			if(!legalHead.save()){
//				legalHead.errors.each{ println it }
//			}
//			def role = NbaRole.findByAuthority(RoleEnum.Role.LEGAL_HEAD)
//			NbaUserNbaRole.create(legalHead,role,true)
//		}
//		
//9- RevlglHead		
		
//		def reviewLH = NbaUser.findByUsername("Review Legal Head")
//		if(!reviewLH){
//			reviewLH = new NbaUser(name:"Review Legal Head",username: 'Review Legal Head',password: 'reviewLH@123',email: "absefiling.nba@gmail.com",mobile:'8899666666',phone:'2255226622',dateOfBirth: 1991-11-14, enabled: true,accountExpired:false, accountLocked:false,passwordExpired:false)
//			if(!reviewLH.save()){
//				reviewLH.errors.each{ println it }
//			}
//			def role = NbaRole.findByAuthority(RoleEnum.Role.REVIEW_LEGAL_HEAD)
//			NbaUserNbaRole.create(reviewLH,role,true)
//		}
		
//10-- TecOfficerIPR		
		
//		def tecOffIPR = NbaUser.findByUsername("Technical Officer IPR")
//		if(!tecOffIPR){
//			tecOffIPR = new NbaUser(name:"Technical Officer IPR",username: 'Technical Officer IPR',password: 'tecOffIPR@123',email: "absefiling.nba@gmail.com",mobile:'8899666666',phone:'2255226622',dateOfBirth: 1991-11-14, enabled: true,accountExpired:false, accountLocked:false,passwordExpired:false)
//			if(!tecOffIPR.save()){
//				tecOffIPR.errors.each{ println it }
//			}
//			def role = NbaRole.findByAuthority(RoleEnum.Role.CHAIRMAN)
//			NbaUserNbaRole.create(tecOffIPR,role,true)
//		}

//11-Secretry		
		
		
//		def secretary = NbaUser.findByUsername("Secretary")
//		if(!secretary){
//			secretary = new NbaUser(name:"Secretary",username: 'Secretary',password: 'secr@123',email: "absefiling.nba@gmail.com",mobile:'8899666666',phone:'2255226622',dateOfBirth: 1991-11-14, enabled: true,accountExpired:false, accountLocked:false,passwordExpired:false)
//			if(!secretary.save()){
//				secretary.errors.each{ println it }
//			}
//			def role = NbaRole.findByAuthority(RoleEnum.Role.SECRETARY)
//			NbaUserNbaRole.create(secretary,role,true)
//		}
		
//12-Tech Offcr IPR Member		
		
//		def tecOffIPRMem = NbaUser.findByUsername("Technical Officer IPR Member")
//		if(!tecOffIPRMem){
//			tecOffIPRMem = new NbaUser(name:"Technical Officer IPR Member",username: 'Technical Officer IPR Member',password: 'secr@123',email: "absefiling.nba@gmail.com",mobile:'8899666666',phone:'2255226622',dateOfBirth: 1991-11-14, enabled: true,accountExpired:false, accountLocked:false,passwordExpired:false)
//			if(!tecOffIPRMem.save()){
//				tecOffIPRMem.errors.each{ println it }
//			}
//			def role = NbaRole.findByAuthority(RoleEnum.Role.REVIEW_IPR_MEMBER)
//			NbaUserNbaRole.create(tecOffIPRMem,role,true)
//		}

//13- Chairman				
		
//		def chairMan = NbaUser.findByUsername("Chairman")
//		if(!chairMan){
//			chairMan = new NbaUser(name:"Chairman User",username: 'Chairman',password: 'chairman@123',email: "absefiling.nba@gmail.com",mobile:'8899666666',phone:'2255226622',dateOfBirth: 1991-11-14, enabled: true,accountExpired:false, accountLocked:false,passwordExpired:false)
//			if(!chairMan.save()){
//				chairMan.errors.each{ println it }
//			}
//			def role = NbaRole.findByAuthority(RoleEnum.Role.CHAIRMAN)
//			NbaUserNbaRole.create(chairMan,role,true)
//		}
		
		
		
		//14- Review Member
		
//		def revMem = NbaUser.findByUsername("Review Member")
//		if(!revMem){
//			revMem = new NbaUser(name:"Review Member",username: 'Review Member',password: 'revMem@123',email: "absefiling.nba@gmail.com",mobile:'8899666666',phone:'2255226622',dateOfBirth: 1991-11-14, enabled: true,accountExpired:false, accountLocked:false,passwordExpired:false)
//			if(!revMem.save()){
//				revMem.errors.each{ println it }
//			}
//			def role = NbaRole.findByAuthority(RoleEnum.Role.REVIEW_MEMBER)
//			NbaUserNbaRole.create(revMem,role,true)
//		}
		
		//15- Chairman
		
//		def revLglMem = NbaUser.findByUsername("Review Legal Member")
//		if(!revLglMem){
//			revLglMem = new NbaUser(name:"Review Member",username: 'Review Legal Member',password: 'revLglMem@123',email: "absefiling.nba@gmail.com",mobile:'8899666666',phone:'2255226622',dateOfBirth: 1991-11-14, enabled: true,accountExpired:false, accountLocked:false,passwordExpired:false)
//			if(!revLglMem.save()){
//				revLglMem.errors.each{ println it }
//			}
//			def role = NbaRole.findByAuthority(RoleEnum.Role.REVIEW_MEMBER)
//			NbaUserNbaRole.create(revLglMem,role,true)
//		}
		
//	16- Ddo 	
//		def ddo = NbaUser.findByUsername("ddo")
//		if(!ddo){
//			ddo = new NbaUser(name:"DDO",username: 'ddo',password: 'ddo@123',email: "absefiling.nba@gmail.com",mobile:'8899666666',phone:'2255226622',dateOfBirth: 1991-11-14, enabled: true,accountExpired:false, accountLocked:false,passwordExpired:false)
//			if(!ddo.save()){
//				ddo.errors.each{ println it }
//			}
//			def role = NbaRole.findByAuthority(RoleEnum.Role.DDO)
//			NbaUserNbaRole.create(ddo,role,true)
//		}
// 17- ssb
//		def sbb = NbaUser.findByUsername("sbb")
//		if(!sbb){
//			sbb = new NbaUser(name:"SBB",username: 'sbb',password: 'sbb@123',email: "absefiling.nba@gmail.com",mobile:'8899666666',phone:'2255226622',dateOfBirth: 1991-11-14, enabled: true,accountExpired:false, accountLocked:false,passwordExpired:false)
//			if(!sbb.save()){
//				sbb.errors.each{ println it }
//			}
//			def role = NbaRole.findByAuthority(RoleEnum.Role.SBB)
//			NbaUserNbaRole.create(sbb,role,true)
//		}
		
//		def virtual = NbaUser.findByUsername("virtual")
//		if(!virtual){
//			virtual = new NbaUser(name:"virtual",username: 'virtual',password: 'virtual@123',email: "absefiling.nba@gmail.com",mobile:'8899666666',phone:'2255226622',dateOfBirth: 1991-11-14, enabled: true,accountExpired:false, accountLocked:false,passwordExpired:false)
//			if(!virtual.save()){
//				virtual.errors.each{ println it }
//			}
//			def role = NbaRole.findByAuthority(RoleEnum.Role.IMAGINARY)
//			NbaUserNbaRole.create(virtual,role,true)
//			virtual.nbaRole = role
//		}
		

	}
	def destroy = {
	}
}
