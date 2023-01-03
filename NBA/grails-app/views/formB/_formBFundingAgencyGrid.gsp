 <div class="table-responsive">
 <table class="table table-bordered datatable">
	 <thead>
		<tr>
			<th rowspan="2">Sl.No</th>
			<th rowspan="2">Institution/Organization name</th>
			<th rowspan="2">Address</th>
			<th rowspan="2" class="text-center" >Communication Particulars</th>
			<th rowspan="2"> Action</th> 
		</tr>	
		
	</thead>
	<tbody>
	<%int i=1 %>
	<g:each in="${listOfFundingAgency}" var="agency">
		<tr>
			<td class="session"><%=i %></td>
			<%i++ %>
			<td>
				${agency?.institutionOrganizationName}
			</td>
			<td>
				${agency?.address1}, ${agency?.address2} ${agency?.address3} ${agency?.city},
				${agency?.state}, ${agency?.country?.country}
			</td>
			<td>
				<b>Phone:</b> ${agency?.phone} <br/> <b>Email:</b>${agency?.email}<br/>
			</td>
			<td>
				<g:link controller="formB"
					action="formBPart3" 
					params='[appFormId:appForm?.id,agencyId:agency?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
					<img src="../images/edit.png" width="16" height="16" alt="edit"
						title="edit" />
				</g:link>
				<g:link controller="formB"
						action="deleteFundingAgency" 
						params='[appFormId:appForm?.id,agencyId:agency?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
						<img src="../images/delete.png" width="16" height="16"
							alt="delete" title="delete" />
				</g:link>
				
			</td>
		</tr>
	</g:each>
</tbody>
</table>
</div>