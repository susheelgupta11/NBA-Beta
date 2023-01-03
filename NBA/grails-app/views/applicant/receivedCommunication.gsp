<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="applicant"/>
<title>NBA</title>
</head>
<body>
 <g:if test="${message}">
			<script>
	      alert("${message}");
			</script>
		</g:if>

	<div class="content-wrapper">
		<div class="col-sm-12 paddingleft">
			<div id="costum-lft" class="col-sm-12" >
				<table
					class="table table-bordered customtable draft-inner col-sm-12 rightdiv">
					<tr class="header">
					<th>S.No</th>
                    
                    <th>Form Applied</th>
                    <th>Appl.no</th>
                    <th>Subject</th>
                    <th>Send By</th>
                
                    <th style="color:#ffff00">Letter No</th>
                    <th style="color:#ffff00">Send Date</th>
                    <th>Action</th>
					</tr>
					
			
					  <g:if test="${receivedLetter}">
					<g:each in="${receivedLetter}" var="commDaitls" status="j">
						<tr style="background: #fff;">
							<td>
								${j+1}
							</td>
							
							<td>
								${commDaitls?.formType}
							</td>
							<td>
								${commDaitls?.appNumber }
							</td>

							<td>
								${commDaitls?.subject?:'NA'}
							</td>
							<td>
								${commDaitls?.approvedBy}
							</td>
							
							<td>${commDaitls?.dynamicLetterNumberClientIN}</td>
							<td><g:formatDate format="dd-MM-yyyy"
									date="${commDaitls?.approvedDate}" /></td>
									
									<td>
<%--								<g:remoteLink action="viewLetter"--%>
<%--										controller="applicant" title="Communication Details"--%>
<%--									params="${[editId:commDaitls?.id,formId:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]}"--%>
<%--									data-target="#success" data-toggle="modal" update="nin">--%>
<%--								    <i class="fa fa-file-text"></i>--%>
<%--									</g:remoteLink>	--%>

<g:remoteLink action="viewLetterDetails"
																controller="LetterCommunication" title="Check letter Details"
																params="${[editId:commDaitls?.id,csrfPreventionSalt:csrfPreventionSalt] }"
																data-target="#success" data-toggle="modal" update="nin">
																<i class="fa fa-file-text"></i>
															</g:remoteLink>
									
					</td>
						</tr>
					</g:each>
					</g:if>
					<g:else>
					<tr><td colspan="9"><b ><center>No Letter is received</center></b></td></tr>
					</g:else>
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
		</div>
	</div>
</body>
</html>