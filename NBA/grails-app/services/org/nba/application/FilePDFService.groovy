package org.nba.application

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import grails.transaction.Transactional

import org.nba.application.FormBFundingAgency

import com.lowagie.text.Document
import com.lowagie.text.DocumentException
import com.lowagie.text.pdf.PdfContentByte
import com.lowagie.text.pdf.PdfCopy
import com.lowagie.text.pdf.PdfCopyFields
import com.lowagie.text.pdf.PdfImportedPage
import com.lowagie.text.pdf.PdfReader
import com.lowagie.text.pdf.PdfWriter


@Transactional
class FilePDFService {

	
	def byte[] mergeDocuments(String appFormId, String formBid=null) {
		println "appFormId == "+appFormId
		def  appForm = ApplicationForm1.get(appFormId)
		//for multiple entries of funding agency
		def listOfFundingAgency = FormBFundingAgency?.findAllByAppform(appForm)
		
		println "appFormId=" + appFormId + "appForm=" + appForm
		println "CATEGORY == "+appForm?.category?.category
		println "CATEGORY 3442== "+FormCategory.Category.Form_1
		List appDocs = []
		def projDocs,formB
		if(appForm?.category?.category == FormCategory.Category.Form_1){
			println "FOR FORM 1"
			projDocs = fetchOtherDocs(appDocs,appForm)
			 //println "projDocs == "+projDocs
			if(appForm?.letterOfintent && appForm?.letterOfintent?.size() != 0){
				appDocs.add(appForm?.letterOfintent)
			}
			if(appForm?.sharingDoc && appForm?.sharingDoc?.size() != 0){
				println "Inside SHARING DOc"
				appDocs.add(appForm?.sharingDoc)
			}
			if(appForm?.transaction?.paymentReceipt && appForm?.transaction?.paymentReceipt?.size() != 0){
				appDocs.add(appForm?.transaction?.paymentReceipt)
			}
		  println "SIZE OF DOCS == "+appDocs?.size()
		}
		else if(appForm?.category?.category == FormCategory.Category.Form_2){
			projDocs = fetchOtherDocs(appDocs,appForm)
			
			if(appForm.bonafideLetter && appForm.bonafideLetter?.size() != 0){
				appDocs.add(appForm?.bonafideLetter)
			}
			
			if(appForm.mouFile && appForm.mouFile?.size() != 0){
				appDocs.add(appForm?.mouFile)
			}
			if(appForm.nbaApprovalFile && appForm.nbaApprovalFile?.size() != 0){
				appDocs.add(appForm?.nbaApprovalFile)
			}
			if(appForm?.transaction?.paymentReceipt && appForm?.transaction?.paymentReceipt?.size() != 0){
				appDocs.add(appForm?.transaction?.paymentReceipt)
			}
			println "SIZE OF DOCS == "+appDocs?.size()
		}
		else if(appForm?.category?.category == FormCategory.Category.Form_3){
			projDocs = fetchOtherDocs(appDocs,appForm)
			if(appForm.nbaApprovalFile && appForm.nbaApprovalFile?.size() != 0){
				appDocs.add(appForm?.nbaApprovalFile)
			}
			if(appForm?.transaction?.paymentReceipt && appForm?.transaction?.paymentReceipt?.size() != 0){
				appDocs.add(appForm?.transaction?.paymentReceipt)
			}
			println "SIZE OF DOCS == "+appDocs?.size()
		}
		else if(appForm?.category?.category == FormCategory.Category.Form_4){
			projDocs = fetchOtherDocs(appDocs,appForm)
			if(appForm.nbaApprovalFile && appForm.nbaApprovalFile?.size() != 0){
				appDocs.add(appForm?.nbaApprovalFile)
			}
			if(appForm?.agreementBtwnApplicantAndThirdParty && appForm?.agreementBtwnApplicantAndThirdParty?.size() != 0){
				appDocs.add(appForm?.agreementBtwnApplicantAndThirdParty)
			}
			if(appForm?.transaction?.paymentReceipt && appForm?.transaction?.paymentReceipt?.size() != 0){
				appDocs.add(appForm?.transaction?.paymentReceipt)
			}
			println "SIZE OF DOCS == "+appDocs?.size()
		}
		else if(appForm?.category?.category == FormCategory.Category.Form_B){
			projDocs = fetchOtherDocs(appDocs,appForm)
			
			if(appForm.undertakingCopy && appForm.undertakingCopy?.size() != 0){
				appDocs.add(appForm?.undertakingCopy)
			}
			
			if(appForm.declarationBySupervisorCopy && appForm.declarationBySupervisorCopy?.size() != 0){
				appDocs.add(appForm?.declarationBySupervisorCopy)
			}
			if(appForm.declarationByRecipientCopy && appForm.declarationByRecipientCopy?.size() != 0){
				appDocs.add(appForm?.declarationByRecipientCopy)
			}
			if(appForm?.transaction?.paymentReceipt && appForm?.transaction?.paymentReceipt?.size() != 0){
				appDocs.add(appForm?.transaction?.paymentReceipt)
			}
			
//			if(formBid && formBid != null){
//				formB = FormB?.get(formBid)
//				appDocs.add(formB?.sanctionOrderMoUcopy)
//			}
			
			if(listOfFundingAgency){
				for(agency in listOfFundingAgency){
					appDocs.add(agency?.sanctionOrder)
				}
			}
			
			
			if(appForm?.declarationByApplicantOnNationalityCopy && appForm?.declarationByApplicantOnNationalityCopy?.size() != 0){
				appDocs.add(appForm?.declarationByApplicantOnNationalityCopy)
			}
			
			println "SIZE OF DOCS == "+appDocs?.size()
			println "appform.formBItems------------------------------------"+formBid
		}
		else if(appForm?.category?.category == FormCategory.Category.Form_C){
			
			if(appForm.undertakingCopy && appForm.undertakingCopy?.size() != 0){
				appDocs.add(appForm?.undertakingCopy)
			}
			
			
			println "SIZE OF DOCS == "+appDocs?.size()
		}
		//println "fileBytes=" + fileBytes
		return mergePdfs2(projDocs)
	}

