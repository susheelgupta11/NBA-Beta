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
<%--		Entity();--%>
		AddActiveClass("menu2");
		addCompletegreenClass(tabStatus);
<%--		BindValidation("ctlwidth", "btnctrl");--%>
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
		
		if(!entityObj){
			$(".hoiBlock").hide();
			$("#supervisorRadio").attr("checked","true");
			$("#headOfInstName").removeAttr("req1");
			$("#headOfInstDesignation").removeAttr("req1");
			}
		else if(supName && supDesig){
			$(".supervisorBlock").show();
			$(".hoiBlock").hide();
			if(supervisorOrHoi == "supervisor"){
				$("#supervisorRadio").attr("checked","true");
				$("#hoiRadio").removeAttr("checked");
				}
			}
		else if(hoiName && hoiDesig){
			$(".supervisorBlock").hide();
			$(".hoiBlock").show();
			if(supervisorOrHoi == "headofinstitution"){
				$("#supervisorRadio").removeAttr("checked");
				$("#hoiRadio").attr("checked","true");
				}
			}
		

		
		
	});


	function showHoiBlock(){
		$(".supervisorBlock").hide();
		$(".hoiBlock").show();
		$("#name").removeAttr("req1");
		$("#supervisorDesignation").removeAttr("req1");
		}
	function showsupervisorBlock(){
		$(".supervisorBlock").show();
		$(".hoiBlock").hide();
		$("#headOfInstName").removeAttr("req1");
		$("#headOfInstDesignation").removeAttr("req1");
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

	
	
</script>
</head>

<body>
<g:javascript>  
  var tabStatus = "${tabStatus}"
  var entityObj = "${entity2 }"
  var supName = "${entity2?.name }"
  var supDesig = "${entity2?.supervisorDesignation }"
  var hoiName = "${entity2?.headOfInstName }"
  var hoiDesig = "${entity2?.headOfInstDesignation }"
  var supervisorOrHoi = "${entity2?.supervisorOrHoi }"
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

						<div class="form-title ">
							<label class="col-sm-12 register-heading"><span class="leftflot">(2)</span>
							<span class="col-sm-11"> Name and address of Institution at the place of work in India </span></label>
						</div>
					</div>
					
					
					
					
			<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}" />


					<div >
							<g:render template="formBpart2"></g:render>
					</div>
				</div>

				<div class="clearfix"></div>
				<div class="main-registeration col-sm-12"
					>
					<g:render template="formBPart2HeadDetails" />
					<!--login form ends -->
				</div>

				<div class="clearfix"></div>
				

				<div class="clearfix"></div>
				<div class=" col-sm-12">
					<!--login form -->
					

						<div class="form-group">
							<div class="col-sm-12">
								
									<g:link controller="formB"
										action="indianResearcher"
										params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
										class="btn btn-primary
									">Previous</g:link>
							
									<g:link controller="formB" action="formBPart3"
										params='[appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]'
										class="btn  btn-primary pull-right" method="POST">Next</g:link>
								
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
