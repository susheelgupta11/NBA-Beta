
<table>
  <tr>
    <th>Doc name</th>
    <th>document</th>
    <th>Action</th>
  </tr>
  <%int i=1 %>
  <g:each in="${listOfdocs}" var="document">
  <tr>
  <g:uploadForm action="addDocument" autocomplete="off">
    <td>${document?.docName}</td>
    <td><g:if test="${document?.document}">
						<g:link controller="testData" action="viewDoc"
							id="${document?.id}" target="_blank"
							params="[filename: 'docName', dataName: 'docFormat',csrfPreventionSalt:'${csrfPreventionSalt}']">
							${document?.docName}
						</g:link>
					</g:if> <g:else>
						<input type="file" mb5="1" class="btnSave" name="DocumentFormat"
							id="docFormat" style="min-width: 160px" />
						<br />
						<b>(PDF Only)</b>
						<g:hiddenField name="docId" value="${document?.id}" />
					</g:else></td>
					<td><g:if test="${!document?.document}">
							<g:submitButton
								class="btn btn-primary ProjectInViewMode ButtonMargin ButtonPadding"
								name="update" value="SAVE" id="btnSave" />
						</g:if></td>
    </g:uploadForm>
  </tr>
  </g:each>
</table>




