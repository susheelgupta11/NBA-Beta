<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="nbaDashboardLayout" />
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
							<th>Application Name</th>
							<th>Form Applied</th>
							<th>App.no</th>
							<th>Subject</th>
							<th>Send By</th>
							<th>Created Date</th>
							<th style="color: #ffff00;">TR5 No</th>
							<th style="color: #ffff00;">Send Date</th>
						</tr>

						<g:each in="${tr5IssueList}" var="commDaitls" status="i">
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
									${commDaitls?.sendBy}
								</td>
								<td><g:formatDate format="dd/MM/yyyy" date="${commDaitls?.sendDate}"/></td>
								<td>${commDaitls?.tr5DynamicNumber}</td>
								<td><g:formatDate format="dd/MM/yyyy" date="${commDaitls?.sendDate}"/></td>
							</tr>
						</g:each>
					</table>
		
			</div>
		</div>
	</div>
</body>
</html>