<%! import org.nba.common.State%>

<style type="text/css">
.wordwrap>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th,
	.table>thead>tr>td, .table>thead>tr>th {
	max-width: 100px;
	word-wrap: break-word;
}
</style>

<div id="print" class="row ">

	<div class="col-sm-12 text-center">
		<h3 class="register-heading">
			<b>Form-I</b>
		</h3>

		(See Rule 14 of Biological Diversity Rules, 2004)<br /> Application
		form for access to the Biological Resources and associated traditional
		knowledge
	</div>
	<g:if test="${appForm?.transaction?.isPaymentMade == true }">
		<div class="col-sm-12">
			<span class="pull-right "><b>Application No:</b> ${appForm?.appNumber}</span>
			<span class="pull-left "><b>Submitted on:</b>${appForm?.submittedOn}</span>
		</div>
	</g:if>

	<g:if test="${listofFormData.size() != 0}">
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
						<td>Profile of the Applicant</td>
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
							${profile?.address1}, ${profile?.address2} ${profile?.address3} ${profile?.city}
							${profile?.country?.country}
						</td>
					</tr>
					<tr>
						<td></td>
						<td class="text-center">b</td>
						<td>Mobile number</td>
						<td><b>:</b></td>
						<td>
							${profile?.mobile}
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
										Id Number:<br/> <b>${profile?.idNum }</b>
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
							<g:link
								controller="applicationManagement" action="showIndividualDc"
								id="${profile?.id}" target="_blank"
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
			  <g:if test="${listOfCompanyData?.size() != 0 }">	
				<tr>
					<td></td>
					<td colspan="3"><b>Type of the Applicant5555555</b></td>
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
							<g:else>
									Incorporated or registered in India under
									any law for the time being in force which has any non-Indian
									participation in its share capital or management  
							</g:else>
						</td>
					</tr>


					<tr>
					<td></td>
							<td class="text-center"><b>(ii)</b></td>
							<td colspan="2"><b>Permanent address</b></td>

							<td class="text-center"><b>:</b></td>
							<td> ${companyProfile1?.address1} ${companyProfile1?.address2}
							${companyProfile1?.address3} ${companyProfile1?.city} ${companyProfile1?.country?.id}
							 ${companyProfile1?.pincode} <br/>
							 <b>Mobile-</b>${companyProfile1?.mobile}<br/>
							  <b>Phone-</b>${companyProfile1?.phone}<br/> 
							  <b>Email-</b>${companyProfile1?.email}<br/>
							  <b>Website-</b>${companyProfile1?.website}
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
							<td><b>Attached copy of document of incorporation or
									registration duly attested by the competent authority</b></td>

							<td class="text-center"><b>:</b></td>
							<td><g:if test="${companyProfile1?.registrationDoc}">
									<g:link controller="applicationManagement" action="showDc"
										id="${companyProfile1?.id}" target="_blank" class="fumargin"
										params='[filename: "registrationDocName", dataName: "registrationDoc",csrfPreventionSalt:"${csrfPreventionSalt}"]'>(click for preview)
						</g:link>
								</g:if> <g:else>
									<span class="text-danger">Document Not Attached</span>
								</g:else></td>
						</tr>

						<tr class="">
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
							<td> ${companyProfile1?.title} ${companyProfile1?.firstName}
							 ${companyProfile1?.middleName} ${companyProfile1?.lastName}
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
							<td><b>Mobile-</b> 
								<g:if test="${!companyProfile1}">
											N/A
								</g:if> 
								<g:elseif test="${companyProfile1?.mobile?.contains('-')}">
									${companyProfile1?.mobile}
								</g:elseif><br /> 
								
								<b>Email-</b> 
									${companyProfile1?.personEmail}<br />
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
					<td class="fifty" colspan="2"><b>Address of the contact person / agent in
						India, if any</b></td>
					<td class="text-center one"><b>:</b></td>
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
					<td><b>(a) Profile-</b> ${agentProfile?.profile} <br /> 
						<b>(b) Name-</b> ${agentProfile?.title} ${agentProfile?.firstName} ${agentProfile?.middleName} ${agentProfile?.lastName}<br/>
						<b>(c) Address-</b> ${agentProfile?.address1} ${agentProfile?.address2} ${agentProfile?.address3} <br /> 
							<b> State / UT-</b> ${State.findById(agentProfile?.province)?.state}
						<br /> <b>City-</b> ${agentProfile?.city} <br /> <b> Zip / Pincode-</b> ${agentProfile?.pincode}
						<br /> <b>(d) Mobile No.-</b> ${agentProfile?.mobile} <br /> <b>(e) Email-</b> ${agentProfile?.email}
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


	<div class=" table-responsive">
		<table class="table table-bordered">

			<tr class="previewheading">
				<td class="text-center one"><b>2</b></td>
				<td colspan="4"><b>Details and specific information about
						nature of access sought and biological material and associated
						knowledge to be accessed</b></td>
			</tr>

			<tr>
				<td></td>
				<td class="text-center one"><b>(i)</b></td>
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


			--%>
		<g:if test= "${listOfBioResources }">	
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
								<th>Quantity of biological resources</th>
								<th>Time span in which the biological</th>
								<th>Traditional use, if any</th>
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
									<td>
										${bioResource?.quantity} ${bioResource?.qtyUnit}
									</td>
									<td>
										${bioResource?.fromTime?.format('dd/MM/yyyy')} - ${bioResource?.toTime?.format('dd/MM/yyyy')}
									</td>
									<td>
										${bioResource?.traditionalUse}
									</td>
								</tr>
							</g:each>
						</tbody>
					</table>
				</td>
			</tr>
		</g:if>	
			<tr>
				<td></td>
				<td class="text-center"><b>(ii)</b></td>
				<td colspan="3">Geographical location of proposed collection</td>
			</tr>
		
		<g:if test="${listOfLocations}">	
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
							<tr>
								<g:if test="${listOfLocations}">
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
								</g:if>
						</tbody>
					</table>

				</td>

			</tr>
		</g:if>	
			
		<g:if test="${appForm?.transaction?.isPaymentMade != true }">	
			<tr>
				<td></td>
				<td colspan="4"><g:link controller="applicationManagement"
						action="form1Part2"
						params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
						class="btn  btn-primary text-center pull-right" method="POST">Edit Part 2</g:link>
				</td>
			</tr>
		</g:if>	

		</table>

	</div>


	<div class=" table-responsive">
		<table class="table table-bordered">




			<tr>
				<td></td>
				<td class="one"><b>(c)</b></td>
				<td><b>Description / nature of traditional knowledge (oral
						/ documented)</b></td>
				<td><b>:</b></td>
				<td>
					${appForm?.nature}
				</td>
			</tr>
		<g:if test= "${appForm?.nature != 'No' }">
			<tr>
				<td></td>
				<td></td>
				<td>Description</td>
				<td><b>:</b></td>
				<td>
					${appForm?.traditionalKnowledgeDesc}
				</td>
			</tr>
		</g:if>	
			<tr>
				<td></td>
				<td><b>(d)</b></td>
				<td colspan="3"><b>Geographical location of the community / individual</b></td>
