<script type="text/javascript">
<%--	$(document).ready(function() {--%>
<%--		Entity();--%>
<%--		addCompletegreenClass(tabStatus);--%>
<%--		form1part4();--%>
<%--	});--%>

	function loadPage() {
		location.reload(true);
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
<g:javascript>
	var tabStatus = "${tabStatus}"		
	 var fetchCodes = "${createLink(controller:'applicationManagement',action:'fetchMobileCode')}"
	 var csrfPreventionSalt = "${csrfPreventionSalt}"
  </g:javascript>
<g:formRemote name="foreignReposatory" class="form-horizontal"
	role="form" autocomplete="off"
	url="[controller:'applicationManagement',action:'submitContactDetailsOfReposatory']"
	onComplete="loadPage()">

	<input type="hidden" name="csrfPreventionSalt"
		value="${csrfPreventionSalt}" />
	<g:set var="RepostoryType" value="ForeignReposatory" />
<%String RepostoryType="ForeignReposatory"  %>
	<%--<g:form controller="applicationManagement" action="saveForm3">--%>
	<div class="form-group col-sm-12 text-left">
		<label class="control-label register-heading ">(4) Name and
			Contact details of the foreign repository where the biological
			resource(s) are to be deposited</label>

	</div>


	<input type="hidden" class="form-control" name="repostoryType"
		value="ForeignRepository" placeholder="Name of the foreign repository" />



	<div class="row form-group ">
		<label class="control-label col-sm-4"><span class="col-sm-1">(i)</span>
			<span class="col-sm-10">Name of the foreign repository<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			
				
						<input type="text" class="form-control ctlwidth width" req1="1" name="repostoryName"
							value="${foreignRepo?.repostoryName}"
							placeholder="Name of the foreign repository" />
					
				
			
		</div>
	</div>
	<div class="row form-group ">
		<label class="control-label col-sm-4"><span class="col-sm-1">(ii)</span>
			<span class="col-sm-10">Address Line 1 <span
				class="text-danger"><b>*</b></span>
		</span></label>
		<div class="col-sm-8">
			
						<input type="text" class="form-control ctlwidth width" req1="1" name="address1"
							value="${foreignRepo?.address1}" placeholder="Address Line 1" />
				</div>
	</div>
	<div class="row form-group ">
		<label class="control-label col-sm-4"><span class="col-sm-1">(iii)</span>
			<span class="col-sm-10">Address Line 2</span></label>
		<div class="col-sm-8">
			
						<input type="text" class="form-control width" name="address2"
							value="${foreignRepo?.address2}" placeholder="Address Line 2" />
					


		</div>
	</div>
	<div class="row form-group ">
		<label class="control-label col-sm-4"><span class="col-sm-1">(iv)</span>
			<span class="col-sm-10">Address Line 3</span></label>
		<div class="col-sm-8">
			
						<input type="text" class="form-control width" name="address3"
							value="${foreignRepo?.address3}" placeholder="Address Line 3" />
				


		</div>
	</div>
	<div class="row form-group ">

		<label class="control-label col-sm-4"><span class="col-sm-1">(v)</span>
			<span class="col-sm-6">Country <span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			
						<g:select name="countryId" from="${listOfForeignCountries}"
							optionKey="id" optionValue="country"
							value="${foreignRepo?.country?.id}" class="width country ctlwidth"
							noSelection="['':'-Select-']" req1="1"
							onchange="${remoteFunction (controller: 'applicationManagement',action: 'fetchStates',
							params: "'countryId='+this.value+'&csrfPreventionSalt=${csrfPreventionSalt}'+'&formType=${formType}'+'&part=Part3'",update: 'updateStates',onComplete: 'updateCountryCodes1(this)')}" />


					</div>
	</div>
	<div id="updateStates">
		<div class="row form-group ">
		<label class="control-label col-sm-4"><span class="col-sm-1">(vi)</span>
				<span class="col-sm-6">State/Province </span></label>
			<div class="col-sm-8">
				<input type="text" class="form-control width ctlwidth" name="province" value="${foreignRepo?.state}" placeholder="State" />
			</div>
		</div>
	</div>
	<div class="row form-group ">
		<label class="control-label col-sm-4"><span class="col-sm-1">(vii)</span>
			<span class="col-sm-10">City <span class="text-danger"><b>*</b></span>
		</span></label>
		<div class="col-sm-8">
			
						<input type="text" class="form-control ctlwidth width" name="city" req1="1"
							value="${foreignRepo?.city}" placeholder="City" />
					


		</div>
	</div>
	<div class="row form-group ">
		<label class="control-label col-sm-4"><span class="col-sm-1">(viii)</span>
			<span class="col-sm-10">Zip / Pincode <span
				class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			
						<input type="text" class="form-control ctlwidth width" name="zip" req1="1"
							value="${foreignRepo?.zip}" placeholder="Zip / Pincode" />
			</div>
	</div>

	<div class="row form-group ">

		<label class="control-label col-sm-4"><span class="col-sm-1">(x)</span>
			<span class="col-sm-10">Phone <span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-2">
		<g:if test="${foreignRepo?.phone?.contains('-')}">
					<input type="text" class="width ctlwidth" placeholder="Phone Code"
							name="PhoneCode" readonly
							value="${foreignRepo?.phone?.split('-')[0]}" mob1="1"
							id="countryPhoneCode">
		</g:if>
		<g:else>
		<input type="text" class="width ctlwidth" placeholder="Phone Code"
							name="PhoneCode" readonly
							value="" mob1="1"
							id="countryPhoneCode">
		</g:else>
		</div>
		<div class="col-sm-4 less-padding">
		<g:if test="${foreignRepo?.phone?.contains('-')}">
					<input type="text" class="width controlclass1 ctlwidth"
							placeholder="Phone No." name="phone"
							value="${foreignRepo?.phone?.split('-')[1]}" req1="1" id="">
		</g:if>
		<g:else>
		<input type="text" class="width controlclass1 ctlwidth"
							placeholder="Phone No." name="phone"
							value="" req1="1" id="">
		</g:else>
		</div>
	</div>
	<div class="row form-group ">
		<label class="control-label col-sm-4"><span class="col-sm-1">(xi)</span>
			<span class="col-sm-10">Email <span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
					<input type="text" class="form-control ctlwidth width" name="email"
							value="${foreignRepo?.email}" email1="1" placeholder="Email" />
				


		</div>
	</div>
	
	<g:hiddenField name="profileId" value="${foreignRepo?.id}" />
	<g:hiddenField name="formType" value="${formType}" />
	<g:hiddenField name="appFormId" value="${appForm}" />
	<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}" />
	<div class="col-sm-12 form-group text-right">
		<input type="submit" class="btn btn-primary btnctrl" value="Save" />

	</div>
</g:formRemote>