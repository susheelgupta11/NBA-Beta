<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>

<title>NBA</title>
</head>
<body>
  <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Letter Details</h4>
      </div>
  <table border="1" align="center">
  <tbody>
  <tr>
 <td><b>Letter Number</b></td> 
 <td>${letterDetails?.dynamicLetterNumberClientIN?.toString()?.replaceAll("\\<.*?>","")}</td> 
 </tr>
 <tr>
 <td><b>Subject</b></td> 
 <td>${letterDetails?.subject}</td>
 </tr>
 <tr> 
 <td colspan="2">${letterDetails?.messageBody?.toString()?.replaceAll("\\<.*?>","")}</td> 
  </tr>
  </tbody>
  </table>
  <div class="modal-footer">
        <button type="button" class="btn btn-default"  data-dismiss="modal">Close</button>
      </div>
</body>
</html>