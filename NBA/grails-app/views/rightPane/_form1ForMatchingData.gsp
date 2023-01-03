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

		<td class="righttd">${individualProfile?.idProofFileName}
		<g:link controller="applicationManagement"
						action="showIndividualDc" id="${individualProfile?.id}" target="_blank"
						params='[filename: "idProof", dataName: "idProof",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
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
				params='[filename: "authorizationLetter", dataName: "authorizationLetter",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
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
				params='[filename: "passportCopy", dataName: "passportCopy",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
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
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td width="35px"></td>
			<td width="35px" rowspan="3"><b>(i)</b></td>
			<td width="35px"><b>(a)</b></td>
			<td style="width: 50% !important"><b>Name of Entity :</b></td>
<%--			<td class="text-center"><b>:</b></td>--%>
			<td class="righttd">
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
			    ${company?.province} 
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
						params="${[filename: 'registrationDocName', dataName: 'registrationDoc',csrfPreventionSalt:csrfPreventionSalt]}">
				(Click here to view)
			</g:link>
				</g:if> <g:else>
					<span class="text-danger">Document Not Attached</span>
				</g:else></td>
		</tr>
		<tr>
			<td></td>
			<td class="text-center"><b>(iii)</b></td>
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

<g:render template="/rightPane/bioResourceAndLocationDetails"></g:render>
<g:render template="/rightPane/part3"></g:render>
<g:render template="/rightPane/part4"></g:render>
<g:render template="/rightPane/part5"></g:render>

