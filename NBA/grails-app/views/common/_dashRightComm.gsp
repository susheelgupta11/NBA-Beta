       <div class="col-md-3 abc1" id="sidebar" style="top:0;">
				  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">Application</a></li>
    <li><a data-toggle="tab" href="#menu1">Attachment</a></li>
    
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
                    <tr>
                      <th scope="row">1</th>
                      <td>Text</td>
                      <td>Text</td>
                      <td>@Text</td>
		  </tr>
		  <tr>
                      <th scope="row">1</th>
                      <td>Text</td>
                      <td>Text</td>
                      <td>@Text</td>
		  </tr>
		  <tr>
                      <th scope="row">1</th>
                      <td>Text</td>
                      <td>Text</td>
                      <td>@Text</td>
		  </tr>
		  </tbody>
		  </table>
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
					  <th>Details</th>
					  <th>Action</th>
                    </tr>
                  </thead>
                  <tbody>
                    <g:if test="${virtualApplications}" >
                  <g:each in="${virtualApplications}" var="virtual" status="i">
                  <tr style="background:#fff;">
                    <td>${i+1}</td>
                    <td>${virtual?.appNumber}</td>
                    <td>${virtual?.currentStatus?.status }</td>
                    <td>${virtual?.currentStatus?.reasonForRecordRoom}</td>
                    <td>${virtual?.currentStatus?.changedBy?.name}</td>
                    <td>Need details for this field</td>
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
			
			
			
			
	   