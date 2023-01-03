
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />
<title>NBA</title>
<script type="text/javascript">
	$(document).ready(function() {
		addCompletegreenClass(tabStatus);
		form1part4();
		  $(".notProposed").hide();
		  $(".Monetary").hide();
		
	});
</script>
</head>

<body>
<g:javascript>
	var tabStatus = "${tabStatus}"		
	var isBenefitSharing = "${appForm?.isBenefitSharing }"	
	var payBenefitSharing = "${appForm?.payBenefitSharing }"
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
				<div class="main-registeration col-sm-12">





					<div class="modal fade" id="myModal1" role="dialog">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h5 class="modal-title text-center"><b>Regulation no.3 </b><br/>
										<span class="text-center">
										<b>Mode of benefit sharing for access to biological resources, for
										commercial utilization or for bio-survey and bio-utilization for commercial utilization</b>
									</span>
									</h5>
									
								</div>
								<div class="modal-body">
									<p>
											(1). Where the applicant/ trader/ manufacturer has not entered into any prior benefit sharing
												negotiation with persons such as the Joint Forest Management Committee (JFMC)/ Forest
												dweller/ Tribal cultivator/ Gram Sabha, and purchases any biological resources directly from
												these persons, the benefit sharing obligations on the trader shall be in the range of 1.0 to
												3.0% of the purchase price of the biological resources and the benefit sharing obligations on
												the manufacturer shall be in the range of 3.0 to 5.0% of the purchase price of the biological
												resources:<br/>
												Provided that where the trader sells the biological resource purchased by him to another
												trader or manufacturer, the benefit sharing obligation on the buyer, if he is a trader, shall
												
												range between 1.0 to 3.0% of the purchase price and between 3.0 to 5.0%, if he is a
												manufacturer:<br/>
												Provided further that where a buyer submits proof of benefit sharing by the immediate
												seller in the supply chain, the benefit sharing obligation on the buyer shall be applicable
												only on that portion of the purchase price for which the benefit has not been shared in the
												supply chain.<br/> </p>
									 <p>	(2). Where the applicant/ trader/ manufacturer has entered into any prior benefit sharing
												negotiation with persons such as the Joint Forest Management Committee (JFMC)/ Forest
												dweller/ Tribal cultivator/ Gram Sabha, and purchases any biological resources directly from
												these persons, the benefit sharing obligations on the applicant shall be not less than 3.0% of
												the purchase price of the biological resources in case the buyer is a trader and not less than
												5.0% in case the buyer is a manufacturer.	

									</p>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>



					<div class="modal fade" id="myModal2" role="dialog">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h5 class="modal-title text-center"><b>Regulation no.4 </b><br/>
										<span class="text-center">
										<b>Option of benefit sharing on sale price of the biological resources
											accessed for commercial utilization under regulation 2</b>
									</span>
									</h5>
									
								</div>
								<div class="modal-body">
									<p>
										When the biological resources are accessed for commercial
										utilization or the bio-survey and bio-utilization leads to
										commercial utilization, the applicant shall have the option to
										pay the benefit sharing ranging from 0.1 to 0.5 % at the
										following graded percentages of the annual gross ex-factory
										sale of the product which shall be worked out based on the
										annual gross ex-factory sale minus government taxes as given
										below:-<br/> </p>
									 <table class="table table-bordered">
									 	<thead>
									 	<tr>
									 		<th>Annual Gross ex-factory sale of product</th>
									 		<th>Benefit sharing component</th>
									 	</tr>
									 	</thead>
									 	
									 	<tbody>
									 		<tr>
									 		<td class="text-center">Up to Rupees 1,00,00,000</td>
									 		<td class="text-center">0.1 %</td>
									 		</tr>
									 		<tr>
									 		<td class="text-center">Rupees 1,00,00,001 up to 3,00,00,000</td>
									 		<td class="text-center">0.2 %</td>
									 		</tr>
									 		<tr>
									 		<td class="text-center">Above Rupees 3,00,00,000</td>
									 		<td class="text-center">0.5 %</td>
									 		</tr>
									 		
									 	</tbody>
									 </table>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>












					<!--login form -->
					<g:uploadForm class="form-horizontal" role="form" autocomplete="off"
						action="savePart4" controller="applicationManagement">
					<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>


						<div class="form-title col-sm-12">
							<label class="register-heading"> (3) Details of any
								national institution which will participate in the Research &
								Development activities </label>
						</div>
						<div class="col-sm-12 form-group">

							<label class="control-label col-sm-6"> (i) Is there any
								such participation : </label>
							<div class="col-sm-6">

								<g:if test="${!appForm.instituteParticipation }">
									<g:radio 
										name="instituteParticipation" value="Yes" onclick="AddValidation_Yes('activities')" />
									<span>Yes &nbsp;</span>
									<g:radio 
										name="instituteParticipation" value="No" onclick="removeValidation_No('activities')" />
									<span>No</span>
								</g:if>
								<g:else>
								<g:if test="${appForm?.instituteParticipation == 'true' }">
									<g:radio  checked="checked"
										name="instituteParticipation" value="Yes"  onclick="AddValidation_Yes('activities')"/>
									<span>Yes &nbsp;</span>
								</g:if>
								<g:else>
									<g:radio 
										name="instituteParticipation" value="Yes"  onclick="AddValidation_Yes('activities')"/>
									<span>Yes &nbsp;</span>
								</g:else>

								<g:if test="${appForm?.instituteParticipation == 'false'  }">
									<g:radio class="instituteparticipation"
										radio-check="activities" checked="checked"
										name="instituteParticipation" value="No" onclick="removeValidation_No('activities')" />
									<span>No</span>
								</g:if>
								<g:else>
									<g:radio 
										radio-check="activities" name="instituteParticipation"
										value="No" onclick="removeValidation_No('activities')" />
									<span>No</span>
								</g:else>
								</g:else>
							</div>
						</div>
						<div class="activities">
							<div class="col-sm-12 form-group">

								<label class="control-label col-sm-12">(ii) Provide the
									name and contact details of the institution / organization
									participating in R & D</label>
								<div class="col-sm-12">

									<g:textArea class="width txtreq" name="detailsOfInstitute"
										value="${appForm?.detailsOfInstitute}"></g:textArea>
								</div>

							</div>



							<div class="col-sm-12 form-group">

								<label class="control-label col-sm-12">(iii) Attach
									self-attested copy of MoU with the National Institution or
									letter of intent detailing the activity </label>
								<div class="col-sm-12">
									<g:if test="${appForm?.letterOfIntentURL}">
										<input type="file" class="width pdf"
											name="LetterOfIntent" />
										<g:if test="${flash.message }">
											<span class="red"><b>
													${flash.message }
											</b></span>
										</g:if>
										<g:else>
											<g:link controller="applicationManagement" action="showAppDc"
												id="${appForm?.id}" target="_blank"
												params='[filename: "letterOfIntentName", dataName: "letterOfIntentName",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
												${appForm?.letterOfIntentName}
											</g:link>
										</g:else>
									</g:if>
									<g:else>
										<input type="file" class="width controlreq pdf"
											name="LetterOfIntent" />
										<g:if test="${flash.message }">
											<span class="red"><b>
													${flash.message }
											</b></span>
										</g:if>	
									</g:else>
								</div>

							</div>
						</div>


						<%int i=1 %>
						<g:each in="${quesAnswerMap}" var="mapKeyValue">
							<div class="form-title col-sm-12">
								<label class="register-heading completewidth"><span
									class="floatleft"> ${mapKeyValue?.getKey()?.questionNo}</span> <span
									class="col-sm-11	"> ${mapKeyValue?.getKey()?.question}
								</span></label>
							</div>
							<div class="col-sm-12 form-group">

								<div class="col-sm-12 ">
									<g:textArea placeholder="${mapKeyValue?.getKey()?.placeholder}"
										class="width" name="answer_${mapKeyValue?.getKey()?.id}"
										value="${mapKeyValue?.getValue()?.answer}"
										data-toggle="tooltip" req="1" txtmaxword100="1" data-placement="top"
										title="${mapKeyValue?.getKey()?.questionTooltip}"></g:textArea>
								</div>

							</div>
							<%i++ %>
						</g:each>

						<div class="form-title col-sm-12">
							<label class="register-heading completewidth"> <span
								class="floatleft">(8)</span><span class="col-sm-11">
									Proposed mechanism and arrangements for benefit sharing </span></label>
						</div>



						<div class="form-group col-sm-12">
							<label class="control-label col-sm-12"> <span
								class="floatleft"> (i)</span><span class="col-sm-11 part4">
									Is there any proposed mechanism and arrangements for benefit
									sharing (non-monetary / monetary) with the provider of the
									biological resource(s) and/or holder of associated traditional
									knowledge in accordance with the BD Act / Rules thereon? </span></label>
							<div class="col-sm-12 form-group">
								<div class="col-sm-4">
								  
								  <g:if test="${!appForm?.isBenefitSharing }">
										<g:radio name="isBenefitSharing" value="Yes"
											onclick="AddValidation_Yes4('Proposed')" />
										<span>Yes &nbsp;</span>
