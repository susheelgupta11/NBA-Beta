<%! import org.nba.common.*%>

<% char alpha = 65 %>
<g:if test="${allDataforMatching?.individualDetailsForMatch.size()>0}">
<g:each in="${allDataforMatching?.individualDetailsForMatch}" var="individualProfile" status="i">
<tr>
	<td></td>
	<td width="35px"><b>(${alpha})</b></td>
	<td colspan="2"><b>Applicant ${i+1}</b></td>
	<td></td>
	
</tr>
<tr>
	<td width="35px"></td>
	<td width="35px" rowspan="3"><b>(i)</b></td>
	<td width="35px"><b>(a)</b></td>
	<td style="width: 50% !important"><b>Name :</b></td>
	
	<td class="righttd">${individualProfile?.title} ${individualProfile?.firstName} ${individualProfile?.middleName} ${individualProfile?.lastName}</td>
</tr>
<tr>
	<td width="35px"></td>
	<td width="35px"><b>(b)</b></td>
	<td><b>Nationality :</b></td>
<%--	<td class="text-center"><b></b></td>--%>
	 <g:if test="${individualProfile?.nationality == 'Non Indian'}">
                          <td class="righttd"><span>${individualProfile?.nationality}: ${individualProfile?.country?.country}
                            </span></td>
                        </g:if>
                        <g:else>
                            <td><span>${individualProfile?.nationality}
                            </span></td>
                        </g:else>
</tr>
<tr>
	<td width="35px"></td>
	<td width="35px"><b>(c)</b></td>
	<td><b>Profile of the Applicant(s) :</b></td>
<%--	<td class="text-center"><b>:</b></td>--%>
	<td class="righttd">${individualProfile?.profile}</td>
</tr>
<tr>
	<td></td>
	<td width="35px"><b>(ii)</b></td>
	<td colspan="2"><b>Permanent Address :</b></td>
<%--	<td class="text-center"><b>:</b></td>--%>
	<td class="text-left">			${individualProfile?.address1} ${individualProfile?.address2} ${individualProfile?.address3}
			${individualProfile?.city} ${individualProfile?.pincode} 
<%--			${State.findById(individualProfile?.province)?.state}--%>
			${individualProfile?.country?.name}<br/> <b>Mobile No:</b> ${individualProfile?.mobile}<br />
			<b>individualProfile No:</b> ${individualProfile?.phone} <br /> <b>Email:</b>
			${individualProfile?.email}<br />
	</td>
</tr>
	<tr>
		<td width="35px"></td>
		<td width="35px"><b>(c)</b></td>
		<td><b> Attached ID proof</b></td>
		<td class="text-center"><b>:</b></td>

		<td class="righttd">	${individualProfile?.idProofFileName}
		<g:link controller="applicationManagement"
						action="showIndividualDc" id="${individualProfile?.id}" target="_blank"
						params="[filename: 'idProof', dataName: 'idProof',csrfPreventionSalt:'${csrfPreventionSalt}']">
					(Click here to view)
					</g:link>
<br/>${individualProfile?.idNum}</td>
	</tr>

	<tr>
		<td width="35px"></td>
		<td width="35px"><b>(d)</b></td>
		<td><b>Attached Authorization letter</b></td>
		<td class="text-center"><b>:</b></td>

		<td class="righttd"><g:if test="${individualProfile?.authorizationLetterFileName}">
            ${individualProfile?.authorizationLetterFileName}
		<g:link controller="applicationManagement"
				action="showIndividualDc" id="${individualProfile?.id}"
				target="_blank"
				params="[filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:'${csrfPreventionSalt}']">
				(Click here to view)
			</g:link>
			<br/> ${individualProfile?.authorizationNo }
			</g:if>
			<g:else>
			(No document attached.)
			</g:else>
			</td>
	</tr>

	<tr>
		<td width="35px"></td>
		<td width="35px"><b>(e)</b></td>
		<td><b>Attached Passport</b></td>
		<td class="text-center"><b>:</b></td>

		<td class="righttd"><g:if test="${individualProfile?.passportCopyFileName}">
		${individualProfile?.passportCopyFileName}
		<g:link controller="applicationManagement"
				action="showIndividualDc" id="${individualProfile?.id}"
				target="_blank"
				params="[filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:'${csrfPreventionSalt}']">
			(Click here to view)
			</g:link>
			<br/>${individualProfile?.passportNum}
			</g:if>	
			<g:else>
			(No document attached.)
			</g:else>
			</td>
	</tr>
	
	</g:each>
	</g:if>


