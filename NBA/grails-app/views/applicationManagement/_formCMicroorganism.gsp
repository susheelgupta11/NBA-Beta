<script type="text/javascript">
	$(document).ready(function() {
ReadonlyRecode_Edit();
	});
	</script>
<g:formRemote name="biologicalResources" class="form-horizontal"
						role="form" autocomplete="off"
						url="[controller:'applicationManagement',action:'submitGeolocationMicroOrganism']"
						update="formCMicroOrganismGeo" onComplete="loadPage()">
						
<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>						


<%--<g:form controller="applicationManagement" action="saveForm3">--%>

<div class="form-group col-sm-12 text-left">
							<label class="control-label register-heading ">(3) Geographical location from where the micro-organism was isolated</label>
		
	</div>
<div class="row form-group ">
		<label class="control-label col-sm-4"><span class="col-sm-1">(i)</span>
			<span class="col-sm-10">Scientific Name<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
	<g:select name="scientistName" id="foucuscontrol1" from="${listOfScientistName?.scientistName}"
				class=" stateddl width controlreq" value="${geoLocationlist1?.bioResource?.scientistName }"
				noSelection="['':'-Select-']" req1="1" />

		</div>
	</div>

		<div class="row form-group">
			<label class="control-label col-sm-4"><span class="col-sm-1">(ii)</span> <span class="col-sm-10">Source of access <span class="text-danger"><b>*</b></span></span></label>
			<div class="col-sm-8">
				<g:select id="sourcesAccess" name="source" from="${accessSources}" onchange="ReadonlyRecordFormC(this)"
					value="${geoLocationlist1?.source}" class="width sourcesAccess controlreq controlclass1" req1="1"
					noSelection="['':'-Select-']" />
			</div>
		</div>
	
	<div class="row form-group ">

		<label class="control-label col-sm-4"><span class="col-sm-1">(iii)</span>
			<span class="col-sm-10">Village/ Panchayat<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<g:if test="${geoLocationlist1?.village}">
			<input type="text" name="village" value="${geoLocationlist1?.village}"class=" readcontrol controlclass1 width" placeholder="Village/ Panchayat"/>
</g:if>
<g:else>
	<input type="text" name="village" value=""class=" width controlreq readcontrol controlclass1" req1="1" placeholder="Village/ Panchayat"/>
</g:else>
		</div>
	</div>
	<div class="row form-group ">
		<label class="control-label col-sm-4"><span class="col-sm-1">(iv)</span>
			<span class="col-sm-10">Town/ Taluk<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<g:if test="${geoLocationlist1?.town }">
			<input type="text" name="town" value="${geoLocationlist1?.town}"class="form-control readcontrol controlclass1 width" placeholder="Town/ Taluk"/>
</g:if>
<g:else>
<input type="text" name="town" value=""class=" width controlreq readcontrol controlclass1"  req1="1" placeholder="Town/ Taluk"/>
</g:else>
		</div>
	</div>
<div class="row form-group ">
		<label class="control-label col-sm-4"><span class="col-sm-1">(v)</span>
			<span class="col-sm-10">District<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
		<g:if test="${geoLocationlist1?.district }">
			<input type="text"  name="district" value="${geoLocationlist1?.district}" class="form-control readcontrol controlclass1 width" placeholder="District"/>
</g:if>
<g:else>
<input type="text"  name="district" value="" class=" width controlreq readcontrol controlclass1"  req1="1" placeholder="District"/>
</g:else>
		</div>
	</div>
	<div class="row form-group ">
		<label class="control-label col-sm-4"><span class="col-sm-1">(vi)</span>
			<span class="col-sm-10">State/UT<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
	<g:select name="state" from="${statesList?.state}"
				class=" stateddl width controlreq ctrolreqddl readcontrol controlclass1 dsblcontrol" req1="1" value="${geoLocationlist1?.state}"
				noSelection="['':'Select State']"   />

		</div>
	</div>
	<!-- start -->
	<div class=" cultivate">
		<div class="form-group row">
			<label class="control-label col-sm-4"><span class="col-sm-1">(g)</span> <span class="col-sm-10">Name</span></label>
			<div class="col-sm-8">
				<input type="text" class="width controlclass1 cultivate1" name="trader" req1="1"
					value="${geoLocationlist1?.traderName}" />
			</div>
		</div>
	</div>

	<div class="cultivate">
		<div class="form-group row">
			<label class="control-label col-sm-4"><span class="col-sm-1">(h)</span><span class="col-sm-10"> Contact details</span></label>
			<div class="col-sm-8">
				<input type="text" class="width controlclass1 cultivate1" req1="1"
					name="traderContactDetails"
					value="${geoLocationlist1?.traderContactDetails }" />
			</div>
		</div>
	</div>
	<!-- end -->
	<g:hiddenField name="profileId" value="${geoLocationlist1?.id}" />
		<g:hiddenField name="formType" value="${formType}" />
		<g:hiddenField name="appFormId" value="${appForm}" />

		<div class="col-sm-12 form-group text-right">
			<input type="submit" class="btn btn-primary btncontrol" value="Save" onclick="$('#table').show()"/>
			<input type="button" class="btn btn-primary focusbtn1" value="Add More"/>
		</div>
					</g:formRemote>