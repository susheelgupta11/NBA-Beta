<html>
<head>
<meta name='layout' content='loggedInUser' />

<g:javascript>
		var menu5 = "${listOfdocs }"
</g:javascript>
<script>
	$(function() {
		ActiveClass("menu5");
	});
</script>
</head>
<body>
	<div class="container">
		<div class="col-sm-2">
			<g:render template="/manageContent/AdminLeftTab" />
		</div>

		<div class="col-sm-10">
			<table class="table table-bordered">
				<tr>
					<th class="center">Doc name</th>
					<th>Document</th>
					<th>Action</th>
				</tr>
				<%int i=1 %>
				<g:each in="${listOfdocs?.sort{it.id}}" var="document">
					<tr>
						<g:uploadForm action="addDocument" autocomplete="off">
							<td align="center">
								${document?.docName}
							</td>
							<td><g:if test="${document?.document}">
									<input type="file" mb5="1" class="btnSave"
										name="DocumentFormat" id="docFormat" style="min-width: 160px" />
									<g:hiddenField name="docId" value="${document?.id}" />

									<g:if
										test="${formatMessage && document?.id?.toString() == docId}">
										<p class="text-danger">
											<b>
												${flash.message }
											</b>
										</p>
									</g:if>
									<g:else>
										<g:link controller="testData" action="viewDoc"
											id="${document?.id}" target="_blank"
											params='[filename: "docName", dataName: "docFormat",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
											${document?.docName}
<%--												File.pdf--%>
										</g:link>
									</g:else>

								</g:if> <g:else>
									<input type="file" mb5="1" class="btnSave"
										name="DocumentFormat" id="docFormat" style="min-width: 160px" />
									<b>(PDF Only)</b>
									<p>
										${flash.message}
									</p>
									<g:hiddenField name="docId" value="${document?.id}" />
								</g:else></td>
							<td class="text-center">
								<%--					<g:if test="${!document?.document }">--%> <g:submitButton
									class="btn btn-primary ProjectInViewMode ButtonMargin ButtonPadding"
									name="update" value="SAVE" id="btnSave" /> <%--						</g:if>--%>
							</td>
						</g:uploadForm>
					</tr>
				</g:each>
			</table>
		</div>
		<div class="col-sm-12 text-center">
			<g:link controller="loggedInAs" action="inbox"
				class="btn btn-primary">Back</g:link>
		</div>
	</div>
	</div>
</body>
</html>



