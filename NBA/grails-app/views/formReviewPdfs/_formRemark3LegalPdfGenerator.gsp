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

<a href="#" target="_blank">
        <img src="https://absefiling.nic.in/NBA/assets/Logo1-9de1c2fa396fb0e8af1ba72ffc12b3dc.jpg" width="700px"  alt="NBA" border="0" style="display: block;" /></a>

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
 Submitted On: ${formDetails?.submittedOn} <span style="padding: 20px;"><b> Checklist Type: Legal</b></span>
 <span >Application Number:	${formDetails?.appNumber}</span>
 
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
             
              <td colspan="4" class="remark" >${formRemkInstance?.onlineAppNumberRmk}</td>
            </tr>
            <tr>
              <td><b>2</b></td>
              <td><b>NBA Reference number</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td  class="remark">${formRemkInstance?.nbaRefNumber}</td>
              
              <td class="remark" colspan="4">${formRemkInstance?.nbaRefNumberRemark}</td>
            </tr>
            <tr>
              <td><b>3</b></td>
              <td><b>Applicant category</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td ><g:if
				test="${formDetails?.individualProfiles}">Individual</g:if> <g:elseif
				test="${formDetails?.companyProfiles}">Company</g:elseif></td>
             
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
              
              <td class="remark" >${formRemkInstance?.applicantNameContRmk}</td>
            </tr>
            <tr>
              <td><b>5</b></td>
              <td><b>Name and Address of the contact person/ authorized person of the company</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td> 
          <g:if test="${formDetails?.companyProfiles}">
			<g:each in="${formDetails?.companyProfiles}" var="company">
			${company?.title} ${company?.firstName} ${company?.middleName} ${company?.lastName}<br/>
			<b>Mobile :</b> ${company?.personMobile} <br />
		<b>Email Id :</b> ${company?.personEmail}
			</g:each>
			</g:if>
			<g:else>No</g:else>
			 </td>
              
              <td class="remark" >${formRemkInstance?.authPersonContRmk}</td>
            </tr>
            <tr>
              <td><b>6</b></td>
              <td><b>Name and address of the contact person/ agent/ attorney, in India</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
             
              <td>
             <g:if test="${formDetails?.agentProfile}">
			${formDetails?.agentProfile?.title} ${formDetails?.agentProfile?.firstName}
			${formDetails?.agentProfile?.middleName} ${formDetails?.agentProfile?.lastName}<br/>
			${formDetails?.agentProfile?.address1} ${formDetails?.agentProfile?.address2}
			${formDetails?.agentProfile?.address3}<br/> ${formDetails?.agentProfile?.city}
			</g:if><g:else>No</g:else>
			</td>
              
              <td class="remark" >${formRemkInstance?.attorneyInIndiaContRmk }</td>
            </tr>
            <tr>
              <td><b>7</b></td>
              <td><b>Category of Application Form</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td >Form III </td>
              
              <td class="remark" >${formRemkInstance?.appFormCatgRmk}</td>
            </tr>
            <tr>
              <td><b>8</b></td>
              <td><b>Is the applicant falls u/s 3(2)</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
		<g:if test="${formRemkInstance?.threeTwocheck == '' || formRemkInstance?.threeTwocheck == null }">
		        <td>Not Selected</td></g:if>
		         <g:if test="${formRemkInstance?.threeTwocheck == false }">
		          <td >No</td></g:if>
				<g:if test="${formRemkInstance?.threeTwocheck == true}">
				<td >Yes</td>
				</g:if>
				
              
              <td class="remark" >${formRemkInstance?.threeTwoRemark}</td>
            </tr>
            <tr>
              <td><b>9</b></td>
              <td><b>Is the applicant falls u/s 7</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              	
		<g:if test="${formRemkInstance?.sevncheck == '' || formRemkInstance?.sevncheck == null }">
		       <td>Not Selected</td></g:if>
				
		   <g:if test="${formRemkInstance?.sevncheck == false }">
		     <td >No</td>
				</g:if>
				
				<g:if test="${formRemkInstance?.sevncheck == true}">
				<td >Yes</td>
				</g:if>
              
              <td class="remark" >${formRemkInstance?.sevnRemark}</td>
            </tr>
            <tr>
              <td><b>10</b></td>
              <td><b>Is Authorization letter/Board Resolution/POA found in order</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
                  		<g:if test="${formRemkInstance?.letterBoardChk == '' || formRemkInstance?.letterBoardChk == null}">
		      <td >Not Selected</td>
		   </g:if>
		 
		 <g:if test="${formRemkInstance?.letterBoardChk == "true"}">
		<td >Yes</td>
		 </g:if>
		 
		 <g:if test="${formRemkInstance?.letterBoardChk == "false"}">
		<td >No</td>
		 </g:if>
		 
		 <g:if test="${formRemkInstance?.letterBoardChk == "notAvailable"}">
		<td >N/A</td>
		 </g:if>
              
              <td class="remark" >${formRemkInstance?.letterBoardRemark}</td>
            </tr>
            <tr>
              <td><b>11</b></td>
              <td><b>Is MoU/AoA/LoI etc, found in order</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
        <g:if test="${formRemkInstance?.holdingPatternChk == '' || formRemkInstance?.holdingPatternChk == null }">
		<td>Not Selected</td>
		 </g:if>
		 
		 <g:if test="${formRemkInstance?.holdingPatternChk == "true" }">
		<td >Yes</td>
		 </g:if>
		 
		 <g:if test="${formRemkInstance?.holdingPatternChk == "false" }">
		<td >No</td>
		 </g:if>
		 
		 <g:if test="${formRemkInstance?.holdingPatternChk == "notAvailable" }">
		<td >N/A</td>
		 </g:if>
		 
		
		<td class="remark" >${formRemkInstance?.holdingPatternRemark}</td>

            </tr>
            <tr>
              <td><b>12</b></td>
              <td><b>Date of filing of Patent Application</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <g:if test="${formDetails?.iprDetails}">
              <td >
              
              <g:each in="${formDetails?.iprDetails}" var="datePatent">
           <g:formatDate format="dd/MM/yyyy" date="${datePatent?.patentApplicationDate}"/>
              </g:each>
              </td>
              </g:if>
              
              <td class="remark" >${formRemkInstance?.patentDateRmk}</td>
            </tr>
            <tr>
              <td><b>13</b></td>
              <td><b>In case the Applicant is a person under section 3(2), has prior approval of NBA been sought
                under Section 3 (Form I) for conducting research?</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td >
               <g:if test= "${formDetails.isApprovalOfNbaObtainedForm3 == 'true'}">
						<span>Yes</span><br/>
						<b>Application No:</b>${formDetails?.applicationNo}<br/>
						<b>Date of Approval:</b>${formDetails?.dateOfApproval?.format('dd/MM/yyyy')}<br/>
						<b>Self attested Copy of the NBA approval / agreement dul</b><g:link controller="form3" action="showDc" id="${formDetails?.id}"
											target="_blank"
											params='[filename: "nbaApprovalFileName", dataName: "nbaApprovalFileName",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
											click for preview
						</g:link>
						
					</g:if>
					<g:else><span>No</span></g:else>
              </td>
              
              <td class="remark" >${formRemkInstance?.priorApprovalOfNBARmk}</td>
            </tr>
            <tr>
              <td><b>14</b></td>
              <td><b>Has patent already been granted for the invention in India and/or abroad?</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              	<g:if test="${formRemkInstance?.patentAlreadyChk == '' || formRemkInstance?.patentAlreadyChk == null }">
		<td ></td></g:if>
		<g:if test="${formRemkInstance?.patentAlreadyChk  == 'needAditionalInfo' }">
		<td >No. Need additional information</td></g:if>
				<g:if test="${formRemkInstance?.patentAlreadyChk  == 'true'}">
				<td >Yes</td>
				</g:if>
             <g:if test="${formRemkInstance?.patentAlreadyChk  == 'false'}">
				<td >No</td>
				</g:if>
              <td  class="remark" >${formRemkInstance?.patentAlreadyRemk}</td>
            </tr>
            <tr>
              <td><b>15</b></td>
              <td><b>Is all the information required for legal vetting available</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
 		<g:if test="${formRemkInstance?.vettingChk == '' || formRemkInstance?.vettingChk == null}">
		<td>Not Selected</td></g:if>
		
		<g:if test="${formRemkInstance?.vettingChk == 'true'}">
		<td >Yes</td>
		</g:if>
		
		<g:if test="${formRemkInstance?.vettingChk == 'false'}">
		<td>No</td>
		</g:if>
		
		<g:if test="${formRemkInstance?.vettingChk == 'needAditionalInfo'}">
		
		<td >Need additional information</td>
		</g:if>
		
		
		<td class="remark" >${formRemkInstance?.vettingRemark}</td>
            </tr>
            <tr>
              <td><b>16</b></td>
              <td><b>Is the Application found in order?</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
        <g:if test="${formRemkInstance?.orderChk == '' || formRemkInstance?.orderChk == null}">
		<td>Not Selected</td></g:if>
		
		<g:if test="${formRemkInstance?.orderChk == 'true'}">
		<td >Yes</td></g:if>
		
		<g:if test="${formRemkInstance?.orderChk == 'false'}">
		<td >No</td></g:if>
		
		<g:if test="${formRemkInstance?.orderChk == 'needAditionalInfo'}">
	
		<td >Need additional information</td></g:if>
	
		
		<td class="remark" >${formRemkInstance?.orderRemark}</td>
            </tr>
            <tr>
              <td><b>17</b></td>
              <td><b>Special observation about the Application, if any</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td >${formRemkInstance?.splObservation}</td>
              <td class="remark" ></td>
              
            </tr>
            <tr>
              <td id="decision"><b>18</b></td>
              <td><b>Is there any violation of Provision of BD Act ?</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
        <g:if test="${formRemkInstance?.violationChk == '' || formRemkInstance?.violationChk == null }">
		<td>Not Selected</td></g:if>
			
			<g:if test="${formRemkInstance?.violationChk == true}">
		<td >Yes</td></g:if>
			
			<g:if test="${formRemkInstance?.violationChk == false }">
		<td >No</td></g:if>
			
		
		<td class="remark" >${formRemkInstance?.violationRemark}</td>
            </tr>
            <tr>
              <td></td>
              <td><b></b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td ><span>Selected sections</span></td>

		<td class="remark" >${formRemkInstance?.violationSelect}</td>
            </tr>
			<tr>
			<td><b>19</b></td>
		<td style="width: 35% !important"><b>Additional
				questionnaires by NBA</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="remark" colspan="2">${formRemkInstance?.additional}</td>
	</tr>

<g:if test="${formRemkInstance != null || formRemkInstance != ''}">

<g:each in="${formRemkInstance?.questionAnswers}" var="quesAnswer" status="k">
<tr>
<td>${k+20}</td>
<td class="remark">${quesAnswer?.question}</td>
<td><b>:</b></td>
<td class="remark" colspan="2">${quesAnswer?.answer}</td>
</tr>
</g:each>

</g:if>
</table>
</body>
</html>