
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />
<title>NBA</title>

<script type="text/javascript">
	$(document).ready(function() {
		addCompletegreenClass(tabStatus);
		//Entity();
		BindValidation("ctlwidth", "btnctrl");
		AddActiveClass("menu6");
	});

	function loadPage() {
		location.reload(true);
	}
</script>
</head>

<body>
	<g:javascript>
	var tabStatus = "${tabStatus}"		
  </g:javascript>

	<!-- Page Content -->
	<div class="container ">
		<div class="row">
			<div id="leftTopTab" class="col-sm-2">
				<g:render template="/applicationManagement/leftTabs"
					model="[formType:formType,appForm:appForm]" />
			</div>

			<div class="col-sm-10">
				<div class="col-sm-12">
					<div class="checkout-wrap">
						<ul class="checkout-bar">

							<li class="previous visited first"><a href="#">Part 1</a></li>

							<li class="previous visited">Part 2</li>

							<li class="previous visited">Part 3</li>

							<li class="previous visited">Part 4</li>
							<li class="active">Form A</li>

							<li>Part 5</li>
							<li>Preview</li>
							<li>Payment</li>

						</ul>
					</div>
				</div>
				<div class="clearfix"></div>
				<div class="main-registeration col-sm-12">


					<!--form A -->


					<!-- start -->
					<div class="table-responsive">
						<table class="table table-bordered datatable">

							<thead>
								<tr>
									<th>S.No.</th>

									<th>Intend to access</th>

									<th>Common Name</th>
									<th>Scientific Name</th>
									<th>Nature of Biological Resource</th>
									<th>Part of Biological Resource</th>
									<th>Quantity of Resource</th>
									<th>Rate per unit (INR)</th>
									<th>State Biodiversity Board</th>
									<th>Prospective buyers / users(if known)</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<g:if test="${listOfBioResources}">
									<%int i=1 %>
									<g:each in="${listOfBioResources}" var="bioResource">
										<tr>
											<td scope="row"><%=i %></td>
											<%i++ %>
											<td>
												${bioResource?.accessIntention}
											</td>
											<g:if
												test="${bioResource?.accessIntention == 'Biological Resources' || bioResource?.accessIntention == 'Biological Resources & Traditional Knowledge' || bioResource?.accessIntention == 'Associated Knowledge' }">
												<td scope="row">
													${bioResource?.commonName}
												</td>
												<td scope="row">
													${bioResource?.scientificName}
												</td>
												<td scope="row">
													${bioResource?.nature}
												</td>
												<td scope="row">
													${bioResource?.biologicalResource}
												</td>
											</g:if>
											<g:else>
												<td scope="row">N/A</td>
												<td scope="row">N/A</td>
												<td scope="row">N/A</td>
												<td scope="row">N/A</td>
											</g:else>



											<g:if test="${formType == 'Form1' && formType != 'Form4' }">

												<g:if
													test="${bioResource?.accessIntention == 'Biological Resources' || bioResource?.accessIntention == 'Biological Resources & Traditional Knowledge' || bioResource?.accessIntention == 'Associated Knowledge'}">
													<td scope="row">
														${bioResource?.quantity} ${bioResource?.qtyUnit}
													</td>
												</g:if>
												<g:else>
													<td scope="row">N/A</td>
												</g:else>

											</g:if>
											<g:formRemote name="biologicalResources"
												class="form-horizontal" role="form" autocomplete="off"
												url='[controller:"formA",action:"saveBioProfile"]'
												onComplete="loadPage()">
												<input type="hidden" name="csrfPreventionSalt"
													value="${csrfPreventionSalt}" />
												<g:hiddenField name="appFormId" value="${appForm?.id}" />
												<g:hiddenField name="bioResourceInstID"
													value="${bioResource?.id}" />
												<g:if test="${formType == 'Form1' }">
													<td scope="row">
													
													<g:if test="${bioResource?.id == bioResourceEditId?.id}">
															<textarea rows="4" class="form-control txtlastvalid txtremovevalidate" txtreq1="1"
																name="ratePerUnit">${bioResource?.ratePerUnit}</textarea>
														</g:if> 
														<g:elseif test="${bioResource?.ratePerUnit != '' && bioResource?.ratePerUnit != null}">${bioResource?.ratePerUnit}</g:elseif> 
														<g:else>
															<textarea rows="4" class="form-control txtlastvalid txtremovevalidate"
																name="ratePerUnit" txtreq1="1"></textarea>
														</g:else>
														
														</td>

													<td scope="row">
													<g:if
															test="${bioResource?.id == bioResourceEditId?.id}">
													<g:select name="stateBiodeversityBoard"
															from="${listOfStates?.state}"
															class=" stateddl width ctlwidth" value="${bioResource?.stateBiodeversityBoard}"
															noSelection="['':'Select State']" /> 
														</g:if> <g:elseif
															test="${bioResource?.stateBiodeversityBoard != '' && bioResource?.stateBiodeversityBoard != null }">
															${bioResource?.stateBiodeversityBoard}
															</g:elseif> <g:else>
															<g:select name="stateBiodeversityBoard"
															from="${listOfStates?.state}"
															class=" stateddl width ctlwidth" value=""
															noSelection="['':'Select State']" /> 
															</g:else>
																
															</td>
													<td scope="row"><g:if
															test="${bioResource?.id == bioResourceEditId?.id}">
															<textarea rows="4" class="form-control txtlastvalid txtremovevalidate" txtreq1="1"
																name="prospectiveBuyers">${bioResource?.prospectiveBuyers}</textarea>
														</g:if> <g:elseif test="${bioResource?.prospectiveBuyers != '' && bioResource?.prospectiveBuyers != null}">${bioResource?.prospectiveBuyers}</g:elseif> <g:else>
															<textarea rows="4" class="form-control txtlastvalid txtremovevalidate"
																name="prospectiveBuyers" txtreq1="1"></textarea>
														</g:else></td>

												</g:if>

												<td><g:link controller="formA" action="editBioProfile"
														params='[bioResource:bioResource?.id,formType:formType,appFormID:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
														<img src="../images/edit.png" width="16" height="16"
															alt="edit" title="edit" />
													</g:link> <%--													<button type="Submit" class="btnctrl btn btn-primary"	value="save"><i class="icon-user icon-white"></i></button>--%>

													<button type="submit" class="submit-with-icon btnctrl1">
														<img src="../images/save.png" width="16" height="16"
															alt="save" title="save" />
													</button> <%--													<img src="../images/save.png" width="16" height="16" alt="save" title="save" />--%>

													<%--													<input ></input>--%> <%--							<g:remoteLink controller="applicationManagement"--%>
													<%--								action="saveBioProfile" onSuccess="loadPage()" update="updateBioResources"--%>
													<%--								params='[bioResourceID:bioResource?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>--%>
													<%--								<img src="../images/save.png" width="16" height="16"--%>
													<%--									alt="save" title="save" />--%> <%--							</g:remoteLink>--%>
												</td>
											</g:formRemote>
										</tr>
									</g:each>
								</g:if>
								<g:else>
									<tr>
										<td scope="row"></td>
										<td scope="row"></td>
										<td scope="row"></td>
										<td scope="row"></td>
										<td scope="row"></td>
										<td scope="row"></td>
										<td scope="row"></td>
										<td scope="row"></td>
										<td scope="row"></td>
										<td scope="row"></td>
										<td scope="row"></td>
									</tr>

								</g:else>
							</tbody>

						</table>
					</div>


					<!-- end -->
					<g:uploadForm action="uploadBenefitSharingProof">
						<div class="form-group col-sm-12 Proposed">
								<label class="control-label col-sm-3"><span
									class="floatleft"></span> <span class="col-sm-11">
										Upload the proof of benefit sharing by immediate seller </span></label>
								<div class="col-sm-9">
									<g:if test="${appForm?.benefitSharingProofFile}">
										<input type="file" class="width pdfc"
											name="benefitSharingProof">
										<g:if test="${flash.message }">
											<span class="red"><b> ${flash.message }
											</b></span>
										</g:if>
										<g:else>
											<g:link action="showAppDc"
												id="${appForm?.id}" target="_blank"
												params='[filename: "benefitSharingProof", dataName: "benefitSharingProof",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
												${appForm?.benefitSharingProofFilename}
											</g:link>
										</g:else>
									</g:if>
									<g:else>
										<input type="file" class="width pdfc"
											name="benefitSharingProof">
										<g:if test="${flash.message }">
											<span class="red"><b> ${flash.message }
											</b></span>
										</g:if>
									</g:else>
									<g:hiddenField name="appFormId" value="${appForm?.id }" />
									<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}" />
									<input type="hidden" name="formType" value="${formType}" />
								</div>
								<div class="col-sm-12 text-right">
										<input type="submit" class="btn btn-primary" value="Save" />
								</div>
							</div>
						</g:uploadForm>




				</div>
				<div>

					<g:render template="formAUndertaking"
						model="[formType:formType,appFormId:appForm]"></g:render>
				</div>
				<div class="col-sm-12">
					<g:link controller="applicationManagement" action="form1Part4" onclick="checkRadio_checked()"
						params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]' class="btn btn-primary  " method="POST">Previous</g:link>
					<g:if
						test="${appForm?.isDeclarationDigitallySigned == 'true' || appForm?.isDeclarationDigitallySigned == 'notDigital' }">
						
						<g:link controller="applicationManagement" action="form1Part5"
							class="btn btn-primary pull-right"
							params='[appFormId:appForm?.id,formType:formType,declaration:"declaration" ,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Next</g:link>
					</g:if>
					<g:else>
						<g:link controller="applicationManagement" action="form1Part5"
							class="btn btn-primary pull-right"
							params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Next</g:link>
					</g:else>
				</div>

			</div>
		</div>
	</div>
	<!-- /.container -->
	<div class="clearfix"></div>

</body>

</html>
