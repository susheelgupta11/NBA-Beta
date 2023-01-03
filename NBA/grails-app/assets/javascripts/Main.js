function IndividualProfile()
{
	
	AddActiveClass("menu1");
	$(".agent").attr("disabled","disabled");
	checksession(this);
	//hideShow_div();
	$(".Yes").hide();
	showState();
	goFocus("focusbtn", "foucuscontrol");
	removeSession();
	BindValidation("controlreq", "btncontrol");
	BindValidation("controlclass1", "btncontrolclass1");
	
	
	$("#otherProfile").hide();
	$("#otherAgentProfile").hide();	
}

function Entity()
{	
	checksession(this);
	removeSession();
	showState();	
	$("#otherProfile").hide();
	$(".Yes").hide();
	goFocus();
	//$("#otherProfile2").hide();
	$("#otherAgentProfile").hide();
	goFocus("focusbtn", "foucuscontrol");
	BindValidation("controlreq", "btncontrol");
	BindValidation("ctlwidth", "btnctrl");
	AddActiveClass("menu1");
}

function datePicker(){
	$(".datePicker").datepicker({
		yearRange : '0:+100',
		minDate : "0",
		changeMonth : true,
		changeYear : true,
		dateFormat : "dd/mm/yy"
	});

	$("#toTime").change(function() {
		dateEndField = $("#fromTime").val();
		$.ajax({
			type : "POST",
			url : dateCheck,
			data : {
				fromTime : $("#fromTime").val(),
				toTime : $("#toTime").val()
			},
			success : function(result) {
				$("#toTime").val(' ');
			},
			error : function() {
				//alert("An error has (Himanshu jain) occured!!!");
			}

		});
	});
}

function form1part2()
{	
	
	commonPart2();
	BindValidation("controlclass1", "btnclass1");
	goFocus("focusbtn", "foucuscontrol");
	goFocus("focusbtn1", "foucuscontrol1");
	$("#other").hide();
	AddActiveClass("menu2");
	$(".datePicker").datepicker({
		yearRange : '0:+100',
		minDate : "0",
		changeMonth : true,
		changeYear : true,
		dateFormat : "dd/mm/yy"
	});

	$("#toTime").change(function() {
		dateEndField = $("#fromTime").val();
		$.ajax({
			type : "POST",
			url : dateCheck,
			data : {
				fromTime : $("#fromTime").val(),
				toTime : $("#toTime").val()
			},
			success : function(result) {
				$("#toTime").val(' ');
			},
			error : function() {
				//alert("An error has (Himanshu jain) occured!!!");
			}

		});
	});
	
	
	}

function form1part3(){
	
	$(".addmored").hide();
	$(".btndisabled").attr("disabled","disabled");
	checkRadio_checked();
	BindValidation("controlclass", "btnclass");
	goFocus("focusbtn", "foucuscontrol");
	goFocus("focusbtn2", "foucuscontrol2");
	goFocus("focusbtn3", "foucuscontrol3");
	hidediv();
	BindValidation("controlreq", "btncontrolreq");
	BindValidation("txtlastvalid", "btnlastvalid");
	BindValidation("ctrlvalidate", "btnctrlvalidate");
	//AddActiveClass("form1Part3", "applicationManagement",	"?formType=Form1&appFormId",appformid);
	AddActiveClass("menu3");
	removeValidation('no','yes','txtremovevalidate');	
	hideshowcontrols('radiobtn', 'rbotxtarea');
	hideShowTradditional();
	showDivInThreeRadio('tradditional','textarea');
	
	var selfContactPerson = $("[type= 'radio'][name= 'contactPerson']:checked").val()
	if(selfContactPerson == 'Self'){
		$(".hideOnSelf").attr('disabled','disabled');
	}
	else{
		$(".hideOnSelf").removeAttr('disabled');
	}
	
	$("#submitCommunity").hide();
	$("#addMore").hide();
		$("input[name='tradditional']").click(function(){
		if($(this).attr("value")=="No"){
			$("#submitCommunity").show();
		}
	});
		/*$("input[name='isConsentObtained']").click(function(){
			if($(this).attr("value")=="Individual" || (this).attr("value")=="Community"){
				$("#submitCommunity").show();
				$("#addMore").show();
			}
		});*/
}

