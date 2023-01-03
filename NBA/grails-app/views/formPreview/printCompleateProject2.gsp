<%! import org.nba.common.State%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="layout" content="projectPreview" />
<title></title>
<script type="text/javascript">
	$(function() {
		window.print();
	});
</script>
<style>
	table{font-size:1.2em;}
</style>
</head>
<body>


<div class="row">
	<div class="col-sm-12 text-center">
		<h3 class="register-heading">
			<b>Form-II</b>
		</h3>
		(See Rule 17 of Biological Diversity Rules, 2004)<br /> Application form for transferring the results of research to foreign nationals, companies, NRIs for commercial purposes.
	</div>
		<g:if test="${appForm?.transaction?.isPaymentMade == true }">
			<div class="col-sm-12">
				<span class="pull-right "><b>Application No:</b> ${appForm?.appNumber}</span>
				<span class="pull-left "><b>Submitted on:</b>${appForm?.submittedOn}</span>
			</div>
		</g:if>


		<g:if test="${listofFormData.size() != 0}">
	<div class="col-sm-12 table-responsive" style="width: 97%; padding: 0px 15px 0px 15px;">
		<table class="table table-bordered" style="border:1px solid #000" >
				<tr>
					<td class="one"></td>
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
						<td class="text-center one heading"><b>(${alph })</b></td>
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
						<td>${profile?.title} ${profile?.firstName} ${profile?.middleName} ${profile?.lastName}</td>
					</tr>


					<tr>
						<td></td>
						<td></td>
						<td>Nationality</td>
						<td class="text-center"><b>:</b></td>
					<g:if test= "${profile?.nationality == 'Non Indian' }">	
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
						<td class="text-center"><b>:</b></td>
						<td>${profile?.profile}
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
						<td class="text-center"><b>:</b></td>
						<td>
							${profile?.address1} ${profile?.address2} ${profile?.address3},${profile?.city},
							${profile?.country?.country}
						</td>
					</tr>
					<tr>
						<td></td>
						<td class="text-center">b</td>
						<td>Mobile phone number</td>
						<td class="text-center"><b>:</b></td>
						<td>
							${profile?.mobile}
						</td>
					</tr>

					<tr>
						<td></td>
						<td class="text-center">c</td>
						<td>Telephone number</td>
						<td class="text-center"><b>:</b></td>
						<td>
							${profile?.phone}
						</td>
					</tr>

					<tr>
						<td></td>
						<td class="text-center">d</td>
						<td>Email address</td>
						<td class="text-center"><b>:</b></td>
						<td>
							${profile?.email}
						</td>
					</tr>

					<tr>
						<td></td>
						<td class="text-center">e</td>
						<td>Attachments</td>
						<td class="text-center"><b>:</b></td>
						<td> 		${profile?.idProofSelect ? profile?.idProofSelect : 'Id Proof' }, Id Num: <b>${profile?.idNum ? profile?.idNum  : 'N/A' }</b>  
							<br />  Passport Copy, Passport Num: <b>${profile?.passportNum ? profile?.passportNum : 'N/A' }</b> 
							<br />   Authorization Letter (as per Schedule A)
												<g:if test="${profile?.authorizationLetter }">,
												</g:if>
												<g:else>:
													<b>(No document attached),</b>
												</g:else>
												 Authorization Number:
							     <g:if test="${profile?.authorizationNo}">		
									<b>${profile?.authorizationNo}</b> 
								</g:if>
								<g:else>
									<b>N/A</b>
								</g:else>	  <br />
						</td>
					</tr>
	
				</g:each>
		</table>
	</div>
	</g:if>


	<div class="col-sm-12 table-responsive" style="width: 97%;padding: 0px 15px 0px 15px">
		<table class="table table-bordered">
		<g:if test= "${listOfCompanyData?.size() != 0 }">
			<tr>
				<td class="one"></td>
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
			</g:if> <g:else>
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
						<td><b>Nature if Business</b></td>

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
						<td><g:if test="${companyProfile1?.passportCopy}">
						
							 ${companyProfile1?.authRepresentativeIdSelect ? companyProfile1?.authRepresentativeIdSelect : 'Id Proof' },
							 
							 	Id Number: <b>${companyProfile1?.idNum ? companyProfile1?.idNum : 'N/A' }</b>
								
							</g:if> <g:else>
								<span class="text-danger">Document Not Attached</span>
							</g:else><br /> <g:if test="${companyProfile1?.authorizationLetter}">
								 Authorization Letter, Authorization Number: <b>N/A</b>
								
							</g:if> <g:else>
								<span class="text-danger">Document Not Attached</span>
							</g:else><br /> </td>
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
				<td><b>(a)</b> <g:if test="${agentProfile?.authorizationLetter}">
						<b>Authorization Letter</b>
						
					</g:if> <g:else>
						<span class="text-danger">Authorization Letter not Attached</span>
					</g:else><br /> <b>(b)</b> 
					
					<g:if test="${agentProfile?.passportCopy}">
					<b>${agentProfile?.photoIdSelect ? agentProfile?.photoIdSelect : 'Photo Id Proof' }</b>
						
					</g:if> <g:else>
						<span class="text-danger">Photo Id Proof not Attached</span>
					</g:else><br />
				</td>
			</tr>
