<%! import org.nba.common.*%>
<% char alpha = 65 %>

<g:if test="${allDataforMatching?.listOfIndianResearcher}">
	<g:each in="${allDataforMatching?.listOfIndianResearcher}" var="indianProfile" status="i">
		<tr>
			<td><b>1</b></td>
			<td width="35px"><b>(${alpha})
			</b></td>
			<td colspan="2"><b>Applicant ${i+1}</b></td>
			<td></td>

		</tr>
		<tr>
			<td width="35px"></td>
			<td width="35px" rowspan="3"><b>(i)</b></td>
			<td width="35px"><b>(a)</b></td>
			<td style="width: 50% !important"><b>Full Name :</b></td>

			<td class="righttd">
				${indianProfile?.title} ${indianProfile?.firstName} ${indianProfile?.middleName}
				${indianProfile?.lastName}
			</td>
		</tr>
		
		<tr>
			<td width="35px"></td>
			<td width="35px"><b>(b)</b></td>
			<td><b>Nationality :</b></td>
			<%--	<td class="text-center"><b></b></td>--%>
			<td class="righttd">
				${indianProfile?.nationality?:'Indian'}
			</td>
		</tr>

		<tr>
			<td></td>
			<td width="35px"><b>(c)</b></td>
			<td><b>Complete Address for the communication :</b></td>
			<%--	<td class="text-center"><b>:</b></td>--%>
			<td class="text-left">
				${indianProfile?.address1} ${indianProfile?.address2} ${indianProfile?.address3}
				${indianProfile?.city} ${indianProfile?.pincode} ${indianProfile?.province}

				${indianProfile?.country?.country} <b>Mobile No:</b> ${indianProfile?.mobile}<br />
				<b>indianProfile No:</b> ${indianProfile?.phone} <br /> <b>Email:</b>
				${indianProfile?.email}<br />
			</td>
		</tr>
		<g:if test="${indianProfile.samePresentAddress == 'No'}">
			<tr>
				<td></td>
				<td width="35px"><b></b></td>
				<td>(d)</td>
				<td><b>Present Address for the communication :</b></td>
				<%--	<td class="text-center"><b>:</b></td>--%>
				<td class="text-left">
					${indianProfile?.presentAddress1} ${indianProfile?.presentAddress2} ${indianProfile?.presentAddress3}
					${indianProfile?.presentCity} ${indianProfile?.presentPincode} ${indianProfile?.presentProvince}

					${indianProfile?.presentCountry?.country} <b>Mobile No:</b> ${indianProfile?.presentMobile}<br />
					<b>indianProfile No:</b> ${indianProfile?.presentPhone} <br />
				</td>
			</tr>
		</g:if>
		<g:elseif test="${indianProfile.samePresentAddress == 'Yes'}">
			<tr>
				<td></td>
				<td width="35px"><b></b></td>
				<td><b>(d)</b></td>
				<td><b>Present Address for the communication :</b></td>
				<%--	<td class="text-center"><b>:</b></td>--%>
				<td class="text-left">
					${indianProfile?.address1} ${indianProfile?.address2} ${indianProfile?.address3}
					${indianProfile?.city} ${indianProfile?.pincode} ${indianProfile?.province}

					${indianProfile?.country?.country} <b>Mobile No:</b> ${indianProfile?.mobile}<br />
					<b>indianProfile No:</b> ${indianProfile?.phone} <br /> <b>Email:</b>
					${indianProfile?.email}<br />
				</td>
			</tr>
		</g:elseif>

		<g:if test="${indianProfile?.addressproofLetterFileName != null}">

			<tr>
				<td width="35px"></td>
				<td width="35px"></td>
				<td><b>(e)</b></td>
				<td class="text-center"><b>Attachment</b><br>Id Number:<br> <b>
						${indianProfile?.addressproofNo}
				</b></td>

				<td class="righttd"><b>
						${indianProfile?.addressproofSelect}
				</b>:<br> <g:link controller="applicationManagement"
						action="showUndertakingFile" id="${indianProfile?.id}" target="_blank"
						params='[filename: "addressproofLetter",appFormId:"${formDetails?.id }",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
													(click here for preview)
												</g:link></td>

			</tr>
		</g:if>
	</g:each>