<g:if test="${allDataforMatching?.companyDetailsForMatch.size() > 0}">
	<g:each in="${allDataforMatching?.companyDetailsForMatch}" var="company" status="j">
		<tr>
			<td></td>
			<td width="35px"><b>(${alpha})
			</b></td>
			<td colspan="2"><b>Applicant ${ j+1}</b></td>
			<td colspan="2"></td>
			
		</tr>
		<tr>
			<td width="35px"></td>
			<td width="35px" rowspan="3"><b>(i)</b></td>
			<td width="35px"><b>(a)</b></td>
			<td style="width: 50% !important"><b>Name of Entity :</b></td>
<%--			<td class="text-center"><b>:</b></td>--%>
			<td class="righttd" colspan="2">
				${company?.entityName}
			</td>
		</tr>
		<tr>
			<td width="35px"></td>
			<td width="35px"><b>(b)</b></td>
			<td><b>Type of Entity :</b></td>
<%--			<td class="text-center"><b>:</b></td>--%>
			<td class="righttd">
				${company?.entityType}
			</td>
		</tr>
		<tr>
			<td width="35px"></td>
			<td width="35px"><b>(c)</b></td>
			<td><b>Status :</b></td>
<%--			<td class="text-center"><b>:</b></td>--%>
			<td class="righttd"><g:if
					test="${company?.nationality == 'notRegisteredInIndia' }">
								Not incorporated or registered in India
							</g:if> <g:elseif
					test="${company?.nationality == 'noNonIndianParticipation' }">
								Registered in India and does not have any non-Indian participation in share capital or management
							</g:elseif> <g:else>
								Incorporated or registered in India under
								any law for the time being in force which has any non-Indian
								participation in its share capital or management  
							</g:else></td>
		</tr>
		<tr>
			<td></td>
			<td width="35px"><b>(ii)</b></td>
			<td colspan="2"><b>Permanent Address :</b></td>
<%--			<td class="text-center"><b>:</b></td>--%>
			<td class="text-left">
				${company?.address1} ${company?.address2} ${company?.address3} ${company?.city}
				${company?.pincode}
<%--				 ${State.findById(company?.province)?.state} --%>
				 ${company?.country?.name}
				<br /> <b>Mobile No:</b> ${company?.mobile}<br /> <b>Phone No:</b> ${company?.phone}
				<br /> <b>Email:</b> ${company?.email}<br /> <b>Website:</b> ${company?.website}
			</td>
		</tr>
		<tr>
			<td></td>
			<td class="text-center"><b>(iii)</b></td>
			<td colspan="4" class="leftalign "><b>Profile of the
					Organization</b></td>
		</tr>
		<tr>
			<td width="35px"></td>
			<td width="35px" rowspan="2"><b></b></td>
			<td width="35px"><b>(a)</b></td>
			<td><b>Nature of Business :</b></td>
<%--			<td class="text-center"><b>:</b></td>--%>
			<td class="righttd">
				${company?.businessNature}
			</td>
		</tr>
		<tr>
			<td width="35px"></td>
			<td width="35px"><b>(b)</b></td>
			<td><b>Attachment copy of Document of incorporation or
					registration duly attested by the competent authority</b></td>
<%--			<td class="text-center"><b>:</b></td>--%>
			<td class="righttd"><g:if
					test="${allDataforMatching?.companyDetailsForMatch?.registrationDoc}">
					${company?.registrationDocName}
					<g:link controller="applicationManagement" action="showDc"
						id="${company?.id}" target="_blank" class="fumargin"
						params="[filename: 'registrationDocName', dataName: 'registrationDoc',csrfPreventionSalt:'${csrfPreventionSalt}']">
				(Click here to view)
			</g:link>
				</g:if> <g:else>
					<span class="text-danger">Document Not Attached</span>
				</g:else></td>
		</tr>
		<tr>
			<td></td>
			<td class="text-center"><b>(iv)</b></td>
			<td colspan="4" class="leftalign "><b>Details of authorized
					representative of Entity</b></td>
		</tr>
		<tr>
			<td width="35px"></td>
			<td width="35px" rowspan="4"><b></b></td>
			<td width="35px"><b>(i)</b></td>
			<td><b>Name :</b></td>
