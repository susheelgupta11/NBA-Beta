package org.nba.mgmt

import com.lowagie.text.pdf.PdfReader
import java.text.SimpleDateFormat
import org.springframework.util.StringUtils
import org.springframework.security.access.annotation.Secured
import org.nba.application.ApplicationForm1
import org.nba.application.FormCategory
import org.nba.resource.GeoLocationOfBioResource
import org.nba.master.MstrDocument
import org.nba.common.Country
import org.nba.common.State
import org.nba.resource.BiologicalResource
import org.nba.resource.GeoLocationOfCommunity
import org.nba.resource.IPRDetail

@Secured('permitAll')
class Form3Controller {
	def springSecurityService
	def applicationMgmtService
	def grailsApplication
	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	def beforeInterceptor = [action: this.&invokeMeBeforeEveryLoad]
	def afterInterceptor = [action: this.&invokeMeAfterEveryLoad]

	private invokeMeBeforeEveryLoad (model){
		println "In invokeMeBeforeEveryLoad"
		println "Tracing action ${actionUri}"
		//println "Timestamp is "+Date.getDateTimeString()

	}


	private invokeMeAfterEveryLoad(model) {
		//1.
		def tabStatus
		println "In invokeMeAfterEveryLoad"
		println "Tracing action ${actionUri}"
		println "SESSION CONTENT == " + session
		if(session.getAttribute('appFormId') != null){
			model?.sessionCheck = sessionCheck()
		}
		else{
			//session.setAttribute('appFormId')
			model?.sessionCheck = sessionCheck()
		}
		
		def agent = ApplicationForm1.get(session.getAttribute('appFormId'))?.agentProfile
		println "agentagentagentagentagent###################################################"+agent
		
		if(agent != null){
			tabStatus = applicationMgmtService.findTabsStatus(ApplicationForm1.get(session.getAttribute('appFormId')),agent)
		}
		else if(agent == null){
			tabStatus = applicationMgmtService.findTabsStatus(ApplicationForm1.get(session.getAttribute('appFormId')),null)
		}
		
		println "tabStatusinForm3 "+tabStatus
		model?.tabStatus = tabStatus
		println "Current model is ${tabStatus}"

	}

	private boolean sessionCheck(){
		def sessionAvailable
		println "SESS CONTENT "+session.getAttribute('appFormId')
		if(session.getAttribute('appFormId') == null){
			sessionAvailable = false
		}
		else{
			sessionAvailable = true
		}
		return sessionAvailable
	}
	
	def index() {
		def formType = params.formType
		println "formType == "+formType
		redirect(action:"selectIndividualOrCompany",controller:"applicationManagement",params:[formType:formType])
	}
	def form3Payment={
	}
	
	def part2 ={
		def formType = params.formType
		println "formType == "+formType

		println "Inside part 2 "
		println "CURRENT uSEr "+springSecurityService?.currentUser
		//1.
		def appForm 
		flash.message= params.msg1
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}
		println "appForm == "+appForm
		def listOfCountries = Country.list()
		def countryMap = [:]
		//countryMap.put(new Country(country:""),true)
		if(params.iprId){
			println "----------==============="
			def ipr= IPRDetail.get(params.iprId)
			def listOfStatuses = ['Granted', 'Not Granted', 'Under Process', 'Abandoned', 'Rejected', 'Withdrawn', 'Others']
			println "----------===============22"
			
			for(country in listOfCountries){
				println "inspecting listOfAos-" + country
				if (appForm?.detailsOfTerritories != null) {
					if(appForm?.detailsOfTerritories.contains(country)){
						println "aos.equals(useraos): true"
						countryMap.put(country, true)
					} else {
						println "aos.equals(useraos): false"
						countryMap.put(country, false)
					}
				}
			}
			println "countryMap=" + countryMap
			render(template:"iprDetailsForm",model:[countryMap:countryMap,ipr:ipr,listOfcountries:Country.list(),formType:formType,appForm:appForm,listOfStatuses:listOfStatuses])
		}
		
