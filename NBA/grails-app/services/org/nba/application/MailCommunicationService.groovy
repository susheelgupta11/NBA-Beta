package org.nba.application

import grails.transaction.Transactional

import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.security.cert.X509Certificate
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSession
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import javax.net.ssl.HttpsURLConnection

import org.codehaus.groovy.grails.core.io.ResourceLocator
import org.nba.communication.Agenda
import org.nba.communication.AgendaLetterStatus
import org.nba.communication.LetterCommunication
import org.nba.communication.PdfFileAttachment
import org.nba.user.NbaUser
import org.nba.user.RoleEnum


@Transactional
class MailCommunicationService {
	def mailService
	def grailsApplication
	def pdfRenderingService
	def springSecurityService

	ResourceLocator grailsResourceLocator
	
		def getCCList(){
		return NbaUser.where{ nbaRole.authority != RoleEnum.Role.APPLICANT &&  nbaRole.authority != RoleEnum.Role.SBB}.list()
		 }
		
		def getSbbEmail(){
			
			return NbaUser.where{nbaRole.authority == RoleEnum.Role.SBB}.list()
		}
	
	def sentLetterEmail(LetterCommunication comfmt){
		
		println"In mail send section"
		
//		String noHTML = comfmt.messageBody.replaceAll("\\<.*?>","");
		mailService.sendMail {
			multipart true
			
			from  "info.nba@gov.in"
			
			to comfmt?.emailId
			cc comfmt?.ccEmailId
			
			subject comfmt?.subject
			html (view: '/letterCommunication/commBodyForMail', model:[emailInstance:comfmt,appForm1:comfmt?.applicationForm1])
			comfmt?.pdfFileAttachments.each { itis->
			attach (new File(itis.attachedUrl))
			}
		}
	}
	
	
	
	def sentTr5Email(LetterCommunication tr5ReceiptInstance ,ApplicationForm1 formDetails){
	 ByteArrayOutputStream  bytesPdf = pdfRenderingService.render(template: "/letterCommunication/eReceiptPdfForMail",model:[tr5ReceiptInstance:tr5ReceiptInstance,formDetails:formDetails])

		mailService.sendMail {
			multipart true
			
			from "info.nba@gov.in"
			
			to tr5ReceiptInstance?.emailId
			cc tr5ReceiptInstance?.ccEmailId
			
			subject tr5ReceiptInstance.subject
		    html(view: '/letterCommunication/eReceiptForMail', model:[tr5ReceiptInstance:tr5ReceiptInstance,formDetails:formDetails])
			
			attach ("Tr5Receipt", "application/pdf",  bytesPdf.toByteArray())
			
		}
	}
	
	
	def sentSbbLetterEmail(LetterCommunication sbbConsentInstance){
		
		ByteArrayOutputStream  bytesPdf = pdfRenderingService.render(template: "/letterCommunication/eReceiptForSbb",model:[sbbConsentInstance:sbbConsentInstance])
		
				mailService.sendMail {
					multipart true
					
					from "info.nba@gov.in"
					to sbbConsentInstance?.emailId
					cc sbbConsentInstance?.ccEmailId
				
					subject sbbConsentInstance.subject
					html(view: '/letterCommunication/commBodyForMail', model:[emailInstance:sbbConsentInstance])
					//html sbbConsentInstance?.messageBody
					attach ("SBB_Communication.pdf", "application/pdf",  bytesPdf.toByteArray())
					
				}
	     }
	
	
	
	def tr5bodyMessageAttachmentPdf(ApplicationForm1 formDetails,LetterCommunication tr5ReceiptInstance){
		
	String fileName = Long.toString(tr5ReceiptInstance?.id) +"tr5body.pdf"
		
	def file = pdfRenderingService.render([template: '/report/report', model: [tr5ReceiptInstance:tr5ReceiptInstance,formDetails:formDetails]], new File(fileName).newOutputStream())
		
	}


		def setAgendaStatus( agendaInstance,AgendaLetterStatus.AgendaLtrStatus sts){
		
		def agendaLetterInstance
	
			if(agendaInstance != null){
					agendaLetterInstance = Agenda.get(agendaInstance)
			}
  
		  def	agendalettersts =  AgendaLetterStatus.where{
				agenda == agendaLetterInstance
			}.find()
		
	
			if(agendalettersts == null || agendalettersts == ''){
				agendalettersts = new AgendaLetterStatus(agdltrstatus:sts,agenda:agendaLetterInstance,statusChangedBy:springSecurityService.currentUser)
			}else{
				agendalettersts.agdltrstatus = sts
				agendalettersts.statusChangedBy = springSecurityService.currentUser
			
			}
			
			if(!agendalettersts.save(flush:true)){
				agendalettersts.errors.allErrors.each {print it}
			}
			return agendalettersts
		}
	
}
