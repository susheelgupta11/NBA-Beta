<script type="text/javascript">
	function updateCountryCodes(e) {
		//var code = $(e).val();
		e.data.split('=')[1]
		var dataElement = e.data ? e.data.split('&')[0] : "No value"
		var countryId = dataElement ? dataElement.split('=')[1] : "No value"
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
<g:form name="formBInstt" controller="formB" class="form-horizontal"
	role="form" autocomplete="off">

	<div class="form-group col-sm-12">
		<label class=" col-sm-12 register-heading">(4) Name and contact
			details of the Institution or organization who shall guide the
			proposed research / receiving the biological resources.</label>
	</div>
	
	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-6"><span class="col-sm-1">(a)</span>
			<span class="col-sm-10">Category<span class="text-danger"><b></b></span></span></label><br/>
		<div class="col-sm-12" style="margin-top: 16px; margin-bottom: 16px;">
			
			<g:if test="${!entity1 }">
			<div class="col-sm-12">
				<input type="radio" name="contactDetailsOfInstOrOrganization" value="whoShallGuideOutsideIndia">&nbsp;<b>Contact details of the Institution or Organization who shall guide the proposed research outside India</b>
			</div>
			<div class="col-sm-12">
				<input type="radio" name="contactDetailsOfInstOrOrganization" value="whoShallRcvTheBioResource">&nbsp;<b>Contact details of the Institution or Organization who shall receive the biological resources outside India</b>
			</div>
			</g:if>
			<g:else>
				<g:if test="${entity1?.contactDetailsOfInstOrOrganization == 'whoShallGuideOutsideIndia' }">
						<div class="col-sm-12">
							<input type="radio" name="contactDetailsOfInstOrOrganization" checked value="whoShallGuideOutsideIndia">&nbsp;<b>Contact details of the Institution or Organization who shall guide the proposed research outside India</b>
						</div>
				</g:if>
				<g:else>
						<div class="col-sm-12">
							<input type="radio" name="contactDetailsOfInstOrOrganization" value="whoShallGuideOutsideIndia">&nbsp;<b>Contact details of the Institution or Organization who shall guide the proposed research outside India</b>
						</div>
				</g:else>
				
				<g:if test="${entity1?.contactDetailsOfInstOrOrganization == 'whoShallRcvTheBioResource' }">
						<div class="col-sm-12">
							<input type="radio" name="contactDetailsOfInstOrOrganization" checked value="whoShallRcvTheBioResource">&nbsp;<b>Contact details of the Institution or Organization who shall receive the biological resources outside India</b>
						</div>
				</g:if>
				<g:else>
						<div class="col-sm-12">
							<input type="radio" name="contactDetailsOfInstOrOrganization" value="whoShallRcvTheBioResource">&nbsp;<b>Contact details of the Institution or Organization who shall receive the biological resources outside India</b>
						</div>
				</g:else>
			
			</g:else>
			
		</div>
	</div>
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(b)</span><span
			class="col-sm-10"> Name of the Institution/Organization outside India<span
				class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" req1="1" name="name"
				value="${entity1?.name}">
		</div>
	</div>
	
	<div class="col-sm-12 form-group ">
		<div class="form-group col-sm-12">
			<label class=" col-sm-12 ">(c) Complete address</label>
		</div>
	</div>
	
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(i)</span><span
			class="col-sm-10"> Address line1<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" req1="1" name="address1"
				value="${entity1?.address1}">
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
		
<%--		<div class="col-sm-8">--%>
<%--			<input type="text" class="width ctlwidth" name="country" req1="1"--%>
<%--				readonly value="India">--%>

<%--		</div>--%>
		
		<div class="col-sm-8">
				<g:select name="countryId" from="${listOfCountries}" optionKey="id"
				optionValue="country" value="${entity1?.country1?.id}"
				class="width ctlwidth" noSelection="['':'-Select-']"
				req1="1" />
		</div>
		
		
		
		
		
	</div>
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(v)</span> <span
			class="col-sm-10"> State/Province<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
<%--			<g:select name="state" from="${listOfStates?.state}" id="state" req1="1"--%>
<%--				class=" width ctlwidth" value="${entity1?.state}"--%>
<%--				noSelection="['':'Select State']" />--%>

				<input type="text" class="width ctlwidth" name="state" req1="1"
					value="${entity1?.state}">


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
			class="col-sm-10"> ZIP<span class="text-danger"><b>*</b></span></span></label>

		<div class="col-sm-8">

			<input type="text" class="width ctlwidth" name="pincode"
				PlaceHolder="Pin Code" req1="1"
				value="${entity1?.pincode}">
		</div>
	</div>

	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(viii) </span><span
			class="col-sm-10"> Phone<span class="text-danger"><b>*</b></span></span></label>

		<div class="col-sm-8">

			<input type="text" class="width ctlwidth" placeholder="Phone No." mob1="1" num1="1" req1="1"
				name="phone" value="${entity1?.phone}" id="">
		</div>

	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(ix)</span>
			<span class="col-sm-10"> Email<span class="text-danger"><b>*</b></span></span>
		</label>
		<div class="col-sm-8">
			<input type="text" class="width ctlwidth" name="email"
				value="${entity1?.email}" req1="1" email1="1">
		</div>
	</div>
	<div class="col-sm-12 text-right top_Pad">
		<g:hiddenField name="profileId" value="${entity1?.id}" />
		<g:hiddenField name="formType" value="${formType}" />
		<g:hiddenField name="appFormId" value="${appForm?.id}" />
		<g:hiddenField name="type" value="institute" />
		<g:hiddenField name="part" value="part3" />
		<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}" />
		<g:actionSubmit action="saveFormBEntity" class="btn btn-primary  btnctrl" value="Save"></g:actionSubmit>
		<%--			<input type="submit" class="btn btn-primary btnctrl" value="Save"/>--%>

	</div>
</g:form>