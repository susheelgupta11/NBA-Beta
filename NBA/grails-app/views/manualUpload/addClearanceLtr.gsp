<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="dashPage">

<title>NBA</title>
	</head>
	<body>
<script>
$(document).ready(function () {

$( "div.success" ).fadeIn( 300 ).delay( 3000 ).fadeOut( 400 );
});
</script>
  <div class="content-wrapper">
     

	<div class="social grid" style="padding-bottom: 2em;">
	 <g:if test="${message}">
					<div class="alert-box success">${message}</div>	
					</g:if>
		<div class="container">
  <div class="row">
    <g:form method="POST" action="saveClearanceLetetr" controller="manualUpload" style="padding-right: 4em; margin:2em;" enctype="multipart/form-data">
      <div class="col-md-6">
          <div class="form-group">
            <label for="sel1">Select Type of documents</label>
           
            <select class="form-control" id="sel1" name="docType" required="required">
		        <option value="" disabled selected><< Select >></option>
		        <option>Cleared</option>
		        <option>Closed</option>
		        <option>Agreement Signed</option>
		        <option>Approved</option>
		        <option>Rejected</option>
		        <option>19/3 Notice</option>
		        <option>Rectified</option>
		        <option>Notice</option>
		        <option>Voilation</option>
		      </select>
          </div>
          
          <div class="form-group">
            <label for="exampleInputFile">Select Document</label>
            <input type="file" id="clrFile" name="clrFile"  required="required" accept="application/pdf" style="display: block">
            <p class="help-block" style="color: red" id="validateMsg"></p>
          </div>
         
          
      </div>
      <div class="col-md-6">
        <div class="form-group">
          <label for="exampleInputDate">Date of signed/cleared/received</label>
          <input class="form-control" id="datetimepicker" name="dateClearance" autocomplete="off"  placeholder="Please select a Date" required="required">
        </div>
       <button type="submit" class="btn btn-primary">Submit</button>
       
        <g:hiddenField name="formId" value="${getFormId}"/>
       <g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
      </div>
    </g:form>
  </div>	
	</div>
</div>
</div>
<script type="text/javascript">
$(document).ready(function () {

	
	$('#datetimepicker').datetimepicker({
        timepicker:true,
        closeOnDateSelect:false,
        closeOnTimeSelect: true,
        initTime: true,
        format: 'd-m-Y',
        roundTime: 'ceil'
  });

});

$('#clrFile').on("change",function () {

    var fileExtension = ['pdf', 'PDF'];
    if ($.inArray($(this).val().split('.').pop().toLowerCase(), fileExtension) == -1) {
        
        $('#validateMsg').html(this.value);
        $('#validateMsg').html("Only '.pdf' formats is allowed.");
        document.getElementById('clrFile').value= null;
    }
    else {
       
       //do what ever you want
    } 
}) 



</script>
</body>
</html>