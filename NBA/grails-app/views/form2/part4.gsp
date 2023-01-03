
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />
<title>NBA</title>

<script type="text/javascript">
	$(document).ready(function() {
		addCompletegreenClass(tabStatus);
		form2Part4();
	});
</script>
<!--calender codes end -->
</head>

<body>
	<g:javascript>
	var tabStatus = "${tabStatus}"		
  </g:javascript>
	<!-- Page Content -->
	<div class="container ">
		<div class="row">

			<div id="leftTopTab" class="col-sm-2">
				<g:render template="/applicationManagement/leftTabs" model="[formType:formType]"/>
			</div>
			<div class="col-sm-10">
				<div class="col-sm-12">
					<div class="checkout-wrap">
						<ul class="checkout-bar">
							<li class="previous visited first"><a href="#">Part 1</a></li>

							<li class="previous visited first">Part 2</li>

							<li class="active">Part 3</li>

							<li class="">Part 4</li>
							<li>Part 5</li>
							<li>Payment</li>
						</ul>
					</div>
				</div>
				<div class="clearfix"></div>

				<div class="clearfix"></div>
				<div class="main-registeration col-sm-12">
					<!--login form -->
					<g:uploadForm action="savePart4" class="form-horizontal" autocomplete="off" role="form">
					<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
						<div class="form-title">
							<label class="register-heading col-sm-12"><span class="leftflot"> (7)</span> <span class="col-sm-11 notificationwidth">Details of
								individual/ organisation to whom the research results are
								intended to be transferred </span></label>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-12"><span class="leftflot">(a)</span><span class="col-sm-11"> Name and
									contact details of individual / organisation </span></label>
								<div class="col-sm-12">
<%--								   <g:if test="${!appForm?.benefitsToTheIndividualOrOrganization }">	--%>
<%--									<g:textArea class="width"  txtmaxword100="1" placeHolder="Provide details in 100 words" name="detailsOfInstitute" value="" req="1"></g:textArea>--%>
<%--								   </g:if>--%>
<%--								   <g:else>	--%>
									<g:textArea class="width"  txtmaxword100="1" placeHolder="Provide details in 500 words" name="detailsOfIndividualOrOrganisation" value="${appForm?.detailsOfIndividualOrOrganisation}" req="1"></g:textArea>
