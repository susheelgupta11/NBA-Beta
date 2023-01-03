<%@ page import="org.nba.user.NbaUser" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta name="layout" content="superAdmin">
		<title>NBA</title>

<style type="text/css">
.dot {
  height: 25px;
  width: 25px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
 }	
</style>	
		

	</head>
	<body>
	<script>
$(document).ready(function () {
$( "div.success" ).fadeIn( 300 ).delay( 3000 ).fadeOut( 400 );

});
</script>	
	
  <div class="content-wrapper">
<%--     <g:link controller="nbaUser" action="create" class="btn btn-primary pull-right" style="margin-bottom: 5px;" >Add User</g:link>--%>

    <div class="col-sm-12 table-responsive">
                  <div>
		       <g:if test="${message}">
					<div class="alert-box success">${message}</div>	
				</g:if>
				
              </div>
        <table class="table table-bordered"  id="us-data">
      
           <thead  class="bg-primary">
              <tr>
              <th>S.No</th>
              <th>Name</th>
              <th>User Name</th>
              <th>Role</th>
              <th>Status</th>
             <th>Create Date</th>
              <th>Edit</th>	
              <th>Change Status</th>
            </tr>
            </thead>
            <tbody>
        <g:each in="${nbaUserInstanceList}" status="i" var="nbaUserInstance">
         
					<tr>
					<td>${i+1}</td>
						<td>${nbaUserInstance?.name}</td>
						<g:if test="${nbaUserInstance?.accountLocked == false}">
						<td>${nbaUserInstance?.username}</td>
						</g:if>
						<g:else>
						<td></td>
						</g:else>
						<td>${nbaUserInstance?.nbaRole?.authority?: 'Not Assign'}</td>
						
						<g:if test="${nbaUserInstance?.accountLocked == true}">
						<td> <span class="dot" style=" background-color:red;"></span></td>
						</g:if>
						<g:elseif test="${nbaUserInstance?.accountLocked == false}">
						<td> <span class="dot" style=" background-color:green;"></span></td>
						</g:elseif>
					
						<td><g:formatDate format="dd-MM-yyyy" date="${nbaUserInstance?.dtCreated}"/></td>
					 <td><g:link action="edit" params="${[id:nbaUserInstance?.id,csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-edit" style="font-size:20px"></i></g:link></td>
					 
					 <g:if test="${nbaUserInstance?.accountLocked == false}">
                     <td><g:link action="changeUser" params="${[id:nbaUserInstance?.id,status:'deactivate',csrfPreventionSalt:csrfPreventionSalt]}" onclick="return confirm('Are you sure to deactivate?');"><i class="fa fa-power-off" style="font-size:20px;color:red"></i></g:link></td>
					</g:if>
					<g:else>
					 <td><g:link action="changeUser" params="${[id:nbaUserInstance?.id,status:'activate',csrfPreventionSalt:csrfPreventionSalt]}" onclick="return confirm('Are you sure to activate?');"><i class="fa fa-power-off" style="font-size:20px"></i></g:link></td>
					</g:else>
					</tr>
				</g:each>
          </tbody>
          </table>

    </div>
 </div>

	</body>
</html>