function form1part4()
{
//	BindValidationMethod();
//	$('#instituteDetail').hide();
//	$(".activities").hide();
//	$(".Proposed").hide();
//	AddActiveClass("menu4");
//	BindValidation('width', 'ctrolvalid');	
//	showDiv_pageloadYesNO('instituteParticipation','activities',null);
//	var valIsBenefitSharing = $("input[type='radio'][name='isBenefitSharing']:checked").val();
//	if(valIsBenefitSharing == 'Yes'){
//		$(".Proposed").show();
//	}
//	else if(valIsBenefitSharing == 'No'){
//		$(".Proposed").hide();
//	}
//	
	
	BindValidationMethod();
	$('#instituteDetail').hide();
	$(".activities").hide();
	$(".Proposed").hide();
	$("#notBenefitSharing").hide();
	$("#openIfMonetary").hide();
	AddActiveClass("menu4");
	BindValidation('width', 'ctrolvalid');	
	showDiv_pageloadYesNO('instituteParticipation','activities',null);
	var valIsBenefitSharing = $("input[type='radio'][name='isBenefitSharing']:checked").val();
	if(valIsBenefitSharing == 'Yes'){
		$(".Proposed").show();
	}
	else if(valIsBenefitSharing == 'No'){
		$(".Proposed").hide();
	}
	
	if(isBenefitSharing == 'false' ){
		$("#notBenefitSharing").show();
		$(".Proposed").hide();
	}
	else if(isBenefitSharing == 'true' ){
		$("#notBenefitSharing").hide();
		$(".Proposed").show();
	}
	if(payBenefitSharing == 'Monetary'){
		$("#openIfMonetary").show();
		$(".Proposed").hide();
	}
	
}

function form1part5() 
{	
	$(".sumitbtn").attr("disabled","disabled");
	DisableSumitbtn();
	$("#DigitalSignature").hide();
	$("#declarestatement").hide();
	$("#Nosignature").hide();
	AddActiveClass("menu5");
	$(".checkbox").each(function(){
		if($(this).is(":checked"))
			{
			$(".sumitbtn").removeAttr("disabled");
			}
		else
			{
			$(".sumitbtn").attr("disabled","disabled");
			}
	});	
}

function form2Part2()
{	
	AddActiveClass("menu2");
	//$(".disablebtn").attr("disabled","disabled");
	$('#other').hide(); 
	$(".nbaApprovalDiv").hide();
	//AddActiveClass("part2","form2","?formType=Form2&appFormId",appformid);
	//BindValidation("controlclass", "btnclass");
	commonPart2();
	BindValidation("controlclass1", "btnclass1");
	BindValidation("controlclass2", "btnclass2");
	BindValidation("validationctrl9", "btnctrl9");
	BindValidation("ctrl1", "btnctrl1");

	goFocus("focusbtn", "foucuscontrol");
	goFocus("focusbtn1", "foucuscontrol1");
	ReadonlyRecord1();
	$('#nbaApprovalDiv').hide();
	$('.nbaApproval').click(function() {
		var val = $(this).val();
		if (val == "Yes") {
			
			$('#nbaApprovalDiv').show();
			$(".pdf1").each(function(){
				$(this).attr("pdf1","1");
				
			});
			
		} else {
			$('#nbaApprovalDiv').hide();
			$(".pdf1").each(function(){
				$(this).removeAttr("pdf1");
			});
		}
	});
	
	$('#otherSource').hide();
	$('#source').click(function() {
		var val = $(this).val();
		if (val == "Others") {
			$('#otherSource').show();
			AddValidation();
		} else {
			$('#otherSource').hide();
		}
	});
	debugger
	var isNbaApprovalObtVal = $("input[name='isNbaApprovalObt']:checked").val();
	if(isNbaApprovalObtVal == 'Yes'){
		$('.nbaApprovalDiv').show();
	}
	else if(isNbaApprovalObtVal == 'No'){
		$('.nbaApprovalDiv').hide();
	}
	
}

