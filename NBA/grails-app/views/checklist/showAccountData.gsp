<%@ page contentType="text/html;charset=UTF-8"%>
<%! import org.nba.application.FormCategory %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="dashPage" />
<title>NBA</title>
<style type="text/css">
.remark{color:blue}
</style>
</head>
<body>

<script>
$(document).ready(function () {
<%--CKEDITOR.replace('editor1');--%>
$( "div.success" ).fadeIn( 300 ).delay( 3000 ).fadeOut( 400 );
});
</script>

	<g:if test="${accountRemarkInstance?.txnDetailsInOrder == false}">
		<g:javascript>
$(document).ready(function() {showText();});	
</g:javascript>
	</g:if>
	<g:if test="${accountRemarkInstance?.mcdWithBakStatement == false}">
		<g:javascript>
$(document).ready(function() {showBox();});
</g:javascript>
	</g:if>
	<g:if test="${accountRemarkInstance?.paymentType == 'Others'}">
		<g:javascript>
$(document).ready(function() {showTextBox();});
</g:javascript>
	</g:if>
	
		<div class="content-wrapper">
			<div class="col-sm-12 paddingleft">
				<div id="costum-lft" class="col-sm-12">
        <g:if test="${message}">
		<div class="alert-box success">${message}</div>	
		</g:if>
					<div class="col-sm-12 rightdiv">
						<g:form name="checklistNote" controller="checklist"
							action="saveAccountNote">
							<table class="table table-bordered customtable main-account" id="tbl_posts">
							<thead>
								<tr class="header">
									<th>S.No</th>
                                     <th>Title</th>
                                       <th></th>
                                      <th>Details</th>
                                      <th colspan="4">Remarks</th>
								</tr>
								</thead>
								<tbody id="tbl_posts_body">
								<tr id="rec-1">
									<td><b><span class="sn">1</span></b></td>
									<td><b>Name of the Applicant</b></td>
									<td class="text-center" style="width: 1px;"><b>:</b></td>
									<td><g:if
											test="${formDetails?.individualProfiles}">


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
										</g:elseif> <g:elseif test="${formDetails?.indianResearcher}">
											<g:each in="${formDetails?.indianResearcher}"
												var="researcher">

												${researcher?.title}
												${researcher?.firstName}
												${researcher?.middleName}
												${researcher?.lastName}

											</g:each>
										</g:elseif> <g:elseif test="${formDetails?.depostionOfMicroOrganism}">
											<g:each in="${formDetails?.depostionOfMicroOrganism}"
												var="depost">
												${depost?.nameOfDepositor}
											</g:each>
										</g:elseif> <g:elseif test="${formDetails?.indianGovtInst}">
											<g:each in="${formDetails?.indianGovtInst}" var="govt">
												${govt?.govtInstName}
											</g:each>
										</g:elseif></td>
									<td colspan="2"></td>
								</tr>
								<tr>
									<td><b>2</b></td>
									<td><b>Category of the
											Applications</b></td>
									<td class="text-center" style="width: 1px;"><b>:</b></td>
									<td><g:if
											test="${formDetails?.category?.category == FormCategory.Category.Form_1}">
													Form I
												</g:if> <g:elseif
											test="${formDetails?.category?.category == FormCategory.Category.Form_2}">
													Form II
												</g:elseif> <g:elseif
											test="${formDetails?.category?.category == FormCategory.Category.Form_3}">
													Form III
												</g:elseif> <g:elseif
											test="${formDetails?.category?.category == FormCategory.Category.Form_4}">
													Form IV
												</g:elseif> <g:elseif
											test="${formDetails?.category?.category == FormCategory.Category.Form_B}">
													Form B
												</g:elseif> <g:elseif
											test="${formDetails?.category?.category == FormCategory.Category.Form_C}">
													Form C
													</g:elseif></td>
									<td colspan="2"></td>
								</tr>
								<tr>
									<td><b>3</b></td>
									<td><b>Transaction ID</b></td>
									<td class="text-center" style="width: 1px;"><b>:</b></td>
									<td>
										${formDetails?.transaction?.transactionId}
									</td>
									<td colspan="2"><g:textField  class="remark" name="trsnsRemark" value="${accountRemarkInstance?.trsnsRemark}"/></td>
								</tr>
								<tr>
									<td><b>4</b></td>
									<td><b>SBI Payment Reference
											Number</b></td>
									<td class="text-center" style="width: 1px;"><b>:</b></td>
									<td>
										${formDetails?.transaction?.paymentRefNo}
									</td>
									<td colspan="2"><g:textField  class="remark" name="paymentRemark" value="${accountRemarkInstance?.paymentRemark}"/></td>
								</tr>
								<tr>
									<td><b>5</b></td>
									<td><b>Payment Received</b></td>
									<td class="text-center" style="width: 1px;"><b>:</b></td>
									<td>
										${formDetails?.transaction?.fee}/-
									</td>
									<td colspan="2"><g:textField  class="remark" name="paymentReceivedRemark" value="${accountRemarkInstance?.paymentReceivedRemark}"/></td>
								</tr>
								<tr>
									<td><b>6</b></td>
									<td><b>Fee to be received</b></td>
									<td class="text-center" style="width: 1px;"><b>:</b></td>
									<td>
										${formDetails?.transaction?.fee}/-
									</td>
									<td colspan="2"><g:textField  class="remark" name="feeRemark" value="${accountRemarkInstance?.feeRemark}"/></td>
								</tr>

								<tr>
									<td><b>7</b></td>
									<td><b>Payment Type</b></td>
									<td class="text-center" style="width: 1px;"><b>:</b></td>
									<td><g:select class="remark"
											from="${paymentType }" name="pymtType" id="dropdn"
											onchange="showTextBox();"
											value="${accountRemarkInstance?.paymentType}"
											noSelection="['':'Select Payment Type']" /></td>

									<td class="remark"  colspan="2"><g:textArea
											name="remarkPayment" id="otherText"
											style="visibility: hidden"
											value="${accountRemarkInstance?.others}" /></td>
								</tr>

								<tr>
									<td><b>8</b></td>
									<td><b>Transaction Details found
											in order</b></td>
									<td class="text-center" style="width: 1px;"><b>:</b></td>

									<td style="padding: 0 10px;"><g:if
											test="${accountRemarkInstance?.txnDetailsInOrder == null}">
											<div class="trans-yn">
												<g:radio id="yesUn" onclick="hideText();" name="txnCofm"
													value="true" />
												Yes

											</div>

											<p>
												<g:radio id="noUn" name="txnCofm" value="false"
													onclick="showText();" />
												No
											</p>

										</g:if> <g:elseif
											test="${accountRemarkInstance?.txnDetailsInOrder == true}">
											<div class="trans-yn">
												<g:radio id="yesUn" onclick="hideText();" name="txnCofm"
													value="true" checked="checked" />
												Yes

											</div>

											<p>
												<g:radio id="noUn" name="txnCofm" value="false"
													onclick="showText();" />
												No
											</p>
										</g:elseif> <g:elseif
											test="${accountRemarkInstance?.txnDetailsInOrder == false}">
											<div class="trans-yn">
												<g:radio id="yesUn" onclick="hideText();" name="txnCofm"
													value="true" />
												Yes
											</div>
											<p>
												<g:radio id="noUn" name="txnCofm" value="false"
													checked="checked" onclick="showText();" />
												No
											</p>
										</g:elseif> <g:else>
											<div class="trans-yn">
												<g:radio id="yesUn" onclick="hideText();" name="txnCofm"
													value="true" />
												Yes
											</div>
											<p>
												<g:radio id="noUn" name="txnCofm" value="false"
													onclick="showText();" />
												No
											</p>
										</g:else></td>
									<td  colspan="2">
										<div>
											<g:textArea  class="remark" name="remark" id="rem" style="display: none;"
												value="${accountRemarkInstance?.txnDetailsRemark}" />
										</div></td>
								</tr>
								<tr>
									<td><b>9</b></td>
									<td><b>Matched with bank
											statement</b></td>
									<td class="text-center" style="width: 1px;"><b>:</b></td>
									<td><g:if
											test="${accountRemarkInstance?.mcdWithBakStatement == null}">
											<div class="trans-yn">
												<g:radio name="mcdBnk" value="true" onclick="hideBox();"
													id="yesM" />
												Yes
											</div>
											<p>
												<g:radio name="mcdBnk" value="false" onclick="showBox();"
													id="noM" />
												No
											</p>
										</g:if> <g:elseif
											test="${accountRemarkInstance?.mcdWithBakStatement == true}">
											<div class="trans-yn">
												<g:radio name="mcdBnk" checked="checked" value="true"
													onclick="hideBox();" id="yesM" />
												Yes
											</div>
											<p>
												<g:radio name="mcdBnk" value="false" onclick="showBox();"
													id="noM" />
												No
											</p>
										</g:elseif> <g:elseif
											test="${accountRemarkInstance?.mcdWithBakStatement == false}">
											<div class="trans-yn">
												<g:radio name="mcdBnk" value="true" onclick="hideBox();"
													id="yesM" />
												Yes
											</div>
											<p>
												<g:radio name="mcdBnk" value="false" onclick="showBox();"
													id="noM" checked="checked" />
												No
											</p>

										</g:elseif> <g:else>
											<div class="trans-yn">
												<g:radio name="mcdBnk" value="true" onclick="hideBox();"
													id="yesM" />
												Yes
											</div>
											<p>
												<g:radio name="mcdBnk" value="false" onclick="showBox();"
													id="noM" />
												No
											</p>

										</g:else></td>
									<td colspan="2"> <div>
											<g:textArea name="remarkBnk" id="remarkM"
												style="display: none;" class="remark"
												value="${accountRemarkInstance?.mcdBakStatementRemark }" />
										</div></td>
								</tr>
								<tr>
									<td><b>10</b></td>
									<td><b>Question / Remark</b></td>
									<td class="text-center" style="width: 1px;"><b>:</b></td>
									<td style="padding: 0 10px;">
