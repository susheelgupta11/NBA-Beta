<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name='layout' content="dashPage" />
<title>NBA</title>
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
			<div id="costum-lft" class="col-sm-12">
		       <g:if test="${message}">
					<div class="alert-box success">${message}</div>	
				</g:if>
			<g:form  enctype='multipart/form-data' controller="agenda" action="updateAgenda" method="POST">
			<div class="col-sm-12 rightdiv">
				<div class="col-sm-9">
			<img src="${resource(dir: 'images', file: 'Logo1.jpg')}" alt="logo"
				class="img-responsive pull-left" />
		</div>
					<g:render template="/agenda/formAgenda"></g:render>
				
				<g:hiddenField name="agendaInstane" value="${agendaInstance?.id}"/>
				<g:hiddenField name="instance" value="${formDetails?.id}"/>
				<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
				<g:hiddenField name="sts"  value="${status}"/>
				
				<g:if test="${status == 'draft'}">
				<g:actionSubmit value="Send for Approval" action="sendForApproval" class="btn btn-primary pull-right" style="margin:5px;"/>
				<g:actionSubmit value="Update Agenda" action="updateAgenda" class="btn btn-primary pull-right" style="margin:5px;"/>
				</g:if>
				<g:elseif test="${status == 'approve' }">
				<g:actionSubmit value="Approved" action="sendAgendaEC" class="btn btn-primary pull-right" style="margin:5px;"/>
				<g:actionSubmit value="Review and Re-submit" action="updateAgenda" class="btn btn-primary pull-right" style="margin:5px;"/>
				</g:elseif>
                 </div>
				</g:form>
			
<%--				   <div class="col-sm-12 form-group">--%>
<%--			--%>
<%--	  <table class="not-com" style="margin-left:10px;">--%>
<%--		<tbody>--%>
<%--			<tr>--%>
<%--				<th style="width: 100%; background-color: #3c8dbc; color: #fff;">Note/Comments</th>--%>
<%--			</tr>--%>
<%--			<tr>--%>
<%--				<td>--%>
<%--													<div id="editor" class="form-group">--%>
<%--													<g:textArea name="comments" id="editor1">--%>
<%--													</g:textArea>--%>
<%--													</div>--%>
<%--					</td>--%>
<%--				<td style="display: inline-block;"><table class="template">--%>
<%--						<tbody>--%>
<%--							<tr>--%>
<%--								<th style="background-color: #3c8dbc; color: #fff;">Templates</th>--%>
<%--							</tr>--%>
<%--						</tbody>--%>
<%--					</table>--%>
<%--					<div class="main-tbs">--%>
<%--					<g:render template="/dashboard/quriesBox"></g:render>--%>
<%--					</div>--%>
<%--					</td>--%>
<%--					</tr>--%>
<%--					</tbody>--%>
<%--					</table>--%>
<%--					<g:form controller="Agenda" action="forwardAgendaWithApplication"  method="post"  onsubmit="return getData()">--%>
<%--						<g:render template="/common/fileForwordBox"></g:render>--%>
<%--						<g:hiddenField name="applicationInstance" value="${formDetails?.id}" />--%>
<%--						<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt }"/>--%>
<%--						--%>
<%--						</g:form>--%>
<%--					</div>--%>
                 </div>
     
			<g:render template="/rightPane/matchdata"></g:render>
		</div>
	</div>
	
</body>
</html>