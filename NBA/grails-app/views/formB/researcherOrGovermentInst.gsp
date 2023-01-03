
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />
<title>NBA</title>

<script type="text/javascript">
	$(document).ready(function() {
		removeSession();
		$('#profileType').val('indianResearcher');
		$("input[name='profile']").click(function() {
			var newvalue = $(this).val();
			if (newvalue == '1') {
				$('#profileType').val('indianResearcher');
			} else {
				$('#profileType').val('indianGovtInst');
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
						
							Form B<br /> (See Regulation 13 of the Guidelines on Access to biological resources and associated knowledge and Benefits Sharing Regulations, 2014) <br />
							Conducting of non-commercial research or research for emergency purposes outside India by Indian researcher/ Government institutions </h3>
							
				<div class=" registration-box">
				<div class="main-registeration">
					<!--login form -->
					<g:form class="form-horizontal" role="form" name="profileTypeForm" autocomplete="off"
						controller="formB" action="selectResearcherType">
					<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	
						<div class="col-sm-12">
							<div class="form-group"></div>
						</div>
						<div class="col-sm-12 form-group">
							
							<span class="col-sm-12 heading_font text-center"><b>I / We apply as</b></span>
<%--								<label class="control-label col-sm-3"--%>
<%--									style="font-size: 20px; font-family:Arial " for="email">--%>
<%--									I/We apply as </label>--%>
								<div class="col-sm-12 fg top">
								<div class="col-sm-5 col-sm-offset-2">
									<input type="radio" id="indianResearcher" name="profile"
										value="1" checked> Indian Researcher</div>
									<div class="col-sm-5"> <input type="radio"
										id="indianGovtInst" name="profile" value="2"> Indian Government Institution</div>
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
 