
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
		<td style="width: 35% !important"><b>Online Application
				number</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">
			${formDetails?.appNumber}
		</td>
		<td colspan="2"><g:textField  class="remark" name="appnumber" 
				value="${formRemkInstance?.onlineAppNumberRmk}" /></td>
	</tr>
	<tr id="rec-2">
		<td><b><span class="sn">2</span></b></td>
		<td style="width: 35% !important"><b>NBA Reference number</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan"><g:textField  class="remark"   name="refNumber"
				value="${formRemkInstance?.nbaRefNumber}" /></td>
		
		<td colspan="2"><g:textField  class="remark" name="nbaRefNumberRemark"
				value="${formRemkInstance?.nbaRefNumberRemark}" /></td>
	</tr>
	<tr id="rec-3">
		<td><b><span class="sn">3</span></b></td>
		<td style="width: 35% !important"><b>Applicant category</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">   	<g:if test="${formDetails?.individualProfiles}">Individual</g:if>
               <g:elseif test="${formDetails?.companyProfiles}">
				<g:each in="${formDetails?.companyProfiles}" var="ct">
				${ct?.entityType }
				</g:each>
				</g:elseif>
				 <g:elseif test="${formDetails?.indianGovtInst}">Government</g:elseif> 
				 <g:elseif test="${formDetails?.depostionOfMicroOrganism}">Micro</g:elseif>
				<g:elseif test="${formDetails?.indianResearcher}">Indian-Researcher</g:elseif></td>
		
		<td colspan="2"><g:textField  class="remark" name="appltcatg"
				value="${formRemkInstance?.applicantCatgRmk}" /></td>
	</tr>
	<tr>
		<td><b><span class="sn">4</span></b></td>
		<td style="width: 35% !important"><b>Name of the applicant
				and contact details</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan"><g:if
				test="${formDetails?.individualProfiles}">
				<g:each in="${formDetails?.individualProfiles}"
					var="individualProfile">

					${individualProfile?.title}
					${individualProfile?.firstName}
					${individualProfile?.middleName}
					${individualProfile?.lastName}<br/>
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
					${researcher?.lastName}<br/>
					${researcher?.address1}
					${researcher?.address2}
					${researcher?.address3}
					${researcher?.presentCity}
				</g:each>
			</g:elseif> <g:elseif test="${formDetails?.depostionOfMicroOrganism}">
				<g:each in="${formDetails?.depostionOfMicroOrganism}" var="depost">
					${depost?.nameOfDepositor}<br/>
					${depost?.address1}
					${depost?.address2}
					${depost?.address3}
					${depost?.city}
				</g:each>
			</g:elseif> <g:elseif test="${formDetails?.indianGovtInst}">
				<g:each in="${formDetails?.indianGovtInst}" var="govt">
					${govt?.govtInstName}<br/>
					${govt?.address1}
					${govt?.address2}
					${govt?.address3}
					${govt?.presentCity}
				</g:each>
			</g:elseif></td>
		
		<td colspan="2"><g:textField  class="remark" name="appltname"
				value="${formRemkInstance?.applicantNameContRmk}" /></td>
	</tr>
	<tr>
		<td><b>5</b></td>
		<td style="width: 35% !important"><b>Name and Address of the
				contact person/ authorized person of the company</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan"><g:if test="${formDetails?.companyProfiles}">
		<g:each in="${formDetails?.companyProfiles}" var="comp">
		${comp?.title}
				${comp?.firstName}
				${comp?.middleName}
				${comp?.lastName} <br/>
		Designation:${comp?.designation} <br/>
		Mobile:${comp?.personMobile} <br/>
	    Email:${comp?.personEmail}
		</g:each>
				
			</g:if> <g:else>No</g:else></td>
		
		<td colspan="2"><g:textField  class="remark" name="nameandComp"
				value="${formRemkInstance?.authPersonContRmk}" /></td>
	</tr>
	<tr>
		<td><b>6</b></td>
		<td style="width: 35% !important"><b>Name and address of the
				contact person/ agent/ attorney, in India</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">
			<g:if test="${formDetails?.agentProfile}">
			${formDetails?.agentProfile?.title} ${formDetails?.agentProfile?.firstName}
			${formDetails?.agentProfile?.middleName} ${formDetails?.agentProfile?.lastName}<br/>
			${formDetails?.agentProfile?.address1} ${formDetails?.agentProfile?.address2}
			${formDetails?.agentProfile?.address3}<br/>
			 ${formDetails?.agentProfile?.city}
			</g:if>
			
			<g:else>No</g:else>
		</td>
		
		<td colspan="2"><g:textField  class="remark" name="agent"
				value="${formRemkInstance?.attorneyInIndiaContRmk }" /></td>
	</tr>
	<tr>
		<td><b>7</b></td>
		<td style="width: 35% !important"><b>Category of Application
				Form</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">
			Form I
		</td>
		
		<td colspan="2"><g:textField  class="remark" name="formCatg"
				value="${formRemkInstance?.appFormCatgRmk}" /></td>
	</tr>
	<tr>
		<td><b>8</b></td>
		<td style="width: 35% !important"><b>Whether Address Proof
				and ID proof matching with the details mentioned above </b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>

		<g:if test="${formRemkInstance?.idAndAddress == true}">
			<td><g:radio name="whrIdProofMtc"
					value="true" checked="true" id="wheatherYes" /> Yes <g:radio
					name="whrIdProofMtc" value="false" id="wheatherNo" /> No</td>
		</g:if>
		<g:elseif test="${formRemkInstance?.idAndAddress == false}">
			<td><g:radio name="whrIdProofMtc"
					value="true" id="wheatherYes" /> Yes <g:radio name="whrIdProofMtc"
					checked="true" value="false" id="wheatherNo" /> No</td>

		</g:elseif>
		<g:elseif
			test="${formRemkInstance?.idAndAddress == '' || formRemkInstance?.idAndAddress == null }">
			<td><g:radio name="whrIdProofMtc"
					value="true" id="wheatherYes" /> Yes <g:radio name="whrIdProofMtc"
					value="false" id="wheatherNo" /> No</td>

		</g:elseif>
		<td colspan="2"><g:textField  class="remark" name="whrIdProof"
				value="${formRemkInstance?.idAndAddressRemark}" /></td>
	</tr>
	<tr>
		<td><b>9</b></td>
		<td colspan="5"><b>Details of biological resources and/ or
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
					<td><b>Time span in which the biological resource to be
							accessed</b></td>
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
				<td>${bioRemarks?.chkQuantity}</td>

				<td>${bioRemarks?.chkFromtime}to ${bioRemarks?.chkTotime}</td>
				
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
							<td>
							<g:hiddenField  name="chkQuantity" value="${resource?.quantity+ '-'+resource?.qtyUnit}"/>
								${resource?.quantity +'-'+resource?.qtyUnit}
							</td>
							<td>
								<g:formatDate format="dd/MM/yyyy" date="${resource?.fromTime}"/>
								<g:hiddenField name="chkFromtime" value="${resource?.fromTime}"/>
								                           to
								<g:formatDate format="dd/MM/yyyy" date="${resource?.toTime}"/>
								<g:hiddenField name="chkTotime" value="${resource?.toTime}"/>
							</td>
							<td><g:textField  class="remark" name="resremk"
									value="${formRemkInstance?.biologicalResRmk}" /></td>
							</tr>
						</g:each>
					
				</g:elseif>
			</table></td>
	</tr>
	<tr>
		<td><b>10</b></td>
		<td colspan="5"><b>Geographical location of the biological
				resources to be accessed
				
			
				</b>
				<table class="table table-bordered">
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
		<td><b>11</b></td>
		<td style="width: 35% !important"><b>Description/nature of
				traditional knowledge (oral/documented)</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">
		${formDetails?.nature}<br />
		
		<g:if test="${formDetails?.nature != 'No'}">
		<b>Details:</b><br/>
		${formDetails?.traditionalKnowledgeDesc}
		</g:if>
		</td>
		<td colspan="2"><g:textField  class="remark" name="oralKnow"
				value="${formRemkInstance?.oralRemark}" /></td>
	</tr>
	<tr>
		<td><b>12</b></td>
		<td style="width: 35% !important"><b>Geographical location of
				the community/individual</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan"><g:if test="${formDetails?.locations}">
				<g:each in="${formDetails?.locations}" var="location">
				
				    ${location?.consentObtained}<br/>
				     <b>Geo Location</b><br/>
