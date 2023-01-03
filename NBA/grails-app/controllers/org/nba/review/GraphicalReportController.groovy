package org.nba.review

import java.text.SimpleDateFormat
import org.hibernate.*;
import org.nba.application.AppStatus
import org.nba.application.ApplicationForm1
import org.nba.user.NbaUser
import org.springframework.security.access.annotation.Secured
import org.nba.master.Transaction;
@Secured('permitAll')

class GraphicalReportController {
	
	def periodicReportService
	def springSecurityService
	
	
    def cristalView(){
		
//		def total = ApplicationForm1.createCriteria().list(){
//			currentStatus {
//				eq('status', AppStatus.Status.SUBMITTED)
//			}
//		}

  def countTotal = AppStatus.countByStatus(AppStatus.Status.SUBMITTED)
		
		println "Total count"+countTotal
		
		
//		println "total"+total
		
		def inprocess = ApplicationForm1.createCriteria().count(){

			or{
				currentStatus {
					eq('status', AppStatus.Status.NBA_PENDING)
				}
				currentStatus {
					eq('status', AppStatus.Status.IN_PROCESS)

				}
			}
		
		}
		
//		executeQuery(
//    "select count(*) from ApplicationForm1 where currentStatus.status == :inp",[AppStatus.Status.IN_PROCESS])
//		
		println"inprocess"+inprocess
		
		def approved =  ApplicationForm1.createCriteria().count(){
			currentStatus {
				eq('status', AppStatus.Status.APPROVED)
			}
		}

//		 ApplicationForm1.executeQuery(
//    "select count(*) from ApplicationForm1 where currentStatus.status == 'AppStatus.Status.APPROVED'")
		
		def reject = ApplicationForm1.createCriteria().count(){
			currentStatus {
				eq('status', AppStatus.Status.REJECTED)
			}}
		
		
//		ApplicationForm1.executeQuery(
//    "select count(*) from ApplicationForm1 where currentStatus.status == 'AppStatus.Status.REJECT'")
	
		def ip = Math.round(inprocess*100/countTotal);
		def ap = Math.round(approved*100/countTotal);
		def rp = Math.round(reject*100/countTotal);
		
// for bar chart
		SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
		
				Date y16f = newFormat.parse("2016-01-01");
				Date y16l = newFormat.parse("2016-12-31");
				
				println "2016 start"+y16f
				println "2016 Last"+y16l
				
				
				Date y17f = newFormat.parse("2017-01-01");
				Date y17l = newFormat.parse("2017-12-31");
				
				Date y18f = newFormat.parse("2018-01-01");
				Date y18l = newFormat.parse("2018-12-31");
				
				
				Date y19f = newFormat.parse("2019-01-01");
				Date y19l = newFormat.parse("2019-12-31");
				
				Date y20f = newFormat.parse("2020-01-01");
				Date y20l = newFormat.parse("2020-12-31");
				
				Date y21f = newFormat.parse("2021-01-01");
				Date y21l = newFormat.parse("2021-12-31");
				
				Date y22f = newFormat.parse("2022-01-01");
				Date y22l = newFormat.parse(newFormat.format(new Date()));
		
	def	first = Transaction.executeQuery("select count(*) from Transaction "+ "where is_payment_made = ? and payment_date BETWEEN ? AND ?",[true, y16f, y16l]);
	def	second = Transaction.executeQuery("select count(*) from Transaction "+ "where is_payment_made = ? and payment_date BETWEEN ? AND ?",[true, y17f, y17l]);
	def	third = Transaction.executeQuery("select count(*) from Transaction "+ "where is_payment_made = ? and payment_date BETWEEN ? AND ?",[true, y18f, y18l]);
	def	four = Transaction.executeQuery("select count(*) from Transaction "+ "where is_payment_made = ? and payment_date BETWEEN ? AND ?",[true, y19f, y19l]);
	def	five = Transaction.executeQuery("select count(*) from Transaction "+ "where is_payment_made = ? and payment_date BETWEEN ? AND ?",[true, y20f, y20l]);
	def	six = Transaction.executeQuery("select count(*) from Transaction "+ "where is_payment_made = ? and payment_date BETWEEN ? AND ?",[true, y21f, y21l]);
	def	seven = Transaction.executeQuery("select count(*) from Transaction "+ "where is_payment_made = ? and payment_date BETWEEN ? AND ?",[true, y22f, y22l]);
	
		[total:countTotal,inprocess:inprocess,approved:approved,reject:reject,ip:ip,ap:ap,rp:rp,first:first,
			second:second,third:third,four:four,five:five,six:six,seven:seven]
	}
	
	
	def formwiseDetails(){
						
	 List<Double> totalRevenue = Transaction.executeQuery("select sum(fee) as total from Transaction "+ "where is_payment_made = :T",[T:true])
	 
	

		switch(params.appType) {
		 
	   case 'total':
			 println("The value of type is One");
			 
			 def fwDetails =   periodicReportService.appWiseDetails(AppStatus.Status.SUBMITTED)
		
		 				 
//			  def totalRevenue =   Transaction.withCriteria {
//				 eq 'isPaymentMade', true
//				 projections {
//					 sum 'fee'
//				 }
//			 }
//			
			println "total revenue"+totalRevenue.get(0)
			 
			 
			 [searchresults:fwDetails,appType:params.appType,totalRevenue:totalRevenue]
	   break;
		
	   case 'inprocess':
			  println("The value of type is inprocess");
			def fwDetails =   periodicReportService.appWiseDetails(AppStatus.Status.IN_PROCESS)
			  [searchresults:fwDetails,appType:params.appType,totalRevenue:totalRevenue]
	   break;
			  
	   case 'approved':
			  println("The value of type is approved");
			  def fwDetails =   periodicReportService.appWiseDetails(AppStatus.Status.APPROVED)
			  [searchresults:fwDetails,appType:params.appType,totalRevenue:totalRevenue]
		
	  break;
	  
	  case 'reject':
		   println("The value of type is reject");
		   
		   def fwDetails =   periodicReportService.appWiseDetails(AppStatus.Status.REJECTED)
		   [searchresults:fwDetails,appType:params.appType,totalRevenue:totalRevenue]
	  break;
		   default:
		   System.out.println("no match");
		
	}
	
	}
	
