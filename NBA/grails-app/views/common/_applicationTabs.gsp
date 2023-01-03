<%! import org.nba.user.NbaUserNbaRole %>
<%! import org.nba.user.NbaRole %>
<%! import org.nba.user.NbaUser %>
<%! import org.nba.user.RoleEnum %>
<nav class = "navbar navbar-defaul menucolor col-sm-12" role = "navigation">
   
   <div class = "navbar-header">
      <button type = "button" class = "navbar-toggle" 
         data-toggle = "collapse" data-target = "#middle_nav_bar">
         <span class = "sr-only">Toggle navigation</span>
         <span class = "icon-bar"></span>
         <span class = "icon-bar"></span>
         <span class = "icon-bar"></span>
      </button>
		
      <a class = "navbar-brand" href = "#"></a>
   </div>
   <% session.setAttribute("csrfPreventionSalt",csrfPreventionSalt) %>
   <div class = "collapse navbar-collapse" id = "middle_nav_bar">
	
      <ul class = "nav navbar-nav navhover">
         <li class="link"><g:link controller="loggedInAs" action="inbox"
				class="active"  params='[]'>Home</g:link></li>
		
		
		
	<g:set var="userObject" value="${NbaUserNbaRole.findByNbaRoleAndNbaUser(NbaRole.findByAuthority(RoleEnum?.Role?.ADMIN),NbaUser.findByUsername(sec.loggedInUserInfo(field:'username')))?.nbaRole?.authority}"/>
		<g:if test="${userObject != 'ADMIN'}">
				<li class="link"><g:link controller="loggedInAs"
									action="decideForm"
									params='[]'>
									${aboutNBA }Apply Online</g:link></li>

		</g:if>
	
		<li class="link"><a href="#">Download</a></li>
		<li class="link"><g:link controller="loggedInAs" action="notifications" params='[]'>Notifications</g:link></li>
		<g:if test="${userObject == 'ADMIN'}">
			<li class="link"><g:link controller="manageContent" action="adminEdits" params= '[csrfPreventionSalt:"", menu1:"aboutNBA"]' >Manage Content</g:link>
			
			</li>
		</g:if>	
      </ul>
   </div>
   
</nav>
