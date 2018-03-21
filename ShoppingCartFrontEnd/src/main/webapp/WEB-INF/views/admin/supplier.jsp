<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
This is supplier Page

${supplierSuccessMessage}
${supplierErrorMessage}
${suppliers}
<form action="supplier/save/" method="post">
<table>
<tr>
<td> Id:</td>
<td><input type="text" name='id'> </td>
</tr>

<tr>
<td>Name:</td>
<td> <input type="text" name='name'> </td>
</tr>

<tr>
<td> Address:</td>
<td> <input type="text" name='address'> </td>
</tr>

</table>

<input type="submit" value='Create Supplier'>
</form>

</body>
</html>