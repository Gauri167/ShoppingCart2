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

<form action="confirmOrder" method="post">
<table>

<tr>

<td></td>
<td>Name:</td>
<td>Price:</td>
<td>Quantity:</td>

</tr>

<c:forEach var="cart" items="${cartList}">
<tr>
<td><img alt="${productName}" src=""></td>
<td><input type="text" name="productName" value="${cart.productName}" disabled="disabled"></td>
<td><input type="text" name="price" value="${cart.price}" disabled="disabled"></td>
<td><input type="text" name="quantity" value="${cart.quantity}" disabled="disabled"></td>
</tr>
</c:forEach>

<tr>
<td>Name:</td>
<td><input type="text" placeholder="Enter Billing Name" name="name" value="${user.name}"></td>
</tr>

<tr>
<td>Address:</td>
<td><input type="text" name="address" placeholder="Enter Shipping Address"></td>
</tr>

<tr>
<td>Contact Number:</td>
<td><input type="text" name="mobile" placeholder="Enter Contact Number" value="${user.mobile}"></td>
</tr>

<tr>
Choose Payment Option:
</tr>

<tr>
<input type="radio" name="paymentMode" value="COD">Cash on Delivery</input>
<input type="radio" name="paymentMode" value="Card">Credit/Debit Card</input>
<input type="radio" name="paymentMode" value="NetBank">Internet Banking</input><br>
</tr>

</table>

<input type="submit" value="Confirm Order">

</form>
</body>
</html>