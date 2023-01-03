<%! import org.nba.master.ManageLoginContent %>
<!DOCTYPE html>
<html lang="en">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Home</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
<%--	<link rel="shortcut icon" href="favicon.ico">--%>
	
	<link rel="shortcut icon" href="${assetPath(src: 'logo.png')}" type="image/x-icon">
	
	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>
	<!-- Animate.css -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<asset:stylesheet src="home/animate.css"/>
	<!-- Icomoon Icon Fonts-->
	<asset:stylesheet src="home/icomoon.css"/>
	<!-- Bootstrap  -->
	<asset:stylesheet src="home/bootstrap.css"/>
	<!-- Superfish -->
	<asset:stylesheet src="home/superfish.css"/>
	<!-- Magnific Popup -->
	<asset:stylesheet src="home/magnific-popup.css"/>
	<!-- Date Picker -->
	<asset:stylesheet src="home/bootstrap-datepicker.min.css"/>
	<!-- CS Select -->
    
    <asset:stylesheet src="home/cs-select.css"/>
    <asset:stylesheet src="home/cs-skin-border.css"/>
    <asset:stylesheet src="home/style.css"/>
    <asset:stylesheet src="home/component.css"/>
    
  
	<asset:javascript src="home/modernizr.custom.js" />
	<asset:javascript src="NBA.js" />
	<asset:javascript src="/aes.js"/>
	

  <asset:stylesheet src="beta-version/css/jquery.datetimepicker.min.css"/>	
 

    <% def aboutNBA = ManageLoginContent?.findByRev(0) %>
	<g:javascript>
 		 var data = "${aboutNBA?.aboutNBA}"
 		 var latestupdates = "${aboutNBA?.latestUpdate }"
 		 var securl = "${createLink(controller:'login',action:'sec')}"
  	</g:javascript>
  	
 

<script>

function makeid() {
	  var text = "";
	  var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	  for (var i = 0; i < 5; i++)
	    text += possible.charAt(Math.floor(Math.random() * possible.length));

	  return text;
	}

