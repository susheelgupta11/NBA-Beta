<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="dashPage"/>
<title>NBA</title>
<style>
.add_mor{
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
</style>
</head>
<body>

<script>
$(document).ready(function () {

$( "div.failure" ).fadeIn( 300 ).delay( 3000 ).fadeOut( 400 );
});
</script>
	
	<script type="text/javascript">
	$(document).ready(function () {
		$('#datetimepicker').datetimepicker({
	        timepicker:true,
	        closeOnDateSelect:false,
	        closeOnTimeSelect: true,
	        initTime: true,
	        format: 'd-m-Y',
	<%--        minDate: 0,--%>
	        roundTime: 'ceil'
	  });

	});

	</script>
   <div class="content-wrapper"  style="margin-left: 210px;">
    <div class="col-sm-12 paddingleft">
      <div id="costum-lft" class="col-sm-12">
<%--        <div class="col-sm-12 rightdiv" style="">--%>
			
			<div class="container-fluid">
			<g:form action="saveBenefitDetails" controller="benefitSharing" enctype="multipart/form-data" method="post">
			<div class= "table-responsive">
				<table class="table table-bordered customtable main-account">
					<tbody>
						<tr>
							<th>App. number</th>
							<th>Type of Form</th>
							<th>Name of the applicant</th>
							<th style="color: red;">Transaction No</th>
							<th style="color: red;">Mode of Payment</th>
							<th>Category</th>
							<th style="color: red;">Amount in INR *</th>
							<th>95%</th>
							<th>5%</th>
							<th>TR 5 Receipt no </th>
							<th>Upload TR 5 receipt </th>
							<th>Date*</th>
							<th>Type of benefit sharing component</th>
							<th>Remarks</th>
						</tr>
						<tr>
							<td><g:textField name="appNumber" value="${formDetails?.appNumber}"/></td>
							<td>${formDetails?.category.category}</td>
							<td><g:if test="${formDetails?.individualProfiles}">
															<g:each in="${formDetails?.individualProfiles}"
																var="individualProfile">

																${individualProfile?.title}
																${individualProfile?.firstName}
																${individualProfile?.middleName}
																${individualProfile?.lastName}
																
	    <g:set var="bsName" 
		value="${individualProfile?.title} ${individualProfile?.firstName} ${individualProfile?.middleName} ${individualProfile?.lastName}"/>
															</g:each>
														</g:if> <g:elseif test="${formDetails?.companyProfiles}">
															<g:each status="k"
																in="${formDetails?.companyProfiles}" var="company">
																${company?.entityName}
													<g:set var="bsName" value="${company?.entityName}"/>
																
															</g:each>
														</g:elseif> <g:elseif test="${formDetails?.indianResearcher}">
															<g:each in="${formDetails?.indianResearcher}"
																var="researcher">

																${researcher?.title}
																${researcher?.firstName}
																${researcher?.middleName}
																${researcher?.lastName}
 <g:set var="bsName" 
		value="${researcher?.title} ${researcher?.firstName} ${researcher?.middleName} ${researcher?.lastName}"/>
					
															</g:each>
														</g:elseif> <g:elseif
															test="${formDetails?.depostionOfMicroOrganism}">
															<g:each
																in="${formDetails?.depostionOfMicroOrganism}"
																var="depost">
																${depost?.nameOfDepositor}
																
																<g:set var="bsName" value="${depost?.nameOfDepositor}"/>
															</g:each>
														</g:elseif> <g:elseif test="${formDetails?.indianGovtInst}">
															<g:each in="${formDetails?.indianGovtInst}"
																var="govt">
																
																${govt?.govtInstName}
																<g:set var="bsName" value="${govt?.govtInstName}"/>
															</g:each>
														</g:elseif></td>
							<td><g:textField name="transNumber" value="${benefitInstance?.transNumber}"/></td>
							<td><g:select name="modeOfPayment" from="${modeOfPayment}" value="${benefitInstance?.modeOfPayment}"/>
							</td>
							<td>
								<g:select name="category" from="${category}" value="${benefitInstance?.category}"/>
							</td>
							<td><g:textField name="amountIn" autocomplete ="off" onmouseout="factor(this)" onkeypress="return isNumber(event)"  value="${benefitInstance?.amountIn}" required="required" /></td>

										<script>
											function factor(e) {
												var getEnterdValue = e.value;
												var firstValue = getEnterdValue * 95 / 100;
												var secondValue = getEnterdValue * 5 / 100;
												var getId = document
														.getElementById("foctorValue").innerHTML = firstValue
														+ '\xa0\xa0\xa0\xa0\xa0\xa0\xa0'
														+ secondValue;
												
												document.getElementById("diff").value = getId;
											}

											function isNumber(evt) {
											    evt = (evt) ? evt : window.event;
											    var charCode = (evt.which) ? evt.which : evt.keyCode;
											    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
											        return false;
											    }
											    return true;
											}
										</script>


							<td colspan="2" ><div id="foctorValue"></div></td>
							<td><g:textField name="tr5ReceiptNumber" value="${benefitInstance?.tr5ReceiptNumber}"/></td>
							<td>
							<div class="input_fields_wrap" style="width:280px;">
							<input type="button"  class="add_mor" id="chgName" Value="Click here"/>
							</div>
<%--							<input style="display:block;" type="file" name="uploadtr5Receipt"accept="application/pdf">--%>
                               <span style="color: red" id="errorMsg" ></span>
							</td>
