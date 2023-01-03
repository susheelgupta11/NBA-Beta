package org.nba.masterData

import com.lowagie.text.pdf.PdfReader
import org.springframework.util.StringUtils
import org.nba.application.FormCategory
import org.nba.master.ManageLoginContent
import org.nba.master.MstrDocument
import org.nba.master.MstrSecurityQuestion
import org.nba.master.Question
import org.nba.master.QuestionCategory
import org.nba.master.Transaction
import org.springframework.security.access.annotation.Secured
import org.nba.user.NbaUserNbaRole

@Secured('permitAll')
class MasterDataController {


	def springSecurityService
	
	def beforeInterceptor = {
		
		def role = NbaUserNbaRole.findByNbaUser(springSecurityService.currentUser)?.nbaRole?.authority
		if (role == 'ADMIN') {
		} else {
		redirect(controller: 'login', action: 'denied')
		}
		}
	
	def index() {
		redirect(action:"addSecurityQuestions")
//		redirect(action:"manageLoginContent")
	}

	def addSecurityQuestions = {
		def securityQue1 = new MstrSecurityQuestion(question: "What is your favourite dish?").save()
		def securityQue2 = new MstrSecurityQuestion(question: "What is the name of your first school?").save()
		def securityQue3 = new MstrSecurityQuestion(question: "What is your pet's name?").save()
		def securityQue4 = new MstrSecurityQuestion(question: "Which is your favourite holiday destination?").save()
		def securityQue5 = new MstrSecurityQuestion(question: "Which is your favourite actor?").save()

		println "security questions saved successfully !!!"
		forward action: "addFormCategories"
	}

	def addFormCategories = {
//		def category1 = new FormCategory(category:FormCategory.Category.Form_1).save()
//		def category2 = new FormCategory(category:FormCategory.Category.Form_2).save()
//		def category3 = new FormCategory(category:FormCategory.Category.Form_3).save()
//		def category4 = new FormCategory(category:FormCategory.Category.Form_4).save()
		def category5 = new FormCategory(category:FormCategory.Category.Form_B).save()
		def category6 = new FormCategory(category:FormCategory.Category.Form_C).save()

		println "categories saved successfully !!!"
//		forward action: "addFormQuestions"
	}

	def addFormQuestions = {

		println "Inside form Questions "

		def queCategory1 = new QuestionCategory(category:QuestionCategory.Category.Form_1).save(flush:true)
		def queCategory2 = new QuestionCategory(category:QuestionCategory.Category.Form_2).save(flush:true)
		def queCategory3 = new QuestionCategory(category:QuestionCategory.Category.Form_3).save(flush:true)
		def queCategory4 = new QuestionCategory(category:QuestionCategory.Category.Form_4).save(flush:true)

		//for form 1
		def que2 = new Question(question:"Primary destination of accessed resource and identity of the location where the R&D will be carried out",
		questionCategory:queCategory1,questionNo:"(4)",placeholder:"Name, address and contact details").save(flush:true)
		def que3 = new Question(question:"The economic and other benefits including those arriving out of any IPR, patent obtained out of accessed biological resources and knowledge that are intended, or may accrue to the applicant or to the country that he/ she belongs",questionTooltip:"Provide details of scope of any IPR that may arise and the monetary benefits envisaged",
		questionCategory:queCategory1,questionNo:"(5)",placeholder:"details in 500 words").save(flush:true)
		def que4 = new Question(question:"The biotechnological, scientific, social or any other benefits obtained out of accessed biological resources and knowledge that are intended, or may accrue to the applicant or to the country that he/ she belongs",questionTooltip:"Provide details of non-monetary benefits envisaged",
		questionCategory:queCategory1,questionNo:"(6)",placeholder:"details in 500 words").save(flush:true)
		def que5 = new Question(question:" Estimation of benefits, that would flow to India/ communities arising out of the use of accessed bioresources and traditional knowledge",questionTooltip:"Provide details of estimated benefits, quantified if possible, and intended timelines of flow",
		questionCategory:queCategory1,questionNo:"(7)",placeholder:"details in 500 words").save(flush:true)
		/*def que6 = new Question(question:"Estimation of benefits that would flow to India/ communities, arising out of the third party transfer of accessed biological resources and traditional knowledge ",
		questionCategory:queCategory1,questionNo:"(8)",placeholder:"Name, address and contact details").save(flush:true)*/
		//def que7 = new Question(question:"Any other information considered relevant",
		//questionCategory:queCategory1,questionNo:"(8)").save(flush:true)

		//for form 4
		def que8 = new Question(question:" Estimation of benefits that would flow to India/communities arising out of the third party transfer of accessed biological resources and traditional knowledge.",
		questionCategory:queCategory4,questionNo:"(9)").save(flush:true)
		def que9 = new Question(question:"Proposed mechanism and arrangements for benefit sharing arising out of the proposed third party transfer.",
		questionCategory:queCategory4,questionNo:"(10)").save(flush:true)
		def que10 = new Question(question:"Any other relevant information.",
			questionCategory:queCategory4,questionNo:"(11)").save(flush:true)



		println "Questions saved successfully "
		forward action: "manageLoginContent"
	}

