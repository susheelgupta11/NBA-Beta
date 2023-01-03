<%! import org.nba.application.FormCategory %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="projectPreview" />
<title></title>
<script type="text/javascript">
	$(function() {
		window.print();
	});
</script>
<style>
table {
	font-size: 1.2em;
}
</style>
</head>
<body>
<g:if
				test="${formDetails?.individualProfiles}">
				<g:each in="${formDetails?.individualProfiles}"
					var="individualProfile">
<g:set var="name" value="${individualProfile?.title ?:''} ${individualProfile?.firstName ?:''} ${individualProfile?.middleName?: ''} ${individualProfile?.lastName ?:''}"/>				
<g:set value="${individualProfile?.address1 ?:''} ${individualProfile?.address2 ?:''} ${individualProfile?.address3 ?:''} ${individualProfile?.city ?:''}" var="address"/>				
               </g:each>
			</g:if> <g:elseif test="${formDetails?.companyProfiles}">
				<g:each status="k" in="${formDetails?.companyProfiles}"
					var="company">
				<g:set var="name" value="	${company?.entityName}"/>
				</g:each>
			</g:elseif> <g:elseif test="${formDetails?.indianResearcher}">
				<g:each in="${formDetails?.indianResearcher}" var="researcher">

			<g:set var="name" value="	${researcher?.title}
					${researcher?.firstName}
					${researcher?.middleName}
					${researcher?.lastName}"/>

      <g:set value="${researcher?.address1}
					${researcher?.address2}
					${researcher?.address3}
					${researcher?.presentCity}" var="address"/>			
	
				</g:each>
			</g:elseif> <g:elseif test="${formDetails?.depostionOfMicroOrganism}">
				<g:each in="${formDetails?.depostionOfMicroOrganism}" var="depost">
				<g:set var="name" value="	${depost?.nameOfDepositor}"/>
		<g:set value="${depost?.address1}
					${depost?.address2}
					${depost?.address3}
					${depost?.city}" var="address" />			
				</g:each>
			</g:elseif> <g:elseif test="${formDetails?.indianGovtInst}">
				<g:each in="${formDetails?.indianGovtInst}" var="govt">
				<g:set var="name" value="	${govt?.govtInstName}"/>
					
				<g:set value="${govt?.address1}
					${govt?.address2}
					${govt?.address3}
					${govt?.presentCity}" var="address"/>
				</g:each>
			</g:elseif>
			
			<g:hiddenField name="name" value="${name}"/>
			<g:hiddenField name="address" value="${address}"/>
			  <div class="col-sm-9">
			<img src="${resource(dir: 'images', file: 'Logo1.jpg')}" alt="logo"
				class="img-responsive pull-left" />
		</div>
			<table class="table table-bordered customtable main-account">
        		<tr>
        			<td><strong>Name of the Meeting :</strong></td>
        			<td><strong>
        			${agendaInstance?.meetingName}
	        			</strong></td>
        		</tr>
        		<tr>
        			<td><strong>No of the Meeting :</strong></td>
        			<td><strong>
        			${agendaInstance?.meetingNum}
	        			</strong></td>
        		</tr>
        		<tr>
        		
        			<td><strong>Date of the Meeting :</strong></td>
        			<td><strong>
	        			  From:${agendaInstance?.fromDate}
        			  
                       To:${agendaInstance?.toDate} 
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
									style="color: red; width: 100px; font-weight: 800; text-align: center;">
									${agendaInstance?.dynamicMeetNum} 
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
					<td colspan="5" class="text-center"><b><u>Part A: Filled by the NBA Secretariat</u></b></td>
							</tr>
							<tr>
								<td><b></b></td>
								<td style="width: 1px;"><b></b></td>
								<td><b>Online application No. <span
										style="color: red;">${formDetails?.appNumber}</span></b></td>
								<td colspan="2"><b>NBA Ref. no : <span
										style="color: red;">${agendaInstance?.refNo}</span></b></td>
							</tr>
							<tr>
								<td><b>1.</b></td>
								<td style="width: 1px;"><b></b></td>
								<td><b>Name & Address of the
										Applicant</b></td>
								<td colspan="2"><b>${name} ${address}</b></td>
								
							</tr>
							<tr>
								<td rowspan="5"><b>2.</b></td>
								<td style="width: 1px;"><b>(a)</b></td>
								<td><b>Category of Application
										Form </b></td>
								<td  colspan="2"><b>
                                   <g:if test="${formDetails?.category?.category == FormCategory?.Category?.Form_1}"> 
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
								<td style="color: red;"  colspan="2"><b>${agendaInstance?.prescribedApplication}</b></td>
								
							</tr>
							<tr>
								<td style="width: 1px;"><b>(c)</b></td>
								<td><b>Whether the application
										contains all the required information</b></td>
								<td colspan="2" style="color: red;"><b>${agendaInstance?.prescribedApplication}</b></td>
								
							</tr>
							<tr>
								<td style="width: 1px;"><b>(d)</b></td>
								<td><b>Whether the Applicant is a
										section 3(2) individual / entity </b></td>
								<td  colspan="2"><b>
								<g:if test="${formDetails?.individualProfiles}">
								Individual
								 </g:if>
								<g:elseif test="${formDetails?.companyProfiles }">
								Company
								</g:elseif>
                                 </b></td>
								
							</tr>
							<tr>
								<td style="width: 1px;"><b>(e)</b></td>
								<td><b>Application Fee received</b></td>
								<td  colspan="2"><b>
								${fee}</b></td>
								
							</tr>
							
							
							<tr>
							<td><b>3.</b></td>
							<td colspan="3"><b>Detail of biological resources and associated knowledge used in research</b>
							<table class="table table-bordered">
							<tr>
							<th>S.No.</th>
							<th>Nature of Request</th>
							<th>Name of Species</th>
							<th>Common/ Scientific Name</th>
							<g:if test="${formDetails?.category?.category == FormCategory?.Category?.Form_1}">
							<th>Quantity</th>
							</g:if>
							</tr>
							<g:if test="${formDetails?.biologicalResources}">
								<g:each in="${formDetails?.biologicalResources}" status="b" var="bioRes">
														<tr>
							<td>${b+1}</td>
							<td>${bioRes?.nature ?: 'NA'}</td>
							<td>${bioRes?.name ?: 'NA'}</td>
							<td>${bioRes?.commonName ?: 'NA'}/${bioRes?.scientificName ?: 'NA'}</td>
							<g:if test="${formDetails?.category?.category == FormCategory?.Category?.Form_1}">
							<td>${bioRes?.quantity?: 'NA'}-${bioRes?.qtyUnit?: 'NA'}</td>
							</g:if>
							
							</tr>
							</g:each>
							</g:if>
							</table></td>
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
								<td  colspan="2" style="color: red;"><b>${agendaInstance?.sbbbmc}</b></td>
								
							</tr>
							<tr>
								<td style="width: 1px;"><b>(b)</b></td>
								<td><b>Recommendations of
										SBB/BMC, if any</b></td>
								<td  colspan="2" style="color: red;"><b>
                                ${agendaInstance?.recommendationSbb}  
                              </b></td>
								
							</tr>
							<tr>
								<td><b>6.</b></td>
								<td style="width: 1px;"><b></b></td>
								<td><b>Proposed use of the
										bioresource: Research/Commercial/Bio-survey and
										Bio-utilization/Transfer of Research Results/IPR/Third Party
										Transfer</b></td>
								<td  colspan="2"><b>
								 <g:if test="${formDetails?.category?.category == FormCategory?.Category?.Form_1 }">
								 
								  	<g:textArea name="thirdpartyPurpose" value="${techChecklist?.assoKnowledgeRmk}"/>
								  </g:if>
								  
								  <g:elseif test="${formDetails?.category?.category == FormCategory?.Category?.Form_2}">
								  <g:textArea name="thirdpartyPurpose" value="Transfer of Research Results"/>
								  </g:elseif>
								  <g:elseif test="${formDetails?.category?.category == FormCategory?.Category?.Form_3}">
								  
								  <g:textArea name="thirdpartyPurpose" value="Intellectual Property Rights (IPR)"/>
								  </g:elseif>
								  <g:elseif test="${formDetails?.category?.category == FormCategory?.Category?.Form_4 }">
								  
								  <g:textArea name="thirdpartyPurpose" value="Third Party Transfer"/>
								  </g:elseif>
								</b></td>
								
							</tr>
							<tr>
								<td><b>7.</b></td>
								<td style="width: 1px;"><b></b></td>
								<td><b>Objective for seeking
										NBA’s approval</b></td>
								<td  colspan="2" style="color: red;"><b>
		 						<g:if test="${formDetails?.approvalOfNba == true }">Yes</g:if>
		                        <g:else>No</g:else></b></td>
								
							</tr>
							<tr>
								<td rowspan="2"><b>8.</b></td>
								<td style="width: 1px;"><b>(a)</b></td>
								<td><b>Time taken between receipt
										of application and its placement before EC on ABS:</b></td>
								<td  colspan="2" style="color: red;"><b>${agendaInstance?.receiptTimeTaken}</b></td>
							
							</tr>
							<tr>
								<td style="width: 1px;"><b>(b)</b></td>
								<td><b>Reasons for inordinate
										delay, if any</b></td>
								<td  colspan="2" style="color: red;"><b>${agendaInstance?.inordinateDelay}</b></td>
								
							</tr>
							<tr>
								<td><b>9.</b></td>
								<td style="width: 1px;"><b></b></td>
								<td><b>Whether listed in NTC by
										MoEFCC</b></td>
								<td  colspan="2" style="color: red;"><b>
								
								${agendaInstance?.whetherListNTC}
								
								
								
								</b></td>
								
							</tr>
							<tr>
								<td><b>10.</b></td>
								<td style="width: 1px;"><b></b></td>
								<td><b>Whether this application
										of the applicant had already been examined /considered by the
										EC? </b></td>
								<td  colspan="2" style="color: red;"><b>${agendaInstance?.alreadyExpEC}</b></td>
								
							</tr>
							<tr>
								<td><b>11.</b></td>
								<td style="width: 1px;"><b></b></td>
								<td style="width: 240px;"><b>If so, recommendation of
										the EC or action taken</b></td>
								<td  colspan="2"><b>${agendaInstance?.actiontaken}</b></td>
								
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
					${agendaInstance?.remarkByNba}
							</td>
							</tr>
							<g:if test="${agendaInstance?.recommendationByNba}">
							 <tr>
								<td><b>13.</b></td>
								<td style="width: 1px;"><b></b></td>
								<td colspan="2"><b>Recommendation by NBA: </b></td>
								
							</tr>
							<tr>
							<td colspan="5">

					${agendaInstance?.recommendationByNba}
							</td>
							</tr>
							
							</g:if>
						</tbody>
					</table>
					</td>
        		</tr>
	        	
			</table>
			
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
</body>
</html>