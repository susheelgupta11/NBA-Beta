
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />
<title>NBA</title>
<script type="text/javascript">
	$(function() {
		addCompletegreenClass(tabStatus);
		form4Part3(appFormId);		
	});
</script>
</head>

<body>

<g:javascript>
	var appFormId= "${appForm?.id}"  
	var tabStatus = "${tabStatus}"
  </g:javascript>
  
	<!-- Page Content -->
	<div class="container ">
		<div class="row">
			<div id="leftTopTab" class="col-sm-2">
				<g:render template="/applicationManagement/leftTabs"
					model="[formType:formType,appFormId:appForm?.id]" />
			</div>

			<div class="col-sm-10">
				<div class="col-sm-12">
					<div class="checkout-wrap">
						<ul class="checkout-bar">
							<li class="previous visited first"><a href="#">Part 1</a></li>

							<li class="active">Part 2</li>

							<li class="next">Part 3</li>
							<li>Part 4</li>
							<li>Preview</li>
							<li>Payment</li>


						</ul>
					</div>
				</div>

				<div class="clearfix"></div>
				<%--				<g:formRemote controller="form4" action="savePart3" class="form-horizontal" role="form">--%>
				
				<g:formRemote name="thirdParty" class="form-horizontal" role="form"
					url="[controller:'form4',action:'saveThirdParty']" autocomplete="off"
					update="thirdPartyGrid" onSuccess="ClearAllFields()"
					onComplete="loadPage()">
				<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	

					<div class="main-registeration col-sm-12" id="thirdPartyForm">
						<div class="form-title">
							<label class="register-heading col-sm-12"> (5) Full
								particulars of the third party to whom the accessed material /
								knowledge is intended to be transferred </label>
						</div>


						<div class="col-sm-12">
							<div class="form-group">
						<g:if test= "${thirdPartyInst }">
							<g:if test= "${thirdPartyInst?.isIndividual == true }">
								<span class="col-sm-3"> 
								<input type="radio" name="indivOrEntity" checked= "checked" style="float:left;"
									value="Individual" /><b class="leftflot"> &nbsp; Individual</b> </span>
							</g:if>	
							<g:else>
								<span class="col-sm-3"> 
								<input type="radio" name="indivOrEntity"  style="float:left;"
									value="Individual" /><b class="leftflot">&nbsp; Individual</b> </span>
							</g:else>
							<g:if test= "${thirdPartyInst?.isIndividual == false }">
								 <span class="col-sm-3"> <input type="radio" name="indivOrEntity" style="float:left;"
									value="Entity" checked= "checked" /><b class="leftflot">&nbsp; Entity</b>
								</span>
							</g:if>
							<g:else>
								<span class="col-sm-3"> <input type="radio" name="indivOrEntity" style="float:left;"
									value="Entity" /><b class="leftflot">&nbsp; Entity</b>
								</span>
							</g:else>
						</g:if>	
						<g:else>
							<span class="col-sm-3"> 
								<input type="radio" name="indivOrEntity"  style="float:left;"
									value="Individual" /><b class="leftflot">&nbsp; Individual</b> </span>
							<span class="col-sm-3"> <input type="radio" name="indivOrEntity" style="float:left;"
									value="Entity" /><b class="leftflot">&nbsp; Entity</b>
								</span>
						</g:else>
							</div>
						</div>


						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-4">(a) Name</label>
								<div class="col-sm-8">
									<input type="text" class="width ctrl" name="detailsOfInstitute" req1="1"
										 value="${thirdPartyInst?.name}" />
								</div>
							</div>
						</div>


						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-4">(b) Address for
									communication</label>
								<div class="col-sm-8">
									<input type="text" class="width ctrl"  req1="1"
										name="instituteAddress" value="${thirdPartyInst?.addressForComm}" />
								</div>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-4">(c) State /
									Province</label>
								<div class="col-sm-8">
									<input type="text" class="width ctrl"  req1="1"
										name="state" value="${thirdPartyInst?.state}" />
								</div>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-4">(d) Zip / Pin Code</label>
								<div class="col-sm-8">
									<input type="text" class="width ctrl" req1="1"
										name="pincode" value="${thirdPartyInst?.pincode}" />
								</div>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-4">(e) Country</label>
								<div class="col-sm-8">

									<g:select name="country" from="${listOfCountries}"
										optionKey="id" optionValue="country"
										value="${thirdPartyInst?.id}" class="width ctrl" req1="1"
										noSelection="['':'-Select-']"  />
								</div>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-4">(f) Telephone </label>
								<div class="col-sm-8">
									<input type="text" class="width ctrl"  name="phone" req1="1"
										value="${thirdPartyInst?.phone}" />
								</div>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-4">(g) Fax </label>
								<div class="col-sm-8">
									<input type="text" class="width ctrl" name="fax" req1="1"
										value="${thirdPartyInst?.fax}" />
								</div>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-4">(h) Website</label>
								<div class="col-sm-8">
									<input type="text" class="width ctrl" name="website" req1="1"
										value="${thirdPartyInst?.website}" />
								</div>
							</div>
						</div>


						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-4">(i) Email </label>
								<div class="col-sm-8">
									<input type="text" class="width ctrl" name="email" req1="1" email1="1"
										value="${thirdPartyInst?.email}" />
								</div>
							</div>
						</div>

						<div class="form-group col-sm-12 text-right">
							<g:hiddenField name="formType" value="${formType}" />
							<g:hiddenField name="appFormId" value="${appForm?.id}" />
							<g:hiddenField name="thirdPartyInstId" value="${thirdPartyInst?.id}" />
							<input type="submit" class="btn btn-primary btnctrl"
								value="Save"></input> 
							<input type="button"
								class="btn btn-primary focusbtn" value="Add More"></input>
						</div>

						<!--login form ends -->
					</div>
				</g:formRemote>
				
				<div id ="thirdPartyGrid"  class="table-responsive col-sm-12 nopadding">
				<g:if test="${listOfThirdParty}">
				<g:render template = "thirdPartyGrid" model = "[thirdPartyInst:thirdPartyInst,listOfThirdParty:listOfThirdParty,appForm:appForm, formType:formType]"></g:render>
				</g:if>
				</div>
				<div class="clearfix"></div>

				<g:uploadForm controller="form4" action="savePart3" autocomplete="off" class="form-horizontal" role="form">
				<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
				<div class="main-registeration col-sm-12">

					<div class="form-title">
						<label class="register-heading col-sm-12"> (6) The purpose
							of the intended third party transfer </label>
					</div>




					<div class="col-sm-12 form-group">
						

							
								<g:each in="${purposeList}" var="purpose">
									<span class="col-sm-4"> <input type="radio"
										name="purpose" class="leftflot " value="${purpose}"> <span
										class="leftflot"> ${purpose}
									</span></span>
								</g:each>
							
						
					</div>
					<div class="col-sm-12">

						
							<g:textArea name="thirdPartyTransferPurpose"  class="width ctrl1" txtreq1="1" txtmaxword100="1"
								placeHolder="Provide details in 500 words" value="${appForm?.thirdPartyTransferPurpose}"></g:textArea>
						

					</div>

					<div class="form-title">
						<label class="register-heading col-sm-12"><span
							class="leftflot"> (7)</span><span id="headingPad"
							class="col-sm-11">Details of economic, social,
								biotechnological, scientific or any other benefits that are
								intended, or may accrue to the third party due to transfer of
								accessed biological material and knowledge </span> </label>
					</div>


					<div class="col-sm-12">
						<div class="form-group">

							<div class="col-sm-12">
								<g:textArea class="width ctrl1"  txtreq1="1" txtmaxword100="1"
									placeHolder="Provide details in 500 words"
									name="benefitsToTheThirdParty"
									value="${appForm?.benefitsToTheThirdParty}"></g:textArea>
							</div>
						</div>
					</div>


					<div class="form-title">
						<label class="register-heading col-sm-12"> (8) Details of
							any agreement to be entered between the applicant and the third
							party </label>
					</div>
					<div class="col-sm-9">
					
					<g:if test= "${!appForm.isAgreementBwApplicantAndThirdParty }">
					  <div class="leftflot">	
						<input type="radio" id="isAgreementEntered" name="isAgreementEntered" class="leftflot" onclick="AddValidation_Yes('hideform4')"
							value="Yes"><span class="leftflot"> &nbsp;Yes</span>
					  </div>
					  <div class="col-sm-3">&nbsp;		
						<input
							type="radio" name="isAgreementEntered" class="leftflot" Value="No" onclick="removeValidation_No('hideform4')"><span
							class="leftflot">&nbsp; No</span>
					  </div>		
					</g:if>
					
					<g:else>
					<div class="leftflot">
					  <g:if test= "${appForm.isAgreementBwApplicantAndThirdParty == 'true' }">
						<input type="radio" name="isAgreementEntered" id="isAgreementEntered" checked="checked" class="leftflot" onclick="AddValidation_Yes('hideform4')"
							value="Yes"><span class="leftflot"> &nbsp;Yes</span>
						</g:if>
						<g:else>
							<input type="radio" id="isAgreementEntered" name="isAgreementEntered" class="leftflot" onclick="AddValidation_Yes('hideform4')"
							value="Yes"><span class="leftflot"> &nbsp;Yes</span>
						</g:else>	
							</div>
							
							<div class="col-sm-3">&nbsp;
						 <g:if test= "${appForm.isAgreementBwApplicantAndThirdParty == 'false' }">	
							<input
							type="radio" name="isAgreementEntered" checked="checked" class="leftflot" Value="No" onclick="removeValidation_No('hideform4')"><span
							class="leftflot">&nbsp; No</span>
						 </g:if>
						 <g:else>
						 	<input
							type="radio" name="isAgreementEntered" class="leftflot" Value="No" onclick="removeValidation_No('hideform4')"><span
							class="leftflot">&nbsp; No</span>
						 </g:else>	
							</div>
							</g:else>
					</div>
					<div class="hideform4" >


						<div class="form-title col-sm-12 "><br/>

							<label class="form-lable">Attach a copy of agreement
								entered between the applicant and the third party, If already
								entered </label>
						</div>
						<div class="col-sm-8">
							<div class="form-group">
								<div class="col-sm-12">
									<g:if test="${appForm?.agreementBtwnApplicantAndThirdParty || appForm?.agreementBtwnApplicantAndThirdPartyURL}">
										<input type="file" class="width ctrl1 pdf" name="NBAApproval">
											<g:if test="${flash.message }">
												<span class="red"><b>
														${flash.message }
												</b></span>
											</g:if>
											<g:else>
												<g:link controller="form4" action="showDc"
													id="${appForm?.id}" target="_blank"
													params='[filename: "nbaApprovalFileName", dataName: "nbaApprovalFileName", nbaApprovalPart3:"part3", csrfPreventionSalt:"${csrfPreventionSalt}"]'>
											click for preview
										</g:link>
											</g:else>
										</g:if>
									<g:else>
										<input type="file" class="width ctrl1 pdf" name="NBAApproval" >
										<g:if test="${flash.message }">
											<span class="red"><b>${flash.message }</b></span>
										</g:if>
									</g:else>
								</div>
							</div>
						</div>
					</div>
					
					<div class="form-title">
						<label class="register-heading col-sm-12 margin-top"> <span
							class="leftflot"> (9)</span> <span id="headingPad"
							class="col-sm-11">Estimation of benefits that would flow to India/communities arising 
																out of the third party transfer of accessed biological resources and
																traditional knowledge.</span> </label>
					</div>
					
					<div class="col-sm-12">
						<div class="form-group">

							<div class="col-sm-12">
								<g:textArea class="width ctrl1"  txtreq1="1" txtmaxword100="1"
									placeHolder="Provide details in 500 words"
									name="benefitsOutOfThirdPartyTransfer"
									value="${appForm?.benefitsOutOfThirdPartyTransfer }"></g:textArea>
							</div>
						</div>
					</div>
					<br/>
					<div class="form-title">
						<label class="register-heading col-sm-12"><span
							class="leftflot"> (10)</span><span id="headingPad"
							class="col-sm-11">Proposed mechanism and arrangements for benefit sharing arising
												out of the proposed third party transfer. </span> </label>
					</div>
					<div class="col-sm-12">
						<div class="form-group">

							<div class="col-sm-12">
								<g:textArea class="width ctrl1"  txtreq1="1" txtmaxword100="1"
									placeHolder="Provide details in 500 words"
									name="mechanismOutOfThirdPartyTransfer"
									value="${appForm?.mechanismOutOfThirdPartyTransfer }"></g:textArea>
							</div>
						</div>
					</div>
					
					<div class="form-title">
						<label class="register-heading col-sm-12"><span
							class="leftflot"> (11)</span><span id="headingPad"
							class="col-sm-11">Any other relevant information </span> </label>
					</div>
					<div class="col-sm-12">
						<div class="form-group">

							<div class="col-sm-12">
								<g:textArea class="width "  txtreq1="1" txtmaxword200="1"
									placeHolder="Provide details in 500 words"
									name="otherRelevantInfo"
									value="${appForm?.otherRelevantInfo }"></g:textArea>
							</div>
						</div>
					</div>
					
					
					

					<%--<%int i=1 %>
					<g:each in="${quesAnswerMap}" var="mapKeyValue">
						<div class="form-title">
							<label class="register-heading col-sm-12"> ${mapKeyValue?.getKey()?.questionNo}
								${mapKeyValue?.getKey()?.question}</label>
						</div>
						<div class="col-sm-12">
							<div class="form-group">
								<div class="col-sm-12">
									<g:textArea class="width ctrl1" txtreq1="1" txtmaxword100="1"
										placeHolder="Provide details in 100 words"
										name="answer_${mapKeyValue?.getKey()?.id}"
										value="${mapKeyValue?.getValue()?.answer}"></g:textArea>
								</div>
							</div>
						</div>
						<%i++ %>
					</g:each>

					--%><div class="form-group">
						<div class="col-sm-12 text-right">
							<g:hiddenField name="appFormId" value="${appForm?.id}" />
							<g:hiddenField name="formType" value="${formType}" />
							<g:hiddenField name="quesCategory" value="${quesCategory?.id}" />
							<input type="submit" class="btn btn-primary btnctrl1" value="Save" />
							
						</div>
					</div>
				</div>
				</g:uploadForm>
				<g:link controller="form4" action="part2"
						params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
						class="btn btn-primary pull-left">Previous
							</g:link>
				<g:link controller="applicationManagement" action="form1Part5"
								params='[appFormId:appForm?.id,formType:formType,declaration:"declaration",csrfPreventionSalt:"${csrfPreventionSalt}"]'
								class="btn btn-primary pull-right">Next
							</g:link>

				<div class="clearfix"></div>
			</div>
		</div>
	</div>

	<div class="clearfix"></div>

</body>

</html>