	def fetchOtherDocs(List projDocs,ApplicationForm1 appForm){
		println "appForm Inside fetchOtherDocs "+appForm
		println "AGENT PROFILE == "+appForm?.agentProfile
		if(appForm?.agentProfile && appForm?.agentProfile != null){
			if(appForm?.agentProfile?.passportCopy && appForm?.agentProfile?.passportCopy?.size() != 0){
				projDocs.add(appForm?.agentProfile?.passportCopy)
			}
			if(appForm?.agentProfile?.authorizationLetter && appForm?.agentProfile?.authorizationLetter?.size() != 0){
				projDocs.add(appForm?.agentProfile?.authorizationLetter)
			}
			//println "projDocs == "+projDocs
		}
		
		if(appForm?.individualProfiles?.size() > 0){
			println "Inside indiv "+appForm?.individualProfiles
			for(indivProfileDoc in appForm?.individualProfiles){
				println "indivProfileDoc == "+indivProfileDoc
				if(indivProfileDoc?.idProof && indivProfileDoc?.idProof?.size() != 0){
					projDocs.add(indivProfileDoc?.idProof)
					//println "projDocs11 == "+projDocs
				}
				if(indivProfileDoc?.passportCopy && indivProfileDoc?.passportCopy?.size() != 0){
					projDocs.add(indivProfileDoc?.passportCopy)
				}
				if(indivProfileDoc?.authorizationLetter && indivProfileDoc?.authorizationLetter?.size() != 0 ){
					
					projDocs.add(indivProfileDoc?.authorizationLetter)
				}
			}
			println "DOC SIZE after adding individual and agent "+projDocs?.size()
		}
		else if(appForm.companyProfiles.size() > 0){
			println "Inside comp"
			for(compProfileDoc in appForm.companyProfiles){
				if(compProfileDoc?.registrationDoc && compProfileDoc?.registrationDoc?.size() != 0){
				projDocs.add(compProfileDoc?.registrationDoc)
				}
				if(compProfileDoc?.passportCopy && compProfileDoc?.passportCopy?.size() != 0){
					projDocs.add(compProfileDoc?.passportCopy)
				}
				if(compProfileDoc?.authorizationLetter && compProfileDoc?.authorizationLetter?.size() != 0){
				projDocs.add(compProfileDoc?.authorizationLetter)
				}
			}

		}
		else if(appForm.indianResearcher.size() > 0){
			println "inside indian researcher"
			for(indianResearcherDoc in appForm.indianResearcher){
				projDocs.add(indianResearcherDoc?.addressproofLetter)
			}
		}
		//println "projDocs == "+projDocs

		return projDocs
	}

