
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />

<title>NBA</title>

</head>
<script type="text/javascript">
$(function(){
	form3Part5();
});

</script>
<body>
<div id="myModal" class="modal fade" role="dialog" style="z-index:9999999;">
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
        <g:link controller="applicationManagement" post="true" action="changeAppStatus" params="[appFormId:appForm?.id,formType:formType]"
						class="btn btn-success">Ok</g:link>
        <button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
      </div>
    </div>

  </div>
</div>
	


	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div id="leftTopTab" class="col-sm-2">
				<g:render template="/applicationManagement/leftTabs" model="[formType:formType]" />

			</div>

			<div class="col-sm-10">
				<div class="col-sm-12">
					<div class="checkout-wrap">
						<ul class="checkout-bar">

							<li class="previous visited first"><a href="#">Part 1</a></li>

							<li class="previous visited">Part 2</li>

							<li class="previous visited">Part 3</li>

							<li class="active">Part 4</li>
							<li>Payment</li>


						</ul>
					</div>
				</div>
				<div class="clearfix"></div>

				<div class="main-registeration col-sm-12">
					<!--login form -->

					<div class="col-sm-12">
						<div class="form-group">
							<label class="control-label col-sm-4">Download
								Declaration Form </label>
							<div class="col-sm-8">
								<g:if test="${declarationForm?.document}">
									<g:link controller="applicationManagement"
										action="showDeclarationForm" id="${declarationForm?.id}"
										target="_blank"
										params="[filename: 'declarationFormName', dataName: 'declarationFormName']">
										${declarationForm?.docName}
									</g:link>
								</g:if>
							</div>
						</div>
					</div>
					<g:uploadForm class="form-horizontal" role="form" autocomplete="off"
						action="saveForm1Part5">
					<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	
						<div class="col-sm-12 form-group">
							<span class="col-sm-4"><b>Upload Signed Declaration
									Form</b></span>
							<div class="col-sm-8">
								<g:if test="${appForm?.declarationForm || appForm?.declarationFormURL}">
									<g:link controller="applicationManagement"
										action="showSignedDeclarationForm" id="${appForm?.id}"
										target="_blank"
										params="[filename: 'declarationFormName', dataName: 'declarationFormName']">
										${appForm?.declarationFormName}
									</g:link>
								</g:if>
								<input type="file" class="form-control" name="DeclarationForm" req="1"/>
							</div>
						</div>

						<div class="col-sm-12 text-center">

							<g:hiddenField name="appFormId" value="${appForm?.id}" />
							<g:hiddenField name="formType" value="${formType}" />
							<input type="submit" name="Save and Continue" class="btn btn-primary"  value="Save"/>
							<input type="button" name="Final Submit" class="btn btn-primary" data-toggle="modal" data-target="#myModal" value="Final Submit"/>

						</div>


					</g:uploadForm>
				</div>
			</div>
		</div>
	</div>

</body>

</html>
