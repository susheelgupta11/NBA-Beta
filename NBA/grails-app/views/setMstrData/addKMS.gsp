<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>


</head>
<body>
 <g:form action="saveKMS" enctype="multipart/form-data" method="POST">
<table border="1" align="center">
<tbody>
<tr>
<td>Title</td>
<td><g:textField name="title"/></td>
</tr>
<tr>
<td>File</td>
<td><input type="file" name="kmsFile" style="display: block;"></td>
</tr>
</tbody>
</table>

<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
<g:submitButton name="Save" class="btn"style=" margin-left:260px;margin-top:15px;"/>
</g:form>
</body>
</html>