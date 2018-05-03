<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>EZ Shopping</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js">
angular.module('getCookies',['ngCookies'])
.controller('checkCookies',['$cookies',function($cookies){
	var mcookie=$cookies.get("emailId");
	var pcookie=$cookies.get("password");
}])
$http.post('/vaildate',mcookie,pcookie,config).then(successCallback,errorCallback);
</script>
  <meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
</head>

<body>

<nav class="navbar navbar">
<div class="container-fluid">
<div class="navbar navbar-inverse">
<div class="navbr-header">
<a class="navbar-brand" href="${pageContext.request.contextPath}/">EZ Shopping</a>
</div>

 <ul class="nav navbar-nav navbar-right">
     <c:if test="${UserClickedLogin==null}">
      <li><a href="${pageContext.request.contextPath}/signUp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </c:if>
     
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <c:if test="${UserClickedLogin==true}">
    <li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      <li><a href="${pageContext.request.contextPath}/mycart"><span class="glyphicon glyphicon-shopping-cart"></span>MyCart(${size})</a></li>
      <li><a href="${pageContext.request.contextPath}/myprofile">My Profile</a></li>
      <%-- <li><a href="#">${pageContext.request.userPrincipal.name}</a></li> --%>
      </c:if>
    </ul>
    </div>
    </div>
    </nav>

</body>
</html>