package org.nba.application

import com.lowagie.text.pdf.PdfReader
import org.springframework.util.StringUtils
import grails.transaction.Transactional

@Transactional
class FileManagementService {

    def String validatePdf(File file) {
		
		def message = "File validate successfully"
		
		int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
		def nullByteCheck = file.getOriginalFilename().contains('%00')
		if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
		
			message = "Please upload file in pdf document format only!"
			return message;
			 
		}
		if (occurance > 1) {
			println '###################'
			message = "Please upload file and file must be .pdf document format only!"
			return message;
		}

		try {
			PdfReader pdf = new PdfReader(file.getBytes())
			if(pdf && pdf.pdfVersion){}
			else{
				message = "Wrong format of pdf"
				return message;
				
			}
		}catch (Exception e){
			println e.message
			message = "Wrong format of pdf"
			return message;

		}
	return message;

    }
}
