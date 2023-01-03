<%! import org.nba.application.CompanyProfile %>
<%! import org.nba.application.AgentProfile %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />

<title>NBA</title>


<!--calender codes end -->
<script type="text/javascript">
	$(document).ready(function() {
		hideShow_div();

	});
</script>
</head>

<body>
	<nav class="navbar-default" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

			</div>

		</div>
		<!-- /.container -->
	</nav>



	<!-- Page Content -->
	<div class="container container1">
		<div class="row">
			<div class="col-sm-3">
				<g:render template="leftTabs" />

			</div>

			<div class="col-sm-9">

				<div class="col-sm-12">
					<i><h3 class="about-login-heading hh">
							Form-I <br /> (See Rule 14 or Biological Diversity Rules, 2004)<br />
							Application form for access to biological resources and
							associated traditional knowledge </span>
						</h3></i>

				</div>
				<div class="clearfix"></div>
				<g:if test="${flash?.message}">
					${flash?.message}
				</g:if>
				<div class="main-registeration col-sm-12 blue-bg">
					<!--login form -->
					<g:uploadForm class="form-horizontal" role="form" autocomplete="off"
						action="submitCompanyProfile">
					<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	
						
						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-12 register-heading">1.
									Full Particulars of Applicant</label>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-12 register-heading">(i)
									Name</label>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3">(a) Name of Entity</label>
								<div class="col-sm-9">
									<input type="text" class="width" name="entityName"
										value="${companyProfile?.entityName}" required="required">
								</div>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3">(b) Type of Entity</label>
								<div class="col-sm-9">
									<g:each in="${entityTypes}" var="entityType">
										<g:radio required="required" name="entityType"
											value="${entityType}"
											checked="${entityType.equals('Government Agency')}" />
										${entityType}<br />
									</g:each>
								</div>
							</div>
						</div>



						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3" for="email">(c)
									Nationality</label>
								<div class="col-sm-9">
									<input type="checkbox"> not incorporated or registered
									in India<br /> <input type="checkbox"> incorporated or
									regisetered in India under any law for the time being in force
									which has any non-indian participation in its share capital or
									management

								</div>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-12 register-heading">(ii)
									Permanent Address</label>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3">(a) Address line1</label>
								<div class="col-sm-9">
									<input type="text" class="width" name="address1"
										value="${companyProfile?.address1}" required="required">
								</div>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3">(b) Address line2</label>
								<div class="col-sm-9">
									<input type="text" class="width" name="address2"
										value="${companyProfile?.address2}" required="required">
								</div>
							</div>
						</div>


						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3">(c) Address line3</label>
								<div class="col-sm-9">
									<input type="text" class="width" name="address3"
										value="${companyProfile?.address2}" required="required">
								</div>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3">(d) Country</label>
								<div class="col-sm-9">
									<g:select name="countryId" from="${listOfCountries}"
										optionKey="id" optionValue="country"
										value="${companyProfile?.country?.id}" class="width"
										noSelection="['':'-Select-']" required="required" />
								</div>
							</div>
						</div>


						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3">(e) State/Province</label>
								<div class="col-sm-9">
									<input type="text" class="width" name="state"
										value="${companyProfile?.province}" required="required">
								</div>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3"> (f) City</label>
								<div class="col-sm-9">
									<input type="text" class="width" name="city"
										value="${companyProfile?.city}" required="required">
								</div>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3">(g) Zip/Pincode</label>
								<div class="col-sm-9">
									<input type="text" class="width" name="pincode"
										value="${companyProfile?.pincode}" required="required">
								</div>
							</div>
						</div>


						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3">(h) Mobile</label>
								<div class="col-sm-9">
									<input type="text" class="width" name="mobile"
										value="${companyProfile?.mobile}" required="required">
								</div>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3">(i) Phone</label>
								<div class="col-sm-9">
									<input type="text" class="width" name="phone"
										value="${companyProfile?.phone}" required="required">
								</div>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3" for="email">(j)
									Email</label>
								<div class="col-sm-9">
									<input type="email" class="width" name="email"
										value="${companyProfile?.email}" required="required">
								</div>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3">(k) Website</label>
								<div class="col-sm-9">
									<input type="text" class="width" name="website"
										value="${companyProfile?.website}" required="required">
								</div>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-12 register-heading">(iii)
									Profile of Organizations</label>
							</div>
						</div>



						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3" for="email">(a)
									Nature of Business</label>
								<div class="col-sm-9">
									<select class="width" onchange="hideshowother(this,'otherBusiness')">
										<option>Select Business Name</option>
									</select>
								</div>
							</div>
						</div>


						<div id="otherBusiness" class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3" for="email">If
									Others, Specify</label>
								<div class="col-sm-9">
									<input type="text" class="width">
								</div>
							</div>
						</div>


						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3" for="email">(b)
									Turnover of Organization in US($) </label>
								<div class="col-sm-9">
									<input type="text" class="width" name="turnover"
										value="${companyProfile?.turnover?.toLong()}"
										required="required">
								</div>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-12 register-heading">(iv)
									Details of Authorized representative of Entity</label>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3" for="email"> (a)
									Title</label>
								<div class="col-sm-9">
									<g:select name="title" req="1" class="width"
										from="${CompanyProfile?.TitleName?.values()}"
										value="${companyProfile?.title}"
										noSelection="['':'-Select title-']" />
								</div>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3" for="email">(b)
									First Name</label>
								<div class="col-sm-9">
									<input type="text" class="width" name="firstName"
										value="${companyProfile?.firstName}">
								</div>
							</div>
						</div>



						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3" for="email">(c)
									Middle Name</label>
								<div class="col-sm-9">
									<input type="text" class="width" name="middleName"
										value="${companyProfile?.middleName}">
								</div>
							</div>
						</div>



						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3" for="email">(d)
									Last Name</label>
								<div class="col-sm-9">
									<input type="text" class="width" name="lastName"
										value="${companyProfile?.lastName}">
								</div>
							</div>
						</div>


						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3" for="email">(e)
									Designation</label>
								<div class="col-sm-9">
									<input type="text" class="width" name="designation"
										value="${companyProfile?.designation}">
								</div>
							</div>
						</div>




						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3" for="email">(f)
									Mobile</label>
								<div class="col-sm-9">
									<input type="text" class="width" name="personMobile"
										value="${companyProfile?.personMobile}">
								</div>
							</div>
						</div>




						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3" for="email">(g)
									Email</label>
								<div class="col-sm-9">
									<input type="text" class="width" name="personEmail"
										value="${companyProfile?.personEmail}">
								</div>
							</div>
						</div>



						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3" for="email">(h)
									Attach a copy of document of incorporation or registration duly
									attested by the competent Authority</label>
								<div class="col-sm-7">
									<g:if test="${companyProfile?.registrationDoc}">
										<g:link controller="applicationManagement" action="showDc"
											id="${companyProfile?.id}" target="_blank"
											params="[filename: 'registrationDocName', dataName: 'registrationDoc',csrfPreventionSalt:'${csrfPreventionSalt}']">
											${companyProfile?.registrationDocName}
										</g:link>
									</g:if>
									<g:else>
										<input type="file" class="width" name="RegistrationDoc ">
									</g:else>
								</div>

							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3" for="email">(i)
									Attach the passport copy with Self Attestation</label>
								<div class="col-sm-7">
									<g:if test="${companyProfile?.passportCopy}">
										<g:link controller="applicationManagement" action="showDc"
											id="${companyProfile?.id}" target="_blank"
											params="[filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:'${csrfPreventionSalt}']">
											${companyProfile?.passportCopyFileName}
										</g:link>
									</g:if>
									<g:else>
										<input type="file" class="width" name="Passport">
									</g:else>
								</div>

							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3" for="email">(j)
									Attach a copy of letter of authorization or board resolution or
									office order issued by the competent authority of the
									representative (referred under VI) for signing the application
									(as per schedule A)</label>
								<div class="col-sm-7">
									<g:if test="${companyProfile?.passportCopy}">
										<g:link controller="applicationManagement" action="showDc"
											id="${companyProfile?.id}" target="_blank"
											params="[filename: 'authorizationLetterFileName', dataName: 'authorizationLetterFileName',csrfPreventionSalt:'${csrfPreventionSalt}']">
											${companyProfile?.authorizationLetterFileName}
										</g:link>
									</g:if>
									<g:else>
										<input type="file" class="width" name="AuthorizationLetter">
									</g:else>
								</div>

							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-12 register-heading">(v)
									Address of the contact person / agent , if any , in india</label>
							</div>
						</div>
						<div class="col-sm-12">
							<div class="form-group">
								<div class="col-sm-7 g">

									<input type="radio" name="name" class="radio" value="Yes"
										style="float: left"> <b
										style="float: left; padding-right: 2vw">Yes</b> <input
										type="radio" name="name" class="radio" value="No"
										style="float: left"> <b>No</b>
								</div>
							</div>
						</div>

						<div class="Yes ">
							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3" for="email">(a)
										Profile</label>
									<div class="col-sm-9">
										<select class="width controlreq">
											<option></option>
										</select>
									</div>
								</div>
							</div>


							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3">(b) Please
										Specify</label>
									<div class="col-sm-9">
										<input type="email" class="width controlreq">
									</div>
								</div>
							</div>

							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3">(c) Title</label>
									<div class="col-sm-9">
										<g:select name="agentTitle" req="1" class="width controlreq"
											value="${agentProfile?.title}"
											from="${AgentProfile.TitleName.values()}"
											noSelection="['':'-Select title-']" />
									</div>
								</div>
							</div>

							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3">(d) First Name</label>
									<div class="col-sm-9">
										<input type="text" class="width controlreq"
											name="agentFirstName" value="${agentProfile?.firstName}">
									</div>
								</div>
							</div>



							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3" for="email">(e)
										Middle Name</label>
									<div class="col-sm-9">
										<input type="text" class="width controlreq"
											name="agentMiddleName" value="${agentProfile?.middleName}">
									</div>
								</div>
							</div>



							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3">(f) Last Name</label>
									<div class="col-sm-9">
										<input type="text" class="width" name="agentLastName"
											value="${agentProfile?.lastName}">
									</div>
								</div>
							</div>

							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3">(g) Address line1</label>
									<div class="col-sm-9">
										<input type="text" class="width" name="agentAddress1"
											value="${agentProfile?.address1}">
									</div>
								</div>
							</div>

							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3">(h) Address line2</label>
									<div class="col-sm-9">
										<input type="text" class="width" name="agentAddress2"
											value="${agentProfile?.address2}">
									</div>
								</div>
							</div>


							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3">(i) Address line3</label>
									<div class="col-sm-9">
										<input type="text" class="width" name="agentAddress3"
											value="${agentProfile?.address3}">
									</div>
								</div>
							</div>

							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3">(e)
										State/Province</label>
									<div class="col-sm-9">
										<input type="text" class="width controlreq" name="agentState"
											value="${agentProfile?.province}" required="required">
									</div>
								</div>
							</div>

							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3"> (f) City</label>
									<div class="col-sm-9">
										<input type="text" class="width controlreq" name="agentCity"
											value="${agentProfile?.city}" required="required">
									</div>
								</div>
							</div>

							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3">(g) Zip/Pincode</label>
									<div class="col-sm-9">
										<input type="text" class="width controlreq"
											name="agentPincode" value="${agentProfile?.pincode}"
											required="required">
									</div>
								</div>
							</div>

							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3">(j) Mobile</label>
									<div class="col-sm-9">
										<input type="text" class="width controlreq mobile"
											name="agentMobile" value="${agentProfile?.mobile}">
									</div>
								</div>
							</div>

							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3">(k) Phone</label>
									<div class="col-sm-9">
										<input type="text" class="width controlreq" name="agentPhone"
											value="${agentProfile?.phone}">
									</div>
								</div>
							</div>

							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3" for="email">(l)
										Email</label>
									<div class="col-sm-9">
										<input type="text" class="width controlreq email"
											name="agentEmail" value="${agentProfile?.email}">
									</div>
								</div>
							</div>
							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3" for="email">(m)
										Attach a copy of letter of authorization or power of attorney
										issued by the applicant to the agent / contact person in India
										(as per Schedule A)</label>
									<div class="col-sm-7">
										<g:if test="${agentProfile?.authorizationLetter}">
											<g:link controller="applicationManagement"
												action="showAgentDc" id="${agentProfile?.id}"
												target="_blank"
												params="[filename: 'authorizationLetterFileName', dataName: 'authorizationLetterFileName',csrfPreventionSalt:'${csrfPreventionSalt}']">
												${agentProfile?.authorizationLetterFileName}
											</g:link>
										</g:if>
										<g:else>
											<input type="file" class="width pdf controlreq"
												name="AgentAuthorityLetter">
										</g:else>
									</div>

								</div>
							</div>



							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3" for="email">(n)
										Attach self attested copies of photo identity (driving licence
										etc.) and address proof (passport) of the agent and contact
										person</label>
									<div class="col-sm-7">
										<g:if test="${agentProfile?.passportCopy}">
											<g:link controller="applicationManagement"
												action="showAgentDc" id="${agentProfile?.id}"
												target="_blank"
												params="[filename: 'passportCopyFileName', dataName: 'passportCopyFileName',csrfPreventionSalt:'${csrfPreventionSalt}']">
												${agentProfile?.passportCopyFileName}
											</g:link>
										</g:if>
										<g:else>
											<input type="file" class="width" name="AgentPassportFile">
										</g:else>
									</div>

								</div>
							</div>

						</div>

						<div class="form-group">
							<div class="col-sm-8"></div>


							<div class="col-sm-2">
								<button type="submit" class="btn  login-btin">Submit</button>
							</div>
							<div class="col-sm-2">
								<g:link controller="applicationManagement" action="form1Part2"
									params="[appFormId:appForm?.id,csrfPreventionSalt:'${csrfPreventionSalt}']"
									class="btn  login-btin pull-right" method="POST">Next</g:link>
							</div>
						</div>

					</g:uploadForm>
					<!--login form ends -->
				</div>



			</div>
		</div>
	</div>
	<!-- /.container -->
	<div class="clearfix"></div>

</body>

</html>
