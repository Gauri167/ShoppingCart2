<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<td>Name:</td>
<td><input type="text" value="${userDetails.name}"></td>
</tr>

<tr>
<td>Contact No.:</td>
<td><input type="text" value="${userDetails.mobile}"></td>
</tr>

<tr>
<td>Register Date:</td>
<td><input type="text" value="${userDetails.registerDate}"></td>
</tr>
</table>
</body>
</html>