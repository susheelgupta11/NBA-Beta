var copyValue = "";
     var displayValue = "";
     
     
    function getAllValue(e) {
	var completevalue = "";
	$(".territories").each(function() {
	if ($(this).is(":checked")) {
	var value = $(this).val();
	var reqValue = '<p>' + value + '</p>';
	completevalue = completevalue + reqValue;
		}
	});

	copyValue = completevalue;
}

function syncValue(v) {
	
	if(CKEDITOR.instances.editor1.getData() == null || "" == CKEDITOR.instances.editor1.getData()){
		
		CKEDITOR.instances.editor1.setData(copyValue);	
		
	}else{
		
		CKEDITOR.instances.editor1.setData(CKEDITOR.instances.editor1.getData() + copyValue);	
	}
	
//	CKEDITOR.instances.editor1.setData(copyValue);
	document.getElementById("ckData").value = CKEDITOR.instances.editor1
			.getData();
}

function getData() {

	var noteValue = CKEDITOR.instances.editor1.getData();
	if(noteValue == "" || noteValue == null){
		alert("Noting section cann't be empty")
		return false;
	}else
	{
		document.getElementById("ckData").value = noteValue.replace(/&nbsp;/g,'');
		return true;
	}	
}


function trshow(e) {
	if (e == 'yes') {
		document.getElementById('show-me').style.visibility = 'visible';
	} else if (e == 'no') {
		document.getElementById('show-me').style.visibility = 'hidden';
	}
};


function showText() {
	document.getElementById('rem').style.display = 'block';
	document.getElementById('yesUn').checked = false;
}
function hideText() {
	document.getElementById('rem').style.display = 'none';
	document.getElementById('rem').value = '';
	document.getElementById('noUn').checked = false;
}

function showBox() {
	document.getElementById('remarkM').style.display = 'block';
	document.getElementById('yesM').checked = false;
}
function hideBox() {
	document.getElementById('remarkM').style.display = 'none';
	document.getElementById('remarkM').value = '';
	document.getElementById('noM').checked = false;
}

function showTextBox() {
	if ($('#dropdn').val().toUpperCase() == 'OTHERS') {
		$('#otherText').css({
			'visibility' : 'visible'
		});
	} else {
		$('#otherText').css({
			'visibility' : 'hidden'
		});
		$('#otherText').val('');
	}
}



function hideSerialBox() {

	document.getElementById('serialRemk').style.display = 'none';
	document.getElementById('serialRemk').value = '';
}

function showSerialBox() {
	document.getElementById('serialRemk').style.display = 'block';
}



//var counter = 0;
//var count = 0 ;
//var questionValue = '';
//var finalQuestionVal = '';
//
//function addQuestionTr(r) {
//	
//	var tdCounter = r.name
//	tdCounter = parseInt(tdCounter,10)
//	
//	
//	if(count == tdCounter + 3)
//		{
//		alert("You can not add more than three questions")
//		return;
//		}
//	counter = counter + 1;
//	count = counter + tdCounter;
//	
//	var div = document.getElementById('cont');
//	var ques = document.getElementById('questi');
//	var serialNo = document.getElementById('serial');
//	var removeButton = document.getElementById('remove');
//
//	var button = document.createElement("INPUT");
//	var input = document.createElement("textarea");
//	var hiddtxt = document.createElement("textarea");
//	var hiddserial = document.createElement("INPUT");
//
//	hiddserial.value = count;
//	hiddtxt.id = "qut" + count;
////	hiddtxt.maxLength = "50";
//	hiddtxt.cols = "40";
//	hiddtxt.rows = "3";
//	hiddtxt.name = "quesValues" + counter;
//	hiddtxt.style = "color:blue;"
//
//	hiddserial.id = "srl" + count;
//	hiddserial.readOnly = true;
//	hiddserial.style.fontWeight = 'bold';
//	hiddserial.style = "font-weight: bold;width: 22px;margin-top: 25px; border:0";
//		
//
//	button.setAttribute('type', 'button');
//	button.setAttribute('value', 'Remove');
//	button.setAttribute('id', 'rem' + count);
//	button.setAttribute('onclick', 'removeFields(this)');
//	button.setAttribute('class', 'btn');
//	button.style = "margin-top: 18px; background-color: coral;"
//
//	input.name = "ansValues" + counter;
////	input.maxLength = "50";
//	input.cols = "45";
//	input.rows = "3";
//	input.id = "qes" + count;
//	input.style = "color:blue";
//
//	div.appendChild(input);
//	ques.appendChild(hiddtxt);
//	serialNo.appendChild(hiddserial);
//	removeButton.appendChild(button) + "\n";
////	var tempcount = count-1;
////	var btnhide = document.getElementById('rem' + tempcount);
////	if(btnhide != null){
////	btnhide.style.display = 'none';}
//	
//	document.getElementById("setCounter").value = counter;
//
//}
//
//function removeFields(e) {
//	var getIdDetails = e.id;
//	var reqId = getIdDetails.toString().substring(3);
//	document.getElementById('qes' + reqId).remove();
//	document.getElementById('qut' + reqId).remove();
//	document.getElementById('srl' + reqId).remove();
//	document.getElementById(getIdDetails).remove();
//	count = count - 1;
//	counter = counter - 1;
////	var tempid = reqId - 1;
////	var btnshow = document.getElementById('rem' + tempid);
////	if(btnshow != null){
////	btnshow.style.display = 'block';}
//	document.getElementById("setCounter").value = counter;
//	
//	
//}

