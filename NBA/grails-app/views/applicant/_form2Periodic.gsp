<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>NBA-Periodic Reoprt</title>
</head>
<body>
 		<table class="table table-bordered customtable main-account">
				<caption class="text-center"><b>Submission of yearly status report for Form-II – Transfer of results of Research</b></caption>
				<tbody>
					<tr>
						<th>S.no.</th>
						<th>Particulars</th>
						<th style="width: 200px">Status reply ( to be furnished by the Applicant)</th>
					</tr>
					<tr>
						<td>1</td>
						<td>Application  Number </td>
				<td>${periodicReportInstance?.applicationNumber}</td>
					</tr>
					<tr>
						<td>2</td>
						<td>Name of the Applicant </td>
						<td>${periodicReportInstance?.applicantName}</td>
					</tr>
					<tr>
						<td>3</td>
						<td>Date of Agreement signed  </td>
						<td>${periodicReportInstance?.agreementSignDt}</td>
					</tr>
					<tr>
						<td>4</td>
						<td>Details of the transferor  </td>
						<td>${periodicReportInstance?.dtsTransferor}</td>
					</tr>
					<tr>
						<td>5</td>
						<td>Details of the transferee</td>
						<td>${periodicReportInstance?.dtsTransferee}</td>
					</tr>
					<tr>
						<td>6</td>
						<td>Mode of transfer</td>
						<td>${periodicReportInstance?.modeOfTransfr}</td>
					</tr>
					<tr>
						<td>7</td>
						<td>Monetary benefits accrued on transfer, if any</td>
						<td>${periodicReportInstance?.monetBeneftOnTrsf}</td>
					</tr>
					<tr>
						<td>8</td>
						<td>Detail of benefit sharing amount payable to the NBA as per the terms of the Agreement</td>
						<td>${periodicReportInstance?.detsOfbenefitSharing}</td>
					</tr>
					<tr>
						<td>9</td>
						<td>Upload the attested proof of document on such transfer </td>
										<g:if test="${periodicReportInstance}">
				<td>
				<g:each in="${periodicReportInstance?.periodicFiles}" var="file">
				<li>${file?.fileName}</li>
				</g:each>
				</td>
				</g:if>
					</tr>
				</tbody>
	</table>
</body>
</html>