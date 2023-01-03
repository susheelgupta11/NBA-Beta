<g:if test="${formRemkInstance?.serialNo == false}">
<g:javascript>
$(document).ready(function() {showSerialBox();});	
</g:javascript>
</g:if>

<table class="table table-bordered customtable" id="tbl_posts">
<thead>
	<tr class="header">
		<th>S.No</th>
		<th>Title</th>
		<th></th>
		<th>Details</th>
		<th colspan="2">Remarks</th>
		
	</tr>
	</thead>
	<tbody id="tbl_posts_body">
	<tr id="rec-1">
		<td><b><span class="sn">1</span></b></td>
		<td style="width: 50% !important"><b>Online Application
				number</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">
			${formDetails?.appNumber}
		</td>
		<td colspan="2"><g:textField name="appnumber" class="remark"
				value="${formRemkInstance?.onlineAppNumberRmk}" /></td>
	</tr>
	<tr id="rec-2">
		<td><b><span class="sn">2</span></b></td>
		<td style="width: 50% !important"><b>NBA Reference number</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan"><g:textField name="refNumber" class="remark"
				value="${formRemkInstance?.nbaRefNumber}" /></td>
		<td colspan="2"><g:textField name="nbaRefNumberRemark" class="remark"
				value="${formRemkInstance?.nbaRefNumberRemark}" /></td>
	</tr>
	<tr id="rec-3">
		<td><b><span class="sn">3</span></b></td>
		<td style="width: 50% !important"><b>Applicant category</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan"><g:if
				test="${formDetails?.individualProfiles}">Individual</g:if> <g:elseif
				test="${formDetails?.companyProfiles}">Company</g:elseif> <g:elseif
				test="${formDetails?.indianGovtInst}">Government</g:elseif> <g:elseif
				test="${formDetails?.depostionOfMicroOrganism}"></g:elseif></td>
		<td colspan="2"><g:textField name="appltcatg" class="remark"
				value="${formRemkInstance?.applicantCatgRmk}" /></td>
	</tr>
	<tr>
		<td><b>4</b></td>
		<td style="width: 50% !important"><b>Name of the applicant
				and contact details</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan"><g:if
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
		<td colspan="2"><g:textField name="appltname" class="remark"
				value="${formRemkInstance?.applicantNameContRmk}" /></td>
	</tr>
	<tr>
		<td><b>5</b></td>
		<td style="width: 50% !important"><b>Name and Address of the
				contact person/ authorized person of the company</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">
		<g:if test="${formDetails?.companyProfiles}">
		
		${formDetails?.companyProfiles?.title} 
		${formDetails?.companyProfiles?.firstName} 
		${formDetails?.companyProfiles?.middleName} 
		${formDetails?.companyProfiles?.lastName} 
		Designation:${formDetails?.companyProfiles?.designation} 
		Mobile:${formDetails?.companyProfiles?.personMobile} 
	  Email:${formDetails?.companyProfiles?.personEmail} 
	</g:if>	
	<g:else>No</g:else>	
		</td>
		<td colspan="2"><g:textField name="nameandComp" class="remark"
				value="${formRemkInstance?.authPersonContRmk}" /></td>
	</tr>
	<tr>
		<td><b>6</b></td>
		<td style="width: 50% !important"><b>Name and address of the
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
		</g:else>
		</td>
		<td colspan="2"><g:textField name="agent" class="remark"
				value="${formRemkInstance?.attorneyInIndiaContRmk }" /></td>
	</tr>
	<tr>
		<td><b>7</b></td>
		<td style="width: 50% !important"><b>Category of Application
				Form</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">
			FormIV
		</td>
		<td colspan="2"><g:textField name="formCatg" class="remark"
				value="${formRemkInstance?.appFormCatgRmk}" /></td>
	</tr>
	<tr>
		<td><b>8</b></td>
		<td style="width: 50% !important"><b>Whether Address Proof
				and ID proof matching with the details mentioned above </b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<g:if test="${formRemkInstance?.idAndAddress == '' || formRemkInstance?.idAndAddress == null}">
		<td class="colspan"><g:radio name="whrIdProofMtc" value="true" /> Yes <g:radio name="whrIdProofMtc" value="false" /> No</td>
			</g:if>	
			<g:elseif test="${formRemkInstance?.idAndAddress == true }">
				<td class="colspan"><g:radio name="whrIdProofMtc" value="true" checked="true" /> Yes <g:radio name="whrIdProofMtc" value="false" /> No</td>
			</g:elseif>
			
			<g:elseif test="${formRemkInstance?.idAndAddress == false }">
				<td class="colspan"><g:radio name="whrIdProofMtc" value="true"  /> Yes <g:radio name="whrIdProofMtc" value="false" checked="true"/> No</td>
			</g:elseif>
				
		
		<td colspan="2"><g:textField name="whrIdProof" class="remark"
				value="${formRemkInstance?.idAndAddressRemark}" /></td>
	</tr>
	<tr>
		<td><b>9</b></td>
		<td style="width: 50% !important"><b>Whether Address Proof
				and ID proof matching with the details mentioned at S.No. 2 & 3</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<g:if test="${formRemkInstance?.serialNo == '' || formRemkInstance?.serialNo == null}">
			<td class="colspan"><g:radio name="serialNo" onclick="hideSerialBox()" value="true"/>Yes<g:radio onclick="showSerialBox()" name="serialNo" value="false" />No</td>
		</g:if>
		<g:elseif test="${formRemkInstance?.serialNo == true}">
	<td class="colspan"><g:radio name="serialNo" onclick="hideSerialBox()" value="true" checked="true"/>Yes<g:radio onclick="showSerialBox()" name="serialNo" value="false" />No</td>
		</g:elseif>
		<g:elseif test="${formRemkInstance?.serialNo == false}">
	<td class="colspan"><g:radio name="serialNo" onclick="hideSerialBox()" value="true"/>Yes<g:radio onclick="showSerialBox()" name="serialNo" value="false" checked="true"/>No</td>
		</g:elseif>
		