<%--			<td class="text-center"><b>:</b></td>--%>
			<td class="righttd">
				${company?.title} ${company?.firstName} ${company?.middleName} ${company?.lastName}
			</td>
		</tr>
		<tr>
			<td width="35px"></td>
			<td width="35px"><b>(ii)</b></td>
			<td><b>Designation :</b></td>
<%--			<td class="text-center"><b>:</b></td>--%>
			<td class="righttd">
				${company?.designation}
			</td>
		</tr>
		<tr>
			<td width="35px"></td>
			<td width="35px"><b>(iii)</b></td>
			<td><b>Mobile Number & Email id :</b></td>
<%--			<td class="text-center"><b>:</b></td>--%>
			<td class="righttd"><b>Mobile :</b> ${company?.personMobile} <br />
				<b>Emaild Id :</b> ${company?.personEmail}</td>
		</tr>
		<tr>
			<td width="35px"></td>
			<td colspan="2"><b>Attachment :</b></td>
<%--			<td class="text-center"><b>:</b></td>--%>
			<td class="righttd"><table class="table table-bordered">
					<tr>
						<td><b>Id Numbers</b><br /> ${company?.idNum}</td>

						<td>Attachment<br /> <g:if
								test="${allDataforMatching?.companyDetailsForMatch?.passportCopy}">
								<g:link controller="applicationManagement" action="showDc"
									id="${company?.id}" target="_blank"
									params="[filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:'${csrfPreventionSalt}']">
									${company?.passportCopyFileName}
								</g:link>
							</g:if> <g:else>
								<span class="text-danger">Document Not Attached</span>
							</g:else></td>
					</tr>
					<tr>
						<td colspan="2">Attachment authorized letter:<g:link
								controller="applicationManagement" action="showDc"
								id="${company?.id}" target="_blank"
								params="[filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:'${csrfPreventionSalt}']">
							(click here to preview)
						</g:link></td>
					</tr>
				</table></td>
		</tr>
	</g:each>
