
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
		<td class="colspan">  	<g:if test="${formDetails?.individualProfiles}">Individual</g:if>
               <g:elseif test="${formDetails?.companyProfiles}">
				<g:each in="${formDetails?.companyProfiles}" var="ct">
				${ct?.entityType }
				</g:each>
				</g:elseif>
				 <g:elseif test="${formDetails?.indianGovtInst}">Government</g:elseif> 
				 <g:elseif test="${formDetails?.depostionOfMicroOrganism}">Micro</g:elseif>
				<g:elseif test="${formDetails?.indianResearcher}">Indian-Researcher</g:elseif></td>

		<td colspan="2"><g:textField name="appltcatg"  class="remark"
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
		<td colspan="2"><g:textField name="appltname"  class="remark"
				value="${formRemkInstance?.applicantNameContRmk}" /></td>
	</tr>
	<tr>
		<td><b>5</b></td>
		<td style="width: 50% !important"><b>Name and Address of the
				contact person/ authorized person of the company</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan"><g:if test="${formDetails?.companyProfiles}">
<g:each in="${formDetails?.companyProfiles}" var="authPerson">
				${authPerson?.title}
				${authPerson?.firstName}
				${authPerson?.middleName}
				${authPerson?.lastName} <br/>
		Designation:${authPerson?.designation} <br/>
		Mobile:${authPerson?.personMobile} <br/>
	  Email:${authPerson?.personEmail}
</g:each>
			</g:if> <g:else>No</g:else></td>
		<td colspan="2"><g:textField name="nameandComp"  class="remark"
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
			${formDetails?.agentProfile?.middleName} ${formDetails?.agentProfile?.lastName}<br />
		Address:${formDetails?.agentProfile?.address1} ${formDetails?.agentProfile?.address2}
			${formDetails?.agentProfile?.address3}<br /> 
			City:${formDetails?.agentProfile?.city}
			</g:if>
			
			<g:else>No</g:else>
		</td>
		<td colspan="2"><g:textField name="agent"  class="remark"
				value="${formRemkInstance?.attorneyInIndiaContRmk }" /></td>
	</tr>
	<tr>
		<td><b>7</b></td>
		<td style="width: 50% !important"><b>Category of Application
				Form</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan">Form II</td>
		<td colspan="2"><g:textField name="formCatg"  class="remark"
				value="${formRemkInstance?.appFormCatgRmk}" /></td>
	</tr>
	<tr>
		<td><b>8</b></td>
		<td style="width: 50% !important"><b>Whether Address Proof
				and ID proof matching with the details mentioned above </b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<g:if test="${formRemkInstance?.idAndAddress == true}">
			<td ><g:radio name="whrIdProofMtc"
					value="true" checked="true" id="wheatherYes" /> Yes <g:radio
					name="whrIdProofMtc" value="false" id="wheatherNo" /> No</td>
		</g:if>
		<g:elseif test="${formRemkInstance?.idAndAddress == false}">
			<td ><g:radio name="whrIdProofMtc"
					value="true" id="wheatherYes" /> Yes <g:radio name="whrIdProofMtc"
					checked="true" value="false" id="wheatherNo" /> No</td>

		</g:elseif>
		<g:elseif
			test="${formRemkInstance?.idAndAddress == '' || formRemkInstance?.idAndAddress == null }">
			<td><g:radio name="whrIdProofMtc"
					value="true" id="wheatherYes" /> Yes <g:radio name="whrIdProofMtc"
					value="false" id="wheatherNo" /> No</td>
		</g:elseif>
		<td colspan="2"><g:textField name="whrIdProof" class="remark"
				value="${formRemkInstance?.idAndAddressRemark}" /></td>
	</tr>

