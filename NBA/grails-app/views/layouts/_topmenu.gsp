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
					controller="loggedInAs" action="inbox"  params='[csrfPreventionSalt:"${csrfPreventionSalt}"]'>Home</g:link></li>
			<li><g:link controller="register" action="userDetail" params='[csrfPreventionSalt:"${csrfPreventionSalt}"]'>Edit Profile </g:link></li>
			<li><g:link controller="register" action="changePassword" params='[csrfPreventionSalt:"${csrfPreventionSalt}"]'>Change Password</g:link></li>
			<li><g:link controller="logout" params='[csrfPreventionSalt:"${csrfPreventionSalt}"]'>Logout</g:link></li>
		</ul>
	</div>
</nav>
