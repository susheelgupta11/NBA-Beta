
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />
<title>NBA</title>
<script>
	$(document).ready(function() {
		// create Calendar from div HTML element
		$('[data-toggle="tooltip"]').tooltip();
		$("#calendar").kendoCalendar();
		$(".k-content").addClass("table table-bordered");
	});
</script>
</head>
<body>

	<div class="row">
		<div id="homebackgournd" class="col-sm-10 col-sm-offset-1 border">

			<div id="topmargin" class="col-sm-12 form-group border">
				<div class="col-sm-2 ">
					<g:link controller="applicationManagement"
						action="selectIndividualOrCompany" class="form-link-btn"
						params='[formType:"Form1",currentUser:currentUser]'
						data-toggle="tooltip" title="Click here to apply">
						<span> Form I</span>
					</g:link>



				</div>
				<span class="col-sm-10 top">Application form for access to
					biological resources and associated traditional knowledge. </span>
			</div>



			<div class="col-sm-12 form-group border">
				<div class="col-sm-2 less_pad">
					<g:link controller="applicationManagement"
						action="selectIndividualOrCompany" class="form-link-btn"
						params='[formType:"Form2",currentUser:currentUser]'
						data-toggle="tooltip" title="Click here to apply">
						<span> Form II</span>
					</g:link>
				</div>
				<span class="col-sm-10 top"> Application form for
					transferring the results of research to foreign nationals,
					companies, NRIs for commercial purposes. </span>

			</div>

			<div class="col-sm-12 form-group border">
				<div class="col-sm-2 less_pad">
					<g:link controller="applicationManagement"
						action="selectIndividualOrCompany" class="form-link-btn"
						params='[formType:"Form3",currentUser:currentUser]'
						data-toggle="tooltip" title="Click here to apply">
						<span> Form III</span>
					</g:link>
				</div>
				<span class="col-sm-10 top"> Application form for applying
					for Intellectual Property Right. </span>

			</div>
			<div class="col-sm-12 form-group border">
				<div class="col-sm-2 less_pad">
					<g:link controller="applicationManagement"
						action="selectIndividualOrCompany" class="form-link-btn"
						params='[formType:"Form4",currentUser:currentUser]'
						data-toggle="tooltip" title="Click here to apply">
						<span> Form IV</span>
					</g:link>
				</div>
				<span class="col-sm-10 top"> Application form for third party
					transfer of the accessed biological resources and associated
					traditional knowledge. </span>
			</div>
			<div class="col-sm-12 form-group border">
				<div class="col-sm-2 less_pad">
					<g:link controller="formB" action="researcherOrGovermentInst"
						class="form-link-btn"
						params='[formType:"FormB",currentUser:currentUser,csrfPreventionSalt:"${csrfPreventionSalt}"]'
						data-toggle="tooltip" title="Click here to apply">
						<span> Form B</span>
					</g:link>
				</div>
				<span class="col-sm-10 top"> Conducting of non-commercial
					research or research for emergency purposes outside India by Indian
					researcher's Government institutions. </span>
			</div>

			<div class="col-sm-12 form-group border">
				<div class="col-sm-2 less_pad">
					<g:link controller="applicationManagement"
						action="depositionOfMicroOrganism" class="form-link-btn"
						params='[formType:"FormC",currentUser:currentUser]'
						data-toggle="tooltip" title="Click here to apply">
						<span> Form C</span>
					</g:link>
				</div>
				<span class="col-sm-10 top"> Deposition of micro-organism by
					Indian scientist / researchers in non-Indian repository for claim
					of novel species. </span>
			</div>



		</div>





	</div>

	<!-- /.container -->
	<div class="clearfix"></div>
</body>

</html>
