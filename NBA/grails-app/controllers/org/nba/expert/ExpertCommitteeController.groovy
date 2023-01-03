package org.nba.expert

import grails.converters.JSON

import org.hibernate.SessionFactory
import org.nba.application.ApplicationForm1
import org.nba.communication.Agenda
import org.nba.communication.AgendaLetterStatus
import org.nba.communication.ParentAgenda
import org.nba.communication.Recommendation
import org.nba.review.AddNote
import org.nba.user.NbaUser
import org.springframework.security.access.annotation.Secured

import com.lowagie.text.DocumentException
import com.nba.constant.Constants



@Secured('permitAll')
class ExpertCommitteeController {

	SessionFactory sessionFactory;
	def filePDFService
	def pdfRenderingService
	def grailsApplication
	def springSecurityService
	
	def meetingDpDn = Constants.MEETING
	
	
    def expertDash() { 
		
	def csrfPreventionSalt = params.csrfPreventionSalt
	def agendaDetails = ParentAgenda.list()
	
	def sendAgendaDetails

   agendaDetails.each { ad->
	sendAgendaDetails = Agenda.where{ 
		agendaLetterStatus.agdltrstatus == AgendaLetterStatus.AgendaLtrStatus.LETTER_SEND && parentAgenda == ad
		
		}.list()
	
	}
 
  [agendaDetails:agendaDetails,csrfPreventionSalt:csrfPreventionSalt]	
		
	}
	
	
	def expertCom() {
		
	def csrfPreventionSalt = params.csrfPreventionSalt
	def agendaDetails = ParentAgenda.where{	agendaName == Constants.MEET_1}.list()
	 render (view:'expertDash',model: [agendaDetails:agendaDetails,csrfPreventionSalt:csrfPreventionSalt,type:'Expert Committee']) 
	}
	
	
	def nbaSec() {
		
	def csrfPreventionSalt = params.csrfPreventionSalt
	def agendaDetails = ParentAgenda.where{ agendaName == Constants.MEET_4}.list()
	 render (view:'expertDash',model: [agendaDetails:agendaDetails,csrfPreventionSalt:csrfPreventionSalt,type:'NBA Secretariat']) 
		
	}
	
def authority() {
		
	def csrfPreventionSalt = params.csrfPreventionSalt

	def agendaDetails = ParentAgenda.where{ agendaName == Constants.MEET_2}.list()
	 render (view:'expertDash',model: [agendaDetails:agendaDetails,csrfPreventionSalt:csrfPreventionSalt,type:'Authority']) 
		
	}
	
def internalCom() {
		
	def csrfPreventionSalt = params.csrfPreventionSalt

	def agendaDetails = ParentAgenda.where{ agendaName == Constants.MEET_3}.list()
	 render (view:'expertDash',model: [agendaDetails:agendaDetails,csrfPreventionSalt:csrfPreventionSalt,type:'Internal Committee']) 
		
	}
	
	
	def agendaSendDetails(){
	
	def csrfPreventionSalt = params.csrfPreventionSalt
	
	def baseDetails = ParentAgenda.get(Long.parseLong(params.detId))
	
	def agendaDetails = Agenda.where{
		
		parentAgenda == baseDetails && agendaLetterStatus.agdltrstatus == AgendaLetterStatus.AgendaLtrStatus.LETTER_SEND
		
		}.list()	
		
	[agendaDetails:agendaDetails,csrfPreventionSalt:csrfPreventionSalt]	
	}
	
	
	def pdfAgendaDownload(){
		def csrfPreventionSalt = params.csrfPreventionSalt
		def agendaInstance = Agenda.get(Long.parseLong(params.downId))
		
		def file = new File(agendaInstance?.agendaPdfUrl)
		response.setContentType("application/pdf")
		response.setHeader("Content-disposition","attachment; filename=${file.getName()}")
		response.outputStream << file.newInputStream()
		
	}
	
	def wordAgendaDownload(){

		def csrfPreventionSalt = params.csrfPreventionSalt
		def agendaInstance = Agenda.get(Long.parseLong(params.downId))
		
		def file = new File(agendaInstance?.agendaPdfUrl)
		def fileName = agendaInstance?.agendaPdfName
		
		response.setContentType("APPLICATION/OCTET-STREAM")
		response.setHeader("Content-Disposition", "Attachment;Filename=\"${fileName}\"")
		def fileInputStream = new FileInputStream(file)
		def outputStream = response.getOutputStream()
		byte[] buffer = new byte[4096];
		int len;
		while ((len = fileInputStream.read(buffer)) > 0) {
			outputStream.write(buffer, 0, len);
		}
		response.outputStream << file.newInputStream()
		//   outputStream.flush()
		outputStream.close()
		fileInputStream.close()

	}
	
