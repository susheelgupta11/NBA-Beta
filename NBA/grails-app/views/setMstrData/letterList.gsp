<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="superAdmin"/>
<title>NBA</title>
</head>
	<body class="hold-transition skin-blue sidebar-mini">
  <div class="content-wrapper usess">
    <div class="col-sm-12 table-responsive">
    <g:link controller="setMstrData" action="addLetter" class="btn btn-primary pull-right" style="margin-bottom: 5px;" >Add New</g:link>
    
         <g:if test="${message}">
			<span style="color: green; text-shadow: orange;"><b>${message}</b></span>
		</g:if>
        <table class="table table-bordered customtable" style="margin-left: 25px;">
      
            <tbody>
              <tr class="header">
              <th>S.No</th>
              <th>Letter Name</th>
              <th>Created Date</th>
              <th>Edit</th>
              <th>Delete</th>
            </tr>
             <g:if test="${letterlist}">
  <g:each in="${letterlist}" status="i" var="letterInstance">
  <tr>
			      	<td>${i+1}</td>
						<td>${letterInstance?.letterName}</td>
						<td><g:formatDate format="dd-MM-yyyy" date="${letterInstance?.templateCreationDate}"/></td>	
						
						 <td><g:link action="editLetter" params="${[idEdit:letterInstance?.id,csrfPreventionSalt:csrfPreventionSalt]}">
					 <i class="fa fa-edit" style="font-size:20px"></i></g:link></td>
					 
					 	 <td><g:link action="deleteLetter" params="${[idDelete:letterInstance?.id,csrfPreventionSalt:csrfPreventionSalt]}" onclick="return confirm('Are you sure to delete?');">
					 <i class="fa fa-trash" style="font-size:20px"></i></g:link></td>
					
						</tr>
				</g:each>
				</g:if>
				<g:else>
			<tr><td colspan="5"> No letter created </td></tr>
				</g:else>
          </tbody>
          </table>
    </div>
 </div>
	</body>
</html>