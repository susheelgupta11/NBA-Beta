
$(document).ready(function () {

$('#pdfForm').css("display", "none");
$('#pdfCloseBut').css("display", "none");


var pdfOpenClass = document.getElementsByClassName("pdfOpenClass");
//for (var i = 0; i < pdfOpenClass.length; i++) {
//    pdfOpenClass[i].addEventListener('click', myFunction, false);
//}


//function myFunction(){
//$('#ResultForm').css("display", "none");
//$('#pdfForm').css("display", "block");
//
//$('#pdfCloseBut').css("display", "block");
//}

});


function closePdf(){

$('#pdfForm').css("display", "none");
$('#ResultForm').css("display", "block");

$('#pdfCloseBut').css("display", "none");
}
