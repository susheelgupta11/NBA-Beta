<%! import org.nba.user.NbaUser %>
<%! import org.nba.user.NbaUserNbaRole %>
<%! import org.nba.user.NbaRole %>
<%! import org.nba.user.RoleEnum %>
<%! import org.nba.application.ApplicationForm1 %>
<%! import org.nba.application.FormCategory %>
<%! import org.nba.user.LinkOfficer %>
<g:set var="headerDetails" value="${formDetails}" />

<g:if test="${headerDetails}"> 
<g:javascript>

$( document ).ready(function() {
	document.getElementById('headerShow').style.display = 'block';
    console.log( "ready!" );
});
 
</g:javascript>
</g:if>
<%--<div class="wrapper">--%>
<header class="main-header">
	<nav class="navbar navbar-static-top">
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<li class="dropdown messages-menu"><g:link
						controller="loggedInAs" action="inbox" params='[csrfPreventionSalt:"${csrfPreventionSalt}"]'><i class="fa fa-home" style="font-size:16px">Home</i></g:link></li>
				<li class="dropdown messages-menu"><g:link controller="logout"
						params='[csrfPreventionSalt:"${csrfPreventionSalt}"]'><i class="fa fa-sign-out" style="font-size:16px">Logout</i></g:link></li>
			</ul>
		</div>
	</nav>
	<div class="container-fluid">
		    <g:set var="userObject" value="${NbaUser.findByUsername(sec.loggedInUserInfo(field:'username'))}"/>
		    <g:set var="getNbaRole" value="${userObject?.nbaRole}"/>
          <g:set var="getRoleDetails" value="${NbaRole.get(getNbaRole?.id)}"/>
          <g:set var="getAuthority" value="${getRoleDetails?.authority}" />
          
             <%-------------------------Link officer login details------------------%>
          <g:set var="linkDetails" value="${LinkOfficer.findByNbaUserTo(userObject)}"/>
          <g:set var="linkOfficerName" value=" ${linkDetails?.nbaUserFrom?.answer}"/>	
	      <g:set  var="linkRole" value="${linkDetails?.nbaUserFrom?.nbaRole}"/>
	      <g:set var="linkAuth" value="${linkRole?.authority}" />
	    
          
		<div class="col-sm-9">
			<img src="${resource(dir: 'images', file: 'Logo1.jpg')}" alt="logo"
				class="img-responsive pull-left" />
		</div>
		<div class="col-sm-3 text-right" style="padding: 10px 0;">
			<div class="col-sm-12">
				<%--					<b>Signed in as : </b>${userObject?.name}--%>
				 <g:if test="${linkOfficer == 'Yes' }">	
			    <b>Signed in as : </b>${linkOfficerName}<br/>
			    	<b>Role:</b>${linkAuth}<br/>
			     </g:if>
			     <g:else>
				<sec:ifLoggedIn>
					<b>Signed in as :</b>${userObject?.name}<br/>
					<b>Role:</b>${getAuthority}
				</sec:ifLoggedIn>
				</g:else>
			</div>
		</div>
	</div>
	
	<nav class="navbar navbar-default">
		<a href="#" class="sidebar-toggle" data-toggle="push-menu"
			role="button"> <span class="sr-only">Toggle navigation</span>
		</a>
		<div class="container-fluid">
