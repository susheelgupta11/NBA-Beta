package org.nba.application

import grails.transaction.Transactional

import java.util.concurrent.TimeUnit

import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap
import org.nba.communication.Agenda
import org.nba.communication.AgendaLetterStatus
import org.nba.communication.AgendaSign
import org.nba.user.NbaUser

import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import com.google.common.cache.LoadingCache
import com.nba.constant.Constants

@Transactional
class OtpService {
def springSecurityService
def pdfRenderingService
def grailsApplication
	
	 private static final Integer EXPIRE_MINS = 2880;
	 
	 private LoadingCache<String, Integer> otpCache;
	 
	 public OtpService(){
		 super();
		 otpCache = CacheBuilder.newBuilder().
			     expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES).build(new CacheLoader<String, Integer>() {
				      public Integer load(String key) {
				             return 0;
				       }
				   });
	 }
	 

	 public int generateOTP(String key){
		 
		Random random = new Random();	
		int otp = 10000000000 + random.nextInt(900000);
		otpCache.put(key, otp);
		return otp;
	 }
		 
	
	 public int getOtp(String key){		 
		try{
			 return otpCache.get(key); 
		}catch (Exception e){
		 return 0;			 
		}
	 }
		 

	public void clearOTP(String key){		 
		 otpCache.invalidate(key);
	 }
	
	
	
	
	
	def agendaUpdate(GrailsParameterMap params , String sts){
		
		def agendaInstance = Agenda.get(Long.parseLong(params.agendaInstane))
	
//		agendaInstance.expertView = params.expertView
		agendaInstance.remarkByNba = params.remarkByNba
		agendaInstance.thirdpartyPurpose = params.thirdpartyPurpose
		agendaInstance.quantityeBio = params.quantityeBio
		agendaInstance.gioLoction = params.gioLoction
		agendaInstance.commonOrScientificName = params.commonOrScientificName
		agendaInstance.speciesName = params.speciesName
		agendaInstance.natureBio = params.natureBio
		agendaInstance.applicationFee = params.applicationFee
		agendaInstance.individualOrEntity = params.individualOrEntity
		agendaInstance.formType = params.formType
		agendaInstance.name = params.name
		agendaInstance.address = params.address
//		agendaInstance.whetherTraditional = params.whetherTraditional
//		agendaInstance.screeningBiores = params.screeningBiores
//		agendaInstance.rareEndemic = params.rareEndemic
//		agendaInstance.wildlifeAct = params.wildlifeAct
//		agendaInstance.restricted = params.restricted
//		agendaInstance.originalFile = params.originalFile
//		agendaInstance.proposal = params.proposal
		agendaInstance.approvalNBA = params.approvalNBA
		agendaInstance.recommendationSbb = params.recommendationSbb
		agendaInstance.sbbbmc = params.sbbbmc
		agendaInstance.refNo = params.refNo
		agendaInstance.receiptTimeTaken = params.receiptTimeTaken
		agendaInstance.inordinateDelay = params.inordinateDelay
		agendaInstance.whetherListNTC = params.whetherListNTC
		agendaInstance.alreadyExpEC = params.alreadyExpEC
		agendaInstance. prescribedApplication = params.prescribedApplication
		agendaInstance. actiontaken = params.actiontaken
//		agendaInstance.meetingName = params.meetingName
//		agendaInstance.meetingNum = params.meetingNum
		agendaInstance.dynamicMeetNum = getFinalMeetNumber(agendaInstance);
//		agendaInstance.fromDate = params.fromDate
//		agendaInstance.toDate = params.toDate
		
	def currentUser = springSecurityService.getCurrentUser().username
	def userName = NbaUser.findByUsername(currentUser)?.name	
		
		
		
		if(params.meetingName == Constants.MEET_4){
			agendaInstance.recommendationByNba = params.recommendationByNba
			}
		
		if(sts == "update"){
		agendaInstance.updatedBy = userName
		agendaInstance.updateDate = new Date()
		}else if(sts == "approve"){
		agendaInstance.approveBy = userName
		agendaInstance.sendDate = new Date()
		}
		
		if(!agendaInstance.save(flush:true)){
			agendaInstance.errors.allErrors.each {print it}
		   }
		return agendaInstance
	}
	
	def dynamicAgendaPdfConverter(Agenda agendaInstance, ApplicationForm1 formDetails){
		
		
				ByteArrayOutputStream  bytesPdf = pdfRenderingService.render(template: "/agenda/dynamicAgendaPdf", model: [agendaInstance:agendaInstance,formDetails:formDetails], filename: agendaInstance?.dynamicMeetNum + agendaInstance.id)
				new File(grailsApplication.config.pdfAgendaDynPath.toString() + File.separatorChar + agendaInstance?.appNumber).mkdirs()
				String filePath = grailsApplication.config.pdfAgendaDynPath.toString() + File.separatorChar + agendaInstance?.appNumber + File.separatorChar + agendaInstance?.dynamicMeetNum + agendaInstance.id+".pdf"
				
				agendaInstance.agendaPdfName = agendaInstance?.dynamicMeetNum +"-Agenda-" +agendaInstance.id+".pdf";
				agendaInstance.agendaPdfUrl = filePath;
				
				OutputStream getPdf = null;
		
				try{
					getPdf = new FileOutputStream(filePath)
					bytesPdf.writeTo(getPdf);
					getPdf.close();
					bytesPdf.close()
				}catch(Exception e){
					println e
				}
			}
		
	
	 public String setAgendaSignature(String action, Agenda obj){
		
		def cu = springSecurityService.getCurrentUser().username
		def userName = NbaUser.findByUsername(cu)
		AgendaSign signObj = new AgendaSign();
		
		signObj.agendaAction = action;
		signObj.agendaActionBy = userName.name;
		signObj.agendaActionRole = userName.nbaRole.authority;
		signObj.agendaActionDate = new Date();
		signObj.agenda = obj;
		if(!signObj.save(flush:true)){
			signObj.errors.allErrors.each{print it}
		}
		
	return "Signature Saved Successfully"	
		
		
	}
	 
	  def getFinalMeetNumber( Agenda updNumber){
		  
		
		 def meetingNum = updNumber.parentAgenda
		 def sendCounter = Agenda.where{
			 parentAgenda == meetingNum && agendaLetterStatus.agdltrstatus == AgendaLetterStatus.AgendaLtrStatus.LETTER_SEND
		 }.list().size()+1;
		 return     updNumber?.meetingNum+"."+sendCounter;
	 }
		
	
}
