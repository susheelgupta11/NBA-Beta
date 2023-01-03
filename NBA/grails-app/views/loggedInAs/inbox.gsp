<%! import org.nba.application.AppStatus %>
<%! import org.nba.application.FormCategory %>
<%! import java.text.SimpleDateFormat %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='superAdmin' />
<title>NBA</title>
</head>

<body>

	

<g:if test="${flash?.message}">
			<script>
	      alert("${flash?.message}");
			</script>
		</g:if>
<sec:ifAnyGranted roles="ADMIN">
<g:set var="getAdminRole" value="ADMIN" />
</sec:ifAnyGranted>
	<!-- Page Content -->
  <div class="content-wrapper usess">
    <div class="col-sm-12 table-responsive">
					
					<table class="table table-bordered" id="form-data">
						<thead class="bg-primary">

							<tr>
								<th>S.No.</th>
								<th>Applicant Name</th>
								<th>Form Applied</th>
							<th>Application No.</th> 
								<th>Status</th>
								<g:if test="${adminUser }">
									<th>Submission Date</th>
								</g:if>
								<th class="no-sort">Action</th>
							</tr>
						</thead>
						<tbody>

							<g:if test="${applications}">
								<%def i=params?.offset==0?1:params?.offset?.toInteger()+1%>

								<g:each in="${applications}" var="app">
									<tr>
										<td><%=i %></td>
										<%i++ %>
										<td>
									${app.applicant_name }
											</td>
										
										<td>
										<g:if test="${app?.category == 'Form_1'}">
										<g:set value="previewForm1Info" var="dyaction"/>Form I
										</g:if>
										<g:elseif  test="${app?.category == 'Form_2'}">
										<g:set value="previewForm2Info" var="dyaction"/>Form II
										</g:elseif>
										
										<g:elseif  test="${app?.category == 'Form_3'}">
										<g:set value="previewForm3Info" var="dyaction"/>Form III
										</g:elseif>
										
										<g:elseif  test="${app?.category == 'Form_4'}">
										<g:set value="previewForm4Info" var="dyaction"/>Form IV
										</g:elseif>
										<g:elseif  test="${app?.category == 'Form_B'}">
										<g:set value="previewFormBInfo" var="dyaction"/>Form B
										</g:elseif>
										<g:elseif  test="${app?.category == 'Form_C'}">
										<g:set value="previewFormCInfo" var="dyaction"/>Form C
										</g:elseif>
												</td>
											
										<td>
											${app?.app_number} 
										</td>

										<td>
											${app?.status}
										</td>
										<g:if test="${adminUser}">
											<td>
<%--											<g:set var="sdf" value="${new SimpleDateFormat('yyyy-MM-dd')}" /> --%>
<%--											<g:set var="sdf1" value="${new SimpleDateFormat('dd/MM/yyyy')}" />--%>
<%--											<g:set var="date" value="${sdf?.parse(app?.submitted_on)}" />--%>
<%--												${sdf1?.format(date) }--%>
<%--                                                                    ${app?.submitted_on}--%>
                                                                    ${app?.to_char}
										</td>
										</g:if>

										<td>
									    <g:remoteLink action="${dyaction}"
																controller="FormPreview" title="View Application" id="${app?.id }"
																params='[fromLogin:"true",appFormId:app?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'
																data-target="#success" data-toggle="modal" update="nin">
																<i class="fa fa-file"></i>
															</g:remoteLink>

									</td>
									</tr>
								</g:each>
							</g:if>
							<g:else>
								<tr>
									<g:if test="${!adminUser}">
										<td colspan="6" class="text-center text-danger">No
											applications found</td>
									</g:if>
									<g:elseif test="${adminUser}">
										<td colspan="7" class="text-center text-danger">No
											applications found</td>
									</g:elseif>
								</tr>
							</g:else>
							
						</tbody>
				
					</table>
<%--		MODAL CODE			--%>

<div id="success" class="modal fade" role="dialog">
<div class="modal-dialog modal-lg">
   <!-- Modal content-->
<div class="modal-content" style="padding:20px;" id="nin">
  <div class="modal-body" >
</div>
<div class="modal-footer">
  <button type="button" class="btn btn-default"  data-dismiss="modal">Close</button>
 </div>
 </div>
</div>
</div>	

				</div>
			</div>

			<div class="col-sm-3"></div>

	<!-- /.container -->
	<div class="clearfix"></div>

	



</body>

</html>
