<%! import org.nba.application.AgentProfile %>
<%! import org.nba.common.State %>
<script type="text/javascript">
	$(document).ready(function() {
		Entity();
	});
	$('#otherAgentProfile').hide();
	function agentProfileOther(){
		$('#otherAgentProfile').show();
		}
</script>
<g:uploadForm class="form-horizontal" role="form" autocomplete="off"
						action="saveAgentProfile">
<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>					
						<div class="col-sm-12 form-group">
						
						<g:if test= "${profile}">
						
							<div class="form-group col-sm-12">
								<label class="control-label col-sm-12 register-heading">(v)
									Address of the contact person / agent, if any, in India</label>
							</div>
						</g:if>
						<g:else>
						
							<div class="form-group col-sm-12">
								<label class="control-label col-sm-12 register-heading">(iv)
									Address of the contact person / agent, if any, in India</label>
						</div>
						</g:else>	
						</div>

						<div class="col-sm-12 form-group ">

							<div class="col-sm-7 ">
                              <g:if test="${agentProfile}">
								<input type="radio" name="name" checked="checked" class="radio agent" onclick="removeSession()" value="Yes"
									style="float: left"></g:if><g:else> 
									<input type="radio" name="name" id="ifYes" class="radio agent" onclick="removeSession()" value="Yes"
									style="float: left">
									</g:else> <b
									style="float: left; padding-right: 2vw"> &nbsp;Yes</b> <input
									type="radio" name="name" class="radio" value="No"
									style="float: left"> <b> &nbsp;No</b>

							</div>
						</div>
						<div class="Yes">
							<div class="col-sm-12 form-group less-padding">

								<label class="control-label col-sm-4"><span
									class="col-sm-1">(a)</span><span class="col-sm-10">
										Profile</span></label>
								<div class="col-sm-8">
								<g:if test= "${profile }">
								  		<g:if test= "${agentProfile?.profile?.contains('-') }">
											<g:select name="agentProfile" id="agentProfileId" from="${profile}"
										 		value="${agentProfile?.profile?.split('-')[0]}"
												class="width  controlreq" onchange="hideshowother(this,'otherAgentProfile')" />
								  		 </g:if>
								   		 <g:else>
								   			 <g:select name="agentProfile" id="agentProfileId" from="${profile}"
										 		value="${agentProfile?.profile}"
												class="width  controlreq" onchange="hideshowother(this,'otherAgentProfile')" />
								  		 </g:else>
								</g:if>
								<g:else>
										<g:if test= "${agentProfile?.profile?.contains('-') }">
											<g:select name="agentProfile" id="agentProfileId" from="${profiles}"
										 		value="${agentProfile?.profile?.split('-')[0]}"
												class="width  controlreq" onchange="hideshowother(this,'otherAgentProfile')" />
								  		 </g:if>
								   		 <g:else>
								   			 <g:select name="agentProfile" id="agentProfileId" from="${profiles}"
										 		value="${agentProfile?.profile}" 
												class="width  controlreq" onchange="hideshowother(this,'otherAgentProfile')" />
								  		 </g:else>
								</g:else>
								
								
								
								
