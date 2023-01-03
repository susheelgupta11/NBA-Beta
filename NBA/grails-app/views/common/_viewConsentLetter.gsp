<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>

<title>NBA</title>
</head>
<body>
 <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
       
      </div>
<g:if test="${sbbInstance?.other}">
<script>
$( document ).ready(function() {

document.getElementById("mySelect").style.display = 'block';
	
});

</script>
</g:if>

          <table class="table table-bordered customtable">
            <tr class="header">
              <h2 style="text-align:center"><u>Consultation Form</u></h2>
              <h4 style="text-align:center">(Under Section 41(2) of the Biological Diversity Act, 2002)</h4>
              <p style="padding:10px"><b>Name of the SBB:</b>&nbsp;<span style="color:red">${sbbInstance?.sbbName}</span></p>
            </tr>
            <tr>
		    <td><b>1</b></td>
			<td><b>Application no.</b></td>
			<td><b>:</b></td>
			<td style="color: red;">${sbbInstance?.appNumber}</td>
		    </tr>
             <tr>
			<td><b>2</b></td>
			<td><b>NBA Letter Ref No & Date </b></td>
			<td><b>:</b></td>
			<td style="color: red;">${sbbInstance?.dynLetterNumber} & <g:formatDate format="dd/MM/yyyy"  date="${sbbInstance?.letterCreatedDate}"/>  - NBA</td>
		    </tr>
                       
            <tr>
              <td><b>3</b></td>
              <td style="width:50%!important"><b>Date of Receipt</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td style="color: red;">${sbbInstance?.consentCreatedDate} </td>
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

 <table id="textbox">
    <tr>
      <td>
       <input type="button" value="Add Body" class="btn btn-primary" onClick="addFunction()">
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

							<tr>
              <td><b>6</b></td>
               <td style="width:50%!important">
                ${sbbInstance?.ddn}
                 </td>
                 <td class="text-center" style="width:1px;"><b>:</b></td>
                 <td></td>
            </tr>
                  <tr>
              <td><b>7</b></td>
              <td style="width:50%!important"></td>
              <td class="text-center" style="width:1px;"></td>
              <td style="width:50%!important">(Member Secretary)</td>
            </tr>
               <tr>
              <td><b>8</b></td>
              <td style="width:50%!important"><b>Any other relevant Document Pls Upload</b></td>
              <td class="text-center" style="width:1px;"></td>
              <td style="width:50%!important">
              
              <g:link controller="SBB" action="fileDetails" target="_blank" params="${[sbbInst:sbbInstance?.id,csrfPreventionSalt:csrfPreventionSalt]}" >${sbbInstance?.fileName}</g:link>
              
             
              </td>
            </tr>
            <tr>
                <td colspan="3"></td>
                
                <td>
                    <p>


                </p>
            </tr>
                </table>
               
                
                
<div class="modal-footer">
        <button type="button" class="btn btn-default"  data-dismiss="modal">Close</button>
      </div>
</body>
</html>