
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />

<title>NBA</title>
<script type="text/javascript">
	$(document).ready(function() {
		addCompletegreenClass(tabStatus);
		form2Part2();
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
	<div class="container">
		<div class="row">

			<div id="leftTopTab" class="col-sm-2">
				<g:render template="/applicationManagement/leftTabs"
					model="[formType:formType]" />
			</div>
			<div class="col-sm-10">
				<div class="col-sm-12">
					<div class="checkout-wrap">
						<ul class="checkout-bar">

							<li class="active"><a href="#">Part 1</a></li>

							<li class="">Part 2</li>

							<li class="next">Part 3</li>

							<li class="">Part 4</li>
							<li class="">Part 5</li>
							<li class="">Payment</li>



						</ul>
					</div>
				</div>
				<div class="clearfix"></div>


				<div class="main-registeration col-sm-12">
					<!--login form -->
					<g:form controller="form2" action="saveResearchResults" autocomplete="off"
						class="form-horizontal" role="form">
					<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	

						<div class="form-title col-sm-12">
							<label class="register-heading"> (2) Details of the
								results of research conducted </label>
						</div>

						<div class="col-sm-12 less-padding form-group">

							<label class="control-label col-sm-4"><span
								class="col-sm-1">(a)</span> <span class="col-sm-10"> A
									brief detail of research conducted </span></label>
							<div class="col-sm-8">
								<g:textArea class="width controlclass2" name="briefDescription"
									placeHolder="Provide the details in 500 words" txtreq1="1"
									txtmaxword100="1" value="${appForm?.briefDescription}"></g:textArea>

							</div>
						</div>




						<div class="col-sm-12 less-padding form-group">

							<label class="control-label col-sm-4"><span
								class="col-sm-1">(b)</span> <span class="col-sm-10"> Type
									of results of research to be transferred </span> </label>
							<div class="col-sm-8">

								<g:textArea class="width controlclass2" name="resultsOfResearch"
									txtreq1="1" txtmaxword100="1"
									value="${appForm?.resultsOfResearch}"
									placeHolder=" Please specify the type / description of research results to be transferred in 500 words "></g:textArea>
							</div>

						</div>
						<div class="form-group">

							<div class="col-sm-12">
								<g:hiddenField name="formType" value="${formType}" />
								<g:hiddenField name="appFormId" value="${appForm?.id}" />
								<input type="submit"
									class="btn btn-primary pull-right btnclass2" Value="Save" />
							</div>
						</div>
					</g:form>
					<!--login form ends -->
				</div>


				<div class="clearfix"></div>
				<div class="col-sm-12 nopadding">


					<div class="main-registeration col-sm-12">
						<!--login form -->
						<div id="AddUpdateDetails">
							<label class="register-heading col-sm-12">(3) Details of biological resources and/ or associated knowledge used in the research </label>
							<g:formRemote name="biologicalResources" class="form-horizontal"
								role="form" autocomplete="off"
								url="[controller:'applicationManagement',action:'saveBiologicalResources']"
								update="updateBioResources" onSuccess="ClearAllFields()"
								onComplete="loadPage()">
							<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	
								
								<%--							<div class="form-title">--%>
								<%--								<label class="register-heading col-sm-12"> (i) Identification--%>
								<%--									(scientific name) of biological resources and its traditional--%>
								<%--									use </label>--%>
								<%--							</div>--%>

								<div class="col-sm-12 form-group less-padding">

									<label class="control-label col-sm-4"><span
										class="col-sm-1">(a)</span> <span class="col-sm-10">Used</span></label>
									<div class="col-sm-8">

										<div class=" row form-group less-padding">

											<span class="col-sm-5"> <input type="radio"
												name="accessIntention" value="Biological Resources" id="tradditional"
												onclick="showhidewithValidation(this)"
												class="istradditional radio col-sm-1"><span
												class="leftflot">&nbsp;Biological Resources</span></span> <span
												class="col-sm-5"> <input type="radio"
												name="accessIntention" value="Associated Knowledge" id="tradditional"
												onclick="showhidewithValidation(this)"
												class="istradditional radio col-sm-1"><span
												class="leftflot">&nbsp;Associated Knowledge</span>
											</span> <span class="col-sm-2"> <input type="radio"
												name="accessIntention" value="Both" id="tradditional"
												onclick="showhidewithValidation(this)"
												class="istradditional radio col-sm-1"><span
												class="leftflot">&nbsp;Both</span>
											</span>


										</div>



									</div>
								</div>


								<div class="col-sm-12 less-padding form-group">

									<label class="control-label col-sm-4"><span
										class="col-sm-1">(b)</span><span class="col-sm-10">
											Nature of biological resources</span> </label>
									<div class="col-sm-8">
										<g:each in="${natureOfReources}" var="resource">
											<input type="radio" name="nature"
												class="Associate controlclass" value="${resource}" />
											${resource}</br>
										</g:each>

									</div>
								</div>
								<div class="col-sm-12 less-padding form-group">

									<label class="control-label col-sm-4"><span
										class="col-sm-1">(c)</span> <span class="col-sm-10">
											Common Name</span> </label>
									<div class="col-sm-8">
										<input id="foucuscontrol" type="text"
											class="width controlclass  Associate" name="commonName">
									</div>

								</div>




								<div class="col-sm-12 less-padding form-group">

									<label class="control-label col-sm-4"><span
										class="col-sm-1">(d)</span> <span class="col-sm-10">
											Scientific Name</span> </label>
									<div class="col-sm-8">

										<input type="text" class="width controlclass  Associate"
											name="scientificName">

									</div>
								</div>




								<div class="col-sm-12 less-padding form-group">

									<label class="control-label col-sm-4"><span
										class="col-sm-1">(e)</span> <span class="col-sm-10">
											Part of biological resources </span> </label>
									<div class="col-sm-8">
										<g:select name="bioResource" from="${resources}" value=""
											onchange="hideshowother(this,'other')"
											class="width controlclass Associate dsblcontrol1"
											noSelection="['':'-Select-']" />

									</div>
								</div>

								<div class="col-sm-12 less-padding form-group" id="other">

									<label class="control-label col-sm-4"><span
										class="col-sm-1">(i)</span> <span class="col-sm-10">
											Please specify</span> </label>
									<div class="col-sm-8">
										<input type="text" name="pleaseSpecify" class="width" />

									</div>
								</div>

								<div class="col-sm-12 text-right form-group">
									<g:hiddenField name="appFormId" value="${appForm?.id}" />
									<g:hiddenField name="formType" value="${formType}" />
									<input type="submit"
										class="btn btn-primary disablebtn  btnclass" value="Save" />
									<input type="button" class="btn btn-primary focusbtn"
										value="Add More" />

								</div>

							</g:formRemote>
						</div>
						<div class="col-sm-12 nopadding" id="updateBioResources">
							<g:if test="${listOfBioResources}">
								<g:render
									template="/applicationManagement/biologicalResourcesGrid"
									model="[listOfBioResources:listOfBioResources,appForm:appForm]" />
							</g:if>
						</div>
						<div id="geographicalLocationForm">
							<g:render
								template="/applicationManagement/geographicalLocationForm"
								model="[newList:newList,listOfBioResources:listOfBioResources,appForm:appForm,geoLocation:geoLocation,listOfStates:listOfStates]" />
						</div>
					</div>
				</div>
				<div class="col-sm-12 nopadding" id="updateGeoLocation">
					<g:if test="${listOfLocations}">
						<g:render
							template="/applicationManagement/geographicalLocationGrid"
							model="[appForm:appForm,listOfLocations:listOfLocations]" />
					</g:if>
				</div>

				<div class="clearfix"></div>
				<g:if
					test="${appForm?.individualProfiles?.size() > 0 && appForm?.individualProfiles?.getAt(0)?.nationality == 'Non Indian' || appForm?.individualProfiles?.getAt(0)?.nationality == 'Non-Resident Indian'}">
					<div class="main-registeration col-sm-12">
						<!--login form -->
						<g:uploadForm action="saveNbaApproval" class="form-horizontal"
							role="form" autocomplete="off">
						<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	

							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-12"><span
										class="leftflot">(a)</span><span class="col-sm-11">
											Whether approval of NBA obtained to access the biological
											resources and / or associated knowledge for the said research</span></label>
									<div class="col-sm-5">
									
									  <g:if test= "${!appForm.isApprovalOfNbaObtained }">
									  		<input type="radio" name="isNbaApprovalObt" value="Yes" class="nbaApproval"
												onclick="AddValidation_Yes('nbaApprovalDiv')"> Yes &nbsp;
											<input type="radio" name="isNbaApprovalObt" class="nbaApproval"
												onclick="removeValidation_No('nbaApprovalDiv')" value="No"> No	
											
									  </g:if>
									  
									  <g:else>

										<g:if test="${appForm.isApprovalOfNbaObtained == 'true' }">
											<input type="radio" name="isNbaApprovalObt" checked="checked" class="nbaApproval"
												value="Yes" onclick="AddValidation_Yes('nbaApprovalDiv')"> Yes &nbsp; </g:if>
										<g:else>
											<input type="radio" name="isNbaApprovalObt" value="Yes"
												onclick="AddValidation_Yes('nbaApprovalDiv')"> Yes &nbsp;
										</g:else>


										<g:if test="${appForm.isApprovalOfNbaObtained == 'false' }">
											<input type="radio" checked="checked" name="isNbaApprovalObt"
												checked="checked" value="No" class="nbaApproval"
												onclick="removeValidation_No('nbaApprovalDiv')"> No </g:if>
										<g:else>
											<input type="radio" name="isNbaApprovalObt" class="nbaApproval"
												onclick="removeValidation_No('nbaApprovalDiv')" value="No"> No
										</g:else>
										
										</g:else>

									</div>


								</div>
							</div>


							<div class="col-sm-12 nbaApprovalDiv">
								<div class="form-group">
									<label class="control-label col-sm-12">(b) If yes,
										attach a copy of the NBA approval / agreement duly self
										attested</label>
									<div class="col-sm-6">
										<g:if test="${appForm?.nbaApprovalFile}">
											<input type="file" class="pdf req width validationctrl9"
												name="NBAApproval">
											<g:if test="${flash.message }">
												<span class="red"><b>
														${flash.message }
												</b></span>
											</g:if>
											<g:else>
												<g:link controller="form2" action="showDc"
													id="${appForm?.id}" target="_blank"
													params='[filename: "nbaApprovalFileName", dataName: "nbaApprovalFileName",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
													${appForm?.nbaApprovalFileName}
												</g:link>
											</g:else>
										</g:if>
										<g:else>
											<input type="file" class="width pdf req validationctrl9"
												name="NBAApproval">
											<g:if test="${flash.message }">
												<span class="red"><b>
														${flash.message }
												</b></span>
											</g:if>	
										</g:else>
									</div>
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-12">
									<g:hiddenField name="appFormId" value="${appForm?.id}" />
									<g:hiddenField name="formType" value="${formType}" />
									<button type="submit" 
										class="btn btn-primary pull-right btnctrl9">Save</button>
								</div>
							</div>
							<!--login form ends -->
						</g:uploadForm>
					</div>



					<div class="clearfix"></div>
				</g:if>

				<div class="form-group">
					<div class="col-sm-12">
						<g:if test="${appForm?.individualProfiles?.size() > 0}">
							<g:link controller="applicationManagement"
								action="individualProfile"
								params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
								class="btn btn-primary
									">Previous</g:link>
						</g:if>
						<g:else>
							<g:link controller="applicationManagement"
								action="companyProfile"
								params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
								class="btn btn-primary
									">Previous</g:link>
						</g:else>
						<g:set var="ListId1"
							value="${listOfLocations?.bioResource?.scientificName}"></g:set>
						<g:set var="ListId2" value="${newList?.scientificName}"></g:set>
						<g:if test="${(ListId1).containsAll(ListId2) == true}">
							<g:link controller="form2" action="part3"
								params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
								class="btn  btn-primary pull-right" method="POST">Next</g:link>
<%--							<a href= "#" method="POST" class="btn btn-primary pull-right" onClick="AddPointerNone(this)" >Next</a>--%>
						</g:if>
						<g:else>
<%--							<g:link controller="form2" action="part3"--%>
<%--								params="[appFormId:appForm?.id,formType:formType]"--%>
<%--								class="btn  btn-primary pull-right" method="POST"--%>
<%--								style="pointer-events:none">Next</g:link>--%>

						<a href= "#" method="POST" class="btn btn-primary pull-right" onClick="AddPointerNone(this)" >Next</a>
						</g:else>
						<br />
					</div>
				</div>

				<div class="clearfix"></div>



			</div>
		</div>
	</div>

</body>

</html>
