
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />
<title>NBA</title>
<script type="text/javascript">
	$(document).ready(function() {
		Entity();
		addCompletegreenClass(tabStatus);
		AddActiveClass("menu5");
		$("#DigitalSignature").hide();
		var r = $("input[type='radio'][name='radio']:checked").val()
		if (r && r == 'digital') {
			$("#DigitalSignature").show();
			$("#declarestatement").show();
			$(".preview").removeAttr('disabled');
		} else if (r && r == 'withoutdigital') {
			$("#Nosignature").show();
			$("#declarestatement").show();
			$(".preview").removeAttr('disabled');
		}
		
	});

	function loadPage() {
		location.reload(true);
	}

</script>
</head>

<body>
	<g:javascript>

	var tabStatus = "${tabStatus}"		
	var csrfPreventionSalt = "${csrfPreventionSalt}"
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
						params='[formType:formType,appFormId:appFormId,csrfPreventionSalt:"${csrfPreventionSalt}"]'
						class="btn btn-success">Ok</g:link>
					<button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
				</div>
			</div>

		</div>
	</div>

	<%--	modelContentEnds--%>
	<div class="container ">
		<div class="row">
			<div id="leftTopTab" class="col-sm-2">
				<g:render template="leftTabs"
					model="[formType:formType,appForm:appForm]" />
			</div>
			<div class="col-sm-10">
				<div class="col-sm-12">
					<div class="checkout-wrap">
						<ul class="checkout-bar">

							<li class="previous visited first"><a href="#">Part 1</a></li>

							<li class="previous visited"><a href="#">Part 2</a></li>

							<li class="previous visited"><a href="#">Part 3</a></li>

							<li class="active"><a href="#">Part 4</a></li>

							<li>Preview</li>


						</ul>
					</div>
				</div>


				<div class="clearfix"></div>
				<div class="main-registeration col-sm-12">


					<!--form A -->
					<g:uploadForm controller="applicationManagement" autocomplete="off"
						action="submitDeclarationFormC">

						<div class="text-center">
							<h3>
								<span><b>Declaration / Undertaking</b></span>
								
							</h3>
							
							<p><span>(Download the Declaration/Undertaking and upload it duly filled in with Signature & Seal) </span></p>
						</div>
						
						
						
						<div class="col-sm-12 text-center form-group">
							
								<g:if test="${appForm?.isDeclarationDigitallySigned == 'true' }">
									<div class="col-sm-6 form-group less-padding">
										<input type="radio" class="leftflot" name="radio"
											value="withoutdigital"
											onclick="showhideDigitalSignature(this)" /><span
											class="leftflot"> &nbsp; <b>Declaration without
												digital signature</b></span>
									</div>

									<div class="col-sm-6 form-group less-padding">
										<input type="radio" class="leftflot " name="radio"
											checked="checked" value="digital" disabled
											onclick="showhideDigitalSignature(this)" /><span
											class="leftflot"> &nbsp;<b>Declaration with
												digital signature</b></span>
									</div>
								</g:if>
								<g:elseif test="${appForm?.isDeclarationDigitallySigned = 'notDigital' }">
									<div class="col-sm-6 form-group less-padding">
										<input type="radio" class="leftflot" name="radio"
											checked="checked" value="withoutdigital"
											onclick="showhideDigitalSignature(this)" /><span
											class="leftflot"> &nbsp; <b>Declaration without
												digital signature</b></span>
									</div>

									<div class="col-sm-6 form-group less-padding">
										<input type="radio" class="leftflot " name="radio" disabled
											value="digital" onclick="showhideDigitalSignature(this)" /><span
											class="leftflot"> &nbsp;<b>Declaration with
												digital signature</b></span>
									</div>
								</g:elseif>
								<g:else>
										<div class="col-sm-6 form-group less-padding">
											<input type="radio" class="leftflot" name="radio"
												value="withoutdigital"
												onclick="showhideDigitalSignature(this)" /><span
												class="leftflot"> &nbsp; <b>Declaration without
													digital signature</b></span>
										</div>
										<div class="col-sm-6 form-group less-padding">
											<input type="radio" class="leftflot " name="radio" disabled
												value="digital" onclick="showhideDigitalSignature(this)" /><span
												class="leftflot"> &nbsp;<b>Declaration with digital
													signature</b></span>
										</div>
								</g:else>

						</div>
						<div id="Nosignature">

							

						</div>
						

						<table class="table-bordered" style="width: 100%">
						<g:each in="${listOfNotifications}" var="notification">
					
						<g:if test="${notification?.docName == 'Declaration by the Applicant Form C'}">
						
							<tr>
								<td style="width: 40%;"><b>Undertaking by the applicant</b>:
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
									req1="1" value="${applicationform?.undertakingCopy}"  onchange="validateFile(this)"/> <g:link
										controller="applicationManagement"
										action="showUndertakingFile" id="${applicationform?.id}"
										target="_blank"
										params='[filename: "undertakingCopy", dataName: "undertakingCopy",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
										${applicationform?.undertakingCopyFileName}
									</g:link></td>
							</tr>
							
						</g:if>
						</g:each>	
							
						<tr id="DigitalSignature">
							<td style="width: 40%;">
								<b>Upload signature</b>: 
							</td>
							<td style="width: 20%;">
							</td>
							<td>
								<input type="file" name="digitalSignature" class="width" onchange="validateFile(this)"/>
							</td>
						</tr>		
						


						</table>
						<g:hiddenField name="formType" value="${formType}" />
						<g:hiddenField name="appFormId" value="${appFormId}" />

						<g:hiddenField name="csrfPreventionSalt"
							value="${csrfPreventionSalt}" />

						<div class="col-sm-12 form-group text-center"
							style="padding-top: 20px">
							<input type="submit" class="btn btn-primary btncontrol"
								value="Save" />
							<g:if test="${formType == 'FormC'}">
								<g:link controller="applicationManagement" id="preview"
									class="btn btn-primary preview" action="formCpreview"
									params='[formType:formType,appFormId:appFormId,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Preview</g:link>
							</g:if>
							<input type="button" class="btn btn-primary sumitbtn"
								onclick="checkLeftTabsValidation()" id="submitFormFinally"
								value="Submit" data-toggle="modal" data-target="#myModal" />

						</div>
					</g:uploadForm>
					<!-- start -->



					<!-- end -->





				</div>


				<div class="col-sm-12">
					<g:link controller="applicationManagement" action="formCPart3"
						class="btn btn-primary"
						params='[appFormId:appFormId,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Previous</g:link>

				</div>

			</div>
		</div>
	</div>

	<div class="clearfix"></div>

</body>

</html>
