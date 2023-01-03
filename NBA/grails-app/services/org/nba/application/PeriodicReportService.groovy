package org.nba.application

import grails.transaction.Transactional
import groovy.sql.Sql

import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap
import org.hibernate.SessionFactory
import org.nba.communication.PeriodicReport
import org.nba.master.Transaction;

import com.nba.constant.Constants

@Transactional
class PeriodicReportService {
	def grailsApplication
	SessionFactory sessionFactory;

	def savePeriodicReport(GrailsParameterMap params,f,ApplicationForm1 applicationNumber) {

		def periodicReportInstance = new PeriodicReport(applicationNumber:params.applicationNumber,applicantName: params.applicantName,
		agreementSignDt:params.agreementSignDt, whetherAccessedBioRes:params.whetherAccessedBioRes, whenBiologicalResearch:params.whenBiologicalResearch,
		whenBiologicalResearchTo:params.whenBiologicalResearchTo,reserchCarriedOut:params.reserchCarriedOut, briefResearchCarried:params.briefResearchCarried,haveYouPublished:params.haveYouPublished,
		haveAppliedPatent:params.haveAppliedPatent, haveTransferredResults:params.haveTransferredResults,haveTransferredBiological:params.haveTransferredBiological,
		place:params.place,publishCheck:params.publishCheck,haveAppliedCheck:params.haveAppliedCheck,haveTrsCheck:params.haveTrsCheck,
		trnsBioCheck:params.trnsBioCheck,dtsTransferor:params.dtsTransferor,dtsTransferee:params.dtsTransferee,
		modeOfTransfr:params.modeOfTransfr,monetBeneftOnTrsf:params.monetBeneftOnTrsf,detsOfbenefitSharing:params.detsOfbenefitSharing,
		country:params.country,pan:params.pan,status:params.status,feeReceived:params.feeReceived,daac:params.daac,
		haveTransfer:params.haveTransfer,haveTrsfCheck:params.haveTrsfCheck,dtsQuantityTfr:params.dtsQuantityTfr, dbsapAgree:params.dbsapAgree,
		 dbsapCheck:params.dbsapCheck,periodFrom:params.fromDate,periodTo:params.toDate)

		periodicReportInstance.applicationForm = applicationNumber
		periodicReportInstance.mods = params.mod
		
	

		if(params.publishCheck == 'Yes'){
			
			if(!f.empty){
				String rename
				new File(grailsApplication.config.periodicReportFiles.toString() + File.separatorChar + applicationNumber?.appNumber ).mkdirs()
				def filePath = new File( grailsApplication.config.periodicReportFiles.toString() + File.separatorChar + applicationNumber?.appNumber  + File.separatorChar + f.getOriginalFilename() )
				def exists = filePath.exists();
				if(exists == true){
					rename = PeriodicReport.count().toString();
					filePath = new File( grailsApplication.config.periodicReportFiles.toString() + File.separatorChar + applicationNumber?.appNumber  + File.separatorChar + rename + f.getOriginalFilename() )
				}
				f.transferTo(filePath)

				periodicReportInstance.pathUrl = filePath;
				periodicReportInstance.fileName = f.getOriginalFilename()
			}
		}
		if(!periodicReportInstance.save()){
			periodicReportInstance.errors.allErrors.each {print it}
		}
		
		return periodicReportInstance
	}
	
	
	def updatePeriodicReport(GrailsParameterMap params,f,applicationNumber){

		def periodicInstance = params.periodicInstance
		def formId = params.appNumber
		def csrfPreventionSalt = params.csrfPreventionSalt

		def periodicInstanceDetails = PeriodicReport.get(periodicInstance as Long)


		periodicInstanceDetails.agreementSignDt = params.agreementSignDt
		periodicInstanceDetails.whetherAccessedBioRes = params.whetherAccessedBioRes
		periodicInstanceDetails.whenBiologicalResearch = params.whenBiologicalResearch
		periodicInstanceDetails.whenBiologicalResearchTo = params.whenBiologicalResearchTo
		periodicInstanceDetails.reserchCarriedOut = params.reserchCarriedOut
		periodicInstanceDetails.briefResearchCarried = params.briefResearchCarried
		periodicInstanceDetails.haveYouPublished = params.haveYouPublished
		periodicInstanceDetails.dtsTransferor = params.dtsTransferor
		periodicInstanceDetails.dtsTransferee = params.dtsTransferee
		periodicInstanceDetails.modeOfTransfr = params.modeOfTransfr
		periodicInstanceDetails.monetBeneftOnTrsf = params.monetBeneftOnTrsf
		periodicInstanceDetails.detsOfbenefitSharing = params.detsOfbenefitSharing
		periodicInstanceDetails.country = params.country
		periodicInstanceDetails.pan = params.pan
		periodicInstanceDetails.status = params.status
		periodicInstanceDetails.mods = params.mod
		periodicInstanceDetails.daac = params.daac
		periodicInstanceDetails.feeReceived = params.feeReceived

		periodicInstanceDetails.place = params.place

		periodicInstanceDetails.haveAppliedCheck = params.haveAppliedCheck
		periodicInstanceDetails.haveTrsCheck = params.haveTrsCheck
		periodicInstanceDetails.trnsBioCheck = params.trnsBioCheck
		
        periodicInstanceDetails.haveTrsfCheck = params.haveTrsfCheck
        periodicInstanceDetails.dtsQuantityTfr = params.dtsQuantityTfr
        periodicInstanceDetails.dbsapAgree = params.dbsapAgree
        periodicInstanceDetails.dbsapCheck = params.dbsapCheck
		
		
		 periodicInstanceDetails.publishCheck = params.publishCheck
		
		
		if(params.publishCheck == 'Yes'){
			
			if(!f.empty){
				String rename
				new File(grailsApplication.config.periodicReportFiles.toString() + File.separatorChar + applicationNumber?.appNumber ).mkdirs()
				def filePath = new File( grailsApplication.config.periodicReportFiles.toString() + File.separatorChar + applicationNumber?.appNumber  + File.separatorChar + f.getOriginalFilename() )
				def exists = filePath.exists();
				if(exists == true){
					rename = PeriodicReport.count().toString();
					filePath = new File( grailsApplication.config.periodicReportFiles.toString() + File.separatorChar + applicationNumber?.appNumber  + File.separatorChar + rename + f.getOriginalFilename() )
				}
				f.transferTo(filePath)

				periodicInstanceDetails.pathUrl = filePath;
				periodicInstanceDetails.fileName = f.getOriginalFilename()
			}
		}
		
	   
	   if(params.haveTrsfCheck == 'No')
		   periodicInstanceDetails.haveTransfer = ''
	   else
		   periodicInstanceDetails.haveTransfer = params.haveAppliedPatent
		   
		if(params.dbsapCheck == 'No')
			periodicInstanceDetails.dbsapAgree = ''
		else
			periodicInstanceDetails.dbsapAgree = params.haveAppliedPatent

		if(params.haveAppliedCheck == 'No')
			periodicInstanceDetails.haveAppliedPatent = ''
		else
			periodicInstanceDetails.haveAppliedPatent = params.haveAppliedPatent


		if(params.haveTrsCheck == 'No')
			periodicInstanceDetails.haveTransferredResults = ''
		else
			periodicInstanceDetails.haveTransferredResults = params.haveTransferredResults

		if(params.trnsBioCheck == 'No')
			periodicInstanceDetails.haveTransferredBiological = ''
		else
			periodicInstanceDetails.haveTransferredBiological = params.haveTransferredBiological



		if(!periodicInstanceDetails.save(flush: true)){
			periodicInstanceDetails.errors.allErrors.each {print it}
		}

		return periodicInstanceDetails
	}
	
	
	
