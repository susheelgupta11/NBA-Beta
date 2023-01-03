<%! import org.nba.application.CompanyProfile %>
<%! import org.nba.application.AgentProfile %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />

<title>NBA</title>


<!--calender codes end -->
<script type="text/javascript">
	$(document).ready(function() {
		addCompletegreenClass(tabStatus);
		Entity();

		$("#otherProfile").hide();
		var profileValue = $("#profileId").val();
		if(profileValue == 'Others'){
				$("#otherProfile").show();
			}
	});
	
	function showYes() {
		$("#otherAgentProfile").hide();
		if ($('#ifYes').attr('checked', 'checked')) {
			$('.Yes').show();
			
		}
		var value=$("#agentProfileId").val();
		if(value == 'Others'){
			$("#otherAgentProfile").show();
			}
	}
</script>
</head>

<body>
	<g:javascript>
  var fetchCodes = "${createLink(controller:'applicationManagement',action:'fetchMobileCode')}"
	var tabStatus = "${tabStatus}"
	var csrfPreventionSalt = "${csrfPreventionSalt}"
  </g:javascript>
	<%--<nav class="navbar-default" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

			</div>

		</div>
		<!-- /.container -->
	</nav>



	--%><!-- Page Content -->
	<div class="container">
		<div class="row">
			<div id="leftTopTab" class="col-sm-2">
				<g:render template="leftTabs" />

			</div>

			<div class="col-sm-10">

				<div class="col-sm-12">
					<div class="checkout-wrap">
						<ul class="checkout-bar">

							<li><a href="#">Part 1</a></li>

							<li>Part 2</li>

							<li>Part 3</li>

							<li>Part 4</li>
							<li>Part 5</li>
							<li>Preview</li>
							<li>Payment</li>

						</ul>
					</h3>--%>

					</div>
					<div class="clearfix"></div>
					<g:if test="${flash?.message}">

					</g:if>
					<div class="main-registeration col-sm-12 " >
						<!--login form -->
						<div id="addEditCompanyProfile">
							<g:render template="companyProfile"
								model="[companyProfile1:companyProfile1,listOfCompanyProfiles:listOfCompanyProfiles,appForm:appForm]"></g:render>
						</div>
						<div class="col-sm-12">
							<g:if test="${listOfCompanyProfiles != null}">
								<g:render template="companyProfileGrid"
									model='[csrfPreventionSalt:"${csrfPreventionSalt}",appForm:appForm,companyProfile1:companyProfile1,listOfCompanyProfiles:listOfCompanyProfiles,formType:formType,deleteCompanyCalled:deleteCompanyCalled]'></g:render>
							</g:if>
						</div>



						<div id="addEditAgentProfile">
							<g:render template="addAgentProfile"
								model="[agentProfile:agentProfile,profiles:profiles,company:company,listOfStates:listOfStates]"></g:render>
						</div>

						<%--				AGENT PROFILE GRID STARTS HERE--%>
						<div id="updateAgentProfile" class="col-sm-12 table-responsive">
							<g:if test="${agentProfile}">
								<g:render template="agentProfileGrid"
									model="[appForm:appForm,agentProfile:agentProfile,company:company,listOfStates:listOfStates ]"></g:render>
							</g:if>
						</div>

						<%--				AGENT PROFILE GRID ENDS HERE--%>

					</div>

					<div class=" col-sm-12 text-right">
						<div class="col-sm-12">
							<g:if test="${formType == 'Form1'}">
								<g:link controller="applicationManagement" action="form1Part2"
									params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
									class="btn btn-primary btnfirstNext inactive" method="POST">Next</g:link>
							</g:if>
							<g:elseif test="${formType == 'Form2'}">
								<g:link controller="form2" action="part2"
									params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
									class="btn btn-primary btnfirstNext inactive" method="POST">Next</g:link>
							</g:elseif>
							<g:elseif test="${formType == 'Form3'}">
								<g:link controller="form3" action="part2"
									params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
									class="btn btn-primary btnfirstNext inactive" method="POST">Next</g:link>
							</g:elseif>
							<g:elseif test="${formType == 'Form4'}">
								<g:link controller="form4" action="part2"
									params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
									class="btn btn-primary btnfirstNext inactive" method="POST">Next</g:link>
							</g:elseif>
						</div>
					</div>

					<!--login form ends -->
				</div>



			</div>
		</div>
	</div>
	<!-- /.container -->
	<div class="clearfix"></div>

</body>

</html>
