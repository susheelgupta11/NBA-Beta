<%! import org.nba.application.IndividualProfile %>

<script type="text/javascript">
	$(document).ready(function() {
		$("#ifIndian").hide();
		$("#statesdiv").hide();
		$("#statesdivDef").hide();
       
		if(selectedCountry != ''){
			//alert("inside if "+selectedCountry);
			$("#statesdiv").hide();
			$("#statesdivDef").show();

			if(selectedCountry == 'India'){
				$("#notIndian").hide();
				$("#noneSelected").hide();
	                $("#ifIndian").show();
				}
			else {
				$("#notIndian").hide();
				$("#ifIndian").hide();
	                $("#noneSelected").show();
				}
		}
	
		else {

			}
		
		
		//alert("hi");
		//$("#notIndian").hide();

		$('#nationality').change(function() {
			var data = $(this).val();
		});

		//$("#nationality").trigger("change");
	});
	function updateCountryCodes(e) {
		//alert("fjdlskfjakasdf");
		$("#indian").val('');
		//var code = $(e).val();
		var ele = e.id
		//$("#statesdivDef").hide();
		var countryId = $('#' + ele).val() ? $('#' + ele).val() : "No value"
		debugger
		$.ajax({
			type : "POST",
			url : fetchCodes,
			data : {
				countryId : countryId,
				csrfPreventionSalt : csrfPreventionSalt
			},
			success : function(result) {
				$('#mobileCode').val('');
				$('#mobileCode').val(result.phonecode);
				$('#PhoneCode').val('');
				$('#PhoneCode').val(result.phonecode);
			},
			error : function() {
				//alert("An error has (Himanshu jain) occured!!!");
			}

		});
	}
</script>
<g:javascript>
var fetchCodes = "${createLink(controller:'applicationManagement',action:'fetchMobileCode')}"
  var checkCountry = "${createLink(controller:'applicationManagement',action:'fetchCountryCode')}"
  var checkCodes = "${createLink(controller:'applicationManagement',action:'fetchcodes')}"
  var selectedProof = "${individualProfile?.idProofSelect }"
  var selectedCountry = "${individualProfile?.country?.country}"
  var csrfPreventionSalt = "${csrfPreventionSalt}"
  
  </g:javascript>
