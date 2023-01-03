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
			 Form IV
		</h2>
</div>
<div align="center"> <span class="text-center">(See Rule 19 of Biological
								Diversity Rules, 2004)<br /> Application form for third party
								transfer of the accessed biological resources and associated
								traditional knowledge.
			</span> </div>
			
			<div style="margin-top: 20px">
 Submitted On: ${formDetails?.submittedOn}<span style="padding: 20px;"><b>Checklist Type : Technical</b></span>
 <span >Application Number:	${formDetails?.appNumber}</span>
 
</div>
<hr />

<table style="margin-top:25px">
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
		<td class="remark" colspan="2">${formRemkInstance?.onlineAppNumberRmk}</td>
	</tr>
	<tr>
		<td><b>2</b></td>
		<td style="width: 35%!important"><b>NBA Reference number</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="remark">${formRemkInstance?.nbaRefNumber}</td>
		<td class="remark" colspan="2">${formRemkInstance?.nbaRefNumberRemark}</td>
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
		<td class="remark" colspan="2">${formRemkInstance?.applicantCatgRmk}</td>
	</tr>
	<tr>
		<td><b>4</b></td>
		<td style="width: 35%!important"><b>Name of the applicant
				and contact details</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">
			<g:if test="${formDetails?.individualProfiles}">
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
		<td class="remark" colspan="2">${formRemkInstance?.applicantNameContRmk}</td>
	</tr>
	<tr>
		<td><b>5</b></td>
		<td style="width: 35%!important"><b>Name and Address of the
				contact person/ authorized person of the company</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">
		<g:if test="${formDetails?.agentProfile}">
			${formDetails?.agentProfile?.title} ${formDetails?.agentProfile?.firstName}
			${formDetails?.agentProfile?.middleName} ${formDetails?.agentProfile?.lastName}
			${formDetails?.agentProfile?.address1} ${formDetails?.agentProfile?.address2}
			${formDetails?.agentProfile?.address3} ${formDetails?.agentProfile?.city}
			</g:if>
			<g:elseif test="${formDetails?.companyProfiles}">
			<g:each in="${formDetails?.companyProfiles}" var="company">
			${company?.title} ${company?.firstName} ${company?.middleName} ${company?.lastName}<br/>
			<b>Mobile :</b> ${company?.personMobile} <br />
		<b>Email Id :</b> ${company?.personEmail}
			</g:each>
			</g:elseif>
			<g:else>No</g:else>
	 
		
		</td>
		<td  class="remark" colspan="2">${formRemkInstance?.authPersonContRmk}</td>
	</tr>
	<tr>
		<td><b>6</b></td>
		<td style="width: 35%!important"><b>Name and address of the
				contact person/ agent/ attorney, in India</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">
		   <g:if test="${formDetails?.agentProfile}">
		${formDetails?.agentProfile?.title} ${formDetails?.agentProfile?.firstName}
			${formDetails?.agentProfile?.middleName} ${formDetails?.agentProfile?.lastName}
			${formDetails?.agentProfile?.address1} ${formDetails?.agentProfile?.address2}
			${formDetails?.agentProfile?.address3} ${formDetails?.agentProfile?.city}
		
		</g:if>
		<g:else>
		No
		</g:else></td>
		<td class="remark" colspan="2">${formRemkInstance?.attorneyInIndiaContRmk }</td>
	</tr>
	<tr>
		<td><b>7</b></td>
		<td style="width: 35%!important"><b>Category of Application
				Form</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">
			FormIV
		</td>
		<td class="remark" colspan="2">${formRemkInstance?.appFormCatgRmk}</td>
	</tr>
	<tr>
		<td><b>8</b></td>
		<td style="width: 35%!important"><b>Whether Address Proof
				and ID proof matching with the details mentioned above </b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		
		<g:if test="${formRemkInstance?.idAndAddress == '' || formRemkInstance?.idAndAddress == null}">
		<td class="colspan">NA</td>
			</g:if>	
			<g:elseif test="${formRemkInstance?.idAndAddress == true }">
				<td class="colspan">Yes</td>
			</g:elseif>
			
			<g:elseif test="${formRemkInstance?.idAndAddress == false }">
                <td class="colspan">No</td>    
			</g:elseif>
			
		<td class="remark" colspan="2">${formRemkInstance?.idAndAddressRemark}</td>
	</tr>
	<tr>
		<td><b>9</b></td>
		<td style="width: 35%!important"><b>Whether Address Proof
				and ID proof matching with the details mentioned at S.No. 2 &amp; 3</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
			<g:if test="${formRemkInstance?.serialNo == '' || formRemkInstance?.serialNo == null}">
			<td class="colspan">NA</td>
		</g:if>
		<g:elseif test="${formRemkInstance?.serialNo == true}">
	<td class="colspan">Yes</td>
		</g:elseif>
		<g:elseif test="${formRemkInstance?.serialNo == false}">
	<td class="colspan">Yes</td>
		</g:elseif>
		
