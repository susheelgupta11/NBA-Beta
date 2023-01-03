<%! import org.nba.application.IndividualProfile %>
<%! import org.nba.application.AgentProfile %>
<%! import org.nba.common.Country %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />

<title>NBA</title>

<script type="text/javascript">
	$(document).ready(function() {
		//	var value=sessionStorage.getItem("green");	
		//alert(tabStatus);
		addCompletegreenClass(tabStatus);
		IndividualProfile();
		$("#otherProfile").hide();
		var profileValue = $("#profileId").val();
		if (profileValue == 'Others') {
			$("#otherProfile").show();
		}

		function loadPage() {
			location.reload(true);
		}
	});
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

	/* default behaviour of Indian, Non-Indian and NRI*/
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

	function updateCodes() {
		$("#noneSelected").hide();
		$("#notIndian").show();
		$("#statesdiv").hide();
		$("#province").removeAttr("req1");
		$("#province").removeClass("controlclass1")
		$("#country").removeAttr("req1");
		$("#country").removeClass("controlclass1")
		<g:remoteFunction controller="applicationManagement" action="fetchCountries" update="notIndian" params='[selectedCountry:selectedCountry,csrfPreventionSalt:"${csrfPreventionSalt}"]'/>

	}
</script>

<!--calender codes end -->
</head>

<body>
	<g:javascript>
  var checkCountry = "${createLink(controller:'applicationManagement',action:'fetchCountryCode')}"
  var tabStatus = "${tabStatus}"
  var getNationality = "${createLink(controller:'applicationManagement',action:'getNationality')}"
  </g:javascript>
	<!-- Page Content -->
	<div class="container">
		<div class="row">

			<div id="leftTopTab" class="col-sm-2">
				<g:render template="leftTabs"
					model="[appFormId:appForm?.id,formType:formType]" />

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
				<div class="clearfix"></div>
				<div class="main-registeration col-sm-12 "
					style="border: 1px solid #9E9E9E; border-radius: 5px">
					<!--login form -->
					<div id="addEditIndividualProfile">
<%--						<input type="hidden" name="csrfPreventionSalt" id="csrfPreventionSalt"--%>
<%--							value="${csrfPreventionSalt}" />--%>
						<g:render template="individualProfile"
							model='[csrfPreventionSalt:"${ csrfPreventionSalt}",statesList:statesList,individualProfile:individualProfile1,listOfIndividualProfiles:listOfIndividualProfiles, profile:profile]'></g:render>

					</div>
					<div class="col-sm-12 table-responsive" id="individualProfileGrid">

						<g:if test="${listOfIndividualProfiles!=null}">
							<g:render template="individualProfileGrid"
								model='[csrfPreventionSalt:"${ csrfPreventionSalt}",appFormId:appForm?.id,individualProfile:individualProfile1,listOfIndividualProfiles:listOfIndividualProfiles,deleteCalled:deleteCalled]'></g:render>
						</g:if>
					</div>
					<div id="addEditAgentProfile">
						<g:render template="addAgentProfile" model="[appForm:appForm]"></g:render>
					</div>

					<!--login form ends -->

					<div id="updateAgentProfile" class="col-sm-12 table-responsive">
						<g:if test="${agentProfile}">
							<g:render template="agentProfileGrid"
								model="[agentProfile:agentProfile,appForm:appForm]"></g:render>
						</g:if>
					</div>


				</div>

			</div>

			<div class="col-sm-12 text-right">
				<div class="col-sm-12">
					<g:if test="${formType == 'Form1'}">
						<g:link controller="applicationManagement" action="form1Part2"
							params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
							class="btn btn-primary btnfirstNext inactive" method="POST">Next</g:link>
					</g:if>
					<g:elseif test="${formType == 'Form2'}">
						<g:link controller="form2" action="part2"
							params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
							class="btn btn-primary btnfirstNext inactive" method="POST">Next</g:link>
					</g:elseif>
					<g:elseif test="${formType == 'Form3'}">
						<g:link controller="form3" action="part2"
							params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
							class="btn btn-primary btnfirstNext inactive" method="POST">Next</g:link>
					</g:elseif>
					<g:elseif test="${formType == 'Form4'}">
						<g:link controller="form4" action="part2"
							params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
							class="btn btn-primary btnfirstNext inactive" method="POST">Next</g:link>
					</g:elseif>
				</div>
			</div>
		</div>


	</div>
	<!-- /.container -->
</body>

</html>
