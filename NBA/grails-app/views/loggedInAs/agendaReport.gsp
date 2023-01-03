<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content='superAdmin' />
<title>NBA</title>
</head>
<body>
	<div class="content-wrapper">
		<div class="col-sm-12 " style="padding-left: 26px !important">
			<div id="costum-lft" class="col-sm-12">

				<table class="table table-bordered customtable draft-inner col-sm-12 rightdiv">
					<tr>
                        <th>S.No</th>
						<th>Name</th>
						<th>App Number</th>
						<th>Form Type</th>
						<th>Created By</th>
						<th>Updated By</th>
						<th>Created Date</th>
					</tr>
					<tbody>
					<g:if test="${agendaInstance}">
						<g:each in="${agendaInstance}" var="agenda" status="i">
							<tr>
							<td>${i+1}</td>
								<td>
									${agenda?.name }
								</td>
								<td>
									${agenda?.appNumber}
								</td>
								<td>
									${agenda?.formType}
								</td>
								<td>
									${agenda?.createdBy}
								</td>
								<td>
									${agenda?.updatedBy}
								</td>
								
								<td>
									${agenda?.createDate}
								</td>

							</tr>
						</g:each>
                  </g:if>
                  <g:else>
                  <tr><td colspan="7">No Agenda Approved</td></tr>
                  
                  </g:else>
					</tbody>

				</table>
			</div>
		</div>
	</div>
</body>
</html>