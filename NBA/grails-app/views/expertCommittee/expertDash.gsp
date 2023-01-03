<%@ page import="org.nba.communication.AgendaLetterStatus" %>
<%@ page import="org.nba.communication.Agenda" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="expertMember" />
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
<%--				<g:if test="${type}">--%>
<%--				<div align="center">${type} Dashboard</div>--%>
<%--				</g:if>--%>
                          
					<div class="panel-group" id="accordion" role="tablist"
						aria-multiselectable="true">
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingOne">
								<h4 class="panel-title">
									<!--  <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne"> -->
									<a class="collapsed" role="button" data-toggle="collapse"
										data-parent="#accordion" href="#collapseOne"
										aria-expanded="true" aria-controls="collapseOne"> <i
										class="more-less glyphicon glyphicon-plus"></i>${type} Dashboard (${agendaDetails?.size()?:0})
									</a>
								</h4>
							</div>
							<div id="collapseOne" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingOne">
								<div class="panel-body">
									<div class="col-lg-12 card">
										<h1 class="title"></h1>

										<div class="table-responsive col-lg-12">
											<table class="table" id="ec1-table">
												<thead style="background-color: #c0bebe;">
													<tr>
														<th>S.No.</th>
														<th>No. of the meetings</th>
														<th>Date of the meeting</th>
														<th>Agenda Placed</th>
														<th>Recommended By EC</th>
													</tr>
												</thead>
												<tbody>
													<g:each in="${agendaDetails}" var="ec" status="i">
														<tr>
															<td>
																${i+1}
															</td>
															<td>
															${ec?.agendaCounter}
															</td>
															<td>
															<g:formatDate format="dd/MM/yyyy" date="${ec?.meetingDate}"/>
														   	
															</td>
															<td>
															${ec?.agendasentCounter?:0}
															<g:if test="${ec?.agendasentCounter}">
															<g:link action="agendaSendDetails" controller="expertCommittee" params="${[detId:ec?.id,csrfPreventionSalt:csrfPreventionSalt]}">(link view)</g:link>
															|<g:link action="agendaDownloadAll" controller="expertCommittee" params="${[dwnId:ec?.id,csrfPreventionSalt:csrfPreventionSalt]}" target="_blank">Download all</g:link>
															</g:if>
								
															</td>
															<td>
														${ec?.recoCounter?:0}
															<g:if test="${ec?.recoCounter}">
															<g:link action="agendaSendDetails" controller="expertCommittee" params="${[detId:ec?.id,csrfPreventionSalt:csrfPreventionSalt]}">(link view)</g:link>
															|<g:link action="recommDwnloadAll" controller="expertCommittee" params="${[dwnId:ec?.id,csrfPreventionSalt:csrfPreventionSalt]}" target="_blank">Download all</g:link>
															</g:if>
															</td>
														</tr>
													</g:each>

												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>

</body>
</html>