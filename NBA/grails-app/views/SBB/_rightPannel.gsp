<%! import org.nba.common.State %>
<%! import org.nba.application.FormCategory %>
<div id="mySidenav" class="sidenavs">
	<div class="col-sm-12 right-div-menu">
		<div class="main-tbs">
			<table class="table table-bordered" style="margin-bottom: 0px;">
				<tr>

					<button class="tablink" onclick="openPage('News', this, 'green')">Application</button>
					<button class="tablink" onclick="openPage('Contact', this, 'blue')">Attachment</button>

					
				</tr>
			</table>
			
				
			
				<div id="News" class="tabcontent">
					<h2 class="text-center">
						${formDetails?.category?.category}
					</h2>

					<g:if
						test="${formDetails?.category?.category == FormCategory.Category.Form_1}">
						<center>
							<span class="text-center">(See Rule 14 of Biological
								Diversity Rules, 2004)<br /> Application form for access to the
								Biological Resources and associated traditional knowledge
							</span>
						</center>
					</g:if>
					<g:elseif
						test="${formDetails?.category?.category == FormCategory.Category.Form_2 }">
						<center>
							<span class="text-center"> (See Rule 17 of Biological
								Diversity Rules, 2004)<br /> Application for seeking prior
								approval of National Biodiversity Authority for transferring the
								results of research to foreign nationals,companies, NRIs for
								commercial purposes.
							</span>
						</center>
					</g:elseif>
					<g:elseif
						test="${formDetails?.category?.category == FormCategory.Category.Form_3 }">
						<center>
							<span class="text-center"> (See Rule 18 of Biological
								Diversity Rules, 2004)<br /> Application form for applying for
								Intellectual Property Right.
							</span>
						</center>
					</g:elseif>
					<g:elseif
						test="${formDetails?.category?.category == FormCategory.Category.Form_4 }">
						<center>
							<span class="text-center"> (See Rule 19 of Biological
								Diversity Rules, 2004)<br /> Application form for third party
								transfer of the accessed biological resources and associated
								traditional knowledge.
							</span>
						</center>
					</g:elseif>
					<g:elseif
						test="${formDetails?.category?.category == FormCategory.Category.Form_B }">
						<center>
							<span class="text-center"> (See Regulation 13 of the
								Guidelines on Access to biological resources and associated
								knowledge and Benefits Sharing Regulations, 2014) <br>
								Conducting of non-commercial research or research for emergency
								purposes outside India by Indian researcher’s/ Government
								institutions
								
							</span>
						</center>
					</g:elseif>
					<g:elseif
						test="${formDetails?.category?.category == FormCategory.Category.Form_C }">
						<center>
							<span class="text-center"> (Deposition of micro-organism
								by Indian scientist / researchers in non-Indian repository for
								claim of novel species.) </span>
						</center>
					</g:elseif>

					<span class="pull-left" style="padding: 10px 0;"><b>Submitted
							On :</b> ${submittedDate}</span> <span class="pull-right"
						style="padding: 10px 0;"><b>Application No :</b> ${applicationNum}</span>
					<table class="table table-bordered customtable">
						<g:if test="${formDetails?.individualProfiles}">
							<tr>
								<td colspan="3"><b>Type of Applicant </b></td>
								<td width="35px" class="text-center"><b>:</b></td>
								<td class="righttd">Individual</td>
							</tr>
							<tr class="header">
								<td></td>
								<td colspan="5" class="leftalign "><b>Full Particular
										of Applicant</b></td>
							</tr>
						</g:if>
						<g:elseif test="${formDetails?.companyProfiles}">
							<tr>
								<td colspan="3"><b>Type of Applicant </b></td>
								<td width="35px" class="text-center"><b>:</b></td>
								<td class="righttd">Entity</td>
							</tr>
							<tr class="header">
								<td></td>
								<td colspan="5" class="leftalign "><b>Full Particular
										of Applicant</b></td>
							</tr>

						</g:elseif>
						<g:elseif test="${formDetails?.depostionOfMicroOrganism}">

							<tr class="header">
								<td colspan="5" class="leftalign "><b>Full Particular
										of Depositor</b></td>
							</tr>
						</g:elseif>

						<g:elseif test="${formDetails?.govtInstitutes}">
							<tr class="header">
								<td colspan="5" class="leftalign "><b>Full Particulars
										of Government Institution in India</b></td>
							</tr>

						</g:elseif>

						<g:elseif test="${formDetails?.indianResearcher}">
							<tr>
								<tr class="header">
							<td colspan="5" class="leftalign "><b>Full Particular of Indian Researcher</b></td>
						</tr>
						</g:elseif>	
						
						
						<g:if
							test="${formDetails?.category?.category == FormCategory.Category.Form_1 && allDataforMatching?.individualDetailsForMatch?.size()>0}">
							<g:render template="/dashboard/form1ForMatchingData"></g:render>
						</g:if>
						<g:elseif
							test="${formDetails?.category?.category == FormCategory.Category.Form_1 && allDataforMatching?.companyDetailsForMatch?.size()>0}">

							<g:render template="/dashboard/form1ForMatchingData"></g:render>
						</g:elseif>
						<g:elseif
							test="${formDetails?.category?.category == FormCategory.Category.Form_2 && allDataforMatching?.individualDetailsForMatch?.size()>0}">
						
							<g:render template="/dashboard/form2ForMatchingData"></g:render>
						</g:elseif>
						<g:elseif
							test="${formDetails?.category?.category == FormCategory.Category.Form_2 && allDataforMatching?.companyDetailsForMatch?.size()>0}">
							
							<g:render template="/dashboard/form2ForMatchingData"></g:render>
						</g:elseif>
						<g:elseif
							test="${formDetails?.category?.category == FormCategory.Category.Form_3 && allDataforMatching?.individualDetailsForMatch?.size()>0}">
							
							<g:render template="/dashboard/form3ForMatchingData"></g:render>
						</g:elseif>
						<g:elseif
							test="${formDetails?.category?.category == FormCategory.Category.Form_3 && allDataforMatching?.companyDetailsForMatch?.size()>0}">
							
							<g:render template="/dashboard/form3ForMatchingData"></g:render>
						</g:elseif>
						<g:elseif
							test="${formDetails?.category?.category == FormCategory.Category.Form_4 && allDataforMatching?.individualDetailsForMatch?.size()>0}">
							
							<g:render template="/dashboard/form4ForMatchingData"></g:render>
						</g:elseif>
						<g:elseif
							test="${formDetails?.category?.category == FormCategory.Category.Form_4 && allDataforMatching?.companyDetailsForMatch?.size()>0}">
							
							<g:render template="/dashboard/form4ForMatchingData"></g:render>
						</g:elseif>
						<g:elseif
							test="${formDetails?.category?.category == FormCategory.Category.Form_B && allDataforMatching?.indianResearcher?.size() >0}">
							
							<g:render template="/dashboard/formBForMatchingData"></g:render>
						</g:elseif>
						
						<g:elseif
							test="${formDetails?.category?.category == FormCategory.Category.Form_B && allDataforMatching?.listOfIndianGovtInst?.size() >0}">
						
							<g:render template="/dashboard/formBForMatchingData"></g:render>
						</g:elseif>
						
						<g:elseif
							test="${formDetails?.category?.category == FormCategory.Category.Form_C && allDataforMatching?.depostionOfMicroOrganism?.size()>0}">
							
							<g:render template="/dashboard/formCForMatchingData"></g:render>
						</g:elseif>
						
					</table>
				
					<g:render template="/rightPane/agentProfileMatching"></g:render>

					<table class="table table-bordered customtable">
						<tr>
							<td style="max-width: 35px"><b>2</b>
							
						
							<td colspan="2"><b> Details and specific information
									about nature of access thourgh and biological material and
									associated knowledge to be accessed</b></td>
						</tr>
						<tr>
							<td></td>
							<td style="width: 35px"><b>(i)</b></td>
							<td style="width: 600px">Identification (scientific name) of
								biological resources and its traditional use</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td><table class="table table-bordered innertable">
									<tr>
										<th>SrNo</th>
										<th>Intent to access</th>
										<th>Common Name</th>
										<th>Scientific Name</th>
										<th>Nature of Biological resources</th>
										<th>Part of Biological resources</th>
										<th>Quantity of Biological resources</th>
										<th>Time Span in Which the biological</th>
										<th>Traditional use, if any</th>
									</tr>
									<g:if test="${formDetails?.biologicalResources}">
										<g:each in="${formDetails?.biologicalResources}"
											var="bioResorce" status="j">
											<g:each in="${bioResorce}" var="bioRes" status="k">
												<tr>
													<td>
														${j+1}
													</td>
													<td>
														${bioRes?.name?:'NA'}
													</td>
													<td>
														${bioRes?.commonName?:'NA'}
													</td>
													<td>
														${bioRes?.scientificName?:'NA'}
													</td>
													<td>
														${bioRes?.nature?:'NA'}
													</td>
													<td>
														${bioRes?.biologicalResource?:'NA'}
													</td>
													<td>
														${bioRes?.quantity?:'NA'} ${bioRes?.qtyUnit?:'NA'}
													</td>
													<td>
													
														${bioRes?.fromTime?: 'NA'} - ${bioRes?.toTime?:'NA'}
													</td>
													<td>
														${bioRes?.traditionalUse?:'NA'}
													</td>
												</tr>
											</g:each>
										</g:each>
									</g:if>
								</table>
						</td>
							</tr>
							<tr>
							<td></td>
							<td style="width: 35px"><b>(ii)</b></td>
							<td style="width: 600px">Geographical location of proposed
								collection</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td><table class="table table-bordered innertable">

									<tr>
										<th>SrNo</th>
										<th>Name biological resources</th>
										<th>Source of access</th>
										<th>village / panchayat</th>
										<th>Town / Taluka</th>
										<th>District</th>
										<th>State</th>
										<th>Name</th>
										<th>Contact Details</th>
									</tr>
									<g:if test="${formDetails?.biologicalResources?.locations}">
										<g:each in="${formDetails?.biologicalResources?.locations}"
											var="giolocation" status="l">
											<g:each in="${giolocation}" var="gioloct" status="m">
												<g:each in="${gioloct}" var="gioloc" status="n">
													<tr>

														<td>
															${l+1}
														</td>
														<td>
														${gioloc?.bioResource?.scientificName?:'NA'}
															
														</td>
														<td>
														${gioloc?.source?:'NA'}	
														</td>
														<td>
														${gioloc?.village?:'NA'}
														</td>
														<td>
															${gioloc?.town?: 'NA'}
														</td>
														<td>
															${gioloc?.district?:'NA'}
														</td>
														<td>
															${gioloc?.state?:'NA'}
														</td>
														<td>
															${gioloc?.traderName?:'NA'}
														</td>
														<td>
															${gioloc?.traderContactDetails?:'NA'}
														</td>
													</tr>
												</g:each>
											</g:each>
										</g:each>
									</g:if>
								</table></td>
						</tr>

					</table>
				</div>
				<div id="Contact" class="tabcontent">
					<h2 class="text-center">
						${formDetails?.category?.category}
					</h2>
					
					<g:if
						test="${formDetails?.category?.category == FormCategory.Category.Form_1}">
						<center>
							<span class="text-center">(See Rule 14 of Biological
								Diversity Rules, 2004)<br /> Application form for access to the
								Biological Resources and associated traditional knowledge
							</span>
						</center>
					</g:if>
					<g:elseif
						test="${formDetails?.category?.category == FormCategory.Category.Form_2 }">
						<center>
							<span class="text-center"> (See Rule 17 of Biological
								Diversity Rules, 2004)<br /> Application for seeking prior
								approval of National Biodiversity Authority for transferring the
								results of research to foreign nationals,companies, NRIs for
								commercial purposes.
							</span>
						</center>
					</g:elseif>
					<g:elseif
						test="${formDetails?.category?.category == FormCategory.Category.Form_3 }">
						<center>
							<span class="text-center"> (See Rule 18 of Biological
								Diversity Rules, 2004)<br /> Application form for applying for
								Intellectual Property Right.
							</span>
						</center>
					</g:elseif>
					<g:elseif
						test="${formDetails?.category?.category == FormCategory.Category.Form_4 }">
						<center>
							<span class="text-center"> (See Rule 19 of Biological
								Diversity Rules, 2004)<br /> Application form for third party
								transfer of the accessed biological resources and associated
								traditional knowledge.
							</span>
						</center>
					</g:elseif>
					<g:elseif
						test="${formDetails?.category?.category == FormCategory.Category.Form_B }">
						<center>
							<span class="text-center"> (See Regulation 13 of the
								Guidelines on Access to biological resources and associated
								knowledge and Benefits Sharing Regulations, 2014) <br>
								Conducting of non-commercial research or research for emergency
								purposes outside India by Indian researcher’s/ Government
								institutions
							</span>
						</center>
					</g:elseif>
					<g:elseif
						test="${formDetails?.category?.category == FormCategory.Category.Form_C }">
						<center>
							<span class="text-center"> (Deposition of micro-organism
								by Indian scientist / researchers in non-Indian repository for
								claim of novel species.) </span>
						</center>
					</g:elseif>

					<span class="pull-left" style="padding: 10px 0;"><b>Submitted
							On :</b> ${submittedDate}</span> <span class="pull-right"
						style="padding: 10px 0;"><b>Application No :</b> ${applicationNum}</span>
					<table class="table table-bordered customtable">
						<tr class="header">
							<th>S.No</th>
							<th>Date</th>
							<th>Title</th>
							<th>Show</th>
						</tr>
						<%int counter = 0 %>
						<g:if test="${formDetails?.sbbConsents}">
						<g:each in="${formDetails?.sbbConsents}" var="pdfFle"
								status="i">

							<g:if test="${pdfFle?.fileName || pdfFle?.filePath}">
									<tr style="background: #fff;">
										<td style="font-weight: 600;">
											${counter = counter+1}

										</td>
										<g:if test="${pdfFle?.consentCreatedDate}">
										<td style="font-weight: 600;">
										
									<g:formatDate format="dd/MM/yyyy"
													date="${pdfFle?.consentCreatedDate}" />
													
										</td>
										</g:if>
										<g:else>
										<td style="font-weight: 600;">NA</td>
										</g:else>
										<td>${pdfFle?.fileName?:'NA'}
