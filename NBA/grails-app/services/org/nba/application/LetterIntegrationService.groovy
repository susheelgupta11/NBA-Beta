package org.nba.application

import grails.transaction.Transactional

import java.time.LocalDate
import java.util.Date;

import org.nba.communication.ClientLetter
import org.nba.communication.LetterCommunication
import org.nba.communication.LetterStatus
import org.nba.communication.LetterType
import org.nba.communication.ResponceLetterStatus
import org.nba.communication.SBBConsent
import org.nba.communication.SbbCommunication
import org.nba.master.LetterTemplate
import org.nba.user.NbaUser

import com.nba.constant.Constants

@Transactional
class LetterIntegrationService {

	def springSecurityService
	def pdfRenderingService
	def grailsApplication
	
	  def setLetterStatus( letterInstance,LetterStatus.LtrStatus sts){
	
	def communicationIns

		if(letterInstance != null){
				communicationIns = LetterCommunication.get(letterInstance)
		}
 
	  def	lettersts =  LetterStatus.where{
			letterCommunication == communicationIns
		}.find()
	

		if(lettersts == null || lettersts == ''){
			lettersts = new LetterStatus(ltrstatus:sts,letterCommunication:communicationIns,statusChangedBy:springSecurityService.currentUser)
		}else{
			lettersts.ltrstatus = sts
			lettersts.statusChangedBy = springSecurityService.currentUser
		}
		if(!lettersts.save(flush:true)){
			lettersts.errors.allErrors.each {print it}
		}
		return lettersts
	}
	  
	  
	  
	  def setResponceLetterStatus( letterInstance,ResponceLetterStatus.LtrStatus sts){
		  
		  def communicationIns
	  
			  if(letterInstance != null){
					  communicationIns = ClientLetter.get(letterInstance)
			  }
	   
			def	lettersts =  ResponceLetterStatus.where{
				  clientLetter == communicationIns
			  }.find()
		  
	  
			  if(lettersts == null || lettersts == ''){
				  lettersts = new ResponceLetterStatus(ltrstatus:sts,clientLetter:communicationIns,statusChangedBy:springSecurityService.currentUser)
			  }else{
				  lettersts.ltrstatus = sts
				  lettersts.statusChangedBy = springSecurityService.currentUser
			  }
			  if(!lettersts.save(flush:true)){
				  lettersts.errors.allErrors.each {print it}
			  }
			  return lettersts
		  }
			

	  
	  def setLetterType(letterInstance,LetterType.LtrType type){
	
		  def typeInstance
		  
				  if(letterInstance != null){
						  typeInstance = LetterCommunication.get(letterInstance)
				  }
		   
				def	letterType =  LetterType.where{
					  letterCommunication == typeInstance
				  }.find()
			  
		  
				  if(letterType == null || letterType == ''){
					  letterType = new LetterType(ltrType:type,letterCommunication:typeInstance,ltrTypeSetBy:springSecurityService.currentUser)
				  }else{
					  letterType.ltrType = type
					  letterType.ltrTypeSetBy = springSecurityService.currentUser
				  }
				  if(!letterType.save(flush:true)){
					  letterType.errors.allErrors.each {print it}
				  }
				  return letterType
		  
	  }
	  
