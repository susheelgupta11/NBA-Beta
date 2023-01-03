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
<title>NBA</title>
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
			Form II
		</h2>
</div>
<div align="center"> <span class="text-center"> (See Rule 17 of
				Biological Diversity Rules, 2004)<br /> Application for seeking
				prior approval of National Biodiversity Authority for transferring
				the results of research to foreign nationals,companies, NRIs for
				commercial purposes.
			</span> </div>
			
			<div style="margin-top: 20px">
 Submitted On: ${formDetails?.submittedOn}<span style="padding: 20px;"><b>Checklist Type : Technical</b></span>
 <span>Application Number:	${formDetails?.appNumber}</span>
 
</div>
<hr />			
<table style="margin-top: 25px">
	<tbody><tr class="header">
		<th>S.No</th>
		<th>Title</th>
		<th></th>
		<th>Details</th>
		<th colspan="2">Remarks</th>
		
	</tr>
	<tr>
		<td><b>1</b></td>
		<td style="width: 35%!important"><b>Online Application
				number</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">
			${formDetails?.appNumber}
		</td>
		
		<td colspan="2" class="remark">${formRemkInstance?.onlineAppNumberRmk}</td>
	</tr>
	<tr>
		<td><b>2</b></td>
		<td style="width: 35%!important"><b>NBA Reference number</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="remark">${formRemkInstance?.nbaRefNumber}</td>
		<td  colspan="2" class="remark">${formRemkInstance?.nbaRefNumberRemark}</td>
	</tr>
	<tr>
		<td><b>3</b></td>
		<td style="width: 35%!important"><b>Applicant category</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan"><g:if
				test="${formDetails?.individualProfiles}">Individual</g:if> <g:elseif
				test="${formDetails?.companyProfiles}">Company</g:elseif> <g:elseif
				test="${formDetails?.indianGovtInst}">Government</g:elseif> <g:elseif
				test="${formDetails?.depostionOfMicroOrganism}"></g:elseif></td>

		
		<td colspan="2" class="remark">${formRemkInstance?.applicantCatgRmk}</td>
	</tr>
	<tr>
		<td><b>4</b></td>
		<td style="width: 35%!important"><b>Name of the applicant
				and contact details</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">
				<g:if
				test="${formDetails?.individualProfiles}">
				<g:each in="${formDetails?.individualProfiles}"
					var="individualProfile">

					${individualProfile?.title}
					${individualProfile?.firstName}
					${individualProfile?.middleName}
					${individualProfile?.lastName}
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
					${researcher?.lastName}
					${researcher?.address1}
					${researcher?.address2}
					${researcher?.address3}
					${researcher?.presentCity}
				</g:each>
			</g:elseif> <g:elseif test="${formDetails?.depostionOfMicroOrganism}">
				<g:each in="${formDetails?.depostionOfMicroOrganism}" var="depost">
					${depost?.nameOfDepositor}
					${depost?.address1}
					${depost?.address2}
					${depost?.address3}
					${depost?.city}
				</g:each>
			</g:elseif> <g:elseif test="${formDetails?.indianGovtInst}">
				<g:each in="${formDetails?.indianGovtInst}" var="govt">
					${govt?.govtInstName}
					${govt?.address1}
					${govt?.address2}
					${govt?.address3}
					${govt?.presentCity}
				</g:each>
			</g:elseif>
				
			</td>
		
		<td  colspan="2" class="remark">${formRemkInstance?.applicantNameContRmk}</td>
	</tr>
	<tr>
		<td><b>5</b></td>
		<td style="width: 35%!important"><b>Name and Address of the
				contact person/ authorized person of the company</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">
				<g:if test="${formDetails?.companyProfiles}">
		<g:each in="${formDetails?.companyProfiles}" var="authPerson">
		${authPerson?.title} 
		${authPerson?.firstName} 
		${authPerson?.middleName} 
		${authPerson?.lastName} 
		Designation:${authPerson?.designation} 
		Mobile:${authPerson?.personMobile} 
	    Email:${authPerson?.personEmail}</g:each> </g:if>
	<g:else>No</g:else>
		</td>
		<td colspan="2" class="remark">${formRemkInstance?.authPersonContRmk}</td>
	</tr>
	<tr>
		<td><b>6</b></td>
		<td style="width: 35%!important"><b>Name and address of the
				contact person/ agent/ attorney, in India</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">
				
				<g:if test="${formDetails?.agentProfile}">
		    ${formDetails?.agentProfile?.title} ${formDetails?.agentProfile?.firstName}
			${formDetails?.agentProfile?.middleName} ${formDetails?.agentProfile?.lastName}<br />
		Address:${formDetails?.agentProfile?.address1} ${formDetails?.agentProfile?.address2}
			${formDetails?.agentProfile?.address3}<br /> 
			City:${formDetails?.agentProfile?.city}
			</g:if>
			<g:else>No</g:else>
			</td>
		<td colspan="2" class="remark">${formRemkInstance?.attorneyInIndiaContRmk}</td>
	</tr>
	<tr>
		<td><b>7</b></td>
		<td style="width: 35%!important"><b>Category of Application
				Form</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">
			Form II
		</td>
		<td colspan="2" class="remark">${formRemkInstance?.appFormCatgRmk}</td>
	</tr>
	<tr>
		<td><b>8</b></td>
		<td style="width: 35%!important"><b>Whether Address Proof
				and ID proof matching with the details mentioned above </b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
				<g:if test="${formRemkInstance?.idAndAddress == true}">
		<td class="colspan">Yes</td>
		</g:if>
		<g:elseif test="${formRemkInstance?.idAndAddress == false}">
      <td class="colspan">No</td>
		
		</g:elseif>
		<g:elseif test="${formRemkInstance?.idAndAddress == '' || formRemkInstance?.idAndAddress == null }">
	      <td class="colspan">NA</td>
		</g:elseif>
		<td colspan="2" class="remark">${formRemkInstance?.idAndAddressRemark}</td>
	</tr>
	<tr>
		<td><b>9</b></td>
		<td style="width: 35%!important"><b>Details of results of
				research conducted</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan"></td>
		<td colspan="2"></td>
	</tr>
	<tr>
		<td><b>9 a)</b></td>
		<td><b>Details of research
				conducted</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">${formDetails?.briefDescription}</td>
		<td colspan="2" class="remark">${formRemkInstance?.resConducted}</td>
	</tr>
	<tr>
		<td><b>9 b)</b></td>
		<td><b>Type of results of
				research to be transferred</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">${formDetails?.resultsOfResearch}</td>
		<td colspan="2" class="remark">${formRemkInstance?.resOfReserch}</td>
	</tr>
	<tr>
		<td><b>10</b></td>
		<td colspan="5"><b>Details of biological resources and
				associated knowledge used in the research</b></td>
	</tr>
	<tr>
		<td></td>
		<td colspan="5"><table class="table table-bordered">
				<tbody><tr>
					<td><b>S. no</b></td>
					<td><b>Accessed</b></td>
					<td><b>Common name</b></td>
					<td><b>Scientific name</b></td>
					<td><b>Nature of biological resources</b></td>
					<td><b>Source of access</b></td>
					<td><b>Remarks</b></td>
				</tr>
				
								<g:if test="${formDetails?.biologicalResources}">
					<tr>
						<g:each in="${formDetails?.biologicalResources}" var="resource"
							status="i">
							<td>
								${i+1}
							</td>
							<td>
								${resource?.name?:'NA'}
							</td>
							<td>
								${resource?.commonName?:'NA'}
							</td>
							<td>
								${resource?.scientificName?:'NA'}
							</td>
							<td>
								${resource?.nature?:'NA'}
							</td>
							<td>
								${resource?.biologicalResource?:'NA'}
							</td>
							<td class="remark">${formRemkInstance?.biologicalResRmk}</td>
						</g:each>
					</tr>
				</g:if>
		</tbody></table>
			</td>
	</tr>
	<tr>
		<td><b>11</b></td>
		<td colspan="5"><b>Geographical location of biological
				resources used in the research</b></td>
	</tr>
	<tr>
		<td></td>
		<td colspan="5"><table class="table table-bordered">
				<tbody><tr>
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
					
				</g:elseif></tbody></table></td>
	</tr>
	<tr>
		<td><b>12</b></td>
		<td><b>Description/nature of
				traditional knowledge (oral/documented)</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan"><g:if test="${formDetails?.individualProfiles}">
			${formDetails?.nature}<br /> <g:if
				test="${formDetails?.nature != 'No'}">
				<b>Details:</b><br/>
				${formDetails?.traditionalKnowledgeDesc}
			</g:if>
			</g:if>
			<g:if test="${formDetails?.companyProfiles}">
			${formDetails?.isNoForTraditional}
			<g:if test= "${formDetails?.isNoForTraditional != 'No' }">
			<b>Description</b><br/>
				
					${formDetails?.traditionalKnowledgeDesc}
			</g:if>
			
			</g:if></td>
		<td colspan="2" class="remark">${formRemkInstance?.oralRemark}</td>
	</tr>
	<tr>
		<td><b>13</b></td>
		<td style="width: 35%!important"><b>Geographical location of
				the community/individual</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan"><g:if test = "${formDetails?.locations}">
				<g:each in="${formDetails?.locations}" var="location">
				 ${location?.consentObtained}<br/>
				    <b>Geo Location</b><br/>
