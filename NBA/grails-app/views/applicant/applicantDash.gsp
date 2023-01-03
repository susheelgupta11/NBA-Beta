<%! import org.nba.application.AppStatus %>
<%! import org.nba.application.FormCategory %>
<%! import org.nba.user.NbaUser %>
<%! import org.nba.communication.LetterStatus %>
<%! import org.nba.communication.LetterType %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="appltDash" />
<title>NBA</title>

</head>
<body>
	<div class="content-wrapper">
		<div class="container col-lg-12">
			<div class="row" id="row-main">
				<div class="col-md-12" id="content">

					<div class="panel-group" id="accordion" role="tablist"
						aria-multiselectable="true">
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingOne">
								<h4 class="panel-title">
									<a class="collapsed" role="button" data-toggle="collapse"
										data-parent="#accordion" href="#collapseOne"
										aria-expanded="true" aria-controls="collapseOne"> <i
										class="more-less glyphicon glyphicon-plus"></i> Submitted Application (${applicationDetails.size()?:0})
									</a>
								</h4>
							</div>
							<div id="collapseOne" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingOne">
								<div class="panel-body">
									<div class="col-lg-12 card">
                                        <h1 class="title"></h1>

										<div class="table-responsive col-lg-12">
											<table class="table" id="applicant-table">
											<thead style="background-color: #c0bebe;">
												<tr>
													<th>S.No.</th>
													<th>Applicant Name</th>
													<th>Form Applied</th>
													<th>Application No.</th>
													<th>Status</th>
													<th>Communication <br> Subject</th>
													<th> Communication <br>Dated
													<th>Action</th>
												</tr>
											</thead>
											<tbody>
												<g:if test="${applicationDetails}">
													<% def i= 1%>
													<g:each in="${applicationDetails}" var="applicationDetail">

														<tr>


															<td class="text-center"><%= i %></td>
															<% i++ %>
															<td class="text-center"><g:if
																	test="${applicationDetail?.individualProfiles}">


																	<g:each in="${applicationDetail?.individualProfiles}"
																		var="individualProfile">

																		${individualProfile?.title}
																		${individualProfile?.firstName}
																		${individualProfile?.middleName}
																		${individualProfile?.lastName}
																	</g:each>
																</g:if> <g:elseif test="${applicationDetail?.companyProfiles}">
																	<g:each status="k"
																		in="${applicationDetail?.companyProfiles}"
																		var="company">
																		${company?.entityName}
																	</g:each>
																</g:elseif> <g:elseif test="${applicationDetail?.indianResearcher}">
																	<g:each in="${applicationDetail?.indianResearcher}"
																		var="researcher">

																		${researcher?.title}
																		${researcher?.firstName}
																		${researcher?.middleName}
																		${researcher?.lastName}

																	</g:each>
																</g:elseif> <g:elseif
																	test="${applicationDetail?.depostionOfMicroOrganism}">
																	<g:each
																		in="${applicationDetail?.depostionOfMicroOrganism}"
																		var="depost">
																		${depost?.nameOfDepositor}
																	</g:each>
																</g:elseif> <g:elseif test="${applicationDetail?.indianGovtInst}">
																	<g:each in="${applicationDetail?.indianGovtInst}"
																		var="govt">
																		${govt?.govtInstName}
																	</g:each>
																</g:elseif></td>



													<td class="text-center"><g:if
															test="${applicationDetail?.category?.category == FormCategory.Category.Form_1}">
														<g:set value="previewForm1Info" var="dyaction"/>
													Form I
												</g:if> <g:elseif
																	test="${applicationDetail?.category?.category == FormCategory.Category.Form_2}">
																	<g:set value="previewForm2Info" var="dyaction"/>
													Form II
												</g:elseif> <g:elseif
																	test="${applicationDetail?.category?.category == FormCategory.Category.Form_3}">
																	<g:set value="previewForm3Info" var="dyaction"/>
													Form III
												</g:elseif> <g:elseif
																	test="${applicationDetail?.category?.category == FormCategory.Category.Form_4}">
																	<g:set value="previewForm4Info" var="dyaction"/>
													Form IV
												</g:elseif> <g:elseif
																	test="${applicationDetail?.category?.category == FormCategory.Category.Form_B}">
																	<g:set value="previewFormBInfo" var="dyaction"/>
													Form B
												</g:elseif> <g:elseif
																	test="${applicationDetail?.category?.category == FormCategory.Category.Form_C}">
																	<g:set value="previewFormCInfo" var="dyaction"/>
													Form C
													</g:elseif></td>
															<td class="text-center">
																${applicationDetail.appNumber}
															</td>
															<td class="text-center"><g:if
																	test="${applicationDetail.currentStatus?.status}">
																	${applicationDetail.currentStatus?.status}
																</g:if>
																</td >
																<td class="text-center">
																<g:if test="${applicationDetail?.letterCommunications}">
																<g:each in="${applicationDetail?.letterCommunications?.last()}" var="commu">
																<g:if test="${commu?.letterStatus.ltrstatus == LetterStatus.LtrStatus.LETTER_SEND && commu?.letterType.ltrType != LetterType.LtrType.SBB_LETTER }">
																
																${commu?.subject}<br>
																
																</g:if>
																
																</g:each>
																
																</g:if>
																<g:else>No Communication</g:else>
																</td>
																<td class="text-center">
																<g:if test="${applicationDetail?.letterCommunications?.sort{it.id}}">
																<g:each in="${applicationDetail?.letterCommunications?.last()}" var="commu">
																<g:if test="${commu?.letterStatus.ltrstatus == LetterStatus.LtrStatus.LETTER_SEND && commu?.letterType.ltrType != LetterType.LtrType.SBB_LETTER }">
																<g:formatDate date="${commu?.sendDate}" format="dd/MM/yyyy"/>	<br>
																</g:if>
																</g:each>
																</g:if>
																<g:else></g:else>
																</td>
															<td style="text-align: center;"><span
															class="dropdown" style="display: inline-block">
																<button class="btn btn-sm btn-primary dropdown-toggle"
																	data-toggle="dropdown" data-hover="dropdown" aria-haspopup="true">
																	Action <span class="caret"></span>
																</button>
																<ul class="dropdown-menu"
																	style="margin-right: -90px !important; margin-left: -90px !important;">
											
