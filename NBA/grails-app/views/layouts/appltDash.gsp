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

<asset:stylesheet src="beta-version/css/bootstrap.min.css"/>
<asset:stylesheet src="beta-version/css/responsive.bootstrap.min.css"/>
<asset:stylesheet src="beta-version/css/font-awesome.min.css"/>
<asset:stylesheet src="beta-version/css/AdminLTE.css"/>
<asset:stylesheet src="beta-version/css/custom.css"/>
<asset:stylesheet src="beta-version/css/all-skins.css"/>
<asset:stylesheet src="beta-version/css/dataTables.bootstrap.min.css"/>


<asset:javascript src="beta-version/js/jquery.min.js" />


<g:layoutHead />
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="minh">
<header>
	<g:render template='/layouts/adminHeader'></g:render>
	</header>
	
	
<aside class="main-sidebar" style="background-color: #fff !important;"> 
    <section class="sidebar" style="margin-top: 10px;"> 
      <ul class="sidebar-menu" data-widget="tree">
      			<li class="formheading"
				style="border: 1px solid #f5dea0; padding: 10px; background: #748aa3; margin-bottom: 5px; text-align: center; color: #fff;">MENU</li>
      <li class="userss"><g:link action="applicantDash" params="${[csrfPreventionSalt:csrfPreventionSalt]}">Dashboard</g:link></li>
      <li class="userss"><g:link controller="loggedInAs" action="decideForm">Apply Online</g:link></li>
      </ul>
    </section>
  </aside>
	<g:layoutBody />
     <asset:javascript src="beta-version/js/datatable/jquery.min.js"/>
	 <asset:javascript src="beta-version/js/datatable/bootstrap.min.js"/>
	 <asset:javascript src="beta-version/js/datatable/jquery.dataTables.min.js"/>
	 <asset:javascript src="beta-version/js/datatable/dataTables.bootstrap.min."/>
	 <asset:javascript src="beta-version/js/datatable/dataTables.responsive.min.js"/>
			


<script type="text/javascript">

$(document).ready(function () {
	  $('#applicant-table').DataTable({

		  "columnDefs": [ { "width": "4%", "targets": 0 }]
		  });
	  
	  $('#applicant-pending').DataTable({
		  "columnDefs": [{ "width": "4%", "targets": 0 }]

		  });
	});
</script>
		</div>
		<g:render template='/layouts/footer'></g:render>	
</body>
</html>