		else{
		//2.
		def tabStatus
		def listOfIprDetails = IPRDetail.findAllByApplicationForm(appForm)
		println "listOfIprDetails == "+listOfIprDetails

		
			for(country in listOfCountries){
				if (appForm?.detailsOfTerritories?.size() > 0) {
					if(appForm?.detailsOfTerritories.contains(country)){
						countryMap.put(country, true)
					} else {
						countryMap.put(country, false)
					}
				} else {
					countryMap.put(country, false)
				}
				
			}
			println "countryMap == "+countryMap
		//3.
		def resources = ['Stem', 'Seed', 'Fruit', 'Root', 'Leaf', 'DNA', 'Others']
		def accessSources = ['Wild', 'Cultivated', 'Market', 'Trader', 'Repositories', 'Institution', 'Others']
		def quantityList  = ['unit', 'ml', 'kg', 'vials', 'slants','tonne']
		def natureOfReources = ['Plant', 'Animal', 'Micro-organism']
		def listOfStatuses = ['Granted', 'Not Granted', 'Under Process', 'Abandoned', 'Rejected', 'Withdrawn', 'Others']
		def listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)
		
		def agent = ApplicationForm1.get(session.getAttribute('appFormId'))?.agentProfile
		println "agentagentagentagentagent###################################################"+agent
		
