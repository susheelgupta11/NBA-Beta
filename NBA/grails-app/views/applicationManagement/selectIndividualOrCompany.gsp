
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />
<title>NBA</title>

<script type="text/javascript">
	$(document).ready(function() {
		removeSession();
		$('#profileType').val('individualProfile');
		$("input[name='profile']").click(function() {
			var newvalue = $(this).val();
			if (newvalue == '1') {
				$('#profileType').val('individualProfile');
			} else {
				$('#profileType').val('companyProfile');
			}
		});

	});
</script>
</head>

<body>





	<!-- Page Content -->
	<div class="container ">
		<div class="row">
			

			<div class="col-sm-8 col-sm-offset-2">
			<h3 class="about-login-heading hh">
						<g:if test="${formType == 'Form1'}">
							Form I<br /> (See Rule 14 of Biological Diversity Rules, 2004) <br />
							Application form for access to biological resources and
							associated traditional knowledge </g:if>
						<g:elseif test="${formType == 'Form2'}">
							Form II <br />
(See Rule 17 of Biological Diversity Rules, 2004)<br />
Application for seeking prior approval of National Biodiversity Authority for transferring the results of research to foreign nationals, companies, NRIs for commercial purposes</g:elseif>
						<g:elseif test="${formType == 'Form3'}">
							Form III <br /> (See Rule 18 of Biological Diversity Rules, 2004)<br />
Application for seeking prior approval of National Biodiversity Authority for applying for Intellectual Property Right </g:elseif>
						<g:elseif test="${formType == 'Form4'}">
							Form IV <br /> (See Rule 19 of Biological Diversity Rules, 2004)<br />
Application form for seeking approval of National Biodiversity Authority for third party transfer of the accessed biological resources and associated traditional knowledge </g:elseif>
					</h3>
				<div class=" registration-box">
				<div class="main-registeration">
					<!--login form -->
					<g:form class="form-horizontal" role="form" name="profileTypeForm" autocomplete="off"
						controller="applicationManagement" action="selectProfileType">
					<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	
						<div class="col-sm-12">
							<div class="form-group"></div>
						</div>
						<div class="col-sm-12 form-group">
							
							<span class="col-sm-12 heading_font text-center"><b>I / We apply as</b></span>
								<div class="col-sm-12 fg top">
								<div class="col-sm-5 col-sm-offset-2">
									<input type="radio" id="individualProfile" name="profile"
										value="1" checked> Individual(s)</div>
									<div class="col-sm-5"> <input type="radio"
										id="companyProfile" name="profile" value="2"> Entity</div>
								</div>
							
						</div>

						<div class="form-group">


							<div class="col-sm-12 text-center toppadding">
								<g:hiddenField name="profileType" id="profileType" value="" />
								<g:hiddenField name="formType"  value="${formType}" />
								<button type="submit" class="btn btn-primary ">Submit</button>
							</div>

						</div>
					</g:form>
					</div>
					<!--login form ends -->
				</div>

			</div>
		</div>

	</div>
	</div>
	<!-- /.container -->
	<div class="clearfix"></div>

</body>

</html>