<%--											<li>--%>
<%--										             	<g:remoteLink action="${dyaction}"--%>
<%--																controller="FormPreview" title="View Application" id="${applicationDetail?.id }"--%>
<%--																params='[fromLogin:"true",appFormId:applicationDetail?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'--%>
<%--																data-target="#success" data-toggle="modal" update="nin">--%>
<%--																View Application--%>
<%--															</g:remoteLink>--%>
<%--											</li>--%>
										
                                    
									<li><g:link controller="applicant" action="createComment"
									params="${[inst:applicationDetail?.id,csrfPreventionSalt:csrfPreventionSalt]}">Reply to NBA</g:link></li>
									 <li>
											<g:remoteLink action="acknowledgementDnld"
										controller="applicant" title="Check File Status"
									params="${[appFormId:applicationDetail?.id,csrfPreventionSalt:csrfPreventionSalt,formType:applicationDetail?.category?.category]}"
									data-target="#success" data-toggle="modal" update="nin">
								     Download Acknowledgement
									</g:remoteLink>	 
											 
<%--	<g:link controller="applicant" action="acknowledgementDnld" target="_blank" params="${[appFormId:applicationDetail?.id,csrfPreventionSalt:csrfPreventionSalt,formType:applicationDetail?.category?.category]}">Download Acknowledgement</g:link>--%>
																
									</li>
																
											<g:if test="${applicationDetail.currentStatus?.status != AppStatus.Status.SUBMITTED}">					
																
											<li>
											
										<g:remoteLink action="fileStatus"
										controller="applicant" title="Check File Status"
									params="${[instance:applicationDetail?.id] }"
									data-target="#success" data-toggle="modal" update="nin">
								       Detailed Status
									</g:remoteLink>
											
											</li>					
																
										</g:if>						
																
																</ul>
														</span>
														</td>	
														</tr>
													</g:each>
												</g:if>

											</tbody>
										</table>
	<div id="success" class="modal fade" role="dialog">
<div class="modal-dialog modal-lg">
   <!-- Modal content-->
<div class="modal-content" style="padding:20px;" id="nin">

  <div class="modal-body" >
 
</div>
 </div>
