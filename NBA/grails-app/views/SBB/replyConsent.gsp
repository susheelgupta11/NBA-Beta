<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="sbb"/>
<title>SBB</title>
</head>
<body>
<script>
$( document ).ready(function() {
$("div.success").fadeIn( 300 ).delay( 3000 ).fadeOut( 400 );
});
</script>
<g:if test="${sbbInstance?.other}">
<script>
$( document ).ready(function() {
$("div.success").fadeIn( 300 ).delay( 3000 ).fadeOut( 400 );
document.getElementById("mySelect").style.display = 'block';
	
});

</script>
</g:if>


  <div class="content-wrapper">
    <div class="col-sm-12 paddingleft">
      <div id="costum-lft" class="col-sm-12">
          <g:if test="${message}">
			<div class="alert-box success">${message}</div>	
		</g:if>
        <div class="col-sm-12 rightdiv">
        <g:form  controller="SBB" action="sbbConsentStatus"  method="Post"  enctype="multipart/form-data">
        
        <g:hiddenField name="sbbName" value="${sbbName}"/>
        <g:hiddenField name="appNumber" value="${formDetails?.appNumber}"/>
        <g:hiddenField name="formId" value="${formDetails?.id}"/>
        <g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
         <g:hiddenField name="instance" value="${formDetails?.id}"/>
          <g:hiddenField name="sbbInst" value="${sbbInstance?.id}"/>
        
       
          <table class="table table-bordered customtable">
            <tr class="header">
              <h2 style="text-align:center"><u>Consultation Form</u></h2>
              <h4 style="text-align:center">(Under Section 41(2) of the Biological Diversity Act, 2002)</h4>
              <p style="padding:10px"><b>Name of the SBB:</b>&nbsp;<span style="color:red">${sbbName?:sbbInstance?.sbbName}</span></p>
            </tr>
            <tr>
		    <td><b>1</b></td>
			<td><b>Application no.</b></td>
			<td><b>:</b></td>
			<td style="color: red;">${formDetails?.appNumber}</td>
		    </tr>
             <tr>
			<td><b>2</b></td>
			<td><b>NBA Letter Ref No & Date </b></td>
			<td><b>:</b></td>
			<td style="color: red;">${sbbInstance?.dynLetterNumber} & <g:formatDate format="dd/MM/yyyy"  date="${sbbInstance?.letterCreatedDate}"/></td>
		    </tr>
                       
            <tr>
              <td><b>3</b></td>
              <td style="width:50%!important"><b>Date of Receipt</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td style="color: red;"><g:formatDate name="consentCreateDate" format="dd/MM/yyyy" date="${new Date()}"/>  </td>
            </tr>
            <tr>
              <td><b>4</b></td>
              <td style="width:50%!important"><b>Name of BMC or Local Body consulted (If applicable)</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              
<td class=""> 
<g:if test="${sbbInstance?.localBody}">
<g:each in="${sbbInstance?.localBody}" var="local">
<li>${local}</li>
</g:each>


</g:if>
<g:else>

<%-- <div id="dynamicInput">--%>
<%--          Local Body 1<br><input type="text" name="localBMC">--%>
<%--     </div>--%>
 <table id="textbox">
    <tr>
      <td>
       <input type="button" value="Add BMC" class="btn btn-primary" onClick="addFunction()">
      </td>
    </tr>
  </table>
    
</g:else>
</td>
            </tr>
            <tr></tr>
            <tr>
              <td><b>5</b></td>
              <td style="width:50%!important"><b>Declaration</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td style="width:50%!important"></td>
            </tr>
            <tr>
                <td></td>
              <td colspan="5"><b>The _<span style="color:red">${sbbName?:sbbInstance?.sbbName}</span>___ State Biodiversity Board after due diligence hereby gives its consent/other inputs on the above particulars referred to it by the National Biodiversity Authority.</b></td>
            </tr>
							<script>

							function addFunction() {
								  var table = document.getElementById("textbox");
								  var rowlen = table.rows.length;
								  var row = table.insertRow(rowlen);
								  
								  row.id = rowlen;
								  var arr = [''];
								  for (i = 0; i < 2; i++) {
								    var x = row.insertCell(i)
								    if (i == 1) {
								      x.innerHTML = "<input type='button' onclick='removeCell(" + row.id + ")' style='background-color: red; color: white' value=Delete>"
								    } else{
								      x.innerHTML = "<label>" + arr[i] + "</label><input type='textbox' name='localBMC' required='required'>"
								    }
								  }
								}

								function removeCell(rowid) {
								  var table = document.getElementById(rowid).remove();
								}


