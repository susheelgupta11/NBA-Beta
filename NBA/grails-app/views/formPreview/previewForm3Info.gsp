<%! import org.nba.common.State%>
<%! import org.nba.common.Country%>
<style type="text/css">
.wordwrap>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th,
	.table>thead>tr>td, .table>thead>tr>th {
	max-width: 100px;
	word-wrap: break-word;
}
</style>
<div id="print" class="row">
	<%--<g:link controller="FormPreview" class=""--%>
	<%--		action="printCompleateProject3" target="_blank"--%>
	<%--		params="[id:appForm?.id]">--%>
	<%--            Proposal <img src="../images/printtopdf.png" width="35"--%>
	<%--			height="13" alt="print" title="print" />--%>
	<%--	</g:link>--%>
	<div class="col-sm-12 text-center">
		<h3 class="register-heading">
			<b>Form-III</b>
		</h3>
		(See Rule 18 of Biological Diversity Rules, 2004)<br /> Application
		form for applying for Intellectual Property Right.
	</div>
	<g:if test="${appForm?.transaction?.isPaymentMade == true }">
	<div class="col-sm-12">
		<span class="pull-right "><b>Application No:</b>${appForm?.appNumber}</span>
		<span class="pull-left "><b>Submitted on:</b>${appForm?.submittedOn}</span>
		
		
		</div>
	</g:if>	
	<g:if test="${listofFormData?.size() != 0}">
		<div class="col-sm-12 table-responsive">
			<table class="table table-bordered">
				<tr>
					<td></td>
					<td colspan="2"><b>Type of the Applicant</b></td>
					<td class="text-center"><b>:</b></td>
					<td><b>Individual(s)</b></td>

				</tr>
				<tr class="previewheading">
					<td class="text-center"><b>(1)</b></td>
					<td colspan="4"><span><b>Full particulars of the
								applicant</b></span></td>
				</tr>

				<% int num= 1 %>
				<% char alph = 65 %>
				<g:each in="${listofFormData}" var="profile">
					<tr class="">
						<td></td>
						<td class="text-center one heading"><b>(${alph })
						</b></td>
						<td class="fifty heading"><b>Applicant ${num }</b></td>
						<td></td>
						<td></td>
					</tr>

					<% num++ %>
					<% alph++ %>


					<tr>
						<td></td>
						<td class="text-center"><b>i</b></td>
						<td><b>Name</b></td>
						<td class="text-center"><b>:</b></td>
						<td>
							${profile?.title} ${profile?.firstName} ${profile?.middleName} ${profile?.lastName}
						</td>
					</tr>


					<tr>
						<td></td>
						<td></td>
						<td>Nationality</td>
						<td><b>:</b></td>
						<g:if test="${profile?.nationality == 'Non Indian' }">
							<td><span> ${profile?.nationality}: ${profile?.country?.country}
							</span></td>
						</g:if>
						<g:else>
							<td><span> ${profile?.nationality}
							</span></td>
						</g:else>
					</tr>

					<tr>
						<td></td>
						<td></td>
						<td>Profile of the Applicant(s)</td>
						<td><b>:</b></td>
						<td>
							${profile?.profile}
						</td>
					</tr>


					<tr class="register-heading">
						<td></td>
						<td class="text-center"><b>ii</b></td>
						<td colspan="3"><b>Permanent Address</b></td>
					</tr>

					<tr>
						<td></td>
						<td class="text-center">a</td>
						<td>Complete Address for the communication</td>
						<td><b>:</b></td>
						<td>
							${profile?.address1} ${profile?.address2} ${profile?.address3},${profile?.city},
							${profile?.country?.country}
						</td>
					</tr>
					<tr>
						<td></td>
						<td class="text-center">b</td>
						<td>Mobile number</td>
						<td><b>:</b></td>
						<td>${profile?.mobile}
						</td>
					</tr>

					<tr>
						<td></td>
						<td class="text-center">c</td>
						<td>Telephone number</td>
						<td><b>:</b></td>
						<td>
							${profile?.phone}
						</td>
					</tr>

					<tr>
						<td></td>
						<td class="text-center">d</td>
						<td>Email address</td>
						<td><b>:</b></td>
						<td>
							${profile?.email}
						</td>
					</tr>

					<tr>
						<td></td>
						<td class="text-center">e</td>
						<td>Attachments</td>
						<td><b>:</b></td>
						<td>
								<table class="table-bordered" style="width:100%;">
								<tr>
									<td>
										${profile?.idProofSelect } Number:<br/> <b>${profile?.idNum }</b>
									</td>
									
									<td>
										Attached ${profile?.idProofSelect } :<br/><g:link
								controller="applicationManagement" action="showIndividualDc"
								id="${profile?.id}" target="_blank"
								params='[filename: "idProof", dataName: "idProof",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
								(click for preview)
							</g:link>
									</td>
								</tr>
								
								
								<tr>
									<td>
										Passport Number:<br/> <b>${profile?.passportNum }</b>
									</td>
									
									<td>
										Attached Passport Copy:<br/><g:link
								controller="applicationManagement" action="showIndividualDc"
								id="${profile?.id}" target="_blank"
								params='[filename: "passportCopy", dataName: "passportCopy",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
								(click for preview)
							</g:link>
									</td>
								</tr>
								
								
								<tr>
									<td>
										Authorization Number:<br/> <b >${profile?.authorizationNo }</b>
									</td>
									
									<td>
										Attached Authorization Letter :<br/>
								<g:if test= "${profile?.authorizationLetter }">			
									<g:link controller="applicationManagement"
										action="showIndividualDc" id="${profile?.id}" target="_blank"
										params='[filename: "authorizationLetter", dataName: "authorizationLetter",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
										(click for preview)
									</g:link>
								</g:if>
								<g:else>
									<span class= "text-danger"><b>(No document attached.)</b></span>
								</g:else>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</g:each>
		</table>
	</div>
	</g:if>


	<div class="col-sm-12 table-responsive">
		<table class="table table-bordered">
		<g:if test= "${listOfCompanyData?.size() != 0 }">
			<tr>
				<td></td>
				<td colspan="3"><b>Type of the Applicant</b></td>
				<td class="text-center"><b>:</b></td>
				<td><b>Entity </b></td>

			</tr>
			<tr class="previewheading">
				<td class="text-center"><b>(1)</b></td>
				<td colspan="5"><span><b>Full particulars of the
							applicant</b></span></td>
			</tr>
