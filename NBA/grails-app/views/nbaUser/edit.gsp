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
		<div id="edit-nbaUser" class="content scaffold-edit" role="main">
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${nbaUserInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${nbaUserInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:nbaUserInstance, action:'update']" method="POST" >
				<g:hiddenField name="version" value="${nbaUserInstance?.version}" />
					<div class="container">
					<div class="row text-white">
						<div
							class="col-xl-5 col-lg-6 col-lg-offset-3 col-md-8 col-sm-10 mx-auto text-center form p-4 shadow"
							style="padding-top: 20px; padding-bottom: 20px;">
							<g:render template="form" />
							<g:actionSubmit class="btn btn-primary btn-lg" action="update"
								value="Update" />
						</div>
					</div>
				</div>

				<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
			</g:form>
			</div>
			</div>
		</div>
	</body>
</html>
