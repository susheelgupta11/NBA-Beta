<%@page import="org.nba.application.FormCategory"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name='layout' content="applicant" />
<title>NBA</title>
<style>
.add_mor {
	background: #367fa9;
	color: #fff;
	padding: 4px 12px;
	display: inline-block;
	border-radius: 4px;
	border: none;
	text-align: center;
	text-decoration: none;
	font-size: 12px;
	margin: 4px 2px;
	cursor: pointer;
}
.tbl-inputs{
width:100%;
}
</style>

</head>
<body>
	<g:if test="${formDetails?.individualProfiles}">
		<g:each in="${formDetails?.individualProfiles}"
			var="individualProfile">
	<g:set value="${individualProfile?.title} ${individualProfile?.firstName} ${individualProfile?.middleName} ${individualProfile?.lastName}"
			  	var="fullName"></g:set>
		</g:each>
	</g:if>
	<g:elseif test="${formDetails?.companyProfiles}">
		<g:each status="k" in="${formDetails?.companyProfiles}" var="company">
			<g:set value="${company?.entityName}" var="fullName"></g:set>

		</g:each>
	</g:elseif>
	<g:elseif test="${formDetails?.indianResearcher}">
		<g:each in="${formDetails?.indianResearcher}" var="researcher">
			<g:set
				value="${researcher?.title} ${researcher?.firstName} ${researcher?.middleName} ${researcher?.lastName}"
				var="fullName"></g:set>
		</g:each>
	</g:elseif>
	<g:elseif test="${formDetails?.depostionOfMicroOrganism}">
		<g:each in="${formDetails?.depostionOfMicroOrganism}" var="depost">

			<g:set value="${depost?.nameOfDepositor}" var="fullName"></g:set>
		</g:each>
	</g:elseif>
	<g:elseif test="${formDetails?.indianGovtInst}">
		<g:each in="${formDetails?.indianGovtInst}" var="govt">

			<g:set value="${govt?.govtInstName}" var="fullName"></g:set>
		</g:each>
	</g:elseif>
	<div class="content-wrapper">
		<div class="container col-lg-12">
			<div class="row" id="row-main">
				<div class="col-md-12" id="content">
					<div class="col-sm-12">
						<div class="panel panel-default">
							<div class="panel-body message">
	<g:form controller="applicant" action="savePeriodicReport" enctype="multipart/form-data" method="Post">
	
	                    <div>
							<g:if test="${message}">
								<span style="color: green; text-shadow: orange;"><b>
										${message}
								</b></span>
							</g:if>
						</div>
	
						<g:if test="${act == '1' }">
						<g:render template="createReport1"></g:render>
						</g:if>
						
							<g:if test="${act == '1C' }">
						<g:render template="createReport1C"></g:render>
						</g:if>
							<g:if test="${act == '2' }">
						<g:render template="createReport2"></g:render>
						</g:if>
							<g:if test="${act == '3' }">
						<g:render template="createReport3"></g:render>
						</g:if>
							<g:if test="${act == '4' }">
						<g:render template="createReport4"></g:render>
						</g:if>
						
						
					
						<g:hiddenField name="formId" value="${formDetails?.id}" />
						<g:hiddenField name="applicantName" value="${fullName}" />
						<g:hiddenField name="periodicInstance"
							value="${periodicReportInstance?.id }" />
						<g:hiddenField name="csrfPreventionSalt"
							value="${csrfPreventionSalt}" />
					<g:hiddenField name="formType" value="${act}"/>
							
	<g:link action="applicantDash" controller="applicant" params="${[csrfPreventionSalt:csrfPreventionSalt] }"
	 class="btn btn-primary pull-right" style="margin-bottom: 5px;">Cancel</g:link>	
						
<g:actionSubmit name="Send"  value="Send" action="savePeriodicReport"
								style="margin-bottom: 5px; margin-right:5px; display:none" id="submi"
								class="btn btn-primary pull-right" />

					</g:form>
				</div>
				</div>
				</div></div>
				<g:render template="/applicant/rightPane"></g:render>
			</div>
		</div>
	</div>
	
   <script type="text/javascript">
        $(document).ready(function () {
			
			//DatePicker Example
			$('#datetimepicker').datetimepicker({
                timepicker:true,
                closeOnDateSelect:false,
                closeOnTimeSelect: true,
               initTime: true,
                format: 'd-m-Y',
                startDate: '01/01/1996',
  //              minDate: 0,
                roundTime: 'ceil',
           
                                                      });
			 var startDate,endDate;
	 			
             $("#startdate").datetimepicker({
            	 
                         timepicker:true,
                         closeOnDateSelect:false,
                         closeOnTimeSelect: true,
                         initTime: true,
                         format: 'd/m/Y',
                       //  minDate: 0,
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
                         format: 'd/m/Y',
   //                      minDate:  0,
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

