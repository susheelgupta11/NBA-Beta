
	<table class="table table-bordered datatable">
		<thead>
			<tr>
				<th>Sl No.</th>
				<th>Name</th>
				<th>Address</th>
				<th>State/Province</th>
				<th>Zip/Pincode</th>
				<th>Country</th>
				<th>Telephone</th>
				<th>Fax</th>
				<th>Website</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
		</thead>
		<%int i=1 %>
		<g:each in="${listOfThirdParty}" var="thirdParty">
			<tr>
				<td class="session"><%=i %></td>
				<%i++ %>
				<td>
					${thirdParty?.name}
				</td>
				<td>
					${thirdParty?.addressForComm}
				</td>
				<td>
					${thirdParty?.state}
				</td>
				<td>
					${thirdParty?.pincode}
				</td>
				<td>
					${thirdParty?.country}
				</td>
				<td>
					${thirdParty?.phone}
				</td>
				<td>
					${thirdParty?.fax}
				</td>
				<td>
					${thirdParty?.website}
				</td>
				<td>
					${thirdParty?.email}
				</td>
				<td><g:link controller="form4"
						action="part3" 
						params='[thirdPartyInstId:thirdParty?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
						<img src="../images/edit.png" width="16" height="16" alt="edit"
							title="edit" />
					</g:link> <g:remoteLink controller="form4"
						action="deleteThirdParty" update ="thirdPartyGrid"
						params='[thirdPartyInstId:thirdParty?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
						<img src="../images/delete.png" width="16" height="16"
							alt="delete" title="delete" />
					</g:remoteLink></td>
			</tr>
		</g:each>

	</table>

