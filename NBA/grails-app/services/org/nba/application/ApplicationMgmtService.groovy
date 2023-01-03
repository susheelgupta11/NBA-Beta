package org.nba.application

import grails.converters.JSON
import grails.transaction.Transactional

import javax.servlet.ServletRequestEvent
import javax.servlet.http.HttpServletRequest

import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap
import org.nba.common.Country
import org.nba.master.Question
import org.nba.master.QuestionCategory
import org.nba.master.FormAnswer
import org.nba.user.NbaUser
import org.springframework.web.context.request.ServletRequestAttributes

@Transactional
class ApplicationMgmtService {

	def springSecurityService
	def grailsApplication

	Map<ApplicationForm1, QuestionCategory> getFormQuestionAnswers(ApplicationForm1 appForm, QuestionCategory quesCategory) {
		def questionsList = Question.findAllByQuestionCategory(quesCategory)
		println("questionsList:" + questionsList+ " size is " + questionsList?.size())

		def answerList = FormAnswer.findAllByApplicationFormAndCategory(appForm,quesCategory)
		println("answerList:" + answerList + " size is " + answerList?.size() + "answer is : "+answerList?.answer)

		def mapOfQuesAnswers = [:]

		if (questionsList != null) {
			for (ques in questionsList) {
				def ans = null;
				if(answerList.size() != 0){
					for (ansInList in answerList) {
						if (ansInList.question.id == ques.id) {
							ans = ansInList
							break
						}
					}
				}

				mapOfQuesAnswers.put(ques, ans)
			}
		}

		return mapOfQuesAnswers
	}

	def saveQuestionAnswers (ApplicationForm1 appForm, QuestionCategory quesCategoryString, LinkedHashMap questionIdAnswerStringMap ) {

		println "quesCategoryString " + quesCategoryString + " appForm " + appForm

		def quesCategory =quesCategoryString
		println "quesCategory " + quesCategory

		println "Saving Answers....."


		questionIdAnswerStringMap.each { quesId, answer ->
			println "quesId " + quesId
			println "ANSWER " + answer
			def projQues = Question.findById(quesId)
			println "projQues " + projQues
			def projAns = FormAnswer.findByApplicationFormAndQuestion(appForm, projQues)
			if (projAns == null) {

				println "ans saved text type"
				projAns = new FormAnswer(question:projQues,applicationForm:appForm,
				answer:answer, category:quesCategory)
			} else {


				println "ans saved text type"
				println "projAns not null " + projAns
				projAns.answer = answer
				println "projAns.projectAnswer=" + projAns.answer
			}
			if(!projAns.save(flush:true)){
				projAns.errors.each{ println "ERROR IN SAVING PROJECT ANSWER IS "+it }
			}

			println "projAns saved " + projAns + "projAns.projectAnswer=" + projAns.answer
		}
	}


