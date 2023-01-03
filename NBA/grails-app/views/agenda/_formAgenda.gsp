<%! import org.nba.application.FormCategory %>

<g:if test="${formDetails?.individualProfiles}">
				<g:each in="${formDetails?.individualProfiles}"
					var="individualProfile">
<g:set var="name" value="${individualProfile?.title ?:''} ${individualProfile?.firstName ?:''} ${individualProfile?.middleName?: ''} ${individualProfile?.lastName ?:''}"/>				
<g:set value="${individualProfile?.address1 ?:''} ${individualProfile?.address2 ?:''} ${individualProfile?.address3 ?:''} ${individualProfile?.city ?:''}" var="address"/>				
               </g:each>
			</g:if> <g:elseif test="${formDetails?.companyProfiles}">
				<g:each status="k" in="${formDetails?.companyProfiles}"
					var="company">
				<g:set var="name" value="	${company?.entityName?:''}"/>
				<g:set value="${company?.address1 ?:''} ${company?.address2 ?:''} ${company?.address3 ?:''} ${company?.city ?:''}" var="address"/>				
				
				</g:each>
			</g:elseif> <g:elseif test="${formDetails?.indianResearcher}">
				<g:each in="${formDetails?.indianResearcher}" var="researcher">

			<g:set var="name" value="	${researcher?.title?:''}
					${researcher?.firstName?:''}
					${researcher?.middleName?: ''}
					${researcher?.lastName?: ''}"/>

      <g:set value="${researcher?.address1?:''}
					${researcher?.address2?:''}
					${researcher?.address3?:''}
					${researcher?.presentCity?:''}" var="address"/>			
	
				</g:each>
			</g:elseif> <g:elseif test="${formDetails?.depostionOfMicroOrganism}">
				<g:each in="${formDetails?.depostionOfMicroOrganism}" var="depost">
				<g:set var="name" value="	${depost?.nameOfDepositor?:''}"/>
		<g:set value="${depost?.address1?:''}
					${depost?.address2?:''}
					${depost?.address3?:''}
					${depost?.city?:''}" var="address" />			
				</g:each>
			</g:elseif> <g:elseif test="${formDetails?.indianGovtInst}">
				<g:each in="${formDetails?.indianGovtInst}" var="govt">
				<g:set var="name" value="	${govt?.govtInstName?:''}"/>
					
				<g:set value="${govt?.address1?:''}
					${govt?.address2?:''}
					${govt?.address3?:''}
					${govt?.presentCity?:''}" var="address"/>
				</g:each>
			</g:elseif>
			
		    <g:hiddenField name="name" value="${name}"/>
			<g:hiddenField name="address" value="${address}"/>
			
			
	<g:if test="${agendaInstance?.recommendationByNba}">
	<g:javascript>
	$(document).ready(function () {
    document.getElementById('recNBA').style.display ='table-row';
    document.getElementById('recNBATxt').style.display ='table-row';
     });;
	</g:javascript>
	
	</g:if>		
	<table class="table table-bordered customtable main-account" style="margin-bottom:0 !important;">
        		<tr>
        			<td><strong>Name of the Meeting :</strong></td>
        			<td><strong>
        		<g:if test="${agendaInstance}">
        		${agendaInstance?.meetingName}
        		</g:if>
        		<g:else>
         <g:select name="meetingName"  from="${meetingName}" noSelection="['':'Choose a Meeting']" onchange="recomSts(this.value);" required="required"/>
        		</g:else>
	           </strong></td>
         </tr>	
         <tr>
        			<td><strong>No of the Meeting :</strong></td>
        			<td>
        			<strong>
        			<g:if test="${agendaInstance}">
        		${agendaInstance?.meetingNum}
        		</g:if>
        			<g:else>
        			
        			<input type="number" name="meetingNum" min="1" onchange="dynamicMeetingNumber(this.value)" value="${agendaInstance?.meetingNum}" required="required"/>
	        			
	        		</g:else>
	        			</strong>
	        			</td>
        		</tr>
        		<tr>
        		
        			<td><strong>Date of the Meeting :</strong></td>
        			<td>
        			<strong>
        				<g:if test="${agendaInstance}">
        		From: ${agendaInstance?.fromDate} To: ${agendaInstance?.toDate}
        		</g:if>
        			<g:else>
        			From: <input name="fromDate" type="text" placeholder="Start Date" autocomplete="off" value="${agendaInstance?.fromDate}"  id="startdate" required="required"> To: 
                          <input  name="toDate" type="text" autocomplete="off" placeholder="End Date" id="enddate" value="${agendaInstance?.toDate}" required="required">
        			
	        		</g:else>	
                 </strong>
	        		</td>
        		</tr>
         <tr>
        			<td colspan="2">
	        		<strong>Agenda Content :</strong>
                       <table class="table table-bordered customtable main-account">
						<tbody>
							<tr>
								<td rowspan="2" class="text-center"
									style="color: red; font-weight: 800; text-align: center;">
									<input type="text" name="dynamicMeetNum" value="${agendaInstance?.dynamicMeetNum}"  id="dyMeet" style="width:inherit">
									</td>
								<td colspan="4" class="text-center"><b>Expert
										Committee meeting on Access and Benefit Sharing for Processing
										of Applications </b></td>
								
							</tr>
							<tr>
								<td colspan="4" class="text-center"><b>Checklist for
										processing of Application in the NBA Secretariat</b></td>
							</tr>
							
							<tr>
							<td colspan="5" class="text-center" style="text-decoration:underline;"><b>Part A: Filled by the NBA Secretariat</b></td>
							</tr>
							<tr>
								<td style="width:20px !important;"><b></b></td>
								<td style="width: 1px;"><b></b></td>
								<td><b>Online application No. <span
										style="color: red;">${formDetails?.appNumber}</span></b></td>
								<td colspan="2"><b>NBA Ref. no : <span
										style="color: red;"><g:textField name="refNo" value="${techChecklist?.nbaRefNumber}"/></span></b></td>
							</tr>
							<tr>
								<td><b>1.</b></td>
								<td style="width: 1px;"><b></b></td>
								<td><b>Name &amp; Address of the
										Applicant</b></td>
								<td colspan="2"><b><g:textArea name="nameAndAddress" value="${name} ${address}" cols="30"></g:textArea></b></td>
								
							</tr>
							
							<tr>
								<td rowspan="5"><b>2.</b></td>
								<td style="width: 1px;"><b>(a)</b></td>
								<td><b>Category of Application
										Form </b></td>
		         	<td colspan="2"><b><g:if test="${formDetails?.category?.category == FormCategory?.Category?.Form_1}"> 
										<g:textField name="formType" value="Form I"/>
										<g:set value="10,000 /-" var="fee"/>
										</g:if>
									<g:elseif test="${formDetails?.category?.category == FormCategory?.Category?.Form_2}">
									<g:textField name="formType" value="Form II"/>
									<g:set value="5,000 /-" var="fee"/>
									</g:elseif>	
										
										<g:elseif test="${formDetails?.category?.category == FormCategory?.Category?.Form_3}">
									<g:textField name="formType" value="Form III"/>
									<g:set value="500 /-" var="fee"/>
									</g:elseif>
									<g:elseif test="${formDetails?.category?.category == FormCategory?.Category?.Form_4}">
									<g:textField name="formType" value="Form IV"/>
									<g:set value="10,000 /-" var="fee"/>
									</g:elseif>
									<g:elseif test="${formDetails?.category?.category == FormCategory?.Category?.Form_B}">
									<g:textField name="formType" value="Form B"/>
									</g:elseif>
									
										</b></td>
								
							</tr>
							<tr>
								<td style="width: 1px;"><b>(b)</b></td>
								<td><b>Whether the prescribed
										application form has been used</b></td>
								<td style="color: red;"  colspan="2"><b>
								<g:if test="${legalChecklist?.orderChk == 'true'}">
								<g:set value="Yes" var="pre"/>
								</g:if>
								<g:elseif test="${legalChecklist?.orderChk == 'needAditionalInfo'}">
								<g:set value="Need Additional Info" var="pre"/>
								</g:elseif>
								<g:else>
								<g:set value="No" var="pre"/>
								</g:else>
								<g:textField name="prescribedApplication" value="${pre}"/>		
										</b></td>
								
							</tr>
							<tr>
								<td style="width: 1px;"><b>(c)</b></td>
								<td><b>Whether the application
										contains all the required information</b></td>
										
									<g:if test="${techChecklist?.technicalInformation == true}">
									<g:set value="Yes" var="wherter"/>
									</g:if>	
										<g:else><g:set value="No" var="wherter"/></g:else>
										
								<td colspan="2" style="color: red;"><b>${wherter}</b></td>
								
							</tr>
							
							<tr>
								<td style="width: 1px;"><b>(d)</b></td>
								<td><b>Whether the Applicant is a
										section 3(2) individual / entity </b></td>
								<td  colspan="2"><b>
								<g:if test="${legalChecklist?.threeTwocheck == true }">
								<g:textField name="individualOrEntity" value="Yes"/>
								</g:if>
								<g:elseif test="${legalChecklist?.threeTwocheck == false }">
								<g:textField name="individualOrEntity" value="No"/>
								</g:elseif>
								<g:else>
								<g:textField name="individualOrEntity" value="NA"/>
								</g:else>
						
                                 </b></td>
								
							</tr>
							<tr>
								<td style="width: 1px;"><b>(e)</b></td>
								<td><b>Application Fee received</b></td>
								<td  colspan="2"><b>
						
								<g:textField name="applicationFee" value="${fee}"/></b></td>
								
							</tr>
							
     <%--       Bio resource tab             --%>
                     
                     	<tr>
							<td><b>3.</b></td>
							<td colspan="3"><b>Detail of biological resources and associated knowledge used in research</b>
							<table class="table table-bordered">
							<tr>
							<th>S.No.</th>
							<th width="20%">Nature of Request</th>
							<th width="20%">Common Name</th>
							<th width="20%">Scientific Name</th>
							<th width="40%">Part</th>
							
						<g:if test="${formDetails?.category?.category == FormCategory?.Category?.Form_1}">
							<th>Quantity</th>
						</g:if>
							</tr>
							<g:if test="${formDetails?.biologicalResources}">
								<g:each in="${formDetails?.biologicalResources}" status="b" var="bioRes">
					      <tr>
							<td>${b+1}</td>
							<td>${bioRes?.nature ?: 'NA'}</td>
							
							<td>${bioRes?.commonName ?: 'NA'}</td>
							<td>${bioRes?.scientificName ?: 'NA'}</td>
							<td>${bioRes?.biologicalResource?: 'NA'}</td>
							
							<g:if test="${formDetails?.category?.category == FormCategory?.Category?.Form_1}">
							<td>${bioRes?.quantity?: 'NA'}-${bioRes?.qtyUnit?: 'NA'}</td>
							</g:if>
							
						</tr>
							</g:each>
							</g:if>
							</table>
							</td>
							</tr>
							
							<tr>
							<td><b>4.</b></td>
							<td colspan="3"><b>Geographical location for access of the bio-resource</b>
							<table class="table table-bordered">
							<tr>
							<th>S.No.</th>
							<th width="30%">Name of biological resource</th>
							<th width="30%">Source of access</th>
							<th width="40%">Source From/Name & Contact Details</th>
							</tr>
						<g:if test="${formDetails?.biologicalResources?.locations}">
								<g:each in="${formDetails?.biologicalResources?.locations}" var="bioRes" status="p" >
							
								<g:each in="${bioRes}" var="gioloc"  status="o">
							
						<tr>
							<td >${p+o+1}</td>
							<td>${gioloc?.bioResource?.scientificName?:'NA'}</td>
							<td>${gioloc?.source?:'NA'}	</td>
							
							<g:if test="${gioloc?.source == 'Wild' || 'Cultivated' == gioloc?.source}">
							<td>${gioloc?.village ?: 'NA'}, ${gioloc?.town ?: 'NA'}, ${gioloc?.district ?: 'NA'}, ${gioloc?.state ?: 'NA'}</td>
							
							</g:if>
							<g:else>
							<td> ${gioloc?.traderName?:'NA'}<br/>${gioloc?.traderContactDetails?:'NA'} </td>
														
							</g:else>
							
						</tr>
							</g:each>
							</g:each>
							</g:if>
							</table></td>
							</tr>
							
							<tr>
								<td rowspan="2"><b>5.</b></td>
								<td style="width: 1px;"><b>(a)</b></td>
								<td><b>Whether SBB/BMC Consulted
								</b></td>
								<td  colspan="2" style="color: red;"><b>
								
								<g:if test="${techChecklist?.sbbBmc == true }">
								<g:set value="Yes" var="sbb"/>
								</g:if>
								<g:else>
								<g:set value="No" var="sbb"/>
								</g:else>
								<g:textField name="sbbbmc" value="${sbb}" style="width:100%"/>
								</b></td>
								
							</tr>
							<tr>
								<td style="width: 1px;"><b>(b)</b></td>
								<td><b>Recommendations of
										SBB/BMC, if any</b></td>
								<td  colspan="2" style="color: red;"><b>
                               <g:textArea name="recommendationSbb" value="${agendaInstance?.recommendationSbb}" style="width:100%"/>   
                              </b></td>
								
							</tr>
							
							<tr>
								<td><b>6.</b></td>
								<td style="width: 1px;"></td>
								<td><b>Proposed use of the
										bioresource: Research/Commercial/Bio-survey and
										Bio-utilization/Transfer of Research Results/IPR/Third Party
										Transfer</b></td>
								<td  colspan="2"> 
								  <g:if test="${formDetails?.category?.category == FormCategory?.Category?.Form_1 }">
								 
								  	<g:textArea name="thirdpartyPurpose" value="${techChecklist?.assoKnowledgeRmk}" style="width:100%"/>
								  </g:if>
								  
								  <g:elseif test="${formDetails?.category?.category == FormCategory?.Category?.Form_2}">
								  <g:textArea name="thirdpartyPurpose" value="Transfer of Research Results" style="width:100%" />
								  </g:elseif>
								  <g:elseif test="${formDetails?.category?.category == FormCategory?.Category?.Form_3}">
								  
								  <g:textArea name="thirdpartyPurpose" value="Intellectual Property Rights (IPR)"style="width:100%" />
								  </g:elseif>
								  <g:elseif test="${formDetails?.category?.category == FormCategory?.Category?.Form_4 }">
								  
								  <g:textArea name="thirdpartyPurpose" value="Third Party Transfer" style="width:100%" />
								  </g:elseif>
								  
