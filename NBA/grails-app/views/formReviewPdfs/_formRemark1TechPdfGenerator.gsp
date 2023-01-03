<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE entities [
   <!ENTITY hyphen "&#x02010;">
   <!ENTITY copy "&#x000A9;">
   <!ENTITY nbsp "&#x000A0;">
   <!ENTITY ndash "&#x02013;">
   <!ENTITY auml "&#x000E4;">
   <!ENTITY uuml "&#x000FC;">
   <!ENTITY deg "&#x000B0;">
   <!ENTITY Delta "&#x00394;">
   <!ENTITY minus "&#x02212;">
   <!ENTITY ensp "&#x02002;">
   <!ENTITY szlig "&#223;">
   <!ENTITY rsquo   "&#8217;">
   <!ENTITY mdash  "&#x2014;" >
    <!ENTITY micro "&#181;">
    <!ENTITY mu    "&#956;">
    <!ENTITY bull "&#8226;">
]>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="main" />
<title>Technical Checklist</title>

<style type="text/css">
.remark{color:blue}

table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>

</head>
<body>
<a href="#" target="_blank">
        <img src="https://absefiling.nic.in/NBA/assets/Logo1-9de1c2fa396fb0e8af1ba72ffc12b3dc.jpg" width="700px"  alt="NBA" border="0" style="display: block;" /></a>

<div align="center">
<h2>
			Form I
		</h2>
</div>
<div align="center"> <span class="text-center">(See Rule 14 of Biological
								Diversity Rules, 2004)<br /> Application form for access to the
								Biological Resources and associated traditional knowledge
			</span> </div>
			
			<div style="margin-top: 20px">
 Submitted On: ${formDetails?.submittedOn} <span style="padding: 20px;"><b>Checklist Type : Technical</b></span>
 <span> Application Number:	${formDetails?.appNumber}</span>
 
