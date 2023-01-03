
<script type="text/javascript">
$( document ).ready(function() {
	$("#statesdivDef").hide();
	
});

</script>
<%--<g:if test="${statesList}">

	<div class="col-sm-12 form-group less-padding">

		<label class=" col-sm-4"><span class="col-sm-1">(e)</span><span
			class="col-sm-10"> State / Province</span></label>
		<div class="col-sm-8">
			<g:select name="province" from="${statesList?.state}"
				class=" stateddl width ctrolreqddl" value=""
				noSelection="['':'Select State']" />
		</div>
	</div>

</g:if>
<g:else>

	<div class="col-sm-12 form-group less-padding" id="statesTemp">

		<label class="control-label col-sm-4"><span class="col-sm-1">(e)</span><span
			class="col-sm-10"> State / Province</span></label>
		<div class="col-sm-8">
			<input type="text" class="width statetxt" name="state"
				value="${individualProfile?.province}">
		</div>
	</div>
</g:else>

<g:if test="${listOfCountries}">

</g:if>

--%>

<g:if test="${formType=='FormB'}">
<g:if test="${statesList}">
	<div class="col-sm-12 form-group less-padding">

		<label class=" col-sm-4"><span class="col-sm-1">(v)</span><span
			class="col-sm-10"> State / Province</span></label>
		<div class="col-sm-8">
			<g:select name="province" from="${statesList?.state}"
				class=" stateddl width ctrolreqddl" value=""
				noSelection="['':'Select State']" />
		</div>
	</div>

</g:if>
<g:else>
	<div class="col-sm-12 form-group less-padding" id="statesTemp">

		<label class="control-label col-sm-4"><span class="col-sm-1">(v)</span><span
			class="col-sm-10"> State / Province</span></label>
		<div class="col-sm-8">
			<input type="text" class="width statetxt" name="state"
				value="${individualProfile?.province}">
		</div>
	</div>
</g:else>
</g:if>
<g:if test="${formType=='FormC'}">
<g:if test="${statesList}">
<g:if test="${part=='Part3'}">
	<div class="row form-group">

		<label class="col-sm-4"><span class="col-sm-1">(vi)</span><span
			class="col-sm-6"> State / Province</span></label>
		<div class="col-sm-8">
			<g:select name="province" from="${statesList?.state}"
				class=" stateddl width ctrolreqddl" value=""
				noSelection="['':'Select State']" />
		</div>
	</div>
</g:if>
<g:else>
<div class="row form-group">

		<label class="col-sm-4"><span class="col-sm-1">(v)</span><span
			class="col-sm-6"> State / Province</span></label>
		<div class="col-sm-8">
			<g:select name="province" from="${statesList?.state}"
				class=" stateddl width ctrolreqddl" value=""
				noSelection="['':'Select State']" />
		</div>
	</div>
</g:else>
</g:if>
<g:else>
<g:if test="${part=='Part3'}">
	<div  class="row form-group" id="statesTemp">

		<label class="control-label col-sm-4"><span class="col-sm-1">(vi)</span><span
			class="col-sm-6"> State / Province</span></label>
		<div class="col-sm-8">
			<input type="text" class="width statetxt" name="province"
				value="">
		</div>
	</div>
	</g:if>
	<g:else>
	<div  class="row form-group" id="statesTemp">

		<label class="control-label col-sm-4"><span class="col-sm-1">(v)</span><span
			class="col-sm-6"> State / Province</span></label>
		<div class="col-sm-8">
			<input type="text" class="width statetxt" name="province"
				value="">
		</div>
	</div>
	</g:else>
</g:else>
</g:if>
<g:if test="${formType!='FormB'&&formType!='FormC'}">
<g:if test="${statesList}">

	<div class="col-sm-12 form-group less-padding">

		<label class=" col-sm-4"><span class="col-sm-1">(e)</span><span
			class="col-sm-10"> State / Province</span></label>
		<div class="col-sm-8">
			<g:select name="province" from="${statesList?.state}"
				class=" stateddl width ctrolreqddl" value=""
				noSelection="['':'Select State']" />
		</div>
	</div>

</g:if>
<g:else>

	<div class="col-sm-12 form-group less-padding" id="statesTemp">

		<label class="control-label col-sm-4"><span class="col-sm-1">(e)</span><span
			class="col-sm-10"> State / Province</span></label>
		<div class="col-sm-8">
			<input type="text" class="width statetxt" name="state"
				value="${individualProfile?.province}">
		</div>
	</div>
</g:else>
</g:if>

<g:if test="${listOfCountries}">

</g:if>

