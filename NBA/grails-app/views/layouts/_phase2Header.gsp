<%! import org.nba.user.NbaUser %>
<%! import org.nba.user.NbaUserNbaRole %>
<%! import org.nba.user.NbaRole %>
<%! import org.nba.user.LinkOfficer %>
<%! import org.nba.user.RoleEnum %>
<%! import org.nba.application.ApplicationForm1 %>

<g:set var="headerDetails" value="${formDetails}" />

<g:if test="${headerDetails}"> 
<g:javascript>

$( document ).ready(function() {
	document.getElementById('headerShow').style.display = 'block';
    console.log( "ready!" );
});
 
</g:javascript>
</g:if>


<nav class="navbar navbar-default navbar1 " role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#example-navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
	</div>
	<div class="collapse navbar-collapse" id="example-navbar-collapse">
		<ul class="nav navbar-nav navbar-right navbar-nav1">
			<li class="active"><g:link
					controller="loggedInAs" action="inbox"  params='[]'><i class="fa fa-home" style="font-size:16px">Home</i></g:link></li>

			<li><g:link controller="logout" params='[csrfPreventionSalt:"${csrfPreventionSalt}"]'><i class="fa fa-sign-out" style="font-size:16px">Logout</i></g:link></li>
		</ul>
	</div>
</nav>
<%--------------------------------------------------------------------------------------------------------------------------%>

	<div class="container-fluid">
		  <g:set var="userObject" value="${NbaUser?.findByUsername(sec.loggedInUserInfo(field:'username'))}"/>
		  <g:set var="getNbaRole" value="${userObject?.nbaRole}"/>
          <g:set var="getRoleDetails" value="${NbaRole.get(getNbaRole?.id)}"/>
          <g:set var="getAuthority" value="${getRoleDetails?.authority}" />
		  
		  <g:set var="linkDetails" value="${LinkOfficer.findByNbaUserTo(userObject)}"/>
		  <g:set var="chkStatus" value="${linkDetails?.status}"/>
		  
		  
		  
		  
		<div class="col-sm-9">
			<img src="${resource(dir: 'images', file: 'Logo1.jpg')}" alt="logo"
				class="img-responsive pull-left" />
		</div>
		<div class="col-sm-3 text-right" style="padding: 10px 0;">
			<div class="col-sm-12">
			
			             <sec:ifLoggedIn>
							<b>Signed in as : </b>${userObject?.name}<br/>
							<b>Role:</b>${getAuthority}<br/>
				         </sec:ifLoggedIn>
				 
					</div>
</div>
</div>