</g:if>
	<g:render template="/rightPane/agentProfileMatching"></g:render>
	
	<g:set var="listOfIPRDetails" value="${allDataforMatching?.listOfIPRDetails}"/>
		<table class="table table-bordered">

			<tr class="previewheading">
				<td class="text-center one"><b>(2)</b></td>
				<td colspan="4"><b>Details of Invention on which IPR is
						sought</b></td>
			</tr>
			<tr>
				<td></td>
				<td class= "one"><b>(a)</b></td>
				<td class="fifty">Title of the invention</td>
				<td class="one"><b>:</b></td>
				<td>
					${formDetails?.titleOfIPR}
				</td>
			</tr>
			<tr>
				<td></td>
				<td><b>(b)</b></td>
				<td class="fifty">Abstract of the invention</td>
				<td class="one"><b>:</b></td>
				<td>
					${formDetails?.abstractOfIPR}
				</td>
			</tr>
			<tr>
				<td></td>
				<td><b>(c)</b></td>
				<td class="fifty">Details of territories / patent offices where the applicant intends to apply for the present invention</td>
				<td class="one"><b>:</b></td>
				<td>
					<g:each status="i" in = "${formDetails?.detailsOfTerritories }" var= "countries">
					  <g:if test= "${formDetails?.detailsOfTerritories?.size() - i == 1  }">	
						${countries?.country }.
					  </g:if>
					  <g:else>
					  	${countries?.country },
					  </g:else>	
					</g:each>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><b>(d)</b></td>
				<td class="fifty">Whether IP application filed for the present invention</td>
				<td class="one"><b>:</b></td>
				<td>
					<g:if test= "${formDetails?.isIPApplicationFiled == 'true' }">
						Yes
					</g:if>
					<g:else>
						No
					</g:else>
				</td>
			</tr>

			<g:if test= "${formDetails?.isIPApplicationFiled == 'true' }">
			<tr>
				<td></td>
				<td class="one"></td>
				<td colspan="3">
					<table class="table table-bordered datatable1">
						<thead>
							<tr>
								<th>S.no</th>
								<th>Country/Territory name</th>
								<th>Patent Application No.</th>
								<th>Date</th>
								<th>Status</th>
								<th>Patent no. & date if granted</th>
								<th>Specify reason</th>
							</tr>
						</thead>
						<tbody>
							<%i=1 %>
							<g:each in="${listOfIPRDetails}" var="ipr">
								<tr>
									<td scope="row"><%=i%></td>
									<%i++ %>
									<td scope="row">
									${Country.get(ipr?.country)?.country}
									</td>
									<td scope="row">
										${ipr?.patentApplicationNo}
									</td>
									<td scope="row">
										${ipr?.patentApplicationDate?.format('dd/MM/yyyy')}
									</td>
									<td scope="row">
										${ipr?.status}
									</td>
									<td scope="row">
										${ipr?.patentNo} ${ipr?.patentDate?.format('dd/MM/yyyy')}
									</td>
									<td scope="row"><g:if test="${ipr?.reasons}">
											${ipr?.reasons}
										</g:if> <g:else>N/A</g:else></td>
								</tr>
							</g:each>
						</tbody>
					</table>


				</td>
			</tr>
			</g:if>
			</table>
			
	<tr class="previewheading">
				<td class="text-center"><b>(3)</b></td>
				<td colspan="4"><b>Details of biological resources and/ or associated knowledge used in the invention</b></td>
			</tr>

		<g:if test= "${formDetails?.biologicalResources }">
			<tr>
				<td></td>
				<td class="text-center"><b>(i)</b></td>
				<td colspan="3">Identification (scientific name) of biological
					resources and its traditional use</td>
			</tr>
              <tr>
				<td></td>
				<td></td>
				<td colspan="3">
					<table class="table table-bordered datatable1">
						<thead>
							<tr>
								<th>SI.No</th>
								<th>Accessed</th>
								<th>Common name</th>
								<th>Scientific name</th>
								<th>Nature of biological resources</th>
								<th>Part of biological resources</th>
<%--								<th>Quantity of biological resources</th>--%>
<%--								<th>Time span in which the biological</th>--%>
<%--								<th>Traditional use, if any</th>--%>
							</tr>
						</thead>
						<tbody>
							<%int i=1 %>
							<g:each in="${formDetails?.biologicalResources }" var="bioResource">
								<tr>
									<td class="text-center"><%=i %></td>
									<%i++ %>
									<td>${bioResource?.accessIntention}</td>
									<td>
										${bioResource?.commonName}
									</td>
									<td>
										${bioResource?.scientificName}
									</td>

									<td>
										${bioResource?.nature}
									</td>
									
									<td>
										${bioResource?.biologicalResource}
									</td>