<script type="text/javascript">
function encryppt() {

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


	$(window).load(function() {
		
		generateCaptcha();
	});

	
</script>
	
  
    <style>
#more {display: none;}
</style>
	</head>
	<body>
		<div id="fh5co-wrapper">
		<div id="fh5co-page">
		<header id="fh5co-header-section" class="sticky-banner" >
			<div class="container" style="width:100%;">
				<div class="nav-header">
					<a href="index.html">
					<img src="${resource(dir: 'images', file: 'logo_nba.png')}" width="75" style="float:left; margin-top:8px;" />
                  <h1 id="fh5co-logo">  National Biodiversity Authority
                    </a>
                    <p style="font-size:10px;">
        An Autonomous and Statutory Body of the Ministry of Environment,<br>Forest and Climate Change, Government of India
                    </p>
                    </h1>
                    <div class="row img-load" style="float:right; margin-top:8px;">
                    <div class="col-lg-5 col-sm-6">
                    <img src="${resource(dir: 'images', file: 'MOEF-home.png')}"  width="70"/>
                    </div>
                    <div class="col-lg-6 col-sm-6">
                <img src="${resource(dir: 'images', file: 'Emblem_of_India2-home.png')}"  width="45"/>
                    </div>
                    </div>
				</div>
			</div>
		</header>

		<!-- end:header-top -->
	
		<div class="fh5co-hero">
			<div class="fh5co-overlay"></div>

			<div class="fh5co-cover" data-stellar-background-ratio="0.5" style="background-image:  url(${resource(dir: 'images', file: 'bg-home.jpg')});">
            
				<div class="desc">
					<div class="container" style="width:95%; ">
						<div class="row">
							<div class="col-sm-5 col-md-5">
								<div class="tabulation animate-box" >

								  <!-- Nav tabs -->
								   <ul class="nav nav-tabs" role="tablist">
								      <li role="presentation" class="active">
								      	<a href="#login" aria-controls="login" role="tab" data-toggle="tab">Login</a>
								      </li>
								      <li role="presentation">
								    	   <a href="#reg" onclick="generateCaptcha();" aria-controls="reg" role="tab" data-toggle="tab">New Registration</a>
								      </li>
								      <!--/*<li role="presentation">
								    	   <a href="#packages" aria-controls="packages" role="tab" data-toggle="tab">Packages</a>
								      </li>*/-->
								   </ul>

								   <!-- Tab panes -->
									<div class="tab-content">
									 <div role="tabpanel" class="tab-pane active" id="login">
										<div class="row">
										
			<form action='${postUrl}' method='POST' id='loginForm' autocomplete='off' id="loginForm" name="loginForm">
								<div class="col-sm-12 mt">
                                    
							<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	
												<div class="input-field">
												
													<label for="from">Username:</label>
													<g:if test='${flash.message}'><span style="color: red">${flash.message}</span></g:if>
													<g:if test='${flash.error}'><span style="color: red">${flash.error}</span></g:if>
													<input type="text" class="form-control" name="j_username" required="required"
											req1="1" id="username"/>
													
												</div>
											</div>
											
											<div class="col-sm-12 mt">
												<div class="input-field">
													<label for="pwd">Password:</label>
											<input type="password" class="form-control" req1="1" name="j_password" id="password" required="required"/>
												</div>
											</div>
                                            <div class="col-sm-12 mt">
												<div class="input-field">
													<label for="date-start">Captcha:&nbsp;&nbsp; <img src="${createLink(controller: 'simpleCaptcha', action: 'captcha')}" class="captcha"  />
													
													</label>
													&nbsp;&nbsp; <span><a href="#" onclick="reloadCaptcha();">Refresh</a></span>
													<input type="text" name="captcha"  class="form-control" required="required" placeholder="Enter Captcha"/>
												</div>
											</div>
									<script type="text/javascript">
                                     function reloadCaptcha(){
                                	   window.location.reload();
	                                  }
									</script>		
											<div class="col-xs-12">
										<input type="hidden" id="hid" name="str" />
										<input type="submit" class="btn btn-primary btn-block" value="Login" onclick="encrypt()">
<%--										<button type="submit" class="btn btn-primary btn-block" onclick="encrypt()">Login</button>--%>
											</div>
                                                                                                                                    
                                           </form>
											<div class="col-xs-12" style="margin-top:8px;">
												
					<h5 align="center">
					<a class="md-trigger" data-modal="modal-13" style="cursor:pointer;">Forgot Password? </a>|
                    <a class="md-trigger" data-modal="modal-14" style="cursor:pointer;"> Forgot Username?</a>
                    
                    </h5>

                                           </div>
                                           <g:if test='${flash.message}'>
									<div class=' red text-center errorpadding'>
										${flash.message}
									</div>
								</g:if>
								 
										</div>
										
									 </div>

									 <div role="tabpanel" class="tab-pane" id="reg">
									 	<div class="row">
			                         <g:render template = "registration"/>
										</div>
									 </div>

									</div>
								</div>
							</div>
							 <% def aboutNBA = ManageLoginContent?.findByRev(0) %>
							<div class="desc2 animate-box" id="infoBox">
								<div class="col-sm-6 col-sm-push-1 col-md-6 col-md-push-1 content_background" style="margin-top:-195px;">
									<h2 class="abs-heading" style=" font-size:40px; margin-bottom:.7em;">ABS e-filing</h2>
                                    <h3 style="font-size:15px; text-align:justify; line-height: 23px;; ">${aboutNBA?.aboutNBA?.toString()?.replaceAll("\\<.*?>","")?.replace("&nbsp;", " ")}</h3>
                        <div class="col-xs-12">
                        <g:link controller="login" action="readMore" target="_blank"><button class="btn btn-primary btn-block" style="width: 20%; margin: auto;margin-bottom: 30px;">Read More</button></g:link>
											</div>


                    </div>               
                                   
   <div class="bird-container bird-container--one">
      <div class="bird bird--one"></div>
    </div>
    <div class="bird-container bird-container--two">
      <div class="bird bird--two"></div>
    </div>
    <div class="bird-container bird-container--three">
      <div class="bird bird--three"></div>
    </div>
    <div class="bird-container bird-container--four">
      <div class="bird bird--four"></div>
    </div>
  </div>
 
									<!-- <p><a class="btn btn-primary btn-lg" href="#">Get Started</a></p> -->
								
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
		


                 
                    <div class="col-md-4 col-sm-6 mt-custom  animate-box" data-animate-effect="fadeIn">
						<div class="card">
								<h3>Latest Update</h3>
								<marquee direction="up" scrollamount="4" onmouseover="this.stop();" onmouseout="this.start();" height="250"><p>Shri Anil Madhav Dave, Hon’ble Minister of State for Environment, Forest and Climate Change (Independent Charge) today (30th March 2017) launched the e-filing of ABS applications through online. This new facility provides the users an online platform for submission of applications seeking approval of NBA for various activities using Indian biological resources and associated knowledge.</p></marquee>
								
							
						</div>
					</div>
               
					               
					<div class="col-md-3 col-sm-6 mt-custom animate-box" data-animate-effect="fadeIn">
						<div class="card">
								<h3>Reference Corner</h3>
                                <ul>
                                    <%-- <li><a class="" href="aboutUs.html"><i class="icon-arrow-right22"></i> Instructions to Applicant</a></li> --%>
                                 	<li><g:link controller="register" action="howToApply" params='[aboutNBAId: "${aboutNBA?.id }"]'
									class="">
									<i class="fa fa-arrow-circle-right"></i> Instructions to Applicant
								</g:link></li>
								 
								 
								 <li> 
								 <g:if test="${doc != null}">
								 <g:link  controller="login"
										action="showDc" id="${doc?.id}" target="_blank"
										params='[filename: "manual", dataName: "manual"]'>
										<i class="fa fa-arrow-circle-right"></i> User Manual
									</g:link>
									</g:if>
									<g:else>
									<b> User Manual</b>
								</g:else>
									</li>
								  
								    <li><g:link controller="register" action="faq" params='[aboutNBAId: "${aboutNBA?.id }"]'
									class=" "><i class="fa fa-arrow-circle-right"></i> FAQs</g:link></li>
                                    <li><g:link controller="register" action="knowYourFormPart1" params='[]'
									class="">
									<i class="fa fa-arrow-circle-right"></i> Know Your Application
								</g:link></li>
                                </ul>
						</div>
					</div>
                    
                    <div class="col-md-5 mt-custom col-sm-12 animate-box" data-animate-effect="fadeIn">
						<div class="card">
								<h3>Video</h3>
                   <iframe width="100%" height="282px" style="margin-top:-30px;" src="https://www.youtube.com/embed/uPFgmuqyQ7w" title="ABS efiling NBA" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
							</div>
					</div>
                    
					<div class="col-md-12 text-center animate-box">
					</div>
				</div>
			</div>
		</div>

         <div class="md-modal md-effect-13" id="modal-13">
			<div class="md-content">
				<h3>Forgot Password</h3>
				<div>
				 <div class="row">
				        <g:form action='forgotPassword' controller="register" name="forgotPasswordForm" autocomplete='off'>
				          <div class="col-xxs-12 col-xs-12 mt">
                                               <input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
												<div class="input-field">
													<label for="from">User Name:</label>
													<g:textField name="username" class="form-control" id="from-place" placeholder="Enter User Id"/>
												</div>
											</div>
											
											<div class="col-xs-12">
												<input type="submit" class="btn btn-primary btn-block" value="Submit">
											</div>
											</g:form>
										</div>
                                        
				                   </div>
                     <div class="md-close" style="text-align:center;">Cancel!</div>
			</div>
		</div>
        
 <div class="md-modal md-effect-13" id="modal-14">
			<div class="md-content">
				<h3>Forgot Username</h3>
				<div>
					
                                        <div class="row">
											<div class="col-xxs-12 col-xs-12 mt">
                                          <g:form class="form-horizontal row" role="form" autocomplete="off" action='showUserId' 
                                          controller="register" name='registerForm'>
						                     <input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}" />
												<div class="input-field">
													<label for="from">Enter your registered Email Id*</label>
													<input type="email" class="form-control" id="from-place" autocomplete="off" name='username'
												         req="1"  placeholder="Enter User Email Id"/>
												</div>
											</div>
											<div class="col-xs-12">
												<input type="submit" class="btn btn-primary btn-block" value="Submit">
											</div>
										</div>
                                        </g:form>
			                    	</div>
                      <div style="text-align:center;" class="md-close">Cancel!</div>
			</div>
		</div>
     
  
	 <div class="md-overlay"></div>  
    <div class="clearfix"></div>
		<footer>
			<div id="footer">
				<div class="container">
					<div class="row">
						<div class="col-md-9 col-md-offset-2 text-center">
							<!-- <p class="fh5co-social-icons">
                            <a href="#">About Us </a>| <a href="#">Blog</a> | <a href="#">Contact Us </a>
							</p> -->
            
            <p>Site designed and hosted by <img src="${resource(dir: 'images', file: 'nic.png')}" width="100" style="/* float:right; */margin-top: 0px;" />
