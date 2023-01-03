<div class="list-group">

	<g:if test="${formType == 'Form1'}">
		<div class="formheading">
			<a href="#">Form I</a>
		</div>
		<g:if test="${appForm == null}">
			<g:link controller="applicationManagement"
				action="selectIndividualOrCompany"
				class="list-group-item menu1 addinactive"
				params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 1</g:link>
		</g:if>
		<g:elseif test="${appForm?.individualProfiles?.size() >= 0}">
			<g:link controller="applicationManagement" action="individualProfile"
				class="list-group-item  menu1 addinactive"
				params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 1</g:link>
		</g:elseif>
		<%--<g:elseif test="${appForm?.companyProfiles?.size() >= 0}">
			<g:link controller="applicationManagement" action="companyProfile"
				class="list-group-item  menu1 addinactive"
				params="[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:'${csrfPreventionSalt}']">Part 1</g:link>
		</g:elseif>
		--%><g:link controller="applicationManagement" action="form1Part2"
			class="list-group-item addinactive menu2"
			params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 2</g:link>
		<g:link controller="applicationManagement" action="form1Part3"
			class="list-group-item addinactive menu3"
			params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 3</g:link>
		<g:link controller="applicationManagement" action="form1Part4"
			class="list-group-item addinactive menu4"
			params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 4</g:link>
<g:if test="${appForm?.isTradingPurpose == 'true' }">
<g:link controller="formA" action="form1FormA"
			class="list-group-item addinactive menu6"
			params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Form A</g:link>