</g:if>
		<%int x = 1 %>
			<%char y = 65 %>
				<g:each var="companyProfile1" in="${listOfCompanyData }">
				<g:if test="${listOfCompanyData?.size() != 0  }">
					<tr class="">
							<td ></td>
							<td class="text-center one heading"><b>(${y })</b></td>
							<td class="fifty heading" colspan="2"><b>Applicant ${x }</b></td>
							<td></td>
							<td></td>
						</tr>
						<%x++ %>
						<%y++ %>


					<tr>
						<td></td>
						<td class="text-center" rowspan="3"><b>(i)</b></td>
						<td class="text-center one"><b>(a)</b></td>
						<td class="fifty"><b>Name of the Entity</b></td>
						<td class="text-center"><b>:</b></td>
						<td> ${companyProfile1?.entityName}
						</td>
					</tr>

					<tr>
						<td></td>
						<td class="text-center"><b>(b)</b></td>
						<td><b>Type of Entity</b></td>
						<td class="text-center"><b>:</b></td>
						<td>
							${companyProfile1?.entityType}
						</td>
					</tr>



					<tr>
						<td></td>
						<td class="text-center"><b>(c)</b></td>
						<td><b>Status</b></td>
						<td class="text-center"><b>:</b></td>
						<td><g:if
								test="${companyProfile1?.nationality == 'notRegisteredInIndia' }">
								Not incorporated or registered in India
							</g:if>
							<g:elseif test="${companyProfile1?.nationality == 'noNonIndianParticipation' }">
								Registered in India and does not have any non-Indian participation in share capital or management
							</g:elseif>
							 <g:else>
								Incorporated or registered in India under
								any law for the time being in force which has any non-Indian
								participation in its share capital or management  
							</g:else></td>
					</tr>


					<tr>
						<td></td>
						<td class="text-center"><b>(ii)</b></td>
						<td colspan="2"><b>Permanent address</b></td>

						<td class="text-center"><b>:</b></td>
						<td> ${companyProfile1?.address1} ${companyProfile1?.address2} ${companyProfile1?.address3} ${companyProfile1?.city}
						 ${companyProfile1?.country?.id}<br /> <b>Zip /Pincode-</b> ${companyProfile1?.pincode}<br />
						   <b>Mobile-</b> ${companyProfile1?.mobile}<br />
							<b> Phone-</b> ${companyProfile1?.phone}<br /> <b> Email-</b> ${companyProfile1?.email}<br />
							 <b>Website-</b> ${companyProfile1?.website}<br />
						</td>
					</tr>

					<tr>
						<td></td>
						<td class="text-center" rowspan="3"><b>(iii)</b></td>
						<td colspan="4"><b>Profile of the organization</b></td>
					</tr>
					<tr>
						<td></td>
						<td class="text-center"><b>(a)</b></td>
						<td><b>Nature of Business</b></td>

						<td class="text-center"><b>:</b></td>
						<td>
							${companyProfile1?.businessNature}
						</td>
					</tr>


					<tr>
						<td></td>
						<td class="text-center"><b>(b)</b></td>
						<td><b>Attach a copy of document of incorporation or
								registration duly attested by the competent authority</b></td>

						<td class="text-center"><b>:</b></td>
						<td><g:if test="${companyProfile1?.registrationDoc}">
								Registration Document
								<g:link controller="applicationManagement" action="showDc"
									id="${companyProfile1?.id}" target="_blank" class="fumargin"
									params='[filename: "registrationDocName", dataName: "registrationDoc",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
									 (click for preview)
						</g:link>
							</g:if> <g:else>
								<span class="text-danger">Document Not Attached</span>
							</g:else></td>
					</tr>

				
					<tr class="heading">
						<td></td>
						<td class="text-center"><b>(iv)</b></td>
						<td colspan="5"><span><b>Details of authorized
									representative of Entity</b></span></td>
					</tr>


					<tr>
						<td></td>
						<td rowspan="4"></td>
						<td class="text-center"><b>(i)</b></td>
						<td><b>Name</b></td>
						<td class="text-center"><b>:</b></td>
						<td> ${companyProfile1?.title} ${companyProfile1?.firstName} ${companyProfile1?.middleName} ${companyProfile1?.lastName}<br />
						</td>
					</tr>


					<tr>
						<td></td>
						<td class="text-center"><b>(ii)</b></td>
						<td><b>Designation</b></td>
						<td class="text-center"><b>:</b></td>
						<td>
							${companyProfile1?.designation}
						</td>
					</tr>

					<tr>
						<td></td>
						<td class="text-center"><b>(iii)</b></td>
						<td><b>Mobile Number & Email Id</b></td>
						<td class="text-center"><b>:</b></td>
						<td><b> Mobile-</b> <g:if test="${!companyProfile1}">
						N/A
					</g:if> <g:elseif test="${companyProfile1?.mobile?.contains('-')}">
								${companyProfile1?.mobile}
							</g:elseif><br /><b>Email-</b> ${companyProfile1?.personEmail}<br />
						</td>
					</tr>
					<tr>
						<td></td>
						<td colspan="2">Attachments</td>
						<td class="text-center"><b>:</b></td>
						
						<td>
								<table class="table-bordered" style="width:100%;">
								
								<tr>
									<td>
										Id Number:<br/> <b>${companyProfile1?.idNum }</b>
									</td>
									
									<td>
										Attached <b>${companyProfile1?.authRepresentativeIdSelect }</b>:<br/>
										<g:if test="${companyProfile1?.passportCopy}">
											<g:link controller="applicationManagement" action="showDc"
												id="${companyProfile1?.id}" target="_blank"
												params='[filename: "passportCopy", dataName: "passportCopy",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
										 		(click for preview)
											</g:link>
										</g:if>
										<g:else>
											<span class="text-danger">Document Not Attached</span>
										</g:else>
									</td>
								</tr>
								
								
								<tr>
									
									<td colspan = "2" style="padding-bottom: 8px; padding-top: 8px;">
										Attached Authorization Letter :
										<g:if test="${companyProfile1?.authorizationLetter}">
											<g:link controller="applicationManagement" action="showDc"
												class="fumargin" id="${companyProfile1?.id}" target="_blank"
												params='[filename: "authorizationLetterFileName", dataName: "authorizationLetterFileName",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
												(click for preview)
											</g:link>
										</g:if>
										<g:else>
											<span class="text-danger">Document Not Attached</span>
										</g:else>
										
									</td>
								</tr>
							</table> 
								
							</td>
						
						
					</tr>
				</g:if>
					</g:each>
		<div class="table-responsive">
			<table class="table table-bordered">
			<tr class= "heading">
				  <g:if test= "${listOfCompanyData?.size() != 0  }">
					<td class="one"><b>(v)</b></td>
				  </g:if>
				  <g:else>
				  	<td class="one"><b>(iv)</b></td>
				  </g:else>	
				<td colspan="2">Address of the contact person / agent in India,
					if any</td>
				<td class="text-center"><b>:</b></td>
				<g:if test= "${agentProfile != null }">		
					<td>Yes</td>
				   </g:if>	
				   <g:else>
				   	<td>No</td>
				   </g:else>
			</tr>
	<g:if test= "${agentProfile != null }">
			<tr>
				<td></td>
				<td colspan="2">Full particulars of Contact person</td>
				<td class="text-center"><b>:</b></td>
				<td><b>(a) Profile-</b>
						  <g:if test= "${agentProfile?.profile?.contains("-")}">
				 			<g:if test="${agentProfile?.profile?.charAt(agentProfile?.profile?.length() -1) == '-'}">
							  ${agentProfile?.profile?.split("-")[0]} 
							</g:if>
							  <g:else>
								  ${agentProfile?.profile?.split("-")[1]}
							  </g:else>
				 		  </g:if>
				 		  <g:else>
				 		  		${agentProfile?.profile} 
				 		  </g:else>
						 <br /> 
					<b>(b) Name-</b> ${agentProfile?.title} ${agentProfile?.firstName} ${agentProfile?.middleName} ${agentProfile?.lastName}
					<br /><b>(c) Address-</b> ${agentProfile?.address1} ${agentProfile?.address2} ${agentProfile?.address3} <br />
					 <b> State / UT-</b> ${State.findById(agentProfile?.province)?.state}
					<br /> <b>City-</b> ${agentProfile?.city} <br /> <b>Zip / Pincode-</b> ${agentProfile?.pincode}
					<br /> <b> Mobile-</b> ${agentProfile?.mobile} <br /> <b> Email-</b> ${agentProfile?.email}
					<br />
				</td>
			</tr>

			<tr>
				<td></td>
				<td colspan="2">Attachments</td>
				<td class="text-center"><b>:</b></td>
				<td>
				
					<table class="table-bordered" style="width:100%;">
							<tr>
							
								<td colspan="2" style="padding-bottom: 8px; padding-top: 8px;">
									<g:if test="${agentProfile?.authorizationLetter}">
									Attached Authorization Letter:
									<g:link controller="applicationManagement" action="showAgentDc"
										id="${agentProfile?.id}" target="_blank"
										params='[filename: "authorizationLetter", dataName: "authorizationLetter",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
										(click for preview)
										</g:link>
									</g:if> 
									<g:else>
										<span class="text-danger">No Document Attached</span>
									</g:else>
									
								</td>
							
							</tr>
							
							<tr>
							
								<td>
									${agentProfile?.photoIdSelect } Number :<br/>
									<b>${agentProfile?.photoIdNum }</b>
								</td>
								<td>
									Attached ${agentProfile?.photoIdSelect }:<br/>
									<g:if test="${agentProfile?.passportCopy}">
										<g:link controller="applicationManagement" class="fumargin"
											action="showAgentDc" id="${agentProfile?.id}" target="_blank"
											params='[filename: "passportCopyFileName", dataName: "passportCopyFileName",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
							 				(click for preview)
										</g:link>
									</g:if> 
									<g:else>
										<span class="text-danger">No Document Attached</span>
									</g:else>
								</td>
							
							</tr>
						</table>
				
				</td>
			</tr>
