<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name='layout' content='dashPage' />
<title>NBA</title>
</head>
<body>
	<div class="content-wrapper">
		<div class="col-sm-12" style="padding-left: 26px !important">
			<div id="costum-lft" class="col-sm-12">
				
					<table
						class="table table-bordered customtable draft-inner col-sm-12 rightdiv">
						<tr class="header">
							<th>S.No</th>
							<th>Applicant Name</th>
							<th>App.no</th>
							<th>Subject</th>
							<th>Created By</th>
							<th>Date</th>
							<th>Action</th>
						</tr>
						<g:if test="${draftItem}">
						<g:each in="${draftItem}" var="commDaitls" status="i">
							<tr style="background: #fff;">

								<td>
									${i+1}
								</td>
								<td>
									${commDaitls?.applicantName}
								</td>
								<td>
									${commDaitls?.applicationForm1?.appNumber }
								</td>

								<td>
									${commDaitls?.subject}
								</td>
								<td>
									${commDaitls?.createdBy}
								</td>
								<td>
								<g:formatDate format="dd/MM/yyyy" date="${commDaitls?.createdDate}"/></td>
								
								<td><g:link action="tr5LetterEdit" controller="letterCommunication" params="${[dftIns:commDaitls?.id,instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt,status:false]}">View</g:link></td>
							</tr>
						</g:each>
						</g:if>
						<g:else>
						<tr><td colspan="7">No Draft Found</td></tr>
						
						</g:else>
					</table>
				
			</div>
			<g:render template="/rightPane/matchdata"></g:render>
		</div>
	</div>
</body>