<%--										<g:radio name="isBenefitSharing" value="No"  onclick="removeValidation_No4('Proposed')"/>--%>
										<g:radio name="isBenefitSharing" value="No"  onclick="removeValidation_No4('notBenefitSharing')"/>
										<span>No</span>
										
								  </g:if>
								  <g:else>
									<g:if test="${appForm?.isBenefitSharing == 'true' }">
										<g:radio name="isBenefitSharing" onclick="AddValidation_Yes4('Proposed')"
											 checked="checked" value="Yes" />
										<span>Yes &nbsp;</span>
									</g:if>
									<g:else>
										<g:radio name="isBenefitSharing" 
											 value="Yes" onclick="AddValidation_Yes4('Proposed')" />
										<span>Yes &nbsp;</span>
									</g:else>


									<g:if test="${appForm?.isBenefitSharing == 'false' }">
										<g:radio name="isBenefitSharing" value="No" onclick="removeValidation_No4('Proposed')" 
											 checked="checked" />
										<span>No</span>
									</g:if>
									<g:else>
										<g:radio name="isBenefitSharing" value="No"  onclick="removeValidation_No4('Proposed')"
											 />
										<span>No</span>
									</g:else>
								</g:else>
								</div>
							</div>
						</div>

<%--						IF YES--%>


						<div class="form-group col-sm-12 Proposed">
							<label class="control-label col-sm-12"><span
								class="floatleft"> (ii)</span> <span class="col-sm-11">
									If yes, attach a copy of mutually agreed terms between the
									applicant and the provider of biological resource(s) and / or
									associated traditional knowledge, if any </span></label>
							<div class="col-sm-8">
								<g:if test="${appForm?.sharingDocURL}">
									<input type="file" class="width pdfc" name="BenefitOfSharingDoc">
									<g:if test="${flash.message }">
										<span class="red"><b>
												${flash.message }
										</b></span>
									</g:if>
									<g:else>
										<g:link controller="applicationManagement" action="showAppDc"
											id="${appForm?.id}" target="_blank"
											params='[filename: "sharingDocName", dataName: "sharingDocName",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
											${appForm?.sharingDocName}
										</g:link>
									</g:else>
								</g:if>
								<g:else>
									<input type="file" class="width pdfc"
										name="BenefitOfSharingDoc">
										<g:if test="${flash.message }">
										<span class="red"><b>
												${flash.message }
										</b></span>
									</g:if>
								</g:else>
							</div>
						</div>
						
						
