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


  
  
<%--<style type="text/css">--%>
<%-- .rotate {--%>
<%--    transform:rotate(180deg);--%>
<%--    transition:all 0.5s;--%>
<%--}--%>
<%--.rotate.in {--%>
<%--    transform:rotate(1800deg);--%>
<%--    transition:all 1.5s;--%>
<%--}--%>
<%--</style>--%>



<asset:javascript src="dashboard.js"/>

<g:layoutHead />

<style>
body {
padding-right: 0px !important;
}
</style>
</head>
<body class="hold-transition skin-blue sidebar-mini">

<header>
<g:render template="/layouts/indexHeader"></g:render>

	</header>
	<div id="innermin_height" class="container-fluid ">
	
	    	<asset:javascript src="beta-version/js/datatable/jquery.min.js"/>
			<asset:javascript src="beta-version/js/datatable/bootstrap.min.js"/>
			<asset:javascript src="beta-version/js/datatable/jquery.dataTables.min.js"/>
			<asset:javascript src="beta-version/js/datatable/dataTables.bootstrap.min."/>
			<asset:javascript src="beta-version/js/datatable/dataTables.responsive.min.js"/>
			

	<script>
$(document).ready(function () {
	$('#myTable').DataTable();
	$('#myTable2').DataTable();
	$('#myTable3').DataTable();
	$('#myTable4').DataTable();
	$('#myTable5').DataTable();
});
</script>


	<aside class="main-sidebar" style="background-color: #fff !important;">
		<section class="sidebar" style="margin-top: 10px;">
			<ul class="sidebar-menu" data-widget="tree">
				<li class="formheading"
					style="border: 1px solid #f5dea0; padding: 10px; background: #748aa3; margin-bottom: 5px; text-align: center; color: #fff;">MENU</li>
				<li class="active"><g:link controller="dashboard"
						action="dashboard"
						params="${[csrfPreventionSalt:csrfPreventionSalt] }">
						<i class="fa fa-dashboard"></i>
						<span>Dashboard</span>
					</g:link></li>

					<li>
					<a href="#" id="opnBtn" data-toggle="modal" data-target="#test-modal"> <i class="fa fa-file-text"></i> <span>File Status</span> </a>

						
						</li>
						
						 <li><g:link controller="graphicalReport" action="cristalView"
	 params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt] }">
	 <i class="fa fa-cloud"></i> <span>MIS Report</span></g:link></li>  
	 
	  <li><g:link controller="graphicalReport" action="individualCristalView"
	 params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt] }">
	 <i class="	fa fa-file"></i> <span>Individual MIS</span></g:link></li>   
	 
				</ul>
		</section>
	</aside>


<div class="modal fade" id="test-modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                	<h4 class="modal-title">Check Application Status</h4>

            </div>
            <div class="container"></div>
            <div class="modal-body">
            <g:formRemote name="unfileStatus" url="[controller: 'dashboard', action:'fileStatus']" update="stsUp" >
       <input type="text" placeholder="Enter application no." autocomplete="off" name="value"/>
       <button class="btn btn-primary" id="signin" data-toggle="modal" data-target="#test-modal-2" name="See Status" >See Status</button>
        </g:formRemote>
            </div>
          <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
    </div>
        </div>
    </div>
</div>
<div class="modal fade" id="test-modal-2">
    <div class="modal-dialog">
        <div class="modal-content" id="stsUp" style="padding: 8px">
           

            </div>
            <div class="container"></div>
            <div class="modal-body">
               
            </div>
          
        </div>
    </div>

<script type="text/javascript">
$(document).ready(function () {


	$("#signin").on( "click", function() {
        $('#test-modal').modal('hide');  
});

<%--    $('#openBtn').click(function () {--%>
<%--        $('#test-modal').modal({--%>
<%--            show: true--%>
<%--        })--%>
<%--    });--%>

<%--        $(document).on('show.bs.modal', '.modal', function (event) {--%>
<%--            var zIndex = 1040 + (10 * $('.modal:visible').length);--%>
<%--            $(this).css('z-index', zIndex);--%>
<%--            setTimeout(function() {--%>
<%--                $('.modal-backdrop').not('.modal-stack').css('z-index', zIndex - 1).addClass('modal-stack');--%>
<%--            }, 0);--%>
<%--        });--%>


});

</script>
		<div  class=" top_Pad">
			<g:layoutBody />
			

		</div>
</div>

		<g:render template='/layouts/footer'></g:render>	
</body>
</html>