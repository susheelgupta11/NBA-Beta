
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="layout" content="main" />
<meta name="description" content="">
<meta name="author" content="">

</head>

<body>
	<div class="col-sm-12 Top_padding">

		<div class="col-sm-12 ">
		
		<div class="col-sm-10 col-sm-offset-1">
		<a href="#"><h3><b id="toplinkbutton">ABS e-filing </b></h3></a>
		</div>
		
		<div class="row">
		<div class="col-sm-7">
					<div class="login-about">
<br/>
							<br/>
						<div id="heighttop" class="nopadding login-wrapper ">
						
						<div class="col-sm-12 top">
						
						
							<p class="login-content leftflot color">National Biodiversity
								Authority, established in 2003 to implement the Biological
								Diversity Act, 2002, is an autonomous and statutory body to
								perform regulatory and advisory functions for Government of
								India on issues of conservation of biodiversity, sustainable use
								of its components and realization of fair and equitable sharing
								of benefits arising out of use of biological resources. </p>
								<p class="login-content leftflot color">
								As part of its mandatory functions,
								NBA regulates access to India’s biological resources and
								associated knowledge by Indians and non‐Indians as well, for
								various kinds of activities, such as access for research,
								commercial utilization and obtaining of IPRs for the inventions
								based on any research or information on a biological resource
								obtained from India.
								</p>
							<p class="login-content leftflot color">
								Biological Diversity Rules, 2004 lays down various Forms, fees,
								time lines and procedures to facilitate the applicants in
								obtaining prior approval of the NBA for various activities under
								the BD Act. The application may be submitted online using this
								platform. The applicants are requested to sign up and follow
								the procedures as per the instructions. 
							</p>
							
							
							</div>
							
							
							
							
						</div>
					</div>
				</div>
				<div class="col-sm-5">
					<br/><br/>
					<div id="heighttop" class="login-wrapper ">
						<h4 class="sinIn">Sign In to your account</h4>
						<div class="main-login">
							
							<form action='${postUrl}' method='POST' id='loginForm'
								 autocomplete='off' id="loginForm" class="top"
								name="loginForm">
							<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	
								<g:if test='${flash.message}'>
									<div class='topPadding error'>
										${flash.message}
									</div>
								</g:if>
								<div class="form-group col-sm-12">

									<label for="UserId" class="control-label col-sm-3 "><g:message
											code='Username' /></label>
									<div class="col-md-9">
										<input type="text" class="form-control" name="j_username"
											req="1" id="username" style="width: 100%;" />
									</div>

								</div>
								<div class="form-group col-sm-12">
									<label class="control-label col-sm-3 " for="pwd">Password</label>
									<div class="col-md-9">
										<input type="password" class="form-control" req="1"
											name="j_password" id="password" />
									</div>
								</div>
																<div class="form-group col-sm-12">
									<label class="control-label col-sm-3 " >Captcha</label>
									<img src="${createLink(controller: 'simpleCaptcha', action: 'captcha')}" />
									<div class="col-sm-6">
										<label id="lblcaptcha" for="captcha" class="col-sm-offset-1">Type
											the letters shown above:</label>
										<div class="col-sm-offset-1">
											<g:textField name="captcha" req="1" />
											<g:if test='${captchaInvalid == true}'>
												<span class="error">invalid captcha</span>
											</g:if>
										</div>
									</div>
								</div>
								<div class="form-group col-sm-12">
									<div class="col-sm-offset-3 col-sm-9">
										<button type="submit" class="btn btn-success">Login</button>
										<g:link href="#" class="btn btn-primary" controller="register"
											action="index">Sign Up</g:link>


									</div>
								</div>
								<div class="form-group text-center red col-sm-12">
									<g:link class="forgot-pwd" controller="register"
										action="forgotPassword" class="red">Forgot Password</g:link>
									<span> |</span>
									<g:link class="register-user" controller="register"
										action="forgotUsername" class="red">Forgot UserName</g:link>
								</div>
							</form>	
							<!--login form ends -->
						</div>
						
					</div>
				</div>				
		</div>
		
		
		
		<div class="row">
		<div class="col-sm-7">
		
		<div class="col-sm-6">
		<div id="updatewidth" class="row">
							<div class="col-sm-12 login-wrapper" style="padding:0px;">
							<h4 class="sinIn">Latest Update</h4>
							
							<marquee id="boxheight" direction="up">
							<ul style="list-style-type: decimal">
							<li><a href="#">NBA Presentation1 pdf</a></li>
							<li><a href="#">NBA Presentation2 pdf</a></li>
							<li><a href="#">NBA Presentation3 pdf</a></li>
							<li><a href="#">NBA Presentation4 pdf</a></li>							
							</ul>
							</marquee>
							</div>
							
							</div>
					</div>								
					
					<div class="col-sm-6">
		<div id="updatewidth" class="row">
							<div  class="col-sm-12 login-wrapper" style="padding:0px;">
							<h4 class="sinIn">Video</h4>
							<div id="boxheight">
							
							<iframe width="100%" height="100%"
src="https://youtu.be/dfqMDUpXoOs">
</iframe>

							</div>
							</div>
							
							</div>
					</div>								
					
					
					
						
				</div>
				
				<div class="col-sm-5">
				
				<div id="referenceCorner" class="login-wrapper">
					<h4 class="sinIn">Reference Corner</h4>
								<div id="boxheight" class="row refTop">
									<div id="RefPadding" class="col-sm-12">
										<img src="${resource(dir: 'images', file: 'image5.PNG')}"

											alt="logo" class="img-responsive leftflot" /><g:link controller="register" action="howToApply"
											class="text-primary "><b>Instructions to Applicant</b></g:link>

									</div>
									<div id="RefPadding" class="col-sm-12">
										<img src="${resource(dir: 'images', file: 'image5.PNG')}"
											alt="logo" class="img-responsive leftflot" /><span
											class="text-primary "><b>FAQ</b></span>
									</div>
									<div id="RefPadding" class="col-sm-12">
										<img src="${resource(dir: 'images', file: 'image5.PNG')}"
											alt="logo" class="img-responsive leftflot" /><span
											class="text-primary "><b>Model Application Formats</b></span>
									</div>
								</div>
					</div>
				
				
				</div>	
					
					
					
		</div>
		
		<!-- fINISH NEW PART -->
			
		</div>






	</div>


</body>

</html>
