<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>

<!-- <head>
 <link rel="stylesheet" href="assests/css/bootstrap.css">
</head> -->

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
			aria-expanded="false">${category.name}</a> <j:forEach var="product"
				items="${category.products}">
				<div class="dropdown-menu">
					<a class="dropdown-item" href="product/get?id=${product.id}">${product.name}</a>
				</div>
			</j:forEach></li>
	</j:forEach>
</ul>

<!-- <script src="assests/js/jquery.js"></script>
<script src="assests/js/popper.js"></script>
<script src="assests/js/bootstrap.min.js"></script> -->
</body>



