<%@ page contentType="text/html;charset=UTF-8" %>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>NBA</title>
<style type="text/css">
.remark{color:blue;}

table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
</head>
<body>
<%--<a href="#" target="_blank">--%>
<%--        <img src="https://absefiling.nic.in/NBA/assets/Logo1.jpg" width="700px"  alt="NBA" border="0" style="display: block;" /></a>--%>

<div align="center">
<h2>
			Form III
		</h2>
</div>
<div align="center"> <span class="text-center"> (See Rule 18 of Biological
								Diversity Rules, 2004)<br /> Application form for applying for
								Intellectual Property Right.
			</span> </div>
			
			<div style="margin-top: 20px">
 Submitted On: ${formDetails?.submittedOn}<span style="padding: 20px;"><b> Checklist Type : Technical</b></span>
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
	
	<tr><td><b>1</b></td>
	<td style="width: 35% !important"><b>Online Application number</b></td>
	<td class="text-center" style="width: 1px;"><b>:</b></td>
	<td class="colspan">
		${formDetails?.appNumber}
	</td>
	<td colspan="2" class="remark">${formRemkInstance?.onlineAppNumberRmk}</td>
	</tr>
	
	<tr>
		<td><b>2</b></td>
		<td style="width: 35% !important"><b>NBA Reference number</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="remark">${formRemkInstance?.nbaRefNumber}</td>
		<td colspan="2" class="remark">${formRemkInstance?.nbaRefNumberRemark}</td>
	</tr>
	<tr>
		<td><b>3</b></td>
		<td style="width: 35% !important"><b>Applicant category</b></td>
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
		<td style="width: 35% !important"><b>Name of the applicant
				and contact details</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td><g:if
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
			</g:elseif> 
			<g:elseif test="${formDetails?.indianResearcher}">
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
		<td class="remark" colspan="2">${formRemkInstance?.applicantNameContRmk}</td>
	</tr>
	<tr>
		<td><b>5</b></td>
		<td style="width: 35% !important"><b>Name and Address of the
				contact person/ authorized person of the company</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">		<g:if test="${formDetails?.companyProfiles}">
		<g:each var="contactPersonDitals" in="${formDetails?.companyProfiles}">
		${contactPersonDitals?.title} 
		${contactPersonDitals?.firstName} 
		${contactPersonDitals?.middleName} 
		${contactPersonDitals?.lastName}<br/> 
		Designation:${contactPersonDitals?.designation} 
		Mobile:${contactPersonDitals?.personMobile} 
	  Email:${contactPersonDitals?.personEmail}
	  </g:each> 
	</g:if>	
	<g:else>No</g:else></td>
		<td class="remark" colspan="2">${formRemkInstance?.authPersonContRmk}</td>
	</tr>
	
		<tr>
		<td><b>6</b></td>
		<td style="width: 35% !important"><b>Name and address of the
				contact person/ agent/ attorney, in India</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">
		<g:if test="${formDetails?.agentProfile}">
			${formDetails?.agentProfile?.title} ${formDetails?.agentProfile?.firstName}
			${formDetails?.agentProfile?.middleName} ${formDetails?.agentProfile?.lastName}<br/>
			${formDetails?.agentProfile?.address1} ${formDetails?.agentProfile?.address2}
			${formDetails?.agentProfile?.address3} <br/>
			${formDetails?.agentProfile?.city}
			</g:if>
			
			<g:else>No</g:else></td>
		<td class="remark" colspan="2">${formRemkInstance?.attorneyInIndiaContRmk}</td>
	</tr>
	<tr>
		<td><b>7</b></td>
		<td style="width: 35% !important"><b>Category of Application
				Form</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">
			Form III
		</td>
		<td class="remark" colspan="2">${formRemkInstance?.appFormCatgRmk}</td>
	</tr>
	
		<tr>
		<td><b>8</b></td>
		<td style="width: 35% !important"><b>Whether Address Proof
				and ID proof matching with the details mentioned above </b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
			<g:if test="${formRemkInstance?.idAndAddress == true}">
		<td>Yes</td>
		</g:if>
		<g:elseif test="${formRemkInstance?.idAndAddress == false}">
      <td>No</td>
		
		</g:elseif>
		<g:elseif test="${formRemkInstance?.idAndAddress == '' || formRemkInstance?.idAndAddress == null }">
	      <td>NA</td>
		</g:elseif>
		<td class="remark" colspan="2">${formRemkInstance?.idAndAddressRemark}</td>
	</tr>
	<tr>
		<td><b>9</b></td>
		<td colspan="5"><b>Details of biological resources and/ or
				associated knowledge used in the invention</b></td>
	</tr>
	<tr>
		<td></td>
		<td colspan="5"><table border="1">
				<tbody><tr>
					<td><b>S. no</b></td>
					<td><b>Accessed</b></td>
					<td><b>Common name</b></td>
					<td><b>Scientific name</b></td>
					<td><b>Nature of biological resources</b></td>
					<td><b>Part of biological resources</b></td>
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
				<td class="remark">${bioRemarks?.bioRemarks}</td>				
				</tr>
				</g:each>
				</g:if>
					<g:else>
						<g:each in="${formDetails?.biologicalResources}" var="resource"
							status="i">
							<tr>
                            <td>${i+1}</td>
							<td>${resource?.name?:'NA'}</td>
							<td>${resource?.commonName?:'NA'}</td>
							<td>${resource?.scientificName?:'NA'}</td>
							<td>${resource?.nature?:'NA'}</td>
							<td>${resource?.biologicalResource?:'NA'}</td>
						
							<td><g:textField name="resremk" class="remark"
									value="${formRemkInstance?.biologicalResRmk}" />
							</td>
							</tr>
						</g:each>
				
				</g:else>

			</tbody></table></td>
	</tr>
	<tr>
		<td><b>10</b></td>
		<td colspan="5"><b>Geographical location of the biological
				resources accessed</b></td>
	</tr>
	<tr>
		<td></td>
		<td colspan="5"><table border="1">
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
					
				</g:elseif>
				
			</tbody></table></td>
	</tr>
	
	<tr>
		<td><b>11</b></td>
		<td colspan="5"><b>Whether listed in
				NTC/Rare/Endemic/Endangered/Threatened,Wildlife
				Act/CITES/BDA/ITPGRFA</b></td>
	</tr>
	<tr>
		<td></td>
		<td colspan="5"><table style="width: 100%">
				<tbody><tr>
					<td><b>S. no</b></td>
					<td><b>Scientific name</b></td>
					<td><b>Status</b></td>
					<td><b>Part</b></td>
					<td><b>Remarks</b></td>
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
				<tr><td colspan="5">No bioresource data is matching</td></tr>
				</g:else>
			</tbody></table></td>
	</tr>
	<tr>
		<td><b>12</b></td>
		<td style="width: 35% !important"><b>Details of institution
				where Research and Development carried out</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">${formDetails?.detailsOfInstitute}</td>
		<td class="remark" colspan="2">${formRemkInstance?.instOrganisation}</td>
	</tr>

	<tr>
		<td><b>13</b></td>
		<td style="width: 35% !important"><b>Details of economic,
				bio-technological, scientific or any other benefits that are
				intended, or may accrue to the applicant due to commercialization of
				the invention</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">${formDetails?.benefitsToTheApplicant}</td>
		<td class="remark" colspan="2">${formRemkInstance?.commTheInvention}</td>
	</tr>

	<tr><td><b>14</b></td>
	<td style="width: 35% !important"><b>Whether the Application
			contains all the required Technical information</b></td>
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
	<td class="remark" colspan="2">${formRemkInstance?.technicalInformationRmk}</td>
	</tr>

