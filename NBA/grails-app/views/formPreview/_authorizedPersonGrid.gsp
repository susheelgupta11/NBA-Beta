
	<table class="table table-bordered datatable">
		<thead>
			<tr>
				<th>Sl No.</th>
				<th>Name</th>
				<th>Address</th>
				<th>Mobile</th>
				<th>Email</th>
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
				
			</tr>
		</g:each>

	</table>

