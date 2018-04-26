<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="cart/add" method="post">

<img alt="" src="${selectedProductImage}"><br>

Name:<input type="text" name="productName" value="${selectedProduct.name}"><br>
Price:<input type="text" name="price" value="${selectedProduct.price}"><br>
Quantity:<input type="text" name="quantity" required><br>
Description:${selectedProduct.description}<br>
<input type="submit" value="Add to Cart">

</form>


<%-- <a href="cart/add?productName=${selectedProduct.name}&price=${selectedProduct.price}&quantity=1">Add To Cart</a>
 --%>
</body>
</html>