<%--						IF NO--%>
						
						<g:if test="${appForm?.companyProfiles?.size() != 0 }">	
						
						
						
								<div class="form-group col-sm-12 " id="notBenefitSharing">
									<label class="control-label col-sm-12"><span
										class="floatleft"> (ii)</span> <span class="col-sm-11">
											Do you intend to pay the benefit sharing in the form of </span></label>
									<div class="col-sm-12 form-group">
										<div class="col-sm-4">
		
											<g:if test="${!appForm?.payBenefitSharing}">
												<g:radio name="payBenefitSharing" value="Monetary"
													onclick="AddValidation_Yes4('openIfMonetary')" />
												<span>Monetary &nbsp;</span>
												<g:radio name="payBenefitSharing" value="Non-Monetary"
													onclick="removeValidation_No4('openIfMonetary')" />
												<span>Non-Monetary</span>
		
											</g:if>
											<g:elseif test="${appForm?.payBenefitSharing }">
												<g:if test="${appForm?.payBenefitSharing == 'Monetary' }">
													<g:radio name="payBenefitSharing"
														onclick="AddValidation_Yes4('openIfMonetary')" checked="checked"
														value="Monetary" />
													<span>Monetary &nbsp;</span>
												</g:if>
												<g:else>
													<g:radio name="payBenefitSharing" value="Monetary"
														onclick="AddValidation_Yes4('openIfMonetary')" />
													<span>Monetary &nbsp;</span>
												</g:else>
		
		
												<g:if test="${appForm?.payBenefitSharing == 'Non-Monetary' }">
													<g:radio name="payBenefitSharing" value="Non-Monetary"
														onclick="removeValidation_No4('openIfMonetary')" checked="checked" />
													<span>Non-Monetary</span>
												</g:if>
												<g:else>
													<g:radio name="payBenefitSharing" value="Non-Monetary"
														onclick="removeValidation_No4('openIfMonetary')" />
													<span>Non-Monetary</span>
												</g:else>
											</g:elseif>
										</div>
									</div>
								</div>
								
								<div class="form-group col-sm-12 " id="openIfMonetary">
									<label class="control-label col-sm-12"><span
										class="floatleft"> </span> <span class="col-sm-11">
