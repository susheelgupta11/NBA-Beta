<%@ page contentType="text/html;charset=UTF-8"%>
<%! import org.nba.application.FormCategory %>

<!DOCTYPE entities [
   <!ENTITY hyphen "&#x02010;">
   <!ENTITY copy "&#x000A9;">
   <!ENTITY nbsp "&#x000A0;">
   <!ENTITY ndash "&#x02013;">
   <!ENTITY auml "&#x000E4;">
   <!ENTITY uuml "&#x000FC;">
   <!ENTITY deg "&#x000B0;">
   <!ENTITY Delta "&#x00394;">
   <!ENTITY minus "&#x02212;">
   <!ENTITY ensp "&#x02002;">
   <!ENTITY szlig "&#223;">
   <!ENTITY rsquo   "&#8217;">
   <!ENTITY mdash  "&#x2014;" >
   <!ENTITY micro "&#181;">
   <!ENTITY mu    "&#956;">
   <!ENTITY bull "&#8226;">
]>

<html>
<head>
<title>NBA</title>
<style type="">
.remark{color:blue}

table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
</head>
<body>
	
<%--		<g:if test="${imageBytes!= null}">--%>
<%--			<rendering:inlinePng bytes="${imageBytes}" class="some-class" />--%>
<%--		</g:if>--%>
 <a href="#" target="_blank">
        <img src="https://absefiling.nic.in/NBA/assets/Logo1-9de1c2fa396fb0e8af1ba72ffc12b3dc.jpg" width="700px"  alt="NBA" border="0" style="display: block;" /></a>
<div align="center">
		<h2>
		<g:if test="${formDetails?.category?.category == FormCategory.Category.Form_1}">Form I</g:if>
		<g:if test="${formDetails?.category?.category == FormCategory.Category.Form_2}">Form II</g:if>
		<g:if test="${formDetails?.category?.category == FormCategory.Category.Form_3}">Form III</g:if>
		<g:if test="${formDetails?.category?.category == FormCategory.Category.Form_4}">Form IV</g:if>
		<g:if test="${formDetails?.category?.category == FormCategory.Category.Form_B}">Form B</g:if>
		</h2>
	</div>
	<div align="center">
		<g:if
			test="${formDetails?.category?.category == FormCategory.Category.Form_1}">
			 <span class="text-center">(See Rule 14 of
				Biological Diversity Rules, 2004)<br /> Application form for access
				to the Biological Resources and associated traditional knowledge
			</span> 
		</g:if>
		<g:elseif
			test="${formDetails?.category?.category == FormCategory.Category.Form_2 }">
			 <span class="text-center"> (See Rule 17 of
				Biological Diversity Rules, 2004)<br /> Application for seeking
				prior approval of National Biodiversity Authority for transferring
				the results of research to foreign nationals,companies, NRIs for
				commercial purposes.
			</span> 
		</g:elseif>
		<g:elseif
			test="${formDetails?.category?.category == FormCategory.Category.Form_3 }">
			 <span class="text-center"> (See Rule 18 of
				Biological Diversity Rules, 2004)<br /> Application form for
				applying for Intellectual Property Right.
			</span> 
		</g:elseif>
		<g:elseif
			test="${formDetails?.category?.category == FormCategory.Category.Form_4 }">
			 <span class="text-center"> (See Rule 19 of
				Biological Diversity Rules, 2004)<br /> Application form for third
				party transfer of the accessed biological resources and associated
				traditional knowledge.
			</span> 
		</g:elseif>
		<g:elseif
			test="${formDetails?.category?.category == FormCategory.Category.Form_B }">
			 <span class="text-center"> (See Regulation
				13 of the Guidelines on Access to biological resources and
				associated knowledge and Benefits Sharing Regulations, 2014) <br />
					Conducting of non-commercial research or research for emergency
					purposes outside India by Indian researcher’s/ Government
					institutions 
			</span> 
		</g:elseif>
		<g:elseif
			test="${formDetails?.category?.category == FormCategory.Category.Form_C }">
			 <span class="text-center"> (Deposition of
				micro-organism by Indian scientist / researchers in non-Indian
				repository for claim of novel species.) </span> 
		</g:elseif>
	</div>
<div style="margin-top: 20px">
 Submitted On: ${formDetails?.submittedOn} <span style="padding: 20px;"><b>Checklist Type: Account </b></span>
 <span>Application Number:	${formDetails?.appNumber}</span>
 
</div>
	