function setAllData() {

	/*
	 * var quesvalue = document.getElementById('quesValue').value; for(var i =
	 * 21 ; i<=count ; i++){ var quevalueId = "qes"+i; questionValue =
	 * questionValue + document.getElementById(quevalueId).value +"\n"; }
	 * finalQuestionVal = questionValue + quesvalue;
	 * document.getElementById("setAllQues").value = finalQuestionVal;
	 */
    document.getElementById("setAllSelect").value = selectValue;
	document.getElementById("setCounter").value = counter;
	

}


var selectValue = '';
function addSectionValue() {

	var getSectionValue = document.getElementById('pickSec').value;
	selectValue = selectValue + getSectionValue + "\n";
	var showValueId = document.getElementById('showSectionVal');
	showValueId.value = selectValue ;
	showValueId.style.display = 'block';
}



function updateQuestion(e) {

	 var updateId = e.id;
	 updateId = updateId.substring(updateId.length,updateId.length-1);
	 var quesTextVal = document.getElementById('qut'+updateId).value;
	 var ansTextVal = document.getElementById('qes'+updateId).value;
	 $.ajax({
	 type : 'Post',
	 dataType : 'JSON',
	 url : '/NBA/checklist/updateQuestion',
	 data : {
	 quesTextVal : quesTextVal,
	 ansTextVal : ansTextVal,
	 updateIns: updateId,
	 id: e.name
	 },
	
	 success : function(result) {
		 alert(result.status);
	 }
	 });
}

//*****************dynamic feild add and delete with auto update serial number***********************//

var counter = 0;
var count = 0 ;
var autoincre = 1;
jQuery(document).delegate('a.add-record', 'click', function(e) {
    e.preventDefault();    
    var content = jQuery('#sample_table tr'),
    size = jQuery('#tbl_posts >tbody >tr').length,
    size = parseInt(size, 10)
    if(count == size + 2)
        {
    	alert("You can not add more than 3 questions")
		return;
        }
    counter = counter + 1;
	count = counter + size;
	
    element = null,    
    element = content.clone();
    element.attr('id', 'rec-'+size);
    element.find('.delete-record').attr('data-id', size);
    element.appendTo('#tbl_posts_body');
// set counter value
     document.getElementById('setCounter').value = counter;
   
    element.find('.sn').html(size);
   	element.find('.ques').attr('name', 'quesValues'+autoincre);
   	element.find('.ans').attr('name', 'ansValues'+autoincre);
   	autoincre = autoincre + 1;

  });

jQuery(document).delegate('a.delete-record', 'click', function(e) {
    e.preventDefault();    
    var didConfirm = confirm("Are you sure You want to delete");
    if (didConfirm == true) {
     var id = jQuery(this).attr('data-id');
     var targetDiv = jQuery(this).attr('targetDiv');
     jQuery('#rec-' + id).remove();
     
 	counter = counter - 1;
 	document.getElementById('setCounter').value = counter;
   //regnerate index number on table
   $('#tbl_posts >tbody >tr').each(function(index) {
   
     $(this).find('span.sn').html(index);
   });
   return true;
 } else {
   return false;
 }
});

//**************************************end***********************************************************//

