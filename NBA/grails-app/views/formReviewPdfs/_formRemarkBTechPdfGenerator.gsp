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
 Submitted On: ${formDetails?.submittedOn}<span style="padding: 20px;"><b> Checklist Type : Technical</b></span>
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
              <td style="width:30%!important"><b>Application category</b></td>
              <td><b>:</b></td>
              <td>Form B</td>
              <td class="remark">${formRemkInstance?.appFormCatgRmk}</td>
            </tr>
            <tr>
              <td><b>2</b></td>
              <td style="width:30%!important"><b>Name of the applicant and contact details given under temporary and permanent address</b></td>
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
              <td class="remark" >${formRemkInstance?.applicantNameContRmk}</td>
            </tr>
            <tr>
              <td><b>3</b></td>
              <td style="width:30%!important"><b>Nationality</b></td>
              <td><b>:</b></td>
            <td> 
            
            Indian${nationality}
            </td>
             
              <td class="remark" >${formRemkInstance?.appltnationality}</td>
            </tr>
            <tr>
              <td><b>4</b></td>
              <td style="width:30%!important"><b>Whether the prescribed application form has been used</b></td>
              <td><b>:</b></td>
             <g:if test="${formRemkInstance?.prescribedApplication == true}">
			<td> Yes </td>
		</g:if>
		<g:elseif test="${formRemkInstance?.prescribedApplication == false}">
			<td>No</td>

		</g:elseif>

              <td  class="remark" >${formRemkInstance?.whetherPrescriedRmk}</td>
            </tr>
            <tr>
              <td><b>5</b></td>
              <td style="width:30%!important"><b>Whether all columns are filled</b></td>
              <td><b>:</b></td>
            
              <g:if test="${formRemkInstance?.columnFilled == true}">
			     <td>Yes</td>
		</g:if>
		<g:elseif test="${formRemkInstance?.columnFilled == false}">
			<td>No</td>

		</g:elseif>
		
              <td class="remark" >${formRemkInstance?.columnFilledRmk}</td>
            </tr>
            <tr>
              <td><b>6</b></td>
              <td style="width:30%!important"><b>Whether Address Proof and ID proof matching with the details mentioned at S.No. 2</b></td>
              <td><b>:</b></td>
                <g:if test="${formRemkInstance?.idAndAddress == true}">
			<td> Yes</td>
		</g:if>
		<g:elseif test="${formRemkInstance?.idAndAddress == false}">
			<td>No</td>

		</g:elseif>
		
              <td class="remark" >${formRemkInstance?.idAndAddressRemark}</td>
            </tr>
            <tr>
              <td><b>7</b></td>
              <td style="width:30%!important"><b>Name and Address of Institution in India</b></td>
              <td><b>:</b></td>
              
              <td>${indianInst?.name}<br/>
              
              
      ${indianInst?.address1}, ${indianInst?.address2} ${indianInst?.address3} ${indianInst?.city}, <br/>
						PIN:${indianInst?.pincode}, ${indianInst?.state} ${indianInst?.country}<br/>
						<b>Phone:</b>${indianInst?.phone}<br/>
						<b>Fax:</b>${indianInst?.fax}<br/>
						<b>Email:</b>${indianInst?.email}
              
              </td>
              <td class="remark" >${formRemkInstance?.indinstitueRemk}</td>
            </tr>
            <tr>
              <td><b>8</b></td>
              <td style="width:30%!important"><b>Name of the Supervisor or Head of Institution at the place of work in India</b></td>
              <td><b>:</b></td>
              <td>${superVisor?.headOfInstName}<br/>
              ${superVisor?.address1}, ${superVisor?.address2} ${superVisor?.address3} ${superVisor?.city}, <br/>
						PIN:${superVisor?.pincode}, ${superVisor?.state} ${superVisor?.country}<br/>
						<b>Phone:</b>${superVisor?.phone}<br/>
						<b>Fax:</b>${superVisor?.fax}<br/>
						<b>Email:</b>${superVisor?.email}
              
              </td>
              <td class="remark" >${formRemkInstance?.headSuperRemk}</td>
            </tr>

            <tr>
              <td><b>9</b></td>
              <td style="width:30%!important"><b>Name and contact details of the Institution or organization who shall guide the proposed research / receiving the biological resources.</b></td>
              <td><b>:</b></td>
              <td>${guidingIns?.name}
              
              ${guidingIns?.address1}, ${guidingIns?.address2} ${guidingIns?.address3} ${guidingIns?.city}, <br/>
						PIN:${guidingIns?.pincode}, ${guidingIns?.state} ${guidingIns?.country}<br/>
						<b>Phone:</b>${guidingIns?.phone}<br/>
						<b>Fax:</b>${guidingIns?.fax}<br/>
						<b>Email:</b>${guidingIns?.email}
              
              </td>
              <td class="remark" > ${formRemkInstance?.indinstitueGuideRemk}</td>
            </tr>

            <tr>
              <td><b>10</b></td>
              <td style="width:30%!important"><b>Details of the Supervisor or Head of Institution or organization who guides the proposed research or recipient of the biological resources</b></td>
              <td><b>:</b></td>
              <td>${guidingSup?.name}
              
              ${guidingSup?.address1}, ${guidingSup?.address2} ${guidingSup?.address3} ${guidingSup?.city}, <br/>
						PIN:${guidingSup?.pincode}, ${guidingSup?.state} ${guidingSup?.country}<br/>
						<b>Phone:</b>${guidingSup?.phone}<br/>
						<b>Fax:</b>${guidingSup?.fax}<br/>
						<b>Email:</b>${guidingSup?.email}</td>
              <td class="remark" >${formRemkInstance?.indinstSuperRemk}</td>
            </tr>
            <tr>
              <td><b>11</b></td>
              <td colspan="5"><b>Details of biological resources proposed for carrying/ sending outside India</b></td>
            </tr>
            <tr>
              <td></td>
              <td colspan="5"><table style="width: 100%">
                  <tr>
                    <td><b>S. no</b></td>
                    <td><b>Intend to access</b></td>
                    <td><b>Common name</b></td>
                    <td><b>Scientific name</b></td>
                    <td><b>Nature of biological resources</b></td>
                    <td><b>Part of biological resources</b></td>
                    <td><b>Quantity of biological resources</b></td>
                    <td><b>Duration</b></td>
                    <td><b>Remarks</b></td>
                  </tr>
                 <g:if test="${formDetails?.biologicalResources}">
					
						<g:each in="${formDetails?.biologicalResources}" var="resource"
							status="i">
							<tr>
							<td>
								${i+1}
							</td>
							<td>
								${resource?.accessIntention?:'NA'}
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
							<td>
								${resource?.quantity} ${resource?.qtyUnit}
							</td>
							<td>
								${resource?.fromTime} - ${resource?.toTime}
							</td>
							<td class="remark">${formRemkInstance?.biologicalResRmk}</td>
							</tr>
						</g:each>
					
				</g:if>
                </table></td>
            </tr> 
            <tr>
              <td><b>12</b></td>
              <td colspan="5"><b>Geographical location of the biological resources accessed</b></td>
            </tr>
            <tr>
              <td></td>
              <td colspan="5"><table class="table table-bordered">
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
                </table></td>
            </tr>
            <tr>
              <td><b>13</b></td>
              <td style="width:30%!important"><b>Name of the funding agency supporting the proposed research</b></td>
              <td><b>:</b></td>
              <td class="colspan">
              
              <g:if test="${formDetails?.formBFundingAgency}">
              <g:each var="fund" in="${formDetails?.formBFundingAgency}">
              ${fund?.institutionOrganizationName}
              </g:each>
              </g:if></td>
              <td class="remark" colspan="2">${formRemkInstance?.fundingRemk}</td>
            </tr>
             <tr>
              <td><b>14</b></td>
              <td style="width:30%!important"><b>If it is for emergency purpose, specify details</b></td>
              <td><b>:</b></td>
              <td>${formDetails?.emergencyDetails}</td>
              <td class = "remark" >${formRemkInstance?.emergencyRemk}</td>
            </tr>
            
            <tr>
              <td><b>15</b></td>
              <td style="width: 100%"><b>Whether the listed species notified under section 38 of the BD Act?</b></td>
              
              <td></td>
              <td colspan="5"></td>
              </tr>
            <tr>
              <td><b>16</b></td>
              <td style="width:30%!important"><b>Whether duly filled in and signed Undertaking and Declarations of the applicant/ supervisor/recipient are attached?</b></td>
              <td><b>:</b></td>
       
		<g:if test="${formRemkInstance?.signedUndertaking == true}">
			<td>Yes</td>
		</g:if>
		<g:elseif test=" ${formRemkInstance?.signedUndertaking == false}">
			<td>No</td>
		</g:elseif>
              <td class="remark" >${formRemkInstance?.signedUndertakingRmk}</td>
            </tr>

          
            <tr>
              <td><b>17</b></td>
              <td style="width:30%!important"><b>Whether the application contains all required technical information</b></td>
              <td><b>:</b></td>
           
		<g:if test="${formRemkInstance?.technicalInformation == true}">
			<td>Yes</td>
		</g:if>
		<g:elseif test="${formRemkInstance?.technicalInformation == false}">
			<td >No</td>
		</g:elseif>
              <td class = "remark" >
				${formRemkInstance?.technicalInformationRmk}</td>
            </tr>
          </table>
</body>
</html>