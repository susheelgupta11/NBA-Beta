		<table class="table table-bordered datatable">
			<tr class="previewheading">
				<td class="text-center"><b>(7)</b></td>
				<td colspan="4"><b>Details of any national institution
						which will participate in the Research & Development activities</b></td>
			</tr>

			<tr>
				<td class="one"></td>

				<td class="text-center one"><b>(i)</b></td>
				<td class="fifty">Is there any such participation</td>
				<td class="text-center one"><b>:</b></td>
			<g:if test="${formDetails?.instituteParticipation == 'true' }">	
				<td>Yes</td>
			</g:if>	
			<g:else>
				<td>No</td>
			</g:else>
			</tr>
<g:if test="${formDetails?.instituteParticipation == 'true' }">	
			<tr>
				<td></td>

				<td class="text-center"><b>(ii)</b></td>
				<td>Provide the name and contact details of the institution /
					organization participating in R & D</td>
				<td class="text-center"><b>:</b></td>
				<td>
				<g:if test="${formDetails?.instituteParticipation == 'true' }">	
					${formDetails?.detailsOfInstitute}
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
				<td><g:if test="${formDetails?.letterOfintent}">
										<g:link controller="applicationManagement" action="showAppDc"
											id="${formDetails?.id}" target="_blank"
											params='[filename: "letterOfIntentName", dataName: "letterOfIntentName",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
											${formDetails?.letterOfIntentName}
										</g:link>
								
									</g:if>
									<g:else>
									<span>N/A</span>
											</g:else>		
									</td>
			</tr>
</g:if>
			

			
	
	
<%--	<g:each in="${quesAnswerMap}" var="mapKeyValue">--%>
<%--		<tr class="previewheading">--%>
<%--				<td class="text-center"><b>${mapKeyValue?.getKey()?.questionNo}</b></td>--%>
<%--				<td colspan="4"><b>${mapKeyValue?.getKey()?.question}</b></td>--%>
<%--		</tr>--%>
<%--			<tr>--%>
<%--				<td></td>--%>
<%--				<td colspan="2"></td>--%>
<%--				<td class="text-center"><b>:</b></td>--%>
<%--				<g:if test= "${mapKeyValue?.getValue()?.answer}">--%>
<%--					<td>${mapKeyValue?.getValue()?.answer}</td>--%>
<%--				</g:if>--%>
<%--				<g:else>--%>
<%--					<td>Details in 100 words</td>--%>
<%--				</g:else>--%>
<%--			</tr>--%>
<%--		</g:each>--%>

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
			<g:if test="${formDetails?.isBenefitSharing?.equals('true')}">	
				<td> Yes</td>
			</g:if>
			<g:elseif test="${formDetails?.isBenefitSharing?.equals('false') }">
				<td> No</td>
			</g:elseif>
			<g:else>
				<td>N/A</td>
			</g:else>	
			</tr>


			<g:if test="${formDetails?.isBenefitSharing?.equals('true')}">	
				<tr>
					<td></td>
					<td><b>(ii)</b></td>
					<td>If yes, attach a copy of mutually agreed terms between the
						applicant and the provider of biological resource(s) and / or
						associated traditional knowledge, if any</td>
	
					<td class="text-center"><b>:</b></td>
					<td><g:if test="${formDetails?.sharingDoc}">
										<g:link controller="applicationManagement" action="showAppDc"
											id="${formDetails?.id}" target="_blank"
											params='[filename: "sharingDocName", dataName: "sharingDocName",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
											${formDetails?.sharingDocName}
										</g:link>
									</g:if>
									<g:else>
										N/A
									</g:else>
									</td>
				</tr>
			</g:if>
			
			
			
			
			
			<g:if test="${formDetails?.companyProfiles?.size() != 0 }">	
					<tr>
						<td></td>
						<td><b>(ii)</b></td>
						<td>Do you intend to pay the benefit sharing in the form of</td>
		
						<td class="text-center"><b>:</b></td>
						<td><g:if test="${formDetails?.payBenefitSharing == 'Monetary' }">
											Monetary
							</g:if>
							<g:elseif test="${formDetails?.payBenefitSharing == 'Non-Monetary' }">
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
						<td><g:if test="${formDetails?.isMonetary == 'purchasePrice' }">
									Purchase price of biological resource 
							</g:if>
							<g:elseif test="${formDetails?.isMonetary == 'exFactorySale' }">
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
				<g:if test= "${formDetails?.otherInfo }">
					<td>${formDetails?.otherInfo }</td>
				</g:if>
				<g:else>
					<td>Details in 100 words</td>
				</g:else>
			</tr>
			
	
			
			<g:if test="${formDetails?.isTradingPurpose?.equals('true')}">
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
								<g:if test="${formDetails?.biologicalResources}">
									<%int i=1 %>
									<g:each in="${formDetails?.biologicalResources}" var="bioResource">
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
			
				<g:if test= "${formDetails?.conditionOfAbs == true }">
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
				<g:if test= "${formDetails?.infromationTrue == true }">
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

				<g:if test= "${formDetails?.approvalOfNba == true }">
				<tr>
				<td></td>
				<td class="one text-center"><input type="checkbox" checked="checked" disabled="disabled"/></td>
				<td colspan="3">I understood to obtain the approval of the NBA/SBB before making any change in the stated purpose.</td>
				
				</tr></g:if>
				<g:if test= "${formDetails?.recordsWithTheNba == true }">
				<tr>
				<td></td>
				<td class="one text-center"><input type="checkbox" checked="checked" disabled="disabled"/></td>
				<td colspan="3">I undertake to furnish/share the relevant records with the NBA / SBB, as and when required.</td>
				</tr></g:if>
				<g:if test= "${formDetails?.infromationTrue == true }">
				<tr>
				<td></td>
				<td class="one text-center"><input type="checkbox" checked="checked" disabled="disabled"/></td>
				<td colspan="3">I further declare that the information provided in the form is true and correct and I shall be liable for any incorrect / wrong 
information and wilfull suppression of the facts.</td>
			</tr>	</g:if>

			</g:if>

		</table>