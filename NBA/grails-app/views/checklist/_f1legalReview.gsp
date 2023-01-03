
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
		<td style="width: 35% !important"><b>Online Application
				number</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td>
			${formDetails?.appNumber}
		</td>
		
		<td colspan="4"><g:textField class="remark" name="onlineAppNumberRmk" value="${formRemkInstance?.onlineAppNumberRmk}" /></td>
	</tr>
	<tr>
		<td><b>2</b></td>
		<td style="width: 35% !important"><b>NBA Reference number</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<g:if test="${nbaReferenceNum}">
    <td colspan="3"><g:textField class="remark" class="remark" name="refNumber" value="${nbaReferenceNum}" /></td>

		</g:if>
		<g:else>
		<td colspan="3"><g:textField class="remark" class="remark" name="refNumber" value="${formRemkInstance?.nbaRefNumber}" /></td>
		</g:else>
		
		<td colspan="4"><g:textField class="remark" name="nbaRefNumberRemark" value="${formRemkInstance?.nbaRefNumberRemark}" /></td>
	</tr>
	<tr>
		<td><b>3</b></td>
		<td style="width: 35% !important"><b>Applicant category</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td colspan="3">   
		<g:if test="${formDetails?.individualProfiles}">Individual</g:if>
               <g:elseif test="${formDetails?.companyProfiles}">
				<g:each in="${formDetails?.companyProfiles}" var="ct">
				${ct?.entityType }
				</g:each>
				</g:elseif>
				 <g:elseif test="${formDetails?.indianGovtInst}">Government</g:elseif> 
				 <g:elseif test="${formDetails?.depostionOfMicroOrganism}">Micro</g:elseif>
				<g:elseif test="${formDetails?.indianResearcher}">Indian-Researcher</g:elseif>
				</td>
		
		<td colspan="4"><g:textField class="remark" name="appltcatg" value="${formRemkInstance?.applicantCatgRmk}"/></td>
	</tr>
	<tr>
		<td><b>4</b></td>
		<td style="width: 35% !important"><b>Name of the applicant
				and contact details</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
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
					${company?.entityName}
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
		<td style="width: 35% !important"><b>Name and Address of the
				contact person/ authorized person of the company</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td colspan="3">
	
			<g:if test="${formDetails?.companyProfiles}">
			<g:each in="${formDetails?.companyProfiles}" var="company">
			${company?.title} ${company?.firstName} ${company?.middleName} ${company?.lastName}<br/>
			<b>Designation:</b> ${company?.designation}<br/>
			<b>Mobile :</b> ${company?.personMobile} <br />
		<b>Email Id :</b> ${company?.personEmail}
			</g:each>
			</g:if>
			<g:else>No</g:else>
		</td>
		
		<td colspan="4"><g:textField class="remark" name="nameandComp" value="${formRemkInstance?.authPersonContRmk}"/></td>
	</tr>
	<tr>
		<td><b>6</b></td>
		<td style="width: 35% !important"><b>Name and address of the
				contact person/ agent/ attorney, in India</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>

		<td>	<g:if test="${formDetails?.agentProfile}">
			${formDetails?.agentProfile?.title} ${formDetails?.agentProfile?.firstName}
			${formDetails?.agentProfile?.middleName} ${formDetails?.agentProfile?.lastName}
			${formDetails?.agentProfile?.address1} ${formDetails?.agentProfile?.address2}
			${formDetails?.agentProfile?.address3} ${formDetails?.agentProfile?.city}
			</g:if><g:else>No</g:else></td>

		
		<td colspan="4"><g:textField class="remark" name="agent" value="${formRemkInstance?.attorneyInIndiaContRmk}"/></td>
	</tr>
	<tr>
		<td><b>7</b></td>
		<td style="width: 35% !important"><b>Category of Application
				Form</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td colspan="3">
			Form I
		</td>
		
		<td  colspan="4"><g:textField class="remark" name="formCatg" value="${formRemkInstance?.appFormCatgRmk}"/></td>
	</tr>
	<tr>
		<td><b>8</b></td>
		<td style="width: 35% !important"><b>Is the applicant falls
				u/s 3(2)</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		
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
		<td style="width: 35% !important"><b>Is the applicant falls
				u/s 7</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		
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
		
		<td colspan="4"><g:textField class="remark" name="sevnRemark" id="remarksevn" value="${formRemkInstance?.sevnRemark}"
				style="display: none;" /></td>
	</tr>
	<tr>
		<td><b>10</b></td>
		<td style="width: 35% !important"><b>Is Authorization
				letter/Board Resolution/POA found in order</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
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
		 
		
		<td colspan="4"><g:textField class="remark" name="letterBoardRemark" value="${formRemkInstance?.letterBoardRemark}"/></td>
	</tr>
	<tr>
		<td><b>11</b></td>
		<td style="width: 35% !important"><b>Is MoU/AoA/LoI/Annual
				Report/Share holding pattern etc, found in order</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
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
		<td colspan="8"><b>Details of biological resources and/or
				associated knowledge proposed for access</b>
				<table class="table table-bordered">
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
							<g:each in="${formDetails?.biologicalResources}" var="resource" status="i">
									<tr>
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
										
										to <g:formatDate format="dd/MM/yyyy" date="${resource?.toTime}"/> </td>
										<td><g:textField class="remark" name="resremk" value="${formRemkInstance?.biologicalResRmk}"/></td>
										</tr>
										</g:each>
									
							</g:if>
			     </table> 
			</td>
	</tr>
	<tr>
		<td><b>13</b></td>
		<td colspan="8"><b>Name and number of persons authorized by
				the applicant for making selection</b>
				<table class="table table-bordered">
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
				<g:else>--Self</g:else>
			</table></td>
	</tr>
	 <tr>
            <td><b>14</b></td>
		<td colspan="8">
		<table class="table table-bordered">
	<tr>
		<td><b>14A</b></td>
		<td style="width: 36% !important"><b>Intended purpose for access of
				biological resources and/or associated knowledge</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td colspan="3">${formDetails?.purposeOfProposal}</td>
		
		<td colspan="2"><g:textField class="remark" name="intendedPurpose" value="${formRemkInstance?.intendedPurpose}"/></td>
	</tr>
	<tr>
		<td><b>14B</b></td>
		<td style="width: 36% !important"><b>In case of research
				Whether the research falls within the legal ambit of section 2(m) of
				BD Act?</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<g:if test="${formRemkInstance?.twoMChk == '' || formRemkInstance?.twoMChk == null}">
		<td colspan="3"><g:radio name="twoMChk" value="true"/> Yes 
		<g:radio name="twoMChk" value="false"/> 
		 No</td>
			</g:if>
			
			<g:if test="${formRemkInstance?.twoMChk == true}">
		<td colspan="3"><g:radio name="twoMChk" value="true" checked="true"/> Yes 
		<g:radio name="twoMChk" value="false"/> 
		 No</td>
			</g:if>
			
			<g:if test="${formRemkInstance?.twoMChk == false}">
		<td colspan="3"><g:radio name="twoMChk" value="true"/> Yes 
		<g:radio name="twoMChk" value="false" checked="true"/> 
		 No</td>
			</g:if>
			
		
		<td colspan="2"><g:textField class="remark" name="twoMRemark" value="${formRemkInstance?.twoMRemark}"/></td>
	</tr>
	<tr>
		<td><b>14C</b></td>
		<td style="width: 36% !important"><b>In case of commercial
				utilization Whether the commercial activity falls within the legal
				ambit of section 2(f) of BD Act?</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<g:if
			test="${formRemkInstance?.twoFChk == '' || formRemkInstance?.twoFChk == null}">
			<td colspan="3"><g:radio name="twoFChk" value="true" />Yes
				<g:radio name="twoFChk" value="false" /> No</td>
		</g:if>

		<g:if test="${formRemkInstance?.twoFChk == true}">
			<td colspan="3"><g:radio name="twoFChk" value="true"
					checked="true" />Yes <g:radio name="twoFChk" value="false" /> No</td>
		</g:if>

		<g:if test="${formRemkInstance?.twoFChk == false}">
			<td colspan="3"><g:radio name="twoFChk" value="true"
					checked="true" />Yes <g:radio name="twoFChk" value="false"
					checked="true" /> No</td>
		</g:if>

		
		<td colspan="2"><g:textField class="remark" name="twoFRemark" value="${formRemkInstance?.twoFRemark}"/></td>
	</tr>
	<tr>
		<td><b>14D</b></td>
		<td style="width: 36% !important"><b>In case of bio-survey
				and bio-utilization Whether the activity falls within the legal
				ambit of section 2(d) of BD Act?</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<g:if test="${formRemkInstance?.twoDChk == '' || formRemkInstance?.twoDChk == null }">
		<td colspan="3"><g:radio name="twoDChk" value="true"/> Yes <g:radio name="twoDChk" value="false"/> 
		 No</td>
			</g:if>
			
			<g:if test="${formRemkInstance?.twoDChk == true}">
		<td colspan="3"><g:radio name="twoDChk" value="true" checked="true"/> Yes <g:radio name="twoDChk" value="false"/> 
		 No</td>
			</g:if>
			
			<g:if test="${formRemkInstance?.twoDChk == false}">
		<td colspan="3"><g:radio name="twoDChk" value="true"/> Yes <g:radio name="twoDChk" value="false" checked="true"/> 
		 No</td>
			</g:if>
			
			
		
		<td colspan="2"><g:textField class="remark" name="twoDRemark" value="${formRemkInstance?.twoDRemark}"/></td>
	</tr>
	</table></td>
	</tr>
	<tr>
		<td><b>15</b></td>
		<td style="width: 35% !important"><b>Is all the information
				required for legal vetting available</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<g:if test="${formRemkInstance?.vettingChk == '' || formRemkInstance?.vettingChk == null}">
		<td colspan="3"><g:radio name="vettingChk" value="true"/> Yes <g:radio name="vettingChk" value="false"/> 
		No</td>
		</g:if>
		
		<g:if test="${formRemkInstance?.vettingChk == "true"}">
		<td colspan="3"><g:radio name="vettingChk" value="true" checked="true"/> Yes <g:radio name="vettingChk" value="false"/> 
		No</td>
		</g:if>
		
		<g:if test="${formRemkInstance?.vettingChk == "false"}">
		<td colspan="3"><g:radio name="vettingChk" value="true"/> Yes <g:radio name="vettingChk" value="false" checked="true"/> 
		No</td>
		</g:if>
		
		
		
		<td colspan="2"><g:textField class="remark" name="vettingRemark" value="${formRemkInstance?.vettingRemark}"/></td>
	</tr>
	<tr>
		<td><b>16</b></td>
		<td style="width: 35% !important"><b>Is the Application found
				in order?</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<g:if test="${formRemkInstance?.orderChk == '' || formRemkInstance?.orderChk == null}">
		<td colspan="3"><g:radio name="orderChk" value="true"/> Yes
		 <g:radio name="orderChk" value="false"/> 
		No</td></g:if>
		
		<g:if test="${formRemkInstance?.orderChk == "true"}">
		<td colspan="3"><g:radio name="orderChk" value="true" checked="true"/> Yes
		 <g:radio name="orderChk" value="false"/> 
		No</td></g:if>
		
		<g:if test="${formRemkInstance?.orderChk == "false"}">
		<td colspan="3"><g:radio name="orderChk" value="true"/> Yes
		 <g:radio name="orderChk" value="false" checked="true"/> 
		No</td></g:if>
	
		
		<td colspan="2"><g:textField class="remark" name="orderRemark" value="${formRemkInstance?.orderRemark}"/></td>
	</tr>
	<tr>
		<td><b>17</b></td>
		<td style="width: 35% !important"><b>Objective for seeking
				NBA's approval</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td colspan="3">${formDetails?.briefDescription}</td>
		
		<td colspan="2"><g:textField class="remark" name="nbaApprovalRmk" value="${formRemkInstance?.nbaApprovalRmk}"/></td>
	</tr>
	 <tr>
            <td><b>18</b></td>
		<td colspan="8">
		<table class="table table-bordered">
	<tr>
		<td><b>18A</b></td>
		<td style="width: 36% !important"><b>Is there any violation
				of Provision of BD Act on Initial Scrutiny</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<g:if test="${formRemkInstance?.violationChk == '' || formRemkInstance?.violationChk == null }">
		<td colspan="3"><g:radio name="violationChk" onclick="trshow('yes');" value="true"/>Yes
			<g:radio name="violationChk" onclick="trshow('no');" value="false"/>No</td></g:if>
			
			<g:if test="${formRemkInstance?.violationChk == true}">
		<td colspan="3"><g:radio name="violationChk" value="true" checked="true"/>Yes
			<g:radio name="violationChk" value="false"/>No</td></g:if>
			
			<g:if test="${formRemkInstance?.violationChk == false }">
		<td colspan="3"><g:radio name="violationChk" value="true"/>Yes
			<g:radio name="violationChk" value="false" checked="true"/>No</td></g:if>
			
		
		<td colspan="2"><g:textField class="remark" name="violationRemark" value="${formRemkInstance?.violationRemark}"/></td>
	</tr>
           <tr id="show-me" style=" visibility: hidden;">
              <td><b>18B</b></td>
              <td style="width:36%!important"><b></b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="3"><span>Select section</span>&nbsp;&nbsp;
              <g:select name="sectionData" from="${vioSection}"
	     	value="${formRemkInstance?.violationSelect}" id="pickSec"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="Add" class="btn" onclick="addSectionValue();"></td>
	
		<g:if test="${formRemkInstance?.violationSelect}">
		
		<g:javascript>
		$(document).ready(function() {
		document.getElementById('showSectionVal').style.display = 'block';
		});
		</g:javascript>		
		
		</g:if>
		<td colspan="2"><g:textArea class="remark" name="violationSelect" value="${formRemkInstance?.violationSelect}" id="showSectionVal" style="display: none;" rows="3" cols="25"/></td>
            </tr>
            </table></td>
            </tr>
			<tr>
			
		
			
			<td><b>19</b></td>
		<td style="width: 35% !important"><b>Additional
				questionnaires by NBA</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td colspan="4">
  <g:textArea class="remark" name="additional" style=" display:none;" value="${formRemkInstance?.additional}"/>
		</td>
		
