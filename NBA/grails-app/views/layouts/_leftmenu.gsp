<%! import org.nba.user.NbaUser %>
<%! import org.nba.user.NbaRole%>
<%! import org.nba.application.ApplicationForm1 %>
<%! import org.nba.application.FormCategory %>
<%! import org.nba.user.NbaUserNbaRole %>


<g:set var="userObject" value="${NbaUser.findByUsername(sec.loggedInUserInfo(field:'username'))}" />
<g:set var="getNbaRole" value="${userObject?.nbaRole}"/>
<g:set var="getRoleDetails" value="${NbaRole.get(getNbaRole?.id)}"/>
<g:set var="getAuthority" value="${getRoleDetails?.authority}" />

 
<sec:ifAnyGranted roles="TECHNICAL_OFFICER_BS">
   <g:set var="getTechRole" value="TECHNICAL_OFFICER_BS" />
</sec:ifAnyGranted>
 
 
 <sec:ifAnyGranted roles="ACCOUNT_OFFICER">
   <g:set var="getAccountRole" value="ACCOUNT_OFFICER" />
</sec:ifAnyGranted>

<sec:ifAnyGranted roles="LEGAL_HEAD">
   <g:set var="getLegalHeadRole" value="LEGAL_HEAD" />
</sec:ifAnyGranted>

 
<g:set var="formID" value="${formDetails?.id}" />
<g:if test="${messageNote}">
<aside class="main-sidebar" style="background-color: #fff !important;" >
	<section class="sidebar" style="margin-top: 10px;">
		<ul class="sidebar-menu tree" data-widget="tree" id="hideForNote">
		
			<li class="formheading"
				style="border: 1px solid #f5dea0; padding: 10px; background: #748aa3; margin-bottom: 5px; text-align: center; color: #fff;">MENU</li>
			<li class=""><g:link controller="dashboard" action="dashboard" params="${[csrfPreventionSalt:csrfPreventionSalt]}">
					<i class="fa fa-dashboard"></i>
					<span>Dashboard</span>
				</g:link>
				</li>
				</ul>
				</section>
				</aside>
				

