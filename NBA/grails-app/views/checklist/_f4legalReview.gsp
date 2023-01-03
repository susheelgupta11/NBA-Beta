          <table class="table table-bordered customtable"  id="tbl_posts">
          <thead>
            <tr class="header">
              <th>S.No</th>
              <th>Title</th>
              <th></th>
              <th>Details</th>
              <th colspan="4">Remarks</th>
            </tr>
            </thead>
            <tbody id="tbl_posts_body">
			<tr id="rec-1">
		<td><b><span class="sn">1</span></b></td>
              <td style="width:35%!important"><b>Online Application number</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="3">${formDetails?.appNumber}</td>
              
              <td colspan="4"><g:textField class="remark" name="onlineAppNumberRmk" value="${formRemkInstance?.onlineAppNumberRmk}"/></td>
            </tr>
            <tr>
              <td><b>2</b></td>
              <td style="width:35%!important"><b>NBA Reference number</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
           <g:if test="${nbaReferenceNum}">
          <td colspan="3"><g:textField class="remark" name="refNumber" value="${nbaReferenceNum}" /></td>

		</g:if>
		<g:else>
		<td colspan="3"><g:textField class="remark" name="refNumber" value="${formRemkInstance?.nbaRefNumber}" /></td>
		</g:else>              
              <td colspan="4"><g:textField class="remark"  name="nbaRefNumberRemark" value="${formRemkInstance?.nbaRefNumberRemark}"/></td>
            </tr>
            <tr>
              <td><b>3</b></td>
              <td style="width:35%!important"><b>Applicant category</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="3">  	<g:if test="${formDetails?.individualProfiles}">Individual</g:if>
               <g:elseif test="${formDetails?.companyProfiles}">
				<g:each in="${formDetails?.companyProfiles}" var="ct">
				${ct?.entityType }
				</g:each>
				</g:elseif>
				 <g:elseif test="${formDetails?.indianGovtInst}">Government</g:elseif> 
				 <g:elseif test="${formDetails?.depostionOfMicroOrganism}">Micro</g:elseif>
				<g:elseif test="${formDetails?.indianResearcher}">Indian-Researcher</g:elseif></td>
              
              <td colspan="4"><g:textField class="remark" colspan="4" name="appltcatg" value="${formRemkInstance?.applicantCatgRmk}"/></td>
            </tr>
            <tr>
              <td><b>4</b></td>
              <td style="width:35%!important"><b>Name of the applicant and contact details</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="3"><g:if
				test="${formDetails?.individualProfiles}">
				<g:each in="${formDetails?.individualProfiles}"
					var="individualProfile">

					${individualProfile?.title}
					${individualProfile?.firstName}
					${individualProfile?.middleName}
					${individualProfile?.lastName}<br/>
					${individualProfile?.address1}
					${individualProfile?.address2}
					${individualProfile?.address3}<br/>
					${individualProfile?.city}
				</g:each>
			</g:if> <g:elseif test="${formDetails?.companyProfiles}">
				<g:each status="k" in="${formDetails?.companyProfiles}"
					var="company">
					${company?.entityName}<br/>
	            	${company?.address1}${company?.address2}${company?.address3}<br/>
		            ${company?.city}
		
				</g:each>
			</g:elseif> <g:elseif test="${formDetails?.indianResearcher}">
				<g:each in="${formDetails?.indianResearcher}" var="researcher">

					${researcher?.title}
					${researcher?.firstName}
					${researcher?.middleName}
					${researcher?.lastName}<br/>
					${researcher?.address1}
					${researcher?.address2}
					${researcher?.address3}<br/>
					${researcher?.presentCity}
				</g:each>
			</g:elseif> <g:elseif test="${formDetails?.depostionOfMicroOrganism}">
				<g:each in="${formDetails?.depostionOfMicroOrganism}" var="depost">
					${depost?.nameOfDepositor}<br/>
					${depost?.address1}
					${depost?.address2}
					${depost?.address3}<br/>
					${depost?.city}
				</g:each>
			</g:elseif> <g:elseif test="${formDetails?.indianGovtInst}">
				<g:each in="${formDetails?.indianGovtInst}" var="govt">
					${govt?.govtInstName}<br/>
					${govt?.address1}
					${govt?.address2}
					${govt?.address3}<br/>
					${govt?.presentCity}
				</g:each>
			</g:elseif></td>
              
              <td colspan="4"><g:textField class="remark" name="appltname" value="${formRemkInstance?.applicantNameContRmk}"/></td>
            </tr>
            <tr>
              <td><b>5</b></td>
              <td style="width:35%!important"><b>Name and Address of the contact person/ authorized person of the company</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
             
               <td colspan="3"> 
              
			<g:if test="${formDetails?.companyProfiles}">
			<g:each in="${formDetails?.companyProfiles}" var="company">
			${company?.title} ${company?.firstName} ${company?.middleName} ${company?.lastName}<br/>
			<b>Mobile :</b> ${company?.personMobile} <br />
		<b>Email Id :</b> ${company?.personEmail}
			</g:each>
			</g:if>
			<g:else>NA</g:else>
			</td>
              <td colspan="4"><g:textField class="remark" name="nameandComp" value="${formRemkInstance?.authPersonContRmk}"/></td>
            </tr>
            <tr>
              <td><b>6</b></td>
              <td style="width:35%!important"><b>Name and address of the contact person/ agent/ attorney, in India</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="3">
              
              <g:if test="${formDetails?.agentProfile}">
			${formDetails?.agentProfile?.title} ${formDetails?.agentProfile?.firstName}
			${formDetails?.agentProfile?.middleName} ${formDetails?.agentProfile?.lastName}<br/>
			${formDetails?.agentProfile?.address1} ${formDetails?.agentProfile?.address2}
			${formDetails?.agentProfile?.address3}<br/> ${formDetails?.agentProfile?.city}
			</g:if>
              
              
