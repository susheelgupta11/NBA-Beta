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
			<b>Form-B</b>
		</h3>

		(See Regulation 13 of the Guidelines on Access to biological resources
		and associated knowledge and Benefits Sharing Regulations, 2014) <br>
		Conducting of non-commercial research or research for emergency purposes outside India by Indian researcher’s/ Government institutions
	</div>
<%--	<g:if test="${appForm?.transaction?.isPaymentMade == true }">--%>
		<div class="col-sm-12">
			<span class="pull-right "><b>Application No:</b> ${appForm?.appNumber}</span>
			<span class="pull-left "><b>Submitted on:</b> ${appForm?.submittedOn}</span>
		</div>
<%--	</g:if>--%>

	<%--	<g:if test="${listOfIndianResearcher.size() != 0}">--%>
	<div class="col-sm-12 table-responsive">
	<g:if test="${listOfIndianResearcher }" >
		<table class="table table-bordered">
			<tr class="previewheading">
				<td class="text-center"><b>(1)</b></td>
				<td colspan="4"><span class="pull-left"><b>Full Particulars of
							Applicant </b></span></td>
			</tr>

			<% int num= 1 %>
			<% char alph = 65 %>
			<g:each in="${listOfIndianResearcher}" var="profile">
				<tr class="">

					<td class="no-width"></td>

					<td class="text-center one heading"><b>(${alph })
					</b></td>
					<td class="fifty heading"><b>Applicant ${num }</b></td>
					<td ></td>
					<td  class="fourty"></td>
				</tr>

				<% num++ %>
				<% alph++ %>
				<tr>
					<td></td>
					<td class="text-center">a</td>
					<td>Full Name</td>
					<td><b>:</b></td>
					<td>
						<span class="pull-left">${profile?.title} ${profile?.firstName} ${profile?.middleName} ${profile?.lastName}</span>
					</td>
				</tr>
				<tr>
					<td></td>
					<td class="text-center">b</td>
					<td>Nationality</td>
					<td><b>:</b></td>
					<td>
						<span class="pull-left">Indian${profile?.nationality}</span>
					</td>
				</tr>
				

				<tr>
					<td></td>
					<td class="text-center">c</td>
					<td>Complete Address for the communication</td>
					<td><b>:</b></td>
					<td>
						<span class="pull-left">
						${profile?.address1}, ${profile?.address2} ${profile?.address3} ${profile?.city},</span><br/>
						<span class="pull-left">PIN:${profile?.pincode}, ${profile?.province} ${profile?.country?.country}</span><br/>
						<span class="pull-left"><b>Mobile:</b>${profile?.mobile}</span><br/>
						<span class="pull-left"><b>Phone:</b>${profile?.phone}</span><br/>
						<span class="pull-left"><b>Email:</b>${profile?.email}</span><br/>
						
					</td>
				</tr>
				

				<!-- present address start -->
				<g:if test="${profile.samePresentAddress == 'No'}">	
					
					<tr>
						<td></td>
						<td class="text-center">d</td>
						<td>Present Address for the communication</td>
						<td><b>:</b></td>
						
							<td>
							<span class="pull-left">
								${profile?.presentAddress1}, ${profile?.presentAddress2} ${profile?.presentAddress3}${profile?.presentCity}, </span><br/>
							<span class="pull-left">PIN:${profile?.presentPincode}, ${profile?.presentProvince} ${profile?.presentCountry?.country}</span><br/>
							<span class="pull-left"><b>Mobile:</b>${profile?.presentMobile}</span><br/>
							<span class="pull-left"><b>Phone:</b>${profile?.presentPhone}</span>
							</td>
						
					</tr>
					
				</g:if>
				<g:elseif test="${profile?.samePresentAddress == 'Yes'}">
					
					<tr>
						<td></td>
						<td class="text-center">d</td>
						<td>Present Address for the communication</td>
						<td><b>:</b></td>
						
							<td>
							<span class="pull-left">
								${profile?.address1}, ${profile?.address2} ${profile?.address3} ${profile?.city},</span><br/>
							<span class="pull-left">PIN:${profile?.pincode}, ${profile?.province} ${profile?.country?.country}</span><br/>
							<span class="pull-left"><b>Mobile:</b>${profile?.mobile}</span><br/>
							<span class="pull-left"><b>Phone:</b>${profile?.phone}</span>
							</td>
						
					</tr>
						
				</g:elseif>
				<!-- present address end -->
				<g:if test="${profile.addressproofLetterFileName != null}">
					

					<tr>
						<td></td>
						<td class="text-center">e</td>
						<td>Attachment</td>
						<td><b>:</b></td>
						<td>
						
								<table class="table-bordered" style="width:100%;">
								
								<tbody><tr>
									<td>
										Id Number:<br> <b>${profile?.addressproofNo}</b>
									</td>
									
									<td>
										Attached <b>${profile?.addressproofSelect}</b>:<br>
										
											<g:link controller="applicationManagement"
													action="showUndertakingFile" id="${profile?.id}"
													target="_blank"
													params='[filename: "addressproofLetter",appFormId:"${appForm?.id }",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
													(click here for preview)
												</g:link>

											</td>
								</tr>
								
								
								<%--<tr>
									
									<td colspan="2" style="padding-bottom: 8px; padding-top: 8px;">
										Attached Authorization Letter :
										
										<g:link controller="applicationManagement"
													action="showDc" id="${profile?.id}"
													target="_blank"
													params='[filename: "authorizationLetterFileName",dataName:"authorizationLetterFileName",appFormId:"${appForm?.id }",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
													(click here for preview)
												</g:link>
											
										
									</td>
								</tr>
							--%></tbody></table>
								
					
						</td>
					</tr>
					
				</g:if>
			</g:each>
		</table>
		</g:if>
		
		
		
		
		
		<g:if test="${listOfIndianGovtInst }" >
				<table class="table table-bordered">
					<tr class="previewheading">
						<td class="text-center"><b>(1)</b></td>
						<td colspan="4"><span class="pull-left"><b>Full Particulars of
									Government Institution in India </b></span></td>
					</tr>
		
					<% int num= 1 %>
					<% char alph = 65 %>
					<g:each in="${listOfIndianGovtInst}" var="profile">
						<tr class="">
							<td class="no-width"></td>
							<td class="text-center one heading"><b>(${alph })
							</b></td>
							<td class="fifty heading"><b>Applicant ${num }</b></td>
							<td ></td>
							<td class="fourty"></td>
						</tr>
		
						<% num++ %>
						<% alph++ %>
						<tr>
							<td></td>
							<td class="text-center">a</td>
							<td>Name of Government Institution</td>
							<td><b>:</b></td>
							<td>
								<span class="pull-left">${profile?.govtInstName} </span>
							</td>
						</tr>
						
						<tr>
							<td></td>
							<td class="text-center">b</td>
							<td>Complete Address for the communication</td>
							<td><b>:</b></td>
							<td>
								<span class="pull-left">${profile?.address1}, ${profile?.address2} ${profile?.address3} </span>
								<span class="pull-left">${profile?.city} ${profile?.country?.country} </span><br/>
								<span class="pull-left"><b>Phone:</b>${profile?.phone}</span><br/>
								<span class="pull-left"><b>Email:</b>${profile?.email}</span><br/>
							</td>
						</tr>

		
						<!-- present address start -->
						<g:if test="${profile.samePresentAddress == 'No'}">
							
							<tr>
								<td></td>
								<td class="text-center">e</td>
								<td>Present Address for the communication</td>
								<td><b>:</b></td>
								<td>
									<span class="pull-left">${profile?.presentAddress1}, ${profile?.presentAddress1} ${profile?.presentAddress1}</span>
									<span class="pull-left">${profile?.presentCity} ${profile?.presentCountry?.country}</span><br/>
									<span class="pull-left"><b>Phone:</b>${profile?.presentPhone}</span><br/>
								</td>
							</tr>
		
						</g:if>
						<!-- present address end -->
						<g:if test="${profile.addressproofLetterFileName != null}">
							<tr class="register-heading">
								<td></td>
								<td class="text-center"><b></b></td>
								<td colspan="3"><b>Attach the Authorization letter</b></td>
							</tr>
		
							<tr>
								<td></td>
								<td class="text-center">g</td>
								<td>Id Proof</td>
								<td><b>:</b></td>
								<td>
									${profile?.addressproofSelect}
								</td>
							</tr>
							<tr>
								<td></td>
								<td class="text-center">h</td>
								<td>Id Proof No/Details</td>
								<td><b>:</b></td>
								<td>
									${profile?.addressproofNo}
								</td>
							</tr>
							<tr>
								<td></td>
								<td class="text-center">i</td>
								<td>Attachment</td>
								<td><b>:</b></td>
								<td><g:link controller="applicationManagement"
										action="showIndividualDc" id="${profile?.id}" target="_blank"
										params='[addressproofLetter:addressproofLetter,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
										${profile?.addressproofLetterFileName}
									</g:link></td>
							</tr>
						</g:if>
					</g:each>
				</table>
		</g:if>
		
	</div>
	<%--	</g:if>--%>

	<!-- part 2 start -->

	<div class="col-sm-12 table-responsive">
		<table class="table table-bordered">
			<tr class="previewheading">
				<td class="text-center" width="5%"><b>(2)</b></td>
				<td colspan="4"><span class="pull-left"><b>Name and Address of Institution in India</b></span></td>
			</tr>


				
				<tr>
					<td class="no-width"></td>
					<td class="text-center one heading">a</td>
					<td class="fifty heading">Name of the Institution*</td>
					<td ><b>:</b></td>
					<td class="fourty">
						<span class="pull-left">${entity1?.name}</span>
					</td>
				</tr>
				<tr>
					<td></td>
					<td class="text-center">b</td>
					<td>Complete Address for the communication</td>
					<td><b>:</b></td>
					<td>
						<span class="pull-left">${entity1?.address1}, ${entity1?.address2} ${entity1?.address3} ${entity1?.city}, </span><br/>
						<span class="pull-left">PIN:${entity1?.pincode}, ${entity1?.state} ${entity1?.country}</span><br/>
						<span class="pull-left"><b>Phone:</b>${entity1?.phone}</span><br/>
						<span class="pull-left"><b>Fax:</b>${entity1?.fax}</span><br/>
						<span class="pull-left"><b>Email:</b>${entity1?.email}</span>
					</td>
				</tr>

		</table>
	</div>
	<!-- part 2 end -->

	<!-- part 3 start -->

	<div class="col-sm-12 table-responsive">
		<table class="table table-bordered">
			<tr class="previewheading">
				<td class="text-center" width="5%"><b>(3)</b></td>
				<td colspan="4"><span class="pull-left"><b>Name of the Supervisor or
							Head of Institution at the place of work in India </b></span></td>
			</tr>

			<%  num= 1 %>
			<%  alph = 65 %>
			
				<g:if test="${entity2?.name || entity2?.supervisorDesignation }">
					<tr>
						<td class="no-width"></td>
						<td class="text-center one">a</td>
						<td class="fifty ">Name of the Supervisor</td>
						<td ><b>:</b></td>
						<td class="fourty">
							<span class="pull-left">${entity2?.name} </span>
						</td>
					</tr>
					<tr>
						<td class="no-width"></td>
						<td class="text-center one ">b</td>
						<td class="fifty ">Designation of the Supervisor</td>
						<td ><b>:</b></td>
						<td class="fourty">
							<span class="pull-left">${entity2?.supervisorDesignation} </span>
						</td>
					</tr>
				</g:if>
				<g:elseif test="${entity2?.headOfInstName || entity2?.headOfInstDesignation  }">
					<tr>
						<td class="no-width"></td>
						<td class="text-center one ">a</td>
						<td class="fifty ">Name of the Head of
							Institution</td>
						<td ><b>:</b></td>
						<td class="fourty">
							<span class="pull-left">${entity2?.headOfInstName} </span>
						</td>
					</tr>
					<tr>
						<td class="no-width"></td>
						<td class="text-center one ">b</td>
						<td class="fifty ">Designation of Head of Institution</td>
						<td ><b>:</b></td>
						<td class="fourty">
							<span class="pull-left">${entity2?.headOfInstDesignation } </span>
						</td>
					</tr>
				</g:elseif>
				<tr>
					<td></td>
					<td class="text-center">c</td>
					<td>Complete Address for the communication</td>
					<td><b>:</b></td>
					<td>
						<span class="pull-left">${entity2?.address1}, ${entity2?.address2} ${entity2?.address3} ${entity2?.city},</span><br/>
						 <span class="pull-left">PIN:${entity2?.pincode}, ${entity2?.state} ${entity2?.country}</span><br/>
						 <span class="pull-left"><b>Phone:</b>${entity2?.phone}</span><br/>
						 <span class="pull-left"><b>Email:</b>${entity2?.email}</span><br/>
					</td>
				</tr>

		</table>
	</div>
	<!-- part 3 end -->

	<!-- part 4 start -->

	<div class="col-sm-12 table-responsive">
		<table class="table table-bordered">
			<tr class="previewheading">
				<td class="text-center" width="5%"><b>(4)</b></td>
				<td colspan="4"><span class="pull-left"><b>Name and contact details of
							the Institution or organization who shall guide the proposed
							research / receiving the biological resources.</b></span></td>
			</tr>

			<%  num= 1 %>
			<%  alph = 65 %>
			
				<tr>
					<td class="no-width"></td>
					<td class="text-center one heading"></td>
					<td class="fifty heading">Category</td>
					<td><b>:</b></td>
					<g:if test="${ entity3?.contactDetailsOfInstOrOrganization == 'whoShallGuideOutsideIndia' }">
						<td class="fourty">
							<span class="pull-left">Contact details of the Institution or Organization who shall </span>
							<span class="pull-left">guide the proposed research outside India</span>
						</td>
					</g:if>
					<g:elseif test="${entity3?.contactDetailsOfInstOrOrganization == 'whoShallRcvTheBioResource'  }">
						<td class="fourty">
							<span class="pull-left">Contact details of the Institution or Organization who shall </span>
							<span class="pull-left">receive the biological resources outside India</span>
						</td>
					</g:elseif>
					
				</tr>
				<tr>
					<td class="no-width"></td>
					<td class="text-center one ">a</td>
					<td class="fifty ">Name of the Institution</td>
					<td><b>:</b></td>
					<td class="fourty">
						<span class="pull-left">${entity3?.name}</span>
					</td>
				</tr>
				<tr>
					<td></td>
					<td class="text-center">b</td>
					<td>Complete Address for the communication</td>
					<td><b>:</b></td>
					<td>
						<span class="pull-left">${entity3?.address1}, ${entity3?.address2} ${entity3?.address3} ${entity3?.city},</span><br/>
						<span class="pull-left"> PIN: ${entity3?.pincode},${entity3?.state} ${entity3?.country}</span><br/>
						<span class="pull-left"><b>Phone:</b>${entity3?.phone}</span><br/>
						<span class="pull-left"><b>Email:</b>${entity3?.email}</span>
						
					</td>
				</tr>

		</table>
	</div>
	<!-- part 4 end -->
	<!-- part 5 start -->

	<div class="col-sm-12 table-responsive">
		<table class="table table-bordered">
			<tr class="previewheading">
				<td class="text-center" width="5%"><b>(5)</b></td>
				<td colspan="4"><span class="pull-left"><b>Details of the Supervisor
							or Head of Institution or organization who guides the proposed
							research or recipient of the</span>
							<span class="pull-left"> biological resources </b></span></td>
			</tr>

			<%  num= 1 %>
			<%  alph = 65 %>
			
		<tr>
					<td class="no-width"></td>
					<td class="text-center one heading"></td>
					<td class="fifty heading">Category</td>
					<td ><b>:</b></td>
					<g:if test="${entity4?.category == 'contactDetails1' }">
						<td class="fourty">
							<span class="pull-left">Contact details of the Supervisor of the Institution</span>
							<span class="pull-left"> or Organization who guides the proposed research outside India</span>
						</td>
					</g:if>
					<g:elseif test="${entity4?.category == 'contactDetails2'  }">
						<td class="fourty">
							<span class="pull-left">Contact details of the Head of the Institution</span>
							<span class="pull-left"> or Organization who guides the proposed research outside India</span>
						</td>
					</g:elseif>
					<g:elseif test="${entity4?.category == 'contactDetails3'  }">
						<td class="fourty">
							<span class="pull-left">Contact details of the recipient of the biological resources</span>
							<span class="pull-left"> outside India</span>
						</td>
					</g:elseif>
				</tr>
				
				<tr>
					<td class="no-width"></td>
					<td class="text-center one ">a</td>
					<td class="fifty ">Name of the Supervisor or Head of
						Institution or recipient outside India</td>
					<td ><b>:</b></td>
					<td class="fourty">
						<span class="pull-left">${entity4?.name}</span>
					</td>
				</tr>
				<tr>
					<td></td>
					<td class="text-center">b</td>
					<td>Complete Address for the communication</td>
					<td><b>:</b></td>
					<td>
						<span class="pull-left">${entity4?.address1}, ${entity4?.address2} ${entity4?.address3} </span>
						<span class="pull-left">${entity4?.city} ${entity4?.state} ${entity4?.country}</span><br/>
						<span class="pull-left"><b>Mobile:</b>${entity4?.mobile}</span><br/>
						<span class="pull-left"><b>Phone:</b>${entity4?.phone}</span><br/>
						<span class="pull-left"><b>Email:</b>${entity4?.email}</span><br/>
					</td>
				</tr>

		</table>
	</div>
	<!-- part 5 end -->

	<!-- part 6 start -->

	<div class="col-sm-12 table-responsive">
		<table class="table table-bordered">
			<tr class="previewheading">
				<td class="text-center" width="5%"><b>(6)</b></td>
				<td colspan="4"><span class="pull-left"><b>Name of the funding agency
							supporting the proposed research </b></span></td>
			</tr>

			<%  num= 1 %>
			<%  alph = 65 %>
			


			<tr class="">
				<td width="5%"></td>
				<td colspan="4"><table class="table table-bordered datatable">

						<thead>
							<tr>
								<th>S.No.</th>
								<th>Institution/Organization name</th>
								<th>Address</th>
								<th>Communication Particulars</th>
								<th>Copy of Sanction order/MoU</th>
							</tr>
						</thead>
						<tbody>
							<g:if test="${listOfFundingAgency}">
								<%int i=1 %>
								<g:each in="${listOfFundingAgency}" var="agency">
									<tr>
										<td scope="row"><%=i %></td>
										<%i++ %>
										<td>
											${agency?.institutionOrganizationName}
										</td>
										
											<td scope="row">
												${agency?.address1}, ${agency?.address2} ${agency?.address3} ${agency?.city},
												${agency?.state}, ${agency?.country?.country}
											</td>
											<td scope="row">
												<b>Phone:</b> ${agency?.phone} <br/> <b>Email:</b>${agency?.email}<br/>
											</td>
											<td scope="row">
												<g:link controller="applicationManagement"
																action="showUndertakingFile" id="${agency?.id}"
																target="_blank"
																params='[filename: "sanctionOrderMoUcopy",appFormId:"${appForm?.id }",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
																${agency?.sanctionOrderMoUcopyFileName}
													</g:link>
											</td>
											
									</tr>
								</g:each>
							</g:if>
							<g:else>
								<tr>
									<td scope="row"></td>
									<td scope="row"></td>
									<td scope="row"></td>
									<td scope="row"></td>
									<td scope="row"></td>
								</tr>

							</g:else>
						</tbody>

					</table></td>

			</tr>