function form2Part3()
{
	/*This function is used to hide Geographical location hide on page load*/
	hidediv();
	/*This function is used to hide Oral / document textarea hide on page load*/
	hideShowTradditional();
/*this function is used to add active class on left tab part3*/	
	AddActiveClass("menu3");
	/*This functioon is used to add validation on traditional Knowledge*/
	BindValidation("controlclass", "btnclass");

	BindValidation("controlreq", "btncontrolreq");
	BindValidation("controlRD", "btnRD");
	BindValidationMethod();
	$(".instituteDetail").hide();
	hidepart3();
	$('#consentObtained').hide();
	$('.isConsentObtained').click(function() {
		var val = $(this).val();
		if (val == "Yes") {
			$('#consentObtained').show();
			$(".txtreq").each(function(){
				$(this).attr("req","1");
				
			});
			$(".txtmaxword100").each(function(){
				$(this).attr("txtmaxword100","1");
			});
		} else {
			$('#consentObtained').hide();
			$(".txtreq").each(function(){
				$(this).removeAttr("req");
			});
			$(".txtmaxword100").each(function(){
				$(this).removeAttr("txtmaxword100");
			});
		}
	});
	showDiv_pageloadYesNO('instituteParticipation','instituteDetail',null);
	showDivInThreeRadio('tradditional','textarea');
	
}

function form2Part5()
{	
	AddActiveClass("menu5");
	//AddActiveClass("part5","form2","?formType=Form2&appFormId",appformid);
	$(".sumitbtn").attr("disabled","disabled");
	DisableSumitbtn();
	$("#DigitalSignature").hide();
	$("#declarestatement").hide();
	$("#Nosignature").hide();
}

function form2Part4()
{
	AddActiveClass("menu4");
	$(".AgreementMOU").hide();	

	$('#agreementLetterDiv').hide();
	$('.isBenefitSharing').click(function() {
		var val = $(this).val();
		if (val == "Yes") {
			$('#agreementLetterDiv').show();
			AddValidation();
		} else {
			$('#agreementLetterDiv').hide();
			removeValidation();
		}
	});
	BindValidationMethod();
	showDiv_pageloadYesNO('agreementOrMou','AgreementMOU',null);
}

function form3Part2()
{	
	AddActiveClass("menu2");	
commonPart2();
	BindValidation("ctrl1", "btnctrl1");
	BindValidation("ctrlabc", "btnctrlabc");
	$("#other").hide();
	
	BindValidation("ctrl2","btnctrl2");
	goFocus("focusbtn", "foucuscontrol");
	showForm3Part2();
	$(".ipr").hide();
	$(".hideform3").hide();

	$(".datePicker").datepicker({
		yearRange : '-100:+0',
		maxDate : "0",
		changeMonth : true,
		changeYear : true,
		dateFormat : "dd/mm/yy"
	});

	$('#otherSource').hide();
	$('#source').click(function() {
		var val = $(this).val();
		if (val == "Others") {
			$('#otherSource').show();
			AddValidation();
		} else {
			$('#otherSource').hide();
		}
	});

	$('#patentInfo').hide();
	$('#reasons').hide();
	$('#otherStatus').hide();
	
	
	var form3Part2Approval = $("input[type='radio'][name='isApprovalOfNbaObtained']:checked").val();
	if(form3Part2Approval == 'Yes'){
		$(".hideform3").show();
	}
	else if(form3Part2Approval == 'No'){
		$(".hideform3").hide();
	}
}

function form3Part3()
{
	var selectedApplicable;
	$("#geoLocationOfCommunityForm").hide();
	$("#ifApplicable").hide();
	$("#updateCommunityLocations").hide();
	$(".isApplicable").click(function(){
		$("#ifApplicable").show();
		$("#geoLocationOfCommunityForm").show();
		$("#updateCommunityLocations").show();
		 
	});
	$(".isNotApplicable").click(function(){
		$("#ifApplicable").hide();
		$("#geoLocationOfCommunityForm").hide();
		$("#updateCommunityLocations").hide();
		 
	});
	selectedApplicable = $("input[name= isApplicable]:checked").val();
	if(selectedApplicable == 'Applicable'){
		$('#ifApplicable').show();
		$("#geoLocationOfCommunityForm").show();
		$("#updateCommunityLocations").show();
	}else{
		$('#ifApplicable').hide();
		$("#geoLocationOfCommunityForm").hide();
		$("#updateCommunityLocations").hide();
	}
		
		
	$("#form3part3Submit").click(function(){
		var consentObtained = $("input[type='radio'][name='isConsentObtained']:checked").val();
		if(consentObtained == "Abc"){
			$('#isNoForTraditional').val('www');
		}
		else if(consentObtained == "No"){
			$('#isNoForTraditional').val("No");
		}
		 
	});
	
	
	//$('[data-toggle="tooltip"]').tooltip();	
	AddActiveClass("menu3");
	BindValidation("controlclass1", "btnclass1");
	BindValidation("ctrl1", "btnctrl1");
	Add_validationonRadioclick1('isConsentObtained ');
	hidepart3();
	ReadonlyRecord1();
	BindValidation("ctrl2", "btnctrl2");
	BindValidation("ctrl3", "btnctrl3");
	BindValidation("ctrl4", "btnctrl4");
	$(".traditionalKnowledgeDesc").hide();
	$(".traditionalKnowledgeDesc1").hide();
	$(".instituteDetail").hide();
$('#reasonOfDisapproval').hide();
showDiv_pageloadYesNO('bioResourcesObtainedFromOutsideIndia','traditionalKnowledgeDesc',null);
showDiv_loadIfNO('approvalOfCountriesObtained','traditionalKnowledgeDesc1',null);
showDiv_pageloadYesNO('instituteParticipation','instituteDetail',null);

}

