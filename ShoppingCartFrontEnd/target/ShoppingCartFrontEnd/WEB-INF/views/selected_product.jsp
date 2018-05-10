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


<form action="cart/add" method="post">

<img alt="" src="<c:url value="/resources/images/${selectedProduct.id}.PNG"/>"><br>
<input type="hidden" name="productId" value="${selectedProduct.id}">
Name:<input type="text" name="productName" value="${selectedProduct.name}"><br>
Price:<input type="text" name="price" value="${selectedProduct.price}"><br>
Quantity:<input type="text" name="quantity" required><br>
Description:${selectedProduct.description}<br>

<input type="submit" value="Add to Cart">

</form>

</body>
</html>