<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>Periodic Report</title>

<style type="">
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>

</head>
<body>
  			<table>
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
				<span style="margin-inline-start: 200px;">From:${periodicReportInstance?.periodFrom}</span>
				</td>
				
				<td colspan="2">To:${periodicReportInstance?.periodTo}</td>
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
						<td>${periodicReportInstance?.country}</td>
						<td>${periodicReportInstance?.pan}</td>
						<td>${periodicReportInstance?.status}</td>
						
						
						<td style="color: red; font-size: 14;font-weight: bold;">
						<g:if test="${periodicReportInstance}">
					    <g:each in="${periodicReportInstance?.mods}" var="mode" status="i">
						<g:checkBox name="mod" value="${mode}" readonly="readonly"/>${mode}<br/>	
						</g:each>
		
						 </g:if>
						</td>
						
						
						<td>${periodicReportInstance?.daac}</td>
					
						
	                                 <g:if test="${periodicReportInstance}">
										<td><g:each in="${periodicReportInstance?.periodicFiles}"
												var="file">
												<li>
													${file?.fileName}
												</li>
											</g:each></td>
									</g:if>


						<td>${periodicReportInstance?.feeReceived}</td>
					</tr>

					<tr>
									<td colspan="8"><b>Declaration</b><br/> <g:if
											test="${periodicReportInstance}">
											<input type="checkbox" name="declare" readonly="readonly"
												value="periodicCheck" onclick="return false;" id="myCheck"/> I/we declare that the information provided in this status report is true and correct and I /We shall be responsible for any incorrect / wrong information.
<br/>
										</g:if> <g:else>
											<input type="checkbox" name="declare" value="periodicCheck"
												onclick="checkPeriodicDecleration()" id="myCheck"/> I/we declare that the information provided in this status report is true and correct and I /We shall be responsible for any incorrect / wrong information.
<br/>
										</g:else> Date of Submission : <g:formatDate
											format="dd/MM/yyyy hh:mm  aa" date="${new Date()}" /> <br/>
										Place : ${periodicReportInstance?.place}</td>
								</tr>
				</tbody>
			</table>
</body>
</html>