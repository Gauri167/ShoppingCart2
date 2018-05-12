<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="confirmOrder" method="post">
<table>
<tr> <td><input type="hidden" name="productId" value="${cart.productId}"></td></tr>
<tr> <td><input type="hidden" name="cartId" value="${cart.id}"></td></tr>
<tr>

<td></td>
<td>Product:</td>
<td>Price:</td>
<td>Quantity:</td>

</tr>

<tr>
<td><img alt="" src="${selectedProductImage}"></td>
<td><input type="text" name="productName" value="${cart.productName}"></td>
<td><input type="text" name="price" value="${cart.price}"></td>
<td><input type="text" name="quantity" value="${cart.quantity}"></td>
</tr>

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
<td>Choose Payment Option:</td>
</tr>

<tr>
<td><input type="radio" name="paymentMode" value="COD">Cash on Delivery</td>
<td><input type="radio" name="paymentMode" value="Card">Credit/Debit Card</td>
<td><input type="radio" name="paymentMode" value="NetBank">Internet Banking</td>
</tr>

</table>

<input type="submit" value="Confirm Order">

</form>
</body>
</html>