<%@ page contentType="text/html;charset=UTF-8" %>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">--%>
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
			 Form IV
		</h2>
</div>
<div align="center"> <span class="text-center">(See Rule 19 of Biological
								Diversity Rules, 2004)<br /> Application form for third party
								transfer of the accessed biological resources and associated
								traditional knowledge.
			</span> </div>
			
			<div style="margin-top: 20px">
 Submitted On: ${formDetails?.submittedOn}<span style="padding: 20px;"><b>Checklist Type : Legal</b></span>
 <span>Application Number:	${formDetails?.appNumber}</span>

</div>
<hr />

 <table style="margin-top: 25px">
 <thead> 
            <tr class="header">
              <th>S.No</th>
              <th>Title</th>
              <th></th>
              <th>Details</th>
              <th colspan="4">Remarks</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td><b>1</b></td>
              <td><b>Online Application number</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="3">${formDetails?.appNumber}</td>
              
              <td class="remark">${formRemkInstance?.onlineAppNumberRmk}</td>
            </tr>
            <tr>
              <td><b>2</b></td>
              <td style="width:50%!important"><b>NBA Reference number</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="3"  class="remark">${formRemkInstance?.nbaRefNumber}</td>
              
              <td class="remark">${formRemkInstance?.nbaRefNumberRemark}</td>
            </tr>
             <tr>
              <td><b>3</b></td>
              <td style="width:50%!important"><b>Applicant category</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="3"><g:if
				test="${formDetails?.individualProfiles}">Individual</g:if> <g:elseif
				test="${formDetails?.companyProfiles}">Company</g:elseif></td>
              
              <td class="remark">${formRemkInstance?.applicantCatgRmk}</td>
            </tr>
            <tr>
              <td><b>4</b></td>
              <td style="width:50%!important"><b>Name of the applicant and contact details</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="3"><g:if
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
              
              <td class="remark">${formRemkInstance?.applicantNameContRmk}</td>
            </tr>
            <tr>
              <td><b>5</b></td>
              <td style="width:50%!important"><b>Name and Address of the contact person/ authorized person of the company</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="3"> 
             <g:if test="${formDetails?.companyProfiles}">
			<g:each in="${formDetails?.companyProfiles}" var="company">
			${company?.title} ${company?.firstName} ${company?.middleName} ${company?.lastName}<br/>
			<b>Mobile :</b> ${company?.personMobile} <br />
		<b>Email Id :</b> ${company?.personEmail}
			</g:each>
			</g:if>
			<g:else>NA</g:else></td>
              
              <td class="remark">${formRemkInstance?.authPersonContRmk}</td>
            </tr>
            <tr>
              <td><b>6</b></td>
              <td style="width:50%!important"><b>Name and address of the contact person/ agent/ attorney, in India</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="3">
              
            <g:if test="${formDetails?.agentProfile}">
			${formDetails?.agentProfile?.title} ${formDetails?.agentProfile?.firstName}
			${formDetails?.agentProfile?.middleName} ${formDetails?.agentProfile?.lastName}<br/>
			${formDetails?.agentProfile?.address1} ${formDetails?.agentProfile?.address2}
			${formDetails?.agentProfile?.address3}<br/> ${formDetails?.agentProfile?.city}
			</g:if>
			<g:else>No</g:else>
			</td>
              
              <td class="remark">${formRemkInstance?.attorneyInIndiaContRmk}</td>
            </tr>
            <tr>
              <td><b>7</b></td>
              <td style="width:50%!important"><b>Category of Application Form</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="3">Form IV</td>
              
              <td class="remark">${formRemkInstance?.appFormCatgRmk}</td>
            </tr>
            <tr>
              <td><b>8</b></td>
              <td style="width:50%!important"><b>Is the applicant falls u/s 3(2)</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
             		<g:if test="${formRemkInstance?.threeTwocheck == '' || formRemkInstance?.threeTwocheck == null }">
		     <td colspan="3">Not Selected</td></g:if>
		<g:if test="${formRemkInstance?.threeTwocheck == false }">
		<td colspan="3"> No</td></g:if>
				<g:if test="${formRemkInstance?.threeTwocheck == true}">
				<td colspan="3">Yes</td></g:if>
              
              <td class="remark">${formRemkInstance?.threeTwoRemark}</td>
            </tr>
            
             <tr>
              <td><b>9</b></td>
              <td style="width:50%!important"><b>Is the applicant falls u/s 7</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
            	
		<g:if test="${formRemkInstance?.sevncheck == '' || formRemkInstance?.sevncheck == null }">
		<td colspan="3">Not Selected</td>
		</g:if>
				
		<g:if test="${formRemkInstance?.sevncheck == false }">
		<td colspan="3">No</td></g:if>
				
			<g:if test="${formRemkInstance?.sevncheck == true}">
				<td colspan="3">Yes</td></g:if>
		
		<td class="remark">${formRemkInstance?.sevnRemark}</td>
            </tr>
            <tr>
              <td><b>10</b></td>
              <td style="width:50%!important"><b>Is Authorization letter/Board Resolution/POA found in order</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
             		<g:if test="${formRemkInstance?.letterBoardChk == '' || formRemkInstance?.letterBoardChk == null}">
		<td colspan="3">Not Selected</td></g:if>
		 
		 <g:if test="${formRemkInstance?.letterBoardChk == "true"}">
		<td colspan="3">Yes</td></g:if>
		 
		 <g:if test="${formRemkInstance?.letterBoardChk == "false"}">
		<td colspan="3">No</td>
		 </g:if>
		 
		 <g:if test="${formRemkInstance?.letterBoardChk == "notAvailable"}">
		<td colspan="3">N/A</td>
		 </g:if>
		 
		
		<td class="remark">${formRemkInstance?.letterBoardRemark}</td>
            </tr>
            <tr>
              <td><b>11</b></td>
              <td style="width:50%!important"><b>Is MoU/AoA/LoIetc, found in order</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
  		<g:if test="${formRemkInstance?.holdingPatternChk == '' || formRemkInstance?.holdingPatternChk == null }">
		<td colspan="3">Not Selected</td></g:if>
		 
		 <g:if test="${formRemkInstance?.holdingPatternChk == "true" }">
		<td colspan="3">Yes</td></g:if>
		 
		 <g:if test="${formRemkInstance?.holdingPatternChk == "false" }">
		<td colspan="3">No</td></g:if>
		 
		 <g:if test="${formRemkInstance?.holdingPatternChk == "notAvailable" }">
		<td colspan="3">N/A</td>
		 </g:if>
		 
		
		<td class="remark">${formRemkInstance?.holdingPatternRemark}</td>

            </tr>
      <tr>
              <td><b>12</b></td>
              <td style="width:50%!important"><b>Has the Applicant taken prior approval of NBA under Section
                3 of the BD Act?</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
         <g:if test="${formRemkInstance?.priorApprovalOfNBA == '' || formRemkInstance?.priorApprovalOfNBA == null}">
		<td colspan="3">Not Selected</td>
		 </g:if>
		 
		 <g:if test="${formRemkInstance?.priorApprovalOfNBA == "true"}">
		<td colspan="3">Yes</td>
		 </g:if>
		 
		 <g:if test="${formRemkInstance?.priorApprovalOfNBA == "false"}">
		<td colspan="3">No</td>
		 </g:if>
		 
		 <g:if test="${formRemkInstance?.priorApprovalOfNBA == "notAvailable"}">
		<td colspan="3">N/A</td>
		 </g:if>
              
              <td class="remark">${formRemkInstance?.priorApprovalOfNBARmk}</td>

            </tr>
            <tr>
              <td><b>13</b></td>
              <td style="width:50%!important"><b>Intended purpose for transfer of biological resources and/or
                associated knowledge</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="3"></td>
              
              <td class="remark">${formRemkInstance?.purposeForTransBioResRmk}</td>
            </tr>
            <tr>
              <td><b>14</b></td>
              <td style="width:50%!important"><b>Proposed date of transfer of biological resources and/or
                associated knowledge</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="3">${formDetails?.thirdPartyTransferPurpose}</td>
              
              <td class="remark">${formRemkInstance?.dateOfTransBioResRmk}</td>
            </tr>
            <tr>
              <td><b>15</b></td>
              <td style="width:50%!important"><b>Is there any legal issue in the MOU/agreement to transfer the
                biological resources?</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
  		<g:if test="${formRemkInstance?.twoDChk == '' || formRemkInstance?.twoDChk == null }">
		<td colspan="3">Not Selected</td>
		</g:if>
			
			<g:if test="${formRemkInstance?.twoDChk == true}">
		     <td colspan="3">Yes</td>
			</g:if>
			
			<g:if test="${formRemkInstance?.twoDChk == false}">
		<td colspan="3">No. Need additional information </td></g:if>
			
			
		
		<td class="remark">${formRemkInstance?.twoDRemark}</td>
            </tr>       
          <tr>
              <td><b>16</b></td>
              <td style="width:50%!important"><b>Is all the information required for legal vetting available?</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
 
 
       <g:if test="${formRemkInstance?.vettingChk == '' || formRemkInstance?.vettingChk == null}">
		<td colspan="3"></td>
		</g:if>
		
		<g:if test="${formRemkInstance?.vettingChk == "true"}">
		<td colspan="3">Yes</td>
		</g:if>
		
		<g:if test="${formRemkInstance?.vettingChk == "false"}">
		<td colspan="3">No. Need additional information</td>
		</g:if>
		
		
		
		<td class="remark">${formRemkInstance?.vettingRemark}</td>
            </tr>
            <tr>
              <td><b>17</b></td>
              <td style="width:50%!important"><b>Is the Application found in order?</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
            <g:if test="${formRemkInstance?.orderChk == '' || formRemkInstance?.orderChk == null}">
		<td colspan="3">Not Selected</td></g:if>
		
		<g:if test="${formRemkInstance?.orderChk == "true"}">
		<td colspan="3">Yes</td></g:if>
		
		<g:if test="${formRemkInstance?.orderChk == "false"}">
		<td colspan="3">No. Need additional information</td></g:if>
	
		
		<td class="remark">${formRemkInstance?.orderRemark}</td>
            </tr>
            <tr>
              <td><b>18</b></td>
              <td style="width:50%!important"><b>Special observation about the Application, if any</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="3">${formRemkInstance?.splObservation}</td>
              <td class=""></td>
              <td class=""></td>
            </tr>  
           <tr>
              <td><b>19</b></td>
              <td colspan="7"><b>Full particular of the third party to whom the accessed material/knowledge is intended to be transferred</b></td>
            </tr>
            <tr>
              <td></td>
              <td colspan="7">
			  <table class="table table-bordered">
                  <tr>
                    <td><b>S. no</b></td>
                    <td><b>Name</b></td>
                    <td><b>Complete Address</b></td>
                    <td><b>Remarks</b></td>
                  </tr>
                  <g:if test="${formDetails?.thirdParty}">
                <g:each in="${formDetails?.thirdParty}" var="thirdParty" status="i">
                 <tr>
                    <td>${i+1}</td>
                    <td>${thirdParty?.name?.toString()?.replaceAll("\\<.*?>","")}</td>
                    <td>${thirdParty?.addressForComm?.toString()?.replaceAll("\\<.*?>","")}${thirdParty?.state?.toString()?.replaceAll("\\<.*?>","")}
                   Pin- ${thirdParty?.pincode}, Country-${thirdParty?.country},Phone-${thirdParty?.phone}
                   E-mail- ${thirdParty?.email},Website-${thirdParty?.website}
                    </td>
                    <td></td>
                  </tr>
                </g:each>  
                </g:if>
                 
                </table></td>
            </tr> 
         <tr>
              <td><b>20</b></td>
              <td style="width:50%!important"><b>Is there any violation of Provision of BD Act?</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
      <g:if test="${formRemkInstance?.violationChk == '' || formRemkInstance?.violationChk == null }">
		<td colspan="3">Not Selected</td></g:if>
			
			<g:if test="${formRemkInstance?.violationChk == true}">
		<td colspan="3">Yes
			</td></g:if>
			
			<g:if test="${formRemkInstance?.violationChk == false }">
		<td colspan="3">No</td></g:if>
			
		
		<td class="remark">${formRemkInstance?.violationRemark}</td>
            </tr>
            <tr>
              <td></td>
              <td style="width:50%!important"><b></b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="3"><span>Selected sections</span></td>

		<td>${formRemkInstance?.violationSelect}</td>
            </tr>
			<tr>
			<td><b>21</b></td>
		<td style="width: 50% !important"><b>Additional
				questionnaires by NBA</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td colspan="4"  class="remark">${formRemkInstance?.additional}</td>
		

	</tr>
	 

<g:if test="${formRemkInstance != null || formRemkInstance != ''}">

<g:each in="${formRemkInstance?.questionAnswers}" var="quesAnswer" status="k">
<tr  class="remark">
<td><b>${k+22}</b></td>
<td>${quesAnswer?.question}</td>
<td><b>:</b></td>
<td colspan="4">${quesAnswer?.answer}</td>
</tr>
</g:each>

</g:if>   
            
</tbody>
</table>

</body>
</html>