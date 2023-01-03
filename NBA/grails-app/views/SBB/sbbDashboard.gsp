<%! import org.nba.application.AppStatus %>
<%! import org.nba.application.FormCategory %>
<%! import org.nba.user.NbaUser %>

<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="sbbDash" />
<title>NBA</title>
</head>
<body>
	<div class="content-wrapper">
		<div class="container col-lg-12">
			<div class="row" id="row-main">
				<div class="col-md-12">

					<div class="panel-group" id="accordion" role="tablist"
						aria-multiselectable="true">
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingOne">
								<h4 class="panel-title">
									<!--  <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne"> -->
									<a class="collapsed" role="button" data-toggle="collapse"
										data-parent="#accordion" href="#collapseOne"
										aria-expanded="true" aria-controls="collapseOne"> <i
										class="more-less glyphicon glyphicon-plus"></i>Application
										Inbox (${applicationDetails?.size()?:0})
									</a>
								</h4>
							</div>
							<div id="collapseOne" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingOne">
								<div class="panel-body">
									<div class="col-lg-12 card">
										<h1 class="title"></h1>

										<div class="table-responsive col-lg-12">
											<table class="table table-striped table-bordered "
												id="sbb-tabl">
												<thead style="background-color: #c0bebe;">
													<tr>
														<th>S.No.</th>
														<th>Applicant Name</th>
														<th>Application No.</th>
														<th>Form Applied</th>
														<th>Received From</th>
														<th>Received Date</th>
														<th>Action For</th>
														<th>Communication Received</th>
														<th>Action</th>
													</tr>
												</thead>
												<tbody>

													<g:if test="${applicationDetails}">
														<%def i = 1%>

														<g:each in="${applicationDetails}" var="applicationDetail">
															<tr>
																<td class="text-center"><%= i %></td>
																<%i++ %>
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

																<td class="text-center">
																	${applicationDetail.appNumber}
																</td>

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

																<td>
																	${applicationDetail?.sbbCommunication?.sendUser}
																</td>

																<td><g:formatDate format="dd/MM/yyyy"
																		date="${applicationDetail?.sbbCommunication?.sendDate}" />
																</td>
																<td>
																	${applicationDetail?.sbbCommunication?.action}
																</td>

															
																<td>
																<g:if test="${applicationDetail?.currentStatus?.communicationStatus == true}">
																Yes
																</g:if>
																<g:else>No</g:else>
																
																</td>

																<td style="text-align: center;"><span
																	class="dropdown">
																		<button class="btn btn-sm btn-primary dropdown-toggle"
																			data-toggle="dropdown" data-hover="dropdown">
																			Action <span class="caret"></span>
																		</button>
																		<ul class="dropdown-menu"
																			style="margin-right: -90px !important; margin-left: -90px !important;">
																			<li><g:link controller="SBB" action="replyConsent"
																					params="${[instance:applicationDetail?.id,csrfPreventionSalt:csrfPreventionSalt]}">Reply Consent</g:link></li>

<%--																			<li><g:link controller="SBB" action="noting"--%>
<%--																					params="${[instance:applicationDetail?.id,csrfPreventionSalt:csrfPreventionSalt]}">View Comments</g:link></li>--%>

																		</ul>
																</span></td>
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
					
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingTwo">
							<h4 class="panel-title">
								<a class="collapsed" role="button" data-toggle="collapse"
									data-parent="#accordion" href="#collapseTwo"
									aria-expanded="false" aria-controls="collapseTwo"> <i
									class="more-less glyphicon glyphicon-plus"></i>Responded
									Applications/In-Process Application (${inProcessApplications?.size()?:0 })
								</a>
							</h4>
						</div>
						<div id="collapseTwo" class="panel-collapse collapse"
							role="tabpanel" aria-labelledby="headingTwo">
							<div class="panel-body">
								<div class="col-lg-12 card">
                                   <h1 class="title"></h1>
									<div class="table-responsive col-lg-12">
										<table class="table table-striped table-bordered" id="sbbRespond">
											<thead style="background-color: #c0bebe;">
												<tr>
													<th>S.No.</th>
													<th>Applicant Name</th>
													<th>Application Number</th>
													<th>Form Applied</th>
													<th>Received From</th>
													<th>Received Date</th>
													<th>Action For</th>
													<th>Communication Received</th>

													<th>Action</th>
												</tr>
											</thead>
											<tbody>
												<g:if test="${inProcessApplications}">
													<%def g = 1%>
													<g:each in="${inProcessApplications}"
														var="applicationDetail">

														<tr>
															<td><%= g%></td>
															<%g++ %>
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



															<td>
																${applicationDetail?.appNumber}
															</td>
															<td>
																${applicationDetail?.category?.category}
															</td>

															<td>
																	${applicationDetail?.sbbCommunication?.sendUser}
																</td>

																<td><g:formatDate format="dd/MM/yyyy"
																		date="${applicationDetail?.sbbCommunication?.sendDate}" />
																</td>
																<td>
																	${applicationDetail?.sbbCommunication?.action}
																</td>

															
																<td>
																<g:if test="${applicationDetail?.currentStatus?.communicationStatus == true}">
																Yes
																</g:if>
																<g:else>No</g:else>
																
																</td>

																				<td style="text-align: center;"><span
																	class="dropdown">
																		<button class="btn btn-sm btn-primary dropdown-toggle"
																			data-toggle="dropdown" data-hover="dropdown">
																			Action <span class="caret"></span>
																		</button>
																		<ul class="dropdown-menu"
																			style="margin-right: -90px !important; margin-left: -90px !important;">
																			<li><g:link controller="SBB" action="replyConsent"
																					params="${[instance:applicationDetail?.id,csrfPreventionSalt:csrfPreventionSalt]}">Reply Consent</g:link></li>


																		</ul>
																</span></td>


															<%--														<td><g:remoteLink action="fileStatus"--%>
															<%--																controller="FileMovments" title="Check File Status"--%>
															<%--																params="${[instance:applicationDetail?.id,csrfPreventionSalt:csrfPreventionSalt] }"--%>
															<%--																data-target="#success" data-toggle="modal" update="nin">--%>
															<%--																<i class="fa fa-file-text"></i>--%>
															<%--															</g:remoteLink></td>--%>
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
<%--			<g:render template="/SBB/rightNotification"></g:render>--%>
		</div>
	</div>
</div>
</body>
</html>