</g:if>

	<g:if test="${appForm?.transaction?.isPaymentMade != true }">
		<g:if test="${listOfCompanyData }">
					<tr>
						<td colspan="5"><g:link controller="applicationManagement"
								action="companyProfile"
								params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
								class="btn  btn-primary pull-right" method="POST">Edit Part 1</g:link></td>
					</tr>
				</g:if>
				<g:elseif test="${listofFormData }">
						<tr>
							<td colspan="5"><g:link controller="applicationManagement"
									action="individualProfile"
									params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
									class="btn  btn-primary pull-right" method="POST">Edit Part 1</g:link></td>
						</tr>
					</g:elseif>
	</g:if>				
		
				</table>
			</div>
		</table>
	</div>

	<div class="table-responsive">
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
					${appForm?.titleOfIPR}
				</td>
			</tr>
			<tr>
				<td></td>
				<td><b>(b)</b></td>
				<td class="fifty">Abstract of the invention</td>
				<td class="one"><b>:</b></td>
				<td>
					${appForm?.abstractOfIPR}
				</td>
			</tr>
			<tr>
				<td></td>
				<td><b>(c)</b></td>
				<td class="fifty">Details of territories / patent offices where the applicant intends to apply for the present invention</td>
				<td class="one"><b>:</b></td>
				<td>
					<g:each status="i" in = "${appForm?.detailsOfTerritories }" var= "countries">
					  <g:if test= "${appForm?.detailsOfTerritories?.size() - i == 1  }">	
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
					<g:if test= "${appForm?.isIPApplicationFiled == 'true' }">
						Yes
					</g:if>
					<g:else>
						No
					</g:else>
				</td>
			</tr>

			<g:if test= "${appForm?.isIPApplicationFiled == 'true' }">
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
			<tr class="previewheading">
				<td class="text-center"><b>(3)</b></td>
				<td colspan="4"><b>Details of biological resources and/ or associated knowledge used in the invention</b></td>
			</tr>

		<g:if test= "${listOfBioResources }">
			<tr>
				<td></td>
				<td class="text-center"><b>(i)</b></td>
				<td colspan="3">Identification (scientific name) of biological
					resources and its traditional use</td>
			</tr>

			<%--<tr>
				<td></td>
				<td><b>(a)</b></td>
				<td class="fifty">Intent to access</td>
				<td class="one"><b>:</b></td>
				<td>
					${listOfBioResources?.getAt(0)?.accessIntention}
				</td>

			</tr>


			--%><tr>
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
							</tr>
						</thead>
						<tbody>
							<%int i=1 %>
							<g:each in="${listOfBioResources }" var="bioResource">
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
									
								</tr>
							</g:each>
						</tbody>
					</table>


				</td>
			</tr>
		</g:if>	
		<g:if test="${appForm?.individualProfiles?.getAt(0)?.nationality == 'Non Indian' || appForm?.individualProfiles?.getAt(0)?.nationality == 'Non-Resident Indian' 
					 || appForm?.companyProfiles?.getAt(0)?.nationality == 'registeredInIndia' || appForm?.companyProfiles?.getAt(0)?.nationality == 'noNonIndianParticipation'}">	
			<tr>
				<td class= "one"></td>
				<td class= "one"><b>(a)</b></td>
				<td class="fifty">Whether approval of NBA obtained to access the biological resources and / or associated knowledge used in the invention</td>
				<td class="one"><b>:</b></td>
				<td>
					<g:if test= "${appForm.isApprovalOfNbaObtainedForm3 == 'true'}">
						<span>Yes</span>
					</g:if>
					<g:else>
						<span>No</span>
					</g:else>
				</td>
			</tr>
			
			<g:if test="${appForm.isApprovalOfNbaObtainedForm3 == 'false' }">
				<tr>
					<td class= "one"></td>
					<td class= "one"><b>(b)</b></td>
					<td class="fifty">Reason for not obtaining the prior approval of NBA</td>
					<td class="one"><b>:</b></td>
					<td>
						<g:if test= "${appForm?.reasonOFNotObtainedApproval}">
							<span>${appForm?.reasonOFNotObtainedApproval}</span>
						</g:if>
						<g:else>
							<span>N/A</span>
						</g:else>	
					</td>
				</tr>
			</g:if>
			<g:elseif test="${appForm.isApprovalOfNbaObtainedForm3 == 'true' }">
			<tr>
				<td class= "one"></td>
				<td class= "one"><b>(b)</b></td>
				<td class="fifty">Application number</td>
				<td class="one"><b>:</b></td>
				<td>
					<g:if test= "${appForm?.applicationNo }">
						<span>${appForm?.applicationNo}</span>
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
					<g:if test= "${appForm?.isApprovalOfNbaObtainedForm3 == 'true' }">
						<span>${appForm?.dateOfApproval?.format('dd/MM/yyyy')}</span>
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
					<g:if test= "${appForm?.nbaApprovalFile && appForm?.isApprovalOfNbaObtainedForm3 == 'true' }">
						<g:link controller="form3" action="showDc" id="${appForm?.id}"
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
			</g:elseif>
			
		</g:if>	
				
		<g:if test="${appForm?.transaction?.isPaymentMade != true }">
			<tr>
				<td colspan="5"><g:link controller="applicationManagement"
						action="form1Part2"
						params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
						class="btn  btn-primary text-center pull-right" method="POST">Edit Part 2</g:link></td>
			</tr>
		</g:if>	
			
			
		<tr>
			
			
		</table>
	


	<div class=" table-responsive">
		<table class="table table-bordered">


	<tr class="previewheading">
				<td class="text-center one"><b>(4)</b></td>
				<td colspan="4"><b>Geographical location of proposed collection</b></td>
			</tr>
			
		<g:if test="${listOfLocations}">	
		<tr>
				<td></td>
				<td></td>
				<td colspan="3">
					<table class="table table-bordered datatable1">

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
								<tr>
											
											<%int k=1 %>
											<g:each in="${listOfLocations}" var="location">
										<tr>
											<td class="text-center"><%=k %></td>
											<%k++ %>
											<td>
												${location?.bioResource?.scientificName}
											</td>
											<td>
												${location?.source}
											</td>
											<td scope="row"><g:if test="${location?.village}">
													${location?.village}
												</g:if> <g:else>
										N/A
									</g:else></td>


											<td scope="row"><g:if test="${location?.town}">
													${location?.town}
												</g:if> <g:else>
										N/A
									</g:else></td>
											<td scope="row"><g:if test="${location?.district}">
													${location?.district}
												</g:if> <g:else>
										N/A
									</g:else></td>
											<td scope="row"><g:if test="${location?.state}">
													${location?.state}
												</g:if> <g:else>
										N/A
									</g:else></td>
											<td scope="row"><g:if test="${location?.traderName}">
													${location?.traderName}
												</g:if> <g:else>
										N/A
									</g:else></td>
											<td scope="row"><g:if
													test="${location?.traderContactDetails}">
													${location?.traderContactDetails}
												</g:if> <g:else>
										N/A
									</g:else></td>
										</tr>
									</g:each>
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
					<g:if test="${appForm?.isBioObtainedOutsideIndia == 'true' }">
											Yes</g:if>
										<g:elseif test= "${appForm?.isBioObtainedOutsideIndia == 'false' }">
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
				  <g:if test="${appForm?.isBioObtainedOutsideIndia == 'true' }">
					${appForm?.traditionalKnowledgeDesc}
				  </g:if>
				  <g:elseif test="${appForm?.isBioObtainedOutsideIndia == 'false'}">
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
					<g:if test="${appForm?.isBioObtainedOutsideIndia == 'false' }">
						N/A
					</g:if>
					<g:elseif test="${appForm?.isApprovalOfCountryObtained == 'true' }">
						Yes
					</g:elseif>
					<g:elseif test="${appForm?.isApprovalOfCountryObtained == 'false' }">
						No
					</g:elseif>
					
				</td>
			</tr>
			<g:if test="${appForm?.isApprovalOfCountryObtained == 'false' }">
			<tr>
				<td></td>
				<td><b>(d)</b></td>
				<td><b>If no, specify the reasons thereon</b></td>
				<td><b>:</b></td>
				<td>
					<g:if test= "${appForm?.reasonOfDisapproval }">
						${appForm?.reasonOfDisapproval}
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
			  <g:if test= "${appForm?.isTraditionalKnowledgeApplicable == 'Applicable' }">	
				<td>Yes</td>
			  </g:if>
			  <g:elseif test= "${appForm?.isTraditionalKnowledgeApplicable == 'Not applicable' }">
			  	<td>No</td>
			  </g:elseif>
			  <g:else>
			  	<td> </td>
			  </g:else>	
				
			</tr>
			
			
		<g:if test= "${appForm?.isTraditionalKnowledgeApplicable == 'Applicable' }">
			<tr>
			<td></td>
				<td colspan="2"></td>
				<td class="one"><b>:</b></td>
				<td>${appForm?.traditionalKnowledgeUsedInInvention}</td>
				
			</tr>
		</g:if>
			

		<g:if test = "${appForm?.isTraditionalKnowledgeApplicable != 'Applicable' || !listOfCommunityLocations }">	
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

