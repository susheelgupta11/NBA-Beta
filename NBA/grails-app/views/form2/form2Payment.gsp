
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />

<title>NBA</title>
<script type="text/javascript">
	$(document).ready(
			function() {
				freezTopLeftTab();
				AddActiveClass("menu6");
			});
</script>
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
			<div id="leftTopTab" class="col-sm-2">
				<g:render template="/applicationManagement/leftTabs" model="[formType:formType]" />

			</div>

			<div class="col-sm-10">
				<div class="col-sm-12">
					<div class="checkout-wrap">
						<ul class="checkout-bar">
							<li class="previous visited first"><a href="#">Part 1</a></li>

							<li class="previous visited first">Part 2</li>

							<li class="previous visited first">Part 3</li>

							<li class="previous visited first">Part 4</li>
							<li class="active">Part 5</li>
							<li class="">Payment</li>
						</ul>
					</div>
				</div>
				<div class="clearfix"></div>

				<div class="main-registeration col-sm-12">
					<label class="control-label col-sm-12 register-heading">(i)
						Payment</label>
						<div class="col-sm-12">
						<h4>Your Transaction Id:-</h4>
						<span>ABCD#@123587</span>
						
						</div>
					<div class="col-sm-12">
						<h4 class="col-sm-4">Click here to go to Payment page</h4>
						<a class="col-sm-2 margin-top" href="#">Click Here</a>
					</div>




				</div>
			</div>
		</div>
	</div>
</body>

</html>