<%--								var counter = 1;--%>
<%--								var limit = 5;--%>
<%--								function addInput(divName) {--%>
<%--									if (counter == limit) {--%>
<%--										alert("You have reached the limit of adding "--%>
<%--												+ counter + " inputs");--%>
<%--									} else {--%>
<%--										var newdiv = document--%>
<%--												.createElement('div');--%>
<%--										newdiv.innerHTML = "Local Body "--%>
<%--												+ (counter + 1)--%>
<%--												+ " <br><input type='text' name='localBMC'>";--%>
<%--										document.getElementById(divName)--%>
<%--												.appendChild(newdiv);--%>
<%--										counter++;--%>
<%--									}--%>
<%--								}--%>

								function checkOther(ddn) {
									if (ddn.value == '3. Consent not given with reasons')
										document.getElementById("mySelect").style.display = 'block';
									else
										document.getElementById("mySelect").style.display = 'none';

								}
							</script>

							<tr>
              <td><b>6</b></td>
               <td style="width:50%!important">
       <g:select name="consentDdn" from="${replyDdn}" noSelection="['':'-Select-']" onchange="checkOther(this)" value="${sbbInstance?.ddn}"/>
                 </td>
                 <td class="text-center" style="width:1px;"><b>:</b></td>
                 <td><input type="text" name="consentDdnOther" id="mySelect" value="${sbbInstance?.other}" placeholder="Please Specify" style="width:100%;display: none" /></td>
            </tr>
                  <tr>
              <td><b>7</b></td>
              <td style="width:50%!important"></td>
              <td class="text-center" style="width:1px;"></td>
              <td style="width:50%!important">(Member Secretary)</td>
            </tr>
             <g:if test="${show == 'show'}">
               <tr>
              <td><b>8</b></td>
              <td style="width:50%!important"><b>Any other relevant Document/Board/Resolution Please Upload</b></td>
              <td class="text-center" style="width:1px;"></td>
              <td style="width:50%!important">
             
<%--              <g:link controller="SBB" action="fileDetails" target="_blank" params="${[sbbInst:sbbInstance?.id,csrfPreventionSalt:csrfPreventionSalt]}" >${sbbInstance?.fileName}</g:link>--%>
              
                   <p><input type="file" id="myFile" name="filename" value="Upload"  onchange="ValidateSingleInput(this);" style="display:block !important"></p>
                 <span style="color: red" id="errorMsg" ></span>
              
              </td>
            </tr>
              </g:if>
            <tr>
                <td colspan="3"></td>
                
                <td>
                    <p>

<g:if test="${show == 'show'}">
<g:link controller="SBB" action="sbbConsentPrint" params="${[sbbInst:sbbInstance?.id,instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]}" class="btn btn-primary pull-right" target="_blank">Print</g:link>
     </g:if>   
     <g:else>            <span>
                        <g:actionSubmit  value="Save" action="consentTempSave" class="btn btn-primary pull-right" style="margin-right: 10px;"/>
                    </span> </g:else> </p>
                </td>
            </tr>
            <tr>
                <td colspan="3"></td>
                
                <td> <p>
<g:if test="${show == 'show'}">
   <g:actionSubmit  value="Submit" action="sbbConsentStatus" class="btn btn-primary pull-center" style="margin-right: 10px;"/>

<%--<g:link controller="SBB" action="sbbConsentStatus" params="${[sbbInst:sbbInstance?.id,instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]}" class="btn btn-primary pull-center">Submit</g:link>--%>
     </g:if>  
                </p>
            </tr>
                </table>
                </g:form>
                </div>
                </div>
                </div>
                </div>
        
</body>
</html>