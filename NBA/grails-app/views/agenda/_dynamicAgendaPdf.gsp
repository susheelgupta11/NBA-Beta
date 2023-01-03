  <%! import org.nba.application.FormCategory %>
  <%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE stylesheet [
<!ENTITY ndash  "&#x2013;" >
<!ENTITY mdash  "&#x2014;" >
]>


<html>

  <head>
    <meta charset="utf-8" />
    <title>Agenda </title>
    

<style type="text/css">
  table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
} 
</style>  

     

  </head>

  <body>
<div class="container">
  <div class="book">
    <div class="page">
        <div class="subpage">
  
      
      <div class="row">
        <div class="col-lg-8">
       <img src="https://absefiling.nic.in/NBA/assets/Logo1.jpg" width="100%"  alt="NBA" style="display: block; margin-bottom: 0.5em;" />
        
        </div>
        <div class="col-lg-4">
          <h2 style="text-align: center; color: gray">AGENDA</h2>
        </div>
      </div>
       <table>
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
                  From:${agendaInstance?.fromDate }  To:${agendaInstance?.toDate}
              </strong>
              </td>
            </tr>

            <tr>
              <td colspan="2">
              
               <table class="table table-bordered ">
            <tbody>
              <tr>
                <td rowspan="2" class="text-center">
                  <p style="font-size: 12px; font-weight: bold; color: red; margin-top:0.5em; width: 16px;">${agendaInstance?.dynamicMeetNum}</p>
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
                
                <td colspan="3"><b>Online application No. <span
                    style="color: red;">${agendaInstance?.appNumber}</span></b></td>
                <td colspan="2"><b>NBA Ref. no : <span
                    style="color: red;">${agendaInstance?.refNo}</span></b></td>
              </tr>
              <tr>
                <td><b>1.</b></td>
                
                <td colspan="2"><b>Name and Address of the
                    Applicant</b></td>
                <td colspan="2"><b>${agendaInstance?.name}<br/>
                     ${agendaInstance?.address}</b></td>
                
              </tr>
              <tr>
                <td rowspan="5"><b>2.</b></td>
                <td style="width: 1px;"><b>(a)</b></td>
                <td><b>Category of Application
                    Form </b></td>
                <td  colspan="2"><b>${agendaInstance?.formType}</b></td>
                
              </tr>
              <tr>
                <td style="width: 1px;"><b>(b)</b></td>
                <td><b>Whether the prescribed
                    application form has been used</b></td>
                <td style="color: red;"  colspan="2"><b>
                ${agendaInstance?.prescribedApplication}    
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
                
                ${agendaInstance?.individualOrEntity}
                
                                 </b></td>
                
              </tr>
              <tr>
                <td style="width: 1px;"><b>(e)</b></td>
                <td><b>Application Fee received</b></td>
                <td  colspan="2"><b>
                ${agendaInstance?.applicationFee}</b></td>
                
              </tr>
              
               <tr>
                <td ><b>3.</b></td>
                <td colspan="3">
              <b>Details of biological resources and associated knowledge used in research </b>   
             </td>
             </tr>
              
               <tr>
               
                <td colspan="4">
       <table style="width: 100%">
  <thead class="thead-light">
    <tr>
      <th scope="col">#</th>
     <th scope="col">Nature of Request</th>
	<th scope="col">Name of Species</th>
	<th scope="col">Common/ Scientific Name</th>
	<g:if test="${formDetails?.category?.category == FormCategory?.Category?.Form_1}">
			<th scope="col">Quantity</th>
	</g:if>
    </tr>
  </thead>
  <tbody>
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
  </tbody>
