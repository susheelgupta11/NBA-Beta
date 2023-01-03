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

<style>
.remark{
color:blue;
width:35%;
}

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
			Form B
		</h2>
</div>
<div align="center"> <span class="text-center"> (See Regulation 13 of the Guidelines on Access to biological resources and associated knowledge and Benefits Sharing Regulations, 2014) 
Conducting of non-commercial research or research for emergency purposes outside India by Indian researcher’s/ Government institutions.
			</span> </div>
			
			<div style="margin-top: 20px">
 Submitted On: ${formDetails?.submittedOn}<span style="padding: 20px;"><b>Checklist Type : Legal</b></span>
 <span>Application Number:	${formDetails?.appNumber}</span>
 
</div>
<hr /> 
<table>
	<tr class="header">
		 <th>S.No</th>
              <th>Title</th>
              <th></th>
              <th>Details</th>
              <th >Remarks</th>
	</tr>

	<tr>
		<td><b>1</b></td>
		<td style="width: 50% !important"><b>Application category</b></td>
		<td><b>:</b></td>
		<td>Form B</td>
		<td class="remark">${formRemkInstance?.appFormCatgRmk}</td>
		
	</tr>
	<tr>
		<td><b>2</b></td>
		<td style="width: 50% !important"><b>Name of the applicant
				and contact details given under temporary and permanent address</b></td>
		<td><b>:</b></td>
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
					<g:set value="${individualProfile?.nationality}" var="nationality"/>
				</g:each>
			</g:if> <g:elseif test="${formDetails?.companyProfiles}">
				<g:each status="k" in="${formDetails?.companyProfiles}"
					var="company">
					${company?.entityName}
						<g:set value="${company?.nationality}" var="nationality"/>
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
					
					<g:set value="${researcher?.nationality}" var="nationality"/>
				</g:each>
			</g:elseif> <g:elseif test="${formDetails?.depostionOfMicroOrganism}">
				<g:each in="${formDetails?.depostionOfMicroOrganism}" var="depost">
					${depost?.nameOfDepositor}
					${depost?.address1}
					${depost?.address2}
					${depost?.address3}
					${depost?.city}
					
					<g:set value="${depost?.nationality}" var="nationality"/>
				</g:each>
			</g:elseif> <g:elseif test="${formDetails?.indianGovtInst}">
				<g:each in="${formDetails?.indianGovtInst}" var="govt">
					${govt?.govtInstName}
					${govt?.address1}
					${govt?.address2}
					${govt?.address3}
					${govt?.presentCity}
					<g:set value="Indian" var="nationality"/>
				</g:each>
			</g:elseif></td>
		<td class="remark">${formRemkInstance?.applicantNameContRmk}</td>
	</tr>
	<tr>
		<td><b>3</b></td>
		<td style="width: 50% !important"><b>Nationality</b></td>
		<td><b>:</b></td>
		<td class="colspan">Indian${nationality}</td>
		<td class="remark">${formRemkInstance?.appltnationality}</td>
	</tr>
	<tr>
		<td><b>4</b></td>
		<td style="width: 50% !important"><b>Whether the prescribed
				application form has been used</b></td>
		<td><b>:</b></td>
		    <g:if test="${formRemkInstance?.prescribedApplication == true}">
			<td>Yes</td>
		</g:if>
		<g:elseif test="${formRemkInstance?.prescribedApplication == false}">
			<td> No</td>

		</g:elseif>
		<g:elseif
			test="${formRemkInstance?.prescribedApplication == '' || formRemkInstance?.prescribedApplication == null }">
			<td>Not Selected</td>

		</g:elseif>
              <td class="remark">${formRemkInstance?.whetherPrescriedRmk}</td>
	</tr>
	<tr>
		<td><b>5</b></td>
		<td style="width: 50% !important"><b>Name and Address of
				Institution in India</b></td>
		<td><b>:</b></td>
		
		<td class="colspan">${indianInst?.name}<br/>
              
              
      ${indianInst?.address1}, ${indianInst?.address2} ${indianInst?.address3} ${indianInst?.city}, <br/>
						PIN:${indianInst?.pincode}, ${indianInst?.state} ${indianInst?.country}<br/>
						<b>Phone:</b>${indianInst?.phone}<br/>
						<b>Fax:</b>${indianInst?.fax}<br/>
						<b>Email:</b>${indianInst?.email}
              
              </td>
              <td class="remark"> ${formRemkInstance?.indinstitueRemk}</td>
	</tr>
	<tr>
		<td><b>6</b></td>
		<td style="width: 50% !important"><b>Name of the Supervisor
				or Head of Institution at the place of work in India</b></td>
		<td><b>:</b></td>
	  <td class="colspan">${superVisor?.name}
              ${superVisor?.address1}, ${superVisor?.address2} ${superVisor?.address3} ${superVisor?.city}, <br/>
						PIN:${superVisor?.pincode}, ${superVisor?.state} ${superVisor?.country}<br/>
						<b>Phone:</b>${superVisor?.phone}<br/>
						<b>Fax:</b>${superVisor?.fax}<br/>
						<b>Email:</b>${superVisor?.email}
              
              </td>
              <td class="remark">${formRemkInstance?.headSuperRemk} </td>
	</tr>

	<tr>
		<td><b>7</b></td>
		<td style="width: 50% !important"><b>Name of the
				funding agency supporting the proposed research</b></td>
               <td><b>:</b></td>
              <td class="colspan">
              
              <g:if test="${formDetails?.formBFundingAgency}">
              <g:each var="fund" in="${formDetails?.formBFundingAgency}">
              ${fund?.institutionOrganizationName}
              </g:each>
              </g:if></td>
              <td class="remark">${formRemkInstance?.fundingRemk}</td>
	</tr>

	<tr>
		<td><b>8</b></td>
		<td style="width: 50% !important"><b>Whether the
				undertakings, declarations / other documents are found in order?</b></td>
		<td><b>:</b></td>
		<g:if test="${formRemkInstance?.letterBoardChk == '' || formRemkInstance?.letterBoardChk == null}">
		<td></td>
		 </g:if>
		 
		 <g:if test="${formRemkInstance?.letterBoardChk == "true"}">
		<td>Yes</td>
		
		 </g:if>
		 
		 <g:if test="${formRemkInstance?.letterBoardChk == "false"}">
		<td>No</td>
		 </g:if>
		 
		
		<td class="remark">${formRemkInstance?.letterBoardRemark}</td>
		
	</tr>

	<tr>
		<td><b>9</b></td>
		<td style="width: 50% !important"><b>If it is for emergency
				purpose, specify details</b></td>
		<td><b>:</b></td>
		 <td class="colspan">${formDetails?.emergencyDetails}</td>
              <td class="remark">${formRemkInstance?.emergencyRemk}</td>
	</tr>

	<tr>
		<td><b>10</b></td>
		<td style="width: 50% !important"><b>Whether the application
				is legally found in order?</b></td>
		<td><b>:</b></td>
			<g:if test="${formRemkInstance?.orderChk == '' || formRemkInstance?.orderChk == null}">
		<td></td></g:if>
		
		<g:if test="${formRemkInstance?.orderChk == "true"}">
		<td>Yes</td></g:if>
		
		<g:if test="${formRemkInstance?.orderChk == "false"}">
		<td>No</td></g:if>
	
		<td class="remark">${formRemkInstance?.orderRemark}</td>
	</tr>


</table>
</body>
</html>