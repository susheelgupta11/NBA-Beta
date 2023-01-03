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



	
</script>
<g:javascript>
var sameAsAbove = "${indianGovtInst?.samePresentAddress }"
</g:javascript>
<g:uploadForm class="form-horizontal" role="form" autocomplete="off"
	action="submitIndianGovtInst">
 <input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
	<div class="text-center">
		<div class="text-success">
			<b><span>
					${flash.message }
			</span></b>
		</div>
	</div>
	<div class="form-group col-sm-12">
		<label class=" col-sm-12 register-heading">(1) Full Particulars
			of Applicant</label>
	</div>



	
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(a)</span><span
			class="col-sm-10"> Name of the Government Institution<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input id="foucuscontrol" type="text" class="width ctlwidth"
				name="govtInstName" value="${indianGovtInst?.govtInstName}" req1="1">
		</div>
	</div>







	<div class="form-group col-sm-12 ">
		<label class=" col-sm-12 register-heading">(i) Complete
			Address</label>
	</div>
	<div class="form-group col-sm-12 ">
		<label class="control-label col-sm-6 "><span class="col-sm-1"><font
				size="3">(a)</font></span> <span class="col-sm-6"><font size="3">Permanent
					Address</font><span class="text-danger"><b>*</b></span></span></label>
	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(i)</span><span
			class="col-sm-10"> Address line1<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="address1"
				value="${indianGovtInst?.address1}" req1="1">
		</div>
	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(ii)</span><span
			class="col-sm-10">Address line2 </span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="address2"
				value="${indianGovtInst?.address2}">
		</div>
	</div>




	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(iii) </span><span
			class="col-sm-10"> Address line3</span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="address3"
				value="${indianGovtInst?.address3}">
		</div>
	</div>

	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(iv)</span> <span
			class="col-sm-10"> Country<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<g:select name="countryId" from="${listOfCountries}" optionKey="id"
				optionValue="country" value="${indianGovtInst?.country?.id}"
				class="width country ctlwidth" noSelection="['':'-Select-']"
				req1="1"
				onchange="${remoteFunction (controller: 'applicationManagement',action: 'fetchStates',
							params: "'countryId='+this.value+'&csrfPreventionSalt=${csrfPreventionSalt}'+'&formType=${formType}'",update: 'updateStates',onComplete: 'updateCountryCodes(this)')}" />
		</div>
	</div>

	<div id="updateStates"></div>


	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(vi)</span> <span
			class="col-sm-10"> City<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="city" req1="1"
				value="${indianGovtInst?.city}">
		</div>
	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(vii)</span> <span
			class="col-sm-10"> Pincode<span class="text-danger"><b>*</b></span></span></label>

		<div class="col-sm-8">

			<input type="text" class="width ctlwidth" name="pincode2"
				PlaceHolder="Pin Code" req1="1"
				value="${indianGovtInst?.pincode}">

		</div>


	</div>




	<%--<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(viii)</span>
			<span class="col-sm-10"> Mobile<span class="text-danger"><b>*</b></span></span></label>

		<div class="col-sm-2">

			<g:if test="${!indianGovtInst}">
				<input type="text" class="width ctlwidth" placeholder="Mobile No."
					name="mobileCode" readonly value="" id="mobileCode">
			</g:if>
			<g:elseif test="${indianGovtInst?.mobile?.contains('-')}">
				<input type="text" class="width ctlwidth" placeholder="Mobile Code"
					name="mobileCode" readonly
					value="${indianGovtInst?.mobile?.split('-')[0]}">

			</g:elseif>
		</div>

		<div class="col-sm-4 less-padding">
			<g:if test="${!indianGovtInst}">
				<input type="text" class="width ctlwidth" placeholder="Mobile No."
					name="mobile" req1="1" mob1="1" num1="1">
			</g:if>

			<g:elseif test="${indianGovtInst?.mobile?.contains('-')}">
				<input type="text" class="width ctlwidth" placeholder="Mobile No."
					name="mobile" req1="1" mob1="1" num1="1"
					value="${indianGovtInst?.mobile?.split('-')[1]}">
			</g:elseif>

		</div>
	</div>
	
	
	--%>
	
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(viii) </span><span
			class="col-sm-10"> Phone<span class="text-danger"><b>*</b></span></span></label>

		<div class="col-sm-2">
			<g:if test="${!indianGovtInst}">

				<input type="text" class="width ctlwidth" placeholder="Mobile No."
					name="PhoneCode" readonly value="" id="countryPhoneCode">
			</g:if>
			<g:elseif test="${indianGovtInst?.phone?.contains('-')}">
				<input type="text" class="width ctlwidth" placeholder="Mobile No."
					name="PhoneCode" readonly
					value="${indianGovtInst?.phone?.split('-')[0]}">
			</g:elseif>
		</div>

		<div class="col-sm-4 less-padding">
			<g:if test="${!indianGovtInst}">
				<input type="text" class="width ctlwidth" placeholder="Phone No."
					name="phone" req1="1" id="">
			</g:if>

			<g:elseif test="${indianGovtInst?.phone?.contains('-')}">
				<input type="text" class="width ctlwidth" placeholder="Phone No."
					name="phone" req1="1"
					value="${indianGovtInst?.phone?.split('-')[1]}">
			</g:elseif>
		</div>

	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(ix)</span> <span
			class="col-sm-10"> Email<span class="text-danger"><b>*</b></span></span>
		</label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="email"
				value="${indianGovtInst?.email}" req1="1" email1="1">
		</div>
	</div>


	<div class="form-group col-sm-12 ">
		<label class="control-label col-sm-6 "><span class="col-sm-1"><font
				size="3">(b)</font></span> <span class="col-sm-6"><font size="3">Present
					Address</font><span class="text-danger"><b>*</b></span></span></label>
	</div>
	<div class="col-sm-12 form-group less-padding">
		<label class="control-label col-sm-4  "><span class="col-sm-1"></span>
			<span class="col-sm-10"><i>Same as above</i><span
				class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-2 ">
		
		<g:if test="${!indianGovtInst }">
			<input type="radio" name="samePresentAddress" value="Yes"
				onclick="presentAddressSame()" /><b class="">Yes</b>
				
			<input type="radio" name="samePresentAddress" value="No"
				onclick="diffPresentAddress()" /><b class="">No</b>
		</g:if>
		<g:else>
			
			<g:if test="${indianGovtInst?.samePresentAddress == 'Yes' }">
				<input type="radio" name="samePresentAddress" value="Yes" checked
					onclick="presentAddressSame()" /><b class="">Yes</b>
			</g:if>
			<g:else>
				<input type="radio" name="samePresentAddress" value="Yes"
					onclick="presentAddressSame()" /><b class="">Yes</b>
			</g:else>
			
			<g:if test="${indianGovtInst?.samePresentAddress == 'No' }">	
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
					value="${indianGovtInst?.presentAddress1}" class="width ctlwidth" req1="1" 
					placeholder="" />

			</div>
		</div>

		<div class="col-sm-12 form-group less-padding">

			<label class="control-label col-sm-4"><span class="col-sm-1">(ii)</span>
				<span class="col-sm-10">Address line2</span></label>
			<div class="col-sm-8">
				<input type="text" name="presentAddress2"
					value="${indianGovtInst?.presentAddress2}" class="width ctlwidth" 
					placeholder="" />

			</div>
		</div>

		<div class="col-sm-12 form-group less-padding">

			<label class="control-label col-sm-4"><span class="col-sm-1">(iii)</span>
				<span class="col-sm-10">Address line3</span></label>
			<div class="col-sm-8">
				<input type="text" name="presentAddress3"
					value="${indianGovtInst?.presentAddress3}" class="width ctlwidth"
					placeholder="" />

			</div>
		</div>

		<div class="form-group col-sm-12 less-padding">
			<label class="control-label col-sm-4"><span class="col-sm-1">(iv)</span>
				<span class="col-sm-10"> Country<span class="text-danger"><b>*</b></span></span></label>
			<div class="col-sm-8">
				<g:select name="presentCountry" from="${listOfCountries}"
					optionKey="id" optionValue="country"
					value="${indianGovtInst?.presentCountry?.id}" req1="1"
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
					value="${indianGovtInst?.presentCity}" class="width ctlwidth"
					placeholder="" />

			</div>
		</div>
		<div class="col-sm-12 form-group less-padding">

			<label class="control-label col-sm-4"><span class="col-sm-1">(vii)</span>
				<span class="col-sm-10">Pincode<span class="text-danger"><b>*</b></span></span></label>
			<div class="col-sm-8">
				<input type="text" class="width ctlwidth" name="presentPincode" value="${indianGovtInst?.presentPincode}" req1="1"
					placeholder="Pincode" />

			</div>
		</div>
	<%--<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(viii)</span>
			<span class="col-sm-10"> Mobile<span class="text-danger"><b>*</b></span></span></label>

		<div class="col-sm-2">

			<g:if test="${!indianGovtInst}">
				<input type="text" class="width ctlwidth" placeholder="Mobile No."
					name="PresentMobileCode" readonly value="" id="presentMobileCode">
			</g:if>
			<g:elseif test="${indianGovtInst?.presentMobile?.contains('-')}">
				<input type="text" class="width ctlwidth" placeholder="Mobile Code"
					name="PresentMobileCode" readonly
					value="${indianGovtInst?.presentMobile?.split('-')[0]}">

			</g:elseif>
		</div>

		<div class="col-sm-4 less-padding">
			<g:if test="${!indianGovtInst}">
				<input type="text" class="width ctlwidth" placeholder="Mobile No."
					name="presentMobile"  mob1="1" num1="1">
			</g:if>

			<g:elseif test="${indianGovtInst?.presentMobile?.contains('-')}">
				<input type="text" class="width ctlwidth" placeholder="Mobile No."	name="presentMobile"  mob1="1" num1="1"	value="${indianGovtInst?.presentMobile?.split('-')[1]}">
			</g:elseif>

		</div>
	</div>
	--%>
	
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(viii) </span><span
			class="col-sm-10"> Phone<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-2">
			<g:if test="${indianGovtInst?.samePresentAddress == 'Yes' || !indianGovtInst}">

				<input type="text" class="width ctlwidth" placeholder="Code" req1="1"
					name="PresentPhoneCode" readonly value="" id="presentCountryPhoneCode">
			</g:if>
			<g:elseif test="${indianGovtInst?.presentPhone?.contains('-')}">
				<input type="text" class="width ctlwidth" placeholder="Code" req1="1"
					name="PresentPhoneCode" readonly
					value="${indianGovtInst?.presentPhone?.split('-')[0]}">
			</g:elseif>
		</div>

		<div class="col-sm-4 less-padding"> 
			<g:if test="${indianGovtInst?.samePresentAddress == 'Yes' || !indianGovtInst}">
				<input type="text" class="width ctlwidth" placeholder="Phone No." req1="1"
					name="presentPhone"  id="">
			</g:if>

			<g:elseif test="${indianGovtInst?.presentPhone?.contains('-')}">
				<input type="text" class="width ctlwidth" placeholder="Phone No."
					name="presentPhone" req1="1"
					value="${indianGovtInst?.presentPhone?.split('-')[1]}">
			</g:elseif>
		</div>

	</div>

</div>

		
		
		<div class="col-sm-12 text-right top_Pad">
			<g:hiddenField name="profileId" value="${indianGovtInst?.id}" />
			<g:hiddenField name="formType" value="${formType}" />
			<g:hiddenField name="appFormId" value="${appForm?.id}" />
			<input type="Submit" class="btn btn-primary  btnctrl" onClick="JavaScript:setsession()" value="Save"></input>
			<input type="button" class="btn btn-primary focusbtn"
				value="Add More" />

		</div>
</g:uploadForm>














