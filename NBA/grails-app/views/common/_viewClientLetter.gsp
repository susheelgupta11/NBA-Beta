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
<%--<table border="1" align="center">--%>
<%--<tbody>--%>
<%--<tr>--%>
<%--<td><b>Subject</b></td>--%>
<%--<td><b>${letterDetails?.subject}</b></td>--%>
<%----%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td><b>Letter Number</b></td>--%>
<%----%>
<%--<td>${letterDetails?.dynamicLetterNumberNbaIN}</td>--%>
<%----%>
<%--</tr>--%>
<%--<tr><td colspan="2">${letterDetails?.bodyContent?.toString()?.replaceAll("\\<.*?>","").replace("&nbsp;", " ")}</td></tr>--%>
<%--</tbody>--%>
<%----%>
<%--</table>--%>

 <div class="row">
    <div class="col-lg-6"><p>${letterDetails?.dynamicLetterNumberNbaIN}</p></div>
    <div class="col-lg-6"><p align="right">Date: <g:formatDate format="dd/MM/yyyy" date="${letterDetails?.letterCreateDate}"/></p></div>
  </div>
 <p>&nbsp;</p>
<p>Dear Sir / Madam,&nbsp;</p>
<p style="margin-left: 2em;">Sub: ${letterDetails?.subject} &ndash; reg.</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
${raw(letterDetails?.bodyContent)}<p>&nbsp;</p>
<p>&nbsp;</p>
 <p style="font-size: 10px;"><i>NBA Reference Only :</i> </p>
<table class="table table-bordered">
  <tbody>
    <tr>
      <th>Sent Date:</th>
      <td><g:formatDate format="dd/MM/yyyy" date="${letterDetails?.letterCreateDate}"/> </td>
      <th>Letter Number:</th>
      <td>${letterDetails?.dynamicLetterNumberNbaIN}</td>
    </tr>
  
  </tbody>
</table>
<%-- ${letterDetails?.messageBody?.toString().replaceAll("\\<.*?>","").replace("&nbsp;", " ")}      --%>
      



<div class="modal-footer">
        <button type="button" class="btn btn-default"  data-dismiss="modal">Close</button>
      </div>
</body>
</html>