		if(agent != null){
			tabStatus = applicationMgmtService.findTabsStatus(ApplicationForm1.get(session.getAttribute('appFormId')),agent)
		}
		else if(agent == null){
			tabStatus = applicationMgmtService.findTabsStatus(ApplicationForm1.get(session.getAttribute('appFormId')),null)
		}
		//println "tabStatus == "+tabStatus
		[msg:params?.msg,tabStatus:tabStatus,countryMap:countryMap,natureOfReources:natureOfReources,listOfBioResources:listOfBioResources,listOfStatuses:listOfStatuses,resources:resources,listOfcountries:Country.list(),formType:formType,appForm:appForm,listOfIprDetails:listOfIprDetails]
		}
	}
	
	def savePart2 = {
		println "PARAMS IN  saveIprDetails ARE "+params
		def csrfPreventionSalt = params.csrfPreventionSalt
		println "DEtails of territories "+params._detailsOfTerritories.size()
		//try{
		def formType= params.formType
		def iprDetail
		def appForm
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}
		if(params.title && params.abstractOfIPR && params.detailsOfTerritories){
			appForm.titleOfIPR = params.title
			appForm.abstractOfIPR = params.abstractOfIPR
			
			}
		if(params?.detailsOfTerritories){
			println "HIIIIIIIIIIIIIII"
			saveTerritories(params.detailsOfTerritories,appForm)
			
			
		}
		else if(params?._detailsOfTerritories || params?._detailsOfTerritories != ''){
			println "INSIDE ELSE"
			flash.message = "Please select atleast one country"
			appForm?.detailsOfTerritories?.clear()
			if(!appForm.save(flush:true)){
				appForm.errors.each{ println "USER NOT SAVED" +it }
			}
			redirect(action:"part2",params:[csrfPreventionSalt:csrfPreventionSalt,appFormId:appForm?.id,formType:params.formType,msg:flash.message])
			return
		}
		else{
			redirect(action:"part2",params:[csrfPreventionSalt:csrfPreventionSalt,appFormId:appForm?.id,formType:params.formType,msg:flash.message])
			return
		}
		println "appForm == "+appForm
		redirect(action:"part2",params:[csrfPreventionSalt:csrfPreventionSalt,appFormId:appForm?.id,formType:params.formType])

	}
	
	def saveTerritories(Object iprTerritories,ApplicationForm1 appForm){
		//1.
		//def ipr = IPRDetail.get(iprId)

		//2.
		println "iprTerritories class == "+iprTerritories.getClass().isArray()
		println "IPR id "+appForm
		def ifTerritoryIsAList = iprTerritories.getClass().isArray()

		//3.
		appForm?.detailsOfTerritories?.clear()

		//4.
		
		if(iprTerritories.getClass().isArray() == true){
			for(countryId in iprTerritories){
				appForm.addToDetailsOfTerritories(Country.findByCountry(countryId))
			}
		}
		else{
			appForm.addToDetailsOfTerritories(Country.findByCountry(iprTerritories))
		}

		//appForm.isIPRfiledOutsideIndia = params.isIPRfiledOutsideIndia == 'Yes' ? true : false
		if(!appForm.save(flush:true)){
			appForm.errors.each{ println "USER NOT SAVED" +it }
		}

	}
	
	def saveIprDetails = {
		println "PARAMS IN  saveIprDetails ARE "+params
		//try{
		def formType= params.formType
		def iprDetail,iprStatus
		def appForm 
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}
		println "appForm == "+appForm
		
		
		if(params.status == "Others"){
			iprStatus = "Others-"+params.otherStatus 
		}
		else{
			iprStatus = params.status
		}

		if(params.iprId){
			println "inside update part of iprDetails--------------------1"+params
			println params
			def iprInst = IPRDetail.get(params.iprId)
			appForm = ApplicationForm1.get(params.appFormId)

			if( params.isIPRfiledOutsideIndia ){

				def isIPRfiledOutsideIndia
				if(params.isIPRfiledOutsideIndia == 'on'){
					appForm?.isIPApplicationFiled = 'true'
				}
				else{
					appForm?.isIPApplicationFiled = 'false'
				}

				def patentAppDate,patentDate
				if(params.patentAppDate != ''){
					SimpleDateFormat parser = new SimpleDateFormat('dd/MM/yyyy')
					patentAppDate = parser.parse(params.patentAppDate)
				}
				if(params.patentDate != ''){
					SimpleDateFormat parser = new SimpleDateFormat('dd/MM/yyyy')
					patentDate = parser.parse(params.patentDate)
				}

				//def detailsOfTerritories = IPRDetail.get(params.detailsOfTerritories)

				println "inside update part of iprDetails--------------------2"
				//saveAOSOfUser(params.detailsOfTerritories,iprInst)
				/*println "country LIST class>>>>>>>>>1 "+params.detailsOfTerritories.getClass()
				iprInst.detailsOfTerritories.clear()
				println "country LIST class>>>>>>>>>2 "+params.detailsOfTerritories.getClass()
				if(params.detailsOfTerritories.getClass().isArray() == true){
					for(country in params.detailsOfTerritories){
						iprInst.addToDetailsOfTerritories(Country.findByCountry(country))
					}
				}
				else{
					iprInst.addToDetailsOfTerritories(Country.findByCountry(country))
				}*/

				appForm.isIPApplicationFiled = params.isIPRfiledOutsideIndia == 'Yes' ? 'true' : 'false'
				iprInst.applicationForm = appForm

				if(params.isIPRfiledOutsideIndia == 'No')
				{
					iprInst.patentApplicationNo = null
					iprInst.country = null
					iprInst.patentApplicationDate = null
					iprInst.patentDate = null
					iprInst.reasons = null
					iprInst.status = null
					iprInst.patentNo = null
				}
				else if(params.status == 'Others'){
					iprInst.status = iprStatus
					iprInst.patentNo = null
					iprInst.patentDate = null
					iprInst.reasons = null
				}

				else{
					iprInst.patentApplicationNo = params.patentAppNo
					iprInst.country = params.country
					iprInst.patentApplicationDate = patentAppDate
					iprInst.patentDate = patentDate
					iprInst.reasons = params.reasons
					iprInst.status = iprStatus
					iprInst.patentNo = params.patentNo
				}
				println "inside update part of iprDetails--------------------3"
				//appForm.titleOfIPR = params.title
				//appForm.abstractOfIPR = params.abstractOfIPR
				appForm.addToIprDetails(iprInst)
				if(!iprInst.save(flush:true)){
					/*detailsOfTerritories?.each{

					}*/
					iprInst.errors.each{ println it }
				}
				println "inside update part of iprDetails--------------------4"
				if(!appForm.save(flush:true)){
					appForm.errors.each{ println it }
				}

				println "updated......... "+iprInst
			}

			def listOfIprDetails = IPRDetail.findAllByApplicationForm(appForm)
			println "listOfIprDetails == "+listOfIprDetails
			render(template:"iprDetailsGrid",model:[listOfIprDetails:listOfIprDetails,ipr:iprInst,appForm:appForm,formType:formType])
		}

		else {

			println "INSIDE ELSE CONDITION"
			if(params.isIPRfiledOutsideIndia == 'Yes' ){

				def isIPRfiledOutsideIndia
				
				def patentAppDate,patentDate
				if(params.patentAppDate != ''){
					SimpleDateFormat parser = new SimpleDateFormat('dd/MM/yyyy')
					patentAppDate = parser.parse(params.patentAppDate)
				}
				if(params.patentDate != ''){
					SimpleDateFormat parser = new SimpleDateFormat('dd/MM/yyyy')
					patentDate = parser.parse(params.patentDate)
				}

				iprDetail = new IPRDetail(patentApplicationNo: params.patentAppNo,
				country:params.country,patentApplicationDate:patentAppDate,patentDate:patentDate,reasons:params.reasons,
				applicationForm:appForm,status:iprStatus,patentNo:params.patentNo)
				
				
				appForm.isIPApplicationFiled = params.isIPRfiledOutsideIndia == 'Yes' ? 'true' : 'false'
				appForm.addToIprDetails(iprDetail)
				if(!iprDetail.save(flush:true)){
					iprDetail.errors.each{ println it }
				}
			}
			else if(params.isIPRfiledOutsideIndia == 'No'){
				appForm.isIPApplicationFiled = params.isIPRfiledOutsideIndia == 'Yes' ? 'true' : 'false'
			}
			if(!appForm.save(flush:true)){
				iprDetail.errors.each{ println it }
			}
			println "SAvED iprDetail IS "+iprDetail
			def listOfIprDetails = IPRDetail.findAllByApplicationForm(appForm)
			println "listOfIprDetails == "+listOfIprDetails
			render(template:"iprDetailsGrid",model:[listOfIprDetails:listOfIprDetails,appForm:appForm,formType:formType])
		}
		//Fetch all rows
		

	}


	def deleteIprDetails = {
		println "Inside deleteIprDetails "+params
		def iprDetail,listOfIprDetails = []
		def appForm = ApplicationForm1.get(params.appFormId)

		if(params.iprId != ''){
			iprDetail = IPRDetail.get(params.iprId)
			iprDetail.delete(flush:true)
			flash.message = "Deleted Successfully"

			listOfIprDetails = IPRDetail.findAllByApplicationForm(appForm)
			println "listOfIprDetails == "+listOfIprDetails
			render(template:"iprDetailsGrid",model:[listOfIprDetails:listOfIprDetails,appForm:appForm])
		}
	}

	def part3 = {
		def formType = params.formType
		println "formType == "+formType

		println "Inside part 2 "+params
		println "CURRENT uSEr "+springSecurityService.currentUser
		//1.
		def appForm 
		flash.message = params?.msg1
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}
		println "appForm == "+appForm

		//3.
		def listOfBioResources = BiologicalResource.findAllByApplicationForm(appForm)
		println "listOfBioResources == "+listOfBioResources
		def newList  = []
		listOfBioResources?.each{
			println "it?.scientificName == "+it?.scientificName.equals(null)
			if(it?.scientificName?.equals(null) == false){
				println "contrins null"
				newList.add(it)
			}
		}
		println "newList deleted "+newList

		def resources = ['Stem', 'Seed', 'Fruit', 'Root', 'Leaf', 'DNA']
		def accessSources = ['Wild', 'Cultivated', 'Market', 'Trader', 'Repositories', 'Institution', 'Others']
		def quantityList  = ['unit', 'ml', 'kg', 'vials', 'slants','tonne']
		def natureOfReources = ['Plant', 'Animal', 'Micro-organism']
		def listOfStatuses = ['Granted', 'Not Granted', 'Under Process', 'Abandoned', 'Rejected', 'Withdrawn', 'Others']

		//fetch geo location rows
		def listOfLocations = []
		for(bioResorce in listOfBioResources){
			def bioResourceLocations = GeoLocationOfBioResource.findAllByBioResource(bioResorce)
			for(loc in bioResourceLocations){
				//if(loc.state != null && loc.district != null && loc.town != null && loc.traderName != null && loc.traderContactDetails != null){
				listOfLocations.add(loc)
				//}
			}
		}
		println "listOfLocations == "+listOfLocations

		//4.
		def listOfCommunityLocations = GeoLocationOfCommunity.findAllByAppForm(appForm)
		println "listOfCommunityLocations == "+listOfCommunityLocations
		[newList:newList,resources:resources,accessSources:accessSources,listOfBioResources:listOfBioResources,
			formType:formType,appForm:appForm,listOfBioResources:listOfBioResources,listOfStates:State.list(),
			listOfLocations:listOfLocations,listOfCommunityLocations:listOfCommunityLocations,listOfStatuses:listOfStatuses]
	}

	def saveNbaApprovalDetails = {
		def csrfPreventionSalt = params.csrfPreventionSalt
		def formType = params.formType
		println "formType == "+formType
		println "Inside saveNbaApprovalDetails "+params
		try{
			//1.
			def appForm
			if(params.appFormId != ''){
				appForm = ApplicationForm1.get(params.appFormId)
			}
			println "appForm == "+appForm
			appForm.isApprovalOfNbaObtainedForm3 = params.isApprovalOfNbaObtained == 'Yes' ? 'true' : 'false'
			
			//2.
			def nbaApproval,nbaApprovalFileName
			if(params.NBAApproval != ''){
			  
			  if(params.NBAApproval?.getBytes()?.size() != 0){		
				nbaApproval = request.getFile('NBAApproval')
				nbaApprovalFileName = "NBAApproval"
//				appForm.nbaApprovalFile = nbaApproval.getBytes()
//				appForm.nbaApprovalFileName = nbaApprovalFileName
				
				if (nbaApproval != null && nbaApproval?.getBytes()?.size() != 0) {
					def file = request.getFile('NBAApproval')
					int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
					def nullByteCheck = file.getOriginalFilename().contains('%00')
					if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
						println '====================='
						flash.message = "Wrong format of pdf"
						forward(action: "part2", params: [msg1: 'Please upload file in pdf document format only!',
																	 appFormId:params.appFormId])
					}
					if (occurance > 1) {
						println '###################'
						flash.message = "Wrong format of pdf"
						forward(action: "part2", params: [msg1: 'Please upload file and file must be .pdf document format only!',
																	 appFormId:params.appFormId])
	
					}
	
					try {
						PdfReader pdf = new PdfReader(file.getBytes())
						if(pdf && pdf.pdfVersion){
							
						new File(grailsApplication.config.nbaApprovalForm3.toString() + File.separatorChar +"mou-doc3").mkdirs()
						 def filePath = new File(grailsApplication.config.nbaApprovalForm3.toString() + File.separatorChar + "mou-doc3"+ File.separatorChar +file.getOriginalFilename() );
					   
						  file.transferTo(filePath)
						  appForm.nbaApprovalFileURL = filePath;
							
//							appForm.nbaApprovalFile = nbaApproval.getBytes()
							appForm.nbaApprovalFileName = nbaApprovalFileName
						}
						else{
							println "*************************"
							flash.message = "Wrong format of pdf"
							forward(action: "part2", params: [msg1: 'Wrong format of pdf!',appFormId:params.appFormId])
							return
						}
					}catch (Exception e){
					println "************2*************inside catch"
						println e.message
						flash.message = "Wrong format of pdf"
						forward(action: "part2", params: [msg1: 'Wrong format of pdf!',appFormId:params.appFormId])
						return
					}
				}
			  }
			  else if(appForm.isApprovalOfNbaObtainedForm3 == 'false'){
				  appForm.nbaApprovalFile = null
				  appForm?.reasonOFNotObtainedApproval = params?.reasonOFNotObtainedApproval
				  }

				if(!appForm.save(flush:true)){
					appForm.errors.each{ println it }
				}
			}
			if(params.appNo != '' && params.approvalDate != ''){

				appForm.applicationNo = params.appNo

				def formatter = new SimpleDateFormat('dd/MM/yyyy')
				println "DATE == "+formatter.parse(params.approvalDate)
				def approvalDate = formatter.parse(params.approvalDate)
				appForm.dateOfApproval = approvalDate
				
				if(params.isApprovalOfNbaObtained == 'Yes'){
					appForm?.reasonOFNotObtainedApproval = null
				}
				
				if(params.isApprovalOfNbaObtained == 'No'){
					println "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
					appForm.applicationNo = null
					appForm.dateOfApproval = null
					appForm.nbaApprovalFile = null
				}
			}
			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}
			redirect(action:"part2",params:[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:csrfPreventionSalt])
		}
		catch(Exception e){
			println e
		}
	}

	def showDc(long id){
		println "PARAms are == "+params
		ByteArrayOutputStream ous = null;
		InputStream ios = null;
		def appForm= ApplicationForm1.get(params?.id)
		def file,filename
		def csrfPreventionSalt = params.csrfPreventionSalt
		
		if(params.filename == 'nbaApprovalFileName'){

			if(appForm.nbaApprovalFile){

				file = appForm.nbaApprovalFile

			} else if(appForm.nbaApprovalFileURL){

				file = new File(appForm.nbaApprovalFileURL)?.getBytes()

			}

			filename = appForm.nbaApprovalFileName
		}
		else if(params.filename == 'bonafideLetterName'){
			if(appForm.bonafideLetter){
				file = appForm.bonafideLetter

			} else if(appForm.bonafideLetterURL){
				file = new File(appForm.bonafideLetterURL).getBytes()
			}

			filename = appForm.bonafideLetterName
		}

		//println "FILE == "+file
		byte[] DocContent = null;
		DocContent = file
		response.setHeader "Content-disposition", "inline; filename=filename"
		response.contentType = 'application/pdf'
		response.outputStream << DocContent
		response.outputStream.flush()
	}

	def saveConsent = {

		def formType = params.formType
		println "formType == "+formType
		println "Inside saveConsent "+params
        def csrfPreventionSalt = params.csrfPreventionSalt
		//1.
		def appForm
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}
		println "appForm == "+appForm
		if(appForm != null  ){
			if(params.bioResourcesObtainedFromOutsideIndia == 'Yes'){
				appForm.isBioObtainedOutsideIndia = 'true'
				appForm.traditionalKnowledgeDesc = params.traditionalKnowledgeDesc
				appForm.reasonOfDisapproval = params.reasonOfDisapproval
			}
			
			if(params.approvalOfCountriesObtained == 'Yes'){
				appForm.isApprovalOfCountryObtained = 'true'
				appForm.reasonOfDisapproval = null
			}
			else if(params.approvalOfCountriesObtained == 'No'){
				appForm.isApprovalOfCountryObtained = 'false'
				appForm.reasonOfDisapproval = params.reasonOfDisapproval
			}

			/*if(params.bioResourcesObtainedFromOutsideIndia == 'No'){
				appForm.traditionalKnowledgeDesc = null
				appForm.reasonOfDisapproval = null
			}*/

			if(params.bioResourcesObtainedFromOutsideIndia == 'No'){
				println "######################################pp"
				appForm.isBioObtainedOutsideIndia = 'false'
				appForm.isApprovalOfCountryObtained = 'true'
				appForm.traditionalKnowledgeDesc = null
				appForm.reasonOfDisapproval = null
			}
			
			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}
			println "APPROVED == "+appForm.isApprovalOfCountryObtained
			redirect(action:"part3",params:[csrfPreventionSalt:csrfPreventionSalt,formType:formType,appFormId:appForm?.id])
		}
	}

	def saveTradionalKnowledge = {
		def formType = params.formType
		println "formType == "+formType
		println "Inside saveConsent "+params
       def csrfPreventionSalt = params.csrfPreventionSalt
		//1.
		def appForm
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}
		println "appForm == "+appForm
		//2.
		if(appForm != null){
			
			appForm?.isTraditionalKnowledgeApplicable = params.isApplicable == 'Applicable' ? 'Applicable' : 'Not applicable'
			
			if(appForm?.isTraditionalKnowledgeApplicable == 'Applicable')
				appForm.traditionalKnowledgeUsedInInvention = params.traditionalKnowledgeUsedInInvention
			else
				appForm.traditionalKnowledgeUsedInInvention = null
			
			//appForm.traditionalKnowledgeSource = params.traditionalKnowledgeSource

			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}
			redirect(action:"part3",params:[csrfPreventionSalt:csrfPreventionSalt,formType:formType,appFormId:appForm?.id])
		}
	}

	def saveInstituteDetails = {
		def formType = params.formType
		println "formType == "+formType
		println "Inside saveConsent "+params
        def csrfPreventionSalt = params.csrfPreventionSalt
		//1.
		def appForm
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}
		println "appForm == "+appForm
		if(appForm != null && params.benefitsToTheApplicant != ''){
			println "HEllo "
			
			appForm.isNoForTraditional = params.isNoForTraditional == 'No' ? 'No' : null
			appForm.isRAndDParticipationForm3 = params.instituteParticipation == 'Yes' ? true : false
			appForm.detailsOfInstitute = params.detailsOfInstitute
			appForm.benefitsToTheApplicant = params.benefitsToTheApplicant

			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}
			redirect(action:"part3",params:[csrfPreventionSalt:csrfPreventionSalt,formType:formType,appFormId:appForm?.id])
		}
	}

	def part4 = {
		println "Inside PART 4 "+params
		def formType = params.formType
		println "formType == "+formType
		def appForm
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}
		println "appForm == "+appForm
		[formType:formType,appForm:appForm]
	}

	def savePart4 = {

		def formType = params.formType
		println "formType == "+formType

		println "In  saveForm1Part5 "+params
		def appForm
		if(params.appFormId != ''){
			appForm = ApplicationForm1.get(params.appFormId)
		}
		println "appForm == "+appForm
		def declarationForm,declarationFormName
		if(params.DeclarationForm != ''){
			declarationForm = request.getFile('DeclarationForm')
			declarationFormName = "DeclarationForm"
		}
		if(appForm != null){
			appForm.declarationForm = declarationForm.getBytes()
			appForm.declarationFormName = declarationFormName

			if(!appForm.save()){
				appForm.errors.each{ println it }
			}
			redirect(action:"form1Part5",params:[formType:formType])
		}
	}

	def showDeclarationForm = {
		println"```````````````````````````````show diclration````````````````````````````````````````````"+params

		ByteArrayOutputStream ous = null;
		InputStream ios = null;
		def document= MstrDocument.findById(params.id)
		def file,filename
		if(document != null ){
			file = document.document
			filename = document.docName

		}
		//println "FILE == "+file
		byte[] DocContent = null;
		DocContent = file
		response.setHeader "Content-disposition", "inline; filename="+filename+".docx"
		response.contentType = 'application/msword'
		response.outputStream << DocContent
		response.outputStream.flush()
	}

	def showSignedDeclarationForm = {
		println "PARAms are == "+params
		ByteArrayOutputStream ous = null;
		InputStream ios = null;
		def appForm= ApplicationForm1.get(params?.id)
		def file,filename
		if(params.filename == 'declarationFormName'){
			file = appForm.declarationForm
			filename = appForm.declarationFormName
		}

		//println "FILE == "+file
		byte[] DocContent = null;
		DocContent = file
		response.setHeader "Content-disposition", "inline; filename="+filename
		response.contentType = 'application/vnd.openxmlformats-officedocument.wordprocessingml.document'
		response.outputStream << DocContent
		response.outputStream.flush()
	}
}
