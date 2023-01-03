<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<meta name="layout" content="superAdmin" />
<title>NBA</title>

</head>
<body>
 <g:if test="${message}">
			<span style="color: green; text-shadow: orange; margin-left: 300px"><b>${message}</b></span>
		</g:if>
<g:form action="setLinkOfficer">

<g:render template="/loggedInAs/linkOfficer"></g:render>
<g:hiddenField name="userLink" value="${currentUser}"/>
<g:hiddenField name="updateInstance" value="${linkOfficerInstance?.id}"/>
<g:if test="${linkOfficerInstance}">

<g:submitButton name="Update" class="btn" style=" margin-left:260px;margin-top:15px;" />
</g:if>

<g:else>
<g:submitButton name="Link" class="btn" style=" margin-left:260px;margin-top:15px;" />
</g:else>
</g:form>

</body>
</html>