<g:formRemote name="communityGeoLocation" class="form-horizontal"
	role="form"
	url="[controller:'applicationManagement',action:'saveGeoLocationOfCommunity']"
	update="updateCommunityLocations" onSuccess="ClearAllFields()">
	
	<g:each in = "${listOfCommunityLocations }" var= "geoLocation">
	

	<div class="col-sm-12  form-group">

		<label class="control-label col-sm-12 ">(i) Consent obtained
			from the community / individual</label>

	</div>
	
<%--	radioStartsHere--%>
	
	<div class="col-sm-12 form-group ">
		</br> 
		<g:if test= "${geoLocation?.consentObtained == 'Community' }">
		<span class="col-sm-3"> <g:radio
				class="isConsentObtained radio col-sm-1" name="isConsentObtained" checked= "checked" disabled= "disabled"
				value="Community" /><span class="leftflot">&nbsp; ${geoLocation?.consentObtained}</span></span>
		</g:if>
		<g:else>
		<span class="col-sm-3"> <g:radio
				class="isConsentObtained radio col-sm-1" name="isConsentObtained" disabled= "disabled"
				value="Community" /><span class="leftflot">&nbsp; Community</span></span>
		</g:else>
		
		<g:if test= "${geoLocation?.consentObtained == 'Individual' }">		
		<span class="col-sm-2"> <g:radio
				class="isConsentObtained radio col-sm-1" name="isConsentObtained" checked= "checked" disabled= "disabled"
				value="Individual" /><span class="leftflot">&nbsp;
				${geoLocation?.consentObtained}</span></span>
		</g:if>
		<g:else>
		<span class="col-sm-2"> <g:radio disabled= "disabled"
				class="isConsentObtained radio col-sm-1" name="isConsentObtained"
				value="Individual" /><span class="leftflot">&nbsp;
				Individual</span></span>
		</g:else>	
		
		
		<g:if test= "${geoLocation?.consentObtained == 'No' }">		
		 <span class="col-sm-2"> <g:radio disabled= "disabled"
				class="isConsentObtained radio col-sm-1" name="isConsentObtained" checked= "checked"
				value="No" /><span class="leftflot"> &nbsp;${geoLocation?.consentObtained}</span>
		</span>	</g:if>
		<g:else>	
		 <span class="col-sm-2"> <g:radio disabled= "disabled"
				class="isConsentObtained radio col-sm-1 GeoNo" name="isConsentObtained"
				value="No" /><span class="leftflot"> &nbsp;No</span>
		</span></g:else>

	</div>
	
<%--	radioEndsHere--%>

	<div id="geoLocation">


<%--		point (a) for community and individual starts here --%>
		
		<g:if test= "${!geoLocation}">
		<div id="Community" class="col-sm-12 form-group ">
			<label class="control-label col-sm-4">(a) Name of the
				community from whom such traditional knowledge is to be accessed</label>
			<div class="col-sm-8">
				${geoLocation?.communityKnowledge }
			</div>
		</div>
	</g:if>	

	<g:elseif test= "${geoLocation?.consentObtained == 'Community' }">
		<div id="Community" class="col-sm-12 form-group ">
			<label class="control-label col-sm-4">(a) Name of the
				community from whom such traditional knowledge is to be accessed</label>
			<div class="col-sm-8">
				${geoLocation?.communityKnowledge }
			</div>
		</div>
	</g:elseif>

	
	<g:if test= "${!geoLocation}">	
		<div id="Individual" class="col-sm-12 form-group ">
			<label class="control-label col-sm-4">(a) Name of the
				individual from whom such traditional knowledge is to be accessed:</label>
			<div class="col-sm-8">
				${geoLocation?.communityKnowledge }
			</div>
		</div>
	</g:if>
	
	<g:elseif test= "${geoLocation?.consentObtained == 'Individual' }">	
		<div id="Individual" class="col-sm-12 form-group ">
			<label class="control-label col-sm-4">(a) Name of the
				individual from whom such traditional knowledge is to be accessed:</label>
			<div class="col-sm-8">
				${geoLocation?.communityKnowledge }
			</div>
		</div>
	</g:elseif>
		
		
		<%--		point (a) for community and individual ends here --%>
		

		<div class="col-sm-12 form-group ">
			<label class="control-label col-sm-4">(b) Village/ Panchayat</label>
			<div class="col-sm-8">
				${geoLocation?.village}
			</div>
		</div>



		<div class="col-sm-12 form-group ">
			<label class="control-label col-sm-4">(c) Town/ Taluk</label>
			<div class="col-sm-8">
				${ geoLocation?.town}
			</div>
		</div>


		<div class="col-sm-12 form-group">
			<label class="control-label col-sm-4">(d) District</label>
			<div class="col-sm-8">
				${ geoLocation?.district}
			</div>
		</div>


		<div class="col-sm-12 form-group">
			<label class="control-label col-sm-4">(e) State / UT</label>
			<div class="col-sm-8">
				${ geoLocation?.state}
			</div>
		</div>
	</div>
</g:each>
	

</g:formRemote>