	def codesConcat(String mobilecode=null, String mobile=null, String areaCode=null, String phone=null, String PhoneCode=null, String pincode1=null, String pincode2=null, String personMobile1=null,String personMobile2=null){

		def completeMobileNumber,completePhoneNumber,completePinCode,completepersonMobile

		if(mobilecode != null && mobile != null){
			completeMobileNumber = Country.findByPhonecode(mobilecode)?.phonecode?.concat('-')?.concat(mobile)
			println "completeMobileNumber "+completeMobileNumber
			return completeMobileNumber
		}
		else if(phone != null && PhoneCode != null){
			completePhoneNumber = Country.findByPhonecode(PhoneCode)?.phonecode?.concat('-')?.concat(phone)
			println "completePhoneNumber "+completePhoneNumber
			return completePhoneNumber
		}
		else if(pincode1 != null && pincode2 != null){
			completePinCode = pincode1?.concat('-')?.concat(pincode2)
			println "completePinCode "+completePinCode
			return completePinCode
		}
		else if(personMobile1 != null && personMobile2 != null){
			completepersonMobile = personMobile1?.concat('-')?.concat(personMobile2)
			println "completepersonMobile "+completepersonMobile
			return completepersonMobile
		}
	}

	
	def saveIndividualProfile(GrailsParameterMap params,idProofFile, String idProofFilename, passportFile,String passportFilename,
			authorityLetter,String authorityLetterFilename,FormCategory category,ApplicationForm1 existingAppForm=null){



		def completeMobileNumber,completePhoneNumber,completePinCode,completepersonMobile
		def mobilecode = params.mobileCode
		def mobile = params.mobile
		println "mobile "+mobile+" mobile code "+mobilecode
		//For mobile no. concatenation
		completeMobileNumber = codesConcat(mobilecode,mobile,null,null,null,null,null,null,null);
		//For phone no. concatenation
		completePhoneNumber = codesConcat(null,null,null,params.phone,params.PhoneCode,null,null,null,null);
		//For pin-code concatenation
		//completePinCode = codesConcat(null,null,null,null,null,params.pincode1,params.pincode2,null,null);
		//For person mobile concatenation
		//completepersonMobile = codesConcat(null,null,null,null,null,null,null,params.personMobile1,params.personMobile2);

		println "completeMobileNumber11"+completeMobileNumber
		println "completePhoneNumber11"+completePhoneNumber
		println "completePinCode11"+completePinCode


		println "hELloooooooooooo passportFile "
		def province,profile,appStatus,appForm,country,emailLower

		if(params.email != null){
			emailLower = (params.email)?.toLowerCase()
		}

		if(springSecurityService.currentUser != null){
			//appForm = ApplicationForm1.findBySubmittedByAndCategory(springSecurityService.currentUser,category)
			if(existingAppForm == null){
				println "form Initiated"+ new Date()
				
				appForm = new ApplicationForm1(submittedBy:springSecurityService.currentUser,category:category)
				if(!appForm.save(flush:true)){
					appForm.errors.each{ println it }
				}
			}
			else{
				appForm = existingAppForm
			}

			//appStatus = new AppStatus(changedBy:springSecurityService.currentUser,status:AppStatus.Status.PENDING,application:appForm)
			if(appForm != null){
				appStatus = changeAppStatus(AppStatus.Status.PENDING,springSecurityService.currentUser,appForm?.id?.toString())
				println "appStatus == "+appStatus
			}

			if(!appStatus.save(flush:true)){
				appStatus.errors.each{ println it }
			}
		}
		if(params.title != '' && params.firstName != '' && params.lastName != '' && params.address1 != '' && params.mobile != '' && params.phone != '' && params.email != '' &&
		params.city != '' && params.pincode2 != ''){

			println "going to save individual profile"


			if(params.state != ''){
				println "params.state1"+params.state
				province = params.state
			}
			else if(params.province != ''){
				println "params.state2"+params.province
				province = params.province
			}


			//			if(params.otherProfile != ''){
			//
			//				profile = params.otherProfile
			//			}
			//			else if(params.profile != ''){
			//				profile = params.profile
			//			}

			if(params?.profile == 'Others'){
				profile = "Others-"+params.otherProfile
			}
			else{
				profile = params.profile
			}

			println "INDIA SELECTED "
			if(params.country != ''){
				country = Country.findByCountry(params.country)
			}
			else if(params.countryId != ''){
				country = Country.get(params.countryId)
			}

			
			def individualForm = new IndividualProfile(title:params.title,profile:profile, firstName: params.firstName ,middleName: params.middleName,
			lastName:params.lastName,nationality:params.nationality,address1:params.address1,address2:params.address2,address3:params.address3,
			country:country,province:province,city:params.city,pincode:params.pincode2,
			mobile:completeMobileNumber,phone:completePhoneNumber,email:emailLower,idProofFileName:idProofFilename,passportCopyFileName:passportFilename,
			authorizationLetterFileName :authorityLetterFilename,idProofSelect:params.idProofSelect,idNum:params.IdNum,passportSelect:params.passportSelect,
			passportNum:params.passportNum,authorizationSelect:params.authorizationSelect,authorizationNo:params.authorizationNo)

			
			
			if(passportFile != null){

				new File(grailsApplication.config.individualPassport.toString() + File.separatorChar +"Passport").mkdirs()
				def filePath = new File(grailsApplication.config.individualPassport.toString() + File.separatorChar + "Passport"+ File.separatorChar + passportFilename) ;
				passportFile.transferTo(filePath)
				 individualForm.passportURL = filePath;
			
			}
			if(idProofFile != null){
				
				new File(grailsApplication.config.individualId.toString() + File.separatorChar +"IdProof").mkdirs()
				def filePath = new File(grailsApplication.config.individualId.toString() + File.separatorChar + "IdProof"+ File.separatorChar + idProofFilename);
				idProofFile.transferTo(filePath)
				 individualForm.idProofURL = filePath;
			}
			if(authorityLetter != null){
				
				new File(grailsApplication.config.individualAuthority.toString() + File.separatorChar +"Authority").mkdirs()
				def filePath = new File(grailsApplication.config.individualAuthority.toString() + File.separatorChar + "Authority"+ File.separatorChar + authorityLetterFilename);
				authorityLetter.transferTo(filePath)
				 individualForm.authorizationLetterURL = filePath;
			}
			   
			
			
			

			appForm.addToIndividualProfiles(individualForm)
			appForm.currentStatus = appStatus
			if(!individualForm.save(flush:true)){
				individualForm.errors.each{ println it }
			}

			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}
			println "individualForm == "

		}
		return appForm
	}

	def updateIndividualProfile(GrailsParameterMap params, idProofFile, String idProofFilename, passportFile,String passportFilename,
			authorityLetter,String authorityLetterFilename,FormCategory category,IndividualProfile existingProfile){

		println "###############################################underUpdate----"+params
		//params.countryId  &&
		if(params.title != '' && params.firstName != '' && params.lastName != '' && params.address1 != '' && params.mobile != ''
		&& params.phone != '' && params.email != '' &&
		params.city != '' && params.pincode != ''){

			def completeMobileNumber,completePhoneNumber,completePinCode,completepersonMobile,profile,emailLower
			def mobilecode = params.mobileCode
			def mobile = params.mobile
			//For mobile no. concatenation
			completeMobileNumber = codesConcat(mobilecode,mobile,null,null,null,null,null,null,null);
			//For phone no. concatenation
			completePhoneNumber = codesConcat(null,null,null,params.phone,params.PhoneCode,null,null,null,null);
			//For pin-code concatenation
			//completePinCode = codesConcat(null,null,null,null,null,params.pincode1,params.pincode2,null,null);
			//For person mobile concatenation
			//completepersonMobile = codesConcat(null,null,null,null,null,null,null,params.personMobileCode,params.personMobile1);
			if(params.email != null){
				emailLower = (params.email)?.toLowerCase()
			}



			existingProfile.idProofSelect=params.idProofSelect
			existingProfile.idNum=params.IdNum
			existingProfile.passportSelect=params.passportSelect
			existingProfile.passportNum=params.passportNum
			existingProfile.authorizationSelect=params.authorizationSelect
			existingProfile.authorizationNo=params.authorizationNo

			existingProfile.title = params.title
			existingProfile.firstName = params.firstName
			existingProfile.middleName = params.middleName
			existingProfile.lastName = params.lastName
			existingProfile.address1 = params.address1
			existingProfile.address2 = params.address2
			existingProfile.address3 = params.address3
			existingProfile.nationality = params.nationality
			if(params?.profile == 'Others'){
				profile = "Others-"+params.otherProfile
			}
			else{
				profile = params.profile
			}
			existingProfile.profile = profile
			//println "OTHER PROFILE == "+existingProfile.profile

			if(params.country != ''){
				existingProfile.country = Country.findByCountry(params.country)
			}
			else{
				existingProfile.country = Country.get(params.countryId)
			}

			println "update---------------province afterwards-------------------------"+existingProfile.country
			if(params.province != ''){
				println "update---------------province1-------------------------"+params.province
				existingProfile.province = params.province
			}
			else if(params.state != ''){
				println "update---------------province2-------------------------"+params.state
				existingProfile.province = params.state
			}
			existingProfile.city = params.city
			existingProfile.pincode = params.pincode2
			existingProfile.mobile = completeMobileNumber
			existingProfile.phone = completePhoneNumber
			existingProfile.email = emailLower
			println "idProofFile.getBytes() "+idProofFile.getBytes()?.size()
			if(idProofFile != null && idProofFile?.getBytes()?.size() != 0){
				//println "SAVING EDITED FILE IDPROOF "+idProofFile

//				existingProfile.idProof = idProofFile.getBytes()

  new File(grailsApplication.config.individualId.toString() + File.separatorChar +"IdProof").mkdirs()
	   def filePath = new File(grailsApplication.config.individualId.toString() + File.separatorChar + "IdProof"+ File.separatorChar + idProofFilename);
	  
	     idProofFile.transferTo(filePath)
	    existingProfile.idProofURL = filePath;
		existingProfile.idProofFileName = idProofFilename

			}
			if(passportFile != null && passportFile?.getBytes()?.size() != 0){
//				existingProfile.passportCopy = passportFile.getBytes()
       new File(grailsApplication.config.individualPassport.toString() + File.separatorChar +"Passport").mkdirs()
	   def filePath = new File(grailsApplication.config.individualPassport.toString() + File.separatorChar + "Passport"+ File.separatorChar + passportFilename);
	           passportFile.transferTo(filePath)
	            existingProfile.passportURL = filePath;
				existingProfile.passportCopyFileName = passportFilename

			}
			if(authorityLetter != null && authorityLetter?.getBytes()?.size() != 0){
//				existingProfile.authorizationLetter= authorityLetter.getBytes()
		 new File(grailsApplication.config.individualAuthority.toString() + File.separatorChar +"Authority").mkdirs()
	     def filePath = new File(grailsApplication.config.individualAuthority.toString() + File.separatorChar + "Authority"+ File.separatorChar + authorityLetterFilename);
	  
		        authorityLetter.transferTo(filePath)
	            existingProfile.authorizationLetterURL = filePath;
				existingProfile.authorizationLetterFileName  = authorityLetterFilename

			}


			if(!existingProfile.save(flush:true)){
				existingProfile.errors.each{ println it }
			}

			println "Saved successfully 1##########################################"
		}
		String msgg = "Updated Successfully"
		return msgg
	}
	def saveAgentProfile(GrailsParameterMap params, agentAuthorityFile,String agentAuthorityFileName, agentPassportFile,
			String agentPassportFilename,FormCategory category,ApplicationForm1 appForm){

		println "In service, method saveAgentProfile()................."+appForm
		println "===================params.name=================="+"("+params.name+")"

		def province,agentProfile,profileSpecified,agentEmailLower

		def completeMobileNumber,completePhoneNumber,completePinCode
		def mobilecode = params.mobileCode
		def mobile = params.mobile
		println "mobile "+mobile+" mobile code "+mobilecode
		//For mobile no. concatenation
		completeMobileNumber = codesConcat(mobilecode,mobile,null,null,null,null,null,null,null);
		//For pin-code concatenation
		//completePinCode = codesConcat(null,null,null,null,null,params.pincode1,params.pincode2,null,null);
		//For Phone number
		completePhoneNumber = codesConcat(null,null,null,params.phone,params.PhoneCode,null,null,null,null);

		println "completeMobileNumber11"+completeMobileNumber
		println "completePinCode11"+completePinCode

		if(params.agentEmail != null){
			agentEmailLower = (params.agentEmail)?.toLowerCase()
		}

		if(params.agentTitle && params.agentTitle != '' && params.agentFirstName != '' && params.agentLastName != '' && params.agentAddress1 != '' && params.agentCity != ''
		&& params.mobile != '' && params.agentEmail != '' && params.pincode1 != ''){
			println "Inside agent profile"

			if(params.agentProfile == 'Others'){
				profileSpecified = "Others-"+params.otherProfile
			}
			else if(params.agentProfile != 'Others'){
				profileSpecified = params.agentProfile
			}

			if(params.agentState != ''){
				province = params.agentState
			}
			else if(params.agentProvince != ''){
				province = params.agentProvince
			}
			if(params.isCompanyProfile == 'true'){
				println "===================params.name2222=================@@@@@@@@@@="+"("+params.name+")"
				agentProfile = new AgentProfile(title:params.agentTitle,firstName: params.agentFirstName ,middleName: params.agentMiddleName,
				lastName:params.agentLastName,address1:params.agentAddress1,address2:params.agentAddress2,address3:params.agentAddress3,photoIdSelect:params.photoIdSelect,photoIdNum:params.photoIdNum,
				province:params.agentProvince,city:params.agentCity,pincode:params.pincode2, profile:profileSpecified,phone: completePhoneNumber,
				mobile:completeMobileNumber,email:agentEmailLower,passportCopyFileName:agentPassportFilename,
				authorizationLetterFileName :agentAuthorityFileName,applicationForm:appForm,isCompanyAgent:true)
			}
			else if(params.isIndividualProfile == 'true'){
				println "INDIVIDUAL PROFILE"
				println "===================params.name=================@@@@@@@@@@="+"("+params.name+")"
				agentProfile = new AgentProfile(title:params.agentTitle,firstName: params.agentFirstName ,middleName: params.agentMiddleName,
				lastName:params.agentLastName,address1:params.agentAddress1,address2:params.agentAddress2,address3:params.agentAddress3,
				province:params.agentProvince,city:params.agentCity,pincode:params.pincode2, profile:profileSpecified,photoIdSelect:params.photoIdSelect,photoIdNum:params.photoIdNum,
				mobile:completeMobileNumber,email:agentEmailLower,passportCopyFileName:agentPassportFilename,
				authorizationLetterFileName :agentAuthorityFileName,applicationForm:appForm,isIndividualAgent:true)
			}

			println "Reached here"
			
			if(agentPassportFile != null && agentPassportFile?.getBytes()?.size() != 0){
			
			new File(grailsApplication.config.agentDocuments.toString() + File.separatorChar +"agentPassport").mkdirs()
			def filePath = new File(grailsApplication.config.agentDocuments.toString() + File.separatorChar + "agentPassport"+ File.separatorChar + agentPassportFilename);
		   
			  agentPassportFile.transferTo(filePath)
			  agentProfile.agentPassportURL = filePath
			  
			}
			if(agentAuthorityFile != null && agentAuthorityFile?.getBytes()?.size() !=0){
				
			  new File(grailsApplication.config.agentDocuments.toString() + File.separatorChar +"agentAuthority").mkdirs()
			  def filePath = new File(grailsApplication.config.agentDocuments.toString() + File.separatorChar + "agentAuthority"+ File.separatorChar + agentAuthorityFileName);
			 
				agentAuthorityFile.transferTo(filePath)
				agentProfile.agentAuthorizationURL = filePath
			
			}
			

			if(!agentProfile.save(flush:true)){
				agentProfile.errors.each{ println it }
			}

			appForm.agentProfile = agentProfile

			if(!appForm.save()){
				appForm.errors.each{ println it }
			}
			println "agent Saved successfully "+agentProfile
			return agentProfile
		}

		
	}

	def updateAgentProfile(AgentProfile existingAgentProfile,GrailsParameterMap params, agentAuthorityFile,String agentAuthorityFileName, agentPassportFile,
			String agentPassportFilename,FormCategory category,ApplicationForm1 appForm){

		println "In service .............."+appForm
		def province,profileSpecified

		def completeMobileNumber,completePhoneNumber,completePinCode,agentEmailLower
		def mobilecode = params.mobileCode
		def mobile = params.mobile
		println "mobile "+mobile+" mobile code"+mobilecode
		//For mobile no. concatenation
		completeMobileNumber = codesConcat(mobilecode,mobile,null,null,null,null,null);
		//For pin-code concatenation
		//completePinCode = codesConcat(null,null,null,null,null,params.pincode1,params.pincode2);

		if(params.agentEmail != null){
			agentEmailLower = (params.agentEmail)?.toLowerCase()
		}

		println "completeMobileNumber11"+completeMobileNumber
		println "completePinCode11"+completePinCode

		if(params.agentTitle != '' && params.agentFirstName != '' && params.agentLastName != '' && params.agentAddress1 != '' && params.agentCity != ''
		&& params.mobile != '' && params.agentEmail != '' && params.pincode1 != ''){
			println "Inside agent profile"

			if(params.agentProfile == 'Others'){
				profileSpecified = "Others-"+params.otherProfile
			}
			else if(params.agentProfile != 'Others'){
				profileSpecified = params.agentProfile
			}

			if(params.agentState != ''){
				existingAgentProfile.province = params.agentState
			}
			else if(params.agentProvince != ''){
				existingAgentProfile.province = params.agentProvince
			}
			//if(params.isCompanyProfile == 'true'){
			existingAgentProfile.title=params.agentTitle
			existingAgentProfile.firstName= params.agentFirstName
			existingAgentProfile.middleName=params.agentMiddleName
			existingAgentProfile.lastName=params.agentLastName
			existingAgentProfile.address1=params.agentAddress1
			existingAgentProfile.address2=params.agentAddress2
			existingAgentProfile.address3=params.agentAddress3
			existingAgentProfile.province=params.agentProvince
			existingAgentProfile.city=params.agentCity
			existingAgentProfile.pincode=params.pincode2
			existingAgentProfile.mobile=completeMobileNumber
			existingAgentProfile.email=agentEmailLower
			existingAgentProfile.photoIdSelect=params.photoIdSelect
			existingAgentProfile.photoIdNum=params.photoIdNum

			if(params.isCompanyProfile == 'true'){
				existingAgentProfile.profile = params.profile
			}
			else{
				existingAgentProfile.profile=profileSpecified
			}
			if(agentPassportFile != null && agentPassportFile?.getBytes()?.size() != 0){
			
	//				existingAgentProfile.passportCopy=agentPassportFile.getBytes()
				
				new File(grailsApplication.config.agentDocuments.toString() + File.separatorChar +"agentPassport").mkdirs()
				def filePath = new File(grailsApplication.config.agentDocuments.toString() + File.separatorChar + "agentPassport"+ File.separatorChar + agentPassportFilename);
			   
				  agentPassportFile.transferTo(filePath)
				  existingAgentProfile.agentPassportURL = filePath
				existingAgentProfile.passportCopyFileName=agentPassportFilename
				
			}
			if(agentAuthorityFile != null && agentAuthorityFile?.getBytes()?.size() != 0){
			
//					existingAgentProfile.authorizationLetter=agentAuthorityFile.getBytes()
				
				new File(grailsApplication.config.agentDocuments.toString() + File.separatorChar +"agentAuthority").mkdirs()
				def filePath = new File(grailsApplication.config.agentDocuments.toString() + File.separatorChar + "agentAuthority"+ File.separatorChar + agentAuthorityFileName);
			   
				  agentAuthorityFile.transferTo(filePath)
				
				  existingAgentProfile.agentAuthorizationURL = filePath
				  existingAgentProfile.authorizationLetterFileName =agentAuthorityFileName
			}
			existingAgentProfile.applicationForm=appForm
			//}
			/*else if(params.isIndividualProfile == 'true'){
			 agentProfile = new AgentProfile(title:params.agentTitle,firstName: params.agentFirstName ,middleName: params.agentMiddleName,
			 lastName:params.agentLastName,address1:params.agentAddress1,address2:params.agentAddress2,address3:params.agentAddress3,
			 province:params.agentProvince,city:params.agentCity,pincode:completePinCode,
			 mobile:completeMobileNumber,email:params.agentEmail,passportCopy:agentPassportFile.getBytes(),passportCopyFileName:agentPassportFilename,authorizationLetter:agentAuthorityFile.getBytes(),
			 authorizationLetterFileName :agentAuthorityFileName,applicationForm:appForm,isIndividualAgent:true)
			 }
			 */
			println "Reached here"

			if(!existingAgentProfile.save(flush:true)){
				existingAgentProfile.errors.each{ println it }
			}

			appForm?.agentProfile = existingAgentProfile

			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}
			println "agent Saved successfully "+existingAgentProfile
			return existingAgentProfile
		}
	}

	def saveIndianResearcher(GrailsParameterMap params,FormCategory category,ApplicationForm1 existingAppForm=null,addressproofLetterDocFile,addressproofLetterDocFilename){
		println "inside save indian researcher----"+params
		def mobilecode = params.mobileCode
		def mobile = params.mobile
		def PresentMobileCode =params.PresentMobileCode
		def PresentMobile=params.presentMobile
		def PresentPhoneCode =params.PresentPhoneCode
		def PresentPhone=params.presentPhone
		println "4444444 "
		def province,appStatus,natureOfBusiness,emailLower,personEmailLower,appForm ,completePresentMobileNumber,completePresentPhoneNumber
		def completeMobileNumber,completePhoneNumber,completePinCode,completepersonMobile
		completeMobileNumber = codesConcat(mobilecode,mobile,null,null,null,null,null,null,null);

		completePhoneNumber = codesConcat(null,null,null,params.phone,params.PhoneCode,null,null,null,null);

		completePresentMobileNumber = codesConcat(PresentMobileCode,PresentMobile,null,null,null,null,null,null,null);

		completePresentPhoneNumber = codesConcat(null,null,null,PresentPhone,PresentPhoneCode,null,null,null,null);

		completepersonMobile = codesConcat(null,null,null,null,null,null,null,params.personMobileCode,params.personMobile1);

		
		println "completePresentMobileNumber-----"+completePresentMobileNumber
		println "completePresentPhoneNumber------"+completePresentPhoneNumber
		
		if(params.email != null){
			emailLower = (params.email)?.toLowerCase()
		}

		if(params.personEmail != null){
			personEmailLower = (params.personEmail)?.toLowerCase()
		}
		println "5555555555555 "

		//
		if(existingAppForm == null){
			appForm = new ApplicationForm1(submittedBy:springSecurityService.currentUser,category:category)
			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}
		}
		else {
			appForm = existingAppForm
		}
		if(appForm != null){
			println "6666666"+appForm
			appStatus = changeAppStatus(AppStatus.Status.PENDING,springSecurityService.currentUser,appForm?.id?.toString())
			println "appStatus == "+appStatus
		}
		if(!appStatus.save(flush:true)){
			appStatus.errors.each{ println it }
		}

		//


		if(params.entityName != '' &&  params.address1 != '' && params.mobile != '' && params.phone != ''
		&& params.email != '' && params.countryId != '' && params.city != ''   && params.website != '' && params.businessNature != '' &&
		params.title != '' && params.firstName != '' && params.lastName != '' && params.personEmail != '' && params.personMobile1 != ''){

			if(params.state != ''){
				province = params.state
			}
			 if(params.province != null){
				province = params.province
			}

			if(params.businessNature == 'Others'){
				natureOfBusiness = 'Others-'+params.otherNatureOfBusiness
			}
			else{
				natureOfBusiness = params.businessNature
			}
			print "Nationality..."+params.nationality
			println "Country.get(params.countryId)--"+Country.get(params.countryId)
			def indianResearcherForm = new IndianResearcher(entityName:params.entityName,nationality:params.nationality,lastName:params.lastName,addressproofNo:params?.addressproofNo,
			address1:params.address1,address2:params.address2,address3:params.address3,addressproofLetterFileName:addressproofLetterDocFilename,
			country:Country.get(params.countryId),city:params.city,pincode:params.pincode2,samePresentAddress:params.samePresentAddress,addressproofSelect:params?.addressproofSelect,
			mobile:completeMobileNumber,phone:completePhoneNumber,email:emailLower,designation:params.designation,authRepresentativeIdSelect:params.authRepresentativeIdSelect,
			businessNature:natureOfBusiness,province:province, title:params.title,firstName:params.firstName,middleName:params.middleName,idNum:params.idNum,presentAddress1:params.presentAddress1,presentAddress2:params.presentAddress2,
			presentAddress3:params.presentAddress3,presentCity:params.presentCity,presentProvince:params.presentProvince,presentPincode:params.presentPincode,presentCountry:params.presentCountry,presentMobile:completePresentMobileNumber,presentPhone:completePresentPhoneNumber,presentEmail:params.presentEmail)

			
			
			new File(grailsApplication.config.indianResearcherAddress.toString() + File.separatorChar +"IND-RESEARCHER").mkdirs()
			def filePath = new File(grailsApplication.config.indianResearcherAddress.toString() + File.separatorChar + "IND-RESEARCHER"+ File.separatorChar + addressproofLetterDocFile.getOriginalFilename());
		   
			  addressproofLetterDocFile.transferTo(filePath)
			 indianResearcherForm.addressproofLetterURL = filePath;
			
//			addressproofLetter:addressproofLetterDocFile?.getBytes()
			appForm.addToIndianResearcher(indianResearcherForm)
			

			if(!indianResearcherForm.save(flush:true)){
				indianResearcherForm.errors.each{ println it }
			}
			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}

			println "Saved successfully "
		}
		return appForm

	}

	//updateindianresearcher
	def updateIndianResearcher(GrailsParameterMap params,FormCategory category,IndianResearcher existingProfile, addressproofLetterDocFile,String addressproofLetterDocFilename){


		def province,natureOfBusiness,personEmailLower
		//		if(params.entityName && params.entityType &&  params.address1 && params.mobile && params.phone && params.email && params.countryId && params.state &&
		//		params.city && params.pincode && params.entityName && params.website && params.businessNature){
		println "profileID inside  updateCompanyProfile2222 "+params
		println "addressproofLetterDocFile--------"+addressproofLetterDocFile

		def completeMobileNumber,completePhoneNumber,completePinCode,completepersonMobile,emailLower,completePresentMobileNumber,completePresentPhoneNumber
		def mobilecode = params.mobileCode
		def mobile = params.mobile
		def PresentMobileCode =params.PresentMobileCode
		def PresentMobile=params.presentMobile
		def PresentPhoneCode =params.PresentPhoneCode
		def PresentPhone=params.presentPhone
		//For mobile no. concatenation
		completeMobileNumber = codesConcat(mobilecode,mobile,null,null,null,null,null,null,null);
		//For phone no. concatenation
		completePhoneNumber = codesConcat(null,null,null,params?.phone,params?.PhoneCode,null,null,null,null);
		//For pin-code concatenation
		//completePinCode = codesConcat(null,null,null,null,null,params.pincode1,params.pincode2,null,null);
		//For person mobile concatenation
		
		completePresentMobileNumber = codesConcat(PresentMobileCode,PresentMobile,null,null,null,null,null,null,null);
		
		completePresentPhoneNumber = codesConcat(null,null,null,PresentPhone,PresentPhoneCode,null,null,null,null);
		
		
		
		completepersonMobile = codesConcat(null,null,null,null,null,null,null,params.personMobileCode,params.personMobile1);

		if(params.email != null){
			emailLower = (params.email)?.toLowerCase()
		}

		if(params.personEmail != null){
			personEmailLower = (params.personEmail)?.toLowerCase()
		}

		if(params.businessNature == 'Others'){
			natureOfBusiness = 'Others-'+params.otherNatureOfBusiness
		}
		else{
			natureOfBusiness = params.businessNature
		}
		existingProfile.entityName = params.entityName
		existingProfile.address1 = params.address1
		existingProfile.address2 = params.address2
		existingProfile.address3 = params.address3
		existingProfile.nationality = params.nationality
		existingProfile.country = Country.get(params.countryId)
//		existingProfile.country = params.countryId
		if(params.state != ''||params.state != null){
			println "+++++11++++++"+params.province
				province = params.state
			}
		 if(params.province != null){
				println "+++++22++++++"
				province = params.province
			}
		println "+++++++++++"+province+"..............."+params.province
		existingProfile.province = province
		existingProfile.city = params.city
		existingProfile.pincode = params.pincode2
		existingProfile.mobile = completeMobileNumber
		existingProfile.phone = completePhoneNumber
		existingProfile.email = emailLower

		existingProfile.addressproofSelect=params.addressproofSelect
		existingProfile.addressproofNo=params.addressproofNo
//		existingProfile.authorizationNo=params.addressproofLetter
		
		existingProfile.designation = params.designation
		existingProfile.idNum=params.idNum
		existingProfile.title = params.title
		existingProfile.firstName = params.firstName
		existingProfile.middleName = params.middleName
		existingProfile.lastName = params.lastName
		
		existingProfile?.samePresentAddress = params?.samePresentAddress
		if(params?.samePresentAddress == 'No'){
			existingProfile?.presentAddress1 = params.presentAddress1
			existingProfile?.presentAddress2 = params.presentAddress2
			existingProfile?.presentAddress3 = params.presentAddress3
			existingProfile?.presentCity = params.presentCity
			existingProfile?.presentProvince = params.presentProvince
			existingProfile?.presentPincode = params.presentPincode
			existingProfile?.presentCountry = Country?.get(params.presentCountry)
			existingProfile?.presentMobile = completePresentMobileNumber
			existingProfile?.presentPhone = completePresentPhoneNumber
			existingProfile?.presentEmail = params.presentEmail
		}
		else{
			existingProfile?.presentAddress1 = null
			existingProfile?.presentAddress2 = null
			existingProfile?.presentAddress3 = null
			existingProfile?.presentCity = null
			existingProfile?.presentProvince = null
			existingProfile?.presentPincode = null
			existingProfile?.presentCountry = null
			existingProfile?.presentMobile = null
			existingProfile?.presentPhone = null
			existingProfile?.presentEmail = null
		}
		
		if(addressproofLetterDocFilename != null && addressproofLetterDocFile?.getBytes()?.size() != 0){
			
			new File(grailsApplication.config.indianResearcherAddress.toString() + File.separatorChar +"IND-RESEARCHER").mkdirs()
			def filePath = new File(grailsApplication.config.indianResearcherAddress.toString() + File.separatorChar + "IND-RESEARCHER"+ File.separatorChar + addressproofLetterDocFile.getOriginalFilename());
		   
			  addressproofLetterDocFile.transferTo(filePath)
			 existingProfile?.addressproofLetterURL = filePath;
			
			
//			existingProfile?.addressproofLetter= addressproofLetterDocFile?.getBytes()
			existingProfile?.addressproofLetterFileName  = addressproofLetterDocFilename
		}
		if(!existingProfile.save(flush:true)){
			existingProfile.errors.each{ println it }
		}

		println "Saved successfully "+existingProfile
		//}
		return
	}
	//
	
	def saveIndianGovtInst(GrailsParameterMap params,FormCategory category,ApplicationForm1 existingAppForm=null,addressproofLetterDocFile,addressproofLetterDocFilename){
		
		println "inside save indian researcher----"+params
		def mobilecode = params.mobileCode
		def mobile = params.mobile
		def PresentMobileCode =params.PresentMobileCode
		def PresentMobile=params.presentMobile
		def PresentPhoneCode =params.PresentPhoneCode
		def PresentPhone=params.presentPhone
		println "4444444 "
		def province,appStatus,natureOfBusiness,emailLower,personEmailLower,appForm ,completePresentMobileNumber,completePresentPhoneNumber
		def completeMobileNumber,completePhoneNumber,completePinCode,completepersonMobile
		completeMobileNumber = codesConcat(mobilecode,mobile,null,null,null,null,null,null,null);

		completePhoneNumber = codesConcat(null,null,null,params.phone,params.PhoneCode,null,null,null,null);

		completePresentMobileNumber = codesConcat(PresentMobileCode,PresentMobile,null,null,null,null,null,null,null);

		completePresentPhoneNumber = codesConcat(null,null,null,PresentPhone,PresentPhoneCode,null,null,null,null);

		completepersonMobile = codesConcat(null,null,null,null,null,null,null,params.personMobileCode,params.personMobile1);

		
		println "completePresentMobileNumber-----"+completePresentMobileNumber
		println "completePresentPhoneNumber------"+completePresentPhoneNumber
		
		if(params.email != null){
			emailLower = (params.email)?.toLowerCase()
		}

		if(params.personEmail != null){
			personEmailLower = (params.personEmail)?.toLowerCase()
		}
		println "5555555555555 "

		//
		if(existingAppForm == null){
			appForm = new ApplicationForm1(submittedBy:springSecurityService.currentUser,category:category)
			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}
		}
		else {
			appForm = existingAppForm
		}
		if(appForm != null){
			println "6666666"+appForm
			appStatus = changeAppStatus(AppStatus.Status.PENDING,springSecurityService.currentUser,appForm?.id?.toString())
			println "appStatus == "+appStatus
		}
		if(!appStatus.save(flush:true)){
			appStatus.errors.each{ println it }
		}

		//


		if(params.govtInstName != '' &&  params.address1 != '' && params.mobile != '' && params.phone != ''
		&& params.email != '' && params.countryId != '' && params.city != ''   && params.website != '' && params.businessNature != '' &&
		params.title != '' && params.firstName != '' && params.lastName != '' && params.personEmail != '' && params.personMobile1 != ''){

			if(params.state != ''){
				province = params.state
			}
			else if(params.province != ''){
				province = params.province
			}

			if(params.businessNature == 'Others'){
				natureOfBusiness = 'Others-'+params.otherNatureOfBusiness
			}
			else{
				natureOfBusiness = params.businessNature
			}
			print "Nationality..."+params.nationality
			
			def indianGovtInstForm = new IndianGovtInst(govtInstName:params.govtInstName,address1:params.address1,address2:params.address2,address3:params.address3,
			country:Country.get(params.countryId),city:params.city,pincode:params.pincode2,samePresentAddress:params?.samePresentAddress,
			phone:completePhoneNumber,email:emailLower,designation:params.designation,authRepresentativeIdSelect:params?.authRepresentativeIdSelect,
			businessNature:natureOfBusiness,idNum:params.idNum,presentAddress1:params.presentAddress1,presentAddress2:params.presentAddress2,
			presentAddress3:params.presentAddress3,presentCity:params.presentCity,presentProvince:params.presentProvince,presentPincode:params.presentPincode,
			presentCountry:params.presentCountry,presentPhone:completePresentPhoneNumber,presentEmail:params.presentEmail)

			appForm.addToIndianGovtInst(indianGovtInstForm)

			if(!indianGovtInstForm.save(flush:true)){
				indianGovtInstForm.errors.each{ println it }
			}
			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}

			println "Saved successfully "
		}
		return appForm

	
	}
	
	def updateIndianGovtInst(GrailsParameterMap params,FormCategory category,IndianGovtInst existingProfile, addressproofLetterDocFile,String addressproofLetterDocFilename){
		
				def province,natureOfBusiness,personEmailLower
				//		if(params.entityName && params.entityType &&  params.address1 && params.mobile && params.phone && params.email && params.countryId && params.state &&
				//		params.city && params.pincode && params.entityName && params.website && params.businessNature){
				println "profileID inside  updateCompanyProfile2222 "+params
				println "addressproofLetterDocFile--------"+addressproofLetterDocFile
		
				def completeMobileNumber,completePhoneNumber,completePinCode,completepersonMobile,emailLower,completePresentMobileNumber,completePresentPhoneNumber 
				def mobilecode = params.mobileCode
				def mobile = params.mobile
				def PresentMobileCode =params.PresentMobileCode
				def PresentMobile=params.presentMobile
				def PresentPhoneCode =params.PresentPhoneCode
				def PresentPhone=params.presentPhone
				//For mobile no. concatenation
				completeMobileNumber = codesConcat(mobilecode,mobile,null,null,null,null,null,null,null);
				//For phone no. concatenation
				completePhoneNumber = codesConcat(null,null,null,params?.phone,params?.PhoneCode,null,null,null,null);
				
				completePresentMobileNumber = codesConcat(PresentMobileCode,PresentMobile,null,null,null,null,null,null,null);
				
				completePresentPhoneNumber = codesConcat(null,null,null,PresentPhone,PresentPhoneCode,null,null,null,null);
				//For pin-code concatenation
				//completePinCode = codesConcat(null,null,null,null,null,params.pincode1,params.pincode2,null,null);
				//For person mobile concatenation
				completepersonMobile = codesConcat(null,null,null,null,null,null,null,params.personMobileCode,params.personMobile1);
		
				if(params.email != null){
					emailLower = (params.email)?.toLowerCase()
				}
		
				if(params.personEmail != null){
					personEmailLower = (params.personEmail)?.toLowerCase()
				}
		
				if(params.businessNature == 'Others'){
					natureOfBusiness = 'Others-'+params.otherNatureOfBusiness
				}
				else{
					natureOfBusiness = params.businessNature
				}
				existingProfile.govtInstName = params.govtInstName
				existingProfile.address1 = params.address1
				existingProfile.address2 = params.address2
				existingProfile.address3 = params.address3
//				existingProfile.nationality = params.nationality
				existingProfile.country = Country.get(params.countryId)
				if(params.state != ''){
					province = params.state
				}
				else if(params.province != ''){
					province = params.province
				}
				
				existingProfile.province = province
				existingProfile.city = params.city
				existingProfile.pincode = params.pincode2
//				existingProfile.mobile = completeMobileNumber
				existingProfile.phone = completePhoneNumber
				existingProfile.email = emailLower
				existingProfile?.samePresentAddress = params?.samePresentAddress
				
				
				if(params?.samePresentAddress == 'No'){
						existingProfile?.presentAddress1 = params.presentAddress1
						existingProfile?.presentAddress2 = params.presentAddress2
						existingProfile?.presentAddress3 = params.presentAddress3
						existingProfile?.presentCity = params.presentCity
						existingProfile?.presentProvince = params.presentProvince
						existingProfile?.presentPincode = params.presentPincode
						existingProfile?.presentCountry = Country?.get(params.presentCountry)
						existingProfile?.presentPhone = completePresentPhoneNumber
						existingProfile?.presentEmail = params.presentEmail
				}
				else{
						existingProfile?.presentAddress1 = null
						existingProfile?.presentAddress2 = null
						existingProfile?.presentAddress3 = null
						existingProfile?.presentCity = null
						existingProfile?.presentProvince = null
						existingProfile?.presentPincode = null
						existingProfile?.presentCountry = null
						existingProfile?.presentPhone = null
						existingProfile?.presentEmail = null
				}
				
//				existingProfile.addressproofSelect=params.addressproofSelect
//				existingProfile.addressproofNo=params.addressproofNo
		//		existingProfile.authorizationNo=params.addressproofLetter
				
				existingProfile.designation = params.designation
				existingProfile.idNum=params.idNum
//				existingProfile.title = params.title
//				existingProfile.firstName = params.firstName
//				existingProfile.middleName = params.middleName
//				existingProfile.lastName = params.lastName
		
//				if(addressproofLetterDocFilename != null && addressproofLetterDocFile?.getBytes()?.size() != 0){
//					existingProfile.addressproofLetter= addressproofLetterDocFile.getBytes()
//					existingProfile.addressproofLetterFileName  = addressproofLetterDocFilename
//				}
				if(!existingProfile.save(flush:true)){
					existingProfile.errors.each{ println it }
				}
		
				println "Saved successfully "+existingProfile
				//}
				return
			
	}
	

	def updateDepositionOfMicroOrganism(GrailsParameterMap params,FormCategory category,DepositionOfMicroOrganism existingProfile){


		def province
		//		if(params.entityName && params.entityType &&  params.address1 && params.mobile && params.phone && params.email && params.countryId && params.state &&
		//		params.city && params.pincode && params.entityName && params.website && params.businessNature){


		def completeMobileNumber,completePhoneNumber,completePinCode,completepersonMobile,emailLower
		def mobilecode = params.mobileCode
		def mobile = params.mobile
		//For mobile no. concatenation
		println "profileID inside  updateCompanyProfile2222 "
		completeMobileNumber = codesConcat(mobilecode,mobile,null,null,null,null,null,null,null);
		//For phone no. concatenation
		println "profileID inside  updateCompanyProfile3333 "
		completePhoneNumber = codesConcat(null,null,null,params.phone,params.PhoneCode,null,null,null,null);
		//For pin-code concatenation
		//completePinCode = codesConcat(null,null,null,null,null,params.pincode1,params.pincode2,null,null);
		//For person mobile concatenation
		println "profileID inside  updateCompanyProfile444444 "

		if(params.email != null){
			emailLower = (params.email)?.toLowerCase()
		}


		existingProfile.nameOfDepositor = params.nameOfDepositor

		existingProfile.address1 = params.address1
		existingProfile.address2 = params.address2
		existingProfile.address3 = params.address3

		existingProfile.country = Country.get(params.countryId)
		
		if(params.state != ''||params.state != null){
			province = params.state
		}
		else if(params.province != ''||params.province != null){
			province = params.province
		}
		existingProfile.state = province
		existingProfile.city = params.city
		existingProfile.zip = params.zip
		existingProfile.mobile = completeMobileNumber
		existingProfile.phone = completePhoneNumber
		existingProfile.email = emailLower


		if(!existingProfile.save(flush:true)){
			existingProfile.errors.each{ println it }
		}

		println "Saved successfully "
		//}
		return
	}

	def saveDepositionOfMicroOrganism(GrailsParameterMap params,FormCategory category,ApplicationForm1 existingAppForm=null){
		println "KKKKKKKKKK inside saveDepositionOfMicroOrganism--"+params
		def appForm,province,emailLower
		def completeMobileNumber,completePhoneNumber,completePinCode,completepersonMobile
		def mobilecode = params.mobileCode
		def mobile = params.mobile
		def appStatus
		//For mobile no. concatenation
		completeMobileNumber = codesConcat(mobilecode,mobile,null,null,null,null,null,null,null);
		//For phone no. concatenation
		completePhoneNumber = codesConcat(null,null,null,params.phone,params.PhoneCode,null,null,null,null);
		//For pin-code concatenation
		//completePinCode = codesConcat(null,null,null,null,null,params.pincode1,params.pincode2,null,null);
		//For person mobile concatenation


		if(params.email != null){
			emailLower = (params.email)?.toLowerCase()
		}
		if(existingAppForm == null){
			println "............."+category
			appForm = new ApplicationForm1(submittedBy:springSecurityService.currentUser,category:category)
			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}
		}
		else {
			appForm = existingAppForm
		}
		if(appForm != null){
			println "6666666"+appForm
			appStatus = changeAppStatus(AppStatus.Status.PENDING,springSecurityService.currentUser,appForm?.id?.toString())
			println "appStatus == "+appStatus
		}
		if(!appStatus.save(flush:true)){
			appStatus.errors.each{ println it }
		}

