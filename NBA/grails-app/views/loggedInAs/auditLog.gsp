<!DOCTYPE html>

<html lang="en">

<head>
<meta name='layout' content='superAdmin' />
<title>NBA</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>


<body>

	<div class="content-wrapper">
		<div class="col-sm-12 paddingleft">

			<div>
				<span><g:if test="${flash.message}">
						<div class="message" style="display: block; margin-left: 55px;">
							${flash.message}
						</div>
					</g:if> </span>
			</div>
			<div id="costum-lft" class="col-sm-12">
				<div class="col-sm-12 rightdiv"
					style="padding-top: 0px; left: 22px;">
					<div>
						<h4 class="text-center" style="margin-bottom: 0px;">
							<b>User Logs</b>
						</h4>
					</div>
					<hr style="margin-top: 0px; border-top: 1px solid;" />

					<ul id="comments-list" class="">
						<li>
							<div class="comment-main-level">
								
								<table id="user-log">
								<thead class="bg-primary">
									<tr>
										<th>Sr No.</th>
										<th> Name</th>
										<th>User Name</th>
										<th> IP Address</th>
										<th>Login Time</th>
										<th>Logout Time</th>
									</tr>
									</thead>
									<tbody>
									<g:each in="${userLogs}" var="log" status="i">
										<tr>
											<td>
												${i+1}
											</td>
											<td>${log?.name}</td>
											<td>${log?.userName}</td>
											<td>${log?.ip}</td>
											
											<td>
											<g:formatDate format="dd/MM/yyyy hh:mm aa" date="${log?.loginTime}"/>											
											</td>
											
											<td>
											<g:formatDate format="dd/MM/yyyy hh:mm aa" date="${log?.logoutTime}"/>											
											</td>
										</tr>
										
									</g:each>
									</tbody>
								</table>

							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>










