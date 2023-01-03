
<%!import org.nba.common.State %>
<g:formRemote name="geoLocation1234" class="form-horizontal" role="form" autocomplete="off"
	url="[controller:'applicationManagement',action:'saveGeoLocation']"
	update="updateGeoLocation" onSuccess="ClearAllFields()" onComplete="loadPage()">
<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	

    <g:if test="${formType == 'Form2'}">
    <div class="form-title col-sm-12">
		<label class="register-heading"> (4) Geographical location from where the biological resources used in the research

												were collected </label>
	</div>
    </g:if>
    <g:else>
	<div class="form-title col-sm-12">
	  <g:if test= "${formType == 'Form3' }">
		<label class="register-heading"> (4) Geographical location from where the biological resources used in the invention are collected </label>
	  </g:if>
	  <g:else>
	  	<label class="register-heading"> (ii) Geographical location of
			proposed collection </label>
	  </g:else>		
	</div>
	</g:else>
	<div class="col-sm-12">
		<div class="form-group">
			<label class="control-label col-sm-4">(a) Name of biological
				resource <span class="text-danger"><b>*</b></span>
			</label>
			<div class="col-sm-8">
				<g:select id="foucuscontrol1" name="name"
					value="${geoLocation?.bioResource?.id}"
					from="${newList}" optionKey="id"
					optionValue="scientificName" class="width controlclass1" req1="1"
					noSelection="['':'-Select-']" />
			</div>
		</div>
	</div>

	<div class="col-sm-12">
		<div class="form-group">
			<label class="control-label col-sm-4">(b) Source of access </label>
			<div class="col-sm-8">
				<g:select id="sourcesAccess" name="source" from="${accessSources}" onchange="ReadonlyRecord(this)"
					value="${geoLocation?.source}" class="width sourcesAccess controlclass1" req1="1"
					noSelection="['':'-Select-']" />
			</div>
		</div>
	</div>

	<div class="col-sm-12">
		<div class="form-group">
			<label class="control-label col-sm-4">(c) Village/ Panchayat</label>
			<div class="col-sm-8">

				<input type="text" class="width readcontrol controlclass1" name="village"
					value="${geoLocation?.village}">
			</div>
		</div>
	</div>

	<div class="col-sm-12">
		<div class="form-group">
			<label class="control-label col-sm-4">(d) Town/ Taluk</label>
			<div class="col-sm-8">
				<input type="text" class="width controlclass1 readcontrol"
					name="town" value="${geoLocation?.town }" />
			</div>
		</div>
	</div>

	<div class="col-sm-12">
		<div class="form-group">
			<label class="control-label col-sm-4">(e) District</label>
			<div class="col-sm-8">
				<input type="text" class="width controlclass1 readcontrol"
					name="district" value="${geoLocation?.district  }" />
			</div>
		</div>
	</div>

	<div class="col-sm-12">
		<div class="form-group">
			<label class="control-label col-sm-4">(f) State / UT</label>
			<div class="col-sm-8">

				<g:select name="state" from="${listOfStates}" optionKey="id"
					optionValue="state" value="${State.findByState(geoLocation?.state)?.id}"
					class="width controlclass1 readcontrol dsblcontrol"
					noSelection="['':'Select State']" />
			</div>
		</div>
	</div>

	<div class="col-sm-12 cultivate">
		<div class="form-group">
			<label class="control-label col-sm-4">(g) Name</label>
			<div class="col-sm-8">
				<input type="text" class="width controlclass1 cultivate1" name="trader"
					value="${geoLocation?.traderName}" />
			</div>
		</div>
	</div>

	<div class="col-sm-12 cultivate">
		<div class="form-group">
			<label class="control-label col-sm-4">(h) Contact details</label>
			<div class="col-sm-8">
				<input type="text" class="width controlclass1 cultivate1"
					name="traderContactDetails"
					value="${geoLocation?.traderContactDetails }" />
			</div>
		</div>
	</div>

	<div class="form-group col-sm-12 text-right">
		<g:hiddenField name="geoLocationId" value="${geoLocation?.id}" />
		<g:hiddenField name="appFormId" value="${appForm?.id}" />
		<input type="submit" class="btn btn-primary  btnclass1" value="Save"></input>
		<input type="button" class="btn btn-primary focusbtn1"
			value="Add more"></input>
		<%--								<g:if test="${listOfLocations?.size() == 0}">--%>
		<%--									<input type="Submit"--%>
		<%--										class="btn btn-primary pull-right btncontrolclass1"--%>
		<%--										value="Submit"></input>--%>
		<%--								</g:if>--%>
		<%--								<g:else>--%>
		<%--									<input type="Submit"--%>
		<%--										class="btn btn-primary pull-right btncontrolclass1"--%>
		<%--										value="Add More"></input>--%>
		<%--								</g:else>--%>

	</div>

</g:formRemote>