<ul class="nav nav1 navbar-nav pull-right">
	<li><g:link controller="applicationManagement" action="index" params='[csrfPreventionSalt:"${csrfPreventionSalt}"]'
			class="active">HOME</g:link></li>
	<li><g:link controller="register" action="editProfile" params='[csrfPreventionSalt:"${csrfPreventionSalt}"]'>EDIT PROFILE</g:link></li>
	<li><g:link controller="register" action="changePassword" params='[csrfPreventionSalt:"${csrfPreventionSalt}"]'>CHANGE PASSWORD</g:link></li>
	<li><g:link controller="logout" action="index" params='[csrfPreventionSalt:"${csrfPreventionSalt}"]'>LOGOUT</g:link></li>
</ul>