function form3part4()
{	
	AddActiveClass("menu4");	
}

function form3Part5()
{
	AddActiveClass("menu5");
	$('#DigitalSignature').hide();
}

function form4Part2()
{	
	AddActiveClass("menu2");
	commonPart2();	
	BindValidation("ctrl1", "btnctrl1");
	goFocus("focusbtn", "foucuscontrol");
	showForm4Part2();
	$("#other").hide();
	$("#datePicker").datepicker({
		yearRange : '-100:+0',
		maxDate : "0",
		changeMonth : true,
		changeYear : true,
		dateFormat : "dd/mm/yy"
	});
	$(".AgreementMOU").hide();
	showDiv_pageloadYesNO('isbenefitSharingDetailImplemented','AgreementMOU',null);
}

function form4Part3()
{
	AddActiveClass("menu3");
	//AddActiveClass("part3","form4","?formType=Form4&appFormId",appformid);	
	BindValidation("ctrl", "btnctrl");
	BindValidation("ctrl1", "btnctrl1");
	showForm4Part2();
	showDiv_pageloadYesNO('isAgreementEntered','hideform4',null);
}

function form4Part5()
{
	$(".sumitbtn").attr("disabled","disabled");
	DisableSumitbtn();
	$("#DigitalSignature").hide();
	$("#declarestatement").hide();
	$("#Nosignature").hide();	
	AddActiveClass("menu5");
}

$(document).ready(function(){
	//$("input[type='radio']").css("z-index","99999");
/*	$("input[type='text']").css("z-index","99999");
	$("input[type='checkbox']").css("z-index","99999");
	$("input[type='submit']").css("z-index","99999");
	$("input[type='button']").css("z-index","99999");*/
});

/*This is common jquery functions collection used in part 2*/
function commonPart2()
{
	$(".disablebtn").attr("disabled","disabled");
	BindValidation("controlclass", "btnclass");	
}

/*This function is used to hide/show please specific contorl on choose other or not*/

function hideshowother(e,controlid)
{	
		var profileVal = $(e).val();
		$("#"+controlid).hide();
		if (profileVal == "Others") {
			$("#"+controlid).show();			
		} 
		else if (profileVal == "Other") {			
			$("#"+controlid).show();
		} 
		else {
			$("#"+controlid).hide();
		}	
}

function AddValidation_Yes(controlclass)
{
	$("."+controlclass).show();
	$("."+controlclass).contents().find(".req").attr("req1","1");
	$("."+controlclass).contents().find(".num").attr("num1","1"); 
	$("."+controlclass).contents().find(".pdf").attr("pdf1","1"); 
	$("."+controlclass).contents().find(".txtreq").attr("txtreq1","1"); 
	$(".showIfApprovalNotObtained").hide();
	$("#approvalNotObtained").removeClass("ctrlabc");
}

function removeValidation_No(controlclass)
{	
	
	$("."+controlclass).contents().find(".req").removeAttr("req1");
	$("."+controlclass).contents().find(".num").removeAttr("num1");
	$("."+controlclass).contents().find(".pdf").removeAttr("pdf1");
	$("."+controlclass).contents().find(".txtreq").removeAttr("txtreq1");
	$("."+controlclass).contents().find(".tooltip_outer").remove();
	$("."+controlclass).hide();	
	$(".showIfApprovalNotObtained").show();
	$("#approvalNotObtained").addClass("ctrlabc");
	
	
}

function callAgentYes(controlclass)
{
	removeSession();
	AddValidation_Yes(controlclass);
	
}