<%--								<g:else>--%>
<%--									<g:select name="agentProfile" from="${profiles}"--%>
<%--										 value="${agentProfile?.profile}"--%>
<%--										class="width  controlreq" onchange="hideshowother(this,'otherAgentProfile')" />--%>
<%--								</g:else>--%>
										

								</div>
							</div>

                            <g:if test= "${agentProfile?.profile?.contains('-')  }">
							<div class="col-sm-12 form-group less-padding"
								id="otherAgentProfile">

								<label class="control-label col-sm-4"><span
									class="col-sm-1">(i)</span> <span class="col-sm-10">
										Please Specify</span></label>
								<div class="col-sm-8">
									<input type="text" class="width" name="otherProfile" value="${agentProfile?.profile?.split('-')[1]}">
								</div>

							</div>
							</g:if>
							<g:else>
							<div class="col-sm-12 form-group less-padding"
								id="otherAgentProfile">

								<label class="control-label col-sm-4"><span
									class="col-sm-1">(i)</span> <span class="col-sm-10">
										Please Specify</span></label>
								<div class="col-sm-8">
									<input type="text" name="otherProfile" class="width ">
								</div>

							</div>
							</g:else>
							
							<div class="col-sm-12 form-group less-padding">

								<label class="control-label col-sm-4"><span
									class="col-sm-1">(b)</span> <span class="col-sm-10">
										Title<span class="text-danger"><b>*</b></span>
								</span></label>
								<div class="col-sm-8">
									<g:select name="agentTitle" class="width controlreq"
										value="${agentProfile?.title}"
										from="${AgentProfile.TitleName.values()}"
										noSelection="['':'-Select title-']" />

								</div>
							</div>


							<div class="col-sm-12 form-group less-padding">

								<label class="control-label col-sm-4"><span
									class="col-sm-1">(c)</span> <span class="col-sm-10">First
										Name<span class="text-danger"><b>*</b></span>
								</span></label>
								<div class="col-sm-8">

									<input type="text" class="width controlreq alp"
										name="agentFirstName" value="${agentProfile?.firstName}">


								</div>
							</div>
							<div class="col-sm-12 form-group less-padding">

								<label class="control-label col-sm-4"><span
									class="col-sm-1">(d)</span> <span class="col-sm-10">Middle
										Name</span></label>
								<div class="col-sm-8">


									<input type="text" class="width " name="agentMiddleName"
										value="${agentProfile?.middleName}">



								</div>
							</div>
							<div class="col-sm-12 form-group less-padding">

								<label class="control-label col-sm-4"><span
									class="col-sm-1">(e)</span> <span class="col-sm-10">Last
										Name<span class="text-danger"><b>*</b></span>
								</span></label>
								<div class="col-sm-8">

									<input type="text" class="width controlreq alp"
										name="agentLastName" value="${agentProfile?.lastName}">


								</div>
							</div>
							<div class="col-sm-12 form-group less-padding">

								<label class="control-label col-sm-4"><span
									class="col-sm-1">(f)</span> <span class="col-sm-10">Address
										Line 1<span class="text-danger"><b>*</b></span>
								</span></label>
								<div class="col-sm-8">

									<input type="text" class="width controlreq"
										name="agentAddress1" value="${agentProfile?.address1}">


								</div>
							</div>
							<div class="col-sm-12 form-group less-padding">

								<label class="control-label col-sm-4"><span
									class="col-sm-1">(g)</span> <span class="col-sm-10">Address
										Line 2</span></label>
								<div class="col-sm-8">

									<input type="text" class="width " name="agentAddress2"
										value="${agentProfile?.address2}">


								</div>
							</div>
							<div class="col-sm-12 form-group less-padding">

								<label class="control-label col-sm-4"><span
									class="col-sm-1">(h)</span> <span class="col-sm-10">Address
										Line 3</span></label>
								<div class="col-sm-8">

									<input type="text" class="width" name="agentAddress3"
										value="${agentProfile?.address3}">


								</div>
							</div>


							<div class="form-group col-sm-12 less-padding">
								<label class="control-label col-sm-4"><span
									class="col-sm-1">(i)</span> <span class="col-sm-10">
										State / UT</span></label>
								<div class="col-sm-8">
									<%--<g:if test="${formType == 'Form2' || formType == 'Form3'}">

										--%>
										<g:select name="agentProvince" from="${listOfStates}"
											optionKey="id" optionValue="state" value="${State.findById(agentProfile?.province)?.id}"
											class="width controlreq" 
											noSelection="['':'Select State']" />
									<%--</g:if>
									<g:elseif test="${formType == 'Form1' || formType == 'Form4' }">
										<input type="text" class="width" name="agentProvince"
											value="${agentProfile?.province}">
									</g:elseif>
								</div>
							--%></div></div>
							<div class="col-sm-12 form-group less-padding">

								<label class="control-label col-sm-4"><span
									class="col-sm-1">(j)</span> <span class="col-sm-10">
										City <span class="text-danger"><b>*</b></span>
								</span></label>
								<div class="col-sm-8">

									<input type="text" class="width controlreq" name="agentCity"
										value="${agentProfile?.city}">

								</div>

							</div>





							<div class="col-sm-12 form-group less-padding">

								<label class="control-label col-sm-4"><span
									class="col-sm-1">(k) </span> <span class="col-sm-10">ZIP
										/ Pincode <span class="text-danger"><b>*</b></span>
								</span></label>

								<%--								<div class="col-sm-2">--%>
								<%--									<g:if test="${!agentProfile }">--%>
								<%--										<input type="text" class="width controlreq" name="pincode1" PlaceHolder="Country Code">--%>
								<%--									</g:if>--%>
								<%--									<g:else>--%>
								<%--										<input type="text" class="width controlreq" name="pincode1" PlaceHolder="Country Code"--%>
								<%--											value="${agentProfile?.pincode?.split('-')[0]}">--%>
								<%--									</g:else>--%>
								<%--								</div>--%>


								<div class="col-sm-8">
									<input type="text" class="width controlreq" num1=""
										name="pincode2" PlaceHolder="Zip / Pin Code"
										value="${agentProfile?.pincode}">
								</div>

							</div>


							<div class="col-sm-12 form-group less-padding">

								<label class="control-label col-sm-4"><span
									class="col-sm-1">(l)</span> <span class="col-sm-10">Mobile<span
										class="text-danger"><b>*</b></span></span></label>
								<div class="col-sm-2">
									<g:if test="${!agentProfile }">
										<input type="text" class="width" 
											readonly name="mobileCode"
											PlaceHolder="Mobile Number" value="+91">
									</g:if>
									<g:elseif test="${agentProfile?.mobile?.contains('-')}">
										<input type="text" class="width " 
											readonly name="mobileCode"
											PlaceHolder="Mobile Number" value="${agentProfile?.mobile?.split('-')[0] }">
									</g:elseif>
								</div>
								<div class="col-sm-4 less-padding">
									<g:if test="${!agentProfile }">
										<input type="number" min="1" class="width controlreq" mob1="1"
											 name="mobile" PlaceHolder="Mobile Number"
											value="">
									</g:if>
									<g:else>
										<input type="text" class="width controlreq" mob1="1"
											name="mobile" PlaceHolder="Mobile Number"
											value="${agentProfile?.mobile?.split('-')[1]}">

									</g:else>

								</div>
							</div>
							<div class="col-sm-12 form-group less-padding">

								<label class="control-label col-sm-4" for="email"><span
									class="col-sm-1">(m)</span> <span class="col-sm-10">Email<span
										class="text-danger"><b>*</b></span></span></label>
								<div class="col-sm-8">

									<input type="text" class="width controlreq" email1="1"
										name="agentEmail" value="${agentProfile?.email}">


								</div>
							</div>

							<div class="col-sm-12 form-group ">

								<label class="control-label col-sm-12"><span
									class="leftflot">(n)</span> <span class="col-sm-11">
										Attach a copy of letter of Authorization or power of attorney
										issued by the applicant to the agent/contact person in India</span></label>
								<div class="col-sm-5">
									<g:if test="${agentProfile?.authorizationLetter}">
										<input type="file" class="width  fumargin"
											name="AgentAuthorityLetter"
											value="${agentProfile?.authorizationLetter}">
										<g:link controller="applicationManagement"
											action="showAgentDc" id='${agentProfile?.id}' target='_blank'
											params='[filename: "authorizationLetter", dataName: "authorizationLetter",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
											${agentProfile?.authorizationLetterFileName}
										</g:link>
									</g:if>
									<g:else>
										<input type="file" class="width controlreq pdf fumargin"
											name="AgentAuthorityLetter">
									</g:else>
								</div>
							</div>

							<div class="col-sm-12 form-group ">
								<label class="control-label col-sm-12"><span
									class="leftflot">(o)</span> <span class="col-sm-11">
										Attach self attested copy of photo identity (Driving Licence / Passport / Government ID) of the agent /
										contact person</span></label>
								
									<g:if test="${agentProfile?.passportCopy}">
									
									       <div class="col-sm-3 " >
											<g:select id="foucuscontrol" name="photoIdSelect" req1="1"
												class="width controlclass1 fumargin" value="${agentProfile?.photoIdSelect }"
												from="${agentPhotoIdSelect }"
												noSelection="['':'-Select Proof-']" />
			  								</div>	
			  
			  							<div class="col-sm-3 " >
											<input type="text" class="width controlclass1 fumargin" name="photoIdNum" placeholder="Photo Id Number"
												value="${agentProfile?.photoIdNum }" >
			  							</div>
			  
			  							<div class="col-sm-5 " >
										<input type="file" class="width  fumargin"
											name="AgentPassportFile"
											value="${agentProfile?.passportCopy}">
										<g:link controller="applicationManagement" class="fumargin"
											action="showAgentDc" id="${agentProfile?.id}" target='_blank'
											params='[filename: "passportCopyFileName", dataName: "passportCopyFileName",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
											${agentProfile?.passportCopyFileName}
										</g:link>
										</div>
									</g:if>
									<g:else>
										<input type="file" class="width pdf controlreq fumargin"
											name="AgentPassportFile">
									</g:else>
								

								<div class="form-group col-sm-12 text-right">
									<g:hiddenField name="agentProfileId"
										value="${agentProfile?.id}" />
									<g:hiddenField name="isIndividualProfile" value="true" />
									<g:hiddenField name="formType" value="${formType}" />
									<g:hiddenField name="appFormId" value="${appForm?.id}" />
									<input type="Submit" class="btn btn-primary btncontrol"
										onClick="JavaScript:setsession()" value="Save"></input>

								</div>
							</div>
						</div>
					</g:uploadForm>