<%--					${location?.communityKnowledge }--%>
					${location?.village }
					${location?.town }
					${location?.district}
				</g:each>
			</g:if>
			<g:else>
			No
			</g:else>
			
			</td>
		<td  colspan="2"><g:textField  class="remark" name="community"
				value="${formRemkInstance?.giolocCommunityRmk}" /></td>
	</tr>
	<tr>
		<td><b>13</b></td>
		<td colspan="5"><b>Name and number of the persons
				authorized by the applicant for making selection</b>
				<g:if test= "${formDetails?.selfAuthorizedPerson}">
				--<i>Self</i>
				</g:if>
				<g:elseif test= "${!formDetails?.selfAuthorizedPerson }">
				<table class="table table-bordered">
				<tr>
					<td><b>S. no</b></td>
					<td><b>Name</b></td>
					<td><b>Address</b></td>
					<td><b>Mobile</b></td>
					<td><b>Email</b></td>
					<td><b>Remarks</b></td>
				</tr>
				
		<g:if test="${formRemkInstance?.checklistContacts}">
		<g:each in="${formRemkInstance?.checklistContacts}" var="cont" status="l">
		<tr>
		<td>${l+1 }</td>
		<td>${cont?.contName}</td>
		<td>${cont?.contAdd}</td>
		<td>${cont?.contMobile}</td>
		<td>${cont?.contEmail}</td>
		<td>${cont?.contRemk}</td>
		</tr>
		</g:each>
		</g:if>		
				<g:else test="${formDetails?.contactPersons}">
					<g:each in="${formDetails?.contactPersons}" var="contPerson"
						status="x">
					<tr>

						<td>
							${x+1 }
						</td>
						<td>
							${contPerson?.nameOfContactPerson}
							<g:hiddenField name="contName" value="${contPerson?.nameOfContactPerson}"/>
						</td>
						<td>
							${contPerson?.addressOfContactPerson}
							<g:hiddenField name="contAdd" value="${contPerson?.addressOfContactPerson}"/>
						</td>
						<td>
							${contPerson?.mobileOfContactPerson}
							<g:hiddenField name="contMobile" value="${contPerson?.mobileOfContactPerson}"/>
						</td>
						<td>
							${contPerson?.emailOfContactPerson}
							<g:hiddenField name="contEmail" value="${contPerson?.emailOfContactPerson}"/>
						</td>
						<td> 
						
						<g:textField  class="remark" name="personsAuth"
								value="${formRemkInstance?.nameAuthByApplicantRmk}" />
								
								</td>
					</tr>
						</g:each>
				</g:else>

			</table>
			</g:elseif>
			</td>
	</tr>
	<tr>
		<td><b>14</b></td>
		<td style="width: 35% !important"><b>Proposed use of
				biological resources and/or associated knowledge</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">${formDetails?.purposeOfProposal}</td>
		<td  colspan="2"><g:textField  class="remark" name="proposed"
				value="${formRemkInstance?.assoKnowledgeRmk}" /></td>
	</tr>
	<tr>
		<td><b>15</b></td>
		<td style="width: 35% !important"><b>Objective for seeking
				NBA's approval</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td>
		${formDetails?.briefDescription}
		
		
		</td>
		<td  colspan="2"><g:textField  class="remark" name="nbaApprovalRmk"
				value="${formRemkInstance?.nbaApprovalRmk}" /></td>
	</tr>
	<tr>
		<td><b>16</b></td>
		<td colspan="6"><b>Whether listed in
				NTC/Rare/Endemic/Endangered/Threatned, Wildlife
				Act/CITIES/BDA/ITPGRFA</b>
				<g:link controller="checklist" action="getNtcData" target="_blank" params="${[csrfPreventionSalt:csrfPreventionSalt]}">NTC Details</g:link>
