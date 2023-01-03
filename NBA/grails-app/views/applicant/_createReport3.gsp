			<table class="table table-bordered customtable main-account">
				<caption class="text-center"><b>Submission of yearly status report for Form-III–Intellectual Property Rights </b></caption>
				<tbody>
				<tr>
				<td colspan="6">Application No.</td>
			    <td colspan="2">${formDetails?.appNumber}</td>
				</tr>
				<tr>
				<td colspan="6">Agreement Signed on</td>
			    <td colspan="2">Update later</td>
				</tr>
					<tr>
				<td colspan="6">Period of Status Report
				<span style="margin-inline-start: 200px;">From:<input name="fromDate" type="text" placeholder="Start Date" autocomplete="off" value="${periodicReportInstance?.periodFrom}"  id="startdate" required="required"></span>
				
				</td>
				<td colspan="2">To:<input  name="toDate" type="text" autocomplete="off" placeholder="End Date" id="enddate" value="${periodicReportInstance?.periodTo}" required="required"></td>
				</tr>
					<tr>
						<th>S.No</th>
						<th>Country</th>
						<th>Patent Application Number</th>
						<th>Patent Application Status</th>
						<th>Mode of  Commercialization </th>
						<th>Annual Gross ex-factory sale of the patented invention</th>
						<th>Details of Assignments/ Licenses</th>
						<th>Details of fee Received /Royalty received</th>
					</tr>
					<tr>
						<td>1</td>
						<td><g:textField name="country" class="tbl-inputs" value="${periodicReportInstance?.country}" required="required"/></td>
						<td><g:textField name="pan" class="tbl-inputs" value="${periodicReportInstance?.pan}" required="required"/></td>
						<td><g:textField name="status" class="tbl-inputs" value="${periodicReportInstance?.status}" required="required"/></td>
						
						
						<td style="color: red; font-size: 14;font-weight: bold;">
						<g:if test="${periodicReportInstance}">
					    <g:each in="${periodicReportInstance?.mods}" var="mode" status="i">
						<g:checkBox name="mod" value="${mode}"/>${mode}<br>	
						</g:each>
		
						 </g:if>
						 <g:else>
						 <g:checkBox name="mod" value="Applicant is Commercialized"/>Applicant is Commercialized<br>
						<g:checkBox name="mod" value="Patent Rights Licensed"/>Patent Rights Licensed <br>
						<g:checkBox name="mod" value="Patent Rights Assigned"/>Patent Rights Assigned<br>
						<g:checkBox name="mod" value="Not Commercialized"/>Not Commercialized<br>
						 
						 </g:else>
						</td>
						
						
						<td><g:textField name="daac" class="tbl-inputs" value="${periodicReportInstance?.daac}" required="required"/></td>
					
						
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

						<td><g:textField name="feeReceived" class="tbl-inputs" value="${periodicReportInstance?.feeReceived}" required="required"/> </td>
					</tr>
<%--                    <tr>--%>
<%--						<td colspan="7"></td>--%>
<%--						<td><b>ADD</b></td>--%>
<%--					</tr>--%>
<%--					<tr></tr>--%>
					<tr>
									<td colspan="8"><b>Declaration</b><br> <g:if
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
			
			
			
			
			