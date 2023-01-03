<%! import org.nba.common.State %>
					
						<table class="table table-bordered customtable">
							<tr>
								<td width="35px"><b>v</b></td>
								<td colspan="2"><b>Address of the contact preson /
										agent in India </b></td>
								<td><b>:</b></td>
								<g:if test="${allDataforMatching?.agentProfile}">
								<td style="min-width: 260px">Yes</td>
								</g:if><g:else>
									<td style="min-width: 260px">No</td>
								</g:else>
							</tr>
							<g:if test="${allDataforMatching?.agentProfile}">
							<tr>
								<td width="35px"></td>
								<td colspan="2"><b>Full Particular of the Contact
										Person</b></td>
								<td><b>:</b></td>
								<td><b>(a) Profile -</b> ${allDataforMatching?.agentProfile?.profile}
									<br /> <b>(b) Name -</b> ${allDataforMatching?.agentProfile?.title}
									${allDataforMatching?.agentProfile?.firstName} ${allDataforMatching?.agentProfile?.middleName}
									${allDataforMatching?.agentProfile?.lastName} <br /> <b>(c)
										Address -</b> ${allDataforMatching?.agentProfile?.address1} ${allDataforMatching?.agentProfile?.address2}
									${allDataforMatching?.agentProfile?.address3} <br /> <b>(d)
										State/UT -</b> ${State.findById(allDataforMatching?.agentProfile?.province)?.state}
									<br /> <b>(e) City -</b> ${allDataforMatching?.agentProfile?.city}<br />
									<b>(f) Zip/Pincode -</b> ${allDataforMatching?.agentProfile?.pincode}
									<br /> <b>(f) Mobile No -</b> ${allDataforMatching?.agentProfile?.mobile}<br /></td>
							</tr>
							<tr>
								<td width="35px"></td>
								<td colspan="2"><b>Attachment</b></td>
								<td><b>:</b></td>
								<td><table class="table table-bordered">
										<tr>
											<td colspan="2">Attachment Authorization Letter <g:if
													test="${allDataforMatching?.agentProfile?.authorizationLetter}">
													${allDataforMatching?.agentProfile?.authorizationLetterFileName}
													<g:link controller="applicationManagement"
														action="showAgentDc"
														id="${allDataforMatching?.agentProfile?.id}"
														target="_blank"
														params="[filename: 'authorizationLetter', dataName: 'authorizationLetter',csrfPreventionSalt:'${csrfPreventionSalt}']">
											(click here to preview)
										</g:link>
												</g:if> <g:else>
													<span class="text-danger">No Document Attached</span>
												</g:else>
											</td>
										</tr>
										<tr>
											<td>Number:<br /> ${allDataforMatching?.agentProfile?.photoIdNum}</td>
										</tr>

									</table></td>
							</tr>
							</g:if>
						</table>
				
					