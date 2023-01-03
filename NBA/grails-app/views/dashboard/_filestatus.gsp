<%! import org.nba.user.NbaUser %>
<%! import org.nba.user.NbaRole%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<style>
.modal {
    overflow-y:auto;
}
</style>
</head>
<body>

  <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">In-Process</h4>
      </div>
	<div>
		<h4 class="text-center" style="margin-bottom: 0px;">
			<b>File Status for Application No :- ${formDetails?.appNumber}</b>
		</h4>
	</div>
	<hr style="margin-top: 0px; border-top: 1px solid;" />

				<g:set var="counter" value="${1}" />
				<table border="1" align="center">
					<tr>
						<th>Live Desk</th>
						<th>Action</th>
						<th>Status</th>
						<th>Date</th>
					</tr>
					<g:if test="${applicationList}">
					<g:each in="${applicationList}" var="applicationListInstance"
						status="i">
						<tr>
							<td>
							
							<% def currentDesk = NbaUser?.findByUsername(applicationListInstance?.forwardMember) %>
							<g:if test="${currentDesk}">
							${currentDesk?.name} - [${currentDesk?.nbaRole?.authority}]
							</g:if>
							<g:else>
							<% def currentTable = NbaUser?.findByAnswer(applicationListInstance?.forwardMember) %>
							${currentTable?.name} - [${currentTable?.nbaRole?.authority}]
							</g:else>
							
								
							</td>
							<td>
								${applicationListInstance?.actions}
							</td>
							<td>${applicationListInstance?.statusUpdate?:'NA'}</td>
							<td><g:formatDate format="dd/MM/yyyy hh:mm aa"
									date="${applicationListInstance?.noteDate}" /> <g:if
									test="${counter == 1}">
									<i class="fa fa-check"></i>
								</g:if></td>
						</tr>
						<g:set var="counter" value="${counter + 1}" />
					</g:each>
					</g:if>
					<g:else>
					<tr><td colspan="4">Application is at Initial stage</td></tr>
					</g:else>
				</table>
				<div class="modal-footer">
        <button type="button" class="btn btn-default"  data-dismiss="modal">Close</button>
      </div>
</body>
</html>