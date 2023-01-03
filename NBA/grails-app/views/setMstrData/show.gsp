
<%@ page import="org.nba.master.SetMstrData" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="superAdmin">
		<g:set var="entityName" value="${message(code: 'setMstrData.label', default: 'SetMstrData')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-setMstrData" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-setMstrData" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list setMstrData">
			
				<g:if test="${setMstrDataInstance?.draft}">
				<li class="fieldcontain">
					<span id="draft-label" class="property-label"><g:message code="setMstrData.draft.label" default="Draft" /></span>
					
						<span class="property-value" aria-labelledby="draft-label"><g:fieldValue bean="${setMstrDataInstance}" field="draft"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${setMstrDataInstance?.note}">
				<li class="fieldcontain">
					<span id="note-label" class="property-label"><g:message code="setMstrData.note.label" default="Note" /></span>
					
						<span class="property-value" aria-labelledby="note-label"><g:fieldValue bean="${setMstrDataInstance}" field="note"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${setMstrDataInstance?.submission}">
				<li class="fieldcontain">
					<span id="submission-label" class="property-label"><g:message code="setMstrData.submission.label" default="Submission" /></span>
					
						<span class="property-value" aria-labelledby="submission-label"><g:fieldValue bean="${setMstrDataInstance}" field="submission"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${setMstrDataInstance?.actions}">
				<li class="fieldcontain">
					<span id="actions-label" class="property-label"><g:message code="setMstrData.actions.label" default="Actions" /></span>
					
						<span class="property-value" aria-labelledby="actions-label"><g:fieldValue bean="${setMstrDataInstance}" field="actions"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${setMstrDataInstance?.forwardUsr}">
				<li class="fieldcontain">
					<span id="forwardUsr-label" class="property-label"><g:message code="setMstrData.forwardUsr.label" default="Forward Usr" /></span>
					
						<span class="property-value" aria-labelledby="forwardUsr-label"><g:fieldValue bean="${setMstrDataInstance}" field="forwardUsr"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${setMstrDataInstance?.priority}">
				<li class="fieldcontain">
					<span id="priority-label" class="property-label"><g:message code="setMstrData.priority.label" default="Priority" /></span>
					
						<span class="property-value" aria-labelledby="priority-label"><g:fieldValue bean="${setMstrDataInstance}" field="priority"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${setMstrDataInstance?.status}">
				<li class="fieldcontain">
					<span id="status-label" class="property-label"><g:message code="setMstrData.status.label" default="Status" /></span>
					
						<span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${setMstrDataInstance}" field="status"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${setMstrDataInstance?.quries}">
				<li class="fieldcontain">
					<span id="quries-label" class="property-label"><g:message code="setMstrData.quries.label" default="Quries" /></span>
					
						<span class="property-value" aria-labelledby="quries-label"><g:fieldValue bean="${setMstrDataInstance}" field="quries"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:setMstrDataInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${setMstrDataInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