function deleteQues(d) {
	
	
	 var didConfirm = confirm("Are you sure You want to delete");
	    if (didConfirm == true) {

	var deleteIns = d.name
	$.ajax({
		type : 'Post',
		dataType : 'JSON',
		url : '/NBA/checklist/deleteQuestion',

		data : {
			deleteIns : deleteIns
		},

		success : function(result) {

			if (result.status == "Question deleted Successfully") {
				var e = d.id;
				var id = e.substring(e.length, e.length - 1);
				document.getElementById('all' + id).remove();
//				//regnerate index number on table
				 $('#tbl_posts >tbody >tr').each(function(index) {
					   
				     $(this).find('span.sn').html(index + 1);
				   });
			}
			else{
				alert(result.status);
				return;
			}
		}
		

	});
	 
	    }
	    else{
	    	return false;
	    	}
}

// IPR member page javascript is
// below //////////////////////////////////////////////////////////////////////

function openRemark() {
	document.getElementById('forePetRmk').style.display = 'block';
	document.getElementById('addRow').style.display = 'none';
	document.getElementById('addRow').value = '';
}

function openTable(){
document.getElementById('addRow').style.display = 'block';
document.getElementById('forePetRmk').style.display = 'none';
document.getElementById('forePetRmk').value ='';   	
}


var foreignPeteCount = 0;
 function cloneRow() {
	 foreignPeteCount = foreignPeteCount + 1;

	 var delBtn = document.getElementById("removeRowBtn");
	 delBtn.setAttribute('name',"removeRowB"+foreignPeteCount)
	 
	 
    var row = document.getElementById("rowToClone");
    var table = document.getElementById("tableToModify");
    
    var clone = row.cloneNode(true); 
   clone.id = "rowToClone"+foreignPeteCount;
   
    table.appendChild(clone);
    // reset the value for new row
    $("td input:text", clone).val("");
 }

 function deleteDynamicRow(r){
	 if(foreignPeteCount == 0 ){
		 alert("You can not delete this row!");
		 return;
	 }
		 
	var getName = r.name;
	var getId = r.id;
	
	var requiredId = getName.toString().substring(10)
	requiredId = "rowToClone"+requiredId;
	document.getElementById(requiredId).remove();
	foreignPeteCount = foreignPeteCount - 1;
 }
 
 function hidePatentMtc(){
	 document.getElementById('mtcRmk').style.display = 'none';
	 document.getElementById('mtcRmk').value = '';
	 
 }
 
 
 function showPatentMtc(){
	 document.getElementById('mtcRmk').style.display = 'block';	 
 }
 
 function bioMtcHide(){
	 document.getElementById('bioMtcRemk').style.display = 'none';
	 document.getElementById('bioMtcRemk').value = '';
 }
 
 
 function bioMtcShow(){
	 
	 document.getElementById('bioMtcRemk').style.display = 'block';	 
 }
 
 function dtsCommTable(){
	 document.getElementById('dtsComzation').style.display = 'none';
	 document.getElementById('dtsComzation').value = '';
	 document.getElementById('commdtstable').style.display = 'block';	
 }
 function dtsCommShow(){
	 
	 document.getElementById('dtsComzation').style.display = 'block';
	 document.getElementById('commdtstable').style.display = 'none';
 }
 

 
 function deleteDynamic(c){
	
	 if(change == 2 ){
		 alert("You can not delete this row!");
		 return;
	 }
		 
	var getName = c.name;
	var requiredId = getName.toString().substring(10);
	requiredId = "rowToClone"+requiredId;
	document.getElementById(requiredId).remove();
	change = change - 1;
 }
 

 function updateDynIprQues(e){
	
	var idForUpdate = e.name;
	var getId = e.id;
	var commonId  = getId.toString().substring(4);
	var quesId = "ques"+commonId;
	var ansId = "answ"+commonId;
	var newQues = document.getElementById(quesId).value;
	var newAns = document.getElementById(ansId).value;
	
	 $.ajax({
	 type : 'Post',
	 dataType : 'JSON',
	 url : '/NBA/checklist/updateQuestionIpr',
	 data : {
		 newQues : newQues,
		 newAns : newAns,
	     id: idForUpdate
	 },
	
	 success : function(result) {
		 alert(result.status)
	 }
	 });
} 
 
 function deleteDynIprRow(r) {
	 var didConfirm = confirm("Are you sure You want to delete");
	    if (didConfirm == true) {
	var getIdForDelete = r.name
	var getBtnId = r.id
	var delRowId = getBtnId.toString().substring(4);
	delRowId = "dele" + delRowId
	$.ajax({
		type : 'Post',
		dataType : 'JSON',
		url : '/NBA/checklist/deleteQuestion',
		data : {

			deleteIns : getIdForDelete
		},

		success : function(success) {
			document.getElementById(delRowId).remove();
			
			$('#tbl_posts >tbody >tr').each(function(index) {
				   
			     $(this).find('span.sn').html(index + 1);
			   });
		}
	});
	    }else return false;
}
 
 
 function updatePetRow(u) {
	var getUpdateId = u.name
	var getId = u.id
	var common = getId.toString().substring(4);
	var seri = document.getElementById('seri' + common).value;
	var coun = document.getElementById('coun' + common).value;
	var appi = document.getElementById('appi' + common).value;
	var date = document.getElementById('date' + common).value;
	var stat = document.getElementById('stat' + common).value;
	var gran = document.getElementById('gran' + common).value;
	var remk = document.getElementById('remk' + common).value;

	$.ajax({
		type : 'Post',
		dataType : 'JSON',
		url : '/NBA/checklist/updatePetentIpr',
		data : {
			seri : seri,
			coun : coun,
			appi : appi,
			date : date,
			stat : stat,
			gran : gran,
			remk : remk,
			id : getUpdateId
		},

		success : function(result) {
			alert(result.status)
		}
	});
}
 
 function deletePetentRow(r){
	var deleteId = r.name;
	var getId = r.id;
	var delRowId = getId.toString().substring(4);
	delRowId = "delt"+delRowId;
	$.ajax({
		type : 'Post',
		dataType : 'JSON',
		url : '/NBA/checklist/deletePetent',
		data : {

			id : deleteId
		},

		success : function(success) {
			document.getElementById(delRowId).remove();
		}
	});
 }
 
 
