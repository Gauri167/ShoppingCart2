<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
<tr>

<td></td>
<td>Name:</td>
<td>Price:</td>
<td>Quantity:</td>

</tr>


<c:forEach var="cart" items="${cartList}">
<tr>

<img alt="${productName}" src="">
<input type="text" name="productName" value="${cart.productName}" disabled="disabled"><br>
<input type="text" name="price" value="${cart.price}" disabled="disabled"><br>
<input type="text" name="quantity" value="${cart.quantity}"><br>
<a href="remove?id=${cart.id}">Remove</a><br>

</tr>
</c:forEach>

</table>
</body>
</html>