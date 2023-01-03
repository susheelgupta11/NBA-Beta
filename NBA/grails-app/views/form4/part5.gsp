
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />

<title>NBA</title>


<%--<modalbox:modalIncludes /> --%>

<script type="text/javascript">
	$(document).ready(function() {
		addCompletegreenClass(tabStatus);
		form4Part5();
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		var r = $("input[type='radio'][name='radio']:checked").val()
		if (r && r == 'digital') {
			$("#DigitalSignature").show();
			$("#declarestatement").show();
			$(".preview").removeAttr('disabled');
		} else if (r && r == 'withoutdigital') {
			$("#Nosignature").show();
			$("#declarestatement").show();
			$(".preview").removeAttr('disabled');
		}

	});
</script>
</head>

<body>

	<g:javascript>
	var appFormId= "${appForm?.id}"	
	var declaration= "${declaration }"
	var tabStatus = "${tabStatus}"
  </g:javascript>

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



	<%--	modelContent--%>
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
					<p>Are you sure you want to make the payment now ?</p>
				</div>
				<div class="modal-footer">
					<g:link controller="applicationManagement" post="true"
						action="changeAppStatus"
						params="[formType:formType,appFormId:appForm?.id]"
						class="btn btn-success">Ok</g:link>
					<button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
				</div>
			</div>

		</div>
	</div>

	<%--	modelContentEnds--%>








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
	<div class="container ">
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
							<li>Part 5</li>
							<li>Preview</li>
							<li>Payment</li>


						</ul>
					</div>
				</div>
				<div class="clearfix"></div>

				<div class="main-registeration col-sm-12">
					<%--				 <modalbox:modalIncludes />--%>
					<%--				<modalbox:createLink action="previewForm1Info"--%>
					<%--					controller="FormPreview" title="Form 1 Preview" width="1000"--%>
					<%--					height="1200">Click here to go to preview </modalbox:createLink>--%>
					<%--					--%>
					<div class="col-sm-10 text-center">
						<h4>
							<b>Declaration</b>
						</h4>

					</div>
					<%--					<g:form controller="applicationManagement" action="changeAppStatus">--%>
					<g:form autocomplete="off">
					<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
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
										<p>Are you sure you want to make the payment now ?</p>
									</div>
									<div class="modal-footer">
										<g:hiddenField name="formType" value="${formType}" />
										<g:actionSubmit action="changeAppStatus"
											class="btn btn-primary" value="OK" />
										<%--										<input type="submit" class="btn btn-primary" name="submit" value="OK">--%>
										<button type="button" class="btn btn-primary"
											data-dismiss="modal">Cancel</button>
									</div>
								</div>

							</div>
						</div>
						<div class="col-sm-12 text-center form-group">
							<g:if test="${!declaration }">
								<div class="col-sm-6 form-group less-padding">
									<input type="radio" class="leftflot" name="radio"
										value="withoutdigital"
										onclick="showhideDigitalSignature(this)" /><span
										class="leftflot"> &nbsp; <b>Declaration without
											digital signature</b></span>
								</div>
								<div class="col-sm-6 form-group less-padding">
									<input type="radio" class="leftflot " name="radio"
										value="digital" onclick="showhideDigitalSignature(this)" /><span
										class="leftflot"> &nbsp;<b>Declaration with digital
											signature</b></span>
								</div>
							</g:if>
							<g:elseif test="${declaration }">
								<g:if test="${appForm?.isDeclarationDigitallySigned == 'true' }">
									<div class="col-sm-6 form-group less-padding">
										<input type="radio" class="leftflot" name="radio"
											value="withoutdigital"
											onclick="showhideDigitalSignature(this)" /><span
											class="leftflot"> &nbsp; <b>Declaration without
												digital signature</b></span>
									</div>

									<div class="col-sm-6 form-group less-padding">
										<input type="radio" class="leftflot " name="radio"
											checked="checked" value="digital"
											onclick="showhideDigitalSignature(this)" /><span
											class="leftflot"> &nbsp;<b>Declaration with
												digital signature</b></span>
									</div>
								</g:if>
								<g:else>
									<div class="col-sm-6 form-group less-padding">
										<input type="radio" class="leftflot" name="radio"
											checked="checked" value="withoutdigital"
											onclick="showhideDigitalSignature(this)" /><span
											class="leftflot"> &nbsp; <b>Declaration without
												digital signature</b></span>
									</div>

									<div class="col-sm-6 form-group less-padding">
										<input type="radio" class="leftflot " name="radio"
											value="digital" onclick="showhideDigitalSignature(this)" /><span
											class="leftflot"> &nbsp;<b>Declaration with
												digital signature</b></span>
									</div>
								</g:else>

							</g:elseif>
						</div>
						<div id="Nosignature">


							<div class="col-sm-12">
								<h4>I / We declare that:-</h4>
							</div>
							<div class="col-sm-12">
								<ul>
									<li><b>Collection of proposed biological resources
											shall not adversely affect the sustainability of the
											resources.</b></li>
									<li><b>Collection of proposed biological resources
											shall not entail any environmental impact.</b></li>
									<li><b>Collection of proposed biological resources
											shall not pose any risk to ecosystems.</b></li>
									<li><b>Collection of proposed biological resources
											shall not adversely affect the local communities.</b>
								</ul>
							</div>

						</div>


						<div id="DigitalSignature">
							<div class="col-sm-12">
								<h4>I / We declare that:-</h4>
							</div>
							<div class="col-sm-12">
								<ul>
									<li><b>Collection of proposed biological resources
											shall not adversely affect the sustainability of the
											resources.</b></li>
									<li><b>Collection of proposed biological resources
											shall not entail any environmental impact.</b></li>
									<li><b>Collection of proposed biological resources
											shall not pose any risk to ecosystems.</b></li>
									<li><b>Collection of proposed biological resources
											shall not adversely affect the local communities.</b></li>
								</ul>
							</div>

							<div class="col-sm-12 form-group less-padding">
								<span class="col-sm-3">Upload signature:- </span>
								<div class="col-sm-4">
									<input type="file" class="width" />
								</div>
								<div class="col-sm-4">
									<input type="button" class="btn btn-primary" value="Upload" />
								</div>

							</div>
						</div>

						<div id="declarestatement" class="col-sm-12 form-group">
							<g:if test="${appForm?.submitCheck == true }">
								<h5>
									<g:checkBox class="checkbox" type="checkbox" checked="true"
										name="submitCheck" onclick="DisableSumitbtn(this)" />
									&nbsp; I / We further declare that information provided in the
									application form is true and correct and I / we shall be
									responsible for any incorrect / wrong information.
								</h5>
							</g:if>
							<g:else>
								<h5>
									<g:checkBox class="checkbox" type="checkbox" name="submitCheck"
										onclick="DisableSumitbtn(this)" />
									&nbsp; I / We further declare that information provided in the
									application form is true and correct and I / we shall be
									responsible for any incorrect / wrong information.
								</h5>
							</g:else>

							<div class="col-sm-12 text-center">
								<g:hiddenField name="appFormId" value="${appForm?.id}" />
								<g:actionSubmit controller="applicationManagement"
									action="saveDeclaration" class="btn btn-primary" value="Save" />
								<%--							<g:link controller="applicationManagement" class="btn btn-primary" action="saveDeclaration" params= "[formType:formType]">Save</g:link>--%>
								
									<g:link controller="applicationManagement" id="preview"
										class="btn btn-primary preview" action="form1preview"
										disabled="true"
										params="[formType:formType,declaration:declaration,appFormId:appForm?.id]">Preview</g:link>
								
								<input type="button" class="btn btn-primary sumitbtn"
									value="Submit" data-toggle="modal" data-target="#myModal" />
								<%--				<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal5">Open Modal</button>--%>
							</div>
						</div>
					</g:form>
				</div>
			</div>
		</div>

	</div>

</body>

</html>
