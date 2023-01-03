<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>


</head>
<body>
 <g:form action="save">
<table border="1">
<tbody>
<tr>

<td><g:textArea name="txtValue"  style="width:560px;" /></td>

</tr>
</tbody>
</table>
<g:hiddenField name="type" value="${type}"/>
<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
<g:submitButton name="Save" class="btn btn-primary"style=" margin-left:260px;margin-top:15px;"/>
</g:form>
</body>
</html>