<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />

<title>NBA</title>

</head>
<body>
	<div class="container">
		

		<div class="row">

			<div class="col-sm-8 col-sm-offset-2 middle_box ">
			<div class="col-sm-12 form-group text-center">
				<span class="heading_font">Do you need assistance to know your application form?</span></div> 
				
				
				<div class="row text-center margin-top">
					<g:link controller="loggedInAs" action="knowYourFormPart1" class="btn btn-primary btnpadding" params='[]'>Yes</g:link>
				<g:link controller="loggedInAs" action="submitApplication" class="btn btn-primary btnpadding" params='[]'>No</g:link>
				</div>
			</div>
		</div>
	</div>
</body>
</html>