<%--		<g:if test = "${appForm?.isNoForTraditional != 'No' || appForm?.isTraditionalKnowledgeApplicable == 'Applicable' }">	--%>
			<g:if test = "${appForm?.isTraditionalKnowledgeApplicable == 'Applicable' }">
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

			
<%--<g:if test="${appForm?.isRAndDParticipationForm3 == true }">--%>
			<tr>
				<td></td>
				
				<td colspan= "2"></td>
				<td class="text-center"><b>:</b></td>
				<td>${appForm?.detailsOfInstitute}</td>
			</tr>
<%--	</g:if>		--%>

			<tr class="previewheading">
				
				<td><b>(7)</b></td>
				<td colspan="4"><b>Details of economic, biotechnological, scientific or any other benefits that are intended, or may accrue to the applicant due to commercialization of the invention</b></td>
			</tr>

			<tr>
			<td></td>
				<td colspan="2"></td>
				<td class="one"><b>:</b></td>
				<td>${appForm?.benefitsToTheApplicant}</td>
			</tr>
			
		<g:if test="${appForm?.transaction?.isPaymentMade != true }">
			<tr>
				<td></td>
				<td colspan="4"><g:link controller="form3"
						action="part3"
						params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
						class="btn  btn-primary pull-right" method="POST">Edit Part 3</g:link>
				</td>
			</tr>
		</g:if>	
		</table>
	</div>
	

