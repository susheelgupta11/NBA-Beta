
<!DOCTYPE html>
<html lang="en">
<head>
<meta name='layout' content='loggedInUser' />

<script>
	$(document).ready(function() {
        $('[data-toggle="tooltip"]').tooltip();
        Entity();
		AddActiveClass("menu4");
		addCompletegreenClass(tabStatus);
	});
</script>

</head>
<body>
	<g:javascript>  
  var tabStatus = "${tabStatus}"
  </g:javascript>
	<%--	modelContent--%>
	<div id="myModal" class="modal fade" role="dialog"
		style="z-index: 9999999;">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Confirm message</h4>
				</div>
				<div class="modal-body">
					<p>Are you sure you want to Submit Application ?</p>
				</div>
				<div class="modal-footer">
					<g:link controller="applicationManagement" post="true"
						action="completePayment"
						params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'
						class="btn btn-success">Ok</g:link>
					<button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
				</div>
			</div>

		</div>
	</div>

	<%--	modelContentEnds--%>
	<div class="container form-group">

		<div id="leftTopTab" class="col-sm-2">
			<g:render template="/applicationManagement/leftTabs"
				model="[appForm:appForm,formType:formType]" />
		</div>


		<div class="col-sm-10">

			<div class="col-sm-12">
				<div class="checkout-wrap">
					<ul class="checkout-bar">

						<li class="previous visited first"><a href="#">Part 1</a></li>

						<li class="previous visited">Part 2</li>

						<li class="previous visited">Part 3</li>

						<li class="active">Part 4</li>
						<li class="next">Part 5</li>
						<li>Preview</li>
						<li>Payment</li>

					</ul>
				</div>
			</div>


			<div class="clearfix"></div>
			<div class="main-registeration col-sm-12 "
				style="border: 1px solid #9E9E9E; border-radius: 5px">
				<!--login form -->

