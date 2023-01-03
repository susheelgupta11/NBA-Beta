<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="main" />
<title>Periodic Report</title>
</head>
 <body>
	<table>
		<tbody>
			<tr>
				<td colspan="2">Period of Status Report</td>
				<td><span>From:<input name="rep4From" id="startdate"
						size="15" required="required" /></span><span> &nbsp To:<input
						name="rep4To" id="enddate" size="15" required="required" /></span></td>
			</tr>
		<caption class="text-center">
			<b>Submission of yearly status report for Form-IV– Transfer of
				already accessed biological resources</b>
		</caption>
		<tr>
			<th>S.no</th>
			<th>Particulars</th>
			<th width="400px">Status reply ( to be furnished by the
				Applicant)</th>
		</tr>
		<tr>
			<td>1</td>
			<td>Application Number</td>
			<td>
				${formDetails?.appNumber }
			</td>
		</tr>
		<tr>
			<td>2</td>
			<td>Name of the Applicant</td>
			<td>
				${periodicReportInstance?.applicantName}
			</td>
		</tr>
		<tr>
			<td>3</td>
			<td>Date of Agreement signed</td>
			<td></td>
		</tr>

		<tr>
			<td>4</td>
			<td>Details of the transferee</td>
			<td>
				${periodicReportInstance?.dtsTransferee}
			</td>
		</tr>
		<tr>
			<td>5</td>
			<td>Have you transferred the biological resources and/or
				associated knowledge to any third party</td>
			<td><g:if
					test="${periodicReportInstance?.trnsBioCheck == ' ' || null == periodicReportInstance?.trnsBioCheck}">
											Not Selected
											
										</g:if> <g:elseif
					test="${periodicReportInstance?.trnsBioCheck == 'Yes'}">
											Yes 
										</g:elseif> <g:else>
											No
											
										</g:else> ${periodicReportInstance?.haveTransferredBiological}</td>
		</tr>
		<tr>
			<td>6</td>
			<td>Details of quantity of biological resources transferred</td>
			<td>
				${periodicReportInstance?.dtsQuantityTfr}
			</td>
		</tr>

		<tr>
			<td>7</td>
			<td>Monetary benefits accrued on transfer, if any</td>
			<td><g:if
					test="${periodicReportInstance?.haveTrsfCheck == '' || periodicReportInstance?.haveTrsfCheck == null }">
											Not Selected
											
										</g:if> <g:elseif
					test="${periodicReportInstance?.haveTrsfCheck == 'Yes' }">
											Yes 
										</g:elseif> <g:else>
											No
											
										</g:else> ${periodicReportInstance?.haveTransfer}</td>
		</tr>
		<tr>
			<td>8</td>
			<td>Detail of benefit sharing amount payable to the NBA as per
				the terms of the Agreement</td>
			<td><g:if
					test="${periodicReportInstance?.dbsapCheck == '' || periodicReportInstance?.dbsapCheck == null }">
											Not selected
											
										</g:if> <g:elseif
					test="${periodicReportInstance?.dbsapCheck == 'Yes' }">
											Yes 
										</g:elseif> <g:else>
											No
											
										</g:else> ${periodicReportInstance?.dbsapAgree}</td>
		</tr>
		<tr>
			<td>9</td>
			<td>Upload the attested proof of document on such transfer of
				Benefit Sharing</td>
			<g:if test="${periodicReportInstance}">
				<td><g:each in="${periodicReportInstance?.periodicFiles}"
						var="file">
						<li>
							${file?.fileName}
						</li>
					</g:each></td>
			</g:if>

		</tr>

		<tr>
			<td colspan="3"><b>Declaration</b><br /> <g:if
					test="${periodicReportInstance}">
					<input type="checkbox" name="declare" readonly="readonly"
						value="periodicCheck" onclick="return false;" id="myCheck" /> I/we declare that the information provided in this status report is true and correct and I /We shall be responsible for any incorrect / wrong information.
<br />
				</g:if> <g:else>
					<input type="checkbox" name="declare" value="periodicCheck"
						onclick="checkPeriodicDecleration()" id="myCheck" /> I/we declare that the information provided in this status report is true and correct and I /We shall be responsible for any incorrect / wrong information.
<br />
				</g:else> Date of Submission : <g:formatDate format="dd/MM/yyyy hh:mm  aa"
					date="${new Date()}" /> <br /> Place : <g:textField name="place"
					value="${periodicReportInstance?.place}" /></td>
		</tr>
		</tbody>
	</table>
</body>
</html>