</g:if>

<%--------------------------------------------------------------------------------------------------------------------------------- --%>
<%--------------------------------------------------------------------------------------------------------------------------------- --%>
<%--------------------------------------------------------------------------------------------------------------------------------- --%>

<% char alpha1 = 65 %>
<g:if test="${allDataforMatching?.listOfIndianGovtInst}">
	<g:each in="${allDataforMatching?.listOfIndianGovtInst}"
		var="govtProfile" status="i">
		<tr>
			<td></td>
			<td width="35px"><b>(${alpha1})
			</b></td>
			<td colspan="2"><b>Applicant ${i+1}</b></td>
			<td></td>

		</tr>
		<tr>
			<td width="35px"></td>
			<td width="35px" rowspan="3"><b>(i)</b></td>
			<td width="35px"><b>(a)</b></td>
			<td style="width: 50% !important"><b>Full Name :</b></td>

			<td class="righttd">
				${govtProfile?.govtInstName}
			</td>
		</tr>
		<tr>

		<tr>
<%--			<td></td>--%>
			<td width="35px"><b>(ii)</b></td>
			<td colspan="2"><b>Complete Address for the communication :</b></td>
			<%--	<td class="text-center"><b>:</b></td>--%>
			<td class="text-left">
				${govtProfile?.address1} ${govtProfile?.address2} ${govtProfile?.address3}
				${govtProfile?.city}${govtProfile?.country?.country} 
				<b>phone No:</b> ${govtProfile?.phone} <br /> <b>Email:</b>
				${govtProfile?.email}<br />
			</td>
		</tr>
		<g:if test="${govtProfile.samePresentAddress == 'No'}">
			<tr>
				<td></td>
				<td width="35px"><b>(ii)</b></td>
				<td colspan="2"><b>Present Address for the communication :</b></td>
				<%--	<td class="text-center"><b>:</b></td>--%>
				<td class="text-left">
					${govtProfile?.presentAddress1} ${govtProfile?.presentAddress2} ${govtProfile?.presentAddress3}
					${govtProfile?.presentCity}
					${govtProfile?.presentCountry?.country} <br />
					<b>govtProfile No:</b> ${govtProfile?.presentPhone} <br />
				</td>
			</tr>
		</g:if>
	
						<g:if test="${govtProfile.addressproofLetterFileName != null}">
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
									${govtProfile?.addressproofSelect}
								</td>
							</tr>
							<tr>
								<td></td>
								<td class="text-center">h</td>
								<td>Id Proof No/Details</td>
								<td><b>:</b></td>
								<td>
									${govtProfile?.addressproofNo}
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
										${govtProfile?.addressproofLetterFileName}
									</g:link></td>
							</tr>
						</g:if>
	</g:each>
</g:if>
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
						<span class="pull-left">${allDataforMatching?.entity1?.name}</span>
					</td>
				</tr>
				<tr>
					<td></td>
					<td class="text-center">b</td>
					<td>Complete Address for the communication</td>
					<td><b>:</b></td>
					<td>
						<span class="pull-left">${allDataforMatching?.entity1?.address1}, ${allDataforMatching?.entity1?.address2} ${allDataforMatching?.entity1?.address3} ${allDataforMatching?.entity1?.city}, </span><br/>
						<span class="pull-left">PIN:${allDataforMatching?.entity1?.pincode}, ${allDataforMatching?.entity1?.state} ${allDataforMatching?.entity1?.country}</span><br/>
						<span class="pull-left"><b>Phone:</b>${allDataforMatching?.entity1?.phone}</span><br/>
						<span class="pull-left"><b>Fax:</b>${allDataforMatching?.entity1?.fax}</span><br/>
						<span class="pull-left"><b>Email:</b>${allDataforMatching?.entity1?.email}</span>
					</td>
				</tr>

		</table>