<g:uploadForm class="form-horizontal" role="form" autocomplete="off"
	action="submitIndividualFormProfile">
	<input type="hidden" name="csrfPreventionSalt" id="csrfPreventionSalt"
		value="${csrfPreventionSalt}" />


	<div class="col-sm-12 form-group">
		<div class="text-center">
			<b><span class="text-success"> ${flash.message }
			</span></b>
		</div>
		<label class="control-label col-sm-12 register-heading">(i)
			Full Particulars of the Applicant</label>

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

	<g:if test="">
		<div class="col-sm-12 form-group" id="otherNationality">

			<label class="control-label col-sm-4">Specify Nationality</label>
			<div class="col-sm-8">
				<input type="text" class="width" name="otherNationality"
					autocomplete="off">

			</div>
		</div>
	</g:if>

	<div class="col-sm-12 form-group">

		<label class="control-label col-sm-12 register-heading">(ii)
			Permanent Address</label>

	</div>

	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-4"><span class="col-sm-1">(a)</span>
			<span class="col-sm-10">Address line1<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlclass1" name="address1"
				autocomplete="off" value="${individualProfile?.address1}" req1="1">

		</div>
	</div>

	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-4"><span class="col-sm-1">(b)</span>
			<span class="col-sm-10">Address line2</span></label>
		<div class="col-sm-8">
			<input type="text" class="width" name="address2" autocomplete="off"
				value="${individualProfile?.address2}">

		</div>
	</div>


	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-4"><span class="col-sm-1">(c)</span>
			<span class="col-sm-10">Address line3</span></label>
		<div class="col-sm-8">
			<input type="text" class="width" name="address3" autocomplete="off"
				value="${individualProfile?.address3}">

		</div>
	</div>

	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-4"><span class="col-sm-1">(d)</span>
			<span class="col-sm-10">Country<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<div id="ifIndian">
				<input type="text" value="${individualProfile?.country?.country}" readonly id="indian" name="country"
					autocomplete="off" class="width">
			</div>
			<div id="notIndian"></div>
			<div id="noneSelected">
				<g:select name="countryId" from="${listOfCountries}" optionKey="id"
					optionValue="country" id="country"
					value="${individualProfile?.country?.id}"
					class="width controlclass1 country" noSelection="['':'-Select-']"
					req1="1" onchange="updateCountryCodes(this)" />
			</div>
		</div>
	</div>

	<div class="col-sm-12 form-group less-padding" id="statesdiv">

		<label class=" col-sm-4"><span class="col-sm-1">(e)</span><span
			class="col-sm-10"> State / Province</span></label>
		<div class="col-sm-8">
			<g:select name="province" from="${statesList?.state}" id="province"
				class=" width ctrolreqddl" value=""
				noSelection="['':'Select State']" />
		</div>
	</div>
	
	<div class="col-sm-12 form-group less-padding" id="statesdivDef">

		<label class=" col-sm-4"><span class="col-sm-1">(e)</span><span
			class="col-sm-10"> State / Province</span></label>
		
			<div class="col-sm-8">
				<input type="text" class="width statetxt" id="statesdivD" name="state"
					value="${individualProfile?.province}">
			</div>
		
	</div>




	<div id="updateStates"></div>




	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-4"><span class="col-sm-1">(f)</span>
			<span class="col-sm-10">City<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">

			<input type="text" class="width controlclass1" name="city"
				autocomplete="off" value="${individualProfile?.city}" req1="1">


		</div>
	</div>

	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-4"> 
			<span class="col-sm-1">(g)</span><span class="col-sm-10">ZIP / Pincode<span class="text-danger"><b>*</b></span></span>
		</label>

		<div class="col-sm-8 ">

			<input type="text" class="width controlclass1" name="pincode2"
				autocomplete="off" PlaceHolder="Zip / Pin Code" req1="1"
				value="${individualProfile?.pincode}">


		</div>

	</div>


	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-4"><span class="col-sm-1">(h)</span>
			<span class="col-sm-10">Mobile<span class="text-danger"><b>*</b></span></span></label>

		<div class="col-sm-2" id="countryMobileCode">

			<g:if test="${!individualProfile}">
				<input type="text" id="mobileCode" class="width" readonly
					placeholder="Mobile No." name="mobileCode" value="">
			</g:if>

			<g:elseif test="${individualProfile?.mobile?.contains('-')}">
				<input type="text" class="width controlclass1" readonly
					placeholder="Mobile No." name="mobileCode" id="mobileCode"
					value="${individualProfile?.mobile?.split('-')[0]}">
			</g:elseif>


		</div>

		<div class="col-sm-4 less-padding">
			<g:if test="${!individualProfile}">
				<input type="number" class="width controlclass1" min="1" autocomplete="off"
					placeholder="Mobile No." name="mobile" req1="1" num1="1" mob1="1">
			</g:if>

			<g:elseif test="${individualProfile?.mobile?.contains('-')}">
				<input type="text" class="width controlclass1" autocomplete="off"
					placeholder="Mobile No." name="mobile" req1="1" num1="1" mob1="1"
					value="${individualProfile?.mobile?.split('-')[1]}">
			</g:elseif>

		</div>
	</div>

	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-4"><span class="col-sm-1">(i)</span><span
			class="col-sm-10"> Phone<span class="text-danger"><b>*</b></span></span></label>

		<div class="col-sm-2">
			<g:if test="${!individualProfile}">
				<input type="text" class="width controlclass1"
					placeholder="Phone No." name="PhoneCode" id="countryPhoneCode"
					readonly>
			</g:if>
			<g:elseif test="${individualProfile?.phone?.contains('-')}">

				<input type="text" class="width controlclass1" readonly
					placeholder="Phone No." name="PhoneCode" req="1" id="PhoneCode"
					value="${individualProfile?.phone?.split('-')[0]}">

			</g:elseif>
		</div>
		<div class="col-sm-4 less-padding">
			<g:if test="${!individualProfile}">
				<input type="number" class="width controlclass1" min="1" autocomplete="off"
					placeholder="Phone No." name="phone" num1="1">
			</g:if>
			<g:elseif test="${individualProfile?.phone?.contains('-')}">

				<input type="text" class="width controlclass1" autocomplete="off"
					placeholder="Phone No." name="phone" num1="1"
					value="${individualProfile?.phone?.split('-')[1]}">

			</g:elseif>
		</div>


	</div>

	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-4" for="email"><span
			class="col-sm-1">(j)</span> <span class="col-sm-10">Email<span
				class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">

			<input type="text" class="width controlclass1" name="email"
				autocomplete="off" value="${individualProfile?.email}" req1="1"
				email1="1">


		</div>
	</div>

	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-4"><span class="col-sm-1">(k)</span>
			<span class="col-sm-10">Attach ID proof copy with Self
				Attestation (Driving License / Goverment ID)<span
				class="text-danger"><b>*</b></span>
		</span></label>






		<g:if test="${individualProfile?.idProof || individualProfile?.idProofURL}">
			
			
			<div class="col-sm-2 klm-select" id="">
				<g:select id="idProofSelect" name="idProofSelect" 
					class="width controlclass1" req1="1"
					value="${individualProfile?.idProofSelect}" from="${idProofSelect}"
					noSelection="['':'-Select Proof-']" />
			</div>

			<div class="col-sm-2 klm-number">
				<input type="text" class="width controlclass1" name="IdNum"
					placeholder="Id Number" value="${individualProfile?.idNum}">
			</div>

			<div class="col-sm-3 klm-fileUpload">
				<input type="file" class="width controlclass1" name="IdProof"
					value="${individualProfile?.idProof }" onchange="validateFile(this)">
				<g:link controller="applicationManagement" action="showIndividualDc"
					id="${individualProfile?.id}" target="_blank"
					params='[filename: "idProof", dataName: "idProof",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
					${individualProfile?.idProofFileName}
				</g:link>
			</div>
		</g:if>
		<g:else>

		<g:if test= "${idProofIndian }">
			<div class="col-sm-2 klm-select" id="">
				<g:select id="idProofSelect" name="idProofSelect" req1="1"
					class="width controlclass1" from="${idProofIndian }"
					noSelection="['':'-Select Proof-']"/>
			</div>
		</g:if>	
		<g:else>
			<div class="col-sm-2 klm-select" id="">
				<g:select id="idProofSelect" name="idProofSelect" req1="1"
					class="width controlclass1" from=""
					noSelection="['':'-Select Proof-']"/>
			</div>
		</g:else>	

			<div class="col-sm-2 klm-number">
				<input type="text" class="width controlclass1" name="IdNum"
					placeholder="Id Number" value="">
			</div>

			<div class="col-sm-3 klm-fileUpload">
				<input type="file" class="width controlclass1" name="IdProof"
					req1="1" pdf1="1" mb10="1"  onchange="validateFile(this)">
			</div>

		</g:else>
	</div>





	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-4"><span class="col-sm-1">(l)</span><span
			class="col-sm-10"> Attach the passport /Driving Licence copy  with Self Attestation<span class="text-danger"><b>*</b></span>
		</span></label>


		<g:if test="${individualProfile?.passportCopy || individualProfile?.passportURL}">

			<div class="col-sm-2 klm-select">
				<g:select id="foucuscontrol" name="passportSelect" req1="1"
					class="width controlclass1"
					value="${individualProfile?.passportSelect }"
					from="${passportSelect }" noSelection="['':'-Select Proof-']" />
			</div>

			<div class="col-sm-2 klm-number">
				<input type="text" class="width controlclass1" name="passportNum"
					placeholder="Passport Number"
					value="${individualProfile?.passportNum }">
			</div>

			<div class="col-sm-3 klm-fileUpload">
				<input type="file" class="width controlclass1" name="Passport"
					value="${individualProfile?.passportCopy }" onchange="validateFile(this)">
				<g:link controller="applicationManagement" action="showIndividualDc"
					id="${individualProfile?.id}" target="_blank"
					params='[filename: "passportCopy", dataName: "passportCopy",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
					${individualProfile?.passportCopyFileName}
				</g:link>
			</div>

		</g:if>
		<g:else>

			<div class="col-sm-2 klm-select">
				<g:select id="foucuscontrol" name="passportSelect" req1="1"
					class="width controlclass1" value="" from="${passportSelect }"
					noSelection="['':'-Select Proof-']" />
			</div>

			<div class="col-sm-2 klm-number">
				<input type="text" class="width controlclass1" name="passportNum"
					placeholder="Passport No." value="">
			</div>

			<div class="col-sm-3 klm-fileUpload">
				<input type="file" class="width controlclass1" name="Passport"
					req1="1" pdf1="1" onchange="validateFile(this)">
			</div>

		</g:else>


	</div>


	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-4"><span class="col-sm-1">(m)</span>
			<span class="col-sm-10">Attach the Authorization letter, if
				necessary </span></label>

		<g:if test="${individualProfile?.authorizationLetter || individualProfile?.authorizationLetterURL}">

			<div class="col-sm-2 klm-select">
				<g:select id="foucuscontrol" name="authorizationSelect"
					class="width controlclass1"
					value="${individualProfile?.authorizationSelect }"
					from="${authorizationSelect }" noSelection="['':'-Select Proof-']" />
			</div>

			<div class="col-sm-2 klm-number">
				<input type="text" class="width controlclass1"
					name="authorizationNo" placeholder="Authorization No."
					value="${individualProfile?.authorizationNo }">
			</div>

			<div class="col-sm-3 klm-fileUpload">

				<input type="file" class="width  " name="AuthorityLetter"
					value="${individualProfile?.authorizationLetter}" onchange="validateFile(this)">
				<g:link controller="applicationManagement" action="showIndividualDc"
					id="${individualProfile?.id}" target="_blank"
					params='[filename: "authorizationLetter", dataName: "authorizationLetter",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
					${individualProfile?.authorizationLetterFileName}
				</g:link>
			</div>
		</g:if>
		<g:else>

			<div class="col-sm-2 klm-select">
				<g:select id="foucuscontrol" name="authorizationSelect" 
					class="width controlclass1" value="" from="${authorizationSelect }"
					noSelection="['':'-Select Proof-']" />
			</div>

			<div class="col-sm-2 klm-number">
				<input type="text" class="width controlclass1"
					name="authorizationNo" placeholder="Authorization No." value="">
			</div>

			<div class="col-sm-3 klm-fileUpload">

				<input type="file" class="width  " pdf1="1" mb5="1"
					name="AuthorityLetter" onchange="validateFile(this)">
			</div>

		</g:else>
	</div>



	<div class="col-sm-12 form-group ">

		<label class="control-label col-sm-12 register-heading">(iii)
			Profile of the Applicant(s)</label>

	</div>

	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-4"><span class="col-sm-1">(a)</span>
			<span class="col-sm-10">Profile</span></label>

		<div class="col-sm-8">
			<g:if test="${individualProfile?.profile?.contains('-') }">
				<g:select name="profile" from="${profile}" id="profileId"
					onchange="hideshowother(this,'otherProfile')"
					value="${individualProfile?.profile?.split('-')[0]}"
					class="width  controlclass1" req1="1" />
			</g:if>
			<g:else>
				<g:select name="profile" from="${profile}" id="profileId"
					onchange="hideshowother(this,'otherProfile')"
					value="${individualProfile?.profile}" class="width  controlclass1"
					req1="1" />
			</g:else>
		</div>
	</div>


	<div class="col-sm-12 form-group less-padding" id="otherProfile">
		<g:if test="${individualProfile?.profile?.contains('-') }">
			<label class="control-label col-sm-4"><span class="col-sm-1">(i)</span>
				<span class="col-sm-10"> Please Specify</span></label>
			<div class="col-sm-8">
				<input type="text" class="width controlclass1" autocomplete="off"
					name="otherProfile"
					value="${individualProfile?.profile?.split('-')[1] }">
			</div>
		</g:if>
		<g:else>
			<label class="control-label col-sm-4"><span class="col-sm-1">(i)</span>
				<span class="col-sm-10"> Please Specify</span></label>
			<div class="col-sm-8">
				<input type="text" autocomplete="off" class="width controlclass1"
					name="otherProfile">
			</div>
		</g:else>
	</div>
	<div class="col-sm-12 text-right top_Pad">
		<g:hiddenField name="profileId" value="${individualProfile?.id}" />
		<g:hiddenField name="formType" value="${formType}" />
		<g:hiddenField name="appFormId" value="${appForm?.id}" />
		<input type="Submit" class="btn btn-primary btncontrolclass1"
			value="Save" oncomplete="checksession(this)"></input> <input
			type="button" class="btn btn-primary focusbtn " value="Add more"></input>

	</div>

</g:uploadForm>