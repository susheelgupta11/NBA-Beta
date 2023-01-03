package org.nba.master



import static org.springframework.http.HttpStatus.*

import grails.converters.JSON
import grails.transaction.Transactional
import groovy.json.JsonSlurper

import org.springframework.security.access.annotation.Secured;

@Secured('permitAll')
class SetMstrDataController {

	static allowedMethods = [save: "POST", update: "POST", delete: "GET"]

	def index() {

		def  setMstrDataInstance = SetMstrData.first()
		def csrfPreventionSalt = params.csrfPreventionSalt
		respond setMstrDataInstance?:0 , csrfPreventionSalt:csrfPreventionSalt
	}
	def note() {

		def  setMstrDataInstance = SetMstrData.first()
		def csrfPreventionSalt = params.csrfPreventionSalt
		respond setMstrDataInstance?:0 , csrfPreventionSalt:csrfPreventionSalt
	}

	def submission() {

		def  setMstrDataInstance = SetMstrData.first()
		def csrfPreventionSalt = params.csrfPreventionSalt
		respond setMstrDataInstance?:0 , csrfPreventionSalt:csrfPreventionSalt
	}
	def queries() {

		def  setMstrDataInstance = SetMstrData.first()
		def csrfPreventionSalt = params.csrfPreventionSalt
		respond setMstrDataInstance?:0 , csrfPreventionSalt:csrfPreventionSalt
	}

	def actions() {

		def  setMstrDataInstance = SetMstrData.first()
		def csrfPreventionSalt = params.csrfPreventionSalt
		respond setMstrDataInstance?:0 , csrfPreventionSalt:csrfPreventionSalt
	}
	def status() {

		def  setMstrDataInstance = SetMstrData.first()
		def csrfPreventionSalt = params.csrfPreventionSalt
		respond setMstrDataInstance?:0 , csrfPreventionSalt:csrfPreventionSalt
	}
	def priority() {

		def  setMstrDataInstance = SetMstrData.first()
		def csrfPreventionSalt = params.csrfPreventionSalt
		respond setMstrDataInstance?:0 , csrfPreventionSalt:csrfPreventionSalt
	}

	def create(){
		def type = params.type
		println "type"+type
		[type:type]
	}

