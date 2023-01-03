<html>

<head>
<meta name='layout' content='main' />
<title><g:message code='spring.security.ui.register.title' /></title>

 <script type="text/javascript">
 
         function generateCaptcha()
         {

             var alpha = new Array('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
                                   'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
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
         return  false;
         
              }
          }
          function removeSpaces(string){
            return string.split(' ').join('');
          }
      </script> 

<script>
	$(document).ready(function() {

		BindValidationMethod();
		//$('#username').focus();
	});

	 $(window).load(function() {
			generateCaptcha();
		});
</script>
</head>

<body>


	<div class="container container1">
		<div class="col-sm-12">


			<div class="col-sm-8 col-sm-offset-2">

				<div class="main-registeration-form row">
					<!--login form -->
					<div class="register-heading1">
						<h4>Forgot UserName</h4>
					</div>
					<div class="text-center">
						<b><span class="text-success"> ${flash.message }
						</span></b>
					</div>
					<g:form class="form-horizontal row" role="form" autocomplete="off"
						action='showUserId' name='registerForm'>
						<input type="hidden" name="csrfPreventionSalt"
							value="${csrfPreventionSalt}" />	
						<g:if test='${user}'>
						<div class="col-sm-12 text-center">
							<span class="text-success"><b><g:message code='Your username is: ' /></b></span>
							<b>${user?.username}</b>
							</div>
							<div class="col-sm-12 text-center">
								<g:link controller="login" action="auth"
									class="btn btn-primary " params='${[csrfPreventionSalt:csrfPreventionSalt]}'>Back</g:link>
							</div>

						</g:if>
							
							<g:else>
							<g:if test="${isUserAvailable == 'false'}">
							<div class="col-sm-12 text-center">
								<span class="red text-center"><g:message code='No user exists with this email id ' /></span>
							</div>
							</g:if>
								<div class="col-sm-12">
									<div class="form-group">

										<div class="col-sm-6">
											<label><b>Enter your registered Email Id*:</b></label>
										</div>

										<div class="col-sm-6">
											<input type="text" autocomplete="off" name='username'
												class="width" req="1" />
										</div>
									</div>
								</div>
								
						<div class="form-group col-sm-12">
									<label class="control-label col-sm-3 ">Captcha</label> 
									<div class="col-sm-4">
<%--									<img --%>
<%--										src="${createLink(controller: 'simpleCaptcha', action: 'captcha')}" class="captcha"/>--%>

<%--									<g:remoteLink controller="simpleCaptcha" action="captcha" update="success" class="captcha"><i class="fa fa-refresh" style="font-size:24px;"></i></g:remoteLink>--%>
<%--									<span onclick="reloadCaptcha();"><i class="fa fa-refresh" style="font-size:24px;"></i></span>--%>
									 
				 <input  type="text" size="10" id="mainCaptcha"readonly="readonly" style=" font-size: 16px;
				  font-style:normal; ; background: aqua; font-weight:bold; "/> 
				 <a onclick="generateCaptcha();"><i class="fa fa-refresh" style="font-size:20px;"></i></a>
                 
									</div>
									
<%--									<img id="success"  alt="captcha"/>--%>
<%--									<script type="text/javascript">--%>
<%--                                   function reloadCaptcha(){--%>
<%--                                    alert("inside captcha");--%>
<%--                                    var img = document.getElementById('success');--%>
<%--	                              img.src="${createLink(controller: 'simpleCaptcha', action: 'captcha')}";--%>
<%--	                                  }--%>
<%--									</script>--%>
                               <div class="col-sm-4" >
                              
									 <input type="text" maxlength="6" placeholder="Type captcha here" name="captcha" id="txtInput"   req="1" required="required"/>
                  
									<span id="error" style="color:red"></span>
									<span id="success" style="color:green"></span>
									</div>
								</div>
								
								
								<div class="col-sm-12 text-center">
									<g:link controller="login" action="auth"
										class="btn btn-primary"
										params='[]'>Back</g:link>
									<g:hiddenField name="userId" value="${currentUser?.id}" />
									<input type="submit" onclick="return CheckValidCaptcha();" class="btn btn-primary" value="Submit">



								</div>


						</g:else>
					</g:form>
					<!--login form ends -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>