<%--              <g:if test="${formDetails?.contactPersons}">--%>
<%--				<g:each in="${formDetails?.contactPersons}" var="contPrsn"--%>
<%--					status="i">--%>
<%--					${contPrsn.nameOfContactPerson}--%>
<%--					${contPrsn.addressOfContactPerson}--%>
<%--				</g:each>--%>
<%--			</g:if>--%>
			
			<g:else>No</g:else>
			</td>
              
              <td colspan="4"><g:textField class="remark" name="agent" value="${formRemkInstance?.attorneyInIndiaContRmk}"/></td>
            </tr>
            <tr>
              <td><b>7</b></td>
              <td style="width:35%!important"><b>Category of Application Form</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="3">Form IV</td>
              
              <td colspan="4"><g:textField class="remark" name="formCatg" value="${formRemkInstance?.appFormCatgRmk}"/></td>
            </tr>
            <tr>
              <td><b>8</b></td>
              <td style="width:35%!important"><b>Is the applicant falls u/s 3(2)</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
             		<g:if test="${formRemkInstance?.threeTwocheck == '' || formRemkInstance?.threeTwocheck == null }">
		<td colspan="3">
		
		<g:radio name="threeTwocheck" id="yesthreeTwo"
				onclick="hideText();" value="true"  /> Yes <g:radio name="threeTwocheck" id="nothreeTwo"
				onclick="showText();" value="false"  /> No</td></g:if>
		<g:if test="${formRemkInstance?.threeTwocheck == false }">
		<td colspan="3">
		<g:radio name="threeTwocheck" id="yesthreeTwo"
				onclick="hideText();" value="true"  /> Yes <g:radio name="threeTwocheck" id="nothreeTwo"
				onclick="showText();" value="false" checked="true" /> No</td></g:if>
				<g:if test="${formRemkInstance?.threeTwocheck == true}">
				<td colspan="3">
		
		<g:radio name="threeTwocheck" id="yesthreeTwo"
				onclick="hideText();" value="true" checked="true" /> Yes <g:radio name="threeTwocheck" id="nothreeTwo"
				onclick="showText();" value="false" /> No</td>
				</g:if>
              
              <td colspan="4"><g:textField class="remark" name="threeTwoRemark" id="remarkthreeTwo" value="${formRemkInstance?.threeTwoRemark}"
				style="display: none;"/></td>
            </tr>
            <tr>
              <td><b>9</b></td>
              <td style="width:35%!important"><b>Is the applicant falls u/s 7</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
            	
		<g:if test="${formRemkInstance?.sevncheck == '' || formRemkInstance?.sevncheck == null }">
		<td colspan="3"><g:radio name="sevncheck" id="yessevn"
				onclick="hide();" value="true" /> Yes <g:radio name="sevncheck" id="nosevn"
				onclick="show();" value="false" /> No</td>
				</g:if>
				
		<g:if test="${formRemkInstance?.sevncheck == false }">
		<td colspan="3"><g:radio name="sevncheck" id="yessevn"
				onclick="hide();" value="true" /> Yes <g:radio name="sevncheck" id="nosevn"
				onclick="show();" value="false" checked="true" /> No</td>
				</g:if>
				
				<g:if test="${formRemkInstance?.sevncheck == true}">
				<td colspan="3"><g:radio name="sevncheck" id="yessevn"
				onclick="hide();" value="true"  checked="true" /> Yes <g:radio name="sevncheck" id="nosevn"
				onclick="show();" value="false" /> No</td>
				</g:if>
		
		<td colspan="4"><g:textField class="remark"  name="sevnRemark" id="remarksevn" value="${formRemkInstance?.sevnRemark}"
				style="display: none;" /></td>
            </tr>
            <tr>
              <td><b>10</b></td>
              <td style="width:35%!important"><b>Is Authorization letter/Board Resolution/POA found in order</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
             		<g:if test="${formRemkInstance?.letterBoardChk == '' || formRemkInstance?.letterBoardChk == null}">
		<td colspan="3"><g:radio name="letterBoardChk" value="true"/> Yes <g:radio name="letterBoardChk" value="false"/> No
		 <g:radio name="letterBoardChk" value="notAvailable"/> N/A</td>
		 </g:if>
		 
		 <g:if test="${formRemkInstance?.letterBoardChk == "true"}">
		<td colspan="3"><g:radio name="letterBoardChk" value="true" checked="true"/> Yes 
		<g:radio name="letterBoardChk" value="false"/> No
		 <g:radio name="letterBoardChk" value="notAvailable"/> N/A</td>
		 </g:if>
		 
		 <g:if test="${formRemkInstance?.letterBoardChk == "false"}">
		<td colspan="3"><g:radio name="letterBoardChk" value="true"/> Yes
		 <g:radio name="letterBoardChk" value="false" checked="true"/> No
		 <g:radio name="letterBoardChk" value="notAvailable"/> N/A</td>
		 </g:if>
		 
		 <g:if test="${formRemkInstance?.letterBoardChk == "notAvailable"}">
		<td colspan="3"><g:radio name="letterBoardChk" value="true"/> Yes
		 <g:radio name="letterBoardChk" value="false"/> No
		 <g:radio name="letterBoardChk" value="notAvailable" checked="true"/> N/A</td>
		 </g:if>
		 
		
		<td colspan="4"><g:textField class="remark"  name="letterBoardRemark" value="${formRemkInstance?.letterBoardRemark}"/></td>
            </tr>
            <tr>
              <td><b>11</b></td>
              <td style="width:35%!important"><b>Is MoU/AoA/LoIetc, found in order</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
  		<g:if test="${formRemkInstance?.holdingPatternChk == '' || formRemkInstance?.holdingPatternChk == null }">
		<td colspan="3">
		<g:radio name="holdingPatternChk" value="true"/> Yes 
		<g:radio name="holdingPatternChk" value="false"/> No
		 <g:radio name="holdingPatternChk" value="notAvailable"/> N/A</td>
		 </g:if>
		 
		 <g:if test="${formRemkInstance?.holdingPatternChk == "true" }">
		<td colspan="3">
		<g:radio name="holdingPatternChk" value="true" checked="true"/> Yes 
		<g:radio name="holdingPatternChk" value="false"/> No
		 <g:radio name="holdingPatternChk" value="notAvailable"/> N/A</td>
		 </g:if>
		 
		 <g:if test="${formRemkInstance?.holdingPatternChk == "false" }">
		<td colspan="3">
		<g:radio name="holdingPatternChk" value="true"/> Yes 
		<g:radio name="holdingPatternChk" value="false" checked="true"/> No
		 <g:radio name="holdingPatternChk" value="notAvailable"/> N/A</td>
		 </g:if>
		 
		 <g:if test="${formRemkInstance?.holdingPatternChk == "notAvailable" }">
		<td colspan="3">
		<g:radio name="holdingPatternChk" value="true"/> Yes 
		<g:radio name="holdingPatternChk" value="false"/> No
		 <g:radio name="holdingPatternChk" value="notAvailable" checked="true"/> N/A</td>
		 </g:if>
		 
		
		<td colspan="4"><g:textField class="remark" name="holdingPatternRemark" value="${formRemkInstance?.holdingPatternRemark}"/></td>

            </tr>
            <tr>
              <td><b>12</b></td>
              <td style="width:35%!important"><b>Has the Applicant taken prior approval of NBA under Section
                3 of the BD Act?</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
         <g:if test="${formRemkInstance?.priorApprovalOfNBA == '' || formRemkInstance?.priorApprovalOfNBA == null}">
		<td colspan="3"><g:radio name="priorApprovalOfNBA" value="true"/> Yes <g:radio name="priorApprovalOfNBA" value="false"/> No
		 <g:radio name="priorApprovalOfNBA" value="notAvailable"/> N/A</td>
		 </g:if>
		 
		 <g:if test="${formRemkInstance?.priorApprovalOfNBA == "true"}">
		<td colspan="3"><g:radio name="priorApprovalOfNBA" value="true" checked="true"/> Yes 
		<g:radio name="priorApprovalOfNBA" value="false"/> No
		 <g:radio name="priorApprovalOfNBA" value="notAvailable"/> N/A</td>
		 </g:if>
		 
		 <g:if test="${formRemkInstance?.priorApprovalOfNBA == "false"}">
		<td colspan="3"><g:radio name="priorApprovalOfNBA" value="true"/> Yes
		 <g:radio name="priorApprovalOfNBA" value="false" checked="true"/> No
		 <g:radio name="priorApprovalOfNBA" value="notAvailable"/> N/A</td>
		 </g:if>
		 
		 <g:if test="${formRemkInstance?.priorApprovalOfNBA == "notAvailable"}">
		<td colspan="3"><g:radio name="priorApprovalOfNBA" value="true"/> Yes
		 <g:radio name="priorApprovalOfNBA" value="false"/> No
		 <g:radio name="priorApprovalOfNBA" value="notAvailable" checked="true"/> N/A</td>
		 </g:if>
              
              <td colspan="4"><g:textField class="remark" name="priorApprovalOfNBARmk" value="${formRemkInstance?.priorApprovalOfNBARmk}"/></td>

            </tr>
            <tr>
              <td><b>13</b></td>
              <td style="width:35%!important"><b>Intended purpose for transfer of biological resources and/or
                associated knowledge</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="3"></td>
              
              <td  colspan="4"><g:textField class="remark"  name="purposeForTransBioResRmk"  value="${formRemkInstance?.purposeForTransBioResRmk}"/></td>
            </tr>
            <tr>
              <td><b>14</b></td>
              <td style="width:35%!important"><b>Proposed date of transfer of biological resources and/or
                associated knowledge</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="3">${formDetails?.thirdPartyTransferPurpose}</td>
              
              <td colspan="4"><g:textField class="remark" name="dateOfTransBioResRmk"  value="${formRemkInstance?.dateOfTransBioResRmk}"/></td>
            </tr>
            <tr>
              <td><b>15</b></td>
              <td style="width:35%!important"><b>Is there any legal issue in the MOU/agreement to transfer the
                biological resources?</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
  		<g:if test="${formRemkInstance?.twoDChk == '' || formRemkInstance?.twoDChk == null }">
		<td colspan="3"><g:radio name="twoDChk" value="true"/> Yes <g:radio name="twoDChk" value="false"/> 
		 No. Need additional information</td>
			</g:if>
			
			<g:if test="${formRemkInstance?.twoDChk == true}">
		<td colspan="3"><g:radio name="twoDChk" value="true" checked="true"/> Yes <g:radio name="twoDChk" value="false"/> 
		 No. Need additional information</td>
			</g:if>
			
			<g:if test="${formRemkInstance?.twoDChk == false}">
		<td colspan="3"><g:radio name="twoDChk" value="true"/> Yes <g:radio name="twoDChk" value="false" checked="true"/> 
		 No. Need additional information </td>
			</g:if>
			
			
		
		<td colspan="4"><g:textField class="remark" name="twoDRemark" value="${formRemkInstance?.twoDRemark}"/></td>
            </tr>
            <tr>
              <td><b>16</b></td>
              <td style="width:35%!important"><b>Is all the information required for legal vetting available?</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
 
 
       <g:if test="${formRemkInstance?.vettingChk == '' || formRemkInstance?.vettingChk == null}">
		<td colspan="3">
		<g:radio name="vettingChk" value="true"/> Yes <g:radio name="vettingChk" value="false"/> 
		No. Need additional information</td>
		</g:if>
		
		<g:if test="${formRemkInstance?.vettingChk == "true"}">
		<td colspan="3">
		<g:radio name="vettingChk" value="true" checked="true"/> Yes
		<g:radio name="vettingChk" value="false"/> 
		No. Need additional information</td>
		</g:if>
		
		<g:if test="${formRemkInstance?.vettingChk == "false"}">
		<td colspan="3"><g:radio name="vettingChk" value="true"/> Yes <g:radio name="vettingChk" value="false" checked="true"/> 
		No. Need additional information</td>
		</g:if>
		
		
		
		<td colspan="4"><g:textField class="remark" name="vettingRemark" value="${formRemkInstance?.vettingRemark}"/></td>
            </tr>
            <tr>
              <td><b>17</b></td>
              <td style="width:35%!important"><b>Is the Application found in order?</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
            <g:if test="${formRemkInstance?.orderChk == '' || formRemkInstance?.orderChk == null}">
		<td colspan="3"><g:radio name="orderChk" value="true"/> Yes
		 <g:radio name="orderChk" value="false"/> 
		No. Need additional information</td></g:if>
		
		<g:if test="${formRemkInstance?.orderChk == "true"}">
		<td colspan="3"><g:radio name="orderChk" value="true" checked="true"/> Yes
		 <g:radio name="orderChk" value="false"/> 
		No. Need additional information</td></g:if>
		
		<g:if test="${formRemkInstance?.orderChk == "false"}">
		<td colspan="3"><g:radio name="orderChk" value="true"/> Yes
		 <g:radio name="orderChk" value="false" checked="true"/> 
		No. Need additional information</td></g:if>
	
		
		<td colspan="4"><g:textField class="remark" name="orderRemark" value="${formRemkInstance?.orderRemark}"/></td>
            </tr>
            <tr>
              <td><b>18</b></td>
              <td style="width:35%!important"><b>Special observation about the Application, if any</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td   ><g:textField class="remark" colspan="4"   name="splObservation" value= "${formRemkInstance?.splObservation}"/></td>
              <td colspan="4"></td>
             
            </tr>
            <tr>
              <td><b>19</b></td>
              <td colspan="7"><b>Full particular of the third party to whom the accessed material/knowledge is intended to be transferred</b>
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
                    <td>${thirdParty?.name}</td>
                    <td>${thirdParty?.addressForComm}${thirdParty?.state}
                   Pin- ${thirdParty?.pincode},<br> Country-${thirdParty?.country},Phone-${thirdParty?.phone}<br>
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
		<td colspan="8">
		<table class="table table-bordered">
            <tr>
              <td><b>20A</b></td>
              <td style="width:35%!important"><b>Is there any violation of Provision of BD Act?</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
      <g:if test="${formRemkInstance?.violationChk == '' || formRemkInstance?.violationChk == null }">
		<td colspan="3"><g:radio name="violationChk" onclick="trshow('yes');" value="true"/>Yes
			<g:radio name="violationChk" onclick="trshow('no');" value="false"/>No</td></g:if>
			
			<g:if test="${formRemkInstance?.violationChk == true}">
		<td colspan="3"><g:radio name="violationChk" value="true" checked="true"/>Yes
			<g:radio name="violationChk" value="false"/>No</td></g:if>
			
			<g:if test="${formRemkInstance?.violationChk == false }">
		<td colspan="3"><g:radio name="violationChk" value="true"/>Yes
			<g:radio name="violationChk" value="false" checked="true"/>No</td></g:if>
			
		
		<td colspan="3"><g:textField class="remark" colspan="4"  name="violationRemark" value="${formRemkInstance?.violationRemark}"/></td>
            </tr>
            <tr id="show-me" style=" visibility: hidden;">
              <td><b>20B</b></td>
              <td style="width:35%!important"><b>Select section (can select multiple)</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="3">
                         <g:select name="sectionData" from="${vioSection}"
	     	value="${formRemkInstance?.violationSelect}" id="pickSec"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="Add" class="btn" onclick="addSectionValue();"></td>
		
		<g:if test="${formRemkInstance?.violationSelect}">
		<g:javascript>
		$(document).ready(function() {
		document.getElementById('showSectionVal').style.display = 'block';
		});
		
		</g:javascript>
		
		
		</g:if>
		<td  colspan="2"><g:textArea class="remark" name="violationSelect" value="${formRemkInstance?.violationSelect}" id="showSectionVal" style="display: none;"/></td>
            </tr>
            </table></td>
            </tr>
			<tr>
			<td><b>21</b></td>
		<td style="width: 35% !important"><b>Additional
				questionnaires by NBA</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td colspan="4"><g:textArea class="remark" name="additional" style=" display:none;" value="${formRemkInstance?.additional}"/></td>
		
