
<g:if test="${periodicReportInstance}">
						<script type="text/javascript">
$( document ).ready(function() {
	 document.getElementById("myCheck").checked = true;
});

</script>
					</g:if>

					<g:if test="${periodicReportInstance?.haveAppliedPatent}">
						<script type="text/javascript">
$( document ).ready(function() {
	 document.getElementById("haveA").style.display = 'block';
});
</script>
					</g:if>

					<g:if test="${periodicReportInstance?.haveTransferredResults}">
						<script type="text/javascript">
$( document ).ready(function() {
	 document.getElementById("transf").style.display = 'block';
});

</script>
					</g:if>

					<g:if test="${periodicReportInstance?.haveTransferredBiological}">

						<script type="text/javascript">
$( document ).ready(function() {
	 document.getElementById("transBio").style.display = 'block';
});

</script>
					</g:if>

					

						<table class="table table-bordered customtable main-account">
							<caption class="text-center">
								<b>Submission of yearly status report for Form-I – Research</b>
							</caption>
							<tbody>
							<tr>
				<td colspan="2">Period of Status Report
				<span style="margin-inline-start: 200px;">From:<input name="fromDate" type="text" placeholder="Start Date" autocomplete="off" value="${periodicReportInstance?.periodFrom}"  id="startdate" required="required"></span>
				
				</td>
				<td>To:<input  name="toDate" type="text" autocomplete="off" placeholder="End Date" id="enddate" value="${periodicReportInstance?.periodTo}" required="required"></td>
				</tr>
								<tr>
									<th class="text-center"><b>S.no</b></th>
									<th class="text-center" style="width: 300px"><b>Particulars</b></th>
									<th style="width: 200px"><b>Status Reply<br>( to
											be furnished by the Applicant)
									</b></th>
								</tr>
								<tr>
									<td>1</td>
									<td>Application Number</td>
									<td><g:textField name="applicationNumber"
											value="${formDetails?.appNumber}" style="width:100%"
											readonly="true" /></td>
								</tr>

								<tr>
									<td>2</td>
									<td>Name of the Applicant</td>
									<td>
										${fullName}
									</td>
								</tr>
								<tr>
									<td>3</td>
									<td>Date of Agreement signed</td>
									<td><input type="text" id="datetimepicker" name="agreementSignDt"
										value="${periodicReportInstance?.agreementSignDt}"
										style="width: 100%" /></td>
								</tr>
								<tr>
									<td>4</td>
									<td>Whether the biological resources accessed from the approved locations ?</td>
									<td><g:radioGroup name="whetherAccessedBioRes"
											value="${periodicReportInstance?.whetherAccessedBioRes}"
											labels="['Yes','No']" values="['Yes','No']">
											<label> <span class="radioSpan"> ${it.radio}
											</span> ${it.label}</label>
										</g:radioGroup>
										</td>
										
										 <%--			<g:textField name="whetherAccessedBioRes" value="${periodicReportInstance?.whetherAccessedBioRes}" style="width:100%"/>--%>
								</tr>
								<tr>
									<td>5</td>
									<td>Date of biological resources accessed for research</td>
									<td>From : <input type="text" id="bio-startdate"
										name="whenBiologicalResearch" autocomplete="off"
										value="${periodicReportInstance?.whenBiologicalResearch} "
										style="width: 100%" required="required"/><br> To : <input type="text" id="bio-enddate"
										name="whenBiologicalResearchTo" autocomplete="off"
										value="${periodicReportInstance?.whenBiologicalResearchTo}"
										style="width: 100%"  required="required"/>

									</td>
								</tr>
								<tr>
									<td>6</td>
									<td>Where the research and development activities was carried out ?</td>
									<td><g:textField name="reserchCarriedOut"
											style="width:100%"
											value="${periodicReportInstance?.reserchCarriedOut}" /></td>
								</tr>
								<tr>
									<td>7</td>
									<td>Brief of the research carried out on the accessed biological resources/ outcome of the research </td>
									<td><g:textField name="briefResearchCarried"
											style="width:100%"
											value="${periodicReportInstance?.briefResearchCarried}" /></td>
								</tr>
								<tr>
									<td>8</td>
									<td>Have you made any publications based on this research ?</td>
									<td><g:if
											test="${periodicReportInstance?.publishCheck == '' ||  periodicReportInstance?.publishCheck == null}">

											<g:radio name="publishCheck" id="yesPub" value="Yes"
												onclick="fileUpload(this)" />Yes <span> <g:radio
													name="publishCheck" id="noPub" value="No"
													onclick="fileUpload(this)" />No
											</span>

										</g:if> <g:elseif
											test="${periodicReportInstance?.publishCheck == 'Yes'}">
											<g:radio name="publishCheck" id="yesPub" value="Yes"
												checked="checked" onclick="fileUpload(this)" />Yes <span>
												<g:radio name="publishCheck" id="noPub" value="No"
													onclick="fileUpload(this)" />No
											</span>
										</g:elseif> <g:else>
											<g:radio name="publishCheck" id="yesPub" value="Yes"
												onclick="fileUpload(this)" />Yes <span> <g:radio
													name="publishCheck" id="noPub" value="No" checked="checked"
													onclick="fileUpload(this)" />No
											</span>
										</g:else> <g:if test="${periodicReportInstance?.fileName}">
											<g:link controller="applicant" action="showPublishPdf"
												target="_blank"
												params="${[publishId:periodicReportInstance?.id,csrfPreventionSalt:csrfPreventionSalt]}">
												${periodicReportInstance?.fileName }
											</g:link>
											<span> <g:link controller="applicant"
													action="deletePublishPdf"
													params="${[formId:formDetails?.id, publishId:periodicReportInstance?.id,csrfPreventionSalt:csrfPreventionSalt,act:'createReport1']}"
													onclick="return confirm('Are you sure to delete this file?');">
													<i class="fa fa-trash-o" style="color: red"></i>
												</g:link>
											</span>
										</g:if> <input type="file" id="uploadFile" name="publishFile"
										onchange="ValidateSingleInput(this);"><span
										id="errorMsg" style="color: red"></span> <%--	<g:textField name="haveYouPublished" style="width:50%" value="${periodicReportInstance?.haveYouPublished}" />--%>

									</td>
								</tr>

								<tr>
									<td>9</td>
									<td>Have you applied any patent in or outside India, if so provide the details of the same? </td>
									<td><g:if
											test="${periodicReportInstance?.haveAppliedCheck == '' || periodicReportInstance?.haveAppliedCheck == null }">
											<g:radio name="haveAppliedCheck" id="yesApp" value="Yes"
												onclick="displayTxt(this)" />Yes <span> <g:radio
													name="haveAppliedCheck" id="noApp" value="No"
													onclick="displayTxt(this)" />No
											</span>
										</g:if> <g:elseif
											test="${periodicReportInstance?.haveAppliedCheck == 'Yes' }">
											<g:radio name="haveAppliedCheck" id="yesApp"
												checked="checked" value="Yes" onclick="displayTxt(this)" />Yes <span>
												<g:radio name="haveAppliedCheck" id="noApp" value="No"
													onclick="displayTxt(this)" />No
											</span>
										</g:elseif> <g:else>
											<g:radio name="haveAppliedCheck" id="yesApp" value="Yes"
												onclick="displayTxt(this)" />Yes <span> <g:radio
													name="haveAppliedCheck" id="noApp" value="No"
													checked="checked" onclick="displayTxt(this)" />No
											</span>
										</g:else> <g:textField name="haveAppliedPatent"
											placeholder="Please provide the details" id="haveA"
											style="width:100%; display:none"
											value="${periodicReportInstance?.haveAppliedPatent}"/></td>
								</tr>
								<tr>
									<td>10</td>
									<td>Have you transferred the results of research to any third party, if so provide the details of the same ?</td>
									<td><g:if
											test="${periodicReportInstance?.haveTrsCheck == '' || null == periodicReportInstance?.haveTrsCheck }">
											<g:radio name="haveTrsCheck" id="yesTra" value="Yes"
												onclick="displayTrf(this)" />Yes <span> <g:radio
													name="haveTrsCheck" id="noTra" value="No"
													onclick="displayTrf(this)" />No
											</span>
										</g:if> <g:elseif
											test="${periodicReportInstance?.haveTrsCheck == 'Yes' }">
											<g:radio name="haveTrsCheck" id="yesTra" checked="checked"
												value="Yes" onclick="displayTrf(this)" />Yes <span> <g:radio
													name="haveTrsCheck" id="noTra" value="No"
													onclick="displayTrf(this)" />No
											</span>
										</g:elseif> <g:else>
											<g:radio name="haveTrsCheck" id="yesTra" value="Yes"
												onclick="displayTrf(this)" />Yes <span> <g:radio
													name="haveTrsCheck" id="noTra" value="No" checked="checked"
													onclick="displayTrf(this)" />No
											</span>
										</g:else> <g:textField name="haveTransferredResults"
											placeholder="Please provide the details" id="transf"
											style="width:100%; display:none"
											value="${periodicReportInstance?.haveTransferredResults}" />

									</td>
								</tr>
								<tr>
									<td>11</td>
									<td>Have you transferred the biological resources to any third party, if so provide the details of the same?  </td>
									<td><g:if
											test="${periodicReportInstance?.trnsBioCheck == ' ' || null == periodicReportInstance?.trnsBioCheck}">
											<g:radio name="trnsBioCheck" id="yesBo" value="Yes"
												onclick="displayBio(this)" />Yes <span> <g:radio
													name="trnsBioCheck" id="noBo" value="No"
													onclick="displayBio(this)" />No
											</span>
										</g:if> <g:elseif
											test="${periodicReportInstance?.trnsBioCheck == 'Yes'  }">
											<g:radio name="trnsBioCheck" id="yesBo" checked="checked"
												value="Yes" onclick="displayBio(this)" />Yes <span> <g:radio
													name="trnsBioCheck" id="noBo" value="No"
													onclick="displayBio(this)" />No
											</span>
										</g:elseif> <g:else>
											<g:radio name="trnsBioCheck" id="yesBo" value="Yes"
												onclick="displayBio(this)" />Yes <span> <g:radio
													name="trnsBioCheck" id="noBo" checked="checked" value="No"
													onclick="displayBio(this)" />No
											</span>
										</g:else> <g:textField name="haveTransferredBiological"
											placeholder="Please provide the details" id="transBio"
											style="width:100%; display:none"
											value="${periodicReportInstance?.haveTransferredBiological}" />
									</td>
								</tr>

								<tr>
									<td>12</td>
									<td>Details of deposition of vouchers specimen of accessed biological resources in the repository</td>
									<g:if test="${periodicReportInstance}">
										<td><g:each in="${periodicReportInstance?.periodicFiles}"
												var="file">
												<li>
													${file?.fileName}
												</li>
											</g:each></td>
									</g:if>
									<g:else>
										<td><table>
												<tr>
													<th><div class="input_fields_wrap">
															<input type="button" class="add_mor" id="chgName"
																Value="upload file" />
														</div></th>
												</tr>
												<tr>
													<td><span style="color: red" id="errorMsg"></span></td>
												</tr>

											</table></td>
									</g:else>
								</tr>
								<tr>
									<td colspan="3"><b>Declaration</b><br> <g:if
											test="${periodicReportInstance}">
											<input type="checkbox" name="declare" readonly="readonly"
												value="periodicCheck" onclick="return false;" id="myCheck"> I/we declare that the information provided in this status report is true and correct and I /We shall be responsible for any incorrect / wrong information.
