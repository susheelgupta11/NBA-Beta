<%! import org.nba.application.AppStatus %>
<%! import org.nba.application.FormCategory %>
<%! import org.nba.user.NbaUser %>


<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="nbaDashboardLayout"/>
<title>NBA</title>
</head>
<body>
 <g:set var="userObject" value="${NbaUser.findByUsername(sec.loggedInUserInfo(field:'username'))}"/>
	<div class="content-wrapper" style="margin-left: 210px;">
		<div class="col-sm-12" style="margin-top: 10px;">
			<div class="navbar-custom-menu dash-main">
				<ul class="nav navbar-nav">
					<li class="dropdown messages-menu open"><g:link
							controller="loggedInAs" action="index" class="dropdown-toggle"
							data-toggle="dropdown">Home</g:link></li>
					<li class="dropdown messages-menu"><g:link
							controller="loggedInAs" action="index" class="dropdown-toggle"
							data-toggle="dropdown">Download</g:link></li>
					<li class="dropdown messages-menu"><g:link
							controller="loggedInAs" action="index" class="dropdown-toggle"
							data-toggle="dropdown">Notification</g:link></li>

				</ul>
			</div>
          </div>
		<g:if test="${flash?.message}">
			<script>
	      alert("${flash?.message}");
			</script>
		</g:if>

		
			<div class="col-sm-12">
			<div>
					<div class="panel-group" id="accordion" style="margin-top: 0px">
						<div class="panel panel-default ">
							<div class="panel-heading" id="accordionHeaderMy">
								<h4 class="panel-title">

									<a class="accordion-toggle" data-toggle="collapse"
										data-parent="#accordion" href="#panel1"> <b>&nbsp;&nbsp;Application Received
											(${applicationDetails.size()?:0})
									</b><i class="glyphicon glyphicon-plus pull-right"></i></a>
								</h4>
							</div>
							<div id="panel1" class="panel-collapse collapse">
								<div>
									<table class="table table-striped table-bordered " id="tableMy">
										<thead style="background-color: #c0bebe;">
											<tr>
												<th>S.No.</th>
												<th>Applicant Name</th>
												<th>Form Applied</th>
												<th>Application No.</th>
												<th>Status</th>
												<th>Priority</th>
												<th>Submission Date</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
                             
											<g:each in="${applicationDetails}" var="applicationDetail" status="i">
												<tr>
													<td class="text-center">
														${i+1}
													</td>
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
																in="${applicationDetail?.companyProfiles}" var="company">
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
														${applicationDetail.appNumber}
													</td>
													<td class="text-center">
													<g:if test="${getReviewHeadRole == 'REVIEW_HEAD' || getReviewMemberRole == 'REVIEW_MEMBER' }">
													<g:if
															test="${applicationDetail.currentStatus?.status}">
															${applicationDetail.currentStatus?.status}
														</g:if>
													
													</g:if>
												 <g:else>
												${applicationDetail.currentStatus?.statusUpdate}
												</g:else></td>
													<td class="text-center"><g:if
															test="${applicationDetail.currentStatus?.priority}">
															${applicationDetail.currentStatus?.priority}
														</g:if> <g:else>
												Updated Soon
												</g:else></td>
													<td class="text-center">
														${applicationDetail.submittedOn}
													</td>

													<td style="text-align: center;"><span class="dropdown">
															<button class="btn btn-sm btn-primary dropdown-toggle"
																data-toggle="dropdown" data-hover="dropdown">
																Action <span class="caret"></span>
															</button>
															<ul class="dropdown-menu"
																style="margin-right: -90px !important; margin-left: -90px !important;">
																<li><g:link controller="superAdmin" action="addNote"
																		params="${[instance:applicationDetail?.id,csrfPreventionSalt:csrfPreventionSalt]}">Review and Forward</g:link></li>

																<li><g:link controller="superAdmin" action="noting"
																		params="${[instance:applicationDetail?.id,csrfPreventionSalt:csrfPreventionSalt]}">View Comments</g:link></li>
																		
<%--																		<li><g:link controller="dashboard" action="cdacApi"--%>
<%--																		params="${[instance:applicationDetail?.id,csrfPreventionSalt:csrfPreventionSalt]}">CDAC</g:link></li>--%>
															</ul>
													</span></td>
												</tr>
											</g:each>

										</tbody>
									</table>
							
				<div class="pagination">
