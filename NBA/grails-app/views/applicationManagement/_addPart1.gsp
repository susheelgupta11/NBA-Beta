<script><%--

$(document).ready(function() {
function endDateValidation(){
			$('#toTime').change(function(){
					var toDate = $('input:text[name=toTime]').val();
					var fromDate = $('input:text[name=fromTime]').val();
					var toDateSplit = toDate.split('/');
					var fromDateSplit = fromDate.split('/');
					var endDate = new Date(toDateSplit[2], toDateSplit][1]-1, toDateSplit[0]); 
					var startDate = new Date(fromDateSplit[2], fromDateSplit[1]-1, fromDateSplit[0])

					if(startDate <= endDate){
							
						}
					else if(endDate < startDate){
							$('#toTime').val('');
							alert('End Date should not be less then start date');
						}
				});
		}
});

--%></script>

					<g:formRemote name="biologicalResources" class="form-horizontal"
						role="form" autocomplete="off"
						url="[controller:'applicationManagement',action:'saveBiologicalResources']"
						update="updateBioResources" onSuccess="ClearAllFields()"
						onComplete="loadPage()">
					<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
			
						
						<div class="form-title col-sm-12 margin-top">
							<label class="register-heading"><span class="leftflot"> (i)</span><span class="col-sm-11">Identification
								(scientific name) of biological resources and its traditional
								use </span></label>
						</div>
						<div class="col-sm-12 form-group less-padding">
							
								<label class="control-label col-sm-4"><span class="col-sm-1">(a)</span> <span class="col-sm-10">Intend to access</span></label>
								<div class="col-sm-8">
									
										<div class=" row form-group less-padding">
								
									<span class="col-sm-5"> <input type="radio" name="accessIntention" value="Biological Resources" id="tradditional" onclick="showhidewithValidation(this)" class="istradditional radio col-sm-1"><span class="leftflot">&nbsp;Biological Resources</span></span>
								


								
									<span class="col-sm-5"> <input type="radio" name="accessIntention" value="Associated Knowledge" id="tradditional" onclick="showhidewithValidation(this)" class="istradditional radio col-sm-1"><span class="leftflot">&nbsp;Associated Knowledge</span>
									</span>
								


								
									<span class="col-sm-2"> <input type="radio" name="accessIntention" value="Both" id="tradditional" onclick="showhidewithValidation(this)" class="istradditional radio col-sm-1"><span class="leftflot">&nbsp;Both</span>
									</span>
								

							</div>
									
									
							
							</div>
						</div>
						
						<div class="col-sm-12 form-group less-padding">
							
								<label class="control-label col-sm-4"><span class="col-sm-1">(b)</span> <span class="col-sm-10"> Nature of
									biological resources</span></label>
								<div class="col-sm-8">
									<g:each in="${natureOfReources}" var="resource">
										<input type="radio" name="nature" class="Associate controlclass leftflot" value="${resource}" />
										&nbsp;${resource}</br>
									</g:each>
							
							</div>
						</div>
						<div class="col-sm-12 form-group less-padding">

								<label class="control-label col-sm-4"><span class="col-sm-1">(c)</span> <span class="col-sm-10"> Common Name<span class="text-danger"><b>*</b></span></span></label>
								<div class="col-sm-8">
									<input id="foucuscontrol" type="text"
										class="width controlclass Associate" name="commonName" >
								</div>
							
						</div>




						<div class="col-sm-12 form-group less-padding">
							
								<label class="control-label col-sm-4"><span class="col-sm-1">(d)</span> <span class="col-sm-10"> Scientific
									Name <span class="text-danger"><b>*</b></span> </span> </label>
								<div class="col-sm-8">

									<input type="text" class="width controlclass Associate"
										name="scientificName" alp1="1">
							
							</div>
						</div>



						
						<div class="col-sm-12 form-group less-padding">

								<label class="control-label col-sm-4"><span class="col-sm-1">(e)</span> <span class="col-sm-10"> Part of biological
									resources<span class="text-danger"><b>*</b></span> </span> </label>
								<div class="col-sm-8">
									<g:select name="bioResource" from="${resources}" value="" onchange="hideshowother(this,'other')"
										class="width controlclass Associate dsblcontrol1" noSelection="['':'-Select-']"
										 />


							</div>
						</div>
						<div id="other" class="col-sm-12 form-group less-padding">
						

								<label class="control-label col-sm-4"><span class="col-sm-1">(i)</span> <span class="col-sm-10">Please specify
									 <span class="text-danger"><b>*</b></span> </span> </label>
								<div class="col-sm-8">
									<input type="text" name="pleaseSpecify" class="width" />
							</div>
						</div>

						<div class="col-sm-12 form-group less-padding">
							
								<label class="control-label col-sm-4"><span class="col-sm-1">(f)</span> <span class="col-sm-10"> Quantity of
									the biological resource <span class="text-danger"><b>*</b></span></span>
									</label>
								<div class="col-sm-3">
									<input type="text" onfocusout="checkZeroValue(this)" class="width controlclass Associate num" name="quantity"/>
								</div>
								<div class="col-sm-3">
									<g:select name="qtyUnit" from="${quantityList}" value=""
										class="width controlclass Associate dsblcontrol1" noSelection="['':'-Select-']" />
								</div>
							
						</div>


						
<%--						<div class="col-sm-12 form-group less-padding" id="otherSource">--%>
<%--							--%>
<%--								<label class="control-label col-sm-4"><span class="col-sm-1">(i)</span> <span class="col-sm-10"> Please specify </span> </label>--%>
<%--								<div class="col-sm-8">--%>
<%--									<input type="text" name="otherSource" class="width ctrl1">--%>
<%--								</div>--%>
<%--							--%>
<%--						</div>--%>
						<div class="col-sm-12 form-group less-padding">
							
								<label class="control-label col-sm-4"><span class="col-sm-1">(g)</span> <span class="col-sm-10"> Time span in
									which the biological resource is proposed to be collected <span class="text-danger"><b>*</b></span></span> </label>
								<div class="col-sm-3">
									<label>From:</label> <input type="text"
										class="controlclass  width datePicker fromTime" 
										name="fromTime" >
								</div>
								<div class="col-sm-3">
									<label>To:</label> <input type="text"
										class="controlclass  width datePicker toTime" 
										name="toTime" >
								</div>
							
						</div>


						<div class="col-sm-12 form-group less-padding">
						
								<label class="control-label col-sm-4" for="email"><span class="col-sm-1">(h)</span>  <span class="col-sm-10">
									Traditional use, if any </span> </label>
								<div class="col-sm-8">
									<input type="text" class=" width controlclass " maxword50="1" name="traditionalUse">
								</div>
						
						</div>


						<div class="form-group col-sm-12 text-right less-padding">


							<g:hiddenField name="appFormId" value="${appForm?.id}" />
							<g:hiddenField name="formType" value="${formType}" />
							<input type="Submit" class="btn btn-primary  btnclass disablebtn"
								value="Save"></input> <input type="button"
								class="btn btn-primary focusbtn " value="Add More"></input>

							<%--								<g:if test="${listOfBioResources?.size() == 0}">--%>
							<%--									<input type="Submit"--%>
							<%--										class="btn btn-primary pull-right btncontrolclass1"--%>
							<%--										value="Submit"></input>--%>
							<%--								</g:if>--%>
							<%--								<g:else>--%>
							<%--									<input type="Submit"--%>
							<%--										class="btn btn-primary pull-right btncontrolclass1"--%>
							<%--										value="Add More"></input>--%>
							<%--								</g:else>--%>

						</div>

					</g:formRemote>