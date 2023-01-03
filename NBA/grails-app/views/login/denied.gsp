<head>
<meta name='layout' content='main' />
<title><g:message code="springSecurity.denied.title" /></title>
<style>
	.customfontsize1{font-size:3em;color:grey;}
	.customfontsize2{font-size:6em;color:grey;}
	.customfontsize3{font-size:1.3em;color:grey;}
	.margintop{margin-top: 230px;}
</style>
</head>

<body>
<div class='body'>
<%--	<div class='errors'><g:message code="springSecurity.denied.message" /></div>--%>
	
	<div class="text-center margintop" >
			<span class="customfontsize1">
				<b>Sorry, its a</b> 
			</span><br/>
			<span class="customfontsize2">  <b>404 Error !</b></span><br/>
			
			<span class="customfontsize3">For Some Reason The Page You Requested Could Not Be Found On Our Server</b></span>
	</div>	
	<div class="text-center" style="margin-top: 20px;"> 
		
		<g:link controller="loggedInAs" action="inbox"><button class="btn">Back to Home</button></g:link>
		
	</div>
	
</div>
</body>