<%--		<td class="">If No, please give your comments</td>--%>
		<td class="remark" colspan="2">${formRemkInstance?.serialNumRemk}</td>
	</tr>
	<tr>
		<td><b>10</b></td>
		<td colspan="5"><b>Details of the biological material and
				traditional knowledge proposed to be transferred</b></td>
	</tr>
	<tr>
		<td></td>
		<td colspan="5"><table class="table table-bordered">
				<tbody><tr>
					<td><b>S. no</b></td>
					<td><b>Intend to be transferred</b></td>
					<td><b>Common name</b></td>
					<td><b>Scientific name</b></td>
					<td><b>Nature of biological resources</b></td>
					<td><b>Part of Biological resources</b></td>
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
							<td class="remark">${formRemkInstance?.biologicalResRmk}</td>
						</g:each>
					</tr>
				</g:if>
				
			</tbody></table></td>
	</tr>
	<tr>
		<td><b>11</b></td>
		<td><b>Details of the access
				contract entered (copy enclosed)</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan"></td>
		<td colspan="2"></td>
		
	</tr>
	<tr>
		<td><b>11 a)</b></td>
		<td style="width: 35%!important"><b>Attached copy of
				approval of NBA(agreement) </b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
				<g:if test="${formRemkInstance?.attachedCopyCheck == '' || formRemkInstance?.attachedCopyCheck == null}">
	<td class="colspan"> NA</td>
		</g:if>
		<g:elseif test="${formRemkInstance?.attachedCopyCheck == true}">
	<td class="colspan">Yes</td>
		</g:elseif>
		<g:elseif test="${formRemkInstance?.attachedCopyCheck == false }">
	<td class="colspan">No</td>
		</g:elseif>
		<td class="remark" colspan="2">${formRemkInstance?.attachedCopy}</td>
	</tr>
	<tr>
		<td><b>11 b)</b></td>
		<td><b>Application No. and Date
				of Approval</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan=">${formDetails?.appNumber} - <g:formatDate format="dd/MM/yyyy" date="${formDetails?.dateOfApproval}"/></td>
		<td class="remark" colspan="2">${formRemkInstance?.dateOfApprovl}</td>
	</tr>
	<tr>
		<td><b>12</b></td>
		<td><b>Details of the benefits
				and mechanism/ arrangements for benefit sharing already implemented</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">${formDetails?.isbenefitSharingDetailImplemented}<br />
		
		${formDetails?.benefitMechanism}</td>
		<td class="remark" colspan="2">${formRemkInstance?.benefitSharingAld}</td>
	</tr>
	<tr>
		<td><b>13</b></td>
		<td colspan="5"><b>Full particulars of the third party to
				whom the accessed material / knowledge is intended to be transferred</b></td>
	</tr>
	<tr>
		<td></td>
		<td colspan="5"><table class="table table-bordered" style="width: 100%">
				<thead>
				<tr>
					<td><b>S. no</b></td>
					<td><b>Name </b></td>
					<td><b>Complete Address </b></td>
					<td><b>Remarks</b></td>
				</tr>
				</thead>
				<tbody>
				<g:if test="${formDetails?.thirdParty}">
				<g:each in="${formDetails?.thirdParty}" var="thirdParty" status="q">
				<tr>
				<td>${q+1 }</td>
					<td>${thirdParty?.name}</td>

					<td>
					${thirdParty?.addressForComm}
					State:${thirdParty?.state} <br />Pin: ${pincode}
					Country:${thirdParty?.country}<br /> Phone:${thirdParty?.phone}
					Fax:${thirdParty?.fax} Website:${thirdParty?.website}<br />
					${thirdParty?.email}
					</td>
					<td class="remark">${formRemkInstance?.thirdParty}</td>
				</tr>			
				</g:each>
				</g:if>
				
			</tbody></table></td>
	</tr>
	<tr>
		<td><b>14</b></td>
		<td><b>The purpose of the
				intended third party transfer</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td>${formDetails?.thirdPartyTransferPurpose}</td>
		<td class="remark" colspan="2">${formRemkInstance?.thirdPartyTransfer}</td>
	</tr>
	<tr>
		<td><b>15</b></td>
		<td><b>Details of economic,
				social, biotechnological, scientific or any other benefits that are
				intended, or may accrue to the third party due to transfer of
				accessed biological material and knowledge</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">${formDetails?.benefitsToTheThirdParty}</td>
		
		<td class="remark" colspan="2">${formRemkInstance?.detailsOfEconomic}</td>
	</tr>
	<tr>
		<td><b>16</b></td>
		<td><b>Details of any agreement
				to be entered between the applicant and the third party</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">
		<g:if test="${formDetails?.isAgreementBwApplicantAndThirdParty== 'true'}">Yes</g:if>
		<g:elseif test="${formDetails?.isAgreementBwApplicantAndThirdParty== 'false'}">No</g:elseif>
		</td>
		<td class="remark" colspan="2">${formRemkInstance?.detailsAnyAgreement }</td>
	</tr>
	<tr>
		<td><b>16 a)</b></td>
		<td style="width: 35%!important"><b>Agreement entered
				between the applicant and the third party</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td>
		<g:if test="${formDetails?.isAgreementBwApplicantAndThirdParty == 'true'}">Yes</g:if>
		<g:elseif test="${formDetails?.isAgreementBwApplicantAndThirdParty == 'false'}">No</g:elseif>
       </td>
