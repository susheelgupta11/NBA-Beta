



						<div class="form-title col-sm-12">
							<label class="register-heading"> (3) Details of any
								national institution which will participate in the Research &
								Development activities </label>
						</div>
						<div class="col-sm-12 form-group">
							
								<label class="control-label col-sm-6"> (i) Is there any
									such participation : </label>
								<div class="col-sm-6">
				
<%--				<g:if test= "${!appForm }">--%>
<%--					<g:radio class="instituteparticipation" disabled= "disabled"--%>
<%--						name="instituteParticipation" value="Yes" />--%>
<%--							<span>Yes &nbsp;</span>--%>
<%--					<g:radio class="instituteparticipation"  disabled= "disabled"--%>
<%--							name="instituteParticipation" value="No" />--%>
<%--									<span>No</span>--%>
<%--				</g:if>--%>
				
				<g:if test="${appForm.instituteParticipation == true }">
					<g:radio class="instituteparticipation"  checked= "checked"
						name="instituteParticipation" value="Yes" disabled= "disabled"/>
							<span><b>Yes</b> &nbsp;</span>
				</g:if>
<%--				<g:else>--%>
<%--					<g:radio class="instituteparticipation" disabled= "disabled"--%>
<%--						name="instituteParticipation" value="Yes" />--%>
<%--							<span>Yes &nbsp;</span>--%>
<%--				</g:else>--%>
				
				<g:elseif test= "${appForm.instituteParticipation == false  }">					
					<g:radio class="instituteparticipation" radio-check="activities" checked= "checked"
							name="instituteParticipation" value="No" disabled= "disabled"/>
									<span><b>No</b></span>
				</g:elseif>
				<g:else>
					
									<span>Nothing Selected</span>
				</g:else>			
							</div>
						</div>
						
						<g:if test= "${appForm.instituteParticipation == true }">
						<div class="activities" id= "questionThree">
							<div class="col-sm-12 form-group">
								
									<label class="control-label col-sm-12">(ii)
										Provide the name and contact details of the institution / organisation participating
										in R & D</label>
									<div class="col-sm-12">

										<g:textArea class="width txtreq" name="detailsOfInstitute" disabled = "disabled" value="${appForm?.detailsOfInstitute}"></g:textArea>
									</div>

							</div>



							<div class="col-sm-12 form-group">
								
									<label class="control-label col-sm-12">(iii) Attach
										self-attested copy of MoU with the National Institution or
										letter of intent detailing the activity </label>
									<div class="col-sm-12">
										<g:if test="${appForm?.letterOfintent}">
<%--										<input type="file" class="width controlreq pdf" name="LetterOfIntent" />--%>
											<g:link controller="applicationManagement" action="showAppDc"
												id="${appForm?.id}" target="_blank"
												params="[filename: 'letterOfIntentName', dataName: 'letterOfIntentName',csrfPreventionSalt:'${csrfPreventionSalt}']">
												${appForm?.letterOfIntentName}
											</g:link>
										</g:if>
										<g:else>
											<span class= "text-danger"><b>No Document Attached</b></span>
<%--											<input type="file" class="width controlreq pdf" name="LetterOfIntent" />--%>
										</g:else>
									</div>
								
							</div>
						</div></g:if>


						<%int i=1 %>
						<g:each in="${quesAnswerMap}" var="mapKeyValue">
							<div class="form-title col-sm-12">
								<label class="register-heading completewidth"><span class="floatleft"> ${mapKeyValue?.getKey()?.questionNo}</span>
									<span class="col-sm-11	">${mapKeyValue?.getKey()?.question}</span></label>
							</div>
							<div class="col-sm-12 form-group">
								
									<div class="col-sm-12 ">
										<g:textArea placeholder="${mapKeyValue?.getKey()?.placeholder}" disabled = "disabled" class="width" name="answer_${mapKeyValue?.getKey()?.id}"
										 value="${mapKeyValue?.getValue()?.answer}" data-toggle="tooltip" req="1"
										  data-placement="top" title="${mapKeyValue?.getKey()?.questionTooltip}"></g:textArea>
									</div>
								
							</div>
							<%i++ %>
						</g:each>

						<div class="form-title col-sm-12">
							<label class="register-heading completewidth"> <span class="floatleft">(8)</span><span class="col-sm-11"> Proposed mechanism
								and arrangements for benefit sharing </span></label>
						</div>



						<div class="form-group col-sm-12">
							<label class="control-label col-sm-12"> <span class="floatleft"> (i)</span><span class="col-sm-11"> Is there any
								proposed mechanism and arrangements for benefit sharing
								(non-monetary / monetary) with the provider of the biological resource(s)
								and / or associated traditional knowledge in accordance with the
								BD Act / Rules thereon? </span></label>
								<div class="col-sm-12 form-group">
							<div class="col-sm-4">
							
							<g:if test= "${appForm?.isBenefitSharing == true }">
								<g:radio name="isBenefitSharing" class="radioshow" radio-check="Proposed" checked = "checked"
									value="Yes" disabled= "disabled" />
								<span>Yes &nbsp;</span></g:if>
<%--							<g:else>--%>
<%--								<g:radio name="isBenefitSharing" class="radioshow" radio-check="Proposed"--%>
<%--									value="Yes" disabled= "disabled"/>--%>
<%--								<span>Yes &nbsp;</span>--%>
<%--							</g:else>--%>
							
							
							<g:elseif test= "${appForm?.isBenefitSharing == false }">	
								<g:radio name="isBenefitSharing" value="No" class="radioshow" radio-check="Proposed" checked= "checked"
									disabled= "disabled" />
								<span>No</span></g:elseif>
							<g:else>
								<b>Nothing Selected</b>
							</g:else>

							</div>
							</div>
						</div>
				<g:if test= "${appForm?.isBenefitSharing == true }">
						<div class="form-group col-sm-12 Proposed">
							<label class="control-label col-sm-12"><span class="floatleft"> (ii)</span> <span class="col-sm-11"> If yes,
								attach a copy of mutually agreed terms between the applicant and
								the provider of biological resource(s) and / or associated
								traditional knowledge, if any </span></label>
							<div class="col-sm-8">
								<g:if test="${appForm?.sharingDoc}">
<%--								<input type="file"  class="width" name="BenefitOfSharingDoc" pdf="1" req="1">--%>
									<g:link controller="applicationManagement" action="showAppDc"
										id="${appForm?.id}" target="_blank"
										params="[filename: 'sharingDocName', dataName: 'sharingDocName',csrfPreventionSalt:'${csrfPreventionSalt}']">
										${appForm?.sharingDocName}
									</g:link>
								</g:if>
								<g:else>
								
									<span class= "text-danger"><b>No Document Attached</b></span>
<%--									<input type="file"  class="width controlreq pdf" name="BenefitOfSharingDoc" >--%>
								</g:else>
							</div>
						</div></g:if>
						
						<div class="form-title col-sm-12">
							<label class="register-heading completewidth"> <span
								class="floatleft">(9)</span><span class="col-sm-11"> Any
									other information considered relevant </span></label>
						</div>

						<div class="col-sm-12 form-group">

							<div class="col-sm-12 ">
								<g:textArea 
									class="width" name="otherInfo" disabled= "disabled"
									value="${appForm?.otherInfo}"></g:textArea>
							</div>

						</div>
						
						