<%--            National Informatics Centre --%>
            <br>
            © 2022 Content Owned, Updated and Maintained by National Biodiversity Authority, Government of India</p>
						</div>
					</div>
				</div>
			</div>
		</footer>
	</div>
	<!-- END fh5co-page -->

	</div>
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>	
   
<asset:javascript src="home/jquery.min.js" />
<asset:javascript src="home/jquery.easing.1.3.js" />
<asset:javascript src="home/bootstrap.min.js" />
<asset:javascript src="home/jquery.waypoints.min.js" />
<asset:javascript src="home/sticky.js" />
<asset:javascript src="home/jquery.stellar.min.js" />
<asset:javascript src="home/hoverIntent.js" />
<asset:javascript src="home/superfish.js" />
<asset:javascript src="home/jquery.magnific-popup.min.js" />
<asset:javascript src="home/magnific-popup-options.js" />
<asset:javascript src="home/bootstrap-datepicker.min.js" />
<asset:javascript src="home/classie.js" />
<asset:javascript src="home/selectFx.js" />
<asset:javascript src="home/modalEffects.js"/>
<asset:javascript src="home/main.js"/>
<asset:javascript src="beta-version/js/calander/jquery.datetimepicker.js" />
    <script>
$(document).ready(function(){
    if ($(window).width() <= 425){
        $("#infoBox").hide();
    };
	
	if ($(window).width() > 425){
        $("#infoBox2").hide();
    };
    
});
</script>

