<%! import org.nba.master.ManageLoginContent %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"  />

<meta name="layout" content="main" />
<meta name="description" content="">
<meta name="author" content="">
    <asset:javascript src="/ckeditor/ckeditor.js"/>
    <asset:javascript src="/ckeditor/jquery.js"/>
    <asset:javascript src="/aes.js"/>
    
    
    <style>
   
    div#editor {
        width: 100%;
        margin: auto;
        text-align: justify;
    }
    
    
    </style>
    <% def aboutNBA = ManageLoginContent?.findByRev(0) %>
	<g:javascript>
 		 var data = "${aboutNBA?.aboutNBA}"
 		 var latestupdates = "${aboutNBA?.latestUpdate }"
 		 var securl = "${createLink(controller:'login',action:'sec')}"
  	</g:javascript>
  	
  	
	
	
<script type="text/javascript">
function encrypppt() {

	var secret = "" ;
	
	$.ajax({
		type : "POST",
		url : securl,
		data : {
			abc : "",
		},
		success : function(result) {

			secret = result.sec;
			alert("result = "+result.sec+" secret= "+secret);
			abc(secret);
		},
		error : function() {
			alert("An error has occured!!!");
		}

	});	

}

function abc(secret) {
	var plainText = $("#password").val();
	alert("----secret------ "+secret+" plaintext is = "+plainText);
	//var secret = aaaa;
	var encrypted = CryptoJS.AES.encrypt(plainText, secret);
	encrypted = encrypted.toString();
	var str = encrypted.substring(encrypted.length-6);
	alert("encrypted = "+encrypted+" str=="+str);
	 $("#password").val(encrypted + '${session["csrfPreventionSalt"]}');
    $("#hid").val(str);
}




		

        $(document).ready(function () {
            var value;
            $('#username').focus();
            $("#btnSubmit").click(function () {
                GetPassword();
            });

    		var html = $(data);
    		var update = $(latestupdates)
    		$('#editor').html(html);
    		$('#latUpdates').html(update);
        });

	
	$(window).load(function() {
		
		$("#cke_1_top").remove();
	});

	
		</script>
		

		
</head>

<body>
	<input type="hidden" id="aaaa" value="${sec }"/>

	<div class="col-sm-12 Top_padding">

		<div class="col-sm-12 ">

			<div class="col-sm-10 col-sm-offset-1">
				<h3>
						<b id="toplinkbutton" class="btn btn-success">ABS e-filing </b>
					</h3>
			</div>

			<div class="row">
				<div class="col-sm-7">
					<div class="login-about">
						<br />

						<div id="heighttop" class="nopadding login-wrapper ">

							<div class="col-sm-12 top">
							
								<% def aboutNBA = ManageLoginContent?.findByRev(0) %>

								<div id="editor">
									
<%--									${aboutNBA?.aboutNBA }--%>
									
<%--									<g:textArea id='edit' autocomplete="off" name="aboutUs"--%>
<%--										value="${aboutNBA?.aboutNBA }" style="margin-top: 10px;">--%>
<%--									</g:textArea>--%>
								</div>

								<%--<p class="login-content leftflot color">National
									Biodiversity Authority, established in 2003 to implement the
									Biological Diversity Act, 2002, is an autonomous and statutory
									body to perform regulatory and advisory functions for
									Government of India on issues of conservation of biodiversity,
									sustainable use of its components and realization of fair and
									equitable sharing of benefits arising out of use of biological
									resources.</p>
								<p class="login-content leftflot color">As part of its
									mandatory functions, NBA regulates access to India’s biological
									resources and associated knowledge by Indians and non‐Indians
									as well, for various kinds of activities, such as access for
									research, commercial utilization and obtaining of IPRs for the
									inventions based on any research or information on a biological
									resource obtained from India.</p>
								<p class="login-content leftflot color">Biological Diversity
									Rules, 2004 lays down various Forms, fees, time lines and
									procedures to facilitate the applicants in obtaining prior
									approval of the NBA for various activities under the BD Act.
									The application may be submitted online using this platform.
									The applicants are requested to sign up and follow the
									procedures as per the instructions.</p>
							--%></div>
						</div>
					</div>
				</div>
				<div class="col-sm-5">
					<br />
					<div id="heighttop" class="login-wrapper ">
						<h4 class="sinIn">Sign In to your account</h4>
						<div class="main-login">
						
							<form action='${postUrl}' method='POST' id='loginForm'
								autocomplete='off' id="loginForm" name="loginForm">
							<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	
								<g:if test='${flash.message}'>
									<div class=' red text-center errorpadding'>
										${flash.message}
									</div>
								</g:if>
								<div class="form-group col-sm-12 top">

									<label for="UserId" class="control-label col-sm-3 "><g:message
											code='Username' /></label>
									<div class="col-md-9">
										<input type="text" class="form-control" name="j_username" required="required"
											req1="1" id="username" style="width: 100%;" />
									</div>

								</div>
								<div class="form-group col-sm-12">
									<label class="control-label col-sm-3 " for="pwd">Password</label>
									<div class="col-md-9">
										<input type="password" class="form-control" req1="1"
											name="j_password" id="password" required="required"/>
									</div>
								</div>
								<div class="form-group col-sm-12">
									<label class="control-label col-sm-3 ">Captcha</label> 
									
									<div class="col-sm-4">
								
									<img src="${createLink(controller: 'simpleCaptcha', action: 'captcha')}" class="captcha"  />
