<html>

<head>
<title><g:message code='spring.security.ui.resetPassword.title' /></title>
<meta name='layout' content='main' />
</head>

<body>

	<div class="col-sm-6 col-sm-offset-3">
		<div class="main-registeration-form row">
			<div class="register-heading1">
				<h4>Reset Password</h4>
			</div>

			<g:form action='resetPassword' name='resetPasswordForm'
				autocomplete='off'>
			<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	
				<g:hiddenField name='t' value='${token}' />
				<div class="sign-in">
					<div class="col-sm-12 form-group col-sm-offset-3">

						<s2ui:passwordFieldRow name='password'
							labelCode='resetPasswordCommand.password.label' bean="${command}"
							labelCodeDefault='Password*' value="${command?.password}" />

					</div>
					<div class="col-sm-12 form-group col-sm-offset-2">
						<s2ui:passwordFieldRow name='password2'
							labelCode='resetPasswordCommand.password2.label'
							bean="${command}" labelCodeDefault='Password(again)*'
							value="${command?.password2}" />

					</div>
				<div class="col-sm-12 form-group text-center">
					<g:link controller="login" action="auth" class="btn btn-primary" params='[csrfPreventionSalt:"${csrfPreventionSalt}"]'>Back</g:link>
					<g:submitButton class="btn btn-primary" name="save" value="Save" />
				</div>
		</div>

		</g:form>
	</div>



	</div>



	<p />

	<%--<s2ui:form width='475' height='250' elementId='resetPasswordFormContainer'--%>
	<%--           titleCode='spring.security.ui.resetPassword.header' center='true'>--%>
	<%----%>
	<%--	<g:form action='resetPassword' name='resetPasswordForm' autocomplete='off'>--%>
	<%--	<g:hiddenField name='t' value='${token}'/>--%>
	<%--	<div class="sign-in">--%>
	<%----%>
	<%--	<br/>--%>
	<%--	<h4><g:message code='spring.security.ui.resetPassword.description'/></h4>--%>
	<%----%>
	<%--	<table>--%>
	<%--		<s2ui:passwordFieldRow name='password' labelCode='resetPasswordCommand.password.label' bean="${command}"--%>
	<%--                             labelCodeDefault='Password' value="${command?.password}"/>--%>
	<%----%>
	<%--		<s2ui:passwordFieldRow name='password2' labelCode='resetPasswordCommand.password2.label' bean="${command}"--%>
	<%--                             labelCodeDefault='Password (again)' value="${command?.password2}"/>--%>
	<%--	</table>--%>
	<%----%>
	<%--	<s2ui:submitButton elementId='reset' form='resetPasswordForm' messageCode='spring.security.ui.resetPassword.submit'/>--%>
	<%----%>
	<%--	</div>--%>
	<%--	</g:form>--%>
	<%----%>
	<%--</s2ui:form>--%>

	<script>
		$(document).ready(function() {
			$('#password').focus();
		});
	</script>

</body>
</html>