<%--					        <g:textArea name="thirdpartyPurpose" value="${formDetails?.thirdPartyTransferPurpose ?: 'NA'}"/>--%>
								
								</td>
								
							</tr>
							<tr>
								<td><b>7.</b></td>
								<td style="width: 1px;"><b></b></td>
								<td><b>Objective for seeking
										NBA’s approval</b></td>
								<td  colspan="2"><b>
								<g:textField name="approvalNBA" style="width:100%" value="${agendaInstance?.approvalNBA }"/>
		 						</b></td>
								
							</tr>
							<tr>
								<td rowspan="2"><b>8.</b></td>
								<td style="width: 1px;"><b>(a)</b></td>
								<td><b>Time taken between receipt
										of application and its placement before EC on ABS:</b></td>
								<td  colspan="2" style="color: red;"><b>
								<g:textField name="receiptTimeTaken" style="width:100%" value="${agendaInstance?.receiptTimeTaken}"/>
								</b></td>
							
							</tr>
							<tr>
								<td style="width: 1px;"><b>(b)</b></td>
								<td><b>Reasons for inordinate
										delay, if any</b></td>
								<td  colspan="2" style="color: red;"><b>
                             <g:textField name="inordinateDelay" style="width:100%" value="${agendaInstance?.inordinateDelay}"/>
                             </b></td>
								
							</tr>
							
									
							<tr>
								<td><b>9.</b></td>
								<td style="width: 1px;"><b></b></td>
								<td><b>Whether listed in NTC by
										MoEFCC</b></td>
								<td  colspan="2" style="color: red;">
								
