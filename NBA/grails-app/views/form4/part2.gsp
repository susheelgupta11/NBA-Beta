
<!DOCTYPE html>
<html lang="en">

<head>

<meta name='layout' content='loggedInUser' />
<title>NBA</title>

<script type="text/javascript">
	$(document).ready(function() {
		addCompletegreenClass(tabStatus);
		form4Part2();
	});
	function clearAll() {
		$("#iprDetails")[0].reset();
	}
	function loadPage() {
		location.reload(true);
	}
</script>
</head>

<body>
	<g:javascript>	  
	var appFormId= "${appForm?.id}"	
	var declaration= "${declaration }"
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

							<li class="next">Part 2</li>

							<li class="#">Part 3</li>
							<li class="#">Part 4</li>
							<li>Preview</li>
							<li class="#">Payment</li>


						</ul>
					</div>
				</div>
				
				<div class="clearfix"></div>
				<div class="col-sm-12 nopadding">
					<div class="main-registeration col-sm-12" id="AddUpdateDetails">
						<div class="form-title">
							<label class="register-heading col-sm-12"> (2) Details of
								the biological material and traditional knowledge accessed </label>
						</div>
						<g:formRemote name="biologicalResources" class="form-horizontal"
							role="form" autocomplete="off"
							url="[controller:'applicationManagement',action:'saveBiologicalResources']"
							update="updateBioResources" onSuccess="ClearAllFields()"
							onComplete="loadPage()">
						<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	
							<div class="col-sm-12 form-group">
							<label class="control-label col-sm-4">(a) Intend to transfer</label>
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
							<div class="col-sm-12 form-group">
								
									<label class="control-label col-sm-4">(b) Nature of
										biological resources</label>
									<div class="col-sm-8">
										<g:each in="${natureOfReources}" var="resource">
											<input type="radio" name="nature" value="${resource}" class="controlclass  Associate" />
											${resource}<br/>
										</g:each>
									</div>
								
							</div>
							<div class="col-sm-12 form-group">
								
									<label class="control-label col-sm-4">(c) Common Name</label>
									<div class="col-sm-8">
										<input id="foucuscontrol" type="text" class="width controlclass  Associate"
											 name="commonName">
									</div>
								
							</div>




							<div class="col-sm-12 form-group">
								
									<label class="control-label col-sm-4">(d) Scientific
										Name</label>
									<div class="col-sm-8">

										<input type="text" class="width controlclass  Associate" 
											name="scientificName">
									</div>
								
							</div>




							<div class="col-sm-12 form-group">
								
									<label class="control-label col-sm-4">(e) Part of
										biological resources </label>
									<div class="col-sm-8">
										<g:select name="bioResource" from="${resources}" value="" onchange="hideshowother(this,'other')"
											class="width controlclass  Associate dsblcontrol1" noSelection="['':'-Select-']" req1="1" />

									</div>								
							</div>
							
							<div id="other" class="col-sm-12 form-group">
								
									<label class="control-label col-sm-4">(i)Please specify</label>
									<div class="col-sm-8">

										<input type="text" class="width" 
											name="pleaseSpecify">
									</div>
								
							</div>

							<div class="col-sm-12 form-group">
								
									<label class="control-label col-sm-4">(f) Quantity of
										the biological resource to be transferred </label>
									<div class="col-sm-3">
										<input type="text" class="width controlclass  Associate" name="quantity"
											req1="1" num1="1">
									</div>
									<div class="col-sm-3">
										<g:select name="qtyUnit" from="${quantityList}" value=""
											class="width controlclass  Associate dsblcontrol1" noSelection="['':'-Select-']" req1="1" />
									</div>
								
							</div>
							<div class="col-sm-12 form-group">
								
									<label class="control-label col-sm-12">(g) Details of
										associated traditional knowledge proposed to be transferred. </label>
									<div class="col-sm-12">
										<g:textArea class="width controlclass"
											placeHolder="Provide details in 500 words" txtreq1="1" rows="4"
											txtmaxword100="1" name="bioResouceTraditionalKnowledge"
											value=""></g:textArea>
									</div>
								
							</div>
							
							<div class="col-sm-12 form-group text-right">
								<g:hiddenField name="appFormId" value="${appForm?.id}" />
								<g:hiddenField name="formType" value="${formType}" />

								<input type="submit" class="btn  btn-primary disablebtn  btnclass"
									Value="Save" /> <input type="button"
									class="btn btn-primary focusbtn" value="Add More" />

							</div>
						</g:formRemote>
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
				<div class="main-registeration col-sm-12">
					<!--login form -->
					<g:uploadForm class="form-horizontal" role="form" autocomplete="off"
						action="savePart2">
					<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	

						<div class="form-title">
							<label class="register-heading col-sm-12"> (3) Details of
								the access contract entered <i style="font-size: 15px">(copy
									to be enclosed)</i>
							</label>
						</div>


						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-4">(a) Attach a copy
									of approval of NBA (agreement) for access</label>
								<div class="col-sm-8">
									<g:if test="${appForm?.nbaApprovalFile || appForm?.nbaApprovalFileURL}">
										<input type="file" class="width ctrl1" name="NBAApproval">
										<g:if test="${flash.message }">
											<span class="red"><b>
													${flash.message }
											</b></span>
										</g:if>
										<g:else>
											<g:link controller="form4" action="showDc"
												id="${appForm?.id}" target="_blank"
												params='[filename: "nbaApprovalFileName", dataName: "nbaApprovalFileName", nbaApprovalPart2:"part2",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
												${appForm?.nbaApprovalFileName}
											</g:link>
										</g:else>
									</g:if>
									<g:elseif test="${!appForm?.nbaApprovalFile}">
										<input type="file" class="width ctrl1" name="NBAApproval"
											req1="1" pdf1="1" />
											<g:if test="${flash.message }">
											<span class="red"><b>
													${flash.message }
											</b></span>
										</g:if>
									</g:elseif>
								</div>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-4">Application Number</label>
								<div class="col-sm-8">
									<input type="text" class="width ctrl1" req1="1"
										name="applicationNo" value="${appForm?.applicationNo}">
								</div>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-4">Date of approval</label>
								<div class="col-sm-8">
									<input type="text" class="width ctrl1" req1="1" dob1="1"
										name="dateOfApproval" id="datePicker"
										value="${appForm?.dateOfApproval?.format('dd/MM/yyyy')}">
								</div>
							</div>
						</div>



						<div class="form-title">
							<label class="register-heading col-sm-12"> (4) Details of
								the benefits and mechanism/ arrangements for benefit sharing
								already implemented </label>
						</div>


						<div class="col-sm-12 form-group">

							<div class="col-sm-8 g">
							
							<g:if test= "${!appForm?.isbenefitSharingDetailImplemented}">
									<input type="radio" name="isbenefitSharingDetailImplemented" onclick="AddValidation_Yes4('AgreementMOU')"
										class="radio leftflot" value="Yes">
									<span class="leftflot"> Yes &nbsp; </span>
									<input type="radio" name="isbenefitSharingDetailImplemented" onclick="removeValidation_No4('AgreementMOU')"
										class="radio leftflot" value="No">
									<span class="leftflot">No</span>
							</g:if>
							
							<g:else>
								<g:if test="${appForm?.isbenefitSharingDetailImplemented == 'true'}">
									<input type="radio" name="isbenefitSharingDetailImplemented" onclick="AddValidation_Yes4('AgreementMOU')"
										class="radio leftflot" value="Yes" checked= "checked">
									<span class="leftflot"> Yes &nbsp; </span></g:if>
								<g:else>
									<input type="radio" name="isbenefitSharingDetailImplemented" onclick="AddValidation_Yes4('AgreementMOU')"
										class="radio leftflot" value="Yes" >
									<span class="leftflot"> Yes &nbsp; </span>
								</g:else>
								
								<g:if test= "${appForm?.isbenefitSharingDetailImplemented == 'false' }">
									<input type="radio" name="isbenefitSharingDetailImplemented" onclick="removeValidation_No4('AgreementMOU')"
										class="radio leftflot" checked= "checked" value="No">
									<span class="leftflot">No</span></g:if>
								<g:else>
									<input type="radio" name="isbenefitSharingDetailImplemented" onclick="removeValidation_No4('AgreementMOU')"
										class="radio leftflot" value="No">
									<span class="leftflot">No</span>
								</g:else>
									
								</g:else>
								

							</div>

						</div>

						<div class="col-sm-12 AgreementMOU">
							<div class=" col-sm-12">


								<g:textArea class="width txtreqc1 txtmaxword100 ctrl1"
									name="benefitMechanism" value="${appForm?.benefitMechanism}"
									placeHolder="Provide details in 500 words" rows="5"></g:textArea>

								<div class="col-sm-12">
									<g:if test="${appForm?.mouFile}">
										
										<g:link controller="form3" action="showDc" id="${appForm?.id}"
											target="_blank"
											params="[filename: 'mouFileName', dataName: 'mouFileName',csrfPreventionSalt:'${csrfPreventionSalt}']">
											${appForm?.mouFileName}
										</g:link>
									</g:if>
									<g:else>
										<%--										<input type="file" class="width ctrl1" req1="1" pdf1="1" name="MOUFile" />--%>
									</g:else>
								</div>
							</div>
						</div>


						<div class="form-group">
							<div class="col-sm-12 text-right">
								<g:hiddenField name="appFormId" value="${appForm?.id}" />
								<g:hiddenField name="formType" value="${formType}" />
								<input type="submit" class="btn  btn-primary btnctrl1"
									Value="Save" />

							</div>
						</div>
					</g:uploadForm>
					<!--login form ends -->
				</div>

				<div class="">
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


				<g:link controller="form4" action="part3"
					params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
					class="btn  btn-primary pull-right">Next
							</g:link>
	</div>
			</div>
			
		</div>
		
	</div>
	
	<!-- /.container -->
	<div class="clearfix"></div>

</body>

</html>
