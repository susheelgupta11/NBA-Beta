package org.nba.communication

import grails.converters.JSON
import groovy.sql.Sql

import org.hibernate.SessionFactory
import org.nba.application.ApplicationForm1
import org.nba.resource.BiologicalResource
import org.nba.review.FormRemark
import org.nba.user.NbaUser
import org.springframework.security.access.annotation.Secured

import com.nba.constant.Constants

@Secured('permitAll')
class AgendaController {
def applicationNotingService
def mailCommunicationService
def springSecurityService	
def grailsApplication
def otpService
SessionFactory sessionFactory;


def meetingName = Constants.MEETING

 String draftMsg = Constants.LETTER_DRAFTED
 String updMsg = Constants. LETTER_UPDATED
 String approvedMsg = Constants.LETTER_APPROVED
 String sendMsg  = Constants.LETTER_SEND
 
 
def createAgenda(){
		
	def csrfPreventionSalt = params.csrfPreventionSalt
	def formId = params.instance
	def agendaIns = params.agendaInstance
	def agendaInstance,techChecklist,legalChecklist
	def message = params.message
	
	
		if(agendaIns != null || "" != agendaIns ){

			agendaInstance = Agenda.get(agendaIns as Long)
		}

		if(formId == "" || formId == null){

			flash.message = "Please select an application"
			redirect(controller:'dashboard', action:'dashboard')
			return;
		}

		
			
		def formDetails = ApplicationForm1.get(formId)
		
		List<String> type = new ArrayList<String>();
		
		formDetails.formremarks?.each{type.add(it.checklistType)}
		println"ooooooo"+type
		
		if(formDetails.formremarks.size() > 2 && ( type.contains('TECHNICAL') && type.contains('LEGAL'))){
			techChecklist = FormRemark.where{checklistType =='TECHNICAL' && applicationForm1 == formDetails}.list()?.get(0);
			legalChecklist = FormRemark.where{checklistType =='LEGAL' && applicationForm1 == formDetails}.list()?.get(0);
			
		}else if(type.contains('TECHNICAL') && type.contains('LEGAL')){
			techChecklist = FormRemark.where{checklistType =='TECHNICAL' && applicationForm1 == formDetails}.find();
			legalChecklist = FormRemark.where{checklistType =='LEGAL' && applicationForm1 == formDetails}.find();
		}
	
		println "llllllllllllllll"+legalChecklist
		println "kkkkkkkkkkkkkkkk"+techChecklist
		
             if(techChecklist == '' || null == techChecklist || legalChecklist == '' || null == legalChecklist){
		redirect(controller:'dashboard', action:'dashboard' , params:[message:'Please Complete Technical or Legal Checklist First'])
			return;
		 
		 }
			 
			 // NTC part
			 
			 Sql sql = new Sql(sessionFactory.currentSession.connection())
			 String queryNtc = Constants.NTC
			 def ntc = sql.rows(queryNtc);
			 
			 println"jjj"+ntc
			 
				 def bioAll = BiologicalResource.where{applicationForm == formDetails}.list()
				 List<String> bio = new ArrayList<String>()
				 
				 bioAll.each{
					 bio.add(it.scientificName)
				 }
			   println"listofbio"+bio
			   def rare = null
			for(int i=0; i<bio.size();i++){
			  rare = ntc.findAll{it.bio_resource == bio.get(i)}
		 
			  println"ree"+rare
			}	 
			 
		def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)
		def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()
		
		
		[formDetails:formDetails,techChecklist:techChecklist,legalChecklist:legalChecklist,dropDnValues:dropDnValues,csrfPreventionSalt:csrfPreventionSalt,message:message,
			allDataforMatching:allDataforMatching,meetingName:meetingName,agendaInstance:agendaInstance,rare:rare]
	}
	
	
	def saveAgenda(){
	def getFormId = params.instance
	def csrfPreventionSalt = params.csrfPreventionSalt
	def formDetails = ApplicationForm1.get(getFormId as Long)
	def currentUser = springSecurityService.getCurrentUser().username
	def userName = NbaUser.findByUsername(currentUser)?.name
	def baseAgenda

		def checkAgenda = ParentAgenda.findByAgendaCounterAndAgendaName(Integer.parseInt(params.meetingNum),params.meetingName)

		if(checkAgenda instanceof org.nba.communication.ParentAgenda){

			baseAgenda = ParentAgenda.findByAgendaCounter(Integer.parseInt(params.meetingNum))
		}else{


			baseAgenda = new ParentAgenda()
			baseAgenda.agendaCounter = Integer.parseInt(params.meetingNum)
			baseAgenda.agendaName = params.meetingName
			baseAgenda.meetingDate = new Date()
			if(!baseAgenda.save(flush:true)){
				baseAgenda.errors.allErrors.each {print it}
			}
		}
	
	def agendaInstance = new Agenda(remarkByNba:params.remarkByNba,thirdpartyPurpose:params.thirdpartyPurpose,quantityeBio:params.quantityeBio,
		gioLoction:params.gioLoction,commonOrScientificName:params.commonOrScientificName,speciesName:params.speciesName,natureBio:params.natureBio,applicationFee:params.applicationFee,
		individualOrEntity:params.individualOrEntity,formType:params.formType,name:params.name,address:params.address,
		recommendationSbb:params.recommendationSbb,	 sbbbmc:params.sbbbmc,refNo:params.refNo, receiptTimeTaken:params.receiptTimeTaken,
	 inordinateDelay:params.inordinateDelay,whetherListNTC:params.whetherListNTC, alreadyExpEC:params.alreadyExpEC, prescribedApplication:params.prescribedApplication,
	  actiontaken:params.actiontaken, meetingName:params.meetingName, meetingNum:params.meetingNum, fromDate:params.fromDate,
	 toDate:params.toDate, dynamicMeetNum:params.dynamicMeetNum,approvalNBA:params.approvalNBA)
	
	if(params.meetingName == Constants.MEET_4){
		agendaInstance.recommendationByNba = params.recommendationByNba
		}
	
	   agendaInstance.applicationForm1 = formDetails
	   agendaInstance.parentAgenda = baseAgenda
	   agendaInstance.appNumber = formDetails?.appNumber
	   agendaInstance.createdBy = userName
	   agendaInstance.createDate = new Date()
	  
	   if(!agendaInstance.save(flush:true)){
		agendaInstance.errors.allErrors.each {print it}   
	   }
	   def agendaStatus = mailCommunicationService.setAgendaStatus(agendaInstance?.id, AgendaLetterStatus.AgendaLtrStatus.LETTER_CREATED)
	  def addUserSignatre = otpService.setAgendaSignature("Create", agendaInstance)
	    redirect(action:'createAgenda', params:[message:draftMsg,instance:formDetails?.id,agendaInstance:agendaInstance?.id, csrfPreventionSalt:csrfPreventionSalt])
	}
	
	
	def agendaDraft(){
		
		def getFormId = params.instance
		def csrfPreventionSalt = params.csrfPreventionSalt
		
		def formDetails = ApplicationForm1.get(getFormId as Long)
		def agendaInstance =  Agenda.where{
			applicationForm1 == formDetails && agendaLetterStatus.agdltrstatus == AgendaLetterStatus.AgendaLtrStatus.LETTER_CREATED
		}
		
		def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)
		def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()

		
		[formDetails:formDetails,agendaInstance:agendaInstance,allDataforMatching:allDataforMatching,
			dropDnValues:dropDnValues,csrfPreventionSalt:csrfPreventionSalt]
	}
	
	
	def agendaApprove(){
		def getFormId = params.instance
		def csrfPreventionSalt = params.csrfPreventionSalt
		
		def formDetails = ApplicationForm1.get(getFormId as Long)
		def agendaInstance =  Agenda.where{
			applicationForm1 == formDetails && agendaLetterStatus.agdltrstatus == AgendaLetterStatus.AgendaLtrStatus.LETTER_APPROVED
		}
		
		def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)
		def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()
		
		[formDetails:formDetails,agendaInstance:agendaInstance,allDataforMatching:allDataforMatching,
			 dropDnValues:dropDnValues,csrfPreventionSalt:csrfPreventionSalt]
	}
	
	def editAgenda(){
	
	def getEditId = params.editId
	def getFormId = params.formId
	def csrfPreventionSalt = params.csrfPreventionSalt
	def status = params.status
   def techChecklist,legalChecklist
	
	def formDetails = ApplicationForm1.get(getFormId as Long)
	def agendaInstance = Agenda.get(getEditId as Long)
	
	def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)
	
	List<String> type = new ArrayList<String>();
		
		formDetails.formremarks?.each{type.add(it.checklistType)}
		println"ooooooo"+type
		
		if(formDetails.formremarks.size() > 2 && ( type.contains('TECHNICAL') && type.contains('LEGAL'))){
			techChecklist = FormRemark.where{checklistType =='TECHNICAL' && applicationForm1 == formDetails}.list()?.get(0);
			legalChecklist = FormRemark.where{checklistType =='LEGAL' && applicationForm1 == formDetails}.list()?.get(0);
			
		}else if(type.contains('TECHNICAL') && type.contains('LEGAL')){
			techChecklist = FormRemark.where{checklistType =='TECHNICAL' && applicationForm1 == formDetails}.find();
			legalChecklist = FormRemark.where{checklistType =='LEGAL' && applicationForm1 == formDetails}.find();
		}
	
	
	def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()
	
	[formDetails:formDetails,meetingName:meetingName,agendaInstance:agendaInstance,techChecklist:techChecklist,dropDnValues:dropDnValues,
	legalChecklist:legalChecklist,allDataforMatching:allDataforMatching,status:status,message : params.message]
	
	}
	 
	def updateAgenda(){

		def csrfPreventionSalt = params.csrfPreventionSalt
		def updateAgendaSts =  otpService.agendaUpdate(params, "update")
		if(updateAgendaSts instanceof org.nba.communication.Agenda ){
			def agendaStatus = mailCommunicationService.setAgendaStatus(updateAgendaSts?.id, AgendaLetterStatus.AgendaLtrStatus.LETTER_CREATED)
			def addUserSignatre = otpService.setAgendaSignature("Updated", updateAgendaSts)
			redirect(action:'editAgenda', params:[message:updMsg,formId:params.instance,editId:updateAgendaSts?.id, csrfPreventionSalt:csrfPreventionSalt,status:params.sts])
		}
	}
	
	
	def sendForApproval(){
		def csrfPreventionSalt = params.csrfPreventionSalt
		def updateAgendaSts =  otpService.agendaUpdate(params, "approve")
		if(updateAgendaSts instanceof org.nba.communication.Agenda ){
		}
		def agendaStatus = mailCommunicationService.setAgendaStatus(updateAgendaSts?.id, AgendaLetterStatus.AgendaLtrStatus.LETTER_APPROVED)
		def addUserSignatre = otpService.setAgendaSignature("Draft", updateAgendaSts)
		redirect(action:'editAgenda', params:[message:approvedMsg,formId:params.instance,editId:updateAgendaSts?.id, csrfPreventionSalt:csrfPreventionSalt])
	}
   
	def sendAgendaEC(){
	
		def csrfPreventionSalt = params.csrfPreventionSalt
		def updateAgendaSts =  otpService.agendaUpdate(params, "approve")
		if(updateAgendaSts instanceof org.nba.communication.Agenda ){
			updateAgendaSts.parentAgenda.agendasentCounter = getSentCounter(updateAgendaSts)
			updateAgendaSts.save(flush:true)
		}
		
		def formDetails = ApplicationForm1.get(Long.parseLong(params.instance))
		
		def dynamicAgendaPdf = otpService.dynamicAgendaPdfConverter(updateAgendaSts, formDetails)
		
		def agendaStatus = mailCommunicationService.setAgendaStatus(updateAgendaSts?.id, AgendaLetterStatus.AgendaLtrStatus.LETTER_SEND)
		
		def addUserSignatre = otpService.setAgendaSignature("Approved", updateAgendaSts)
		redirect(action:'editAgenda', params:[message:approvedMsg,formId:params.instance,editId:updateAgendaSts?.id, csrfPreventionSalt:csrfPreventionSalt])
	
	
	}
	
	def forwardAgendaWithApplication(){
		
	 def csrfPreventionSalt = params.csrfPreventionSalt
	 def msg = 'File forward successfully'
	 def instance = applicationNotingService.addNoteForApplication(params)
			  
	 if(instance instanceof org.nba.review.AddNote)
	 redirect(action:'noting', controller:'dashboard', params:[message:msg,instance:params.applicationInstance,csrfPreventionSalt:csrfPreventionSalt])
	  return;
		
	}
	

	
		def downloadAgendaInDoc(){
		
//		def docId = params.docId
//		ByteArrayOutputStream  bytesPdf = pdfRenderingService.render(template: "/letterCommunication/commDynamicPdf", model: [body:letterInstance,letterName:dynamicFileName], filename: dynamicFileName + letterInstance.id)
//		new File(grailsApplication.config.docFileForAgenda.toString() + File.separatorChar + docId?.toString() ).mkdirs()
//		def filePath = new File( grailsApplication.config.docFileForAgenda.toString() + File.separatorChar + docId?.toString() + File.separatorChar + 'Agenda_Doc'+docId.toString() )
//		def exists = filePath.exists();
//		
//		def docFile = new File()
	}
		
	def printableAgenda(){
		def csrfPreventionSalt = params.csrfPreventionSalt
		def formDetails = ApplicationForm1.get(Long.parseLong(params.formId))
		def agendaInstance = Agenda.get(Long.parseLong(params.printId))
		render(view:'/agenda/printablePage' , model:[csrfPreventionSalt:csrfPreventionSalt,formDetails:formDetails,agendaInstance:agendaInstance])
		}
	
 def dynamicAgendaShowPdf(){
	 def csrfPreventionSalt = params.csrfPreventionSalt
	 def detailsForFile = Agenda.get(params?.dynamicId)
	 def file = new File(detailsForFile?.agendaPdfUrl)
	 response.setContentType("application/pdf")
	 response.setHeader("Content-disposition","filename=${file.getName()}")
	 response.outputStream << file.newInputStream()
	 }	
	
	def getMeetDyNumber(){

		def getexitMeeting = ParentAgenda.findAllByAgendaCounter(params.meetNumber as int)

		def result = [dynamicMeetNumber:getexitMeeting.size()+1]
		render result as JSON
	}
	
	
	public int getSentCounter(Agenda agendaIns)	{

		def meetingNum = agendaIns.parentAgenda
		def sendCounter = Agenda.where{
			parentAgenda == meetingNum && agendaLetterStatus.agdltrstatus == AgendaLetterStatus.AgendaLtrStatus.LETTER_SEND
		}.list().size()+1;
		return sendCounter;
	}
}