<%--		<td class="">If No, please give your comments</td>--%>
		<td colspan="2"><g:textArea name="serialNumRemk" class="remark" id="serialRemk" style="display: none;" value="${formRemkInstance?.serialNumRemk}"/></td>
	</tr>
	<tr>
		<td><b>10</b></td>
		<td colspan="5"><b>Details of the biological material and
				traditional knowledge proposed to be transferred</b>
				<table class="table table-bordered">
	<tr>
					<td><b>S. no</b></td>
					<td><b>Intend to be transferred</b></td>
					<td><b>Common name</b></td>
					<td><b>Scientific name</b></td>
					<td><b>Nature of biological resources</b></td>
					<td><b>Part of Biological resources</b></td>
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
			
				<g:elseif test="${formDetails?.biologicalResources}">
					
						<g:each in="${formDetails?.biologicalResources}" var="resource"
							status="i">
							<tr>
                            <td>
								${i+1}
							</td>
							<td>
							<g:hiddenField name="chkname" value="${resource?.accessIntention?:'NA'}" />
							${resource?.accessIntention?:'NA'}	
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
						
							<td><g:textField name="resremk" class="remark"
									value="${formRemkInstance?.biologicalResRmk}" />
							</td>
							</tr>
						</g:each>
				
				</g:elseif>
			</table></td>
	</tr>
	<tr>
		<td><b>11</b></td>
		<td colspan="5"><b>Details of the access
				contract entered (copy enclosed)</b>
                
        <table class="table table-bordered">
				<tr>
					<td><b>S. no</b></td>
                    <td colspan="4"></td>
				</tr>
				
	
	
	<tr>
		<td style="width:8%"><b>11 (a)</b></td>
		<td style="width:30%"><b>Attached copy of
				approval of NBA(agreement) </b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<g:if test="${formRemkInstance?.attachedCopyCheck == '' || formRemkInstance?.attachedCopyCheck == null}">
	<td><g:radio name="attachedCopyCheck" value="true" />Yes<g:radio name="attachedCopyCheck" value="false"/> No</td>
		</g:if>
		<g:elseif test="${formRemkInstance?.attachedCopyCheck == true}">
	<td><g:radio name="attachedCopyCheck" checked="true" value="true" />Yes<g:radio name="attachedCopyCheck" value="false"/> No</td>
		</g:elseif>
		<g:elseif test="${formRemkInstance?.attachedCopyCheck == false }">
	<td><g:radio name="attachedCopyCheck" value="true" />Yes<g:radio name="attachedCopyCheck"  checked="true" value="false"/> No</td>
		</g:elseif>
	
		<td colspan="2"><g:textField name="attachedCopy" class="remark"
				value="${formRemkInstance?.attachedCopy}" /></td>
	</tr>
	<tr>
		<td style="width:8%"><b>11 (b)</b></td>
		<td style="width:30%"><b>Application No. and Date
				of Approval</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td style="width:35%; text-align:justify">${formDetails?.appNumber} & 
		
		<g:formatDate format="dd/MM/yyyy" date="${formDetails?.dateOfApproval}"/>
		</td>
		<td colspan="2"><g:textField name="dateOfApprovl" class="remark"
				value="${formRemkInstance?.dateOfApprovl}" /></td>
	</tr>
    </table></td>
   </tr>
	<tr>
		<td><b>12</b></td>
		<td style="width: 50% !important"><b>Details of the benefits
				and mechanism/ arrangements for benefit sharing already implemented</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">
		${formDetails?.isbenefitSharingDetailImplemented}<br />
		
		${formDetails?.benefitMechanism}</td>
		<td colspan="2"><g:textField name="benefitSharingAld" class="remark"
				value="${formRemkInstance?.benefitSharingAld}" /></td>
	</tr>
	<tr>
		<td><b>13</b></td>
		<td colspan="5"><b>Full particulars of the third party to
				whom the accessed material / knowledge is intended to be transferred</b><table class="table table-bordered">
				<tr>
					<td><b>S. no</b></td>
					<td><b>Name </b></td>
					<td><b>Complete Address </b></td>
					<td><b>Remarks</b></td>
				</tr>
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
					<td><g:textField name="thirdParty" class="remark"
							value="${formRemkInstance?.thirdParty}" /></td>
				</tr>			
				</g:each>
				</g:if>
				<tr>
			</table></td>
	</tr>
	<tr>
		<td><b>14</b></td>
		<td style="width: 50% !important"><b>The purpose of the
				intended third party transfer</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">${formDetails?.thirdPartyTransferPurpose}</td>
		<td colspan="2"><g:textField name="thirdPartyTransfer" class="remark"
				value="${formRemkInstance?.thirdPartyTransfer}" /></td>
	</tr>
	<tr>
		<td><b>15</b></td>
		<td style="width: 50% !important"><b>Details of economic,
				social, biotechnological, scientific or any other benefits that are
				intended, or may accrue to the third party due to transfer of
				accessed biological material and knowledge</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">${formDetails?.benefitsToTheThirdParty}</td>
		<td colspan="2"><g:textField name="detailsOfEconomic" class="remark"
				value="${formRemkInstance?.detailsOfEconomic}" /></td>
	</tr>
	<tr>
		<td><b>16</b></td>
		<td colspan="5">
        <table class="table table-bordered">
				
	<tr>
		<td><b>(a)</b></td>
		<td style="width: 44% !important"><b>Details of any agreement
				to be entered between the applicant and the third party</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td style="width: 25% !important">
		<g:if test="${formDetails?.isAgreementBwApplicantAndThirdParty== 'true'}">
		Yes
		</g:if>
		<g:elseif test="${formDetails?.isAgreementBwApplicantAndThirdParty== 'false'}">
		No
		</g:elseif>
		</td>
		
		<td colspan="2"><g:textField name="detailsAnyAgreement" class="remark"
				value="${formRemkInstance?.detailsAnyAgreement}" /></td>
	</tr>
	<tr>
		<td><b>(b)</b></td>
		<td style="width: 44% !important"><b>Agreement entered
				between the applicant and the third party</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		
		<td style="width: 25% !important">
		
		<g:if test="${formDetails?.isAgreementBwApplicantAndThirdParty == 'true'}">Yes</g:if>
		<g:elseif test="${formDetails?.isAgreementBwApplicantAndThirdParty == 'false'}">No</g:elseif>
		</td>
		