</g:if>

		
		
				</table>
			</div>
		</table>
	</div>
	









		<div class="col-sm-12 table-responsive">
		<table class="table table-bordered">
		
			<tr class="previewheading">
				<td class="text-center one"><b>(2)</b></td>
				<td colspan="4"><b>Details of the results of research conducted</b></td>
			</tr>
			<tr>
				<td class= "one"></td>
				<td class= "one"><b>(a)</b></td>
				<td class="fifty">A brief detail of research conducted</td>
				<td class="one"><b>:</b></td>
				<td>${appForm?.briefDescription}</td>

			</tr>
			<tr>
				<td></td>
				<td><b>(b)</b></td>
				<td class="fifty">Type of results of research to be transferred</td>
				<td class="one"><b>:</b></td>
				<td>${appForm?.resultsOfResearch}</td>
			</tr>

			<tr class="previewheading">
				<td class="text-center"><b>(3)</b></td>
				<td colspan="4"><b>Details of biological resources and associated knowledge used in the research</b></td>
			</tr>

			<g:if test= "${listOfBioResources }">	
			<tr>
				<td></td>
				<td class="text-center"><b>(i)</b></td>
				<td colspan="3">Identification (scientific name) of biological
					resources and its traditional use</td>
			</tr>
		</g:if>
		<g:else>	
			<tr>
				<td></td>
				<td class="text-center"><b>(i)</b></td>
				<td>Identification (scientific name) of biological
					resources and its traditional use</td>
				<td><b>:</b></td>
				<td>No</td>
			</tr>
		</g:else>

			<%--<tr>
				<td></td>
				<td><b>(a)</b></td>
				<td class="fifty">Intent to access</td>
				<td class="one"><b>:</b></td>
				<td>
					<g:if test= "${ listOfBioResources?.getAt(0)?.accessIntention == 'Biological' }">
						${listOfBioResources?.getAt(0)?.accessIntention} Resources
					</g:if>
					<g:elseif test= "${ listOfBioResources?.getAt(0)?.accessIntention == 'Associated' }">
						${listOfBioResources?.getAt(0)?.accessIntention} Knowledge
					</g:elseif>
					<g:else>
						${listOfBioResources?.getAt(0)?.accessIntention}
					</g:else>
				</td>

			</tr>


			--%>
		<g:if test= "${listOfBioResources }">	
			<tr>
				<td></td>
				<td></td>
				<td colspan="3">
					<table class="table table-bordered datatable1">
						<thead>
							<tr>
								<th>SI.No</th>
								<th>Transferred</th>
								<th>Common name</th>
								<th>Scientific name</th>
								<th>Nature of biological resources</th>
								<th>Source of access</th>
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
		
			<g:if test="${listOfLocations}">
			<tr>
				<td>&nbsp;</td>
				<td class="text-center"><b>(ii)</b>
				<td colspan="3"><b>Geographical location of proposed
						collection</b></td>

			</tr>
		</g:if>
		<g:else>
			<tr>
				<td>&nbsp;</td>
				<td class="text-center"><b>(ii)</b>
				<td><b>Geographical location of proposed
						collection</b></td>
				<td><b>:</b></td>
				<td>No</td>
			</tr>
		</g:else>	
			
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


