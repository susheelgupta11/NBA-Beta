package org.nba.application


import grails.transaction.Transactional

import java.text.SimpleDateFormat

import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap
import org.nba.communication.LetterCommunication
import org.nba.master.KMS
import org.nba.master.SetMstrData
import org.nba.resource.BiologicalResource
import org.nba.resource.GeoLocationOfBioResource
import org.nba.resource.GeoLocationOfCommunity
import org.nba.resource.IPRDetail
import org.nba.resource.ThirdParty
import org.nba.review.AddNote
import org.nba.review.PdfFileUpload
import org.nba.user.NbaUser
import org.nba.user.RoleEnum
import org.nba.versions.VersionApplicationForm1
import org.nba.versions.VersionBiologicalResource
import org.nba.versions.VersionCompanyProfile
import org.nba.versions.VersionContactPerson
import org.nba.versions.VersionDepositionOfMicroOrganism
import org.nba.versions.VersionGeoLocationOfBioResource
import org.nba.versions.VersionIndianGovtInst
import org.nba.versions.VersionIndianResearcher
import org.nba.versions.VersionIndividualProfile
import org.springframework.util.StringUtils
import com.lowagie.text.pdf.PdfReader
import com.nba.constant.Constants
@Transactional
class ApplicationNotingService {
	def springSecurityService
	def grailsApplication


 public static boolean validateFileExtn(String fileName){
		
		
		List fileExtensions=["doc", "docx", "pdf"]
		println "--------in the service----------"

//		def extension = fileName?.substring(fileName?.lastIndexOf(".") + 1);
		
		def fextension = fileName.substring(fileName.indexOf(".")+1);
		
		return fileExtensions.contains(fextension);
		
		}
 
 
 public boolean validateFileContent(File file){
	 
	 PdfReader pdf = new PdfReader(file.getBytes())
	 println "In file content section"
	 
	 if(pdf && pdf.pdfVersion){return true;}else{return false;}
	 }