</table>
</div>

				
				<!-- part 6 end -->

	<!-- part 7 start-->
	<div class="col-sm-12 table-responsive">
		<table class="table table-bordered">
			<tr class="previewheading">
				<td class="text-center"><b>(7)</b></td>
				<td colspan="4"><span class="pull-left"><b>Brief description of
							research </b></span></td>
			</tr>

			<%  num= 1 %>
			<%  alph = 65 %>
			<tr class="">
				<td width="5%"></td>
				<td colspan="4">
					<span class="pull-left">${appForm?.briefDescription}</span>
				</td>

			</tr>


		</table>
	</div>
	<!-- part 7 end -->
	<!-- part 8 start-->
	<div class="col-sm-12 table-responsive">
		<table class="table table-bordered">
			<tr class="previewheading">
				<td class="text-center"><b>8.(i)</b></td>
				<td colspan="4"><span class="pull-left"><b>Details of biological
							resources proposed to be carried along or sent for the research </b></span></td>
			</tr>

			<%  num= 1 %>
			<%  alph = 65 %>
			<tr class="">
				<td width="5%"></td>
				<td colspan="4"><table class="table table-bordered datatable">

						<thead>
							<tr>
								<th>S.No.</th>
								<g:if test="${formType == 'Form1' || formType == 'FormB' }">
									<th>Intend to access</th>
								</g:if>
								
								
								<th>Common Name</th>
								<th>Scientific Name</th>
								<th>Nature of Biological Resource</th>
								<th>Part of Biological Resource</th>
								<th>Quantity of Biological Resource</th>

							
								
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
											test="${bioResource?.accessIntention == 'Carried along for the research' || bioResource?.accessIntention == 'Sent for the Research'}">
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
											<td scope="row">
												${bioResource?.quantity} ${bioResource?.qtyUnit}
											</td>
										</g:if>
										<g:else>
											<td scope="row">N/A</td>
											<td scope="row">N/A</td>
											<td scope="row">N/A</td>
											<td scope="row">N/A</td>
											<td scope="row">N/A</td>
										</g:else>

									</tr>
								</g:each>
							</g:if>
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
									
								</tr>

							</g:else>
						</tbody>

					</table></td>

			</tr>


		</table>
	</div>
	<!-- part 8 end -->
	<!-- part 9 start-->
	<div class="col-sm-12 table-responsive">
		<table class="table table-bordered">
			<tr class="previewheading">
				<td class="text-center"><b>8.(ii)</b></td>
				<td colspan="4"><span class="pull-left"><b>Duration of Research</b></span></td>
			</tr>

			<%  num= 1 %>
			<%  alph = 65 %>
			<tr class="">
				<td width="5%"></td>
				<td colspan="2">
					
					<b>From:</b>  ${appForm?.researchDurationFrom?.format('dd/MM/yyyy') }
				
				</td>
				<td colspan="2">
					<b>To</b>: ${appForm?.researchDurationTo?.format('dd/MM/yyyy') }
				</td>
			</tr>
			
			<tr>
				<td width="5%"></td>
				<td colspan="2">
					
					<b>Type of exercise:</b>  
				
				</td>
				<td colspan="2">
					<g:if test="${appForm?.typeOfExercise == 'multipleTime'}">
						Multiple-time Exercise
					</g:if>
					<g:else>
						One-time Exercise
					</g:else>
				</td>
			</tr>
			
			<g:if test="${appForm?.typeOfExercise == 'multipleTime'}">
					<tr>
						<td width="5%"></td>
						<td colspan="2">
							
							<b>How many times going to send /carry the biological resources?</b>  
						
						</td>
						<td colspan="2">
							${appForm?.numOfTimesOfSending }
						</td>
					</tr>
					
					<tr>
						<td width="5%"></td>
						<td colspan="2">
							
							<b>Explain the reasons for sending /carrying the multiple times</b>  
						
						</td>
						<td colspan="2">
							${appForm?.reasonsForSending }
						</td>
					</tr>
			</g:if>


		</table>
	</div>
	<!-- part 9 end -->
	<!-- part 10 start-->
	<div class="col-sm-12 table-responsive">
		<table class="table table-bordered">
			<tr class="previewheading">
				<td class="text-center"><b>8.(iii)</b></td>
				<td colspan="4"><span class="pull-left"><b>Geographical location of collection</b></span></td>
			</tr>

			<%  num= 1 %>
			<%  alph = 65 %>
			<tr class="">
				<td width="5%"></td>
				<td colspan="4">
					<table class="table table-bordered datatable">
						<thead>
							<tr>
								<th>S.No.</th>
								<th>Name of biological resource </th>
								<th>Source of access</th>
								<th>Village/ Panchayat</th>
								<th>Town/ Taluk</th>
								<th>District</th>
								<th>State</th>
								<th> Name</th>
								<th> Contact details</th>
							
							</tr>
						</thead>
						<tbody>
							<g:if test="${listOfLocations}">
						<%int i=1 %>
						<g:each in="${listOfLocations}" var="location">
							<tr>
								<td scope="row"><%=i %></td>
								<%i++ %>
								<td scope="row">${location?.bioResource?.scientificName}</td>
								<td scope="row">${location?.source}</td>
								<td scope="row">
									<g:if test= "${location?.village}">
										${location?.village}
									</g:if>
									<g:else>
										N/A
									</g:else>
								</td>
								
								
								<td scope="row">
									<g:if test="${location?.town}">	
										${location?.town}
									</g:if>
									<g:else>
										N/A
									</g:else>	
								</td>
								<td scope="row">
									<g:if test= "${location?.district}">
										${location?.district}
									</g:if>
									<g:else>
										N/A
									</g:else>	
								</td>
								<td scope="row">
									<g:if test="${location?.state}">	
										${location?.state}
									</g:if>
									<g:else>
										N/A
									</g:else>	
								</td>
								<td scope="row">
									<g:if test="${location?.traderName}">
										${location?.traderName}
									</g:if>
									<g:else>
										N/A
									</g:else>	
								</td>
								<td scope="row">
									<g:if test="${location?.traderContactDetails}">	
										${location?.traderContactDetails}
									</g:if>
									<g:else>
										N/A
									</g:else>	
								</td>
								
							</tr>
							</g:each>
							</g:if>
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
								<td scope="row"></td>
							</tr>
						
						</g:else>
							
						</tbody>
					</table>
				</td>

			</tr>


		</table>
	</div>
	
	<!-- part 10 end -->
	<!-- part 11 start-->
	<div class="col-sm-12 table-responsive">
		<table class="table table-bordered">
			<tr class="previewheading">
				<td class="text-center"><b>(9)</b></td>
				<td colspan="4"><span class="pull-left"><b> If it is for emergency purpose, specify details</b></span></td>
			</tr>

			<%  num= 1 %>
			<%  alph = 65 %>
			<tr class="">
				<td width="5%"></td>
				<td colspan="4">
					<span class="pull-left">${appForm?.emergencyDetails }</span>
				</td>

			</tr>


		</table>
	</div>
	
	
	
	<div class="col-sm-12 table-responsive">
		<table class="table table-bordered">
			<tr class="previewheading">
				<td class="text-center"></td>
				<td colspan="4"><span><b>Undertaking/Declaration</b></span></td>
			</tr>
			
			<tr>
					<td></td>
					<td>Undertaking by the applicant</td>
					<td><b>:</b></td>
					<td>
						<span class="pull-left">
							<b>
							<g:link controller="applicationManagement" action="showUndertakingFile"
								id="${appForm?.id}" target="_blank"
								params='[filename: "undertakingCopy", dataName: "undertakingCopy",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
								${appForm?.undertakingCopyFileName}
							</g:link>
							</b>
						</span>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>Declaration by the Applicant on Nationality</td>
					<td><b>:</b></td>
					<td>
						<span class="pull-left">
							<b>
							<g:link
								controller="applicationManagement" action="showUndertakingFile"
								id="${appForm?.id}" target="_blank"
								params='[filename: "declarationByApplicantOnNationalityCopy", dataName: "declarationByApplicantOnNationalityCopy",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
								${appForm?.declarationByApplicantOnNationalityCopyFileName}
							</g:link>
							</b>
						</span>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>Declaration by the Supervisor / Head of Institution in India</td>
					<td><b>:</b></td>
					<td>
						<span class="pull-left">
							<b>
							<g:link
								controller="applicationManagement" action="showUndertakingFile"
								id="${appForm?.id}" target="_blank"
								params='[filename: "declarationBySupervisorCopy", dataName: "declarationBySupervisorCopy",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
								${appForm?.declarationBySupervisorCopyFileName}
							</g:link>
							</b>
						</span>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>Declaration by the Recipient or Collaborator outside India</td>
					<td><b>:</b></td>
					<td>
						<span class="pull-left">
							<b>
							<g:link
								controller="applicationManagement" action="showUndertakingFile"
								id="${appForm?.id}" target="_blank"
								params='[filename: "declarationByRecipientCopy", dataName: "declarationByRecipientCopy",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
								${appForm?.declarationByRecipientCopyFileName}
							</g:link>
							</b>
						</span>
					</td>
				</tr>
			
			
			
			
			
		</table>
	</div>
	
	
	
	
	<!-- part 11 end -->
	<div>
		<div class="">
			<table class="table table-bordered datatable">
				<tr>

					<td colspan="4" class="text-center"><g:link
							controller="formPreview" class="btn btn-primary"
							action="printCompleteProjectB" target="_blank"
							params='[id:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
            Print Form
	</g:link> <g:link controller="PDF" class="btn btn-primary" action="index" 
							params='[projectId:appForm?.id,formBid:"${entity5?.id }",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
            Print Attachments 
	</g:link></td>
				</tr>

			</table>
		</div>
	</div>
</div>		
				
	