<%--							value="${benefitInstance?.uploadtr5Receipt}"--%>
							<td>
							   <input  id="datetimepicker" autocomplete="off"  placeholder="dd/mm/yyyy" required="required" name="dateBenefit" value="${benefitInstance?.dateBenefit}">
							</td>
							<td>
                           <g:select name="typeOfSharing" from="${typeOfSharing}" value="${benefitInstance?.typeOfSharing}"/>
							</td>
							<td><g:textField name="remarks" value="${benefitInstance?.remarks}"/></td>
						</tr>
						<tr>
							<td colspan="13" style="color:green"><b>${message}</b></td>
							<g:if test="${addMore == 'true'}">
							<td>
							<input type="submit" name="Add More" value="Add more" class="btn btn-primary pull-right"/>
							</td>
							</g:if>
							<g:elseif test="${addMore == null || "" == addMore}">
							<td>
							<input type="submit" name="Add" value="Add" class="btn btn-primary pull-right"/>
							</td>
							</g:elseif>
						</tr>
					</tbody>
				</table>
					</div>
				<g:hiddenField name="factorval" id="diff"/>
				<g:hiddenField name="formInstance" value="${formDetails?.id}"/>
				<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
				<g:hiddenField name="bsName" value="${bsName}"/>
				</g:form>
				</div>
			
			<div style="margin-top: 20px;">
				<g:if test="${benefitList}">
				<table id= "bsT" style="width: 100%">
				<thead class="thead-dark">
				<tr>
							<th>App. number</th>
							<th>Type of Form</th>
							<th>Name of the applicant</th>
							<th>Transaction No</th>
							<th>Mode of Payment</th>
							<th>Category</th>
							<th>Amount in INR</th>
							<th>95%</th>
							<th>5%</th>
							<th>TR 5 Receipt no </th>
							<th>Upload TR 5 receipt</th>
							<th>Date</th>
							<th>Type of benefit sharing component</th>
							<th>Remarks</th>
						</tr>
				</thead>
				<tbody>
				<g:each in="${benefitList}" var="benefit">
				<tr>
				

				<td>${benefit?.appNumber}</td>
				<td>${benefit?.applicationForm1?.category.category}</td>
				<td>${benefit?.bsName}</td>
				<td>${benefit?.transNumber }</td>
				<td>${benefit?.modeOfPayment }</td>
				<td>${benefit?.category}</td>
				<td>${benefit?.amountIn}</td>
			<% float fact1=Float.parseFloat(benefit?.amountIn)*0.95;   %>
			<% float fact2=Float.parseFloat(benefit?.amountIn)*0.05;   %>
				<td>${fact1 ?:'NA'}</td>
				<td>${fact2 ?:'NA'}</td>
				<td>${benefit?.tr5ReceiptNumber }</td>
				<g:if test="${benefit?.periodicFiles}">
				<td>
				<g:each in="${benefit?.periodicFiles}" var="receiptLink">
				<g:link controller="benefitSharing" action="showTr5Receipt" target="_blank" params="${[showId:receiptLink?.id, csrfPreventionSalt:csrfPreventionSalt]}">${receiptLink?.fileName}</g:link><br></br>
				</g:each>
				</td>
				</g:if>
				<g:else><td>No attachment added</td></g:else>
			
				<td><g:formatDate format="dd/MM/yyyy" date="${benefit?.dateBenefit}"/></td>
				<td>${benefit?.typeOfSharing }</td>
				<td>${benefit?.remarks }</td>
				</tr>
				</g:each>
				</tbody>
				
				</table>
				</g:if>
				</div>
				
				
				
<%--				<hr>--%>
				
<%--					<div class="col-sm-12 form-group">--%>
<%--						<table class="not-com" style="margin-left: 10px;">--%>
<%--							<tbody>--%>
<%--								<tr>--%>
<%--								--%>
<%--									<th style="width: 100%; background-color: #3c8dbc; color: #fff;">Note/Comments</th>--%>
<%--								</tr>--%>
<%--								<tr>--%>
<%--									<td>--%>
<%--													<div id="editor" class="form-group">--%>
<%--													<g:textArea name="comments" id="editor1">--%>
<%--													</g:textArea>--%>
<%--													</div>--%>
<%-- --%>
<%--									</td>--%>
<%--									<td style="display: inline-block;">--%>
<%--										<table class="template">--%>
<%--											<tbody>--%>
<%--										--%>
<%--												<tr>--%>
<%--													<th style="background-color: #3c8dbc; color: #fff;">Templates</th>--%>
<%--												</tr>--%>
<%--											</tbody>--%>
<%--										</table>--%>
<%--										<div class="main-tbs">--%>
<%--							<g:render template="/dashboard/commentBox"></g:render>				--%>
<%--                    </div>--%>
<%--				</td>--%>
<%--                </tr>--%>
<%--              </tbody>--%>
<%--            </table>--%>
<%--        --%>
<%--     	   <g:form action="forwardApplication">--%>
<%--     	  --%>
<%--			<g:hiddenField name="applicationInstance" value="${formDetails?.id}" />--%>
<%--			<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}" />--%>
<%--			<g:render template="/common/fileForwordBox"></g:render>				--%>
<%----%>
<%--              </g:form>--%>
<%--            </div>			--%>
			
			
<%--				</div>--%>
				</div>
	        <g:render template="/rightPane/matchdata"></g:render>
			</div>
		</div>


				
</body>
</html>