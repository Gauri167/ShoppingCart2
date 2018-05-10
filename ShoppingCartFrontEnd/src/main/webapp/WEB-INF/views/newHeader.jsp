<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<body>

<div class="page-header">
  <nav class="navbar navbar-inverse">
    <div class="navbar-header">
    	<button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".js-navbar-collapse">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="${pageContext.request.contextPath}/">EZ Shopping</a>
	</div>
	
	<div class="collapse navbar-collapse js-navbar-collapse">
		<ul class="nav navbar-nav">
			<li class="dropdown mega-dropdown">
				<c:forEach var="category" items="${categories}">
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
			aria-expanded="false">${category.name}<span class="caret"></span></a>
			<div class="dropdown-menu">
			 <c:forEach var="product" items="${category.products}">
				
					<a class="dropdown-item" href="${pageContext.request.contextPath}/product/get?id=${product.id}">${product.name}</a><br/>
				
			</c:forEach></div></li>
	</c:forEach>
	</li>
	</ul>
	
		
		<ul class="nav navbar-nav navbar-right">
     <c:if test="${UserClickedLogin==null}">
      <li><a href="${pageContext.request.contextPath}/signUp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </c:if>
    </ul>
		
        <ul class="nav navbar-nav navbar-right">
		<c:if test="${UserClickedLogin==true}">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">My account <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="myDetails">My Details</a></li>
            <li><a href="myOrders">My Orders</a></li>
          </ul>
        </li>
        <li><a href="${pageContext.request.contextPath}/mycart"><span class="glyphicon glyphicon-shopping-cart"></span>My cart (${size}) items</a></li>
		<li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
		  </c:if>
      </ul>
      </div>
      </nav>
	</div><!-- /.nav-collapse -->

</body>
</html>