package org.nba.userManagement
import org.springframework.security.access.annotation.Secured
@Secured('permitAll')
class TestDataController {

	def index() {
		println "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
		forward(action:"uploadDocs")
	}

	def uploadDocs = {
		println "ssssssssssssssssssssssssssssssssss"
		[listOfdocs:MstrDocument.list()]
	}

	def addDocument = {

		println "Adding new Doc "+params
		def file
		file = request.getFile('DocumentFormat')
		if(params.DocumentFormat !=null){
			println"hi this is new doc format file"
			def docFormat = MstrDocument.findById(params.docId)
			docFormat.fileName = file.originalFilename
			docFormat.document = file.getBytes()
			docFormat.isActive = true
			docFormat.save(failOnError: true, flush: true)
			println "User doc format saved successfully"
		}
		redirect(action: "uploadDocs")
	}

	def viewDoc(long id){
		println "PARAMS == "+params
		ByteArrayOutputStream ous = null;
		InputStream ios = null;
		def file
		def filename
		file = MstrDocument.findById(id).document
		filename = MstrDocument.findById(id).docName+".docx"
		//		println "FILE == "+file

		byte[] DocContent = null;
		DocContent = file
		response.setHeader "Content-disposition", "inline; filename="+filename
		response.contentType = 'application/pdf'
		response.outputStream << DocContent
		response.outputStream.flush()
	}
}