<%--   <g:textField name="whetherListNTC" style="width:100%" value="${agendaInstance?.whetherListNTC}"/>--%>
                           </td>
							</tr>
							<tr>
							<td></td>
							<td colspan="4">
							<table class="table table-bordered">
				<tr>
					<td><b>S. no</b></td>
					<td><b>Scientific name</b></td>
					<td><b>Status</b></td>
				</tr>
				<g:if test="${rare}">
				<g:each in="${rare}" var="ntc" status="i">
				<tr>
					<td>${i+1}</td>
					<td>${ntc?.bio_resource }</td>
					<td>${ntc?.status}</td>
				</tr>
				</g:each>
				</g:if><g:else>
				<tr><td colspan="3">No bioresource data is matching</td>
				</tr>
				</g:else>
			</table>
							
						</td>	
							</tr>
							
					<tr>
								<td><b>10.</b></td>
								<td style="width: 1px;"><b></b></td>
								<td><b>Whether this application
										of the applicant had already been examined /considered by the
										EC? </b></td>
								<td  colspan="2" style="color: red;"><b>
								<g:textField name="alreadyExpEC" style="width:100%" value="${agendaInstance?.alreadyExpEC}"/>
										</b></td>
								
							</tr>
							<tr>
								<td><b>11.</b></td>
								<td style="width: 1px;"><b></b></td>
								<td style="width: 240px;"><b>If so, recommendation of
										the EC or action taken</b></td>
								<td  colspan="2"><b>
								<g:textField name="actiontaken" style="width:100%" value="${agendaInstance?.actiontaken}"/>
								</b></td>
								
							</tr>
							<tr>
								<td><b>12.</b></td>
								<td style="width: 1px;"><b></b></td>
								<td colspan="2"><b>Remarks by
										NBA: 
								</b></td>
								
							</tr>
							<tr>
							<td colspan="5">

					<textarea name="remarkByNba" style="width:100%">${agendaInstance?.remarkByNba}</textarea>
							</td>
							</tr>
						
					<tr id="recNBA" style="display: none">
								<td><b>13.</b></td>
							<td style="width: 1px;"><b>:</b></td>
								<td colspan="2"><b>Recommendation by
										NBA: 
								</b></td>
								
							</tr>
							<tr  id="recNBATxt" style="display: none">
							<td colspan="5">

					<textarea name="recommendationByNba"  style="width:100%">${agendaInstance?.recommendationByNba}</textarea>
							</td>
							</tr>		
							
							
							
							
							</tbody>
							</table>
							</td>
							</tr>
						 <g:if test="${agendaInstance?.signature}" >
					<table class="table table-bordered customtable main-account">
						<tbody>
							<tr>
								<td colspan="4"><b>Signatures of:</b></td>
							</tr>
							<g:each in="${agendaInstance?.signature}" var="sign" >
							<tr>
								<td><b>${sign?.agendaActionBy} -${sign?.agendaAction}<br/> <span
										style="color: red;">${sign?.agendaActionRole }</span></b></td>
								<td><g:formatDate format="dd/MM/yyyy hh:mm aa" date="${sign?.agendaActionDate}"/></td>
							</tr>
							</g:each>
						</tbody>
					</table>
					</g:if>
				
	        	<tr>
	        
	        	<g:if test="${agendaInstance}">
	        		<td colspan="2"><g:link controller="agenda" class="btn btn-success" action="printableAgenda" target="_blank" style="margin: 10px;"
	        		 params="${[printId:agendaInstance?.id,formId:formDetails?.id, csrfPreventionSalt:csrfPreventionSalt]}">Print</g:link></td>
	        	</g:if>
	        	
	        	</tr>
         	
         </table>
			
			
	
	     <script type="text/javascript">

        $(document).ready(function () {
			var startDate,endDate;
			
         $("#startdate").datetimepicker({
        	 
                     timepicker:true,
                     closeOnDateSelect:false,
                     closeOnTimeSelect: true,
                     initTime: true,
                     format: 'd/m/Y',
                     minDate: 0,
                     roundTime: 'ceil',
                     onChangeDateTime: function(dp,$input){
                               startDate = $("#startdate").val();
                               var datearray = startDate.split("/");
                               var newdate = datearray[1] + '/' + datearray[0] + '/' + datearray[2];
                               var start_actual_time = new Date(newdate)
                              
                               var endarray = endDate.split("/");
                               var enddate = endarray[1] + '/' + endarray[0] + '/' + endarray[2];
                               var end_actual_time = new Date(enddate)
                               
                               if(start_actual_time>end_actual_time){
                                      alert('Please select correct start date');
                                      document.getElementById('startdate').value = ''
                                }
                                                           }
                                                           });
        $("#enddate").datetimepicker({
                     timepicker:true,
                     closeOnDateSelect:false,
                     closeOnTimeSelect: true,
                     initTime: true,
                     format: 'd/m/Y',
                     minDate:  0,
                     onClose: function(current_time, $input){
                            endDate = $("#enddate").val();
                          

                           
                            var datearray = startDate.split("/");
                            var newdate = datearray[1] + '/' + datearray[0] + '/' + datearray[2];
                            var start_actual_time = new Date(newdate)
                           
                            var endarray = endDate.split("/");
                            var enddate = endarray[1] + '/' + endarray[0] + '/' + endarray[2];
                            var end_actual_time = new Date(enddate)
                            
                            if(start_actual_time>end_actual_time){
                                   alert('Please select correct end date');
                                   document.getElementById('enddate').value = ''
                             }
             }
              });

		});



        function recomSts(m) {

            var hedr = document.getElementById('recNBA');
            var txtH = document.getElementById('recNBATxt');

            if(m == "NBA Secretariat"){
            hedr.style.display ='table-row';
            txtH.style.display ='table-row';
             }else{
             hedr.style.display ='none';
             txtH.style.display ='none';
            }
       }
       	    
    </script>   		
			
			
			