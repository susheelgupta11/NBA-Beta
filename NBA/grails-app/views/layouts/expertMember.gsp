<%! import org.nba.user.NbaUser %>
<%! import org.nba.user.NbaUserNbaRole %>
<%! import org.nba.user.NbaRole %>
<%! import org.nba.user.LinkOfficer %>
<%! import org.nba.user.RoleEnum %>
<%! import org.nba.application.ApplicationForm1 %>



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

<%--for message view --%>
<asset:stylesheet src="morquee.css" />

<asset:javascript src="beta-version/js/jquery.min.js" />
<asset:javascript src="beta-version/js/adminlte.min.js" />


<g:layoutHead />

<style>
body {
padding-right: 0px !important;
}
</style>
</head>
<body class="hold-transition skin-blue sidebar-mini">


<g:set var="headerDetails" value="${formDetails}" />

<g:if test="${headerDetails}"> 
<g:javascript>

$( document ).ready(function() {
	document.getElementById('headerShow').style.display = 'block';
    console.log( "ready!" );
});
 
</g:javascript>
</g:if>

<header class="main-header">
	<nav class="navbar navbar-static-top">
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
			<li class="dropdown messages-menu"><g:link
						controller="expertCommittee" action="expertDash" params='[csrfPreventionSalt:"${csrfPreventionSalt}"]'><i class="fa fa-home" style="font-size:16px">Home</i></g:link></li>
				<li class="dropdown messages-menu"><g:link controller="logout"
						params='[csrfPreventionSalt:"${csrfPreventionSalt}"]'><i class="fa fa-sign-out" style="font-size:16px;">Logout</i></g:link></li>
			</ul>
		</div>
	</nav>
	
	<div class="container-fluid">
		  <g:set var="userObject" value="${NbaUser.findByUsername(sec.loggedInUserInfo(field:'username'))}"/>
		  <g:set var="getNbaRole" value="${userObject?.nbaRole}"/>
          <g:set var="getRoleDetails" value="${NbaRole.get(getNbaRole?.id)}"/>
          <g:set var="getAuthority" value="${getRoleDetails?.authority}" />
		  
		  <g:set var="linkDetails" value="${LinkOfficer.findByNbaUserTo(userObject)}"/>
		  <g:set var="chkStatus" value="${linkDetails?.status}"/>
		  <g:set var="tillTime" value=" ${linkDetails?.toDate}"/>		  
		
		<div class="col-sm-9">
			<img src="${resource(dir: 'images', file: 'Logo1.jpg')}" alt="logo"
				class="img-responsive pull-left" />
		</div>
		<div class="col-sm-3 text-right" style="padding: 10px;">
			<div class="col-sm-12">
			
			             <sec:ifLoggedIn>
							<b>Signed in as : </b>${userObject?.username}<br/>
							<b>Role:</b>${getAuthority}<br/>
				         </sec:ifLoggedIn>
				 
</div>
</div>
</div>
  
   <nav class="navbar navbar-default"> 
    <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button"> 
    <span class="sr-only">Toggle navigation</span> </a>
    <div style="float:right; padding:1em; cursor:pointer;">
    <div class="btn-group" role="group" aria-label="Controls">
         <i class="fa fa-bars toggle-sidebar" aria-hidden="true" style="color:#FFF; font-size:18px;"></i>
        </div>
	</div>
        
        
     <div class="container-fluid">
        <div class="collapse navbar-collapse" id="defaultNavbar1">
          <ul class="nav navbar-nav">
            <li><a href="#"><span class="sr-only">(current)</span></a></li>
            <li><a href="#"></a></li>
          </ul>
        </div>
      </div>
    </nav>
	</header>
	<div id="innermin_height" class="container-fluid ">
	
	    	<asset:javascript src="beta-version/js/datatable/jquery.min.js"/>
			<asset:javascript src="beta-version/js/datatable/bootstrap.min.js"/>
			<asset:javascript src="beta-version/js/datatable/jquery.dataTables.min.js"/>
			<asset:javascript src="beta-version/js/datatable/dataTables.bootstrap.min."/>
			<asset:javascript src="beta-version/js/datatable/dataTables.responsive.min.js"/>
			

	<script>
$(document).ready(function () {
	$('#ec-table').DataTable();
	$('#ec1-table').DataTable({

		"columnDefs": [
		               { "width": "5%", "targets": 0 }
		             ]
		});
});
</script>


	<aside class="main-sidebar" style="background-color: #fff !important;">
		<section class="sidebar" style="margin-top: 10px;">
			<ul class="sidebar-menu" data-widget="tree">
				<li class="formheading"
					style="border: 1px solid #f5dea0; padding: 10px; background: #748aa3; margin-bottom: 5px; text-align: center; color: #fff;">MENU</li>
				<li class="treeview"><a href="#"> <i
					class="fa fa-calendar-check-o"></i> <span>Agenda</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
	<ul class="treeview-menu">
         <li><g:link action="expertCom" params="${[csrfPreventionSalt:csrfPreventionSalt]}">Expert Committee</g:link></li>
         <li><g:link action="authority" params="${[csrfPreventionSalt:csrfPreventionSalt]}">Authority</g:link></li>
         <li><g:link action="internalCom" params="${[csrfPreventionSalt:csrfPreventionSalt]}">Internal Committee</g:link></li>
         <li><g:link action="nbaSec" params="${[csrfPreventionSalt:csrfPreventionSalt]}">NBA Secretariat</g:link></li>
	</ul>
  </li>
   
    <li class="userss"><g:link action="addReco" controller="expertCommittee"  params="${[csrfPreventionSalt:csrfPreventionSalt]}">Recommendation</g:link></li>
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