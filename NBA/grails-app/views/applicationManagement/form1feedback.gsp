
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />

<title>NBA</title>
<script type="text/javascript">
$(document).ready(function(){
	BindValidationMethod();
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
	
	<!-- Page Content -->
	<div class="container container1">
		<div class="row">
			
			<div class="col-sm-8 col-sm-offset-2">
				
				<div class="clearfix"></div>

				<div class="main-registeration col-sm-12">
				<g:form action = "saveFormFeedback" autocomplete="off">
				<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
					<label class="control-label col-sm-12 register-heading">
						Feedback </label>
					<div class= "text-center"><span class= "text-success "><b>${flash.message }</b></span></div>	
					<div class="col-sm-12">
						<span class="col-sm-4">Enter your feedback comment</span>
						<div class="col-sm-8">
							<g:textArea rows="5" name="feedback"  value="" class="width" req="1" ></g:textArea>
						</div>
					</div>
					
					<div class="col-sm-12 text-center">
					<g:hiddenField name="appFormId" value= "${appForm?.id }"/>
					<input type="submit" class="btn btn-primary" value="Send Feedback"  />
					<g:link controller="loggedInAs" class="btn btn-primary" action="inbox" params='[appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Back</g:link>
					</div>
				</g:form>



				</div>
			</div>
		</div>
	</div>
</body>

</html>
