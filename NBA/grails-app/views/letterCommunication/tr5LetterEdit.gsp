
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name='layout' content='dashPage' />
<title>NBA</title>
</head>
<body>
<script>
$(document).ready(function () {
CKEDITOR.replace('editor1');
$( "div.success" ).fadeIn( 300 ).delay( 3000 ).fadeOut( 400 );
});
</script>
	<div class="content-wrapper">
		<div class="col-sm-12 paddingleft">
			<div id="costum-lft" class="col-sm-12">
			  <g:if test="${message}">
			 <div class="alert-box success">${message}</div>	
			  </g:if>
				<div class="col-sm-12 rightdiv">
					<div class="col-sm-12"></div>
					<div class="panel panel-default">
						<div class="panel-body message" style="padding: 0px !important">
							<div class="main-receipt"
								style="border: none; padding-left: 20px;">
								<g:form enctype='multipart/form-data' method='POST' controller="letterCommunication" action="tr5LetterSave">
									<g:render template="/letterCommunication/tr5"></g:render>
									<g:hiddenField name="instance" value="${formDetails?.id}" />
									<g:hiddenField name="receiptNo" value="${tr5ReceiptInstance?.receiptNo}" />
									<g:hiddenField name="tr5Instance" value="${tr5ReceiptInstance?.id}"/>
									<g:hiddenField name="csrfPreventionSalt"
										value="${csrfPreventionSalt}" />
									<div class="col-md-12 form-group" style="text-align: center">
									<g:if test="${status == 'true'}">
									<g:actionSubmit value="Send" class="btn btn-primary pull-right"  style="margin-left:15px" action="tr5ReceiptSent"/>
									<g:actionSubmit value="Resend to Draft" class="btn btn-primary pull-right" action="tr5LetterSave"/>
									</g:if>
									<g:else>
								<g:actionSubmit value="Move to Approval" class="btn btn-primary pull-right" action="moveForApproval" style="margin-left:15px"/>
								<g:actionSubmit value="Save as Draft" class="btn btn-primary pull-right" action="tr5LetterSave"/>
									</g:else>

										
									</div>
								</g:form>
								
								
								
<%--								<div class="col-sm-12 form-group" style="margin-top: 10px;">--%>
<%--									<table class="not-com">--%>
<%--										<tbody>--%>
<%--											<tr>--%>
<%--												<th style="width: 100%; background-color: #3c8dbc; color: #fff;">Note/Comments</th>--%>
<%--											</tr>--%>
<%--											<tr>--%>
<%--												<td>--%>
<%--													<div id="editor" class="form-group">--%>
<%--													<g:textArea name="comments" id="editor1">--%>
<%--													</g:textArea>--%>
<%--													</div>--%>
<%--												</td>--%>
<%--												<td style="display: inline-block;">--%>
<%--													<table class="template">--%>
<%--														<tbody>--%>
<%--															<tr>--%>
<%--												<th style="width: 100%; background-color: #3c8dbc; color: #fff;">Note/Comments</th>--%>
<%--															</tr>--%>
<%--														</tbody>--%>
<%--													</table>--%>
<%--													<div class="main-tbs">--%>
<%--														<g:render template="/dashboard/commentBox"></g:render>--%>
<%--													</div>--%>
<%--												</td>--%>
<%--											</tr>--%>
<%--										</tbody>--%>
<%--									</table>--%>
<%--									<g:form action="forwardApplication" controller="letterCommunication">--%>
<%--									<g:hiddenField name="applicationInstance" value="${formDetails?.id}"/>--%>
<%--									<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>--%>
<%--									<g:render template="/common/fileForwordBox"></g:render>--%>
<%--									</g:form>--%>
<%--								</div>--%>
							</div>
						</div>
					</div>
				</div>
			</div>
			<g:render template="/rightPane/matchdata"></g:render>
		</div>
	</div>
</body>
</html>