	def appWiseDetails(AppStatus.Status formType ){
		
		
		
		
//		def fm1 = ApplicationForm1.countByCategoryAndCurrentStatus(FormCategory.Category.Form_1,formType)
		
//		println "fm1"+fm1
		
		def form1 = ApplicationForm1.createCriteria().count {
			
		category{
			eq('category',FormCategory.Category.Form_1)
			}
		and{
			currentStatus {
				eq('status', formType)
			}
			}
		}
		
		def form2 = ApplicationForm1.createCriteria().count {
			
		category{
			eq('category',FormCategory.Category.Form_2)
			}
		and{
			currentStatus {
				eq('status', formType)
			}
			}
		}
		def form3 = ApplicationForm1.createCriteria().count {
			
		category{
			eq('category',FormCategory.Category.Form_3)
			}
		and{
			currentStatus {
				eq('status', formType)
			}
			}
		}
		
		def form4 = ApplicationForm1.createCriteria().count{
			
		category{
			eq('category',FormCategory.Category.Form_4)
			}
		and{
			currentStatus {
				eq('status', formType)
			}
			}
		}
		
		def appSts
		
		if(formType == AppStatus.Status.SUBMITTED){appSts = 'SUBMITTED'}
		else if(formType == AppStatus.Status.IN_PROCESS){appSts = 'IN_PROCESS'}
		else if(formType == AppStatus.Status.APPROVED){appSts = 'APPROVED'}
		else if(formType == AppStatus.Status.REJECTED){appSts = 'REJECTED'}
		
		Sql sql = new Sql(sessionFactory.currentSession.connection())
		String querySyntax = Constants.STATUS_WISE.replace('APPTYPE',appSts)
		
		println"query"+querySyntax
		
		 def app = sql.rows(querySyntax);
		 
		 println"query result"+app
		 
  
		
	return	[form1:form1,form2:form2,form3:form3, form4:form4,result:app]
	
	}


	
  def formWiseDetails(String  ctg , String formType){
		
	
		Sql sql = new Sql(sessionFactory.currentSession.connection())
		String querySyntax = Constants.FORM_WISE.replace('APPU', ctg).replace('APPTYPE',formType)
		
		println"query"+querySyntax
		
		 def app = sql.rows(querySyntax);
		 
		 println"query result"+app
		 
	

	     [result:app]
	
	}
}