<%--									<g:textArea name="quest" value="${accountRemarkInstance?.question }" style="width: 100%;" class="remark" /></td>--%>
								<td></td>
								<td></td>
								</tr>
							<g:if
								test="${accountRemarkInstance != null || accountRemarkInstance != ''}">
								<g:each in="${accountRemarkInstance?.questionAnswers}"
									var="quesAnswer" status="k">
									<tr id="all${k+1 }"  class="remark">
										<td><b id="srl${k+1}">
												<span class="sn">${k+11}</span>
										</b></td>
										<td><g:textArea name="quesValues${k+1}" id="qut${k+1}"
												value="${quesAnswer?.question}" rows="3" cols="40"></g:textArea></td>
										<td><b>:</b></td>
										<td><g:textArea name="ansValues${k+1}"
												id="qes${k+1}" value="${quesAnswer?.answer}" rows="3"
												cols="40"></g:textArea></td>
										<td><input type="button" onclick="updateQuestion(this);"
											class="btn btn-success" style="margin: 15%"  value="Update" id="upd${k+1}"
											name="${quesAnswer?.id}" /></td>
										<%--<g:remoteLink  controller="checklist" action="deleteQuestion" id="rem${k+1}" params="${[deleteIns:quesAnswer?.id]}"  onSuccess="removeTextBoxes(this);">Remove</g:remoteLink>--%>
										<td><input type="button" onclick="deleteQues(this);"
											value="Remove" id="rem${k+1}" name="${quesAnswer?.id}"
											class="btn btn-danger" style="margin-top: 15%" /></td>
									</tr>
								</g:each>
							</g:if>
							</tbody>
						</table>


							<div class="col-sm-12 form-group">
								<g:link action="accountCheckList"
									class="btn btn-primary pull-right" controller="checklist"
									target="_blank"
									params="${[accountInstance:accountRemarkInstance?.id,instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]}">Generate Pdf</g:link>

								<g:actionSubmit type="button" class="btn btn-primary pull-right"
									value="Update" name="Update" action="saveAccountNote" style="margin-right:10px" />

							</div>
							<g:hiddenField name="accountRemarkInstance" value="${accountRemarkInstance?.id}" />
							<g:hiddenField name="instance" value="${formDetails?.id}" />
							<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt }"/>
						</g:form>
                