	  public String getDynLetterNumberApplicantOut(String appNumber){
		  
		  String dynamicLetterNumber = "", dynamicNumber;
		 def countletter = ClientLetter.list().size();
	 
		  def counter = countletter+1;
  
		   if(counter >= 1 && counter < 10){
			  dynamicNumber = "000"+counter.toString();
			 }else if(counter> 10 && counter < 100){
	 
				 dynamicNumber = "00"+counter.toString();
			 }
			 else if(counter > 100 && counter < 1000){
	 
				 dynamicNumber = "0"+counter.toString();
			 }
			 else if(counter > 1000 && counter < 10000){
	 
				 dynamicNumber = counter.toString();
			 }
		 
		 LocalDate today = LocalDate.now();
		 int month = today.getMonthValue();
		 int currentYear = today.getYear();
		 
		 String subCurrentYear = currentYear.toString().substring(2);
		 
		 int previousYear = Integer.parseInt(subCurrentYear) -1;
		 int nextYear = Integer.parseInt(subCurrentYear) +1;
		
	 
		 if(month >= 4){
			 
			 dynamicLetterNumber = appNumber+"/OT/"+subCurrentYear+"-"+nextYear+"/"+dynamicNumber;
			 
			 }
		 else{
			 dynamicLetterNumber = appNumber+"/OT/"+previousYear+"-"+subCurrentYear+"/"+dynamicNumber;
			 
			 }
			 return dynamicLetterNumber;
		  }
	  
	  
   public String getDynLetterNumberNbaIn(String appNumber){

		  String dynamicLetterNumber = "", dynamicNumber;
		 def counter = ClientLetter.list().size()+1;
  
			 if(counter >= 1 && counter < 10){
			  dynamicNumber = "000"+counter.toString();
			 }else if(counter> 10 && counter < 100){
	 
				 dynamicNumber = "00"+counter.toString();
			 }
			 else if(counter > 100 && counter < 1000){
	 
				 dynamicNumber = "0"+counter.toString();
			 }
			 else if(counter > 1000 && counter < 10000){
	 
				 dynamicNumber = counter.toString();
			 }
		 
		 LocalDate today = LocalDate.now();
		 int month = today.getMonthValue();
		 int currentYear = today.getYear();
		 
		 String subCurrentYear = currentYear.toString().substring(2);
		 
		 int previousYear = Integer.parseInt(subCurrentYear) -1;
		 int nextYear = Integer.parseInt(subCurrentYear) +1;
		 
	 
		 if(month >= 4){
			 
			 dynamicLetterNumber = "NBA/IN/"+ appNumber.substring(9)+"/"+subCurrentYear+"-"+nextYear+"/"+dynamicNumber;
			 
			 }
		 else{
			 dynamicLetterNumber = "NBA/IN/"+ appNumber.substring(9)+"/"+previousYear+"-"+subCurrentYear+"/"+dynamicNumber;
			 
			 }
			 return dynamicLetterNumber;
		  }
	  
