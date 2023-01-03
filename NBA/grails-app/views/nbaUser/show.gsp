
<%@ page import="org.nba.user.NbaUser" %>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="superAdmin">

<title>NBA</title>
</head>
<body>
 <div class="content-wrapper usess">
    <div class="col-sm-12 table-responsive">
<div id="show-nbaUser" class="content scaffold-show" role="main">

		<ol class="property-list nbaUser">

			<g:if test="${nbaUserInstance?.name}">
				<li class="fieldcontain"><span id="name-label"
					class="property-label"><g:message code="nbaUser.name.label"
							default="Name" /></span> <span class="property-value"
					aria-labelledby="name-label"><g:fieldValue
							bean="${nbaUserInstance}" field="name" /></span></li>
			</g:if>

			<g:if test="${nbaUserInstance?.username}">
				<li class="fieldcontain"><span id="username-label"
					class="property-label"><g:message
							code="nbaUser.username.label" default="Username" /></span> <span
					class="property-value" aria-labelledby="username-label"><g:fieldValue
							bean="${nbaUserInstance}" field="username" /></span></li>
			</g:if>







			<g:if test="${nbaUserInstance?.accountExpired}">
				<li class="fieldcontain"><span id="accountExpired-label"
					class="property-label"><g:message
							code="nbaUser.accountExpired.label" default="Account Expired" /></span>

					<span class="property-value" aria-labelledby="accountExpired-label"><g:formatBoolean
							boolean="${nbaUserInstance?.accountExpired}" /></span></li>
			</g:if>

			<g:if test="${nbaUserInstance?.accountLocked}">
				<li class="fieldcontain"><span id="accountLocked-label"
					class="property-label"><g:message
							code="nbaUser.accountLocked.label" default="Account Locked" /></span> <span
					class="property-value" aria-labelledby="accountLocked-label"><g:formatBoolean
							boolean="${nbaUserInstance?.accountLocked}" /></span></li>
			</g:if>

			<g:if test="${nbaUserInstance?.dateOfBirth}">
				<li class="fieldcontain"><span id="dateOfBirth-label"
					class="property-label"><g:message
							code="nbaUser.dateOfBirth.label" default="Date Of Birth" /></span> <span
					class="property-value" aria-labelledby="dateOfBirth-label"><g:formatDate
							date="${nbaUserInstance?.dateOfBirth}" /></span></li>
			</g:if>

			<g:if test="${nbaUserInstance?.email}">
				<li class="fieldcontain"><span id="email-label"
					class="property-label"><g:message code="nbaUser.email.label"
							default="Email" /></span> <span class="property-value"
					aria-labelledby="email-label"><g:fieldValue
							bean="${nbaUserInstance}" field="email" /></span></li>
			</g:if>

			<g:if test="${nbaUserInstance?.enabled}">
				<li class="fieldcontain"><span id="enabled-label"
					class="property-label"><g:message
							code="nbaUser.enabled.label" default="Enabled" /></span> <span
					class="property-value" aria-labelledby="enabled-label"><g:formatBoolean
							boolean="${nbaUserInstance?.enabled}" /></span></li>
			</g:if>

			<g:if test="${nbaUserInstance?.mobile}">
				<li class="fieldcontain"><span id="mobile-label"
					class="property-label"><g:message
							code="nbaUser.mobile.label" default="Mobile" /></span> <span
					class="property-value" aria-labelledby="mobile-label"><g:fieldValue
							bean="${nbaUserInstance}" field="mobile" /></span></li>
			</g:if>

			<g:if test="${nbaUserInstance?.passwordExpired}">
				<li class="fieldcontain"><span id="passwordExpired-label"
					class="property-label"><g:message
							code="nbaUser.passwordExpired.label" default="Password Expired" /></span>

					<span class="property-value"
					aria-labelledby="passwordExpired-label"><g:formatBoolean
							boolean="${nbaUserInstance?.passwordExpired}" /></span></li>
			</g:if>

			<g:if test="${nbaUserInstance?.phone}">
				<li class="fieldcontain"><span id="phone-label"
					class="property-label"><g:message code="nbaUser.phone.label"
							default="Phone" /></span> <span class="property-value"
					aria-labelledby="phone-label"><g:fieldValue
							bean="${nbaUserInstance}" field="phone" /></span></li>
			</g:if>

		</ol>
		<g:form url="[resource:nbaUserInstance, action:'delete']"
			method="DELETE">
			<fieldset class="buttons">
				<g:link class="btn btn-primary pull-left" action="edit"
					resource="${nbaUserInstance}">
					<g:message code="default.button.edit.label" default="Edit"
						style="margin-left: 12px;" />
   
   
				</g:link>
				<g:actionSubmit class="btn btn-primary pull-left" action="delete"
					value="${message(code: 'default.button.delete.label', default: 'Delete')}"
					onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"
					style=" margin-left: 12px;" />
    
  
			</fieldset>
			<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
		</g:form>
		</div>
		</div>
	</div>
</body>
</html>
