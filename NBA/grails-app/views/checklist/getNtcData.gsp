
<html>
<head>
<title>NBA NTC List</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
<h1 align="center">Please Press ctrl+F for Search</h1>

<table>
<thead>
<tr>
<th>State</th>
<th>Bio-Resource</th>
<th>Author Name</th>
<th>Part</th>
<th>Source</th>
<th>Status</th>
</tr>
</thead>
<tbody>

<g:each in="${ntcDetails}" var="ntc">
<tr>
<td>${ntc?.item_state}</td>
<td>${ntc?.bio_resource}</td>
<td>${ntc?.author_name}</td>
<td>${ntc?.part}</td>
<td>${ntc?.cmw}</td>
<td>${ntc?.status}</td>

</tr>

</g:each>
</tbody>
</table>
</body>
</html>