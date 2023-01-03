 <%! import java.util.Collections %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />
<title>NBA</title>
<script type="text/javascript">
	$(document).ready(function() {
		addCompletegreenClass(tabStatus);
		$('.toTime').change(function(){
			debugger
			
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
<%--						alert('Start date should be less then end date');--%>
				 }
		});
		
		form1part2();

		
	});
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

	
	
</script>
</head>

<body>
<g:javascript>  
  var tabStatus = "${tabStatus}"
  </g:javascript>
	
	<!-- Page Content -->
	<div class="container">
		<div class="row">

			<div id="leftTopTab" class="col-sm-2">
				<g:render template="leftTabs"
					model="[appForm:appForm,formType:formType]" />
			</div>
			<div class="col-sm-10">
				<div class="col-sm-12">
					<div class="checkout-wrap">
						<ul class="checkout-bar">

							<li class="active"><a href="#">Part 1</a></li>

							<li>Part 2</li>

							<li>Part 3</li>

							<li>Part 4</li>
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

						<div class="form-title col-sm-12">
							<label class="register-heading"><span class="leftflot">2.</span><span
								class="col-sm-11"> Details and specific information about
									nature of access sought and biological material and associated
									knowledge to be accessed </span></label>
						</div>
					</div>


					<div id="AddUpdateDetails">
						<g:if test="${bioResourceInst}">
							<g:render template="editForm1Part2"
								model="[bioResourceInst:bioResourceInst,formType:formType]"></g:render>

						</g:if>
						<g:else>
							<g:render template="addPart1"
								model="[bioResourceInst:bioResourceInst]"></g:render>

						</g:else>
					</div>

				</div>


				<div class="col-sm-12 nopadding table-responsive"
					id="updateBioResources">
					<g:if test="${listOfBioResources}">
						<g:render template="biologicalResourcesGrid"
							model="[listOfBioResources:listOfBioResources]" />
					</g:if>
				</div>


				<div class="clearfix"></div>
				<div class="main-registeration col-sm-12"
					id="geographicalLocationForm">
					<g:render template="geographicalLocationForm"
						model="[bioresource:bioresource,listOfStates:listOfStates,appForm:appForm,geoLocation:geoLocation,formType:formType]" />
					<!--login form ends -->
				</div>

				<div class="clearfix"></div>
				<div class="col-sm-12 nopadding table-responsive"
					id="updateGeoLocation">
					<g:if test="${listOfLocations}">
						<g:render template="geographicalLocationGrid"
							model="[appForm:appForm,listOfLocations:listOfLocations,formType:formType]" />
					</g:if>

				</div>

				<div class="clearfix"></div>
				<div class=" col-sm-12">
					<!--login form -->
					<g:form controller="applicationManagement"
						action="saveDetailedTraditionalKnowledge" autocomplete="off" class="form-horizontal"
						role="form">
					<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>

						<div class="form-group">
							<div class="col-sm-12">
								<g:if test="${appForm?.individualProfiles?.size() > 0}">
									<g:link controller="applicationManagement"
										action="individualProfile"
										params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
										class="btn btn-primary
									">Previous</g:link>
								</g:if>
								<g:else>
									<g:link controller="applicationManagement"
										action="companyProfile"
										params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
										class="btn btn-primary
									">Previous</g:link>
								</g:else>
								<g:hiddenField name="appFormId" value="${appForm?.id}" />

								<g:set var="ListId1"
									value="${listOfLocations?.bioResource?.scientificName}"></g:set>
								<g:set var="ListId2" value="${newList?.scientificName}"></g:set>
								<g:if test="${(ListId1).containsAll(ListId2) == true}">
									<g:link controller="applicationManagement" action="form1Part3"
										params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
										class="btn  btn-primary pull-right" method="POST">Next</g:link>
								</g:if>
								<g:else>
<%--									<g:link controller="applicationManagement" action="form1Part3"--%>
<%--										params="[appFormId:appForm?.id,formType:formType]"--%>
<%--										class="btn  btn-primary pull-right" method="POST"--%>
<%--										style="pointer-events:none">Next</g:link>--%>
				<a href= "#" method="POST" class="btn btn-primary pull-right" onClick="AddPointerNone(this)" >Next</a>
								</g:else>
							</div>
						</div>

					</g:form>
					<!--login form ends -->
				</div>



			</div>
		</div>
	</div>
	<!-- /.container -->
	<div class="clearfix"></div>

</body>

</html>
