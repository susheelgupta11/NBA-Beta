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

<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<asset:stylesheet src="googlefont.css"/>


<asset:stylesheet src="morquee.css" />

<asset:stylesheet src="betaTables/bootstrap.min.css"/>
<asset:stylesheet src="beta-version/css/bootstrap.min.css"/>
<asset:stylesheet src="beta-version/css/font-awesome.min.css"/>

<asset:stylesheet src="beta-version/css/AdminLTE.css"/>
<asset:stylesheet src="beta-version/css/custom.css"/>
<asset:stylesheet src="beta-version/css/all-skins.css"/>

<%----------------------------------susheel gupta ----------------------%>
  
<%-- Calander add CSS--%>

  <asset:stylesheet src="beta-version/css/jquery.datetimepicker.min.css"/>




<%--<asset:javascript src="adapters/jquery.js"/>--%>

<asset:javascript src="/beta-version/js/jquery.min.js" />

<asset:javascript src="/beta-version/js/sample.js" />
<asset:javascript src="/beta-version/js/adminlte.min.js" />
<asset:javascript src="/beta-version/js/bootstrap.min.js"/>
<asset:javascript src="/beta-version/js/custom.js"/>
<%--<asset:javascript src="beta-version/js/ckeditor.js" />--%>

<asset:javascript src="/beta-version/config.js" />
<asset:javascript src="/beta-version/build-config.js" />


<%--<asset:javascript src="/ckeditor/jquery.js" />--%>
<asset:javascript src="/ckeditor/ckeditor.js" />
<%--<script src="/ckeditor/adapters/jquery.js"></script>--%>


<asset:javascript src="dashboard.js"/>

<%--forpdf view --%>
<%--<asset:javascript src="/beta-version/pdf-upload/pdf.js"/>--%>
<%--<asset:javascript src="/beta-version/pdf-upload/pdf.worker.js"/>--%>



<g:layoutHead />
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="minh">
<header>
	<g:render template='/layouts/dashboardHeader'></g:render>

</header>
<div id="innermin_height" class="container-fluid ">
<%--<g:render template="/layouts/leftmenu"></g:render> 	--%>

<%-- Calander add JS--%>

    <asset:javascript src="beta-version/js/calander/jquery.datetimepicker.js" />
			<g:layoutBody />
	
	</div>
	</div>
		<g:render template='/layouts/footer'></g:render>	
</body>
</html>