<%--										<td>--%>
<%--										${bioResource?.quantity} ${bioResource?.qtyUnit}--%>
<%--									</td>--%>
<%--									<td>--%>
<%--										${bioResource?.fromTime?.format('dd/MM/yyyy')} - ${bioResource?.toTime?.format('dd/MM/yyyy')}--%>
<%--									</td>--%>
<%--									<td>--%>
<%--										${bioResource?.traditionalUse}--%>
<%--									</td>--%>
								</tr>
							</g:each>
						</tbody>
					</table>


				</td>
			</tr>
		</g:if>	
		<g:if test="${formDetails?.individualProfiles?.getAt(0)?.nationality == 'Non Indian' || formDetails?.individualProfiles?.getAt(0)?.nationality == 'Non-Resident Indian' 
					 || formDetails?.companyProfiles?.getAt(0)?.nationality == 'registeredInIndia' || formDetails?.companyProfiles?.getAt(0)?.nationality == 'noNonIndianParticipation'}">	
			
			<table>
			<tr>
				<td class= "one"></td>
				<td class= "one"><b>(a)</b></td>
				<td class="fifty">Whether approval of NBA obtained to access the biological resources and / or associated knowledge used in the invention</td>
				<td class="one"><b>:</b></td>
				<td>
					<g:if test= "${formDetails.isApprovalOfNbaObtainedForm3 == 'true'}">
						<span>Yes</span>
					</g:if>
					<g:else>
						<span>No</span>
					</g:else>
				</td>
			</tr>
			</table>
			<g:if test="${formDetails.isApprovalOfNbaObtainedForm3 == 'false' }">
			<table>
				<tr>
					<td class= "one"></td>
					<td class= "one"><b>(b)</b></td>
					<td class="fifty">Reason for not obtaining the prior approval of NBA</td>
					<td class="one"><b>:</b></td>
					<td>
						<g:if test= "${formDetails?.reasonOFNotObtainedApproval}">
							<span>${formDetails?.reasonOFNotObtainedApproval}</span>
						</g:if>
						<g:else>
							<span>N/A</span>
						</g:else>	
					</td>
				</tr>
				</table>
			</g:if>
			<g:elseif test="${formDetails.isApprovalOfNbaObtainedForm3 == 'true' }">
			<table>
			<tr>
				<td class= "one"></td>
				<td class= "one"><b>(b)</b></td>
				<td class="fifty">Application number</td>
				<td class="one"><b>:</b></td>
				<td>
					<g:if test= "${formDetails?.applicationNo }">
						<span>${formDetails?.applicationNo}</span>
					</g:if>
					<g:else>
						<span>N/A</span>
					</g:else>	
				</td>
			</tr>
			<tr>
				<td class= "one"></td>
				<td class= "one"><b>(c)</b></td>
				<td class="fifty">Date of Approval</td>
				<td class="one"><b>:</b></td>
				<td>
					<g:if test= "${formDetails?.isApprovalOfNbaObtainedForm3 == 'true' }">
						<span>${formDetails?.dateOfApproval?.format('dd/MM/yyyy')}</span>
					</g:if>
					<g:else>
						<span>N/A</span>
					</g:else>	
				</td>
			</tr>
			
			<tr>
				<td class= "one"></td>
				<td class= "one"><b>(d)</b></td>
				<td class="fifty">Self attested Copy of the NBA approval / agreement duly</td>
				<td class="one"><b>:</b></td>
				<td>
					<g:if test= "${formDetails?.nbaApprovalFile && formDetails?.isApprovalOfNbaObtainedForm3 == 'true' }">
						<g:link controller="form3" action="showDc" id="${formDetails?.id}"
											target="_blank"
											params='[filename: "nbaApprovalFileName", dataName: "nbaApprovalFileName",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
											click for preview
						</g:link>
					</g:if>
					<g:else>
						N/A
					</g:else>
				</td>
			</tr>
			</table>
			</g:elseif>
			
		</g:if>	
			