</table>
</td> </tr>
              
         <tr>
                <td><b>4.</b></td>
                <td colspan="3"><b>Geographical location for
                    access of the bioresource</b></td>
                </tr>

              <tr>
                <td colspan="4">
                  <table style="width: 100%">
                    <thead class="thead-light">
                      <tr>
                        <th scope="col">#</th>
                        <th  scope="col">Name of biological resource</th>
							<th scope="col">Source of access</th>
							<th scope="col">Source From/Name and Contact Details</th>
							</tr>
							</thead>
							<tbody>
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
                    </tbody>
                  </table>
                </td>
              </tr>
              
              
          <tr>
                <td rowspan="2"><b>5.</b></td>
                <td style="width: 1px;"><b>(a)</b></td>
                <td><b>Whether SBB/BMC Consulted
                </b></td>
                <td  colspan="2" style="color: red;"><b>
                ${agendaInstance?.sbbbmc}
                </b></td>
                
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
                
                <td colspan="2"><b>Proposed use of the
                    bioresource: </b></td>
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
                
                <td colspan="2"><b>Objective for seeking
                    NBA’s approval</b></td>
                <td  colspan="2" style="color: red;"><b>
                <g:if test="${formDetails?.approvalOfNba == true }">Yes</g:if>
                            <g:else>No</g:else></b></td>
                
              </tr>
              <tr>
                <td rowspan="2"><b>8.</b></td>
                <td style="width: 1px;"><b>(a)</b></td>
                <td><b>Time taken between receipt
                    of application and its placement before EC on ABS</b></td>
                <td  colspan="2" style="color: red;"><b>
                ${agendaInstance?.receiptTimeTaken}
                </b></td>
              
              </tr>
              <tr>
                <td style="width: 1px;"><b>(b)</b></td>
                <td><b>Reasons for inordinate
                    delay, if any</b></td>
                <td  colspan="2" style="color: red;"><b>
                            ${agendaInstance?.inordinateDelay}
                             </b></td>
                
              </tr>
              <tr>
                <td><b>9.</b></td>
                
                <td colspan="2"><b>Whether listed in NTC by
                    MoEFCC</b></td>
                <td  colspan="2" style="color: red;"><b> </b></td>
              </tr>
    
             <tr>
                <td colspan="4">
                  <table style="width: 100%">
                    <thead class="thead-light">
                      <tr>
                        <th scope="col">#</th>
                        <th scope="col">Sceintific Name</th>
                        <th scope="col">Status</th>
                      </tr>
                    </thead>
                    <tbody>
                     <g:if test="${rare}">
				<g:each in="${rare}" var="ntc" status="i">
				<tr>
					<td>${i+1}</td>
					<td>${ntc?.bio_resource}</td>
					<td>${ntc?.status}</td>
				</tr>
				</g:each>
				</g:if><g:else>
				<tr><td colspan="3">No bioresource data is matching</td>
				</tr>
				</g:else>
                    </tbody>
                  </table>
                </td>
              </tr>


              <tr>
                <td><b>10.</b></td>
                
                <td colspan="2" width="50%"><b>Whether this application
                    of the applicant had already been examined /considered by the
                    EC? </b></td>
                <td style="color: red;" width="50%"><b>
                ${agendaInstance?.alreadyExpEC}
                    </b></td>
                
              </tr>      
                   
            <tr>
                <td><b>11.</b></td>
                
                <td colspan="2"><b>If so, recommendation of
                    the EC or action taken</b></td>
                <td><b>
                ${agendaInstance?.actiontaken}
                </b></td>
                
              </tr>
              <tr>
                <td><b>12.</b></td>
                
                <td colspan="3"><b>Remarks by
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
                
                <td colspan="3"><b>Recommendation by NBA:</b></td>
              </tr>
              
              <tr>
              <td colspan="5">

          ${agendaInstance?.recommendationByNba}
              </td>
              </tr>
              </g:if>
               <tr>
                <td colspan="4"><b>Signature of.</b></td>
                
              </tr>
              <tr>
              <td colspan="5">
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
					</td>
					</tr>
				  
             
             
              </tbody>
              </table>
             
      </td>
      </tr>
      </table>  
     
      
      
      
      
      </div>
      </div>
      </div>
      </div>
      </body>
      </html>
     