</div>
<hr />			
<table style="margin-top: 25px">
		<tbody>
			<tr class="header">
				<th>S.No</th>
				<th>Title</th>
				<th></th>
				<th>Details</th>
				<th>Remarks</th>
				
			</tr>
			<tr>
				<td><b>1</b></td>
				<td><b>Online Application
						number</b></td>
				<td class="text-center" style="width: 1px;"><b>:</b></td>
				<td class="colspan">
					${formDetails?.appNumber}
				</td>
				
				<td class="remark">
					${formRemkInstance?.onlineAppNumberRmk}
				</td>
			</tr>
			<tr>
				<td><b>2</b></td>
				<td><b>NBA Reference number</b></td>
				<td class="text-center" style="width: 1px;"><b>:</b></td>
				<td class="colspan">
					${formRemkInstance?.nbaRefNumber}
				</td>
				
				<td class="remark">
					${formRemkInstance?.nbaRefNumberRemark}
				</td>
			</tr>
			<tr>
				<td><b>3</b></td>
				<td><b>Applicant category</b></td>
				<td class="text-center" style="width: 1px;"><b>:</b></td>
				<td class="colspan"><g:if
						test="${formDetails?.individualProfiles}">Individual</g:if> <g:elseif
						test="${formDetails?.companyProfiles}">Entity</g:elseif> <g:elseif
						test="${formDetails?.indianGovtInst}">Government</g:elseif> <g:elseif
						test="${formDetails?.depostionOfMicroOrganism}">Micro</g:elseif></td>
				
				<td class="remark">
					${formRemkInstance?.applicantCatgRmk}
				</td>
			</tr>
			<tr>
				<td><b>4</b></td>
				<td><b>Name of the applicant
						and contact details</b></td>
				<td class="text-center" style="width: 1px;"><b>:</b></td>
				<td class="colspan"><g:if
						test="${formDetails?.individualProfiles}">
						<g:each in="${formDetails?.individualProfiles}"
							var="individualProfile">

							${individualProfile?.title}
							${individualProfile?.firstName}
							${individualProfile?.middleName}
							${individualProfile?.lastName}<br/>
							${individualProfile?.address1}
							${individualProfile?.address2}
							${individualProfile?.address3}
							${individualProfile?.city}
						</g:each>
					</g:if> <g:elseif test="${formDetails?.companyProfiles}">
						<g:each status="k" in="${formDetails?.companyProfiles}"
							var="company">
							${company?.entityName}
						</g:each>
					</g:elseif> <g:elseif test="${formDetails?.indianResearcher}">
						<g:each in="${formDetails?.indianResearcher}" var="researcher">

							${researcher?.title}
							${researcher?.firstName}
							${researcher?.middleName}
							${researcher?.lastName}<br/>
							${researcher?.address1}
							${researcher?.address2}
							${researcher?.address3}
							${researcher?.presentCity}
						</g:each>
					</g:elseif> <g:elseif test="${formDetails?.depostionOfMicroOrganism}">
						<g:each in="${formDetails?.depostionOfMicroOrganism}" var="depost">
							${depost?.nameOfDepositor}<br/>
							${depost?.address1}
							${depost?.address2}
							${depost?.address3}
							${depost?.city}
						</g:each>
					</g:elseif> <g:elseif test="${formDetails?.indianGovtInst}">
						<g:each in="${formDetails?.indianGovtInst}" var="govt">
							${govt?.govtInstName}<br/>
							${govt?.address1}
							${govt?.address2}
							${govt?.address3}
							${govt?.presentCity}
						</g:each>
					</g:elseif></td>
				
				<td class="remark">
					${formRemkInstance?.applicantNameContRmk}
				</td>
			</tr>
				<tr>
				<td><b>5</b></td>
				<td><b>Name and Address of
						the contact person/ authorized person of the company</b></td>
				<td class="text-center" style="width: 1px;"><b>:</b></td>
				<td class="colspan">
					<g:if test="${formDetails?.companyProfiles}">
		
	<g:each in="${formDetails?.companyProfiles}" var="comp">
		        ${comp?.title}
				${comp?.firstName}
				${comp?.middleName}
				${comp?.lastName} <br/>
		Designation:${comp?.designation} 
		Mobile:${comp?.personMobile} 
	    Email:${comp?.personEmail}
		</g:each></g:if>
	    <g:else>No</g:else>
				</td>
				
				<td class="remark">
					${formRemkInstance?.authPersonContRmk}
				</td>
			</tr>
	<tr>
				<td><b>6</b></td>
				<td><b>Name and address of
						the contact person/ agent/ attorney, in India</b></td>
				<td class="text-center" style="width: 1px;"><b>:</b></td>
				<td class="colspan">${formDetails?.agentProfile?.title} ${formDetails?.agentProfile?.firstName}
					${formDetails?.agentProfile?.middleName} ${formDetails?.agentProfile?.lastName}<br/>
					${formDetails?.agentProfile?.address1} ${formDetails?.agentProfile?.address2}
					${formDetails?.agentProfile?.address3} ${formDetails?.agentProfile?.city}</td>
				
				<td class="remark">
					${formRemkInstance?.attorneyInIndiaContRmk}
				</td>
			</tr>
			<tr>
				<td><b>7</b></td>
				<td><b>Category of
						Application Form</b></td>
				<td class="text-center" style="width: 1px;"><b>:</b></td>
				<td class="colspan">
					Form I
				</td>
				
				<td class="remark">
					${formRemkInstance?.appFormCatgRmk}
				</td>
			</tr>		
		<tr>
				<td><b>8</b></td>
				<td><b>Whether Address Proof
						and ID proof matching with the details mentioned above </b></td>
				<td class="text-center" style="width: 1px;"><b>:</b></td>
				<g:if test="${formRemkInstance?.idAndAddress == true}">
					<td class="colspan">Yes</td>
				</g:if>
				<g:elseif test="${formRemkInstance?.idAndAddress == false}">
					<td class="colspan">No</td>

				</g:elseif>
				<g:elseif
					test="${formRemkInstance?.idAndAddress == '' || formRemkInstance?.idAndAddress == null }">
					<td class="colspan">NA</td>
				</g:elseif>
				
				<td class="remark">
					${formRemkInstance?.idAndAddressRemark}
				</td>
			</tr>
			<tr>
				<td><b>9</b></td>
				<td colspan="5"><b>Details of biological resources and/ or
						associated knowledge proposed for access</b></td>
			</tr>	
			<tr>
				<td colspan="5"><table border="1">
						<tbody>
							<tr>
								<td><b>S. no</b></td>
								<td><b>Intend to access</b></td>
								<td><b>Common name</b></td>
								<td><b>Scientific name</b></td>
								<td><b>Nature of biological resources</b></td>
								<td><b>Part of biological resources</b></td>
								<td><b>Quantity of biological resources</b></td>
								<td><b>Time span in which the biological resource to be
										accessed</b></td>
								<td><b>Remarks</b></td>
							</tr>

				
				<g:if test="${formRemkInstance?.checklistBioresorces}">
				<g:each in="${formRemkInstance?.checklistBioresorces}" var="bioRemarks" status="j">
				<tr>
				<td>${j+1}</td>
				<td>${bioRemarks?.chkname}</td>
				<td>${bioRemarks?.chkcommonName}</td>
				<td>${bioRemarks?.chkscientificName}</td>
				<td>${bioRemarks?.chknature}</td>
				<td>${bioRemarks?.chkbiologicalResource}</td>
				<td>${bioRemarks?.chkQuantity}</td>
				<td>${bioRemarks?.chkFromtime}to ${bioRemarks?.chkTotime}</td>
				<td class="remark">${bioRemarks?.bioRemarks}</td>				
				</tr>
				</g:each>
				</g:if>
				
				<g:elseif test="${formDetails?.biologicalResources}">
					
						<g:each in="${formDetails?.biologicalResources}" var="resource"
							status="i">
							<tr>
							<td>
								${i+1}
							</td>
													<td>
							<g:hiddenField name="chkname" value="${resource?.name?:'NA'}" />
							${resource?.name?:'NA'}	
							</td>
							<td>
							<g:hiddenField name="chkcommonName" value="${resource?.commonName?:'NA'}"/>
								${resource?.commonName?:'NA'}
							</td>
							<td>
							<g:hiddenField name="chkscientificName" value="${resource?.scientificName?:'NA'}" />
								${resource?.scientificName?:'NA'}
							</td>
							<td>
							<g:hiddenField name="chknature" value="${resource?.nature?:'NA'}"/>
								${resource?.nature?:'NA'}
							</td>
							<td>
							<g:hiddenField  name="chkbiologicalResource" value="${resource?.biologicalResource?:'NA'}"/>
							${resource?.biologicalResource?:'NA'}	
							</td>
							<td>
							<g:hiddenField  name="chkQuantity" value="${resource?.quantity+ '-'+resource?.qtyUnit}"/>
								${resource?.quantity +'-'+resource?.qtyUnit}
							</td>
							<td>
								<g:formatDate format="dd/MM/yyyy" date="${resource?.fromTime}"/>
								<g:hiddenField name="chkFromtime" value="${resource?.fromTime}"/>
								                           to
								<g:formatDate format="dd/MM/yyyy" date="${resource?.toTime}"/>
								<g:hiddenField name="chkTotime" value="${resource?.toTime}"/>
							</td>
							<td>${formRemkInstance?.biologicalResRmk}</td>
							</tr>
						</g:each>
					
				</g:elseif>

						</tbody>
					</table></td>
			</tr>
	
	<tr>
				<td><b>10</b></td>
				<td colspan="5"><b>Geographical location of the biological
						resources to be accessed</b></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="5"><table border="1">
						<tbody>
							<tr>
					<td><b>S. no</b></td>
					<td><b>Name of biological resource</b></td>
					<td><b>Source of access</b></td>
					<td><b>Village / Panchayat</b></td>
					<td><b>Town / Taluk</b></td>
					<td><b>Distict</b></td>
					<td><b>State</b></td>
					<td><b>Trader Name</b></td>
					<td><b>Contact Details</b></td>
					<td><b>Remarks</b></td>
							</tr>


							<g:if test="${formRemkInstance?.checklistLocations}">
				<g:each in="${formRemkInstance?.checklistLocations}" var="location" status="k">
				<tr>
				<td>${k+1}</td>
				<td>${location?.locscientificName}</td>
				<td>${location?.locsource}</td>
				<td>${location?.locvillage}</td>
				<td>${location?.loctown}</td>
				<td>${location?.locdistrict}</td>
				<td>${location?.locstate}</td>
				<td>${location?.loctraderName}</td>
				<td>${location?.loctraderContactDetails}</td>
				<td class="remark">${location?.locationRemark}</td>
				</tr>	
				</g:each>
				</g:if>

				<g:elseif test="${formDetails?.biologicalResources?.locations}">
					
						<g:each in="${formDetails?.biologicalResources?.locations}"
							var="giolocation" status="i">
							<g:each in="${giolocation}" var="gioloc" status="j">
							<tr>
								<td>${i+1}</td>
							<td>
								<g:hiddenField name="locscientificName" value="${gioloc?.bioResource?.scientificName?:'NA'}"/>
									${gioloc?.bioResource?.scientificName?:'NA'}
								</td>
								<td>
								<g:hiddenField name="locsource" value="${gioloc?.source?:'NA'}" />
									${gioloc?.source?:'NA'}
								</td>
								<td>
								<g:hiddenField name="locvillage" value="${gioloc?.village?:'NA'}"/>
								${gioloc?.village?:'NA'}
								</td>
								<td>
								<g:hiddenField name="loctown" value="${gioloc?.town?:'NA'}"/>
								${gioloc?.town?:'NA'}</td>
								
								<td>
								<g:hiddenField name="locdistrict" value="${gioloc?.district?:'NA'}"/>
								${gioloc?.district?:'NA'}</td>
								
								<td>
								<g:hiddenField name="locstate" value="${gioloc?.state?:'NA'}"/>
								${gioloc?.state?:'NA'}</td>
								<td>
								<g:hiddenField name="loctraderName" value="${gioloc?.traderName}"/>
								${gioloc?.traderName?:'NA'}
								</td>
								<td>
								<g:hiddenField name="loctraderContactDetails" value="${gioloc?.traderContactDetails?:'NA'}"/>
								${gioloc?.traderContactDetails?:'NA'}
								</td>
								
								<td>
							
								<g:textField name="locRmk" class="remark" value="${formRemkInstance?.locationRmk}"/>
                                  
								</td>
								
							</tr>
							</g:each>
						</g:each>
					
				</g:elseif>
						</tbody>
					</table></td>
			</tr>		
			
			<tr>
				<td><b>11</b></td>
				<td><b>Description/nature of
						traditional knowledge (oral/documented)</b></td>
				<td class="text-center" style="width: 1px;"><b>:</b></td>
				<td class="colspan">
			${formDetails?.nature}
		<g:if test="${formDetails?.nature != 'No'}">
		<b>Details:</b><br/>
		${formDetails?.traditionalKnowledgeDesc}
		</g:if>
		</td>
				
				<td class="remark">
					${formRemkInstance?.oralRemark}
				</td>
			</tr>
			<tr>
				<td><b>12</b></td>
				<td><b>Geographical location
						of the community/individual</b></td>
				<td class="text-center" style="width: 1px;"><b>:</b></td>
				<td class="colspan">
				<g:if test="${formDetails?.locations}">
				
				<g:each in="${formDetails?.locations}" var="location">