<div class="table-responsive">
<table class="table table-bordered datatable">
<tr class="previewheading">
<%--				<td class="text-center"><b></b></td>--%>
				<td colspan="4"><b>Declaration:</b></td>
			</tr>
			
		<g:if test="${appForm?.isDeclarationDigitallySigned == 'true' }">
			<tr>
<%--			<td></td>--%>
			<td class="one text-center"><b>(a)</b></td>
			<td colspan="3">Declaration with digital signature</td>
			</tr>
		</g:if>
		<g:else>	
			<tr>
<%--			<td></td>--%>
			<td class="one text-center"><b>(a)</b></td>
			<td colspan="3">Declaration without digital signature</td>
			</tr>
		</g:else>	
			
<%--			<tr>--%>
<%--			<td></td>--%>
			
<%--			<td colspan="4"><h4>I / we declare that :- </h4></td>--%>
			
		
			
<%--			</tr>--%>
			
			<%--<tr>
			<td>
			</td>
			<td colspan="4">
				<ul>
									<li><b>Collection of proposed biological resources shall not
										adversely affect the sustainability of the resources.</b></li>
									<li><b>Collection of proposed biological resources shall not
										entail any environmental impact.</b></li>
									<li><b>Collection of proposed biological resources shall not
										pose any risk to ecosystems.</b></li>
									<li><b>Collection of proposed biological resources shall not
										adversely affect the local communities.</b>
								</li></ul>
			</td>
			</tr>
			
		--%>
			<g:if test= "${appForm?.submitCheck == true }">
			<tr>