<%--				<td class="text-center"><b>:</b></td>--%>
<%--				<td>geoLocation?.consentObtained</td>--%>
			</tr>
			
		<g:if test= "${appForm?.nature == 'No' }">	
			<tr>
				<td></td>
				<td></td>
				<td>(i) Consent obtained from the community / individual</td>
				<td><b>:</b></td>
				<td>
					${appForm?.nature}
				</td>
			</tr>
		</g:if>	

		<g:if test= "${appForm?.nature != 'No' }">
		  <g:if test= "${listOfCommunityLocations }">
			<tr>
				<td></td>
				<td colspan="4">
					<table class="table table-bordered datatable1 wordwrap">
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
							<g:if test="${listOfCommunityLocations}">
								<%int a=1 %>
								<g:each in="${listOfCommunityLocations}" var="location">
									<tr>
										<td scope="row"><%=a %></td>
										<%a++ %>
										<td scope="row">
											${location?.communityKnowledge}
										</td>
										<td scope="row">${location?.village}
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
		</g:if>
		
		<g:if test= "${appForm?.selfAuthorizedPerson }">	
			<tr>
				<td></td>
				<td><b>(e)</b></td>
				<td><b>Name and Number of the persons authorized by the
						applicant for making selection</b></td>
				<td class="text-center"><b>:</b></td>
					<td>Self</td>
			</tr>
		</g:if>	
		<g:else>	
			<tr>
				<td></td>
				<td><b>(e)</b></td>
				<td colspan="3"><b>Name and Number of the persons authorized by the
						applicant for making selection</b></td>
