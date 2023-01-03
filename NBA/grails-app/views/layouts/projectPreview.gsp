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
        response.setHeader("Cache-Control", "private");
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
        response.setHeader("Pragma", "no-cache"); //HTTP 1.0
        response.setDateHeader("Expires", -1);

    %>
    <%
        response.setHeader("Cache-control", "no-store"); //HTTP 1.1
        response.setHeader("Pragma", "no-cache"); //HTTP1.0
        response.setDateHeader("Expire", 0); //prevents caching at the proxy server
    %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<%--    <title><g:layoutTitle--%>
<%--            default="Ministry of Earth Sciences - Online Research and Outreach Project Management"/></title>--%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${assetPath(src: 'logo.png')}"
          type="image/x-icon">
    <link rel="apple-touch-icon"
          href="${assetPath(src: 'logo.png')}">
    <link rel="apple-touch-icon" sizes="114x114"
          href="${assetPath(src: 'logo.png')}">
    <link rel="apple-touch-icon"
          href="${assetPath(src: 'logo.png')}">
    <asset:stylesheet src="application.css"/>
    <asset:stylesheet src="bootstrap.css"/>
    <asset:stylesheet src="bootstrap-theme.css"/>
    <asset:stylesheet src="jquery-ui.min.css"/>
    <asset:stylesheet src="myBootstrap.css"/>
    <asset:stylesheet src="mybootstrap2.css"/>
    <asset:stylesheet src="print.css" media="print"/>
    <asset:stylesheet src="jquery.tooltip.css"/>
    <asset:javascript src="jquery-v.min.js"/>
    <asset:javascript src="jquery-migrate-1.2.1.js"/>
    <asset:javascript src="jquery-ui.min.js"/>
    <asset:javascript src="bootstrap.min.js"/>
    <asset:javascript src="expand.js"/>
    <asset:javascript src="modernizr-1.7.min.js"/>
    <asset:javascript src="Main.js"/>
    <asset:javascript src="MoES_Validations.js"/>
    <asset:javascript src="jquery.tooltip.js"/>
    <g:layoutHead/>
</head>

<body>
<div class="container backgroundColor pageMinHeight">
    <div class="col-md-3">
        <%--			<g:render template='/projectPreview/newProposalPreviewSubTabs'></g:render>--%>
    </div>
    <g:layoutBody/>
</div>
</body>
</html>