<g:formRemote name="biologicalResources" class="form-horizontal"
						role="form" autocomplete="off"
						url="[controller:'applicationManagement',action:'saveEditForm1Part3']"
						update="divAuthorizedPersonGrid" onSuccess="ClearAllFields()"
						onComplete="loadPage()">
<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>

<%--<g:form controller="applicationManagement" action="saveForm3">--%>
						<div class="form-title col-sm-12">
							<label class="register-heading"> (e) Name and number of
								persons authorized by the applicant for making the selection </label>
						</div>
						
						<div class="col-sm-12 form-group">

<%--							<g:if test= "${appForm?.selfAuthorizedPerson == 'Self' || contactPersonInst?.contactPerson == 'Self' }">--%>
							<g:if test= "${contactPersonInst?.contactPerson != 'Any Other Person accompanying applicant' && 
											contactPersonInst?.contactPerson != 'No' && appForm?.selfAuthorizedPerson == 'Self'}">
							<span class="col-sm-2"> <g:radio class="contactPerson radio col-sm-1" checked= "checked" onclick="hideshowmorebtn(this)"
									name="contactPerson" value="Self" /><span class="leftflot">&nbsp;
									Self</span></span></g:if>
							
							<g:else>
								<span class="col-sm-2"> <g:radio class="contactPerson radio col-sm-1" onclick="hideshowmorebtn(this)"
									name="contactPerson" value="Self" /><span class="leftflot">&nbsp;
									Self</span></span>
							</g:else>
							
									
							<g:if test= "${contactPersonInst?.contactPerson == 'Any Other Person accompanying applicant' }">		 
							<span class="col-sm-6"> <g:radio 
									checked= "checked" class="contactPerson radio col-sm-1" onclick="hideshowmorebtn(this)" name="contactPerson" value="Any Other Person accompanying applicant" /><span
								class="leftflot">&nbsp; ${contactPersonInst?.contactPerson}
									</span></span>
							</g:if>
							<g:else>
							<span class="col-sm-6"> <g:radio
									class="contactPerson radio col-sm-1" name="contactPerson" onclick="hideshowmorebtn(this)" value="Any Other Person accompanying applicant" /><span
								class="leftflot">&nbsp; Any Other Person accompanying
									applicant</span></span></g:else>
									
							
							<g:if test= "${contactPersonInst?.contactPerson == 'No' }">		
							 <span class="col-sm-2"> <g:radio class="contactPerson radio col-sm-1" onclick="hideshowmorebtn(this)" checked= "checked"
									name="contactPerson" value="No" /><span class="leftflot">
									&nbsp;Others </span>
							</span></g:if>
							<g:else>
								<span class="col-sm-2"> <g:radio class="contactPerson radio col-sm-1" onclick="hideshowmorebtn(this)"
									name="contactPerson" value="No" /><span class="leftflot">
									&nbsp;Others</span>
								</span>
							</g:else>

						</div>
						
						
						<div class="margin-top ">
							<div class="form-group col-sm-12 ">
								<label class="control-label col-sm-3">(a) Name </label>
								<div class="col-sm-9">
									<input id="foucuscontrol" type="text"
										class="width ctrlvalidate" req1="1" name="nameOfContactPerson"
										 value="${contactPersonInst?.nameOfContactPerson}"/>
<%--										 value="${appForm?.contactPersons?.nameOfContactPerson}"--%>
								</div>
							</div>
							<div class="form-group col-sm-12 ">
								<label class="control-label col-sm-3">(b) Address </label>
								<div class="col-sm-9">
									<input type="text" class="width ctrlvalidate" req1="1"
										name="addressOfContactPerson" 
										 value="${contactPersonInst?.addressOfContactPerson}"/>
<%--										 value="${appForm?.contactPersons?.addressOfContactPerson}"--%>
								</div>
							</div>
							<div class="form-group col-sm-12 ">
								<label class="control-label col-sm-3">(c) Mobile </label>
								<div class="col-sm-9">
									<input type="text" class="width ctrlvalidate" mob1="1"
										name="mobileOfContactPerson" 
										 value="${contactPersonInst?.mobileOfContactPerson}"/>
<%--										 value="${appForm?.contactPersons?.mobileOfContactPerson}"--%>
								</div>
							</div>
							<div class="form-group col-sm-12 " >
								<label class="control-label col-sm-3">(d) Email </label>
								<div class="col-sm-9">
									<input type="text" class="ctrlvalidate width" req1="1"
										email1="1" name="emailOfContactPerson"
										value="${contactPersonInst?.emailOfContactPerson}" />
<%--										 value="${appForm?.contactPersons?.emailOfContactPerson}"--%>
								</div>
							</div>
							<div class="form-group col-sm-12">
							<g:hiddenField name="appId" value="${appForm?.id}"></g:hiddenField>
							<g:hiddenField name="contactPersonInstId" value="${contactPersonInst?.id}"></g:hiddenField>
								<input type="submit" class="btn btn-primary focusbtn pull-right btnctrlvalidate"
									Value="Update" />
															</div>
						</div>
					</g:formRemote>