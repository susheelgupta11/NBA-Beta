<!DOCTYPE html>
<html lang="en">
<head>
<title>NBA</title>
<style type="text/css">
<%--#test-modal-2{z-index:999;}--%>
.modal:nth-of-type(even) {
    z-index: 1052 !important;
}
.modal-backdrop.show:nth-of-type(even) {
    z-index: 1051 !important;
}
</style>
<asset:javascript src="/beta-version/js/jquery.min.js"/>

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
</head>
<body>

       <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title">Record Room Details</h4>
      </div>
            <g:form  controller="dashboard" action="saveRecordRoom" id="reco">
               
               <table align="center">
               <tbody>
               <tr>
               <td>Applicant No.</td>
               <td> ${formDetails?.appNumber}</td>
               </tr>
               
                <tr>
               <td>Applicant  Name</td>
               <td><g:if test="${formDetails?.individualProfiles}">
							<g:each in="${formDetails?.individualProfiles}"
								var="individualProfile">

								${individualProfile?.title}
								${individualProfile?.firstName}
								${individualProfile?.middleName}
								${individualProfile?.lastName}
							</g:each>
						</g:if> <g:elseif test="${formDetails?.companyProfiles}">
							<g:each status="k" in="${formDetails?.companyProfiles}"
								var="company">
								${company?.entityName}
							</g:each>
						</g:elseif> <g:elseif
							test="${formDetails?.indianResearcher}">
							<g:each in="${formDetails?.indianResearcher}"
								var="researcher">

								${researcher?.title}
								${researcher?.firstName}
								${researcher?.middleName}
								${researcher?.lastName}

							</g:each>
						</g:elseif> <g:elseif
							test="${formDetails?.depostionOfMicroOrganism}">
							<g:each in="${formDetails?.depostionOfMicroOrganism}"
								var="depost">
								${depost?.nameOfDepositor}
							</g:each>
						</g:elseif> <g:elseif test="${formDetails?.indianGovtInst}">
							<g:each in="${formDetails?.indianGovtInst}" var="govt">
								${govt?.govtInstName}
							</g:each>
						</g:elseif></td>
               </tr>
               
                <tr>
               <td>Form No.</td>
               <td>${formDetails?.appNumber}</td>
               </tr>
               
                <tr>
               <td>Current Status</td>
               <td>${formDetails?.currentStatus?.statusUpdate}</td>
               </tr>
               
                <tr>
               <td>Moved On</td>
               <td>will be updated</td>
               </tr>
               
                <tr>
               <td>Timed Period</td>
               <td> From: <input name="fromDate" type="text" placeholder="Start Date" autocomplete="off"  id="startdate" required="required"> To: 
               <input  name="toDate" type="text" autocomplete="off" placeholder="End Date" id="enddate" required="required">
               </td>
               </tr>
               
                <tr>
               <td>Action For</td>
               <td><g:select name="actions" class="form-control"
				from="${actionList}"
				value=""
				noSelection="['':'-Choose Action For Record Room-']" required="required" /></td>
               </tr>
               
                  <tr>
               <td>Reason/Notes</td>
               <td><g:textArea name="reason" style="width:100%"/></td>
               </tr>
               </tbody>
               </table>
              <g:hiddenField name="appId" value="${formDetails?.id }"/>
                    <div class="modal-footer">        
            <button class="btn btn-primary"  data-toggle="modal" name="Move">Move</button>
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
        </g:form>
        
   <div class="modal fade" id="test-modal-2" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" id="stsUp">
            </div>
            <div class="container"></div>
            <div class="modal-body">
               
            </div>
        </div>
    </div>     
        
        
        
      <asset:stylesheet src="beta-version/css/jquery.datetimepicker.min.css"/>
      <asset:javascript src="beta-version/js/bootstrap.min.js" />
      <asset:javascript src="beta-version/js/calander/jquery.datetimepicker.js" />
  
      <script type="text/javascript">

      
        $(document).ready(function () {

<%--            $('#openBtn').click(function () {--%>
<%--                $('#test-modal').modal({--%>
<%--                    show: true--%>
<%--                })--%>
<%--            });--%>
<%--            --%>
<%--             $(document).on('show.bs.modal', '.modal', function (event) {--%>
<%--                var zIndex = 1040 + (10 * $('.modal:visible').length);--%>
<%--                $(this).css('z-index', zIndex);--%>
<%--                setTimeout(function() {--%>
<%--                    $('.modal-backdrop').not('.modal-stack').css('z-index', zIndex - 1).addClass('modal-stack');--%>
<%--                }, 0);--%>
<%--            });--%>

			//DatePicker Example
             var startDate,endDate;
 			
             $("#startdate").datetimepicker({
            	 
                         timepicker:true,
                         closeOnDateSelect:false,
                         closeOnTimeSelect: true,
                         initTime: true,
                         format: 'd/m/Y H:i',
                         minDate: 0,
                         roundTime: 'ceil',
                         onChangeDateTime: function(dp,$input){
                                   startDate = $("#startdate").val();
                                   var datearray = startDate.split("/");
                                   var newdate = datearray[1] + '/' + datearray[0] + '/' + datearray[2];
                                   var start_actual_time = new Date(newdate)
                                  
                                   var endarray = endDate.split("/");
                                   var enddate = endarray[1] + '/' + endarray[0] + '/' + endarray[2];
                                   var end_actual_time = new Date(enddate)
                                   
                                   if(start_actual_time>end_actual_time){
                                          alert('Please select correct start date');
                                          document.getElementById('startdate').value = ''
                                    }
                                                               }
                                                               });
            $("#enddate").datetimepicker({
                         timepicker:true,
                         closeOnDateSelect:false,
                         closeOnTimeSelect: true,
                         initTime: true,
                         format: 'd/m/Y H:i',
                         minDate:  0,
                         onClose: function(current_time, $input){
                                endDate = $("#enddate").val();
                              

                               
                                var datearray = startDate.split("/");
                                var newdate = datearray[1] + '/' + datearray[0] + '/' + datearray[2];
                                var start_actual_time = new Date(newdate)
                               
                                var endarray = endDate.split("/");
                                var enddate = endarray[1] + '/' + endarray[0] + '/' + endarray[2];
                                var end_actual_time = new Date(enddate)
                                
                                if(start_actual_time>end_actual_time){
                                       alert('Please select correct end date');
                                       document.getElementById('enddate').value = ''
                                 }
                 }
                  });

		});
    </script>   
 
      </body>
      </html>