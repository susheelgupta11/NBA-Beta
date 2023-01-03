function setsession()
{
	
	var value=$("#title").val();
	if( value!="")
	{
	$.session.set("myVar", value);
	$(".inactive").each(function(){
		$(this).removeClass("inactive");
	});
	$(".btnfirstNext").removeClass("inactive");
	
	}
	else
		{
		addinactive_class();
		}
}

function checksession(e)
{
	$.unblockUI();
	var wasPressed = false;
	function fkey(e){
	        e = e || window.event;
	       if( wasPressed ) return true; 

	        if (e.keyCode == 116) {	        	
	        	addinactive_class();        	
	        		        	
	        	return true;
	            
	        }else {
	        	addinactive_class();
	        }
	 }
	document.onkeydown = fkey;
	document.onkeypress = fkey
	document.onkeyup = fkey;
	var getSessionvalue=$.session.get("myVar");
	if(getSessionvalue!="" )
		{
		if(getSessionvalue!=undefined )
			{
		$(".inactive").each(function(){
			$(this).removeClass("inactive");
			
		});
			}
		else
			{
			addinactive_class();
			}
		}	
	else
		{
		addinactive_class();
		}
	removeSession();
}

function addinactive_class()
{
	$.session.remove("myVar");
	$(".addinactive").each(function(){
		$(this).addClass("inactive");
		});
	$(".btnfirstNext").addClass("inactive");
}


function encrypt() {
	
    var plainText = $("#password").val();
    
    var str = secc.toString().substr(14, 5);
	//alert("str "+str+" sec= "+sec+" csrf"+csrf);
	//var secret = aaaa;
	var encrypted = CryptoJS.AES.encrypt(plainText, str.split('').reverse().join(''));
	encrypted = encrypted.toString();
//	alert("encrypted = "+encrypted);
	var str = encrypted.substring(encrypted.length-6);
	 $("#password").val(encrypted + csrf);
    $("#hid").val(str);
}


