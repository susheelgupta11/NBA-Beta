
<script type="text/javascript">

function updateCountryCodes(e){
//var code = $(e).val();
e.data.split('=')[1]
	var countryId = e.data? e.data.split('=')[1]:"No value"
	$.ajax({
		type : "POST",
		url : fetchCodes,
		data : {
			countryId : countryId
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

<g:each var="companyProfile1" in="${listOfCompanyData }">
	<div class="form-group col-sm-12">
		<label class=" col-sm-12 register-heading">1. Full Particulars
			of Applicant</label>
	</div>



	<div class="form-group col-sm-12">
		<label class=" col-sm-12 register-heading">(i) Name</label>
	</div>


	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(a)</span><span
			class="col-sm-10"> Name of Entity</span></label>
		<div class="col-sm-8">
			${companyProfile1?.entityName}
		</div>
	</div>


	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(b)</span><span
			class="col-sm-10"> Type of Entity</span></label>
		<div class="col-sm-8">
<%--			<g:each in="${entityTypes}" var="entityType">--%>
				<g:if test= "${companyProfile1?.entityType}">	
					<g:radio name="entityType" value="${entityType}"  disabled="disabled" req1="1"
						class="ctlwidth leftflot"
						checked="checked" />
					<span id="TopPadding " class="col-sm-10"> ${companyProfile1?.entityType}</span>
				</g:if>
				<g:else>
					<span class= "text-danger">Please Select an Entity Type</span>
				</g:else>
					<br />
					<br />
<%--			</g:each>--%>
		</div>
	</div>





	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(c)</span><span
			class="col-sm-10"> Status</span></label>
		<div class="col-sm-8">
		
			<g:if test= "${companyProfile1?.nationality == 'notRegisteredInIndia' }">
				<input type="radio" name="status" class="leftflot" checked= "checked"  value="notRegisteredInIndia"/><span
				class="col-sm-10">Not incorporated or registered in India</span><br />
			<br /> 
			</g:if>
			<g:else>
				<input type="radio" name="status" class="leftflot" checked= "checked" value="registeredInIndia"/><span
				class="col-sm-10"> Incorporated or registered in India under
				any law for the time being in force which has any non-Indian
				participation in its share capital or management </span> <br /> 
			</g:else>
		</div>
	</div>



	<div class="form-group col-sm-12 ">
		<label class=" col-sm-12 register-heading">(ii) Permanent
			Address</label>
	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(a)</span><span
			class="col-sm-10"> Address</span></label>
		<div class="col-sm-8">
			${companyProfile1?.address1} ${companyProfile1?.address2} ${companyProfile1?.address3}
		</div>
	</div>

	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(b)</span> <span
			class="col-sm-10"> Country</span></label>
		<div class="col-sm-8">
			${companyProfile1?.country?.id}
		</div>
	</div>

	<div id="updateStates"></div>


	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(c)</span> <span
			class="col-sm-10"> City</span></label>
		<div class="col-sm-8">
			${companyProfile1?.city}
		</div>
	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(d)</span> <span
			class="col-sm-10"> Zip / Pincode</span></label>

		<div class="col-sm-8">

			${companyProfile1?.pincode}

		</div>


	</div>




	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(e)</span> <span
			class="col-sm-10"> Mobile</span></label>

		<div class="col-sm-2">

			<g:if test="${!companyProfile1}">
				<span class= "text-danger">N/A</span>
			</g:if>
			<g:elseif test="${companyProfile1?.mobile?.contains('-')}">
				${companyProfile1?.mobile}
			</g:elseif>
		</div>

	</div>
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(f) </span><span
			class="col-sm-10"> Phone</span></label>

		<div class="col-sm-2">
			<g:if test="${!companyProfile1}">
				N/A
			</g:if>
			<g:elseif test="${companyProfile1?.phone?.contains('-')}">
				${companyProfile1?.phone}
			</g:elseif>
		</div>

	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(g)</span> <span
			class="col-sm-10"> Email</span> </label>
		<div class="col-sm-8">
			${companyProfile1?.email}
		</div>
	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(h) </span><span
			class="col-sm-10"> Website</span></label>
		<div class="col-sm-8">
			${companyProfile1?.website}
		</div>
	</div>


	<div class="form-group col-sm-12">
		<label class=" col-sm-12 register-heading">(iii) Profile of
			Organization</label>
	</div>





	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(a)</span> <span
			class="col-sm-10">Nature of Business</span></label>
		<div class="col-sm-8">
			${companyProfile1?.businessNature}
		</div>
	</div>


	<div class="form-group col-sm-12 ">
		<label class=" col-sm-12"><span class="leftflot ">(b)</span><span
			class="col-sm-10"> Attached copy of document of incorporation
				or registration duly attested by the Competent Authority</span></label>
		<div class="col-sm-4 ">
			<g:if test="${companyProfile1?.registrationDoc}">
				<g:link controller="applicationManagement" action="showDc"
					id="${companyProfile1?.id}" target="_blank" class="fumargin"
					params="[filename: 'registrationDocName', dataName: 'registrationDoc',csrfPreventionSalt:'${csrfPreventionSalt}']">
					${companyProfile1?.registrationDocName}
				</g:link>
			</g:if>
			<g:else>
				<span class="text-danger">Document Not Attached</span>
			</g:else>
		</div>

	</div>



	<div class="form-group col-sm-12">
		<label class="  register-heading col-sm-12">(iv) Details of
			Authorized Representative of Entity</label>
	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(a)</span> <span
			class="col-sm-10"> Name</span></label>
		<div class="col-sm-8">
			${companyProfile1?.title} ${companyProfile1?.firstName} ${companyProfile1?.middleName} ${companyProfile1?.lastName}
		</div>
	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(b)</span><span
			class="col-sm-10"> Designation</span></label>
		<div class="col-sm-8">
			${companyProfile1?.designation}
		</div>
	</div>






	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(c)</span> <span
			class="col-sm-10">Mobile</span></label>

		<div class="col-sm-2">
			<g:if test="${!companyProfile1}">
				N/A
			</g:if>
			<g:elseif test="${companyProfile1?.mobile?.contains('-')}">
				${companyProfile1?.mobile}
			</g:elseif>
		</div>
		
	</div>


	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4" for="email"><span class="col-sm-1">(d)</span><span
			class="col-sm-10"> Email</span></label>
		<div class="col-sm-8">
			${companyProfile1?.personEmail}
		</div>
	</div>

	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(e)</span><span
			class="col-sm-10"> Attached passport copy with self
				attestation</span></label>
		<div class="col-sm-8">
			<g:if test="${companyProfile1?.passportCopy}">
				<g:link controller="applicationManagement" action="showDc"
					id="${companyProfile1?.id}" target="_blank"
					params="[filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:'${csrfPreventionSalt}']">
					${companyProfile1?.passportCopyFileName}
				</g:link>
			</g:if>
			<g:else>
				<span class="text-danger" >Document Not Attached</span>
			</g:else>
		</div>

	</div>
	


	<div class="form-group col-sm-12">
		<label class=" col-sm-12"><span class="leftflot">(f)</span> <span
			class="col-sm-10"> Attached copy of letter of authorization or
				board resolution or office order issued by the competent authority
				of the representative for signing the application</span></label>
		<div class="col-sm-8">

			<g:if test="${companyProfile1?.authorizationLetter}">
				<g:link controller="applicationManagement" action="showDc"
					class="fumargin" id="${companyProfile1?.id}" target="_blank"
					params="[filename: 'authorizationLetterFileName', dataName: 'authorizationLetterFileName',csrfPreventionSalt:'${csrfPreventionSalt}']">
					${companyProfile1?.authorizationLetterFileName}
				</g:link>
			</g:if>
			<g:else>
				<span class= "text-danger">Document Not Attached</span>
			</g:else>
		</div>

	</div>
</g:each>

