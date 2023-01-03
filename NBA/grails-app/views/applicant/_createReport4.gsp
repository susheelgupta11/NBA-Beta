<g:if test="${periodicReportInstance}">
						<script type="text/javascript">
$( document ).ready(function() {
	 document.getElementById("myCheck").checked = true;
});

</script>
					</g:if>

<g:if test="${periodicReportInstance?.haveTransfer}">
   <script type="text/javascript">
$( document ).ready(function() {
	 document.getElementById("haveA").style.display = 'block';
});
</script>
	</g:if>

					<g:if test="${periodicReportInstance?.dbsapAgree}">
						<script type="text/javascript">
$( document ).ready(function() {
	 document.getElementById("transf").style.display = 'block';
});

</script>
					</g:if>

<g:if test="${periodicReportInstance?.haveTransferredBiological}">

<script type="text/javascript">
$( document ).ready(function() {
	 document.getElementById("transBio").style.display = 'block';
});

</script>
					</g:if>

						<g:hiddenField name="appNumber" value="${formDetails?.id}" />
						<g:hiddenField name="applicantName" value="${fullName}" />
						<g:hiddenField name="periodicInstance"
							value="${periodicReportInstance?.id }" />
						<g:hiddenField name="csrfPreventionSalt"
							value="${csrfPreventionSalt}" />
						<g:hiddenField name="formType" value="createReport4" />




						<table class="table table-bordered customtable main-account">
							<tbody>
							<tr>
							<td colspan="2">Period of Status Report</td>
							<td><span>From:<input name="rep4From" id="startdate" size="15" required="required"/></span><span> &nbsp To:<input name="rep4To" id="enddate" size="15" required="required"/></span></td>
							</tr>
							<caption class="text-center">
								<b>Submission of yearly status report for Form-IV– Transfer
									of already accessed biological resources</b>
							</caption>
							<tr>
								<th>S.no</th>
								<th>Particulars</th>
								<th width="400px">Status reply ( to be furnished by
									the Applicant)
								</th>
							</tr>
							<tr>
								<td>1</td>
								<td>Application Number</td>
								<td>${formDetails?.appNumber }</td>
							</tr>
							<tr>
								<td>2</td>
								<td>Name of the Applicant</td>
								<td>${fullName}</td>
							</tr>
							<tr>
								<td>3</td>
								<td>Date of Agreement signed</td>
								<td></td>
							</tr>
						
							<tr>
								<td>4</td>
								<td>Details of the transferee</td>
								<td><g:textField name="dtsTransferee" value="${periodicReportInstance?.dtsTransferee}" style="width:100%"/></td>
							</tr>
							<tr>
								<td>5</td>
								<td>Have you transferred the biological resources and/or associated knowledge to any third party</td>
								<td><g:if
											test="${periodicReportInstance?.trnsBioCheck == ' ' || null == periodicReportInstance?.trnsBioCheck}">
											<g:radio name="trnsBioCheck" id="yesBo" value="Yes"
												onclick="displayBio(this)" />Yes <span> <g:radio
													name="trnsBioCheck" id="noBo" value="No"
													onclick="displayBio(this)" />No
											</span>
										</g:if> <g:elseif
											test="${periodicReportInstance?.trnsBioCheck == 'Yes'}">
											<g:radio name="trnsBioCheck" id="yesBo" checked="checked"
												value="Yes" onclick="displayBio(this)" />Yes <span> <g:radio
													name="trnsBioCheck" id="noBo" value="No"
													onclick="displayBio(this)" />No
											</span>
										</g:elseif> <g:else>
											<g:radio name="trnsBioCheck" id="yesBo" value="Yes"
												onclick="displayBio(this)" />Yes <span> <g:radio
													name="trnsBioCheck" id="noBo" checked="checked" value="No"
													onclick="displayBio(this)" />No
											</span>
										</g:else> <g:textField name="haveTransferredBiological"
											placeholder="Please provide the details" id="transBio"
											style="width:100%; display:none"
											value="${periodicReportInstance?.haveTransferredBiological}" /></td>
							</tr>
							<tr>
								<td>6</td>
								<td>Details of quantity of biological resources transferred
								</td>
								<td><g:textField name="dtsQuantityTfr" value="${periodicReportInstance?.dtsQuantityTfr}" style="width:100%"/></td>
							</tr>
							
							<tr>
								<td>7</td>
								<td>Monetary benefits accrued on transfer, if any</td>
								<td><g:if
											test="${periodicReportInstance?.haveTrsfCheck == '' || periodicReportInstance?.haveTrsfCheck == null }">
											<g:radio name="haveTrsfCheck" id="yesApp" value="Yes"
												onclick="displayTxt(this)" />Yes <span> <g:radio
													name="haveTrsfCheck" id="noApp" value="No"
													onclick="displayTxt(this)" />No
											</span>
										</g:if> <g:elseif
											test="${periodicReportInstance?.haveTrsfCheck == 'Yes' }">
											<g:radio name="haveTrsfCheck" id="yesApp"
												checked="checked" value="Yes" onclick="displayTxt(this)" />Yes <span>
												<g:radio name="haveTrsfCheck" id="noApp" value="No"
													onclick="displayTxt(this)" />No
											</span>
										</g:elseif> <g:else>
											<g:radio name="haveTrsfCheck" id="yesApp" value="Yes"
												onclick="displayTxt(this)" />Yes <span> <g:radio
													name="haveTrsfCheck" id="noApp" value="No"
													checked="checked" onclick="displayTxt(this)" />No
											</span>
										</g:else> <g:textField name="haveTransfer"
											placeholder="Please provide the details" id="haveA"
											style="width:100%; display:none"
											value="${periodicReportInstance?.haveTransfer}"/></td>
							</tr>
							<tr>
								<td>8</td>
								<td>Detail of benefit sharing amount payable to the NBA as
									per the terms of the Agreement</td>
								<td><g:if
											test="${periodicReportInstance?.dbsapCheck == '' || periodicReportInstance?.dbsapCheck == null }">
											<g:radio name="dbsapCheck" id="yesTra" value="Yes"
												onclick="displayTrf(this)" />Yes <span> <g:radio
													name="dbsapCheck" id="noTra" value="No"
													onclick="displayTrf(this)" />No
											</span>
										</g:if> <g:elseif
											test="${periodicReportInstance?.dbsapCheck == 'Yes' }">
											<g:radio name="dbsapCheck" id="yesTra"
												checked="checked" value="Yes" onclick="displayTrf(this)" />Yes <span>
												<g:radio name="dbsapCheck" id="noTra" value="No"
													onclick="displayTrf(this)" />No
											</span>
										</g:elseif> <g:else>
											<g:radio name="dbsapCheck" id="yesTra" value="Yes"
												onclick="displayTrf(this)" />Yes <span> <g:radio
													name="dbsapCheck" id="noTra" value="No"
													checked="checked" onclick="displayTrf(this)" />No
											</span>
										</g:else> <g:textField name="dbsapAgree"
											placeholder="Please provide the details" id="transf"
											style="width:100%; display:none"
											value="${periodicReportInstance?.dbsapAgree}"/></td>
							</tr>
							<tr>
								<td>9</td>
								<td>Upload the attested proof of document on such transfer of Benefit Sharing</td>
								<g:if test="${periodicReportInstance}">
										<td><g:each in="${periodicReportInstance?.periodicFiles}"
												var="file">
												<li>
													${file?.fileName}
												</li>
											</g:each></td>
									</g:if>
									<g:else>
										<td><table>
												<tr>
													<th><div class="input_fields_wrap">
															<input type="button" class="add_mor" id="chgName"
																Value="upload file" />
														</div></th>
												</tr>
												<tr>
													<td><span style="color: red" id="errorMsg"></span></td>
												</tr>

											</table></td>
									</g:else>
							</tr>
							
															<tr>
									<td colspan="3"><b>Declaration</b><br> <g:if
											test="${periodicReportInstance}">
											<input type="checkbox" name="declare" readonly="readonly"
												value="periodicCheck" onclick="return false;" id="myCheck"> I/we declare that the information provided in this status report is true and correct and I /We shall be responsible for any incorrect / wrong information.
<br>
										</g:if> <g:else>
											<input type="checkbox" name="declare" value="periodicCheck"
												onclick="checkPeriodicDecleration()" id="myCheck"> I/we declare that the information provided in this status report is true and correct and I /We shall be responsible for any incorrect / wrong information.
<br>
										</g:else> Date of Submission : <g:formatDate
											format="dd/MM/yyyy hh:mm  aa" date="${new Date()}" /> <br>
										Place : <g:textField name="place"
											value="${periodicReportInstance?.place}" /></td>
								</tr>
							</tbody>
						</table>