</g:if>
		<g:if test="${appForm?.isDeclarationDigitallySigned == 'true' }">
			<g:link controller="applicationManagement" action="form1Part5"
				class="list-group-item addinactive menu5"
				params='[formType:formType,appFormId:appForm?.id,declaration:"declaration",csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 5</g:link>
		</g:if> 
		<g:elseif
			test="${appForm?.isDeclarationDigitallySigned == 'notDigital' }">
			<g:link controller="applicationManagement" action="form1Part5"
				class="list-group-item addinactive menu5"
				params='[formType:formType,appFormId:appForm?.id,declaration:"declaration",csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 5</g:link>
		</g:elseif>
		<g:else>
			<g:link controller="applicationManagement" action="form1Part5"
				class="list-group-item addinactive menu5"
				params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 5</g:link>
		</g:else>
		<%--		<g:link controller="applicationManagement" action="form1preview"--%>
		<%--			class="list-group-item himanshu" params="[formType:formType]">Preview</g:link>--%>
		<%--<g:link controller="applicationManagement" action="form1Payment"
			class="list-group-item addinactive menu6" params="[formType:formType,appFormId:appForm?.id]">Payment</g:link>
	--%>
	</g:if>
	<g:elseif test="${formType == 'Form2'}">
		<div class="formheading">
			<a href="#">Form II</a>
		</div>
		<g:if test="${appForm == null}">
			<g:link controller="applicationManagement"
				action="selectIndividualOrCompany"
				class="list-group-item menu1 addinactive"
				params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 1</g:link>
		</g:if>
		<g:elseif test="${appForm?.individualProfiles?.size() >= 0}">
			<g:link controller="applicationManagement" action="individualProfile"
				class="list-group-item  menu1 addinactive"
				params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 1</g:link>
		</g:elseif>
		<%--<g:elseif test="${appForm?.companyProfiles?.size() >= 0}">
			<g:link controller="applicationManagement" action="companyProfile"
				class="list-group-item  menu1 addinactive"
				params="[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:'${csrfPreventionSalt}']">Part 1</g:link>
		</g:elseif>

		--%><g:link controller="form2" action="part2"
			class="list-group-item addinactive menu2"
			params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 2</g:link>
		<g:link controller="form2" action="part3"
			class="list-group-item addinactive menu3"
			params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 3</g:link>
		<g:link controller="form2" action="part4"
			class="list-group-item addinactive menu4"
			params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 4</g:link>
		<g:link controller="applicationManagement" action="form1Part5"
			class="list-group-item addinactive menu5"
			params='[formType:formType,appFormId:appForm?.id,declaration:"declaration",csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 5</g:link>

	</g:elseif>
	<g:if test="${formType == 'Form3'}">
		<div class="formheading">
			<a href="#">Form III</a>
		</div>
		<g:if test="${appForm == null}">
			<g:link controller="applicationManagement"
				action="selectIndividualOrCompany"
				class="list-group-item menu1 addinactive"
				params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 1</g:link>
		</g:if>
		<g:elseif test="${appForm?.individualProfiles?.size() > 0}">
			<g:link controller="applicationManagement" action="individualProfile"
				class="list-group-item  menu1 addinactive"
				params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 1</g:link>
		</g:elseif>
		<g:elseif test="${appForm?.companyProfiles?.size() > 0}">
			<g:link controller="applicationManagement" action="companyProfile"
				class="list-group-item  menu1 addinactive"
				params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 1</g:link>
		</g:elseif>
		<g:link controller="form3" action="part2"
			class="list-group-item addinactive menu2"
			params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 2</g:link>
		<g:link controller="form3" action="part3"
			class="list-group-item addinactive menu3"
			params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 3</g:link>
		<g:link controller="applicationManagement" action="form1Part5"
			class="list-group-item addinactive menu5"
			params='[formType:formType,appFormId:appForm?.id,declaration:"declaration",csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 4</g:link>
		<%--<g:link controller="form3" action="form3Payment"
			class="list-group-item addinactive menu5"
			params="[formType:formType,appFormId:appForm?.id]">Payment</g:link>
	--%>
	</g:if>
	<g:if test="${formType == 'Form4'}">
		<div class="formheading">
			<a href="#">Form IV</a>
		</div>
		<g:if test="${appForm == null}">
			<g:link controller="applicationManagement"
				action="selectIndividualOrCompany"
				class="list-group-item menu1 addinactive"
				params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 1</g:link>
		</g:if>
		<g:elseif test="${appForm?.individualProfiles?.size() >= 0}">
			<g:link controller="applicationManagement" action="individualProfile"
				class="list-group-item  menu1 addinactive"
				params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 1</g:link>
		</g:elseif>
		<%--<g:elseif test="${appForm?.companyProfiles?.size() >= 0}">
			<g:link controller="applicationManagement" action="companyProfile"
				class="list-group-item  menu1 addinactive"
				params="[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:'${csrfPreventionSalt}'">Part 1</g:link>
		</g:elseif>
		--%><g:link controller="form4" action="part2"
			class="list-group-item addinactive menu2"
			params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 2</g:link>
		<g:link controller="form4" action="part3"
			class="list-group-item addinactive menu3"
			params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 3</g:link>
		<g:link controller="applicationManagement" action="form1Part5"
			class="list-group-item addinactive menu5"
			params='[formType:formType,appFormId:appForm?.id,declaration:"declaration",csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 4</g:link>
		<%--<g:link controller="form4" action="form4Payment"
			class="list-group-item addinactive menu5"
			params="[formType:formType,appFormId:appForm?.id]">Payment</g:link>
		--%><%--<g:link controller="form4" action="part5"
			class="list-group-item himanshu" params="[formType:formType]">Part5</g:link>
	--%>
	</g:if>
	
	
	
	
	<g:if test="${formType == 'FormB'}">
		<div class="formheading">
			<a href="#">Form B</a>
		</div>
		
		
		<g:if test="${appForm == null}">
			<g:link controller="formB"
				action="researcherOrGovermentInst"
				class="list-group-item menu1 addinactive"
				params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 1</g:link>
		</g:if>
		<g:elseif test="${appForm?.indianResearcher?.size() > 0 }">
			<g:link controller="formB"
				action="indianResearcher"
				class="list-group-item menu1 addinactive"
				params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 1</g:link>
		</g:elseif>
		<g:elseif test="${appForm?.indianGovtInst?.size() > 0 }">		
			<g:link controller="formB"
				action="indianGovtInst"
				class="list-group-item menu1 addinactive"
				params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 1</g:link>
		</g:elseif>
		
		<g:link controller="formB" action="formBPart2"
			class="list-group-item addinactive menu2"
			params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 2</g:link>
		<g:link controller="formB" action="formBPart3"
			class="list-group-item addinactive menu3"
			params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 3</g:link>
		<g:link controller="formB" action="formBPart4"
			class="list-group-item addinactive menu5"
			params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 4</g:link>
	
		<g:link controller="formB" action="formBPart5"
			class="list-group-item himanshu menu4" params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 5</g:link>
			
<%--			<g:link controller="applicationManagement" id="preview"--%>
<%--									class="list-group-item himanshu" action="formBpreview"--%>
<%--									params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Preview</g:link>--%>
	</g:if>
	
	
	
	
	
	<g:if test="${formType == 'FormC'}">
		<div class="formheading">
			<a href="#">Form C</a>
		</div>
		<g:link controller="applicationManagement"
				action="depositionOfMicroOrganism"
				class="list-group-item menu1 addinactive"
				params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 1</g:link>
		<g:link controller="applicationManagement" action="formCPart2"
			class="list-group-item addinactive menu2"
			params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 2</g:link>
			<g:link controller="applicationManagement" action="formCPart3"
			class="list-group-item addinactive menu3"
			params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 3</g:link>
		<g:link controller="applicationManagement" action="formCPart4"
			class="list-group-item addinactive menu5"
			params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Part 4</g:link>
		
	</g:if>
</div>