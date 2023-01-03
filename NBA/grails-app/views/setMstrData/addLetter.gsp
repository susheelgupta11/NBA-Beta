<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="superAdmin"/>
<title>NBA</title>
</head>
<body>
 	<script>
		$(document).ready(function() {
			CKEDITOR.replace('editor2');
		});
	</script>
	<div class="content-wrapper">
		<div class="col-sm-12 paddingleft">
			<div id="costum-lft" class="col-sm-12">
				<div class="col-sm-12 rightdiv" style="padding-top: 0px;">
					<div class="col-sm-12">
						<div class="panel panel-default">
							<div class="panel-body message" style="margin-left: 20px;">

								<g:form controller="setMstrData" action="letterTempleteSave">
									<div>
										<input type="text" class="form-control" name="letterName" value="${letterTemInstance?.letterName}"
											required="required" placeholder="Write the Letter Name">
									</div>

									<br />
									<div id="editor" class="form-group">
										<g:textArea name="templateLetter" id="editor2" value="${letterTemInstance?.templateLetter}"/>
									</div>
									<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
									<g:hiddenField name="letterInstance" value="${letterTemInstance?.id}"/>
									<g:if test="${letterTemInstance}"><g:submitButton name="Update" class="btn btn-primary pull-right"/></g:if>
									<g:else> <g:submitButton name="Add" class="btn btn-primary pull-right"/></g:else>
                                   
								</g:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>