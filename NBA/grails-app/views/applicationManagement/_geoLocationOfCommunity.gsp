<%! import org.nba.common.State %>
<%--<g:if test="${consentObtained != 'No' }">--%>
<table class="table table-bordered datatable">
	<thead>
		<tr>
			<th>S.No.</th>
			<th>Community/Individual</th>
			<th>Village/ Panchayat</th>
			<th>Town/ Taluk</th>
			<th>District</th>
			<th>State</th>
			
			<th>Action</th>
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
						${State?.findById(location?.state)?.state}
					</td>
					
					<td><g:remoteLink controller="applicationManagement" onSuccess="AddValidationGeographical_edit()"
						action="form1Part3" update="geoLocationOfCommunityForm" 
						params='[locationId:location?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
						<img id="imgeditpart2" src="../images/edit.png" width="16" height="16" alt="edit"
							title="edit" />
					</g:remoteLink>
					<g:remoteLink controller="applicationManagement"
						action="deleteGeoLocationOfCommunity" update="updateCommunityLocations"
						params='[locationId:location?.id,formType:formType,appFormID:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
						<img src="../images/delete.png" width="16" height="16"
							alt="delete" title="delete" />
					</g:remoteLink></td>
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
<%--</g:if>--%>