<%--								   </g:else>	--%>
								</div>
							</div>
						</div>


						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-12"><span class="leftflot">(b)</span> <span class="col-sm-11"> Details of the
									intended use of research results by the transferee  </span></label>
								<div class="col-sm-12">
									<g:textArea class="width"  txtmaxword100="1" placeHolder="Provide details in 500 words" name="useofResearchResults" value="${appForm?.useofResearchResults}" req="1"></g:textArea>
								</div>
							</div>
						</div>


						<div class="form-title">
							<label class="register-heading col-sm-12"><span class="leftflot">  (8)</span> <span class="col-sm-11 notificationwidth">  Details of economic,
								biotechnological, scientific or any other benefits that are
								intended, or may accrue to the individual / organization due to
								commercialization of transferred research results </span></label>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-12"> </label>
								<div class="col-sm-12">
									<g:textArea class="width"  txtmaxword100="1" placeHolder="Provide details in 500 words" name="benefitsToTheIndividualOrOrganization" value="${appForm?.benefitsToTheIndividualOrOrganization}" req="1"></g:textArea>
								</div>
							</div>
						</div>


						<div class="form-title">
							<label class="register-heading col-sm-12"> <span class="leftflot"> (9)</span> <span class="col-sm-11 notificationwidth">  Details of economic,
								biotechnological, scientific or any other benefits that are
								intended, or may accrue to the applicant seeking approval for
								transfer of results of research </span></label>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<div class="col-sm-12">
									<g:textArea class="width" txtmaxword100="1" name="benefitsToTheApplicant" placeHolder="Provide details in 500 words" value="${appForm?.benefitsToTheApplicant}" req="1"></g:textArea>
								</div>
							</div>
						</div>

						<div class="form-title">
							<label class="register-heading col-sm-12"> <span class="leftflot">(10)</span><span class="col-sm-11 "> Details of any
								agreement or MoU between the proposed recipient and applicant
								seeking approval for transfer of results of research </span></label>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<div class="col-sm-7 g">
								
								<g:if test= "${!appForm?.isAgreementOrMou}" >
								<div class="col-sm-2 less-padding">
									<input type="radio" name="agreementOrMou"  value="Yes"  onclick="AddValidation_Yes4('AgreementMOU')"
										style="float: left"> <b class="leftflot">Yes</b>	
										</div>									
								 	 <input type="radio" name="agreementOrMou"  value="No" onclick="removeValidation_No4('AgreementMOU')" 
										style="float: left"> <b class="leftflot">No</b>
								 </g:if>
								 
								<g:else>
								 	<g:if test= "${appForm?.isAgreementOrMou == 'true' }">
								 	<div class="col-sm-2 less-padding">
								 		<input type="radio" name="agreementOrMou"  value="Yes" onclick="AddValidation_Yes4('AgreementMOU')"  checked= "checked"
											style="float: left"> <b class="leftflot" >Yes</b>
											</div>
								  	</g:if>
								 	<g:else>
								 	<div class="col-sm-2 less-padding">
								    	<input type="radio" name="agreementOrMou"  value="Yes"  onclick="AddValidation_Yes4('AgreementMOU')"
											style="float: left"> <b class="leftflot">Yes</b>
											</div>
									</g:else>
									
									<g:if test= "${appForm?.isAgreementOrMou == 'false' }">
										<input type="radio" name="agreementOrMou"  value="No" checked= "checked" onclick="removeValidation_No4('AgreementMOU')"
											style="float: left"> <b class="leftflot">No</b>
									</g:if>
									<g:else>
										<input type="radio" name="agreementOrMou"  value="No"  onclick="removeValidation_No4('AgreementMOU')"
											style="float: left"> <b class="leftflot">No</b>
									</g:else>
								</g:else>
								 	
								</div>
							</div>
						</div>
						<div class="AgreementMOU">
							<div class="col-sm-12">
								<div class="form-group">
									
									<div class="col-sm-12">
										<g:textArea class="width reqc txtmaxword100" rows="5" PlaceHolder="Provide details in 500 words" name="collaborationDetails" value="${appForm?.collaborationDetails}"></g:textArea>
									</div>
								</div>
							</div>

							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-12">
										Attach a copy of the relevant agreement or MoU</label>
									<div class="col-sm-12">
									<g:if test="${appForm?.mouFile || appForm?.mouFileURL}">
								<input type="file" class="width pdfc" name="MouFile">

											<g:if test="${flash.message }">
												<span class="red"><b>${flash.message }</b></span>
											</g:if>
											<g:else>
												<g:link controller="form2" action="showDc"
													id="${appForm?.id}" target="_blank"
													params='[filename: "mouFileName", dataName: "mouFileName",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
													${appForm?.mouFileName}
												</g:link>
											</g:else>
										</g:if>
										<g:else>
										<input type="file" class="width pdfc" name="MouFile"/>
											<g:if test="${flash.message }">
												<span class="red"><b>${flash.message }</b></span>
											</g:if>
										</g:else>
									</div>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-12 text-right">
							
							
							
								
							<g:hiddenField name="appFormId" value="${appForm?.id}" />
								<g:hiddenField name="formType" value="${formType}" />
						<input type="submit" class="btn btn-primary " Value="Save"/>
						
							</div>
						</div>
					</g:uploadForm>
				</div>
				<div class="col-sm-12 form-group">
				<g:link controller="form2" action="part3"
							params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
							class="btn btn-primary pull-left">Previous
							</g:link>
				
				<g:link controller="applicationManagement" action="form1Part5"
							params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
							class="btn btn-primary pull-right">Next
							</g:link>
				</div>
				<!--login form ends -->

				<div class="clearfix"></div>

			</div>
		</div>
	</div>
	<!-- /.container -->
	<div class="clearfix"></div>

</body>

</html>
