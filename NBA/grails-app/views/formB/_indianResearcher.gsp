<%! import org.nba.application.IndianResearcher %>
<script type="text/javascript">

    $(document).ready(function(){
        $('[data-toggle="tooltip"]').tooltip();
    });
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
function updateCountryCodes1(e){
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
				$('#presentMobileCode').val(result.phonecode);
				$('#presentCountryPhoneCode').val(result.phonecode);
				$('#presentPersonMobileCode').val(result.phonecode);
			},
			error : function() {
				//alert("An error has (Himanshu jain) occured!!!");
			}

		});	
		}

$(document).ready(function() {
    $('#validateMob').blur(function(e) {
        if (validatePhone('validateMob')) {
            $('#spnPhoneStatus').html('');
            //$('#spnPhoneStatus').css('color', 'green');
        }
        else {
            $('#spnPhoneStatus').html('Invalid ! Enter numbers only.');
            $("#validateMob").val('');
            $('#spnPhoneStatus').css('color', 'red');
        }
    });
    $('#validatePh').blur(function(e) {
        if (validatePhone('validatePh')) {
            $('#spnPhoneStatus').html('');
            //$('#spnPhoneStatus').css('color', 'green');
        }
        else {
            $('#spnPhoneStatus').html('Invalid ! Enter numbers only.');
            $("#validatePh").val('');
            $('#spnPhoneStatus').css('color', 'red');
        }
    });
    $('#validatePresntMob').blur(function(e) {
        if (validatePhone('validatePresntMob')) {
            $('#spnPhoneStatusPresent').html('');
            //$('#spnPhoneStatus').css('color', 'green');
        }
        else {
            $('#spnPhoneStatusPresent').html('Invalid ! Enter numbers only.');
            $("#validatePresntMob").val('');
            $('#spnPhoneStatusPresent').css('color', 'red');
        }
    });
    $('#validatePresntPh').blur(function(e) {
        if (validatePhone('validatePresntPh')) {
            $('#spnPhoneStatusPresent').html('');
            //$('#spnPhoneStatus').css('color', 'green');
        }
        else {
            $('#spnPhoneStatusPresent').html('Invalid ! Enter numbers only.');
            $("#validatePresntPh").val('');
            $('#spnPhoneStatusPresent').css('color', 'red');
        }
    });
});

function validatePhone(txtPhone) {
    var a = document.getElementById(txtPhone).value;
    var filter = /^[0-9]+$/;
    if (filter.test(a)) {
        return true;
    }
    else {
        return false;
    }
}



	
</script>

