<script>

	function beforeDelete(){
			alert("Are you sure you want to delete the Scientist Name?");
		}

	function beforeDelete() {
	    var txt;
	    var r = confirm("Are you sure you want to delete the Scientist Name?");
	    if (r == true) {
	        return true;
	    } else {
	    	return false;
	    }
	    //document.getElementById("demo").innerHTML = txt;
	}
</script>



<table class="table table-bordered datatable">

	<thead>
		<tr>
			<th>Sl.No</th>
			<th>Scientific Name</th>
			<th>Source of access</th>
			<th>Village Name</th>
			<th>Town/ Taluk</th>
			<th>District</th>
			<th>State</th>
			<th>Name</th>
			<th>Contact details</th>

			<th>Action</th>

		</tr>
	</thead>

	<%int i=1 %>



	<g:each in="${locations}" var="profile" status="k">

		<%--<g:each in="${profile1}" var="profile" >
				--%>
		<tr>
			<td class="session"><%=i %></td>
			<td class="text-center">
				${profile?.bioResource?.scientistName}
			</td>
			<td class="text-center">
				${profile?.source}
			</td>
			<td class="text-center"><g:if test="${profile?.village}">
					${profile?.village}
				</g:if> <g:else>
												N/A
											</g:else></td>
			<td class="text-center"><g:if test="${profile?.town}">
					${profile?.town}
				</g:if> <g:else>
												N/A
											</g:else></td>
			<td class="text-center"><g:if test="${profile?.district}">
					${profile?.district}
				</g:if> <g:else>
												N/A
											</g:else></td>
			<td class="text-center"><g:if test="${profile?.state}">
					${profile?.state}
				</g:if> <g:else>
												N/A
											</g:else></td>
			<td class="text-center"><g:if test="${profile?.traderName}">
					${profile?.traderName}
				</g:if> <g:else>
										N/A
									</g:else></td>
			<td class="text-center"><g:if test="${profile?.traderContactDetails}">
					${profile?.traderContactDetails}
				</g:if> <g:else>
										N/A
									</g:else></td>
			<td class="text-center"><g:if
					test="${microOrgaScirntistName || deleteCalled }">
					<g:link controller="applicationManagement"
						action="editGeoMicroOrganism" onSuccess=""
						params='[profileId:profile?.id,bioresourceId:bioresource?.id,formType:formType,appFormId:appFormId,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
						<img src="../../images/edit.png" width="16" height="16" alt="edit"
							title="edit" />
					</g:link>
					<g:link controller="applicationManagement"
						action="deleteGeoMicroOrganism" onclick="return beforeDelete();"
						params='[profileId:profile?.id,formType:formType,appFormId:appFormId,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
						<img src="../../images/delete.png" width="16" height="16"
							alt="delete" title="delete" />
					</g:link>
				</g:if> <g:elseif test="${!microOrgaScirntistName }">
					<g:link controller="applicationManagement"
						action="editGeoMicroOrganism" onSuccess=""
						params='[profileId:profile?.id,bioresourceId:bioresource?.id,formType:formType,appFormId:appFormId,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
						<img src="../images/edit.png" width="16" height="16" alt="edit"
							title="edit" />
					</g:link>
					<g:link controller="applicationManagement"
						action="deleteGeoMicroOrganism" onclick="return beforeDelete();"
						params='[profileId:profile?.id,formType:formType,appFormId:appFormId,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
						<img src="../images/delete.png" width="16" height="16"
							alt="delete" title="delete" />
					</g:link>
				</g:elseif></td>
			<%i++ %>
		</tr>
	</g:each>
	<%--</g:each>
	

--%>
</table>