<%--	</tr>--%>
<%--	<tr>--%>
<%--		<td></td>--%>
		<table class="table table-bordered">
				<tr>
					<td><b>S. no</b></td>
					<td><b>Scientific name</b></td>
					<td><b>Status</b></td>
					<td><b>Part</b></td>
					<td><b>Remarks</b></td>
				</tr>
				<g:if test="${rare}">
				<g:each in="${rare}" var="ntc" status="i">
				<tr>
					<td>${i+1}</td>
					<td>${ntc?.bio_resource }</td>
					<td>${ntc?.status}</td>
					<td>${ntc?.part}</td>
					<td><g:textField name="ntc" class="remark" value="${formRemkInstance?.listedInRmk}"/></td>
				</tr>
				</g:each>
				</g:if><g:else>
				<tr><td colspan="4">No bioresource data is matching</td>
				<td><g:textField name="ntc" class="remark" value="${formRemkInstance?.listedInRmk}"/></td>
				</tr>
				</g:else>
			</table></td>
			
	</tr>
	<tr>
		<td><b>17</b></td>
		<td style="width: 35% !important"><b>Details of any national
				institution which will participate in the Research & Development
				activities</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan"><g:if
				test="${formDetails?.instituteParticipation == true}">
       ${formetails?.detailsOfInstitute}
			</g:if>
			<g:else>No</g:else>
			</td>
		<td  colspan="2"><g:textField  class="remark" name="resAndDev"
				value="${formRemkInstance?.dtsOfNationalInstRmk}" /></td>
	</tr>
	<tr>
		<td><b>18</b></td>
		<td style="width: 35% !important"><b>Where the research
				activities will be carried out</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td>
		
		<g:if test= "${formDetails?.instituteParticipation == 'true' }">
				Yes <br/>
				${formDetails?.detailsOfInstitute}<br/>
				${formDetails?.letterOfIntentName}
			</g:if>
			<g:else>
				No
			</g:else>	
		
		
		</td>
		<td  colspan="2"><g:textField  class="remark" name="carriedOut"
				value="${formRemkInstance?.researchActivitiesRmk}" /></td>
	</tr>
	
