
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />

<title>NBA</title>
<script type="text/javascript">
	$(document).ready(
			function() {
				freezTopLeftTab();
				$(".hidecontrols").hide();

				BindValidationMethod();
				AddActiveClass("menu6");

				if(declaration){
					$(".confirm").removeAttr("disabled");
					}
			});

	
</script>
</head>

<body>
<g:javascript>
	var appFormId= "${appForm?.id}"
  	var transactionId = "${transactionNum}"
  	var declaration = "${declaration }"
  </g:javascript>
  
  
  <div id="myModalConfirm" class="modal fade" role="dialog"
		style="z-index: 9999999;">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Confirm message</h4>
				</div>
				<div class="modal-body">
					<p>Are you sure you want to proceed?</p>
				</div>
				<div class="modal-footer">
					<g:link controller="applicationManagement" post="true"
						action="completePayment"
						params='[formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'
						class="btn btn-success">Ok</g:link>
					<button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
				</div>
			</div>

		</div>
	</div>
  
  
  
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
						class="btn btn-success" params='[csrfPreventionSalt:"${csrfPreventionSalt}"]'>Ok</g:link>

				</div>
			</div>

		</div>
	</div>
	<%--<nav class="navbar-default" role="navigation">
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

	--%><!-- Page Content -->
	<div class="container ">
		<div class="row">
			<div id="leftTopTab" class="col-sm-2">
				<g:render template="leftTabs" model="[formType:formType]" />

			</div>

			<div class="col-sm-10">
				<div class="col-sm-12">
					<div class="checkout-wrap">
						<ul class="checkout-bar">

							<li class="previous visited first"><a href="#">Part 1</a></li>

							<li class="previous visited">Part 2</li>

							<li class="previous visited">Part 3</li>

							<li class="previous visited">Part 4</li>
							<li class="active">Part 5</li>
							<li>Payment</li>


						</ul>
					</div>
				</div>
				<div class="clearfix"></div>
				
				
				<div class="main-registeration col-sm-12">
				
					<g:if test="${flash.message }">
						<div class="text-center">
							<span style="color:#eb3430;"><b>***${flash.message }***</b></span>
						</div>
					</g:if>
				
					<label class="control-label col-sm-12 register-heading">
						Make payment of application fee</label>
					<div class="col-sm-12 form-group less-padding">
						<h5 class="col-sm-4">
							<b>Payment Reference Number*:-</b>
						</h5>
						<h5 class="col-sm-4">
							${transactionNum}
						</h5>

					</div>
					<div class="col-sm-12 form-group less-padding">
						<h5 class="col-sm-4">
							<b>Make payment :</b>
						</h5>
						<div class="col-sm-4">
							<a class="btn btn-primary " target="_blank"
             <%-- change it on 14-01-2019 https://www.onlinesbi.com/prelogin/icollecthome.htm?corpID=317266--%>
          <%-- change it on 11-10-2022  https://www.onlinesbi.com/sbicollect/icollecthome.htm?corpID=317266--%>
             
								href="https://www.onlinesbi.sbi/sbicollect/icollecthome.htm?corpID=317266">Pay
								Online</a>
						</div>
					</div>

					<a data-toggle="modal" data-target="#InstructionModal"
						class="col-sm-12 red">Instructions for making online payment
						and completing the process of submission of application form</a>

					<!-- Modal -->
					<div id="InstructionModal" class="modal fade" role="dialog">
						<div class="modal-dialog modal-lg">

							<!-- Modal content-->
							<div class="modal-content" style="font-size:12px;">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h5 class="modal-title">Instructions for making online
										payment and completing the process of submission of
										application form</h5>
								</div>
								<div class="modal-body">



									<div class="form-group col-sm-12">
										<span class="leftflot"><b> Step 1:</b> </span>
										<div class="col-sm-11">
											To Make payment click<span class="red"> "Pay Online" </span>
											to go to State Bank of India website and enter Your <span
												class="red">"Transaction reference number"</span> <i>(example:
												XYZ12345Z14 mentioned above in the appropriate column)</i>
										</div>
									</div>

									<div class="form-group col-sm-12">
										<div class="leftflot">
											<b> Step 2:</b>
										</div>
										<div class="col-sm-11">
											Select the following payment category<span class="red">"Application
												Payment using Transaction reference number"</span>
										</div>
									</div>

									<div class="form-group col-sm-12">
										<div class="leftflot">
											<b> Step 3:</b>
										</div>
										<div class="col-sm-11">After making the payment, SB
											Collect payment confirmation receipt wil be generated that
											can be saved as pdf and a print out also be taken</div>
									</div>

									<div class="form-group col-sm-12">
										<div class="leftflot">
											<b> Step 4:</b>
										</div>
										<div class="col-sm-11">
											Then Return to NBA online Portal where you have to<br /> i)
											Enter SB collect reference number and<br /> ii) Upload
											payment confirmation receipt
										</div>
									</div>
									
									<div class="form-group col-sm-12">
										<div class="leftflot">
											<b> Step 5:</b>
										</div>
										<div class="col-sm-11">
											Those who make payment through different mode, please provide reference number
										</div>
									</div>

								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-primary"
										data-dismiss="modal">Close</button>
								</div>
							</div>

						</div>
					</div>




					<div class="col-sm-12">
						<h5>
							<b>To Complete the Payment process</b>
						</h5>
					</div>
					<g:uploadForm controller="applicationManagement" autocomplete="off">
					<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
						

						<div class="col-sm-12  form-group less-padding">
							<span class="col-sm-4">Enter Payment Reference Number</span>
							<div class="col-sm-4">
								<input type="text" class="width" name="paymentRefNo" req="1" value="${appForm?.transaction?.paymentRefNo }" req1="1"/>
							</div>

						</div>
						<div class="col-sm-12 form-group less-padding">
							<span class="col-sm-4">Upload payment receipt</span>
							<div class="col-sm-4">
								
								<g:if test= "${appForm?.transaction?.paymentReceiptURL}">
									<input type="file" class=" width" name="PaymentReceipt"  value="" />
									<g:link controller="applicationManagement" action="showIndividualDc"
										id="${appForm?.transaction?.id}" target="_blank"
										params='[filename: "paymentReceipt", dataName: "paymentReceipt", appFormId: appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'>
										Click to preview Payment Receipt
									</g:link>
								</g:if>
								<g:else>
									<input type="file" class=" width" name="PaymentReceipt" req="1" value="" />
									<b>(PDF only)</b>
								</g:else>
								
							</div>
							
						
						</div>
						
						
						
						<div class="col-sm-10 text-center">
							<g:hiddenField name="formType" value="${formType}" />
							<g:hiddenField name="appFormId" value="${appFormId}" />
							<g:hiddenField name="transactionId" value="${transactionNum}" />
							
					<div class="col-sm-12 red less-padding"><h5 ><b>Note:</b>Only after the receipt of confirmation of full payment from the SBI/other mode and receipt of the amount, the application will be considered.</h5></div>
							
							<g:actionSubmit value= "Save" action="saveBeforePaymentProcess" class="btn btn-primary" />
<%--							<g:link action="saveBeforePaymentProcess" params="[formType:formType,transactionId:transactionNum,appFormId:appFormId,declaration:'declaration']" class="btn btn-primary" >Save</g:link>--%>
							<input type="button"  class="btn btn-primary confirm" disabled="disabled" data-toggle="modal"  data-target="#myModalConfirm"  value="Confirm" />
						</div>
					</g:uploadForm>



				</div>
			</div>
		</div>
	</div>
</body>

</html>
