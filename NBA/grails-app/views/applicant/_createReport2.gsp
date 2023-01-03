
					<g:if test="${periodicReportInstance?.monetBeneftOnTrsf}">
						<script type="text/javascript">
$( document ).ready(function() {
	 document.getElementById("transf").style.display = 'block';
});

</script>
					</g:if>
					
					
					<g:if test="${periodicReportInstance?.detsOfbenefitSharing}">
						<script type="text/javascript">
$( document ).ready(function() {
	 document.getElementById("transBio").style.display = 'block';
});

</script>
					</g:if>




			<table class="table table-bordered customtable main-account">
				<caption class="text-center"><b>Submission of yearly status report for Form-II – Transfer of results of Research</b></caption>
				<tbody>
				<tr>
				<td colspan="2">Period of Status Report
				<span style="margin-inline-start: 200px;">From:<input name="fromDate" type="text" placeholder="Start Date" autocomplete="off" value="${periodicReportInstance?.periodFrom}"  id="startdate" required="required"></span>
				
				</td>
				<td>To:<input  name="toDate" type="text" autocomplete="off" placeholder="End Date" id="enddate" value="${periodicReportInstance?.periodTo}" required="required"></td>
				</tr>
			
					<tr>
						<th>S.no.</th>
						<th class="text-center" style="width: 300px">Particulars</th>
						<th  style="width: 200px">Status reply <br>( to be furnished by the Applicant)</th>
					</tr>
					<tr>
						<td>1</td>
						<td>Application  Number </td>
				<td><g:textField name="applicationNumber" value="${formDetails?.appNumber}" style="width:100%" readonly="true"/></td>
					</tr>
					<tr>
						<td>2</td>
						<td>Name of the Applicant </td>
						<td>${fullName}</td>
					</tr>
					<tr>
						<td>3</td>
						<td>Date of Agreement signed  </td>
						<td><input type="text" id="datetimepicker" name="agreementSignDt" value="${periodicReportInstance?.agreementSignDt}" style="width:100%" required="required"/></td>
					</tr>

					<tr>
						<td>4</td>
						<td>Details of the transferee</td>
						<td><g:textField name="dtsTransferee"  value="${periodicReportInstance?.dtsTransferee}" style="width:100%" required="required"/></td>
					</tr>
					
					<tr>
						<td>5</td>
						<td>Monetary benefits accrued on transfer, if any</td>
						<td>
						
						<g:if
											test="${periodicReportInstance?.haveTrsCheck == '' || null == periodicReportInstance?.haveTrsCheck }">
											<g:radio name="haveTrsCheck" id="yesTra" value="Yes"
												onclick="displayTrf(this)" />Yes <span> <g:radio
													name="haveTrsCheck" id="noTra" value="No"
													onclick="displayTrf(this)" />No
											</span>
										</g:if> <g:elseif
											test="${periodicReportInstance?.haveTrsCheck == 'Yes' }">
											<g:radio name="haveTrsCheck" id="yesTra" checked="checked"
												value="Yes" onclick="displayTrf(this)" />Yes <span> <g:radio
													name="haveTrsCheck" id="noTra" value="No"
													onclick="displayTrf(this)" />No
											</span>
										</g:elseif> <g:else>
											<g:radio name="haveTrsCheck" id="yesTra" value="Yes"
												onclick="displayTrf(this)" />Yes <span> <g:radio
													name="haveTrsCheck" id="noTra" value="No" checked="checked"
													onclick="displayTrf(this)" />No
											</span>
										</g:else> <g:textField name="monetBeneftOnTrsf"
											placeholder="Please provide the details" id="transf"
											style="width:100%; display:none"
											value="${periodicReportInstance?.monetBeneftOnTrsf}" />
						</td>
					</tr>
					<tr>
						<td>6</td>
						<td>Benefit sharing amount payable to the NBA as per the terms of the Agreement</td>
						<td>
						<g:if
											test="${periodicReportInstance?.trnsBioCheck == ' ' || null == periodicReportInstance?.trnsBioCheck}">
											<g:radio name="trnsBioCheck" id="yesBo" value="Yes"
												onclick="displayBio(this)" />Yes <span> <g:radio
													name="trnsBioCheck" id="noBo" value="No"
													onclick="displayBio(this)" />No
											</span>
										</g:if> <g:elseif
											test="${periodicReportInstance?.trnsBioCheck == 'Yes'  }">
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
										</g:else> <g:textField name="detsOfbenefitSharing"
											placeholder="Please provide the details" id="transBio"
											style="width:100%; display:none"
											value="${periodicReportInstance?.detsOfbenefitSharing}" />
						
						</td>
					</tr>
					<tr>
						<td>7</td>
						<td>Upload the attested proof of document on such transfer of Benefit Sharing </td>
										<g:if test="${periodicReportInstance}">
				<td>
				<g:each in="${periodicReportInstance?.periodicFiles}" var="file">
				<li>${file?.fileName}</li>
				</g:each>
				</td>
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
					