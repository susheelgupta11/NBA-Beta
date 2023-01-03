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
					<b>Sorry, its a</b> 
				</span><br/>
				<span class="customfontsize2">  <b>500 Error !</b></span><br/>
				
				<span><img src="${resource(dir: 'images', file: "500.gif")}" alt="500"/></span>
			</div>	
			<div class="text-center" style="margin-top: 20px;"> 
				
				<g:link controller="loggedInAs" action="inbox"><button class="btn">Back to Home</button></g:link>
				
			</div>
		</g:else>
	</body>
</html>