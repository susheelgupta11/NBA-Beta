<html>

<head>
<meta name='layout' content='loggedInUser' />
<title><g:message code='spring.security.ui.register.title' /></title>
<script>
	function controlswidth() {

		$('input[type=text]').addClass("width");

		$('input[type=password]').addClass("width");

		$("select").addClass("form-control");

		$("textarea").addClass("form-control");

	}

	$(document).ready(function() {
		$('[data-toggle="popover"]').popover();
		controlswidth();
		$("#datePicker").datepicker({
			yearRange : '-100:+0',
			maxDate : "0",
			changeMonth : true,
			changeYear : true,
			dateFormat : "dd/mm/yy"
		});
		BindValidationMethod();
		//$('#username').focus();
	});
</script>
</head>

<body>
	<p />

	<div class="container container1">
		<div class="row">


			<div class="col-sm-8 col-sm-offset-2">

				<div class="main-registeration-form row">
					<!--login form -->
					<div class="register-heading1">
						<h4>Edit Profile</h4>
					</div>
					<div class="text-center">
						<b><span class="text-success"> ${flash.message }
						</span></b>
					</div>
<span class=" col-sm-8 col-sm-offset-4 red form-group"><b> * Marked
							fields are mandatory </b></span>
					<g:form class="form-horizontal" role="form" autocomplete="off"
						action='saveuserDetails' name='registerForm'>
					<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	

						<g:if test='${emailSent}'>
							<g:message code='spring.security.ui.register.sent' />
						</g:if>
						<g:else>
						
							<div class="col-sm-12 form-group">



								<div class="col-sm-4">
									<label><b>Username*:</b></label>
								</div>
								<div class="col-sm-8">
									<input type="text" autocomplete="off" name='username' disabled="disabled" req="1"
										value="${currentUser?.username }" />
								</div>


							</div>


							<div class="col-sm-12 form-group">


								<div class="col-sm-4">
									<label><b>Name*:</b></label>
								</div>
								<div class="col-sm-8">
									<input type="text" autocomplete="off" name='name' req="1"
										value="${currentUser?.name }" />
								</div>

							</div>
							<div class="col-sm-12 form-group">


								<div class="col-sm-4">
									<label><b>Email*:</b></label>
								</div>
								<div class="col-sm-8">
									<input type="text" name='email' req="1" email="1" class="bold"
										value="${currentUser?.email}" />
								</div>
							</div>


							<div class="col-sm-12 form-group">


								<div class="col-sm-4">
									<label><b>Date of Birth*:</b></label>
								</div>
								<div class="col-sm-8">
									<input type="text" name='dateOfBirth' id="datePicker" req="1"
										dob="1" class="width  bold"
										value="${currentUser?.dateOfBirth?.format('dd/MM/yyyy')}" />

								</div>
							</div>


							<div class="col-sm-12 form-group">


								<div class="col-sm-4">
									<label><b>Mobile No *:</b></label>
								</div>
								<div class="col-sm-8">
									<input type="text" name='mobile' id='mobileField' req="1" mob="1"
										class="  bold" maxlength="15" value="${currentUser?.mobile}" />

								</div>
							</div>


							<div class="col-sm-12 form-group">


								<div class="col-sm-4">
									<label><b>Phone No* :</b></label>
								</div>
								<div class="col-sm-8">
									<input type="text" name='phone' class="  bold " req="1" maxlength="12"
										value="${currentUser?.phone}" />

								</div>
							</div>
							<div class="col-sm-12 form-group text-center">
								<g:link controller="login" action="auth" class="btn btn-primary" params='[csrfPreventionSalt:"${csrfPreventionSalt}"]'>Back</g:link>
								<g:hiddenField name="userId" value="${currentUser?.id }" />
								<input type="submit" class="btn btn-primary" value="Submit">


							</div>
				
				</g:else>
				</g:form>
				<!--login form ends -->
			</div>
		</div>
	</div>
	</div>
</body>
</html>
