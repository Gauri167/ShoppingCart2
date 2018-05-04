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

<td></td>
<td>Name:</td>
<td>Price:</td>
<td>Quantity:</td>
<td></td>

</tr>


<c:forEach var="cart" items="${cartList}">
<tr>

<td><img alt="${cart.productName}" src="${selectedProductImage}"></td>
<td><input type="text" name="productName" value="${cart.productName}" disabled="disabled"></td>
<td><input type="text" name="price" value="${cart.price}" disabled="disabled"></td>
<td><input type="text" name="quantity" value="${cart.quantity}" disabled="disabled"></td>
<td><a href="${pageContext.request.contextPath}/remove?id=${cart.id}">Remove/</a></td>
<td><a href="${pageContext.request.contextPath}/buy?id=${cart.id}">BUY</a></td>

</tr>
</c:forEach>

</table>


</body>
</html>