<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Shopping Cart</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>

<nav class="navbar navbar">
<div class="container-fluid">
<div class="navbar navbar-inverse">
<div class="navbr-header">
<a class="navbar-brand" href="#">ShoppingCart</a>
</div>
<form class="navbar-form navbar-left" action="">
<div class="input-group">
<input type="text" class="form-control" placeholder="Search" name="search"/>
<div class="input-group-btn">
<button class="btn btn-default" type="submit">
<i class="glyphicon glyphicon-search"></i>
</button>
</div>
</div>
</form>

 <ul class="nav navbar-nav navbar-right">
     <c:if test="${isUserClickedLogin==null}">
      <li><a href="signUp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </c:if>
     
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <c:if test="${isUserClickedLogin==true}">
    <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      <li><a href="mycart"><span class="glyphicon glyphicon-shopping-cart"></span>MyCart(${size})</a></li>
      <li><a href="myprofile">My Profile</a></li>
      </c:if>
    </ul>
    </div>
    </div>
    </nav>

</body>
</html>