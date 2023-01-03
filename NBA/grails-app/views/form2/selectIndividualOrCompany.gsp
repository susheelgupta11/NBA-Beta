
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />
<title>NBA</title>

<script type="text/javascript">
	$(document).ready(function() {
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
	<div class="container">
		<div class="row">
			<div class="col-sm-2">

				<g:render template="leftTabs"/>

			</div>

			<div class="col-sm-10">
				<div class="main-registeration-form">
					<!--login form -->
					<g:form class="form-horizontal" role="form" name="profileTypeForm" autocomplete="off"
						controller="form2" action="selectProfileType">
					<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	
						<div class="col-sm-12">
							<div class="form-group"></div>
						</div>
						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-5"
									style="font-size: 20px; font-family: cursive" for="email">
									I/We apply as </label>
								<div class="col-sm-7 fg">
									<input type="radio" id="individualProfile" name="profile"
										value="1" checked> Individual(s)
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
										id="companyProfile" name="profile" value="2"> Entity
								</div>
							</div>
						</div>

						<div class="form-group">


							<div class="col-sm-12 text-center toppadding">
								<g:hiddenField name="profileType" id="profileType" value="" />
								<button type="submit" class="btn btn-primary ">Submit</button>
							</div>

						</div>
					</g:form>
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
