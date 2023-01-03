<%@page import="org.nba.application.FormCategory"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name='layout' content="applicant" />
<title>NBA</title>
<style>
.add_mor {
	background: #367fa9;
	color: #fff;
	padding: 4px 12px;
	display: inline-block;
	border-radius: 4px;
	border: none;
	text-align: center;
	text-decoration: none;
	font-size: 12px;
	margin: 4px 2px;
	cursor: pointer;
}

.tbl-inputs{
width:100%;
}
</style>

</head>
<body>

	<div class="content-wrapper">
		<div class="col-sm-12 paddingleft">
			<div id="costum-lft" class="col-sm-12">
				<div class="col-sm-12 rightdiv" style="">
					<g:form controller="applicant" action="updatePeriodicReport" enctype="multipart/form-data"
						method="Post">
						<div>
							<g:if test="${message}">
								<span style="color: green; text-shadow: orange;"><b>
										${message}
								</b></span>
							</g:if>
						</div>
						<g:if test="${act == '1' }">
						<g:render template="createReport1"></g:render>
						</g:if>
						
							<g:if test="${act == '1C' }">
						<g:render template="createReport1C"></g:render>
						</g:if>
							<g:if test="${act == '2' }">
						<g:render template="createReport2"></g:render>
						</g:if>
							<g:if test="${act == '3' }">
						<g:render template="createReport3"></g:render>
						</g:if>
							<g:if test="${act == '4' }">
						<g:render template="createReport4"></g:render>
						</g:if>
						
	
						<g:hiddenField name="formId" value="${formDetails?.id}" />
						<g:hiddenField name="applicantName" value="${fullName}" />
						<g:hiddenField name="periodicInstance"
							value="${periodicReportInstance?.id }" />
						<g:hiddenField name="csrfPreventionSalt"
							value="${csrfPreventionSalt}" />
						<g:hiddenField name="formType" value="createReport1" />					
						<g:hiddenField name="formType" value="${act}"/>
<%--	<g:actionSubmit value="Update" action="updatePeriodicReport"--%>
<%--								class="btn btn-primary pull-right" style="margin-bottom:5px" />--%>

<%--							<g:link class="btn btn-primary pull-right"--%>
<%--								action="generatePdfForPeriodicReport"--%>
<%--								params="${[instance:formDetails?.id,periodInstance:periodicReportInstance?.id]}"--%>
<%--								target="_blank" style="margin-right: 12px; margin-bottom: 5px;">Generate PDF</g:link>--%>
					</g:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

