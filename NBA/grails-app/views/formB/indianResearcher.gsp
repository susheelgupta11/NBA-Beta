<%! import org.nba.application.CompanyProfile %>
<%! import org.nba.application.AgentProfile %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />

<title>NBA</title>


<!--calender codes end -->
<script type="text/javascript">
	$(document).ready(function() {
		BindValidation("ctlwidth", "btnctrl");
		BindValidation("controlclass1", "btnctrl");
		checksession(this);
		removeSession();
		if(sameAsAbove == 'No'){
			$("#diffPresentAddresss").show();
		}
		else{
			$("#diffPresentAddresss").hide();
			}

		if(sameAsAbove == 'Yes'){
			$("#diffPresentAddresss").each(function() {
				$('input[type="submit"]').removeClass("btnctrl");
			});
			}	
		
		
		
		AddActiveClass("menu1");
		addCompletegreenClass(tabStatus);
		goFocus("focusbtn", "foucuscontrol");
		goFocus("focusbtn1", "foucuscontrol1");
		$("#otherProfile").hide();
		var profileValue = $("#profileId").val();
		if (profileValue == 'Others') {
			$("#otherProfile").show();
		}
		
		
	});


	function presentAddressSame(){ 
		$("#diffPresentAddresss").hide();
		
		$("#diffPresentAddresss").each(function() {
				$('input[type="submit"]').removeClass("btnctrl");

			});
	}

	function diffPresentAddress(){
		$("#diffPresentAddresss").show();
		
	}
	
	function showYes() {
		$("#otherAgentProfile").hide();
		if ($('#ifYes').attr('checked', 'checked')) {
			$('.Yes').show();

		}
		var value = $("#agentProfileId").val();
		if (value == 'Others') {
			$("#otherAgentProfile").show();
		}
	}
	function updateCountry(e, val) {
		var csrfPreventionSalt = $('#csrfPreventionSalt').val();
		var nationality;
		if (val == null) {
			nationality = $(e).val();
		} else {
			nationality = val;
		}
		
		if (nationality == 'Indian') {
			$("#nonIndianCountry").val('');
			$("#country").val('');

			$.ajax({
				type : "POST",
				url : checkCountry,
				data : {
					nationality : nationality,
					csrfPreventionSalt : csrfPreventionSalt
				},
				success : function(result) {
					$("#noneSelected").hide();
					$("#notIndian").hide();
					$("#indian").val(result.country);
					$("#mobileCode").val(result.phonecode);
					$("#countryPhoneCode").val(result.phonecode);
					$("#PhoneCode").val(result.phonecode);
					//$("#countryMobileCode").show();
					$("#ifIndian").show();
					$("#nonIndianCountry").removeAttr("req1")
					$("#nonIndianCountry").removeClass("controlclass1")
					$("#country").removeAttr("req1")
					$("#country").removeClass("controlclass1")
					$("#province").attr("req1", "1");
					$("#province").addClass("controlclass1")
					$("#statesdiv").show();
					$("#statesdivDef").hide();
					$("#country").html('');
					//$("#notIndian").hide();
					//alert("nationality is indian "+result);
				},
				error : function() {
					//alert("An error has (Himanshu jain) occured!!!");
				}

			});
		} else if (nationality == 'Non Indian' || nationality == 'Non-Resident Indian') {

			$("#indian").val('');
			$("#statesdivD").val('');
			//$("#noneSelected").html('');

			if(nationality == 'Non Indian'){
				  var selectString;
					
					$.ajax({
						type : "POST",
						url : getNationality,
						
						data :{
								nationality : nationality,
								csrfPreventionSalt : csrfPreventionSalt
								},
						success: function(result) { 
				            		var aaa=result.substring(1, result.length-1);
				            		var value=aaa.split(", ");

				            		$("#idProofSelect option:not(:first)").remove().end();

				            		//$('#idProofSelect').html('');
				            		for(var i=0;i<value.length;i++)
					            	{
					            	$('#idProofSelect').append($('<option>', { 
					                    value: value[i].substring(1, value[i].length-1),
					                    text : value[i].substring(1, value[i].length-1)					                     
					                }));

					            	}
				            		if(selectedProof)
					            	{
					            	//alert("inside selected proof");
				            		$("#idProofSelect option[value='"+selectedProof+"']").prop("selected", "selected");
					            	//$("option[value='"+value[i]+"']").attr("himanshu","11");
					            	}

				            		if(selectedCountry)
									{
									//$("#nonIndianCountry").val(selectedCountry);
									$("#nonIndianCountry option[value='"+selectedCountry+"']").prop("selected", "selected");
									}

					            	
				            	
				       				 },
						error : function(request, status, error) {
									alert(error);
							}  
					});

					//alert("non-indiannnn")
					
					//$("#nationalityIndian").hide();
					//$("#nationalityNRI").hide();
					//$("#nationalityNonIndian").show();
					//$("#showInStarting").hide();
				}
			else if(nationality == 'Non-Resident Indian'){
				
				//alert("Himanshu");
				
				var selectString;
					$.ajax({
						type : "POST",
						url : getNationality,
						
						data :{
								nationality : nationality,
								csrfPreventionSalt : csrfPreventionSalt
								},
						success: function(result) { 
				            		//alert("result===="+result);
				            		$('#idProofSelect').val('');
				            		var aaa=result.substring(1, result.length-1);
				            		var value=aaa.split(", ");

				            		$("#idProofSelect option:not(:first)").remove().end();

				            		//$('#idProofSelect').html('');
				            		for(var i=0;i<value.length;i++)
					            	{
					            	$('#idProofSelect').append($('<option>', { 
					                    value: value[i].substring(1, value[i].length-1),
					                    text : value[i].substring(1, value[i].length-1) 
					                }));		

					            	}

				            		if(selectedProof)
					            	{
					            	//alert("inside selected proof");
				            		$("#idProofSelect option[value='"+selectedProof+"']").prop("selected", "selected");
					            	//$("option[value='"+value[i]+"']").attr("himanshu","11");

					            	}

									if(selectedCountry)
										{
										//alert("inside selectedCountry "+selectedCountry);
										$("#nonIndianCountry").val(selectedCountry);
										//$("#nonIndianCountry option[value='"+selectedCountry+"']").prop("selected", "selected");
										}
					            	
				            	
				       				 },
						 error : function(request, status, error) {
									alert("errorrrrrrrrrr");
									alert(error);
							}  
					});
				
				
				//$("#nationalityIndian").hide();
				//$("#nationalityNRI").show();
				//$("#nationalityNonIndian").hide();
				//$("#showInStarting").hide();
				}
			
			$("#ifIndian").hide();
			$("#mobileCode").val('');
			$("#countryPhoneCode").val('');
			$("#PhoneCode").val('');
			updateCodes();
		}
		

	}
