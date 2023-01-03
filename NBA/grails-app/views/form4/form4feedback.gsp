
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />

<title>NBA</title>

</head>

<body>
	<div id="myModal" class="modal fade" role="dialog"
		style="z-index: 9999999;">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Confirm message</h4>
				</div>
				<div class="modal-body">
					<p>Are you sure you want to submit the form ?</p>
				</div>
				<div class="modal-footer">
					<g:link controller="applicationManagement" action="form1Payment"
						class="btn btn-success">Ok</g:link>

				</div>
			</div>

		</div>
	</div>
	<nav class="navbar-default" role="navigation">
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

	<!-- Page Content -->
	<div class="container container1">
		<div class="row">
			
			<div class="col-sm-8 col-sm-offset-2">
				
				<div class="clearfix"></div>

				<div class="main-registeration col-sm-12">
					<label class="control-label col-sm-12 register-heading">(i)
						Feedback </label>
						
					<div class="col-sm-12">
						<span class="col-sm-4">Enter your feedback comment</span>
						<div class="col-sm-8">
						<textarea rows="5" class="width"></textarea>
						</div>
						
					</div>
					
					<div class="col-sm-12 text-center">
					<input type="button" class="btn btn-primary" value="Send Feedback"/>
					<input type="button" class="btn btn-primary" value="Back"/>
					</div>




				</div>
			</div>
		</div>
	</div>
</body>

</html>
