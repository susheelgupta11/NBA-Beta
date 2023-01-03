package org.nba.upload

import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import grails.transaction.Transactional

import org.apache.jasper.compiler.Node.ParamsAction;
import org.codehaus.groovy.grails.core.io.ResourceLocator
import org.codehaus.groovy.grails.web.json.JSONArray;
import org.nba.application.ApplicationForm1;

import org.springframework.core.io.Resource
import org.springframework.security.access.annotation.Secured;

@Secured('permitAll')
class ManualUploadController {
 
	def address
	def fileUploadService
	def applicationNotingService
   
  static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	ResourceLocator grailsResourceLocator
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ManualUpload.list(params), model:[manualUploadInstanceCount: ManualUpload.count()]
    }

    def show(ManualUpload manualUploadInstance) {
        respond manualUploadInstance
    }

    def create() {
        respond new ManualUpload(params)
    }
	
	def addDocument(){
		
	def manualDataDetails
		
	def csrfPreventionSalt = params.csrfPreventionSalt
	def getFormId = params.instance
	def message = params.message
	
	
	println "manualData-----"+params.manualData
	
	if(params.manualData == '' || null == params.manualData){
		println "manualData-----"+params.manualData
	 }else{
	 manualDataDetails = ManualUpload.get(Long.parseLong(params.manualData))
	 }
	
	ApplicationForm1 formDetails = ApplicationForm1.get(Long.parseLong(getFormId))
	
	def allDataforMatching = applicationNotingService.applicationFormMatching(formDetails)
	def dropDnValues = applicationNotingService.dropDownElemetsValueSetBySuperAdmin()
	
	[getFormId:getFormId,message:message,csrfPreventionSalt:csrfPreventionSalt,manualDataDetails:manualDataDetails,
		allDataforMatching:allDataforMatching,formDetails:formDetails,dropDnValues:dropDnValues]		
	}

  
    def save() {
		
		def csrfPreventionSalt = params.csrfPreventionSalt
		def getFormId = params.formId
		ApplicationForm1 formDetails = ApplicationForm1.get(getFormId)
		ManualUpload manualUploadInstance =  new ManualUpload(classified:params.classified,language:params.language, type :params.type,
			letterDate:params.letterDate, mobileNumber:params.mobileNumber, fileNumber:params.fileNumber,deliveryMode:params.deliveryMode,
			letterReferenceNumber:params.letterReferenceNumber,name:params.name, designation:params.designation, address1:params.address1,
			address2:params.address2, country:params.country,state:params.state, city:params.city,pin:params.pin,applicationForm1:formDetails,
			uploadType:"Unsigned")
		
		
	
		if(!manualUploadInstance.save(flush:true)){
			manualUploadInstance.errors.allErrors.each {print it}
		}
		def message = "Data save successfully"
		
		def dynamicPdf = fileUploadService.getDynamicManualPdf(formDetails, manualUploadInstance)
		
		redirect(action: 'addDocument' ,params:[instance:formDetails?.id,manualData:manualUploadInstance.id,message:message,csrfPreventionSalt:csrfPreventionSalt])
    }

    def edit(ManualUpload manualUploadInstance) {
        respond manualUploadInstance
    }

    @Transactional
    def update(ManualUpload manualUploadInstance) {
        if (manualUploadInstance == null) {
            notFound()
            return
        }

        if (manualUploadInstance.hasErrors()) {
            respond manualUploadInstance.errors, view:'edit'
            return
        }

        manualUploadInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ManualUpload.label', default: 'ManualUpload'), manualUploadInstance.id])
                redirect manualUploadInstance
            }
            '*'{ respond manualUploadInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ManualUpload manualUploadInstance) {

        if (manualUploadInstance == null) {
            notFound()
            return
        }

        manualUploadInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ManualUpload.label', default: 'ManualUpload'), manualUploadInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'manualUpload.label', default: 'ManualUpload'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
	
//	def showCurrentPdf(){
//	println "-------"+params
//	def csrfPreventionSalt = params.csrfPreventionSalt
//	def filePdf = request.getFile('file')
//	String rename =''
//	new File(grailsApplication.config.pdfFilePath.toString() + File.separatorChar + "NBASCAN" ).mkdirs()
//	def filePath = new File( grailsApplication.config.pdfFilePath.toString() + File.separatorChar + "NBASCAN" + File.separatorChar + filePdf.getOriginalFilename() )
//	def exists = filePath.exists();
//	if(exists == true){
//		 rename = ManualUpload.count().toString()
//		filePath = new File( grailsApplication.config.pdfFilePath.toString() + File.separatorChar + "NBASCAN" + File.separatorChar + rename + filePdf.getOriginalFilename() )
//	}
//	filePdf.transferTo(filePath)
//	address = filePath.toURI()
//	def result = [filePath:filePath.toURI(),csrfPreventionSalt:csrfPreventionSalt]
//	render result as JSON
//	
//	}
	
//	def reflectPdf(){
//		
//		if(address != null){
//			
//		def file = new File(address)
//		response.setContentType("application/pdf")
//		response.setHeader("Content-disposition","filename=${file.getName()}")
//		response.outputStream << file.newInputStream()
//		}
//	}
	
	
	
	def addClearanceLtr(){
		
		def csrfPreventionSalt = params.csrfPreventionSalt
		def getFormId = params.instance
		def message = params.message
		
		ApplicationForm1 formDetails = ApplicationForm1.get(Long.parseLong(getFormId))
		[getFormId:getFormId,message:message,csrfPreventionSalt:csrfPreventionSalt,formDetails:formDetails]

	}
	
	
	def saveClearanceLetetr(){
		def csrfPreventionSalt = params.csrfPreventionSalt
		def getFormId = params.formId
		ApplicationForm1 formDetails = ApplicationForm1.get(getFormId)
		ManualUpload clearanceIns =  new ManualUpload(docType:params.docType, date:params.dateClearance,applicationForm1:formDetails,uploadType:"Signed")
		
	
		def clrFile = request.getFile('clrFile')
		new File(grailsApplication.config.fileForKMS.toString()+ File.separatorChar + "NBASCAN" ).mkdirs()
		def filePath = new File( grailsApplication.config.fileForKMS.toString()+ File.separatorChar + "NBASCAN" +File.separatorChar + clrFile.getOriginalFilename() )
		def exists = filePath.exists();
		if(exists == true){
		def	rename = ManualUpload.count().toString()

			filePath = new File( grailsApplication.config.fileForKMS.toString()+ File.separatorChar + "NBASCAN"  + File.separatorChar + rename + clrFile.getOriginalFilename() )
		}
		clrFile.transferTo(filePath)
		
		clearanceIns.fileName = clrFile.getOriginalFilename() 
		clearanceIns.fileUrl = filePath
		
	
		if(!clearanceIns.save(flush:true)){
			clearanceIns.errors.allErrors.each {print it}
		}
		def message = "Data save successfully"
		redirect(action: 'addClearanceLtr' ,params:[instance:formDetails?.id,message:message,csrfPreventionSalt:csrfPreventionSalt])
		
	}
	
def manualDocShow(){
	def file
	def csrfPreventionSalt = params.csrfPreventionSalt
	def detailsForFile = ManualUpload.get(params?.dynamicId)
	if(detailsForFile?.fileUrl){
	 file = new File(detailsForFile?.fileUrl)
	}else if(detailsForFile?.dyUrl){
	file = new File(detailsForFile?.dyUrl)
	}
	
	response.setContentType("application/pdf")
	response.setHeader("Content-disposition","filename=${file.getName()}")
	response.outputStream << file.newInputStream()
	
	}	
	
	
}