</script>
</head>

<body>

	<g:javascript>
  var checkCountry = "${createLink(controller:'applicationManagement',action:'fetchCountryCode')}"
  var tabStatus = "${tabStatus}"
  var getNationality = "${createLink(controller:'applicationManagement',action:'getNationality')}"
 
  var fetchCodes = "${createLink(controller:'applicationManagement',action:'fetchMobileCode')}"
	
	var csrfPreventionSalt = "${csrfPreventionSalt}"
  </g:javascript>
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



	--%>
	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div id="leftTopTab" class="col-sm-2">
				<g:render template="/applicationManagement/leftTabs" />

			</div>

			<div class="col-sm-10">
				<div class="col-sm-12">
					<%--		Header Part			--%>

					<div class="checkout-wrap">
						<ul class="checkout-bar">

							<li><a href="#">Part 1</a></li>

							<li>Part 2</li>

							<li>Part 3</li>

							<li>Part 4</li>
							<li>Part 5</li>
							<%--							<li>Preview</li>--%>
							<li>Preview</li>
							<li>Payment</li>

						</ul>
					</div>
					<%--Header Part--%>
				</div>


				<div class="col-sm-12">
					
					<div class="clearfix"></div>
					<g:if test="${flash?.message}">

					</g:if>
					
					<div class="main-registeration col-sm-12 ">
						<!--login form -->
						<div>
							<g:render template="indianResearcher"
								model="[formType:formType,listOfCountries:listOfCountries,nationality:nationality,addressproofSelect:addressproof,appFormId:appForm?.id,indianResearcher:indianResearcher1]"></g:render>
						</div>
						
						<div class="col-sm-12 table-responsive" id="individualProfileGrid">
	
							<g:if test="${listOfIndianResearcher!=null}">
								<g:render template="indianResearcherGrid"
									model='[csrfPreventionSalt:"${ csrfPreventionSalt}",appFormId:appForm?.id,indianResearcher:indianResearcher1,listOfIndianResearcher:listOfIndianResearcher,deleteCalled:deleteCalled]'></g:render>
							</g:if>
						</div>
					</div>

					<div class=" col-sm-12 text-right">
						<div class="col-sm-12">
							
								<g:link controller="formB" action="formBPart2"
									params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
									class="btn btn-primary btnfirstNext inactive" method="POST">Next</g:link>
						
						</div>
					</div>

					<!--login form ends -->
				</div>



			</div>
		</div>
	</div>
	<!-- /.container -->
	<div class="clearfix"></div>

</body>

</html>
