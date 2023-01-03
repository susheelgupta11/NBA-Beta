<div class="table-responsive">
	<table class="table table-bordered datatable">

		<thead>
			<tr>
				<th>S.No.</th>
				<g:if test="${formType == 'Form1' || formType == 'FormB' }">
				<th>Type of access</th>
				</g:if>
				<g:elseif test="${formType == 'Form3' }">
					<th>Accessed</th>
				</g:elseif>
				<g:elseif test="${formType == 'Form2' || formType == 'Form4'}">
				<th>Used</th>
				</g:elseif>
				<th>Common Name</th>
				<th>Scientific Name</th>
				<th>Nature of Biological Resource</th>
				<th>Part of Biological Resource</th>
				<th>Quantity of Biological Resource</th>
				<g:if test="${formType == 'Form1' && formType != 'Form4'}">
					<th>Quantity of Resource</th>
				</g:if>

				<g:if
					test="${formType == 'Form1' && formType !='Form4' && formType != 'Form2'}">
					<th>Time span</th>
					<th>Traditional use</th>
				</g:if>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<g:if test="${listOfBioResources}">
				<%int i=1 %>
				<g:each in="${listOfBioResources}" var="bioResource">
					<tr>
						<td scope="row"><%=i %></td>
						<%i++ %>
                        <td>${bioResource?.accessIntention}</td>
						<g:if
							test="${bioResource?.accessIntention == 'Sent for the Research' || bioResource?.accessIntention == 'Carried along for the research' }">
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
								${bioResource?.quantity} ${bioResource?.qtyUnit }
							</td>
						</g:if>
						<g:else>
							<td scope="row">N/A</td>
							<td scope="row">N/A</td>
							<td scope="row">N/A</td>
							<td scope="row">N/A</td>
						</g:else>



						<g:if test="${formType == 'Form1' && formType != 'Form4' }">

							<g:if
								test="${bioResource?.accessIntention == 'Biological Resources' || bioResource?.accessIntention == 'Biological Resources & Traditional Knowledge' || bioResource?.accessIntention == 'Associated Knowledge'}">
								<td scope="row">
									${bioResource?.quantity} ${bioResource?.qtyUnit}
								</td>
							</g:if>
							<g:else>
								<td scope="row">N/A</td>
							</g:else>

						</g:if>

						<g:if
							test="${formType == 'Form1' }">
							<td scope="row">
								${bioResource?.fromTime?.format('dd/MM/yyyy')} - ${bioResource?.toTime?.format('dd/MM/yyyy')}
							</td>

							<td scope="row">
								${bioResource?.traditionalUse}
							</td>


						</g:if>

						<td><g:remoteLink controller="formB"
								action="editFormBPart4" update="updateBioResourceForm" onComplete="hideShowOnEdit()"
								params='[bioResourceId:bioResource?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
								<img src="../images/edit.png" width="16" height="16" alt="edit"
									title="edit" />
							</g:remoteLink> <g:remoteLink controller="applicationManagement"
								action="deleteBioProfile" onSuccess="loadPage()" update="updateBioResources"
								params='[bioResourceID:bioResource?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
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
				</tr>

			</g:else>
		</tbody>

	</table>
</div>