</div>
</div>	
										</div>

									</div>

								</div>
							</div>
						</div>
						<div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingTwo">
                <h4 class="panel-title">
                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                        <i class="more-less glyphicon glyphicon-plus"></i>
                        Pending/Draft Applications (${pendingApplication?.size()?:0 })
                    </a>
                </h4>
            </div>
            <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                <div class="panel-body">
	   <div class="col-lg-12 card">
	   
	     <div class="table-responsive col-lg-12">
           <table class="table table-striped table-bordered "
													id="applicant-pending">
													<thead style="background-color: #c0bebe;">
														<tr>
															<th>S.No.</th>
															<th>Applicant Name</th>
															<th>Form Applied</th>
															<th>Application No.</th>
															<th>Status</th>
															<th>Action</th>
														</tr>
													</thead>
													<tbody>
														<g:if test="${pendingApplication}">
															<% def i= 1 %>
															<g:each in="${pendingApplication}"
																var="applicationDetail">

																<tr>


																	<td class="text-center"><%= i %></td>
																	<% i++ %>
																	<td class="text-center"><g:if
																			test="${applicationDetail?.individualProfiles}">


																			<g:each in="${applicationDetail?.individualProfiles}"
																				var="individualProfile">

																				${individualProfile?.title}
																				${individualProfile?.firstName}
																				${individualProfile?.middleName}
																				${individualProfile?.lastName}
																			</g:each>
																		</g:if> <g:elseif
																			test="${applicationDetail?.companyProfiles}">
																			<g:each status="k"
																				in="${applicationDetail?.companyProfiles}"
																				var="company">
																				${company?.entityName}
																			</g:each>
																		</g:elseif> <g:elseif
																			test="${applicationDetail?.indianResearcher}">
																			<g:each in="${applicationDetail?.indianResearcher}"
																				var="researcher">

																				${researcher?.title}
																				${researcher?.firstName}
																				${researcher?.middleName}
																				${researcher?.lastName}

																			</g:each>
																		</g:elseif> <g:elseif
																			test="${applicationDetail?.depostionOfMicroOrganism}">
																			<g:each
																				in="${applicationDetail?.depostionOfMicroOrganism}"
																				var="depost">
																				${depost?.nameOfDepositor}
																			</g:each>
																		</g:elseif> <g:elseif test="${applicationDetail?.indianGovtInst}">
																			<g:each in="${applicationDetail?.indianGovtInst}"
																				var="govt">
																				${govt?.govtInstName}
																			</g:each>
																		</g:elseif></td>



																	<td class="text-center"><g:if
																			test="${applicationDetail?.category?.category == FormCategory.Category.Form_1}">
													Form I
												</g:if> <g:elseif
																			test="${applicationDetail?.category?.category == FormCategory.Category.Form_2}">
													Form II
												</g:elseif> <g:elseif
																			test="${applicationDetail?.category?.category == FormCategory.Category.Form_3}">
													Form III
												</g:elseif> <g:elseif
																			test="${applicationDetail?.category?.category == FormCategory.Category.Form_4}">
													Form IV
												</g:elseif> <g:elseif
																			test="${applicationDetail?.category?.category == FormCategory.Category.Form_B}">
													Form B
												</g:elseif> <g:elseif
																			test="${applicationDetail?.category?.category == FormCategory.Category.Form_C}">
													Form C
													</g:elseif></td>
																	<td class="text-center">
																		${applicationDetail?.appNumber}
																	</td>
																	<td class="text-center"><g:if
																			test="${applicationDetail.currentStatus?.status}">
																			${applicationDetail.currentStatus?.status}
																		</g:if></td>
																	<td style="text-align: center;">
																	
																	<span
															class="dropdown">
																<button class="btn btn-sm btn-primary dropdown-toggle"
																	data-toggle="dropdown" data-hover="dropdown">
																	Action <span class="caret"></span>
																</button>
																<ul class="dropdown-menu"
																	style="margin-right: -90px !important; margin-left: -90px !important;">
																	<li><g:link controller="applicant"
																			action="deleteApplication"
																			params="${[instance:applicationDetail?.id,csrfPreventionSalt:csrfPreventionSalt]}">Delete</g:link></li>
																
																
																<li>
													   <g:if test="${applicationDetail?.category?.category == FormCategory.Category.Form_1 && applicationDetail?.individualProfiles && applicationDetail?.individualProfiles?.size() >=0 &&