	def save() {

		def setMstrDataInstance
		def csrfPreventionSalt = params.csrfPreventionSalt
		println "======"+params
		def mstList = SetMstrData.list()
		if(mstList.size() == 0){
			setMstrDataInstance = new SetMstrData()

			Set<SetMstrData> draft = new HashSet<SetMstrData>()
			Set<SetMstrData> note = new HashSet<SetMstrData>()
			Set<SetMstrData> submission = new HashSet<SetMstrData>()
			Set<SetMstrData> actions = new HashSet<SetMstrData>()
			Set<SetMstrData> priority = new HashSet<SetMstrData>()
			Set<SetMstrData> status = new HashSet<SetMstrData>()
			Set<SetMstrData> quries = new HashSet<SetMstrData>()

			if(params.type == 'draft'){
				draft.add(params.txtValue)
			}else if(params.type == 'note'){
				note.add(params.txtValue)
			}else if(params.type == 'submission'){
				submission.add(params.txtValue)
			}else if(params.type == 'actions'){
				actions.add(params.txtValue)
			} else if(params.type == 'priority'){
				priority.add(params.txtValue)
			}else if(params.type == 'status'){
				status.add(params.txtValue)
			}else if(params.type == 'quries'){
				quries.add(params.txtValue)
			}
		}else{

			setMstrDataInstance =  mstList[0]

			if(params.type == 'draft'){
				setMstrDataInstance.draft.add(params.txtValue)
			}else if(params.type == 'note'){
				setMstrDataInstance.note.add(params.txtValue)
			}else if(params.type == 'submission'){
				setMstrDataInstance.submission.add(params.txtValue)
			}else if(params.type == 'actions'){
				setMstrDataInstance.actions.add(params.txtValue)
			} else if(params.type == 'priority'){
				setMstrDataInstance.priority.add(params.txtValue)
			}else if(params.type == 'status'){
				setMstrDataInstance.status.add(params.txtValue)
			}else if(params.type == 'quries'){
				setMstrDataInstance.quries.add(params.txtValue)
			}
		}

		if(!setMstrDataInstance.save(flush: true)){
			setMstrDataInstance.errors.allErrors.each {print it}
		}
		
//		def result = ['addValue':params.txtValue,'type':params.type,csrfPreventionSalt:csrfPreventionSalt]
//		render result as JSON
		if(params.type == 'draft'){
			redirect (action:'index', params:[csrfPreventionSalt:csrfPreventionSalt])
		}else if(params.type == 'note'){
			redirect (action:'note', params:[csrfPreventionSalt:csrfPreventionSalt])
		}else if(params.type == 'submission'){
			redirect (action:'submission', params:[csrfPreventionSalt:csrfPreventionSalt])
		}else if(params.type == 'actions'){
			redirect (action:'actions', params:[csrfPreventionSalt:csrfPreventionSalt])
		} else if(params.type == 'priority'){
			redirect (action:'priority', params:[csrfPreventionSalt:csrfPreventionSalt])
		}else if(params.type == 'status'){
			redirect (action:'status', params:[csrfPreventionSalt:csrfPreventionSalt])
		}else if(params.type == 'quries'){
			redirect (action:'queries', params:[csrfPreventionSalt:csrfPreventionSalt])
		}
	}

def edit(){
	def type= params.type
	def index = params.index as Integer
	def value
	def setMstrDataInstance = SetMstrData.first()
	
	if(params.type == 'draft'){
		def	updateElement = setMstrDataInstance.draft as List
	       value = updateElement.get(index);
		println "value"+value
	}

	else if(params.type == 'note'){

		def	updateElement = setMstrDataInstance.note as List
	 value = updateElement.get(index);
	}
	else if(params.type == 'submission'){

		def	updateElement = setMstrDataInstance.submission as List
		 value = updateElement.get(index);
	}
	else if(params.type == 'actions'){

		def	updateElement = setMstrDataInstance.actions as List
		 value = updateElement.get(index);
	}
	else if(params.type == 'priority'){

		def	updateElement = setMstrDataInstance.priority as List
		 value = updateElement.get(index);
	}
	else if(params.type == 'status'){

		def	updateElement = setMstrDataInstance.status as List
		 value = updateElement.get(index);
	}

	else if(params.type == 'quries'){

		def	updateElement = setMstrDataInstance.quries as List
		 value = updateElement.get(index);
	}

	
	
	
	[type:type,index:index,value:value]
	}

	def update() {

		def csrfPreventionSalt = params.csrfPreventionSalt
		int indxValue = params.index as Integer
		def setMstrDataInstance = SetMstrData.first()
		def checkTxt = params.txtValue

		if(checkTxt != ''|| checkTxt != "" || checkTxt != []|| checkTxt != null ){

			if(params.type == 'draft'){
				def	updateElement = setMstrDataInstance.draft as List
				setMstrDataInstance.draft.remove(updateElement.get(indxValue))
				setMstrDataInstance.draft.add(params.txtValue)
			}

			else if(params.type == 'note'){

				def	updateElement = setMstrDataInstance.note as List
				setMstrDataInstance.note.remove(updateElement.get(indxValue))
				setMstrDataInstance.note.add(params.txtValue)
			}
			else if(params.type == 'submission'){

				def	updateElement = setMstrDataInstance.submission as List
				setMstrDataInstance.submission.remove(updateElement.get(indxValue))
				setMstrDataInstance.submission.add(params.txtValue)
			}
			else if(params.type == 'actions'){

				def	updateElement = setMstrDataInstance.actions as List
				setMstrDataInstance.actions.remove(updateElement.get(indxValue))
				setMstrDataInstance.actions.add(params.txtValue)
			}
			else if(params.type == 'priority'){

				def	updateElement = setMstrDataInstance.priority as List
				setMstrDataInstance.priority.remove(updateElement.get(indxValue))
				setMstrDataInstance.priority.add(params.txtValue)
			}
			else if(params.type == 'status'){

				def	updateElement = setMstrDataInstance.status as List
				setMstrDataInstance.status.remove(updateElement.get(indxValue))
				setMstrDataInstance.status.add(params.txtValue)
			}

			else if(params.type == 'quries'){

				def	updateElement = setMstrDataInstance.quries as List
				setMstrDataInstance.quries.remove(updateElement.get(indxValue))
				setMstrDataInstance.quries.add(params.txtValue)
			}

			if(!setMstrDataInstance.save(flush:true)){
				setMstrDataInstance.errors.allErrors.each {print it}
			}
			if(params.type == 'draft'){
				redirect (action:'index', params:[csrfPreventionSalt:csrfPreventionSalt])
			}else if(params.type == 'note'){
				redirect (action:'note', params:[csrfPreventionSalt:csrfPreventionSalt])
			}else if(params.type == 'submission'){
				redirect (action:'submission', params:[csrfPreventionSalt:csrfPreventionSalt])
			}else if(params.type == 'actions'){
				redirect (action:'actions', params:[csrfPreventionSalt:csrfPreventionSalt])
			} else if(params.type == 'priority'){
				redirect (action:'priority', params:[csrfPreventionSalt:csrfPreventionSalt])
			}else if(params.type == 'status'){
				redirect (action:'status', params:[csrfPreventionSalt:csrfPreventionSalt])
			}else if(params.type == 'quries'){
				redirect (action:'queries', params:[csrfPreventionSalt:csrfPreventionSalt])
			}
		}

	}



