<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%! import org.nba.common.State%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name='layout' content='main' />
<title> NBA Print Preview</title>

<style type="text/css" media="print">
table.datatable1>thead>tr>th
{
background-color:#b9b9b9;
}
table
{
border:1px solid #000;
width:100%;
margin-bottom:10px;
}
th, tr> td {
  border-bottom:1px solid #000;
  border-left: 1px solid #000;
  
}
.slno {width:3%}
.previewheading {background-color:#DCDCDC}
.center-align{text-align: center;}

</style>

</head>
<body>
<%--<div id="divToPrint">--%>
<div id="print" class="row ">
	
	
	
	<div class="col-sm-10">
					<div class="logo">
						<img src="${resource(dir: 'images', file: 'Logo1.jpg')}" alt="logo" class="img-responsive pull-left" />
					</div>
	</div>
	
	
	
	<div class="col-sm-12 text-center center-align">
		<h3 class="register-heading">
			<b>Form-C</b>
		</h3>

		(Deposition of micro-organism by Indian scientist / researchers in
		non-Indian repository for claim of novel species.)
	</div>
	<g:if test="${appForm?.transaction?.isPaymentMade == true }">
		<div class="col-sm-12">
			<span class="pull-right "><b>Application No:</b> ${appForm?.appNumber}</span>
			<span class="pull-left "><b>Submitted on:</b> ${appForm?.submittedOn}</span>
		</div>
	</g:if>

	<g:if test="${listOfDepositionOfMicroOrganism.size() != 0}">
		<div class="col-sm-12 table-responsive">
			<table class="table table-bordered" >
				<tr class="previewheading">
					<td class="text-center"><b>(1)</b></td>
					<td colspan="4"><span class="pull-left"><b>Full particulars of the
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
						<td></td>
						<td class="fourty"></td>
					</tr>

					<% num++ %>
					<% alph++ %>

					<tr>
						<td class="no-width"></td>
						<td class="text-center">i</td>
						<td>Name of depositor</td>
						<td><b>:</b></td>
						<td>
							<span class="pull-left">${profile?.nameOfDepositor}</span>
						</td>
					</tr>
					<tr>
						<td class="no-width"></td>
						<td class="text-center">ii</td>
						<td>Complete Address for the communication</td>
						<td><b>:</b></td>
						<td>
							<span class="pull-left">${profile?.address1}, ${profile?.address2} ${profile?.address3} ${profile?.city}, </span>
							<span class="pull-left">PIN:${profile?.zip }, ${profile?.state }, ${profile?.country?.country}</span><br/>
							<span class="pull-left"><b>Mobile:</b>${profile?.mobile}</span><br/>
							<span class="pull-left"><b>Phone:</b>${profile?.phone}</span><br/>
							<span class="pull-left"><b>Email:</b>${profile?.email}</span><br/>
						</td>
					</tr>

				</g:each>
			</table>
		</div>
	</g:if>

	<div class="col-sm-12 table-responsive">
		<table class="table table-bordered" >

			<tr class="previewheading">
				<td class="text-center slno" ><b>(2)</b></td>
				<td colspan="4"><span class="pull-left"><b>Name of the micro-organism(s) to the
						deposited in the foreign repository</b></span></td>
			</tr>
			<%  char alph = 97 %>
			<%int i=1 %>
			<g:each in="${listOfScientistName}" var="scientist">

				<tr>

					<td  class="text-center no-width">${alph }
					</td>
					<td align="center" class="fifty"><span class="pull-left">Scientific Name (${i})</span>
					</td>
					<td class="fifty">
						<span class="pull-left">${scientist?.scientistName}</span>
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
				<td class="text-center slno"><b>(3)</b></td>
				<td colspan="8"><span class="pull-left"><b>Geographical location from where the
						micro-organism was isolated</b></span></td>
			</tr>

			<tr>
				<th>Sl. No</th>
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
				<td class="text-center"><b>(4)</b></td>
				<td colspan="4"><span class="pull-left"><b>Name and Contact details of
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
					<td class="fifty">Repository Name</td>
					<td><b>:</b></td>
					<td>
						<span class="pull-left">${profile.repostoryName}</span>
					</td>
				</tr>
				
				<tr>
					<td></td>
					<td class="text-center">ii</td>
					<td>Complete Address for the communication</td>
					<td><b>:</b></td>
					<td>
						<span class="pull-left">${profile?.address1}, ${profile?.address2} ${profile?.address3} ${profile?.city}, </span>
						<span class="pull-left">PIN:${profile.zip}, ${profile.state}, ${profile?.country?.country} </span><br/>
						<span class="pull-left"><b>Phone:</b>${profile?.phone}</span><br/>
						<span class="pull-left"><b>Email:</b>${profile?.email}</span><br/>
					</td>
				</tr>

			</g:each>
		</table>
	</div>
	<div class="col-sm-12 table-responsive">
		<table class="table table-bordered">
			<tr class="previewheading">
				<td class="text-center slno" ><b>(5)</b></td>
				<td colspan="4"><span class="pull-left"><b>Purpose of deposition</b></span></td>
			</tr>
			<tr>
				<td class=" no-width"><b></b></td>
				<td colspan="4"><span>
							<span class="pull-left">${applicationform?.depositionPerpose}</span>
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
				<td class="text-center slno"><b>(7)</b></td>
				<td colspan="4"><span class="pull-left"><b>Undertaking by the applicant</b></span></td>
			</tr>
			<tr>
				<td class=" no-width"><b></b></td>
				<td colspan="4"><span class="pull-left"><b>
							<g:if test="${applicationform?.undertakingCopyFileName}">
								<g:link
											controller="applicationManagement"
											action="showUndertakingFile" id="${applicationform?.id}"
											target="_blank"
											params='[filename: "undertakingCopy", dataName: "undertakingCopy",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
											${applicationform?.undertakingCopyFileName}
								</g:link>
							</g:if>
							<g:else>
								File not uploaded
							</g:else>
					</b></span>
				</td>
			</tr>
		</table>
	</div>
	
	
</div>

</body>
</html>