<tr>
	<td><b>19</b></td>
	<td style="width: 35% !important"><b>Proposed mechanism and
			arrangement for benefit sharing</b></td>
	<td class="text-center" style="width: 1px;"><b>:</b></td>
	<g:if
		test="${formRemkInstance?.benefitSharing == '' || formRemkInstance?.benefitSharing == null }">
		<td class="colspan"><g:radio value="true" name="benefitShr" />
			Yes <g:radio value="false" name="benefitShr" /> No</td>

	</g:if>
	<g:elseif test="${formRemkInstance?.benefitSharing == true}">
		<td class="colspan"><g:radio value="true" checked="true"
				name="benefitShr" /> Yes <g:radio value="false" name="benefitShr" />
			No</td>
	</g:elseif>
	<g:elseif test="${formRemkInstance?.benefitSharing == false}">
		<td class="colspan"><g:radio value="true" name="benefitShr" />
			Yes <g:radio value="false" name="benefitShr" checked="true" /> No</td>
	</g:elseif>

	<td  colspan="2"><g:textField  class="remark" name="bfsh"
			value="${formRemkInstance?.benefitSharingRmk}" /></td>
	</tr>
	<tr>
		<td><b>20</b></td>
		<td style="width: 35% !important"><b>Whether the application
				contains all required technical information</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<g:if
			test="${formRemkInstance?.technicalInformation == '' || formRemkInstance?.technicalInformation == null }">
			<td><g:radio value="true" name="reqTechInfo" />Yes
				<g:radio value="false" name="reqTechInfo" /> No</td>

		</g:if>
		<g:elseif test="${formRemkInstance?.technicalInformation == true}">
			<td><g:radio value="true" checked="true"
					name="reqTechInfo" />Yes <g:radio value="false" name="reqTechInfo" />
				No</td>
		</g:elseif>
		<g:elseif test="${formRemkInstance?.technicalInformation == false}">
			<td><g:radio value="true" name="reqTechInfo" />Yes
				<g:radio value="false" checked="true" name="reqTechInfo" /> No</td>
		</g:elseif>
		<td  colspan="2"><g:textField  class="remark" name="techInfo"
				value="${formRemkInstance?.technicalInformationRmk}" /></td>
	</tr>
	<tr>
		<td><b>21</b></td>
		<td style="width: 35% !important"><b>Whether SBB/BMC
				Consultation is required ${formRemkInstance?.sbbBmc}</b></td>
				<td class="text-center" style="width: 1px;"><b>:</b></td>
				<g:if
			test="${formRemkInstance?.sbbBmc == '' || formRemkInstance?.sbbBmc == null}">
			<td><g:radio value="true" name="sbbMbs" onclick="locationSelect(this)" />Yes
				<g:radio value="false" name="sbbMbs" onclick="locationSelect(this)"/> No</td>

		</g:if>
		
		<g:elseif test="${formRemkInstance?.sbbBmc == true}">
			<td><g:radio value="true" checked="true"
					name="sbbMbs" onclick="locationSelect(this)" />Yes <g:radio value="false" name="sbbMbs"  onclick="locationSelect(this)"/> No</td>
		</g:elseif>

		<g:elseif test="${formRemkInstance?.sbbBmc == false}">
			<td><g:radio value="true" name="sbbMbs" onclick="locationSelect(this)" />Yes
				<g:radio checked="true" value="false" name="sbbMbs" onclick="locationSelect(this)" /> No</td>
		</g:elseif>
		<td  colspan="2"><g:textField  class="remark" name="sbb"
				value="${formRemkInstance?.sbbBmcRmk}" /></td>
				

	</tr>
	

	<tr>
		<td><b>22</b></td>
		<td><b>Geographical Locations</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		
		<td id="selLoc">
		
		<g:select name="gioState"  id="mySelect" open multiple class="form-control"
				from="${listOfStates}" optionKey="state" optionValue= "${{it.state}}"
				value="${formRemkInstance?.gioLocation}"/>

		</td>
								
       <td colspan="2">
	<p id="demo"></p>
 <g:each in="${formRemkInstance?.gioLocation}" status="i" var="a">
     <li> ${a} </li>
 </g:each>		
	</td>