   def getSBBDynLetterNumberApplicantOut(String appNumber){
	   String dynamicLetterNumber = "", dynamicNumber;
	   
	   
	   def currentUser  = springSecurityService.getCurrentUser().username
	   def 	userIns = NbaUser.findByUsername(currentUser)
	   String sbbName = userIns.name
		  
	   
	   def countletter = ClientLetter.list().size();
   
		def counter = countletter+1;

		 if(counter >= 1 && counter < 10){
			dynamicNumber = "000"+counter.toString();
		   }else if(counter> 10 && counter < 100){
   
			   dynamicNumber = "00"+counter.toString();
		   }
		   else if(counter > 100 && counter < 1000){
   
			   dynamicNumber = "0"+counter.toString();
		   }
		   else if(counter > 1000 && counter < 10000){
   
			   dynamicNumber = counter.toString();
		   }
	   
	   LocalDate today = LocalDate.now();
	   int month = today.getMonthValue();
	   int currentYear = today.getYear();
	   
	   String subCurrentYear = currentYear.toString().substring(2);
	   
	   int previousYear = Integer.parseInt(subCurrentYear) -1;
	   int nextYear = Integer.parseInt(subCurrentYear) +1;
	  
   
	   if(month >= 4){
		   
		   dynamicLetterNumber = sbbName+"/OT/"+subCurrentYear+"-"+nextYear+"/"+dynamicNumber;
		   
		   }
	   else{
		   dynamicLetterNumber = sbbName+"/OT/"+previousYear+"-"+subCurrentYear+"/"+dynamicNumber;
		   
		   }
		   return dynamicLetterNumber;
	   
   }
   
   
	def letterTempleteDropDn(){
		
		def result = LetterTemplate.createCriteria().list {

		projections { property('letterName') } 
		
	}
		return result
	}
	
	
	def dynamicPdfConverter(ApplicationForm1 appForm1, LetterCommunication letterInstance,String dynamicFileName) throws Exception{
		
		ByteArrayOutputStream  bytesPdf = null;
   
		if(dynamicFileName == 'TR5_Letter'){
			 bytesPdf = pdfRenderingService.render(template: "/letterCommunication/tr5DynamicPdf", model: [body:letterInstance,letterName:dynamicFileName], filename: dynamicFileName + letterInstance.id)

		}else{

			  bytesPdf = pdfRenderingService.render(template: "/letterCommunication/commDynamicPdf", model: [body:letterInstance,appForm1:appForm1,letterName:dynamicFileName], filename: dynamicFileName + letterInstance.id)
		}
		
				
				new File(grailsApplication.config.pdfFileAttachedPath.toString() + File.separatorChar + letterInstance?.appNumber).mkdirs()
				String filePath = grailsApplication.config.pdfFileAttachedPath.toString() + File.separatorChar + letterInstance?.appNumber + File.separatorChar + dynamicFileName + letterInstance.id+".pdf"
				
				letterInstance.bodyPdfName = dynamicFileName + letterInstance.id+".pdf";
     			letterInstance.bodyPdfUrl = filePath;
				

					OutputStream getPdf = null;
				try{
					getPdf = new FileOutputStream(filePath)
					bytesPdf.writeTo(getPdf);
					getPdf.close()
					bytesPdf.close()
				}catch(Exception e){
					println e
				}
			}
		

	def letterExistsToSBB(ApplicationForm1 appInstance,LetterCommunication ltrIns){

		def message

		def entryCheck = SBBConsent.findBySbbUserNameAndAppNumberAndResponceStatus(NbaUser.findByEmail(ltrIns?.emailId)?.username , appInstance?.appNumber,true)
		if(entryCheck){
			message = Constants.SBB_CONSENT_CONF
			return message;
		}else{
			message = Constants.SBB_CONSENT_NEW
			return message;
		}
	}
	
	
	def mapSbbValue(ApplicationForm1 appInstance,LetterCommunication ltrIns){
		SBBConsent sbbIns = new SBBConsent()

		sbbIns.sbbUserName = NbaUser.findByEmail(ltrIns?.emailId)?.username
		sbbIns.responceStatus = true
		sbbIns.applicationForm1 = appInstance
		sbbIns.appNumber = appInstance?.appNumber
		sbbIns.dynLetterNumber = ltrIns?.dynamicLetterNumberClientIN
		sbbIns.letterCreatedDate = ltrIns?.sendDate

		if(!sbbIns.save(flush:true)){
			sbbIns.errors.allErrors.each {print it}
		}
// set other details		
		SbbCommunication sbbcom = new SbbCommunication()
		
		 sbbcom.sendUser = springSecurityService.getCurrentUser()?.name
		 sbbcom.sendDate = new Date()
		 sbbcom.action = "Consultation"
		 sbbcom.application = appInstance
		 
		 if(!sbbcom.save(flush:true)){
			 sbbcom.errors.allErrors.each {print it}
		 }
		 
	}
	
	
	public void setCommunicationStatusForNBA(ApplicationForm1 appForm1){
		
	      appForm1.currentStatus.communicationStatus  = true;	
		  println"setting Value"
		  appForm1.save(flush:true)
		  
		
	}
	
	
	public void setCommunicationStatusForApplicant(ApplicationForm1 appForm1){
		
		  appForm1.currentStatus.commStatusApplicant  = true;
		  println"setting Value"
		  appForm1.save(flush:true)
		  
		
	}
	
  
}
