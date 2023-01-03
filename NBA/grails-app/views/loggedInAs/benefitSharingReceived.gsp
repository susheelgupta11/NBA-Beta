<%! import org.nba.application.FormCategory %>

<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content='superAdmin' />
<title>Benefit-Sharing-NBA</title>
<style type="text/css">
thead input {
        width: 100%;
    }
</style>
</head>
<body>
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
	<div class="content-wrapper">
		<div class="col-sm-12 " style="padding-left: 26px !important">
			<div class="row">
				<div class="col-lg-6">
<%--		<g:form action="benefitSeach" controller="loggedInAs"  method="POST">--%>
<%--		Form:--%>
<%--		<input type="text" autocomplete="off" name="fromT" placeholder="Form type" />--%>
<%--		 <g:select name="fromT" from="${formType}"/>--%>
<%--		Benefit :--%>
<%--		<input type="text" autocomplete="off" name="typeBenefit" placeholder="Type of benefit sharing component"/>--%>
<%--		             <g:select name="typeBenefit" from="${typeOfSharing}"/>--%>
<%--	       <g:submitButton value="Search" name="Search"/>--%>
<%--		</g:form>		--%>
				</div>
				<div class="col-lg-6">
				<g:form action="benefitFilter" controller="loggedInAs"  method="POST">
		From:<input type="text" autocomplete="off" name="fromFilter" id="startdate"required="required"/>
		To:<input type="text" autocomplete="off" name="toFilter" id="enddate" required="required"/>
	       <g:submitButton value="Filter" name="Filter"/>
		</g:form>
				
				</div>
			
			</div>
		
			<div id="costum-lft" class="col-sm-12">

				<table id="bs-table" class="display" style="width:100%">
					<thead class="bg-primary">
					<tr>
					    <th>S No.</th>
                        <th>Applicant Name</th>
						<th>App Number</th>
						<th>Form Type</th>
						<th>Amount (INR)</th>
						<th>Receipt No.</th>
						<th>Date</th>
						<th>Category</th>
						<th>Payment Mode</th>
						<th>Type of benefit sharing component</th>
					</tr>
					</thead>
					<tbody>
					<g:if test="${benefitSharingInstance}">
						<g:each in="${benefitSharingInstance}" var="benefit" status="i">
							<tr>
							    <td>${i+1}</td>
							    <td>${benefit?.bsName}</td>
								<td>
									${benefit?.appNumber }
								</td>
								<td>
								<g:if test="${benefit?.applicationForm1?.category?.category == FormCategory.Category.Form_1}">Form I</g:if>
								<g:elseif test="${benefit?.applicationForm1?.category?.category == FormCategory.Category.Form_2}">Form II</g:elseif>
								<g:elseif test="${benefit?.applicationForm1?.category?.category == FormCategory.Category.Form_3}">Form III</g:elseif>
								<g:elseif test="${benefit?.applicationForm1?.category?.category == FormCategory.Category.Form_4}">Form IV</g:elseif>
								<g:elseif test="${benefit?.applicationForm1?.category?.category == FormCategory.Category.Form_B}">Form B</g:elseif>
								<g:elseif test="${benefit?.applicationForm1?.category?.category == FormCategory.Category.Form_C}">Form C</g:elseif>
								
								
								</td>
								
								<td>
									${benefit?.amountIn}
								</td>
								<td>${benefit?.tr5ReceiptNumber}</td>
								<td><g:formatDate format="dd/MM/yyyy" date="${benefit?.dateBenefit}"/></td>
								<td>
									${benefit?.category}
								</td>
								<td>
									${benefit?.modeOfPayment}
								</td>
								<td>
									${benefit?.typeOfSharing}
								</td>
							</tr>
						</g:each>
                  </g:if>
<%--                  <g:else>--%>
<%--                  <tr>--%>
<%--                  <td colspan="9"> No Benefit Sharing</td>--%>
<%--                  </tr>--%>
<%--                  </g:else>--%>
					</tbody>
<%--                <tfoot>--%>
<%--            <tr>--%>
<%----%>
<%--                        <th>Applicant Name</th>--%>
<%--						<th>App Number</th>--%>
<%--						<th>Form Type</th>--%>
<%--						<th>Amount (INR)</th>--%>
<%--						<th>Date</th>--%>
<%--						<th>Category</th>--%>
<%--						<th>Payment Mode</th>--%>
<%--						<th>Type of benefit sharing component</th>--%>
<%--            </tr>--%>
<%--        </tfoot>--%>
				</table>
			</div>
		</div>
	</div>
</body>
</html>