function callAgentNo(controlclass)
{
	removeSession();
	removeValidation_No(controlclass);
}

/*This two function is used in part 4*/

function AddValidation_Yes4(controlclass)
{
	$("."+controlclass).show();
	
	$("."+controlclass).contents().find(".reqc").attr("req","1");
	$("."+controlclass).contents().find(".numc").attr("num","1"); 
	$("."+controlclass).contents().find(".pdfc").attr("pdf","1"); 
	$("."+controlclass).contents().find(".txtreqc").attr("txtreq","1"); 
	$("."+controlclass).contents().find(".txtmaxword100").attr("txtmaxword100","1");
	$("."+controlclass).contents().find(".txtreqc1").attr("txtreq1","1");
	
	if(controlclass == "openIfMonetary"){
		$("#notBenefitSharing").show();
		$("#openIfMonetary").show();
	}
	else if(controlclass == "Proposed"){
		$("#openIfMonetary").hide();
		$("#notBenefitSharing").hide();
	}
}

function removeValidation_No4(controlclass)
{	
	$("."+controlclass).contents().find(".reqc").removeAttr("req");
	$("."+controlclass).contents().find(".numc").removeAttr("num");
	$("."+controlclass).contents().find(".pdfc").removeAttr("pdf");
	$("."+controlclass).contents().find(".txtreqc").removeAttr("txtreq");
	$("."+controlclass).contents().find(".tooltip_outer").remove();
	$("."+controlclass).contents().find(".txtmaxword100").removeAttr("txtmaxword100");
	$("."+controlclass).contents().find(".txtreqc1").removeAttr("txtreq1");
	$("."+controlclass).hide();
	$(".not"+controlclass).show();
	
	$(".Proposed").hide();
	$("#"+controlclass).show();
	
	if(controlclass == "openIfMonetary"){
		$("#openIfMonetary").hide();
	}
	
	if(payBenefitSharing == ''){
		$("#notBenefitSharing").show();
		$(".Proposed").hide();
	}
	
}


function showDiv_pageloadYesNO(controlName, divclass,divid)
{
  var o= $("input[name='"+controlName+"']");
  var value=null;
  if(divclass!=null)
	  {  
	if((o).is(":checked"))
		{	
		(o).each(function(){
			if($(this).attr("checked"))
				{
				 value=$(this).val();				
				}
		});
		if(value=="No")
			{
			
			$("."+divclass).hide();
			removeValidation_No4('AgreementMOU');
			}
		else
			{
			$("."+divclass).show();
			AddValidation_Yes4('AgreementMOU');
			
			}
		}
	  }
  
  else if(divid!=null)
	  {
	  if((o).prop("checked"))
		{	
		if((o).val()=="No")
			{
			$("#"+divid).hide();
			removeValidation_No4('AgreementMOU');
			}
		else
			{			
			$("#"+divid).show();
			AddValidation_Yes4('AgreementMOU');
			}
		}
	  }
  else
	  {}
}

function showDivInThreeRadio(controlName,divId)
{
	var flag=false;
	var o=$("input[name='"+controlName+"']");		
	$("input[name='"+controlName+"']").each(function(){
		if($(this).prop("checked"))
			{
			
			if($(this).val()=="No")
				{
				$("#"+divId).hide();
				}
			else				
				{
				$("#"+divId).show();
				}
			//flag=true;
			}
		
	});
	
}

function showDiv_loadIfNO(controlName, divclass,divid)
{
  var o= $("input[name='"+controlName+"']");
  
  (o).each(function(){
	  
  if(divclass!=null)
	  {  
	if($(this).prop("checked"))
		{	
		if($(this).val()=="No")
			{
			$("."+divclass).show();
			}
		else
			{
			$("."+divclass).hide();
			
			}
		}
	  }
  });
}

function checkboxlength(e)
{
	

	if($(".territories:checked").length<=0)
		{
		alert("please check at least one checkbox ..");
		e.preventDefault;
		return false;
		}
	

}

function GelAllcheckedvalue(e)
{
	var completevalue="";
	$(".territories").each(function(){
		if($(this).is(":checked")){
			var value=$(this).val();
			var value1="<h6 class='text-primary'><b>"+value+"</b></h6>"
			completevalue=completevalue+value1;			
		}
	});
	$("#setcountry").html(completevalue);
	//alert(completevalue);
}
function GetMessage1(m) {
	return "<h6>"
			+ m + "</h6>";
}