<html>

<head>
<meta name='layout' content='main' />

<title><g:message code='spring.security.ui.register.title' /></title>

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
 
<script>

function makeid() {
	  var text = "";
	  var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	  for (var i = 0; i < 5; i++)
	    text += possible.charAt(Math.floor(Math.random() * possible.length));

	  return text;
	}

function encryptt() {
    var plainText = $(".password").val();
	var plainText1 = $(".confirmpassword").val();
	if(plainText == '' || plainText1 == ''){return}
	else{
		//var secret = "ZZZaAaYx";
		var secret = makeid();
		var encrypted = CryptoJS.AES.encrypt(plainText, secret);
		encrypted = encrypted.toString();
		var str = encrypted.substring(encrypted.length-6);
		$(".password").val(secret + encrypted + '${session["csrfPreventionSalt"]}');
	    $(".confirmpassword").val(secret + encrypted + '${session["csrfPreventionSalt"]}');
	    $("#hidd").val(str);
	}
}




	function controlswidth() {
		$("label").addClass("col-sm-4");
		$('input[type=text]').wrap('<div class="col-sm-8"/>');
		$('input[type=text]').addClass("width");

		$('input[type=password]').wrap('<div class="col-sm-8"/>');
		$('input[type=password]').addClass("width");
		$("select").wrap('<div class="col-sm-8"/>');
		$("select").addClass("form-control");
		$("textarea").wrap('<div class="col-sm-8"/>');
		$("textarea").addClass("form-control");

	}

	$(document).ready(function() {
		$('[data-toggle="popover"]').popover();
		controlswidth();
		$("#datePicker").datepicker({
			yearRange : '-100:+0',
			maxDate : "0",
			changeMonth : true,
			changeYear : true,
			dateFormat : "dd/mm/yy"
		});
		BindValidationMethod();
		//$('#username').focus();
		$("#usenameCheck" ).focusout(function() {
			IsUserExist();
		});

		$( "#emailField").focusout(function() {
			if($("#emailField").val() == ""){
				}
			else{
				email = $("#emailField").val();
				$.ajax({
					type : "POST",
					url : emailAvailability,
					data : {
						email : $("#emailField").val(),
						csrfPreventionSalt : $("#csrfPreventionSalt").val()
					},
					success : function(result11) {
		                msgForEmailCheck(result11);
	                    $("#userCheckLabel").removeClass("col-sm-2");
	                    $("#userCheckLabel").addClass("col-sm-12");
						
					},
					error : function() {
					//	alert("An error(Zahir) has occured!!!");
					}

				});
				}
			});
	});
	function msgForEmailCheck(data11){
		newResult = data11;
		if(newResult.flag1 != false){
	$('#userCheckLabel').html("A user with this email already exists. Please enter a different email-id"); 
	//$('#modalToDisplay').modal('show'); 
		}
		else{
			$("#userCheckLabel").html('');
			}
		
	}

	$(window).load(function() {
		generateCaptcha();
		
	});
</script>
<script>

	function IsUserExist() {
		if ($("#usenameCheck").val() == "") {
			alert("Please Enter User Name ");
		} else
		{
			$("#userAvailabilityMsg").html();
			$.ajax({
				type : "POST",
				url : checkUserAvailabilityURL,
				data : {
					userNameAvailability : $("#usenameCheck").val(),
					csrfPreventionSalt : $("#csrfPreventionSalt").val()
				},
				success : function(result) {
					
					if(result.msg == 'This username is valid')
						{
						$("#userAvailabilityMsg").html('');
						//$("#userAvailabilityMsg").removeClass('error');
						//$("#userAvailabilityMsg").addClass('greenColor');
						}
					else
						{
						$("#userAvailabilityMsg").html(result.msg);
						$("#userAvailabilityMsg").removeClass('greenColor');
						$("#userAvailabilityMsg").addClass('error');
						}
				},
				error : function() {
					//alert("An error has (Himanshu jain) occured!!!");
				}

			});
		}
	}
</script>

	
</head>

<body>
<g:javascript>
var checkUserAvailabilityURL = "${createLink(controller:'register',action:'checkUserNameAvailability')}"
  var userAvailability = "${createLink(controller:'register',action:'userAvailability')}"
