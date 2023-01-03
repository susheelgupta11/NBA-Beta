
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />
<title>NBA</title>
<script type="text/javascript">
	$(document).ready(function() {
		
		AddActiveClass("menu2");
		BindValidation("controlreq", "btncontrol");
		BindValidation("ctlwidth", "btnctrl");
		goFocus("focusbtn", "foucuscontrol");
		goFocus("focusbtn1", "foucuscontrol1");
		addCompletegreenClass(tabStatus);
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

							<li class="active"><a href="#">Part 2</a></li>

							<li class="next"><a href="#">Part 3</a></li>

							<li><a href="#">Part 4</a></li>

							<li>Preview</li>


						</ul>
					</div>
				</div>

				<div class="clearfix"></div>
				<div class="main-registeration col-sm-12"
					id="geographicalLocationForm">
					<g:render template="formCMicroorganismName"
						model='[appForm:appFormId,formType:formType,csrfPreventionSalt:"${ csrfPreventionSalt}"]' />
				</div>
				<div class="col-sm-12 table-responsive"
					id="microOrganismScientistName" style="padding: 0px !important;">

					<g:if test="${listOfScientistName!=null}">
						<g:render template="microOrganismScientistNameGrid"
							model='[csrfPreventionSalt:"${ csrfPreventionSalt}",appFormId:appFormId,microOrgaScirntistName:microOrgaScirntistName,listOfScientistName:listOfScientistName,deleteCalled:deleteCalled]'></g:render>
					</g:if>
				</div>
				<div class="main-registeration col-sm-12">
					<g:render template="formCMicroorganism"
						model='[appForm:appFormId,geoLocationlist1:geoLocationlist1,geoLocationlist:geoLocationlist,listOfScientistName:listOfScientistName,
						formType:formType,statesList:listOfStates,scientistNameObj:scientistNameObj,accessSources:accessSources,csrfPreventionSalt:"${ csrfPreventionSalt}"]'/>
				</div>
				<g:if test="${locations?.size() >0}">
					<div class="col-sm-12 table-responsive" id="formCMicroOrganismGeo"
						style="padding: 0px !important;">


						<g:render template="formCMicroorganismGrid"
							model='[appFormId:appFormId,geoLocationlist:geoLocationlist,listOfScientistName:listOfScientistName,deleteCalled:deleteCalled,microOrgaScirntistName:microOrgaScirntistName,
								bioResourceLocations:bioResourceLocations,locations:locations,geoLocationlist1:geoLocationlist1,deleteCalled1:deleteCalled1,csrfPreventionSalt:"${ csrfPreventionSalt}"]'></g:render>

					</div>

				</g:if>
				<!-- start -->
				<div class="col-sm-12">
					<g:link controller="applicationManagement"
						action="depositionOfMicroOrganism" class="btn btn-primary"
						params='[appFormId:appFormId,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Previous</g:link>

					<g:set var="ListId1"
						value="${locations?.bioResource?.scientistName}"></g:set>
					<g:set var="ListId2" value="${newList?.scientistName}"></g:set>
					<g:if test="${(ListId1).containsAll(ListId2) == true}">

						<g:link controller="applicationManagement" action="formCPart3"
							class="btn  btn-primary pull-right"
							params='[formType:formType,appFormId:appFormId,csrfPreventionSalt:"${csrfPreventionSalt}"]'>Next</g:link>

					</g:if>
					<g:else>

						<a href="#" method="POST" class="btn btn-primary pull-right"
							onClick="AddPointerNone(this)">Next</a>
					</g:else>
				</div>


				<!-- end -->





			</div>




		</div>
	</div>
	</div>

	<div class="clearfix"></div>

</body>

</html>
