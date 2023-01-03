

<g:if test="${formDetails?.individualProfiles}">
	<g:each in="${formDetails?.individualProfiles}" var="individualProfile">
		<g:set var="name"
			value="${individualProfile?.title?: ''} ${individualProfile?.firstName?:'' } ${individualProfile?.middleName?:'' } ${individualProfile?.lastName?:'' }"></g:set>

		<g:set var="address"
			value="${individualProfile?.address1?: ''} ${individualProfile?.address2?:'' } ${individualProfile?.address3?:'' } ${individualProfile?.mobile?:'' }"></g:set>


	</g:each>
</g:if>
<g:elseif test="${formDetails?.companyProfiles}">
	<g:each status="k" in="${formDetails?.companyProfiles}" var="company">
		<g:set value="${company?.entityName}" var="name"></g:set>
	</g:each>
</g:elseif>
<g:elseif test="${formDetails?.indianResearcher}">
	<g:each in="${formDetails?.indianResearcher}" var="researcher">
		<g:set var="name"
			value="${researcher?.title ?:''}${researcher?.firstName?: ''}${researcher?.middleName?:''}${researcher?.lastName?:''}"></g:set>
	</g:each>
</g:elseif>
<g:elseif test="${formDetails?.depostionOfMicroOrganism}">
	<g:each in="${formDetails?.depostionOfMicroOrganism}" var="depost">
		<g:set value="${depost?.nameOfDepositor}" var="name"></g:set>
	</g:each>
</g:elseif>
<g:elseif test="${formDetails?.indianGovtInst}">
	<g:each in="${formDetails?.indianGovtInst}" var="govt">
		<g:set value="${govt?.govtInstName}" var="name"></g:set>
	</g:each>
</g:elseif>
<g:set value="${new Date()}" var="date"></g:set>


<div class="pull-right" >
	<span><b>SBB</b></span>
	<g:select name="email" from="${sbbEmailIds}"
		onchange="getEmailId(this.value);" optionKey="email" optionValue="${{it.name  +' '+ "<" +it.email +">"}}" noSelection="['':' select One']" />

</div>
<div class="pull-right">
	<span><b>CC Email</b></span>
	<g:select name="ccEm" from="${ccUser}"
		onchange="getEmailIdCC(this.value);"  optionKey="email" optionValue="${{it.name  +' '+ "<" +it.email +">"}}"  noSelection="['':' select One']" style="width:302px"/>

</div>

<div class="pull-left" >
	<span><b>Letter</b></span>
	<g:select name="lette" from="${letterTemplate}"
		onchange="lettertemplete(this.value);" noSelection="['':' select']" />

</div>




<div id="edit"></div>

<script>

	function getEmailIdCC(email) {
		document.getElementById('cici').value = email;
	}


	function getEmailId(name) {

//		$.ajax({
//			type : 'Post',
//			dataType : 'JSON',
//			url : '/NBA/letterCommunication/getSbbEmailId',
//			data : {name : name},
//			success : function(result) {
//				document.getElementById('to').value = result.email;
//			}
//		});
		
		document.getElementById('to').value = name;	
	}	
</script>


<div class="col-sm-12">
	<label for="to" class="col-sm-1 control-label">To*:</label>
	<div class="">
		<input type="email" class="form-control" name="emailId" id="to"
			placeholder="Forward to" value="${sbbConsentInstance?.emailId}"
			required="required">
	</div>
	<label for="to" class="col-sm-1 control-label">CC*:</label>
	<div class="">
		<input type="email" class="form-control" name="ccEmailId" id="cici"
			placeholder="CC" value="${sbbConsentInstance?.ccEmailId}"
			required="required">
	</div>
	<label for="to" class="col-sm-1 control-label">Subject:</label>
	<div>
		<input type="text" class="form-control" name="subject" id="subjectId"
			required="required" placeholder="subject here" autocomplete="off"
			value="${sbbConsentInstance?.subject}">
	</div>
	<%--								</div>--%>
	<%--								<div class="col-sm-12 ">--%>

	<br />
	<div id="editor" class="form-group">
		<g:textArea name="comments" id="editor2" name="body"
			value="${sbbConsentInstance?.messageBody}" />
	</div>
	   <%--Upload attachment in the communication--%>
	<div class="col-sm-7 form-group">
		<span class="col-sm-3"><b>Upload File/Files </b></span>
		<table>
			<tr>
				<td><div class="input_fields_wrap">
						<input type="button"  class="add_mor" id="chgName" Value="Click here"/>
						<span style="color: red" id="errorMsg"></span>
					</div>
<%--					<div>--%>
<%--						<input type="file" name="files[]" id="subfile"--%>
<%--							class="input-xlarge" onchange="ValidateSingleInput(this);" />--%>
<%--					</div>--%>
					</td>
			</tr>
		</table>
	

	<g:if test="${sbbConsentInstance?.pdfFileAttachments}">
										    <table>
											<g:each in="${sbbConsentInstance?.pdfFileAttachments}" var="attachmentPdf">
											<tr><td>
<%--											<g:link controller="dashboard" action="communicationShowPdf" target="_blank" --%>
<%--											params="${[showId:attachmentPdf?.id,csrfPreventionSalt:csrfPreventionSalt] }" >${attachmentPdf?.pdfName}</g:link>--%>
											
										<g:link action="communicationFileShow" target="_blank" 
											params="${[showId:attachmentPdf?.id,csrfPreventionSalt:csrfPreventionSalt] }" >${attachmentPdf?.pdfName}</g:link>	
											
											</td>
										<td><g:link action="deleteCommunicationPdf" params="${[deleteId:attachmentPdf?.id,formId:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt] }" onclick="return confirm('Are you sure?');"><i class="fa fa-trash"></i></g:link></td>
											</tr>
											</g:each>
											</table>
											</g:if>
											</div>
									      </div>
	

		<div class="form-group">
			<g:hiddenField name="name" value="${name}" />
			<g:hiddenField name="formId" value="${formDetails?.id}" />

			<g:hiddenField name="sbbConsentInstance"
				value="${sbbConsentInstance?.id}" />
			<g:hiddenField name="csrfPreventionSalt"
				value="${csrfPreventionSalt}" />
		</div>

<style>
.add_mor{
    background: #367fa9;
    color: #fff;
    padding: 4px 12px;
    display: inline-block;
    border-radius: 4px;
    border: none;
    text-align: center;
    text-decoration: none;
    font-size: 12px;
    margin: 4px 2px;
    cursor: pointer;
    }
</style>		