<g:uploadForm controller="formB" autocomplete="off" action="submitDeclarationFormB">

				<div class="text-center">
					<h3>
						<span><b>Declaration / Undertaking</b></span>
					</h3>
					<p><a href="#" data-toggle="tooltip" title="(Download each Declaration/Undertaking and upload them duly filled in with Signature & Seal)">(Download each Declaration/Undertaking and upload them duly filled in with Signature & Seal) </a></p>

				</div>
				
			<div style="overflow-x:auto;">	
				<table class="table-bordered" style="width: 100%">
					
						<g:each in="${listOfNotifications}" var="notification">
					
						<g:if test="${notification?.docName == 'Undertaking by the Applicant Form B'}">
						
							<tr>

									<td align="left" style="width: 50%;"><b>Undertaking
												by the applicant</b>:
									</td>


									<td style="width: 20%;">
										<span class="col-sm-12 form-group"><span
											class="col-sm-11 notificationwidth"><g:link
											controller="loggedInAs" action="showDc"
											id="${notification?.id}"
											params='[filename: "notification1", dataName: "notification1",csrfPreventionSalt:"${csrfPreventionSalt}"]'
											target="_blank">
											<b> Download</b>
										</g:link></span></span>
									</td>


									<td class="left-padding"><input type="file"
											name="undertakingCopy" class="width controlclass1 controlreq"
											req1="1" value="${appForm?.undertakingCopy}" /> <g:link
												controller="applicationManagement"
												action="showUndertakingFile" id="${appForm?.id}"
												target="_blank"
												params='[filename: "undertakingCopy", dataName: "undertakingCopy",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
												${appForm?.undertakingCopyFileName}
											</g:link>
											<g:if test="${flash.message }">
												<span class="text-danger">${flash.message }</span>
											</g:if>
									</td>


							</tr>	
						</g:if>
						
						
						<g:if test="${notification?.docName == 'Declaration by the applicant on Nationality Form B'}">
						
							<tr>
							
								<td>
									<b>Declaration by the Applicant on Nationality</b>:
								</td>
							
							
								<td>
									<span class="col-sm-12 form-group"><span
											class="col-sm-11 notificationwidth"><g:link
											controller="loggedInAs" action="showDc"
											id="${notification?.id}"
											params='[filename: "notification1", dataName: "notification1",csrfPreventionSalt:"${csrfPreventionSalt}"]'
											target="_blank">
											<b> Download</b>
										</g:link></span></span>
								</td>	
								
								<td>
										<input type="file"
											name="declarationByApplicantOnNationalityCopy"
											class="width controlclass1 controlreq" req1="1"
											value="${appForm?.declarationByApplicantOnNationalityCopy}" />
											<g:link
												controller="applicationManagement" action="showUndertakingFile"
												id="${appForm?.id}" target="_blank"
												params='[filename: "declarationByApplicantOnNationalityCopy", dataName: "declarationByApplicantOnNationalityCopy",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
												${appForm?.declarationByApplicantOnNationalityCopyFileName}
											</g:link>
											<g:if test="${flash.message }">
												<span class="text-danger">${flash.message }</span>
											</g:if>
								</td>	
							
							</tr>
						</g:if>
						
						
						
						<g:if test="${notification?.docName == 'Declaration by the Supervisor head of the institution in India Form B'}">
						
							<tr>
								
								<td>
									<b>Declaration by the Supervisor / Head of Institution in India</b>:
								</td>
							
								<td>
								<span class="col-sm-12 form-group"><span
									class="col-sm-11 notificationwidth"><g:link
											controller="loggedInAs" action="showDc"
											id="${notification?.id}"
											params='[filename: "notification1", dataName: "notification1",csrfPreventionSalt:"${csrfPreventionSalt}"]'
											target="_blank">
											<b> Download</b>
										</g:link></span></span>
								</td>
								
								<td>
									<input type="file"
										name="declarationBySupervisorCopy"
										class="width controlclass1 controlreq" req1="1"
										value="${appForm?.declarationBySupervisorCopy}" />
										<g:link
											controller="applicationManagement" action="showUndertakingFile"
											id="${appForm?.id}" target="_blank"
											params='[filename: "declarationBySupervisorCopy", dataName: "declarationBySupervisorCopy",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
											${appForm?.declarationBySupervisorCopyFileName}
										</g:link>
										<g:if test="${flash.message }">
												<span class="text-danger">${flash.message }</span>
											</g:if>
								</td>
								
										
							</tr>
						</g:if>
						
						
						
						<g:if test="${notification?.docName == 'Declaration by the Recipient collaborator outside india Form B'}">
							<tr>
							
								
								<td>
									<b>Declaration by the Recipient or Collaborator outside India</b>:
								</td>
								
								<td>
								<span class="col-sm-12 form-group"><span
									class="col-sm-11 notificationwidth"><g:link
											controller="loggedInAs" action="showDc"
											id="${notification?.id}"
											params='[filename: "notification1", dataName: "notification1",csrfPreventionSalt:"${csrfPreventionSalt}"]'
											target="_blank">
											<b> Download</b>
										</g:link></span></span>
								</td>	
								
								<td>
										<input type="file"
										name="declarationByRecipientCopy"
										class="width controlclass1 controlreq" req1="1"
										value="${appForm?.declarationByRecipientCopy}" />
										<g:link
											controller="applicationManagement" action="showUndertakingFile"
											id="${appForm?.id}" target="_blank"
											params='[filename: "declarationByRecipientCopy", dataName: "declarationByRecipientCopy",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
											${appForm?.declarationByRecipientCopyFileName}
										</g:link>
										<g:if test="${flash.message }">
												<span class="text-danger">${flash.message }</span>
											</g:if>
								</td>
								
									
							</tr>
						</g:if>
					</g:each>
					
					
					
					
				</table>
			</div>	
					<g:hiddenField name="appFormId" value="${appForm?.id}" />
					<g:hiddenField name="formType" value="${formType}" />
					<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}" />
				
				<div class="col-sm-12 form-group text-center"
					style="padding-top: 20px">
					<input type="submit" class="btn btn-primary btncontrol"
								value="Save" />
					<%--<input type="button" class="btn btn-primary" value="Preview" onclick="$('#table').show()"/>--%>


					<g:link controller="applicationManagement" id="preview"
						class="btn btn-primary" action="formBpreview"
						params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Preview</g:link>

					<input type="button" class="btn btn-primary sumitbtn"
						onclick="checkLeftTabsValidation()" id="submitFormFinally"
						value="Submit" data-toggle="modal" data-target="#myModal" />

				</div>
	</g:uploadForm>

			</div>
			
			
			<div class="col-sm-12">
						<g:link controller="formB"
							action="formBPart4"
							params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
							class="btn btn-primary
									">Previous</g:link>
					</div>
			
			
		</div>

	</div>



</body>
</html>
