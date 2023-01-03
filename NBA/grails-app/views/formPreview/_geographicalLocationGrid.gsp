<table class="table table-bordered datatable">
						<thead>
							<tr>
								<th>S.No.</th>
								<th>Name of biological resource</th>
								<th>Source of access</th>
								<th>Village/ Panchayat</th>
								<th>Town/ Taluk</th>
								<th>District</th>
								<th>State</th>
								<th>Trader name</th>
								<th>Trader contact details</th>
							
							</tr>
						</thead>
						<tbody>
				<g:if test="${listOfLocations}">
						<%int i=1 %>
					<g:each in="${listOfLocations}" var="location">
						<tr>
								<td scope="row"><%=i %></td>
								<%i++ %>
							<g:if test= "${location?.bioResource?.scientificName }">
								<td scope="row">${location?.bioResource?.scientificName}</td>
							</g:if>
							<g:else>
								<td scope="row">N/A</td>
							</g:else>	
							<g:if test= "${location?.source}">
								<td scope="row">${location?.source}</td>
							</g:if>
							<g:else>
								<td scope="row">N/A</td>
							</g:else>
							<g:if test= "${location?.village}">
								<td scope="row">${location?.village}</td>
							</g:if>
							<g:else>
								<td scope="row">N/A</td>
							</g:else>
							<g:if test= "${location?.town}">
								<td scope="row">${location?.town}</td>
							</g:if>
							<g:else>
								<td scope="row">N/A</td>
							</g:else>
							<g:if test= "${location?.district}">
								<td scope="row">${location?.district}</td>
							</g:if>
							<g:else>
								<td scope="row">N/A</td>
							</g:else>	
							<g:if test= "${location?.state}">
								<td scope="row">${location?.state}</td>
							</g:if>
							<g:else>
								<td scope="row">N/A</td>
							</g:else>
							<g:if test= "${location?.traderName}">
								<td scope="row">${location?.traderName}</td>
							</g:if>
							<g:else>
								<td scope="row">N/A</td>
							</g:else>
							<g:if test= "${location?.traderContactDetails}">
								<td scope="row">${location?.traderContactDetails}</td>
							</g:if>
							<g:else>
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
								<td scope="row"></td>
								<td scope="row"></td>
							</tr>
						
				</g:else>
							
						</tbody>
					</table>