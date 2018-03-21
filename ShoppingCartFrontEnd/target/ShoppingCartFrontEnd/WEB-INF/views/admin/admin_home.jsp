<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>
<a href="manage_category">Manage Categories</a>
<a href="manage_supplier"> Manage Suppliers</a>
<a href="manage_product">Manage Products</a>
</h2>

<br>
<c:if test="${isAdminClickedManageCategories==true}">
<jsp:include page="category.jsp"></jsp:include>
</c:if>

<c:if test="${isAdminClickedManageProducts==true}">
<jsp:include page="product.jsp"></jsp:include>
</c:if>

<c:if test="${isAdminClickedManageSuppliers==true}">
<jsp:include page="supplier.jsp"></jsp:include>
</c:if>

</body>
</html>