<%--											If Monetary, whether the benefit sharing will be based on </span></label>--%>
											Whether the benefit sharing will be based on </span></label>
									<div class="col-sm-12 form-group">
										<div class="col-sm-8">
		
											<g:if test="${!appForm?.isMonetary }">
												<g:radio name="isMonetary" value="purchasePrice"
													onclick="AdValidation_Yes4('Proposed')" />
												<span>Purchase price of biological resource</span>
												<span data-toggle="modal" data-target="#myModal1" style="color:red;">(Refer Regulation no.3)&nbsp;</span><br/>
												<g:radio name="isMonetary" value="exFactorySale"
													onclick="removValidation_No4('Proposed')" />
												<span>Gross ex-factory sale of Product</span>
												<span data-toggle="modal" data-target="#myModal2" style="color:red;">(Refer Regulation no.4)&nbsp;</span><br/>
		
											</g:if>
											<g:else>
												<g:if test="${appForm?.isMonetary == 'purchasePrice' }">
													<g:radio name="isMonetary"
														onclick="AdValidation_Yes4('Proposed')" checked="checked"
														value="purchasePrice" />
													<span>Purchase price of biological resource </span>
												<span data-toggle="modal" data-target="#myModal1" style="color:red;">(Refer Regulation no.3)&nbsp;</span><br/>
												</g:if>
												<g:else>
													<g:radio name="isMonetary" value="purchasePrice"
														onclick="AdValidation_Yes4('Proposed')" />
													<span>Purchase price of biological resource </span>
												<span data-toggle="modal" data-target="#myModal1" style="color:red;">(Refer Regulation no.3)&nbsp;</span><br/>
												</g:else>
		
		
												<g:if test="${appForm?.isMonetary == 'exFactorySale' }">
													<g:radio name="isMonetary" value="exFactorySale"
														onclick="removValidation_No4('Proposed')" checked="checked" />
													<span>Gross ex-factory sale of Product </span>
													<span data-toggle="modal" data-target="#myModal2" style="color:red;">(Refer Regulation no.4)&nbsp;</span><br/>
												</g:if>
												<g:else>
													<g:radio name="isMonetary" value="exFactorySale"
														onclick="removValidation_No4('Proposed')" />
													<span>Gross ex-factory sale of Product</span>
													<span data-toggle="modal" data-target="#myModal2" style="color:red;">(Refer Regulation no.4)&nbsp;</span><br/>
												</g:else>
											</g:else>
										</div>
									</div>
								</div>
								
								
								
						</g:if>
						
						
						
