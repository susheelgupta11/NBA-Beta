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
	 <g:if test="${profile?.nationality == 'Non Indian'}">
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
			${individualProfile?.country?.name} <b>Mobile No:</b> ${individualProfile?.mobile}<br />
			<b>Telephone No:</b> ${individualProfile?.phone} <br /> <b>Email:</b>
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
			<td class="righttd"colspan="2" >
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
			<td class="text-left" colspan="2">
				${company?.address1} ${company?.address2} ${company?.address3} ${company?.city}
				${company?.pincode} 
<%--				${State.findById(company?.province)?.state}--%>
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

						<td>Attachment<br />
						${company?.authRepresentativeIdSelect }
						 <g:if
								test="${allDataforMatching?.company?.passportCopy}">
								<g:link controller="applicationManagement" action="showDc"
									id="${company?.id}" target="_blank"
									params="[filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:'${csrfPreventionSalt}']">
									(click here to view)
								</g:link>
							</g:if> <g:else>
								<span class="text-danger" colspan="2">Document Not Attached</span>
							</g:else></td>
					</tr>
					<tr>
						<td colspan="2">Attachment authorized letter:
						<g:if test="${companyProfile1?.authorizationLetter}"><g:link
								controller="applicationManagement" action="showDc"
								id="${company?.id}" target="_blank"
								params="[filename: 'authorizationLetterFileName', dataName: 'authorizationLetterFileName',csrfPreventionSalt:'${csrfPreventionSalt}']">
							(click here to preview)
						</g:link>
						</g:if>
						<g:else>
						<span class="text-danger">Document Not Attached</span>
						</g:else>
						</td>
					</tr>
				</table></td>
		</tr>
	</g:each>
</g:if>


<g:render template="/rightPane/agentProfileMatching"/>

