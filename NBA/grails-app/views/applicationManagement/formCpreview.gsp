
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />

<title>NBA</title>
<script type="text/javascript">
	$(document).ready(function() {
		form1part5();
	});
</script>
</head>

<body>



	<!-- Modal -->
	<div id="myModal5" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Modal Header</h4>
				</div>
				<div class="modal-body">
					<p>Some text in the modal.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>

	<!-- Modal -->

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
					<g:link controller="applicationManagement" post="true"
						action="changeAppStatus"
						params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'
						class="btn btn-success">Ok</g:link>
					<button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
				</div>
			</div>

		</div>
	</div>
	

	<!-- Page Content -->
	<div class="container ">
		<div class="row">
			<%--			<div id="leftTopTab" class="col-sm-2">--%>
			<%--				<g:render template="leftTabs" model="[formType:formType]" />--%>
			<%----%>
			<%--			</div>--%>

			<div class="col-sm-10 col-sm-offset-1">
<%--				<div class="col-sm-12">--%>
<%--					<div class="checkout-wrap">--%>
<%--						<ul class="checkout-bar">--%>
<%----%>
<%--							<li class="previous visited first"><a href="#">Part 1</a></li>--%>
<%----%>
<%--							<li class="previous visited">Part 2</li>--%>
<%----%>
<%--							<li class="previous visited">Part 3</li>--%>
<%----%>
<%--							<li class="previous visited">Part 4</li>--%>
<%--							<li class="active">Part 5</li>--%>
<%--							<li>Preview</li>--%>
<%--							<li>Payment</li>--%>
<%----%>
<%----%>
<%--						</ul>--%>
<%--					</div>--%>
<%--				</div>--%>
				<div class="clearfix"></div>



				<div class="main-registeration col-sm-12">
					<div class="col-sm-12 text-center">
						<h3>
							<b> Form Preview</b>
						</h3>
					</div>
					<modalbox:modalIncludes />
					<g:if test="${formType == 'FormC'}">
						<modalbox:createLink action="previewFormCInfo"
							controller="FormPreview" title="Form C Preview" width="1000" params= '[csrfPreventionSalt:"${csrfPreventionSalt}"]'
							height="1200" id="${appForm?.id }">Click here to go to preview </modalbox:createLink>
						
					</g:if>
					
					<div>
					<g:link controller="applicationManagement" action="formCPart4"
						
						params='[appFormId:"${appForm?.id }",formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Go back to submit.</g:link>
						
					</div>


				</div>
			</div>
		</div>

	</div>

</body>

</html>
