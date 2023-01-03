<html>
<head>
<title><g:message code='spring.security.ui.forgotPassword.title'/></title>
<meta name='layout' content='main'/>


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

         //checking the captcha
         
          function CheckValidCaptcha(){
              var string1 = removeSpaces(document.getElementById('mainCaptcha').value);
              var string2 = removeSpaces(document.getElementById('txtInput').value);
              if (string1 == string2){
         document.getElementById('success').innerHTML = "Captcha Matched";
         document.getElementById('error').innerHTML = "";
         
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
 
 <script type="text/javascript">
 $(window).load(function() {
		generateCaptcha();
	});
 </script>
 
<style type="text/css">
.ui-widget-content a
{
color:#fff;
}
h4{font-size:14px;}
</style>
</head>

<body>

<div class="col-sm-6 col-sm-offset-3">
<div class="main-registeration-form row">
<div class="register-heading1">

						<h4>Forgot Password</h4>
					</div>
                                <g:if test='${flash.message}'>
									<div class=' red text-center errorpadding'>
										${flash.message}
									</div>
								</g:if>
<g:form action='forgotPassword' name="forgotPasswordForm" autocomplete='off'>
<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
	<g:if test='${emailSent}'>
	<br/>
	<h5><g:message code='spring.security.ui.forgotPassword.sent'/></h5>
	<div class="col-sm-12 text-center">
	<g:link controller="login" action="auth" class="btn btn-primary " params='${[csrfPreventionSalt:csrfPreventionSalt]}'>Back</g:link>
	</div>
	</g:if>
	<g:else>

	
<div class="col-sm-12 form-group">
<label class="col-sm-4"><g:message code='spring.security.ui.forgotPassword.username'/></label>
<div class="col-sm-8">
<g:textField name="username" size="25"/> 
</div>
</div>
<div class="form-group col-sm-12">
									<label class="control-label col-sm-3 ">Captcha</label> 
									<div class="col-sm-4">

									 
				  <input  type="text" size="10" id="mainCaptcha"readonly="readonly" style=" font-size: 16px;
				   font-style:normal;font-weight:bold; background: aqua;"/> 
				 <a onclick="generateCaptcha();"><i class="fa fa-refresh" style="font-size:20px;"></i></a>
                 
									</div>
									

                               <div class="col-sm-4" >
                              
									 <input type="text" placeholder="Type captcha here" maxlength="6" name="captcha" id="txtInput" 
									    req="1" required="required"/>
                  
									<span id="error" style="color:red"></span>
									<span id="success" style="color:green"></span>
									</div>
								</div>
                             

<div class="col-sm-12 text-center">
<g:link controller="login" action="auth" class="btn btn-primary" params='${[csrfPreventionSalt:csrfPreventionSalt]}'>Back</g:link>
<g:submitButton  name="submitResetForm"  onclick=" return CheckValidCaptcha();" class="btn btn-primary" value="Reset"></g:submitButton>
</div>

</g:else>
	</g:form>
</div>
</div>
<p/>

<script>
$(document).ready(function() {
	$('#username').focus();
});
</script>

</body>
</html>
