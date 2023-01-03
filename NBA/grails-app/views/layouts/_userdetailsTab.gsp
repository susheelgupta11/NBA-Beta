<%! import org.nba.user.NbaUserNbaRole %>
<%! import org.nba.user.NbaRole %>
<%! import org.nba.user.NbaUser %>
<%! import org.nba.user.RoleEnum %>
<nav class="navbar navbar-defaul menucolor col-sm-12" role="navigation">
	<g:set var="userObject"
		value="${NbaUser.findByUsername(sec.loggedInUserInfo(field:'username'))}" />
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#middle_nav_bar">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>

		<a class="navbar-brand" href="#"></a>
	</div>
	<% session.setAttribute("csrfPreventionSalt",csrfPreventionSalt) %>
	<div class="collapse navbar-collapse" id="middle_nav_bar">

		<ul class="nav navbar-nav navhover">
			<div class="main-applicant-bar" style="top: 0px">
				<div class="applicant">
					<span>Applicant Name :<strong>
							${userObject?.name}
					</strong></span><span>Application Number :<strong>INBA1239854</strong></span>
				</div>
				<div class="applicant category">
					<span>Applicant Category :<strong>Individual</strong></span> <span>Nationality
						:<strong>Indian</strong>
					</span>
				</div>
				<div class="applicant version">
					<span>Application Form :<strong>Form 1</strong></span> <span>Fee
						Recieved :<strong>Rs 10000</strong>
					</span> <span>Version :<strong>1</strong></span>
				</div>
			</div>
		</ul>
	</div>
</nav>