	def byte[] mergePdfs(List projDocs) {
		// step 1
		Document document = new Document();

		// step 2
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
		PdfCopy copy = new PdfCopy(document, outputStream);

		// step 3
		document.open();

		// step 4
		println "mergePdfs --> In Step 4"
		PdfReader reader;
		int n;
		// loop over the documents you want to concatenate
		for ( projDoc in projDocs) {
			//println "projDoc=" + projDoc
			InputStream ins = new ByteArrayInputStream(projDoc)
			println "ins=" + ins
			reader = new PdfReader(ins);
			// loop over the pages in that document
			n = reader.getNumberOfPages();
			println "No of Pages=" + n
			for (int page = 0; page < n; ) {
				copy.addPage(copy.getImportedPage(reader, ++page));
			}
			println "Before free reader"
			copy.freeReader(reader);
			println "Before reader close"
			reader.close();
		}

		// step 5
		//		println "mergePdfs --> In Step 5"
		outputStream.flush();
		//		document.close();
		//outputStream.close();

		//6.
		println "before toByteArray --> In Step 6"
		byte[] fileBytes = outputStream.toByteArray();
		//println "fileBytes=" + fileBytes
		return fileBytes
	}

	def byte[] mergePdfs2(List projDocs) {
		// step 1
		Document document = new Document();

		// step 2
		println "mergePdfs2 --> In Step 2 "
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
		PdfCopyFields finalCopy = new PdfCopyFields(outputStream);
		finalCopy.open();

		// step 3
		println "mergePdfs2 --> In Step 3"
		PdfReader reader;
		int n;
		// loop over the documents you want to concatenate
		for ( projDoc in projDocs) {
			//println "projDoc=" + projDoc
			InputStream ins = new ByteArrayInputStream(projDoc)
			println "ins=" + ins
			reader = new PdfReader(ins);
			//if(reader != null ){
			finalCopy.addDocument(reader);
			//}
			println "After adding document"
		}

		// step 4
		println "mergePdfs2 --> In Step 4"
				outputStream.flush();
				document.close();
		outputStream.close();
		finalCopy.close();

		//5.
		println "before toByteArray --> In Step 5"
		byte[] fileBytes = outputStream.toByteArray();
		//println "fileBytes=" + fileBytes
		return fileBytes
	}


	def createPDF() {
		List<InputStream> list = new ArrayList<InputStream>();
		try {
			println "Before reading files.."

			// Source pdfs
			list.add(new FileInputStream(new File("E:/1.pdf")));
			list.add(new FileInputStream(new File("E:/2.pdf")));

			// Resulting pdf
			OutputStream out = new FileOutputStream(new File("E:/result.pdf"));

			println "Before merge...."
			doMerge2(list, out);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void doMerge2(List<InputStream> list, OutputStream outputStream)
	throws DocumentException, IOException {
		// step 1
		Document document = new Document();

		// step 2
		PdfCopy copy = new PdfCopy(document, outputStream);

		// step 3
		document.open();

		// step 4
		println "In Step 4"
		PdfReader reader;
		int n;
		// loop over the documents you want to concatenate
		for (InputStream ins : list) {
			reader = new PdfReader(ins);
			// loop over the pages in that document
			n = reader.getNumberOfPages();
			for (int page = 0; page < n; ) {
				copy.addPage(copy.getImportedPage(reader, ++page));
			}
			copy.freeReader(reader);
			reader.close();
		}

		// step 5
		println "In Step 5"
		outputStream.flush();
		document.close();
		outputStream.close();
	}

	void doMerge(List<InputStream> list, OutputStream outputStream)
	throws DocumentException, IOException {
		Document document = new Document();

		PdfWriter writer = PdfWriter.getInstance(document, outputStream);
		println 'Before document open...'
		document.open();
		println 'After document open...'
		PdfContentByte cb = writer.getDirectContent();
		println 'After  PdfWriter getDirectContent...'
		PdfReader.unethicalreading = true;
		for (InputStream ins : list) {
			PdfReader reader = new PdfReader(ins);
			println 'After  new PdfReader...'
			for (int i = 1; i <= reader.getNumberOfPages(); i++) {
				document.newPage();
				//import the page from source pdf
				PdfImportedPage page = writer.getImportedPage(reader, i);
				println 'After  PdfImportedPage...'
				//add the page to the destination pdf
				cb.addTemplate(page, 0, 0);
			}
		}
		outputStream.flush();
		document.close();
		outputStream.close();
	}
	
	public static  doAgendaMerge(List<InputStream> listPdf)
	throws DocumentException, IOException {
Document document = new Document();
ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
PdfWriter writer = PdfWriter.getInstance(document, outputStream);
document.open();
PdfContentByte cb = writer.getDirectContent();

for (InputStream ini : listPdf) {
	PdfReader reader = new PdfReader(ini);
	for (int i = 1; i <= reader.getNumberOfPages(); i++) {
		document.newPage();
		//import the page from source pdf
		PdfImportedPage page = writer.getImportedPage(reader, i);
		//add the page to the destination pdf
		cb.addTemplate(page, 0, 0);
	}
}

outputStream.flush();
document.close();
outputStream.close();
byte[] fileBytes = outputStream.toByteArray();
//println "fileBytes=" + fileBytes
return fileBytes
}
	
}