<%--		<g:if test="${formRemkInstance?.agreementCheck == '' || formRemkInstance?.agreementCheck == null}">--%>
<%--	<td class="colspan"><g:radio name="agreementCheck" value="true" /> Yes <g:radio name="agreementCheck" value="false"/> No</td>--%>
<%--		</g:if>--%>
<%--		<g:elseif test="${formRemkInstance?.agreementCheck == true}">--%>
<%--	<td class="colspan"><g:radio name="agreementCheck" value="true" checked="checked" /> Yes <g:radio name="agreementCheck" value="false"/> No</td>--%>
<%--		--%>
<%--		</g:elseif>--%>
<%--		--%>
<%--		<g:elseif test="${formRemkInstance?.agreementCheck == false}">--%>
<%--	<td class="colspan"><g:radio name="agreementCheck" value="true" /> Yes <g:radio name="agreementCheck" checked="checked" value="false"/> No</td>--%>
<%--		--%>
<%--		</g:elseif>--%>
			
		
		<td colspan="2"><g:textField name="agreement" class="remark"
				value="${formRemkInstance?.agreement}" /></td>
	</tr>
	</table></td>
	</tr>
	<tr>
		<td><b>17</b></td>
		<td style="width: 50% !important"><b>Estimation of benefits
				that would flow to India/communities arising out of the third party
				transfer of accessed biological resources and traditional knowledge</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">${formDetails?.benefitsOutOfThirdPartyTransfer}</td>
		<td colspan="2"></td>
	
	</tr>
	<tr>
		<td><b>18</b></td>
		<td style="width: 50% !important"><b>Proposed mechanism and
				arrangements for benefit sharing arising out of the proposed third
				party transfer</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">${formDetails?.mechanismOutOfThirdPartyTransfer}</td>
		
		<td colspan="2"><g:textField name="proposedMechanism" class="remark"
				value="${formRemkInstance?.proposedMechanism}" /></td>
	</tr>
	<tr>
		<td><b>19</b></td>
		<td style="width: 50% !important"><b>Any other relevant
				information</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">${formDetails?.otherRelevantInfo }</td>
		<td colspan="2"><g:textField name="anyOther" class="remark"
				value="${formRemkInstance?.anyOther}" /></td>
	</tr>
	<tr>
		<td><b>20</b></td>
		<td><b>Question</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td  colspan="2"><g:textArea style="width: 100%;  display:none;"
				class="form-control" name="ques"
				value="${formRemkInstance?.question}" /></td>
				<g:if test="${formRemkInstance == null || formRemkInstance == ''}">