<table class="table table-bordered">
	<tr class="previewheading">
				<td class="text-center one"><b>(4)</b></td>
				<td colspan="4"><b>Geographical location of proposed collection</b></td>
			</tr>
			
		<tr>
				<td></td>
				<td class="text-center"><b>(ii)</b></td>
				<td colspan="3">Geographical location of proposed collection</td>
			</tr>
		
		<g:if test="${formDetails?.biologicalResources?.locations}">	
			<tr>
				<td></td>
				<td></td>
				<td colspan="3">
					<table class="table table-bordered datatable1 wordwrap">

						<thead>

							<tr>
								<th>SI.No</th>
								<th>Name of biological resource</th>
								<th>Source of access</th>
								<th>Village / Panchayat</th>
								<th>Town / Taluk</th>
								<th>District</th>
								<th>State</th>
								<th>Name</th>
								<th>Contact Details</th>
							</tr>
						</thead>
						<tbody>
						
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
                       
						</tbody>
					</table>

				</td>

			</tr>
			</g:if>
			
			

			<tr>
				<td></td>
				<td class="one"><b>(a)</b></td>
				<td><b>Whether any biological resources and/ or traditional knowledge used in the invention was obtained outside India</b></td>
				<td><b>:</b></td>
				<td>
					<g:if test="${formDetails?.isBioObtainedOutsideIndia == 'true' }">
											Yes</g:if>
										<g:elseif test= "${formDetails?.isBioObtainedOutsideIndia == 'false' }">
											 No
									</g:elseif>
									<g:else>
										
									</g:else>
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td><b>(b)</b></td>
				<td><b>Scientific name(s) and common name(s) of biological resource(s) and / or details of traditional knowledge used</b></td>
				<td><b>:</b></td>
				<td>
				  <g:if test="${formDetails?.isBioObtainedOutsideIndia == 'true' }">
					${formDetails?.traditionalKnowledgeDesc}
				  </g:if>
				  <g:elseif test="${formDetails?.isBioObtainedOutsideIndia == 'false'}">
				  	N/A
				  </g:elseif>
				  <g:else>
				  </g:else>
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td><b>(c)</b></td>
				<td><b>Whether approval of the country (ies), obtained for accessing the biological resources and / or associated traditional knowledge for the said invention.</b></td>
				<td><b>:</b></td>
				<td>
					<g:if test="${formDetails?.isBioObtainedOutsideIndia == 'false' }">
						N/A
					</g:if>
					<g:elseif test="${formDetails?.isApprovalOfCountryObtained == 'true' }">
						Yes
					</g:elseif>
					<g:elseif test="${formDetails?.isApprovalOfCountryObtained == 'false' }">
						No
					</g:elseif>
					
				</td>
			</tr>
			<g:if test="${formDetails?.isApprovalOfCountryObtained == 'false' }">
			<tr>
				<td></td>
				<td><b>(d)</b></td>
				<td><b>If no, specify the reasons thereon</b></td>
				<td><b>:</b></td>
				<td>
					<g:if test= "${formDetails?.reasonOfDisapproval }">
						${formDetails?.reasonOfDisapproval}
					</g:if>
					<g:else>
						N/A
					</g:else>	
				</td>
			</tr>
			</g:if>
			
			
			<tr class="previewheading">
				<td class="text-center"><b>(5)</b></td>
				
				<td colspan="4"><b>Details of any traditional knowledge used in the invention and any identified individual / community holding the traditional knowledge:</b></td>
			</tr>
			
			<tr>
			<td></td>
				<td colspan="2">Is applicable?</td>
				<td class="one"><b>:</b></td>
			  <g:if test= "${formDetails?.isTraditionalKnowledgeApplicable == 'Applicable' }">	
				<td>Yes</td>
			  </g:if>
			  <g:elseif test= "${formDetails?.isTraditionalKnowledgeApplicable == 'Not applicable' }">
			  	<td>No</td>
			  </g:elseif>
			  <g:else>
			  	<td> </td>
			  </g:else>	
				
			</tr>
			
			
		<g:if test= "${formDetails?.isTraditionalKnowledgeApplicable == 'Applicable' }">
			<tr>
			<td></td>
				<td colspan="2"></td>
				<td class="one"><b>:</b></td>
				<td>${formDetails?.traditionalKnowledgeUsedInInvention}</td>
				
			</tr>
		</g:if>
			

		<g:if test = "${formDetails?.isTraditionalKnowledgeApplicable != 'Applicable' || !listOfCommunityLocations }">	
			<tr>
				<td></td>
				<td><b>(a)</b></td>
				<td ><b>Geographical location of the community / individual</b></td>
				<td><b>:</b></td>
				<td>No</td>
			</tr>
		</g:if>
		<g:else>	
			<tr>
				<td></td>
				<td><b>(a)</b></td>
				<td colspan = "3"><b>Geographical location of the community / individual</b></td>
			</tr>
		</g:else>	