<tr>
		<td><b>9</b></td>
		<td colspan="5"><b>Details of results of
				research conducted</b>
                <table class="table table-bordered">
				<tr>
					<td><b>S. no</b></td>
                    <td colspan="4"></td>
				</tr>
				
				<tr>
				<td style="width:8%"><b>9 (a)</b></td>
		<td style="width:24%"><b>Details of research conducted</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td style="width:35%; text-align:justify">
			${formDetails?.briefDescription}
		</td>
		<td colspan="2"><g:textField name="resConducted" class="remark"
				value="${formRemkInstance?.resConducted}" /></td>
	</tr>
	<tr>
		<td style="width:8%"><b>9 (b)</b></td>
		<td style="width:24%"><b>Type of results of
				research to be transferred</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td style="width:35%; text-align:justify">
			${formDetails?.resultsOfResearch}
		</td>
		<td colspan="2"><g:textField name="resOfReserch" class="remark"
				value="${formRemkInstance?.resOfReserch}" /></td>
	</tr>
    </table></td>
	</tr>
	<tr>
		<td><b>10</b></td>
		<td colspan="5"><b>Details of biological resources and
				associated knowledge used in the research</b>
				<table class="table table-bordered">
				<tr>
					<td><b>S. no</b></td>
					<td><b>Intend to access</b></td>
					<td><b>Common name</b></td>
					<td><b>Scientific name</b></td>
					<td><b>Nature of biological resources</b></td>
					<td><b>Source of access</b></td>
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
<%--							<g:textField name="chkname" value="${resource?.name?:'NA'}" readonly="true"/>--%>
							${resource?.accessIntention?:'NA'}	
							</td>
							<td>
							<g:hiddenField name="chkcommonName" value="${resource?.commonName?:'NA'}"/>
<%--							<g:textField name="chkcommonName" value="${resource?.commonName?:'NA'}" readonly="true"/>--%>
								${resource?.commonName?:'NA'}
							</td>
							<td>
							<g:hiddenField name="chkscientificName" value="${resource?.scientificName?:'NA'}" />
<%--							<g:textField name="chkscientificName" value="${resource?.scientificName?:'NA'}" readonly="true"/>--%>
								${resource?.scientificName?:'NA'}
							</td>
							<td>
							<g:hiddenField name="chknature" value="${resource?.nature?:'NA'}"/>
<%--							<g:textField name="chknature" value="${resource?.nature?:'NA'}" readonly="true"/>--%>
								${resource?.nature?:'NA'}
							</td>
							<td>
							<g:hiddenField  name="chkbiologicalResource" value="${resource?.biologicalResource?:'NA'}"/>
<%--							<g:textField name="chkbiologicalResource" value="${resource?.biologicalResource?:'NA'}" readonly="true"/>--%>
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
		<td colspan="5"><b>Geographical location of biological
				resources used in the research</b>
				<table class="table table-bordered">
				<tbody>
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
				</tbody>
			</table></td>
	</tr>
	<tr>
		<td><b>12</b></td>
		<td style="width: 50% !important"><b>Description/nature of
				traditional knowledge (oral/documented)</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td style="text-align:justify">
		<g:if test="${formDetails?.individualProfiles}">
			${formDetails?.nature}<br /> <g:if
				test="${formDetails?.nature != 'No'}">
				<b>Details:</b><br/>
				${formDetails?.traditionalKnowledgeDesc}
			</g:if>
			</g:if>
			<g:if test="${formDetails?.companyProfiles}">
			${formDetails?.isNoForTraditional}
			<g:if test= "${formDetails?.isNoForTraditional != 'No' }">
			<b>Description</b><br/>
				
					${formDetails?.traditionalKnowledgeDesc}
			</g:if>
			
			</g:if>
		</td>
		
		<td colspan="2"><g:textField name="oralKnow" class="remark"
				value="${formRemkInstance?.oralRemark}" /></td>
	</tr>
	<tr>
		<td><b>13</b></td>
		<td style="width: 50% !important"><b>Geographical location of
				the community/individual</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td><g:if test = "${formDetails?.locations}">
				<g:each in="${formDetails?.locations}" var="location">
				 ${location?.consentObtained}<br/>
				    <b>Geo Location</b><br/>
