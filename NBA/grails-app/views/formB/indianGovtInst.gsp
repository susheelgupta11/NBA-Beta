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
	BindValidation("ctlwidth", "btnctrl");
	BindValidation("controlclass1", "btnctrl");
	checksession(this);
	removeSession();
	if(sameAsAbove == 'No'){
		$("#diffPresentAddresss").show();
	}
	else{
		$("#diffPresentAddresss").hide();
		}

	if(sameAsAbove == 'Yes'){
		$("#diffPresentAddresss").each(function() {
			$('input[type="submit"]').removeClass("btnctrl");
		});
		}	
	
	AddActiveClass("menu1");
	addCompletegreenClass(tabStatus);
	Entity();

	$("#otherProfile").hide();
	var profileValue = $("#profileId").val();
	if (profileValue == 'Others') {
		$("#otherProfile").show();
	}
	
	
});

function presentAddressSame(){ 
	$("#diffPresentAddresss").hide();
	
	$("#diffPresentAddresss").each(function() {
			$('input[type="submit"]').removeClass("btnctrl");
		});
}

function diffPresentAddress(){
	$("#diffPresentAddresss").show();

	$("#diffPresentAddresss").each(function() {
		$('input[type="submit"]').addClass("btnctrl");
	});
}

	function showYes() {
		$("#otherAgentProfile").hide();
		if ($('#ifYes').attr('checked', 'checked')) {
			$('.Yes').show();

		}
		var value = $("#agentProfileId").val();
		if (value == 'Others') {
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



	--%>
	<!-- Page Content -->
	
	
	<div class="container">
		<div class="row">
			<div id="leftTopTab" class="col-sm-2">
				<g:render template="/applicationManagement/leftTabs" />

			</div>

			<div class="col-sm-10">

				<div class="col-sm-12">
					<%--		Header Part			--%>

					<div class="checkout-wrap">
						<ul class="checkout-bar">

							<li><a href="#">Part 1</a></li>

							<li>Part 2</li>

							<li>Part 3</li>

							<li>Part 4</li>
							<li>Part 5</li>
							<%--							<li>Preview</li>--%>
							<li>Preview</li>
							<li>Payment</li>

						</ul>
					</div>
					<%--Header Part--%>
				</div>
			
			
				<div class="col-sm-12">
					
					<div class="clearfix"></div>
					<g:if test="${flash?.message}">

					</g:if>
					<div class="main-registeration col-sm-12 ">
						<!--login form -->
						<div id="addEditCompanyProfile">
							<g:render template="indianGovtInst"
								model="[indianGovtInst:indianGovtInst1,listOfCompanyProfiles:listOfCompanyProfiles,appForm:appForm]"></g:render>
						</div>
						
						<div class="col-sm-12 table-responsive" id="individualProfileGrid">
	
							<g:if test="${listOfIndianGovtInst!=null}">
								<g:render template="indianGovtInstGrid"
									model='[csrfPreventionSalt:"${ csrfPreventionSalt}",appFormId:appForm?.id,indianGovtInst:indianGovtInst1,listOfIndianGovtInst:listOfIndianGovtInst,deleteCalled:deleteCalled]'></g:render>
							</g:if>
						</div>


						

						<%--				AGENT PROFILE GRID STARTS HERE--%>
						

						<%--				AGENT PROFILE GRID ENDS HERE--%>

					</div>

					<div class=" col-sm-12 text-right">
						<div class="col-sm-12">
							
								<g:link controller="formB" action="formBPart2"
									params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
									class="btn btn-primary btnfirstNext inactive" method="POST">Next</g:link>
						
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
