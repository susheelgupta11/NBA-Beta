

 <div class="table-responsive">
 <table class="table table-bordered datatable">
 <thead>
	<tr>
		<th>Sl.No</th>
		<th>Entity name</th>
		<th>Entity type</th>
		<th>Address</th>
		<th>Mobile</th>
		<th>Phone</th>
		<th>Email</th>
		<th>Website</th>

	</tr>
	</thead>
	<tbody>
	<%int i=1 %>
	<g:each in="${listOfCompanyData}" var="profile">
		<tr>
			<td class="session"><%=i %></td>
			<%i++ %>
			<td>
				${profile?.entityName}
			</td>
			<td>
				${profile?.entityType}
			</td>
			<td>
				${profile?.address1} ${profile?.address2} ${profile?.address3} ${profile?.city}
				${profile?.province} ${profile?.country?.country}
			</td>
			<td>
				${profile?.mobile}
			</td>
			<td>
				${profile?.phone}
			</td>
			<td>
				${profile?.email}
			</td>
			<td>
				${profile?.website}
			</td>
			
		</tr>
	</g:each>
</tbody>
</table>
</div>