<%--					${location?.communityKnowledge}--%>
					${location?.village}
					${location?.town}
					${location?.district}
				</g:each>
			</g:if>
			<g:else>No</g:else>
			
			
			</td>
		<td colspan="2"><g:textField name="community" class="remark"
				value="${formRemkInstance?.giolocCommunityRmk}" /></td>
	</tr>
	<tr>
		<td><b>14</b></td>
		<td style="width: 50% !important"><b>Consent obtained from
				the community/individual</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td>
		
			<g:if test="${formDetails?.locations?.consentObtained != 'No'}">
				<g:each in="${formDetails?.locations}" var="consent">
				${consent?.consentObtained}<br />
				<b>Address:</b><br/>
					${consent?.communityKnowledge}
					${consent?.village}
					${consent?.town}
					${consent?.district}
					${consent?.state}
				</g:each>
			</g:if>
		
		<g:if  test="${formDetails?.isNoForTraditional == 'No'}">
			No
			</g:if>
			
			
			</td>
		<td colspan="2"><g:textField  class="remark" name="consObtained"
				value="${formRemkInstance?.consObtained}" /></td>
	</tr>
	<tr>
		<td><b>15</b></td>
		<td colspan="5"><b>Details of institution
				where R&amp;D activities carried out</b>
                <table class="table table-bordered">
				<tr>
					<td><b>S. no</b></td>
                    <td colspan="4"></td>
				</tr>
				<tr>
		<td style="width:8%"><b>15 (a)</b></td>
		<td style="width: 24%"><b>Provide the name and
				contact details of the institution / organisation where R&amp;D was
				carried out</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td style="width:35%; text-align:justify">
			${formDetails?.detailsOfInstitute}
		</td>
		<td colspan="2"><g:textField name="instOrganisation" class="remark"
				value="${formRemkInstance?.instOrganisation}" /></td>
	</tr>	
	</table></td>	
	</tr>
	<tr>
		<td><b>16</b></td>
		<td colspan="5">
		<table class="table table-bordered">
	<tr>
		<td style="width:8%"><b>(a)</b></td>
		<td style="width: 24% !important"><b>Details of individual/
				organisation to whom the research results are intended to be
				transferred</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td style="width:35%; text-align:justify">
			${formDetails?.detailsOfIndividualOrOrganisation}
		</td>
		<td colspan="2"></td>
	
	</tr>
	<tr>
		<td style="width:8%"><b>(b)</b></td>
		<td style="width: 24% !important"><b>Name and contact details
				of individual / organisation</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td style="width:35%; text-align:justify"></td>
		<td colspan="2"><g:textField name="individualOrg" class="remark"
				value="${formRemkInstance?.individualOrg}" /></td>
	</tr>
	<tr>
		<td style="width:8%"><b>(c)</b></td>
		<td style="width: 24% !important"><b>Details of the intended
				use of research results by the transferee</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td style="width:35%; text-align:justify">${formDetails?.useofResearchResults}</td>
		<td colspan="2"><g:textField name="intendedUseOfResearch" class="remark"
				value="${formRemkInstance?.intendedUseOfResearch}" /></td>
	</tr>
	</table></td>	
	</tr>
	<tr>
		<td><b>17</b></td>
		<td style="width: 50% !important"><b>Details of economic,
				biotechnological, scientific or any other benefits that are
				intended, or may accrue to the individual / organization due to
				commercialization of transferred research results</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td>${formDetails?.benefitsToTheIndividualOrOrganization}</td>
		<td colspan="2"><g:textField name="biotechnological" class="remark"
				value="${formRemkInstance?.biotechnological}" /></td>
	</tr>
	<tr>
		<td><b>18</b></td>
		<td style="width: 50% !important"><b>Details of economic,
				biotechnological, scientific or any other benefits that are
				intended, or may accrue to the applicant seeking approval for
				transfer of results of research</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		<td class="colspan" style="text-align:justify">${formDetails?.benefitsToTheApplicant}</td>
		<td colspan="2"><g:textField name="seekApproval" class="remark"
				value="${formRemkInstance?.seekApproval}" /></td>
	</tr>
	<tr>
		<td><b>19</b></td>
		<td style="width: 50% !important"><b>Whether the application
				contains all the required technical information</b></td>
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
<td colspan="2"></td>
	</tr>
	<tr>
		<td><b>20</b></td>
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
		<td><b>21</b></td>
		<td><b>Geographical Locations</b></td>
		<td class="text-center" style="width: 1px;"><b>:</b></td>
		
		<td id="selLoc" >
		
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
		<td><b>22</b></td>
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
<tr id="all${k+1 }">
<td><b id="srl${k+1}"><span class="sn">${k+22}</span></b></td>
<td><g:textArea name="quesValues${k+1}" id="qut${k+1}" value="${quesAnswer?.question}" rows="3" cols="40"></g:textArea></td>
<td><b>:</b></td>
<td><g:textArea name="ansValues${k+1}" id="qes${k+1}" value="${quesAnswer?.answer}" rows="3" cols="40"></g:textArea></td>
<td style="width:15% !important">
<input type="button" onclick="updateQuestion(this);" class="btn btn-success" style="margin:15%" value="Update" id="upd${k+1}" name="${quesAnswer?.id}"/></td>
<%--<g:remoteLink  controller="checklist" action="deleteQuestion" id="rem${k+1}" params="${[deleteIns:quesAnswer?.id]}"  onSuccess="removeTextBoxes(this);">Remove</g:remoteLink>--%>
<td><input type="button" onclick="deleteQues(this);" value="Remove" id="rem${k+1}" name="${quesAnswer?.id}" class="btn btn-danger" style="margin-top:20%"  />
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


