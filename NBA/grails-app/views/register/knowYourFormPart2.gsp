<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='main' />

<title>NBA</title>
<script type="text/javascript">
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>
<style type="text/css">
.tooltip-wide .tooltip {min-width:800px;}
</style>
</head>
<body>
	<div class="container">
	<div class="row">
		<div class="col-sm-8 col-sm-offset-2 text-center form_heading">
			<h3>Know Your Application Form</h3>
		</div>
		</div>



		<div class="row">
			<g:form action="savePart2" name="knowYourFormPart2" autocomplete="off">
			<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
				<div class="col-sm-8 col-sm-offset-2 middle_box">

<div class="col-sm-12 form-group">
					<span class="heading_font"><b>I intend to</b></span></div> 
					<div class="col-sm-12 form-group">
						<input type="radio" class="col-sm-1"
						name="category" value="category1" /> <span class="col-sm-11">Transfer the results of
						research on biological resources occurring in or obtained from
						India to a person covered under<a href="#" style="text-decoration:underline;"> <b data-toggle="tooltip"
						title="section 3(2): NRI / Non-Indian individual / Body corporate, association or organization, not incorporated or registered in India / Body corporate association or organization, 
incorporated or registered in India, which has any non-Indian participation in share capital or management">section 3(2) </b></a>of the BD Act</span></div>



<div class="col-sm-12 form-group">
					<input
						type="radio" name="category" class="rbo_font col-sm-1" value="category2" /><span class="col-sm-11">Obtain
					Intellectual Property Rights in India or outside, on any invention
					based on research or information on a biological resource
					obtained from India</span>
					</div>
					<div class="col-sm-12">
					 <input type="radio" name="category" value="category3" class="col-sm-1" /><span class="col-sm-11">Transfer
					/ Carry the biological resources to a foreign country for
					conducting basic non-commercial research</span> </div>
					<div class="col-sm-12 margin-top">
						<g:hiddenField name="nationality" value="${nationality}" />
						<g:hiddenField name="formPart" value="Part2" />
						<g:link controller="register" action="knowYourFormPart1" params='[]'
							class="btn btn-primary pull-left">Back</g:link>
						<input type="submit" class="btn btn-primary pull-right" value="Next" />
					</div>
				</div>
			</g:form>
		</div>
	</div>
</body>
</html>