	def form1Details(){
		println "in one form details"
		
	 List<Double> f1Revenue = Transaction.executeQuery("select sum(fee) from Transaction "+ "where is_payment_made = ? and form_type=?",[true,'Form_1']);
		

		switch(params.appType) {

			case 'total':
				println("The value of type is One");

				def result =   periodicReportService.formWiseDetails("Form_1", "SUBMITTED")
				
			
				render(template:'searchResults', model:[searchresults:result,totalRevenue:f1Revenue])
				break;

			case 'inprocess':
				println("The value of type is inprocess");
				def result =   periodicReportService.formWiseDetails("Form_1" , "IN_PROCESS")
				render(template:'searchResults', model:[searchresults:result,totalRevenue:f1Revenue])
				break;

			case 'approved':
				println("The value of type is approved");
				def result =   periodicReportService.formWiseDetails("Form_1", "APPROVED")
				render(template:'searchResults', model:[searchresults:result,totalRevenue:f1Revenue])

				break;

			case 'reject':
				println("The value of type is reject");

				def result =   periodicReportService.formWiseDetails("Form_1" , "REJECTED")
				render(template:'searchResults', model:[searchresults:result,totalRevenue:f1Revenue])
				break;
			default:
				System.out.println("no match");

		}
		
	}
	
	
	
	
	def form2Details(){
		println "in two form details"
		 List<Double> f2Revenue = Transaction.executeQuery("select sum(fee) from Transaction "+ "where is_payment_made = ? and form_type=?",[true,'Form_2']);
		
		switch(params.appType) {

			case 'total':
				println("The value of type is One");

				def result =   periodicReportService.formWiseDetails('Form_2', 'SUBMITTED')
				render(template:'searchResults', model:[searchresults:result,totalRevenue:f2Revenue])
				break;

			case 'inprocess':
				println("The value of type is inprocess");
				def result =   periodicReportService.formWiseDetails('Form_2', 'IN_PROCESS')
				render(template:'searchResults', model:[searchresults:result,totalRevenue:f2Revenue])
				break;

			case 'approved':
				println("The value of type is approved");
				def result =   periodicReportService.formWiseDetails('Form_2', 'APPROVED')
				render(template:'searchResults', model:[searchresults:result,totalRevenue:f2Revenue])

				break;

			case 'reject':
				println("The value of type is reject");

				def result =   periodicReportService.formWiseDetails('Form_2', 'REJECTED')
				render(template:'searchResults', model:[searchresults:result,totalRevenue:f2Revenue])
				break;
			default:
				System.out.println("no match");

		}
		
	}
	def form3Details(){
		println "in three form details"
		
		 List<Double> f3Revenue = Transaction.executeQuery("select sum(fee) from Transaction "+ "where is_payment_made = ? and form_type=?",[true,'Form_3']);
		
		
		switch(params.appType) {

			case 'total':
				println("The value of type is One");

				def result =   periodicReportService.formWiseDetails('Form_3', 'SUBMITTED')
				render(template:'searchResults', model:[searchresults:result,totalRevenue:f3Revenue])
				break;

			case 'inprocess':
				println("The value of type is inprocess");
				def result =   periodicReportService.formWiseDetails('Form_3', 'IN_PROCESS')
				render(template:'searchResults', model:[searchresults:result,totalRevenue:f3Revenue])
				break;

			case 'approved':
				println("The value of type is approved");
				def result =   periodicReportService.formWiseDetails('Form_3','APPROVED')
				render(template:'searchResults', model:[searchresults:result,totalRevenue:f3Revenue])

				break;

			case 'reject':
				println("The value of type is reject");

				def result =   periodicReportService.formWiseDetails('Form_3', 'REJECTED')
				render(template:'searchResults', model:[searchresults:result,totalRevenue:f3Revenue])
				break;
			default:
				System.out.println("no match");

		}
		
	}
	def form4Details(){
		println "in four form details"
		
		 List<Double> f4Revenue = Transaction.executeQuery("select sum(fee) from Transaction "+ "where is_payment_made = ? and form_type=?",[true,'Form_4']);
		
		
		switch(params.appType) {

			case 'total':
				println("The value of type is One");

				def result =   periodicReportService.formWiseDetails('Form_4', 'SUBMITTED')
				render(template:'searchResults', model:[searchresults:result,totalRevenue:f4Revenue])
				break;

			case 'inprocess':
				println("The value of type is inprocess");
				def result =   periodicReportService.formWiseDetails('Form_4','IN_PROCESS')
				render(template:'searchResults', model:[searchresults:result,totalRevenue:f4Revenue])
				break;

			case 'approved':
				println("The value of type is approved");
				def result =   periodicReportService.formWiseDetails('Form_4', 'APPROVED')
				render(template:'searchResults', model:[searchresults:result,totalRevenue:f4Revenue])

				break;

			case 'reject':
				println("The value of type is reject");

				def result =   periodicReportService.formWiseDetails('Form_4', 'REJECTED')
				render(template:'searchResults', model:[searchresults:result,totalRevenue:f4Revenue])
				break;
			default:
				System.out.println("no match");

		}
		
	}
		
// Individual MIS Report  
	
	
	