<g:javascript>
var sameAsAbove = "${indianResearcher?.samePresentAddress }"
</g:javascript>
<g:uploadForm class="form-horizontal" role="form" autocomplete="off"
	action="submitIndianResearcher">
	<input type="hidden" name="csrfPreventionSalt"
		value="${csrfPreventionSalt}" />
	<div class="text-center">
		<div class="text-success">
			<g:if test="${flash.args != 'phonePattern' }">
				<b><span> ${flash.message }
				</span></b>
			</g:if>
		</div>
	</div>
	<div class="form-group col-sm-12">
		<label class=" col-sm-12 register-heading">(1) Full Particulars
			of Applicant 
		</label>
	</div>


	<div class="form-group col-sm-12 less-padding">
		<label class="col-sm-4"><span class="col-sm-1">(a)</span> <span
			class="col-sm-10">Title<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<g:select id="foucuscontrol" name="title" req1="1"
				class="width controlclass1" value="${indianResearcher?.title}"
				from="${IndianResearcher.TitleName.values()}"
				noSelection="['':'-Select title-']" />
		</div>
	</div>




	<div class="col-sm-12 form-group less-padding">

		<label class="col-sm-4"><span class="col-sm-1">(b)</span> <span
			class="col-sm-10">First Name<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlclass1" name="firstName"
				autocomplete="off" req1="1" value="${indianResearcher?.firstName}">
		</div>

	</div>



	<div class="col-sm-12 form-group less-padding">

		<label class="col-sm-4"><span class="col-sm-1">(c) </span><span
			class="col-sm-10">Middle Name</span></label>
		<div class="col-sm-8">
			<input type="text" class="width " name="middleName"
				autocomplete="off" value="${indianResearcher?.middleName}">
		</div>

	</div>



	<div class="col-sm-12 form-group less-padding">

		<label class="col-sm-4"><span class="col-sm-1">(d)</span> <span
			class="col-sm-10">Last Name<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlclass1" name="lastName"
				autocomplete="off" value="${indianResearcher?.lastName}" req1="1">
		</div>
	</div>

	

	<div class="form-group col-sm-12 ">
			<label class=" col-sm-12 register-heading">(i) Complete
				Address</label>
		</div>
		
		<div class="col-sm-12 form-group ">
			<div class="form-group col-sm-12">
				<label class=" col-sm-12 ">(a) Permanent Address</label>
			</div>
		</div>
	
	
	
	



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(i)</span><span
			class="col-sm-10"> Address line1<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="address1"
				value="${indianResearcher?.address1}" req1="1">
		</div>
	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(ii)</span><span
			class="col-sm-10">Address line2 </span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="address2"
				value="${indianResearcher?.address2}">
		</div>
	</div>




	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(iii) </span><span
			class="col-sm-10"> Address line3</span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="address3"
				value="${indianResearcher?.address3}">
		</div>
	</div>

	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(iv)</span> <span
			class="col-sm-10"> Country<span class="text-danger"><b></b></span></span></label>
		<div class="col-sm-8" id="countrySelect">
		
		<g:select name="countryId" from="${countryIndiaFromList}" optionKey="id"
				optionValue="country" value="${indianResearcher?.country?.id}"
				class="width country ctlwidth" 
				 />		
				
				
		</div>
	</div>

	<div id="updateStates">
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(vi)</span> <span
			class="col-sm-10"> State<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
		
			<g:select name="state" from="${listOfStates?.state}" req1="1"
				class="width ctlwidth" value="${indianResearcher?.province}"
				noSelection="['':'Select State']" />
		
		</div>
	</div>
	
	</div>


	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(vi)</span> <span
			class="col-sm-10"> City<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="city" req1="1"
				value="${indianResearcher?.city}">
		</div>
	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(vii)</span> <span
			class="col-sm-10"> Pincode<span class="text-danger"><b>*</b></span></span></label>

		<div class="col-sm-8">

			<input type="text" class="width ctlwidth" name="pincode2"
				PlaceHolder="Pin Code" req1="1"
				value="${indianResearcher?.pincode}">

		</div>


	</div>




	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(viii)</span>
			<span class="col-sm-10"> Mobile<span class="text-danger"><b>*</b></span></span></label>

		<div class="col-sm-2">

			<g:if test="${!indianResearcher}">
				<input type="text" class="width ctlwidth " placeholder="Mobile No."
					name="mobileCode" readonly value="+91" id="mobileCode">
			</g:if>
			<g:elseif test="${indianResearcher?.mobile?.contains('-')}">
				<input type="text" class="width ctlwidth" placeholder="Mobile Code"
					name="mobileCode" readonly 
					value="${indianResearcher?.mobile?.split('-')[0]}">

			</g:elseif>
		</div>

		<div class="col-sm-4 less-padding">
			<g:if test="${!indianResearcher}">
				<input type="text" class="width ctlwidth " id="validateMob" placeholder="Enter only numbers"
					name="mobile" req1="1" mob1="1" num1="1">
			</g:if>

			<g:elseif test="${indianResearcher?.mobile?.contains('-')}">
				<input type="text" class="width ctlwidth" id="validateMob" placeholder="Enter only numbers"
					name="mobile" req1="1" mob1="1" num1="1" 
					value="${indianResearcher?.mobile?.split('-')[1]}">
			</g:elseif>

		</div>
	</div>
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(ix) </span><span
			class="col-sm-10"> Phone<span class="text-danger"><b></b></span></span></label>

		<div class="col-sm-2">
			<g:if test="${!indianResearcher}">

				<input type="text" class="width ctlwidth" placeholder="Mobile No."
					name="PhoneCode" readonly value="+91" id="countryPhoneCode">
			</g:if>
			<g:elseif test="${indianResearcher?.phone?.contains('-')}">
				<input type="tel" class="width ctlwidth" placeholder="Mobile No."
					name="PhoneCode" readonly mob1="1" num1="1" 
					value="${indianResearcher?.phone?.split('-')[0]}">
			</g:elseif>
		</div>

		<div class="col-sm-4 less-padding">
			<g:if test="${!indianResearcher}">
				<input type="text" class="width ctlwidth" id="validatePh" placeholder="Enter only numbers"
					name="phone"   >
				
			</g:if>

			<g:elseif test="${indianResearcher?.phone?.contains('-') || flash.message }">
				<input type="text" class="width ctlwidth" id="validatePh" placeholder="Enter only numbers"
					name="phone" mob1="1" num1="1"
					value="${indianResearcher?.phone?.split('-')[1]}">
					
			</g:elseif>
				<span id="spnPhoneStatus">	</span>
		</div>

	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(x)</span> <span
			class="col-sm-10"> Email<span class="text-danger"><b>*</b></span></span>
		</label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="email"
				value="${indianResearcher?.email}" req1="1" email1="1">
		</div>
	</div>


	
	<div class="col-sm-12 form-group ">
		<div class="form-group col-sm-12">
			<label class=" col-sm-12 ">(b) Present Address</label>
		</div>
	</div>
	
	
	
	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-4  "><span class="col-sm-1"></span>
			<span class="col-sm-10"><i>Same as above</i><span
				class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-2 ">
			
			
				<g:if test="${!indianResearcher }">
					<input type="radio" name="samePresentAddress" value="Yes"
						onclick="presentAddressSame()" /><b class="">Yes</b>
						
					<input type="radio" name="samePresentAddress" value="No"
						onclick="diffPresentAddress()" /><b class="">No</b>
				</g:if>
				<g:else>
					
					<g:if test="${indianResearcher?.samePresentAddress == 'Yes' }">
						<input type="radio" name="samePresentAddress" value="Yes" checked
							onclick="presentAddressSame()" /><b class="">Yes</b>
					</g:if>
					<g:else>
						<input type="radio" name="samePresentAddress" value="Yes"
							onclick="presentAddressSame()" /><b class="">Yes</b>
					</g:else>
					
					<g:if test="${indianResearcher?.samePresentAddress == 'No' }">	
						<input type="radio" name="samePresentAddress" value="No" checked
							onclick="diffPresentAddress()" /><b class="">No</b>
					</g:if>
					<g:else>
						<input type="radio" name="samePresentAddress" value="No"
							onclick="diffPresentAddress()" /><b class="">No</b>
					</g:else>	
				
				</g:else>	
				
				
		</div>
	</div>
	<br />


	<div id="diffPresentAddresss">

		<div class="col-sm-12 form-group less-padding">

			<label class="control-label col-sm-4"><span class="col-sm-1">(i)</span>
				<span class="col-sm-10">Address line1<span
					class="text-danger"><b>*</b></span></span></label>
			<div class="col-sm-8">
				<input type="text" name="presentAddress1"
					value="${indianResearcher?.presentAddress1}" class="width ctlwidth" req1="1"
					placeholder="" />

			</div>
		</div>

		<div class="col-sm-12 form-group less-padding">

			<label class="control-label col-sm-4"><span class="col-sm-1">(ii)</span>
				<span class="col-sm-10">Address line2</span></label>
			<div class="col-sm-8">
				<input type="text" name="presentAddress2"
					value="${indianResearcher?.presentAddress2}" class="width ctlwidth" 
					placeholder="" />

			</div>
		</div>

		<div class="col-sm-12 form-group less-padding">

			<label class="control-label col-sm-4"><span class="col-sm-1">(iii)</span>
				<span class="col-sm-10">Address line3</span></label>
			<div class="col-sm-8">
				<input type="text" name="presentAddress3"
					value="${indianResearcher?.presentAddress3}" class="width ctlwidth" 
					placeholder="" />

			</div>
		</div>

		<div class="form-group col-sm-12 less-padding">
			<label class="control-label col-sm-4"><span class="col-sm-1">(iv)</span>
				<span class="col-sm-10"> Country<span class="text-danger"><b>*</b></span></span></label>
			<div class="col-sm-8">
				<g:select name="presentCountry" from="${listOfCountries}"
					optionKey="id" optionValue="country" req1="1"
					value="${indianResearcher?.presentCountry?.id}"
					class="width country ctlwidth" noSelection="['':'-Select-']"
					onchange="${remoteFunction (controller: 'applicationManagement',action: 'fetchStates',
							params: "'countryId='+this.value+'&csrfPreventionSalt=${csrfPreventionSalt}'+'&formType=${formType}'",update: 'updateStates1',onComplete: 'updateCountryCodes1(this)')}" />
			</div>
		</div>

		<div id="updateStates1"></div>

		<div class="col-sm-12 form-group less-padding">

			<label class="control-label col-sm-4"><span class="col-sm-1">(vi)</span>
				<span class="col-sm-10">City<span class="text-danger"><b>*</b></span></span></label>
			<div class="col-sm-8">
				<input type="text" name="presentCity" req1="1"
					value="${indianResearcher?.presentCity}" class="width ctlwidth"
					placeholder="" />

			</div>
		</div>
		<div class="col-sm-12 form-group less-padding">

			<label class="control-label col-sm-4"><span class="col-sm-1">(vii)</span>
				<span class="col-sm-10">Pincode<span class="text-danger"><b>*</b></span></span></label>
			<div class="col-sm-8">
				<input type="text" class="width ctlwidth" name="presentPincode" value="${indianResearcher?.presentPincode}" req1="1"
					placeholder="ZIP/ Pincode" />

			</div>
		</div>
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(viii)</span>
			<span class="col-sm-10"> Mobile<span class="text-danger"><b>*</b></span></span></label>

		<div class="col-sm-2">

			<g:if test="${indianResearcher?.samePresentAddress == 'Yes' || !indianResearcher}">
				<input type="text" class="width ctlwidth" placeholder="Mobile No." req1="1"
					name="PresentMobileCode" readonly value="" id="presentMobileCode">
			</g:if>
			<g:elseif test="${indianResearcher?.presentMobile?.contains('-')}">
				<input type="text" class="width ctlwidth" placeholder="Mobile Code" req1="1"
					name="PresentMobileCode" readonly
					value="${indianResearcher?.presentMobile?.split('-')[0]}">

			</g:elseif>
		</div>

		<div class="col-sm-4 less-padding">
			<g:if test="${indianResearcher?.samePresentAddress == 'Yes' || !indianResearcher}">
				<input type="text" class="width ctlwidth" placeholder="Mobile No." id="validatePresntMob"
					name="presentMobile"  mob1="1" req1="1">
			</g:if>

			<g:elseif test="${indianResearcher?.presentMobile?.contains('-')}">
				<input type="text" class="width ctlwidth" id="validatePresntMob" placeholder="Mobile No."	name="presentMobile"  mob1="1" req1="1"	value="${indianResearcher?.presentMobile?.split('-')[1]}">
			</g:elseif>

		</div>
	</div>
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(ix) </span><span
			class="col-sm-10"> Phone<span class="text-danger"><b></b></span></span></label>
		<div class="col-sm-2">
			<g:if test="${indianResearcher?.samePresentAddress == 'Yes' || !indianResearcher}">

				<input type="text" class="width ctlwidth" placeholder="Mobile No."  mob1="1" 
					name="PresentPhoneCode" readonly value="" id="presentCountryPhoneCode">
			</g:if>
			<g:elseif test="${indianResearcher?.presentPhone?.contains('-')}">
				<input type="text" class="width ctlwidth" placeholder="Mobile No."  mob1="1" 
					name="PresentPhoneCode" readonly
					value="${indianResearcher?.presentPhone?.split('-')[0]}">
			</g:elseif>
		</div>

		<div class="col-sm-4 less-padding">
			<g:if test="${indianResearcher?.samePresentAddress == 'Yes' || !indianResearcher}">
				<input type="text" class="width ctlwidth" id="validatePresntPh" placeholder="Phone No."  mob1="1" 
					name="presentPhone"  id="">
			</g:if>

			<g:elseif test="${indianResearcher?.presentPhone?.contains('-')}">
				<input type="text" class="width ctlwidth" id="validatePresntPh" placeholder="Phone No."  mob1="1" num1="1" 
					name="presentPhone" 
					value="${indianResearcher?.presentPhone?.split('-')[1]}">
			</g:elseif>
			<span id="spnPhoneStatusPresent">	</span>
		</div>

	</div>

