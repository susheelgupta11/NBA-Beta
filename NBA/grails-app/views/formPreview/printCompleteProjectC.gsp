<%! import org.nba.common.State%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="layout" content="projectPreview" />
<title> NBA Print Preview</title>
<style type="text/css">
.wordwrap>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th,
	.table>thead>tr>td, .table>thead>tr>th {
	max-width: 100px;
	word-wrap: break-word;
}

table{font-size:1.3em;}
</style>

<script type="text/javascript">

$(function(){
	window.print();
});

</script>
</head>
<body>
<div id="print" class="row ">

	<div class="col-sm-12 text-center">
		<h3 class="register-heading">
			<b>Form-C</b>
		</h3>

		(Deposition of micro-organism by Indian scientist / researchers in
		non-Indian repository for claim of novel species.)
	</div>
	<g:if test="${appForm?.transaction?.isPaymentMade != true }">
		<div class="col-sm-12">
			<span class="pull-right "><b>Application No:</b> ${appForm?.appNumber}</span>
			<span class="pull-left "><b>Submitted on:</b> ${appForm?.submittedOn}</span>
		</div>
	</g:if>

	<g:if test="${listOfDepositionOfMicroOrganism.size() != 0}">
		<div class="col-sm-12 ">
			<table class="table table-bordered">
				<tr class="previewheading">
					<td class="text-center one"><b>(1)</b></td>
					<td colspan="4"><span><b>Full particulars of the
								Depositor
								
								</b></span></td>
				</tr>

				<% int num= 1 %>
				<% char alph = 65 %>
				<g:each in="${listOfDepositionOfMicroOrganism}" var="profile">
					<tr class="">
						<td class="no-width"></td>
						<td  class="text-center one heading"><b>(${alph })
						</b></td>
						<td  class="fifty heading"><b>Depositor ${num }</b></td>
						<td class="one"></td>
						<td class="fourty">${profile?.nameOfDepositor}</td>
					</tr>

					<% num++ %>
					<% alph++ %>

					<tr class="register-heading">
						<td class="no-width"></td>
						<td class="text-center"><b></b></td>
						<td colspan="3"><b>Complete Address with contact Details</b></td>
					</tr>

					<tr>
						<td class="no-width"></td>
						<td class="text-center">i</td>
						<td>Complete Address for the communication</td>
						<td><b>:</b></td>
						<td>
							${profile?.address1}, ${profile?.address2} ${profile?.address3} ${profile?.city}, 
							PIN:${profile?.zip }, ${profile?.state }, ${profile?.country?.country}
						</td>
					</tr>
					<tr>
						<td class="no-width"></td>
						<td class="text-center">ii</td>
						<td>Mobile number</td>
						<td><b>:</b></td>
						<td>
							${profile?.mobile}
						</td>
					</tr>

					<tr>
						<td class="no-width"></td>
						<td class="text-center">iii</td>
						<td>Telephone number</td>
						<td><b>:</b></td>
						<td>
							${profile?.phone}
						</td>
					</tr>

					<tr>
						<td class="no-width"></td>
						<td class="text-center">iv</td>
						<td>Email address</td>
						<td><b>:</b></td>
						<td>
							${profile?.email}
						</td>
					</tr>

				</g:each>
			</table>
		</div>
	</g:if>

	<div class="col-sm-12 table-responsive">
		<table class="table table-bordered">

			<tr class="previewheading">
				<td class="text-center one"><b>(2)</b></td>
				<td colspan="4"><b>Name of the micro-organism(s) to the
						deposited in the foreign repository</b></td>
			</tr>
			<%  char alph = 97 %>
			<%int i=1 %>
			<g:each in="${listOfScientistName}" var="scientist">

				<tr>

					<td  class=" no-width">(${alph })
					</td>
					<td align="center" class="fifty">Scientific Name (${i})
					</td>
					<td class="fifty">
						${scientist?.scientistName}
					</td>
				</tr>
				<% i++ %>
				<%  alph++ %>
			</g:each>
		</table>
	</div>
	<div class="col-sm-12 table-responsive">
		<table class="table table-bordered">

			<tr class="previewheading">
				<td class="text-center one"><b>(3)</b></td>
				<td colspan="8"><b>Geographical location from where the
						micro-organism was isolated</b></td>
			</tr>

			<tr>
				<th>Sl.No</th>
				<th>Scientific Name</th>
				<th>Source of access</th>
				<th>Village Name</th>
				<th>Town/ Taluk</th>
				<th>District</th>
				<th>State</th>
				<th>Name</th>
				<th>Contact details</th>
			</tr>

			<%   alph = 97 %>



			<g:each in="${bioRes}" var="profile1" status="k">

				<g:each in="${profile1}" var="profile">
					<tr>
						<td class="session" align="center"><%=alph %></td>
						<td align="center">
							${profile?.bioResource?.scientistName}
						</td>
						<td align="center">
							${profile?.source}
						</td>
						<td align="center">
							<g:if test="${profile?.village}">
								${profile?.village}
							</g:if> 
							<g:else>
									N/A
							</g:else>
						</td>
						<td align="center">
							<g:if test="${profile?.town }">
								${profile?.town}
							</g:if> 
							<g:else>
									N/A
							</g:else>
						</td>
						<td align="center">
							<g:if test="${profile?.district }">
								${profile?.district}
							</g:if> 
							<g:else>
								N/A
							</g:else>
						</td>
						<td align="center">
							<g:if test="${profile?.state }">
								${profile?.state}
							</g:if> 
							<g:else>
									N/A
							</g:else>
						</td>
						<td align="center">
							<g:if test="${profile?.traderName }">
								${profile?.traderName}
							</g:if> 
							<g:else>
									N/A
							</g:else>
						</td>
						<td align="center">
							<g:if test="${profile?.traderContactDetails }">
								${profile?.traderContactDetails}
							</g:if> 
							<g:else>
									N/A
							</g:else>
						</td>
						<%alph++ %>
					</tr>
				</g:each>
			</g:each>
		</table>
	</div>

	<div class="col-sm-12 table-responsive">
		<table class="table table-bordered">
			<tr class="previewheading">
				<td class="text-center one"><b>(4)</b></td>
				<td colspan="4"><span><b>Name and Contact details of
							the repository where the biological resource(s) are to be
							deposited</b></span></td>
			</tr>

			<% int num= 1 %>
			<%  alph = 65 %>
			<g:each in="${listOfContactDetailsOfRepository}" var="profile">
				<tr class="">
					<td class="no-width"></td>
					<td  class="text-center one heading"><b>(${alph })
					</b></td>
					<td  class="fourty heading"><b>
							${profile.repostoryType}
					</b></td>
					<td ></td>
					<td class="fifty"></td>
				</tr>

				<% num++ %>
				<% alph++ %>

				<tr>
					<td></td>
					<td class="text-center">i</td>
					<td>Repository Name</td>
					<td class="one"><b>:</b></td>
					<td>
						${profile.repostoryName}
					</td>
				</tr>
				<tr class="register-heading">
					<td></td>
					<td class="text-center"><b></b></td>
					<td colspan="3"><b>Complete Address with contact Details</b></td>
				</tr>

				<tr>
					<td></td>
					<td class="text-center">ii</td>
					<td>Complete Address for the communication</td>
					<td><b>:</b></td>
					<td>
						${profile?.address1}, ${profile?.address2} ${profile?.address3} ${profile?.city}, 
						PIN:${profile.zip}, ${profile.state}, ${profile?.country?.country} 
					</td>
				</tr>
				<tr>
					<td></td>
					<td class="text-center">iii</td>
					<td>Telephone number</td>
					<td><b>:</b></td>
					<td>
						${profile?.phone}
					</td>
				</tr>

				<tr>
					<td></td>
					<td class="text-center">iv</td>
					<td>Email address</td>
					<td><b>:</b></td>
					<td>
						${profile?.email}
					</td>
				</tr>

			</g:each>
		</table>
	</div>
	<div class="col-sm-12 table-responsive">
		<table class="table table-bordered">
			<tr class="previewheading">
				<td class="text-center one"><b>(5)</b></td>
				<td colspan="4"><span><b>Purpose of deposition</b></span></td>
			</tr>
			<tr>
				<td class=" no-width"><b></b></td>
				<td colspan="4"><span>
							${applicationform?.depositionPerpose}
					</span></td>
			</tr>
		</table>
	</div>
	
	<div class="col-sm-12 table-responsive">
		<table class="table table-bordered">
			<tr class="previewheading">
				<td class="text-center one"><b>(6)</b></td>
				<td colspan="4"><span class="pull-left"><b>Accession number allotted by the Indian repository to the deposited microorganisms</b></span></td>
			</tr>
			<tr>
				<td class=" no-width"><b></b></td>
				<td colspan="4"><span>
							<span class="pull-left">${accessionNumber?.accessionNumber }</span>
					</span></td>
			</tr>
		</table>
	</div>
	
	<div class="col-sm-12 table-responsive">
		<table class="table table-bordered">
			<tr class="previewheading">
				<td class="text-center one"><b>(7)</b></td>
				<td colspan="4"><span><b>Undertaking by the applicant</b></span></td>
			</tr>
			<tr>
				<td class=" no-width"><b></b></td>
				<td colspan="4"><span>
							<g:if test="${applicationform?.undertakingCopyFileName}">
								Undertaking copy attached (Go to preview)
							</g:if>
							<g:else>
								File not uploaded
							</g:else>
					</span>
				</td>
			</tr>
		</table>
	</div>
	
	
</div>
</body>
</html>
