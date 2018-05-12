<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>

<body>

<ul class="nav nav-tabs">
	<j:forEach var="category" items="${categories}">
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
			aria-expanded="false">${category.name}<span class="caret"></span></a>
			<div class="dropdown-menu">
			 <j:forEach var="product" items="${category.products}">
				
					<a class="dropdown-item" href="${pageContext.request.contextPath}/product/get?id=${product.id}">${product.name}</a><br/>
				
			</j:forEach></div></li>
	</j:forEach>
</ul>


</body>



