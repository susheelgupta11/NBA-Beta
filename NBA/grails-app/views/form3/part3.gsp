
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />
<title>NBA</title>
<script type="text/javascript">
	$(document).ready(function() {
		addCompletegreenClass(tabStatus);
		form3Part3();

	});

	

	function loadPage() {
		location.reload(true);
<%--		<g:remoteLink controller="applicationManagement" action="fetchUpdatedBioResources" update="updateGeoLocation"/>--%>
	}

	function removetxtreq1(){
			$("#rmvtxtreq").removeAttr("txtreq1")
		}
	function addtxtreq1(){
			$("#rmvtxtreq").attr("txtreq1","1")
		}
	
	
</script>

</head>

<body>
<g:javascript>
	var tabStatus = "${tabStatus}"		
	var isChecked = "${appForm?.isTraditionalKnowledgeApplicable}"
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
							<li>Payment</li>


						</ul>
					</div>
				</div>

				<div class="clearfix"></div>
				<div class="main-registeration col-sm-12">
					<div class="col-sm-12 nopadding" id="geographicalLocationForm">
						<g:render
							template="/applicationManagement/geographicalLocationForm"
							model="[appForm:appForm,formType:formType]" />
					</div>
				</div>

				<div class="clearfix"></div>
				<div class="col-sm-12 nopadding" id="updateGeoLocation">
					<g:if test="${listOfLocations}">
						<g:render
							template="/applicationManagement/geographicalLocationGrid"
							model="[appForm:appForm,formType:formType,listOfLocations:listOfLocations]" />
					</g:if>
				</div>




				<div class="main-registeration col-sm-12">
					<!--login form -->
					<g:form class="form-horizontal" role="form" action="saveConsent" autocomplete="off">
					<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-12"><span
									class="floatleft">(i)</span> <span class="col-sm-10">
										Whether any biological resources and/ or traditional knowledge
										used in the invention was obtained outside India</span></label>
								<div class="col-sm-12">
									<g:if test="${!appForm }">
									<div class="col-sm-1 less-padding">
										<input type="radio"
											name="bioResourcesObtainedFromOutsideIndia"
											class="outsideIndia ctrl" value="Yes" style="float:left"
											onclick="AddValidation_Yes('traditionalKnowledgeDesc')"><span class="leftflot"> Yes </span> 
									</div>
									<input type="radio" name="bioResourcesObtainedFromOutsideIndia"
											class="ctrl" value="No"
											onclick="removeValidation_No('traditionalKnowledgeDesc')"><span class="leftflot"> No</span>
									</g:if>
									<g:else>
										<g:if test="${appForm?.isBioObtainedOutsideIndia == 'true' }">
										<div class="col-sm-1 less-padding">
											<input type="radio"
												name="bioResourcesObtainedFromOutsideIndia" style="float:left"
												checked="checked" class="ctrl" value="Yes"
												onclick="AddValidation_Yes('traditionalKnowledgeDesc')"><span class="leftflot"> Yes </span> 
										</div>
										</g:if>
										<g:else>
										<div class="col-sm-1 less-padding">
											<input type="radio"
												name="bioResourcesObtainedFromOutsideIndia" class="ctrl" style="float:left"
												value="Yes"
												onclick="AddValidation_Yes('traditionalKnowledgeDesc')"><span class="leftflot"> Yes </span> 
										</div>
										</g:else>

										<g:if test="${appForm?.isBioObtainedOutsideIndia == 'false' }">
											<input type="radio"
												name="bioResourcesObtainedFromOutsideIndia" style="float:left"
												checked="checked" class="ctrl" value="No"
												onclick="removeValidation_No('traditionalKnowledgeDesc')"><span class="leftflot"> No</span>
										</g:if>
										<g:else>
											<input type="radio"
												name="bioResourcesObtainedFromOutsideIndia" class="ctrl" style="float:left"
												value="No"
												onclick="removeValidation_No('traditionalKnowledgeDesc')"> <span class="leftflot">No</span>
										</g:else>
									</g:else>
								</div>
							</div>
						</div>


						<div class="col-sm-12 traditionalKnowledgeDesc">
							<div class="form-group">
								<label class="control-label col-sm-12"><span
									class="floatleft">(j)</span> <span class="col-sm-10">
										Scientific name(s) and common name(s) of biological
										resource(s) used and / or details of traditional knowledge</span></label>
								<div class="col-sm-8">
									<input type="text" class="width ctrl1 req"
										name="traditionalKnowledgeDesc"
										value="${appForm?.traditionalKnowledgeDesc}">
								</div>
							</div>






							<div class="col-sm-12 form-group less-padding">
								<label class="control-label col-sm-12"><span
									class="floatleft">(k)</span> <span class="col-sm-10">
										Whether approval of the country (ies), obtained for accessing
										the biological resources and / or associated traditional
										knowledge for the said invention.</span></label>
								<div class="col-sm-12 " id="traditionalKnowledgeDesc">
									<g:if test="${!appForm }">
										<input type="radio" name="approvalOfCountriesObtained"
											class=" ctrl" value="Yes"
											onclick="AddValidation_Yes('traditionalKnowledgeDesc1')"> Yes &nbsp; 
										<input type="radio" name="approvalOfCountriesObtained"
											class=" ctrl" value="No"
											onclick="removeValidation_No('traditionalKnowledgeDesc1')"> No
											
									</g:if>
									<g:else>

										<g:if
											test="${appForm?.isApprovalOfCountryObtained == 'true' || appForm?.isBioObtainedOutsideIndia == 'false' }">
											<input type="radio" name="approvalOfCountriesObtained"
												class=" ctrl" checked="checked" value="Yes"
												onclick="removeValidation_No('traditionalKnowledgeDesc1')"> Yes
												
												<input type="radio" name="approvalOfCountriesObtained"
												class=" ctrl" value="No"
												onclick="AddValidation_Yes('traditionalKnowledgeDesc1')"> No &nbsp;
										</g:if>
										<g:elseif
											test="${appForm?.isApprovalOfCountryObtained == 'false' }">
											<input type="radio" name="approvalOfCountriesObtained"
												 class=" ctrl" value="Yes"
												onclick="removeValidation_No('traditionalKnowledgeDesc1')"> Yes &nbsp; 
												
												<input type="radio" name="approvalOfCountriesObtained"
												class=" ctrl" value="No" checked="checked"
												onclick="AddValidation_Yes('traditionalKnowledgeDesc1')"> No &nbsp;
												
											<%--<input type="radio" name="approvalOfCountriesObtained"
												class=" ctrl" value="Yes" 
												onclick="removeValidation_No('traditionalKnowledgeDesc1')"> Yes
										--%>
										</g:elseif>
										<%--<g:elseif
											test="${appForm?.isApprovalOfCountryObtained == 'close' }">
											<input type="radio" name="approvalOfCountriesObtained"
												checked="checked" class=" ctrl" value="Yes"
												onclick="AddValidation_Yes('traditionalKnowledgeDesc1')"> Yes &nbsp; 
												
												<input type="radio" name="approvalOfCountriesObtained"
												class=" ctrl" value="No"
												onclick="AddValidation_Yes('traditionalKnowledgeDesc1')"> No &nbsp;
												
											<input type="radio" name="approvalOfCountriesObtained"
												class=" ctrl" value="Yes" 
												onclick="removeValidation_No('traditionalKnowledgeDesc1')"> Yes
										
										</g:elseif>
										
										--%><g:else>

											<input type="radio" name="approvalOfCountriesObtained"
												class=" ctrl" value="Yes"
												onclick="removeValidation_No('traditionalKnowledgeDesc1')"> Yes 
												
												<input type="radio" name="approvalOfCountriesObtained"
												class=" ctrl" value="No"
												onclick="AddValidation_Yes('traditionalKnowledgeDesc1')"> No &nbsp;
										</g:else>
									</g:else>

								</div>
							</div>
						
						<div class="col-sm-12 traditionalKnowledgeDesc1">
							<div class="form-group col-sm-12 less-padding">
								<label class="control-label "><span
									class="floatleft">(l)</span> <span class="col-sm-10"> If
										no, specify the reasons thereon</span></label>
								<div >
									<input type="text" class="width ctrl1 "
										name="reasonOfDisapproval"
										value="${appForm?.reasonOfDisapproval}">
								</div>
							</div>
						</div>