<%--	${location?.communityKnowledge}     --%>
					${location?.village}
					${location?.town}
					${location?.district}
				</g:each>
			</g:if>
			<g:else>
			No
			</g:else></td>
				
				<td class="remark">
					${formRemkInstance?.giolocCommunityRmk}
				</td>
			</tr>
	<tr>
				<td><b>13</b></td>
				<td colspan="3"><b>Name and number of the persons authorized by the
						applicant for making selection</b>
						<g:if test= "${formDetails?.selfAuthorizedPerson}">
				--<i>Self</i>
				</g:if>
				<g:elseif test= "${!formDetails?.selfAuthorizedPerson }">
				<table class="table table-bordered">
				<tr>
					<td><b>S. no</b></td>
					<td><b>Name</b></td>
					<td><b>Address</b></td>
					<td><b>Mobile</b></td>
					<td><b>Email</b></td>
					<td><b>Remarks</b></td>
				</tr>
				
		<g:if test="${formRemkInstance?.checklistContacts}">
		<g:each in="${formRemkInstance?.checklistContacts}" var="cont" status="l">
		<tr>
		<td>${l+1 }</td>
		<td>${cont?.contName}</td>
		<td>${cont?.contAdd}</td>
		<td>${cont?.contMobile}</td>
		<td>${cont?.contEmail}</td>
		<td>${cont?.contRemk}</td>
		</tr>
		</g:each>
		</g:if>		
				<g:else test="${formDetails?.contactPersons}">
					<g:each in="${formDetails?.contactPersons}" var="contPerson"
						status="x">
					<tr>

						<td>
							${x+1 }
						</td>
						<td>
							${contPerson?.nameOfContactPerson}
							<g:hiddenField name="contName" value="${contPerson?.nameOfContactPerson}"/>
						</td>
						<td>
							${contPerson?.addressOfContactPerson}
							<g:hiddenField name="contAdd" value="${contPerson?.addressOfContactPerson}"/>
						</td>
						<td>
							${contPerson?.mobileOfContactPerson}
							<g:hiddenField name="contMobile" value="${contPerson?.mobileOfContactPerson}"/>
						</td>
						<td>
							${contPerson?.emailOfContactPerson}
							<g:hiddenField name="contEmail" value="${contPerson?.emailOfContactPerson}"/>
						</td>
						<td> 
						
						<g:textField  class="remark" name="personsAuth"
								value="${formRemkInstance?.nameAuthByApplicantRmk}" />
								
								</td>
					</tr>
						</g:each>
				</g:else>

			</table>
				</g:elseif>
						
						
						
						
						
						
						</td>
			</tr>
			
			<tr>
				<td><b>14</b></td>
				<td><b>Proposed use of
						biological resources and/or associated knowledge</b></td>
				<td class="text-center" style="width: 1px;"><b>:</b></td>
				<td class="colspan">${formDetails?.purposeOfProposal}</td>
				
				<td class="remark">
					${formRemkInstance?.assoKnowledgeRmk}
				</td>
			</tr>
			<tr>
				<td><b>15</b></td>
				<td ><b>Objective for seeking
						NBA's approval</b></td>
				<td class="text-center" style="width: 1px;"><b>:</b></td>
				<td>
				${formDetails?.briefDescription}
				
