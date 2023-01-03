<%! import org.nba.user.NbaUser %>
<html>
	<head>
		<meta name="layout" content="superAdmin">
		<title>NBA</title>
		<style>
.dot {
  height: 25px;
  width: 25px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
 
}
</style>
	</head>
	<body class="hold-transition skin-blue sidebar-mini">
  <div class="content-wrapper usess">
    <div class="col-sm-12 table-responsive">
    <g:link controller="loggedInAs" action="linkOfficer" class="btn btn-primary pull-right" style="margin-bottom: 5px;" >Link Officer</g:link>
 <g:if test="${message}">
			<span style="color: green; text-shadow: orange;"><b>${message}</b></span>
		</g:if>
        <table class="table table-bordered customtable" style="margin-left: 25px;">
      
            <tbody>
              <tr class="header">
              <th>S.No</th>
              <th>Officer Name</th>
              <th>Linked Officer Name</th>
              <th>Status</th>
              <th>Edit</th>
              <th>Delete</th>
            </tr>
<g:each in="${linkOfficerInstance}" status="i" var="userlist">
					<tr>
					<td>${i+1}</td>
						<td>${userlist?.nbaUserFrom?.name}</td>
						<td>${userlist?.nbaUserTo?.name}</td>
						<g:if test="${userlist?.status == true}">
						<td> <span class="dot" style=" background-color:green;"></span></td>
						</g:if>
						<g:elseif test="${userlist?.status == false}">
						<td> <span class="dot" style=" background-color:red;"></span></td>
						</g:elseif>
						
						<g:elseif test="${userlist?.status == '' || null == userlist?.status}">
						<td> <span class="dot"></span></td>
						</g:elseif>
						
					 <td><g:link action="editLinkOfficer" params="${[editId:userlist?.id]}"><i class="fa fa-edit"></i></g:link></td>
                     <td><g:link action="deleteOfficer" params="${[deleteId:userlist?.id]}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"><i class="fa fa-trash"></i></g:link></td>
					
					</tr>
				</g:each>
          </tbody>
          </table>
         
    </div>
 </div>
 
 
	</body>
</html>