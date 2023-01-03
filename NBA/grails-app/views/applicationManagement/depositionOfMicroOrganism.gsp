
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />
<title>NBA</title>
<script type="text/javascript">
	$(document).ready(function() {
		Entity();
		addCompletegreenClass(tabStatus);
		AddActiveClass("menu1");
		goFocus("focusbtn", "foucuscontrol");
	});

	function loadPage() {
		location.reload(true);
	}
	function updateCountryCodes(e){
		//var code = $(e).val();
	
		e.data.split('=')[1]
		var dataElement = e.data? e.data.split('&')[0]:"No value"
			var countryId = dataElement? dataElement.split('=')[1]:"No value"
			
			
			$.ajax({
				type : "POST",
				url : fetchCodes,
				data : {
					countryId : countryId,
					csrfPreventionSalt : csrfPreventionSalt
				},
				success : function(result) {
					$('#mobileCode').val(result.phonecode);
					$('#countryPhoneCode').val(result.phonecode);
					$('#personMobileCode').val(result.phonecode);
				},
				error : function() {
					//alert("An error has (Himanshu jain) occured!!!");
				}

			});	
			}
</script>


</head>

<body>
	<g:javascript>
	var tabStatus = "${tabStatus}"		
	 var fetchCodes = "${createLink(controller:'applicationManagement',action:'fetchMobileCode')}"
	 var csrfPreventionSalt = "${csrfPreventionSalt}"
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

							<li class="active"><a href="#">Part 1</a></li>

							<li ><a href="#">Part 2</a></li>

							<li ><a href="#">Part 3</a></li>

							<li ><a href="#">Part 4</a></li>

							<li>Preview</li>


						</ul>
					</div>
				</div>

				<div class="clearfix"></div>

				<div class="main-registeration col-sm-12"> 
					<!--form A -->
					<g:uploadForm class="form-horizontal" role="form"
						autocomplete="off" action="submitDepositionOfMicroOrganism">
						<input type="hidden" name="csrfPreventionSalt"
							value="${csrfPreventionSalt}" />
<%--						<div class="form-group col-sm-12 text-left">--%>
<%--							<label class="control-label register-heading ">--%>
<%--								Deposition of micro-organism by Indian scientist / researchers--%>
<%--								in non-indian repository for claim of novel species--%>
<%--							</label>--%>
<%--						</div>--%>

						<div class="form-group col-sm-12">
							<label class=" control-label register-heading text-left">(1) Full Particulars of the Depositor</label>
						</div>
						
						<div class="form-group row ">

							<label class="control-label col-sm-4"><span
								class="col-sm-1">(a)</span> <span class="col-sm-10">Name
									of the Depositor<span class="text-danger"><b>*</b></span>
							</span></label>
							<div class="col-sm-8">
								<input type="text" id="foucuscontrol" class="form-control width ctlwidth "
									name="nameOfDepositor" req1="1"
									value="${depositionOfMicroOrganism1?.nameOfDepositor}"
									placeholder="Name of Depositor" />


							</div>
						</div>
					<div class="form-group col-sm-12 text-left">
		<label class="col-sm-12  register-heading ">(i) Complete
									Address with contact Details</label>

						</div>
						<div class="form-group row">

							<label class="control-label col-sm-4"><span
								class="col-sm-1">(i)</span> <span class="col-sm-10">Address
									Line 1 <span class="text-danger"><b>*</b></span>
							</span></label>
							<div class="col-sm-8">

								<input type="text" class="form-control width ctlwidth" req1="1"
									name="address1" value="${depositionOfMicroOrganism1?.address1}"
									placeholder="Address line 1" />

							</div>
						</div>
						<div class="form-group row">

							<label class="control-label col-sm-4"><span
								class="col-sm-1">(ii)</span> <span class="col-sm-10">Address
									Line 2 </span></label>
							<div class="col-sm-8">

								<input type="text"  class="form-control width ctlwidth"
									value="${depositionOfMicroOrganism1?.address2}" name="address2"
									placeholder="Address line 2" />

							</div>
						</div>
						<div class="row form-group ">

							<label class="control-label col-sm-4"><span
								class="col-sm-1">(iii)</span> <span class="col-sm-10">Address
									Line 3</span></label>
							<div class="col-sm-8">

								<input type="text" name="address3" class="form-control width ctlwidth"
									value="${depositionOfMicroOrganism1?.address3}"
									placeholder="Address line 3" />

							</div>
						</div>
						<div class="row form-group ">

							<label class="control-label col-sm-4"><span
								class="col-sm-1">(iv)</span> <span class="col-sm-6">Country
									<span class="text-danger"><b>*</b></span>
							</span></label>
							<div class="col-sm-8" id="countrySelect">

								<g:select name="countryId" from="${listOfCountries}"
									optionKey="id" optionValue="country"
									value="${depositionOfMicroOrganism1?.country?.id}"
									class="width country ctlwidth" 
									
									 />





							</div>
						</div>
						<div id="updateStates">
						
							<div class="row form-group ">

								<label class="control-label col-sm-4"><span
									class="col-sm-1">(iv)</span> <span class="col-sm-6">State/Province<span class="text-danger"><b>*</b></span>
								</span></label>
													<div class="col-sm-8">
									<g:select name="state" from="${statesList?.state}"
									class="form-control width ctlwidth" req1="1" value="${depositionOfMicroOrganism1?.state}"
									noSelection="['':'Select State']" />
