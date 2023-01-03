          
									<label for="cc" class="col-sm-1 control-label">Subject:</label>
									<div style="margin-top: 10px;">
									
									<input type="text" class="form-control" name="subject" autocomplete="off" required="required"
											placeholder="subject here" value="${communicationInstance?.subject}">
									</div>
									<br />
					                                <div id="editor" class="form-group">
													<g:textArea id="editor1" name="comment" value="${communicationInstance?.messageBody}"/>
													</div>

	<div class="col-sm-7 form-group">
		<span class="col-sm-3"><b>Upload File/Files </b></span>
		<table>
			<tr>
				<td><div class="input_fields_wrap">
						<input type="button"  class="add_mor" id="chgName" Value="Click here"/>
						<span style="color: red" id="errorMsg"></span>
					</div>

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
									      
								
									    <div class="form-group">
<%--											<g:hiddenField name="communicationDetails" value="${communicationInstance?.id}"/>--%>
											<g:hiddenField name="formId" value="${formDetails?.id}"/>
											<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
										
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