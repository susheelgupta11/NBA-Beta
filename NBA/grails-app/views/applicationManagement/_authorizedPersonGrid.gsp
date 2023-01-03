<div class="table-responsive">
	<table class="table table-bordered datatable">
		<thead>
			<tr>
				<th>Sl No.</th>
				<th>Name</th>
				<th>Address</th>
				<th>Mobile</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
		</thead>
		<%int i=1 %>
		<g:each in="${listOfContactPerson}" var="profile">
			<tr>
				<td class="session"><%=i %></td>
				<%i++ %>
				<td>
					${profile?.nameOfContactPerson}
				</td>
				<td>
					${profile?.addressOfContactPerson}
				</td>
				
				<td>
					${profile?.mobileOfContactPerson}
				</td>
				
				<td>
					${profile?.emailOfContactPerson}
				</td>
				<td><g:remoteLink controller="applicationManagement" 
						action="editForm1Part3" update="authorizedPersons"
						params='[profileId:profile?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
						<img src="../images/edit.png" width="16" height="16" alt="edit"
							title="edit" />
					</g:remoteLink> <g:remoteLink controller="applicationManagement"
						action="deleteAuthorizedPerson" update="divAuthorizedPersonGrid"
						params='[profileId:profile?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
						<img src="../images/delete.png" width="16" height="16"
							alt="delete" title="delete" />
					</g:remoteLink></td>
			</tr>
		</g:each>

	</table>
</div>
