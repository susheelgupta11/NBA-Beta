<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta name="layout" content="superAdmin">
		<g:set var="entityName" value="${message(code: 'nbaUser.label', default: 'NbaUser')}" />
		<title>NBA</title>
	</head>
	<body>
	
	<script>
$(document).ready(function () {

$( "div.failure" ).fadeIn( 300 ).delay( 3000 ).fadeOut( 400 );
});
</script>
	 <div class="content-wrapper">
             
		<div id="create-nbaUser" class="content scaffold-create" role="main">
         <g:form controller="nbaUser", action ="save" method="POST" >
				<div class="container">
					<div class="row text-white">
						<div class="col-xl-5 col-lg-6 col-lg-offset-3 col-md-8 col-sm-10 mx-auto text-center form p-4 shadow"
						
							style="padding-top: 20px; padding-bottom: 20px;">
							<g:render template="form" />
							<g:actionSubmit class="btn btn-primary btn-lg" action="save"
								value="Create" />
						</div>
					</div>
				</div>

				<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>  
				</g:form>        

			</div>
			</div>
		
  
 
	</body>
</html>
