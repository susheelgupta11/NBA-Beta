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
              <th colspan="2">Details</th>
              <th colspan="4">Remarks</th>
            </tr>
            <tr>
              <td><b>1</b></td>
              <td style="width:35%!important"><b>Application category</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="2">Form B</td>
              <td class="" colspan="4"><g:textField name="formCatg"
				value="${formRemkInstance?.appFormCatgRmk}" class = "remark"/></td>
            </tr>
            <tr>
              <td><b>2</b></td>
              <td style="width:35%!important"><b>Name of the applicant and contact details given under temporary and permanent address</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="2"><g:if
				test="${formDetails?.individualProfiles}">
				<g:each in="${formDetails?.individualProfiles}"
					var="individualProfile">

					${individualProfile?.title}
					${individualProfile?.firstName}
					${individualProfile?.middleName}
					${individualProfile?.lastName}<br>
					${individualProfile?.address1}<br>
					${individualProfile?.address2}<br>
					${individualProfile?.address3}<br>
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
					${researcher?.lastName}<br>
					${researcher?.address1}<br>
					${researcher?.address2}<br>
					${researcher?.address3}<br>
					${researcher?.presentCity}
				<g:set value="${researcher?.nationality}" var="nationality"/>	
				</g:each>
			</g:elseif> <g:elseif test="${formDetails?.depostionOfMicroOrganism}">
				<g:each in="${formDetails?.depostionOfMicroOrganism}" var="depost">
					${depost?.nameOfDepositor}<br>
					${depost?.address1}
					${depost?.address2}
					${depost?.address3}<br>
					${depost?.city}
						<g:set value="${depost?.nationality}" var="nationality"/>	
				</g:each>
			</g:elseif> <g:elseif test="${formDetails?.indianGovtInst}">
				<g:each in="${formDetails?.indianGovtInst}" var="govt">
					${govt?.govtInstName}<br>
					${govt?.address1}
					${govt?.address2}<br>
					${govt?.address3}<br>
					${govt?.presentCity}
						<g:set value="Indian" var="nationality"/>
				</g:each>
			</g:elseif></td>
              <td colspan="4"><g:textField name="appltname"
				value="${formRemkInstance?.applicantNameContRmk}" class = "remark"/> </td>
            </tr>
            <tr>
              <td><b>3</b></td>
              <td style="width:35%!important"><b>Nationality</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
            <td colspan="2"> 
            
           ${nationality}
            </td>
             
              <td colspan="4"><g:textField name="appltnationality"
				value="${formRemkInstance?.appltnationality}" class = "remark"/></td>
            </tr>
            <tr>
              <td><b>4</b></td>
              <td style="width:35%!important"><b>Whether the prescribed application form has been used</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
             <g:if test="${formRemkInstance?.prescribedApplication == true}">
			<td colspan="2"><g:radio name="prescribedApplication"
					value="true" checked="true" id="wheatherYes" /> Yes <g:radio
					name="prescribedApplication" value="false" id="wheatherNo" /> No</td>
		</g:if>
		<g:elseif test="${formRemkInstance?.prescribedApplication == false}">
			<td colspan="2"><g:radio name="prescribedApplication"
					value="true" id="wheatherYes" /> Yes <g:radio name="prescribedApplication"
					checked="true" value="false" id="wheatherNo" /> No</td>

		</g:elseif>
		<g:elseif
			test="${formRemkInstance?.prescribedApplication == '' || formRemkInstance?.prescribedApplication == null }">
			<td colspan="2"><g:radio name="prescribedApplication"
					value="true" id="wheatherYes"  /> Yes <g:radio name="prescribedApplication"
					value="false" id="wheatherNo" /> No</td>

		</g:elseif>
              <td  colspan="4"><g:textField name="whetherPrescriedRmk"
				value="${formRemkInstance?.whetherPrescriedRmk}" class = "remark"/></td>
            </tr>
            <tr>
              <td><b>5</b></td>
              <td style="width:35%!important"><b>Whether all columns are filled</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
            
              <g:if test="${formRemkInstance?.columnFilled == true}">
			     <td colspan="2"><g:radio name="columnFilled"
					value="true" checked="true" id="columnFilledYes" /> Yes <g:radio
					name="columnFilled" value="false" id="columnFilledNo" /> No</td>
		</g:if>
		<g:elseif test="${formRemkInstance?.columnFilled == false}">
			<td colspan="2"><g:radio name="columnFilled"
					value="true" id="columnFilledYes" /> Yes <g:radio name="columnFilled"
					checked="true" value="false" id="columnFilledNo" /> No</td>

		</g:elseif>
		<g:elseif
			test="${formRemkInstance?.columnFilled == '' || formRemkInstance?.columnFilled == null }">
			<td colspan="2"><g:radio name="columnFilled"
					value="true" id="columnFilledYes" /> Yes <g:radio name="columnFilled"
					value="false" id="columnFilledNo" /> No</td>
		</g:elseif>
              <td  colspan="4"><g:textField name="columnFilledRmk"
				value="${formRemkInstance?.columnFilledRmk}" class = "remark"/> </td>
            </tr>
            <tr>
              <td><b>6</b></td>
              <td style="width:35%!important"><b>Whether Address Proof and ID proof matching with the details mentioned at S.No. 2</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
                <g:if test="${formRemkInstance?.idAndAddress == true}">
			<td colspan="2"><g:radio name="whrIdProofMtc"
					value="true" checked="true" id="wheatherYes" /> Yes <g:radio
					name="whrIdProofMtc" value="false" id="wheatherNo" /> No</td>
		</g:if>
		<g:elseif test="${formRemkInstance?.idAndAddress == false}">
			<td colspan="2"><g:radio name="whrIdProofMtc"
					value="true" id="wheatherYes" /> Yes <g:radio name="whrIdProofMtc"
					checked="true" value="false" id="wheatherNo" /> No</td>

		</g:elseif>
		<g:elseif
			test="${formRemkInstance?.idAndAddress == '' || formRemkInstance?.idAndAddress == null }">
			<td colspan="2"><g:radio name="whrIdProofMtc"
					value="true" id="wheatherYes" /> Yes <g:radio name="whrIdProofMtc"
					value="false" id="wheatherNo" /> No</td>

		</g:elseif>
              <td colspan="4"><g:textField name="whrIdProof"
				value="${formRemkInstance?.idAndAddressRemark}" class = "remark"/> </td>
            </tr>
            <tr>
              <td><b>7</b></td>
              <td style="width:35%!important"><b>Name and Address of Institution in India</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              
              <td colspan="2">${indianInst?.name}<br/>
              
              
      ${indianInst?.address1}, ${indianInst?.address2} ${indianInst?.address3} ${indianInst?.city}, <br/>
						PIN:${indianInst?.pincode}, ${indianInst?.state} ${indianInst?.country}<br/>
						<b>Phone:</b>${indianInst?.phone}<br/>
						<b>Fax:</b>${indianInst?.fax}<br/>
						<b>Email:</b>${indianInst?.email}
              
              </td>
              <td  colspan="4"> <g:textField name="indinstitueRemk"
				value="${formRemkInstance?.indinstitueRemk}" class = "remark"/></td>
            </tr>
            <tr>
              <td><b>8</b></td>
              <td style="width:35%!important"><b>Name of the Supervisor or Head of Institution at the place of work in India</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="2">${superVisor?.headOfInstName}<br/>
              ${superVisor?.address1}, ${superVisor?.address2} ${superVisor?.address3} ${superVisor?.city}, <br/>
						PIN:${superVisor?.pincode}, ${superVisor?.state} ${superVisor?.country}<br/>
						<b>Phone:</b>${superVisor?.phone}<br/>
						<b>Fax:</b>${superVisor?.fax}<br/>
						<b>Email:</b>${superVisor?.email}
              
              </td>
              <td  colspan="2"><g:textField name="headSuperRemk"
				value="${formRemkInstance?.headSuperRemk}" class = "remark"/> </td>
            </tr>

            <tr>
              <td><b>9</b></td>
              <td style="width:35%!important"><b>Name and contact details of the Institution or organization who shall guide the proposed research / receiving the biological resources.</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="2">${guidingIns?.name}
              
              ${guidingIns?.address1}, ${guidingIns?.address2} ${guidingIns?.address3} ${guidingIns?.city}, <br/>
						PIN:${guidingIns?.pincode}, ${guidingIns?.state} ${guidingIns?.country}<br/>
						<b>Phone:</b>${guidingIns?.phone}<br/>
						<b>Fax:</b>${guidingIns?.fax}<br/>
						<b>Email:</b>${guidingIns?.email}
              
              </td>
              <td  colspan="2"> <g:textField name="indinstitueGuideRemk"
				value="${formRemkInstance?.indinstitueGuideRemk}" class = "remark"/> </td>
            </tr>

            <tr>
              <td><b>10</b></td>
              <td style="width:35%!important"><b>Details of the Supervisor or Head of Institution or organization who guides the proposed research or recipient of the biological resources</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="2">${guidingSup?.name}
              
              ${guidingSup?.address1}, ${guidingSup?.address2} ${guidingSup?.address3} ${guidingSup?.city}, <br/>
						PIN:${guidingSup?.pincode}, ${guidingSup?.state} ${guidingSup?.country}<br/>
						<b>Phone:</b>${guidingSup?.phone}<br/>
						<b>Fax:</b>${guidingSup?.fax}<br/>
						<b>Email:</b>${guidingSup?.email}</td>
              <td  colspan="2"><g:textField name="indinstSuperRemk"
				value="${formRemkInstance?.indinstSuperRemk}" class = "remark"/>  </td>
            </tr>
            <tr>
              <td><b>11</b></td>
              <td colspan="5"><b>Details of biological resources proposed for carrying/ sending outside India</b></td>
            </tr>
            <tr>
              <td></td>
              <td colspan="5"><table class="table table-bordered">
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
								${resource?.fromTime} -${resource?.toTime}
							</td>
							<td><g:textField name="resremk" class="remark"
									value="${formRemkInstance?.biologicalResRmk}" /></td>
							</tr>
						</g:each>
					
				</g:if>
                </table></td>
            </tr> 
            
            
             <tr>
              <td><b>12</b></td>
              <td colspan="5"><b>Duration of Research</b></td>
            </tr>
             <tr>
              <td>(i)</td>
            <td colspan="2">
					
					<b>From:</b>  ${formDetails?.researchDurationFrom?.format('dd/MM/yyyy') }
				
				</td>
				<td colspan="3">
					<b>To</b>: ${formDetails?.researchDurationTo?.format('dd/MM/yyyy') }
				</td>
			</tr>
			<tr>
				<td>(ii)</td>
				<td colspan="2">
					
					<b>Type of exercise:</b>  
				
				</td>
				<td colspan="3">
					<g:if test="${appForm?.typeOfExercise == 'multipleTime'}">
						Multiple-time Exercise
					</g:if>
					<g:else>
						One-time Exercise
					</g:else>
				</td>
			</tr>
			
			<g:if test="${appForm?.typeOfExercise == 'multipleTime'}">
					<tr>
						<td>(iii)</td>
						<td colspan="2">
							
							<b>How many times going to send /carry the biological resources?</b>  
						
						</td>
						<td colspan="3">
							${appForm?.numOfTimesOfSending }
						</td>
					</tr>
					
					<tr>
						<td>(iv)</td>
						<td colspan="2">
							
							<b>Explain the reasons for sending /carrying the multiple times</b>  
						
						</td>
						<td colspan="3">
							${appForm?.reasonsForSending }
						</td>
					</tr>
			</g:if>
			
			
            <tr>
              <td><b>13</b></td>
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
              <td><b>14</b></td>
              <td style="width:35%!important"><b>Name of the funding agency supporting the proposed research</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="2">
              
              <g:if test="${formDetails?.formBFundingAgency}">
              <g:each var="fund" in="${formDetails?.formBFundingAgency}">
              ${fund?.institutionOrganizationName}
              </g:each>
              </g:if></td>
              <td  colspan="2"><g:textField name="fundingRemk"
				value="${formRemkInstance?.fundingRemk}" class = "remark"/>  </td>
            </tr>
             <tr>
              <td><b>15</b></td>
              <td style="width:35%!important"><b>If it is for emergency purpose, specify details</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="2">${formDetails?.emergencyDetails}</td>
              <td colspan="4"><g:textField name="emergencyRemk"
				value="${formRemkInstance?.emergencyRemk}" class = "remark"/>  </td>
            </tr>
            
            <tr>
              <td><b>16</b></td>
              <td colspan="5"><b>Whether the listed species notified under section 38 of the BD Act?</b></td>
              <tr>
              <td></td>
              <td colspan="5">
              <table class="table table-bordered">
              <thead>
                  <tr>
                    <th><b>S. no</b></th>
                    <th><b>Common name</b></th>
                    <th><b>Scientific name</b></th>
                    <th><b>Status</b></th>
                    <th><b>Remarks</b></th>
                  </tr>
                  </thead>
                <tbody>
                <tr>
                
                
                </tr>
                
                </tbody>  
                  
                  
                  
              </table>
              
              
              
              </td>
              </tr>
            <tr>
              <td><b>17</b></td>
              <td style="width:35%!important"><b>Whether duly filled in and signed Undertaking and Declarations of the applicant/ supervisor/recipient are attached?</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
         
             <g:if
			test="${formRemkInstance?.signedUndertaking == '' || formRemkInstance?.signedUndertaking == null }">
			<td colspan="2"><g:radio value="true" name="signedUndertaking" />Yes
				<g:radio value="false" name="signedUndertaking" /> No</td>

		</g:if>
		<g:elseif test="${formRemkInstance?.signedUndertaking == true}">
			<td colspan="2"><g:radio value="true" checked="true"
					name="signedUndertaking" />Yes <g:radio value="false" name="signedUndertaking" />
				No</td>
		</g:elseif>
		<g:elseif test="${formRemkInstance?.signedUndertaking == false}">
			<td colspan="2"><g:radio value="true" name="signedUndertaking" />Yes
				<g:radio value="false" checked="true" name="signedUndertaking" /> No</td>
		</g:elseif>
              <td colspan="4"><g:textField name="signedUndertakingRmk"
				value="${formRemkInstance?.signedUndertakingRmk}" class = "remark"/></td>
            </tr>

          
            <tr>
              <td><b>18</b></td>
              <td style="width:35%!important"><b>Whether the application contains all required technical information</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
             <g:if
			test="${formRemkInstance?.technicalInformation == '' || formRemkInstance?.technicalInformation == null }">
			<td colspan="2"><g:radio value="true" name="reqTechInfo" />Yes
				<g:radio value="false" name="reqTechInfo" /> No</td>

		</g:if>
		<g:elseif test="${formRemkInstance?.technicalInformation == true}">
			<td colspan="2"><g:radio value="true" checked="true"
					name="reqTechInfo" />Yes <g:radio value="false" name="reqTechInfo" />
				No</td>
		</g:elseif>
		<g:elseif test="${formRemkInstance?.technicalInformation == false}">
			<td colspan="2"><g:radio value="true" name="reqTechInfo" />Yes
				<g:radio value="false" checked="true" name="reqTechInfo" /> No</td>
		</g:elseif>
              <td colspan="4"><g:textField name="techInfo"
				value="${formRemkInstance?.technicalInformationRmk}" class = "remark"/></td>
            </tr>
          </table>