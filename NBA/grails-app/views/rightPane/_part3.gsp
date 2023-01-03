	<table class="table table-bordered">




			<tr>
				<td></td>
				<td class="one"><b>(3)</b></td>
				<td><b>Description / nature of traditional knowledge (oral
						/ documented)</b></td>
				<td><b>:</b></td>
				<td>
					${formDetails?.nature}
				</td>
			</tr>
		<g:if test= "${formDetails?.nature != 'No' }">
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
				<td><b>(4)</b></td>
				<td colspan="3"><b>Geographical location of the community / individual</b></td>
<%--				<td class="text-center"><b>:</b></td>--%>
<%--				<td>geoLocation?.consentObtained</td>--%>
			</tr>
			
		<g:if test= "${formDetails?.nature == 'No' }">	
			<tr>
				<td></td>
				<td></td>
				<td>(i) Consent obtained from the community / individual</td>
				<td><b>:</b></td>
				<td>
					${formDetails?.nature}
				</td>
			</tr>
		</g:if>	

		<g:if test= "${formDetails?.nature != 'No' }">
		  <g:if test= "${allDataforMatching?.listOfCommunityLocations }">
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
							<g:if test="${allDataforMatching?.listOfCommunityLocations}">
								<%int a=1 %>
								<g:each in="${allDataforMatching?.listOfCommunityLocations}" var="location">
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
		
		<g:if test= "${formDetails?.selfAuthorizedPerson }">	
			<tr>
				<td></td>
				<td><b>(5)</b></td>
				<td><b>Name and Number of the persons authorized by the
						applicant for making selection</b></td>
				<td class="text-center"><b>:</b></td>
					<td>Self</td>
			</tr>
		</g:if>	
		<g:else>	
			<tr>
				<td></td>
				<td><b>(5)</b></td>
				<td colspan="3"><b>Name and Number of the persons authorized by the
						applicant for making selection</b></td>
<%--				<td class="text-center"><b>:</b></td>--%>
<%--				<g:if test= "${formDetails?.selfAuthorizedPerson }">--%>
<%--					<td>Self</td>--%>
<%--				</g:if>--%>
<%--				<g:else>--%>
<%--					<td>${formDetails?.contactPerson }</td>--%>
<%--				</g:else>--%>
			</tr>
		</g:else>	
			
			<g:if test= "${!formDetails?.selfAuthorizedPerson }">
			<g:if test= "${allDataforMatching?.listOfContactPerson }">
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
				<g:each in="${allDataforMatching?.listOfContactPerson}" var="profile">
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
				<td class="text-center"><b>(6)</b></td>
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
				<td>${formDetails?.purposeOfProposal}</td>
			</tr>

			<tr>
				<td></td>

				<td class="text-center"><b>(ii)</b></td>
				<td>A brief description of the research or bio-survey and
					bio-utilization or commercial utilization expressing the scope /
					intention and purpose / goals / commercial outlook</td>
				<td class="text-center"><b>:</b></td>
				<td>${formDetails?.briefDescription}</td>
			</tr>

			<tr>
				<td></td>

				<td class="text-center"><b>(iii)</b></td>
				<td>Whether any collection of the resource endangers any
					component of biological diversity and the risks which may arise
					from the access.</td>
				<td class="text-center"><b>:</b></td>
			<g:if test= "${formDetails?.isRisky == 'true' }">
				<td>Yes</td>
			</g:if>
			<g:else>
				<td>No</td>
			</g:else>	
			</tr>
			<g:if test= "${formDetails?.isRisky == 'true' }">
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td class="text-center"><b>:</b></td>
				<td>${formDetails?.riskInvolved}</td>
			</tr>
			</g:if>
			
		</table>
