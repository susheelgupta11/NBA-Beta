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

						<div class="col-sm-12 form-group margin-topp">
							<g:if test= "${listOfCompanyData?.size() > 1 }">
								<div class="form-group col-sm-12">
									<label class="control-label col-sm-12 register-heading">
										Address of the contact person / agent, if any, in India</label>
								</div>
							</g:if>
							<g:else>
								<div class="form-group col-sm-12">
									<label class="control-label col-sm-12 register-heading">(v)
										Address of the contact person / agent, if any, in India</label>
								</div>
							</g:else>	
						</div>

						
						<div >
							<div class="col-sm-12 form-group less-padding">

								<label class="control-label col-sm-4"><span
									class="col-sm-1">(a)</span><span class="col-sm-10">
										Profile</span></label>
								<div class="col-sm-8">
									${agentProfile?.profile}
								</div>
							</div>

                       
							<div class="col-sm-12 form-group less-padding">

								<label class="control-label col-sm-4"><span
									class="col-sm-1">(b)</span> <span class="col-sm-10">
										Name<span class="text-danger"><b>*</b></span>
								</span></label>
								<div class="col-sm-8">
									${agentProfile?.title}
									${agentProfile?.firstName}
									${agentProfile?.middleName}
									${agentProfile?.lastName}

								</div>
							</div>

							<div class="col-sm-12 form-group less-padding">

								<label class="control-label col-sm-4"><span
									class="col-sm-1">(c)</span> <span class="col-sm-10">Address
										<span class="text-danger"><b></b></span>
								</span></label>
								<div class="col-sm-8">
									${agentProfile?.address1}
									${agentProfile?.address2}
									${agentProfile?.address3}
									
								</div>
							</div>


							<div class="form-group col-sm-12 less-padding">
								<label class="control-label col-sm-4"><span
									class="col-sm-1">(d)</span> <span class="col-sm-10">
										State / UT</span></label>
								<div class="col-sm-8">
									${State.findById(agentProfile?.province)?.id}
								</div></div>
							
							<div class="col-sm-12 form-group less-padding">
								<label class="control-label col-sm-4"><span
									class="col-sm-1">(e)</span> <span class="col-sm-10">
										City 
								</span></label>
								<div class="col-sm-8">

									${agentProfile?.city}

								</div>

							</div>


							<div class="col-sm-12 form-group less-padding">

								<label class="control-label col-sm-4"><span
									class="col-sm-1">(f) </span> <span class="col-sm-10">ZIP
										/ Pincode 
								</span></label>

								<div class="col-sm-8">
									${agentProfile?.pincode}
								</div>

							</div>


							<div class="col-sm-12 form-group less-padding">

								<label class="control-label col-sm-4"><span
									class="col-sm-1">(g)</span> <span class="col-sm-10">Mobile<span
										class="text-danger"><b>*</b></span></span></label>
								<div class="col-sm-2">
									<g:if test="${!agentProfile }">
										N/A
									</g:if>
									<g:elseif test="${agentProfile?.mobile?.contains('-')}">
										${agentProfile?.mobile}
									</g:elseif>
								</div>
								
							</div>
							
							<div class="col-sm-12 form-group less-padding">

								<label class="control-label col-sm-4" for="email"><span
									class="col-sm-1">(h)</span> <span class="col-sm-10">Email</span></label>
								<div class="col-sm-8">
									${agentProfile?.email}
								</div>
							</div>

							<div class="col-sm-12 form-group ">

								<label class="control-label col-sm-12"><span
									class="leftflot">(i)</span> <span class="col-sm-11">
										Attached copy of letter of Authorization or power of attorney
										issued by the applicant to the agent/contact person in India</span></label>
								<div class="col-sm-5">
									<g:if test="${agentProfile?.authorizationLetter}">
										
										<g:link controller="applicationManagement"
											action="showAgentDc" id="${agentProfile?.id}" target="_blank"
											params="[filename: 'authorizationLetter', dataName: 'authorizationLetter',csrfPreventionSalt:'${csrfPreventionSalt}']">
											${agentProfile?.authorizationLetterFileName}
										</g:link>
									</g:if>
									<g:else>
										<span class= "text-danger">No Document Attached</span>
									</g:else>
								</div>

							</div>

							<div class="col-sm-12 form-group ">

								<label class="control-label col-sm-12"><span
									class="leftflot">(j)</span> <span class="col-sm-11">
										Attached self attested copy of photo identity (
										Driving Licence / Passport / Government ID) of the agent /
										contact person</span></label>
								<div class="col-sm-5 ">
									<g:if test="${agentProfile?.passportCopy}">
										<g:link controller="applicationManagement" class="fumargin"
											action="showAgentDc" id="${agentProfile?.id}" target="_blank"
											params="[filename: 'passportCopyFileName', dataName: 'passportCopyFileName',csrfPreventionSalt:'${csrfPreventionSalt}']">
											${agentProfile?.passportCopyFileName}
										</g:link>
									</g:if>
									<g:else>
										<span class= "text-danger">No Document Attached</span>
									</g:else>


								</div>

							</div>
						</div>

