<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="dashPage" />
<title>NBA</title>

<style type="text/css">
.remark{color: blue;}

</style>
</head>
<body>
<script>
$(document).ready(function () {
<%--CKEDITOR.replace('editor1');--%>
$( "div.success" ).fadeIn( 300 ).delay( 3000 ).fadeOut( 400 );
});
</script>




	<div class="content-wrapper">
		<div class="col-sm-12 paddingleft">
<%--			<div id="costum-lft" class="col-sm-12">--%>
			<g:if test="${message}">
				<div class="alert-box success">${message}</div>	
					</g:if>
				<div class="col-sm-12 rightdiv">
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
						<g:hiddenField name="listId" value="${formDetails?.id}" />
						<g:hiddenField name="checkInstance" value="${formRemkInstance?.id}" />
						<g:hiddenField name="formType" value="${formType}" />
						<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
						<%--<g:hiddenField name="applicationInstance" value="${formRemkInstance?.id}" />--%>
						<div class="col-sm-12 form-group">
							<input type="submit" name="Update"
								class="btn btn-primary pull-right" value="Update" />
							
							<g:link  class="btn btn-primary pull-right"
							action="technicalCheckList" target="_blank"
							params="${[remark:formRemkInstance?.id,instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]}" style="margin-right: 15px;">Generate Pdf</g:link>
						
<%--						<g:link  class="btn btn-primary pull-right"--%>
<%--							action="testPdf" target="_blank"  style="margin-right: 15px;">Test Pdf</g:link>--%>
						
						</div>                                                                                 
						
					</g:form>
					
					
					
<%--					<div class="col-sm-12 form-group">--%>
<%--						<table class="not-com" style="margin-left: 10px;">--%>
<%--							<tbody>--%>
<%--								<tr>--%>
<%--							<th style="width: 100%; background-color: #3c8dbc; color: #fff;">Note/Comments</th>--%>
<%--								</tr>--%>
<%--								<tr>--%>
<%--									<td>--%>
<%----%>
<%--													<div id="editor" class="form-group">--%>
<%--													<g:textArea name="comments" id="editor1">--%>
<%--													</g:textArea>--%>
<%--													</div>--%>
<%----%>
<%--										</td>--%>
<%--									<td style="display: inline-block;"><table class="template">--%>
<%--											<tbody>--%>
<%--												<tr>--%>
<%--												 <th style="background-color: #3c8dbc; color: #fff;">Templates</th>--%>
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
<%--							enctype="multipart/form-data" method="post"  onsubmit="return getData()">--%>
<%--							<g:render template="/dashboard/addnotes"></g:render>--%>
<%--							<g:hiddenField name="formType" value="${formType}" />--%>
<%--							<g:hiddenField name="checkInstance" value="${formRemkInstance?.id}"/>--%>
<%--				            <g:hiddenField name="applicationInstance" value="${formId}" />--%>
<%--							<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>--%>
<%--							<g:hiddenField name="flag" value="2"/>--%>
<%--						</g:form>--%>
<%--					</div>--%>
				</div>
				<g:render template="/rightPane/matchdata"></g:render>
			</div>
			
		</div>
<%--	</div>--%>

</body>
</html>