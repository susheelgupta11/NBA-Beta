<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="dashPage" />
<title>NBA</title>
</head>
<body>

	<div class="content-wrapper">
		<div class="col-sm-12 paddingleft">
			<div id="costum-lft" class="col-sm-12" style="margin-left: 30px;">
				<table
					class="table table-bordered customtable draft-inner col-sm-12 rightdiv">
					<tr class="header">
						<th>S.No</th>
						<th>Application Name</th>
						<th>Form Applied</th>
						<th>App.no</th>
						<th>Subject</th>
						<th>Created By</th>
						<th>Date</th>
						<th>Action</th>
					</tr>
                  <g:if test="${draftItem}">
					<g:each in="${draftItem}" var="sbbDaitls" status="i">
						<tr style="background: #fff;">
							<td>
								${i+1}
							</td>
							<td>
								${sbbDaitls?.applicantName}
							</td>
							<td>
								${sbbDaitls?.formType}
							</td>
							<td>
								${sbbDaitls?.appNumber}
							</td>

							<td>
								${sbbDaitls?.subject?:'NA'}
							</td>
							<td>
								${sbbDaitls?.createdBy}
							</td>
							<td><g:formatDate format="dd-MM-yyyy"
									date="${sbbDaitls?.createdDate}" /></td>
					<td><g:link action="editSbbDraftLtr" params="${[editId:sbbDaitls?.id,formId:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt,status:false]}">Edit</g:link></td>
						</tr>
					</g:each>
					</g:if>
					<g:else>
					<tr style="background: #fff;"><td colspan="8">No Letter is created</td> </tr>
					</g:else>
				</table>
			</div>
			<g:render template="/rightPane/matchdata"></g:render>
		</div>
	</div>
</body>
</html>