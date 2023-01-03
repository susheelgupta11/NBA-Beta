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
			</span> 
</div>
			
<div style="margin-top: 20px">
 Submitted On: ${formDetails?.submittedOn}<span style="padding: 20px;"><b>Checklist Type : Legal </b></span>
 <span> Application Number:	${formDetails?.appNumber}</span>
 
</div>
<hr />			
    <table style="margin-top: 25px">
            <tr class="header">
               <th>S.No</th>
              <th>Title</th>
              <th></th>
              <th>Details</th>
              <th colspan="4">Remarks</th>
            </tr>
            <tr>
              <td><b>1</b></td>
              <td><b>Online Application number</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td >${formDetails?.appNumber}</td>
              
              <td class="remark" colspan="4">${formRemkInstance?.onlineAppNumberRmk}</td>
            </tr>
            <tr>
              <td><b>2</b></td>
              <td><b>NBA Reference number</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td>${formRemkInstance?.nbaRefNumber}</td>
              
              <td class="remark" colspan="4">${formRemkInstance?.nbaRefNumberRemark}</td>
            </tr>
            <tr>
              <td><b>3</b></td>
              <td><b>Applicant category</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td ><g:if
				test="${formDetails?.individualProfiles}">Individual</g:if> <g:elseif
				test="${formDetails?.companyProfiles}">Company</g:elseif> </td>
              
              <td class="remark" colspan="4">${formRemkInstance?.applicantCatgRmk}</td>
            </tr>
             <tr>
              <td><b>4</b></td>
              <td><b>Name of the applicant and contact details</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td ><g:if
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
			</g:elseif></td>
              
              <td class="remark" colspan="4">${formRemkInstance?.applicantNameContRmk}</td>
            </tr>
             <tr>
              <td><b>5</b></td>
              <td><b>Name and Address of the contact person/<br /> authorized person of the company</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td > <g:if test="${formDetails?.companyProfiles}">
			<g:each in="${formDetails?.companyProfiles}" var="company">
			${company?.title} ${company?.firstName} ${company?.middleName} ${company?.lastName}<br/>
			<b>Designation:</b> ${company?.designation}<br/>
			<b>Mobile :</b> ${company?.personMobile} <br />
		<b>Email Id :</b> ${company?.personEmail}
			</g:each>
			</g:if>
			<g:else>No</g:else></td>
              
             <td class="remark" colspan="4">${formRemkInstance?.authPersonContRmk}</td>
            </tr>
             <tr>
              <td><b>6</b></td>
              <td><b>Name and address of the contact person/<br /> agent/ attorney, in India</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td >
             <g:if test="${formDetails?.agentProfile}">
			${formDetails?.agentProfile?.title} ${formDetails?.agentProfile?.firstName}
			${formDetails?.agentProfile?.middleName} ${formDetails?.agentProfile?.lastName}
			${formDetails?.agentProfile?.address1} ${formDetails?.agentProfile?.address2}
			${formDetails?.agentProfile?.address3} ${formDetails?.agentProfile?.city}
			</g:if><g:else>No</g:else></td>
              
              <td class="remark" colspan="4">${formRemkInstance?.attorneyInIndiaContRmk}</td>
            </tr>
            <tr>
              <td><b>7</b></td>
              <td><b>Category of Application Form</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td > Form I </td>
             
              <td class="remark" colspan="4">${formRemkInstance?.appFormCatgRmk}</td>
            </tr>
            <tr>
              <td><b>8</b></td>
              <td><b>Is the applicant falls u/s 3(2)</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td ><g:if test="${formRemkInstance?.threeTwocheck == true }">
                Yes</g:if>
             <g:if test="${formRemkInstance?.threeTwocheck == false }">
                No</g:if> </td>
              
              <td class="remark" colspan="4">${formRemkInstance?.threeTwoRemark}</td>
            </tr>
            <tr>
              <td><b>9</b></td>
              <td><b>Is the applicant falls u/s 7</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td ><g:if test="${formRemkInstance?.sevncheck == true }">
                Yes
               </g:if>
               <g:if test="${formRemkInstance?.sevncheck == false }">
                No</g:if> </td>
              
              <td class="remark" colspan="4">${formRemkInstance?.sevnRemark}</td>
            </tr>
             <tr>
              <td><b>10</b></td>
              <td><b>Is Authorization letter/Board Resolution/POA found in order</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td > <g:if test="${formRemkInstance?.letterBoardChk == "true"}">
                Yes
                </g:if>
                 <g:if test="${formRemkInstance?.letterBoardChk == "false"}">
                No
              </g:if>
              <g:elseif test="${formRemkInstance?.letterBoardChk == 'notAvailable'}">
                N/A</g:elseif> </td>
              
              <td class="remark" colspan="4">${formRemkInstance?.letterBoardRemark}</td>
            </tr>
            <tr>
              <td><b>11</b></td>
              <td><b>Is MoU/AoA/LoI/Annual Report/Share holding pattern etc, found in order</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td ><g:if test="${formRemkInstance?.holdingPatternChk == "true" }">
                Yes
               </g:if>
               <g:if test="${formRemkInstance?.holdingPatternChk == "false" }">
                No
              </g:if>
              <g:elseif test="${formRemkInstance?.holdingPatternChk =="notAvailable"}">
              
              N/A </g:elseif>
              </td>
              
              <td class="remark" colspan="4">${formRemkInstance?.holdingPatternRemark}</td>
            </tr>
                 <tr>
              <td><b>12</b></td>
              <td colspan="5"><b>Details of biological resources and/or associated knowledge proposed for access</b></td>
            </tr>
            <tr>
              <td></td>
              <td colspan="7"><table class="table table-bordered">
                  <tr>
                    <td><b>S. no</b></td>
                    <td><b>Intend to access</b></td>
                    <td><b>Common name</b></td>
                    <td><b>Scientific name</b></td>
                    <td><b>Nature of biological resources</b></td>
                    <td><b>Part of biological resources</b></td>
                    <td><b>Quantity of biological resources</b></td>
                    <td><b>Time span in which the biological resource</b></td>
                    <td><b>Remarks</b></td>
                  </tr>
                			<g:if test="${formDetails?.biologicalResources}">
									<tr>
									<g:each in="${formDetails?.biologicalResources}" var="resource" status="i">
										<td>${i+1}</td>
										<td>${resource?.accessIntention}</td>
										<td>${resource?.commonName}</td>
										<td>${resource?.scientificName}</td>
										<td>${resource?.nature}</td>
										<td>${resource?.biologicalResource}</td>
										<td>${resource?.quantity}
										${resource?.qtyUnit}</td>
										<td>
										<g:formatDate format="dd/MM/yyyy" date="${resource?.fromTime}"/>
										
										to 
										<g:formatDate format="dd/MM/yyyy" date="${resource?.toTime}"/> </td>
										<td class="remark">${formRemkInstance?.biologicalResRmk}</td>
										</g:each>
									</tr>
							</g:if>
                </table></td>
            </tr>
            
               <tr>
              <td><b>13</b></td>
		<td colspan="8"><b>Name and number of persons authorized by
				the applicant for making selection</b>
				<g:if test= "${formDetails?.selfAuthorizedPerson }">
				--Self
				</g:if>
				<table style="width: 100%">
				<tr>
					<td><b>S. no</b></td>
					<td><b>Name</b></td>
					<td><b>Address</b></td>
					<td><b>Mobile</b></td>
					<td><b>Email</b></td>
					<td><b>Remarks</b></td>
				</tr>
				<g:if test= "${!formDetails?.selfAuthorizedPerson }">	
				<g:each in="${allDataforMatching?.listOfContactPerson}" var="profile" status="m">
					<tr>
						<td class="session">${m+1}</td>
					
						<td class="text-center">
							${profile?.nameOfContactPerson?:'NA'}
						</td>
						<td class="text-center">
							${profile?.addressOfContactPerson?:'NA'}
						</td>
				
						<td class="text-center">
							${profile?.mobileOfContactPerson?:'NA'}
						</td>
				
						<td class="text-center">
							${profile?.emailOfContactPerson?:'NA'}
						</td>
				<td><g:textField class="remark" name="makingSelection" value="${formRemkInstance?.makingSelection}"/></td>
					</tr>
				</g:each>
				</g:if>
				
			</table></td>
        </tr>
             <tr>
              <td><b>14</b></td>
              <td><b>Intended purpose for access of biological resources and/or associated knowledge</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td >${formDetails?.purposeOfProposal}</td>
              
              <td class="remark" colspan="4">${formRemkInstance?.intendedPurpose}</td>
            </tr>
            <tr>
              <td><b>14A</b></td>
              <td><b>In case of research Whether the research falls within the legal ambit of section 2(m) of BD Act?</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td ><g:if test="${formRemkInstance?.twoMChk == true}">
                Yes
               </g:if>
               <g:if test="${formRemkInstance?.twoMChk == false}">
                No. Need additional information from the Applicant </g:if></td>
              
              <td class="remark" colspan="4">${formRemkInstance?.twoMRemark}</td>
            </tr>
             <tr>
              <td><b>14B</b></td>
              <td><b>In case of commercial utilization Whether the commercial activity falls within the legal ambit of section
                2(f) of BD Act?</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td ><g:if test="${formRemkInstance?.twoFChk == true}">
                Yes
             </g:if>
             <g:if test="${formRemkInstance?.twoFChk == false}">
                No. Need additional information from the Applicant</g:if> </td>
              
              <td class="remark" colspan="4">${formRemkInstance?.twoFRemark}</td>
            </tr>
            <tr>
              <td><b>14C</b></td>
              <td><b>In case of bio-survey and bio-utilization Whether the activity falls within the legal ambit of section 2(d) of BD
                Act?</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td ><g:if test="${formRemkInstance?.twoDChk == true}">
                Yes
              </g:if>
              <g:if test="${formRemkInstance?.twoDChk == false}">
                No. Need additional information from the Applicant</g:if> </td>
              
              <td class="remark" colspan="4">${formRemkInstance?.twoDRemark}</td>
            </tr>
          <tr>
              <td><b>15</b></td>
              <td><b>Is all the information required for legal vetting available</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td >
              <g:if test="${formRemkInstance?.vettingChk == "true"}">
                Yes
               </g:if>
               <g:if test="${formRemkInstance?.vettingChk == "false"}">
                No. Need additional information</g:if> </td>
              
              <td class="remark" colspan="4">${formRemkInstance?.vettingRemark}</td>
            </tr>
            <tr>
              <td><b>16</b></td>
              <td style="width:50%!important"><b>Is the Application found in order?</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td ><g:if test="${formRemkInstance?.orderChk == "true"}">
                Yes
               </g:if>
               <g:if test="${formRemkInstance?.orderChk == "false"}">
                No. Need additional information</g:if> </td>
              
              <td class="remark" colspan="4">${formRemkInstance?.orderRemark}</td>
            </tr>
            <tr>
              <td><b>17</b></td>
              <td style="width:50%!important"><b>Objective for seeking NBA's approval</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td >${formDetails?.briefDescription}</td>
              
              <td class="remark" colspan="4">${formRemkInstance?.nbaApprovalRmk}</td>
            </tr>
            <tr>
              <td><b>18</b></td>
              <td><b>Is there any violation of Provision of BD Act on Initial Scrutiny</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td ><g:if test="${formRemkInstance?.violationChk == true}">
                Yes
               </g:if>
               <g:if test="${formRemkInstance?.violationChk == false}">
                No</g:if> </td>
              
              <td class="remark" colspan="4">${formRemkInstance?.violationRemark}</td>
            </tr>
            <g:if test="${formRemkInstance?.violationChk == true}">
              <tr>
              <td></td>
              <td><b></b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td ><span>Selected sections</span>
              ${formRemkInstance?.violationSelect}
               </td>
              <td class="remark" colspan="2">${formRemkInstance?.violationRemark}</td>
              <td class=""></td>
            </tr>
            </g:if>
            <tr>
              <td><b>19</b></td>
              <td><b>Additional questionnaires by NBA</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td class="remark">${formRemkInstance?.additional}</td>
              
              <td>${formRemkInstance?.additionalReview}</td>
            </tr>
			<tr>
			 <td><b>20</b></td>
             
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="2">${formRemkInstance?.question}</td>
			  <td></td>
			  </tr>
    <g:if test="${formRemkInstance != null || formRemkInstance != ''}">

  <g:each in="${formRemkInstance?.questionAnswers}" var="quesAnswer" status="k">
<tr>
<td>${k+21}</td>
<td class="remark"  colspan="2">${quesAnswer?.question}</td>
<td><b>:</b></td>
<td class="remark" colspan="2">${quesAnswer?.answer}</td>
</tr>
</g:each>

</g:if>

</table>
</body>
</html>