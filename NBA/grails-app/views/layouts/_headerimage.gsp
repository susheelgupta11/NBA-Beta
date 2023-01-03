<%! import org.nba.user.NbaUser %>
<%! import org.nba.user.NbaUserNbaRole %>
<%! import org.nba.user.NbaRole %>
<%! import org.nba.user.RoleEnum %>
<style type="text/css">
.image_bg
{
background-image:url('../images/Abstract-Header.jpg');
background-size:100%;
}
</style>
<div class="col-sm-12">
	<div class="">
		<div class=" col-sm-12 img-responsive TopLogoBorder" >
			<div class="container img_top">
				<div class="col-sm-10">
					<div class="logo">
					<g:set var="userObject" value="${NbaUser.findByUsername(sec.loggedInUserInfo(field:'username'))}"/>
						<img src="${resource(dir: 'images', file: 'Logo1.jpg')}" alt="logo" class="img-responsive pull-left" />
					</div>
				</div>
				<div class="col-sm-2">
				
				<g:if test="${adminUser }">
				   <div class="row">
					<b>Signed in as : </b> ${userObject?.name}	
				   </div>	
				</g:if>
				<g:else>
				   <div class="col-sm-12">
					<b>Signed in as : </b> ${userObject?.name}
				   </div>	
				</g:else>
<%--				  <g:if test="${!adminUser }">	--%>
<%--					<g:set var="userObject"--%>
<%--						value="${NbaUserNbaRole.findByNbaRoleAndNbaUser(NbaRole.findByAuthority(RoleEnum?.Role?.ADMIN),NbaUser.findByUsername(sec.loggedInUserInfo(field:'username')))?.nbaRole?.authority}" />--%>
<%--					<g:if test="${userObject != 'ADMIN'}">--%>
<%--						<div class="row less_padding imgfixed">--%>
<%--							<span id="helpdesktext" class="col-sm-2 text-danger"> <b>Helpdesk</b>--%>
<%--							</span>--%>
<%--							<g:link controller="loggedInAs" action="helpDesk"--%>
<%--								params='[csrfPreventionSalt:"${csrfPreventionSalt}"]'--%>
<%--								class="col-sm-12 helpdeskimage">--%>
<%--								<img src="${resource(dir: 'images', file: 'helpdeskicon.png')}"--%>
<%--									alt="logo" class="img-responsive " />--%>
<%--							</g:link>--%>
<%----%>
<%--						</div>--%>
<%--					</g:if>--%>
				</div>
			</div>
		</div>
	</div>
</div>