<g:set var="entity2" value="${allDataforMatching?.entity2}"/>
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
		
<g:set var="entity3" value="${allDataforMatching?.entity3}"/>		
		
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
		
		<g:set var="entity4" value="${allDataforMatching?.entity4}"/>
		
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
		
<g:set var="listOfFundingAgency" value="${allDataforMatching?.listOfFundingAgency}"/>		
		
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
																params='[filename: "sanctionOrderMoUcopy",appFormId:"${formDetails?.id }",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
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
					</table>
					</td>
					</tr>
					</table>
					
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
					<span class="pull-left">${formDetails?.briefDescription}</span>
				</td>

			</tr>


		</table>	
					
		<table class="table table-bordered">

			<tr class="previewheading">
				<td class="text-center one"><b>8</b></td>
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
								<th>Quantity of biological resources</th>
								<th>Time span in which the biological</th>
								<th>Traditional use, if any</th>
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
		
				
			<tr class="previewheading">
			<td></td>
				<td class="text-center"><b>(ii)</b></td>
				<td colspan="3"><span class="pull-left"><b>Duration of Research</b></span></td>
			</tr>

			<%  num= 1 %>
			<%  alph = 65 %>
			<tr class="">
				<td width="5%"></td>
				<td></td>
				<td>
					
					<b>From:</b>  ${formDetails?.researchDurationFrom?.format('dd/MM/yyyy') }
				
				</td>
				<td colspan="2">
					<b>To</b>: ${formDetails?.researchDurationTo?.format('dd/MM/yyyy') }
				</td>
			</tr>
			
			<tr>
				<td width="5%"></td>
				<td></td>
				<td>
					
					<b>Type of exercise:</b>  
				
				</td>
				<td colspan="2">
					<g:if test="${formDetails?.typeOfExercise == 'multipleTime'}">
						Multiple-time Exercise
					</g:if>
					<g:else>
						One-time Exercise
					</g:else>
				</td>
			</tr>
			
			<g:if test="${formDetails?.typeOfExercise == 'multipleTime'}">
					<tr>
						<td width="5%"></td>
						<td colspan="2">
							
							<b>How many times going to send /carry the biological resources?</b>  
						
						</td>
						<td colspan="2">
							${formDetails?.numOfTimesOfSending }
						</td>
					</tr>
					
					<tr>
						<td width="5%"></td>
						<td colspan="2">
							
							<b>Explain the reasons for sending /carrying the multiple times</b>  
						
						</td>
						<td colspan="2">
							${formDetails?.reasonsForSending }
						</td>
					</tr>
			</g:if>


	
		
		
		
			<tr>
				<td></td>
				<td class="text-center"><b>(iii)</b></td>
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
		</table>
		

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
					<span class="pull-left">${formDetails?.emergencyDetails }</span>
				</td>

			</tr>
		</table>


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
								id="${formDetails?.id}" target="_blank"
								params='[filename: "undertakingCopy", dataName: "undertakingCopy",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
								${formDetails?.undertakingCopyFileName}
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
								id="${formDetails?.id}" target="_blank"
								params='[filename: "declarationByApplicantOnNationalityCopy", dataName: "declarationByApplicantOnNationalityCopy",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
								${formDetails?.declarationByApplicantOnNationalityCopyFileName}
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
								id="${formDetails?.id}" target="_blank"
								params='[filename: "declarationBySupervisorCopy", dataName: "declarationBySupervisorCopy",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
								${formDetails?.declarationBySupervisorCopyFileName}
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
								id="${formDetails?.id}" target="_blank"
								params='[filename: "declarationByRecipientCopy", dataName: "declarationByRecipientCopy",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
								${formDetails?.declarationByRecipientCopyFileName}
							</g:link>
							</b>
						</span>
					</td>
				</tr>
		</table>