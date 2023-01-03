<!DOCTYPE html>
<html lang="en">
<head>

<meta name="layout" content="superAdmin">
<title>NBA</title>
</head>

<body class="hold-transition skin-blue sidebar-mini">
  <div class="content-wrapper usess" >
    <div class="col-sm-12 table-responsive">
   <modalbox:modalIncludes />
  
  <modalbox:createLink url="addKMS.gsp" title="Add KMS Details!" width="600">
   <input type="submit" value="Add" class="btn btn-primary pull-right" style="margin-bottom: 5px;"/>
</modalbox:createLink>
<span><b>KMS Details</b></span>
 <g:if test="${message}">
			<span style="color: green; text-shadow: orange;"><b>${message}</b></span>
		</g:if>

        <table class="table table-bordered customtable" >
            <thead>
              <tr class="header">
              <th>S.No</th>
              <th style="text-align:left !important;">Title</th>
              <th>File Name</th>
              <th>Download File</th>
              <th>Delete</th>
            </tr>
            </thead>
            <g:javascript library="application" /> 

<tbody>
    <g:each var="kmsd" in="${kmsInstance}" status="j">
					<tr>
					<td>${j+1}</td>
					<td>${kmsd?.title}</td>
                                        <td>${kmsd?.fileName}</td>
                          <td>
<%--                          <modalbox:modalIncludes />--%>
<%--								<modalbox:createLink action="editKMS" params="[editId:kmsd?.id]" title="Update KMS Details!" width="600">--%>
<%--								<i class="fa fa-edit" style="font-size: 24 px"></i>--%>
<%--								</modalbox:createLink>--%>
<%--                          --%>
<g:link action="showKMS" controller="setMstrData" params="${[editId:kmsd?.id] }"><i class="fa fa-download"></i></g:link></td>
                          </td>
                          <td><g:link action="deleteKMS" params="[deleteId:kmsd?.id,csrfPreventionSalt:csrfPreventionSalt]"><i class="fa fa-trash-o" style="font-size:24px;color:red"></i></g:link>
               
					</tr>
                                        </g:each>
					</tbody>
				
 
          </table>
    </div>
  
  </div>
</body>
</html>