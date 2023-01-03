<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="projectPreview" />
<title></title>
<script type="text/javascript">
	$(function() {
		window.print();
	});
</script>
<style>
table {
	font-size: 1.2em;
}
</style>
</head>
<body>
	<g:if test="${printInstance?.other}">
		<script>
$( document ).ready(function() {
	document.getElementById("mySelect").style.display = 'block';
});

</script>
	</g:if>


	<div class="content-wrapper">
		<div class="col-sm-12 paddingleft" style="margin-top: 4px;">
			<div id="costum-lft" class="col-sm-12">
				<div class="col-sm-12 rightdiv" style="">
<%-- <a href="http://139.59.4.110:8082/NBA/login/auth" target="_blank">--%>
<%--                             <img src="http://139.59.4.110:8082/NBA/assets/Logo1-9de1c2fa396fb0e8af1ba72ffc12b3dc.jpg" width="600"  alt="NBA" border="0" style="display: block;" /></a>--%>
<%--                                --%>
					<table class="table table-bordered customtable">
						<tr class="header">
							<h2 style="text-align: center">
								<u>Consultation Form</u>
							</h2>
							<h4 style="text-align: center">(Under Section 41(2) of the
								Biological Diversity Act, 2002)</h4>
							<p style="padding: 10px">
								<b>Name of the SBB:</b>&nbsp;<span style="color: red">
									${sbbName?:printInstance?.sbbName}
								</span>
							</p>
						</tr>
						<tr>
							<td><b>1</b></td>
							<td><b>Application no.</b></td>
							<td><b>:</b></td>
							<td style="color: red;">
								${formDetails?.appNumber?:printInstance?.appNumber}
							</td>
						</tr>
						<tr>
							<td><b>2</b></td>
							<td><b>NBA Letter Ref No & Date </b></td>
							<td><b>:</b></td>
							<td style="color: red;">${printInstance?.dynLetterNumber} & <g:formatDate format="dd/MM/yyyy"  date="${printInstance?.letterCreatedDate}"/></td>
						</tr>

						<tr>
							<td><b>3</b></td>
							<td style="width: 50% !important"><b>Date of Receipt</b></td>
							<td class="text-center" style="width: 1px;"><b>:</b></td>
							<td style="color: red;"><g:formatDate
									name="consentCreateDate" format="dd/MM/yyyy"
									date="${new Date()}" /></td>
						</tr>
						<tr>
							<td><b>4</b></td>
							<td style="width: 50% !important"><b>Name of BMC or
									Local Body consulted (If applicable)</b></td>
							<td class="text-center" style="width: 1px;"><b>:</b></td>

							<td><g:if test="${printInstance?.localBody}">
									<g:each in="${printInstance?.localBody}" var="local">
										<li>
											${local}
										</li>
									</g:each>


								</g:if> <g:else>

									No local body yet
								</g:else></td>
						</tr>
						<tr></tr>
						<tr>
							<td><b>5</b></td>
							<td style="width: 50% !important"><b>Declaration</b></td>
							<td class="text-center" style="width: 1px;"><b>:</b></td>
							<td style="width: 50% !important"></td>
						</tr>
						<tr>
							<td></td>
							<td colspan="5"><b>The _<span style="color: red">
										${sbbName?:printInstance?.sbbName}
								</span>___ State Biodiversity Board after due diligence hereby gives
									its consent/other inputs on the above particulars referred to
									it by the National Biodiversity Authority.
							</b></td>
						</tr>
						<tr>
							<td><b>6</b></td>
							<td style="width: 50% !important">${printInstance?.ddn}</td>
							<td class="text-center" style="width: 1px;"><b>:</b></td>
							<td>${printInstance?.other?:''}</td>
						</tr>
						<tr>
							<td><b>7</b></td>
							<td style="width: 50% !important"></td>
							<td class="text-center" style="width: 1px;"></td>
							<td style="width: 50% !important">(Member Secretary)</td>
						</tr>
						<tr>
							<td><b>8</b></td>
							<td style="width: 50% !important"><b>Any other relevant
									Document Pls Upload</b></td>
							<td class="text-center" style="width: 1px;"></td>
							<td style="width: 50% !important">
							<g:if test="${printInstance}"> ${printInstance?.fileName}</g:if> </td>
						</tr>
					</table>


				</div>
			</div>
		</div>
	</div>
</body>
</html>