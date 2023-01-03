<!DOCTYPE html>

<html lang="en">

<head>
<meta name='layout' content='dashPage' />
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
							<b>File Movements for Application No :- ${formDetails?.appNumber}</b>
						</h4>
					</div>
					<hr style="margin-top: 0px; border-top: 1px solid;" />

					<ul id="comments-list" class="">
						<li>
							<div class="comment-main-level">
								<g:set var="counter" value="${1}" />
								<table>
									<tr>
										<th>Forward Member</th>
										<th>Action</th>
										<th>Status</th>
										<th>Date</th>
									</tr>
									<g:each in="${applicationList}" var="applicationListInstance"
										status="i">
										<tr>
											<td>
												${applicationListInstance?.forwardMember}
											</td>
											<td>${applicationListInstance?.actions}</td>
											
											<td>${applicationListInstance?.statusUpdate}</td>
											<td>
											<g:formatDate format="dd/MM/yyyy hh:mm aa" date="${applicationListInstance?.noteDate}"/>	
											 <g:if test="${counter == 1}">
													<i class="fa fa-check"></i>
											 </g:if>
											</td>
										</tr>
										<g:set var="counter" value="${counter + 1}" />
									</g:each>
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