<%--										<g:link style="color: #000;" controller="dashboard"--%>
<%--													action="showPdf" target="_blank"--%>
<%--													params="${[showId:pdfFle?.id,csrfPreventionSalt:csrfPreventionSalt] }">--%>
<%--												<i style="color: #e02025; padding-right: 4px;"--%>
<%--														class="fa fa-file-pdf-o"></i>--%>
<%--												${pdfFle?.fileName?:'NA'}--%>
<%--											</g:link>--%>
											</td>
<%--   for download file downloadFile   --%>
										<td style="text-align: center !important"><g:link
													controller="SBB" action="sbbFileShows" target="_blank"
													params="${[showId:pdfFle?.id,csrfPreventionSalt:csrfPreventionSalt]}">
												<i class="fa fa-clone"></i>
											</g:link></td>
									</tr>
									</g:if>
								</g:each>
							</g:if>
   <g:if test="${formDetails?.clientLetters}">
   <g:each var="act" in="${formDetails?.clientLetters}">
   <g:each var="dynamic" in="${act?.pdfFileAttachments }">
   
   <g:if test="${dynamic?.pdfName || dynamic?.attachedUrl}">
                <tr style="background: #fff;">
										<td style="font-weight: 600;">${counter = counter+1}</td>
										
										<td style="font-weight: 600;">
										<g:formatDate format="dd/MM/yyyy" date="${dynamic?.attachedDate}" />
										
									  </td>
										
										
										<td>${dynamic?.pdfName}</td>

										<td style="text-align: center !important"><g:link
													controller="SBB" action="dynamicLetterShow"  target="_blank"
													params="${[dynamicId:dynamic?.id,csrfPreventionSalt:csrfPreventionSalt]}">
												<i class="fa fa-clone"></i>
											</g:link></td>
									</tr>
									</g:if>
									</g:each>
                           </g:each>
                          </g:if>

					</table>
				</div>
			
			</div>
		</div>
	</div>