<%--				<td><input type="button" value="Add Question" id="morQues" name="21" class="btn" onclick="addQuestionTr(this);"/></td>--%>
		<td>
        <a class="btn btn-primary pull-right add-record" data-added="0"><i class="glyphicon glyphicon-plus"></i> Add Questions</a>
      </td>
		</g:if>
		 <g:else><td></td></g:else>
	</tr>
	<g:if test="${formRemkInstance != null || formRemkInstance != ''}">
<g:each in="${formRemkInstance?.questionAnswers}" var="quesAnswer" status="k">
<tr id="all${k+1}">
<td><b id="srl${k+1}"><span class="sn">${k+21}</span></b></td>
<td><g:textArea name="quesValues${k+1}" id="qut${k+1}" value="${quesAnswer?.question}" rows="3" cols="40"></g:textArea></td>
<td><b>:</b></td>
<td><g:textArea name="ansValues${k+1}" id="qes${k+1}" value="${quesAnswer?.answer}" rows="3" cols="40"></g:textArea></td>
<td>
<input type="button" onclick="updateQuestion(this);" class="btn btn-success" value="Update" id="upd${k+1}" name="${quesAnswer?.id}"/></td>
<%--<g:remoteLink  controller="checklist" action="deleteQuestion" id="rem${k+1}" params="${[deleteIns:quesAnswer?.id]}"  onSuccess="removeTextBoxes(this);">Remove</g:remoteLink>--%>
<td><input type="button" onclick="deleteQues(this);" value="Remove" id="rem${k+1}" name="${quesAnswer?.id}" class="btn btn-danger"  />
</td>
</tr>
</g:each>
</g:if>
	<tr style="display:none;">
<td>
    <table id="sample_table">
      <tr id="">
       <td><b><span class="sn"></span></b></td>
       <td><g:textArea name="quesValues" class="ques" style="width:100%"></g:textArea> </td>
       <td>:</td>
       <td colspan="2"><g:textArea name="ansValues" class="ans" style="width:100%"></g:textArea></td>
       <td><a class="btn btn-xs delete-record" data-id="0"><span class="btn btn-danger"><i class="fa fa-trash"></i> Remove Row</span></a></td>
     </tr>
   </table>

</td>
</tr>
</tbody>	
</table>