<%--						<div class="col-sm-12 form-group">--%>
<%--							<table class="not-com" style="margin-left: 10px;">--%>
<%--								<tbody>--%>
<%--									<tr>--%>
<%--									<th style="width: 100%; background-color: #3c8dbc; color: #fff;">Note/Comments</th>--%>
<%----%>
<%--									</tr>--%>
<%--									<tr>--%>
<%--										<td>--%>
<%--                                                  <div id="editor" class="form-group">--%>
<%--													<g:textArea name="comments" id="editor1">--%>
<%--													</g:textArea>--%>
<%--													</div>--%>
<%----%>
<%--											</td>--%>
<%--										<td style="display: inline-block;">--%>
<%--											<table class="template">--%>
<%--												<tbody>--%>
<%--													<tr>--%>
<%--										 <th style="background-color: #3c8dbc; color: #fff;">Templates</th>--%>
<%--													</tr>--%>
<%--												</tbody>--%>
<%--											</table>--%>
<%--											<div class="main-tbs">--%>
<%--												<g:render template="/dashboard/commentBox"></g:render>--%>
<%--											</div>--%>
<%----%>
<%--										</td>--%>
<%--									</tr>--%>
<%--								</tbody>--%>
<%--							</table>--%>
<%--							<g:form controller="checklist" action="saveAccountComment"--%>
<%--								enctype="multipart/form-data" method="post"  onsubmit="return getData()">--%>
<%--								<g:render template="/dashboard/addnotes"></g:render>--%>
<%--								<g:hiddenField name="flag" value="2" />--%>
<%--								<g:hiddenField name="accountRemarkInstance" value="${accountRemarkInstance?.id}" />--%>
<%--								<g:hiddenField name="applicationInstance" value="${formDetails?.id}" />--%>
<%--								<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt }"/>--%>
<%--							</g:form>--%>
<%--						</div>--%>
					</div>
				</div>
				<g:render template="/rightPane/matchdata"></g:render>
			</div>
		</div>

</body>
</html>