<%--			<div class="collapse navbar-collapse" id="defaultNavbar1">--%>
<%--				<ul class="nav navbar-nav">--%>
<%--					<li><a href="#"><span class="sr-only">(current)</span></a></li>--%>
<%--					<li><a href="#"></a></li>--%>
<%--				</ul>--%>
<%--			</div>--%>
		
	<div class="main-applicant-bar" id="headerShow" style="display: none; position:relative; top:2px">
		<div class="applicant" style="width:430px;">
			<span>Applicant Name :<strong> <g:if
						test="${headerDetails?.individualProfiles}">


						<g:each in="${headerDetails?.individualProfiles}"
							var="individualProfile">

							${individualProfile?.title}
							${individualProfile?.firstName}
							${individualProfile?.middleName}
							${individualProfile?.lastName}
						</g:each>
					</g:if> <g:elseif test="${headerDetails?.companyProfiles}">
						<g:each status="k" in="${headerDetails?.companyProfiles}"
							var="company">
							${company?.entityName}
						</g:each>
					</g:elseif> <g:elseif test="${headerDetails?.indianResearcher}">
						<g:each in="${headerDetails?.indianResearcher}" var="researcher">

							${researcher?.title}
							${researcher?.firstName}
							${researcher?.middleName}
							${researcher?.lastName}

						</g:each>
					</g:elseif> <g:elseif test="${headerDetails?.depostionOfMicroOrganism}">
						<g:each in="${headerDetails?.depostionOfMicroOrganism}"
							var="depost">
							${depost?.nameOfDepositor}
						</g:each>
					</g:elseif> <g:elseif test="${headerDetails?.indianGovtInst}">
						<g:each in="${headerDetails?.indianGovtInst}" var="govt">
							${govt?.govtInstName}
						</g:each>
					</g:elseif>

			</strong></span><span>Application Number :<strong>
					${headerDetails?.appNumber}
			</strong></span>
		</div>
		<div class="applicant category">
			<span>Applicant Category :<strong><g:if
						test="${headerDetails?.individualProfiles}">Individual</g:if> 
						<g:elseif
						test="${headerDetails?.companyProfiles}">
						<g:each in="${headerDetails?.companyProfiles }" var="ct">
						
						${ct?.entityType }
						</g:each>
						
						</g:elseif>
						 <g:elseif
						test="${headerDetails?.indianGovtInst}">Government</g:elseif> <g:elseif
						test="${headerDetails?.depostionOfMicroOrganism}">Micro</g:elseif>
						<g:elseif test="${headerDetails?.indianResearcher}">Indian-Researcher</g:elseif>
						
						</strong></span>
			<span>Nationality:<strong>
			<g:if test="${headerDetails?.individualProfiles}">
						<g:each in="${headerDetails?.individualProfiles}" var="natio">
						<g:if test="${natio?.nationality == 'Indian'}">
						Indian
						</g:if>	<g:else>Non-Indian</g:else>
						</g:each>
					</g:if> <g:elseif test="${headerDetails?.companyProfiles}">
					
						<g:each in="${headerDetails?.companyProfiles}" var="natio">
						
							<g:if test="${natio?.nationality == 'registeredInIndia' || 'noNonIndianParticipation'== natio?.nationality}">
						Indian
						</g:if>
						<g:else>Non-Indian</g:else>
						</g:each>
					</g:elseif> <g:elseif test="${headerDetails?.indianGovtInst}">
						
						Indian-Govt
						
					</g:elseif> 
					
					<g:elseif
						test="${headerDetails?.depostionOfMicroOrganism}">
						<g:each in="${headerDetails?.depostionOfMicroOrganism}"
							var="natio">
							<g:if test="${natio?.nationality == 'Indian'}">
						Indian
						</g:if>	<g:else>Non-Indian</g:else>
						</g:each>
					</g:elseif>
					
					<g:elseif test="${headerDetails?.indianResearcher}">Indian</g:elseif>
					 </strong></span>
		</div>
		<div class="applicant version">
			<span>Application Form :<strong>
			<g:if test="${headerDetails?.category?.category == FormCategory?.Category?.Form_1}">Form I
			<g:set var="fee" value="10,000 /-"/>
			</g:if>
			<g:elseif test="${headerDetails?.category?.category == FormCategory?.Category?.Form_2}">Form II
			<g:set var="fee" value="5,000 /-"/>
			</g:elseif>
			<g:elseif test="${headerDetails?.category?.category == FormCategory?.Category?.Form_3}">Form III
			<g:set var="fee" value="500 /-"/>
			</g:elseif>
			<g:elseif test="${headerDetails?.category?.category == FormCategory?.Category?.Form_4}">Form IV
			<g:set var="fee" value="10,000 /-"/>
			</g:elseif>
			<g:elseif test="${headerDetails?.category?.category == FormCategory?.Category?.Form_B}">Form B</g:elseif>
			<g:elseif test="${headerDetails?.category?.category == FormCategory?.Category?.Form_C}">Form C</g:elseif>
			
					
			</strong></span> <span>Fee Recieved :<strong>
			
					${fee}
			</strong></span> <span>Version :<strong>
			<g:if test="${headerDetails?.versionApplicationForm1 != null}">
			${headerDetails?.versionApplicationForm1.size()+1}
			</g:if>
			<g:elseif test="${formDetails}">
			   1
			</g:elseif>
					
			</strong></span>
		</div>
	</div>
</div>
	</nav>

</header>
