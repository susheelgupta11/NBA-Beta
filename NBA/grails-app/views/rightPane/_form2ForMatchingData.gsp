
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
	<td class="righttd">${individualProfile?.nationality}</td>
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
			${individualProfile?.country?.name} <b>Mobile No:</b> ${individualProfile?.mobile}<br />
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
						params="${[filename: 'idProof', dataName: 'idProof',csrfPreventionSalt:csrfPreventionSalt]}">
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
				params="${[filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:csrfPreventionSalt]}">
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
				params="${[filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:csrfPreventionSalt]}">
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
			<td class="righttd" colspan="2">
				${company?.entityType}
			</td>
		</tr>
		<tr>
			<td width="35px"></td>
			<td width="35px"><b>(c)</b></td>
			<td><b>Status :</b></td>
<%--			<td class="text-center"><b>:</b></td>--%>
			<td class="righttd" colspan="2"><g:if
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
			<td class="text-left" colspan="2">
				${company?.address1} ${company?.address2} ${company?.address3} ${company?.city}
				${company?.pincode} ${company?.province} ${company?.country?.name}
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
						params="${[filename: 'registrationDocName', dataName: 'registrationDoc',csrfPreventionSalt:csrfPreventionSalt]}">
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
				<b>Email Id :</b> ${company?.personEmail}</td>
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
									params="${[filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:csrfPreventionSalt]}">
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
								params="${[filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:csrfPreventionSalt]}">
							(click here to preview)
						</g:link></td>
					</tr>
				</table></td>
		</tr>
	</g:each>
</g:if>

<g:render template="/rightPane/agentProfileMatching"></g:render>

     <table class="table table-bordered">
			<tr class="previewheading">
				<td class="text-center"><b>2</b></td>
				<td colspan="4"><b>Details of the results of research conducted</b></td>
			</tr>
			<tr>
				<td class= "one"></td>
				<td class= "one"><b>(a)</b></td>
				<td class="fifty">A brief detail of research conducted</td>
				<td class="one"><b>:</b></td>
				<td>${formDetails?.briefDescription}</td>

			</tr>
			<tr>
				<td></td>
				<td><b>(b)</b></td>
				<td class="fifty">Type of results of research to be transferred</td>
				<td class="one"><b>:</b></td>
				<td>${formDetails?.resultsOfResearch}</td>
			</tr>
      </table>



<g:render template="/rightPane/bioResourceAndLocationDetails"></g:render>

 <table class="table table-bordered">
<g:if test="${formDetails?.individualProfiles?.size() > 0 && formDetails?.individualProfiles?.getAt(0)?.nationality == 'Non Indian' || formDetails?.individualProfiles?.getAt(0)?.nationality == 'Non-Resident Indian' }">	
			<tr>
				<td class= "one"></td>
				<td class= "one"><b>(a)</b></td>
				<td class="fifty">Whether approval of NBA obtained to access the biological resources and / or associated knowledge for the said research</td>
				<td class="one"><b>:</b></td>
				<td>
					<g:if test= "${formDetails.isApprovalOfNbaObtained == 'true'}">
						<span>Yes</span>
					</g:if>
					<g:else>
						<span>No</span>
					</g:else>
				</td>
			</tr>
			
			<tr>
				<td class= "one"></td>
				<td class= "one"><b>(b)</b></td>
				<td class="fifty">Self attested Copy of the NBA approval / agreement duly</td>
				<td class="one"><b>:</b></td>
				<td>
					<g:if test= "${formDetails?.nbaApprovalFile }">
						<g:link controller="form2" action="showDc"
												id="${formDetails?.id}" target="_blank"
												params='[filename: "nbaApprovalFileName", dataName: "nbaApprovalFileName",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
												<span>click for preview</span>
						</g:link>
					</g:if>
					<g:else>
						N/A
					</g:else>
				</td>
			</tr>
			
		</g:if>	
 </table>
		
	<table class="table table-bordered">

		<g:if test= "${formDetails?.isNoForTraditional == 'No' }">
			<tr class="previewheading">
				<td class="text-center one"><b>(3)</b></td>
				<td colspan="2"><b>Description / nature of traditional knowledge (oral
						/ documented)</b></td>
				<td><b>:</b></td>
				<td>
					${formDetails?.isNoForTraditional}
				</td>
			</tr>
		</g:if>
		<g:if test= "${formDetails?.isNoForTraditional != 'No' }">
			<tr class="previewheading">
				<td class="text-center one"><b>(3)</b></td>
				<td colspan="4"><b>Description / nature of traditional knowledge (${formDetails?.nature})</b></td>
			</tr>
		</g:if>	
			
			
			<g:if test= "${formDetails?.isNoForTraditional != 'No' }">
			<tr>
				<td></td>
				<td></td>
				<td>Description</td>
				<td><b>:</b></td>
				<td>
					${formDetails?.traditionalKnowledgeDesc}
				</td>
			</tr>
			</g:if>
			<tr>
				<td></td>
				<td><b>(d)</b></td>
				<td colspan="3"><b>Geographical location of the community / individual</b></td>
