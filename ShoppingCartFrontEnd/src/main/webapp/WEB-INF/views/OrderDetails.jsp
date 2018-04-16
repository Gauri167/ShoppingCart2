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
<td>Order No.</td>
<td>Order Date</td>
<td>Amount</td>
<td>Payment Mode</td>
<td>Items</td>
<td>Cancel Order</td>
</tr>

<c:forEach var="order" items="${orders}">
<tr>
<td>${order.id}</td>
<td>${order.orderDate}</td>
<td>${order.amount}</td>
<td>${order.paymentMode}</td>
<c:forEach var="product" items="${order.productName}">
<td>${order.productName}</td>
</c:forEach>
<td><a href="myOrder?id=${order.id}">Cancel</a></td>
</tr>
</c:forEach>

</table>

<c:if test="${UserClickedDeleteOrder==true}">
<jsp:include page="cancel_order.jsp"></jsp:include>
</c:if>
</body>
</html>