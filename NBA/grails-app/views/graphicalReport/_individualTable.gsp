   
  
<%--            <asset:javascript src="beta-version/js/datatable/jquery.min.js"/>--%>
<%--			<asset:javascript src="beta-version/js/datatable/bootstrap.min.js"/>--%>
<%--			<asset:javascript src="beta-version/js/datatable/jquery.dataTables.min.js"/>--%>
<%--			<asset:javascript src="beta-version/js/datatable/dataTables.bootstrap.min."/>--%>
<%--			<asset:javascript src="beta-version/js/datatable/dataTables.responsive.min.js"/>--%>
 <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.23/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="exportTable/jquery.dataTables.min.css">
<link rel="stylesheet" href="expoetTable/buttons.dataTables.min.css">
<asset:stylesheet src="exportTable/fixedHeader.dataTables.min.css"/>

<asset:javascript src="exportTable/jquery-3.5.1.js"/>
<asset:javascript src="exportTable/jquery.dataTables.min.js"/>
<asset:javascript src="exportTable/dataTables.buttons.min.js"/>
<asset:javascript src="exportTable/jszip.min.js"/>
<asset:javascript src="exportTable/pdfmake.min.js"/>
<asset:javascript src="exportTable/vfs_fonts.js"/>
<asset:javascript src="exportTable/buttons.html5.min.js"/>
<asset:javascript src="exportTable/buttons.print.min.js"/>
<asset:javascript src="exportTable/dataTables.fixedHeader.min.js"/>



<script>

$(document).ready(function () {

	 $('#indiG thead tr').clone(true).appendTo( '#indiG thead' );
	    $('#indiG thead tr:eq(1) th').each( function (i) {
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

var table =	$('#indiG').DataTable({

	 orderCellsTop: true,
     fixedHeader: true,
        dom: 'Bfrtip',
        buttons: [
            'excel', 'pdf', 'print'
        ]
    });
	
});
</script>

<style>
<!--
thead input {
        width: 100%;
    }
-->
</style>

<div id="searchresults">
    <g:if test="${ondeskApplication}">
       <br/>
       
        <div class="list">
                <table id="indiG" class= "display" style="width:100%">
                    <thead style="background-color:aqua;">
                        <tr>
                            <th>S No.</th>
                            <th>Applicant Name</th>
                            <th> App Number </th>
<%--                            <th>Submitted By</th>--%>
                            <th>Submitted On</th>
                            <th>Form Type</th>
                            <th>Status</th>
                            <th>Status Date</th>
                            <th>Current Desk</th>
                            <th>Action</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${ondeskApplication}" status="i" var="ind">
                        <tr>
                             <td>${i+1}</td>
                            <td>Ram</td>
                            <td>${ind?.application?.appNumber}</td>
<%--                            <td>${ind?.received_from}</td>--%>
                            <td> <g:formatDate format="dd/MM/yyyy" date="${ind?.changedOn}"/></td>
                            <td>FormType</td>
                            <td>${ind?.statusUpdate?:'N/A'}</td>
                            <td> <g:formatDate format="dd/MM/yyyy" date="${ind?.forwardedDate}"/></td>
                            <td>${ind?.currentDesk?:'Initial User'}</td>
                            <td>${ind?.actionFor?:'N/A'}</td>
                        </tr>
                    </g:each>
                    </tbody>
                 
                </table>
            </div>
    </g:if>
</div>