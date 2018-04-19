<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="C:/Users/Gauri Gaur/Desktop/website/assests/css/bootstrap.css">

<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}

img.avatar {
    width: 40%;
    border-radius: 50%;
}

.container {
    padding: 16px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>

</head>
<body>

<!-- HEADER -->
<header>
<jsp:include page="newlogin.jsp"></jsp:include>
 
<jsp:include page="product_menu.jsp"></jsp:include>

</header>

${welcomeMessage}
${errorMessage}
${successMessage}
${logoutMessage}

<c:if test="${isUserSelectedProduct==true}">
<jsp:include page="selected_product.jsp"></jsp:include>
</c:if>

<c:if test="${isUserClickedMyCart==true}">
<jsp:include page="cart.jsp"></jsp:include>
</c:if>

<c:if test="${UserClickedLogin==true}">
<jsp:include page="login.jsp"></jsp:include>
</c:if>

<c:if test="${UserClickedSignUp==true}">
<jsp:include page="signUp.jsp"></jsp:include>
</c:if>


<c:if test="${isAdmin==true}">
<jsp:include page="admin/admin_home.jsp"></jsp:include>
</c:if>

<c:if test="${UserClickedMyProfile==true}">
<jsp:include page="myprofile.jsp"></jsp:include>
</c:if>

<c:if test="${UserClickedBuy==true}">
<jsp:include page="checkout.jsp"></jsp:include>
</c:if>

<c:if test="${userClickedMyDetails==true}">
<jsp:include page="my_details.jsp"></jsp:include>
</c:if>

<!-- FOOTER -->
<footer>
<jsp:include page="footer.jsp"></jsp:include>
</footer>
<script src="C:/Users/Gauri Gaur/Desktop/website/assests/js/jquery.js"></script>
<script src="C:/Users/Gauri Gaur/Desktop/website/assests/js/popper.js"></script>
<script src="C:/Users/Gauri Gaur/Desktop/website/assests/js/bootstrap.min.js"></script>
</body>
</html>