		
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="dashPage">
		
		<title>NBA</title>
	</head>
	<body>
  <div class="content-wrapper">
    <div class="col-sm-12 paddingleft">
      <div class="col-sm-7 ">
        <div class="col-sm-12 rightdiv" style="padding-top:0px;">
          <div class="col-sm-11">
            <h4 class="pull-left" style="margin-bottom: 0px;"><b>Upload(PDF only)</b></h4>
            
<%--            <g:formRemote name="myForm" update="pdf-main-container" method="POST"--%>
<%--              action="${createLink(controller: 'manualUpload', action: 'showCurrentPdf')}"--%>
<%--              url="[controller: 'manualUpload', action: 'showCurrentPdf']">--%>
<%--    <input type="file" class="pull-right" name="file" id="upload-button"   style="margin-bottom: 0px; margin-top: 10px; width: 180px;" accept="application/pdf"/>--%>
<%--    <g:actionSubmit value="show"/>--%>
<%--</g:formRemote>--%>

  <input type="file" class="pull-right" name="file" id="upload-button" onchange="showPdfFile(this);"  style="margin-bottom: 0px; margin-top: 10px; width: 180px;" accept="application/pdf"/>
          </div>
          <div class="col-sm-12">
            <hr style="margin-top: 10px; border-top: 1px solid;"/>
        
          
          <div id="pdf-main-container" style="margin-left: 0px; margin-right: 0px;">
<%--        <embed id="dynaPdf" src="${g.resource(dir:"images" , file:"8DclUndtk.pdf", absolute: true ) }" type="application/pdf" height=500 width="500"/>   --%>
        <embed id="dynaPdf" src ="${createLink(controller: 'manualUpload', action:'reflectPdf')}" type="application/pdf" height=500 width="600">   

<%--        <object data="${g.resource(dir:"images" , file:"8DclUndtk.pdf", absolute: true ) }" type="application/pdf" height=500 width="500"></object>--%>
          </div>
        </div>
      </div>
        </div>
      <div class="col-sm-5 right-div-menu" style="margin-top: 0px; border: 0px !important;">
        <div class="col-sm-12 leftdiv" style="padding-left: 0;padding-right: 0;">
        <g:form controller="manualUpload" action="save">
          <table class="table table-bordered" style="background:#d3d3d3;">
            <thead>
            <th>File details</th>
                </thead>
            <tbody>
          </table>
          <table class="col-sm-12" style="margin-bottom: 20px;">
            <tbody class="row">
              <tr class="">
                <td class=""><span class="col-sm-6"><b>Classified</b></span>
                  <input type="text" name="classified" class="col-sm-6" style="float: right;"></td>
                <td><span class="col-sm-6"><b>Language</b></span>
                  <input type="text" name="language" class="col-sm-6" style="float: right;"></td>
              </tr>
              <tr>
                <td><span class="col-sm-6"><b>Type</b></span>
                  <input type="text" name="type" class="col-sm-6" style="float: right;"></td>
                <td><span class="col-sm-6"><b>Letter Date</b></span>
                  <input type="text"  name="letterDate" class="col-sm-6" style="float: right;"></td>
              </tr>
              <tr class="">
                <td style=""><span class="col-sm-6"><b>Mobile No.</b></span>
                  <input type="text" name="mobileNumber" class="col-sm-6" style="float: right;"></td>
                <td><span class="col-sm-6"><b>File No.</b></span>
                  <input type="text" name="fileNumber" class="col-sm-6" style="float: right;"></td>
              </tr>
              <tr>
                <td><span class="col-sm-6"><b>Delivery Mode</b></span>
                  <input type="text" name="deliveryMode" class="col-sm-6" style="float: right;"></td>
                <td><span class="col-sm-6"><b>Letter Ref. No.</b></span>
                  <input type="text" name="letterReferenceNumber" class="col-sm-6" style="float: right;"></td>
              </tr>
            </tbody>
          </table>
          <table class="table table-bordered" style="background:#d3d3d3; border-top: solid gray;">
            <thead>
            <th>Contact details</th>
                </thead>
            <tbody>
          </table>
          <table class="col-sm-12" style="margin-bottom: 20px;">
            <tbody class="row">
              <tr class="">
                <td class=""><span class="col-sm-6"><b>Name</b></span>
                  <input type="text" name="name" class="col-sm-6" style="float: right;"></td>
                <td><span class="col-sm-6"><b>Designation</b></span>
                  <input type="text" name="designation" class="col-sm-6" style="float: right;"></td>
              </tr>
              <tr>
                <td><span class="col-sm-6"><b>Address 1</b></span>
                  <input type="text" name="address1" class="col-sm-6" style="float: right;"></td>
                <td style=""><span class="col-sm-6"><b>Address 2</b></span>
                  <input type="text" name="address2" class="col-sm-6" style="float: right;"></td>
              </tr>
              <tr>
                <td><span class="col-sm-6"><b>Country</b></span>
                  <input type="text" name="country" class="col-sm-6" style="float: right;"></td>
                <td><span class="col-sm-6"><b>State</b></span>
                  <input type="text" name="state" class="col-sm-6" style="float: right;"></td>
              </tr>
              <tr>
                <td><span class="col-sm-6"><b>City</b></span>
                  <input type="text" name="city" class="col-sm-6" style="float: right;"></td>
                <td><span class="col-sm-6"><b>Pin</b></span>
                  <input type="text" name="pin" class="col-sm-6" style="float: right;"></td>
              </tr>
            </tbody>
          </table>
          <div class="col-sm-12">
            <hr style="margin-top: 10px; border-top: 1px solid;">
          </div>
          <div class="pull-right" style="margin-right: 14px;">
            <g:submitButton name="Submit" value="Submit" class="btn btn-primary text-center "/>
          </div>
          </g:form>
        </div>
      </div>
    </div>
  </div>
	<script type="text/javascript">
	
		function showPdfFile(e) {
		
		    var file = $('#upload-button').val()
		    var jForm = new FormData();
		    jForm.append("file", $('#upload-button').get(0).files[0]);
		        $.ajax({
		            url: "/NBA/manualUpload/showCurrentPdf",
		            type: "POST",
		            data: jForm,
		            mimeType: "multipart/form-data",
		            contentType: false,
		            cache: false,
		            processData: false,
		            success: function(result) {

		            	  location.reload(true);

<%--		            	$(document).ajaxStop(function(){--%>
<%--		            	    window.location.reload();--%>
<%--		            	});--%>
<%--		        var refresh =   document.getElementById("dynaPdf")--%>
		        	            

<%--			           var fileUrl = '';--%>
<%--			            var dataObj = eval("(" + result + ")");--%>
<%--			            var finalArr = [];--%>
<%--			            for(var i in dataObj) {--%>
<%--			                var t = dataObj[i];--%>
<%--			                finalArr.push({--%>
<%--			                    path: t.path,--%>
<%--			             --%>
<%--			                });--%>
<%--			            }--%>
<%--			            var result = finalArr.find(obj => {--%>
<%--			            filePath = obj.path;--%>
<%--			            	})--%>
<%--             var myEmbed = document.getElementById("dynaPdf");--%>
<%--                 myEmbed.setAttribute("src", filePath);--%>
			           
			         }
		        });
		}
	</script>
</body>
</html>