<script type="text/javascript">
function updateCountryCodes(e){
//var code = $(e).val();
e.data.split('=')[1]
var dataElement = e.data? e.data.split('&')[0]:"No value"
	var countryId = dataElement? dataElement.split('=')[1]:"No value"
	$.ajax({
		type : "POST",
		url : fetchCodes,
		data : {
			countryId : countryId,
			csrfPreventionSalt : csrfPreventionSalt
		},
		success : function(result) {
			$('#mobileCode').val(result.phonecode);
			$('#countryPhoneCode').val(result.phonecode);
			$('#personMobileCode').val(result.phonecode);
		},
		error : function() {
			//alert("An error has (Himanshu jain) occured!!!");
		}

	});	
	}
</script>

<g:uploadForm class="form-horizontal" role="form" autocomplete="off"
	action="submitCompanyProfile">
 <input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
	<div class="text-center">
		<div class="text-success">
			<b><span>
					${flash.message }
			</span></b>
		</div>
	</div>
	<div class="form-group col-sm-12">
		<label class=" col-sm-12 register-heading">1. Full Particulars
			of Applicant</label>
	</div>



	<div class="form-group col-sm-12">
		<label class=" col-sm-12 register-heading">(i) Name</label>
	</div>


	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(a)</span><span
			class="col-sm-10"> Name of the Entity<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input id="foucuscontrol" type="text" class="width ctlwidth"
				name="entityName" value="${companyProfile1?.entityName}" req1="1">
		</div>
	</div>


	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(b)</span><span
			class="col-sm-10"> Type of Entity<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<g:each in="${entityTypes}" var="entityType">
				<g:if test= "${companyProfile1?.entityType == entityType }">	
					<g:radio name="entityType" value="${entityType}" req1="1"
						class="ctlwidth leftflot"
						checked="checked" required="required"/>
					<span id="TopPadding " class="col-sm-10"> ${entityType}</span>
				</g:if>
				<g:else>
					<g:radio name="entityType" value="${entityType}" req1="1"
						class="ctlwidth leftflot" required="required" />
					<span id="TopPadding " class="col-sm-10" > ${entityType}</span>
				</g:else>
					<br />
					<br />
			</g:each>
		</div>
	</div>





	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(c)</span><span
			class="col-sm-10"> Status<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
		<g:if test= "${!companyProfile1 }">
		
			<g:radio name="status" class="leftflot"  value="notRegisteredInIndia" required="required"/><span
				class="col-sm-10" >Not incorporated or registered in India</span><br />
		      <br/> 
			<g:radio name="status" class="leftflot" value="registeredInIndia" required="required"/><span
				class="col-sm-10" > Incorporated or registered in India under
				any law for the time being in force which has any non-Indian
				participation in its share capital or management </span> <br /> <br /><br/>
			<g:if test= "${formType == 'Form3' || formType == 'Form2' }">	
				<g:radio name="status" class="leftflot" value="noNonIndianParticipation" required="required"/><span
					class="col-sm-10"> Registered in India and does not have any non-Indian participation in share capital or management </span>
			</g:if>
		</g:if>
		<g:elseif test= "${companyProfile1 }">
		  <g:if test= "${companyProfile1?.nationality == 'notRegisteredInIndia' }">
				<input type="radio" name="status" class="leftflot" checked= "checked"  value="notRegisteredInIndia"/><span
				class="col-sm-10">Not incorporated or registered in India</span><br />
			<br /> 
			<input type="radio" name="status" class="leftflot" value="registeredInIndia"/><span
				class="col-sm-10"> Incorporated or registered in India under
				any law for the time being in force which has any non-Indian
				participation in its share capital or management </span> <br /> <br /><br/>
			<g:if test= "${formType == 'Form3' || formType == 'Form2' }">	
				<input type="radio" name="status" class="leftflot" value="noNonIndianParticipation"/><span
					class="col-sm-10"> Registered in India and does not have any non-Indian participation in share capital or management </span>
			</g:if>
		  </g:if>
		  <g:elseif test= "${companyProfile1?.nationality == 'registeredInIndia' }">
				<input type="radio" name="status" class="leftflot"   value="notRegisteredInIndia"/><span
				class="col-sm-10">Not incorporated or registered in India</span><br />
			<br /> 
				<input type="radio" name="status" class="leftflot" checked= "checked" value="registeredInIndia"/><span
				class="col-sm-10"> Incorporated or registered in India under
				any law for the time being in force which has any non-Indian
				participation in its share capital or management </span> <br />  <br /> <br/>
				<g:if test= "${formType == 'Form3' || formType == 'Form2' }">	
				<input type="radio" name="status" class="leftflot" value="noNonIndianParticipation"/><span
					class="col-sm-10"> Registered in India and does not have any non-Indian participation in share capital or management </span>
				</g:if>
			</g:elseif>
			<g:elseif test= "${companyProfile1?.nationality == 'noNonIndianParticipation' }">
				<input type="radio" name="status" class="leftflot"   value="notRegisteredInIndia"/><span
				class="col-sm-10">Not incorporated or registered in India</span><br />
			<br /> 
				<input type="radio" name="status" class="leftflot" value="registeredInIndia"/><span
				class="col-sm-10"> Incorporated or registered in India under
				any law for the time being in force which has any non-Indian
				participation in its share capital or management </span> <br /> <br /> <br/>
				<g:if test= "${formType == 'Form3' }">	
				<input type="radio" name="status" class="leftflot"  checked= "checked" value="noNonIndianParticipation"/><span
					class="col-sm-10"> Registered in India and does not have any non-Indian participation in share capital or management </span>
				</g:if>
			</g:elseif>
		</g:elseif>
		</div>
	</div>



	<div class="form-group col-sm-12 ">
		<label class=" col-sm-12 register-heading">(ii) Permanent Address</label>
	</div>
	
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(a)</span><span
			class="col-sm-10"> Address line1<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="address1"
				value="${companyProfile1?.address1}" req1="1">
		</div>
	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(b)</span><span
			class="col-sm-10">Address line2 </span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="address2"
				value="${companyProfile1?.address2}" >
		</div>
	</div>




	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(c) </span><span
			class="col-sm-10"> Address line3</span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="address3"
				value="${companyProfile1?.address3}">
		</div>
	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(d)</span> <span
			class="col-sm-10"> Country<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<g:select name="countryId" from="${listOfCountries}" optionKey="id"
				optionValue="country" value="${companyProfile1?.country?.id}"
				class="width country ctlwidth" noSelection="['':'-Select-']" req1="1"
				onchange="${remoteFunction (controller: 'applicationManagement',action: 'fetchStates',
							params: "'countryId='+this.value+'&csrfPreventionSalt=${csrfPreventionSalt}'",update: 'updateStates',onComplete: 'updateCountryCodes(this)')}" />
		</div>
	</div>

	<div id="updateStates"></div>


	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(f)</span> <span
			class="col-sm-10"> City<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="city" req1="1"
				value="${companyProfile1?.city}">
		</div>
	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(g)</span> <span
			class="col-sm-10"> Zip / Pincode<span class="text-danger"><b>*</b></span></span></label>

		<div class="col-sm-8">

			<input type="text" class="width ctlwidth" name="pincode2"
				PlaceHolder="Zip / Pin Code" req1="1"
				value="${companyProfile1?.pincode}">

		</div>


	</div>




	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(h)</span> <span
			class="col-sm-10"> Mobile<span class="text-danger"><b>*</b></span></span></label>

		<div class="col-sm-2">

			<g:if test="${!companyProfile1}">
				<input type="text" class="width ctlwidth" placeholder="Mobile No."
					name="mobileCode"  readonly value=""
					id="mobileCode">
			</g:if>
			<g:elseif test="${companyProfile1?.mobile?.contains('-')}">
				<input type="text" class="width ctlwidth" placeholder="Mobile Code"
					name="mobileCode"  readonly
					value="${companyProfile1?.mobile?.split('-')[0]}">

			</g:elseif>
		</div>

		<div class="col-sm-4 less-padding">
			<g:if test="${!companyProfile1}">
				<input type="number" min="1" class="width ctlwidth" placeholder="Mobile No."
					name="mobile" req1="1" mob1="1" num1="1">
			</g:if>

			<g:elseif test="${companyProfile1?.mobile?.contains('-')}">
				<input type="text" class="width ctlwidth" placeholder="Mobile No."
					name="mobile" req1="1" mob1="1" num1="1"
					value="${companyProfile1?.mobile?.split('-')[1]}">
			</g:elseif>

		</div>
	</div>
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(i) </span><span
			class="col-sm-10"> Phone<span class="text-danger"><b>*</b></span></span></label>

		<div class="col-sm-2">
			<g:if test="${!companyProfile1}">

				<input type="text" class="width ctlwidth" placeholder="Mobile No."
					name="PhoneCode" readonly value=""
					id="countryPhoneCode">
			</g:if>
			<g:elseif test="${companyProfile1?.phone?.contains('-')}">
				<input type="text" class="width ctlwidth" placeholder="Mobile No."
					name="PhoneCode" readonly
					value="${companyProfile1?.phone?.split('-')[0]}">
			</g:elseif>
		</div>

		<div class="col-sm-4 less-padding">
			<g:if test="${!companyProfile1}">
				<input type="number" min="1" class="width ctlwidth" placeholder="Phone No."
					name="phone" req1="1" id="">
			</g:if>

			<g:elseif test="${companyProfile1?.phone?.contains('-')}">
				<input type="text" class="width ctlwidth" placeholder="Phone No."
					name="phone" req1="1" value="${companyProfile1?.phone?.split('-')[1]}">
			</g:elseif>
		</div>

	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(j)</span> <span
			class="col-sm-10"> Email<span class="text-danger"><b>*</b></span></span> </label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="email"
				value="${companyProfile1?.email}" req1="1" email1="1">
		</div>
	</div>


	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(k) </span><span
			class="col-sm-10"> Website<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="website" req1="1"
				value="${companyProfile1?.website}">
		</div>
	</div>


	<div class="form-group col-sm-12">
		<label class=" col-sm-12 register-heading">(iii) Profile of
			Organization</label>
	</div>





	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(a)</span> <span
			class="col-sm-10">Nature of Business<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
		  <g:if test= "${companyProfile1?.businessNature?.contains('-') }">
			<g:select name="businessNature" id="profileId" from="${listOfNature}" onchange="hideshowother(this,'otherProfile')"
				 value ="${companyProfile1?.businessNature?.split('-')[0]}"
				class="width ctlwidth" noSelection="['':'-Select-']" req1="1" />
		  </g:if>
		  <g:else>
		  	<g:select name="businessNature" id="profileId" from="${listOfNature}" onchange="hideshowother(this,'otherProfile')"
				 value="${companyProfile1?.businessNature}"
				class="width ctlwidth" noSelection="['':'-Select-']" req1="1" />
		  </g:else>
		</div>
	</div>



	<div id="otherProfile">
		<div class="form-group col-sm-12  less-padding">
			<label class=" col-sm-4"><span class="col-sm-1">(i)</span><span
				class="col-sm-10">Please specify</span></label>
			<div class="col-sm-8">
			<g:if test= "${companyProfile1?.businessNature?.contains('-') }">
				<input type="text" name="otherNatureOfBusiness" value="${companyProfile1?.businessNature?.split('-')[1]}" class="width">
			</g:if>
			<g:else>
				<input type="text" name="otherNatureOfBusiness"  class="width">
			</g:else>
			</div>
		</div>
	</div>

	<div class="form-group col-sm-12 ">
		<label class=" col-sm-12"><span class="leftflot ">(b)</span><span
			class="col-sm-10"> Attach a copy of document of incorporation
				or registration duly attested by the Competent Authority</span></label>
		<div class="col-sm-4 ">
			<g:if test="${companyProfile1?.registrationDocURL}">
				<input type="file" class="width ctlwidth fumargin"
					name="RegistrationDoc" onchange="validateFile(this)">
				<g:link controller="applicationManagement" action="showDc"
					id="${companyProfile1?.id}" target="_blank" class="fumargin"
					params='[filename: "registrationDocName", dataName: "registrationDoc",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
					${companyProfile1?.registrationDocName}
				</g:link>
			</g:if>
			<g:else>
				<input type="file" class="width ctlwidth fumargin"
					name="RegistrationDoc " req1="1" pdf1="1" onchange="validateFile(this)">
			</g:else>
		</div>

	</div>



	<div class="form-group col-sm-12">
		<label class="  register-heading col-sm-12">(iv) Details of
			Authorized Representative of Entity</label>
	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(a)</span> <span
			class="col-sm-10"> Title<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<g:select name="title" req1="1" class="width ctlwidth" req1="1"
				from="${org.nba.application.CompanyProfile?.TitleName?.values()}"
				value="${companyProfile1?.title}"
				noSelection="['':'-Select title-']" />
		</div>
	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(b)</span> <span
			class="col-sm-10"> First Name<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="firstName" req1="1"
				 value="${companyProfile1?.firstName}">
		</div>
	</div>





	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(c)</span> <span
			class="col-sm-10"> Middle Name</span></label>
		<div class="col-sm-8">
			<input type="text" class="width " name="middleName" 
				 value="${companyProfile1?.middleName}">
		</div>
	</div>





	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(d)</span><span
			class="col-sm-10"> Last Name<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="lastName" req1="1"
				 value="${companyProfile1?.lastName}">
		</div>
	</div>




	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(e)</span><span
			class="col-sm-10"> Designation<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="designation" req1="1"
				value="${companyProfile1?.designation}">
		</div>
	</div>






	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(f)</span> <span
			class="col-sm-10">Mobile<span class="text-danger"><b>*</b></span></span></label>

		<div class="col-sm-2">
			<g:if test="${!companyProfile1}">
				<input type="text" class="width ctlwidth" name="personMobileCode" id="personMobileCode"
					value="" readonly>
			</g:if>
			<g:elseif test="${companyProfile1?.mobile?.contains('-')}">
					
					<input type="text" class="width ctlwidth" placeholder="Mobile Code"
					name="personMobileCode"  readonly
					value="${companyProfile1?.personMobile?.split('-')[0]}">

			</g:elseif>
		</div>
		<div class="col-sm-4 less-padding">
	
			<g:if test="${!companyProfile1}">
				<input type="text" class="width ctlwidth" placeholder="Mobile No." 
					name="personMobile1" req1="1"  num1="1" mob1="1">
			</g:if>

			<g:elseif test="${companyProfile1?.mobile?.contains('-')}">
				<input type="text" class="width ctlwidth" placeholder="Mobile No."
					name="personMobile1" req1="1"  num1="1" mob1="1" 
					value="${companyProfile1?.mobile?.split('-')[1]}">
			</g:elseif>

		</div>


	</div>






	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4" for="email"><span class="col-sm-1">(g)</span><span
			class="col-sm-10"> Email<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="personEmail"
				email1="1" value="${companyProfile1?.personEmail}">
		</div>
	</div>









	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(h)</span><span
			class="col-sm-10"> Attach a self attested copy of Passport / Driving license</span></label>
		
			<g:if test="${companyProfile1?.passportCopyURL}">
			
				<div class="col-sm-2 klm-select" >
					<g:select id="foucuscontrol" name="authRepresentativeIdSelect" req1="1" value= "${companyProfile1?.authRepresentativeIdSelect }"
						class="width controlclass1" 
						from="${authRepresentativeId}"
						noSelection="['':'-Select Proof-']" />
			  	</div>	
			  
			  	<div class="col-sm-2 klm-number" >
					<input type="text" class="width controlclass1" name="idNum" placeholder="Id Number"
					value="${companyProfile1?.idNum }" >
			  	</div>
			  
			  	<div class="col-sm-3 klm-fileUpload" >
					<input type="file" class="width ctlwidth" name="Passport" onchange="validateFile(this)">
					<g:link controller="applicationManagement" action="showDc"
						id="${companyProfile1?.id}" target="_blank"
						params='[filename: "passportCopy", dataName: "passportCopy",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
						${companyProfile1?.passportCopyFileName}
					</g:link>
				</div>	
			</g:if>
			<g:else>
			
				<div class="col-sm-2 klm-select" >
					<g:select id="foucuscontrol" name="authRepresentativeIdSelect" req1="1"
						class="width controlclass1" 
						from="${authRepresentativeId}"
						noSelection="['':'-Select Proof-']" />
			  	</div>	
			  
			  <div class="col-sm-2 klm-number" >
					<input type="text" class="width controlclass1" name="idNum" placeholder="Id Number"
					value="" >
			  </div>
			  
			  <div class="col-sm-3 klm-fileUpload" >
			
				<input type="file" class="width ctlwidth" name="Passport" req1="1"
					pdf1="1" onchange="validateFile(this)">
			  </div>		
			</g:else>
		

	</div>
	<div class="col-sm-12 form-group">

		<div class="col-sm-8">
			<g:if test="${scheduleAformat?.document}">
				<g:link controller="applicationManagement"
					action="showDeclarationForm" id="${scheduleAformat?.id}"
					target="_blank"
					params='[filename: "scheduleAformat", dataName: "scheduleAformat",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
					${scheduleAformat?.docName}
				</g:link>
			</g:if>

		</div>
	</div>


	<div class="form-group col-sm-12">
		<label class=" col-sm-12"><span class="leftflot">(i)</span> <span
			class="col-sm-10"> Attach a copy of letter of authorization or
				board resolution or office order issued by the competent authority
				to the representative for signing the application</span></label>
		<div class="col-sm-8">

			<g:if test="${companyProfile1?.authorizationLetterURL}">
				<input type="file" class="width ctlwidth fumargin"
					name="AuthorizationLetter" onchange="validateFile(this)">
				<g:link controller="applicationManagement" action="showDc"
					class="fumargin" id="${companyProfile1?.id}" target="_blank"
					params='[filename: "authorizationLetterFileName", dataName: "authorizationLetterFileName",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
					${companyProfile1?.authorizationLetterFileName}
				</g:link>
			</g:if>
			<g:else>
				<input type="file" class="width ctlwidth fumargin"
					name="AuthorizationLetter" req1="1" pdf1="1" onchange="validateFile(this)">
			</g:else>
		</div>

	</div>




	<div class="col-sm-12 text-right top_Pad">
		<g:hiddenField name="profileId" value="${companyProfile1?.id}" />
		<g:hiddenField name="formType" value="${formType}" />
		<g:hiddenField name="appFormId" value="${appForm?.id}" />
		<input type="Submit" class="btn btn-primary  btnctrl" value="Save"></input>
		<input type="button" class="btn btn-primary focusbtn" value="Add More" />

	</div>
</g:uploadForm>