(applicationDetail?.currentStatus?.status == AppStatus.Status.PENDING || applicationDetail?.currentStatus?.status == AppStatus.Status.NBA_PENDING )}">
												<g:link controller="applicationManagement"
													action="individualProfile"
													params='[formType:"Form1",appFormId:applicationDetail?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
													Complete
												</g:link>

											</g:if> 
	                                       <g:elseif test="${applicationDetail?.category?.category == FormCategory.Category.Form_1 && applicationDetail?.companyProfiles && applicationDetail?.companyProfiles?.size() >=0 && 
 (applicationDetail?.currentStatus?.status == AppStatus.Status.PENDING || applicationDetail?.currentStatus?.status == AppStatus.Status.NBA_PENDING )}">
												<g:link controller="applicationManagement"
													action="companyProfile"
													params='[formType:"Form1",appFormId:applicationDetail?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
													Complete
												</g:link>
											</g:elseif> 
											
											<g:if
												test="${applicationDetail?.category?.category == FormCategory.Category.Form_C && applicationDetail?.depostionOfMicroOrganism && applicationDetail?.depostionOfMicroOrganism?.size() >=0 && 
 (applicationDetail?.currentStatus?.status == AppStatus.Status.PENDING || applicationDetail?.currentStatus?.status == AppStatus.Status.NBA_PENDING )}">
												<g:link controller="applicationManagement"
													action="depositionOfMicroOrganism"
													params='[formType:"FormC",appFormId:applicationDetail?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
													Complete
												</g:link>
												
											</g:if>
											
											
											<g:if test="${applicationDetail?.category?.category == FormCategory.Category.Form_B && applicationDetail?.indianGovtInst && applicationDetail?.indianGovtInst?.size() >=0 && 
 (applicationDetail?.currentStatus?.status == AppStatus.Status.PENDING || applicationDetail?.currentStatus?.status == AppStatus.Status.NBA_PENDING )}">
												<g:link controller="formB"
													action="indianGovtInst"
													params='[formType:"FormB",appFormId:applicationDetail?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
													Complete
												</g:link>
												
											</g:if>
											
										
											<g:if test="${applicationDetail?.category?.category == FormCategory.Category.Form_2 && applicationDetail?.individualProfiles && applicationDetail?.individualProfiles?.size() >=0 &&
 (applicationDetail?.currentStatus?.status == AppStatus.Status.PENDING || applicationDetail?.currentStatus?.status == AppStatus.Status.NBA_PENDING )}">
												<g:link controller="applicationManagement"
													action="individualProfile"
													params='[formType:"Form2",appFormId:applicationDetail?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
													Complete
												</g:link>
											</g:if>
											
											<g:elseif
												test="${applicationDetail?.category?.category == FormCategory.Category.Form_2 && applicationDetail?.companyProfiles && applicationDetail?.companyProfiles?.size() >=0 && 
 (applicationDetail?.currentStatus?.status == AppStatus.Status.PENDING || applicationDetail?.currentStatus?.status == AppStatus.Status.NBA_PENDING )}">
												<g:link controller="applicationManagement"
													action="companyProfile"
													params='[formType:"Form2",appFormId:applicationDetail?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
													Complete
												</g:link>
											</g:elseif>
											
											
											<g:if test="${applicationDetail?.category?.category == FormCategory.Category.Form_3 && applicationDetail?.individualProfiles && applicationDetail?.individualProfiles?.size() >=0 && 
(applicationDetail?.currentStatus?.status == AppStatus.Status.PENDING || applicationDetail?.currentStatus?.status == AppStatus.Status.NBA_PENDING )}">
												<g:link controller="applicationManagement"
													action="individualProfile"
													params='[formType:"Form3",appFormId:applicationDetail?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
													Complete
												</g:link>
												</g:if>
											<g:elseif test="${applicationDetail?.category?.category == FormCategory.Category.Form_3 && applicationDetail?.companyProfiles && applicationDetail?.companyProfiles?.size() >=0 && 
 (applicationDetail?.currentStatus?.status == AppStatus.Status.PENDING || applicationDetail?.currentStatus?.status == AppStatus.Status.NBA_PENDING )}">
												<g:link controller="applicationManagement"
													action="companyProfile"
													params='[formType:"Form3",appFormId:applicationDetail?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
													Complete
												</g:link>
											</g:elseif> 
											<g:if
												test="${applicationDetail?.category?.category == FormCategory.Category.Form_4 && applicationDetail?.individualProfiles && applicationDetail?.individualProfiles?.size() >=0 && 
													 (applicationDetail?.currentStatus?.status == AppStatus.Status.PENDING || applicationDetail?.currentStatus?.status == AppStatus.Status.NBA_PENDING )}">
												<g:link controller="applicationManagement"
													action="individualProfile"
													params='[formType:"Form4",appFormId:applicationDetail?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
													Complete
												</g:link>
											</g:if> 

											<g:elseif
												test="${applicationDetail?.category?.category == FormCategory.Category.Form_4 && applicationDetail?.companyProfiles && applicationDetail?.companyProfiles?.size() >=0 && 
	 (applicationDetail?.currentStatus?.status == AppStatus.Status.PENDING || applicationDetail?.currentStatus?.status == AppStatus.Status.NBA_PENDING )}">
												<g:link controller="applicationManagement"
													action="companyProfile"
													params='[formType:"Form4",appFormId:applicationDetail?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
													Complete
												</g:link>
											</g:elseif> 
											
											<g:elseif
												test="${applicationDetail?.category?.category == FormCategory.Category.Form_B && applicationDetail?.indianResearcher && applicationDetail?.indianResearcher?.size() >=0 && 
 (applicationDetail?.currentStatus?.status == AppStatus.Status.PENDING || applicationDetail?.currentStatus?.status == AppStatus.Status.NBA_PENDING )}">
												<g:link controller="formB" action="indianResearcher"
													params='[formType:"FormB",appFormId:applicationDetail?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
													Complete
												</g:link>

											</g:elseif>
																
																
																</li>
																
																
																
																
																
																</ul>
														</span>
																	
																	
																	</td>
																</tr>
															</g:each>
														</g:if>

													</tbody>
												</table>
                    
					</div>
				</div>
			</div>
		</div>
	</div>

</div>
</div>
<g:render template="/common/rightPan"></g:render>
	</div>
 </div>
 </div>

</body>
</html>