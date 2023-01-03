
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />

<title>NBA</title>
<script type="text/javascript">
	$(document).ready(function() {
		addCompletegreenClass(tabStatus);
		form2Part3();		
	});
	function loadPage() {
		location.reload(true);
	}

function saveNo(){
	var tradValue = $('#tradditional').val();
	if(tradValue == 'No'){
			$('#saveNoForTradtional').val('No');
		}
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
					model="[formType:formType]" />
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
							<li>Payment</li>
						</ul>
					</div>
				</div>
				<div class="clearfix"></div>



				<div class="clearfix"></div>
				<%--				<g:uploadForm action="savePart3" class="form-horizontal" role="form">--%>

				<div class="main-registeration col-sm-12">
					
					<div class="form-title">
						<label class="register-heading col-sm-12"> <span
							class="leftflot">(5)</span><span class="col-sm-11">
								Details of any traditional knowledge used in the research and any identified individual/ community holding the traditional knowledge </span></label>
					</div>

					<g:form controller="applicationManagement" autocomplete="off"
						action="saveDetailedTraditionalKnowledge">
					<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	
						<div class="col-sm-12">

							<div class=" row form-group less-padding">
								<g:if test="${appForm?.nature == 'Oral' }">
									<span class="col-sm-3"> <g:radio
											onclick="checkRadio_checked()"
											class="istradditional radio col-sm-1" name="tradditional"
											checked="checked" value="Oral" /><span class="leftflot"><b>&nbsp;${appForm?.nature}</b></span></span>
								</g:if>
								<g:else>
									<span class="col-sm-3"> <g:radio
											onclick="checkRadio_checked()"
											class="istradditional radio col-sm-1" name="tradditional"
											value="Oral" /><span class="leftflot"><b>&nbsp;Oral</b></span></span>
								</g:else>


								<g:if test="${appForm?.nature == 'Document' }">
									<span class="col-sm-3"> <g:radio
											onclick="checkRadio_checked()"
											class="istradditional radio col-sm-1" name="tradditional"
											checked="checked" value="Document" /><span class="leftflot"><b>&nbsp;${appForm?.nature}</b></span>
									</span>
								</g:if>
								<g:else>
									<span class="col-sm-3"> <g:radio
											onclick="checkRadio_checked()"
											class="istradditional radio col-sm-1" name="tradditional"
											value="Document" /><span class="leftflot"><b>&nbsp;Document</b></span>
									</span>
								</g:else>


								<g:if test="${appForm.isNoForTraditional == 'No'   }">
									<span class="col-sm-3"> <g:radio
											onclick="checkRadio_checked()"
											class="istradditional radio col-sm-1" name="tradditional"
											checked="checked" value="No" /><span class="leftflot">
											<b>&nbsp;${appForm.isNoForTraditional }</b>
									</span>
									</span>
								</g:if>
								<g:else>
									<span class="col-sm-3"> <g:radio
											onclick="checkRadio_checked()"
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
				<div class="clearfix"></div>
				<div class="main-registeration col-sm-12">
					<!--login form -->

					<div class="col-sm-12 nopadding" id="geoLocationOfCommunityForm">
						<g:render
							template="/applicationManagement/geoLocationOfCommunityForm"
							model="[appForm:appForm,listOfStates:listOfStates]" />
					</div>
				</div>


				<div class="clearfix"></div>
				<div class="col-sm-12 nopadding" id="updateCommunityLocations">
					<g:if test="${listOfCommunityLocations}">
						<g:render template="/applicationManagement/geoLocationOfCommunity"
							model="[listOfCommunityLocations:listOfCommunityLocations,appForm:appForm]" />
					</g:if>
				</div>
				<div class="clearfix"></div>


				<g:uploadForm action="savePart3" class="form-horizontal" role="form" autocomplete="off">
				<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
					<div class="main-registeration col-sm-12">
						<!--login form -->
						<div class="form-title">
							<label class="register-heading col-sm-12"> (6) Details of
								institution where R&D activities carried out </label>
						</div>
						
						<%--
						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-6"><span
									class="leftflot">(a)</span><span class="col-sm-11">Is
										there any such participation </span> </label>
								<div class="col-sm-6">
								
								
								 <g:if test="${!appForm.isResearchParticipation }">
								 		<input type="radio" name="instituteParticipation" value="Yes"
											id="instituteParticipation" onclick="AddValidation_Yes('instituteDetail')" >
											Yes &nbsp;
										<input type="radio" name="instituteParticipation" value="No" onclick="removeValidation_No('instituteDetail')"
											id="instituteParticipation" >
											No
								 </g:if>
								 <g:else>
									<g:if test="${appForm.isResearchParticipation == 'true' }">
										<input type="radio" name="instituteParticipation"
											checked="checked" value="Yes" id="instituteParticipation" onclick="AddValidation_Yes('instituteDetail')"
											>
									Yes &nbsp;
								</g:if>
									<g:else>
										<input type="radio" name="instituteParticipation" value="Yes"
											id="instituteParticipation" onclick="AddValidation_Yes('instituteDetail')" >
									Yes &nbsp;
								</g:else>

									<g:if test="${appForm.isResearchParticipation == 'false' }">
										<input type="radio" name="instituteParticipation" onclick="removeValidation_No('instituteDetail')"
											checked="checked" value="No" id="instituteParticipation"
											>
									No </g:if>
									<g:else>
										<input type="radio" name="instituteParticipation" value="No" onclick="removeValidation_No('instituteDetail')"
											id="instituteParticipation" >
									No
								</g:else>
								</g:else>
								
								</div>
							</div>
						</div>
						--%>
						<div class="instituteDetal" >
							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-12"><span
										class="leftflot">(i)</span><span
										class="col-sm-11 notificationwidth"> Provide the name
											and contact details of the institution / organisation where R&D was carried out</span></label>
									<div class="col-sm-12">

										<g:textArea class="width txtreq controlRD txtmaxword100"
											name="detailsOfInstitute" id="detailsOfInstitute"
											value="${appForm?.detailsOfInstitute}"></g:textArea>
										.
									</div>
								</div>
							</div>

							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-12"><span
										class="leftflot">(ii)</span><span
										class="col-sm-11 notificationwidth"> Attach bona-fide
											letter to the applicant issued by the competent authority of
											the institution/ organization where R&D was carried out.</span></label>
									<div class="col-sm-12">
										<g:if test="${appForm?.bonafideLetter || appForm?.bonafideLetterURL}">
											<input type="file" class="width pdf controlRD" name="BonafideLetter">
											<g:if test="${flash.message }">
												<span class="red"><b>${flash.message }</b></span>
											</g:if>
											<g:else>
												<g:link controller="form2" action="showDc"
													id="${appForm?.id}" target="_blank"
													params='[filename: "bonafideLetterName", dataName: "bonafideLetterName",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
													${appForm?.bonafideLetterName}
												</g:link>
											</g:else>
										</g:if>
										<g:else>
											<input type="file" class="width pdf controlRD" name="BonafideLetter">
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
								<g:hiddenField id="isNoForTraditional" name="isNoForTraditional"/>
								<g:hiddenField name="formType" value="${formType}" />
								<input type="submit" class="btn btn-primary btnRD" Value="Save" />

							</div>
						</div>
					</div>
				</g:uploadForm>
				
				<div class="col-sm-12 form-group">
					<g:link controller="form2" action="part2"
						params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
						class="btn btn-primary pull-left">Previous
							</g:link>
					<g:link controller="form2" action="part4"
						params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
						class="btn btn-primary pull-right">Next
							</g:link>

				</div>

				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- /.container -->
	<div class="clearfix"></div>

</body>

</html>
