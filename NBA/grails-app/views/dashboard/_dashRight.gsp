       <div class="col-md-3 abc1" id="sidebar" style="top:0;">
				  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">Communication <br>Received</a></li>
    <li><a data-toggle="tab" href="#menu1">Record <br> Room</a></li>
    
  </ul>

  <div class="tab-content">
        <div id="home" class="tab-pane fade in active table-responsive">
		  <table class="table">
                  <thead class="thead-dark">
                    <tr>
                      <th>S.No</th>
                      <th>Application No</th>
                      <th>Subject</th>
                      <th>Read</th>
                    </tr>
                  </thead>
                  <tbody>
                  <g:if test="${commApplication}">
                  
                  <g:each in="${commApplication}" var="comm" status="l">
                  
                  <g:if test="${comm?.client_id}">
                  <tr>
                  <td>${l+1}</td>
                  <td>${comm?.app_number}</td>
                  <td>${comm?.subject}</td>
                  <td>
<%-- <g:link controller="dashboard" action="quickViewComm" params="${[clientId:comm?.client_id]}"><i class="fa fa-eye"></i> </g:link>--%>
         <g:remoteLink action="viewCommunication" controller="letterCommunication" title="Client Communication Details"
									params="${[editId:comm?.client_id,csrfPreventionSalt:csrfPreventionSalt]}"
									data-target="#success" data-toggle="modal" update="nin">
								    <i class="fa fa-eye"></i>
				</g:remoteLink>	         
                  
                  </td>
                  </tr>
                  </g:if>
                  
                    <g:elseif test="${comm?.sbb_consent_id}">
                  <tr>
                  <td>${l+1}</td>
                  <td>${comm?.app_number}</td>
                  <td>${'Consent Reply '+comm?.app_number}</td>
                  <td>
                  
<%--                  <g:link controller="dashboard" action="quickViewComm" params="${[sbbConsentId:comm?.sbb_consent_id]}"><i class="fa fa-eye"></i></g:link>--%>
                  
                  <g:remoteLink action="viewConsent" controller="SBB" title="SBB Communication Details"
									params="${[editId:comm?.sbb_consent_id,csrfPreventionSalt:csrfPreventionSalt]}"
									data-target="#success" data-toggle="modal" update="nin">
								    <i class="fa fa-eye"></i>
				</g:remoteLink>	
                  
                  
                  </td>
                  </tr>
                  </g:elseif>
                  </g:each>
                  </g:if>
                  
                  <g:else>
                   <tr>
                     <td colspan="4">No communication Received</td>
		           </tr>
                  </g:else>
                   
		  </tbody>
		  </table>
		  <div id="success" class="modal fade" role="dialog">
<div class="modal-dialog modal-lg">
   <!-- Modal content-->
<div class="modal-content" style="padding:20px;" id="nin">
  <div class="modal-body" >
</div>
 </div>
</div>
</div>
        </div>
        <div id="menu1" class="tab-pane fade table-responsive">
		  <table class="table">
                  <thead class="thead-dark">
                    <tr>
                      <th>S.No</th>
                      <th>Application No</th>
                      <th>Status</th>
                      <th>Reason</th>
					  <th>Intiated By</th>
<%--					  <th>Details</th>--%>
					  <th>Action</th>
                    </tr>
                  </thead>
                  <tbody>
                    <g:if test="${virtualApplications}" >
                  <g:each in="${virtualApplications}" var="virtual" status="i">
                  <tr style="background:#fff;">
                    <td>${i+1}</td>
                    <td>${virtual?.appNumber}</td>
                    <td>${virtual?.currentStatus?.statusUpdate }</td>
                    <td>${virtual?.currentStatus?.reasonForRecordRoom}</td>
                    <td>${virtual?.currentStatus?.changedBy?.name}</td>
<%--                    <td>Need details for this field</td>--%>
                    <td><g:link controller="dashboard" action="movetoInbox" onclick="return confirmation('Are you sure')" params="${[instance:virtual?.id] }">Retrieve to Inbox</g:link></td>
                   
                  </tr>
                  </g:each>
                </g:if>
                <g:else>
                <tr><td colspan="7">No record found</td></tr>
                </g:else>
         
		  </tbody>
		  </table>
        </div>
      </div>
			</div>
			
			
			
			
	   