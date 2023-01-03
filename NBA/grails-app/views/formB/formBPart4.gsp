
<!DOCTYPE html>
<html lang="en">
<head>
<meta name='layout' content='loggedInUser' />

<script>
	$(document).ready(function() {
		BindValidation("controlclass", "btnctrl");
		BindValidation("controlclass1", "btnclass1");
		addCompletegreenClass(tabStatus);
		AddActiveClass("menu5");
		datePicker();
		$('#other').hide();
		if(multipleTimeExercise == 'multipleTime'){
			$("#ifMultipleTimeExercise").show();
		 }
		else{
			$("#ifMultipleTimeExercise").hide();
			}
		goFocus("focusbtn", "foucuscontrol");
		goFocus("focusbtn1", "foucuscontrol1");
	});

	function validateResearchDuration(){
		BindValidation("controlclass2", "btnclass2");
		BindValidation('widthemergencyDetails', 'ctrolvalid');	
		}
	
	
	function loadPage() {
		location.reload(true);
	}

	function showTimeAndReasonFields(){
		$("#ifMultipleTimeExercise").show();
		$("#ifMultipleTimeExercise").each(function() {
			$('input[type="submit"]').addClass("btnclass2");
		});
		}
	function hideTimeAndReasonFields(){
		$("#ifMultipleTimeExercise").hide();
		//$("#ifMultipleTimeExercise").removeClass('controlclass2');
		$("#ifMultipleTimeExercise").each(function() {
			$('input[type="submit"]').removeClass("btnclass2");
		});
		}

	function hideShowOnEdit(){
		$('#other').hide();
		var value = $('#source').val();
		if(value == 'Others'){
			$('#other').show();
			}
		}

	function removeReqForMicroorganism(){
		var natureRadioValue;
		natureRadioValue = $('input[name=nature]:checked').val();
		//alert(natureRadioValue);

		if(natureRadioValue == 'Micro-organism'){
				$("#mandatoryAstrik").html('');
				$(".commonName").removeAttr("req1");
			}
		else{
				$("#mandatoryAstrik").html("<b>*</b>");
				$(".commonName").attr("req1","1");
			}
		}
	