//		if(params.nameOfDepositor != '' &&  params.address1 != ''&&  params.address2!= ''  && params.mobile != '' && params.phone != ''
//		&& params.email != '' && params.countryId != '' && params.city != '' ){

			
				if(params.state != ''||params.state != null){
			province = params.state
		}
		else if(params.province != ''||params.province != null){
			province = params.province
		}


			def depositionMicroOrganism = new DepositionOfMicroOrganism(nameOfDepositor:params.nameOfDepositor,
			address1:params.address1,address2:params.address2,address3:params.address3,
			country:Country.get(params.countryId),state:province,city:params.city,
			mobile:completeMobileNumber,phone:completePhoneNumber,email:emailLower,zip:params.zip
			)

			//			companyForm.isRegisteredInIndia = params.status == 'notRegisteredInIndia' ? true : false
			print "ok.....1"+depositionMicroOrganism

			if(!depositionMicroOrganism.save(flush:true)){
				depositionMicroOrganism.errors.each{ println it }
			}

			appForm.addToDepostionOfMicroOrganism(depositionMicroOrganism)

			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}
			print "ok....2."+depositionMicroOrganism
			println "Saved successfully "
//		}
		return appForm
	}
//savecontactdetails of reposatory
	def updateContactDetailsOfReposatory(GrailsParameterMap params,ContactDetailsOfRepository existingProfile){
		
		
		def province
		def completeMobileNumber,completePhoneNumber,completePinCode,completepersonMobile,emailLower
		def mobilecode = params.mobileCode
		def mobile = params.mobile
		completeMobileNumber = codesConcat(mobilecode,mobile,null,null,null,null,null,null,null);
		//For phone no. concatenation
		completePhoneNumber = codesConcat(null,null,null,params.phone,params.PhoneCode,null,null,null,null);
		if(params.email != null){
			emailLower = (params.email)?.toLowerCase()
		}
		
		
		println "params =="+params

		existingProfile.repostoryType = params.repostoryType
		
		existingProfile.repostoryName = params.repostoryName
		existingProfile.address1 = params.address1
		existingProfile.address2 = params.address2
		existingProfile.address3 = params.address3
		
		existingProfile.country = Country.get(params.countryId)
		
			//province = params.state
		
		if(params.state != '' && params.state != null){
			province = params.state
		}
		if(params.province != '' && params.province != null){
			province = params.province
		}
		
		//println ".......province..... "+params.province+"3333333333"+params.state
		existingProfile.state = province
		existingProfile.city = params.city
		existingProfile.zip = params.zip
		existingProfile.mobile = completeMobileNumber
		existingProfile.phone = completePhoneNumber
		existingProfile.email = emailLower

		
		if(!existingProfile.save(flush:true)){
			existingProfile.errors.each{ println it }
		}

		println "Saved successfully "
		//}
		return
	}
	
	
	
		def saveContactDetailsOfReposatory(GrailsParameterMap params,FormCategory category,ApplicationForm1 existingAppForm=null){
		
			println "params in save contact details repository--"+params
		def appForm,province,emailLower
		def completeMobileNumber,completePhoneNumber,completePinCode,completepersonMobile
		def mobilecode = params.mobileCode
		def mobile = params.mobile
		def appStatus
		//For mobile no. concatenation
		completeMobileNumber = codesConcat(mobilecode,mobile,null,null,null,null,null,null,null);
		//For phone no. concatenation
		completePhoneNumber = codesConcat(null,null,null,params.phone,params.PhoneCode,null,null,null,null);
		//For pin-code concatenation
		//completePinCode = codesConcat(null,null,null,null,null,params.pincode1,params.pincode2,null,null);
		//For person mobile concatenation
		
		
		if(params.email != null){
			emailLower = (params.email)?.toLowerCase()
		}
		if(existingAppForm == null){
			appForm = new ApplicationForm1(submittedBy:springSecurityService.currentUser,category:category)
			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}
		}
		else {
			appForm = existingAppForm
		}
		if(appForm != null){
			println "6666666"+appForm
			appStatus = changeAppStatus(AppStatus.Status.PENDING,springSecurityService.currentUser,appForm?.id?.toString())
			println "appStatus == "+appStatus
		}
		if(!appStatus.save(flush:true)){
			appStatus.errors.each{ println it }
		}

