<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="dashPage" />
<title>NBA</title>
</head>
<body>
	<div class="content-wrapper">
		<div class="col-sm-12 paddingleft">
			<div id="costum-lft" class="col-sm-12">
				<table
					class="table table-bordered customtable">
					<tr class="header">
						<th>S.No</th>
						<th>Application Name</th>
						<th>Form Applied</th>
						<th>App.no</th>
						<th>Updated By</th>
						<th>Date</th>
						<th>Action</th>
						
					</tr>
                  <g:if test="${agendaInstance}">
					<g:each in="${agendaInstance}" var="agdDaitls" status="i">
						<tr style="background: #fff;">
							<td>
								${i+1}
							</td>
							<td>
								${agdDaitls?.name }
							</td>
							<td>
								${agdDaitls?.formType}
							</td>
							<td>
								${agdDaitls?.appNumber }
							</td>

					
							<td>
								${agdDaitls?.updatedBy?:agdDaitls?.approveBy}
							</td>
							<td><g:formatDate format="dd-MM-yyyy"
									date="${agdDaitls?.updateDate?:agdDaitls?.sendDate}" /></td>
								
																					
							<td><g:link action="editAgenda" params="${[editId:agdDaitls?.id,formId:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt,status:'approve']}">Edit</g:link></td>
									
								
						</tr>
					</g:each>
					</g:if>
					<g:else>
					<tr style="background: #fff;"><td colspan="8">No Agenda is approved</td> </tr>
					</g:else>
				</table>
			</div>
			<g:render template="/rightPane/matchdata"></g:render>
		</div>
	</div>
</body>
</html>