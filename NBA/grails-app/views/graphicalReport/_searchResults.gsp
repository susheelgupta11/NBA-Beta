   
  
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

  <asset:stylesheet src="beta-version/css/jquery.datetimepicker.min.css"/>
  <asset:javascript src="beta-version/js/calander/jquery.datetimepicker.js" />

<script>

$(document).ready(function () {

	 $('#formW thead tr').clone(true).appendTo( '#formW thead' );
	    $('#formW thead tr:eq(1) th').each( function (i) {
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

var table =	$('#formW').DataTable({

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

thead input {
        width: 100%;
    }
    
.revenue h3{
	margin-top: 1px !important;
    margin-bottom: 7px;
}
</style>
 <g:render template="revenue"/>
<div id="searchresults">
    <g:if test="${searchresults}">
       
       <div class="row">
       		<div class="col-lg-4 revenue">
       		  <h3>Total Revenue:₹ ${totalRevenue.get(0)}</h3> 
       		</div>
       		<div class="col-lg-8">
       		<g:formRemote name="filter" on404="alert('not found!')" update="revenue"
              url="[controller: 'graphicalReport', action:'revenueFilter']"  method="post">
                 From:<input type="text" autocomplete="off" name="fromFilter" id="startdate"required="required"/>
				 To:<input type="text" autocomplete="off" name="toFilter" id="enddate" required="required"/>
				
				<label for="rev">Select type:</label>
                      <select name="rev" id="rev">
                       <option value="total">Total</option>
                       <option value="Form_1">Form I</option>
                       <option value="Form_2">Form II</option>
                       <option value="Form_3">Form III</option>
                       <option value="Form_4">Form IV</option>
                      </select>
			     <g:submitButton value="Filter" name="Filter" />
</g:formRemote>
       		
       		</div>
       </div>
     <script type="text/javascript">

        $(document).ready(function () {
			var startDate,endDate;
			
         $("#startdate").datetimepicker({
        	 
                     timepicker:true,
                     closeOnDateSelect:false,
                     closeOnTimeSelect: true,
                     initTime: true,
                     format: 'd-m-Y',
<%--                     minDate: 0,--%>
                     roundTime: 'ceil',
                      });
        $("#enddate").datetimepicker({
                     timepicker:true,
                     closeOnDateSelect:false,
                     closeOnTimeSelect: true,
                     initTime: true,
                     format: 'd-m-Y',
<%--                     minDate:  0,--%>
              });

		});
		</script>      
      
       
        <div class="list">
                <table id="formW" class= "display" style="width:100%">
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
                    <g:each in="${searchresults?.result}" status="i" var="formWise">
                        <tr>
                             <td>${i+1}</td>
                            <td>${formWise?.applicant_name}</td>
                            <td>${formWise?.app_number}</td>
<%--                            <td>${formWise?.received_from}</td>--%>
                            <td> <g:formatDate format="dd/MM/yyyy" date="${formWise?.changed_on}"/></td>
                            <td>${formWise?.category?:'N/A'}</td>
                            <td>${formWise?.status_update?:'N/A'}</td>
                            <td> <g:formatDate format="dd/MM/yyyy" date="${formWise?.forwarded_date}"/></td>
                            <td>${formWise?.current_desk?:'Initial User'}</td>
                            <td>${formWise?.action_for?:'N/A'}</td>
                        </tr>
                    </g:each>
                    </tbody>
                 
                </table>
            </div>
    </g:if>
</div>