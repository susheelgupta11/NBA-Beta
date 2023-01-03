<%@ page contentType="text/html;charset=UTF-8"%>
<%! import org.nba.common.Country %>
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
   <!ENTITY micro "&#181;">
   <!ENTITY mu    "&#956;">
   <!ENTITY bull "&#8226;">
]>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

<title>NBA</title>
<style type="text/css">
.remark{color:blue}

table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
</head>
<body>

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
				<span class="text-center">(See Rule 14 of Biological
					Diversity Rules, 2004)<br /> Application form for access to the
					Biological Resources and associated traditional knowledge
				</span>
		</g:if>
		<g:elseif
			test="${formDetails?.category?.category == FormCategory.Category.Form_2 }">
				<span class="text-center"> (See Rule 17 of Biological
					Diversity Rules, 2004)<br /> Application for seeking prior
					approval of National Biodiversity Authority for transferring the
					results of research to foreign nationals,companies, NRIs for
					commercial purposes.
				</span>
		</g:elseif>
		<g:elseif
			test="${formDetails?.category?.category == FormCategory.Category.Form_3 }">
				<span class="text-center"> (See Rule 18 of Biological
					Diversity Rules, 2004)<br /> Application form for applying for
					Intellectual Property Right.
				</span>
		</g:elseif>
		<g:elseif
			test="${formDetails?.category?.category == FormCategory.Category.Form_4 }">
				<span class="text-center"> (See Rule 19 of Biological
					Diversity Rules, 2004)<br /> Application form for third party
					transfer of the accessed biological resources and associated
					traditional knowledge.
				</span>
		</g:elseif>
		<g:elseif
			test="${formDetails?.category?.category == FormCategory.Category.Form_B }">
			<center>
				<span class="text-center"> (See Regulation 13 of the
					Guidelines on Access to biological resources and associated
					knowledge and Benefits Sharing Regulations, 2014) <br />
					Conducting of non-commercial research or research for emergency
					purposes outside India by Indian researcher’s/ Government
					institutions
				</span>
			</center>
		</g:elseif>
		<g:elseif
			test="${formDetails?.category?.category == FormCategory.Category.Form_C }">
				<span class="text-center"> (Deposition of micro-organism by
					Indian scientist / researchers in non-Indian repository for claim
					of novel species.) </span>
		</g:elseif>
	</div>
	<div style="margin-top: 20px">
		Submitted On:
		${formDetails?.submittedOn} <span style="padding: 20px;"><b>Checklist Type: IPR</b></span>
		<span >Application Number: ${formDetails?.appNumber}</span>
		 
	</div>

	<hr />


					<table>
						<tr class="header">
							<td><b>S.No.</b></td>
							<td colspan="5" class="leftalign "><b>Details of
									invention on which IPR is sought</b></td>
						</tr>
						<tr>

							<td style="font-weight: 600;">1</td>
							<td style="width: 50% !important"><b>Title of invention</b></td>
							<td class="text-center" style="width: 1px;"><b>:</b></td>
							<td class="righttd" colspan="3">
								${formDetails?.titleOfIPR}
							</td>
						</tr>
						<tr>

							<td style="font-weight: 600;">2</td>
							<td><b>Abstract of the invention</b></td>
							<td class="text-center"><b>:</b></td>
							<td class="righttd" colspan="3">
							
									${formDetails?.abstractOfIPR}
							</td>
						</tr>
						<tr>

							<td style="font-weight: 600;">3</td>
							<td><b>Details of territories / patent offices where the
									applicant intends to apply for the present invention</b></td>
							<td class="text-center"><b>:</b></td>
							<td class="righttd" colspan="3">Incorporated / Register in
								India</td>
						</tr>
						<tr>

							<td style="font-weight: 600;">4</td>
							<td style="width: 50% !important"><b>Whether IP
									application filed for the present invention</b></td>
							<td class="text-center" style="width: 1px;"><b>:</b></td>
							<td class="righttd" colspan="3">
								  <g:if test="  ${formDetails?.isIPApplicationFiled == 'true'}">
              Yes
              </g:if>
            <g:else>No</g:else>
              
							</td>
						</tr>
						<tr>
							<td></td>
							<td colspan="5"><b>Patent details furnished by applicant</b></td>
						</tr>
						<tr>
							<td></td>
							<td colspan="5"><table border="1" style="width: 100%">
									<tr>
										<td><b>S. no</b></td>
										<td><b>Country/Territory name</b></td>
										<td><b>Patent Application No.</b></td>
										<td><b>Date</b></td>
										<td><b>Status</b></td>
										<td><b>Patent no. and date if granted</b></td>
										<td><b>Specify</b></td>
										<td><b>Remarks</b></td>
									</tr>
									<g:if test="${formDetails?.iprDetails}">
										<g:each in="${formDetails?.iprDetails}" var="iprDetls"
											status="i">
											<tr>
												<td>
													${i+1 ?:'NA'}
												</td>
												<td>
												${Country.get(iprDetls?.country)?.country}${country}
												</td>
												<td>
													${iprDetls?.patentApplicationNo ?:'NA'}
												</td>
												<td>
												<g:formatDate date="${iprDetls?.patentApplicationDate}" format="dd/MM/yyyy"/>
												</td>
												<td>
													${iprDetls?.status ?:'NA'}
												</td>
												<td>
													${iprDetls?.patentNo} - ${iprDetls?.patentDate?.format('dd/MM/yyyy')}
												</td>
												<td>
													${iprDetls?.reasons ?:'NA'}
												</td>
												<td>
													${iprRemarkInstance?.patentDtsRmk}
												</td>
											</tr>
										</g:each>
									</g:if>
									
								</table></td>
						</tr>
						<tr>

							<td style="font-weight: 600;">5</td>
							<td style="width: 50% !important"><b>Any other foreign
									patent found for the same invention</b></td>
							<td class="text-center" style="width: 1px;"><b>:</b></td>
							<td colspan="3" class="remark"><g:if
									test="${iprRemarkInstance?.foreignPetentChk == true}">
                                          Yes
                                     </g:if> <g:if
									test="${iprRemarkInstance?.foreignPetentChk == false}">
									<td class="">If No, Remarks</td>
									<td class="remark">
										${iprRemarkInstance?.foreignPatentRemark}
									</td>
								</g:if></td>
						</tr>
						<tr>
							<td></td>
							<g:if test="${iprRemarkInstance?.foreignPetentChk == true}">
								<td colspan="5">
									<table border="1" style="width: 100%">
										<tbody>
											<tr>
												<th>S. no</th>
												<th>Country/Territory name</th>
												<th>Patent Application No.</th>
												<th>Date</th>
												<th>Status</th>
												<th>Patent no. and date if granted</th>
												<th>Remarks</th>
											</tr>
											<g:if test="${iprRemarkInstance?.iprForignPetents}">
												<g:each in="${iprRemarkInstance?.iprForignPetents}"
													var="iprForignPetent" status="k">
													<tr class="remark">
														<td>
															${iprForignPetent?.serialNumber}
														</td>
														<td>
															${iprForignPetent?.countryTerritoryName}
														</td>
														<td>
															${iprForignPetent?.patentApplicationNum }
														</td>
														<td>
															${iprForignPetent?.datePatent }
														</td>
														<td>
															${iprForignPetent?.statusPatent }
														</td>
														<td>
															${iprForignPetent?.patentNumAndDateIfGranted}
														</td>
														<td>
															${iprForignPetent?.remarksPetent }
														</td>
													</tr>
												</g:each>
											</g:if>
										</tbody>
									</table>
								</td>
							</g:if>
						</tr>

						<tr>

							<td style="font-weight: 600;">6</td>
							<td><b>Application name matched with patent application</b></td>
							<td class="text-center" style="width: 1px;"><b>:</b></td>
							<td colspan="3" class="remark"><g:if
									test="${iprRemarkInstance?.mtcWithPatentAppChk == true}">
                                             Yes
                            </g:if> <g:if test="${iprRemarkInstance?.mtcWithPatentAppChk == false}">
                                 No,Remark--${iprRemarkInstance?.mtcWithPatentAppRmk}
								</g:if></td>

						</tr>
						<tr>

							<td style="font-weight: 600;">7</td>
							<td style="width: 50% !important"><b>Bioresource matched
									with patent</b></td>
							<td class="text-center" style="width: 1px;"><b>:</b></td>
							<td colspan="3" class="remark"><g:if
									test="${iprRemarkInstance?.bioresourceMtcChk == true }">
							 Yes
							 </g:if> <g:if test="${iprRemarkInstance?.bioresourceMtcChk == false }">
							 No,Remark-${iprRemarkInstance?.bioresourceMtcRmk}
								</g:if></td>
						</tr>
						<tr>

							<td style="font-weight: 600;">8</td>
							<td style="width: 50% !important"><b>Details of
									commercialization</b></td>
							<td class="text-center" style="width: 1px;"><b>:</b></td>
							<td colspan="3" class="remark"><g:if
									test="${iprRemarkInstance?.dtsCommercializationChk == true}">
							Yes
							</g:if> <g:if
									test="${iprRemarkInstance?.dtsCommercializationChk == false}">
							      No,Remark-${iprRemarkInstance?.detailsCommercialRmk}
								</g:if></td>
						</tr>
						<tr>
							<td></td>
							<g:if
								test="${iprRemarkInstance?.dtsCommercializationChk == true}">
								<td colspan="5"><table border="1" style="width: 100%">
										<tr>
											<th>Country</th>
											<th>Financial Year</th>
											<th>Amount</th>
											<th>Remarks</th>
										</tr>
										<tr class="remark">
											<td>
												${iprRemarkInstance?.country}
											</td>
											<td>
												${iprRemarkInstance?.financialYr}
											</td>
											<td>
												${iprRemarkInstance?.amount}
											</td>
											<td>
												${iprRemarkInstance?.remarksA}
											</td>
										</tr>
									</table></td>
							</g:if>
						</tr>
						<tr>
							<td style="font-weight: 600;">9</td>
							<td><b>Question</b></td>
							<td class="text-center" style="width: 1px;"><b>:</b></td>
							<td colspan="2" class="remark">
								${iprRemarkInstance?.questionRequired}
							</td>
						</tr>
						<g:if test="${iprRemarkInstance?.questionAnswers}">
							<g:each in="${iprRemarkInstance?.questionAnswers}" var="quesAns"
								status="i">
								<tr>
									<td></td>
									<td colspan="5"><table border="1" style="width: 100%">
											<tbody>
												<tr class="remark">
													<td>
														${quesAns?.question}
													</td>
													<td>
														${quesAns?.answer}
													</td>
												</tr>
											</tbody>
										</table></td>
								</tr>
							</g:each>
						</g:if>
					</table>
		
</body>
</html>