<%--				<td class="text-center"><b>:</b></td>--%>
<%--				<td></td>--%>
			</tr>
			<g:if test= "${formDetails?.isNoForTraditional == 'No' || allDataforMatching?.listOfCommunityLocations ?.size() == 0}">
			<tr>
				<td></td>
				<td></td>
				<td>(i) Consent obtained from the community / individual</td>
				<td class="text-center"><b>:</b></td>
				<td>No</td>
			</tr>
			</g:if>

			<g:if test="${allDataforMatching?.listOfCommunityLocations }">
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
							<g:if test="${allDataforMatching?.listOfCommunityLocations }">
								<%int a=1 %>
								<g:each in="${allDataforMatching?.listOfCommunityLocations }" var="location">
									<tr>
										<td scope="row"><%=a %></td>
										<%a++ %>
										<td scope="row">${location?.communityKnowledge}	
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
		</g:if>
	</tbody>
   </table>
</td>
			</tr>
		</g:if>	
			
	



			<tr class="previewheading">
				<td class="text-center one"><b>(4)</b></td>
				<td colspan="4"><b>Details of institution where R&D activities carried out</b></td>
			</tr>

			
			<tr>
				<td></td>

				<td class="text-center one"><b>(i)</b></td>
				<td>Provide the name and contact details of the institution / organisation where R & D was carried out</td>
				<td class="text-center"><b>:</b></td>
				<td>
				  <g:if test="${formDetails?.detailsOfInstitute}">
					   ${formDetails?.detailsOfInstitute}
				  </g:if>
				  <g:else>
				  		N/A
				  </g:else>	
				</td>
			</tr>

			<tr>
				<td></td>

				<td class="text-center"><b>(ii)</b></td>
				<td>Attach bona-fide letter to the applicant issued by the competent authority of the institution/ organization where R&D was carried out.</td>
				<td class="text-center"><b>:</b></td>
				<td><g:if test="${formDetails?.bonafideLetter || formDetails.isResearchParticipation == 'true'}">
										<g:link controller="form2" action="showDc"
												id="${formDetails?.id}" target="_blank"
												params='[filename: "bonafideLetterName", dataName: "bonafideLetterName",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
												${formDetails?.bonafideLetterName}
											</g:link>
								
									</g:if>
									<g:else>
									<span>N/A</span>
											</g:else>		
									</td>
			</tr>
			
			</table>
			

<table class="table table-bordered datatable">
			<tr class="previewheading">
				<td class="text-center one"><b>(5)</b></td>
				<td colspan="4"><b>Details of
								individual/ organisation to whom the research results are
								intended to be transferred </b></td>
			</tr>
			<tr>
				<td></td>
				<td><b>(a)</b></td>
				<td>Name and contact details of individual / organisation</td>

				<td class="text-center"><b>:</b></td>
			
				<td>${formDetails?.detailsOfInstitute}</td>
			</tr>
			<tr>
				<td></td>
				<td><b>(b)</b></td>
				<td>Details of the intended use of research results by the transferee</td>

				<td class="text-center"><b>:</b></td>
			
				<td>${formDetails?.useofResearchResults}</td>
			</tr>

			

			<tr class="previewheading">
				<td class="text-center"><b>(6)</b></td>
				<td colspan="4"><b>Details of economic, biotechnological, scientific or any other benefits that are
								intended, or may accrue to the individual / organization due to
								commercialization of transferred research results</b></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2"></td>
				<td class="text-center"><b>:</b></td>
				<g:if test= "${formDetails?.benefitsToTheIndividualOrOrganization}">
					<td>${formDetails?.benefitsToTheIndividualOrOrganization}</td>
				</g:if>
				<g:else>
					<td>Details in 100 words</td>
				</g:else>
			</tr>
			
			<tr class="previewheading">
				<td class="text-center"><b>(7)</b></td>
				<td colspan="4"><b>Details of economic, biotechnological, scientific or any other benefits that are
								intended, or may accrue to the applicant seeking approval for
								transfer of results of research</b></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2"></td>
				<td class="text-center"><b>:</b></td>
				<g:if test= "${formDetails?.benefitsToTheApplicant}">
					<td>${formDetails?.benefitsToTheApplicant}</td>
				</g:if>
				<g:else>
					<td>Details in 100 words</td>
				</g:else>
			</tr>

			<tr class="previewheading">
				<td class="text-center"><b>(8)</b></td>
				<td colspan="4"><b>Details of any agreement or MoU between the proposed recipient and applicant
								seeking approval for transfer of results of research</b></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2">Is there any such detail</td>
				<td class="text-center"><b>:</b></td>
				<g:if test= "${formDetails?.collaborationDetails}">
					<td>Yes</td>
				</g:if>
				<g:else>
					<td>No</td>
				</g:else>
			</tr>
			
		<g:if test= "${formDetails?.collaborationDetails}">	
			<tr>
				<td></td>
				<td colspan="2"></td>
				<td class="text-center"><b>:</b></td>
				<g:if test= "${formDetails?.collaborationDetails}">
					<td>${formDetails?.collaborationDetails}</td>
				</g:if>
				<g:else>
					<td>N/A</td>
				</g:else>
			</tr>
			<tr>
				<td></td>
				<td colspan="2">Attached copy of the relevant agreement or MoU</td>
				<td class="text-center"><b>:</b></td>
				<td><g:link controller="form2" action="showDc" id="${formDetails?.id}"
									target="_blank"
									params='[filename: "mouFileName", dataName: "mouFileName",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
									${formDetails?.mouFileName}
								</g:link></td>
			</tr>
</g:if>


		</table>





<g:render template="/rightPane/part5"></g:render>
