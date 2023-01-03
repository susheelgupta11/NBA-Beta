		<table border="1" align="center">
			<tbody>
				<tr class="my-td-left">
					<td><b>Current User</b></td>
					
					<g:if test="${linkOfficerInstance}">
					<td>${linkOfficerInstance?.nbaUserFrom?.name}</td>
					
					</g:if>
					<g:else>
					<td>
					<g:select name="userLinkByAdmin" from="${nbauser}" value="${linkOfficerInstance?.nbaUserFrom?.name}"
					   noSelection="['':'-Choose User -']" required="required"/>
					
					</td>
					</g:else>
					
					
					
				<tr>
					<td><b>Link Officer</b></td>
					<g:if test="${linkOfficerInstance}">
					<td>${linkOfficerInstance?.nbaUserTo?.name}</td>
					
					</g:if><g:else>
					<td><g:select name="linkUser" from="${nbauser}" value="${linkOfficerInstance?.nbaUserTo?.name}"
					         noSelection="['':'-Choose Link Officer -']" required="required"/></td>
                 </g:else>
				</tr>
				<tr>
					<td colspan="2"><b><center>Period</center></b></td>

				</tr>
				<tr>
					<td><b>From</b></td>
					<td>
<%--					<input type="date" name="fromDate"  value="${linkOfficerInstance?.fromDate}"/>--%>
					
					<g:datePicker name="fromDate"  value="${linkOfficerInstance?.fromDate}"/>
             </td>

				</tr>

				<tr>
					<td><b>To</b></td>
					<td>
<%--					<input type="date" name="toDate"  value="${linkOfficerInstance?.toDate}"/>--%>
					<g:datePicker name="toDate"  value="${linkOfficerInstance?.toDate}"/>
					</td>

				</tr>

				<tr>
					<td><b>Specify Reason</b></td>
					<td><g:textArea name="reason" style="width:100%"
							value="${linkOfficerInstance?.reason}" /></td>
				</tr>

<tr>
					<td><b>Want to Activate</b></td>
					<g:if test="${linkOfficerInstance?.status == '' || linkOfficerInstance?.status == null}">
					<td>Yes:<g:radio name="status" value="yes"/>
					No:<g:radio name="status" value="no" checked="true"/>
					</td>
					</g:if>
					<g:if test="${linkOfficerInstance?.status == true}">
					<td>Yes:<g:radio name="status" value="yes" checked="true"/>
					No:<g:radio name="status" value="no"/>
					</td>
					</g:if>
					<g:if test="${linkOfficerInstance?.status == false}">
					<td>Yes:<g:radio name="status" value="yes"/>
					No:<g:radio name="status" value="no" checked="true"/>
					</td>
					</g:if>
					
					
				</tr>
			</tbody>
			
		</table>
		
		
		<style>
table {
	border-collapse: collapse;
	margin-left: 250px;
	padding: 10px;
	margin-top: 10px;
}

table tr td {
	padding: 8px;
}

table, th, td {
	border: 1px solid black;
}

.my-td-left {
	background: white;
	margin-bottom: 50px;
	width: 50%;
	height: auto;
	vertical-align: top;
	text-align: left;
}

.my-td-right {
	background: transparent;
	margin-bottom: 30px;
	width: 50%;
	height: 50px;
	vertical-align: top;
	text-align: left;
}

tr:nth-child(2n) td {
	height: 30px;
}
</style>