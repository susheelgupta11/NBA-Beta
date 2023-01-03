<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="applicant"/>
<title>NBA</title>
</head>
<body>
	<script>
		$(document).ready(function(){
			CKEDITOR.replace('editor1');
			$( "div.success" ).fadeIn( 300 ).delay( 3000 ).fadeOut( 400 );
		});
	</script>
	<div class="content-wrapper">
		<div class="container col-lg-12">
			<div class="row" id="row-main">
				<div class="col-md-12" id="content">
				
					<div class="col-sm-12">
						<div class="panel panel-default">
							<div class="panel-body message">
							 <g:if  test="${message}">
				<div class="alert-box success">${message}</div>
				</g:if>
								<g:form controller="Applicant" action="sendToNBA"
									enctype="multipart/form-data" method="POST">

									<g:render template="/applicant/communicationBox"></g:render>

									<g:actionSubmit value="Send to NBA"
										class="btn btn-primary pull-right" action="sendToNBA" />
								</g:form>
								<g:if test="${message}">
									<span style="color: green; text-shadow: orange;"><b>
											${message}
									</b></span>
								</g:if>

							</div>
						</div>
					</div>
				</div>
				<g:render template="/applicant/rightPane"></g:render>
			</div>

		</div>
	</div>
</body>
</html>