<script type="text/javascript">
	$(document).ready(function () {
		$('#datetimepicker').datetimepicker({
	        timepicker:true,
	        closeOnDateSelect:false,
	        closeOnTimeSelect: true,
	        initTime: true,
	        format: 'd/m/Y',
	<%--        minDate: 0,--%>
	        roundTime: 'ceil'
	  });

	});

	</script>	

 <script type="text/javascript">
 
         function generateCaptcha()
         {

             var alpha = new Array('A','B','C','D','E','F','G','H','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
                                   'a','b','c','d','e','f','g','h','i','j','k','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
             var i;
             for (i=0;i<6;i++){
               var a = alpha[Math.floor(Math.random() * alpha.length)];
               var b = alpha[Math.floor(Math.random() * alpha.length)];
               var c = alpha[Math.floor(Math.random() * alpha.length)];
               var d = alpha[Math.floor(Math.random() * alpha.length)];
               var e = alpha[Math.floor(Math.random() * alpha.length)];
               var f = alpha[Math.floor(Math.random() * alpha.length)];
              }
            var code = a + '' + b + '' + '' + c + '' + d + '' + e + '' + f;
            document.getElementById('mainCaptcha').value = code;
            document.getElementById('txtInput').value = "";
          }
         
          function CheckValidCaptcha(){
              var string1 = removeSpaces(document.getElementById('mainCaptcha').value);
              var string2 = removeSpaces(document.getElementById('txtInput').value);
              if (string1 == string2){
         document.getElementById('success').innerHTML = "Captcha Matched";
         document.getElementById('error').innerHTML = "";
         return true;
              }
              else{       
         document.getElementById('error').innerHTML = "Invalid Captcha"; 
         document.getElementById('success').innerHTML = "";
        return false;
         
              }
          }
          function removeSpaces(string){
            return string.split(' ').join('');
          }
      </script> 	

<g:javascript>
 		 var secc = "${secc}"
 		 var csrf = "${session["csrfPreventionSalt"]}"
  	</g:javascript>


	</body>
</html>

