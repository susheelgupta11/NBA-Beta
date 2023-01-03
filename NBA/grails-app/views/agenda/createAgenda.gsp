<%@ page contentType="text/html;charset=UTF-8"%>
<%! import org.nba.application.FormCategory %>
<%! import org.nba.application.ApplicationForm1 %>
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
		<div class="col-sm-12 rightdiv">

		       <g:if test="${message}">
					<div class="alert-box success">${message}</div>	
					</g:if>
			<g:form controller="Agenda" action="saveAgenda" method="post">
				
							<div id="costum-lft" class="col-sm-12">
			  <div class="col-sm-9">
			<img src="${resource(dir: 'images', file: 'Logo1.jpg')}" alt="logo"
				class="img-responsive pull-left" />
		</div>
					<g:render template="/agenda/formAgenda"></g:render>
				
				<g:hiddenField name="instance" value="${formDetails?.id}"/>
				<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
				<g:hiddenField name="flag" value="1"/>
				<g:if test="${agendaInstance == null || agendaInstance == ''}">
				<g:submitButton name="Save as Draft" class="btn btn-primary pull-right" style="margin: 7px;"/>
				</g:if>
		
				</div>
				</g:form>
				
				
<%--				   <div class="col-sm-12 form-group">--%>
<%--			--%>
<%--	  <table class="not-com">--%>
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