<%! import org.nba.application.IndividualProfile %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />

<title>NBA</title>

<script type="text/javascript">
	$(document).ready(function() {
		
		IndividualProfile();
		var value=sessionStorage.getItem("green");
		
		//addCompletegreenClass(value);
		
	});
</script>

<!--calender codes end -->
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
				<g:render template="leftTabs"/>

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
				<div class="main-registeration col-sm-12 blue-bg"
					style="border: 1px solid #9E9E9E; border-radius: 5px">
					<!--login form -->

					<g:uploadForm class="form-horizontal" role="form"
						action="submitIndividualFormProfile" autocomplete="off">
					<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-12 register-heading">(i)
									Full Particulars of the Applicant</label>
							</div>
						</div>


						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3">(a)
									Title</label>
								<div class="col-sm-9">
									<g:select name="title" req="1" class="width"
										value="${individualProfile?.title}"
										from="${IndividualProfile.TitleName.values()}"
										noSelection="['':'-Select title-']" />
								</div>
							</div>
						</div>


						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3">(b)
									First Name</label>
								<div class="col-sm-9">
									<input type="text" class="width" name="firstName" req="1"
										value="${individualProfile?.firstName}">
								</div>
							</div>
						</div>



						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3">(c)
									Middle Name</label>
								<div class="col-sm-9">
									<input type="text" class="width" name="middleName"
										value="${individualProfile?.middleName}">
								</div>
							</div>
						</div>



						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3">(d)
									Last Name</label>
								<div class="col-sm-9">
									<input type="text" class="width" name="lastName"
										value="${individualProfile?.lastName}">
								</div>
							</div>
						</div>

					<div class="col-sm-12">
						<div class="form-group">
							<label class="control-label col-sm-3" >(e)
								Nationality</label>
							<div class="col-sm-9">
								<select class="width" name="nationality" id="nationality"
									value="${individualProfile?.nationality}">
									<option value="" selected>Select</option>
									<option value="nonResidentIndian">Non-Resident Indian</option>
									<option value="nonIndian">Non Indian</option>
								</select>

							</div>
						</div>

						<div class="col-sm-12" id="otherNationality">
							<div class="form-group">
								<label class="control-label col-sm-3">Specify
									Nationality</label>
								<div class="col-sm-9">
									<input type="text" class="width" name="otherNationality">
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
								<label class="control-label col-sm-3" >(a)
									Address line1</label>
								<div class="col-sm-9">
									<input type="text" class="width" name="address1"
										value="${individualProfile?.address1}">
								</div>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3">(b)
									Address line2</label>
								<div class="col-sm-9">
									<input type="text" class="width" name="address2"
										value="${individualProfile?.address2}">
								</div>
							</div>
						</div>


						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3" >(c)
									Address line3</label>
								<div class="col-sm-9">
									<input type="text" class="width" name="address3"
										value="${individualProfile?.address3}">
								</div>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3" >(d)
									Country</label>
								<div class="col-sm-9">

									<g:select name="countryId" from="${listOfCountries}"
										optionKey="id" optionValue="country"
										value="${individualProfile?.country?.id}"
										class="width" noSelection="['':'-Select-']"
										required="required" />


								</div>
							</div>
						</div>


						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3">(e)
									State/Province</label>
								<div class="col-sm-9">
									<input type="text" class="width" name="province"
										value="${individualProfile?.title}">
								</div>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3">(f)
									City</label>
								<div class="col-sm-9">

									<input type="text" class="width" name="city" value="${individualProfile?.city}">

								</div>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3" >(g)
									ZIP/Pincode</label>
								<div class="col-sm-9">

									<input type="text" class="width" name="pincode" value="${individualProfile?.pincode}">

								</div>
							</div>
						</div>


						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3">(h)
									Mobile</label>
								<div class="col-sm-9">

									<input type="text" class="width" name="mobile" value="${individualProfile?.mobile}">

								</div>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3">(i)
									Phone</label>
								<div class="col-sm-9">

									<input type="text" class="width" name="phone" value="${individualProfile?.phone}">

								</div>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3" for="email">(j)
									Email</label>
								<div class="col-sm-9">

									<input type="email" class="width" name="email" value="${individualProfile?.email}">

								</div>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3" >(k)
									Attach ID proof copy with Self Attestation (Driving
									License,etc)</label>
								<div class="col-sm-7">

								<g:if test="${individualProfile?.idProof}">
										<g:link controller="applicationManagement" action="showIndividualDc"
											id="${individualProfile?.id}" target="_blank"
											params="[filename: 'idProof', dataName: 'idProof',csrfPreventionSalt:'${csrfPreventionSalt}']">
											${individualProfile?.idProofFileName}
										</g:link>
									</g:if>
									<g:else>
									<input type="file" class="width" name="IdProof">

									</g:else>
								</div>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3" >(l)
									Attach the passport copy with Self Attestation</label>
								<div class="col-sm-7">

								<g:if test="${individualProfile?.passportCopy}">
										<g:link controller="applicationManagement" action="showIndividualDc"
											id="${individualProfile?.id}" target="_blank"
											params="[filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:'${csrfPreventionSalt}']">
											${individualProfile?.passportCopyFileName}
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
								<label class="control-label col-sm-3" >(m)
									Attach the Authorization letter duly filled in , if necessary</label>
								<div class="col-sm-7">

								<g:if test="${individualProfile?.authorizationLetter}">
										<g:link controller="applicationManagement" action="showIndividualDc"
											id="${individualProfile?.id}" target="_blank"
											params="[filename: 'authorizationLetter', dataName: 'authorizationLetter',csrfPreventionSalt:'${csrfPreventionSalt}']">
											${individualProfile?.authorizationLetterFileName}
										</g:link>
									</g:if>
									<g:else>
									<input type="file" class="width" name="AuthorityLetter">

									</g:else>
								</div>
								
							</div>
						</div>
