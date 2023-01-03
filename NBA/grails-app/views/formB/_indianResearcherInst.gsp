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


$( document ).ready(function() {
	$("#diffPresentAddress").hide();
});

function diffPresentAddress(){
	$("#diffPresentAddress").show();
}
function samePresentAddress(){
	$("#diffPresentAddress").hide();
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


<div class="form-group col-sm-12 less-padding">
		<label class="col-sm-4"><span class="col-sm-1">(a)</span> <span
			class="col-sm-10">Title<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<g:select id="foucuscontrol" name="title" req1="1"
				class="width controlclass1" value="${individualProfile?.title}"
				from="${IndividualProfile.TitleName.values()}"
				noSelection="['':'-Select title-']" />
		</div>
	</div>




	<div class="col-sm-12 form-group less-padding">

		<label class="col-sm-4"><span class="col-sm-1">(b)</span> <span
			class="col-sm-10">First Name<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlclass1" name="firstName"
				autocomplete="off" req1="1" value="${individualProfile?.firstName}">
		</div>

	</div>



	<div class="col-sm-12 form-group less-padding">

		<label class="col-sm-4"><span class="col-sm-1">(c) </span><span
			class="col-sm-10">Middle Name</span></label>
		<div class="col-sm-8">
			<input type="text" class="width " name="middleName"
				autocomplete="off" value="${individualProfile?.middleName}">
		</div>

	</div>



	<div class="col-sm-12 form-group less-padding">

		<label class="col-sm-4"><span class="col-sm-1">(d)</span> <span
			class="col-sm-10">Last Name<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlclass1" name="lastName"
				autocomplete="off" value="${individualProfile?.lastName}" req1="1">
		</div>
	</div>

	<div class="col-sm-12 form-group less-padding">

		<label class=" col-sm-4"><span class="col-sm-1">(e)</span><span
			class="col-sm-10"> Nationality<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<g:select from="${nationality}" class="width controlclass1"
				name="nationality" req1="1" id="nationality"
				value="${individualProfile?.nationality}"
				onchange="updateCountry(this)" />
		</div>
	</div>






	<div class="form-group col-sm-12 ">
		<label class=" col-sm-12 register-heading">(ii) Complete
			Address</label>
	</div>
<div class="form-group col-sm-12 ">
		<label class="control-label col-sm-6 "><span class="col-sm-1"><font size="3">(a)</font></span>
			<span class="col-sm-6" ><font size="3">Permanent Address</font><span class="text-danger"><b>*</b></span></span></label>
	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(i)</span><span
			class="col-sm-10"> Address line1<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="address1"
				value="${companyProfile1?.address1}" req1="1">
		</div>
	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(ii)</span><span
			class="col-sm-10">Address line2 </span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="address2"
				value="${companyProfile1?.address2}" >
		</div>
	</div>




	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(iii) </span><span
			class="col-sm-10"> Address line3</span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="address3"
				value="${companyProfile1?.address3}">
		</div>
	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(iv)</span> <span
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
		<label class=" col-sm-4"><span class="col-sm-1">(v)</span> <span
			class="col-sm-10"> City<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="city" req1="1"
				value="${companyProfile1?.city}">
		</div>
	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(vi)</span> <span
			class="col-sm-10"> Zip / Pincode<span class="text-danger"><b>*</b></span></span></label>

		<div class="col-sm-8">

			<input type="text" class="width ctlwidth" name="pincode2"
				PlaceHolder="Zip / Pin Code" req1="1"
				value="${companyProfile1?.pincode}">

		</div>


	</div>




	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(vii)</span> <span
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
				<input type="text" class="width ctlwidth" placeholder="Mobile No."
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
		<label class=" col-sm-4"><span class="col-sm-1">(viii) </span><span
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
				<input type="text" class="width ctlwidth" placeholder="Phone No."
					name="phone" req1="1" id="">
			</g:if>

			<g:elseif test="${companyProfile1?.phone?.contains('-')}">
				<input type="text" class="width ctlwidth" placeholder="Phone No."
					name="phone" req1="1" value="${companyProfile1?.phone?.split('-')[1]}">
			</g:elseif>
		</div>

	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(ix)</span> <span
			class="col-sm-10"> Email<span class="text-danger"><b>*</b></span></span> </label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="email"
				value="${companyProfile1?.email}" req1="1" email1="1">
		</div>
	</div>


<div class="form-group col-sm-12 ">
		<label class="control-label col-sm-6 "><span class="col-sm-1"><font size="3">(a)</font></span>
			<span class="col-sm-6" ><font size="3">Present Address</font><span class="text-danger"><b>*</b></span></span></label>
	</div>
<div class="col-sm-12 form-group ">

		<label class="control-label col-sm-6"><span class="col-sm-1"></span>
			<span class="col-sm-10"><i>Same as above</i><span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-2 ">
			<input type="radio" name="presentAddress" value="Yes" onclick="samePresentAddress()" /><b class="">Yes</b>
			<input type="radio" name="presentAddress" value="No" onclick="diffPresentAddress()" /><b class="">No</b>
		</div>
	</div><br/>


<div id="diffPresentAddress">
	
		<div class="col-sm-12 form-group ">

		<label class="control-label col-sm-6"><span class="col-sm-1">(i)</span>
			<span class="col-sm-10">Address line1<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-6">
			<input type="text" class="form-control" placeholder=""/>

		</div>
		</div>
	
		<div class="col-sm-12 form-group ">

		<label class="control-label col-sm-6"><span class="col-sm-1">(ii)</span>
			<span class="col-sm-10">Address line2</span></label>
		<div class="col-sm-6">
			<input type="text" class="form-control" placeholder=""/>

		</div>
		</div>
	
		<div class="col-sm-12 form-group ">

		<label class="control-label col-sm-6"><span class="col-sm-1">(iii)</span>
			<span class="col-sm-10">Address line3</span></label>
		<div class="col-sm-6">
			<input type="text" class="form-control" placeholder=""/>

		</div>
		</div>
	
		<div class="col-sm-12 form-group ">

		<label class="control-label col-sm-6"><span class="col-sm-1">(iv)</span>
			<span class="col-sm-10">Country<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-6">
			<input type="text" class="form-control" placeholder="Country"/>

		</div>
		</div>
	
		<div class="col-sm-12 form-group ">

		<label class="control-label col-sm-6"><span class="col-sm-1">(v)</span>
			<span class="col-sm-10">City<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-6">
			<input type="text" class="form-control" placeholder=""/>

		</div>
		</div>
		<div class="col-sm-12 form-group ">

		<label class="control-label col-sm-6"><span class="col-sm-1">(vi)</span>
			<span class="col-sm-10">ZIP/ Pincode<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-6">
			<input type="text" class="form-control" placeholder="ZIP/ Pincode"/>

		</div>
		</div>
		<div class="col-sm-12 form-group ">

		<label class="control-label col-sm-6"><span class="col-sm-1">(vii)</span>
			<span class="col-sm-10">Mobile<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-6">
			<input type="text" class="form-control" placeholder="Mobile"/>

		</div>
		</div>
		<div class="col-sm-12 form-group ">

		<label class="control-label col-sm-6"><span class="col-sm-1">(viii)</span>
			<span class="col-sm-10">Phone<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-6">
			<input type="text" class="form-control" placeholder="Phone"/>

		</div>
		</div>
		<div class="col-sm-12 form-group ">

		<label class="control-label col-sm-6"><span class="col-sm-1">(ix)</span>
			<span class="col-sm-10">Email<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-6">
			<input type="text" class="form-control" placeholder=""/>

		</div>
		</div>
	
	</div>

<div class="col-sm-12 form-group ">

		<label class="control-label col-sm-6"><span class="col-sm-1">(c)</span>
			<span class="col-sm-10">Attach address proof with Self attestation</span></label>
		
		<div class="col-sm-2">
			<select class="form-control">
				<option value="">--Select--</option>
				<option value="VoterId">VoterId Proof</option>
<%--				<option value="VoterId">Aadhar Card</option>--%>
				<option value="DrivingLicence">Driving Licence</option>
				<option value="PANcard">Passport</option>
			</select>
		</div>
		<div class="col-sm-2">
			<input type="text" class="form-control" placeholder="Proof No"/>
		</div>
		<div class="col-sm-2">
			<input type="file" class="form-control" placeholder="Proof No"/>
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