// function putAjaxReq(a){
//	 var id = a.name;
//	 var type = 'tipp';
//		 $.ajax({
//			 type : 'Post',
//			 dataType : 'JSON',
//			 url : '/NBA/loggedInAs/getIrccData',
//			 data : {
//			type:type,
//			 id: id 
//			 },
//			 success : function(result) {
//				 alert(result.data);
//			 }
//			 });	
//	}
 
 function successFun(n){
	 console.log(n);
	 var s = n.success;
	 var d = s.arguments[0];
	alert(d.data)
	
 }
 
 var max_chars = 0; 
 function limitForAgenda(element)
 {
	 var counterId =''
	// counting start from zero
	if (element.name == 'remarkByNba') {
		counterId = document.getElementById('text_count');
		max_chars = 4999;
	} else if(element.name == 'expertView') {

		counterId = document.getElementById('text_num');
		max_chars = 2999;
	}
    	 
     if(element.value.length > max_chars) {
         element.value = element.value.substr(0, max_chars);
    	 alert('You can not add more than '+ ++max_chars+' characters')
     }else{ 
    	 counterId.value = max_chars - element.value.length;
     }
 }
 
 
 function dynamicMeetingNumber(d){
	var setContent = document.getElementById('dyMeet'); 
	
	$.ajax({
		type : 'Post',
		dataType : 'JSON',
		url : '/NBA/agenda/getMeetDyNumber',
		data : {meetNumber : d},

		success : function(result) {
//			setContent.style.display= 'block';
			setContent.value = d+"."+ result.dynamicMeetNumber;
		}
	})
	 
 }
 
 var _validFileExtensions = [".doc", ".docx", ".pdf"];    

 function ValidateSingleInput(oInput) {
     if (oInput.type == "file") {
         var sFileName = oInput.value;
         var sFileSize = oInput.files[0].size;
         const fileSize = Math.round((sFileSize / 1024));
         
          if (sFileName.length > 0) {
             var blnValid = false;
             for (var j = 0; j < _validFileExtensions.length; j++) {
                 var sCurExtension = _validFileExtensions[j];
                 var x = sFileName.substring(sFileName.indexOf(".")+1).toLowerCase();
                 
                 if ("."+x == sCurExtension.toLowerCase()) {
                     blnValid = true;
                     break;
                 }
             }
             var errorMsgId = document.getElementById('errorMsg');
             if (!blnValid) {
            	 
                  var message = "Sorry, Allowed extensions are- " + _validFileExtensions.join(", ");
                
                   errorMsgId.innerHTML = message;
              
                 oInput.value = "";
                 return false;
             }else if(fileSize > 5120) { 
            	 
            	 var message = "File, More than 5 MB are not allowed "
            	 errorMsgId.innerHTML = message;
            	 oInput.value = "";
                 return false;	 
             }
         }
     }
     errorMsgId.innerHTML = "";
     return true;
 }
 

 $(document).ready(function() {
 	var max_fields      = 2; 
 	var wrapper   		= $(".input_fields_wrap"); 
 	var add_button      = $(".add_mor"); 
 	
 	var x = 1; 
 	$(add_button).click(function(e){ 
 		this.value = "Add More";
 		e.preventDefault();
 		if(x <= max_fields){ 
 			x++;
 			
 			$(wrapper).append('<div><input type="file" name="files[]" id="subfile" class="input-xlarge" required="required" onchange="ValidateSingleInput(this);"/><a href="#" class="remove_field"><i class="fa fa-trash-o" style="font-size:22px;color:red"></i></a></br></div>'); //add input box
 		}else{
 //		return false;	
 		alert("You are allowed to select maximum 2 files");

 		}
 	});
 	
 	$(wrapper).on("click",".remove_field", function(e){ 
 		e.preventDefault(); $(this).parent('div').remove(); 
 		x--;
 		
 		if(x == 1){
 			document.getElementById('chgName').value = "Click here";
 			document.getElementById('errorMsg').innerHTML = "";
 		}
 	})
 });

 function checkPeriodicDecleration() {
	  
	  var checkBox = document.getElementById("myCheck");
	  var text = document.getElementById("submi");

	  if (checkBox.checked == true){
	    text.style.display = "block";
	  } else {
	    text.style.display = "none";
	  }
	}
 
 
 
 

