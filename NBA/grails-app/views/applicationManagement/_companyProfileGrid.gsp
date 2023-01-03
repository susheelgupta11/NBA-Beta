 <div class="table-responsive">
 <table class="table table-bordered datatable">
 <g:if test= "${listOfCompanyProfiles }">
 <thead>
	<tr>
		<th rowspan="2">Sl.No</th>
		<th rowspan="2">Entity name</th>
		<th rowspan="2">Entity type</th>
		<th rowspan="2">Address</th>
		<th rowspan="2" class="text-center" >Communication Particulars</th>
<%--		<th rowspan="2">Phone</th>--%>
<%--		<th rowspan="2">Email</th>--%>
<%--		<th rowspan="2">Website</th>--%>
		<th rowspan="2">Nature of Business</th>
		<th colspan="3" class="text-center">
		Details of Authorized Representative of Entity
		</th>
		<th rowspan="2"> Action</th> 
	</tr>	
		
		<tr>
		
		<th>Full Name</th>
		<th class="text-center">Designation </th>
		<th>Communication Particulars </th>
<%--		<th>Email</th>--%>
		</tr>
		
		
	</thead>
	</g:if>
	<tbody>
	<%int i=1 %>
	<g:each in="${listOfCompanyProfiles}" var="profile">
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
				<b>Mobile:</b> ${profile?.mobile} <br/> <b>Phone:</b> ${profile?.phone} <br/> <b>Email:</b>${profile?.email}<br/>
				<b>Website:</b>${profile?.website}
			</td>
<%--			<td>--%>
<%--				${profile?.phone}--%>
<%--			</td>--%>
<%--			<td>--%>
<%--				${profile?.email}--%>
<%--			</td>--%>
<%--			<td>--%>
<%--				${profile?.website}--%>
<%--			</td>--%>
			<td>
				${profile?.businessNature}
			</td>
			
			<td>${profile?.title} ${profile?.firstName} ${profile?.middleName} ${profile?.lastName}</td>
			<td>${profile?.designation}</td>
			<td><b>Mobile:</b>${profile?.personMobile}<br/> <b>Email:</b>${profile?.personEmail}</td>
<%--			<td>${profile?.personEmail}</td>--%>
			<td>
			<g:if test="${companyProfile1 || deleteCompanyCalled }">
				<g:link controller="applicationManagement"
					action="editCompanyProfile" 
					params='[appFormId:appForm?.id,profileId:profile?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
					<img src="../../images/edit.png" width="16" height="16" alt="edit"
						title="edit">
				</g:link>
				<g:link controller="applicationManagement"
						action="deleteCompanyProfile" 
						params='[appFormId:appForm?.id,profileId:profile?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
						<img src="../../images/delete.png" width="16" height="16"
							alt="delete" title="delete" />
				</g:link>
			</g:if>
			<g:elseif test="${!companyProfile1}">
				<g:link controller="applicationManagement"
					action="editCompanyProfile" 
					params='[appFormId:appForm?.id,profileId:profile?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
					<img src="../images/edit.png" width="16" height="16" alt="edit"
						title="edit" />
				</g:link>
				<g:link controller="applicationManagement"
						action="deleteCompanyProfile" 
						params='[appFormId:appForm?.id,profileId:profile?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
						<img src="../images/delete.png" width="16" height="16"
							alt="delete" title="delete" />
				</g:link>
				
			</g:elseif>
				
			</td>
		</tr>
	</g:each>
</tbody>
</table>
</div>