function eencrypt() {
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
		
		var str = secc.toString().substr(14, 5);
		//alert("str "+str+" sec= "+sec+" csrf"+csrf);
		//var secret = aaaa;
		var encrypted = CryptoJS.AES.encrypt(plainText, str.split('').reverse().join(''));
		encrypted = encrypted.toString();
		var encrypted1 = CryptoJS.AES.encrypt(plainText1, str.split('').reverse().join(''));
		encrypted1 = encrypted1.toString();
		var encrypted2 = CryptoJS.AES.encrypt(plainText2, str.split('').reverse().join(''));
		encrypted2 = encrypted2.toString();
		
	var str = encrypted.substring(encrypted.length-6);
	
	 $("#oldPwd").val(encrypted + csrf);		 
	 $("#newPwd").val(encrypted1 + csrf);
     $("#confirmNewPwd").val(encrypted2 + csrf);		 
		
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


function enncrypt() {
    var plainText = $(".password").val();
	var plainText1 = $(".confirmpassword").val();
	if(plainText == '' || plainText1 == ''){return}
	else{
		
		var str = secc.toString().substr(14, 5);
		var encrypted = CryptoJS.AES.encrypt(plainText, str.split('').reverse().join(''));
		encrypted = encrypted.toString();
		var str = encrypted.substring(encrypted.length-6);
		 $(".password").val(encrypted + csrf);
		 $(".confirmpassword").val(encrypted + csrf);
		 $("#hidd").val(str);
		
	}
}




/*
function encrypt() {

	$.ajax({
		type : "POST",
		url : securl,
		data : {
			abc : "",
		},
		success : function(result) {
			var plainText = $("#password").val();
			var encrypted = CryptoJS.AES.encrypt(plainText, result.sec.toString());
			encrypted = encrypted.toString();
			var str = encrypted.substring(encrypted.length-6);
			 $("#password").val(encrypted + '${session["csrfPreventionSalt"]}');
		    $("#hid").val(str);
		},
		error : function() {
			//alert("An error has occured!!!");
		}

	});	

}
*/

function AddValidation()
{
	$(".pdf").each(function(){
		$(this).attr("pdf","1");		
	});
	$(".txtreq").each(function(){
		$(this).attr("req","1");
		
	});
	$(".req").each(function(){
		$(this).attr("req","1");
	});
	$(".req1").each(function(){
		$(this).attr("req1","1");
	});
	$(".txtmaxword100").each(function(){
		$(this).attr("txtmaxword100","1");
	});
}

function removeValidation()
{
	$(".pdf").each(function(){
		$(this).removeAttr("pdf");		
	});
	$(".txtreq").each(function(){
		$(this).removeAttr("req");
	});
	$(".req").each(function(){
		$(this).removeAttr("req");
	});
	$(".req1").each(function(){
		$(this).removeAttr("req1");
	});
}


function ClearAllFields() {
	$("input[type=text]").val("");
	$("textarea").val("");
	$('select').prop('selectedIndex', 0);
	$('input[type=radio]').removeAttr('checked');
	$('input[type=checkbox]').removeAttr('checked');
	$('input[type=file]').val("");
	$(":password").val('');
//	$("input[type='hidden'").val("");
}

function AddActiveClass(activecontrolclass)
{
	$(document).find(".list-group-item").each(function(){
		$(this).removeClass("active");
	});
	$("."+activecontrolclass).addClass("active");
}


/*function removeSession()
{
var aa=true;
var tbl2=true;
var agent=true;

$(".session").each(function(){
	aa=false;
});

$(".agent").each(function(){	
	if($(this).is(":checked"))
		{
		agent=false;
		//return false;
		}
});
if(aa==false)
	{
	$(".agent").removeAttr("disabled");
	}
else
	{
	$(".agent").attr("disabled","disabled");
	}


if((aa==false)&&(agent==false))
	{
	alert("kdjasfklajsdfk");
	$.session.set("myVar", "value1");
	$(".inactive").each(function(){
		$(this).removeClass("inactive");
	});
	$(".btnfirstNext").removeClass("inactive");
	}
else if((aa==true)&&(agent==true))
	{
	$(".himanshu").each(function(){
		$(this).addClass("inactive");
	});
	$(".btnfirstNext").addClass("inactive");
	$.session.remove("myVar");
	}
else
	{
	$(".himanshu").each(function(){
		$(this).addClass("inactive");
	});
	$(".btnfirstNext").addClass("inactive");
	$.session.remove("myVar");
	}
}*/

function removeSession()
{
var aa=true;
var tbl2=true;
var agent=true;

$(".session").each(function(){
	aa=false;
});

$(".agent").each(function(){	
	if($(this).is(":checked"))
		{
		agent=false;
		//return false;
		}
});
if(aa==false)
	{
	$(".agent").removeAttr("disabled");
	}
else
	{
	$(".agent").attr("disabled","disabled");
	}


if((aa==false)&&(agent==false))
	{
	$.session.set("myVar", "value1");
	$(".inactive").each(function(){
		$(this).removeClass("inactive");
	});
	$(".btnfirstNext").removeClass("inactive");
	}
else if((aa==true)&&(agent==true))
	{
	$(".himanshu").each(function(){
		$(this).addClass("inactive");
	});
	$(".btnfirstNext").addClass("inactive");
	$.session.remove("myVar");
	}
else if((aa==false))
	{
	$.session.set("myVar", "value1");
	$(".inactive").each(function(){
		$(this).removeClass("inactive");
	});
	$(".btnfirstNext").removeClass("inactive");
	}
else
	{
	$(".himanshu").each(function(){
		$(this).addClass("inactive");
	});
	$(".btnfirstNext").addClass("inactive");
	$.session.remove("myVar");
	}
}


function showState()
{
$(".country").change(function(){
	var value=$(this).val();
	if(value=="79")
		{
		$(".statetxt").hide();
		$(".stateddl").show();
		
		}
	else
		{
		$(".statetxt").show();
		
		$(".stateddl").hide();
		}
});
}

function goFocus(btnclass,controlid)
{
	$("."+btnclass).click(function(){
		if(controlid == 'foucuscontrolfunding'){
			$("."+controlid).focus();
		}
		else{
			$("#"+controlid).focus();
		}
		});
}

function hidediv()
{
	$('#geoLocation').hide();
	$("#Individual").hide();
	$("#Community").hide();
}

function hideShowTradditional()
{
	$("#textarea").hide();
$(".istradditional").click(function(){
	var value=$(this).val();
	if(value=="Oral")
		{
		$("#textarea").show();
		$(".GeoNo").removeAttr("checked");
		$(".community").removeAttr("disabled");
		$(".individual").removeAttr("disabled");
		
		
		}
	else if(value=="Document")
		{
		$("#textarea").show();
		$(".GeoNo").removeAttr("checked");
		$(".community").removeAttr("disabled");
		$(".individual").removeAttr("disabled");
		}
	else if(value=="No")
		{
		$("#textarea").hide();
		$("#isNoForTraditional").val("No");
		$(".isConsentObtained").each(function(){
			if($(this).is(":checked"))
				{
				$(this).removeAttr("checked");				
				}
		});
		$(".GeoNo").prop("checked","checked");
		$(".individual").attr("disabled","disabled");
		$(".community").attr("disabled","disabled");
		$("#geoLocation").hide();
		}
	else
		{
		
		}
});	
}

function Errormessage()
{
	$("#nextbtn").click(function(){
	var status=false;
	$("input[type='radio']").each(function(){
		if($(this).is('checked'))
			{
			status=true;
			}		
	});
	if(status==false)
	{
	alert("Please selelct at least one radio button");
	//$("#errormsg").text("please check atleast one");
	$("#nextbtn").attr("disabled","disabled");
	}
	else
		{
		$("#nextbtn").removeAttr("disabled");
		}
  });
}

function commonCode()
{
	$(".readcontrol").each(function(){
		 $(this).attr("disabled","disabled");
		 $(this).next('.tooltip_outer').remove();
		 $(this).removeAttr("req1");
		 $(this).val("");
	  });
	$(".dsblcontrol").each(function(){
		$(this).addClass("readcontrol_disabled ");
		$(this).removeClass("dsblcontrol");
	});
	
	
	
	
	
	
}

function showReadonlycontrol()
{
	$(".readcontrol").each(function(){
		 $(this).removeAttr("disabled"); 
	  });
	$(".readcontrol_disabled").each(function(){
		$(this).addClass("dsblcontrol");
		$(this).removeClass("readcontrol_disabled");
	});
	$(".readcontrol").attr("req1","1");
}
function showCultivated()
{
	$(".cultivate").each(function(){
		$(this).show();
		
	});
	$(".cultivate1").each(function(){
		$(this).attr("req1","1");
	});
}

function commoncode_readrecord(value)
{
	if(value=='Market')
	{
	commonCode();	
	showCultivated();
	}
else if(value=='Trader')
	{
	commonCode();
	showCultivated();
	}
else if(value=='Repositories'){
	commonCode();
	showCultivated();
}
else if(value=='Institution')
	{
	commonCode();
	showCultivated();
	}
else if(value=='Cultivated')
	{
	$(".cultivate").each(function(){
		$(this).hide();
		
	});
	
	
	showReadonlycontrol();
	$(".cultivate1").each(function(){
		$('.cultivate1').next('.tooltip_outer').remove();
		$(this).removeAttr("req1");
	});
	}
else if(value=='Wild')
	{
	$(".cultivate").each(function(){
		$(this).hide();
	});
	
	showReadonlycontrol();	
	$(".cultivate1").each(function(){
		$('.cultivate1').next('.tooltip_outer').remove();
		$(this).removeAttr("req1");
	});
	
	}
else
	{
	showReadonlycontrol();
	$(".cultivate").show();
	}
}

function ReadonlyRecode_Edit()
{
	var value=$("#sourcesAccess").val();	
	commoncode_readrecord(value);	
}


function ReadonlyRecord(e)
{
	$(".controlclass1").each(function(){
		$(this).attr("req1","1");
	});
	var value=$(e).val();
	commoncode_readrecord(value);

}

function ReadonlyRecordFormC(e)
{
	$(".controlclass1").each(function(){
		$(this).attr("req1","1");
	});
	var value=$(e).val();
	commoncode_readrecord_formc(value);

}

function commoncode_readrecord_formc(value)
{
	
	
	if(value=='Market')
	{
	commonCode();	
	showCultivated();
	}
else if(value=='Trader')
	{
	commonCode();
	showCultivated();
	}
else if(value=='Repositories'){
	commonCode();
	showCultivated();
}
else if(value=='Institution')
	{
	commonCode();
	showCultivated();
	}
else if(value=='Cultivated')
	{
	$(".cultivate").each(function(){
		$(this).hide();
		
	});
	
	
	showReadonlycontrol();
	$(".cultivate1").each(function(){
		$('.cultivate1').next('.tooltip_outer').remove();
		$(this).removeAttr("req1");
	});
	}
else if(value=='Wild')
	{
	$(".cultivate").each(function(){
		$(this).hide();
	});
	
	showReadonlycontrol();	
	$(".cultivate1").each(function(){
		$('.cultivate1').next('.tooltip_outer').remove();
		$(this).removeAttr("req1");
	});
	
	}
else
	{
	showReadonlycontrol();
	$(".cultivate").show();
	}
}

function hideshowtextarea()
{
	$(".rbotxtarea").hide();
	$(".radiobtn").click(function(){
		var value=$(this).val();
		if(value=="false")
			{
			$(".rbotxtarea").show();
			}
		else			
			{
			$(".rbotxtarea").hide();
			}
	});
}

function showForm3Part2()
{
	$(".hideform3").hide();
$(".radio").click(function(){
	var value=$(this).val();
	if(value=='Yes')
		{
		$(".hideform3").show();
		}
	else
		{
		$(".hideform3").hide();
		}
});	
}

function hidepart3()
{
	$("#instituteDetail").hide();;
$("#instituteDetail").hide();
$(".instituteParticipation").click(function(){
	var value=$(this).val();
	if(value=='Yes')
		{
		$("#instituteDetail").show();
		$(".txtreq").each(function(){
			$(this).attr("req","1");
			
		});
		$(".pdf").each(function(){
			$(this).attr("pdf","1");
			
		});
		$(".txtmaxword100").each(function(){
			$(this).attr("txtmaxword100","1");
		});
		}
	else
		{
		$("#instituteDetail").hide();
		$(".txtreq").each(function(){
			$(this).removeAttr("req");
		});
		$(".pdf").each(function(){
			$(this).removeAttr("pdf");
		});
		$(".txtmaxword100").each(function(){
			$(this).removeAttr("txtmaxword100");
		});
		}
		
	
})
}

function showForm4Part2()
{
	$(".hideform4").hide();
$(".radio").click(function(){
	var value=$(this).val();
	if(value=='Yes')
		{
		$(".hideform4").show();
		$(".pdf1").each(function(){
			$(this).attr("pdf1","1");
		});
		}
	else
		{
		$(".hideform4").hide();
		$(".pdf1").each(function(){
			$(this).removeAttr("pdf1");
		});
		}
});	
}


function CommoncodeOfGeographical(value)
{
	//$("#Community").hide();
	//$("#Individual").hide();
	$("#geoLocation").hide();
	$("#btnsubmit").hide();	
	if (value == "Community" ) {		
		$("#geoLocation").show();
		//$("#Community").show();
		//$("#Individual").hide();
		$("#btnsubmit").show();
		$(".labelForCommunityKnowledge").text("(a) Name of the community from whom such traditional knowledge is to be accessed")
		$(".controlreq").each(function(){
			$(this).attr("req1","1");
		});
		$(".email").each(function(){
			$(this).attr("email1","1");
		});
		
		$(".mobile").each(function(){
			$(this).attr("mob1","1");
		});
		
		$(".pdf").each(function(){
			$(this).attr("pdf1","1");
		});
		$(".alp").each(function(){
			$(this).attr("alp1","1");
			
		});
		$(".num").each(function(){
			$(this).attr("num1","1");
		});
		$(".txtreq").each(function(){
			$(this).attr("txtreq1","1");
		});		
		
		$("#submitCommunity").show();
		$("#addMore").show();
	}
	else if (value == "Individual" ) {
		$("#geoLocation").show();
		//$("#Community").hide();
		//$("#Individual").show();
		$("#btnsubmit").show();
		$(".labelForCommunityKnowledge").text("(a) Name of the individual from whom such traditional knowledge is to be accessed:")

					
		$(".controlreq").each(function(){
			$(this).attr("req1","1");
		});
		$(".email").each(function(){
			$(this).attr("email1","1");
		});
		
		$(".mobile").each(function(){
			$(this).attr("mob1","1");
		});
		
		$(".pdf").each(function(){
			$(this).attr("pdf1","1");
		});
		$(".alp").each(function(){
			$(this).attr("alp1","1");
			
		});
		$(".num").each(function(){
			$(this).attr("num1","1");
		});
		$(".txtreq").each(function(){
			$(this).attr("txtreq1","1");
		});		
		$("#submitCommunity").show();
		$("#addMore").show(); 
	}
	else if (value == "No") {
		$("#Community").hide();
		$("#Individual").hide();
		$("#geoLocation").hide();
		$("#btnsubmit").hide();
		$(".controlreq").each(function(){
			$(this).removeAttr("req1");
		});
		
		$(".email").each(function(){
			$(this).removeAttr("email1");
		});
		$(".mobile").each(function(){
			$(this).removeAttr("mob1");
		});
		$(".pdf").each(function(){
			$(this).removeAttr("pdf1");
		});
		$(".txtreq").each(function(){
			$(this).removeAttr("txtreq1");
		});		
		$("#submitCommunity").show(); 
		$("#addMore").hide(); 
	} 	
	else {
		$("#Community").hide();
		$("#Individual").hide()
		$("#geoLocation").hide();
		$("#btnsubmit").hide();
		$(".controlreq").each(function(){
			$(this).removeAttr("req1");
		});
		$(".email").each(function(){
			$(this).removeAttr("email1");
		});
		$(".mobile").each(function(){
			$(this).removeAttr("mob1");
		});
		$(".pdf").each(function(){
			$(this).removeAttr("pdf1");
		});
		$(".txtreq").each(function(){
			$(this).removeAttr("txtreq1");
		});
		$("."+GetAttr).hide();		
	}
	
	
	
}

function AddValidationGeographical(e)
{
	checkRadio_checked();
	var value=$(e).val();
	CommoncodeOfGeographical(value);
}

function AddValidationGeographical_edit()
{
	var value;
	$("#isConsentObtained").each(function(){
		if($(this).is(":checked"))
			{
		value=$(this).val();
		CommoncodeOfGeographical(value);
			}
	});
}


function Add_validationonRadioclick1(radiobuttonclass)
{
	$("#Community").hide();
	$("#Individual").hide();
	$("#geoLocation").hide();
	$("#btnsubmit").hide();
	$("."+radiobuttonclass).click(function() {
		var value=$(this).val();
	
		if (value == "Community") {		
			$("#geoLocation").show();
			$("#Community").show();
			$("#Individual").hide();
			$("#btnsubmit").show();
			$(".controlreq").each(function(){
				$(this).attr("req1","1");
			});
			$(".email").each(function(){
				$(this).attr("email1","1");
			});
			
			$(".mobile").each(function(){
				$(this).attr("mob1","1");
			});
			
			$(".pdf").each(function(){
				$(this).attr("pdf1","1");
			});
			$(".alp").each(function(){
				$(this).attr("alp1","1");
				
			});
			$(".num").each(function(){
				$(this).attr("num1","1");
			});
			$(".txtreq").each(function(){
				$(this).attr("txtreq1","1");
			});		
			
		}
		else if (value == "Individual") {
			$("#geoLocation").show();
			$("#Community").hide();
			$("#Individual").show();
			$("#btnsubmit").show();
						
			$(".controlreq").each(function(){
				$(this).attr("req1","1");
			});
			$(".email").each(function(){
				$(this).attr("email1","1");
			});
			
			$(".mobile").each(function(){
				$(this).attr("mob1","1");
			});
			
			$(".pdf").each(function(){
				$(this).attr("pdf1","1");
			});
			$(".alp").each(function(){
				$(this).attr("alp1","1");
				
			});
			$(".num").each(function(){
				$(this).attr("num1","1");
			});
			$(".txtreq").each(function(){
				$(this).attr("txtreq1","1");
			});		
			/*$("#submitCommunity").show();
			$("#addMore").show();*/
			
		}
		else if (value == "No") {
			$("#Community").hide();
			$("#Individual").hide();
			$("#geoLocation").hide();
			$("#btnsubmit").hide();
			$(".controlreq").each(function(){
				$(this).removeAttr("req1");
			});
			
			$(".email").each(function(){
				$(this).removeAttr("email1");
			});
			$(".mobile").each(function(){
				$(this).removeAttr("mob1");
			});
			$(".pdf").each(function(){
				$(this).removeAttr("pdf1");
			});
			$(".txtreq").each(function(){
				$(this).removeAttr("txtreq1");
			});		
		} 	
		else {
			$("#Community").hide();
			$("#Individual").hide()
			$("#geoLocation").hide();
			$("#btnsubmit").hide();
			$(".controlreq").each(function(){
				$(this).removeAttr("req1");
			});
			$(".email").each(function(){
				$(this).removeAttr("email1");
			});
			$(".mobile").each(function(){
				$(this).removeAttr("mob1");
			});
			$(".pdf").each(function(){
				$(this).removeAttr("pdf1");
			});
			$(".txtreq").each(function(){
				$(this).removeAttr("txtreq1");
			});
			$("."+GetAttr).hide();		
		}
		
		
		
	});
}

function ReadonlyRecord1()
{
$(".sourcesAccess").change(function(){
	var value=$(this).val();
	if(value=='Market')
		{
		commonCode();	
		showCultivated();
		}
	else if(value=='Trader')
		{
		commonCode();
		showCultivated();
		}
	else if(value=='Repositories'){
		commonCode();
		showCultivated();
	}
	else if(value=='Institution')
		{
		commonCode();
		showCultivated();
		}
	else if(value=='Cultivated')
		{
		$(".cultivate").each(function(){
			$(this).hide();
		});
		showReadonlycontrol();	
		}
	else if(value=='Wild')
		{
		$(".cultivate").each(function(){
			$(this).hide();
		});
		showReadonlycontrol();	
		
		}
	else
		{
		showReadonlycontrol();
		$(".cultivate").show();
		}
});
}

/*This function is used to hide and how function()*/

function hideshowcontrols(radioclass,controlclass)
{
$("."+controlclass).hide();
$("."+radioclass).each(function(){
if($(this).attr("checked")=='checked')
	{
	var value=$(this).val();
	if(value=='Yes')
		{
		$("."+controlclass).show();
		}
	else
		{
		$("."+controlclass).hide();
		}
	//alert(value);
	}
});

$("."+radioclass).click(function(){
//	$(this).attr("verifyattr","true");
	var value=$(this).attr("checkattr");
	if(value=='true')
		{
		$("."+controlclass).show();
		}
	else
		{
		$("."+controlclass).hide();
		}
});
}

function DisableSumitbtn(e){
	
	$("#hidButton").show();
		
		if($(e).prop("checked")==true)
		{
		$(".sumitbtn").removeAttr("disabled");
		}
	else
		{
		$(".sumitbtn").attr("disabled","disabled");
		}		
		
	
}

function Disableknowformbtn(e)
{
	if($(e).prop("checked")==true)
		{
		$(".next").removeAttr("disabled");
		}
	else
		{
		$(".next").attr("disabled","disabled");
		}
}
function hideshow(radioclasa)
{	
	if(radioclasa=='upload')
		{
		$("input[type='file']").attr('req','1');
		$("input[type='file']").attr('pdf','1');
		$("input[type='text']").removeAttr('req');
		}
	else if(radioclasa=='number')
		{
		$("input[type='text']").attr('req','1');
		$("input[type='file']").removeAttr('req');
		$("input[type='file']").removeAttr('pdf');		
		}
	else
		{
		$("input[type='file']").removeAttr('req');
		$("input[type='file']").removeAttr('pdf');	
		$("input[type='text']").removeAttr('req');		
		}
		$(".hidecontrols").hide();
		$("#"+radioclasa).show();
	
}
function updateCountryCodes(e){
	var code = $(e).val();
		//alert();
			
		}

function removeValidation(hideradio,showradio,controlclass){
	$("."+hideradio).click(function(){
		$("."+controlclass).each(function(){
			$(this).removeAttr("req1");
			$(this).removeAttr("txtreq1");
			$(this).removeAttr("txtmaxword100");
		});
		$("."+showradio).click(function(){
			$("."+controlclass).reset();
		});
	});
}
/*this functionis used to hide show add more button in form1part3*/
function hideshowmorebtn(e)
{
	checkRadio_checked();
var value=$(e).val();
if(value=='Self')
	{
	$("#selfForAuthorized").val("Self");
	$(".addmored").hide();
	$(".ctrlvalidate").attr("disabled","disabled");
	$(".ctrlvalidate").next('.tooltip_outer').remove();
	$(".btnctrlvalidate").attr("disabled","disabled");
	}
else
	{
	$(".addmored").show();
	$(".ctrlvalidate").removeAttr("disabled");
	$(".btnctrlvalidate").removeAttr("disabled");
	}
}
function freezTopLeftTab()
{
	$(".addinactive").each(function(){
		$(this).addClass("inactive");
		$(this).removeClass("active");
		$(this).addClass("greenbg");
	});	
	
	$(".addinactiveclass").removeClass("active");
}
function showhideDigitalSignature(e,tst)
{

	var value=$(e).val();
	if(value=="digital")
		{
		$("#DigitalSignature").show();
		$("#declarestatement").show();
		$("#Nosignature").hide();
		$("#evcInstruction").show();
		if(tst == "false" || "" == tst || null == tst){
		$("#otpbtn").show();	
		}
		
		$("#savebtn").attr("disabled");
		}
	else		
		{
		$("#Nosignature").show();
		$("#declarestatement").show();
		$("#DigitalSignature").hide();
		$("#evcInstruction").hide();
		$("#savebtn").removeAttr("disabled");
		$("#otpbtn").hide();
		}
	
}

/*This is common code function of form1part2 add validation*/
function commoncodeAddValidation(value)
{
	$(".disablebtn").each(function(){
		$(this).removeAttr("disabled","disabled");
	});
	$(".controlclass").each(function(){
		$(this).attr("req1","1");
		$(this).removeAttr("disabled");		
	});
	
	$(".num").each(function(){
		$(this).attr("num1","1");
	});
	
	if(value=="Biological")
		{
		$(".biologicalresources").each(function(){
			$(this).removeAttr("req1");
			$(this).next(".tooltip_outer").remove();
			$(this).attr("disabled","disabled");
			
			if(($(this).attr("disabled"))=="disabled")
				{
				$(this).val("");
				$("select").prop('selectedIndex', 0);
				$(this).prop('checked', false);
				}
			
		});
		$(".readcontrol_disabled").each(function(){
			$(this).addClass("dsblcontrol1");
			$(this).removeClass("readcontrol_disabled");
		});
		
		$(".Associate").each(function(){
			$(this).removeAttr("disabled");
		});
		}
	else if(value=="Associated")
		{
		$(".Associate").each(function(){
			$(this).removeAttr("req1");
			$(this).next(".tooltip_outer").remove();
			$(this).attr("disabled","disabled");
		
		$(this).removeAttr("checked");
		$(this).removeAttr("num1");
		if(($(this).attr("disabled"))=="disabled")
		{
		$(this).val("");
		$("select").prop('selectedIndex', 0);
		$(this).prop('checked', false);
		}
		
		$(".dsblcontrol1").each(function(){
			$(this).addClass("readcontrol_disabled ");
			$(this).removeClass("dsblcontrol1");
		});

		
		
		});
		}
		else if(value=="Both")
			{
			$(".controlclass").each(function(){
				$(this).attr("req1","1");
			});
			$(".num").each(function(){
				$(this).attr("num1","1");
			});
			$(".readcontrol_disabled").each(function(){
				$(this).addClass("dsblcontrol1");
				$(this).removeClass("readcontrol_disabled");
			});
			}
		else
			{
			
			}
}


/*this function is used in form1part2 in edit mode in Identification part*/
function showhidewithvalidation_edit()
{
	var value;
	$(".datePicker").datepicker({
		yearRange : '0:+100',
		minDate : "0",
		changeMonth : true,
		changeYear : true,
		dateFormat : "dd/mm/yy"
	});
	$(".istradditional").each(function(){
		if($(this).is(":checked"))
			{
			value=$(this).val(); 
			commoncodeAddValidation(value);
			}
		
	});
}

/*form1Part2*/
function showhidewithValidation(e)
{	
	var value=$(e).val();
	commoncodeAddValidation(value);
	
}


function print(printedarea)
{	
	    var mode = 'iframe'; // popup
	    var close = mode == "popup";
	    var options = { mode : mode, popClose : close};
	    //$("div.content").printArea( options );
	    $(printedarea).printArea( options );    
	
}

function checkRadio_checked()
{
	var trad=false,consent=false,isContact=false;
	$(".istradditional").each(function(){
		if($(this).is(":checked"))
			{
			trad=true;
			}
	});
	
	
	$(".isConsentObtained").each(function(){
		if($(this).is(":checked"))
			{
			consent=true;
			}
	});
	
	
	$(".contactPerson").each(function(){
		if($(this).is(":checked"))
			{
			isContact=true;
			}
	});
	
	if((trad==true)&&(consent==true)&&(isContact==true))
		{
		$(".btndisabled").removeAttr("disabled")
		}
	else
		{
		$(".btndisabled").attr("disabled","disabled");
		}
}

function checkZeroValue(e)
{
	//alert("focus out");
var value=$(e).val();
if(value!="" && value==0)
	{
	alert("Sorry! you can not enter value 0");
	$(e).val("");
	return false;
	}
else
	{
	return true;
	}
}


/* This function is used to show contorl in form3part2 */
function showStatusForForm3Part2(e, val1) {
	$('#patentInfo').hide();
	$('#reasons').hide();
	$('#otherStatus').hide();
	if (val1 == null) {
		var val1 = $(e).val();
		if (val1 == "Granted") {
			$('#patentInfo').show();
			$('#reasons').hide();
			$('#otherStatus').hide();
			AddValidation();
		} else if (val1 == "Not Granted" || val1 == "Not Granted"
				|| val1 == "Under Process" || val1 == "Abandoned"
				|| val1 == "Rejected" || val1 == "Withdrawn") {
			$('#patentInfo').hide();
			$('#reasons').show();
			$('#otherStatus').hide();
		} else if (val1 == "Others") {
			$('#otherStatus').show();
			$('#reasons').hide();
			$('#patentInfo').hide();
		}
	} else {

		if (val1 == "Granted") {
			$('#patentInfo').show();
			$('#reasons').hide();
			$('#otherStatus').hide();
			AddValidation();
		} else if (val1 == "Not Granted" || val1 == "Not Granted"
				|| val1 == "Under Process" || val1 == "Abandoned"
				|| val1 == "Rejected" || val1 == "Withdrawn") {
			$('#patentInfo').hide();
			$('#reasons').show();
			$('#otherStatus').hide();
		} else if (val1.split("-",1) == "Others") {   
			$('#otherStatus').show();
			$('#reasons').hide();
			$('#patentInfo').hide();
		}
	}
}

function addMore(){
	
	$('.ipr').show();

}

function AddPointerNone(e)
{
alert('Please select all Geographical Locations of bio-resources');
return false;
}

function addCompletegreenClass(value)
{	
	var val=value.replace("[","");
	var val=val.replace("]","");
	
	var array=val.split(',');
	for (var i = 0; i < array.length; i++)
		{
		if((array[i]!="null")||(array[i]!=" null"))
			{
		var aa=	$.trim(array[i]);
		
			$("."+aa).addClass('greenbg');
			
			}
		}	
}

function checkLeftTabsValidation(){
	if($(".menu1").hasClass("greenbg") == true){
		
	}else{
		alert("Part 1 of the form is not completely filled");
		$("#submitFormFinally").removeAttr("data-target");
	}
		
	if($(".menu2").hasClass("greenbg") == true){
		
	}else{
		alert("Part 2 of the form is not completely filled");
		$("#submitFormFinally").removeAttr("data-target");
	}
	
	if($(".menu3").hasClass("greenbg") == true){
		
	}else{
		alert("Part 3 of the form is not completely filled");
		$("#submitFormFinally").removeAttr("data-target");
	}
	
	
	if($(".menu4").length > 0){
		if($(".menu4").hasClass("greenbg") == true){
			
		}else{
			alert("Part 4 of the form is not completely filled");
			$("#submitFormFinally").removeAttr("data-target");
		}
	}
		
	if($(".menu5").hasClass("greenbg") == true){
		
	}else{
		alert("Form is not completely filled");
		$("#submitFormFinally").removeAttr("data-target");
	}
}

/*function traditionalCommunitySaveNo(){
	
	$("input[type='radio'][name='tradditional']").click(function(){
		if($(this).attr("value")=="No"){
			$("#noForTraditionalKnowledge").show();
		}else{
			$("#noForTraditionalKnowledge").hide();
		}
	}
}*/
/*var isTraditionalVal = $("input[type='radio'][name='tradditional']:checked").val();
var geoLocationOfCommunity = $("input[type='radio'][name='isConsentObtained']:checked").val();
if(isTraditionalVal == 'No' && geoLocationOfCommunity == 'No'){
	$("#noForTraditionalKnowledge").show();
}else{
	$("#noForTraditionalKnowledge").hide();
}*/



function preventBack(){window.history.forward();}
setTimeout("preventBack()", 0);
window.onunload=function(){null};

window.onbeforeunload = function(event)
{
	$.blockUI({ message: 'Please wait...' });
	setInterval(3000);
};


$(window).load(function(){
	$.unblockUI();
	$(".pagging").children().addClass("btn btn-default");
	$(".pagging").children().css("margin-top","2px");
	$(".pagging").children().css("margin-bottom","2px");
	$(".pagging").children().css("padding","2px 4px");
});

$(document).load(function(){
	$.blockUI({ message: 'Please wait...' });
});



/*This function is used to add active class in admin Manage Content page*/
function ActiveClass(menu){
	$(".list-group-item").each(function(){
		$(this).removeClass("active");
		});
	$("."+menu).addClass("active");
}

/* OTP sending process*/

function otpSend(e) {
	
	$.blockUI({ message: 'Sending OTP on registerd email-Id...' });
 var formId = e;
	$.ajax({
		type : 'Post',
		dataType : 'JSON',
		url : '/NBA/applicationManagement/sendOtp',
		data:{formId:formId},
		success : function(result) {
		document.getElementById('chkotp').style.display = 'block';
		
		$.unblockUI();
		$('#chkotp').bind("copy paste",function(e) {
				e.preventDefault();
			});
		}
	});
}

   function otpVerify(e) {
	var val = document.getElementById('getOtp').value;
	var messageTxt = document.getElementById('otpmsg');
	var formId = e.name;
	
	if(val == "" || val == null){
		messageTxt.innerHTML = "<span style='color: red;'>Please enter the otp</span>";
		
	}else{
		
	$.ajax({
		type : 'Post',
		dataType : 'JSON',
		url : '/NBA/applicationManagement/verifyOtp',
		data:{
			otp: val,
			formId:formId
		},
		success : function(responce) {
//			messageTxt.innerHTML = responce.result;
			if(responce.result == "Entered OTP is validated successfully"){
			messageTxt.innerHTML = "<span style='color: green;'>"+responce.result+"</span>";
			document.getElementById('chkotp').style.display = 'none';
			$("#savebtn").removeAttr("disabled");
			$("#otpbtn").hide();
			}else{
				messageTxt.innerHTML = "<span style='color: red;'>"+responce.result+"</span>";
				document.getElementById('chkotp').style.display = 'block';
				}
		}
	});	
 }
	}

 
/*File validation with multi extension*/
   
   function validateFile(f){
	   var status = false;
       var sFileName = f.value;
       var sFileSize = f.files[0].size;
       const fileSize = Math.round((sFileSize / 1024));
	   var x = sFileName.substring(sFileName.indexOf(".")+1).toLowerCase();
       
       if ("."+x == ".pdf" || "."+x == ".PDF") {
    	   status = true;
   }
       if (!status) {
          alert("Only Pdf is allowed");
          f.value = "";
          return false;
      }else if(f.size > 5120) { 
     	 
     	 alert("File, More than 5 MB are not allowed");
     	 f.value = "";
          return false;	 
      }
   }

