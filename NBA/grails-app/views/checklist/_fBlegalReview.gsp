
<style>
.remark{
color:blue;
width: 204px;
}
</style>



<table class="table table-bordered customtable">
	<tr class="header">
		 <th>S.No</th>
              <th>Title</th>
              <th></th>
              <th>Details</th>
              <th colspan="2">Remarks</th>
	</tr>

	<tr>
		<td><b>1</b></td>
		<td style="width: 50% !important"><b>Application category</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">Form B</td>
		<td class="" colspan="2"><g:textField name="formCatg" class="remark" value="${formRemkInstance?.appFormCatgRmk}"/></td>
		
	</tr>
	<tr>
		<td><b>2</b></td>
		<td style="width: 50% !important"><b>Name of the applicant
				and contact details given under temporary and permanent address</b></td>
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
		<td class="" colspan="2"><g:textField name="appltname" class="remark" value="${formRemkInstance?.applicantNameContRmk}"/></td>
	</tr>
	<tr>
		<td><b>3</b></td>
		<td style="width: 50% !important"><b>Nationality</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td>
		Indian${nationality} </td>
            
		<td class="" colspan="2"><g:textField name="appltnationality"
				value="${formRemkInstance?.appltnationality}" class="remark"/></td>
	</tr>
	<tr>
		<td><b>4</b></td>
		<td style="width: 50% !important"><b>Whether the prescribed
				application form has been used</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		    <g:if test="${formRemkInstance?.prescribedApplication == true}">
			<td class="colspan="3"><g:radio name="prescribedApplication"
					value="true" checked="true" id="wheatherYes" /> Yes <g:radio
					name="prescribedApplication" value="false" id="wheatherNo" /> No</td>
		</g:if>
		<g:elseif test="${formRemkInstance?.prescribedApplication == false}">
			<td class="colspan="3"><g:radio name="prescribedApplication"
					value="true" id="wheatherYes" /> Yes <g:radio name="prescribedApplication"
					checked="true" value="false" id="wheatherNo" /> No</td>

		</g:elseif>
		<g:elseif
			test="${formRemkInstance?.prescribedApplication == '' || formRemkInstance?.prescribedApplication == null }">
			<td class="colspan="3"><g:radio name="prescribedApplication"
					value="true" id="wheatherYes" /> Yes <g:radio name="prescribedApplication"
					value="false" id="wheatherNo" /> No</td>

		</g:elseif>
              <td class="" colspan="2"><g:textField name="whetherPrescriedRmk"
				value="${formRemkInstance?.whetherPrescriedRmk}" class="remark"/></td>
	</tr>
	<tr>
		<td><b>5</b></td>
		<td style="width: 50% !important"><b>Name and Address of
				Institution in India</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		
		<td class="colspan">${indianInst?.name}<br/>
              
              
      ${indianInst?.address1}, ${indianInst?.address2} ${indianInst?.address3} ${indianInst?.city}, <br/>
						PIN:${indianInst?.pincode}, ${indianInst?.state} ${indianInst?.country}<br/>
						<b>Phone:</b>${indianInst?.phone}<br/>
						<b>Fax:</b>${indianInst?.fax}<br/>
						<b>Email:</b>${indianInst?.email}
              
              </td>
              <td class="" colspan="2"> <g:textField name="indinstitueRemk"
				value="${formRemkInstance?.indinstitueRemk}" class="remark"/></td>
	</tr>
	<tr>
		<td><b>6</b></td>
		<td style="width: 50% !important"><b>Name of the Supervisor
				or Head of Institution at the place of work in India</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
	  <td class="colspan">${superVisor?.name}
              ${superVisor?.address1}, ${superVisor?.address2} ${superVisor?.address3} ${superVisor?.city}, <br/>
						PIN:${superVisor?.pincode}, ${superVisor?.state} ${superVisor?.country}<br/>
						<b>Phone:</b>${superVisor?.phone}<br/>
						<b>Fax:</b>${superVisor?.fax}<br/>
						<b>Email:</b>${superVisor?.email}
              
              </td>
              <td class="" colspan="2"><g:textField name="headSuperRemk"
				value="${formRemkInstance?.headSuperRemk}" class="remark"/> </td>
	</tr>

	<tr>
		<td><b>7</b></td>
		<td style="width: 50% !important"><b>Name of the
				funding agency supporting the proposed research</b></td>
               <td class="text-center" style="width:1px;"><b>:</b></td>
              <td class="colspan">
              
              <g:if test="${formDetails?.formBFundingAgency}">
              <g:each var="fund" in="${formDetails?.formBFundingAgency}">
              ${fund?.institutionOrganizationName}
              </g:each>
              </g:if></td>
              <td class="" colspan="2"><g:textField name="fundingRemk"
				value="${formRemkInstance?.fundingRemk}" class="remark"/>  </td>
	</tr>

	<tr>
		<td><b>8</b></td>
		<td style="width: 50% !important"><b>Whether the
				undertakings, declarations / other documents are found in order?</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<g:if test="${formRemkInstance?.letterBoardChk == '' || formRemkInstance?.letterBoardChk == null}">
		<td colspan="2">
		</td>
		 </g:if>
		 
		 <g:if test="${formRemkInstance?.letterBoardChk == "true"}">
		<td colspan="2">Yes</td>
		 </g:if>
		 
		 <g:if test="${formRemkInstance?.letterBoardChk == "false"}">
		<td colspan="2"> No</td>
		 </g:if>
		
		<td><g:textField name="letterBoardRemark" value="${formRemkInstance?.letterBoardRemark}" class="remark"/></td>
		
	</tr>

	<tr>
		<td><b>9</b></td>
		<td style="width: 50% !important"><b>If it is for emergency
				purpose, specify details</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		 <td class="colspan">${formDetails?.emergencyDetails}</td>
              <td class="" colspan="2"><g:textField name="emergencyRemk"
				value="${formRemkInstance?.emergencyRemk}" class="remark"/>  </td>
	</tr>

	<tr>
		<td><b>10</b></td>
		<td style="width: 50% !important"><b>Whether the application
				is legally found in order?</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
			<g:if test="${formRemkInstance?.orderChk == '' || formRemkInstance?.orderChk == null}">
		<td colspan="2"></td></g:if>
		
		<g:if test="${formRemkInstance?.orderChk == "true"}">
		<td colspan="2">Yes</td></g:if>
		
		<g:if test="${formRemkInstance?.orderChk == "false"}">
		<td colspan="2">No</td></g:if>
	
		<td class="" colspan="2"><g:textField name="orderRemark" value="${formRemkInstance?.orderRemark}" class="remark"/></td>
	</tr>


</table>