<div id="main">
	<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
	<span class="openbtn" style="font-size: 30px; cursor: pointer"
		onclick="openNav()">&#9776;</span>
</div>

<script>
$( document ).ready(function() {
    $(".closebtn").hide();
});
$( document ).ready(function() {
    $(".closebtn").hide();
});
function openNav() {
	  var scroll = $(window).width();	
	
	if (scroll >= 320 && scroll <= 480) {
  document.getElementById("mySidenav").style.width = "310px";
  }
  if (scroll >= 481 && scroll <= 500) {
  document.getElementById("mySidenav").style.width = "470px";
  }
  if (scroll >= 501 && scroll <= 1199) {
  document.getElementById("mySidenav").style.width = "400px";
  }
  if (scroll >= 1200 ) {
  document.getElementById("mySidenav").style.width = "540px";
  }
	document.getElementById("costum-lft").style.width = "600px";
	$(".closebtn").show();
	$(".openbtn").hide();
  if (scroll >= 992 && scroll <= 1199) {
  document.getElementById("costum-lft").style.width = "360px";
  }
  if (scroll >= 1200 && scroll <= 1380) {
  document.getElementById("costum-lft").style.width = "570px";
  }
  if (scroll >= 1201 && scroll <= 1400) {
  document.getElementById("costum-lft").style.width = "570px";
  }
  if (scroll >= 1401 && scroll <= 1600) {
  document.getElementById("costum-lft").style.width = "58%";
  }
  if (scroll >= 1601 && scroll <= 1900) {
  document.getElementById("costum-lft").style.width = "62%";
  }
  if (scroll >= 1901 ) {
  document.getElementById("costum-lft").style.width = "69%";
  }
}
function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
	document.getElementById("costum-lft").style.width = "100%";
	$(".closebtn").hide();
	$(".openbtn").show();
}
</script>