	def delete() {
		
		def index = params.index as Integer
        def csrfPreventionSalt = params.csrfPreventionSalt
		def setMstrDataInstance = SetMstrData.first()
        
		 
		if(params.type == 'draft'){
			def removeValueList = setMstrDataInstance.draft as List
			def removeValue = removeValueList.get(index)
			
			setMstrDataInstance.draft.remove(removeValue)
		}
		else if(params.type == 'note'){
			def removeValueList = setMstrDataInstance.note as List
			def removeValue = removeValueList.get(index)
			setMstrDataInstance.note.remove(removeValue)
		}
		else if(params.type == 'submission'){
			def removeValueList = setMstrDataInstance.submission as List
			def removeValue = removeValueList.get(index)
			setMstrDataInstance.submission.remove(removeValue)
		}
		else if(params.type == 'actions'){
			def removeValueList = setMstrDataInstance.actions as List
			def removeValue = removeValueList.get(index)
			setMstrDataInstance.actions.remove(removeValue)
		}
		else if(params.type == 'priority'){
			def removeValueList = setMstrDataInstance.priority as List
			def removeValue = removeValueList.get(index)
			setMstrDataInstance.priority.remove(removeValue)
		}
		else if(params.type == 'status'){
			def removeValueList = setMstrDataInstance.status as List
			def removeValue = removeValueList.get(index)
			setMstrDataInstance.status.remove(removeValue)
		}
		else if(params.type == 'quries'){
			def removeValueList = setMstrDataInstance.quries as List
			def removeValue = removeValueList.get(index)
			setMstrDataInstance.quries.remove(removeValue)
		}

		if(!setMstrDataInstance.save (flush:true)){
			setMstrDataInstance.errors.allErrors.each{print it}
		}
		if(params.type == 'draft'){
			redirect (action:'index', params:[csrfPreventionSalt:csrfPreventionSalt])
		}else if(params.type == 'note'){
			redirect (action:'note', params:[csrfPreventionSalt:csrfPreventionSalt])
		}else if(params.type == 'submission'){
			redirect (action:'submission', params:[csrfPreventionSalt:csrfPreventionSalt])
		}else if(params.type == 'actions'){
			redirect (action:'actions', params:[csrfPreventionSalt:csrfPreventionSalt])
		} else if(params.type == 'priority'){
			redirect (action:'priority', params:[csrfPreventionSalt:csrfPreventionSalt])
		}else if(params.type == 'status'){
			redirect (action:'status', params:[csrfPreventionSalt:csrfPreventionSalt])
		}else if(params.type == 'quries'){
			redirect (action:'queries', params:[csrfPreventionSalt:csrfPreventionSalt])
		}
	}
	
// letter templete modules ............................................
	
	
    def letterList(){
		
	def message = params.message
	def csrfPreventionSalt = params.csrfPreventionSalt
	def letterlist  = LetterTemplate.list()	

	[letterlist:letterlist,csrfPreventionSalt:csrfPreventionSalt,message:message]
		
	}
	
