<script type="text/javascript">
<%--	$(document).ready(function() {--%>
<%--		Entity();--%>
<%--		--%>
<%--	});--%>
</script>
<g:formRemote name="biologicalResources" class="form-horizontal"
						role="form" autocomplete="off"
						url="[controller:'applicationManagement',action:'submitDepositionPerpose']"
						onComplete="loadPage()">
						
<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>						


<%--<g:form controller="applicationManagement" action="saveForm3">--%>
	

	
	<div class="row form-group ">

		
			<label class="control-label register-heading col-sm-4 "><span class="col-sm-1">(5)</span><span class="col-sm-10">Purpose of deposition</span></label>
		<div class="col-sm-8">
			
		<textarea rows="10" class="form-control width ctlwidth1   txtlastvalid txtremovevalidate" txtreq1="1"  name="depositionPerpose" placeholder="Purpose of deposition">${applicationform?.depositionPerpose}</textarea>

		</div>
	</div>

	
	<g:hiddenField name="profileId" value="${microOrgaScirntistName?.id}" />
		<g:hiddenField name="formType" value="${formType}" />
		<g:hiddenField name="appFormId" value="${appForm}" />
		<div class="col-sm-12 form-group text-right">
			<input type="submit" class="btn btn-primary btnctrl1" value="Save"/>
		
		</div>
					</g:formRemote>