<tr>
		<td><b>15</b></td>
		<td style="width: 35% !important"><b>Whether SBB/BMC
				Consultation is required</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
	<g:if test="${formRemkInstance?.sbbBmc == '' || formRemkInstance?.sbbBmc == null}">
		<td class="colspan">NA</td>
		
		</g:if>
		<g:elseif test="${formRemkInstance?.sbbBmc == true}">
	<td class="colspan">Yes</td>
		</g:elseif>
		
		<g:elseif test="${formRemkInstance?.sbbBmc == false}">
		<td class="colspan">No</td>
		</g:elseif>
		<td class="remark" colspan="2">${formRemkInstance?.sbbBmcRmk}</td>
	</tr>
				<tr>
				<td><b>16</b></td>
				<td><b>Geographical location</b></td>
				<td class="text-center" style="width: 1px;"><b>:</b></td>
				<td class="remark" colspan="3">
					
					<g:each in="${formRemkInstance?.gioLocation}" status="i" var="a">
     <li> ${a} </li>
 </g:each>		
				</td>
				
			</tr>
	<tr>
		<td><b>17</b></td>
		<td><b>Question</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td colspan="3" class="remark">${formRemkInstance?.question}</td>
		
	</tr>

<g:if test="${formRemkInstance != null || formRemkInstance != ''}">

<g:each in="${formRemkInstance?.questionAnswers}" var="quesAnswer" status="k">
<tr class="remark">
<td>${k+18}</td>
<td>${quesAnswer?.question}</td>
<td><b>:</b></td>
<td colspan="3">${quesAnswer?.answer}</td>
</tr>
</g:each>
</g:if>

	
	</tbody>
	</table>
	
</body>
</html>