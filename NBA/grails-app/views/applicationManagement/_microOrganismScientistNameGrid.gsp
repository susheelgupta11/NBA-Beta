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


<g:if test="${listOfScientistName?.size() > 0}">
<table class="table table-bordered datatable">
		<g:if test="${listOfScientistName }">
			<thead>
				<tr>
					<th>Sl.No</th>
					<th>Scientific Name</th>
				
					
					<th>Action</th>

				</tr>
			</thead>
		</g:if>
		<%int i=1 %>
	<g:each in="${listOfScientistName}" var="profile">
		<tr>
			<td class="session"><%=i %></td>
			
			<td class="text-center">
				${profile?.scientistName} 
			</td>
			
			
			<td>
			
				<g:if test="${microOrgaScirntistName || deleteCalled }">
				<g:link controller="applicationManagement"
						action="editScientistName" onSuccess="" 
						params='[appFormId:appFormId,profileId:profile?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
						<img src="../../images/edit.png" width="16" height="16" alt="edit"
							title="edit" />
					</g:link>
					<g:link controller="applicationManagement" action="deleteScientistName" onclick="return beforeDelete();"
							params='[profileId:profile?.id,formType:formType,appFormId:appFormId,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
							<img src="../../images/delete.png" width="16" height="16"
								alt="delete" title="delete" />
					</g:link>
				</g:if>
				<g:elseif test="${!microOrgaScirntistName }">
					<g:link controller="applicationManagement"
						action="editScientistName" onSuccess="" 
						params='[appFormId:appFormId,profileId:profile?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
						<img src="../images/edit.png" width="16" height="16" alt="edit"
							title="edit" />
					</g:link>
												<g:link controller="applicationManagement" action="deleteScientistName" onclick="return beforeDelete();"
							params='[profileId:profile?.id,formType:formType,appFormId:appFormId,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
							<img src="../images/delete.png" width="16" height="16"
								alt="delete" title="delete" />
						</g:link>
					</g:elseif>
					
					
					
		
				
			</td>
			<%i++ %>
		</tr>
	</g:each>

</table>
</g:if>