<%--						IF Purchase price of biological resource FORM A will appear--%>
						
						
						
						
						
						
						
						
						

						<div class="form-title col-sm-12">
							<label class="register-heading completewidth"> <span
								class="floatleft">(9)</span><span class="col-sm-11"> Any
									other information considered relevant </span></label>
						</div>

						<div class="col-sm-12 form-group">

							<div class="col-sm-12 ">
								<g:textArea 
									class="width" name="otherInfo"
									value="${appForm?.otherInfo}"></g:textArea>
							</div>

						</div>
						
						<%--<g:if test="${appForm?.companyProfiles?.size() != 0 }">	
						<div class="form-title col-sm-12">
							<label class="register-heading completewidth"> <span
								class="floatleft">(10)</span><span class="col-sm-11">
									Whether proposed access is for trading purpose </span></label>
						</div>

						<div class="col-sm-12 form-group">

							<div class="col-sm-4">

								<g:if test="${!appForm?.isTradingPurpose }">
									<g:radio name="isTradingPurpose" value="Yes" />
									<span>Yes &nbsp;</span>
									<g:radio name="isTradingPurpose" value="No" />
									<span>No</span>

								</g:if>
								<g:else>
									<g:if test="${appForm?.isTradingPurpose == 'true' }">
										<g:radio name="isTradingPurpose" checked="checked" value="Yes" />
										<span>Yes &nbsp;</span>
									</g:if>
									<g:else>
										<g:radio name="isTradingPurpose" value="Yes" />
										<span>Yes &nbsp;</span>
									</g:else>


									<g:if test="${appForm?.isTradingPurpose == 'false' }">
										<g:radio name="isTradingPurpose" value="No" checked="checked" />
										<span>No</span>
									</g:if>
									<g:else>
										<g:radio name="isTradingPurpose" value="No" />
										<span>No</span>
									</g:else>
								</g:else>
							</div>


						</div>
					</g:if>	
						
						
						
						
						--%><div class="col-sm-12 text-right form-group">
							<%--								<g:link controller="applicationManagement" action="form1Part3"--%>
							<%--									class="btn btn-primary" params="[appFormId:appForm?.id]">Previous</g:link>--%>
							<g:hiddenField name="appFormId" value="${appForm?.id}" />
							<g:hiddenField name="formType" value="${formType}" />
							<g:hiddenField name="quesCategory" value="${quesCategory?.id}" />
							<input type="submit" class="btn btn-primary ctrolvalid"
								Value="Save" />
							<%--								<g:link controller="applicationManagement" action="form1Part5"--%>
							<%--									class="btn btn-primary" params="[appFormId:appForm?.id,formType:formType]">Next</g:link>--%>

						</div>
					</g:uploadForm>
				</div>

				<div class="col-sm-12">
					<g:link controller="applicationManagement" action="form1Part3"
						class="btn btn-primary" params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Previous</g:link>
				    <g:if test="${appForm?.isTradingPurpose == 'true' }">
						<g:link controller="formA" action="form1FormA"
							class="btn btn-primary pull-right"
							params='[appFormId:appForm?.id,formType:formType,declaration:"declaration" ,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Next</g:link>
					</g:if>
					<g:elseif test= "${appForm?.isDeclarationDigitallySigned == 'true' || appForm?.isDeclarationDigitallySigned == 'notDigital' }">
						<g:link controller="applicationManagement" action="form1Part5"
							class="btn btn-primary pull-right"
							params='[appFormId:appForm?.id,formType:formType,declaration:"declaration" ,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Next</g:link>
					</g:elseif>
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