var emailAvailability = "${createLink(controller:'register',action:'emailAvailability')}"
</g:javascript>
	<p />

	<div class="container container1">
		<div class="row">


			<div class="col-sm-8 col-sm-offset-2">

				<div class="main-registeration-form">
					<!--login form -->
					<div class="register-heading1">
						<h4>New User Registration</h4>
					</div>
					           <g:if test='${flash.message}'>
									<div class=' red text-center errorpadding'>
										${flash.message}
									</div>
								</g:if>
					<g:form class="form-horizontal" role="form" action='register'
						name='registerForm' autocomplete="off">
						
					<input type="hidden" id="csrfPreventionSalt" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	
						<g:if test='${emailSent}'>
							<g:message code='spring.security.ui.register.sent' />
							<%--<div class="col-sm-12 text-center">
								<g:link controller="login" action="auth"
									class="btn btn-primary ">Back</g:link>
							</div>
							
						--%></g:if>
						<g:else>
						
                     <div class="col-sm-12">
								<div class="form-group">
									<span class="control-label red col-sm-8 col-sm-offset-4"><b> * Marked
											fields are mandatory </b></span>
								</div>
							</div>
							<div class="col-sm-12">
								<div class="form-group">
									<s2ui:textFieldRow name='name' req="1" 
										placeholder="Enter name (for example - Susheel Gupta) " 
										labelCode='user.name.label' class="  bold " bean="${command}"
										labelCodeDefault='Name* :' value="${command.name}" maxlength="40"/>
								</div>
							</div>
							
							<div class="col-sm-12">
								<div class="form-group">

									<s2ui:textFieldRow name='username' data-toggle="popover" id="usenameCheck"
										placeholder="Enter username (Minimum 4 alphabets or numbers)"
										data-trigger="focus" data-placement="top" req="1"
										minlength="1" _maxlength="1" WhiteSpace="1" class="width"
										data-content="You can use only alphabets and number "
										labelCode='user.username.label' bean="${command}"
										labelCodeDefault='Username* :' maxlength="20"
										value="${command.username}" />
								</div>
								<div id="userAvailabilityMsg" class="pull-right red col-sm-8"></div>
							</div>
							
							<div class="col-sm-12">
								<div class="form-group">
									<s2ui:passwordFieldRow name='password' data-toggle="popover"
										data-trigger="focus" data-placement="top" class="password"
										data-content="You can use only alphabets and number "
										placeholder="Enter password (for example- abcd@123)"
										data-content="Please enter minumum 4 alphabets, one special character(only !@#\$%^& are allowed),one number and one alphabet.Password minimum length is (Minimum 7- Maximum 16))"
										labelCode='user.password.label' bean="${command}"
										labelCodeDefault='Password* :' value="${command.password}"
										req="1" whiteSpace="1" Passfmt="1" />
								</div>
							</div>

							<div class="col-sm-12">
								<div class="form-group">
									<s2ui:passwordFieldRow name='password2'
										class="leftpadding confirmpassword" data-toggle="popover"
										data-placement="top" data-trigger="focus"
										placeholder="Enter password (for example- abcd@123)"
										data-content="Please enter minumum 4 alphabets, one special character,one number and one character.
Password minimum length is (Minimum 7- Maximum 16))"
										req="1" labelCode='user.password2.label' bean="${command}"
										labelCodeDefault='Confirm Password* :'
										value="${command.password2}" />
								</div>
							</div>

							<div class="col-sm-12">
								<div class="form-group">
									<s2ui:textFieldRow name='email' req="1" email="1"
										placeholder="Enter email (ex-abc@gmail.com)" id='emailField'
										labelCode='user.email.label' class="bold " bean="${command}"
										labelCodeDefault='Email* :' value="${command.email}" />
								</div>
								<div id="userCheckLabel" class="pull-right red col-sm-8"></div>
							</div>

							<div class="col-sm-12">
								<div class="form-group">

									<s2ui:textFieldRow name='dateOfBirth' 
										placeholder="Enter date (ex-01/01/2001)" data-placement="top"
										data-toggle="popover" id="datePicker" req="1" dob="1" 
										labelCode='user.dateOfBirth.label' class="  bold"
										bean="${command}" labelCodeDefault='Date of Birth* :' 
										value="${command.dateOfBirth}" />
								</div>
							</div>

							<div class="col-sm-12">
								<div class="form-group">
									<s2ui:textFieldRow name='mobile'
										placeholder="Enter mobile (ex-9999999999)" id='mobileField'
										data-placement="top" data-toggle="popover" mob="1" req="1"
										data-trigger="focus" data-content="Enter mobile number"
										labelCode='user.mobile.label' class="  bold" bean="${command}"
										labelCodeDefault='Mobile No *:' maxlength = "15" value="${command.mobile}" />
								</div>
							</div>

							<div class="col-sm-12">
								<div class="form-group">
									<s2ui:textFieldRow placeholder="Enter number (ex-01141458598)"
										num="1" data-placement="top" data-toggle="popover"
										data-trigger="focus" req="1"
										data-content="Enter number (ex-0121313525)" name='phone'
										labelCode='user.phone.label' class=" bold " bean="${command}"
										labelCodeDefault='Phone No* :' maxlength="10" value="${command.phone}" />
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
				  font-style:normal; ; background: aqua; font-weight: bold;"/> 
				 <a onclick="generateCaptcha();"><i class="fa fa-refresh" style="font-size:20px;"></i></a>
                 
									</div>

                               <div class="col-sm-4" >
                              
									 <input type="text" maxlength="6" placeholder="Type captcha here" name="captcha" id="txtInput" onmouseleave="CheckValidCaptcha();"   req="1" required="required"/>
                  
									<span id="error" style="color:red"></span>
									<span id="success" style="color:green"></span>
									</div>
								</div>
							
							
							<div class="form-group">

								<div class="col-sm-12 text-center">
									<g:link controller="login" action="auth" params='${[csrfPreventionSalt:csrfPreventionSalt]}'
										class="btn btn-primary">Back</g:link>
									<input type="hidden" id="hidd" name="str" />	
									<input type="submit" class="btn btn-primary"  value="Submit" onclick="enncrypt()" before="block()" onSuccess="unblock()" onFailure="unblock()" onComplete="unblock()" >
								</div>
							</div>
						</g:else>
					</g:form>
					<!--login form ends -->
				</div>


			</div>

		</div>
	</div>

<g:javascript>
 		 var secc = "${secc}"
 		 var csrf = "${session["csrfPreventionSalt"]}"
  	</g:javascript>
</body>
</html>
