<g:if test="${formDetails?.individualProfiles}">
	<g:each in="${formDetails?.individualProfiles}" var="individualProfile">
		<g:set var="name"
			value="${individualProfile?.title?: ''} ${individualProfile?.firstName?:'' } ${individualProfile?.middleName?:'' } ${individualProfile?.lastName?:'' }"></g:set>
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
			value="${researcher?.title ?:''} ${researcher?.firstName?: ''} ${researcher?.middleName?:''} ${researcher?.lastName?:''}"></g:set>
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


<div class="pull-right" style="">
	<span><b>Choose Template</b></span>
	<g:select name="lette" from="${letterTemplate}" 
		onchange="lettertemplete(this.value);" noSelection="['':' select']" />

</div>

<div class="pull-right" style="">
	<span><b>Choose CC</b></span>
	<g:select name="ccEmail" from="${ccEmailList}" optionKey="email" optionValue="${{it.name  +' '+ "<" +it.email +">"}}"
		noSelection="['':' select One email Id for cc']" onchange="getCcEmailId(this.value);" />
</div>

<script>
	function getCcEmailId(email) {
		document.getElementById('cc').value = email;
	}



									</script>
					
						
							<div class="col-sm-12">
									<label for="to" class="col-sm-1 control-label">To*:</label>
									<div class="">
										<input type="email" class="form-control" name="emailId" id="to"
											placeholder="Forward to" value="${toEmail}" >
									</div>

									<label for="cc" class="col-sm-1 control-label">CC*:</label>
									<div class="">
									<input type="email" class="form-control" name="ccEmailId" id="cc"
											placeholder="cc" value="${communicationInstance?.ccEmailId}" required onkeypress="return false;">
									
									
									</div>
									
									
									<label for="cc" class="col-sm-1 control-label">Subject:</label>
									<div style="margin-top: 10px;">
									
									<input type="text" class="form-control" name="subject" id="subjectId" required="required"
											placeholder="subject here" autocomplete="off" value="${communicationInstance?.subject}">
									</div>
<%--								</div>--%>
<%--								<div class="col-sm-12 ">--%>
								
									<br />
					                                <div id="editor" class="form-group">
													<g:textArea name="comments" id="editor2" name="body" value="${communicationInstance?.messageBody}"/>
													</div>
<%--									<div class="form-group">--%>
<%--										<textarea class="form-control" id="message" name="body"--%>
<%--											rows="20" placeholder="Click here for draft input"></textarea>--%>
<%--									</div>--%>
 
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
	

	<g:if test="${communicationInstance?.pdfFileAttachments}">
										    <table>
											<g:each in="${communicationInstance?.pdfFileAttachments}" var="attachmentPdf">
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
											  <g:hiddenField name="communicationDetails" value="${communicationInstance?.id}"/>
											<g:hiddenField name="formId" value="${formDetails?.id}"/>
											<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
											<g:hiddenField name="name" value="${name}"/>
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