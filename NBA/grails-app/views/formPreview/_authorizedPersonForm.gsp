<g:formRemote name="biologicalResources" class="form-horizontal"
						role="form"
						url="[controller:'applicationManagement',action:'saveContactperson']"
						update="divAuthorizedPersonGrid" onSuccess="ClearAllFields()"
						onComplete="loadPage()">

						<g:each in="${listOfContactPerson}" var="contactPersonInst">
						<div class="col-sm-12 form-group">

							<g:if test= "${contactPersonInst?.contactPerson == 'Self' }">
							<span class="col-sm-2"> <g:radio class=" radio col-sm-1" checked= "checked" disabled= "disabled"
									name="contactPerson" value="Self" /><span class="leftflot">&nbsp;
									${contactPersonInst?.contactPerson}</span></span></g:if>
<%--							<g:else>--%>
<%--								<span class="col-sm-2"> <g:radio class=" radio col-sm-1" disabled= "disabled"--%>
<%--									name="contactPerson" value="Self" /><span class="leftflot">&nbsp;--%>
<%--									Self</span></span>--%>
<%--							</g:else>--%>
							
									
							<g:if test= "${contactPersonInst?.contactPerson == 'Any Other Person accompanying applicant' }">		 
							<span class="col-sm-6"> <g:radio  disabled= "disabled"
									checked= "checked" class=" radio col-sm-1" name="contactPerson" value="Any Other Person accompanying applicant" /><span
								class="leftflot">&nbsp; ${contactPersonInst?.contactPerson}
									</span></span>
							</g:if>
<%--							<g:else>--%>
<%--							<span class="col-sm-6"> <g:radio disabled= "disabled"--%>
<%--									class=" radio col-sm-1" name="contactPerson" value="Any Other Person accompanying applicant" /><span--%>
<%--								class="leftflot">&nbsp; Any Other Person accompanying--%>
<%--									applicant</span></span></g:else>--%>
									
							
							<g:if test= "${contactPersonInst?.contactPerson == 'No' }">		
							 <span class="col-sm-2"> <g:radio class=" radio col-sm-1" checked= "checked" disabled= "disabled"
									name="contactPerson" value="No" /><span class="leftflot">
									&nbsp;Others </span>
							</span></g:if>
<%--							<g:else>--%>
<%--								<span class="col-sm-2"> <g:radio class=" radio col-sm-1" disabled= "disabled"--%>
<%--									name="contactPerson" value="No" /><span class="leftflot">--%>
<%--									&nbsp;Others</span>--%>
<%--								</span>--%>
<%--							</g:else>--%>

						</div>
						
					<g:if test= "${contactPersonInst?.contactPerson != 'Self' }">	
						<div class="margin-top ">
							<div class="form-group col-sm-12">
								<label class="control-label col-sm-3">(a) Name </label>
								<div class="col-sm-9">
									${contactPersonInst?.nameOfContactPerson}
								</div>
							</div>
							<div class="form-group col-sm-12 ">
								<label class="control-label col-sm-3">(b) Address </label>
								<div class="col-sm-9">
									${contactPersonInst?.addressOfContactPerson}"
								</div>
							</div>
							<div class="form-group col-sm-12 ">
								<label class="control-label col-sm-3">(c) Mobile </label>
								<div class="col-sm-9">
									${contactPersonInst?.mobileOfContactPerson}"
								</div>
							</div>
							<div class="form-group col-sm-12 " >
								<label class="control-label col-sm-3">(d) Email </label>
								<div class="col-sm-9">
									${contactPersonInst?.emailOfContactPerson}
								</div>
							</div>
							
						</div></g:if>
						</g:each>
					</g:formRemote>