</g:if>
<g:else>
<aside class="main-sidebar" style="background-color: #fff !important;" >
	<section class="sidebar" style="margin-top: 10px;">
		<ul class="sidebar-menu tree" data-widget="tree" id="hideForNote">
		
			<li class="formheading"
				style="border: 1px solid #f5dea0; padding: 10px; background: #748aa3; margin-bottom: 5px; text-align: center; color: #fff;">MENU</li>
			<li class=""><g:link controller="dashboard" action="dashboard" params="${[csrfPreventionSalt:csrfPreventionSalt]}">
					<i class="fa fa-dashboard"></i>
					<span>Dashboard</span>
				</g:link>
				</li>

			<li class="treeview"><a href=""> <i class="fa fa-renren"></i>
					<span>Noting</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li><g:link controller="dashboard" action="noting"
							params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt]}">
							<i class="fa fa-circle-o"></i> View Note</g:link></li>
					<li><g:link controller="dashboard" action="addNote"
							params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt]}">
							<i class="fa fa-circle-o"></i>Add Note</g:link></li>

				</ul></li>
		<g:if test="${getAuthority == 'ACCOUNT_ASSISTANT_MEMBER' ||
			 getAuthority =='REVIEW_LEGAL_MEMBER'|| getAuthority == 'IPR_MEMBER'|| getAuthority == 'REVIEW_MEMBER' || getAuthority =='IPR_OFFICER_MEMBER' || getAuthority == 'REVIEW_IPR_MEMBER'}">
			<li class="treeview"><a href=""> <i
					class="fa fa-calendar-check-o"></i> <span>Checklist</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

		<g:if test="${getAuthority == 'ACCOUNT_ASSISTANT_MEMBER'}">
						<li><g:link controller="checklist" action="accountMembers"
								params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt]}">
								<i class="fa fa-circle-o"></i> Accounts Member</g:link></li></g:if>
			<g:if test="${getAuthority == 'REVIEW_MEMBER' || getAuthority == 'REVIEW_IPR_MEMBER'}">
						<li class="treeview">

								<g:link><i class="fa fa-circle-o"></i>Technical Review</g:link>
							<ul class="treeview-menu">
								

											<li><g:link controller="checklist"
													action="technicalReview"
													params="${[instanceId:formID,formType:formDetails?.category?.category,csrfPreventionSalt:csrfPreventionSalt]}">
													<i class="fa "></i>
													<g:if test="${formDetails?.category?.category == FormCategory?.Category?.Form_1 }">
													Form I
													</g:if>
													<g:if test="${formDetails?.category?.category == FormCategory?.Category?.Form_2 }">
													Form II
													</g:if>
													<g:if test="${formDetails?.category?.category == FormCategory?.Category?.Form_3 }">
													Form III
													</g:if>
													<g:if test="${formDetails?.category?.category == FormCategory?.Category?.Form_4 }">
													Form IV
													</g:if>
													
													<g:if test="${formDetails?.category?.category == FormCategory?.Category?.Form_B }">
													Form B
													</g:if>
												
												</g:link></li>
							</ul></li></g:if>
							<g:if test="${getAuthority =='REVIEW_LEGAL_MEMBER' || getAuthority =='IPR_MEMBER'}">
						<li class="treeview"><a href="#"><i
								class="fa fa-circle-o"></i> Legal Review</a>
							<ul class="treeview-menu">
								<li><g:link controller="checklist" action="legalHead"
										params="${[instanceId:formID,formType:formDetails?.category?.category,csrfPreventionSalt:csrfPreventionSalt]}">
										<i class="fa "></i>
										<g:if
											test="${formDetails?.category?.category == FormCategory?.Category?.Form_1 }">
													Form I
													</g:if>
										<g:if
											test="${formDetails?.category?.category == FormCategory?.Category?.Form_2 }">
													Form II
													</g:if>
										<g:if
											test="${formDetails?.category?.category == FormCategory?.Category?.Form_3 }">
													Form III
													</g:if>
										<g:if
											test="${formDetails?.category?.category == FormCategory?.Category?.Form_4 }">
													Form IV
													</g:if>
													
													<g:if
											test="${formDetails?.category?.category == FormCategory?.Category?.Form_B }">
													Form B
													</g:if>
									</g:link></li>
							</ul></li></g:if>
							<g:if test="${getAuthority =='IPR_MEMBER' || getAuthority == 'IPR_OFFICER_MEMBER'}">
						<li><g:link controller="checklist" action="iprRemark" params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt]}"><i
								class="fa fa-circle-o"></i> IPR Member</g:link></li></g:if>
				
				</ul>
			</li>
	</g:if>
	<g:if test="${getAuthority == 'ACCOUNT_ASSISTANT_MEMBER' || getAuthority == 'REVIEW_MEMBER'|| getAuthority == 'REVIEW_IPR_MEMBER' ||
			 getAuthority =='REVIEW_LEGAL_MEMBER'|| getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR'||
			  getAuthority =='IPR_OFFICER_MEMBER' || getAuthority == 'REVIEW_HEAD' ||  getAuthority == 'REVIEW_LEGAL_HEAD'||  getAuthority == 'LEGAL_HEAD'||
			 getAuthority =='IPR_MEMBER' || getAuthority == 'ACCOUNT_OFFICER'  || getAuthority =='DDO'|| getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN'}">
			<li class="treeview"><a href="#/accounts.html#"> <i
					class="fa fa-laptop"></i> <span>Communication Format</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				
			
				<ul class="treeview-menu">
				<g:if test="${getAuthority == 'ACCOUNT_ASSISTANT_MEMBER' || getAuthority == 'REVIEW_MEMBER'|| getAuthority == 'REVIEW_IPR_MEMBER' ||
			 getAuthority =='REVIEW_LEGAL_MEMBER'||  getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR'||
			 getAuthority =='IPR_MEMBER' || getAuthority =='IPR_OFFICER_MEMBER' || getAuthority == 'REVIEW_HEAD' ||  getAuthority == 'REVIEW_LEGAL_HEAD'||
			 getAuthority =='LEGAL_HEAD'|| getAuthority == 'ACCOUNT_OFFICER'|| getAuthority =='DDO' ||   getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN' }">
					<li><g:link controller="letterCommunication" action="createCommunication"
							params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt]}">
							<i class="fa fa-circle-o"></i>
							Create</g:link></li>
							</g:if>
							
			<g:if test="${getAuthority == 'ACCOUNT_ASSISTANT_MEMBER' || getAuthority == 'REVIEW_MEMBER'|| getAuthority == 'REVIEW_IPR_MEMBER' ||
			 getAuthority =='REVIEW_LEGAL_MEMBER'||  getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR'||
			 getAuthority =='IPR_MEMBER' || getAuthority =='IPR_OFFICER_MEMBER' || getAuthority == 'REVIEW_HEAD'
			 ||  getAuthority == 'REVIEW_LEGAL_HEAD'|| getAuthority =='LEGAL_HEAD'|| getAuthority == 'ACCOUNT_OFFICER'|| getAuthority =='DDO'  || getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN'}">
					<li><g:link controller="letterCommunication" action="draftCommunication"
							params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt]}">
							<i class="fa fa-circle-o"></i>
							Draft</g:link></li>
							</g:if>
							<g:if test="${getAuthority == 'REVIEW_HEAD' || getAuthority =='IPR_MEMBER'|| getAuthority == 'ACCOUNT_OFFICER'|| getAuthority =='DDO'
							 || getAuthority == 'REVIEW_LEGAL_HEAD'|| getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR'||
							 getAuthority =='SECRETARY' ||getAuthority =='LEGAL_HEAD'|| getAuthority =='CHAIRMAN'}">
					<li><g:link controller="letterCommunication" action="approveCommunication"
							params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt]}">
							<i class="fa fa-circle-o"></i>
							Approve</g:link></li></g:if>
				</ul></li></g:if>
				
				<g:if test="${getAuthority == 'ACCOUNT_ASSISTANT_MEMBER' || getAuthority == 'ACCOUNT_OFFICER'|| getAuthority =='DDO'}">
			<li class="treeview"><a href="#/accounts.html#"> <i
					class="fa fa-download"></i> <span>TR5 Receipt</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu" style="display: none;">
				<g:if test="${getAuthority == 'ACCOUNT_ASSISTANT_MEMBER'}">
					<li><g:link controller="letterCommunication" action="tr5Create"
							params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt]}">
							<i class="fa fa-circle-o"></i> Create</g:link></li></g:if>
							
						<g:if test="${getAuthority == 'ACCOUNT_ASSISTANT_MEMBER' || getAuthority == 'ACCOUNT_OFFICER'|| getAuthority =='DDO'}">	
					<li><g:link controller="letterCommunication" action="tr5Draft"
							params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt]}">
							<i class="fa fa-circle-o"></i> Draft</g:link></li></g:if>
							<g:if test="${getAuthority == 'ACCOUNT_OFFICER'|| getAuthority =='DDO'}">
					<li><g:link controller="letterCommunication" action="tr5Approve"
							params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt]}">
							<i class="fa fa-circle-o"></i> Approve</g:link></li></g:if>
				</ul></li></g:if>
				
			<g:if test="${getAuthority == 'REVIEW_MEMBER'|| getAuthority == 'REVIEW_IPR_MEMBER' || getAuthority == 'REVIEW_LEGAL_HEAD'||
			 getAuthority =='REVIEW_LEGAL_MEMBER'||  getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR'||
			 getAuthority =='IPR_MEMBER' || getAuthority =='IPR_OFFICER_MEMBER' || getAuthority == 'REVIEW_HEAD' || 
			 getAuthority =='LEGAL_HEAD' ||   getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN' }">
			<li class="treeview"><a href="#"> <i
					class="fa fa-info-circle"></i> <span>SBB Consent</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
				<g:if test="${getAuthority == 'REVIEW_MEMBER'|| getAuthority == 'REVIEW_IPR_MEMBER' || getAuthority == 'REVIEW_LEGAL_HEAD'||
			 getAuthority =='REVIEW_LEGAL_MEMBER'||  getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR'||
			 getAuthority =='IPR_MEMBER' || getAuthority =='IPR_OFFICER_MEMBER' || getAuthority == 'REVIEW_HEAD' || 
			 getAuthority =='LEGAL_HEAD' ||   getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN' }">
					<li><g:link controller="letterCommunication" action="sbbCreate" params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-circle-o"></i>
							Create</g:link></li>
							</g:if>
							<g:if test="${getAuthority == 'REVIEW_MEMBER'|| getAuthority == 'REVIEW_IPR_MEMBER' || getAuthority == 'REVIEW_LEGAL_HEAD'||
			 getAuthority =='REVIEW_LEGAL_MEMBER'||  getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR'||
			 getAuthority =='IPR_MEMBER' || getAuthority =='IPR_OFFICER_MEMBER' || getAuthority == 'REVIEW_HEAD' || 
			 getAuthority =='LEGAL_HEAD' ||   getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN' }">
					<li><g:link controller="letterCommunication" action="sbbDraft" params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-circle-o"></i>
							Draft</g:link></li></g:if>
							<g:if test="${getAuthority =='IPR_MEMBER'||getAuthority == 'TECHNICAL_OFFICER_BS' || getAuthority == 'TECHNICAL_OFFICER_IPR'|| getAuthority == 'REVIEW_HEAD'
			|| getAuthority == 'REVIEW_LEGAL_HEAD' || getAuthority == 'LEGAL_HEAD'|| getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN'}">
					<li><g:link controller="letterCommunication" action="sbbApprove" params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-circle-o"></i>
							Approve</g:link></li></g:if>
				</ul></li>
				</g:if>
				
				<li class=""><g:link controller="letterCommunication" action="allSentLetters"
					params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt]}"> <i
					class="fa fa-share-square-o"></i> <span>Sent/Dispatched</span>
				
			</g:link>
				</li>
				<li><g:link controller="letterCommunication" action="receivedCommunication" params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt] }"> <i class="fa fa-download"></i> <span>Received/Receipt</span>
			</g:link></li>

							<g:if test="${getAuthority == 'ACCOUNT_ASSISTANT_MEMBER' || getAuthority == 'REVIEW_MEMBER' || getAuthority == 'REVIEW_IPR_MEMBER'||
			 getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR'||getAuthority == 'ACCOUNT_OFFICER'|| getAuthority =='DDO'||
			 getAuthority =='IPR_MEMBER' || getAuthority =='IPR_OFFICER_MEMBER'|| getAuthority == 'REVIEW_HEAD' || getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN'}">
			
			<li class="treeview"><a href="#/accounts.html#"> <i
					class="fa fa-line-chart"></i> <span>Benefit Sharing</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
				<g:if test="${getAuthority == 'ACCOUNT_ASSISTANT_MEMBER' || getAuthority == 'REVIEW_MEMBER' || getAuthority == 'REVIEW_IPR_MEMBER'||
			 getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR'||getAuthority == 'ACCOUNT_OFFICER'|| getAuthority =='DDO'||
			 getAuthority =='IPR_MEMBER' || getAuthority =='IPR_OFFICER_MEMBER'|| getAuthority == 'REVIEW_HEAD' || getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN'}">
			
					<li><g:link controller="benefitSharing" action="receivedBenefit" params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-circle-o"></i>
							Received</g:link></li></g:if>
            <g:if test="${getAuthority == 'ACCOUNT_ASSISTANT_MEMBER' || getAuthority == 'REVIEW_MEMBER' || getAuthority == 'REVIEW_IPR_MEMBER'||
			 getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR'||getAuthority == 'ACCOUNT_OFFICER'|| getAuthority =='DDO'||
			 getAuthority =='IPR_MEMBER' || getAuthority =='IPR_OFFICER_MEMBER'|| getAuthority == 'REVIEW_HEAD' || getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN'}">
								<li><g:link controller="benefitSharing" action="distribution" params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-circle-o"></i>
							Distribution</g:link></li></g:if>
				</ul></li></g:if>
				
				
				<g:if test=" ${getAuthority == 'REVIEW_MEMBER'|| getAuthority == 'REVIEW_IPR_MEMBER' || getAuthority =='REVIEW_LEGAL_MEMBER'|| getAuthority == 'TECHNICAL_OFFICER_BS'||
				getAuthority == 'TECHNICAL_OFFICER_IPR'|| getAuthority =='IPR_OFFICER_MEMBER' || getAuthority == 'REVIEW_HEAD' ||  getAuthority == 'REVIEW_LEGAL_HEAD'||
			    getAuthority =='IPR_MEMBER'||  getAuthority == 'LEGAL_HEAD' || getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN'}">
				
			<li class="treeview"><a href="#/accounts.html#"> <i
					class="fa fa-calendar"></i> <span>Agenda</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
			<g:if test="${ getAuthority == 'REVIEW_MEMBER'|| getAuthority == 'REVIEW_IPR_MEMBER'|| 
			 getAuthority =='REVIEW_LEGAL_MEMBER'|| getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR'||
			  getAuthority =='IPR_OFFICER_MEMBER' || getAuthority == 'REVIEW_HEAD' ||  getAuthority == 'REVIEW_LEGAL_HEAD'||
			 getAuthority =='IPR_MEMBER'||  getAuthority == 'LEGAL_HEAD'}">
					<li><g:link controller="agenda" action="createAgenda" params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-circle-o"></i>
							Create</g:link></li></g:if>
							
						<g:if test="${ getAuthority == 'REVIEW_MEMBER'|| getAuthority == 'REVIEW_IPR_MEMBER' ||
			 getAuthority =='REVIEW_LEGAL_MEMBER'|| getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR'||
			  getAuthority =='IPR_OFFICER_MEMBER' || getAuthority == 'REVIEW_HEAD' ||  getAuthority == 'REVIEW_LEGAL_HEAD'||
			 getAuthority =='IPR_MEMBER'||  getAuthority == 'LEGAL_HEAD'|| getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN'}">
					<li><g:link controller="agenda" action="agendaDraft" params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-circle-o"></i>
							Draft</g:link></li></g:if>
							<g:if test="${getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN' || getAuthority == 'LEGAL_HEAD'||
			                  getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR' }">
					<li><g:link controller="agenda" action="agendaApprove" params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-circle-o"></i>
							Approve</g:link></li></g:if>
				</ul></li></g:if>
