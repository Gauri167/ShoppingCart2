<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>


<tr>
<td>Order No.</td>
<td>${order.id}</td>
</tr>

<tr>
<td>Order Date</td>
<td>${order.orderDate}</td>
</tr>

<tr>
<td>Amount</td>
<td>${order.amount}</td>
</tr>

<tr>
<td>Payment Mode</td>
<td>${order.paymentMode}</td>
</tr>

<tr>
<td>Item</td>
<c:forEach var="product" items="${order.productName}">
<td>${order.productName}</td>
</c:forEach>
</tr>

<tr>
<td>Are you sure you want to CANCEL Order?</td>
</tr>
<tr>
<td><a href="cancelOrder?id=${order.id}">YES</a></td>
<td><a href="OrderDetails.jsp">NO</a></td>
</tr>

</table>


</body>
</html>