//		if(params.repostoryName != '' &&  params.address1 != ''&&  params.address2!= ''  && params.mobile != '' && params.phone != ''
//			&& params.email != '' && params.countryId != '' && params.city != '' ){
	
				if(params.state != '' && params.state != null){
					province = params.state
				}
				if(params.province != '' && params.province != null){
					province = params.province
				}
	
		
				println "province=="+province
	
				def contactDetailsOfRepository = new ContactDetailsOfRepository(repostoryType:params.repostoryType,repostoryName:params.repostoryName,
				address1:params.address1,address2:params.address2,address3:params.address3,
				country:Country.get(params.countryId),state:province,city:params.city,
				mobile:completeMobileNumber,phone:completePhoneNumber,email:emailLower,zip:params.zip
				)
	
				//			companyForm.isRegisteredInIndia = params.status == 'notRegisteredInIndia' ? true : false
				print "ok....."+contactDetailsOfRepository
	
	
				appForm.addToRepositoryContactDetails(contactDetailsOfRepository)
	
				if(!contactDetailsOfRepository.save(flush:true)){
					contactDetailsOfRepository.errors.each{ println it }
				}
			
				if(!appForm.save(flush:true)){
					appForm.errors.each{ println it }
				}
				println "Saved successfully "
//			}
			return appForm
		
		
		
}

	
	
		def saveCompanyProfile(GrailsParameterMap params,registrationDocFile,registrationDocFilename, passportFile,String passportFilename,
			authorityLetter,String authorityLetterFilename,FormCategory category,ApplicationForm1 existingAppForm=null){

		println "hELloooooooooooo"
		println "hiiiiiiiiiiiiiiiiiiiii"
		def appForm,province,appStatus,natureOfBusiness,emailLower,personEmailLower

		def completeMobileNumber,completePhoneNumber,completePinCode,completepersonMobile
		def mobilecode = params.mobileCode
		def mobile = params.mobile
		//For mobile no. concatenation
		completeMobileNumber = codesConcat(mobilecode,mobile,null,null,null,null,null,null,null);
		//For phone no. concatenation
		completePhoneNumber = codesConcat(null,null,null,params.phone,params.PhoneCode,null,null,null,null);
		//For pin-code concatenation
		//completePinCode = codesConcat(null,null,null,null,null,params.pincode1,params.pincode2,null,null);
		//For person mobile concatenation
		completepersonMobile = codesConcat(null,null,null,null,null,null,null,params.personMobileCode,params.personMobile1);

		if(params.email != null){
			emailLower = (params.email)?.toLowerCase()
		}

		if(params.personEmail != null){
			personEmailLower = (params.personEmail)?.toLowerCase()
		}

		println "appform inside service "+appForm

		if(existingAppForm == null){
			appForm = new ApplicationForm1(submittedBy:springSecurityService.currentUser,category:category)
			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}
		}
		else {
			appForm = existingAppForm
		}
		if(appForm != null){
			appStatus = changeAppStatus(AppStatus.Status.PENDING,springSecurityService.currentUser,appForm?.id?.toString())
			println "appStatus == "+appStatus
		}
		if(!appStatus.save(flush:true)){
			appStatus.errors.each{ println it }
		}
		println "appForm == "+appForm
		if(params.entityName != '' &&  params.address1 != '' && params.mobile != '' && params.phone != ''
		&& params.email != '' && params.countryId != '' && params.city != ''   && params.website != '' && params.businessNature != '' &&
		params.title != '' && params.firstName != '' && params.lastName != '' && params.personEmail != '' && params.personMobile1 != ''){

			if(params.state != ''){
				province = params.state
			}
			else if(params.province != ''){
				province = params.province
			}

			if(params.businessNature == 'Others'){
				natureOfBusiness = 'Others-'+params.otherNatureOfBusiness
			}
			else{
				natureOfBusiness = params.businessNature
			}

			def companyForm = new CompanyProfile(entityName:params.entityName,nationality:params.status,
			address1:params.address1,address2:params.address2,address3:params.address3,
			country:Country.get(params.countryId),province:province,city:params.city,pincode:params.pincode2,
			mobile:completeMobileNumber,phone:completePhoneNumber,email:emailLower,
//			registrationDoc:registrationDocFile.getBytes(),passportCopy:passportFile.getBytes(),authorizationLetter:authorityLetter.getBytes(),
			registrationDocName:registrationDocFilename,passportCopyFileName:passportFilename,
			authorizationLetterFileName :authorityLetterFilename,applicationForm:appForm,designation:params.designation,authRepresentativeIdSelect:params.authRepresentativeIdSelect,
			businessNature:natureOfBusiness, title:params.title,firstName:params.firstName,middleName:params.middleName,idNum:params.idNum,
			lastName:params.lastName,personMobile:completepersonMobile,personEmail:personEmailLower,website:params.website,entityType:params.entityType)

			def com_count = CompanyProfile.count().toString()
			
			new File(grailsApplication.config.companyRegistration.toString() + File.separatorChar +"registration").mkdirs()
            def filePath = new File(grailsApplication.config.companyRegistration.toString() + File.separatorChar + "registration"+ File.separatorChar + com_count);
		   
			  registrationDocFile.transferTo(filePath)
			 companyForm.registrationDocURL = filePath;
			 
			 
			 new File(grailsApplication.config.companyPassport.toString() + File.separatorChar +"Passport").mkdirs()
			 def filePathPass = new File(grailsApplication.config.companyPassport.toString() + File.separatorChar + "passport"+ File.separatorChar + com_count);
			
			   passportFile.transferTo(filePathPass)
			  companyForm.passportCopyURL = filePathPass;
			  
			  new File(grailsApplication.config.companyAuthority.toString() + File.separatorChar +"Authority").mkdirs()
			  def filePathAuth = new File(grailsApplication.config.companyAuthority.toString() + File.separatorChar + "Authority"+ File.separatorChar + com_count);
			 
				authorityLetter.transferTo(filePathAuth)
			   companyForm.authorizationLetterURL = filePathAuth;
			  
			  
			
			

			appForm.addToCompanyProfiles(companyForm)
			appForm.currentStatus = appStatus

			if(!companyForm.save(flush:true)){
				companyForm.errors.each{ println it }
			}

			if(!appForm.save(flush:true)){
				appForm.errors.each{ println it }
			}
			println "Saved successfully "
		}
		return appForm
	}



	def updateCompanyProfile(GrailsParameterMap params, registrationDocFile, String registrationDocFilename, passportFile,String passportFilename,
			authorityLetter,String authorityLetterFilename,FormCategory category,CompanyProfile existingProfile){

		println "profileID inside  updateCompanyProfile1 "
		def province,natureOfBusiness,personEmailLower
	

		def completeMobileNumber,completePhoneNumber,completePinCode,completepersonMobile,emailLower
		def mobilecode = params.mobileCode
		def mobile = params.mobile
		//For mobile no. concatenation
		completeMobileNumber = codesConcat(mobilecode,mobile,null,null,null,null,null,null,null);
		//For phone no. concatenation
		completePhoneNumber = codesConcat(null,null,null,params.phone,params.PhoneCode,null,null,null,null);
		//For pin-code concatenation
		//For person mobile concatenation
		completepersonMobile = codesConcat(null,null,null,null,null,null,null,params.personMobileCode,params.personMobile1);

		if(params.email != null){
			emailLower = (params.email)?.toLowerCase()
		}

		if(params.personEmail != null){
			personEmailLower = (params.personEmail)?.toLowerCase()
		}

		if(params.businessNature == 'Others'){
			natureOfBusiness = 'Others-'+params.otherNatureOfBusiness
		}
		else{
			natureOfBusiness = params.businessNature
		}
		existingProfile.entityName = params.entityName
		existingProfile.entityType = params.entityType
		existingProfile.address1 = params.address1
		existingProfile.address2 = params.address2
		existingProfile.address3 = params.address3
		existingProfile.nationality = params.status
		existingProfile.country = Country.get(params.countryId)
		if(params.state != ''){
			province = params.state
		}
		else if(params.province != ''){
			province = params.province
		}
		existingProfile.province = province
		existingProfile.city = params.city
		existingProfile.pincode = params.pincode2
		existingProfile.mobile = completeMobileNumber
		existingProfile.phone = completePhoneNumber
		existingProfile.email = emailLower

		existingProfile.authRepresentativeIdSelect=params.authRepresentativeIdSelect
		existingProfile.idNum=params.idNum
		existingProfile.title = params.title
		existingProfile.firstName = params.firstName
		existingProfile.middleName = params.middleName
		existingProfile.lastName = params.lastName
		existingProfile.personMobile = completepersonMobile
		existingProfile.personEmail = personEmailLower
		existingProfile.designation = params.designation
		existingProfile.website = params.website
		existingProfile.businessNature = natureOfBusiness
		
		def com_count = CompanyProfile.count().toString()
		
		if(registrationDocFile != null && registrationDocFile?.getBytes()?.size() != 0){
			
			new File(grailsApplication.config.companyRegistration.toString() + File.separatorChar +"registration").mkdirs()
			def filePath = new File(grailsApplication.config.companyRegistration.toString() + File.separatorChar + "registration"+ File.separatorChar + com_count);
		   
			  registrationDocFile.transferTo(filePath)
			 existingProfile.registrationDocURL = filePath;
			
//			existingProfile.registrationDoc = registrationDocFile.getBytes()
			existingProfile.registrationDocName = registrationDocFilename
		}
		if(passportFile != null && passportFile?.getBytes()?.size() != 0){
			
			new File(grailsApplication.config.companyPassport.toString() + File.separatorChar +"Passport").mkdirs()
			def filePathPass = new File(grailsApplication.config.companyPassport.toString() + File.separatorChar + "passport"+ File.separatorChar + com_count);
		   
			  passportFile.transferTo(filePathPass)
			 existingProfile.passportCopyURL = filePathPass;
			
//			existingProfile.passportCopy =passportFile.getBytes()
			existingProfile.passportCopyFileName = passportFilename
		}
		if(authorityLetter != null && authorityLetter?.getBytes()?.size() != 0){
			
			new File(grailsApplication.config.companyAuthority.toString() + File.separatorChar +"Authority").mkdirs()
			def filePathAuth = new File(grailsApplication.config.companyAuthority.toString() + File.separatorChar + "Authority"+ File.separatorChar + com_count);
		   
			  authorityLetter.transferTo(filePathAuth)
			 existingProfile.authorizationLetterURL = filePathAuth;
			
//			existingProfile.authorizationLetter= authorityLetter.getBytes()
			existingProfile.authorizationLetterFileName  = authorityLetterFilename
		}
		existingProfile.personMobile  = completepersonMobile

		println "profileID inside  updateCompanyProfile33333 "

		if(!existingProfile.save(flush:true)){
			existingProfile.errors.each{ println it }
		}

		println "Saved successfully "
		//}
		return
	}

	def findTabsStatus(ApplicationForm1 appForm, AgentProfile agent) {
		def part1 = "null"
		def part2 = "null"
		def part3 = "null"
		def part4 = "null"
		def part5 = "null"
		def formA="null"
		def projectPreview = "null"

		println "appForm == "+appForm

		//Form 1
		if(appForm && appForm?.category?.category == FormCategory.Category.Form_1 ){

			if(appForm.individualProfiles?.size() > 0){
				if(appForm.individualProfiles?.size() == 0 ) {
					part1 = "null"
				}
				else if(appForm?.isAddressOfContactPerson == 'NoForIndividual' || agent ) {
					part1 = "menu1"
				}
			}
			else if(appForm.companyProfiles?.size() > 0){
				if(appForm.companyProfiles?.size() == 0 ){
					part1 = "null"
				}
				else if(appForm?.isAddressOfContactPerson == 'NoForCompany' || agent) {
					part1 = "menu1"
				}
			}

			if(appForm?.biologicalResources?.size() == 0){
				part2 = "null"
			}else if(appForm?.biologicalResources?.size() > 0 ){

				for(geoLocation in appForm?.biologicalResources){
					if(geoLocation?.locations.size() > 0){
						part2 = "menu2"
					}
				}
			}

			if(appForm?.nature?.isEmpty() || appForm?.nature == null || appForm?.purposeOfProposal?.isEmpty() || appForm?.purposeOfProposal == null ||
			!appForm?.nature && appForm?.locations?.size() == 0 || !appForm?.selfAuthorizedPerson && appForm?.contactPersons?.size() == 0){
				part3 = "null"
			}else{
				part3 = "menu3"
			}
			def form1Part4Answers = FormAnswer.findAllByCategoryAndApplicationForm(QuestionCategory.findByCategory(QuestionCategory.Category.Form_1), appForm)
			if(form1Part4Answers?.size()==4){
				for(int i=0; i<=form1Part4Answers.size()-1;i++) {

					if(form1Part4Answers[i].answer == null || form1Part4Answers[i].answer ==" " ||
					!appForm?.instituteParticipation || !appForm?.isBenefitSharing){
						part4 = "null"
						break;
					}else{
						part4 = "menu4"
					}
				}
			}else{

				part4 = "null"
			}
			if(appForm?.isDeclarationDigitallySigned?.isEmpty()  || appForm?.isDeclarationDigitallySigned == null || appForm?.submitCheck == false){
				part5 = "null"
			}else{
				part5 = "menu5"
			}
//			if(appForm?.approvalOfNba==null ||appForm?.conditionOfAbs==null ||appForm?.infromationTrue==null||appForm?.recordsWithTheNba==null ){
			if(appForm?.benefitSharingProofFilename==null ||appForm?.conditionOfAbs==null ){
					formA = "null"
				}else{
					formA = "menu6"
				}
			
			

			if(![part1, part2, part3, part4, part5,formA].contains(null)){
				//projectPreview= "backgroundGreen"

			}
			println "benefitSharingProof=="+appForm?.benefitSharingProofFilename
			println "conditionOfAbs=="+appForm?.conditionOfAbs
			println "infromationTrue=="+appForm?.infromationTrue
			println "recordsWithTheNba=="+appForm?.recordsWithTheNba

			return [part1, part2, part3, part4, part5,formA]

		}
		//Form 2
		if(appForm && appForm?.category?.category == FormCategory.Category.Form_2 ){
			if(appForm.individualProfiles?.size() > 0){
				if(appForm.individualProfiles?.size() == 0 && appForm.agentProfile == null) {
					part1 = "null"
				}
				else if(appForm?.isAddressOfContactPerson == 'NoForIndividual' || agent ){
					part1 = "menu1"
				}
			}
			else if(appForm.companyProfiles?.size() > 0){
				if(appForm.companyProfiles?.size() == 0 ){
					part1 = "null"
				}
				else if(appForm?.isAddressOfContactPerson == 'NoForCompany' || agent){
					part1 = "menu1"
				}
			}

			if(appForm?.briefDescription?.isEmpty() || appForm?.briefDescription == null ||
			appForm?.resultsOfResearch?.isEmpty() || appForm?.resultsOfResearch == null ||
			appForm?.biologicalResources?.size() == 0 ){

				part2 = "null"
			}else if(appForm?.biologicalResources?.size() > 0 ){
				for(geoLocation in appForm?.biologicalResources){
					if(geoLocation?.locations?.size() > 0)
						part2 = "menu2"
				}

				if(appForm?.individualProfiles?.getAt(0)?.nationality == 'Non Indian' ||
				appForm?.individualProfiles?.getAt(0)?.nationality == 'Non-Resident Indian'){

					if(appForm.isApprovalOfNbaObtained != null && appForm.isApprovalOfNbaObtained == 'false'){
						appForm.nbaApprovalFile = null
						part2 = "menu2"
						println "***********part21*****************"+part2
					}
					else if(appForm.isApprovalOfNbaObtained != null && appForm.isApprovalOfNbaObtained == 'true'){
						part2 =  appForm.nbaApprovalFile != null ? "menu2" : "null"
						println "***********part22*****************"+part2
					}
					else{
						part2 = null
					}
					println "***********part2*****************"+part2
				}
			}
			if( appForm?.nature == null && appForm.isNoForTraditional == null || appForm?.locations?.size() == 0 && appForm.isNoForTraditional == null ){
				println "1234**************************1"
				part3 = null
			}
			else if(appForm.isNoForTraditional == 'No' && appForm?.locations?.size() == 0 &&
			appForm.detailsOfInstitute && appForm.bonafideLetter ){
				println "*********4435353******************2"
				part3 = "menu3"
			}
			else if(appForm?.nature != null && appForm?.locations?.size() > 0 &&
			appForm.detailsOfInstitute && appForm.bonafideLetter){
				println "***************************************3"
				part3 = "menu3"
			}

			if(appForm?.detailsOfInstitute?.isEmpty() || appForm?.detailsOfInstitute == null || appForm?.useofResearchResults?.isEmpty() || appForm?.useofResearchResults == null ||
			appForm?.benefitsToTheIndividualOrOrganization?.isEmpty() || appForm?.benefitsToTheIndividualOrOrganization == null ||
			appForm?.benefitsToTheApplicant?.isEmpty() || appForm?.benefitsToTheApplicant == null ){
				part4 = "null"
			}else{
				part4 = "menu4"
			}

			if(appForm?.isDeclarationDigitallySigned?.isEmpty()  || appForm?.isDeclarationDigitallySigned == null || appForm?.submitCheck == false){
				part5 = "null"
			}else{
				part5 = "menu5"
			}

			if(![part1, part2, part3, part4, part5].contains( null )){
				//projectPreview= "backgroundGreen"

			}

			return [part1, part2, part3, part4, part5]
		}
		//Form 3
		if(appForm && appForm?.category?.category == FormCategory.Category.Form_3 ){
			if(appForm.individualProfiles?.size() > 0){
				if(appForm.individualProfiles?.size() == 0 ) {
					part1 = "null"
				}
				else if(appForm?.isAddressOfContactPerson == 'NoForIndividual' || agent ){
					part1 = "menu1"
				}
			}
			else if(appForm.companyProfiles?.size() > 0){
				if(appForm.companyProfiles?.size() == 0 ){
					part1 = "null"
				}
				else if(appForm?.isAddressOfContactPerson == 'NoForCompany' || agent){
					part1 = "menu1"
				}
			}

			if(appForm?.titleOfIPR?.isEmpty() || appForm?.titleOfIPR == null || appForm?.abstractOfIPR?.isEmpty() || appForm?.abstractOfIPR == null ||
	           appForm?.iprDetails?.size() == 0 && appForm.isIPApplicationFiled != 'false' || appForm?.biologicalResources?.size() == 0){
				println "Form 3 part 2 is null"
				part2 = "null"
			}else{
				println "*********PART222222222222**********2"
				part2 = "menu2"

				if(appForm?.individualProfiles?.getAt(0)?.nationality == 'Non Indian' ||
				appForm?.individualProfiles?.getAt(0)?.nationality == 'Non-Resident Indian'){

					if(appForm.isApprovalOfNbaObtainedForm3 != null && appForm.isApprovalOfNbaObtainedForm3 == 'false'){
						appForm?.applicationNo = null
						appForm?.dateOfApproval = null
						appForm?.nbaApprovalFile = null
						part2 = "menu2"
						println "***********part21*****************"+part2
					}
					else if(appForm.isApprovalOfNbaObtainedForm3 != null && appForm.isApprovalOfNbaObtainedForm3 == 'true'){
						part2 =  appForm.nbaApprovalFile != null && appForm?.applicationNo &&
								appForm?.dateOfApproval ? "menu2" : "null"
						println "***********part22*****************"+part2
					}
					else{
						part2 = null
					}
					println "***********part2*****************"+part2
				}
			}


			/*if(appForm?.nature?.isEmpty() || appForm?.nature == null || appForm?.locations?.size() == 0 ){
			 part3 = "null"
			 }else{
			 part3 = "menu3"
			 }*/

			if(	!appForm?.biologicalResources?.locations?.getAt(0)   || appForm?.isBioObtainedOutsideIndia == 'true' && !appForm?.traditionalKnowledgeDesc ||
			appForm?.isApprovalOfCountryObtained == 'false' && !appForm?.reasonOfDisapproval || !appForm?.isBioObtainedOutsideIndia ||
			appForm?.isTraditionalKnowledgeApplicable == 'Applicable' && appForm?.locations?.size() == 0 ||
			appForm?.isTraditionalKnowledgeApplicable == 'Applicable' && !appForm?.traditionalKnowledgeUsedInInvention ||
			!appForm?.detailsOfInstitute || !appForm?.benefitsToTheApplicant || !appForm?.isTraditionalKnowledgeApplicable){

				println "***************1***********************"+appForm?.biologicalResources?.locations?.getAt(0)
				part3 = "null"
			}
			else{
				println "***************2***********************"+appForm?.biologicalResources?.locations?.getAt(0)
				part3 = "menu3"
				/*if(appForm?.isBioObtainedOutsideIndia == 'false'){
				 part3 = "menu3"
				 }*/
			}


			/*if(appForm?.detailsOfInstitute?.isEmpty() || appForm?.detailsOfInstitute == null || appForm?.useofResearchResults?.isEmpty() || appForm?.useofResearchResults == null ||
			 appForm?.benefitsToTheIndividualOrOrganization?.isEmpty() || appForm?.benefitsToTheIndividualOrOrganization == null ||
			 appForm?.benefitsToTheApplicant?.isEmpty() || appForm?.benefitsToTheApplicant == null ){
			 part4 = "null"
			 }else{
			 part4 = "menu4"
			 }*/

			if(appForm?.isDeclarationDigitallySigned?.isEmpty()  || appForm?.isDeclarationDigitallySigned == null || appForm?.submitCheck == false){
				part5 = "null"
			}else{
				part5 = "menu5"
			}

			if(![part1, part2, part3, part4, part5].contains( null )){
				//projectPreview= "backgroundGreen"

			}

			return [part1, part2, part3, part4, part5, projectPreview]
		}


		//Form 4
		if(appForm && appForm?.category?.category == FormCategory.Category.Form_4 ){
			println "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"
			if(appForm.individualProfiles?.size() > 0){
				if(appForm.individualProfiles?.size() == 0 ) {
					part1 = "null"
				}
				else if(appForm?.isAddressOfContactPerson == 'NoForIndividual' || agent ){
					part1 = "menu1"
				}
			}
			else if(appForm.companyProfiles?.size() > 0){
				if(appForm.companyProfiles?.size() == 0 ){
					part1 = "null"
				}
				else if(appForm?.isAddressOfContactPerson == 'NoForCompany' || agent){
					part1 = "menu1"
				}
			}

			if(appForm?.applicationNo?.isEmpty() || appForm?.applicationNo == null || appForm?.dateOfApproval == null ||
			appForm?.biologicalResources?.size() == 0 || !appForm?.isbenefitSharingDetailImplemented ||
			appForm?.isbenefitSharingDetailImplemented == 'true' && !appForm?.benefitMechanism){
				part2 = "null"
			}else{
				part2 = "menu2"
			}
			if(appForm?.benefitsToTheThirdParty?.isEmpty() || appForm?.benefitsToTheThirdParty == null ||
			appForm?.isAgreementBwApplicantAndThirdParty == null || appForm?.isAgreementBwApplicantAndThirdParty == 'true' && !appForm.agreementBtwnApplicantAndThirdParty ||
			appForm?.benefitsOutOfThirdPartyTransfer?.isEmpty() || appForm?.benefitsOutOfThirdPartyTransfer == null ||
			appForm?.mechanismOutOfThirdPartyTransfer?.isEmpty() || appForm?.mechanismOutOfThirdPartyTransfer == null ||
			appForm?.thirdParty?.size() == 0 ){
				part3 = "null"
			}else{
				part3 = "menu3"
			}
			if(appForm?.isDeclarationDigitallySigned?.isEmpty()  || appForm?.isDeclarationDigitallySigned == null || appForm?.submitCheck == false){
				part5 = "null"
			}else{
				part5 = "menu5"
			}

			if(![part1, part2, part3, part4, part5].contains( "null" )){
				//projectPreview= "null"

			}

			return [part1, part2, part3, part4, part5]
		}
		
		//////////Form C start
		if(appForm && appForm?.category?.category == FormCategory.Category.Form_C ){
			println "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"
			if(appForm.depostionOfMicroOrganism?.size() ==0){
				
				
					part1 = "null"
			}else{
				part1 = "menu1"
			}
			if(appForm?.biologicalResources?.size() == 0 || appForm?.biologicalResources?.locations?.getAt(0)?.size() == 0){
				part2 = "null"
			}else{
				part2 = "menu2"
			}
			
			if(appForm?.repositoryContactDetails?.size() >= 2 && appForm?.depositionPerpose != null && appForm?.depositionPerpose != ''){
				
				part3 = "menu3"
			}else{
				part3 = "null"
			}
			if(appForm?.undertakingCopyFileName?.isEmpty()  || appForm?.undertakingCopy == null || appForm?.declarationAcceptance == false){
				part4 = "null"
			}else{
				part4 = "menu5"
			}

			if(![part1, part2, part3, part4, part5].contains( "null" )){
				//projectPreview= "null"

			}

			return [part1, part2, part3, part4, part5]
		}
		//form C end
		
		
		
		println "appForm?.formBItems------------"+appForm?.formBItems
		//////////Form B start
		if(appForm && appForm?.category?.category == FormCategory.Category.Form_B ){
			println "BBBBBBBBBBBBBBBBBBBBB"
			if(appForm?.indianResearcher?.size() > 0){
					part1 = "menu1"
			}
			else if(appForm?.indianGovtInst?.size() > 0){
				part1 = "menu1"
			}
			else{
				part1 = null
			}
			
			if(appForm?.formBItems?.size() == 0){
				part2 = "null"
			}
			else if(appForm?.formBItems?.size() == 1){
				part2 = "null"
			}
			else if(appForm?.formBItems?.size() >= 2){
				part2 = "menu2"
			}
			else{
				part2 = "null"
			}
			
			
			if(appForm?.formBItems?.size() == 5 && appForm?.briefDescription != '' && appForm?.briefDescription != null ){
				part3 = "menu3"
			}
			else if(appForm?.formBFundingAgency?.size() != 0){
				part3 = "menu3"
			}
			else{
				part3 = "null"
			}
			
			if(appForm?.biologicalResources?.size() !=0 && appForm?.researchDurationFrom != '' && appForm?.researchDurationFrom != null  && 
				appForm?.researchDurationTo != '' && appForm?.researchDurationTo != null &&
				appForm?.biologicalResources?.locations?.size() != 0 && appForm?.emergencyDetails != '' && appForm?.emergencyDetails != null){
				println "--part 4--"
				part4 = "menu5"
			}
			else{
			println "**part 4**"
			part4 = "null"
			}
			
			
			
			if(appForm?.undertakingCopyFileName?.isEmpty()  || appForm?.undertakingCopy == null || appForm?.declarationAcceptance == false){
				part5 = "null"
			}else{
				part5 = "menu4"
			}

			if(![part1, part2, part3, part4, part5].contains( null )){
				//projectPreview= "backgroundGreen"

			}
			
			println "part1="+part1
			println "part2="+part2
			println "part3="+part3
			println "part4="+part4
			println "part5="+part5
			

			return [part1, part2, part3, part4, part5]
		}
		//form B end
		else{
			println "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"
			println "part1="+part1
			println "part2="+part2
			println "part3="+part3
			println "part4="+part4
			println "part5="+part5
			return [part1, part2, part3, part4, part5]
		}
	}

	

