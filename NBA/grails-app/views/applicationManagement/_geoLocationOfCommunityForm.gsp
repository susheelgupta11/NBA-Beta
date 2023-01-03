<g:formRemote name="communityGeoLocation546" class="form-horizontal"
	role="form" autocomplete="off"
	url="[controller:'applicationManagement',action:'saveGeoLocationOfCommunity']"
	update="updateCommunityLocations" onSuccess="ClearAllFields()" 
	onComplete="loadPage()">
<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	
	
	<div class="form-title col-sm-12">
		<g:if test= "${formType == 'Form3' }">
			<label class="register-heading"> (a) Geographical location of
			the community / individual </label>
		</g:if>
		<g:elseif test= "${formType == 'Form2' }">
		<label class="register-heading">(b) Geographical location of
			the community / individual </label>
		</g:elseif>	
		<g:else>
			<label class="register-heading"> (d) Geographical location of
			the community / individual </label>
		</g:else>
	</div>

	<div class="col-sm-12  form-group">

		<label class="control-label col-sm-12 ">(i) Consent obtained
			from the community / individual</label>

	</div>
	<div class="col-sm-12 form-group ">
		<br/>
		<g:if test="${geoLocation?.consentObtained == 'Community' }">
			<span class="col-sm-3"> <g:radio class="isConsentObtained radio col-sm-1 community"
					name="isConsentObtained" onclick="AddValidationGeographical(this)"
					checked="checked" value="Community" /><span class="leftflot">&nbsp;
					${geoLocation?.consentObtained}
			</span></span>
		</g:if>
		<g:else>
			<span class="col-sm-3"> <g:radio class="isConsentObtained radio col-sm-1 community"
					name="isConsentObtained" onclick="AddValidationGeographical(this)" id="communityConsentObtained"
					value="Community" /><span class="leftflot">&nbsp; Community</span></span>
		</g:else>

		<g:if test="${geoLocation?.consentObtained == 'Individual' }">
			<span class="col-sm-2"> <g:radio class="isConsentObtained radio col-sm-1 individual"
					name="isConsentObtained" checked="checked"
					onclick="AddValidationGeographical(this)" value="Individual" /><span
				class="leftflot">&nbsp; ${geoLocation?.consentObtained}</span></span>
		</g:if>
		<g:else>
			<span class="col-sm-2"> <g:radio class="isConsentObtained radio col-sm-1 individual"
					name="isConsentObtained" id="individualConsentObtained" onclick="AddValidationGeographical(this)"
					value="Individual" /><span class="leftflot">&nbsp;
					Individual</span></span>
		</g:else>


		<g:if test="${geoLocation?.consentObtained == 'No' }">
			<span class="col-sm-2"> <g:radio class="isConsentObtained radio col-sm-1"
					name="isConsentObtained" checked="checked" onclick="AddValidationGeographical(this)"
					value="No" /><span class="leftflot"> &nbsp;${geoLocation?.consentObtained}</span>
			</span>
		</g:if>
		<g:elseif test="${appForm?.isNoForTraditional == 'No' }">
			<span class="col-sm-2"> <g:radio class="isConsentObtained radio col-sm-1"
					name="isConsentObtained" checked="checked" onclick="AddValidationGeographical(this)"
					value="No" /><span class="leftflot"> &nbsp;${appForm.isNoForTraditional}</span>
			</span>
		</g:elseif>
		<g:else>
			<span class="col-sm-2"> <g:radio class="isConsentObtained radio col-sm-1 GeoNo"
					name="isConsentObtained" id="noConsentObtained" onclick="AddValidationGeographical(this)"
					value="No" /><span class="leftflot"> &nbsp;No</span>
			</span>
		</g:else>

	</div>

		<div id="geoLocation">

	<g:if test="${!geoLocation}">
		<div class="col-sm-12 form-group ">
			<%--<label class="control-label col-sm-4">(a) Name of the
				community from whom such traditional knowledge is to be accessed</label>
			<div class="col-sm-8">
				<input id="foucuscontrol3" type="text" class="width " name="communityKnowledge"
					value="${geoLocation?.communityKnowledge }" />
			</div>
		--%>
		<label class="control-label col-sm-4 labelForCommunityKnowledge"></label>
			<div class="col-sm-8">
				<input id="foucuscontrol3" type="text" class="width " name="individualKnowledge"
					value="${geoLocation?.communityKnowledge }" />
			</div>
		
		</div>
	</g:if>

	<g:elseif test="${geoLocation?.consentObtained }">
		<g:if test="${geoLocation?.consentObtained == 'Community'  }">
			<div id="Community" class="col-sm-12 form-group ">
			  <g:if test= "${formType == 'Form3' }">
			  	<label class="control-label col-sm-4 labelForCommunityKnowledge">(a) Name of the community from whom such traditional knowledge accessed</label>
			  </g:if>
			  <g:else>
				<label class="control-label col-sm-4 labelForCommunityKnowledge">(a) Name of the community from whom such traditional knowledge was accessed</label>
			  </g:else>	
				<div class="col-sm-8">
					<input id="foucuscontrol3" type="text" class="width " name="communityKnowledge"
						value="${geoLocation?.communityKnowledge }" />
				</div>
			</div>
		</g:if>
		<g:elseif test="${geoLocation?.consentObtained == 'Individual'  }">
			<div id="Individual" class="col-sm-12 form-group ">
				<label class="control-label col-sm-4 labelForCommunityKnowledge">(a) Name of the individual from whom such traditional knowledge was accessed:</label>
				<div class="col-sm-8">
					<input id="foucuscontrol3" type="text" class="width " name="individualKnowledge"
						value="${geoLocation?.communityKnowledge }" />
				</div>
			</div>
		</g:elseif>
	</g:elseif>
	<g:else>
			<label class="control-label col-sm-4 labelForCommunityKnowledge"></label>
			<div class="col-sm-8">
				<input id="foucuscontrol3" type="text" class="width " name="individualKnowledge"
					value="${geoLocation?.communityKnowledge }" />
			</div>
	</g:else>
	<div class="col-sm-12 form-group ">

		<label class="control-label col-sm-4">(b) Village/ Panchayat <span
			class="text-danger"><b>*</b></span></label>
		<div class="col-sm-8">

			<input type="text" class="width controlreq" name="village"
				value="${geoLocation?.village}">
		</div>

	</div>



	<div class="col-sm-12 form-group ">

		<label class="control-label col-sm-4">(c) Town/ Taluk <span
			class="text-danger"><b>*</b></span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlreq" name="town"
				value="${ geoLocation?.town}">
		</div>
	</div>


	<div class="col-sm-12 form-group">

		<label class="control-label col-sm-4">(d) District <span
			class="text-danger"><b>*</b></span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlreql" name="district"
				value="${ geoLocation?.district}">
		</div>

	</div>


	<div class="col-sm-12 form-group">

		<label class="control-label col-sm-4">(e) State / UT <span
			class="text-danger"><b>*</b></span></label>
		<div class="col-sm-8">
			<g:select class="width controlreq" from="${listOfStates}" optionKey="id" optionValue="state" name="state" 
						value= "${geoLocation?.state}" noSelection="['':'Select State']"/>
			
<%--			<input type="text" class="width controlreq" name="state"--%>
<%--				value="${ geoLocation?.state}">--%>
		</div>
		</div>
		
		<g:if test="${formType != 'Form1'  }">
		
	<div class="col-sm-12 form-group text-right">
		<g:hiddenField name="geoLocationId" value="${geoLocation?.id}" />
		<g:hiddenField name="appFormId" value="${appForm?.id}" />

		<input type="submit" class="btn btn-primary btncontrolreq" id="submitCommunity"
				Value="Save" />
		<input type="button" class="btn btn-primary focusbtn3 " value="Add More"></input>
	</div>
			
		</g:if>
		
	</div>
	
<g:if test="${formType == 'Form1' }">	
	<div class="col-sm-12 form-group text-right" >
		<g:hiddenField name="geoLocationId" value="${geoLocation?.id}" />
		<g:hiddenField name="appFormId" value="${appForm?.id}" />
		<g:hiddenField id="isNoForTraditional" name="isNoForTraditional"/>
		<input type="submit" class="btn btn-primary btncontrolreq" id="submitCommunity"
			Value="Save" />
		<input type="button" class="btn btn-primary focusbtn3 " id="addMore" value="Add More"></input>
	</div>
</g:if>		

</g:formRemote>