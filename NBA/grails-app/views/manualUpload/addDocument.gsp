<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="dashPage">
    
<style>
.pdfobject-container { height:50rem; width: 560px; border: 1rem solid rgba(0,0,0,.1); }
</style>

<title>NBA</title>
	</head>
	<body>
<script>
$(document).ready(function () {

$( "div.success" ).fadeIn( 300 ).delay( 3000 ).fadeOut( 400 );
});
</script>
  <div class="content-wrapper">
    <div class="col-sm-12 paddingleft">
      <div class="col-sm-7 ">
        <div class="col-sm-12 rightdiv">
               <g:if test="${message}">
					<div class="alert-box success">${message}</div>	
					</g:if>
          <div class="col-sm-11">
             <h4 class="pull-left"><b>Upload(PDF only)</b></h4>
             
              <button id="upload-dialog" class="btn btn-primary pull-right" style="margin-bottom: 0px; margin-top: 10px;">Select PDF</button>
        
             <input type="file" id="myPdf" accept="application/pdf"/><br>
             </div>
                 
             

          <div class="col-sm-12">
            <hr style="margin-top: 10px; border-top: 1px solid;"/>
          </div>
            <div id="example1"></div>

         
        </div>
      </div>
      <div class="col-sm-5 right-div-menu" style="margin-top: 0px; border: 0px !important;">
        <div class="col-sm-12 leftdiv" style="padding-left: 0;padding-right: 0;">
        <g:form controller="manualUpload" action="save" id="uplod">
          <table class="table table-bordered" style="background:#d3d3d3;">
            <thead>
            <tr>
            <th>File details</th>
            </tr>
                </thead>
            <tbody>
          </table>
          <table class="col-sm-12" id="part1" style="margin-bottom: 20px;">
            <tbody class="row">
              <tr class="">
                <td class=""><span><b>Classified</b></span>
                  <input type="text" name="classified"  value="${manualDataDetails?.classified}" class="col-sm-6" style="float: right;"></td>
                <td><span ><b>Language</b></span>
                  <input type="text" name="language"  value="${manualDataDetails?.language}" class="col-sm-6" style="float: right;"></td>
              </tr>
              <tr>
                <td><span ><b>Type</b></span>
                  <input type="text" name="type"  value="${manualDataDetails?.letterDate}" class="col-sm-6" style="float: right;"></td>
                <td><span><b>Letter Date*</b></span>
                  <input type="text" placeholder="dd/mm/yyyy" required="required" name="letterDate" value="${manualDataDetails?.letterDate}" class="col-sm-6" style="float: right;"></td>
              </tr>
              <tr class="">
                <td style=""><span ><b>Mobile No.</b></span>
                  <input type="text" name="mobileNumber"  value="${manualDataDetails?.mobileNumber}" class="col-sm-6" style="float: right;"></td>
                <td><span ><b>File No.</b></span>
                  <input type="text" name="fileNumber"   value="${manualDataDetails?.fileNumber}" class="col-sm-6" style="float: right;"></td>
              </tr>
              <tr>
                <td><span ><b>Delivery Mode</b></span>
                  <input type="text" name="deliveryMode"  value="${manualDataDetails?.deliveryMode}" class="col-sm-6" style="float: right;"></td>
                <td><span ><b>Letter Ref. No.</b></span>
                  <input type="text" name="letterReferenceNumber"  value="${manualDataDetails?.letterReferenceNumber}" class="col-sm-6" style="float: right;"></td>
              </tr>
            </tbody>
          </table>
          <table class="table table-bordered" style="background:#d3d3d3; border-top: solid gray;">
            <thead>
            <tr>
            <th>Contact details</th>
            </tr>
                </thead>
            <tbody>
          </table>
          <table class="col-sm-12" id="part2" style="margin-bottom: 20px;">
            <tbody class="row">
              <tr class="">
                <td class=""><span ><b>Name</b></span>
                  <input type="text" name="name"  value="${manualDataDetails?.name}" class="col-sm-6" style="float: right;"></td>
                <td><span ><b>Designation</b></span>
                  <input type="text" name="designation"  value="${manualDataDetails?.designation}" class="col-sm-6" style="float: right;"></td>
              </tr>
              <tr>
                <td><span ><b>Address 1</b></span>
                  <input type="text" name="address1"  value="${manualDataDetails?.address1}" class="col-sm-6" style="float: right;"></td>
                <td style=""><span ><b>Address 2</b></span>
                  <input type="text" name="address2"  value="${manualDataDetails?.address2}" class="col-sm-6" style="float: right;"></td>
              </tr>
              <tr>
                <td><span ><b>Country</b></span>
                  <input type="text" name="country"  value="${manualDataDetails?.country}" class="col-sm-6" style="float: right;"></td>
                <td><span ><b>State</b></span>
                  <input type="text" name="state"  value="${manualDataDetails?.state}" class="col-sm-6" style="float: right;"></td>
              </tr>
              <tr>
                <td><span ><b>City</b></span>
                  <input type="text" name="city"  value="${manualDataDetails?.city}" class="col-sm-6" style="float: right;"></td>
                <td><span ><b>Pin</b></span>
                  <input type="text" name="pin"  value="${manualDataDetails?.pin}" class="col-sm-6" style="float: right;"></td>
              </tr>
             
            </tbody>
          </table>
          <div class="col-sm-12">
            <hr style="margin-top: 10px; border-top: 1px solid;">
          </div>
          <div class="pull-right" style="margin-right: 14px;">
          
          <input type="button" name="Reset" value="Reset" class="btn btn-success text-center" onclick="resetField()"/>
            <g:submitButton name="Submit" value="Submit" class="btn btn-primary text-center"/>
           
            <g:hiddenField name="formId" value="${getFormId}"/>
            <g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
          </div>
          </g:form>
        </div>
      </div>
    <g:render template="/rightPane/matchdata"></g:render>
    </div>
  </div>


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfobject/2.1.1/pdfobject.js"></script>


<script>
/* Show Select File dialog */
	document.querySelector("#upload-dialog").addEventListener('click', function() {
	    document.querySelector("#myPdf").click();
	});
$("#myPdf").on("change", function(e){
	debugger;
	var file = e.target.files[0]

    var name = file.name
    var extension =  name.slice(name.length-3, name.length)
    if(extension == 'pdf' || extension == 'PDF'){
	
	var path = (window.URL || window.webkitURL).createObjectURL(file);
	PDFObject.embed(path, "#example1");
	$(".col-sm-6").val("");
    }else{alert("Please select a Pdf file")}
});

function resetField(){
	$(".col-sm-6").val("");	
}
</script>

</body>
</html>