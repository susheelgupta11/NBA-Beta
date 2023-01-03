package org.nba.pdf;

//import java.io.File;
//import java.io.FileOutputStream;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.Image;
//import com.itextpdf.text.pdf.PdfWriter;


//public class CreatePdf {      
//   public static void main(String args[]) throws Exception {              
//	   int indentation = 0;
//	   String FILE_NAME = "E:\\java_pdf\\nba1.pdf";
//       Document document = new Document();
//       try {
//           PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
//           document.open();
//           String img = "E:\\java_pdf\\Logo1.jpg";
//           
//           Image image = Image.getInstance(img);
//           
//           float scaler = ((document.getPageSize().getWidth() - document.leftMargin()
//                   - document.rightMargin() - indentation) / image.getWidth()) * 100;
//           
//           image.scalePercent(scaler);
//           document.add(image);
//           document.close();
//           System.out.println("Done");
//       } catch (Exception e) {
//           e.printStackTrace();
//       } 
//   } 
//}  