<%--									<g:remoteLink controller="simpleCaptcha" action="captcha" update="success" class="captcha"><i class="fa fa-refresh" style="font-size:24px;"></i></g:remoteLink>--%>
										<a href="#" onclick="reloadCaptcha();"><i class="fa fa-refresh" style="font-size:18px;"></i></a>
									</div>
									
<%--									<img id="success" src="" alt="captcha"/>--%>
									<script type="text/javascript">
                                   function reloadCaptcha(){
                                	   window.location.reload();
	                                  }
									</script>
									
									<div class="col-sm-4 ">
									
									<g:textField name="captcha"  req="1" class="margin-top" required="required"/>
									
									<g:if test='${captchaInvalid == true}'>
										<span class="error">invalid captcha</span>
									</g:if>
									</div>
									
								</div>
								<div class="col-sm-12 form-group">
									
											
								
								</div>
								
								
								<div class="form-group col-sm-12">
									<div class="col-sm-offset-5 col-sm-6">
										<input type="hidden" id="hid" name="str" />
										<button type="submit" class="btn btn-success" onclick="encrypt()">Login</button>
										


									</div>
								</div>
								<div class="form-group text-center red col-sm-12">
									<g:link class="forgot-pwd" controller="register"
										action="forgotPassword" class="red" params='[]'>Forgot Password</g:link>
									<span> |</span>
									<g:link class="register-user" controller="register"
										action="forgotUsername" class="red" params='[]'>Forgot UserName</g:link>
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
							<div class="col-sm-12 login-wrapper" style="padding: 0px;">
								<h4 class="sinIn">Latest Update</h4>

								<marquee id="boxheight" scrollamount="3" direction="up" onmouseover="this.stop();" onmouseout="this.start();">
									<ul style="list-style-type: decimal;-webkit-padding-start: 10px; padding-right:10px;">
									
									<span id="latUpdates" style= "text-align:justify"></span>
									
										<%--<b>Introduction of ABS e-filing beta version.</b>
										<p class="login-content leftflot color">As a measure of providing improved services to the users, the NBA introduces e-filing of ABS Application through 
										online by the users. Making use of this facility, users can submit application for access to biological resources and associated knowledge 
										for various activities, attach the required documents and also make payment of fee at a time.</p>
										
										--%><%--<li><a href="#">NBA Presentation1 pdf</a></li>
										<li><a href="#">NBA Presentation2 pdf</a></li>
										<li><a href="#">NBA Presentation3 pdf</a></li>
										<li><a href="#">NBA Presentation4 pdf</a></li>
									--%></ul>
								</marquee>
							</div>

						</div>
					</div>

					<div class="col-sm-6">
						<div id="updatewidth" class="row">
							<div class="col-sm-12 login-wrapper" style="padding: 0px;">
								<h4 class="sinIn">Video</h4>
								<div id="boxheight">

									<iframe width="100%" height="100%"
										src="http://www.youtube.com/embed/dcVTK-6D2l0?rel=0" allowfullscreen="allowfullscreen"> </iframe>

								</div>
							</div>

						</div>
					</div>
				</div>

				<div class="col-sm-5">

					<div id="referenceCorner" class="login-wrapper">
						<h4 class="sinIn">Reference Corner</h4>
						<div id="boxheight" class="row refTop">
							<div id="RefPadding" class="col-sm-8">
								<img src="${resource(dir: 'images', file: 'blue.png')}" class="lessTopmargin"
									alt="logo" class="img-responsive leftflot" />
								<g:link controller="register" action="howToApply" params='[aboutNBAId: "${aboutNBA?.id }"]'
									class="text-primary ">
									<b>Instructions to Applicant</b>
								</g:link>

							</div>
							<div id="RefPadding" class="col-sm-8">

								<img src="${resource(dir: 'images', file: 'blue.png')}"
									class="lessTopmargin" alt="logo"
									class="img-responsive leftflot" />
								<g:if test="${doc != null}">
									<g:link class="text-primary " controller="login"
										action="showDc" id="${doc?.id}" target="_blank"
										params='[filename: "manual", dataName: "manual"]'>
										<b>User Manual</b>
									</g:link>
								</g:if>
								<g:else>
									<b class="text-primary ">User Manual</b>
								</g:else>
							</div>
							<div id="RefPadding" class="col-sm-8">
								<img src="${resource(dir: 'images', file: 'blue.png')}" class="lessTopmargin"
									alt="logo" class="img-responsive leftflot" /><g:link controller="register" action="faq" params='[aboutNBAId: "${aboutNBA?.id }"]'
									class="text-primary "><b>FAQs</b></g:link>
							</div>
							<%--<div id="RefPadding" class="col-sm-12">
								<img src="${resource(dir: 'images', file: 'image5.PNG')}"
									alt="logo" class="img-responsive leftflot" /><span
									class="text-primary "><b>Model Application Formats</b></span>
							</div>
							--%><div id="RefPadding" class="col-sm-8">
								<img src="${resource(dir: 'images', file: 'blue.png')}" class="lessTopmargin"
									alt="logo" class="img-responsive leftflot" />
								<g:link controller="register" action="knowYourFormPart1" params='[]'
									class="text-primary ">
									<b>Know Your Application</b>
								</g:link>
							</div>
						</div>
					</div>


				</div>



			</div>

			<!-- fINISH NEW PART -->

		</div>






	</div>

<g:javascript>
 		 var sec = "${sec}"
 		 var csrf = "${session["csrfPreventionSalt"]}"
  	</g:javascript>
</body>

</html>

