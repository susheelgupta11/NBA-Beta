<script type="text/javascript">


$( document ).ready(function() {

var text = document.getElementById("submi").style.display = "block";

});




</script>

        	<table class="table table-bordered customtable main-account">
				<caption class="text-center"><b>Submission of yearly status report for Form-I – commercial utilization or bio-survey and bio-utilization for commercial utilization</b></caption>
				<tbody>
				<tr>
				<td colspan="2">Period of Status Report
				<span style="margin-inline-start: 200px;">From:<input name="fromDate" type="text" placeholder="Start Date" autocomplete="off" value="${periodicReportInstance?.periodFrom}"  id="startdate" required="required"></span>
				
				</td>
				<td>To:<input  name="toDate" type="text" autocomplete="off" placeholder="End Date" id="enddate" value="${periodicReportInstance?.periodTo}" required="required"></td>
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
	    				<td><input type="file" name="uploadFile" style="display:block"></td>
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
	    				<td><input type="file" name="uploadFile" style="display:block"></td>
	    			</tr>
				</tbody>	
			</table>
	
 