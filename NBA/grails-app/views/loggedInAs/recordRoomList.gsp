<html>
<head>
<meta name='layout' content='superAdmin' />
<title>NBA</title>
</head>

<body>
 <div class="content-wrapper usess">
    <div class="col-sm-12 table-responsive">
<table class="table" id="myTable3">
						<thead class="thead-dark-reco">
							<tr>
								<th>S.No.</th>
								<th>Application Title</th>
								<th>Move By</th>
								<th>Move Date</th>
								<th>Status</th>
								<th>App. Submitted Date</th>
<%--								<th>Action</th>--%>
							</tr>
						</thead>
						<tbody>
						
							<g:each in="${recordRoomApplication}" var="applicationDetail"
								status="i">
<%--								<g:if test="${applicationDetail?.currentStatus?.statusUpdate}">--%>
									<tr>
										<td>
											${i+1}
										</td>
										<td>
											${applicationDetail?.appNumber}
										</td>
										<td>
											${applicationDetail?.currentStatus?.changedBy?.name}
										</td>
										<td><g:formatDate format="dd/MM/yyyy"
												date="${applicationDetail?.currentStatus?.forwardedDate}" /></td>

										<td><g:if
												test="${applicationDetail?.currentStatus?.statusUpdate}">
												${applicationDetail?.currentStatus?.statusUpdate}
											</g:if> <g:else>
												Update soon
												</g:else></td>
										<td>
										${applicationDetail?.submittedOn}
											
										</td>

<%--										<td><g:link action="addNote" controller="dashboard"--%>
<%--												params="${[instance:applicationDetail?.id,csrfPreventionSalt:csrfPreventionSalt] }"--%>
<%--												title="Assign to another user">--%>
<%--												<i class="fa fa-send"></i>--%>
<%--											</g:link>--%>
<%--											   <g:link controller="dashboard" action="movetoInbox" onclick="return confirmation('Are you sure to resend this')" params="${[instance:applicationDetail?.id,csrfPreventionSalt:csrfPreventionSalt] }" title="Send to another user"><i class="fa fa-send"></i> </g:link>	--%>
<%----%>
<%--										</td>--%>
									</tr>
<%--								</g:if>--%>
							</g:each>
						</tbody>
					</table>
</div>
</div>
</body>

</html>