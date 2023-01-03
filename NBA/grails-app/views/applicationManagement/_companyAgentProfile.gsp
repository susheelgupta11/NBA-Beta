		<g:uploadForm class="form-horizontal" role="form" autocomplete="off"
						action="saveAgentProfile">
		  <input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>			
						<div class="form-group col-sm-12">
							<label class="control-label col-sm-12 register-heading">(v)
								Address of the contact person / agent, if any, in India</label>
						</div>

						<div class="form-group col-sm-12">
							<div class="col-sm-7 g">

								<input type="radio" name="name" class="radio" value="Yes" 
									style="float: left"> <b
									style="float: left; padding-right: 2vw">Yes</b> <input
									type="radio" name="name" class="radio" value="No"
									style="float: left"> <b>No</b>

							</div>
						</div>

						<div class="Yes ">

							<div class="form-group col-sm-12 less-padding">
								<label class=" col-sm-4"><span class="col-sm-1">(a)</span><span
									class="col-sm-10"> Profile</span></label>
								<div class="col-sm-8">
									<g:select name="profile" from="${profiles}"
										
										class="width" onchange="hideshowother(this,'otherProfile2')" />
								
								</div>
							</div>




							<div class="form-group col-sm-12 less-padding" id="otherProfile2">
								<label class=" col-sm-4"><span class="col-sm-1">(i)</span><span
									class="col-sm-10">Please Specify</span></label>
								<div class="col-sm-8">
									<input type="text" class="width">
								</div>
							</div>



							<div class="form-group col-sm-12 less-padding">
								<label class="col-sm-4"><span class="col-sm-1">(b)</span>
									<span class="col-sm-10">Title</span></label>
								<div class="col-sm-8">
									<g:select name="agentTitle" class="width controlreq"
										
										from="${AgentProfile.TitleName.values()}"
										noSelection="['':'-Select title-']" />
								</div>
							</div>



							<div class="form-group col-sm-12 less-padding">
								<label class="col-sm-4"><span class="col-sm-1">(c)</span><span
									class="col-sm-10"> First Name</span></label>
								<div class="col-sm-8">
									<input type="text" class="width controlreq alp"
										name="agentFirstName" >
								</div>
							</div>





							<div class="form-group col-sm-12 less-padding">
								<label class="col-sm-4"><span class="col-sm-1">(d)</span><span
									class="col-sm-10"> Middle Name</span></label>
								<div class="col-sm-8">
									<input type="text" class="width alp"
										name="agentMiddleName" >
								</div>
							</div>





							<div class="form-group col-sm-12 less-padding">
								<label class=" col-sm-4 "><span class="col-sm-1">(e)</span><span
									class="col-sm-10"> Last Name </span></label>
								<div class="col-sm-8">
									<input type="text" class="width" name="agentLastName"
										class="width controlreq alp" >
								</div>
							</div>



							<div class="form-group col-sm-12 less-padding">
								<label class="col-sm-4 "><span class="col-sm-1">(f)</span><span
									class="col-sm-10"> Address line1</span></label>
								<div class="col-sm-8">
									<input type="text" class="width controlreq"
										name="agentAddress1" >
								</div>
							</div>



							<div class="form-group col-sm-12 less-padding">
								<label class=" col-sm-4"><span class="col-sm-1">(g)
								</span><span class="col-sm-10">Address line2</span></label>
								<div class="col-sm-8">
									<input type="text" class="width "
										name="agentAddress2" >
								</div>
							</div>




							<div class="form-group col-sm-12 less-padding">
								<label class="control-label col-sm-4"><span
									class="col-sm-1">(h)</span><span class="col-sm-10">
										Address line3</span></label>
								<div class="col-sm-8">
									<input type="text" class="width" name="agentAddress3"
										>
								</div>
							</div>
							<div class="form-group col-sm-12 less-padding">
								<label class=" col-sm-4 "><span class="col-sm-1">(i)
								</span><span class="col-sm-10">State / UT</span></label>
								<div class="col-sm-8">
									<g:select name="agentProvince" from="${listOfStates}"
										optionKey="state" optionValue="state"
										 class="  width ctrolreqddl"
										noSelection="['':'Select State']" />
								</div>
							</div>

							<div class="form-group col-sm-12 less-padding">
								<label class="col-sm-4 "><span class="col-sm-1">
										(j) </span><span class="col-sm-10">City</span></label>
								<div class="col-sm-8">
									<input type="text" class="width controlreq" name="agentCity"
										>
								</div>
							</div>



							<div class="form-group col-sm-12 less-padding">
								<label class="col-sm-4 "><span class="col-sm-1">(k)</span><span
									class="col-sm-10"> Zip / Pincode</span></label>
								
								<div class="col-sm-8 ">

									<input type="text" class="width controlclass1"
										placeholder="Zip/Pincode" name="pincode2" req1="1"
										>

								</div>

							</div>



							<div class="form-group col-sm-12 less-padding">
								<label class="col-sm-4 "><span class="col-sm-1">(l)</span><span
									class="col-sm-10"> Mobile</span></label>

								<div class="col-sm-2">

									<g:if test="${!agentProfile}">

										<input type="text" class="width controlclass1"
											readonly placeholder="Mobile No."
											name="mobileCode" value="+91">
									</g:if>
									<g:elseif test="${agentProfile?.mobile?.contains('-')}">
										<input type="text" class="width controlclass1"
											readonly placeholder="Mobile No."
											name="mobileCode" 
											 />

									</g:elseif>
								</div>
								<div class="col-sm-4 less-padding">
									<g:if test="${!agentProfile}">
										<input type="number" min="1" class="width controlreq"
											placeholder="Mobile No." name="mobile" req1="1" num1="1">
									</g:if>

									<g:elseif test="${agentProfile?.mobile?.contains('-')}">
										<input type="text" class="width controlreq"
											placeholder="Mobile No." name="mobile" req1="1" num1="1"
											>
									</g:elseif>

								</div>


							</div>



							<div class="form-group col-sm-12 less-padding">
								<label class=" col-sm-4 "><span class="col-sm-1">(m)</span><span
									class="col-sm-10"> Phone</span></label>
								<div class="col-sm-2">
									<g:if test="${!agentProfile}">
										<input type="text" class="width"
											readonly placeholder="Mobile No." name="PhoneCode"
											value="+91">
									</g:if>
									<g:elseif test="${agentProfile?.phone?.contains('-')}">
										<input type="text" class="width"
											readonly placeholder="Mobile No." name="PhoneCode"
											  />
									</g:elseif>
								</div>

							<div class="col-sm-4 less-padding">

									<g:if test="${!agentProfile}">
										<input type="number" min="1" class="width controlreq"
											placeholder="Phone No." name="phone" num1="1">
									</g:if>

									<g:elseif test="${agentProfile?.phone?.contains('-')}">
										<input type="text" class="width controlreq"
											placeholder="Phone No." name="phone" num1="1"
											>

									</g:elseif>
							</div>

							</div>
							



							<div class="form-group col-sm-12 less-padding">
								<label class=" col-sm-4 "><span class="col-sm-1">(n)</span><span
									class="col-sm-10">Email</span></label>
								<div class="col-sm-8">
									<input type="text" class="width controlreq email"
										name="agentEmail" >
								</div>
							</div>



							<div class="form-group col-sm-12 ">
								<label class=" col-sm-8" for="email"><span
									class="leftflot">(o)</span><span id="left-pad"
									class="col-sm-11"> Attach a copy of letter of
										authorization or power of attorney issued by the applicant to
										the agent / contact person in India </span></label>
								<div class="col-sm-4">
									<g:if test="${agentProfile?.authorizationLetter}">
										<input id="fualigh" type="file" class="width pdf controlreq"
											name="AgentAuthorityLetter">
										<g:link controller="applicationManagement"
											action="showAgentDc" id="${agentProfile?.id}" target="_blank"
											params="[filename: 'authorizationLetterFileName', dataName: 'authorizationLetterFileName',csrfPreventionSalt:'${csrfPreventionSalt}']">
											${agentProfile?.authorizationLetterFileName}
										</g:link>
									</g:if>
									<g:else>
										<input id="fualigh" type="file" class="width pdf controlreq"
											name="AgentAuthorityLetter">
									</g:else>
								</div>

							</div>





							<div class="form-group col-sm-12 ">
								<label class="col-sm-8" for="email"><span
									class="leftflot">(p)</span> <span id="left-pad"
									class="col-sm-11">Attach self attested copy of photo
										identity (Driving licence / Passport /
										Government ID ) of the agent / contact person</span></label>
								<div class="col-sm-4">
									<g:if test="${agentProfile?.passportCopy}">
										<input id="fualigh" type="file" class="width pdf controlreq"
											name="AgentPassportFile">
										<g:link controller="applicationManagement"
											action="showAgentDc" id="${agentProfile?.id}" target="_blank"
											params="[filename: 'passportCopyFileName', dataName: 'passportCopyFileName',csrfPreventionSalt:'${csrfPreventionSalt}']">
											${agentProfile?.passportCopyFileName}
										</g:link>
									</g:if>
									<g:else>
										<input id="fualigh" type="file" class="width pdf controlreq"
											name="AgentPassportFile">
									</g:else>
								</div>
								<div class="col-sm-12 text-right">


									<g:hiddenField name="isCompanyProfile" value="true" />
									<g:hiddenField name="formType" value="${formType}" />
									<input type="submit" class="btn btn-primary btncontrolclass"
										value="Submit" onClick="JavaScript:setsession()" />
								</div>


							</div>

						</div>
					</g:uploadForm>