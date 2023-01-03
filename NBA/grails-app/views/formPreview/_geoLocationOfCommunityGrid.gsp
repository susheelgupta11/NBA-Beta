<table class="table table-bordered datatable">
	<thead>
		<tr>
			<th>S.No.</th>
			<th>Community/Individual</th>
			<th>Village/ Panchayat</th>
			<th>Town/ Taluk</th>
			<th>District</th>
			<th>State</th>
			
		</tr>
	</thead>
	<tbody>
		<g:if test="${listOfCommunityLocations}">
			<%int i=1 %>
			<g:each in="${listOfCommunityLocations}" var="location">
				<tr>
					<td scope="row"><%=i %></td>
					<%i++ %>
					<td scope="row">
					${location?.communityKnowledge}	
					</td>
					<td scope="row">
						${location?.village}
					</td>
					<td scope="row">
						${location?.town}
					</td>
					
					<td scope="row">
						${location?.district}
					</td>
					<td scope="row">
						${location?.state}
					</td>
					
					
				</tr>
			</g:each>
		</g:if>
		<g:else>
			<tr>
				<td scope="row"></td>
				<td scope="row"></td>
				<td scope="row"></td>
				<td scope="row"></td>
				<td scope="row"></td>
				<td scope="row"></td>
				<td scope="row"></td>
			</tr>

		</g:else>

	</tbody>
</table>