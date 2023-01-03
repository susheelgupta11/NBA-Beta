package org.nba.application

import java.util.List;

import org.nba.benefits.BenefitSharing
import org.nba.communication.PeriodicFileAttach
import org.nba.communication.PeriodicReport;
import org.nba.upload.ManualUpload

import grails.transaction.Transactional

@Transactional
class FileUploadService {

  def springSecurityService
  def grailsApplication
  def pdfRenderingService
  
  def periodicFilesUpload(List filesPeriodic, fileInstance ,String applicationNumber){
	  String rename = "", message
	  
	  
	  filesPeriodic.each{ file ->
		  new File(grailsApplication.config.periodicreportFileAttachedPath.toString() + File.separatorChar + applicationNumber ).mkdirs()
		  def filePath = new File( grailsApplication.config.periodicreportFileAttachedPath.toString() + File.separatorChar + applicationNumber + File.separatorChar + file.getOriginalFilename() )
		  def exists = filePath.exists();
		  if(exists == true){
			  rename = PeriodicFileAttach.count().toString();
			  filePath = new File( grailsApplication.config.periodicreportFileAttachedPath.toString() + File.separatorChar + applicationNumber + File.separatorChar + rename + file.getOriginalFilename() )
		  }
		  file.transferTo(filePath)
		  
		  if(fileInstance instanceof org.nba.communication.PeriodicReport){
		  
		  def periodicFileAttach = new PeriodicFileAttach()
		  periodicFileAttach.pathUrl = filePath;
		  periodicFileAttach.fileDate = new Date();
		  periodicFileAttach.fileName = file.getOriginalFilename()
		  periodicFileAttach.periodicReport = fileInstance;
		  if(!periodicFileAttach.save()){
			  periodicFileAttach.errors.allErrors.each {print it}
		  }
		    message = "file Upload Successfully"
			
			}else if(fileInstance instanceof org.nba.benefits.BenefitSharing){
			
			def periodicFileAttach = new PeriodicFileAttach()
			periodicFileAttach.pathUrl = filePath;
			periodicFileAttach.fileName = file.getOriginalFilename()
			periodicFileAttach.benefitSharing = fileInstance;
			if(!periodicFileAttach.save()){
				periodicFileAttach.errors.allErrors.each {print it}
			}
			  message = "file Upload Successfully"
			}
	  }
	  return message
  }
  
   public getDynamicManualPdf(ApplicationForm1 af,    ManualUpload manualIns){
	   
	   ByteArrayOutputStream  bytesPdf = pdfRenderingService.render(template: "/manualUpload/manualDynamicPdf", model: [manualDataDetails:manualIns], filename: "Manual-Upload"+ af?.appNumber)
	   new File(grailsApplication.config.manualUpload.toString() + File.separatorChar +af?.appNumber).mkdirs()
	   String filePath = grailsApplication.config.manualUpload.toString() + File.separatorChar + af?.appNumber + File.separatorChar + "Manual-Upload"+af?.appNumber+".pdf";
	   
	   manualIns.dyName ="Manual-Upload"+af?.appNumber+".pdf";
	   manualIns.dyUrl = filePath;

	   	   OutputStream getPdf = null;  

	   try{
		   getPdf = new FileOutputStream(filePath)
		   bytesPdf.writeTo(getPdf);
		   getPdf.close()
	   }catch(Exception e){
		   println e
	   }
	   
   }
  
  
    
   public generatePeriodicReportDynamicPdf(ApplicationForm1 af, PeriodicReport periodicReportInstance, String formCheck ){
	   ByteArrayOutputStream  bytesPdf = null;
	   
		if(af?.category?.category == FormCategory?.Category?.Form_1 && formCheck == '1'){

			  bytesPdf = pdfRenderingService.render(template: "/applicant/form1Periodic", model: [formDetails:af, periodicReportInstance:periodicReportInstance], filename: "Periodic-Report1"+ af?.appNumber)
		}

		else if(af?.category?.category == FormCategory?.Category?.Form_1 && formCheck == '1C'){

			  bytesPdf = pdfRenderingService.render(template: "/applicant/form1CPeriodic", model: [formDetails:af, periodicReportInstance:periodicReportInstance], filename: "Periodic-Report1C"+ af?.appNumber)
		}

		else if(af?.category?.category == FormCategory?.Category?.Form_2 && formCheck == '2'){

			  bytesPdf = pdfRenderingService.render(template: "/applicant/form2Periodic", model: [formDetails:af, periodicReportInstance:periodicReportInstance], filename: "Periodic-Report2"+ af?.appNumber)
		}

		else if(af?.category?.category == FormCategory?.Category?.Form_3 && formCheck == '3'){

			  bytesPdf = pdfRenderingService.render(template: "/applicant/form3Periodic", model: [formDetails:af, periodicReportInstance:periodicReportInstance], filename: "Periodic-Report3"+ af?.appNumber)
		}

		else if(af?.category?.category == FormCategory?.Category?.Form_4 && formCheck == '4'){

			  bytesPdf = pdfRenderingService.render(template: "/applicant/form4Periodic", model: [formDetails:af, periodicReportInstance:periodicReportInstance], filename: "Periodic-Report4"+ af?.appNumber)
		}
	   
	   
	    new File(grailsApplication.config.periodicReportFiles.toString() + File.separatorChar +af?.appNumber).mkdirs()
	   String filePath = grailsApplication.config.periodicReportFiles.toString() + File.separatorChar + af?.appNumber + File.separatorChar + "Periodic-Report -"+af?.appNumber+".pdf";
	   
	   periodicReportInstance.dyFileName ="Periodic-Report"+af?.appNumber+".pdf";
	   periodicReportInstance.dyFileURL = filePath;
	   periodicReportInstance.generateDate = new Date()

	  OutputStream getPdf = null;

	   try{
		   getPdf = new FileOutputStream(filePath)
		   bytesPdf.writeTo(getPdf);
		   getPdf.close()
	   }catch(Exception e){
		   println e
	   }
	   
   }
   
   
   
  
} 
 
  
  
  
  