<g:if test="${appForm?.individualProfiles?.size() > 0 && appForm?.individualProfiles?.getAt(0)?.nationality == 'Non Indian' || appForm?.individualProfiles?.getAt(0)?.nationality == 'Non-Resident Indian' }">	
			<tr>
				<td class= "one"></td>
				<td class= "one"><b>(a)</b></td>
				<td class="fifty">Whether approval of NBA obtained to access the biological resources and / or associated knowledge for the said research</td>
				<td class="one"><b>:</b></td>
				<td>
					<g:if test= "${appForm.isApprovalOfNbaObtained == 'true'}">
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
					<g:if test= "${appForm?.nbaApprovalFile }">
						
					</g:if>
					<g:else>
						N/A
					</g:else>
				</td>
			</tr>
			
		</g:if>	



			
		</table>

	</div>





	<div class="col-sm-12 table-responsive">
		<table class="table table-bordered">
			
			
			

			<g:if test= "${appForm.isNoForTraditional == 'No' }">
			<tr class="previewheading">
				<td class="text-center one"><b>(5)</b></td>
				<td colspan="2"><b>Description / nature of traditional knowledge (oral
						/ documented)</b></td>
				<td><b>:</b></td>
				<td>
					${appForm.isNoForTraditional}
				</td>
			</tr>
		</g:if>
		<g:if test= "${appForm.isNoForTraditional != 'No' }">
			<tr class="previewheading">
				<td class="text-center one"><b>(5)</b></td>
				<td colspan="4"><b>Description / nature of traditional knowledge (${appForm?.nature})</b></td>
			</tr>
		</g:if>	
			
			
			<g:if test= "${appForm.isNoForTraditional != 'No' }">
			<tr>
				<td></td>
				<td></td>
				<td>Description</td>
				<td class="text-center one"><b>:</b></td>
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
<%--				<td></td>--%>
			</tr>
			<g:if test= "${appForm.isNoForTraditional == 'No' || listOfCommunityLocations?.size() == 0}">
			<tr>
				<td></td>
				<td></td>
				<td>(i) Consent obtained from the community / individual</td>
				<td class="text-center"><b>:</b></td>
				<td>No</td>
			</tr>
			</g:if>

			<g:if test="${listOfCommunityLocations}">
			<tr>
				<td></td>
				<td colspan="4">
					<table class="table table-bordered datatable1">
						<thead>
							<tr>
								<th class="text-center">SI. No</th>
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
				<td class="text-center"><b>(6)</b></td>
				<td colspan="4"><b>Details of institution where R&D activities carried out</b></td>
			</tr>
			
			<tr>
				<td></td>

				<td class="text-center one"><b>(i)</b></td>
				<td>Provide the name and contact details of the institution / organisation where R & D was carried out</td>
				<td class="text-center"><b>:</b></td>
				<td>
				  <g:if test="${appForm?.detailsOfInstitute}">
					   ${appForm?.detailsOfInstitute}
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
				<td><g:if test="${appForm?.bonafideLetter || appForm.isResearchParticipation == 'true'}">
										
								
									</g:if>
									<g:else>
									<span>N/A</span>
											</g:else>		
									</td>
			</tr>
			
			</table>
			</div>

