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
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">

<asset:stylesheet src="morquee.css" />
<%-- Calander add CSS--%>

  <asset:stylesheet src="beta-version/css/jquery.datetimepicker.min.css"/>
  
<asset:stylesheet src="beta-version/css/bootstrap.min.css"/>
<asset:stylesheet src="beta-version/css/responsive.bootstrap.min.css"/>
<asset:stylesheet src="beta-version/css/font-awesome.min.css"/>
<asset:stylesheet src="beta-version/css/AdminLTE.css"/>
<asset:stylesheet src="beta-version/css/custom.css"/>
<asset:stylesheet src="beta-version/css/all-skins.css"/>
<asset:stylesheet src="beta-version/css/dataTables.bootstrap.min.css"/>


<%--<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.23/css/jquery.dataTables.min.css">--%>
<link rel="stylesheet" href="exportTable/jquery.dataTables.min.css">
<link rel="stylesheet" href="expoetTable/buttons.dataTables.min.css">

<link rel="stylesheet" href="exportTable/fixedHeader.dataTables.min.css">





<asset:javascript src="beta-version/js/jquery.min.js" />
<asset:javascript src="beta-version/js/sample.js" />
<asset:javascript src="beta-version/js/adminlte.min.js" />
<asset:javascript src="beta-version/js/bootstrap.min.js"/>
<asset:javascript src="/ckeditor/ckeditor.js" />
<asset:javascript src="dashboard.js"/>

<%--for dd/mm/yyyy calandar--%>
<asset:stylesheet src="beta-version/css/jquery.datetimepicker.min.css"/>

<g:layoutHead />
<style>
body {
padding-right: 0px !important;
}
</style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="minh">
<header>

	<g:render template='/layouts/adminHeader'></g:render>

	</header>
	    	<asset:javascript src="beta-version/js/datatable/jquery.min.js"/>
			<asset:javascript src="beta-version/js/datatable/bootstrap.min.js"/>
			<asset:javascript src="beta-version/js/datatable/jquery.dataTables.min.js"/>
			<asset:javascript src="beta-version/js/datatable/dataTables.bootstrap.min."/>
			<asset:javascript src="beta-version/js/datatable/dataTables.responsive.min.js"/>



<%--<asset:javascript src="exportTable/jquery-3.5.1.js"/>--%>
<%--<asset:javascript src="exportTable/jquery.dataTables.min.js"/>--%>
<asset:javascript src="exportTable/dataTables.buttons.min.js"/>
<asset:javascript src="exportTable/jszip.min.js"/>
<asset:javascript src="exportTable/pdfmake.min.js"/>
<asset:javascript src="exportTable/vfs_fonts.js"/>
<asset:javascript src="exportTable/buttons.html5.min.js"/>
<asset:javascript src="exportTable/buttons.print.min.js"/>
<asset:javascript src="exportTable/dataTables.fixedHeader.min.js"/>
	
	<g:render template="/layouts/adminLeftMenus"></g:render>
		
		<div  class=" top_Pad">
<%--		 Calander add JS--%>

    <asset:javascript src="beta-version/js/calander/jquery.datetimepicker.js" />
			
			<g:layoutBody />



<script type="text/javascript">

$(document).ready(function () {
	  $('#form-data').DataTable({'aoColumnDefs': [{
	        'bSortable': false,
	        'aTargets': [-1],
	     
	    }]

	  
	 });
	  $('#us-data').DataTable({
		  'aoColumnDefs': [{
		        'bSortable': false,
		        'aTargets': [-2,-4],
		    }]

		  });
	  $('#user-log').DataTable();
});
	  



  
$(document).ready(function () {
	 $('#tr5-iss thead tr').clone(true).appendTo( '#tr5-iss thead' );
	    $('#tr5-iss thead tr:eq(1) th').each( function (i) {
	        var title = $(this).text();
	        $(this).html( '<input type="text" placeholder="Search '+title+'" />' );
	 
	        $( 'input', this ).on( 'keyup change', function () {
	            if ( table.column(i).search() !== this.value ) {
	                table
	                    .column(i)
	                    .search( this.value )
	                    .draw();
	            }
	        } );
	    } );

var table =	$('#tr5-iss').DataTable({

	orderCellsTop: true,
   fixedHeader: true,

  dom: 'Bfrtip',
  buttons: [
      'excel', 'pdf', 'print'
  ]

});
});


$(document).ready(function () {
	
$('#bs-table thead tr').clone(true).appendTo( '#bs-table thead' );
$('#bs-table thead tr:eq(1) th').each( function (i) {
    var title = $(this).text();
    $(this).html( '<input type="text" placeholder="Search '+title+'" />' );

    $( 'input', this ).on( 'keyup change', function () {
        if ( table.column(i).search() !== this.value ) {
            table
                .column(i)
                .search( this.value )
                .draw();
        }
    } );
} );

var table =	$('#bs-table').DataTable({

<%--orderCellsTop: true,--%>
<%--fixedHeader: true,--%>

dom: 'Bfrtip',
buttons: [
 'excel', 'pdf', 'print'
]
});
});
	  
<%--      $('#bs-table').DataTable({--%>
<%--          "searching": false,--%>
<%--          "lengthChange": false,--%>
<%--          "order": [[ 5, "desc" ]],--%>
<%--          dom: 'Bfrtip',--%>
<%--	        buttons: [--%>
<%--	            'excel', 'pdf', 'print'--%>
<%--	        ]--%>
<%----%>
<%--          });--%>
	
</script>
		</div>
	</div>
	
		<g:render template='/layouts/footer'></g:render>
	
</body>
</html>
