<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content='superAdmin'/>
<title>TR5-Issued-NBA</title>

<style type="text/css">
thead input {
        width: 100%;
    }
</style>
</head>
<body>

	<div class="content-wrapper">
		<div class="col-sm-12 " style="padding-left: 26px !important">
		
				<div class="row">
				<div class="col-lg-6">

				</div>
				<div class="col-lg-6">
				<g:form action="tr5DateFilter" controller="loggedInAs"  method="POST">
		From:<input type="text" autocomplete="off" name="fromFilter" id="startdate"required="required"/>
		To:<input type="text" autocomplete="off" name="toFilter" id="enddate" required="required"/>
	       <g:submitButton value="Filter" name="Filter"/>
		</g:form>
				
				</div>
			
			</div>
			<div id="costum-lft" class="col-sm-12">

					<table id="tr5-iss" class="display" style="width:100%">
						<thead class="bg-primary">
						<tr>
							<th>S.No</th>
							<th>Application Name</th>
							<th>Form Applied</th>
							<th>App.no</th>
							<th>Amount</th>
							<th>Receipt No.</th>
							<th>Receipt Date</th>
							<th>Send By</th>
							<th>Send Date</th>
						</tr>
						</thead>
						
                      <g:if test="${tr5ReceiptInstance}">
                      <tbody>
						<g:each in="${tr5ReceiptInstance}" var="commDaitls" status="i">
					
							<tr>
								<td>
									${i+1}
								</td>
								<td>
									${commDaitls?.applicantName}
								</td>
								<td>
									${commDaitls?.formType}
								</td>
								<td>
									${commDaitls?.appNumber}
								</td>
								<td>
									${commDaitls?.sumOfRupees}
								</td>
							   <td>${commDaitls?.receiptNo}</td>
								<td><g:formatDate format="dd/MM/yyyy" date="${commDaitls?.createdDate}"/></td>

                                <td>
									${commDaitls?.sendBy}
								</td>
								<td><g:formatDate format="dd/MM/yyyy" date="${commDaitls?.sendDate}"/></td>
							</tr>
							
						</g:each>
						</tbody>
						</g:if>
						
<%--						<g:else>--%>
<%--						<tr><td colspan="9">No tr5 Letter Sent</td></tr>--%>
<%--						</g:else>--%>
					</table>
			</div>
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
</body>
</html>