<script type="text/javascript">
<%--	$(document).ready(function() {--%>
<%--		Entity();--%>
<%--		--%>
<%--	});--%>
	</script>
<g:formRemote name="biologicalResources" class="form-horizontal"
	role="form" autocomplete="off"
	url="[controller:'applicationManagement',action:'submitScientistName']"
	update="divAuthorizedPersonGrid" onSuccess="ClearAllFields()" onComplete="loadPage()">
<%--	update="divAuthorizedPersonGrid" onSuccess="ClearAllFields()" onComplete="loadPage()">--%>
	

	<input type="hidden" name="csrfPreventionSalt"
		value="${csrfPreventionSalt}" />


	<%--<g:form controller="applicationManagement" action="saveForm3">--%>
	<div class="form-group col-sm-12 text-left">
							<label class="control-label register-heading ">(2) Name of the micro-organism(s) to the
				deposited in the foreign repository
				</label>

	</div>
	<div class="row form-group ">

		<label class="control-label col-sm-4"><span class="col-sm-1"></span>
			<span class="col-sm-10">Scientific Name<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">

			<input type="text" class="form-control width ctlwidth" req1="1"
				name="scientistName" id="foucuscontrol"
				value="${microOrgaScirntistName?.scientistName}"
				placeholder="Scientific Name" />

		</div>
	</div>
	<g:hiddenField name="profileId" value="${microOrgaScirntistName?.id}" />
	<g:hiddenField name="formType" value="${formType}" />
	<g:hiddenField name="appFormId" value="${appForm}" />
	<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}" />
	<div class="col-sm-12 form-group text-right">
		<input type="submit" class="btn btn-primary btnctrl" value="Save" /> <input
			type="button" class="btn btn-primary focusbtn" value="Add More" />
	</div>
</g:formRemote>