<%--		<g:if test = "${formDetails?.isNoForTraditional != 'No' || formDetails?.isTraditionalKnowledgeApplicable == 'Applicable' }">	--%>
			<g:if test = "${formDetails?.isTraditionalKnowledgeApplicable == 'Applicable' }">
			<g:if test="${listOfCommunityLocations}">
			<tr>
				<td></td>
				<td colspan="4">
					<table class="table table-bordered datatable1">
						<thead>
							<tr>
								<th class="text-center">Sl. No</th>
								<th>Traditional knowledge</th>
								<th>Village / Panchayat</th>
								<th>Town / Taluk</th>
								<th>District</th>
								<th>State</th>
							</tr>
						</thead>
						<tbody>
							
								<%int a=1 %>
								<g:each in="${listOfCommunityLocations}" var="location">
									<tr>
										<td scope="row" class= "text-center"><%=a %></td>
										<%a++ %>
										<td scope="row">
											${location?.communityKnowledge}
										</td>
										<td scope="row">
											${location?.village}
										</td>
										<td scope="row">
											${location?.town}
										</td>

										<td scope="row">
											${location?.district}
										</td>
										<td scope="row">
											${State?.findById(location?.state)?.state}
										</td>
									</tr>
								</g:each>
						</tbody>
					</table>
				</td>
			</tr>
			</g:if>
		</g:if>
	
			<tr class="previewheading">
				
				<td><b>(6)</b></td>
				<td colspan="4"><b>Details of institution where Research and Development activities carried out</b></td>
			</tr>

			
<%--<g:if test="${formDetails?.isRAndDParticipationForm3 == true }">--%>
			<tr>
				<td></td>
				
				
				<td colspan="4">${formDetails?.detailsOfInstitute}</td>
			</tr>
<%--	</g:if>		--%>

			<tr class="previewheading">
				
				<td><b>(7)</b></td>
				<td colspan="4"><b>Details of economic, biotechnological, scientific or any other benefits that are intended, or may accrue to the applicant due to commercialization of the invention</b></td>
			</tr>

			<tr>
			<td></td>
				
				<td colspan="4">${formDetails?.benefitsToTheApplicant}</td>
			</tr>
			
		
		</table>

	<table class="table table-bordered datatable">
<tr class="previewheading">
<td><b>8</b></td>
				<td colspan="3"><b>Declaration:</b></td>
			</tr>
			
		<g:if test="${formDetails?.isDeclarationDigitallySigned == 'true' }">
			<tr>

			<td class="one text-center"><b>(a)</b></td>
			<td colspan="3">Declaration with digital signature</td>
			</tr>
		</g:if>
		<g:else>	
			<tr>

			<td class="one text-center"><b>(a)</b></td>
			<td colspan="3">Declaration without digital signature</td>
			</tr>
		</g:else>	
			

			<g:if test= "${formDetails?.submitCheck == true }">
			<tr>
			<td class="one text-center"><input type="checkbox" checked="checked" disabled="disabled"/></td>
			<td colspan="3">I / We further declare that information provided in the application form is true and correct and I / we shall be responsible for any incorrect / wrong information.</td>
			</tr>
		</g:if>
		<g:else>
			<tr>
			<td class="one text-center"><input type="checkbox"  disabled="disabled"/></td>
			<td colspan="3">I / We further declare that information provided in the application form is true and correct and I / we shall be responsible for any incorrect / wrong information.</td>
			</tr>
		</g:else>	
</table>


				<g:if test="${formDetails?.transaction?.isPaymentMade == true }">
				 <div class="table-responsive">
				  <table class="table table-bordered datatable">
					<tr class="previewheading">

						<td colspan="5"><b>Payment Details:</b></td>
					</tr>
					<tr>
						<td class= "text-center one">(a)</td>
						<td colspan="2">Transaction Id</td>
						<td class="one"><b>:</b></td>
						<td>
							${formDetails?.transaction?.transactionId}
						</td>
					</tr>
					<tr>
						<td class= "text-center one">(b)</td>
						<td colspan="2">Payment Reference Number</td>
						<td class="one"><b>:</b></td>
						<td>
							${formDetails?.transaction?.paymentRefNo}
						</td>
					</tr>
					<tr>
						<td class= "text-center one">(c)</td>
						<td colspan="2">Payment Amount</td>
						<td class="one"><b>:</b></td>
						<td>
							Rs. 500/-
						</td>
					</tr>
					<tr>
						<td class= "text-center one">(d)</td>
						<td colspan="2">Payment Receipt</td>
						<td class="one"><b>:</b></td>
						<td><g:link controller="applicationManagement" action="showIndividualDc"
										id="${formDetails?.transaction?.id}" target="_blank"
										params='[filename: "paymentReceipt", dataName: "paymentReceipt", appFormId: formDetails?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
										Click to preview Payment Receipt
									</g:link></td>
					</tr>
					</table>
				</div>	
				</g:if>