<%--				<g:if test="${formDetails?.approvalOfNba == true }">Yes</g:if><g:else>No</g:else>--%>
		
		
		</td>
				
				<td class="remark" colspan="2">
					${formRemkInstance?.nbaApprovalRmk}
				</td>
			</tr>
			
			<tr>
				<td><b>16</b></td>
				<td colspan="5"><b>Whether listed in
						NTC/Rare/Endemic/Endangered/Threatned, Wildlife
						Act/CITIES/BDA/ITPGRFA</b></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="5"><table border="1">
						<tbody>
							<tr>
								<td><b>S. no</b></td>
								<td><b>Scientific name</b></td>
								<td><b>Status</b></td>
								<td><b>Part</b></td>
								<td colspan="2"><b>Remarks</b></td>
							</tr>
							<g:if test="${rare}">
				<g:each in="${rare}" var="ntc" status="i">
				<tr>
					<td>${i+1}</td>
					<td>${ntc?.bio_resource }</td>
					<td>${ntc?.status}</td>
					<td>${ntc?.part}</td>
					<td><g:textField name="ntc" class="remark" value="${formRemkInstance?.listedInRmk}"/></td>
				</tr>
				</g:each>
				</g:if><g:else>
				<tr><td colspan="4">No bioresource data is matching</td></tr>
				</g:else>
						</tbody>
					</table></td>
			</tr>
			<tr>
				<td><b>17</b></td>
				<td><b>Details of any
						national institution which will participate in the Research &amp;
						Development activities</b></td>
				<td class="text-center" style="width: 1px;"><b>:</b></td>
				<td class="colspan">
				<g:if test="${formDetails?.instituteParticipation == true}">
                    ${formetails?.detailsOfInstitute}
		            	</g:if>
			     <g:else>No</g:else></td>
				
				<td class="remark">
					${formRemkInstance?.dtsOfNationalInstRmk}
				</td>
			</tr>
			<tr>
				<td><b>18</b></td>
				<td style="width: 25%!important"><b>Where the research
						activities will be carried out</b></td>
				<td class="text-center" style="width: 1px;"><b>:</b></td>
				<td>
				<g:if test= "${formDetails?.instituteParticipation == 'true'}"> Yes <br/>
				${formDetails?.detailsOfInstitute}<br/>${formDetails?.letterOfIntentName}
			</g:if>
			<g:else>
				No
			</g:else>	
				
				
				</td>
				
				<td class="remark">
					${formRemkInstance?.researchActivitiesRmk}
				</td>
			</tr>
			<tr></tr>

			<tr>
				<td><b>19</b></td>
				<td><b>Proposed mechanism and
						arrangement for benefit sharing</b></td>
				<td class="text-center" style="width: 1px;"><b>:</b></td>

				<g:if test="${formRemkInstance?.benefitSharing == true}">
					<td class="colspan">Yes</td>
				</g:if>
				<g:elseif test="${formRemkInstance?.benefitSharing == false}">
					<td class="colspan">No</td>

				</g:elseif>
				<g:elseif
					test="${formRemkInstance?.benefitSharing == '' || formRemkInstance?.benefitSharing == null }">
					<td class="colspan">NA</td>
				</g:elseif>
				
				<td class="remark">
					${formRemkInstance?.benefitSharingRmk}
				</td>
			</tr>
			<tr>
				<td><b>20</b></td>
				<td><b>Whether the
						application contains all required technical information</b></td>
				<td class="text-center" style="width: 1px;"><b>:</b></td>
		<g:if test="${formRemkInstance?.technicalInformation == '' || formRemkInstance?.technicalInformation == null }">
	<td class="colspan">NA</td>
		
	</g:if>
	<g:elseif test="${formRemkInstance?.technicalInformation == true}">
	<td class="colspan">Yes</td>
	</g:elseif>
	<g:elseif test="${formRemkInstance?.technicalInformation == false}">
	<td class="colspan">No</td>
	</g:elseif>
				
				<td class="remark">
					${formRemkInstance?.technicalInformationRmk}
				</td>
			</tr>
			<tr>
				<td><b>21</b></td>
				<td><b>Whether SBB/BMC
						Consultation is required</b></td>
				<td class="text-center" style="width: 1px;"><b>:</b></td>
				<g:if
					test="${formRemkInstance?.sbbBmc == '' || formRemkInstance?.sbbBmc == null}">
					<td class="colspan">NA</td>

				</g:if>
				<g:elseif test="${formRemkInstance?.sbbBmc == true}">
					<td class="colspan">Yes</td>
				</g:elseif>

				<g:elseif test="${formRemkInstance?.sbbBmc == false}">
					<td class="colspan">No</td>
				</g:elseif>
				
				<td class="remark">
					${formRemkInstance?.sbbBmcRmk}
				</td>
			</tr>
			<tr>
				<td><b>22</b></td>
				<td><b>Geographical location</b></td>
				<td class="text-center" style="width: 1px;"><b>:</b></td>
				<td class="remark" colspan="3">
					
					<g:each in="${formRemkInstance?.gioLocation}" status="i" var="a">
     <li> ${a} </li>
 </g:each>		
				</td>
				
			</tr>

			<tr>
				<td><b>23</b></td>
				<td><b>Question</b></td>
				<td class="text-center" style="width: 1px;"><b>:</b></td>
				<td class="remark" colspan="2">
					${formRemkInstance?.question}
				</td>
			</tr>
<g:if test="${formRemkInstance != null || formRemkInstance != ''}">

<g:each in="${formRemkInstance?.questionAnswers}" var="quesAnswer" status="k">
<tr  class="remark">
<td>${k+24}</td>
<td >${quesAnswer?.question}</td>
<td><b>:</b></td>
<td colspan="2">${quesAnswer?.answer}</td>
</tr>
</g:each>

</g:if>
		
</tbody>
</table>

</body>
</html>