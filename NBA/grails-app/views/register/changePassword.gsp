<html>

<head>
<meta name='layout' content='loggedInUser' />
<asset:javascript src="/aes.js"/>
<title><g:message code='spring.security.ui.register.title' /></title>
<script>
	$(document).ready(function() {

		BindValidationMethod();

		$('#newPwd').keyup(function(){
			$('#result').html(checkStrength($('#newPwd').val()))

			if(checkStrength($('#newPwd').val()) == 'Too short')
				$('#result').addClass("text-danger");
			else if(checkStrength($('#newPwd').val()) == 'Weak')
				$('#result').addClass("text-danger");
			else if(checkStrength($('#newPwd').val()) == 'Good')
				$('#result').addClass("text-success");
			else if(checkStrength($('#newPwd').val()) == 'Strong')	
				$('#result').addClass("text-success");
			
			else if(checkStrength($('#newPwd').val()) == 'Do not use previous password'){
				$('#result').addClass("text-danger");
				$('#newPwd').val('');
				}
		})
		
		$('#confirmNewPwd').keyup(function(){
			$('#resultConfirm').html(matchNewAndConfirmPwd($('#confirmNewPwd').val()))
			$("#resultConfirm").fadeToggle(4000);

			if(matchNewAndConfirmPwd($('#confirmNewPwd').val()) == 'Matched'){
				$("#resultConfirm").removeClass("text-danger");
				$("#resultConfirm").addClass("text-success");
			}
			else{
				$("#resultConfirm").removeClass("text-success")
				$("#resultConfirm").addClass("text-danger");
				}
				
					
					
		})
		
		if($('#result').val() == 'Too short' || $('#result').val() == 'Weak')
			$('#result').addClass("text-danger")
		else if($('#result').val() == 'Strong')	
			$('#result').addClass("text-success")
		//$('#username').focus();
	});



	function matchNewAndConfirmPwd(confirmPwd){

		var newPwdVal = $('#newPwd').val();
		

		if(confirmPwd == newPwdVal)
				return 'Matched'
			else
				return 'New password and confirm password doesn\'t match'	
		}

	function checkStrength(password){

		var previousPass = $("#oldPwd").val();
		if(previousPass == password){
			 $('#result').removeClass()
		     $('#result').addClass('short')
		      return 'Do not use previous password' 
			}
		   //initial strength
		    var strength = 0 //if the password length is less than 6, return message. 
		   if (password.length < 6 ) {
			    $('#result').removeClass()
			     $('#result').addClass('short')
			      return 'Too short' 
			      } 
		   //length is ok, lets continue. 
		   //if length is 8 characters or more, increase strength value 
		   if (password.length > 7) 
			   strength += 1 

		//if password contains both lower and uppercase characters, increase strength value 
			if (password.match(/([a-z].*[A-Z])|([A-Z].*[a-z])/)) 
				strength += 1 
		//if it has numbers and characters, increase strength value 
			if (password.match(/([a-zA-Z])/) && password.match(/([0-9])/)) 
				strength += 1 
		//if it has one special character, increase strength value 
			
			if (password.match(/([!,%,&,@,#,$,^,*,?,_,~])/)) 
				strength += 1 
		//if it has two special characters, increase strength value 
		
			if (password.match(/(.*[!,%,&,@,#,$,^,*,?,_,~].*[!,",%,&,@,#,$,^,*,?,_,~])/)) 
				strength += 1 

		//now we have calculated strength value, we can return messages 
		//if value is less than 2 
		if (strength < 2 ) { 
			$('#result').removeClass() 
			$('#result').addClass('weak') 
			return 'Weak' 
			
			} 
		else if (strength == 2 ) {
			 $('#result').removeClass() 
			 $('#result').addClass('good') 
			 return 'Good' 
			 } 
		 else {
			  $('#result').removeClass() 
			  $('#result').addClass('strong') 
			  return 'Strong' 
			  } 

			  } 

	function makeid() {
		  var text = "";
		  var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	
		  for (var i = 0; i < 5; i++)
		    text += possible.charAt(Math.floor(Math.random() * possible.length));
	
		  return text;
		}
	

	function encryyypt() {
		//alert("inside encrypt");

		
		var plainText = $("#oldPwd").val();
        var plainText1 = $("#newPwd").val();
        var plainText2 = $("#confirmNewPwd").val();

        var valOfpasswordField= checkStrength(plainText1);
        //alert('1.outside if else'+valOfpasswordField);
        
		if(plainText == '' || plainText1 == '' || plainText2 == ''){
			//alert('inside blank......');
			return
			}
		
		else if(valOfpasswordField == 'Strong'){
			//alert('inside Strong......');
			
		var secretKey = makeid();	
		var secret = secretKey;	
		
		
		var encrypted = CryptoJS.AES.encrypt(plainText, secret);
		encrypted = encrypted.toString();
		var encrypted1 = CryptoJS.AES.encrypt(plainText1, secret);
		encrypted1 = encrypted1.toString();
		var encrypted2 = CryptoJS.AES.encrypt(plainText2, secret);
		encrypted2 = encrypted2.toString();
		
		var str = encrypted.substring(encrypted.length-6);
		
		 $("#oldPwd").val(secret + encrypted + '${session["csrfPreventionSalt"]}');		 
		 $("#newPwd").val(secret + encrypted1 + '${session["csrfPreventionSalt"]}');
         $("#confirmNewPwd").val(secret + encrypted2 + '${session["csrfPreventionSalt"]}');		 
			
		$("#hid").val(str);

                //alert("inside encrypt2");     
		} 
		else{

			//alert('Please use "special-symbols" and "numerals" to make your password strong');
			$("#newPwd").val('');

			$("#confirmNewPwd").val('');
			$("#result").html('');
			$("#result").html('<span class="text-danger">Please use "special-symbols" and "numerals" to make your password strong</span>');
			
			$("#resultConfirm").html('');
			
			//$('.submitIfStrongPswd').removeProp('');
			return
			}           
		return
    }

    $(document).ready(function () {
        var value
        $('#username').focus();
        $("#btnSubmit").click(function () {
            GetPassword();
        });
    });


	
</script>
</head>

<body>
	<p />

	<div class="container container1">
		<div class="row">


			<div class="col-sm-8 col-sm-offset-2">

				<div class="main-registeration-form">
					<!--login form -->
					<div class="register-heading1">
						<h4>Change Password</h4>
					</div>
					<g:if test="${message}">
						<div class="text-center" id="updateMsg">
							<b><span class="text-success"> ${message }

							</span></b>
							
						</div>
					</g:if>
					
					<g:else> 

						<g:form class="form-horizontal row submitIfStrongPswd" role="form" autocomplete="off"
							url="[controller:'register',action:'saveChangedPassword']"
							name='registerForm'>
						<input type="hidden" name="csrfPreventionSalt" value="${session["csrfPreventionSalt"]}"/>

							<div class="col-sm-12 form-group">


								<div class="col-sm-6">
									<label><b>Old Password*:</b></label>
								</div>
								<div class="col-sm-6">
									<input type="password" autocomplete="off" id="oldPwd" name='oldPwd' req="1"
										class="width" />

								</div>
							</div>
							<div class="col-sm-12 form-group">


								<div class="col-sm-6">
									<label><b>New Password*:</b></label>
								</div>
								<div class="col-sm-6">
									<input type="password" id="newPwd" name='newPwd' class="width" req="1" />
									
									<span id="result" ></span>
								</div>
							</div>

							<div class="col-sm-12 form-group">


								<div class="col-sm-6">
									<label><b>Confirm Password:</b></label>
								</div>
								<div class="col-sm-6">
									<input type="password" id="confirmNewPwd" name='confirmNewPwd' req="1"
										class="width" />
									<span id="resultConfirm" ></span> <span id="passHistory" ></span>
								</div>
							</div>
							<div class="col-sm-12 text-center">
								<g:link controller="loggedInAs" action="inbox"
									class="btn btn-primary" params='[]'>Back</g:link>
								<g:hiddenField name="userId" value="${currentUser?.id }" />
								<input type="hidden" id="hid" name="str" />
								<input type="submit" class="btn btn-primary" value="Submit" onclick="eencrypt()">
							</div>
						</g:form>
					</g:else>
					<!--login form ends -->
				</div>
			</div>



		</div>
	</div>
	
	<g:javascript>
 		 var secc = "${secc }"
 		 var csrf = "${session["csrfPreventionSalt"]}"
  	</g:javascript>
</body>
</html>