<%--			<td></td>--%>
			<td class="one text-center"><input type="checkbox" checked="checked" disabled="disabled"/></td>
			<td colspan="3">I / We further declare that information provided in the application form is true and correct and I / we shall be responsible for any incorrect / wrong information.</td>
			</tr>
		</g:if>
		<g:else>
			<tr>
<%--			<td></td>--%>
			<td class="one text-center"><input type="checkbox"  disabled="disabled"/></td>
			<td colspan="3">I / We further declare that information provided in the application form is true and correct and I / we shall be responsible for any incorrect / wrong information.</td>
			</tr>
		</g:else>	
</table>
</div>

				<g:if test="${appForm?.transaction?.isPaymentMade == true }">
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
							${appForm?.transaction?.transactionId}
						</td>
					</tr>
					<tr>
						<td class= "text-center one">(b)</td>
						<td colspan="2">Payment Reference Number</td>
						<td class="one"><b>:</b></td>
						<td>
							${appForm?.transaction?.paymentRefNo}
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
										id="${appForm?.transaction?.id}" target="_blank"
										params='[filename: "paymentReceipt", dataName: "paymentReceipt", appFormId: appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
										Click to preview Payment Receipt
									</g:link></td>
					</tr>
					</table>
				</div>	
				</g:if>

		<div>
			<table class="table table-bordered datatable">
				<tr>
					

					<td colspan="4" class="text-center"><g:link
							controller="FormPreview" class="btn btn-primary"
							action="printCompleateProject3" target="_blank"
							params='[id:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
            Print Form
	</g:link> <g:link controller="PDF" class="btn btn-primary" action="index"
							params='[projectId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
            Print Attachments 
	</g:link></td>
				</tr>

			</table>
		</div>

	</div>