<g:if test="${formRemkInstance == null || formRemkInstance == ''}">
<%-- <td> <input type="button" class="btn" id="add" value="Add Question" name="19" onclick="addQuestionTr(this);"/></td>--%>
<td><a class="btn btn-primary pull-right add-record" data-added="0"><i class="glyphicon glyphicon-plus"></i> Add Questions</a></td>
 </g:if>
 <g:else><td></td></g:else>
</tr>
	 

<g:if test="${formRemkInstance != null || formRemkInstance != ''}">
<g:each in="${formRemkInstance?.questionAnswers}" var="quesAnswer" status="k">
<tr id="all${k+1 }">
<td><b id="srl${k+1}"><span class="sn">${k+20}</span></b></td>
<td><g:textArea class="remark" name="quesValues${k+1}" id="qut${k+1}" value="${quesAnswer?.question}" rows="3" cols="40"></g:textArea></td>
<td><b>:</b></td>
<td colspan="3"><g:textArea class="remark" name="ansValues${k+1}" id="qes${k+1}" value="${quesAnswer?.answer}" rows="3" cols="40"></g:textArea></td>
<td>

<input type="button" onclick="updateQuestion(this);" class="btn btn-success" style="margin-top: 22%;" value="Update" id="upd${k+1}" name="${quesAnswer?.id}"/></td>
<%--<g:remoteLink  controller="checklist" action="deleteQuestion" id="rem${k+1}" params="${[deleteIns:quesAnswer?.id]}"  onSuccess="removeTextBoxes(this);">Remove</g:remoteLink>--%>
<td><input type="button" onclick="deleteQues(this);" value="Remove" id="rem${k+1}" name="${quesAnswer?.id}" class="btn btn-danger"  style="margin-top: 22%;" />
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