</tr>




	<tr>
		<td><b>23</b></td>
		<td><b>Question</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td colspan="2"><g:textArea style="width: 100%; display:none;" class="form-control" name="ques" value="${formRemkInstance?.question}" /></td>
				<g:if test="${formRemkInstance == null || formRemkInstance == ''}">
<%--				<td><input type="button" value="Add Question" id="morQues" name="23" class="btn btn-primary" onclick="addQuestionTr(this);"/></td>--%>
		
		<td>
        <a class="btn btn-primary pull-right add-record" data-added="0"><i class="glyphicon glyphicon-plus"></i> Add Questions</a>
      </td>
		
		</g:if>
		 <g:else><td></td></g:else>
	</tr>
	

<g:if test="${formRemkInstance != null || formRemkInstance != ''}">
<g:each in="${formRemkInstance?.questionAnswers}" var="quesAnswer" status="k">
<tr id="all${k+1 }">
<td><b><span class="sn"  id="srl${k+1}">${k+24}</span></b></td>
<td><g:textArea name="quesValues${k+1}" id="qut${k+1}" value="${quesAnswer?.question}" rows="3" cols="45"></g:textArea></td>
<td><b>:</b></td>
<td><g:textArea name="ansValues${k+1}" id="qes${k+1}" value="${quesAnswer?.answer}" rows="3" cols="45"></g:textArea></td>
<td>
<input type="button" onclick="updateQuestion(this);" style="margin:15%" class="btn btn-success" value="Update" id="upd${k+1}" name="${quesAnswer?.id}"/></td>
<%--<g:remoteLink  controller="checklist" action="deleteQuestion" id="rem${k+1}" params="${[deleteIns:quesAnswer?.id]}"  onSuccess="removeTextBoxes(this);">Remove</g:remoteLink>--%>
<td><input type="button" onclick="deleteQues(this);" value="Remove" style="margin-top:20%" id="rem${k+1}" name="${quesAnswer?.id}" class="btn btn-danger"  />
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

