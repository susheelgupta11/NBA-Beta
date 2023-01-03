
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />
<title>NBA</title>
<script type="text/javascript">
	$(document).ready(function() {
		AddActiveClass("menu3");
		addCompletegreenClass(tabStatus);
		BindValidation("controlreq", "btncontrol");
		BindValidation("ctlwidth", "btnctrl");
		BindValidation("ctlwidth1", "btnctrl1");
		
	});

	function loadPage() {
		location.reload(true);
	}
</script>
</head>

<body>
	<g:javascript>
	var tabStatus = "${tabStatus}"		
  </g:javascript>

	<div class="container ">
		<div class="row">
			<div id="leftTopTab" class="col-sm-2">
				<g:render template="leftTabs"
					model="[formType:formType,appForm:appForm]" />
			</div>
<div class="col-sm-10">
				<div class="col-sm-12">
					<div class="checkout-wrap">
						<ul class="checkout-bar">

							<li class="previous visited first"><a href="#">Part 1</a></li>

							<li class="previous visited"><a href="#">Part 2</a></li>

							<li class="active"><a href="#">Part 3</a></li>

							<li class="next"><a href="#">Part 4</a></li>

							<li>Preview</li>


						</ul>
					</div>
				</div>
				<div class="clearfix"></div>
				<div class="main-registeration col-sm-12">
					<g:render template="formCForeignRepository"
						model='[appForm:appFormId,formType:formType,foreignRepo:foreignRepo,csrfPreventionSalt:"${csrfPreventionSalt }",
						listOfForeignCountries:listOfForeignCountries,listOfContactDetailsOfRepository:listOfContactDetailsOfRepository,listOfCountries:listOfCountries,listOfStates:listOfStates]' />
				</div>


				<div class="main-registeration col-sm-12">
					<g:render template="formCRepository"
						model='[appForm:appFormId,applicationform:applicationform,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt }"]' />
				</div>

				<div class="main-registeration col-sm-12">
					<g:render template="formCIndianRepository"
						model='[appForm:appFormId,formType:formType,indianRepo:indianRepo,indianCountries:indianCountries,listOfContactDetailsOfRepository:listOfContactDetailsOfRepository,
						listOfCountries:listOfCountries,listOfStates:listOfStates,csrfPreventionSalt:"${csrfPreventionSalt }"]' />
				</div>
				<!-- start -->
				<div class="main-registeration col-sm-12">
					<div class="form-group col-sm-12 text-left">
						<label class="control-label register-heading ">(7) Accession number allotted by the Indian repository to the deposited microorganisms</label>

					</div>
					<div class="row form-group ">
						<label class="control-label col-sm-4"><span
							class="col-sm-1">(i)</span> <span class="col-sm-10">Accession number allotted<span class="text-danger"></span>
						</span></label>
						<div class="col-sm-8">

						<g:form action="submitAccessionNumber">
							<input type="text" class="form-control width" req1="1"
								name="accessionNumber" value="${indianRepoForAccession?.accessionNumber }"
								placeholder="Accession Number" />

								<g:hiddenField name="appFormId" value="${appFormId}" />
								<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}" />
								<g:hiddenField name="formType" value="${formType}" />
								<g:hiddenField name="profileId" value="${indianRepoForAccession?.id}" />
								<div class="col-sm-12 form-group text-right">
									<input type="submit" class="btn btn-primary "
										value="Save" />
								</div>
						</g:form>
						</div>
					</div>

				</div>



				<!-- end -->


				<div class="col-sm-12">
					<g:link controller="applicationManagement" action="formCPart2"
						class="btn btn-primary"
						params='[appFormId:appFormId,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Previous</g:link>

					<g:link controller="applicationManagement" action="formCPart4"
						class="btn  btn-primary pull-right"
						params='[appFormId:appFormId,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Next</g:link>

				</div>


			</div>




		</div>
	</div>
	</div>

	<div class="clearfix"></div>

</body>

</html>
