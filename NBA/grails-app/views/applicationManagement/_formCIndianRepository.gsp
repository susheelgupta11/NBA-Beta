<script type="text/javascript">
	

	function loadPage() {
		location.reload(true);
	}
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
					$('#mobileCode1').val(result.phonecode);
					$('#countryPhoneCode1').val(result.phonecode);
					$('#personMobileCode1').val(result.phonecode);
				},
				error : function() {
					//alert("An error has (Himanshu jain) occured!!!");
				}

			});	
			}
</script>
<g:javascript>
	var tabStatus = "${tabStatus}"		
	 var fetchCodes = "${createLink(controller:'applicationManagement',action:'fetchMobileCode')}"
	 var csrfPreventionSalt = "${csrfPreventionSalt}"
  </g:javascript>
<g:formRemote name="indianRepository" class="form-horizontal"
	role="form" autocomplete="off"
	url="[controller:'applicationManagement',action:'submitContactDetailsOfReposatory']"
	onComplete="loadPage()">

	<input type="hidden" name="csrfPreventionSalt"
		value="${csrfPreventionSalt}" />
	
	
	<%--<g:form controller="applicationManagement" action="saveForm3">--%>




	<div class="form-group col-sm-12 text-left">
		<label class="control-label register-heading ">(6) Name and
			contact details of the Indian repository where the biological
			resources deposited</label>

	</div>

	<input type="hidden" class="form-control" name="repostoryType"
		value="IndianRepository" placeholder="Name of the foreign repository" />


	<div class="row form-group ">
		<label class="control-label col-sm-4"><span class="col-sm-1">(i)</span>
			<span class="col-sm-10">Name of the Indian repository<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			

						<input type="text" class="form-control controlreq width" req1="1" name="repostoryName"
							value="${indianRepo?.repostoryName}"
							placeholder="Name of the Indian repository" />
					
				</div>
	</div>
	<div class="row form-group ">
		<label class="control-label col-sm-4"><span class="col-sm-1">(ii)</span>
			<span class="col-sm-10">Address Line 1 <span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			
						<input type="text" class="form-control controlreq width" req1="1" name="address1"
							value="${indianRepo?.address1}" placeholder="Address Line 1" />
					


		</div>
	</div>
	<div class="row form-group ">
		<label class="control-label col-sm-4"><span class="col-sm-1">(iii)</span>
			<span class="col-sm-10">Address Line 2</span></label>
		<div class="col-sm-8">
			
						<input type="text" class="form-control width" name="address2"
							value="${indianRepo?.address2}" placeholder="Address Line 2" />
					
		</div>
	</div>
	<div class="row form-group ">
		<label class="control-label col-sm-4"><span class="col-sm-1">(iv)</span>
			<span class="col-sm-10">Address Line 3</span></label>
		<div class="col-sm-8">
			
						<input type="text" class="form-control width" name="address3"
							value="${indianRepo?.address3}" placeholder="Address Line 3" />
				
		</div>
	</div>

	<div class="row form-group ">

		<label class="control-label col-sm-4"><span class="col-sm-1">(v)</span>
			<span class="col-sm-6">Country <span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8" id="countrySelect">
		
						<g:select name="countryId" from="${indianCountries}"
							optionKey="id" optionValue="country"
							value="${indianRepo?.country?.id}" class="width country controlreq"
							onchange="${remoteFunction (controller: 'applicationManagement',action: 'fetchStates',
							params: "'countryId='+this.value+'&csrfPreventionSalt=${csrfPreventionSalt}'+'&formType=${formType}'+'&part=Part3'",update: 'updateStates1',onComplete: 'updateCountryCodes(this)')}" />


					

		</div>
	</div>
	<div id="updateStates1">
	
			
				<div class="row form-group " >

					<label class="control-label col-sm-4"><span
						class="col-sm-1">(vi)</span> <span class="col-sm-6">State/Province</span></label>
					<div class="col-sm-8" >
								<g:select name="state" from="${listOfStates?.state}" req1="1"
										class="width controlreq" value="${indianRepo?.state}"
										noSelection="['':'Select State']" />
						
<%--								<input type="text" class="form-control controlreq width"  name="province"--%>
<%--									value="${indianRepo?.state}" placeholder="State" />--%>
							
					</div>
				</div>
			
	
	</div>
	<div class="row form-group ">
		<label class="control-label col-sm-4"><span class="col-sm-1">(vii)</span>
			<span class="col-sm-10">City <span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			
						<input type="text" class="form-control controlreq width" req1="1" name="city"
							value="${indianRepo?.city}" placeholder="City" />
					

		</div>
	</div>
	<div class="row form-group ">
		<label class="control-label col-sm-4"><span class="col-sm-1">(viii)</span>
			<span class="col-sm-10">Zip / Pincode <span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			
						<input type="text" class="form-control width controlreq" req1="1" name="zip"
							value="${indianRepo?.zip}" placeholder="Zip / Pincode" />
				
			

		</div>
	</div>

	<div class="row form-group ">

		<label class="control-label col-sm-4"><span class="col-sm-1">(x)</span>
			<span class="col-sm-6">Phone <span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-2">
			<g:if test="${indianRepo?.phone?.contains('-')}">
						<input type="text" class="width controlreq" placeholder="Phone Code"
							name="PhoneCode" readonly
							value="${indianRepo?.phone?.split('-')[0]}" id="countryPhoneCode1">
					</g:if>
			<g:else>
			<input type="text" class="width controlreq" placeholder="Phone Code"
							name="PhoneCode" readonly
							value="+91" id="countryPhoneCode1">
			</g:else>


		</div>
		<div class="col-sm-4 less-padding">
			<g:if test="${indianRepo?.phone?.contains('-')}">
						<input type="text" class="width controlclass1  controlreq" placeholder="Phone No."
							name="phone" value="${indianRepo?.phone?.split('-')[1]}" req1="1"
							id="">
			</g:if>		
<g:else>
	<input type="text" class="width controlclass1  controlreq" placeholder="Phone No."
							name="phone" value="" req1="1"
							id="">
</g:else>
			

		</div>
	</div>
	<div class="row form-group ">
		<label class="control-label col-sm-4"><span class="col-sm-1">(xi)</span>
			<span class="col-sm-10">Email <span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			
						<input type="text" class="form-control width controlreq" name="email"
							value="${indianRepo?.email}" email1="1" placeholder="Email" />
				
		</div>
	</div>

	
				<g:hiddenField name="profileId" value="${indianRepo?.id}" />
			
	<g:hiddenField name="formType" value="${formType}" />
	<g:hiddenField name="appFormId" value="${appForm}" />

	<div class="col-sm-12 form-group text-right">
		<input type="submit" class="btn btn-primary btncontrol" value="Save" />

	</div>
</g:formRemote>