</div>

						<div class="form-group">
							<div class="col-sm-12">

								<g:hiddenField name="appFormId" value="${appForm?.id}" />
								<g:hiddenField name="formType" value="${formType}" />
								<input type="submit" class="btn btn-primary pull-right btnctrl1"
									value="Save" />

							</div>
						</div>
					</g:form>
					<!--login form ends -->
				</div>


				<div class="main-registeration col-sm-12">
					<!--login form -->
					<g:form class="form-horizontal" role="form" name="tradDetails"
						action="saveTradionalKnowledge" autocomplete="off">
					<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	
						<div class="form-title col-sm-12">
							<label class="register-heading" data-toggle="tooltip"
								title="Description
									and nature of traditional knowledge used in the invention (in
									approx. 200 words)">

								<span class="floatleft">(5)</span> <span id="headingPad"
								class="col-sm-10"> Details of any traditional knowledge
									used in the invention and any identified individual / community
									holding the traditional knowledge </span>
							</label>
						</div>
						
						<br />
						<g:if test="${appForm?.isTraditionalKnowledgeApplicable == 'Applicable' }">
							<span class="col-sm-3"> <g:radio
									class="isApplicable radio col-sm-1 community"
									name="isApplicable"
									onclick="addtxtreq1()" checked="checked"
									value="Applicable" /><span class="leftflot">&nbsp; ${appForm?.isTraditionalKnowledgeApplicable}
							</span></span>
						</g:if>
						<g:else>
							<span class="col-sm-3"> <g:radio
									class="isApplicable radio col-sm-1 community"
									name="isApplicable"
									onclick="addtxtreq1()"
									id="isApplicable" value="Applicable" /><span
								class="leftflot">&nbsp; Applicable</span></span>
						</g:else>

						<g:if test="${appForm?.isTraditionalKnowledgeApplicable == 'Not applicable' }">
							<span class="col-sm-2"> <g:radio
									class=" radio col-sm-1 isNotApplicable"
									name="isApplicable" checked="checked"
									onclick="removetxtreq1()" value="Not applicable" /><span
								class="leftflot">&nbsp; ${appForm?.isTraditionalKnowledgeApplicable}</span></span>
						</g:if>
						<g:else>
							<span class="col-sm-2"> <g:radio
									class="isNotApplicable radio col-sm-1 "
									name="isApplicable" id="isNotApplicable"
									onclick="removetxtreq1()" value="Not applicable" /><span
								class="leftflot">&nbsp; Not applicable</span></span>
						</g:else>


						<div class="col-sm-12 form-group" id="ifApplicable">

							<%--								<label class="control-label col-sm-3">(a) Description--%>
							<%--									and nature of traditional knowledge used in the invention (in--%>
							<%--									approx. 200 words)</label>--%>
							<div class="col-sm-12">
								<g:textArea class="width ctrl2 " rows="3"  txtmaxword100="1" id="rmvtxtreq"
									placeholder="Please provide details in 500 words"
									name="traditionalKnowledgeUsedInInvention"
									value="${appForm?.traditionalKnowledgeUsedInInvention}"></g:textArea>

							</div>
						</div>

						<div class="col-sm-12">

							<g:hiddenField name="appFormId" value="${appForm?.id}" />
							<g:hiddenField name="formType" value="${formType}" />
							<input type="submit" class="btn btn-primary pull-right btnctrl2"
								Value="Save" />

						</div>
					</g:form>
					<!--login form ends -->
				</div>


				<div class="clearfix"></div>
				<div class="main-registeration col-sm-12"
					id="geoLocationOfCommunityForm">
					<div class="col-sm-12 nopadding" id="geoLocationOfCommunityForm">
						<g:render
							template="/applicationManagement/geoLocationOfCommunityForm"
							model="[appForm:appForm,formType:formType]" />
					</div>
				</div>



				<div class="clearfix"></div>
				<div class="col-sm-12 nopadding" id="updateCommunityLocations">
					<g:if test="${listOfCommunityLocations}">
						<g:render template="/applicationManagement/geoLocationOfCommunity"
							model="[listOfCommunityLocations:listOfCommunityLocations,formType:formType,appForm:appForm]" />
					</g:if>
				</div>
				<div class="main-registeration col-sm-12">
					<g:form class="form-horizontal" role="form" autocomplete="off"
						action="saveInstituteDetails">
					<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	
						<div class="form-title">
							<label class="register-heading col-sm-12"> <span
								class="floatleft">(6)</span><span id="headingPad"
								class="col-sm-10"> Details of institution where Research
									and Development activities carried out</span>
							</label>
						</div>

						<div >
							<div class="col-sm-12">
								<div class="form-group">
									
									<div class="col-sm-12">

										<g:textArea class="width txtreq ctrl4" 
											name="detailsOfInstitute"
											placeholder="Provide the name and contact details of the institution / organisation"
											id="detailsOfInstitute"
											value="${appForm?.detailsOfInstitute}"></g:textArea>
									</div>
								</div>
							</div>

						</div>




						<div class="form-title">
							<label class="register-heading col-sm-12"><span
								class="floatleft"></span><span class="floatleft"> (7)</span><span
								id="headingPad" class="col-sm-11"> Details of economic,
									biotechnological, scientific or any other benefits that are
									intended, or may accrue to the applicant due to
									commercialization of the invention </span></label>
						</div>


						<div class="col-sm-12">
							<div class="form-group">
								<div class="col-sm-12">
									<g:textArea class="width ctrl4 " txtreq1="1" rows="4" txtmaxword100="1" onkeyup="txtareawordcount(this)"
										PlaceHolder="Provide the details in 500 words"
										name="benefitsToTheApplicant"
										value="${appForm?.benefitsToTheApplicant}"></g:textArea>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-12 text-right">
								<g:hiddenField name="appFormId" value="${appForm?.id}" />
								<g:hiddenField name="formType" value="${formType}" />
								<g:hiddenField name="isNoForTraditional" id="isNoForTraditional" />
								<input type="submit" class="btn btn-primary btnctrl4"
									id="form3part3Submit" value="Save" />






							</div>
						</div>

					</g:form>
					<!--login form ends -->
				</div>


				<g:link controller="form3" action="part2"
					params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
					class="btn btn-primary ">Previous</g:link>

				<g:set var="ListId1"
					value="${listOfLocations?.bioResource?.scientificName}"></g:set>
				<g:set var="ListId2" value="${newList?.scientificName}"></g:set>

				<g:if
					test="${(appForm?.isDeclarationDigitallySigned == 'true' || appForm?.isDeclarationDigitallySigned == 'notDigital') && ListId1?.size() != 0 && (ListId1).containsAll(ListId2) == true}">
					<g:link controller="applicationManagement" action="form1Part5"
						class="btn btn-primary pull-right" method="POST"  
						params='[appFormId:appForm?.id,formType:formType,declaration:"declaration",csrfPreventionSalt:"${csrfPreventionSalt}" ]'>Next</g:link>
				</g:if>
				<g:elseif
					test="${(!appForm?.isDeclarationDigitallySigned || appForm?.isDeclarationDigitallySigned == null) && (ListId1).containsAll(ListId2) == true}">
					<g:link controller="applicationManagement" action="form1Part5"
						class="btn btn-primary pull-right" method="POST"  
						params='[appFormId:appForm?.id,formType:formType,declaration:"declaration",csrfPreventionSalt:"${csrfPreventionSalt}"]'>Next</g:link>
				</g:elseif>
				<g:elseif test="${(ListId1).containsAll(ListId2) == false}">
<%--					<g:link controller="applicationManagement" action="form1Part5"--%>
<%--						method="POST" class="btn btn-primary pull-right"--%>
<%--						 onClick="AddPointerNone(this)"--%>
<%--						params="[appFormId:appForm?.id,formType:formType]">Next</g:link><br/>--%>

						<a href= "#" method="POST" class="btn btn-primary pull-right" onClick="AddPointerNone(this)" >Next</a>
					
						 
						
						
						
						
				</g:elseif>
				<g:else>
<%--					<g:link controller="applicationManagement" action="form1Part5"--%>
<%--						method="POST" class="btn btn-primary pull-right"--%>
<%--						 onClick="AddPointerNone(this)"--%>
<%--												params="[appFormId:appForm?.id,formType:formType]">Next</g:link><br/>--%>
					
						<a href= "#" method="POST" class="btn btn-primary pull-right" onClick="AddPointerNone(this)" >Next</a>		
				</g:else>


				<div class="clearfix"></div>

			</div>
		</div>
	</div>
	<!-- /.container -->


</body>

</html>
