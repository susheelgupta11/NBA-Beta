<script>

	function beforeDelete(){
			alert("Are you sure you want to delete the applicant?");
		}

	function beforeDelete() {
	    var txt;
	    var r = confirm("Are you sure you want to delete the applicant?");
	    if (r == true) {
	        return true;
	    } else {
	    	return false;
	    }
	    //document.getElementById("demo").innerHTML = txt;
	}
</script>

<div id="myModalConfirm" class="modal fade" role="dialog"
		style="z-index: 9999999;">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Confirm message</h4>
				</div>
				<div class="modal-body">
					<p>Are you sure you want to proceed?</p>
				</div>
				<div class="modal-footer">
					<g:link controller="applicationManagement" post="true"
						action="deleteProfile"
						params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'
						class="btn btn-success">Ok</g:link>
					<button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
				</div>
			</div>

		</div>
	</div>

<div class="table-responsive">
<g:if test="${listOfIndividualProfiles?.size() > 0}">
<table class="table table-bordered datatable">
		<g:if test="${listOfIndividualProfiles }">
			<thead>
				<tr>
					<th>Sl.No</th>
					<th>Full name</th>
					<th>Profile</th>
					<th>Address</th>
					<th>Mobile</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Action</th>

				</tr>
			</thead>
		</g:if>
		<%int i=1 %>
		
	<g:each in="${listOfIndividualProfiles}" var="profile">
		<tr>
			<td class="session"><%=i %></td>
			
			<td>
				${profile?.title} ${profile?.firstName} ${profile?.middleName} ${profile?.lastName}
			</td>
			<td>
				${profile?.profile}
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
			<% def listttt =  listOfIndividualProfiles.size() - 1 %>
				<g:if test="${individualProfile || deleteCalled }">
					<g:link controller="applicationManagement"
						action="editIndividualProfile" 
						params='[appFormId:appForm?.id,profileId:profile?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
						<img src="../../images/edit.png" width="16" height="16" alt="edit"
							title="edit" />
					</g:link>
					<g:if test="${listOfIndividualProfiles?.size() == 1}">
						<g:link controller="applicationManagement" action="deleteProfile" onclick="return beforeDelete();"
							params='[profileId:profile?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
							<img src="../../images/delete.png" width="16" height="16"
								alt="delete" title="delete" />
						</g:link>
					</g:if>
					<g:else>
						<g:link controller="applicationManagement" action="deleteProfile"
							params='[profileId:profile?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
							<img src="../../images/delete.png" width="16" height="16"
								alt="delete" title="delete" />
						</g:link>
					</g:else>		
				</g:if>
				<g:elseif test="${!individualProfile }">
					<g:link controller="applicationManagement"
						action="editIndividualProfile" onSuccess="updateCountry(null,${profile?.nationality})" 
						params='[appFormId:appForm?.id,profileId:profile?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
						<img src="../images/edit.png" width="16" height="16" alt="edit"
							title="edit" />
					</g:link>
					<g:if test="${listOfIndividualProfiles?.size() == 1}">
						<g:link controller="applicationManagement" action="deleteProfile" onclick="return beforeDelete();"
							params='[profileId:profile?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
							<img src="../images/delete.png" width="16" height="16"
								alt="delete" title="delete" />
						</g:link>
					</g:if>
					<g:else>
						<g:link controller="applicationManagement" action="deleteProfile"
							params='[profileId:profile?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
							<img src="../images/delete.png" width="16" height="16"
								alt="delete" title="delete" />
						</g:link>
					</g:else>
					
					
				</g:elseif> 
				
				
			</td>
			<%i++ %>
		</tr>
	</g:each>

</table>
</g:if>
</div>