// for periodic report form 1---validation
		function fileUpload(val) {

			var displ = document.getElementById('uploadFile')
			if (val.value == 'Yes')
				displ.style.display = 'block';
			else
				displ.style.display = 'none';
		}


		function displayTxt(e){
			var displ = document.getElementById('haveA')
			if (e.value == 'Yes')
				displ.style.display = 'block';
			else
				displ.style.display = 'none';
			}

		function displayTrf(trs){
			var displ = document.getElementById('transf')
			if (trs.value == 'Yes')
				displ.style.display = 'block';
			else
				displ.style.display = 'none';
			}

		function displayBio(trs){
			var displ = document.getElementById('transBio')
			if (trs.value == 'Yes')
				displ.style.display = 'block';
			else
				displ.style.display = 'none';


			}

//letter templete mesage body content.........................
		
		function lettertemplete(categoryId) {
		
									$.ajax({
										type : 'Post',
										dataType : 'JSON',
										url : '/NBA/letterCommunication/letterChanged',
										data : {categoryId : categoryId},
				
										success : function(result) {
										CKEDITOR.instances.editor2.setData(result.bodyContent);	
										}
									})
			          }									
			
		
			
		

			
			var a = ['','one ','two ','three ','four ', 'five ','six ','seven ','eight ','nine ','ten ','eleven ','twelve ','thirteen ','fourteen ','fifteen ','sixteen ','seventeen ','eighteen ','nineteen '];
			var b = ['', '', 'twenty','thirty','forty','fifty', 'sixty','seventy','eighty','ninety'];

			function inWords (num) {
			    if ((num = num.toString()).length > 9) return 'overflow';
			    n = ('000000000' + num).substr(-9).match(/^(\d{2})(\d{2})(\d{2})(\d{1})(\d{2})$/);
			    if (!n) return; var str = '';
			    str += (n[1] != 0) ? (a[Number(n[1])] || b[n[1][0]] + ' ' + a[n[1][1]]) + 'crore ' : '';
			    str += (n[2] != 0) ? (a[Number(n[2])] || b[n[2][0]] + ' ' + a[n[2][1]]) + 'lakh ' : '';
			    str += (n[3] != 0) ? (a[Number(n[3])] || b[n[3][0]] + ' ' + a[n[3][1]]) + 'thousand ' : '';
			    str += (n[4] != 0) ? (a[Number(n[4])] || b[n[4][0]] + ' ' + a[n[4][1]]) + 'hundred ' : '';
			    str += (n[5] != 0) ? ((str != '') ? 'and ' : '') + (a[Number(n[5])] || b[n[5][0]] + ' ' + a[n[5][1]]) + 'only ' : '';
			    return str;
			}

			function convertMoney () {
			    document.getElementById('words').value  = inWords(document.getElementById('number').value);
			}
			
			
			


		
		