	def addDocuments() {
//		def doc1 = new MstrDocument(docName: "Notification 1.").save()
//		def doc2 = new MstrDocument(docName: "Notification 2.").save()
//		def doc3 = new MstrDocument(docName: "Notification 3.").save()
//		def doc4 = new MstrDocument(docName: "Notification 4.").save()
//		def doc5 = new MstrDocument(docName: "Notification 5.(i)").save()
//		def doc26 = new MstrDocument(docName: "Notification 5.(ii)").save()
//		def doc27 = new MstrDocument(docName: "Notification 5.(iii)").save()
//		def doc6 = new MstrDocument(docName: "Notification 6.").save()
//		def doc7 = new MstrDocument(docName: "Notification 7.").save()
//		def doc8 = new MstrDocument(docName: "Notification 8.").save()
//		def doc9 = new MstrDocument(docName: "Notification 9.(a- Bihar)").save()
//		def doc10 = new MstrDocument(docName: "Notification 9.(b- Goa)").save()
//		def doc11 = new MstrDocument(docName: "Notification 9.(c- Himachal Pradesh)").save()
//		def doc12 = new MstrDocument(docName: "Notification 9.(d- Karnataka)").save()
//		def doc13 = new MstrDocument(docName: "Notification 9.(e- Kerala)").save()
//		def doc14 = new MstrDocument(docName: "Notification 9.(f- Madhya Pradesh)").save()
//		def doc15 = new MstrDocument(docName: "Notification 9.(g- Manipur)").save()
//		def doc16 = new MstrDocument(docName: "Notification 9.(h- Meghalaya)").save()
//		def doc17 = new MstrDocument(docName: "Notification 9.(i- Mizoram)").save()
//		def doc18 = new MstrDocument(docName: "Notification 9.(j- Orissa)").save()
//		def doc19 = new MstrDocument(docName: "Notification 9.(k- Punjab)").save()
//		def doc20 = new MstrDocument(docName: "Notification 9.(l- Tamil Nadu)").save()
//		def doc21 = new MstrDocument(docName: "Notification 9.(m- Tripura)").save()
//		def doc22 = new MstrDocument(docName: "Notification 9.(n- Uttar Pradesh)").save()
//		def doc23 = new MstrDocument(docName: "Notification 9.(o- Uttarakhand)").save()
//		def doc24 = new MstrDocument(docName: "Notification 9.(p- West Bengal)").save()
//		def doc25 = new MstrDocument(docName: "Notification 10.").save()
//		def doc28 = new MstrDocument(docName: "User Manual").save()
		def doc28 = new MstrDocument(docName: "Undertaking by the Applicant Form A").save()
		def doc29 = new MstrDocument(docName: "Declaration by the Recipient collaborator outside india Form B").save()
		def doc30 = new MstrDocument(docName: "Declaration by the Supervisor head of the institution in India Form B").save()
		def doc31 = new MstrDocument(docName: "Undertaking by the Applicant Form B").save()
		def doc32 = new MstrDocument(docName: "Declaration by the applicant on Nationality Form B").save()
		def doc33 = new MstrDocument(docName: "Declaration by the Applicant Form C").save()
		
		println "documents added successfully !!!"
//		forward action: "createTransactionIds"
		//forward action: "manageLoginContent"
	}
	
