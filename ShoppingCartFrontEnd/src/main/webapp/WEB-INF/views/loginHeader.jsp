<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <ul class="nav navbar-nav navbar-left">
    <%-- <c:if test="${loggedInUserId==false}"> --%>
      <li><a href="signUp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      <%-- </c:if> --%>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <c:if test="${loggedInUserId==true}">
    <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      <li><a href="mycart"><span class="glyphicon glyphicon-shopping-cart"></span>MyCart(${size})</a></li>
      </c:if>
    </ul>
  </div>
</nav>
  
</body>
</html>