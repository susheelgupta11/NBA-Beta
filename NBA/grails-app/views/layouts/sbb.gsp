<%! import org.nba.application.ApplicationForm1 %>
<%! import org.nba.application.FormCategory %>

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

<asset:stylesheet src="beta-version/css/bootstrap.min.css"/>
<asset:stylesheet src="beta-version/css/responsive.bootstrap.min.css"/>
<asset:stylesheet src="beta-version/css/font-awesome.min.css"/>
<asset:stylesheet src="beta-version/css/AdminLTE.css"/>
<asset:stylesheet src="beta-version/css/custom.css"/>
<asset:stylesheet src="beta-version/css/all-skins.css"/>
<asset:stylesheet src="beta-version/css/dataTables.bootstrap.min.css"/>



<asset:javascript src="beta-version/js/jquery.min.js" />
<asset:javascript src="beta-version/js/sample.js" />
<asset:javascript src="beta-version/js/adminlte.min.js" />
<asset:javascript src="beta-version/js/bootstrap.min.js"/>

<asset:javascript src="/ckeditor/ckeditor.js" />
<asset:javascript src="dashboard.js"/>

<g:layoutHead />
</head>
<body  class="hold-transition skin-blue sidebar-mini">
<div class="minh">
<header>
	<g:render template='/layouts/dashboardHeader'></g:render>
		    	
	</header>
	
	<asset:javascript src="beta-version/js/datatable/jquery.min.js"/>
	<asset:javascript src="beta-version/js/datatable/bootstrap.min.js"/>
	<asset:javascript src="beta-version/js/datatable/jquery.dataTables.min.js"/>
	<asset:javascript src="beta-version/js/datatable/dataTables.bootstrap.min."/>
	<asset:javascript src="beta-version/js/datatable/dataTables.responsive.min.js"/>
	
	
	<g:set var="formId" value="${formDetails?.id}" />
	 <aside class="main-sidebar" style="background-color: #fff !important;"> 
    <section class="sidebar" style="margin-top: 10px;"> 
      <ul class="sidebar-menu" data-widget="tree">
      			<li class="formheading"
				style="border: 1px solid #f5dea0; padding: 10px; background: #748aa3; margin-bottom: 5px; text-align: center; color: #fff;">MENU</li>
      <li class="userss"><g:link controller="SBB" action="sbbDashboard" params="${[instance:formId,csrfPreventionSalt:csrfPreventionSalt] }">Dashboard</g:link></li>
     
     <g:if test="${formId}">
     
      <li class="userss"><a href="#">Notification</a></li>
        <li class="treeview userss"><a href="#"><span>SBB Consent Form</span> <span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i> </span> </a>
        <ul class="treeview-menu">
<%--            <li><g:link controller="SBB"  action="receivedConsent" params="${[instance:formId,csrfPreventionSalt:csrfPreventionSalt] }"><i class="fa fa-circle-o"></i>Received</g:link></li>--%>
            <li><g:link controller="SBB"  action="replyConsent" params="${[instance:formId,csrfPreventionSalt:csrfPreventionSalt] }"><i class="fa fa-circle-o"></i> Create</g:link></li>
         </ul>
         </li>
         <li class="treeview userss"><a href="#"><span>Communication</span> <span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i> </span> </a>
        <ul class="treeview-menu">
            <li><g:link controller="SBB" action="createComment" params="${[instance:formId,csrfPreventionSalt:csrfPreventionSalt] }"><i class="fa fa-circle-o"></i> Create</g:link></li>
            
         </ul>
         </li>
          <li class="userss"><g:link controller="SBB"  action="sendCommunication" params="${[instance:formId,csrfPreventionSalt:csrfPreventionSalt] }">Send Dispatched</g:link></li>
        <li class="userss"><g:link controller="SBB"  action="receivedCommunication" params="${[instance:formId,csrfPreventionSalt:csrfPreventionSalt] }">Received/Receipt</g:link></li>
<%--        <li class="userss"><a href="#">SENT Communication to NBA</a></li>--%>
</g:if>
      </ul>
     
    </section>
  </aside>
	
		<div  class=" top_Pad">
			<g:layoutBody />
		</div>
	</div>
	
		<g:render template='/layouts/footer'></g:render>	
</body>
</html>