	def manageLoginContent() {
		def about = new ManageLoginContent(aboutNBA : "<p"+" class"+"="+"login-content leftflot color"+">"+"National Biodiversity Authority, established in 2003 to implement theBiological Diversity Act, 2002, is an autonomous and statutory body to perform regulatory and advisory functions for Government of India on issues of conservation of biodiversity, sustainable use of its components and realization of fair and equitable sharing of benefits arising out of use of biological resources."+"</p>"
														+"<p"+" class"+"="+"login-content leftflot color"+">"+"As part of its mandatory functions, NBA regulates access to Indiaâ€™s biological resources and associated knowledge by Indians and nonâ€�Indians as well, for various kinds of activities, such as access for research, commercial utilization and obtaining of IPRs for the inventions based on any research or information on a biological resource obtained from India."+"</p>"
														+"<p"+" class"+"="+"login-content leftflot color"+">"+"Biological Diversity Rules, 2004 lays down various Forms, fees, time lines and procedures to facilitate the applicants in obtaining prior approval of the NBA for various activities under the BD Act. The application may be submitted online using this platform. The applicants are requested to sign up and follow the procedures as per the instructions."+"</p>" , 
											latestUpdate: "<b>"+"Introduction of ABS e-filing beta version."+"</b>"	
															+"<p"+"class"+"="+"login-content leftflot color"+">"+"As a measure of providing improved services to the users, the NBA introduces e-filing of ABS Application through online by the users. Making use of this facility, users can submit application for access to biological resources and associated knowledge for various activities, attach the required documents and also make payment of fee at a time."+"</p>",
											instructions: "<p>As part of its continuous efforts in providing upgraded service to its stakeholders, the NBA has introduced online submission of application portal, integrated to its website, www.nbaindia.org.</p>"
														  +"<p>To avail the service, applicants are requested to register as user providing a login id (4 to 20 word) with a password having 4 to 12 word with at least one numeral or special character. Once registered, the user can log in and upload any number of applications without limit.</p>"
														  +"<p>Please keep all the information and scanned copies of the mandatory documents, such as, ID/Address Proof, companyâ€™s, MoA, AoA, shareholding pattern, Power of Attorney and Authorization letter ready.</p>"
														  +"<p>The following instructions will provide a step-to- step guide to fill up the Application Form without errors:</p>"
														  +"<span"+"class=col-sm-12 form-group"+">"+"<span"+"class=leftflot"+">"+"1.<"+"/span"+">"+"<span"+"class=col-sm-11 notificationwidth"+">"+"Name of applicant(s) and addresses should correspond with the name available in the ID/Address proofs submitted. Especially for Form III, the name given in the patent application and the name provided here should be one and same.</span></span> <span class="+"col-sm-12 form-group"+">"+"<span class="+"leftflot"+">2.</span> <span class="+"col-sm-11 notificationwidth"+">"+" If the contact person of the applicant is different from the person authorized to submit the application, separate authorization letters shall be provided by the applicant.</span></span>"
														  +"<span class="+"col-sm-12 form-group"+">"+"<span class="+"leftflot"+">3.</span> <span class="+"col-sm-11 notificationwidth"+">If the biological resources have already been procured by a person covered under section 3(2) for undertaking research leading to filing of IPR or intended for transfer, such applicant shall provide scanned copies of invoices/bills along with approval for access granted by NBA.</span></span>"
														  +"<span class="+"col-sm-12 form-group"+"><span class="+"leftflot"+">4.</span><span class="+"col-sm-11 notificationwidth"+">	If Research &amp; Development is undertaken in any national / other organization outside the applicantâ€™s institution/company based on any agreement or MoU, a copy of such document shall be uploaded.</span></span> "
														  +"<span class="+"col-sm-12 form-group"+">"+"<span class="+"leftflot"+">5.</span>  <span class="+"col-sm-11 notificationwidth"+">For transferring the results of research/ biological resources to a person covered under section 3(2), if there exists any agreement/MoU between the transferor and the transferee, scanned copy of such document shall be uploaded.</span> </span> <span class="+"col-sm-12 form-group"+">"+"<span class="+"leftflot"+">6.</span> <span class="+"col-sm-11 notificationwidth"+"> If the applicants"
														  +"have entered into any agreement with any person for commercializing the biological resources accessed or IPR obtained, copy of such document shall be uploaded.</span></span> "
														  +"<span class="+"col-sm-12 form-group"+">"+"<span class="+"leftflot"+">7."+"</span>  <span class="+"col-sm-11 notificationwidth"+">If the procurement of the biological resources is done after entering into any benefit sharing agreement with the benefit claimers by the applicant, copy of such agreement shall be uploaded.</span></span> "
														  +"<span class="+"col-sm-12 form-group"+"><span class="+"leftflot"+">8.</span> <span class="+"col-sm-11 notificationwidth"+">Details of benefits that may likely to arise out of the commercialization of the results of research/biological resources transferred to the transferor and the transferee shall be separately indicated in the application Form at the appropriate columns.</span></span><br /> General "
														  +"<span class="+"col-sm-12 form-group"+"><span class="+"leftflot"+">1.</span> <span class="+"col-sm-11 notificationwidth"+">The inputs provided in the application may be saved from time to time and only when the applicant is satisfied that complete and correct information has been uploaded, the Form may be submitted. Please note that after clicking submit button, no revision in the details already furnished is possible.</span></span> <span class="+"col-sm-12 form-group"+"><span class="+"leftflot"+">2.</span> <span class="+"col-sm-11 notificationwidth"+">After entering all the details, the form can be reviewed before final submission.</span> </span>"
														  +"<span class="+"col-sm-12 form-group"+"><span class="+"leftflot"+">3.</span><span class="+"col-sm-11 notificationwidth"+">After making final submission, a reference number will be generated and the applicants will be directed to payment of fees page, where a link is provided to SBI Connect. Using the facility provided, the applicant can make payment of application fee through e-payment.</span></span> <span class="+"col-sm-12 form-group"+"><span class="+"leftflot"+">4.</span> <span class="+"col-sm-11 notificationwidth"+">After making payment, a receipt containing declaration part of the application will generate and the applicant shall take a print out of the same,"
														  +" sign it at appropriate place and send the hard copy to the Secretary, NBA, at the address provided in the site.</span></span>",
											 faq: "<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" style=\"width:1000px\"> <tbody> <tr> <td style=\"height:5px; width:30px\">&nbsp; &nbsp;<strong>1</strong>&nbsp;</td> <td>&nbsp;<strong>How to start using e-filing portal?</strong></td> </tr><tr> <td>&nbsp;</td> <td><p>&nbsp;Applicants who wish to file application on-line shall register in the Home page of the site by clicking &ldquo;New Registration&rdquo; button, which will take them to Applicant&rsquo;s &nbsp;Profile page, where they are required to enter personal details along with a login ID and a password. There is a validation process, in which a confirmation mail will be &nbsp;sent to the email ID provided by the applicant in the profile page." 
											 		      + "By clicking the link provided in the email, the applicant will be directed to the Home page-log in site. &nbsp;If a user is already registered he can log in using the User ID and Password</p></td></tr><tr><td>&nbsp; &nbsp;<strong>2</strong></td><td>&nbsp;<strong>How to choose the correct application form ?</strong></td></tr><tr><td>&nbsp;</td><td><p>&nbsp;After log in and choosing &lsquo;Apply online&rsquo; from the main menu, the applicant will be taken to a page which will display &ldquo;Do you need assistance to know your application &nbsp;form?&rdquo; If you click &lsquo;yes&rsquo; then it will redirect you to &ldquo;Know Your Form&rdquo; page. If you click &lsquo;no&rsquo;, it will take you"
														  + "to a page containing four types of Forms and you can &nbsp;choose appropriate Form for online filing. Applicant can enter either as individual or as an entity and then the status and the type of activity for which approval is &nbsp;sought will be displayed. By selecting a particular activity, the applicant will be directed to the appropriate Form.</p></td></tr><tr><td>&nbsp; &nbsp;<strong>3</strong></td><td>&nbsp;<strong>What are the activities which need prior approval under the Biological Diversity Act 2002 ?</strong></td></tr><tr><td>&nbsp;</td><td><p>&nbsp;Accessing biological resources and/ or associated knowledge for:-</p><ol><li>Research</li><li>Bio-survey and Bio-utilization</li>"
														  + "<li>Commercial Utilization</li><li>Transfer of research results</li><li>Applying for Intellectual Property Rights</li><li>Third party transfer of accessed biological resources and/ or associated knowledge.</li></ol></td></tr><tr><td>&nbsp; &nbsp;<strong>4</strong></td><td>&nbsp;<strong>Who is required to get approval under the Act for accessing biological resources and/ or associated knowledge for the above activities ?</strong></td></tr><tr><td>&nbsp;</td><td><p>&nbsp;Accessing biological resources and/ or associated knowledge for:-</p><ol><li>Persons who are citizens of India,</li><li>Body corporate, association or organization registered in India</li><li>Persons who are not citizens of India</li>"
														  + "<li>Non-resident Indian as defined under clause 30 of Section 2 of the Income-Tax Act, 1961</li><li>Body corporate, Association or Organization which is not incorporated or registered in India</li><li>Body corporate, Association or Organisation incorporated or registered in India having non-Indian participation in its share capital or management.</li></ol></td></tr><tr><td>&nbsp; &nbsp;<strong>5</strong></td><td>&nbsp;<strong>What types of Application Forms they can file ?</strong></td></tr><tr><td>&nbsp;</td><td>"
														  + "<p>&nbsp;<strong>FormI</strong>: To access biological resources and/or associated knowledge occurring in India for research or bio-survey or bio-utilization or commercial utilization, by the &nbsp;person referred under sl.no iii, iv &amp; vi at question no.4<br /><br />"
														  + "&nbsp;<strong>FormII</strong>: To transfer results of research involving biological resources occurring in or obtained from India and/or associated knowledge to the persons who fall u/s 3(2) &nbsp;of the BD Act, by all persons referred under question no.4&nbsp;<br /><br />"
														  + "&nbsp;<strong>FormIII</strong>: To apply for patent in India or outside for the invention based on research or information on biological resources obtained from India, by all persons referred &nbsp;under question no.4&nbsp;<br /><br />&nbsp;<strong>FormIV</strong>: To transfer biological resources and/or associated knowledge already accessed by obtaining approval under Form I, to a third party, by the person referred &nbsp;under sl.no iii, iv &amp; vi at question no.4.</p></td></tr><tr><td>&nbsp; &nbsp;<strong>6</strong></td><td>&nbsp;<strong>What are the fees required to be paid for various forms ?</strong></td></tr><tr><td>&nbsp;</td><td>"
														  +"<p>&nbsp;<strong>Form I:</strong> INR 10,000&nbsp;<br />"
														  +"&nbsp;<strong>Form II:</strong> INR 5,000&nbsp;<br />"
														  +"&nbsp;<strong>Form III:</strong> INR 500<br />"
														  +"&nbsp;<strong>Form IV:</strong> INR 10,000</p></td></tr><tr><td>&nbsp; &nbsp;<strong>7</strong></td><td>&nbsp;<strong>What are the basic documents required to be kept ready before e-filing ?</strong></td></tr><tr><td>&nbsp;</td><td><p>&nbsp;Address/ID proof- self-attested copies of any one of the following documents, each in A &amp; B:<br /><strong>&nbsp;A &ndash; Address Proof</strong></p><ol><li>Valid passport</li><li>Overseas resident card / PIO card</li><li>Any document to prove NRI status</li><li>Aadhaar card</li></ol><strong>&nbsp;B &ndash; Identity Proof</strong><ol><li>Driving Licence</li><li>Government ID card</li><li>Aadhaar card</li><li>PAN Card</li><li>Voter ID</li></ol>"
														  +"<strong>&nbsp;Other documents required are</strong><ol><li>Letter of authorization, if there are more than one applicant or the applicant authorises someone or attorney to represent on his/her behalf</li><li>Proof for doing business (for entity) &ndash; Document of Incorporation</li><li>Agreement / MoU / letter of intent with the national/R&amp;D institution for collaboration.</li><li>Agreement / any negotiated instrument between applicant and provider of biological resources</li></ol><strong><em>&nbsp;Scanned copies of all these shall be self-attested and uploaded, wherever required, while filling up the Form.</em></strong></td></tr><tr><td>&nbsp; &nbsp;<strong>8</strong></td>"
														  +"<td>&nbsp;<strong>What is required to be done before submission of the Form ?</strong></td></tr><tr><td>&nbsp;</td><td><p>&nbsp;After entering necessary details and submitting the form, a unique reference number will be generated by the system and then the applicant will be led to the payment &nbsp;gateway to facilitate making payment of application fee though &lsquo;SBI collect&rsquo; link, online</p><p>&nbsp;Those who wish to make payment through &lsquo;SBI Collect&rsquo; can do so, by entering the unique number generated already and complete the payment process. After &nbsp;successful payment, an acknowledgement will be auto-generated with an application number</p><p>&nbsp;If no digital signature is available,"
														  +" a print out of the acknowledgement has to be taken and forwarded to the NBA, duly signed by the applicant</p><p>&nbsp;The applicant can also make payment through any other mode, provided, he/she has to submit reference number of the transaction and bank receipt to be uploaded &nbsp;by entering in the appropriate column. However, only on receipt of full payment by NBA, the application will be considered for processing</p></td></tr><tr><td>&nbsp; &nbsp;<strong>9</strong></td><td>&nbsp;<strong>What is meant by the term &ldquo;biological resource&rdquo; ?</strong></td></tr><tr><td>&nbsp;</td><td><p>&nbsp;&ldquo;Biological resources&quot; means plants, animals and micro-organisms or parts thereof, their genetic material and by products (excluding value added products) with &nbsp;actual or potential use or value, but does not include human genetic material&rdquo;</p>"
														  +"</td></tr><tr><td>&nbsp; <strong>10</strong></td><td>&nbsp;<strong>What denotes &quot;research&quot; under the Biological Diversity Act ?</strong></td></tr><tr><td>&nbsp;</td><td><p>&nbsp;&ldquo;Research&rdquo; means study or systematic investigation of any biological resource or technological application, that uses biological systems, living organisms or &nbsp;derivatives thereof to make or modify products or processes for any use;</p></td></tr><tr><td>&nbsp; <strong>11</strong></td><td>&nbsp;<strong>Define &ndash; &ldquo;bio survey and bio utilization?&rdquo; ?</strong></td></tr><tr><td>&nbsp;</td><td>"
														  +"<p>&nbsp;&ldquo;Bio survey and bio utilization&quot; means survey or collection of species, subspecies, genes, components and extracts of biological resource for any purpose and &nbsp;includes characterization, inventorization and bioassay.</p></td></tr><tr><td>&nbsp; <strong>12</strong></td><td>&nbsp;<strong>What is &ldquo;commercial utilization&quot; ?</strong></td></tr><tr><td>&nbsp;</td><td><p>&nbsp;&ldquo;Commercial utilization&rdquo; means end uses of biological resources for commercial utilization such as drugs, industrial enzymes, food flavours, fragrance, cosmetics, &nbsp;emulsifiers, oleoresins, colours, extracts and genes used for improving crops and livestock through genetic intervention, but does not include conventional breeding &nbsp;or traditional practices in use in any agriculture, horticulture, poultry, dairy farming, animal husbandry or bee keeping.</p>"
														  +"</td></tr><tr><td>&nbsp; <strong>13</strong></td><td>&nbsp;<strong>What kinds of benefits are envisaged under the benefit sharing arrangement approved by the NBA ?</strong></td></tr><tr><td>&nbsp;</td><td><p>&nbsp;The benefits include monetary and/ or non-monetary components. Examples could include grant of joint ownership of IPRs, transfer of technology, association of &nbsp;Indian Scientists in R&amp;D, setting up of venture capital fund, etc.</p></td></tr><tr><td>&nbsp; <strong>14</strong></td><td>&nbsp;<strong>How to change the login password ?</strong></td></tr><tr><td>&nbsp;</td><td>"
														  + "<p>&nbsp;Change Password facility is available under header menu on Home page. User has to ensure the strong password. As per present policy, the password must contain &nbsp;at least one lowercase, one numeral or special character in the password and the length should be at least 4 words..</p></td></tr><tr><td>&nbsp; <strong>15</strong></td><td>&nbsp;<strong>I need help and information about ABS E-filing system ?</strong></td></tr><tr><td>&nbsp;</td><td>"
														  + "<p>&nbsp;Live help is available during office hours (10.00 AM to 5:00 PM), on all working days. A staff member will answer your questions live and guide you further for filling &nbsp;up of application forms.<br />&nbsp;Call : +91 44 2254 2777 or mail to techbs@nba.nic.in.</p></td></tr><tr><td>&nbsp; <strong>16</strong></td><td>&nbsp;<strong>Which web browser is best suited for using the system ?</strong></td></tr><tr><td>&nbsp;</td><td><p>&nbsp;Internet Explorer 6 and above</p></td></tr><tr><td>&nbsp; <strong>17</strong></td><td>&nbsp;<strong>Can I edit the filled-in form after submitting declaration ?</strong></td></tr><tr><td>&nbsp;</td><td>"
														  + "<p>&nbsp;You can edit the filled-in form on preview screen before submission. Once it is submitted, it cannot be edited and only fresh application has to be filled in after &nbsp;trashing the previous one from your inbox</p></td></tr><tr><td>&nbsp; <strong>18</strong></td><td>&nbsp;<strong>The following error is appearing on the screen when I attempt to fill in a form: &ldquo;Error has occurred on the form. Please notify development team&rdquo;. What &nbsp;am I expected to do ?</strong></td></tr><tr><td>&nbsp;</td><td><p>&nbsp;Copy of the error details may be mailed to support@nbaindia.in or techbs@nba.nic.in for further action</p></td></tr><tr><td>&nbsp; <strong>19</strong></td>"
														  +"<td>&nbsp;<strong>Where can I check my application status from ?</strong></td></tr><tr><td>&nbsp;</td><td><p>&nbsp;Check your application status using the link provided on the main page</p></td></tr><tr><td>&nbsp; <strong>20</strong></td><td>&nbsp;<strong>Due to network problem, my link got disconnected while paying fee through online mode. My payment was not successful. What should I do ?</strong></td></tr><tr><td>&nbsp;</td><td><p>&nbsp;You can access the page again by login and make payment</p></td></tr><tr><td>&nbsp; <strong>21</strong></td><td>&nbsp;<strong>My online payment was unsuccessful. Can I pay the fee thro&rsquo; offline ?</strong></td></tr><tr><td>&nbsp;</td><td>"
														  + "<p>&nbsp;No, you can make payment of the fee online only. If payment is not successful, please retry after a gap of 10 minutes</p></td></tr><tr><td>&nbsp; <strong>22</strong></td><td>&nbsp;<strong>What is the difference between a declaration with digital signature and without digital signature ?</strong></td></tr><tr><td>&nbsp;</td><td><p>&nbsp;Applicant has two options to submit the online application viz. with digital signature or without digital signature</p><p>&nbsp;If he opts to submit the application with digital signature, the application will be treated as submitted once he signs the application digitally</p>"
														  +"<p>&nbsp;Otherwise, if he opts to submit without digital signature, he will be required to take print out of the auto generated declaration, affix signature on it and then submit to &nbsp;NBA</p></td></tr><tr><td>&nbsp;<strong> 23</strong></td><td>&nbsp;<strong>Is the Digital Signature a must ?</strong></td></tr><tr><td>&nbsp;</td><td><p>&nbsp;It is only optional, at present</p></td></tr><tr><td>&nbsp;<strong> 24</strong></td><td>&nbsp;<strong>Where can I get more information about the Biological Diversity Act and Rule ?</strong></td></tr><tr><td>&nbsp;</td><td>"
														  + "<p>&nbsp;The Biological Diversity Act and its Rules and other important notifications can be accessed through NBA&rsquo;s &nbsp;website<a href=\"http://nbaindia.org/content/18/21/1/notifications.html\">http://nbaindia.org/content/18/21/1/notifications.html.</a></p></td></tr><tr><td>&nbsp;<strong> 25</strong></td><td>&nbsp;<strong>I have more questions - what should I do</strong></td></tr><tr><td>&nbsp;</td><td>"
														  + "<p>&nbsp;Please email techbs@nba.nic.in, if you have any general question that hasn&#39;t been answered here. Please refer to FAQ 15 also</p></td></tr><tr><td>&nbsp;<strong> 26</strong></td><td>&nbsp;<strong>Is there a deadline for partially saved application ?</strong></td></tr><tr><td>&nbsp;</td><td><p>&nbsp;Yes. If your application remains unsubmitted for thirty days from the date of last login, it will be removed automatically. If necessary, you have to apply afresh</p></td></tr><tr><td>&nbsp;<strong> 27</strong></td><td>&nbsp;<strong>How do I know that my application is submitted successfully ?</strong></td></tr><tr><td>&nbsp;</td><td>"
														  +"<p>&nbsp;If the application is submitted successfully, the system will auto-generate a unique Application Number along with an Acknowledgement</p></td></tr><tr><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td><p><strong>&nbsp;Disclaimer :&nbsp;</strong>The information in this FAQ is intended only to provide a general overview of e-Filing of ABS application. For further details please login to &nbsp;www.nbaindia.org</p></td></tr></tbody></table><p>&nbsp;</p>").save(flush:true)
		
											
														  
					println "check for faqssssssssssssssssssssssssss"									  
		forward action: "createTransactionIds"
	}

