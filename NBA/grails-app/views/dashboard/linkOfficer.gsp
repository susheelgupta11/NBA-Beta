<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="dashPage"/>
<title>Link Officer</title>
</head>
<body>
  	<g:form action="setLinkOfficer" controller="dashboard">

    <g:render template="/common/linkOfficer"></g:render>

		<g:submitButton name="Link" class="btn"
			style=" margin-left:260px;margin-top:15px;" />
	</g:form>
  
</body>
</html>