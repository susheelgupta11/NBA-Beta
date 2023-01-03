<%! import org.nba.application.AppStatus %>
<%! import org.nba.application.FormCategory %>
<%! import org.nba.user.NbaUser %>
<%! import org.nba.user.NbaRole%>
<%! import org.nba.application.ApplicationForm1 %>
<%! import org.nba.user.NbaUserNbaRole %>


<g:set var="userObject"
	value="${NbaUser.findByUsername(sec.loggedInUserInfo(field:'username'))}" />
<g:set var="getNbaRole" value="${userObject?.nbaRole}" />
<g:set var="getRoleDetails" value="${NbaRole.get(getNbaRole?.id)}" />
<g:set var="getAuthority" value="${getRoleDetails?.authority}" />



<!DOCTYPE html>
<html lang="en">
<head>

<meta name='layouts' content='dashboard'/>
<title>NBA</title>
</head>
<body>
<script>
$(document).ready(function () {
$( "div.success" ).fadeIn( 300 ).delay( 3000 ).fadeOut( 400 );
});

</script>
	<div class="content-wrapper">
		<div class="container col-lg-12">
			<div class="row" id="row-main">
			
		       <g:if test="${message}">
					<div class="alert-box success">${message}</div>	
					</g:if>
			
				<div class="col-md-12" id="content">

					<div class="panel-group" id="accordion" role="tablist"
						aria-multiselectable="true">
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingOne">
								<h4 class="panel-title">
									<!--  <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne"> -->
									<a class="collapsed" role="button" data-toggle="collapse"
										data-parent="#accordion" href="#collapseOne"
										aria-expanded="true" aria-controls="collapseOne"> <i
										class="more-less glyphicon glyphicon-plus"></i> New
										Applications Received(${applicationDetails?.size()?:0})
									</a>
									
								</h4>
							</div>
							<div id="collapseOne" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingOne">
								<div class="panel-body">
									<div class="col-lg-12 card">
                                        <h1 class="title"></h1>

										<div class="table-responsive col-lg-12">
											<table class="table" id="myTable">
												<thead class="thead-dark">
													<tr>
														<th scope = "col">S.No.</th>
														<th>Applicant Name</th>
														<th>Application No.</th>
														<th>Form Applied</th>
														<th>Received From</th>
														<th>Received Date</th>
														<th>Action For</th>
														<th>Priority</th>
														<th>Application Status</th>
														<th>Communication Received</th>
														<th>Action</th>
													</tr>
												</thead>
												<tbody>

											<g:if test="${applicationDetails}">
												<%def i = 1%>

												<g:each in="${applicationDetails}" var="application">
													<tr>
														<td class="text-center"><%= i %></td>
														<%i++ %>
														<td class="text-center">${application?.applicant_name}</td>
															
																<td class="text-center">
															${application?.app_number}
														</td>
															
														<td class="text-center">
													<g:if test="${application?.category == 'Form_1'}">Form I</g:if>
													<g:if test="${application?.category == 'Form_2'}">Form II</g:if>
													<g:if test="${application?.category == 'Form_3'}">Form III</g:if>
													<g:if test="${application?.category == 'Form_4'}">Form IV</g:if>
													<g:if test="${application?.category == 'Form_B'}">Form B</g:if>
														</td>
													
															<td>
															<g:if test="${application?.link_officer_check == true}">
															Link Officer -${application?.received_from}
																	</g:if>
																	<g:else>
																		${application?.received_from}
																	</g:else>
																</td>

														<td>
														<g:formatDate format="dd/MM/yyyy" date="${application?.changed_on}" />
														</td>
														<td>
														${application?.action_for?:'Initial'}
														</td>

														<td>
															${application?.priority?:'No Priority'}
														</td>

														<td>
															${application?.status_update?:'Submitted'}
														</td>
														<td>
														<g:if test="${application?.communication_status == true}">
														Yes</g:if>
														<g:else>
														   No
														</g:else>
                                                        </td>

														<td>
														
														<span class="dropdown">
																<button class="btn btn-sm btn-primary dropdown-toggle"
																	data-toggle="dropdown" data-hover="dropdown">
																	Action <span class="caret"></span>
																</button>
																<ul class="dropdown-menu"
																	style="margin-right: -90px !important; margin-left: -90px !important;">
																	
																		<li><g:link controller="dashboard" action="noting"
																			params="${[instance:application?.id,linkOfficer:linkOfficer,csrfPreventionSalt:csrfPreventionSalt]}">View Comments</g:link></li>

																	<li>
																	
																	<li><g:link controller="dashboard" action="addNote"
																			params="${[instance:application?.id,linkOfficer:linkOfficer,csrfPreventionSalt:csrfPreventionSalt]}">Review and Forward</g:link></li>
																	
		                                               <li><g:link controller="dashboard" action="cdacApi" 
		                                               params="${[instance:application?.id,csrfPreventionSalt:csrfPreventionSalt]}">cdac</g:link>
								                       </li>

								<li><g:remoteLink action="moveToRecordRoom" controller="dashboard" title="Record Room Details" params="${[instance:application?.id,linkOfficer:linkOfficer,csrfPreventionSalt:csrfPreventionSalt] }"
										data-target="#record-modal" data-toggle="modal" update="con">Move to Record Room  </g:remoteLink>

																	
																	</li>
																
																</ul>
														</span>
														
														</td>
													</tr>
												</g:each>
											</g:if>
										</tbody>
									</table>
