
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />
<title>NBA</title>
<script type="text/javascript">

		
	$(document).ready(function() {
		addCompletegreenClass(tabStatus);
		form3Part2();
		$(".showIfApprovalNotObtained").hide();
		showReason();
	});

	function showReason(){

		if(isApprovalOfNbaObtainedForm3 == 'false'){
			$(".showIfApprovalNotObtained").show();
			}
		else if(isApprovalOfNbaObtainedForm3 == 'true'){
			$(".showIfApprovalNotObtained").hide();
			}
		}

	function clearAll() {

		//$("input[type=text]").val("");
		$("#patentAppNo").val("");
		$("#patentAppDate").val("");
		$("textarea").val("");
		$('select').prop('selectedIndex', 0);
		$('input[type=radio]').removeAttr('checked');
		$("input[name='patentNo']").val("");
		$("input[name='patentDate']").val("");
		//$("input[type='hidden'").val("");
	}
	function loadPage() {
		location.reload(true);
<%--		<g:remoteLink controller="applicationManagement" action="fetchUpdatedBioResources" update="updateGeoLocation"/>--%>
	}
</script>
</head>

<body>
<g:javascript>
	var tabStatus = "${tabStatus}"	
	var isApprovalOfNbaObtainedForm3 = "${appForm?.isApprovalOfNbaObtainedForm3 }" 
  </g:javascript>
	<!-- Page Content -->
	<div class="container">
		<div class="row">

			<div id="leftTopTab" class="col-sm-2">
				<g:render template="/applicationManagement/leftTabs"
					model="[formType:formType,appFormId:appFormId]" />
			</div>
			<div class="col-sm-10">
				<div class="col-sm-12">
					<div class="checkout-wrap">
						<ul class="checkout-bar">

							<li class="active"><a href="#">Part 1</a></li>

							<li>Part 2</li>

							<li class="next">Part 3</li>

							<li class="">Part 4</li>
							<li>Preview</li>
							<li>Payment</li>


						</ul>
					</div>
				</div>
				<div class="clearfix"></div>
				<div class="main-registeration col-sm-12" >
					<g:form name="iprDetailsPart2" id="iprDetails"
						class="form-horizontal" role="form" autocomplete="off"
						url="[controller:'form3',action:'savePart2']">
					<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>

						<div class="form-title">
							<label class="register-heading col-sm-12"> (2) Details of
								Invention on which IPRs sought </label>
						</div>
						<div>
							<div class="col-sm-12 form-group less-padding "
								style="padding-top: 15px;">

								<label class="control-label col-sm-4 "><span
									class="col-sm-1">(a)</span> <span class="col-sm-10">Title
										of the invention</span></label>
								<div class="col-sm-8">
									<input id="foucuscontrol1" type="text" class="width ctrl1 "
										name="title" req1="1" value="${appForm?.titleOfIPR}" />
								</div>

							</div>

							<div class="col-sm-12 form-group less-padding ">

								<label class="control-label col-sm-4 "><span
									class="col-sm-1">(b)</span> <span class="col-sm-10">
										Abstract of the invention </span></label>
								<div class="col-sm-8">
									<g:textArea class="width ctrl1"  name="abstractOfIPR" txtreq1="1" txtmaxword200="1" value="${appForm?.abstractOfIPR}"></g:textArea>

								</div>
							</div>
							
							<div class="col-sm-12 form-group less-padding">

								<label class="control-label col-sm-4"><span
									class="col-sm-1"> (c)</span> <span class="col-sm-10">
										Details of territories / patent offices where the applicant
										intends to apply for the present invention</span> </label>
								<div class="col-sm-4" style="overflow: scroll; max-height: 250px;">
									<%--<g:select name="detailsOfTerritories" from="${listOfcountries}"
				optionKey="id" optionValue="country" smultiple="true"
				value="${ipr?.detailsOfTerritories?.id}"
				class="width  country ctrl1" req1="1" noSelection="['':'-Select-']" />

			<g:each in="${listOfcointries}" var="country">
				<g:checkBox name="detailsOfTerritories" value=""/>${ country?.country}
			</g:each>--%>

									<g:each in="${countryMap}" var="countryKeyValue">
										<g:if test="${countryKeyValue?.value}">
											<span class="bold"><g:checkBox 
												name="detailsOfTerritories" class="territories ctrl1"
												onclick="GelAllcheckedvalue(this)" chkreq1="1"
												checked="true"
												value="${countryKeyValue?.key?.country}" 
												/> ${countryKeyValue?.key?.country} </span>
											<br />
										</g:if>
										<g:else>
											<span class="bold"><g:checkBox 
												name="detailsOfTerritories" class="territories ctrl1" chkreq1="1"
												onclick="GelAllcheckedvalue(this)"
												value="${countryKeyValue?.key?.country}"  checked="false"/> ${countryKeyValue?.key?.country}</span>
											<br />
										</g:else>

									</g:each>

								</div>
								<div id="setcountry" class="col-sm-4"

									style="overflow:auto; height: 250px;">
									<span class="text-right red ">${msg}</span>
									<g:each in="${countryMap}" var="countryKeyValue">
										<g:if test="${countryKeyValue?.value}">
											<span class="bold text-primary">${countryKeyValue?.key?.country}</span>
											<br />
										</g:if>
									</g:each>
									</div>


							</div>

							<%--<div class="col-sm-12 form-group">
								<div id="setcountry" class="col-sm-5 col-sm-offset-4"
									style="overflow: scroll; min-height: 20px;"></div>
							</div>


						--%></div>
						<div class="col-sm-12 form-group less-padding text-right">

							<g:hiddenField name="appFormId" value="${appForm?.id}" />
							<g:hiddenField name="formType" value="${formType}" />

							<input type="submit" class="btn btn-primary  btnctrl1"
								value="Save"><%-- <input type="button"
								class="btn btn-primary focusbtn1" value="Add More">
						--%></div>
					</g:form>
				</div>
				<div class="main-registeration col-sm-12" id="iprDetailForm">
					<!--login form -->
					<g:render template="iprDetailsForm"
						model='[appForm:appForm,formType:formType,ipr:ipr,listOfStatuses:listOfStatuses,csrfPreventionSalt:"${csrfPreventionSalt}"]' />
					<!--login form ends -->
				</div>

				<div class="col-sm-12 nopadding" id="updateIprDetails">
					<g:if test="${listOfIprDetails}">
						<g:render template="iprDetailsGrid"
							model="[listOfIprDetails:listOfIprDetails,appForm:appForm,formType:formType]" />
					</g:if>
				</div>

				<div class="clearfix"></div>
				<div class="col-sm-12 nopadding">
					<div class="main-registeration col-sm-12" id="AddUpdateDetails">
						<!--login form -->
						<label class="register-heading col-sm-12"> (3) Details of
							biological resources and/ or associated knowledge used in the
							invention </label>
						<g:formRemote name="biologicalResources" class="form-horizontal"
							role="form" onComplete="loadPage()" autocomplete="off"
							url="[controller:'applicationManagement',action:'saveBiologicalResources']"
							update="updateBioResources" onSuccess="ClearAllFields()">
						<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	

							<div class="col-sm-12 form-group less-padding">

								<label class="control-label col-sm-4"><span
									class="col-sm-1">(a)</span> <span class="col-sm-10">
										Accessed</span></label>


								<div class="col-sm-8">
									<div class=" row form-group less-padding">
										<span class="col-sm-5"> 
										<input type="radio"
											name="accessIntention" value="Biological Resources" id="tradditional" style="float:left"
											onclick="showhidewithValidation(this)"
											class="istradditional radio"><span
											class="leftflot">&nbsp;Biological Resources</span></span> 
											
											<span
											class="col-sm-5"> <input type="radio"
											name="accessIntention" value="Associated Knowledge" id="tradditional" style="float:left"
											onclick="" class="istradditional radio "><span
											class="leftflot">&nbsp;Associated Knowledge</span>
										</span> 
										
										<span class="col-sm-2"> <input type="radio"
											name="accessIntention" value="Both" id="tradditional" style="float:left"
											onclick="showhidewithValidation(this)"
											class="istradditional radio "><span
											class="leftflot">&nbsp;Both</span>
										</span>
									</div>
								</div>

							</div>


							<div class="col-sm-12 form-group less-padding">

								<label class="control-label col-sm-4"><span
									class="col-sm-1">(b)</span> <span class="col-sm-10">
										Nature of biological resources</span></label>
								<div class="col-sm-8">
									<g:each in="${natureOfReources}" var="resource">
										<input type="radio" name="nature" value="${resource}"
											class="Associate controlclass" />
										${resource}<br />
									</g:each>
								</div>

							</div>

							<div class="col-sm-12 form-group less-padding">

								<label class="control-label col-sm-4"><span
									class="col-sm-1">(c)</span> <span class="col-sm-10">
										Common Name</span></label>
								<div class="col-sm-8">
									<input id="foucuscontrol" type="text"
										class="width controlclass  Associate"
										value="${bioResourceInst?.commonName}" name="commonName"
										req1="1">
								</div>

							</div>




							<div class="col-sm-12 form-group less-padding">

								<label class="control-label col-sm-4"><span
									class="col-sm-1">(d)</span> <span class="col-sm-10">
										Scientific Name</span></label>
								<div class="col-sm-8">

									<input type="text" class="width controlclass  Associate"
										name="scientificName">
								</div>

							</div>




							<div class="col-sm-12 form-group less-padding">

								<label class="control-label col-sm-4"><span
									class="col-sm-1">(e) </span> <span class="col-sm-10">Part
										of biological resources </span></label>
								<div class="col-sm-8">
									<g:select name="bioResource" from="${resources}" value=""
										onchange="hideshowother(this,'other')"
										class="width controlclass  Associate dsblcontrol1"
										noSelection="['':'-Select-']" />

								</div>

							</div>
							<div id="other" class="col-sm-12 form-group less-padding">

								<label class="control-label col-sm-4"><span
									class="col-sm-1">(i)</span> <span class="col-sm-10">
										Please specify</span></label>
								<div class="col-sm-8">

									<input type="text" class="width" name="pleaseSpecify">
								</div>

							</div>



							<div class="col-sm-12 form-group text-right">
								<g:hiddenField name="appFormId" value="${appForm?.id}" />
								<g:hiddenField name="formType" value="${formType}" />
								<input type="submit" class="btn  btn-primary   btnclass"
									value="Save"> <input type="button"
									class="btn btn-primary focusbtn" value="Add more" />
							</div>

						</g:formRemote>
						<!--login form ends -->
					</div>
				</div>
				<div class="col-sm-12 nopadding" id="updateBioResources">
					<g:if test="${listOfBioResources}">
						<g:render
							template="/applicationManagement/biologicalResourcesGrid"
							model="[listOfBioResources:listOfBioResources]" />
					</g:if>
				</div>
				<div class="clearfix"></div>
				<g:if test="${appForm?.individualProfiles?.size() > 0 && appForm?.individualProfiles?.getAt(0)?.nationality == 'Non Indian' || 
					appForm?.individualProfiles?.getAt(0)?.nationality == 'Non-Resident Indian' || appForm?.companyProfiles?.getAt(0)?.nationality == 'notRegisteredInIndia' ||
					 appForm?.companyProfiles?.getAt(0)?.nationality == 'registeredInIndia' }" 
					>
					<div class="main-registeration col-sm-12">
						<!--login form -->
						<g:uploadForm action="saveNbaApprovalDetails" autocomplete="off"
							class="form-horizontal" role="form">
						<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	

							<div class="col-sm-12 form-group ">

								<label class="control-label col-sm-12"> <span
									class="leftflot">(f)</span> <span class="col-sm-11">
										Whether approval of NBA obtained to access the biological
										resources and / or associated knowledge used in the invention</span></label>
								<div class="col-sm-12">
									<div class=" margin-top">
										<g:if test="${!appForm?.isApprovalOfNbaObtainedForm3 }">
											<input type="radio" name="isApprovalOfNbaObtained"
												class="leftflot" value="Yes"
												onclick="AddValidation_Yes('hideform3')">
											<span class="leftflot"> Yes &nbsp; </span>
											<input type="radio" name="isApprovalOfNbaObtained"
												onclick="removeValidation_No('hideform3')" class="leftflot"
												Value="No"> No
										</g:if>
										<g:else>
											<g:if test="${appForm.isApprovalOfNbaObtainedForm3 == 'true' }">
												<input type="radio" name="isApprovalOfNbaObtained"
													class="leftflot" checked="checked" value="Yes"
													onclick="AddValidation_Yes('hideform3')">
												<span class="leftflot"> Yes &nbsp; </span>
											</g:if>
											<g:else>
												<input type="radio" name="isApprovalOfNbaObtained"
													class="leftflot" value="Yes"
													onclick="AddValidation_Yes('hideform3')">
												<span class="leftflot"> Yes &nbsp; </span>
											</g:else>

											<g:if
												test="${appForm.isApprovalOfNbaObtainedForm3 == 'false' }">
												<input type="radio" name="isApprovalOfNbaObtained"
													checked="checked" class="leftflot" Value="No"
													onclick="removeValidation_No('hideform3')"> No
											</g:if>
											<g:else>
												<input type="radio" name="isApprovalOfNbaObtained"
													class="leftflot" Value="No"
													onclick="removeValidation_No('hideform3')"> No
											</g:else>
										</g:else>
									</div>
									<br/>
									<div class="col-sm-12 form-group hideform3">
										<div class=" form-group">
											<label class="col-sm-4">Application number </label>
											<div class="col-sm-8">
												<input type="text" class="width ctrl2 req" name="appNo"
													value="${appForm?.applicationNo}" />
											</div>
										</div>


										<div class="form-group hideform3 ">
											<label class="col-sm-4">Date of Approval </label>
											<div class="col-sm-8">
												<input type="text" class="width ctrl2 datePicker req"
													name="approvalDate" readonly="readonly"
													value="${appForm?.dateOfApproval?.format('dd/MM/yyyy')}" />
											</div>
										</div>

									</div>
								</div>
							</div>


							<div id="" class="col-sm-12 hideform3 form-group ">

								<label class="control-label col-sm-4"> Attach a copy of
									the NBA approval / agreement duly self attested</label>
								<div class="col-sm-7 less-padding">
									<g:if test="${appForm?.nbaApprovalFile || appForm?.nbaApprovalFileURL}">
										<input type="file" class="width ctrl2 pdf" name="NBAApproval">
										<g:if test="${flash.message }">
											<span class="red"><b>
													${flash.message }
											</b></span>
										</g:if>
										<g:else>
											<g:link controller="form3" action="showDc"
												id="${appForm?.id}" target="_blank"
												params='[filename: "nbaApprovalFileName", dataName: "nbaApprovalFileName",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
												${appForm?.nbaApprovalFileName}
											</g:link>
										</g:else>
									</g:if>
									<g:else>
										<input type="file" class="width ctrl2 pdf" name="NBAApproval">
										<g:if test="${flash.message }">
											<span class="red"><b>
													${flash.message }
											</b></span>
										</g:if>
									</g:else>

								</div>
								</div>
								
								<div class="col-sm-12 form-group showIfApprovalNotObtained">
												<label class="control-label col-sm-4">Please specify the reason for not obtaining the prior approval of NBA </label>
												<div class="col-sm-8">
													<g:textArea class="width" id="approvalNotObtained"  name="reasonOFNotObtainedApproval" txtreq1="1" txtmaxword500="1" value="${appForm?.reasonOFNotObtainedApproval}"></g:textArea>
											</div>
									</div>
								
								
								
								
								<div class="form-group">
									<div class="col-sm-12 form-group text-right">
										<g:hiddenField name="appFormId" value="${appForm?.id}" />
										<g:hiddenField name="formType" value="${formType}" />
										<input type="submit" class="btn  btn-primary btnctrl2 btnctrlabc " 
											Value="Save" />
									</div>
								</div>
							


						</g:uploadForm>
						<!--login form ends -->

					</div>
				</g:if>
				<g:if test="${appForm?.individualProfiles?.size() > 0}">
					<g:link controller="applicationManagement"
						action="individualProfile"
						params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
						class="btn btn-primary
									">Previous</g:link>
				</g:if>
				<g:else>
					<g:link controller="applicationManagement" action="companyProfile"
						params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
						class="btn btn-primary
									">Previous</g:link>
				</g:else>
				<g:link controller="form3" action="part3"
					params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
					class="btn btn-primary pull-right">Next
							</g:link>


				<div class="clearfix"></div>


			</div>
		</div>
		<!-- /.container -->
		<div class="clearfix"></div>
	</div>
</body>

</html>
								
									
