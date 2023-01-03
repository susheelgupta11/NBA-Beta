<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="dashPage" />
<title>NBA</title>
<style>
.remark {
	color: blue;
}
</style>

</head>
<body>

	<script>
		$(document).ready(function() {
<%--			CKEDITOR.replace('editor1');--%>
			$( "div.success" ).fadeIn( 300 ).delay( 3000 ).fadeOut( 400 );
		});
	</script>

	<g:if test="${formRemkInstance?.threeTwocheck == false}">
		<g:javascript>
 $(document).ready(function() {showText();});	
 </g:javascript>
	</g:if>
	<g:if test="${formRemkInstance?.sevncheck == false }">
		<g:javascript>
$(document).ready(function() {show();});
</g:javascript>
	</g:if>
	<div class="content-wrapper">
		<div class="col-sm-12 paddingleft">
			<div id="costum-lft" class="col-sm-12">
			<g:if test="${message}">
				<div class="alert-box success">${message}</div>	
					</g:if>
				<div class="col-sm-12 rightdiv">
					<g:form controller="checklist" action="legalFormRemarkSave">
						<g:if test="${subForm == "1" }">
							<g:render template="f1legalReview"></g:render>
						</g:if>
						<g:elseif test="${subForm == "2"}">
							<g:render template="f2legalReview"></g:render>
						</g:elseif>
						<g:elseif test="${subForm == "3"}">
							<g:render template="f3legalReview"></g:render>
						</g:elseif>
						<g:elseif test="${subForm == "4"}">
							<g:render template="f4legalReview"></g:render>
						</g:elseif>
						<g:elseif test="${subForm == "B"}">
							<g:render template="fBlegalReview"></g:render>
						</g:elseif>

						<g:hiddenField name="formTpe" value="${subForm}" />
						<g:hiddenField name="frmId" value="${formDetails?.id}" />
						<g:hiddenField name="listId" value="${formId}" />
						<g:hiddenField name="checkInstance"
							value="${formRemkInstance?.id}" />
						<g:hiddenField name="csrfPreventionSalt"
							value="${csrfPreventionSalt }" />
						<g:hiddenField name="select" id="setAllSelect" value="" />
						<g:hiddenField name="counterVal" id="setCounter" value="" />

						<input type="submit" class="btn btn-primary pull-right"
							value="Save" onclick="setAllData()"  style="margin-bottom: 1%;"/>
					</g:form>

<%--					<div class="col-sm-12 form-group">--%>
<%--						<table class="not-com" style="margin-left: 10px;">--%>
<%--							<tbody>--%>
<%--								<tr>--%>
<%--								<th style="width: 100%; background-color: #3c8dbc; color: #fff;">Note/Comments</th>--%>
<%--								</tr>--%>
<%--								<tr>--%>
<%--									<td>--%>
<%----%>
<%--										<div id="editor" class="form-group">--%>
<%--											<g:textArea name="comments" id="editor1">--%>
<%--											</g:textArea>--%>
<%--										</div>--%>
<%----%>
<%--									</td>--%>
<%--									<td style="display: inline-block;"><table class="template">--%>
<%--											<tbody>--%>
<%--												<tr>--%>
<%--													<th style="background-color: #3c8dbc; color: #fff;">Templates</th>--%>
<%--												</tr>--%>
<%--											</tbody>--%>
<%--										</table>--%>
<%--										<div class="main-tbs">--%>
<%--											<g:render template="/dashboard/quriesBox"></g:render>--%>
<%--										</div></td>--%>
<%--								</tr>--%>
<%--							</tbody>--%>
<%--						</table>--%>
<%--						<g:form controller="checklist" action="saveLegalComment"--%>
<%--							enctype="multipart/form-data" method="post"--%>
<%--							onsubmit="return getData()">--%>
<%--							<g:render template="/dashboard/addnotes"></g:render>--%>
<%--							<g:hiddenField name="formType" value="${formType}" />--%>
<%--							<g:hiddenField name="applicationInstance" value="${formId}" />--%>
<%--							<g:hiddenField name="csrfPreventionSalt"--%>
<%--								value="${csrfPreventionSalt }" />--%>
<%--							<g:hiddenField name="flag" value="1" />--%>
<%--						</g:form>--%>
<%--					</div>--%>
				</div>
			</div>
			<g:render template="/rightPane/matchdata"></g:render>
		</div>
	</div>

	<script>
		function showText() {
			document.getElementById('remarkthreeTwo').style.display = 'block';
			document.getElementById('yesthreeTwo').checked = false;
		}
		function hideText() {
			document.getElementById('remarkthreeTwo').style.display = 'none';
			document.getElementById('remarkthreeTwo').value = '';
			document.getElementById('nothreeTwo').checked = false;
		}

		function show() {
			document.getElementById('remarksevn').style.display = 'block';
			document.getElementById('yessevn').checked = false;
		}
		function hide() {
			document.getElementById('remarksevn').style.display = 'none';
			document.getElementById('remarksevn').value = '';
			document.getElementById('nosevn').checked = false;
		}
	</script>


</body>
</html>