<%--	Record room modal popup	--%>
 <div class="modal fade" id="record-modal" data-modal-index="1">
  <div class="modal-dialog">
    <div class="modal-content" id="con">
      
      <div class="modal-body">
      </div>
      
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
 
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
                        In Process Applications(${inProcessApplications?.size()?:0 })
                      
                    </a>
                </h4>
            </div>
            <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                <div class="panel-body">
	   <div class="col-lg-12 card">
	  <h1 class="title"></h1>
	     <div class="table-responsive col-lg-12">
            <table class="table" id="myTable2">
                  <thead class="thead-dark-inp">
                    <tr>
                    <th>S.No.</th>
												<th>Applicant Name</th>
												<th>Application Number</th>
												<th>Form Applied</th>
												<th>Received From</th>
												<th>Received Date</th>
												<th>Action For</th>
												<th>Priority</th>
												<th>Application Status</th>
												<th>Communication Received</th>

												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<g:if test="${inProcessApplications}">
												<%def g = 1 %>
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
														<g:if test="${applicationDetail?.category?.category == FormCategory.Category.Form_1}">Form I</g:if>
														<g:if test="${applicationDetail?.category?.category == FormCategory.Category.Form_2}">Form II</g:if>
														<g:if test="${applicationDetail?.category?.category == FormCategory.Category.Form_3}">Form III</g:if>
														<g:if test="${applicationDetail?.category?.category == FormCategory.Category.Form_4}">Form IV</g:if>
														<g:if test="${applicationDetail?.category?.category == FormCategory.Category.Form_B}">Form B</g:if>	
														</td>

														<td>
															${applicationDetail?.currentStatus?.changedBy?.name}
														</td>

														<td><g:formatDate format="dd/MM/yyyy"
																date="${applicationDetail?.currentStatus?.forwardedDate}" />
														</td>
														<td>
															${applicationDetail?.currentStatus?.actionFor}
														</td>

														<td>
															${applicationDetail?.currentStatus?.priority?:'No Priority'}
														</td>

														<td>
															${applicationDetail?.currentStatus?.statusUpdate}
														</td>
														<td>
														<g:if test="${applicationDetail?.currentStatus?.communicationStatus == true}">
														Yes
														</g:if>
														<g:else>No
														</g:else>
                                                        </td>
														
														
														
									<td style="text-align: center;"><span
															class="dropdown">
																<button class="btn btn-sm btn-primary dropdown-toggle"
																	data-toggle="dropdown" data-hover="dropdown">
																	Action <span class="caret"></span>
																</button>
																<ul class="dropdown-menu"
																	style="margin-right: -90px !important; margin-left: -90px !important;">
																	
																			<li><g:link controller="dashboard" action="noting"
																			params="${[instance:applicationDetail?.id,linkOfficer:linkOfficer,csrfPreventionSalt:csrfPreventionSalt]}">View Comments</g:link></li>
																	
																
																	<li><g:link controller="dashboard"
																			action="addNote"
																			params="${[instance:applicationDetail?.id,linkOfficer:linkOfficer,csrfPreventionSalt:csrfPreventionSalt]}">Review and Forward</g:link></li>

									
										<li><g:remoteLink action="moveToRecordRoom" controller="dashboard" title="Record Room Details" params="${[instance:application?.id,linkOfficer:linkOfficer,csrfPreventionSalt:csrfPreventionSalt] }"
										data-target="#record-modal" data-toggle="modal" update="con">Move to Record Room  </g:remoteLink>
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
<g:if test="${getAuthority == 'CHAIRMAN' || getAuthority == 'SECRETARY' }">
<g:render template="/dashboard/superAdmin"></g:render>
</g:if>
</div>
</div>
<g:render template="dashRight"></g:render>
	</div>
 </div>
 </div>
<script>
	$(document).ready(function () {
		
		$(".toggle-sidebar").click(function () {
			$("#sidebar").toggleClass("collapsed");
			$("#content").toggleClass("col-md-9 col-md-12");
			$("#sidebar").toggleClass("abc1 abc2");
			
			//$(".fa .fa-bars").hide();
			$(".toggle-sidebar").toggleClass(" fa fa-bars fa fa-times");
			//$(".toggle-sidebar").addClass("");
			return false;
			
			
		});
	});
</script>
<script>
$(document).ready(function(){
  $('[data-toggle="tooltip"]').tooltip();   
});

function toggleIcon(e) {
    $(e.target)
        .prev('.panel-heading')
        .find(".more-less")
        .toggleClass('glyphicon-plus glyphicon-minus');
}
$('.panel-group').on('hidden.bs.collapse', toggleIcon);
$('.panel-group').on('shown.bs.collapse', toggleIcon);

</script>
</body>
</html>
