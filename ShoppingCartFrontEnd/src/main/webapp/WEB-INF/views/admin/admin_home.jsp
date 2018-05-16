<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${categorySuccessMessage} 
${categoryErrorMessage}

<h2>
<a href="${pageContext.request.contextPath}/manage_category">Manage Categories</a>
<a href="${pageContext.request.contextPath}/manage_supplier"> Manage Suppliers</a>
<a href="${pageContext.request.contextPath}/manage_product">Manage Products</a>
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