<%--				<td class="text-center"><b>:</b></td>--%>
<%--				<g:if test= "${appForm?.selfAuthorizedPerson }">--%>
<%--					<td>Self</td>--%>
<%--				</g:if>--%>
<%--				<g:else>--%>
<%--					<td>${appForm?.contactPerson }</td>--%>
<%--				</g:else>--%>
			</tr>
		</g:else>	
			
			<g:if test= "${!appForm?.selfAuthorizedPerson }">
			<g:if test= "${listOfContactPerson }">
			<tr>
				<td></td>
				<td colspan="4">
					<table class="table table-bordered datatable1 wordwrap">
						<thead>
							<tr>
								<th class="text-center">SI.No</th>
								<th>Name</th>
								<th>Address</th>
								<th>Mobile</th>
								<th>Email</th>
							</tr>
						</thead>

						<tbody>
							<%int b=1 %>
				<g:each in="${listOfContactPerson}" var="profile">
					<tr>
						<td class="session"><%=b %></td>
						<%b++ %>
						<td>
							${profile?.nameOfContactPerson}
						</td>
						<td>
							${profile?.addressOfContactPerson}
						</td>
				
						<td>
							${profile?.mobileOfContactPerson}
						</td>
				
						<td>
							${profile?.emailOfContactPerson}
						</td>
				
					</tr>
				</g:each>
				</tbody>
				</table>
				</td>
			</tr>
			</g:if>
			</g:if>
			<tr>
				<td></td>
				<td class="text-center"><b>(f)</b></td>
				<td colspan="3"><b>The purpose for which the access is
						requested including the type and extend of research, commercial
						use being derived and expected to be derived from it.</b></td>

			</tr>

			<tr>
				<td></td>

				<td class="text-center"><b>(i)</b></td>
				<td>Purpose for which the biological resource(s) and/ or
					associated knowledge is proposed to be accessed</td>
				<td class="text-center"><b>:</b></td>
				<td>${appForm?.purposeOfProposal}</td>
			</tr>

			<tr>
				<td></td>

				<td class="text-center"><b>(ii)</b></td>
				<td>A brief description of the research or bio-survey and
					bio-utilization or commercial utilization expressing the scope /
					intention and purpose / goals / commercial outlook</td>
				<td class="text-center"><b>:</b></td>
				<td>${appForm?.briefDescription}</td>
			</tr>

			<tr>
				<td></td>

				<td class="text-center"><b>(iii)</b></td>
				<td>Whether any collection of the resource endangers any
					component of biological diversity and the risks which may arise
					from the access.</td>
				<td class="text-center"><b>:</b></td>
			<g:if test= "${appForm?.isRisky == 'true' }">
				<td>Yes</td>
			</g:if>
			<g:else>
				<td>No</td>
			</g:else>	
			</tr>
			<g:if test= "${appForm?.isRisky == 'true' }">
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td class="text-center"><b>:</b></td>
				<td>${appForm?.riskInvolved}</td>
			</tr>
			</g:if>
			
		<g:if test="${appForm?.transaction?.isPaymentMade != true }">	
			<tr>
				<td></td>
				<td colspan="4"><g:link controller="applicationManagement"
						action="form1Part3"
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
				<td class="text-center"><b>(3)</b></td>
				<td colspan="4"><b>Details of any national institution
						which will participate in the Research & Development activities</b></td>
			</tr>

			<tr>
				<td class="one"></td>

				<td class="text-center one"><b>(i)</b></td>
				<td class="fifty">Is there any such participation</td>
				<td class="text-center one"><b>:</b></td>
			<g:if test="${appForm?.instituteParticipation == 'true' }">	
				<td>Yes</td>
			</g:if>	
			<g:else>
				<td>No</td>
			</g:else>
			</tr>

			<tr>
				<td></td>

				<td class="text-center"><b>(ii)</b></td>
				<td>Provide the name and contact details of the institution /
					organization participating in R & D</td>
				<td class="text-center"><b>:</b></td>
				<td>
				<g:if test="${appForm?.instituteParticipation == 'true' }">	
					${appForm?.detailsOfInstitute}
				</g:if>
				<g:else>
					N/A
				</g:else>
				</td>
			</tr>

			<tr>
				<td></td>

				<td class="text-center"><b>(iii)</b></td>
				<td>Attach self-attested copy of MoU with the National
					Institution or letter of intent detailing the activity</td>
				<td class="text-center"><b>:</b></td>
				<td><g:if test="${appForm?.letterOfintent}">
										<g:link controller="applicationManagement" action="showAppDc"
											id="${appForm?.id}" target="_blank"
											params='[filename: "letterOfIntentName", dataName: "letterOfIntentName",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
											${appForm?.letterOfIntentName}
										</g:link>
								
									</g:if>
									<g:else>
									<span>N/A</span>
											</g:else>		
									</td>
			</tr>

			

			
	
	
	<g:each in="${quesAnswerMap}" var="mapKeyValue">
		<tr class="previewheading">
				<td class="text-center"><b>${mapKeyValue?.getKey()?.questionNo}</b></td>
				<td colspan="4"><b>${mapKeyValue?.getKey()?.question}</b></td>
		</tr>
			<tr>
				<td></td>
				<td colspan="2"></td>
				<td class="text-center"><b>:</b></td>
				<g:if test= "${mapKeyValue?.getValue()?.answer}">
					<td>${mapKeyValue?.getValue()?.answer}</td>
				</g:if>
				<g:else>
					<td>Details in 100 words</td>
				</g:else>
			</tr>
		</g:each>

			<tr class="previewheading">
				<td class="text-center"><b>(8)</b></td>
				<td colspan="4"><b>Proposed mechanism and arrangements for
						benefit sharing</b></td>
			</tr>
			<tr>
				<td></td>
				<td><b>(i)</b></td>
				<td>Is there any proposed mechanism and arrangements for
					benefit sharing (non-monetary / monetary) with the provider of the
					biological resource(s) and / or associated traditional knowledge in
					accordance with the BD Act / Rules thereon?</td>

				<td class="text-center"><b>:</b></td>
			<g:if test="${appForm?.isBenefitSharing?.equals('true')}">	
				<td> Yes</td>
			</g:if>
			<g:elseif test="${appForm?.isBenefitSharing?.equals('false') }">
				<td> No</td>
			</g:elseif>
			<g:else>
				<td>N/A</td>
			</g:else>	
			</tr>


			<g:if test="${appForm?.isBenefitSharing?.equals('true')}">	
				<tr>
					<td></td>
					<td><b>(ii)</b></td>
					<td>If yes, attach a copy of mutually agreed terms between the
						applicant and the provider of biological resource(s) and / or
						associated traditional knowledge, if any</td>
	
					<td class="text-center"><b>:</b></td>
					<td><g:if test="${appForm?.sharingDoc}">
										<g:link controller="applicationManagement" action="showAppDc"
											id="${appForm?.id}" target="_blank"
											params='[filename: "sharingDocName", dataName: "sharingDocName",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
											${appForm?.sharingDocName}
										</g:link>
									</g:if>
									<g:else>
										N/A
									</g:else>
									</td>
				</tr>
			</g:if>
			
			
			
			
			
			<g:if test="${appForm?.companyProfiles?.size() != 0 }">	
					<tr>
						<td></td>
						<td><b>(ii)</b></td>
						<td>Do you intend to pay the benefit sharing in the form of</td>
		
						<td class="text-center"><b>:</b></td>
						<td><g:if test="${appForm?.payBenefitSharing == 'Monetary' }">
											Monetary
							</g:if>
							<g:elseif test="${appForm?.payBenefitSharing == 'Non-Monetary' }">
											Non-Monetary
							</g:elseif>
							<g:else>
									N/A
							</g:else>
						</td>
					</tr>
					
					<tr>
						<td></td>
						<td><b></b></td>
						<td>Whether the benefit sharing will be based on</td>
		
						<td class="text-center"><b>:</b></td>
						<td><g:if test="${appForm?.isMonetary == 'purchasePrice' }">
									Purchase price of biological resource 
							</g:if>
							<g:elseif test="${appForm?.isMonetary == 'exFactorySale' }">
									Gross ex-factory sale of Product 
							</g:elseif>
							<g:else>
									N/A
							</g:else>
						</td>
					</tr>
					
			</g:if>
			
			

			<tr class="previewheading">
				<td class="text-center"><b>(9)</b></td>
				<td colspan="4"><b>Any other information considered
						relevant</b></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2"></td>
				<td class="text-center"><b>:</b></td>
				<g:if test= "${appForm?.otherInfo }">
					<td>${appForm?.otherInfo }</td>
				</g:if>
				<g:else>
					<td>Details in 100 words</td>
				</g:else>
			</tr>
			
			
			<%--<tr class="previewheading">
				<td class="text-center"><b>(10)</b></td>
				<td colspan="4"><b>Whether proposed access is for trading purpose</b></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2">Whether proposed access is for trading purpose</td>
				<td class="text-center"><b>:</b></td>
				<g:if test="${appForm?.isTradingPurpose?.equals('true')}">	
				<td> Yes</td>
			</g:if>
			<g:elseif test="${appForm?.isTradingPurpose?.equals('false') }">
				<td> No</td>
			</g:elseif>
			<g:else>
				<td>N/A</td>
			</g:else>	
			</tr>--%>
			
			
			
			<g:if test="${appForm?.isTradingPurpose?.equals('true')}">
				<tr><td></td><td colspan="4" class="text-center"><b>Form A</b></td></tr>	
			<tr>
				<td> </td>
				<td colspan="4">
				<!-- start -->
				<table class="table-bordered datatable1 wordwrap">

							<thead>
								<tr>
									<th>S.No.</th>

									<th>Intend to access</th>

									<th>Common Name</th>
									<th>Scientific Name</th>
									<th>Nature of Biological Resource</th>
									<th>Part of Biological Resource</th>
									<th>Quantity of Resource</th>
									<th>Rate per unit (INR)</th>
									<th>State Biodiversity Board</th>
									<th>Prospective buyers / users(if known)</th>
									
								</tr>
							</thead>
							<tbody>
								<g:if test="${listOfBioResources}">
									<%int i=1 %>
									<g:each in="${listOfBioResources}" var="bioResource">
										<tr>
											<td scope="row"><%=i %></td>
											<%i++ %>
											<td>
												${bioResource?.accessIntention}
											</td>
											<g:if
												test="${bioResource?.accessIntention == 'Biological Resources' || bioResource?.accessIntention == 'Biological Resources & Traditional Knowledge' || bioResource?.accessIntention == 'Associated Knowledge' }">
												<td scope="row">
													${bioResource?.commonName}
												</td>
												<td scope="row">
													${bioResource?.scientificName}
												</td>
												<td scope="row">
													${bioResource?.nature}
												</td>
												<td scope="row">
													${bioResource?.biologicalResource}
												</td>
											</g:if>
											<g:else>
												<td scope="row">N/A</td>
												<td scope="row">N/A</td>
												<td scope="row">N/A</td>
												<td scope="row">N/A</td>
											</g:else>
									

												<g:if
													test="${bioResource?.accessIntention == 'Biological Resources' || bioResource?.accessIntention == 'Biological Resources & Traditional Knowledge' || bioResource?.accessIntention == 'Associated Knowledge'}">
													<td scope="row">
														${bioResource?.quantity} ${bioResource?.qtyUnit}
													</td>
												</g:if>
												<g:else>
													<td scope="row">N/A</td>
												</g:else>

											
												<td scope="row">${bioResource?.ratePerUnit}	</td>
													<td scope="row">${bioResource?.stateBiodeversityBoard}</td>
													<td scope="row">${bioResource?.prospectiveBuyers}</td>

									</tr></g:each></g:if>			

									
								<g:else>
									<tr>
										<td scope="row"></td>
										<td scope="row"></td>
										<td scope="row"></td>
										<td scope="row"></td>
										<td scope="row"></td>
										<td scope="row"></td>
										<td scope="row"></td>
										<td scope="row"></td>
										<td scope="row"></td>
									</tr>

								</g:else>
							</tbody>

						</table>
				
				<!-- end -->
				
				</td>
			</tr>
			<tr>
				<td></td>
				<td colspan="4"><b>Undertaking</b></td>
				</tr>
			
				<g:if test= "${appForm?.conditionOfAbs == true }">
				<tr>
				<td></td>
				<td class="one text-center"><input type="checkbox" checked="checked" disabled="disabled"/></td>
				<td colspan="3">
				 I have read and understood the terms and conditions of ABS guidelines and I undertake to abide by 
                relevant legal provisions applicable to biological resources. </td></tr>

					<tr><td></td><td></td><td colspan="3"> I understood to obtain the approval of the NBA/SBB before making any change in the stated purpose</td></tr>

					<tr><td></td><td></td><td colspan="3">I understood to obtain the approval of the NBA/SBB before making any change in the stated purpose</td></tr>

					<tr><td></td><td></td> <td colspan="3">I undertake to furnish/share the relevant records with the NBA / SBB, as and when required.</td></tr>

					<tr><td></td><td></td><td colspan="3">I undertake to furnish/share the relevant records with the NBA / SBB, as and when required.</td></tr>
				</g:if>
				<g:if test= "${appForm?.infromationTrue == true }">
					<li>
						<%--	<input type="checkbox" name="infromationTrue" checked="true"  class="pull-left" /> --%>
						&nbsp;<span>I further declare that the information provided in the form is true and correct and I shall be liable for any incorrect / wrong
					information and wilfull suppression of the facts.</li>
				</g:if><g:else>
				<li>
					<%--	<input type="checkbox" name="infromationTrue" class="pull-left" /> --%>
					&nbsp;<span>I further declare that the information provided in the form is true and correct and I shall be liable for any incorrect / wrong
				information and wilfull suppression of the facts.</li>
			</g:else>

				<g:if test= "${appForm?.approvalOfNba == true }">
				<tr>
				<td></td>
				<td class="one text-center"><input type="checkbox" checked="checked" disabled="disabled"/></td>
				<td colspan="3">I understood to obtain the approval of the NBA/SBB before making any change in the stated purpose.</td>
				
				</tr></g:if>
				<g:if test= "${appForm?.recordsWithTheNba == true }">
				<tr>
				<td></td>
				<td class="one text-center"><input type="checkbox" checked="checked" disabled="disabled"/></td>
				<td colspan="3">I undertake to furnish/share the relevant records with the NBA / SBB, as and when required.</td>
				</tr></g:if>
				<g:if test= "${appForm?.infromationTrue == true }">
				<tr>
				<td></td>
				<td class="one text-center"><input type="checkbox" checked="checked" disabled="disabled"/></td>
				<td colspan="3">I further declare that the information provided in the form is true and correct and I shall be liable for any incorrect / wrong 