public  String getDynamicApplicationNumber(String formCategory,ApplicationForm1 appForm){
		
		def applicationNumber
		def year =  appForm.submittedOn.split('-')[0]
		def formCount = ApplicationForm1.where{submittedOn != null}.size();
		
		println"formCategory"+formCategory
		
		if(formCount < 10){
			applicationNumber = 'INBA'+formCategory+year+'0000'+formCount.toString();
		}
		else if(formCount >= 10 && formCount < 100){
			applicationNumber = 'INBA'+formCategory+ year+'000'+formCount.toString();
		}
		else if(formCount >= 100 && formCount < 1000){
			applicationNumber = 'INBA'+formCategory+ year+'00'+formCount.toString();
		}
		else if(formCount >= 1000 && formCount < 10000){
			applicationNumber = 'INBA'+formCategory+year+'0'+formCount.toString();
		}
		else if(formCount >= 10000 && formCount < 100000){
			applicationNumber = 'INBA'+formCategory+year+formCount.toString();
		}
		
		return applicationNumber
	}
	
	
	

	def changeAppStatus(AppStatus.Status status,NbaUser user,String appFormId){

		println "appFormId == "+appFormId 
		def appForm
		
		if(appFormId != null){
			appForm = ApplicationForm1.get(appFormId as Long)
		}

	def	appstatus = AppStatus.where{application == appForm}.find() 

		if(appstatus == null){
			appstatus = new AppStatus(status:status,changedBy:user,application:appForm,changedOn:new Date())
			
		}else{
//		appForm.currentStatus = appstatus
        appstatus.status = status
		appstatus.changedOn = new Date()
		
	    appstatus.forwardedUser = appstatus.changedBy.username
		appstatus.changedBy = user
		}
		
		
		
		if(!appForm.save(flush:true)){
			appForm.errors.each{ println it }
		}
		if(!appstatus.save(flush:true)){
			appstatus.errors.each{ println it }
		}

		return appstatus
	}
	
	
	
	

	def saveFormBEntity(GrailsParameterMap params,ApplicationForm1 appForm,sanctionOrderMoUcopyDocFile,sanctionOrderMoUcopyDocFilename,addressproofLetterFile,addressproofLetterFilename){
		println "inside the service"+params
		def type,province
		def formBEntity
		if(params.type == 'institute' && params.part == 'part2'){
			formBEntity  = FormB?.findByAppFormAndType(appForm,FormB?.EntityType?.Institute)
		}
		else if(params.type == 'supervisor' && params.part == 'part2'){
			formBEntity  = FormB?.findByAppFormAndType(appForm,FormB.EntityType.Supervisor)
		}
		else if(params.type == 'institute' && params.part == 'part3'){
			formBEntity  = FormB.findByAppFormAndType(appForm,FormB.EntityType.Guiding_Institute)
		}
		else if(params.type == 'supervisor' && params.part == 'part3'){
			formBEntity  = FormB.findByAppFormAndType(appForm,FormB.EntityType.Guiding_Supervisor)
		}
		else if(params.type == 'funding' && params.part == 'part3'){
			formBEntity  = FormB.findByAppFormAndType(appForm,FormB.EntityType.Funding_Agency)
		}

		if(formBEntity == null){
			println "inside if--------------"
			def email
			if(params?.email != null){
				email = (params?.email)?.toLowerCase()
			}

			if(params?.type == 'institute' && params?.part == 'part2'){
				type = FormB?.EntityType.Institute
			}
			else if(params?.type == 'supervisor' && params?.part == 'part2'){
				type = FormB.EntityType.Supervisor
			}
			else if(params?.type == 'institute' && params?.part == 'part3'){
				type = FormB.EntityType.Guiding_Institute
			}
			else if(params?.type == 'supervisor' && params?.part == 'part3'){
				type = FormB.EntityType.Guiding_Supervisor
			}
			else if(params?.type == 'funding' && params?.part == 'part3'){
				type = FormB.EntityType.Funding_Agency
			}
			
			if(params?.state != ''){
				province = params.state
			}
			 if(params?.province != null){
				province = params.province
			}
			 
			 
//			if(params?.name!= '' && params?.address1 != '' &&  params?.email ){
				println "saving the institute"+params
				formBEntity = new FormB(name:params?.name,supervisorDesignation:params?.supervisorDesignation,headOfInstName:params?.headOfInstName,
					address1:params?.address1,address2:params?.address2,address3:params?.address3,city:params?.city,headOfInstDesignation:params?.headOfInstDesignation,
					sanctionOrderMoUcopy:sanctionOrderMoUcopyDocFile?.getBytes(),sanctionOrderMoUcopyFileName:sanctionOrderMoUcopyDocFilename,fax:params?.fax,
					addressproofLetter:addressproofLetterFile?.getBytes(),addressproofLetterFileName:addressproofLetterFilename,addressproofSelect:params?.addressproofSelect , 
					addressproofNo:params?.addressproofNo,
					phone:params?.phone,email:email,appForm:appForm,type:type,state:province,pincode : params?.pincode,mobile : params?.mobile,supervisorOrHoi:params?.supervisorOrHoi,
					contactDetailsOfInstOrOrganization:params?.contactDetailsOfInstOrOrganization, category:params?.category,country1:Country.get(params?.countryId))

				appForm?.addToFormBItems(formBEntity)
//			}
		}
		if(params?.type == 'funding'){
			
		}
		else{
			println "inside else--------------"+params
			if(params.state != ''){
				province = params?.state
			}
			 if(params.province != null){
				province = params?.province
			}
			println "I;m inside else "
			
			formBEntity.supervisorOrHoi = params?.supervisorOrHoi
			if(params?.supervisorOrHoi == 'supervisor'){
				println "inside supervisor saving block"
				formBEntity.name = params?.name
				formBEntity.supervisorDesignation = params?.supervisorDesignation
				formBEntity.headOfInstName = null
				formBEntity.headOfInstDesignation = null
			}
			else if(params?.supervisorOrHoi == 'headofinstitution'){
				println "inside hoi saving block"
				formBEntity.headOfInstName = params?.headOfInstName
				formBEntity.headOfInstDesignation = params?.headOfInstDesignation
				formBEntity.name = null
				formBEntity.supervisorDesignation = null
			}
			formBEntity.address1 = params?.address1
			formBEntity.address2 = params?.address2
			formBEntity.address3 = params?.address3
			formBEntity.city = params?.city
			formBEntity.pincode = params?.pincode
			formBEntity.state = province
			formBEntity.phone = params?.phone
			formBEntity.email = params?.email
			formBEntity.mobile = params?.mobile
			formBEntity.fax = params?.fax
			formBEntity.contactDetailsOfInstOrOrganization = params?.contactDetailsOfInstOrOrganization
			formBEntity.category = params?.category
			formBEntity.country1 = Country?.get(params?.countryId)
			
			if(params?.category == 'contactDetails3'){
				formBEntity.addressproofSelect = params?.addressproofSelect
				formBEntity.addressproofNo = params?.addressproofNo
				
				if(addressproofLetterFilename != null && addressproofLetterFile?.getBytes()?.size() != 0){
					formBEntity?.addressproofLetter = addressproofLetterFile?.getBytes()
					formBEntity?.addressproofLetterFileName = addressproofLetterFilename
				}
			}
			else{
				formBEntity.addressproofSelect = null
				formBEntity.addressproofNo = null
				formBEntity?.addressproofLetter = null
				formBEntity?.addressproofLetterFileName = null
			}
			
			if(sanctionOrderMoUcopyDocFilename != null && sanctionOrderMoUcopyDocFile?.getBytes()?.size() != 0){
				formBEntity?.sanctionOrderMoUcopy= sanctionOrderMoUcopyDocFile?.getBytes()
				formBEntity?.sanctionOrderMoUcopyFileName  = sanctionOrderMoUcopyDocFilename
			}
			
			
		}
		if(!formBEntity?.save(flush:true)){
			formBEntity?.errors?.each{ println it }
		}

		if(!appForm.save(flush:true)){
			appForm.errors.each{println it}
		}
		println "formBEntity == "+formBEntity
		println "Before returning"
		return formBEntity
	}
	
	def ipGenerateLocalMachine(){
		
//		InetAddress localhost = InetAddress.getLocalHost();
//		return localhost.getHostAddress().trim();
		
	}

	
	
	public String getClientIpAddress(HttpServletRequest request) {

		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;

	  }
	}
