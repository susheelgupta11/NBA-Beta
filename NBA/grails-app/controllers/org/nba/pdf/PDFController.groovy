package org.nba.pdf

import grails.plugin.springsecurity.annotation.Secured
import test.ReadAndUsePdf
import org.nba.application.ApplicationForm1

@Secured(['permitAll'])
class PDFController {
	
	
	def filePDFService
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def mergeProjectPdfs(projectId,formBid) {
		//OutputStream out = response.getOutputStream();
		println "Taken output stream...." + params["id"]
		println "proj id "+params.projectId
		def projId = projectId
		byte [] fileBytes = filePDFService.mergeDocuments(projId,formBid)
		//println "fileBytes.length=" + fileBytes.length
		
		//response.outputStream << fileBytes
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "attachment; filename=Preview.pdf")
		response.setContentLength(fileBytes.length)
		response.getOutputStream().write(fileBytes)
		response.outputStream.flush()

		//println "After merging, response" + response + " fileBytes=" + fileBytes
		//response.flush()
	}

	def index() {
		println "proj id "+params.projectId
		def projId = params.projectId
		mergeProjectPdfs(projId,params?.formBid)
	}
	
	def index2() {

		println "hi  ths is pdf controller start"
		//ReadAndUsePdf.main() //calling java class for creating merge two file.(src/test/ReadAndUsePdf)
		filePDFService.createPDF()


		/*this is another approach   */

		/*Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		 PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream())
		 def File = ProjectDocument.findById(281) //here id of the document
		 if (File != null && File.document.size() > 0) {
		 def byte[] app_letter = File.document
		 PdfReader pdfReader = new PdfReader(app_letter)
		 PdfImportedPage applicationPage
		 PdfContentByte cb
		 //the pdf file may contain more than one pages
		 for (pageNumber in 0..pdfReader.getNumberOfPages() - 1) {
		 pageNumber++
		 applicationPage = writer.getImportedPage(pdfReader, pageNumber) //Create page from PdfReader
		 cb.addTemplate(applicationPage, 0, 0) // add page to PdfDocument
		 }
		 }*/

		println "hi  ths is pdf controller stop"
	}

	
	
	
	/*
	def filePDFService
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def mergeProjectPdfs(projectId) {
		//OutputStream out = response.getOutputStream();
		println "Taken output stream...." + params["id"]
		println "proj id "+params.projectId
		def projId = projectId
		byte [] fileBytes = filePDFService.mergeDocuments(projId)
		//println "fileBytes.length=" + fileBytes.length
		
		//response.outputStream << fileBytes
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "attachment; filename=Preview.pdf")
		response.setContentLength(fileBytes.length)
		response.getOutputStream().write(fileBytes)
		response.outputStream.flush()

		//println "After merging, response" + response + " fileBytes=" + fileBytes
		//response.flush()
	}

	def index() {
		println "proj id "+params.projectId
		def projId = params.projectId
		mergeProjectPdfs(projId)
	}
	
	def index2() {

		println "hi  ths is pdf controller start"
		//ReadAndUsePdf.main() //calling java class for creating merge two file.(src/test/ReadAndUsePdf)
		filePDFService.createPDF()


		this is another approach   

		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		 PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream())
		 def File = ProjectDocument.findById(281) //here id of the document
		 if (File != null && File.document.size() > 0) {
		 def byte[] app_letter = File.document
		 PdfReader pdfReader = new PdfReader(app_letter)
		 PdfImportedPage applicationPage
		 PdfContentByte cb
		 //the pdf file may contain more than one pages
		 for (pageNumber in 0..pdfReader.getNumberOfPages() - 1) {
		 pageNumber++
		 applicationPage = writer.getImportedPage(pdfReader, pageNumber) //Create page from PdfReader
		 cb.addTemplate(applicationPage, 0, 0) // add page to PdfDocument
		 }
		 }

		println "hi  ths is pdf controller stop"
	}
*/}
