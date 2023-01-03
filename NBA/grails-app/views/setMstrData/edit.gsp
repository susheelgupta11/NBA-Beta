<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>


</head>
<body>
 <g:form action="update">
<table border="1">
<tbody>
<tr>

<td><g:textArea name="txtValue" value="${value}"  style="width:300px;"/></td>

</tr>
</tbody>
</table>
<g:hiddenField name="type" value="${type}"/>
<g:hiddenField name="index" value="${index}"/>
<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
<g:submitButton name="Update" class="btn btn-primary"style="margin-left:260px;margin-top:15px;"/>
</g:form>
</body>
</html>