<%--			<li>--%>
<%--			<g:link controller="periodicReport" action="createReport" params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt]}"> <i class="fa fa-file-text-o"></i>--%>
<%--					<span>Periodic Report</span>--%>
<%--			</g:link>--%>
<%--			</li>--%>

<%--	 <li><g:link controller="graphicalReport" action="cristalView"--%>
<%--	 params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt] }">--%>
<%--	 <i class="fa fa-cloud"></i> <span>Graphical Report</span></g:link></li>   --%>
	 
	 
			<li><g:link controller="fileMovments" action="fileMovment"
					params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt]}">
					<i class="fa fa-refresh"></i>
					<span>File Movement</span></g:link></li>
			<li class="treeview"><a href="#/accounts.html#"> <i
					class="fa fa-upload"></i> <span>Upload</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li><g:link controller="manualUpload" action="addDocument"
							params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt]}">
							<i class="fa fa-circle-o"></i>
							Add Document</g:link></li>
					<li><g:link controller="manualUpload" action="addClearanceLtr"
							params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-circle-o"></i>
							Clearance/Agreement</g:link>></li>
<%--					<li><a href="#/accounts.html#"><i class="fa fa-circle-o"></i>--%>
<%--							Draft Agreement</a></li>--%>
				</ul></li>
				<g:if test="${getAuthority == 'LEGAL_HEAD'|| getAuthority == 'TECHNICAL_OFFICER_BS'||getAuthority == 'TECHNICAL_OFFICER_IPR'|| getAuthority =='SECRETARY' || getAuthority =='CHAIRMAN' }">
			<li><g:link controller="versionManager" params="${[instance:formID,csrfPreventionSalt:csrfPreventionSalt] }" onclick="return confirm( 'Are you sure?');"><i class="fa fa-edit"></i> <span>Request for Modification</span></g:link>
			</li></g:if>
		
		</ul>
	</section>
</aside>
</g:else>