</div>

		<div class="col-sm-12 form-group less-padding">

			<label class="control-label col-sm-4" font size="3"><span class="col-sm-1">(c)</span>
				<span class="col-sm-10" data-toggle="tooltip" title="Complete proof of address needs to be scanned in  original  and attached.">Attach address proof with Self attestation<span class="text-danger"><b>*</b></span> </span></label>
				
			<g:if test="${indianResearcher?.addressproofLetter || indianResearcher?.addressproofLetterURL}">
				<div class="col-sm-2 klm-select">
					<g:select id="foucuscontrol" name="addressproofSelect"
						class="width controlclass1" req1="1"
						value="${indianResearcher?.addressproofSelect }"
						from="${addressproofSelect }" noSelection="['':'-Select Proof-']" />
				</div>

				<div class="col-sm-2 klm-number">
					<input type="text" class="width controlclass1" req1="1"
						name="addressproofNo" value="${indianResearcher?.addressproofNo }">
				</div>

				<div class="col-sm-3 klm-fileUpload">

					<input type="file" class="width  " name="addressproofLetter" req1="1"
						value="${indianResearcher?.addressproofLetter}" onchange="validateFile(this)">
					<g:link controller="applicationManagement"
						action="showUndertakingFile" id="${indianResearcher?.id}"
						target="_blank"
						params='[filename: "addressproofLetter",appFormId:"${appForm?.id }",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
						${indianResearcher?.addressproofLetterFileName}
					</g:link>
				</div>
			</g:if>
			<g:else>

				<div class="col-sm-2 klm-select">
					<g:select id="foucuscontrol" name="addressproofSelect" req1="1"
						class="width controlclass1" value="" from="${addressproofSelect}"
						 />
				</div>

				<div class="col-sm-2 klm-number">
					<input type="text" class="width controlclass1" req1="1"
						name="addressproofNo" placeholder="Address Proof No." value="">
				</div>

				<div class="col-sm-3 klm-fileUpload">

					<input type="file" class="width  controlclass1" pdf1="1" mb5="1" req1="1"
						name="addressproofLetter" onchange="validateFile(this)">


				</div>

			</g:else>
		</div>



		<div class="col-sm-12 text-right top_Pad">
			<g:hiddenField name="profileId" value="${indianResearcher?.id}" />
			<g:hiddenField name="formType" value="${formType}" />
			<g:hiddenField name="appFormId" value="${appForm?.id}" />
			<input type="Submit" class="btn btn-primary  btnctrl" onClick="JavaScript:setsession()" value="Save"></input>
			<input type="button" class="btn btn-primary focusbtn"
				value="Add More" />

		</div>
</g:uploadForm>