
  
  

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

<g:javascript>
var checkUserAvailabilityURL = "${createLink(controller:'register',action:'checkUserNameAvailability')}"
  var userAvailability = "${createLink(controller:'register',action:'userAvailability')}"
var emailAvailability = "${createLink(controller:'register',action:'emailAvailability')}"
</g:javascript>

<g:form class="form-horizontal" role="form" controller="register" action='register' name='registerForm' autocomplete="off">
						
		<input type="hidden" id="csrfPreventionSalt" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
		
						<div class="form-body">
						<div class="row">
								<div class="col-lg-12 form-group">
									<s2ui:textFieldRow name='name' req="1" 
										placeholder="ex- Yatharth Gupta" class=""
										labelCode='user.name.label' bean="${command}"
										labelCodeDefault='Name* :' value="${command?.name}"  required="required"/>
								</div>
						
							
							
								<div class="col-lg-12 form-group">

									<s2ui:textFieldRow name='username' data-toggle="popover" id="usenameCheck"
										placeholder="Enter username (Minimum 4 alphabets or numbers)"
										data-trigger="focus" data-placement="top" req="1"
										minlength="1" _maxlength="1" WhiteSpace="1" class=""
										data-content="You can use only alphabets and number "
										labelCode='user.username.label' bean="${command}"
										labelCodeDefault='Username* :' maxlength="20"
										value="${command?.username}" required="required"/>
								
								<div id="userAvailabilityMsg" class="pull-right red col-sm-8"></div>
							</div>
							
							<div class="col-lg-12 form-group">
									<s2ui:passwordFieldRow name='password' data-toggle="popover"
										data-trigger="focus" data-placement="top" class="password"
										data-content="You can use only alphabets and number "
										placeholder="Enter password (for example- abcd@123)"
										data-content="Please enter minumum 4 alphabets, one special character(only !@#\$%^& are allowed),one number and one alphabet.Password minimum length is (Minimum 7- Maximum 16))"
										labelCode='user.password.label' bean="${command}"
										labelCodeDefault='Password* :' value="${command?.password}"
										req="1" whiteSpace="1" Passfmt="1" required="required"/>
							
							 </div>

							<div class="col-lg-12 form-group">
									<s2ui:passwordFieldRow name='password2'
										class="leftpadding confirmpassword" data-toggle="popover"
										data-placement="top" data-trigger="focus"
										placeholder="Enter password (for example- abcd@123)"
										data-content="Please enter minumum 4 alphabets, one special character,one number and one character.
                                                      Password minimum length is (Minimum 7- Maximum 16))"
										req="1" labelCode='user.password2.label' bean="${command}"
										labelCodeDefault='Confirm Password* :'
										value="${command?.password2}" required="required"/>
								
							</div>

							<div class="col-lg-12 form-group">
									<s2ui:textFieldRow name='email' req="1" email="1"
										placeholder="Enter email (ex-abc@gmail.com)" id='emailField'
										labelCode='user.email.label' class="bold " bean="${command}"
										labelCodeDefault='Email* :' value="${command?.email}" required="required"/>
								
								<div id="userCheckLabel" class="pull-right red col-sm-8"></div>
							 </div>
 							<div class="col-lg-12 form-group">
									<s2ui:textFieldRow name='dateOfBirth' 
										placeholder="Enter date (ex-dd/MM/yyyy)" data-placement="top"
										data-toggle="popover" id="datetimepicker" req="1" dob="1" 
										labelCode='user.dateOfBirth.label' class="  bold"
										bean="${command}" labelCodeDefault='Date of Birth* :' 
										value="${command?.dateOfBirth}" required="required" />
								
							</div>

							<div class="col-lg-12 form-group">
									<s2ui:textFieldRow name='mobile'
										placeholder="Enter mobile (ex-9999999999)" id='mobileField'
										data-placement="top" data-toggle="popover" mob="1" 
										data-trigger="focus" data-content="Enter mobile number"
										labelCode='user.mobile.label' class="  bold" bean="${command}"
										labelCodeDefault='Mobile No *:' maxlength = "15" value="${command?.mobile}" required="required" />
								
							</div>

							
								<div class="col-lg-12 form-group">
									<s2ui:textFieldRow placeholder="Enter number (ex-01141458598)"
										num="1" data-placement="top" data-toggle="popover"
										data-trigger="focus" req="1"
										data-content="Enter number (ex-0121313525)" name='phone'
										labelCode='user.phone.label' class=" bold " bean="${command}"
										labelCodeDefault='Phone No* :' maxlength="10" value="${command?.phone}" required="required"/>
								
							  </div>
							
							  <div class="col-lg-12 form-group">
									<label for="mainCaptcha">Captcha</label>
									<a onclick="generateCaptcha();"><i class="fa fa-refresh" style="font-size:20px;"></i></a>
    			                     <input  type="text" size="10" id="mainCaptcha"readonly="readonly"/> 
				                

                               
									<input type="text" size="10" maxlength="6" placeholder="Type captcha" name="captcha" id="txtInput" onmouseleave="CheckValidCaptcha();"   req="1" required="required"/>
         							<span id="error" style="color:red"></span>
									<span id="success" style="color:green"></span>
									
							   </div>
							
							
								<div class="col-lg-12 text-center">
									<input type="hidden" id="hidd" name="str" />	
									<input type="submit" class="btn btn-primary btn-block"  value="Submit" onclick="enncrypt()" before="block()" onSuccess="unblock()" onFailure="unblock()" onComplete="unblock()" >
								</div>
							</div>
					</div>
						</g:form>
									
											
		<%-- <g:javascript>
 		 var secc = "${secc }"
 		 var csrf = "${session["csrfPreventionSalt"]}"
  	</g:javascript> --%>