<br>
										</g:if> <g:else>
											<input type="checkbox" name="declare" value="periodicCheck"
												onclick="checkPeriodicDecleration()" id="myCheck"> I/we declare that the information provided in this status report is true and correct and I /We shall be responsible for any incorrect / wrong information.
<br>
										</g:else> Date of Submission : <g:formatDate
											format="dd/MM/yyyy hh:mm  aa" date="${new Date()}" /> <br>
										Place : <g:textField name="place"
											value="${periodicReportInstance?.place}" /></td>
								</tr>
							</tbody>
						</table>
	<script type="text/javascript">
        $(document).ready(function () {
			
			//DatePicker Example
			$('#datetimepicker').datetimepicker({
                timepicker:true,
                closeOnDateSelect:false,
                closeOnTimeSelect: true,
                initTime: true,
                format: 'd-m-Y',
<%--                minDate: 0,--%>
                roundTime: 'ceil',
           
                                                      });
			 var startDate,endDate;
	 			
             $("#bio-startdate").datetimepicker({
            	 
                         timepicker:true,
                         closeOnDateSelect:false,
                         closeOnTimeSelect: true,
                         initTime: true,
                         format: 'd/m/Y H:i',
                         minDate: 0,
                         roundTime: 'ceil',
                         onChangeDateTime: function(dp,$input){
                                   startDate = $("#bio-startdate").val();
                                   var datearray = startDate.split("/");
                                   var newdate = datearray[1] + '/' + datearray[0] + '/' + datearray[2];
                                   var start_actual_time = new Date(newdate)
                                  
                                   var endarray = endDate.split("/");
                                   var enddate = endarray[1] + '/' + endarray[0] + '/' + endarray[2];
                                   var end_actual_time = new Date(enddate)
                                   
                                   if(start_actual_time>end_actual_time){
                                          alert('Please select correct start date');
                                          document.getElementById('bio-startdate').value = ''
                                    }
                                                               }
                                                               });
            $("#bio-enddate").datetimepicker({
                         timepicker:true,
                         closeOnDateSelect:false,
                         closeOnTimeSelect: true,
                         initTime: true,
                         format: 'd/m/Y H:i',
                         minDate:  0,
                         onClose: function(current_time, $input){
                                endDate = $("#bio-enddate").val();
                              

                               
                                var datearray = startDate.split("/");
                                var newdate = datearray[1] + '/' + datearray[0] + '/' + datearray[2];
                                var start_actual_time = new Date(newdate)
                               
                                var endarray = endDate.split("/");
                                var enddate = endarray[1] + '/' + endarray[0] + '/' + endarray[2];
                                var end_actual_time = new Date(enddate)
                                
                                if(start_actual_time>end_actual_time){
                                       alert('Please select correct end date');
                                       document.getElementById('bio-enddate').value = ''
                                 }
                 }
                  });
			
		});
		
		
        
    </script>
