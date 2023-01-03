<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="dashPage" />

<asset:link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.13/css/bootstrap-multiselect.css" />
<asset:link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

<title>NBA</title>
<style type="text/css">
.remark {
	color: blue;
}

body {
	padding: 15px;
}

.select-checkbox option::before {
	content: "\2610";
	width: 1.3em;
	text-align: center;
	display: inline-block;
}

.select-checkbox option:checked::before {
	content: "\2611";
}

.select-checkbox-fa option::before {
	font-family: FontAwesome;
	content: "\f096";
	width: 1.3em;
	display: inline-block;
	margin-left: 2px;
}

.select-checkbox-fa option:checked::before {
	content: "\f046";
}
</style>
</head>
<body>
	<g:if test="${formRemkInstance?.sbbBmc == true}">
		<g:javascript>
$(document).ready(function () {
 document.getElementById('selLoc').style.display = 'block';
});
</g:javascript>
	</g:if>

	<g:else>
		<g:javascript>
$(document).ready(function () {
document.getElementById('selLoc').style.display = 'none';
});
</g:javascript>
	</g:else>

	<script>
		$(document).ready(function() {
	<%--CKEDITOR.replace('editor1');--%>
		$("div.success").fadeIn(300).delay(3000).fadeOut(400);
		});
	</script>



	<div class="content-wrapper">
		<div class="col-sm-12 paddingleft">
			<div id="costum-lft" class="col-sm-12">
				<g:if test="${message}">
					<div class="alert-box success">
						${message}
						
					</div>
				</g:if>
				<div class="col-sm-12 rightdiv">
<%--				<g:link controller="checklist" action="dynamicPdfCustom">Custom Pdf</g:link>--%>
					<g:form controller="checklist" action="techFormRemarkSave">
						<g:if test="${subForm == "1" }">
							<g:render template="form1Review"></g:render>
						</g:if>
						<g:if test="${subForm == "2"}">
							<g:render template="form2Review"></g:render>
						</g:if>
						<g:if test="${subForm == "3"}">
							<g:render template="form3Review"></g:render>
						</g:if>
						<g:if test="${subForm == "4"}">
							<g:render template="form4Review"></g:render>
						</g:if>
						<g:if test="${subForm == "B"}">
							<g:render template="formBReview"></g:render>
						</g:if>
						<g:hiddenField name="formTpe" value="${subForm}" />
						<g:hiddenField name="frmId" value="${formDetails?.id}" />
						<g:hiddenField name="listId" value="${formId}" />
						<g:hiddenField name="checkInstance"
							value="${formRemkInstance?.id}" />
						<g:hiddenField name="formType" value="${formType}" />
						<g:hiddenField name="counterVal" id="setCounter" value="" />
						<g:hiddenField name="csrfPreventionSalt"
							value="${csrfPreventionSalt}" />

						<g:hiddenField name="bioResourceNumber"
							value="${formDetails?.biologicalResources.size()}" />
							
							<g:set var="loctionGio" value="${formDetails?.biologicalResources?.locations?.flatten()}" />
				
							
						<g:hiddenField name="locationNumber"
							value="${loctionGio.size()}" />
						<g:hiddenField name="contactNumber"
							value="${formDetails?.contactPersons.size()}" />



						<%--					<g:hiddenField name="applicationInstance" value="${formRemkInstance?.id}" />--%>
						<div class="col-sm-12 form-group">
							<input type="submit" name="Save"
								class="btn btn-primary pull-right" value="Save" />
						</div>

					</g:form>

					<%--					<div class="col-sm-12 form-group">--%>
					<%--						<table class="not-com" style="margin-left: 10px;">--%>
					<%--							<tbody>--%>
					<%--								<tr>--%>
					<%--									<th style="width: 100%; background-color: #3c8dbc; color: #fff;">Note/Comments</th>--%>
					<%--								</tr>--%>
					<%--								<tr>--%>
					<%--									<td>--%>
					<%--													<div id="editor" class="form-group">--%>
					<%--													<g:textArea name="comments" id="editor1">--%>
					<%--													</g:textArea>--%>
					<%--													</div>--%>
					<%----%>
					<%--										</td>--%>
					<%--									<td style="display: inline-block;"><table class="template">--%>
					<%--											<tbody>--%>
					<%--												<tr>--%>
					<%--								 <th style="background-color: #3c8dbc; color: #fff;">Templates</th>--%>
					<%--												</tr>--%>
					<%--											</tbody>--%>
					<%--										</table>--%>
					<%--										<div class="main-tbs">--%>
					<%--											<g:render template="/dashboard/quriesBox"></g:render>--%>
					<%--										</div></td>--%>
					<%--								</tr>--%>
					<%--							</tbody>--%>
					<%--						</table>--%>
					<%--						<g:form controller="checklist" action="saveTechComment"--%>
					<%--								enctype="multipart/form-data" method="post"  onsubmit="return getData()">--%>
					<%--								<g:render template="/dashboard/addnotes"></g:render>--%>
					<%--								<g:hiddenField name="formType" value="${formType}"/>--%>
					<%--								<g:hiddenField name="applicationInstance" value="${formId}" />--%>
					<%--								<g:hiddenField name="checkInstance" value="${formRemkInstance?.id}"/>--%>
					<%--								<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>--%>
					<%--								<g:hiddenField name="flag" value="1"/>--%>
					<%--							</g:form>--%>
				</div>
			</div>
			<g:render template="/rightPane/matchdata"></g:render>
		</div>
	</div>

	<script type="text/javascript">
		function locationSelect(evn) {
			var hidId = document.getElementById('selLoc');

			if (evn.value == 'true') {
				hidId.style.display = 'block';
			}

			else if (evn.value == 'false') {
				hidId.style.display = 'none';
			}
		}
	</script>

	<script src="https://code.jquery.com/jquery-2.2.0.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.13/js/bootstrap-multiselect.js"></script>

	<script type="text/javascript">
		$('select[multiple]').multiselect(
				{
					columns : 2,
					placeholder : 'Select options',
					onChange : function(element, checked) {
						var options = $('#mySelect option:selected');
						var selected = [];
						$(options).each(function(index, brand) {
							selected.push($(this).val());
						});
						console.log(selected);
						if (selected.length !== null) {
							var list = "";
							for (var i = 0; i < selected.length; i++) {
								list += list = !"" ? "</br>" + selected[i]
										: selected[i];
							}

							//console.log(list);
						}
						$('#demo').html(list);
					}
				});
	</script>

</body>
</html>