<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="dashPage" />
<title>NBA</title>
</head>
<body>
	<script>
		$(document).ready(function() {
			$( "div.success" ).fadeIn( 300 ).delay( 3000 ).fadeOut( 400 );
		});
	</script>

	<div class="content-wrapper">
		<div class="col-sm-12 paddingleft">
			<div id="costum-lft" class="col-sm-12">
		                            <g:if test="${message}">
					                    <div class="alert-box success">${message}</div>	
					                  </g:if>
				<table
					class="table table-bordered customtable draft-inner col-sm-12 rightdiv">
					<tr class="header">
					<th>S.No</th>
                    <th>Applicant Name</th>
                    <th>Form Applied</th>
                    <th>Appl.no</th>
                    <th>Subject</th>
                    <th>Send By</th>
                    <th>Create Date</th>
                    <th style="color:#ffff00">Letter No</th>
                    <th style="color:#ffff00">Send Date</th>
                    <th>Action</th>
					</tr>
					
			
					  <g:if test="${appLetter}">
					<g:each in="${appLetter}" var="commDaitls" status="j">
						<tr style="background: #fff;">
							<td>
								${j+1}
							</td>
							<td>
								${commDaitls.applicantName }
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
								${commDaitls?.sendBy}
							</td>
							<td><g:formatDate format="dd-MM-yyyy"
									date="${commDaitls?.createdDate}" /></td>
							<td>${commDaitls?.dynamicLetterNumberNbaOUT}</td>
							<td><g:formatDate format="dd-MM-yyyy"
									date="${commDaitls?.approvedDate}" /></td>
									
										<td><g:remoteLink action="viewLetterDetails"
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
					<tr><td colspan="10"><b ><center>No Letter is sent</center></b></td></tr>
					</g:else>
				</table>
<%----------------------------in process modal pop-up code start-----------------------------------------------------%>


			</div>
			<g:render template="/rightPane/matchdata"></g:render>
		</div>
	</div>
	<div id="success" class="modal fade" role="dialog">
<div class="modal-dialog modal-lg">
   <!-- Modal content-->
<div class="modal-content" id="nin" style="padding:8px;">
  <div class="modal-body" >
</div>
 </div>
</div>
</div>
</body>
</html>