<%--					${location?.communityKnowledge}--%>
					${location?.village}
					${location?.town}
					${location?.district}
				</g:each>
			</g:if>
			<g:else>No</g:else></td>
		<td colspan="2" class="remark">${formRemkInstance?.giolocCommunityRmk}</td>
	</tr>
	<tr>
		<td><b>14</b></td>
		<td style="width: 35%!important"><b>Consent obtained from
				the community/individual</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">			
		<g:if test="${formDetails?.locations?.consentObtained != 'No'}">
				<g:each in="${formDetails?.locations}" var="consent">
				${consent?.consentObtained}<br />
				<b>Address:</b><br/>
					${consent?.communityKnowledge}
					${consent?.village}
					${consent?.town}
					${consent?.district}
					${consent?.state}
				</g:each>
			</g:if>
		
		<g:if  test="${formDetails?.isNoForTraditional == 'No'}">
			No
			</g:if></td>
		<td  colspan="2" class="remark">${formRemkInstance?.consObtained}</td>
	</tr>
	<tr>
		<td><b>15</b></td>
		<td style="width: 35%!important"><b>Details of institution
				where R&amp;D activities carried out</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan"></td>
		<td colspan="2"></td>
		
	</tr>
	<tr>
		<td><b>15 a)</b></td>
		<td style="width: 35%!important"><b>Provide the name and
				contact details of the institution / organisation where R&amp;D was
				carried out</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">${formDetails?.detailsOfInstitute}</td>
		<td colspan="2" class="remark">${formRemkInstance?.instOrganisation}</td>
	</tr>
	<tr>
		<td><b>16</b></td>
		<td style="width: 35%!important"><b>Details of individual/
				organisation to whom the research results are intended to be
				transferred</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">${formDetails?.detailsOfIndividualOrOrganisation}</td>
		<td colspan="2"></td>
	
	</tr>
	<tr>
		<td><b>16 a)</b></td>
		<td style="width: 35%!important"><b>Name and contact details
				of individual / organisation</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan"></td>
		<td colspan="2"></td>
	</tr>
	<tr>
		<td><b>16 b)</b></td>
		<td style="width: 35%!important"><b>Details of the intended
				use of research results by the transferee</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">${formDetails?.useofResearchResults}</td>
		<td colspan="2" class="remark">${formRemkInstance?.intendedUseOfResearch}</td>
	</tr>
	<tr>
		<td><b>17</b></td>
		<td style="width: 35%!important"><b>Details of economic,
				biotechnological, scientific or any other benefits that are
				intended, or may accrue to the individual / organization due to
				commercialization of transferred research results</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">${formDetails?.benefitsToTheIndividualOrOrganization}</td>
		<td colspan="2" class="remark">${formRemkInstance?.biotechnological}</td>
	</tr>
	<tr>
		<td><b>18</b></td>
		<td style="width: 35%!important"><b>Details of economic,
				biotechnological, scientific or any other benefits that are
				intended, or may accrue to the applicant seeking approval for
				transfer of results of research</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td>${formDetails?.benefitsToTheApplicant}</td>
							
		<td colspan="2" class="remark">${formRemkInstance?.seekApproval}</td>
	</tr>
	<tr>
		<td><b>19</b></td>
		<td style="width: 35%!important"><b>Whether the application
				contains all the required technical information</b></td>
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
		<td colspan="2"></td>
	</tr>
	<tr>
		<td><b>20</b></td>
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
				<td><b>21</b></td>
				<td><b>Geographical location</b></td>
				<td class="text-center" style="width: 1px;"><b>:</b></td>
				<td class="remark" colspan="3">
					
					<g:each in="${formRemkInstance?.gioLocation}" status="i" var="a">
     <li> ${a} </li>
 </g:each>		
				</td>
				
			</tr>
	<tr>
		<td><b>22</b></td>
		<td><b>Question</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td colspan="2" class="remark">${formRemkInstance?.question}</td>

<td></td>
	</tr>
<g:if test="${formRemkInstance != null || formRemkInstance != ''}">

<g:each in="${formRemkInstance?.questionAnswers}" var="quesAnswer" status="k">
<tr class="remark">
<td>${k+22}</td>
<td>${quesAnswer?.question}</td>
<td><b>:</b></td>
<td colspan="2">${quesAnswer?.answer}</td>
</tr>
</g:each>
</g:if>	
</tbody>
</table>
</body>
</html>