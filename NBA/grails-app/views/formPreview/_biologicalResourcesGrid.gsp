					<table class="table table-bordered datatable">
					
						<thead>
							<tr>
								<th>Sl.No.</th>
								<th>Common Name</th>
								<th>Scientific Name</th>
								<th>Nature of Biological Resource</th>
								<th>Part of Biological Resource</th>
								<g:if test="${formType != 'Form3' && formType != 'Form2'}">
								<th>Quantity of Resource</th>
								</g:if>
								<g:if test="${formType != 'Form4'}">
<%--								<th>Source of access</th>--%>
								</g:if>
								<g:if test="${formType != 'Form3' && formType !='Form4' && formType != 'Form2'}">
								<th>Time span</th>
								<th>Traditional use</th>
								</g:if>
							
							</tr>
						</thead>
						<tbody>
						<g:if test="${listOfBioResources}">
						<%int i=1 %>
						<g:each in="${listOfBioResources}" var="bioResource">
							<tr>
								<td scope="row"><%=i %></td>
								<%i++ %>
								<td scope="row">${bioResource?.commonName}</td>
								<td scope="row">${bioResource?.scientificName}</td>
								<td scope="row">${bioResource?.nature}</td>
								<td scope="row">${bioResource?.biologicalResource}</td>
								<g:if test="${formType != 'Form3' &&  formType != 'Form2'}">
								<td scope="row">${bioResource?.quantity} ${bioResource?.qtyUnit}</td>
								
								</g:if>
<%--								<g:if test="${formType != 'Form4'}">--%>
<%--								<td scope="row">${bioResource?.source}</td>--%>
<%--								</g:if>--%>
								<g:if test="${formType != 'Form3' && formType != 'Form4' && formType != 'Form2'}">
								<td scope="row">${bioResource?.fromTime?.format('dd/MM/yyyy')} - ${bioResource?.toTime?.format('dd/MM/yyyy')}</td>
								<td scope="row">${bioResource?.traditionalUse}</td>
								</g:if>
								
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
							</tr>
						
						</g:else>
						</tbody>
						
					</table>