<table class="table table-bordered">

			<tr class="previewheading">
				<td class="text-center one"><b>(3)</b></td>
				<td colspan="4"><b>Details and specific information about
						nature of access sought and biological material and associated
						knowledge to be accessed</b></td>
			</tr>

			<tr>
				<td></td>
				<td class="text-center one"><b></b></td>
				<td colspan="3">Identification (scientific name) of biological
					resources and its traditional use</td>
			</tr>

			
		<g:if test= "${formDetails?.biologicalResources}">	
			<tr>
				<td></td>
				<td></td>
				<td colspan="3">
					<table class="table table-bordered datatable1 wordwrap">
						<thead>
							<tr>
								<th>S.No.</th>
								<th>Intend to access</th>
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
							<g:each in="${formDetails?.biologicalResources}" var="bioResource">
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
<%-- 										<td>--%>
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
			</table>
			
			
		<table class="table table-bordered">
			 <tr class="previewheading">
                <td class="text-center"><b>(4)</b></td>
                <td colspan="4"><b>Details of the access contract entered (copy enclosed)</b></td>
            </tr>
            <tr>
                <td></td>
                <td colspan="2">Attached copy of approval of NBA(agreement) for access</td>
                <td class="one"><b>:</b></td>
                <td>
                    <g:link controller="form4" action="showDc"
						id="${formDetails?.id}" target="_blank"
						params='[filename: "nbaApprovalFileName", dataName: "nbaApprovalFileName", nbaApprovalPart2:"part2",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
						${formDetails?.nbaApprovalFileName}
					</g:link>
				</td>
            </tr>
            <tr>
                <td></td>
                <td colspan="2">Application No.</td>
                <td class="one"><b>:</b></td>
                <td>${formDetails?.applicationNo}</td>
            </tr>
            <tr>
                <td></td>
                <td colspan="2">Date of approval</td>
                <td class="one"><b>:</b></td>
                <td>${formDetails?.dateOfApproval?.format('dd/MM/yyyy')}</td>
            </tr>
            <tr class="previewheading">
                <td class="text-center"><b>(4)</b></td>
                <td colspan="4"><b>Details of the benefits and mechanism/ arrangements for benefit sharing already implemented</b>
                </td>
            </tr>
            <tr>
                <td></td>
                <td colspan="2">Is there any such detail?</td>
                <td class="one"><b>:</b></td>
                <g:if test="${formDetails?.isbenefitSharingDetailImplemented == 'true'}">
                    <td>Yes</td>
                </g:if>
                <g:else>
                    <td>No</td>
                </g:else>
            </tr>
            <g:if test="${formDetails?.isbenefitSharingDetailImplemented == 'true'}">
                <tr>
                    <td></td>
                    <td colspan="2"></td>
                    <td class="one"><b>:</b></td>
                    <td>${formDetails?.benefitMechanism}</td>
                </tr>
            </g:if>
            </table>	
            
            
             <table class="table table-bordered ">
                <tr class="previewheading">
                    <td class="text-center one"><b>(5)</b></td>
                    <td colspan="4"><b>Full particulars of the third party to whom the accessed material / knowledge is intended to be transferred</b>
                    </td>
                </tr>
              <g:if test= "${allDataforMatching?.listOfThirdParty?.size() > 0 }">  
                <tr>
                	<td></td>
                    <td>
                    <div class= "table-responsive">
                		<table class="table table-bordered datatable1">
                                <thead>
                                <tr>
                                    <th>SI.No</th>
                                    <th>Name</th>
                                    <th>Address</th>
                                    <th>State/Province</th>
                                    <th>Zip/Pincode</th>
                                    <th>Country</th>
                                    <th>Telephone</th>
                                    <th>Fax</th>
                                    <th>Website</th>
                                    <th>Email</th>
                                </tr>
                                </thead>
                                <tbody>

                                <tr>
                                <g:if test="${allDataforMatching?.listOfThirdParty}">
                                    <% int k = 1 %>
                                    <g:each in="${allDataforMatching?.listOfThirdParty}" var="thirdPartyInst">
                                        <tr>
                                            <td class="text-center"><%=k%></td>
                                            <% k++ %>
                                            <td>
                                                ${thirdPartyInst?.name}
                                            </td>
                                            <td>
                                                ${thirdPartyInst?.addressForComm}
                                            </td>
                                            <td>
                                                ${thirdPartyInst?.state}
                                            </td>
                                            <td>
                                                ${thirdPartyInst?.pincode}
                                            </td>
                                            <td>
                                                ${thirdPartyInst?.country}
                                            </td>
                                            <td>
                                                ${thirdPartyInst?.phone}
                                            </td>
                                            <td>
                                                ${thirdPartyInst?.fax}
                                            </td>
                                            <td>
                                                ${thirdPartyInst?.website}
                                            </td>
                                            <td>
                                                ${thirdPartyInst?.email}
                                            </td>
                                        </tr>
                                    </g:each>
                                </g:if>
                                </tbody>
                            </table>
                            </div>
                	</td>
                </tr>
              </g:if>  
               </table>  
               
                <table class="table table-bordered">
                <tr class="previewheading">
                    <td class="text-center one"><b>(6)</b></td>

                    <td colspan="4"><b>The purpose of the intended third party transfer</b></td>
                </tr>
                <tr>
                    <td></td>
                    <td colspan="2"></td>
                    <td class="one"><b>:</b></td>
                    <td>${formDetails?.thirdPartyTransferPurpose}</td>
                </tr>
                <tr class="previewheading">
                    <td class="text-center"><b>(7)</b></td>

                    <td colspan="4"><b>Details of economic, social, biotechnological, scientific or any other benefits that are intended, or may accrue to the third party due to transfer of accessed biological material and knowledge</b>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td colspan="2"></td>
                    <td class="one"><b>:</b></td>
                    <td>${formDetails?.benefitsToTheThirdParty}</td>
                </tr>
                <tr class="previewheading">
                    <td class="text-center"><b>(8)</b></td>

                    <td colspan="4"><b>Details of any agreement to be entered between the applicant and the third party</b>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td colspan="2">Is there any such agreement</td>
                    <td class="one"><b>:</b></td>
                    <g:if test="${formDetails?.isAgreementBwApplicantAndThirdParty == 'true'}">
                        <td>Yes</td>
                    </g:if>
                    <g:elseif test="${formDetails?.isAgreementBwApplicantAndThirdParty == 'false'}">
                        <td>No</td>
                    </g:elseif>
                    <g:else>
                    	<td></td>
                    </g:else>
                </tr>
               <g:if test="${formDetails?.isAgreementBwApplicantAndThirdParty == 'true'}">
                <tr>
                    <td></td>
                    <td colspan="2">Attached copy of agreement entered between the applicant and the third party</td>
                    <td class="one"><b>:</b></td>
                    <td>
                    	<g:link controller="form4" action="showDc"
							id="${formDetails?.id}" target="_blank"
							params='[filename: "nbaApprovalFileName", dataName: "nbaApprovalFileName", nbaApprovalPart3:"part3",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
											(click for preview)
						</g:link>
					</td>
                </tr>
               </g:if>
               
               <tr class="previewheading">
                    <td class="text-center"><b>(9)</b></td>

                    <td colspan="4"><b>Estimation of benefits that would flow to India/communities arising 
																out of the third party transfer of accessed biological resources and
																traditional knowledge</b>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td colspan="2"></td>
                    <td class="one"><b>:</b></td>
                    <td>${formDetails?.benefitsOutOfThirdPartyTransfer}</td>
                </tr>
                
                <tr class="previewheading">
                    <td class="text-center"><b>(10)</b></td>

                    <td colspan="4"><b>Proposed mechanism and arrangements for benefit sharing arising
												out of the proposed third party transfer</b>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td colspan="2"></td>
                    <td class="one"><b>:</b></td>
                    <td>${formDetails?.mechanismOutOfThirdPartyTransfer}</td>
                </tr>
               
               <tr class="previewheading">
                    <td class="text-center"><b>(11)</b></td>

                    <td colspan="4"><b>Any other relevant information</b>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td colspan="2"></td>
                    <td class="one"><b>:</b></td>
                    <td>${formDetails?.otherRelevantInfo}</td>
                </tr>
            </table>
       
         <table class="table table-bordered datatable">
                <tr class="previewheading">

                    <td colspan="4"><b>Declaration:</b></td>
                </tr>
                <g:if test="${formDetails?.isDeclarationDigitallySigned == 'true'}">
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

                <g:if test="${formDetails?.submitCheck == true}">
                    <tr>

                        <td class="one text-center"><input type="checkbox" checked="checked" disabled="disabled"/></td>
                        <td colspan="3">I / We further declare that information provided in the application form is true and correct and I / we shall be responsible for any incorrect / wrong information.</td>
                    </tr>
                </g:if>
                <g:else>
                    <tr>

                        <td class="one text-center"><input type="checkbox" disabled="disabled"/></td>
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
							Rs. 10,000/-
						</td>
					</tr>
					<tr>
						<td class= "text-center one">(d)</td>
						<td colspan="2">Payment Receipt</td>
						<td class="one"><b>:</b></td>
						<td><g:link controller="applicationManagement"
								action="showIndividualDc" id="${formDetails?.transaction?.id}" target="_blank"
								params='[filename: "paymentReceipt", dataName: "paymentReceipt", appFormId: formDetails?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
										Click to preview Payment Receipt
									</g:link></td>
					</tr>
					</table>
				</div>	
				</g:if>