<%--			<g:if test="${formRemkInstance?.agreementCheck == '' || formRemkInstance?.agreementCheck == null}">--%>
<%--	     <td class="colspan"> NA</td>--%>
<%--		</g:if>--%>
<%--		<g:elseif test="${formRemkInstance?.agreementCheck == true}">--%>
<%--	     <td class="colspan">Yes</td>--%>
<%--		</g:elseif>--%>
<%--		--%>
<%--		<g:elseif test="${formRemkInstance?.agreementCheck == false}">--%>
<%--     	<td class="colspan">No</td>--%>
<%--		</g:elseif>--%>
<%--		<td class="">Remarks</td>--%>
		<td class="remark" colspan="2">${formRemkInstance?.agreement}</td>
	</tr>
	<tr>
		<td><b>17</b></td>
		<td><b>Estimation of benefits
				that would flow to India/communities arising out of the third party
				transfer of accessed biological resources and traditional knowledge</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">${formDetails?.benefitsOutOfThirdPartyTransfer}</td>
		<td colspan="2"></td>
		
	</tr>
	<tr>
		<td><b>18</b></td>
		<td><b>Proposed mechanism and
				arrangements for benefit sharing arising out of the proposed third
				party transfer</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">${formDetails?.mechanismOutOfThirdPartyTransfer}</td>
		<td  class="remark" colspan="2">${formRemkInstance?.proposedMechanism}</td>
	</tr>
	<tr>
		<td><b>19</b></td>
		<td style="width: 35%!important"><b>Any other relevant
				information</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">${formDetails?.otherRelevantInfo}</td>
		<td  class="remark" colspan="2">${formRemkInstance?.anyOther}</td>
	</tr>
	<tr>
		<td><b>20</b></td>
		<td><b>Question</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td colspan="2">${formRemkInstance?.question}</td>

<td>
</td>
	</tr>
<g:if test="${formRemkInstance != null || formRemkInstance != ''}">

<g:each in="${formRemkInstance?.questionAnswers}" var="quesAnswer" status="k">
<tr class="remark">
<td>${k+21}</td>
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