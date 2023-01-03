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
				<caption class="text-center"><b>Submission of yearly status report for Form-I – commercial utilization or bio-survey and bio-utilization for commercial utilization</b></caption>
				<tbody>
				<tr>
				<td colspan="2">Period of Status Report
				<span style="margin-inline-start: 200px;">From:${periodicReportInstance?.periodFrom}</span>
				
				</td>
				<td>To:${periodicReportInstance?.periodTo}</td>
				</tr>
					<tr>
						<th class="text-center"><b>S.no</b></th>
						<th class="text-center" ><b>Particulars</b></th>
						<th  style="width: 200px"><b>Status reply<br/>( to be furnished by the Applicant)</b></th>
	    			</tr>
	    			<tr>
	    				<td>1</td>
	    				<td>Application Number</td>
	    				<td>${formDetails?.appNumber}</td>
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
	    				<td>Whether accessed the biological resources from the locations proposed in the Application</td>
	    				<td></td>
	    			</tr>
	    			<tr>
	    				<td>5</td>
	    				<td>Name of the product developed  based on the accessed biological resources</td>
	    				<td></td>
	    			</tr>
	    			<tr>
	    				<td>6</td>
	    				<td>Details of annual gross ex-factory sale of the product  </td>
	    				<td></td>
	    			</tr>
	    			<tr>
	    				<td>7</td>
	    				<td>Detail of benefit sharing amount payable to the NBA as per the terms of the Agreement</td>
	    				<td></td>
	    			</tr>
	    			<tr>
	    				<td>8</td>
	    				<td>Upload the audited statement of the company  </td>
	    				<td><input type="file" name="uploadFile" style="display:block"/></td>
	    			</tr>
	    			<tr>
	    				<td>9</td>
	    				<td>Have you applied any patent in or outside India, if so provide the details of the same?</td>
	    				<td></td>
	    			</tr>
	    			<tr>
	    				<td>10</td>
	    				<td>Have you transferred the biological resources to any third party, if so provide the details of the same? </td>
	    				<td></td>
	    			</tr>
	    			<tr>
	    				<td>11</td>
	    				<td>Details of deposition of vouchers specimen of accessed biological resources in the repository</td>
	    				<td><input type="file" name="uploadFile" style="display:block"/></td>
	    			</tr>
				</tbody>	
			</table>
	
 
</body>
</html>