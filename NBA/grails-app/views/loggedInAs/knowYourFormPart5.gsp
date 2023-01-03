<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />

<title>NBA</title>
</head>
<body>
	<div class="container">
	<div class="row">
		<div class="col-sm-8 col-sm-offset-2 text-center form_heading">
			<h3>Know your Application</h3>
		</div>
		</div>
		<div class="row">

			<div class="col-sm-8 col-sm-offset-2 middle_box">
				<span class="heading_font">You may apply in</span><br /> <br />
				<div class="col-sm-12">
					<span class="col-sm-3"><g:if test="${formNumber == 'form1'}">
							<b>Form I:</b>
						</g:if> <g:elseif test="${formNumber == 'form2'}">
							<b>Form II:</b>
						</g:elseif> <g:elseif test="${formNumber == 'form3'}">
							<b>Form III:</b>
						</g:elseif> <g:elseif test="${formNumber == 'form4'}">
							<b>Form IV:</b>
						</g:elseif> <g:else>
							<b>Form B</b>
						</g:else> </span> <span class="col-sm-9"><g:if
							test="${formNumber == 'form1'}">Application
						form for access to biological resources and associated traditional
						knowledge</g:if> <g:elseif test="${formNumber == 'form2'}"> Application for seeking prior approval of National Biodiversity Authority for transferring the results of research to foreign nationals, companies, NRIs for commercial purposes</g:elseif>
						<g:elseif test="${formNumber == 'form3'}">Application for seeking prior approval of National Biodiversity Authority for applying for Intellectual Property Right</g:elseif>
						<g:elseif test="${formNumber == 'form4'}">Application form for seeking approval of National Biodiversity Authority for third party transfer of the accessed Biological resources and/ or associated traditional knowledge</g:elseif>

					</span><br />
<%--					<div class="col-sm-12 text-center">--%>
<%--						--%>
<%--					</div>--%>
				</div>

				<div class="col-sm-12 form-group">
				<br/>
					<g:if
						test="${formNumber == 'form1' || formNumber == 'form2' || formNumber == 'form3' || formNumber == 'form4' }">
						<span class="col-sm-3"><b>Fee:</b></span>
						<span class="col-sm-9">${fee}</span>
					</g:if>
				</div>
				<div class="col-sm-12 margin-top">
				<g:link controller="loggedInAs" action="knowYourFormPart1" params='[formType:"Form1",csrfPreventionSalt:"${csrfPreventionSalt}"]' class="btn btn-primary pull-left">Back</g:link>
					<g:if test="${formNumber == 'form1'}">
						<g:link controller="applicationManagement"
							action="selectIndividualOrCompany" params='[formType:"Form1",csrfPreventionSalt:"${csrfPreventionSalt}"]'
							class="btn btn-primary pull-right">OK</g:link>
					</g:if>
					<g:elseif test="${formNumber == 'form2'}">
						<g:link controller="applicationManagement"
							action="selectIndividualOrCompany" params='[formType:"Form2",csrfPreventionSalt:"${csrfPreventionSalt}"]'
							class="btn btn-primary pull-right">OK</g:link>
					</g:elseif>
					<g:elseif test="${formNumber == 'form3'}">
						<g:link controller="applicationManagement"
							action="selectIndividualOrCompany" params='[formType:"Form3",csrfPreventionSalt:"${csrfPreventionSalt}"]'
							class="btn btn-primary pull-right">OK</g:link>
					</g:elseif>
					<g:elseif test="${formNumber == 'form4'}">
						<g:link controller="applicationManagement"
							action="selectIndividualOrCompany" params='[formType:"Form4",csrfPreventionSalt:"${csrfPreventionSalt}"]'
							class="btn btn-primary pull-right">OK</g:link>
					</g:elseif>
					
				</div>
			</div>
		</div>
	</div>
</body>
</html>