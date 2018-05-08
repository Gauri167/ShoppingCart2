<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>



<%-- <nav class="navbar navbar-inverse">
	<div class="container-fluid">

		<ul>

			<j:forEach var="category" items="${categories}">
				<li class="dropdown"><a href="#" class="dropbtn">${category.name}</a>

					<j:forEach var="product" items="${category.products}">
						<div class="dropdown-content">
							<a href="product/get?id=${product.id}">${product.name}</a>
						</div>
					</j:forEach></li>
			</j:forEach>

		</ul>

	</div>
</nav> --%>

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