	def createTransactionIds() {
		//1.
		println "creating 100 transaction for each form type "
		println "random number "+UUID.randomUUID().toString().toUpperCase()
		//2.
		def transactionId
		Double form1fee = 10000
		Double form2fee = 5000
		Double form3fee = 500
		Double form4fee = 10000

		//3.
		for(int i=1;i<=1000;i++){
			def transactionIdForm1 = new Transaction(transactionId:UUID.randomUUID().toString().toUpperCase().split('-')[4],formType:FormCategory.Category.Form_1,fee:form1fee)

			if(!transactionIdForm1.save(flush:true)){
				transactionIdForm1.errors.each{ println it }
			}
		}

		//4.
		for(int i=1;i<=1000;i++){
			def transactionIdForm2 = new Transaction(transactionId:UUID.randomUUID().toString().toUpperCase().split('-')[4],formType:FormCategory.Category.Form_2,fee:form2fee)

			if(!transactionIdForm2.save(flush:true)){
				transactionIdForm2.errors.each{ println it }
			}
		}

		//5.
		for(int i=1;i<=1000;i++){
			def transactionIdForm3 = new Transaction(transactionId:UUID.randomUUID().toString().toUpperCase().split('-')[4],formType:FormCategory.Category.Form_3,fee:form3fee)
			if(!transactionIdForm3.save(flush:true)){
				transactionIdForm3.errors.each{ println it }
			}
		}

		//6.
		for(int i=1;i<=1000;i++){
			def transactionIdForm4 = new Transaction(transactionId:UUID.randomUUID().toString().toUpperCase().split('-')[4],formType:FormCategory.Category.Form_4,fee:form4fee)

			if(!transactionIdForm4.save(flush:true)){
				transactionIdForm4.errors.each{ println it }
			}
		}
		forward action: "uploadDocs"
	}
	