	def individualCristalView(){
		
		def currentUser = NbaUser.findByUsername(springSecurityService?.getCurrentUser().username)
		
//		def ondesk1 = AddNote.findAllByForwardMember(currentUser?.username)?.unique{it.formNumber}?.size()
//		def processed1 = AddNote.findAllByNotedUser(currentUser?.name)?.unique{it.formNumber}?.size()
		
		
		def ondesk = AppStatus.findAllByForwardedUser(currentUser?.username)?.size()
		def processed = AppStatus.findAllBySendByUser(currentUser?.name)?.size()
		
		def ondeskApplication = AppStatus.findAllByForwardedUser(currentUser?.username)
		def processedApplication  = AppStatus.findAllBySendByUser(currentUser?.name)
		
		
		def recordRoom = ApplicationForm1.createCriteria().list(){
			currentStatus {
				eq('status', AppStatus.Status.RECORD_ROOM)
				and{
					eq('changedBy',springSecurityService?.getCurrentUser())
				}
			}

		}
		
		def total = ondesk+processed+recordRoom?.size()
		println"Total"+total
		def od,pd,rm
		
		try{
			 od = Math.round(ondesk*100/total);
		}catch(ArithmeticException ae){
		println "Have a look at this exception"+ae
		}
		try{pd = Math.round(processed*100/total);
			
		}catch(ArithmeticException ae){
		println "Have a look at this exception"+ae
		}
		try{rm = Math.round(recordRoom.size()*100/total);
			
		}catch(ArithmeticException ae){
		println "Have a look at this exception"+ae
		}
		
		
	[ondesk:ondesk,processed:processed,total:total,recordRoom:recordRoom.size(),od:od,pd:pd,rm:rm,
			ondeskApplication:ondeskApplication, processedApplication:processedApplication]
		
	}
	
	
	
	def revenueFilter(){

		println "data coming for filter" +params
		List<Double> filter
		def pattern = "dd-MM-yyyy"
		def startDate = Date.parse(pattern,params.fromFilter)
		def endDate = Date.parse(pattern, params.toFilter)
		println"Start"+startDate
		println"End"+endDate

		SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date from = newFormat.parse(newFormat.format(startDate));
		Date to = newFormat.parse(newFormat.format(endDate));

		def sum = 0;
		if(params.rev == 'total'){

			filter = Transaction.executeQuery("select sum(fee) from Transaction "+ "where is_payment_made = ? and payment_date BETWEEN ? AND ?",[true, from, to]);

			println "Trans"+filter
		} else{

			filter = Transaction.executeQuery("select sum(fee) from Transaction "+ "where is_payment_made = ? and form_type=? and payment_date BETWEEN ? AND ?",[true, params.rev, from, to]);

			println "Trans"+filter
		}

		render(template:'revenue', model:[totalRevenue:filter])


	}

}

	
	
	