<div class="col-sm-12 table-responsive">
		<table class="table table-bordered datatable">
			<tr class="previewheading">
				<td class="text-center one"><b>(7)</b></td>
				<td colspan="4"><b>Details of
								individual/ organisation to whom the research results are
								intended to be transferred </b></td>
			</tr>
			<tr>
				<td></td>
				<td><b>(a)</b></td>
				<td>Name and contact details of individual / organisation</td>

				<td class="text-center"><b>:</b></td>
			
				<td>${appForm?.detailsOfInstitute}</td>
			</tr>
			<tr>
				<td></td>
				<td><b>(b)</b></td>
				<td>Details of the intended use of research results by the transferee</td>

				<td class="text-center"><b>:</b></td>
			
				<td>${appForm?.useofResearchResults}</td>
			</tr>

			

			<tr class="previewheading">
				<td class="text-center"><b>(8)</b></td>
				<td colspan="4"><b>Details of economic, biotechnological, scientific or any other benefits that are
								intended, or may accrue to the individual / organization due to
								commercialization of transferred research results</b></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2"></td>
				<td class="text-center"><b>:</b></td>
				<g:if test= "${appForm?.benefitsToTheIndividualOrOrganization}">
					<td>${appForm?.benefitsToTheIndividualOrOrganization}</td>
				</g:if>
				<g:else>
					<td>Details in 100 words</td>
				</g:else>
			</tr>
			
			<tr class="previewheading">
				<td class="text-center"><b>(9)</b></td>
				<td colspan="4"><b>Details of economic, biotechnological, scientific or any other benefits that are
								intended, or may accrue to the applicant seeking approval for
								transfer of results of research</b></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2"></td>
				<td class="text-center"><b>:</b></td>
				<g:if test= "${appForm?.benefitsToTheApplicant}">
					<td>${appForm?.benefitsToTheApplicant}</td>
				</g:if>
				<g:else>
					<td>Details in 100 words</td>
				</g:else>
			</tr>

			<tr class="previewheading">
				<td class="text-center"><b>(10)</b></td>
				<td colspan="4"><b>Details of any agreement or MoU between the proposed recipient and applicant
								seeking approval for transfer of results of research</b></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2">Is there any such detail</td>
				<td class="text-center"><b>:</b></td>
				<g:if test= "${appForm?.collaborationDetails}">
					<td>Yes</td>
				</g:if>
				<g:else>
					<td>No</td>
				</g:else>
			</tr>
			
		<g:if test= "${appForm?.collaborationDetails}">	
			<tr>
				<td></td>
				<td colspan="2"></td>
				<td class="text-center"><b>:</b></td>
				<g:if test= "${appForm?.collaborationDetails}">
					<td>${appForm?.collaborationDetails}</td>
				</g:if>
				<g:else>
					<td>N/A</td>
				</g:else>
			</tr>
			<tr>
				<td></td>
				<td colspan="2">Attached copy of the relevant agreement or MoU</td>
				<td class="text-center"><b>:</b></td>
				<td><g:link controller="form2" action="showDc" id="${appForm?.id}"
									target="_blank"
									params="[filename: 'mouFileName', dataName: 'mouFileName']">
									${appForm?.mouFileName}
								</g:link></td>
			</tr>
</g:if>

			

		</table>
	</div>





<div class="col-sm-12 table-responsive">
<table class="table table-bordered datatable">
<tr class="previewheading">
<%--				<td class="text-center one"><b>(10)</b></td>--%>
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
							Rs. 5,000/-
						</td>
					</tr>
					
					<tr>
						<td class= "text-center one">(d)</td>
						<td colspan="2">Payment Receipt</td>
						<td class="one"><b>:</b></td>
						<td></td>
					</tr>
					</table>
				</div>	
				</g:if>

</div>
</body>
</html>