<%--						<div class="col-sm-12">--%>
<%--						<table class="table table-bordered datatable">--%>
<%--						<tr>--%>
<%--						<th>Sr.No</th>--%>
<%--						<th>Title</th>--%>
<%--						<th>First name</th>--%>
<%--						</tr>--%>
<%--						</table>--%>
<%--						</div>--%>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-12 register-heading">(iii)
									Profile of the Applicant(s)</label>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-3">(a)
									Profile</label> <select class="width" name="profile"
									id="profile">
									<option value="">Select</option>
									<option value="student">Student</option>
									<option value="researcher">Researcher</option>
									<option value="others">Others</option>
								</select>
							</div>
						</div>


						<div class="col-sm-12" id="otherProfile">
							<div class="form-group">
								<label class="control-label col-sm-3" >(b)
									Please Specify</label>
								<div class="col-sm-9">
									<input type="email" class="width">
								</div>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<label class="control-label col-sm-12 register-heading">(iv)
									Address of the contact person/agent, if any, in India</label>
							</div>
						</div>

						<div class="col-sm-12">
							<div class="form-group">
								<div class="col-sm-7 fg">

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
									<label class="control-label col-sm-3">(a)
										Profile</label>
									<div class="col-sm-9">
										<select class="width controlreq" name="agentProfile"
											id="agentProfile">
											<option value="">Select</option>
											<option value="student">Student</option>
											<option value="researcher">Researcher</option>
											<option value="others">Others</option>
										</select>
									</div>
								</div>
							</div>


							<div class="col-sm-12" id="otherAgentProfile">
								<div class="form-group">
									<label class="control-label col-sm-3">(b)
										Please Specify</label>
									<div class="col-sm-9">
										<input type="email" class="width controlreq">
									</div>
								</div>
							</div>
							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3">(c)
										Title</label>
									<div class="col-sm-9">
										<g:select name="agentTitle" class="width controlreq"
											value="${agentProfile?.title}"
											from="${IndividualProfile.TitleName.values()}"
											noSelection="['':'-Select title-']" />
									</div>
								</div>
							</div>


							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3">(d)First
										Name</label>
									<div class="col-sm-9">

										<input type="text" class="width controlreq" name="agentfirstname" value="${agentProfile?.firstName}">

									</div>
								</div>
							</div>
							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3">(e)Middle
										Name</label>
									<div class="col-sm-9">

										<input type="text" class="width controlreq"
											name="agentmiddlename" value="${agentProfile?.middleName}">

									</div>
								</div>
							</div>
							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3">(f)Last
										Name</label>
									<div class="col-sm-9">

										<input type="text" class="width controlreq" name="agentlastname" value="${agentProfile?.lastName}">

									</div>
								</div>
							</div>
							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3">(g)Address
										Line 1</label>
									<div class="col-sm-9">

										<input type="text" class="width controlreq" name="agentaddress1" value="${agentProfile?.address1}">

									</div>
								</div>
							</div>
							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3">(h)Address
										Line 2</label>
									<div class="col-sm-9">

										<input type="text" class="width " name="agentaddress2" value="${agentProfile?.address2}">

									</div>
								</div>
							</div>
							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3">(i)Address
										Line 3</label>
									<div class="col-sm-9">

										<input type="text" class="width" name="agentaddress3" value="${agentProfile?.address3}">

									</div>
								</div>
							</div>

							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3" >(e)
										Province</label>
									<div class="col-sm-9">
										<input type="text" class="width controlreq" name="agentProvince"
											value="${agentProfile?.title}">
									</div>
								</div>
							</div>
							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3" >(f)
										City</label>
									<div class="col-sm-9">

										<input type="text" class="width controlreq" name="agentCity" value="${agentProfile?.city}">

									</div>
								</div>
							</div>

							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3">(k)ZIP/Pincode</label>
									<div class="col-sm-9">

										<input type="text" class="width controlreq" name="agentPincode" value="${agentProfile?.pincode}">

									</div>
								</div>
							</div>
							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3" >(j)Mobile</label>
									<div class="col-sm-9">

										<input type="text" class="width controlreq mobile" name="agentmobile" value="${agentProfile?.mobile}">

									</div>
								</div>
							</div>
							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3" for="email">(l)Email</label>
									<div class="col-sm-9">

										<input type="email" class="width controlreq email" name="agentemail" value="${agentProfile?.email}">

									</div>
								</div>
							</div>

							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3">(m)
										Attach a copy of letter of Authorization or power of attorney
										issued by the applicant to the agent/contact person in
										India(As per Schedule A)</label>
									<div class="col-sm-7">

									<g:if test="${agentProfile?.authorizationLetter}">
										<g:link controller="applicationManagement" action="showIndividualDc"
											id="${agentProfile?.id}" target="_blank"
											params="[filename: 'authorizationLetter', dataName: 'authorizationLetter',csrfPreventionSalt:'${csrfPreventionSalt}']">
											${agentProfile?.authorizationLetterFileName}
										</g:link>
									</g:if>
									<g:else>
										<input type="file" class="width controlreq pdf" name="AgentAuthorityLetter">
											</g:else>
									</div>
								</div>
							</div>

							<div class="col-sm-12">
								<div class="form-group">
									<label class="control-label col-sm-3">(n)
										Attach self attested copies of photo identity(driving licence
										etc.) and Address proof(Passport) of the agent/contact person</label>
									<div class="col-sm-7">
										<input type="file" class="width controlreq pdf"
											name="AgentPassportFile">
									</div>
									
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-8"></div>
							<div class="col-sm-2">

							</div>
							<div class="col-sm-2">

								<input type="Submit" class="btn login-btin" onClick="JavaScript:setsession()" value="Submit"></input>
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
	</div>
	<!-- /.container -->
	<div class="clearfix"></div>

</body>

</html>
