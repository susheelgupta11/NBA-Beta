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

<g:uploadForm name="supervisorForm" class="form-horizontal"
	role="form" autocomplete="off" action="saveFundingAgency"
	controller="formB" autocomplete='off'>

	<div class="form-group col-sm-12">
		<label class=" col-sm-12 register-heading">(6) Name of the funding agency supporting the proposed research</label>
	</div>
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(a)</span><span
			class="col-sm-10"> Name of the Institution/Organization<span class="text-danger"><b>*</b></span>
		</span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlreqired foucuscontrolfunding"
				value="${fundingAgencyObj?.institutionOrganizationName}" name="name"
				id="institutionOrganizationName" req1="1">
		</div>
	</div>


	<div class="col-sm-12 form-group ">
		<div class="form-group col-sm-12">
			<label class=" col-sm-12 ">(b) Complete address</label>
		</div>
	</div>
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(i)</span><span
			class="col-sm-10">Address line1<span class="text-danger"><b>*</b></span> </span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlreqired" req1="1" name="address1" value="${fundingAgencyObj?.address1}">
		</div>
	</div>

	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(ii)</span><span
			class="col-sm-10">Address line2 </span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlreqired" name="address2" value="${fundingAgencyObj?.address2}">
		</div>
	</div>




	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(iii) </span><span
			class="col-sm-10"> Address line3</span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlreqired" name="address3" value="${fundingAgencyObj?.address3}">
		</div>
	</div>

	<div class="form-group col-sm-12 less-padding">
	<label class=" col-sm-4"><span class="col-sm-1">(iv)</span> <span
			class="col-sm-10"> Country<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
<%--				<g:select name="countryId" from="${listOfCountries}" optionKey="id"--%>
<%--				optionValue="country" value="${entity3?.country1?.id}"--%>
<%--				class="width country controlreqired" noSelection="['':'-Select-']"--%>
<%--				req1="1"--%>
<%--				onchange="${remoteFunction (controller: 'applicationManagement',action: 'fetchStates',--%>
<%--							params: "'countryId='+this.value+'&csrfPreventionSalt=${csrfPreventionSalt}'+'&formType=${formType}'",--%>
<%--							update: 'updateStates',onComplete: 'updateCountryCodes(this)')}" />--%>
							
							
				<g:select name="countryId" from="${listOfCountries}" optionKey="id"
				optionValue="country" value="${fundingAgencyObj?.country?.id}"
				class="width country controlreqired" noSelection="['':'-Select-']"
				req1="1" />			
							
							
							
		</div>
		
	</div>
	<div id="updateStates">
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(v)</span> <span
			class="col-sm-10"> State <span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlreqired" name="state" req1="1"
				value="${fundingAgencyObj?.state}">
				
		</div>
	</div>
</div>
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(iv)</span> <span
			class="col-sm-10"> City<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlreqired" name="city" req1="1"
				value="${fundingAgencyObj?.city}">
		</div>
	</div>

	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(v)</span> <span
			class="col-sm-10"> Phone</span></label>
		<div class="col-sm-8">
			<input type="text"  class="width controlreqired" name="phone" mob1="1" num1="1" value="${fundingAgencyObj?.phone}">
		</div>
	</div>
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(vi)</span> <span
			class="col-sm-10"> Email<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlreqired" name="email" email1="1" req1="1" value="${fundingAgencyObj?.email}">
		</div>
	</div>
	
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(c)</span><span
			class="col-sm-10"> Copy of Sanction order/MoU/ any document given by the funding agency<span class="text-danger"><b>*</b></span>
		</span></label>
		<div class="col-sm-8">
			<input type="file" class="width controlreqired" pdf1="1" mb5="1" req1="1" name="sanctionOrderMoUcopy" >
			
			<g:link controller="applicationManagement"
						action="showUndertakingFile" id="${fundingAgencyObj?.id}"
						target="_blank"
						params='[filename: "sanctionOrderMoUcopy",appFormId:"${appForm?.id }",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
						${fundingAgencyObj?.sanctionOrderMoUcopyFileName}
			</g:link>	
						
		</div>
	</div>
	
	
	<div class="col-sm-12 form-group text-right">
		 <g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}" />
		 <g:hiddenField name="type" value="funding" />
		 <g:hiddenField name="part" value="part3" />
		 <g:hiddenField name="formType" value="${formType}" />
			<g:hiddenField name="appFormId" value="${appForm?.id}" />
			<g:hiddenField name="agencyId" value="${fundingAgencyObj?.id}" />
		 <input type="submit" class="btn btn-primary btnctrlone" value="Save"/>
		 <input type="button" class="btn btn-primary focusbtnfunding " value="Add More">
	</div>
</g:uploadForm>