<g:if test="${formRemkInstance == null || formRemkInstance == ''}">
<%-- <td colspan="4"> <input type="button" class="btn" id="add" value="Add Question" name="21" onclick="addQuestionTr(this);"/></td>--%>
 <td><a class="btn btn-primary pull-right add-record" data-added="0"><i class="glyphicon glyphicon-plus"></i> Add Questions</a></td>
 
 </g:if>
 <g:else><td colspan="4"></td></g:else>
	</tr>
	 

<g:if test="${formRemkInstance != null || formRemkInstance != ''}">
<g:each in="${formRemkInstance?.questionAnswers}" var="quesAnswer" status="k">
<tr id="all${k+1 }">
<td><b id="srl${k+1}"><span class="sn">${k+22}</span></b></td>
<td><g:textArea class="remark" name="quesValues${k+1}" id="qut${k+1}" value="${quesAnswer?.question}" rows="3" cols="40"></g:textArea></td>
<td><b>:</b></td>
<td colspan="3"><g:textArea class="remark" name="ansValues${k+1}" id="qes${k+1}" value="${quesAnswer?.answer}" rows="3" cols="45"></g:textArea></td>
<td>

<input type="button" onclick="updateQuestion(this);" class="btn btn-success" style="margin-top: 22%; margin-left: 6%;" value="Update" id="upd${k+1}" name="${quesAnswer?.id}"/></td>
<%--<g:remoteLink  controller="checklist" action="deleteQuestion" id="rem${k+1}" params="${[deleteIns:quesAnswer?.id]}"  onSuccess="removeTextBoxes(this);">Remove</g:remoteLink>--%>
<td><input type="button" onclick="deleteQues(this);" value="Remove" id="rem${k+1}" name="${quesAnswer?.id}" class="btn btn-danger" style="margin-top:22%"  />
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
       <td><b>:</b></td>
       <td colspan="4"><g:textArea name="ansValues" class="ans" style="width:100%"></g:textArea></td>
       <td><a class="btn btn-xs delete-record" data-id="0"><span class="btn btn-danger"><i class="fa fa-trash"></i> Remove Row</span></a></td>
     </tr>
   </table>

</td>
</tr>
</tbody>
</table>