	def agendaDownloadAll(){
		
		def csrfPreventionSalt = params.csrfPreventionSalt
		
		def baseDetails = ParentAgenda.get(Long.parseLong(params.dwnId))
		def agendaDetails = Agenda.where{
			
	     parentAgenda == baseDetails && agendaLetterStatus.agdltrstatus == AgendaLetterStatus.AgendaLtrStatus.LETTER_SEND
			
			}.list()
		
			List<InputStream> lis = new ArrayList<InputStream>();
			try {
				agendaDetails.each {
				lis.add(new FileInputStream(new File(it?.agendaPdfUrl)));
				}

				byte [] fileBytes = filePDFService.doAgendaMerge(lis);
				response.setContentType("application/pdf");
				response.setHeader("Content-disposition", "attachment; filename=Agenda-all.pdf")
				response.setContentLength(fileBytes.length)
				response.getOutputStream().write(fileBytes)
				response.outputStream.flush()
	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (DocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
  
	def recommDwnloadAll(){
		
		def csrfPreventionSalt = params.csrfPreventionSalt
		
		def baseDetails = ParentAgenda.get(Long.parseLong(params.dwnId))
		def agendaDetails = Agenda.where{
			
		 parentAgenda == baseDetails && recoStatus == true
			
			}.list()
		
			List<InputStream> lisp = new ArrayList<InputStream>();
			try {
				agendaDetails.each {iny ->
	ByteArrayOutputStream   bytesPdf = pdfRenderingService.render(template: "/expertCommittee/recommendation", model: ['agendaInstance': iny,csrfPreventionSalt:csrfPreventionSalt])
	InputStream is = new ByteArrayInputStream(bytesPdf.toByteArray());
	      lisp.add(is)
            }
				byte [] fileBytes = filePDFService.doAgendaMerge(lisp);
				response.setContentType("application/pdf");
				response.setHeader("Content-disposition", "attachment; filename=Recomm-all.pdf")
				response.setContentLength(fileBytes.length)
				response.getOutputStream().write(fileBytes)
				response.outputStream.flush()
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (DocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	

	 def saveRecommendation(){
	
	 def csrfPreventionSalt = params.csrfPreventionSalt
     def agendaDetails = Agenda.get(Long.parseLong(params.agenId))
    
    agendaDetails.whetherTraditional = params.whetherTraditional
	agendaDetails.screeningBiores = params.screeningBiores
	agendaDetails.rareEndemic = params.rareEndemic
	agendaDetails.wildlifeAct = params.wildlifeAct
	agendaDetails.restricted = params.restricted
	agendaDetails.originalFile = params.originalFile
	agendaDetails.proposal = params.proposal
	agendaDetails.anyOther = params.anyOther
	agendaDetails.expertView = params.expertView
	agendaDetails.recoStatus = true
	agendaDetails.parentAgenda.recoCounter = getRecoCounter(agendaDetails)
	
	if(!agendaDetails.save(flush:true)){
	agendaDetails.errors.allErrors.each {print it}	
		}

redirect(action:'agendaSendDetails', params:[detId:agendaDetails?.parentAgenda?.id,csrfPreventionSalt:csrfPreventionSalt])		
	
	}

		
	public int getRecoCounter(Agenda agendaIns)	{

		def meetingNum = agendaIns.parentAgenda
		def sendCounter = Agenda.where{
			parentAgenda == meetingNum && recoStatus == true
		}.list().size()+1;
		return sendCounter;
	}
	
	
	def recomDownload (){
		
		def filename = 'Recommendation'+params.downId + '.pdf'
		 def csrfPreventionSalt = params.csrfPreventionSalt
		 def agendaInstance = Agenda.get(Long.parseLong(params.downId))
		 ByteArrayOutputStream  bytesPdf = pdfRenderingService.render(template: "/expertCommittee/recommendation", model: ['agendaInstance': agendaInstance,csrfPreventionSalt:csrfPreventionSalt])
		 byte [] fileBytes = bytesPdf.toByteArray()
		 response.setContentType("application/pdf");
		 response.setHeader("Content-disposition", "attachment; filename=${filename}")
		 response.setContentLength(fileBytes.length)
		 response.getOutputStream().write(fileBytes)
		 response.outputStream.flush()
	}
		
	def addReco(){
		
		def message = params.message
		def csrfPreventionSalt = params.csrfPreventionSalt
		
		def recoDetails = Agenda.where{
			agendaLetterStatus.agdltrstatus == AgendaLetterStatus.AgendaLtrStatus.LETTER_SEND
			
			}.list()
			
			
			println"recoDetails"+recoDetails
			
			Set<String> recoSet = new HashSet<String>();
			for (Agenda x : recoDetails)
				recoSet.add(x.meetingNum);
				
			println"recoSet"+recoSet
		
	[meetingDpDn:meetingDpDn, recoDetails:recoSet,message:message,csrfPreventionSalt:csrfPreventionSalt]	
	}
	
	
	def getApplicationNum(){
		
//		def meetId = params.meetingId
//		println "inside meeting number"+meetId
//		def meetingNum = Agenda.get(Long.parseLong(meetId))?.meetingNum
		def appNumDetails = Agenda.findAllByMeetingNum(params.meetingId)
		List<String> appNum = new ArrayList<String>();
		
		def setNum = appNumDetails.each {
		appNum.add(it.appNumber)
	}
		println "Susheel"+appNum
		println "ram"+setNum
//		def result = [appNumber:appNum]
		render appNum as JSON
		
	}
	
     def saveRecommDetails(){
		
		def  csrfPreventionSalt = params.csrfPreventionSalt
      def recoObject = new Recommendation( meetingNameReco:params.meetingNameReco, checkReco:params. checkReco,
	 meetingNumberReco:params.meetingNumberReco,purposeReco:params.purposeReco )
	
	   
	   String[] values = params.selectedApp.split(",");
		ArrayList appN = new ArrayList(Arrays.asList(values));
		
		recoObject.appNumReco = appN
		
		
						
	   def relevantFile =  request.getFile('recoFile')
	
	  if(relevantFile != null && relevantFile?.getBytes()?.size() != 0 ){
	
		def rename;
		new File(grailsApplication.config.fileForRecommendation.toString() + File.separatorChar + "Reco" ).mkdirs()
		def filePath = new File( grailsApplication.config.fileForRecommendation.toString() + File.separatorChar + "Reco" + File.separatorChar + relevantFile.getOriginalFilename() )
		def exists = filePath.exists();
		if(exists == true){
			rename = Recommendation.count().toString()

			filePath = new File( grailsApplication.config.fileForRecommendation.toString() + File.separatorChar + "Reco" + File.separatorChar + rename + relevantFile.getOriginalFilename() )
		}
		relevantFile.transferTo(filePath)

		recoObject.fileNameReco = relevantFile.getOriginalFilename();
		recoObject.filePathReco = filePath;
		
		 }
	if(!recoObject.save(flush:true)){
		recoObject.errors.allErrors.each {print it}
		}
	
	// adding Noting concept--Susheel
	
	def getcurrentUserDetails = NbaUser.findByUsername(springSecurityService?.getCurrentUser().username)
   
	       for(int i=0; i<appN.size() ; i++){
			   
		   println "Gupta"+appN.get(i)
		
		def getApp = ApplicationForm1.findByAppNumber(appN.get(i))
		 println"Application Number"+getApp
		
		AddNote addobj = new AddNote()
		
		addobj.formNumber = appN.get(i)
		
		if(params.checkReco == 'Recommendation')
		addobj.comments =   "The application is placed in "+ recoObject.meetingNumberReco+" "+recoObject.meetingNameReco+"  and recommended for approval"
		else
		addobj.comments =   "The application is placed in "+ recoObject.meetingNumberReco+" "+recoObject.meetingNameReco+"  and recommended for not approval"
		
		addobj.notedUser = getcurrentUserDetails?.name
		addobj.noteDate = new Date()
		addobj.applicationForm1 = getApp
		if(!addobj.save(flush:true)){
			addobj.errors.allErrors.each {print it}
		}
	 }
	redirect(action:'addReco', params:[message: "Recommendation added successfully",csrfPreventionSalt:csrfPreventionSalt])
	}	
}