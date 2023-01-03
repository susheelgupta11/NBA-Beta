<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head>
<%
response.setHeader("Cache-Control","private");
response.setHeader("Cache-Control","no-store");
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", -1);


%>
<% 
response.setHeader("Cache-control","no-store"); //HTTP 1.1 
response.setHeader("Pragma","no-cache"); //HTTP1.0 
response.setDateHeader("Expire",0); //prevents caching at the proxy server 

%>


<meta http-equiv="Cache-control" content="private">
<meta http-equiv="Cache-control" content="no-cache">
<meta http-equiv="Cache-control" content="no-store">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title><g:layoutTitle
		default="National Biodiversity Application" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="${assetPath(src: 'logo.png')}"
	type="image/x-icon">
<link rel="apple-touch-icon"
	href="${assetPath(src: 'logo.png')}">
<link rel="apple-touch-icon" sizes="114x114"
	href="${assetPath(src: 'logo.png')}">
<link rel="apple-touch-icon"
	href="${assetPath(src: 'logo.png')}">
<link rel="logo" href="${assetPath(src: 'images/logo.png')}">

<asset:stylesheet src="jquery-ui.min.css" />
<asset:stylesheet src="jquery.datepick.css" />
<asset:stylesheet src="bootstrap.min.css" />
<asset:stylesheet src="custom.css" />
<asset:stylesheet src="mybootstrap2.css" />
<asset:stylesheet src="jquery.tooltip.css" />
<asset:stylesheet src="font-awesome.min.css" />
<asset:stylesheet src="calender/kendo.dataviz.material.min.css" />
<asset:stylesheet src="calender/kendo-material.min.css" />
<asset:stylesheet src="calender/kendo-dataviz.min.css" />
<asset:stylesheet src="calender/kendo-dataviz.material.min.css" />

<asset:javascript src="jquery-vv.js" />
<asset:javascript src="jquery-v.min.js" />
<asset:javascript src="/aes.js"/>
<asset:javascript src="NBA.js" />
<asset:javascript src="blockUI.js" />
<asset:javascript src="jquery-ui.min.js" />
<asset:javascript src="bootstrap.min.js" />
<asset:javascript src="jquery-datepick.js" />
<asset:javascript src="responsive-calendar.js" />
<asset:javascript src="MoES_Validations.js" />
<asset:javascript src="responsive-calendar.min.js" />
<asset:javascript src="calender/kendo-all.min.js" />
<asset:javascript src="calender/kendo-all.min.js" />

<g:layoutHead />
</head>

<body>
<div class="minh ">

<g:render template='/layouts/outerheader' model='[csrfPreventionSalt:"${csrfPreventionSalt}"]'></g:render>
	<div id="middleheight" class="row">
		<g:layoutBody />
		</div>
	
	<g:render template='/layouts/footer'></g:render>
	
</div>	
</body>
</html>