	def addLetter(){
		def csrfPreventionSalt = params.csrfPreventionSalt
		[csrfPreventionSalt:csrfPreventionSalt]
	}
	
	
	def editLetter(){
	def csrfPreventionSalt = params.csrfPreventionSalt	
	def letterTemInstance = LetterTemplate.get(Long.parseLong(params.idEdit))
	println"-----------"+letterTemInstance
	render(view:'addLetter', model:[letterTemInstance:letterTemInstance,csrfPreventionSalt:csrfPreventionSalt])	
	}
	
	def deleteLetter(){
		def csrfPreventionSalt = params.csrfPreventionSalt
		def letterTemInstance = LetterTemplate.get(Long.parseLong(params.idDelete))
		println"========"+letterTemInstance
		if(!letterTemInstance.delete(flush:true)){
			letterTemInstance.errors.allErrors.each{print it}
		}
		redirect(action:'letterList',params:[csrfPreventionSalt:csrfPreventionSalt,message:'Letter delete successfully'])
	}
	
	def letterTempleteSave(){
		def csrfPreventionSalt = params.csrfPreventionSalt
		def letterIns = params.letterInstance
		
		def letterTemInstance,message
		if(letterIns =='' || letterIns == null){
			
	letterTemInstance = new LetterTemplate(templateLetter:params.templateLetter,letterName:params.letterName,templateCreationDate:new Date())
			message = 'Letter saved successfully';
			
		}else{
		letterTemInstance = LetterTemplate.get(Long.parseLong(letterIns))
		
		letterTemInstance.templateLetter = params.templateLetter
		letterTemInstance.letterName = params.letterName
		message = 'Letter updated successfully';
		}
		
	if(!letterTemInstance.save(flush:true)){
		letterTemInstance.errors.allErrors.each {print it}
		}
	redirect(action:'letterList',params:[csrfPreventionSalt:csrfPreventionSalt,message:message])
		
	}
	
	
	///////////////////////////KMS////////////////////////
	
	def kms(){
		
	def message = params.message
	
    [kmsInstance : KMS.list(), message:message]}	
	
	def addKMS(){}
	
    
	def saveKMS(){
		def csrfPreventionSalt = params.csrfPreventionSalt
		def kmsFile = request.getFile('kmsFile')
		

		new File(grailsApplication.config.fileForKMS.toString() ).mkdirs()
		def filePath = new File( grailsApplication.config.fileForKMS.toString() +File.separatorChar + kmsFile.getOriginalFilename() )
		def exists = filePath.exists();
		if(exists == true){
		def	rename = KMS.count().toString()

			filePath = new File( grailsApplication.config.fileForKMS.toString()  + File.separatorChar + rename + kmsFile.getOriginalFilename() )
		}
		kmsFile.transferTo(filePath)

		def kmsObject = new KMS();
		kmsObject.title = params.title
		kmsObject.fileName = kmsFile.getOriginalFilename()
		kmsObject.fileUrl = filePath
		kmsObject.createDate = new Date();
		if(!kmsObject.save(flush:true)){
			kmsObject.errors.allErrors.each{print it}
		}
		redirect(action:'kms',params:[message:"KMS saved successfully"])

	}
	
	
	
	def deleteKMS(){		
	def deleteId = params.deleteId
	
	def deleteKMS = KMS.get(Long.parseLong(deleteId))
	def getFile = new File(deleteKMS?.fileUrl)
	if(getFile.delete())
	println "KMS file delete successfully"
	
	if(!deleteKMS.delete(flush:true)){
		println('record not deleted')
		}	
		
	redirect(action:'kms',params:[message:"KMS details delete successfully"])
	
	}
	
	def showKMS(){

	def showDetails = KMS.get(Long.parseLong(params.editId))
		
	def file = new File(showDetails?.fileUrl)
	response.setContentType("application/octet-stream")
	response.setHeader("Content-disposition", "filename=${file.getName()}")
	response.outputStream << file.newInputStream()
	response.outputStream.flush()
		
	}

}
