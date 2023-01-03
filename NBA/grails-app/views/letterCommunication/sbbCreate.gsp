<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="dashPage"/>
<title>NBA</title>
</head>

  <body>

	<script>
		$(document).ready(function() {
<%--			CKEDITOR.replace('editor1');--%>
			CKEDITOR.replace('editor2');
			$( "div.success" ).fadeIn( 300 ).delay( 3000 ).fadeOut( 400 );
		});
	</script>
	<div class="content-wrapper">
		<div class="col-sm-12 paddingleft">
			<div id="costum-lft" class="col-sm-12">
		                  <g:if test="${message}">
			 <div class="alert-box success">${message}</div>	
					    </g:if>
<%--				<div class="col-sm-12 rightdiv" style="padding-top: 0px;">--%>
					<div class="col-sm-12">
						<div class="panel panel-default">
							<div class="panel-body message" style="margin-left: 20px;">
							
								<g:form controller="letterCommunication"  action="sendForSbbApproval" enctype="multipart/form-data" method="POST">
									<g:render template="/letterCommunication/sbbckeditor"></g:render>
	                           <g:actionSubmit  class="btn btn-primary pull-right" style="margin-left: 15px;" 
								   value="Send for Approval" action="sendForSbbApproval"/>
								<g:actionSubmit value="Save as Draft" action="saveSbbLetter" class="btn btn-primary pull-right"/>

								</g:form>
										    
<%--								<div class="col-sm-12 form-group" style="margin-top: 10px;">--%>
<%--									<table class="not-com">--%>
<%--										<tbody>--%>
<%--											<tr>--%>
<%--											<th style="width: 100%; background-color: #3c8dbc; color: #fff;">Note/Comments</th>--%>
<%--											</tr>--%>
<%--											<tr>--%>
<%--												<td>--%>
<%--													<div id="editor" class="form-group">--%>
<%--														<g:textArea name="comment" id="editor1" />--%>
<%--													</div>--%>
<%----%>
<%--												</td>--%>
<%--												<td style="display: inline-block;">--%>
<%--													<table class="template">--%>
<%--														<tbody>--%>
<%--															<tr>--%>
<%--														<th style="background-color: #3c8dbc; color: #fff;">Templates</th>--%>
<%--															</tr>--%>
<%--														</tbody>--%>
<%--													</table>--%>
<%--													<div class="main-tbs">--%>
<%--														<g:render template="/dashboard/quriesBox"></g:render>--%>
<%--													</div>--%>
<%--												</td>--%>
<%--											</tr>--%>
<%--										</tbody>--%>
<%--									</table>--%>
<%--									<g:form action="forwardApplication"--%>
<%--										controller="letterCommunication">--%>
<%--										<g:hiddenField name="applicationInstance" value="${formDetails?.id}" />--%>
<%--										<g:hiddenField name="csrfPreventionSalt"--%>
<%--											value="${csrfPreventionSalt}" />--%>
<%--										<g:render template="/common/fileForwordBox"></g:render>--%>
<%--									</g:form>--%>
<%--								</div>--%>
<%--							</div>--%>
						</div>
					</div>
				</div>
			</div>
			<g:render template="/rightPane/matchdata"></g:render>
		</div>
	</div>

</body>

</html>