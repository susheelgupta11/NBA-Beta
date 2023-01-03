<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>NBA</title>
</head>
<body>
 
<table class="table table-bordered customtable main-account">
	<caption class="text-center">
		<b>Submission of yearly status report for Form-I – Research</b>
	</caption>
	<tbody>
		<tr>
			<th><b>S.no</b></th>
			<th><b>Particulars</b></th>
			<th style="width: 200px"><b>Status Reply( to be
					furnished by the Applicant)
			</b></th>
		</tr>
		<tr>
			<td>1</td>
			<td>Application Number</td>
			<td>${periodicReportInstance?.applicationNumber}</td>
		</tr>

		<tr>
			<td>2</td>
			<td>Name of the Applicant</td>
			<td>${periodicReportInstance?.applicantName }</td>
		</tr>
		<tr>
			<td>3</td>
			<td>Date of Agreement signed</td>
			<td>${periodicReportInstance?.agreementSignDt}</td>
		</tr>
		<tr>
			<td>4</td>
			<td>Whether accessed the biological resources from the locations
				proposed in the Application</td>
			<td>${periodicReportInstance?.whetherAccessedBioRes}</td>
		</tr>
		<tr>
			<td>5</td>
			<td>When the biological resources was accessed for research
				(i.e. Time of access)</td>
			<td>${periodicReportInstance?.whenBiologicalResearch}</td>
		</tr>
		<tr>
			<td>6</td>
			<td>Where the research and development activities was carried
				out?</td>
			<td>${periodicReportInstance?.reserchCarriedOut}</td>
		</tr>
		<tr>
			<td>7</td>
			<td>Brief of the research carried out on the accessed biological
				resources/ outcome of the research</td>
			<td>${periodicReportInstance?.briefResearchCarried}</td>
		</tr>
		<tr>
			<td>8</td>
			<td>Have you published an article based on this research, if
				any?</td>
			<td>${periodicReportInstance?.haveYouPublished}</td>
		</tr>
		<tr>
			<td>9</td>
			<td>Have you applied any patent in or outside India, if so
				provide the details of the same?</td>
			<td>${periodicReportInstance?.haveAppliedPatent}</td>
		</tr>
		<tr>
			<td>10</td>
			<td>Have you transferred the results of research to any third
				party, if so provide the details of the same ?</td>
			<td>${periodicReportInstance?.haveTransferredResults}</td>
		</tr>
		<tr>
			<td>11</td>
			<td>Have you transferred the biological resources to any third
				party, if so provide the details of the same?</td>
			<td>${periodicReportInstance?.haveTransferredBiological}</td>
		</tr>
		
		<tr>
			<td>12</td>
			<td>Details of deposition of vouchers specimen of accessed
				biological resources in the repository</td>
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