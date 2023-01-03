<div class="panel panel-default">
	<div class="panel-heading" role="tab" id="headingThree">
		<h4 class="panel-title">
			<a class="collapsed" role="button" data-toggle="collapse"
				data-parent="#accordion" href="#collapseThree" aria-expanded="false"
				aria-controls="collapseThree"> <i
				class="more-less glyphicon glyphicon-plus"></i>Record Room
				Application (${recordRoomApplication?.size()?:0 })
			</a>
		</h4>
	</div>
	<div id="collapseThree" class="panel-collapse collapse" role="tabpanel"
		aria-labelledby="headingTwo">
		<div class="panel-body">
			<div class="col-lg-12 card">
				<h1 class="title"></h1>
				<div class="table-responsive col-lg-12">
					<table class="table" id="myTable3">
						<thead class="thead-dark-reco">
							<tr>
								<th>S.No.</th>
								<th>Application Title</th>
								<th>Move By</th>
								<th>Move Date</th>
								<th>Status</th>
								<th>App. Submitted Date</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
						
							<g:each in="${recordRoomApplication}" var="applicationDetail"
								status="i">
<%--								<g:if test="${applicationDetail?.currentStatus?.statusUpdate}">--%>
									<tr>
										<td>
											${i+1}
										</td>
										<td>
											${applicationDetail?.appNumber}
										</td>
										<td>
											${applicationDetail?.currentStatus?.changedBy?.name}
										</td>
										<td><g:formatDate format="dd/MM/yyyy"
												date="${applicationDetail?.currentStatus?.forwardedDate}" /></td>

										<td><g:if
												test="${applicationDetail?.currentStatus?.statusUpdate}">
												${applicationDetail?.currentStatus?.statusUpdate}
											</g:if> <g:else>
												Update soon
												</g:else></td>
										<td>
											${applicationDetail?.submittedOn}
										</td>

										<td><g:link action="addNote" controller="dashboard"
												params="${[instance:applicationDetail?.id,csrfPreventionSalt:csrfPreventionSalt] }"
												title="Assign to another user">
												<i class="fa fa-send"></i>
											</g:link>
											 <%--  <g:link controller="dashboard" action="movetoInbox" onclick="return confirmation('Are you sure to resend this')" params="${[instance:applicationDetail?.id,csrfPreventionSalt:csrfPreventionSalt] }" title="Send to another user"><i class="fa fa-send"></i> </g:link>	--%>

										</td>
									</tr>
<%--								</g:if>--%>
							</g:each>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="panel panel-default">
	<div class="panel-heading" role="tab" id="headingFour">
		<h4 class="panel-title">
			<a class="collapsed" role="button" data-toggle="collapse"
				data-parent="#accordion" href="#collapseFour" aria-expanded="false"
				aria-controls="collapseTwo"> <i
				class="more-less glyphicon glyphicon-plus"></i>Approved Application
				(${approvedApplications?.size()?:0 })
			</a>
		</h4>
	</div>
	<div id="collapseFour" class="panel-collapse collapse" role="tabpanel"
		aria-labelledby="headingTwo">
		<div class="panel-body">
			<div class="col-lg-12 card">
				<h1 class="title"></h1>
				<div class="table-responsive col-lg-12">
					<table class="table" id="myTable4">
						<thead class="thead-dark-sec">
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
										<g:formatDate format="dd/MM/yyyy" date="${applicationDetail?.currentStatus?.forwardedDate}"/>
											
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
		</div>
	</div>
</div>
<div class="panel panel-default">
	<div class="panel-heading" role="tab" id="headingFive">
		<h4 class="panel-title">
			<a class="collapsed" role="button" data-toggle="collapse"
				data-parent="#accordion" href="#collapseFive" aria-expanded="false"
				aria-controls="collapseTwo"> <i
				class="more-less glyphicon glyphicon-plus"></i>Rejected Application(${rejectedApplications?.size()?:0 })
			</a>
		</h4>
	</div>
	<div id="collapseFive" class="panel-collapse collapse" role="tabpanel"
		aria-labelledby="headingTwo">
		<div class="panel-body">
			<div class="col-lg-12 card">
				<h1 class="title"></h1>
				<div class="table-responsive col-lg-12">
					<table class="table" id="myTable5">
						<thead class="thead-dark-rej">
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
										<td>
											${l+1}
										</td>
										<td>
											${applicationDetail?.appNumber}
										</td>
										<td><g:formatDate format="dd/MM/yyyy"
												date="${applicationDetail?.currentStatus?.forwardedDate}" /></td>
										<td>
											${applicationDetail?.currentStatus?.statusUpdate}
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