
<%! import java.util.Collections %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />
<title>NBA</title>
<script type="text/javascript">
	$(document).ready(function() {
		BindValidation("ctlwidth", "btnctrl");
		BindValidation("controlclass1", "btnctrl");
		BindValidation("controlreq", "btncontrol"); 
		BindValidation("controlreqired", "btnctrlone"); 
		BindValidation("controltxtarea", "btnctrltxtarea");
		AddActiveClass("menu3");
		
		addCompletegreenClass(tabStatus);

		goFocus("focusbtnfunding", "foucuscontrolfunding");

		if(recipientOutsideIndia == 'contactDetails3'){
				$('#recipientOutsideIndia').show();
			}
		else{
				$('#recipientOutsideIndia').hide();
			}

		
		$('.toTime').change(function(){
			
			var toDate = $('.toTime').val();
			var fromDate = $('.fromTime').val();

			if(fromDate == ''){
				alert('Start date is blank');
				return
				}
				
			var toDateSplit = toDate.split('/');
			var fromDateSplit = fromDate.split('/');
			
			
			var endDate = new Date(toDateSplit[2], toDateSplit[1]-1, toDateSplit[0]); 
			var startDate = new Date(fromDateSplit[2], fromDateSplit[1]-1, fromDateSplit[0])
			
			 if(endDate < startDate){
					$('.toTime').val('');
					alert('End Date should not be less then start date');
				}
			 else if(endDate != '' && startDate != ''){
					if(startDate > endDate)
						$('#startDate').val('');
				 }
		});
		
		if(fundingAgencyObj || deletefundingagency){
				$("#institutionOrganizationName").focus();
			}

		$(document).on( 'form', ':input', function(){
	        $( this ).attr( 'autocomplete', 'off' );
	    });
		
	});

	function validateResearchDuration(){
		BindValidation("controlclass2", "btnclass2");
		BindValidation('widthemergencyDetails', 'ctrolvalid');	
		}
	
	
	function clearForm() {
		$('#geoLocation')[0].reset();
	}

	function loadPage() {
		location.reload(true);
	}

	function hideShowOnEdit(){
		$('#other').hide();
		var value = $('#source').val();
		if(value == 'Others'){
			$('#other').show();
			}
		}
	function showAddressProofDiv(){
		var categoryVal;
			$('#recipientOutsideIndia').show();

			categoryVal = $('input[name=category]:checked').val();	
			if(categoryVal == 'contactDetails3'){
					$(".addressproofSelect").attr("req1","1");
					$(".addressproofNo").attr("req1","1");
					$(".addressproofLetter").attr("req1","1");
				}
			else{
				$(".addressproofSelect").removeAttr("req1");
				$(".addressproofNo").removeAttr("req1");
				$(".addressproofLetter").removeAttr("req1");
				$(".addressproofLetter").removeAttr("pdf1");
				}
			
		}
	function hideAddressProofDiv(){
		$('#recipientOutsideIndia').hide();
		var categoryVal;
		categoryVal = $('input[name=category]:checked').val();
		if(categoryVal != 'contactDetails3'){
			$(".addressproofSelect").removeAttr("req1");
			$(".addressproofNo").removeAttr("req1");
			$(".addressproofLetter").removeAttr("req1");
			$(".addressproofLetter").removeAttr("pdf1");
		}	
	}
	
	
</script>
</head>

<body>
	<g:javascript>  
  var tabStatus = "${tabStatus}"
  var recipientOutsideIndia = "${entity2?.category }"
  var fundingAgencyObj = "${fundingAgencyObj }"
  var deletefundingagency = "${deletefundingagency }"
  </g:javascript>

	<!-- Page Content -->
	<div class="container">
		<div class="row">

			<div id="leftTopTab" class="col-sm-2">
				<g:render template="/applicationManagement/leftTabs"
					model="[appForm:appForm,formType:formType]" />
			</div>
			<div class="col-sm-10">

				<div class="col-sm-12">
					<div class="checkout-wrap">
						<ul class="checkout-bar">

							<li class="previous visited first"><a href="#">Part 1</a></li>

							<li class="active">Part 2</li>

							<li class="next">Part 3</li>

							<li class="">Part 4</li>
							<li>Part 5</li>
							<li>Preview</li>
							<li>Payment</li>
						</ul>
					</div>
				</div>

				<div class="clearfix"></div>

				<div class="clearfix"></div>
				<div class="main-registeration col-sm-12">
					<!--login form -->
					<div class="col-sm-12 nopadding">

					</div>

					<div id="">
						<g:render template="formBpart3"></g:render>
					</div>
				</div>

				<div class="clearfix"></div>
				<div class="main-registeration col-sm-12" id="">
					<g:render template="formBPart3HeadDetails" />
					<!--login form ends -->
				</div>

				<div class="clearfix"></div>


				<div class="clearfix"></div>
				<div class="main-registeration col-sm-12">
					<!--login form -->
					<g:render template="formBFundingAgency" 
							  model='[csrfPreventionSalt:"${ csrfPreventionSalt}",
						appForm:appForm,formType:formType,fundingAgencyObj:fundingAgencyObj]' />
				</div>
				
				<g:if test="${listOfFundingAgency }">
					<div class="main-registeration col-sm-12">
						<!--login form -->
						<g:render template="formBFundingAgencyGrid" 
						model='[csrfPreventionSalt:"${ csrfPreventionSalt}",
						appForm:appForm,formType:formType,listOfFundingAgency:listOfFundingAgency]'/>
					</div>
				</g:if>
				
				<div class="main-registeration col-sm-12">
				<g:form controller="formB" name="descriptionForm" class="form-horizontal"
						role="form" autocomplete="off">
					<div class="col-sm-12 form-group">
						<label class="control-label  register-heading">(7)
							Brief description of research </label>
					</div>
					<div class="col-sm-12">
						<g:textArea class="form-control widthemergencyDetails txtlastvalid txtremovevalidate" txtmaxword200="1"  txtreq1="1" rows="4"  name="description" value="${appForm?.briefDescription}" 
							placeholder="Purpose of taking the sample/sending bio resources outside India and brief description thereof (500 words)"></g:textArea>
						<br />
					</div>
					<div class="col-sm-12 form-group text-right">
					<g:hiddenField name="appFormId" value="${appForm?.id}" />
					<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}" />
					<g:hiddenField name="formType" value="${formType}" />
						<g:actionSubmit type="button" action="saveDescription" class="btn btn-primary ctrolvalid" value="Save" onclick="validateResearchDuration()"></g:actionSubmit>
					</div>
					</g:form>
				</div>

				<div class="form-group">
					<div class="col-sm-12">

						<g:link controller="formB"
							action="formBPart2"
							params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
							class="btn btn-primary
									">Previous</g:link>

						<g:hiddenField name="appFormId" value="${appForm?.id}" />


						<g:link controller="formB" action="formBPart4"
							params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
							class="btn  btn-primary pull-right" method="POST">Next</g:link>

					</div>
				</div>



			</div>
		</div>
	</div>
	<!-- /.container -->
	<div class="clearfix"></div>

</body>

</html>
