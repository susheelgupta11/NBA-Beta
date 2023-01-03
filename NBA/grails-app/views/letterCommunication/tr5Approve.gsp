<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="dashPage" />
<title>NBA</title>
</head>
<body>
	<div class="content-wrapper">
		<div class="col-sm-12 " style="padding-left: 26px !important">
			<div id="costum-lft" class="col-sm-12">

					<table
						class="table table-bordered customtable draft-inner col-sm-12 rightdiv">
						<tr class="header">
							<th>S.No</th>
							<th>Applicant Name</th>
							<th>Form Applied</th>
							<th>App.no</th>
							<th>Subject</th>
							<th>Approved By</th>
							<th>Created Date</th>
<%--							<th style="color: #ffff00;">TR5 No</th>--%>
							<th style="color: #ffff00;">Approved Date</th>
							<th>Action</th>
						</tr>
                     <g:if test="${approveItem}">
						<g:each in="${approveItem}" var="commDaitls" status="i">
							<tr style="background: #fff;">
								<td>
									${i+1}
								</td>
								<td>
									${commDaitls?.applicantName}
								</td>
								<td>
									${commDaitls?.formType}
								</td>
								<td>
									${commDaitls?.appNumber}
								</td>
								<td>
									${commDaitls?.subject}
								</td>
								<td>
									${commDaitls?.approvedBy}
								</td>
								<td><g:formatDate format="dd/MM/yyyy" date="${commDaitls?.createdDate}"/></td>
<%--								<td>${commDaitls?.tr5DynamicNumber}</td>--%>
								<td><g:formatDate format="dd/MM/yyyy" date="${commDaitls?.approvedDate}"/></td>
								<td><g:link action="tr5LetterEdit" controller="letterCommunication" params="${[dftIns:commDaitls?.id,instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt,status:true]}">View</g:link></td>
							</tr>
						</g:each>
						</g:if>
						<g:else>
					<tr><td colspan="10">No Letter is Approved</td></tr>
					</g:else>
					</table>
			</div>
			<g:render template="/rightPane/matchdata"></g:render>
		</div>
	</div>
</body>
</html>