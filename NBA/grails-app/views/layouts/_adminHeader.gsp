<%! import org.nba.user.NbaUser %>
<%! import org.nba.user.NbaUserNbaRole %>
<%! import org.nba.user.NbaRole %>
<%! import org.nba.user.RoleEnum %>
<sec:ifAnyGranted roles="ADMIN">
<g:set var="getRole" value="ADMIN" />
</sec:ifAnyGranted>

<sec:ifAnyGranted roles="APPLICANT">
<g:set var="getApplicant" value="APPLICANT" />
</sec:ifAnyGranted>


  <header class="main-header">
   	<nav class="navbar navbar-static-top">
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<li class="dropdown messages-menu"><g:link
						controller="loggedInAs" action="inbox" params='[csrfPreventionSalt:"${csrfPreventionSalt}"]'><i class="fa fa-home" style="font-size:16px">Home</i></g:link></li>
				<g:if test="${getApplicant == 'APPLICANT'}">
			<li class="dropdown messages-menu"><g:link controller="register" action="userDetail"><i class="fa fa-edit" style="font-size:16px">Edit Profile </i></g:link> </li>
          <li class="dropdown messages-menu"><g:link controller="register" action="changePassword"><i class="fa fa-user" style="font-size:16px">Change Password</i></g:link></li>
				</g:if>
				<g:if test="${getRole == 'ADMIN'}">
				   <li class="dropdown messages-menu">	
					<g:link controller="manageContent" action="adminEdits" params= '[csrfPreventionSalt:"${csrfPreventionSalt}", menu1:"aboutNBA"]'>
					<i class="fa fa-book" style="font-size:16px"></i>Manage Content</g:link></li>
				</g:if>
				<li class="dropdown messages-menu"><g:link controller="logout"
						params='[csrfPreventionSalt:"${csrfPreventionSalt}"]'><i class="fa fa-sign-out" style="font-size:16px">Logout</i></g:link></li>
						
			</ul>
		</div>
	</nav>
    <div class="container-fluid">
<%--    <g:set var="userObject" value="${NbaUser.findByUsername(sec.loggedInUserInfo(field:'username'))}"/>--%>
      <div class="col-sm-9"> <img src="${resource(dir: 'images', file: 'Logo1.jpg')}" alt="logo" class="img-responsive pull-left" /> </div>
      <div class="col-sm-3 text-right" style="padding:10px 0;">
				   <div class="col-sm-12">
<%--					<b>Signed in as : </b>${userObject?.name}--%>
					<sec:ifLoggedIn>
                     <b>Signed in as :</b><sec:username />
                    </sec:ifLoggedIn>
				   </div>	
             </div>
            </div>
 
    <nav class="navbar navbar-default"> 
    <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button"> 
    <span class="sr-only">Toggle navigation</span> </a>
    <div style="float:right; padding:1em; cursor:pointer;">
    <div class="btn-group" role="group" aria-label="Controls">
         <i class="fa fa-bars toggle-sidebar" aria-hidden="true" style="color:#FFF; font-size:18px;"></i>
        </div>
	</div>
        
        
     <div class="container-fluid">
        <div class="collapse navbar-collapse" id="defaultNavbar1">
          <ul class="nav navbar-nav">
            <li><a href="#"><span class="sr-only">(current)</span></a></li>
            <li><a href="#"></a></li>
          </ul>
        </div>
      </div>
    </nav>
            
            
<%--    <nav class="navbar navbar-default">--%>
<%--    <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button"> <span class="sr-only">Toggle navigation</span> </a>--%>
<%--      <div class="container-fluid">--%>
<%--        <div class="collapse navbar-collapse" id="defaultNavbar1">--%>
<%--          <ul class="nav navbar-nav">--%>
<%--             <li class="link"><g:link controller="loggedInAs" action="inbox" class="active">Home</g:link></li>--%>
	<g:set var="userObject" value="${NbaUserNbaRole.findByNbaRoleAndNbaUser(NbaRole.findByAuthority(RoleEnum?.Role?.ADMIN),NbaUser.findByUsername(sec.loggedInUserInfo(field:'username')))?.nbaRole?.authority}"/>
<%--		<g:if test="${getRole != 'ADMIN'}">--%>
<%--				<li class="link">--%>
<%--				<g:link controller="loggedInAs" action="decideForm"> ${aboutNBA }Apply Online</g:link></li>--%>
<%--		</g:if>--%>
<%----%>
<%--		<li class="link"><g:link controller="loggedInAs" action="notifications">Notifications</g:link></li>--%>
<%--		<g:if test="${getRole == 'ADMIN'}">--%>
<%--	<li class="link"><g:link controller="manageContent" action="adminEdits" params= '[csrfPreventionSalt:"", menu1:"aboutNBA"]' >Manage Content</g:link></li>--%>
<%--		</g:if>	--%>
<%--          </ul>--%>
<%--        </div>--%>
<%--      </div>--%>
<%--    </nav>--%>
    </header>