<%--				<g:paginate total="${appsize.size() ?:0}" params="${[csrfPreventionSalt:csrfPreventionSalt]}"/>--%>
			     </div>
			    
								</div>
							</div>
			<div class="panel-heading" id="accordionHeaderMy"
								style="margin-top: 4px">
								<h4 class="panel-title">
									<a class="accordion-toggle" data-toggle="collapse"
										data-parent="#accordion" href="#panel12"> <b>&nbsp;&nbsp;Record Room Application
										 (${recordRoomApplication?.size()?:0 })
									</b><i class="glyphicon glyphicon-plus pull-right"></i></a>
								</h4>
							</div>
							<div id="panel12" class="panel-collapse collapse">
								<div>
									<table class="table table-striped table-bordered " id="tableMy">
										<thead style="background-color: #c0bebe;">
											<tr>
												<th>S.No.</th>
												<th>Application Title</th>
												<th>Status</th>
												<th>Date</th>
											</tr>
										</thead>
										<tbody>
											<g:each in="${recordRoomApplication}" var="applicationDetail"
												status="i">
												<g:if
													test="${applicationDetail?.currentStatus?.statusUpdate}">
													<tr>
														<td>
															${i+1}
														</td>
														<td>
															${applicationDetail?.category?.category}
														</td>
														<td><g:if
																test="${applicationDetail?.currentStatus?.statusUpdate}">
																${applicationDetail?.currentStatus?.statusUpdate}
															</g:if> <g:else>
												Update soon
												</g:else></td>
														<td>
															${applicationDetail?.submittedOn}
														</td>
													</tr>
												</g:if>
											</g:each>
										</tbody>
									</table>
								</div>
							</div>
									
					<div class="panel-heading" id="accordionHeaderMy"
								style="margin-top: 4px">
								<h4 class="panel-title">
									<a class="accordion-toggle" data-toggle="collapse"
										data-parent="#accordion" href="#panel15"> <b>&nbsp;&nbsp;Approved
											Application (${approvedApplications?.size()?:0 })
									</b><i class="glyphicon glyphicon-plus pull-right"></i></a>
								</h4>
							</div>

							<div id="panel15" class="panel-collapse collapse">
								<div>
									<table class="table table-striped table-bordered " id="tableMy">
										<thead style="background-color: #c0bebe;">
											<tr>
												<th>S.No.</th>
												<th>Application Title</th>
												<th>Approve Date</th>
												<th>Approve by</th>
												<th>Status</th>
											</tr>
										</thead>
										<tbody>
											<g:if test="${approvedApplications?.size()}">
												<g:each in="${approvedApplications}" var="applicationDetail"
													status="i">
													<tr>
														<td>
															${i+1 }
														</td>
														<td>
															${applicationDetail?.category?.category}
														</td>
														<td>
															${applicationDetail?.submittedOn}
														</td>
														<td>
															${currentUser}
														</td>
														<td>Approved</td>
													</tr>
												</g:each>
											</g:if>
										</tbody>
									</table>
								</div>
							</div>
							<div class="panel-heading" id="accordionHeaderMy"
								style="margin-top: 4px">
								<h4 class="panel-title">
									<a class="accordion-toggle" data-toggle="collapse"
										data-parent="#accordion" href="#panel2"><b>
											&nbsp;&nbsp;Rejected Application(${rejectedApplications?.size()?:0 })
									</b><i class="glyphicon glyphicon-plus pull-right"></i></a>
								</h4>
							</div>
							<div id="panel2" class="panel-collapse collapse">
								<div>
									<table class="table table-striped table-bordered " id="tableMy">
										<thead style="background-color: #c0bebe;">
											<tr>
												<th>S.No.</th>
												<th>Application Title</th>
												<th>Rejected Date</th>
												<th>Reason</th>
											</tr>
										</thead>
										<tbody>
											<g:if test="${rejectedApplications?.size()}">
												<g:each in="${rejectedApplications}" var="applicationDetail"
													status="l">
													<tr>
														<td>${l+1}</td>
														<td>NBA Title 1</td>
														<td>
														<g:formatDate format="yyyy/MM/dd" date="${applicationDetail?.currentStatus?.changedOn}"/>
														</td>
														<td>${applicationDetail?.currentStatus?.statusUpdate}</td>
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
</body>
</html>