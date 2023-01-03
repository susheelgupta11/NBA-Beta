<%! import org.nba.common.State%>
<script type="text/javascript">
	$(document).ready(function() {
		function loadPage() {
			location.reload(true);
		}
	});
</script>
<div class="table-responsive">
<table class="table table-bordered datatable">
	<thead>
		<tr>
			<th>Sl.No</th>
			<th>Full name</th>
			<th>Profile</th>
			<th>Address</th>
			<th>Mobile</th>
			<th>Email</th>
			<th>Action</th>

		</tr>
	</thead>
	<%int i=1 %>
	<g:if test="${agentProfile != null}">
	<g:each in="${agentProfile}" var="agent">
		<tr>
			<td class="session1"><%=i %></td>
			<%i++ %>
			<td>
				${agent?.title} ${agent?.firstName} ${agent?.middleName} ${agent?.lastName}
			</td>
			<td>
				${agent?.profile}
			</td>
			<td>
				${agent?.address1} ${agent?.address2} ${agent?.address3} ${agent?.city} ${State.get(agent?.province)?.state}
			</td>
			<td>
				${agent?.mobile}
			</td>
			<%--<td>
				${agent?.phone}
			</td>
			--%><td>
				${agent?.email}
			</td>
			<td><g:if test="${company}">
				
					<g:remoteLink controller="applicationManagement" update="addEditAgentProfile" onSuccess= "showYes()"
						action="editAgentProfile" params='[agentId:agent?.id,formType:formType,company:company,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
						<img src="../images/edit.png" width="16" height="16" alt="edit"
							title="edit" >
					</g:remoteLink>
				
					<g:remoteLink controller="applicationManagement" update="updateAgentProfile1"
						action="deleteAgentProfile" params='[agentId:agent?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]' onComplete="loadPage();">
						<img src="../images/delete.png" width="16" height="16" alt="delete"
							title="delete" >
					</g:remoteLink>
				
				

				</g:if>
				
				<g:else>
					<g:remoteLink controller="applicationManagement" update="addEditAgentProfile" onSuccess="showYes()"
						action="editAgentProfile" params='[agentId:agent?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
						<img src="../images/edit.png" width="16" height="16" alt="edit"
							title="edit" >
					</g:remoteLink>
				
					  <g:remoteLink controller="applicationManagement" update="updateAgentProfile"
						action="deleteAgentProfile" params='[agentId:agent?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]' onSuccess="loadPage();">
						<img src="../images/delete.png" width="16" height="16" alt="delete"
							title="delete" >
					</g:remoteLink>
				</g:else>
				
				</td>
		</tr>
	</g:each>
	</g:if>
	
</table>
</div>