<%--									<input type="text" class="form-control width ctlwidth" name="state" req1="1"--%>
<%--										value="${depositionOfMicroOrganism1?.state}"--%>
<%--										placeholder="State" />--%>

								</div>
							</div>
						
						</div>
						<div class="row form-group ">

							<label class="control-label col-sm-4"><span
								class="col-sm-1">(v)</span> <span class="col-sm-10">City
									<span class="text-danger"><b>*</b></span>
							</span></label>
							<div class="col-sm-8">

								<input type="text" name="city" req1="1"
									class="form-control width ctlwidth"
									value="${depositionOfMicroOrganism1?.city}" placeholder="City" />

							</div>
						</div>
						<div class="row form-group ">

							<label class="control-label col-sm-4"><span
								class="col-sm-1">(vi)</span> <span class="col-sm-6">Zip
									/ Pincode <span class="text-danger"><b>*</b></span>
							</span></label>
							<div class="col-sm-8">

								<input type="text" name="zip" req1="1"
									class="form-control width ctlwidth"
									value="${depositionOfMicroOrganism1?.zip}" placeholder="Zip" />

							</div>
						</div>
						<div class="row form-group  ">

							<label class="control-label col-sm-4"><span
								class="col-sm-1">(vii)</span> <span class="col-sm-10"> Mobile
									<span class="text-danger"><b>*</b></span>
							</span></label>
							<div class="col-sm-2">
								<g:if test="${!depositionOfMicroOrganism1}">
									<input type="text" class="ctlwidth width"
										placeholder="Mobile Code" name="mobileCode" readonly
										id="mobileCode" value="+91">
								</g:if>
								<g:elseif
									test="${depositionOfMicroOrganism1?.mobile?.contains('-')}">
									<input type="text" req1="1" class=" ctlwidth width"
										placeholder="Mobile Code" name="mobileCode" readonly
										id="mobileCode"
										value="${depositionOfMicroOrganism1?.mobile?.split('-')[0]}">
								</g:elseif>

							</div>

							<div class="col-sm-4 less-padding">
								<g:if test="${!depositionOfMicroOrganism1}">
									<input type="text" class="width ctlwidth controlclass1"
										placeholder="Mobile No." name="mobile" req1="1" mob1="1"
										num1="1">
								</g:if>
								<g:elseif
									test="${depositionOfMicroOrganism1?.mobile?.contains('-')}">
									<input type="text" class=" width ctlwidth controlclass1"
										placeholder="Mobile No." name="mobile" req1="1" mob1="1"
										num1="1"
										value="${depositionOfMicroOrganism1?.mobile?.split('-')[1]}">
								</g:elseif>
							</div>
						</div>
						<div class="row form-group ">

							<label class="control-label col-sm-4"><span
								class="col-sm-1">(viii)</span> <span class="col-sm-10">Phone
									<span class="text-danger"><b>*</b></span>
							</span></label>
							<div class="col-sm-2">
								<g:if test="${!depositionOfMicroOrganism1}">
									<input type="text" class="ctlwidth  width "
										placeholder="Phone code." name="PhoneCode" readonly value="+91"
										id="countryPhoneCode">
								</g:if>
								<g:elseif
									test="${depositionOfMicroOrganism1?.phone?.contains('-')}">
									<input type="text" class="width ctlwidth "
										placeholder="Phone code." name="PhoneCode" readonly
										value="${depositionOfMicroOrganism1?.phone?.split('-')[0]}"
										id="countryPhoneCode">
								</g:elseif>

							</div>
							<div class="col-sm-4 less-padding">
								<g:if test="${!depositionOfMicroOrganism1}">
									<input type="text" class=" width ctlwidth controlclass1" num1="1"
										placeholder="Phone No." name="phone" req1="1" id="">
								</g:if>
								<g:elseif
									test="${depositionOfMicroOrganism1?.phone?.contains('-')}">
									<input type="text" class=" width ctlwidth controlclass1" num1="1"
										placeholder="Phone No." name="phone" readonly
										value="${depositionOfMicroOrganism1?.phone?.split('-')[1]}"
										id="countryPhoneCode">
								</g:elseif>
							</div>
						</div>
						<div class="row form-group ">

							<label class="control-label col-sm-4"><span
								class="col-sm-1">(ix)</span> <span class="col-sm-6">Email
									<span class="text-danger"><b>*</b></span>
							</span></label>
							<div class="col-sm-8">

								<input type="text" class="form-control width ctlwidth" req1="1"
									email1="1" name="email"
									value="${depositionOfMicroOrganism1?.email}"
									placeholder="Email" />

							</div>
						</div>


						<div class="col-sm-12 form-group text-right">
							<g:hiddenField name="profileId"
								value="${depositionOfMicroOrganism1?.id}" />
							<g:hiddenField name="formType" value="${formType}" />
							<g:hiddenField name="appFormId" value="${appForm?.id}" />
							<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}" />
							<input type="submit" class="btn btn-primary btnctrl" onClick="JavaScript:setsession()" value="Save" />
							<input type="button" class="btn btn-primary focusbtn" value="Add More" />

						</div>
					</g:uploadForm>
					<!-- start -->



					<!-- end -->

				</div>
				<div class="col-sm-12 table-responsive" id="individualProfileGrid"
					style="padding: 0px !important;">

					<g:if test="${listOfDepositionOfMicroOrganism!=null}">
						<g:render template="depositionOfMicroOrganismGrid"
							model='[csrfPreventionSalt:"${csrfPreventionSalt}",appFormId:appForm?.id,depositionOfMicroOrganism:depositionOfMicroOrganism1,listOfDepositionOfMicroOrganism:listOfDepositionOfMicroOrganism,deleteCalled:deleteCalled]'></g:render>
					</g:if>
				</div>


				<div class="col-sm-12">


<%--					<g:if test="${listOfDepositionOfMicroOrganism.size()>0}">--%>
						<g:link controller="applicationManagement" action="formCPart2"
							class="btn btn-primary pull-right btnfirstNext inactive"
							params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Next</g:link>
<%--					</g:if>--%>
				</div>

			</div>
		</div>
	</div>

	<div class="clearfix"></div>

</body>

</html>
