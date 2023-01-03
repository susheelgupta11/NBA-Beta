<div class="table-responsive">
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
								<th>Action</th>
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
								<td>
							<g:remoteLink controller="applicationManagement" onSuccess="ReadonlyRecode_Edit()"
						action="editGeoLocation" update="geographicalLocationForm" 
						params='[locationId:location?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
						<img src="../images/edit.png" width="16" height="16" alt="edit"
							title="edit" />
					</g:remoteLink> <g:remoteLink controller="applicationManagement"
						action="deleteGeoLocation" update="updateGeoLocation" onSuccess="loadPage()"
						params='[locationId:location?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
						<img src="../images/delete.png" width="16" height="16"
							alt="delete" title="delete" />
					</g:remoteLink></td>
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
					</div>