	def uploadDocs = {
		println "ssssssssssssssssssssssssssssssssss"
		flash.message = params.msg1
		def formatMessage = params.msg1
		[listOfdocs:MstrDocument.list(), docId:params?.docId,formatMessage:formatMessage]
	}

	def addDocument = {
		println "inside add document.........................."+params
		def file, originalFileName, ext
		String filenamestring
		//if (idProofFile != null && idProofFile?.getBytes()?.size() != 0) {
		originalFileName = request.getFile('DocumentFormat')?.getOriginalFilename()
		
		
		filenamestring = originalFileName?.toString()
		
		println "filenamestring========="+filenamestring
		
		String[] parts = filenamestring?.split("\\.")
		ext = parts[parts.length -1 ]
		println "ext========="+ext
		if(ext != "pdf"){
//			return
			forward(action: "uploadDocs", params: [msg1: 'Please upload file in pdf document format only!', docId:params?.docId,
				appFormId:params.appFormId])
		}
		else{
		if (params.DocumentFormat !=null) {
			//def file = request.getFile('IdProof')
			file = request.getFile('DocumentFormat')
			int occurance = StringUtils.countOccurrencesOf(file.getOriginalFilename(), ".");
			def nullByteCheck = file.getOriginalFilename().contains('%00')
			
			println "original file name== "+file.getOriginalFilename()
			
			if(!file.getContentType().equalsIgnoreCase("application/pdf") ||  nullByteCheck){
				println '.........check check 1.............'
				flash.message = "Wrong format of pdf"
				forward(action: "uploadDocs", params: [msg1: 'Please upload file in pdf document format only!', docId:params?.docId,
					appFormId:params.appFormId])
			}
			if (occurance > 1) {
				
				println ".........check check 2............."
				flash.message = "Wrong format of pdf"
				forward(action: "uploadDocs", params: [msg1: 'Please upload file and file must be .pdf document format only!', docId:params?.docId,
					appFormId:params.appFormId])
			}
			try {
				PdfReader pdf = new PdfReader(file.getBytes())
				if(pdf && pdf.pdfVersion){}
				else{
					println ".........check check 3............."
					flash.message = "Wrong format of pdf"
					forward(action: "uploadDocs", params: [msg1: 'Wrong format of pdf!', docId:params?.docId])
					return
				}
			}catch (Exception e){
			
				println ".........check check 4............."
				println e.message
				flash.message = "Wrong format of pdf"
				forward(action: "uploadDocs", params: [msg1: 'Wrong format of pdf!', docId:params?.docId])

			}
			
			println ".........check check 5............."
			def docFormat = MstrDocument.findById(params.docId)
			docFormat.fileName = file.originalFilename
			docFormat.document = file.getBytes()
			docFormat.isActive = true
			docFormat.save(failOnError: true, flush: true)
			println "User doc format saved successfully"
			
		}
		}
		

		println "Adding new Doc "+params
		/*def file
		file = request.getFile('DocumentFormat')
		if(params.DocumentFormat !=null){
			println"hi this is new doc format file"
			def docFormat = MstrDocument.findById(params.docId)
			docFormat.fileName = file.originalFilename
			docFormat.document = file.getBytes()
			docFormat.isActive = true
			docFormat.save(failOnError: true, flush: true)
			println "User doc format saved successfully"
		}*/
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
		println "FILE == "+file

		byte[] DocContent = null;
		DocContent = file
		response.setHeader "Content-disposition", "inline; filename="+filename
		response.contentType = 'application/msword'
		response.outputStream << DocContent
		response.outputStream.flush()
	}
}
