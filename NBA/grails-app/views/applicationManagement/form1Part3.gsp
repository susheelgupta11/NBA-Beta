
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />

<title>NBA</title>
<script type="text/javascript">
	$(document).ready(function() {
		addCompletegreenClass(tabStatus);
				form1part3();
				

				var tradValue = $('#tradditional').val();
				if(tradValue == 'No'){
						$('#isNoForTraditional').val('No');
					}
			});
	function loadPage() {
		location.reload(true);
	}
</script>
</head>

<body>
<g:javascript>
	var appFormId= "${appForm?.id}"	
	var tabStatus = "${tabStatus}"		
  </g:javascript>
	<%--<nav class="navbar-default" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

			</div>

		</div>
		<!-- /.container -->
	</nav>

	--%><!-- Page Content -->
	<div class="container ">
		<div class="row">

			<div id="leftTopTab" class="col-sm-2">
				<g:render template="leftTabs" model="[formType:formType]" />
			</div>
			<div class="col-sm-10">

				<div class="col-sm-12">
					<div class="checkout-wrap">
						<ul class="checkout-bar">

							<li class="previous visited first"><a href="#">Part 1</a></li>

							<li class="active">Part 2</li>

							<li class="next">Part 3</li>

							<li class="">Part 4</li>






							<li>Part 5</li>
							<li>Preview</li>
							<li>Payment</li>
						</ul>
					</div>
				</div>
				<div class="main-registeration col-sm-12">
					<g:form controller="applicationManagement"
						action="saveDetailedTraditionalKnowledge" autocomplete="off">
					<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	
						<div class="col-sm-12">

							<div class="form-title ">
								<label class="register-heading">(c) Description/ nature
									of traditional knowledge (oral/ documented) </label>
							</div>

							<div class=" row form-group less-padding">
								<g:if test="${appForm?.nature == 'Oral' }">
									<span class="col-sm-3"> <g:radio onclick="checkRadio_checked()"
											class="istradditional radio col-sm-1" name="tradditional"
											checked="checked" value="Oral" /><span class="leftflot"><b>&nbsp;${appForm?.nature}</b></span></span>
								</g:if>
								<g:else>
									<span class="col-sm-3"> <g:radio onclick="checkRadio_checked()"
											class="istradditional radio col-sm-1" name="tradditional"
											value="Oral" /><span class="leftflot"><b>&nbsp;Oral</b></span></span>
								</g:else>


								<g:if test="${appForm?.nature == 'Document' }">
									<span class="col-sm-3"> <g:radio onclick="checkRadio_checked()"
											class="istradditional radio col-sm-1" name="tradditional"
											checked="checked" value="Document" /><span class="leftflot"><b>&nbsp;${appForm?.nature}</b></span>
									</span>
								</g:if>
								<g:else>
									<span class="col-sm-3"> <g:radio onclick="checkRadio_checked()"
											class="istradditional radio col-sm-1" name="tradditional"
											value="Document" /><span class="leftflot"><b>&nbsp;Document</b></span>
									</span>
								</g:else>


								<g:if test="${appForm?.nature == 'No'  }">
									<span class="col-sm-3"> <g:radio onclick="checkRadio_checked()"
											class="istradditional radio col-sm-1" name="tradditional" 
											checked="checked" value="No" /><span class="leftflot">
											<b>&nbsp;${appForm?.nature }</b>
									</span>
									</span>
								</g:if>
								<g:else>
									<span class="col-sm-3"> <g:radio onclick="checkRadio_checked()"
											class="istradditional radio col-sm-1" name="tradditional" 
											value="No" /><span class="leftflot"> <b>&nbsp;No</b></span>
									</span>
								</g:else>

							</div>
							<div id="textarea">
								<div class="col-sm-12 form-group less-padding">
									<g:textArea rows="4" class="width controlclass"
										PlaceHolder="Provide details such as, nature of knowledge,if it is oral or source of knowledge, if documented not exceeding 500 words."
										name="traditionalKnowledgeDesc" txtreq1="1" txtmaxword100="1"
										value="${appForm?.traditionalKnowledgeDesc}"></g:textArea>

								</div>

								<div class="col-sm-12 form-group text-right">
									<g:hiddenField name="appFormId" value="${appForm?.id}" />
									<g:hiddenField name="formType" value="${formType}" />
									<input type="submit" class="btn btn-primary btnmargin btnclass"
										value="Save" />
								</div>

							</div>


						</div>
					</g:form>
				</div>
				<div class="clearfix"></div>
				<div class="main-registeration col-sm-12">
					<!--login form -->

					<div class="col-sm-12 nopadding" id="geoLocationOfCommunityForm">

						<g:render template="geoLocationOfCommunityForm"
							model="[appForm:appForm,listOfStates:listOfStates]" />
					</div>
				</div>


				<div class="clearfix"></div>
				<div class="col-sm-12 nopadding" id="updateCommunityLocations">
					<g:if test="${appForm?.isNoForTraditional != 'No' && listOfCommunityLocations}">
						<g:render template="geoLocationOfCommunity"
							model="[listOfCommunityLocations:listOfCommunityLocations,appForm:appForm]" />
					</g:if>
				</div>
				<div class="clearfix"></div>

				<%--				<g:form class="form-horizontal" controller="applicationManagement"--%>
				<%--					action="saveForm3" role="form">--%>

				<div class="main-registeration col-sm-12" id="authorizedPersons">
					<!--login form -->
					<g:render template="form1part3" model="[appForm:appForm]" />

					<!--login form ends -->
				</div>

				<!-- GRID AFTER FORM IN POINT (e)  -->

				<div class="col-sm-12 nopadding table-responsive"
					id="divAuthorizedPersonGrid">

					<g:if test="${listOfContactPerson}">
						<g:render template="authorizedPersonGrid"
							model="[listOfContactPerson:listOfContactPerson,appForm:appForm]" />
					</g:if>
				</div>

				<!-- GRID ENDS here  -->

				<div class="clearfix"></div>

				<div class="main-registeration col-sm-12">
					<!--login form -->
					<g:form name="saveForm3" controller="applicationManagement"
						action="saveForm3" autocomplete="off">
					<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	
						<div class="form-title col-sm-12 ">
							<label class="register-heading"><span class="leftflot">
									(f)</span><span class="col-sm-11"> The purpose for which the
									access is requested including the type and extent of research,
									commercial use being derived and expected to be derived from it
							</span></label>
						</div>
						<div class="col-sm-12 form-group">
							<div class="form-group">
								<label class="control-label "><span class="leftflot">(i)</span><span
									class="col-sm-11"> Purpose for which the biological
										resource(s) and/ or associated knowledge is proposed to be
										accessed</span></label>
								<div class="col-sm-12 less-padding">
									<g:each in="${purposeList}" var="purpose">
										<g:if test= "${appForm?.purposeOfProposal == purpose }">
											<g:radio name="purpose" value="${purpose}" checked="checked" />
											<span> ${purpose} </span>
										</g:if>
										<g:else>
											<g:radio name="purpose" value="${purpose}" />
											<span> ${purpose} </span>
										</g:else>
									</g:each>
								</div>
							</div>


							<div class="form-group col-sm-12 less-padding margin-top">
								<label class="control-label "><span class="leftflot">(ii)</span>
									<span class="col-sm-11"> A brief description of the
										research or bio-survey and bio-utilization or commercial
										utilization expressing the scope/ intention and purpose/
										goals/ commercial outlook </span></label>
								<div class="col-sm-12 less-padding">
									<g:textArea class=" width txtlastvalid" onkeyup="TextareaValidataion(this)" rows="4" txtreq1="1" txtmaxword100="1"
										placeHolder="Details in 500 words" name="briefDescription"
										value="${appForm?.briefDescription}"></g:textArea>
								</div>
							</div>


							<div class="form-group col-sm-12 less-padding">
								<label class="control-label "><span class="leftflot">(iii)</span><span
									class="col-sm-11"> Whether any collection of the
										resource endangers any component of biological diversity and
										the risks which may arise from the access. </span></label>
								<div class=" form-group">

									<g:if test= "${!appForm?.isRisky }">
										<g:radio name="isRisky" checkattr="true" 
										value="Yes" class="left radiobtn yes" />
										<span>Yes</span>
										<g:radio name="isRisky" value="No" checkattr="false" 
										class="radiobtn no" />
										<span>No</span>
										
									</g:if>
									<g:else>
									<g:if test= "${appForm?.isRisky == 'true' }">
									<g:radio name="isRisky" checkattr="true" checked= "checked"
										value="Yes" class="left radiobtn yes" />
										<span>Yes</span>
									</g:if>
									<g:else>
										<g:radio name="isRisky" checkattr="true" 
										value="Yes" class="left radiobtn yes" />
										<span>Yes</span>
									</g:else>
									
									<g:if test= "${appForm?.isRisky == 'false' }">
										<g:radio name="isRisky" value="No" checkattr="false" checked= "checked"
										class="radiobtn no" />
										<span>No</span>
									</g:if>
									<g:else>
										<g:radio name="isRisky" value="No" checkattr="false" 
										class="radiobtn no" />
										<span>No</span>
									</g:else>	
									</g:else>
								</div>
							</div>


							<div class="form-group col-sm-12 rbotxtarea less-padding">
								<g:textArea class="txtlastvalid width txtremovevalidate"  txtmaxword100="1"
									name="riskInvolved" placeHolder="Details in 500 words"
									value="${appForm?.riskInvolved}"></g:textArea>

							</div>


							<div class="form-group">
								<div class="col-sm-12 text-right">
									<%--									<g:link controller="applicationManagement" action="form1Part2"--%>
									<%--										class="btn btn-primary" params="[appFormId:appForm?.id]">Previous</g:link>--%>
									<g:hiddenField name="appFormId" value="${appForm?.id}" />
									<g:hiddenField name="formType" value="${formType}" />
									<g:hiddenField id="selfForAuthorized" name="selfForAuthorized" />
<%--									<g:hiddenField id="isNoForTraditional" name="isNoForTraditional"/>--%>
									<input type="submit" class="btn btn-primary btnlastvalid" name="Save"
										value="Save">

									<%--									<g:link controller="applicationManagement" action="form1Part4"--%>
									<%--										params="[appFormId:appForm?.id,formType:formType]"--%>
									<%--										class="btn btn-primary " method="POST">Next</g:link>--%>

								</div>
							</div>

							<!--login form ends -->

						</div>

					</g:form>
				</div>
				<div class="col-sm-12">
					<g:link controller="applicationManagement" action="form1Part2"
						class="btn btn-primary " params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Previous</g:link>
				
					<g:link controller="applicationManagement" action="form1Part4" onclick="checkRadio_checked()"
						params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]' class="btn btn-primary pull-right " method="POST">Next</g:link>

				</div>
				<%--				</g:form>--%>
			</div>
		</div>
	</div>
	<!-- /.container -->
	<div class="clearfix"></div>

</body>

</html>