</script>
</head>
<body>
	<g:javascript>  
  var tabStatus = "${tabStatus}"
  var multipleTimeExercise = "${appForm?.typeOfExercise }"
  </g:javascript>
	<div class="container form-group">
		<div class="row">

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

							<li class="active">Part 3</li>

							<li class="next">Part 4</li>

							<li>Part 5</li>
							<li>Preview</li>
							<li>Payment</li>

						</ul>
					</div>
				</div>
				<div class="clearfix"></div>
				<div class="col-sm-12 ">
					<!--login form -->

		
					<div id="updateBioResourceForm">
						<!--PART 4 starts -->

						
							<g:if test="${bioRes}">
								<g:render template="bioResourceForm"
									model='[bioRes:bioRes,csrfPreventionSalt:"${csrfPreventionSalt}"]' />
							</g:if>
							<g:else>
									<g:render template="bioResourceForm"
									model='[csrfPreventionSalt:"${csrfPreventionSalt}"]' />
							</g:else>
						
					</div>
					<div class="col-sm-12 nopadding table-responsive"
						id="updateBioResourceGrid">
						<g:if test="${listOfBioResources}">
							<g:render template="bioresourceGrid"
								model="[listOfBioResources:listOfBioResources]" />
						</g:if>
					</div>



					<div class="main-registeration col-sm-12">
						<div class="col-sm-12 form-group">
							<label
								class="control-label col-sm-4 register-heading less-padding">(ii)
								Duration of Research </label>
							<g:formRemote name="researchDuration" class="form-horizontal"
								role="form" autocomplete="off"
								url="[controller:'formB',action:'researchDuration']" update=""
								onSuccess="" onComplete="loadPage()">
								<input type="hidden" name="csrfPreventionSalt"
									value="${csrfPreventionSalt}" />
								<div class="col-sm-3">
									<label>From:</label> <input type="text"
										name="researchDurationFrom"
										value="${appForm?.researchDurationFrom?.format('dd/MM/yyyy') }" req1="1"
										class="form-control datePicker fromTime controlclass2" placeholder="" />
								</div>
								<div class="col-sm-3" style="margin-bottom: 25px;">
									<label>To:</label> <input type="text" name="researchDurationTo"
										value="${appForm?.researchDurationTo?.format('dd/MM/yyyy') }" req1="1"
										class="form-control datePicker toTime controlclass2" placeholder="" />
								</div>
								
								
								
								<div class="row ">
									<label class="control-label col-sm-4"><span class="col-sm-1">(a)</span>
										<span class="col-sm-10">Type of exercise <span class="text-danger">*</span> </span>
									</label>
									
									
									<div class="col-sm-7">
									
									<g:if test="${!appForm }">
										<span class="col-sm-5"> <input type="radio"
											name="typeOfExercise" value="oneTime" id="tradditional"
											onclick="hideTimeAndReasonFields()" req1="1"
											class="isonetime radio col-sm-1 controlclass2"><span
											class="leftflot">&nbsp;One-time exercise</span></span>
					
										<span class="col-sm-5"> <input type="radio"
											name="typeOfExercise" value="multipleTime" id="tradditional"
											onclick="showTimeAndReasonFields()" req1="1"
											class="ismultiple radio col-sm-1 controlclass2"><span
											class="leftflot">&nbsp;Multiple-time exercise</span>
										</span>
									</g:if>
									<g:else>
											<g:if test="${appForm?.typeOfExercise == 'oneTime' }">
												<span class="col-sm-5"> <input type="radio"
												name="typeOfExercise" value="oneTime" id="tradditional"
												onclick="hideTimeAndReasonFields()" checked
												class="isonetime radio col-sm-1"><span
												class="leftflot">&nbsp;One-time exercise</span></span>
											</g:if>
											<g:else>
												<span class="col-sm-5"> <input type="radio"
												name="typeOfExercise" value="oneTime" id="tradditional"
												onclick="hideTimeAndReasonFields()"
												class="isonetime radio col-sm-1"><span
												class="leftflot">&nbsp;One-time exercise</span></span>
											</g:else>
											
											<g:if test="${appForm?.typeOfExercise == 'multipleTime' }">
													<span class="col-sm-5"> <input type="radio"
													name="typeOfExercise" value="multipleTime" id="tradditional"
													onclick="showTimeAndReasonFields()" checked
													class="ismultiple radio col-sm-1"><span
													class="leftflot">&nbsp;Multiple-time exercise</span>
										</span>
											</g:if>
											<g:else>
													<span class="col-sm-5"> <input type="radio"
													name="typeOfExercise" value="multipleTime" id="tradditional"
													onclick="showTimeAndReasonFields()" 
													class="ismultiple radio col-sm-1"><span
													class="leftflot">&nbsp;Multiple-time exercise</span>
											</g:else>
									</g:else>	
									</div>
								 </div>


								<div id="ifMultipleTimeExercise">
									<div class="col-sm-12 form-group less-padding" style="margin-top: 20px;">
										<label class="control-label col-sm-4"><span
											class="col-sm-1">(b)</span> <span class="col-sm-10">
												How many times going to send /carry the biological resources?<span class="text-danger"><b>*</b></span>
										</span></label>
										<div class="col-sm-8">
											<input id="foucuscontrol" type="text" req1="1"
												class="width controlclass2 Associate" name="numOfTimesOfSending"
												value="${appForm?.numOfTimesOfSending }">
										</div>
									</div>
									
									<div class="col-sm-12 form-group less-padding" >
										<label class="control-label col-sm-4"><span
											class="col-sm-1">(c)</span> <span class="col-sm-10">
												Reasons for sending /carrying the biological resources multiple times<span class="text-danger"><b>*</b></span>
										</span></label>
										<div class="col-sm-8">
											<input id="foucuscontrol" type="text" req1="1"
												class="width controlclass2 Associate" name="reasonsForSending"
												value="${appForm?.reasonsForSending }">
										</div>
									</div>
								</div>


								<div class="col-sm-12 form-group text-right" style="margin-top:10px;">
									<g:hiddenField name="appFormId" value="${appForm?.id}" />
									<g:hiddenField name="formType" value="${formType}" />
														<input type="submit" class="btn btn-primary btnclass2" onclick="validateResearchDuration()" value="Save"/>