information and wilfull suppression of the facts.</td>
			</tr>	</g:if>




			</g:if>
			

		<g:if test="${appForm?.transaction?.isPaymentMade != true }">
			<tr>
				<td></td>
				<td colspan="4">
				<g:link controller="applicationManagement" action="form1Part4"
						params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
						class="btn  btn-primary pull-right" method="POST">Edit Part 4</g:link>
				</td>
			</tr>
		</g:if>	

		</table>
	</div>


<div class="table-responsive">
<table class="table table-bordered datatable">
<tr class="previewheading">
				<td class="text-center one"><b></b></td>
				<td colspan="4"><b>Declaration:</b></td>
			</tr>
			
		<g:if test="${appForm?.isDeclarationDigitallySigned == 'true' }">
			<tr>
			<td></td>
			<td class="one text-center"><b>(a)</b></td>
			<td colspan="3">Declaration with digital signature</td>
			</tr>
		</g:if>
		<g:else>	
			<tr>
			<td></td>
			<td class="one text-center"><b>(a)</b></td>
			<td colspan="3">Declaration without digital signature</td>
			</tr>
		</g:else>	
			
			<tr>
			<td></td>
			
			<td colspan="4"><h4>I / we declare that :- </h4></td>
			
		
			
			</tr>
			
			<tr>
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
			
		<g:if test= "${appForm?.submitCheck == true }">
			<tr>
			<td></td>
			<td class="one text-center"><input type="checkbox" checked="checked" disabled="disabled"/></td>
			<td colspan="3">I / We further declare that information provided in the application form is true and correct and I / we shall be responsible for any incorrect / wrong information.</td>
			</tr>
		</g:if>
		<g:else>
			<tr>
			<td></td>
			<td class="one text-center"><input type="checkbox"  disabled="disabled"/></td>
			<td colspan="3">I / We further declare that information provided in the application form is true and correct and I / we shall be responsible for any incorrect / wrong information.</td>
			</tr>
		</g:else>	
	</table>
</div>

			<g:if test="${appForm?.transaction?.isPaymentMade == true }">
				 <div class="table-responsive ">
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
							Rs. 10,000/-
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
	<div class="">
		<table class="table table-bordered datatable">
			<tr>


				<td colspan="4" class="text-center"><g:link
						controller="FormPreview" class="btn btn-primary"
						action="printCompleateProject" target="_blank"
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

</div>