<hr />
	
	<table style="width:100%;  margin-top: 20px">
								<thead><tr>
										<th>S.No</th>
                                      <th>Title</th>
                                       <th></th>
                                      <th>Details</th>
                                      <th colspan="4">Remarks</th>
								</tr>
								</thead>
								<tbody>
								<tr>
									<td><b>1:</b></td>
									<td><b>Name of the Applicant</b></td>
									<td class="text-center" style="width: 1px;"><b>:</b></td>
									<td>
									<g:if test="${formDetails?.individualProfiles}">
											<g:each in="${formDetails?.individualProfiles}"
												var="individualProfile">

												${individualProfile?.title}
												${individualProfile?.firstName}
												${individualProfile?.middleName}
												${individualProfile?.lastName}
											</g:each>
										</g:if> <g:elseif test="${formDetails?.companyProfiles}">
											<g:each status="k" in="${formDetails?.companyProfiles}"
												var="company">
												${company?.entityName}
											</g:each>
										</g:elseif> <g:elseif test="${formDetails?.indianResearcher}">
											<g:each in="${formDetails?.indianResearcher}"
												var="researcher">

												${researcher?.title}
												${researcher?.firstName}
												${researcher?.middleName}
												${researcher?.lastName}

											</g:each>
										</g:elseif> <g:elseif test="${formDetails?.depostionOfMicroOrganism}">
											<g:each in="${formDetails?.depostionOfMicroOrganism}"
												var="depost">
												${depost?.nameOfDepositor}
											</g:each>
										</g:elseif> <g:elseif test="${formDetails?.indianGovtInst}">
											<g:each in="${formDetails?.indianGovtInst}" var="govt">
												${govt?.govtInstName}
											</g:each>
										</g:elseif>		
										</td>
									<td colspan="4"></td>
								</tr>
								<tr>
									<td><b>2:</b></td>
									<td><b>Category of the
											Applications</b></td>
									<td class="text-center" style="width: 1px;"><b>:</b></td>
									<td>
													<g:if
											test="${formDetails?.category?.category == FormCategory.Category.Form_1}">
													Form I
												</g:if> <g:elseif
											test="${formDetails?.category?.category == FormCategory.Category.Form_2}">
													Form II
												</g:elseif> <g:elseif
											test="${formDetails?.category?.category == FormCategory.Category.Form_3}">
													Form III
												</g:elseif> <g:elseif
											test="${formDetails?.category?.category == FormCategory.Category.Form_4}">
													Form IV
												</g:elseif> <g:elseif
											test="${formDetails?.category?.category == FormCategory.Category.Form_B}">
													Form B
												</g:elseif> <g:elseif
											test="${formDetails?.category?.category == FormCategory.Category.Form_C}">
													Form C
													</g:elseif>
													</td>
									<td></td>
								</tr>
								<tr>
									<td><b>3:</b></td>
									<td><b>Transaction ID</b></td>
									<td class="text-center" style="width: 1px;"><b>:</b></td>
									<td>
									${formDetails?.transaction?.transactionId}
									</td>
									<td class="remark">${accountRemark?.trsnsRemark}</td>
								</tr>
								<tr>
									<td><b>4:</b></td>
									<td><b>SBI Payment Reference
											Number</b></td>
									<td class="text-center" style="width: 1px;"><b>:</b></td>
									<td>
										${formDetails?.transaction?.paymentRefNo}	
									</td>
									<td class="remark">${accountRemark?.paymentRemark}</td>
								</tr>
								<tr>
									<td><b>5:</b></td>
									<td><b>Payment Received</b></td>
									<td class="text-center" style="width: 1px;"><b>:</b></td>
									<td>
										${formDetails?.transaction?.fee}/-
									</td>
									<td class="remark">${accountRemark?.paymentReceivedRemark}</td>
								</tr>
								<tr>
									<td><b>6:</b></td>
									<td><b>Fee to be received</b></td>
									<td class="text-center" style="width: 1px;"><b>:</b></td>
									<td>
									${formDetails?.transaction?.fee}/-
									</td>
									<td class="remark">${accountRemark?.feeRemark}</td>
								</tr>

								<tr>
									<td><b>7:</b></td>
									<td><b>Payment Type</b></td>
									<td class="text-center" style="width: 1px;"><b>:</b></td>
									<td>${accountRemark?.paymentType }</td>

									<td class="remark"> ${accountRemark?.others}</td>
								</tr>

								<tr>
									<td><b>8:</b></td>
									<td><b>Transaction Details found
											in order</b></td>
									<td class="text-center" style="width: 1px;"><b>:</b></td>

									<td style="padding: 0 10px;">
									<g:if test="${accountRemark?.txnDetailsInOrder == true}">
											<div class="trans-yn">
												Yes
											</div>
											</g:if>
											<g:elseif test="${accountRemark?.txnDetailsInOrder == false }">
											<p>
												No
											</p>
											</g:elseif>
										</td>
									<td>
									<div class="remaks"></div>
										<div class="remark">
										${accountRemark?.txnDetailsRemark}
										</div>
										</td>
									
								</tr>
								<tr>
									<td><b>9:</b></td>
									<td><b>Matched with bank
											statement</b></td>
									<td class="text-center" style="width: 1px;"><b>:</b></td>
									<td style="padding: 0 10px;">
									<g:if test="${accountRemark?.mcdWithBakStatement == true}">
											<div class="trans-yn">
												Yes
											</div>
											</g:if>
											<g:elseif test="${accountRemark?.mcdWithBakStatement == false}">
											<p>
												No
											</p>
                                         </g:elseif>
										</td>
									
									<td>
									<div class="remaks"></div>
										<div class="remark">
                                  ${accountRemark?.mcdBakStatementRemark}
										</div>
										</td>
								</tr>
								<tr>
									<td><b>10:</b></td>
									<td><b>Question / Remark</b></td>
									<td class="text-center" style="width: 1px;"><b>:</b></td>
									<td style="padding: 0 10px;"  class="remark" colspan="2">${accountRemark?.question}</td>
									
				   </tr>
			<g:if test="${accountRemark != null || accountRemark != ''}">

				<g:each in="${accountRemark?.questionAnswers}" var="quesAnswer"
					status="k">
					<tr>
						<td><b>
							${k+11}:
						</b></td>
						
						<td class="remark">
							${quesAnswer?.question}
						</td>
						<td class="text-center" style="width: 1px;"><b>:</b></td>
						<td class="remark" colspan="2">
							${quesAnswer?.answer}
						</td>
					</tr>
				</g:each>

			</g:if>

		</tbody>
			</table>
</body>
</html>