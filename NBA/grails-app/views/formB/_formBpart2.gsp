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
			//csrfPreventionSalt : csrfPreventionSalt
		},
		success : function(result) {
			alert(result.phonecode);
			$('#mobileCode').val(result.phonecode);
			$('#countryPhoneCode').val(result.phonecode);
			$('#personMobileCode').val(result.phonecode);
		},
		error : function() {
			alert("An error occured!!!");
		}

	});	
	}
	</script>
	<g:javascript>
  var fetchCodes = "${createLink(controller:'applicationManagement',action:'fetchMobileCode')}"
  </g:javascript>
<g:form name="formBInstt" controller="formB"  class="form-horizontal"
						role="form" autocomplete="off">
						
						
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(a)</span><span
			class="col-sm-10"> Name of the Institution<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" req1="1" name="name" value="${entity1?.name}"
				 >
		</div>
		</div>
		
		
	<div class="form-group col-sm-12">
		<label class=" col-sm-12 ">(b) Complete address of Institution in India</label>
	</div>
		
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(i)</span><span
			class="col-sm-10"> Address line1<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" req1="1" name="address1"
				value="${entity1?.address1}" >
		</div>
	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(ii)</span><span
			class="col-sm-10">Address line2 </span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="address2"
				value="${entity1?.address2}">
		</div>
	</div>




	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(iii) </span><span
			class="col-sm-10"> Address line3</span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="address3"
				value="${entity1?.address3}">
		</div>
	</div>


	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(iv)</span> <span
			class="col-sm-10"> Country<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlclass1" name="country" req1="1" readonly
				value="India">
		</div>
	</div>
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(v)</span> <span
			class="col-sm-10"> State<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
				<g:select name="state" from="${listOfStates?.state}" id="state" req1="1"
				class="width controlclass1" value="${entity1?.state}"
				noSelection="['':'Select State']" />
		</div>
	</div>


	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(vi)</span> <span
			class="col-sm-10"> City<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="city" req1="1"
				value="${entity1?.city}">
		</div>
	</div>
	
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(vii)</span> <span
			class="col-sm-10"> Pincode<span class="text-danger"><b>*</b></span></span></label>

		<div class="col-sm-8">

			<input type="text" class="width ctlwidth" name="pincode"
				PlaceHolder="Pin Code" req1="1"
				value="${entity1?.pincode}">
		</div>
	</div>

	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(viii) </span><span
			class="col-sm-10"> Phone</span></label>

		<div class="col-sm-8">

				<input type="text" class="width ctlwidth" placeholder="Phone No."  mob1="1" num1="1" 
					name="phone"  value="${entity1?.phone}" id="">
		</div>

	</div>
	
	
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(ix) </span><span
			class="col-sm-10"> Fax</span></label>

		<div class="col-sm-8">

				<input type="text" class="width ctlwidth" placeholder="Fax" mob1="1" num1="1" 
					name="fax"  value="${entity1?.fax}" id="">
		</div>

	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(x)</span> <span
			class="col-sm-10"> Email<span class="text-danger"><b>*</b></span></span>
		</label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="email"
				value="${entity1?.email}" req1="1" email1="1">
		</div>
	</div>
	<div class="col-sm-12 text-right top_Pad">
			<g:hiddenField name="profileId" value="${entity1?.id}" />
			<g:hiddenField name="formType" value="${formType}" />
			<g:hiddenField name="part" value="part2" />
			<g:hiddenField name="appFormId" value="${appForm?.id}" />
			<g:hiddenField name="type" value="institute" />
			<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}" />
			<g:actionSubmit action="saveFormBEntity" class="btn btn-primary  btnctrl" value="Save"></g:actionSubmit>
<%--			<input type="submit" class="btn btn-primary btnctrl" value="Save"/>--%>
			
		</div>
					</g:form>