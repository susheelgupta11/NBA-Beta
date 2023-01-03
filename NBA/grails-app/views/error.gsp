<!DOCTYPE html>
<html>
	<head>
		<title><g:if env="development">Grails Runtime Exception</g:if><g:else>Error</g:else></title>
		<meta name="layout" content="main">
		<g:if env="development"><asset:stylesheet src="errors.css"/></g:if>
	</head>
	<body>
		<g:if env="development">
			<g:renderException exception="${exception}" />
		</g:if>
		<g:else>
			<div class="text-center margintop" >
				<span class="customfontsize1">
					<b>Welcome to NBA Beta</b> 
				</span><br/>
				<span class="customfontsize2"><b>The page you looking having an technical issue</b></span><br/>
				
				<span class="customfontsize3"><b>Please talk to the development team and if possible share an screenshot</b></span>
			</div>	
			<div class="text-center" style="margin-top: 20px;"> 
				
				<g:link controller="loggedInAs" action="inbox"><button class="btn">Back to Home</button></g:link>
				
			</div>
		</g:else>
	</body>
</html>
