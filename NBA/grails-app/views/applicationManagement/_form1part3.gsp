
<g:formRemote name="biologicalResources" class="form-horizontal"
						role="form" autocomplete="off"
						url="[controller:'applicationManagement',action:'saveContactperson']"
						update="divAuthorizedPersonGrid" onSuccess="ClearAllFields()"
						onComplete="loadPage()">
						
<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>						


<%--<g:form controller="applicationManagement" action="saveForm3">--%>
						<div class="form-title col-sm-12">
							<label class="register-heading"> (e) Name and number of
								persons authorized by the applicant for making the selection </label>
						</div>
					<div class="col-sm-12 form-group">
					
							<g:if test= "${appForm?.selfAuthorizedPerson == 'Self'}"> 	
								<span class="col-sm-2"> <g:radio class="contactPerson radio col-sm-1" onclick="hideshowmorebtn(this)"
									name="contactPerson" checked="checked" value="Self" /><span class="leftflot">&nbsp;
									Self</span></span>
							</g:if>
							<g:else>
							<span class="col-sm-2"> <g:radio class="contactPerson radio col-sm-1" onclick="hideshowmorebtn(this)"
									name="contactPerson" value="Self" /><span class="leftflot">&nbsp;
									Self</span></span>
							</g:else>		
									 
							<span class="col-sm-6"> <g:radio
									class="contactPerson radio col-sm-1" onclick="hideshowmorebtn(this)" name="contactPerson" value="Any Other Person accompanying applicant" /><span
								class="leftflot">&nbsp; Any Other Person accompanying
									applicant</span></span>
									
							<span class="col-sm-2"> <g:radio class="contactPerson radio col-sm-1"  onclick="hideshowmorebtn(this)"
									name="contactPerson" value="No" /><span class="leftflot">
									&nbsp;Others</span>
							</span>

					</div>
						
						<div class="margin-top ">
							<div class="form-group col-sm-12">
								<label class="control-label col-sm-3">(a) Name </label>
								<div class="col-sm-9">
									<input id="foucuscontrol" type="text"
										class="width ctrlvalidate hideOnSelf"  name="nameOfContactPerson" req1="1"
										 />
<%--										 value="${appForm?.contactPersons?.nameOfContactPerson}"--%>
								</div>
							</div>
							<div class="form-group col-sm-12 ">
								<label class="control-label col-sm-3">(b) Address </label>
								<div class="col-sm-9">
									<input type="text" class="width ctrlvalidate hideOnSelf"  req1="1"
										name="addressOfContactPerson" 
										 />
<%--										 value="${appForm?.contactPersons?.addressOfContactPerson}"--%>
								</div>
							</div>
							<div class="form-group col-sm-12 ">
								<label class="control-label col-sm-3">(c) Mobile </label>
								<div class="col-sm-9">
									<input type="number" min="1" class="width ctrlvalidate hideOnSelf" req1="1" num1="1" mob1="1"
										name="mobileOfContactPerson" 
										/>
<%--										 value="${appForm?.contactPersons?.mobileOfContactPerson}"--%>
								</div>
							</div>
							<div class="form-group col-sm-12 " >
								<label class="control-label col-sm-3">(d) Email </label>
								<div class="col-sm-9">
									<input type="text" class="ctrlvalidate width hideOnSelf" req1="1" email1="1"
										 name="emailOfContactPerson"
										 />
<%--										 value="${appForm?.contactPersons?.emailOfContactPerson}"--%>
								</div>
							</div>
							<div class="form-group col-sm-12 text-right">
							
							<g:hiddenField name="appId" value="${appForm?.id}"></g:hiddenField>
								<input type="submit" class="btn btn-primary focusbtn  btnctrlvalidate hideOnSelf"
									Value="Save" />
									<input type="button" class="btn btn-primary focusbtn addmored"
									Value="Add more" />
															</div>
						</div>
					</g:formRemote>