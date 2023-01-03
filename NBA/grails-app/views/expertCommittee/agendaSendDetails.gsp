<%! import org.nba.application.FormCategory %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="expertMember" />
<title>NBA</title>

</head>
<body>
	<div class="content-wrapper">
		<div class="container col-lg-12">
			<div class="row" id="row-main">
				<div class="col-md-12" id="content">
									<div class="col-lg-12 card">
										<h1 class="title"></h1>
            
										<div class="table-responsive col-lg-12">
											<table class="table" id="ec-table">
												<thead style="background-color: #c0bebe;">
													<tr>
														<th>Agenda No.</th>
														<th>Applicant Name</th>
														<th>Application No.</th>
														<th>Form Applied</th>
														<th>Approved Date</th>
														<th>Download</th>
														<th>Action For</th>
														<th>Download Recommendation</th>
													</tr>
												</thead>
												<tbody>
													<g:each in="${agendaDetails}" var="ecd" status="i">
														<tr>
														<td>${ecd?.dynamicMeetNum}</td>
															<td> ${ecd?.name}</td>
															<td>${ecd?.appNumber}</td>
															
															<td>
															${ecd?.formType}
														
															<g:set value="previewForm${ecd?.formType?.substring(5)}Info" var="dyaction"/>
															</td>
															<td>
															<g:formatDate format="dd/MM/yyyy" date="${ecd?.sendDate}"/>
															</td>
															<td><g:link action="pdfAgendaDownload" controller="expertCommittee"
															params="${[downId:ecd?.id, csrfPreventionSalt:csrfPreventionSalt] }" target="_blank">
															pdf</g:link><br/>
															
<%--															<g:link action="wordAgendaDownload" controller="expertCommittee"--%>
<%--															params="${[downId:ecd?.id, csrfPreventionSalt:csrfPreventionSalt] }" target="_blank">--%>
<%--															word</g:link>--%>
															</td>

															<td>
	      <g:remoteLink action="${dyaction}" controller="FormPreview" title="View Application" id="${ecd?.applicationForm1?.id }"
				params='[fromLogin:"true",appFormId:ecd?.applicationForm1?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'
			    data-target="#app-modal" data-toggle="modal" update="nin">View Application</g:remoteLink>														
															
															
                                                          </td>
															
															<g:if test="${ecd?.recoStatus}">
															<td><g:link action="recomDownload" controller="expertCommittee"
															params="${[downId:ecd?.id, csrfPreventionSalt:csrfPreventionSalt] }" target="_blank">
															Download</g:link></td>
															
															</g:if>
															<g:else>
														<td><button id="whateverID" type="button" class="btn btn-danger" data-toggle="modal" data-target="#test-modal">Add Recommendation</button>	
															
															
                                  <%--Application details modal--%>
 	<div id="app-modal" class="modal fade" role="dialog">
<div class="modal-dialog modal-lg">
   <!-- Modal content-->
<div class="modal-content" style="padding:20px;" id="nin">

  <div class="modal-body" >
 
</div>
 </div>
</div>
</div>




	 <!--Recommendation Modal -->
  <div class="modal fade" id="test-modal" data-modal-index="1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title">Expert Recommendation</h4>
      </div>
      <div class="modal-body">
     
        <g:form  controller="expertCommittee" action="saveRecommendation" method="POST">
        <g:hiddenField name="agenId" value="${ecd.id}" />
        <g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
    
                  <table class="table table-bordered customtable main-account">
						<tbody>
							<tr>
								<td colspan="4" class="text-center"><b><u>Part B: To be checked by the Expert Committee</u></b></td>
							</tr>
							<tr>
								<td><b>13.</b></td>
								<td colspan="2"><b>Whether Traditional Knowledge has
										been used*</b></td>
								<td><g:textField name="whetherTraditional" required="true"/></td>
							</tr>
							<tr>
								<td><b>14.</b></td>
								<td colspan="2"><b>Screening of the bioresources
										species*</b></td>
								<td><g:textField name="screeningBiores" required="true"/></td>
							</tr>
							<tr>
								<td></td>
								<td><b>(a)</b></td>
								<td><b>Whether Rare/Endemic/Endangered/Threatened*</b></td>
								<td><g:textField name="rareEndemic" required="true"/></td>
							</tr>
							<tr>
								<td></td>
								<td><b>(b)</b></td>
								<td><b>Whether listed under Wildlife Act/CITES/BDA, etc*</b></td>
								<td><g:textField name="wildlifeAct" required="true"/></td>
							</tr>
							<tr>
								<td></td>
								<td><b>(c)</b></td>
								<td><b>Whether restricted/prohibited under EXIM
										policy/DGFT guidelines/rules*</b></td>
								<td><g:textField name="restricted" required="true"/></td>
							</tr>
							<tr>
								<td><b>15.</b></td>
								<td colspan="2"><b>Whether the original file of the
										applicant was placed before the EC*</b></td>
								<td><g:textField name="originalFile" required="true"/></td>
							</tr>
							<tr>
								<td><b>16.</b></td>
								<td colspan="2"><b>Whether the proposal is likely to
										have an adverse impact on environment/sustainability of use/
										livelihoods/ national interest</b></td>
								<td><g:textField name="proposal"/></td>
							</tr>
							<tr>
								<td><b>17.</b></td>
								<td colspan="2"><b>Any other item </b></td>
								<td><g:textField name="anyOther"/></td>
							</tr>
							<tr>
								<td colspan="6"><b>Recommendations of the Expert
										Committee on ABS (to be incorporated in the prescribed
										agreement format once approved by the Authority):</b><br>
								
						
				         <textarea name="expertView" style="width:100%"></textarea>
								</td>
							</tr>
						</tbody>
					</table>

          <div class="modal-footer">
         <button class="btn btn-primary" name="Ec Reomm." >Submit</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
        </g:form>
        
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

   </td>
</g:else>													
														</tr>
													</g:each>

												</tbody>
											</table>
										</div>

									</div>

								</div>
								
	<g:render template="/common/dashRightComm"></g:render>							
								
								
							</div>
						</div>
					</div>
		<script>
		$(document).ready(function() {

			$(".toggle-sidebar").click(function() {
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
		$(document).ready(function() {
			$('[data-toggle="tooltip"]').tooltip();
		});

		function toggleIcon(e) {
			$(e.target).prev('.panel-heading').find(".more-less").toggleClass(
					'glyphicon-plus glyphicon-minus');
		}
		$('.panel-group').on('hidden.bs.collapse', toggleIcon);
		$('.panel-group').on('shown.bs.collapse', toggleIcon);
	</script>
	
</body>
</html>