	public String checkFileValidation(pdfFileData){
		String message="";

		List notingFileList = pdfFileData

		println"In side file upload and size is "+notingFileList.size()
		notingFileList.each { file ->

			String fileName = file.getOriginalFilename().toString();
			println"file Name"+fileName

			if(fileName == "" || fileName == null){

				message = "Empty file not allowed"
				return message;
			}
			
			int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
			def nullByteCheck = file.getOriginalFilename().contains('%00')
			if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
				println '====================='
				message = "Wrong format of pdf"
				
			}
			if (occurance > 1) {
				println '###################'
				message = "Wrong format of pdf"
				
			}

			try {
				PdfReader pdf = new PdfReader(file.getBytes())
				if(pdf && pdf.pdfVersion){}
				else{
					message = "Wrong format of pdf"
					
				}
			}catch (Exception e){
				println e.message
				message = "Wrong format of pdf"
				

			}
		
			boolean validateFile = validateFileExtn(fileName);
//			boolean validatecontent = validateFileContent(file);

			println "validate status"+ validateFile
//			println "validate content"+ validatecontent

			if(validateFile == false && (message != null || message != "" )){

//				def extension = fileName?.substring(fileName.lastIndexOf("."));
//				message = " File with " +extension+"  are not allowed, upload .pdf/.doc/.docx format only!"
				message = "File validation fail"
			}else if(message == '' || message ==  null ){
			message = "Validate Successfully"
			}
		}
		return message
	}
   

	def addNoteForApplication(GrailsParameterMap params){

		ApplicationForm1 instanceForNote = ApplicationForm1.get(Long.parseLong(params?.applicationInstance))

		println "inside save note section +++++++++ service"
		println "instance_________"+params.applicationInstance

		def addNoteInstance = new AddNote()

		if(params.applicationInstance != "" || params.applicationInstance != null){
			def applicationNumber = params.applicationNumber
			def submittedDate  = params.applicationSubmitDate
			def formDetails = params.applicationInstance
			println "inside save note section "+params.applicationInstance


			if(params.statusUpdate != "" || params.priorities != "" || params.ckeditorData  != "" || params.actions != "" || params.forwardMember != ""){
				
                 println "forword user name"+params.forwardMember
				 
				def getForwardUserDetails = NbaUser.get(Long.parseLong(params?.forwardMember))

				def getcurrentUserDetails = NbaUser.findByUsername(springSecurityService?.getCurrentUser().username)
				def userRole = getForwardUserDetails.nbaRole?.authority
			
				println "username is"+getForwardUserDetails

				instanceForNote.currentStatus.changedBy = springSecurityService?.getCurrentUser()
				instanceForNote.currentStatus.sendByUser = getcurrentUserDetails?.name
				instanceForNote.currentStatus.currentDesk = getForwardUserDetails?.name
				instanceForNote.currentStatus.currentComment = params.ckeditorData
				instanceForNote.currentStatus.statusUpdate = params.statusUpdate
				instanceForNote.currentStatus.priority = params.priorities
				instanceForNote.currentStatus.actionFor =  params.actions
				instanceForNote.currentStatus.communicationStatus = false
				
				if(getForwardUserDetails?.answer == '' || null == getForwardUserDetails?.answer)
				   instanceForNote.currentStatus.forwardedUser = getForwardUserDetails?.username
				else
				   instanceForNote.currentStatus.forwardedUser = getForwardUserDetails?.answer
				
				instanceForNote.currentStatus.forwardedDate = new Date()
				
				if(params.linkOfficer == 'Yes')
				instanceForNote.currentStatus.linkOfficerCheck = true
				else
				instanceForNote.currentStatus.linkOfficerCheck = false
				
				def getExistUser = AddNote.findByFormNumberAndForwardMember(instanceForNote?.appNumber,getForwardUserDetails?.username)

				println"current Role =" +RoleEnum.Role.REVIEW_MEMBER
				println"equal to"+userRole
				
			if(getExistUser || userRole == "REVIEW_MEMBER"){
					
					instanceForNote.currentStatus.userCounter = false
				} else{
				
				instanceForNote.currentStatus.userCounter = true
				}
				try{
				if(params.statusUpdate == "Approved"){
					instanceForNote.currentStatus.status = AppStatus.Status.APPROVED
					
				}else if(params.statusUpdate == "Rejected"){
					instanceForNote.currentStatus.status = AppStatus.Status.REJECTED
					
//				}else if(getForwardUserDetails?.username == 'virtual'){
//				instanceForNote.currentStatus.status = AppStatus.Status.RECORD_ROOM
				
//				}else if(getForwardUserDetails?.nbaRole?.authority == RoleEnum.Role.SBB){
//				instanceForNote.currentStatus.status = AppStatus.Status.SBB_RES
				
				}else{
					instanceForNote.currentStatus.status = AppStatus.Status.IN_PROCESS
				}
				}catch(Exception e){
				println e
				}
				

				if(!instanceForNote.save(flush:true)){
					instanceForNote.errors.allErrors.each{print it}
				}

				addNoteInstance.applicationForm1 = instanceForNote
				addNoteInstance.comments = params.ckeditorData
				addNoteInstance.statusUpdate = params.statusUpdate
				addNoteInstance.actions = params.actions
				addNoteInstance.priorities = params.priorities
				addNoteInstance.forwardMember = getForwardUserDetails?.username
				addNoteInstance.formNumber = applicationNumber?:instanceForNote?.appNumber
				addNoteInstance.submitForm = submittedDate?:instanceForNote?.submittedOn
				if(params.linkOfficer == 'Yes')
				addNoteInstance.notedUser = "Link Officer -"+getcurrentUserDetails?.name 
				else
				addNoteInstance.notedUser = getcurrentUserDetails?.name
				
				addNoteInstance.noteDate = new Date()

				if (!addNoteInstance.save(flush: true)) {
					addNoteInstance.errors.allErrors.each {print it}
				}
			}

			println "addNoteInstance"+addNoteInstance
		}
		return addNoteInstance;
	}
		   
		   
		   
		   
   def boolean transferFile(notingFileList, String applicationNumber, AddNote addNoteInstance){
	   String rename = "", message = "";
	   notingFileList.each {file ->

		   new File(grailsApplication.config.pdfFilePath.toString() + File.separatorChar + applicationNumber ).mkdirs()
		   def filePath = new File( grailsApplication.config.pdfFilePath.toString() + File.separatorChar + applicationNumber + File.separatorChar + file.getOriginalFilename() )
		   def exists = filePath.exists();
		   if(exists == true){
			   rename = AddNote.count().toString()

			   filePath = new File( grailsApplication.config.pdfFilePath.toString() + File.separatorChar + applicationNumber + File.separatorChar + rename + file.getOriginalFilename() )
		   }
		   file.transferTo(filePath)

		   def pdfFileUploadInstance  = new PdfFileUpload()
		   pdfFileUploadInstance.addnote = addNoteInstance
		   pdfFileUploadInstance.fileName = rename + file.getOriginalFilename()
		   pdfFileUploadInstance.pathForFile = filePath
		   pdfFileUploadInstance.uploadingDate = new Date()
		   if(!pdfFileUploadInstance.save(flush:true)){
			   pdfFileUploadInstance.errors.allErrors.each {print it}
		   }
	   }
	 return true
   }
   
   
	def recordRoomTransfer(GrailsParameterMap params){

		def appDetails = ApplicationForm1.get(Long.parseLong(params.appId))
//		def appStatus = AppStatus.where{application == appDetails}.find()
		appDetails.currentStatus.forwardedUser = Constants.VIRTUAL_USER
		appDetails.currentStatus.actionFor = params.actions
		appDetails.currentStatus.reasonForRecordRoom =  params.reason
		
		
		def format = new SimpleDateFormat("dd/MM/yyyy HH:mm")
		appDetails.currentStatus.fromRecord = format.parse(params.fromDate)
		appDetails.currentStatus.toRecord = format.parse(params.toDate)
		
		appDetails.currentStatus.changedBy = springSecurityService?.getCurrentUser()
		appDetails.currentStatus.status = AppStatus.Status.RECORD_ROOM
		if(!appDetails.save(flush:true)){

			appDetails.errors.allErrors.each {print it}
		}
		def message = Constants.Record_Room;
		return  message;
	}
   

	def applicationFormMatching(ApplicationForm1 inst){

         def communicationList = LetterCommunication.findAllByApplicationForm1(inst)
		

		def addNoteList = AddNote.findAllByApplicationForm1(inst)
		println "getting addNoteList"+addNoteList

		def individualDetailsForMatch = IndividualProfile.findAllByApplicationForm1(inst)
		println "getting individual Profile"+individualDetailsForMatch

		def companyDetailsForMatch =  CompanyProfile.findAllByApplicationForm(inst)
		println "getting company Profile"+companyDetailsForMatch

		def agentProfile = inst?.agentProfile
		println "getting agent Profile"+agentProfile

		def listOfDepositionOfMicroOrganism = DepositionOfMicroOrganism.findAllByApplicationForm1(inst)
		println "getting micro Orgism "+listOfDepositionOfMicroOrganism

		def listOfScientistName = BiologicalResource.findAllByApplicationForm(inst)
		println "getting scientist Name"+listOfScientistName

		def bioRes = new ArrayList()

		for(bioResorce in listOfScientistName){
			println "bioResourceLocations-------"+bioResorce

			def	bioResourceLocations = GeoLocationOfBioResource?.findAllByBioResource(bioResorce)

			bioRes.add(bioResourceLocations)
		}


		def listOfContactDetailsOfRepository = ContactDetailsOfRepository.findAllByApplicationForm1(inst)
		println "getting Contact Details Of Repository"+listOfContactDetailsOfRepository

		def listOfIndianResearcher = IndianResearcher.findAllByApplicationForm1(inst)

		println "getting listOfIndianResearcher "+listOfIndianResearcher

		def listOfIndianGovtInst = IndianGovtInst.findAllByApplicationForm1(inst)

		println "getting listOfIndianGovtInst "+listOfIndianGovtInst
		
		def listOfContactPerson = ContactPerson.findAllByApplicationForm(inst)
		
		println "getting listOfContactPerson "+listOfContactPerson
		
		def listOfCommunityLocations = GeoLocationOfCommunity.findAllByAppForm(inst)

		def entity1 = FormB.findByAppFormAndType(inst,FormB.EntityType.Institute)
		def entity2 = FormB.findByAppFormAndType(inst,FormB.EntityType.Supervisor)
		def entity3 = FormB.findByAppFormAndType(inst,FormB.EntityType.Guiding_Institute)
		def entity4 = FormB.findByAppFormAndType(inst,FormB.EntityType.Guiding_Supervisor)
		def entity5 = FormB.findByAppFormAndType(inst,FormB.EntityType.Funding_Agency)

		println "all the entity1"+entity1+"entity2"+entity2+"entity3"+entity3+"entity4"+entity4+"entity5"+entity5
		
		
		def listOfFundingAgency = FormBFundingAgency?.findAllByAppform(inst)
		def  listOfIPRDetails = IPRDetail.findAllByApplicationForm(inst)
		def listOfThirdParty = ThirdParty.findAllByApplicationForm(inst)
		// Fetching details for Versioning  data............
		
		def versionDataDetails,versionIndividualData,versionCompanyData,versionAgentData,versionDepositionOfmicroOrganismData,
		versionListOfScienceData,versionIndianGovtInst,versionIndianResearcherData,versionContactPersonData
		
		def versionBioRes = new ArrayList()
		
		
		if(inst.versionApplicationForm1){
			versionDataDetails = VersionApplicationForm1.where {applicationForm == inst}.list()
		}
		
		if(versionDataDetails != null){
			
			versionIndividualData = VersionIndividualProfile.where{applicationForm1 == versionDataDetails}.list()
			
			versionCompanyData = VersionCompanyProfile.where {applicationForm == versionDataDetails}.list()
			
			versionDataDetails.each {it->versionAgentData = it?.agentProfile}
			
			versionDepositionOfmicroOrganismData = VersionDepositionOfMicroOrganism.where {applicationForm1 == versionDataDetails}.list()
			
			versionListOfScienceData = VersionBiologicalResource.where{applicationForm == versionDataDetails}.list()
			
			for(bioResorce in versionListOfScienceData){
			
			def	versionBioResourceLocations = VersionGeoLocationOfBioResource.where {bioResource == bioResorce}.list()
			
			versionBioRes.add(versionBioResourceLocations)
			}
			
			versionIndianGovtInst = VersionIndianGovtInst.where {applicationForm1 == versionDataDetails}.list()
			
			versionIndianResearcherData = VersionIndianResearcher.where {applicationForm1 == versionDataDetails}.list()
			
			versionContactPersonData = VersionContactPerson.where {applicationForm == versionDataDetails}.list()
			
			
		}

		
		
		
			return [addNoteList:addNoteList,individualDetailsForMatch:individualDetailsForMatch,companyDetailsForMatch:companyDetailsForMatch,
			agentProfile:agentProfile,listOfDepositionOfMicroOrganism:listOfDepositionOfMicroOrganism,listOfScientistName:listOfScientistName,
			bioRes:bioRes,listOfContactDetailsOfRepository:listOfContactDetailsOfRepository,listOfIndianResearcher:listOfIndianResearcher,
			listOfIndianGovtInst:listOfIndianGovtInst,entity1:entity1,entity2:entity2,entity3:entity3,entity4:entity4,entity5:entity5,
			listOfFundingAgency:listOfFundingAgency,listOfIPRDetails:listOfIPRDetails,listOfThirdParty:listOfThirdParty,
			listOfContactPerson:listOfContactPerson,communicationList:communicationList,listOfCommunityLocations:listOfCommunityLocations,
			versionDataDetails:versionDataDetails,versionIndividualData:versionIndividualData,versionCompanyData:versionCompanyData,
			versionAgentData:versionAgentData,versionDepositionOfmicroOrganismData:versionDepositionOfmicroOrganismData,versionListOfScienceData:versionListOfScienceData,
			versionBioRes:versionBioRes,versionIndianGovtInst:versionIndianGovtInst,versionIndianResearcherData:versionIndianResearcherData,
			versionContactPersonData:versionContactPersonData]
	}

	List fixedStatus = ["Approved", "Rejected"]

		def dropDownElemetsValueSetBySuperAdmin(){
		
		def firstInstance = SetMstrData.list()
		println "firstInstance"+firstInstance[0]
		def statusList = firstInstance[0]?.status
		if(statusList?.size() == 0){
		statusList = fixedStatus
		}else{
			try{
				statusList = statusList + fixedStatus
				}

			catch(NullPointerException e){
				println e
				}
			}
		def actionList = firstInstance[0]?.actions
		def priorityList = firstInstance[0]?.priority
		def noteTabList = firstInstance[0]?.note
		def draftTabList = firstInstance[0]?.draft
		def submissionTabList = firstInstance[0]?.submission
		def quriesTabList = firstInstance[0]?.quries

		
		def forwordUsrList = NbaUser.createCriteria().list {
			eq('accountLocked',false)
			and{
				nbaRole{
					and{
						ne('authority','APPLICANT')
						ne('authority','SBB')
						ne('authority','EC')
					}
				}
			}
			order("name", "asc")
		}
		def kmsDetails = KMS.list()
		
		return [statusList:statusList,actionList:actionList,priorityList:priorityList,noteTabList:noteTabList,kmsDetails:kmsDetails,
			draftTabList:draftTabList,submissionTabList:submissionTabList,quriesTabList:quriesTabList,forwordUsrList:forwordUsrList]

	}
}