<%--									<input type="button" class="btn btn-primary " value="Add More" />--%>
								</div>
							</g:formRemote>
						</div>
						<div class="col-sm-12 form-group text-right "></div>

					</div>


					<div class="main-registeration col-sm-12"
						id="geographicalLocationForm">
						<g:render
							template="/applicationManagement/geographicalLocationForm"
							model="[bioresource:bioresource,listOfStates:listOfStates,appForm:appForm,geoLocation:geoLocation,formType:formType]" />
						<!--login form ends -->
					</div>

					<div class="col-sm-12 nopadding table-responsive"
						id="updateGeoLocation">
						<g:if test="${listOfLocations}">
							<g:render
								template="/applicationManagement/geographicalLocationGrid"
								model="[appForm:appForm,listOfLocations:listOfLocations,formType:formType]" />
						</g:if>

					</div>


					<div class="main-registeration col-sm-12">
						<div class="col-sm-12 form-group">
							<label class="control-label  register-heading">(9) If it
								is for emergency purpose, specify details </label>
						</div>
						<g:formRemote name="emergencyDetails" class="form-horizontal"
							role="form" autocomplete="off"
							url="[controller:'formB',action:'researchDuration']" update=""
							onSuccess="" onComplete="loadPage()">
							<input type="hidden" name="csrfPreventionSalt"
								value="${csrfPreventionSalt}" />
							<div class="col-sm-12">
								<g:textArea class="form-control widthemergencyDetails txtlastvalid txtremovevalidate" rows="4" name="emergencyDetails" txtmaxword100="1"
								
									placeholder="Details in 500 words">${appForm?.emergencyDetails }</g:textArea>
									
									
									
<%--							<g:textArea class="form-control widthemergencyDetails" name="emergencyDetails" value="${appForm?.emergencyDetails }"--%>
<%--										data-toggle="tooltip" req="1"  data-placement="top">--%>
<%--							</g:textArea>		--%>
									
									
									
									
									
								<br />
							</div>
							<div class="col-sm-12 form-group text-right ">
								<g:hiddenField name="appFormId" value="${appForm?.id}" />
								<g:hiddenField name="formType" value="${formType}" />
								<input type="submit" class="btn btn-primary ctrolvalid" onclick="validateResearchDuration()" value="Save" /> 
<%--								<input type="button" class="btn btn-primary " value="Add More" />--%>
							</div>
						</g:formRemote>

					</div>

					<div class="col-sm-12">
						<g:link controller="formB"
							action="formBPart3"
							params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
							class="btn btn-primary
									">Previous</g:link>
						
						<g:set var="ListId1" value="${listOfLocations?.bioResource?.scientificName}"></g:set>
						<g:set var="ListId2" value="${newList?.scientificName}"></g:set>
						<g:if test="${(ListId1).containsAll(ListId2) == true}">
							<g:link controller="formB" action="formBPart5"
								params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
								class="btn  btn-primary pull-right" method="POST">Next</g:link>
						</g:if>
						<g:else>
							<a href= "#" method="POST" class="btn btn-primary pull-right" onClick="AddPointerNone(this)" >Next</a>
						</g:else>		
					</div>
				</div>
			</div>
</body>
</html>
