<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html >
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
 
</head>

<body>

<!-- HEADER -->
<header>
 <jsp:include page="newHeader.jsp"></jsp:include>
</header>

${welcomeMessage}<br>
${errorMessage}<br>
${successMessage}<br>
${logoutMessage}<br>

<c:if test="${isUserSelectedProduct==true}">
<jsp:include page="selected_product.jsp"></jsp:include>
</c:if>

<c:if test="${isUserClickedMyCart==true}">
<jsp:include page="cart.jsp"></jsp:include>0
</c:if>

<c:if test="${isUserClickedLogin==true}">
<jsp:include page="login.jsp"></jsp:include>
</c:if>

<c:if test="${UserClickedSignUp==true}">
<jsp:include page="signUp.jsp"></jsp:include>
</c:if>

<c:if test="${UserClickedForgotPassword==true}">
<jsp:include page="forgotPassword.jsp"></jsp:include>
</c:if>

<c:if test="${isUserEntersOTP==true}">
<jsp:include page="EnterOTP.jsp"></jsp:include>
</c:if>

<c:if test="${userClickedEnternewPasswrd==true}">
<jsp:include page="createPassword.jsp"></jsp:include>
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

<c:if test="${UserClickedCancelOrder==true}">
<jsp:include page="OrderDetails.jsp"></jsp:include>
</c:if>

<c:if test="${UserClickedDeleteOrder==true}">
<jsp:include page="cancel_order.jsp"></jsp:include>
</c:if>

<c:if test="${userClickedAboutUs==true}">
<jsp:include page="aboutUs.jsp"></jsp:include>
</c:if>

<c:if test="${userClickedfaq==true}">
<jsp:include page="faq.jsp"></jsp:include>
</c:if>

<c:if test="${userClickedTermsandPolicy==true}">
<jsp:include page="termsAndCond.jsp"></jsp:include>
</c:if>

<c:if test="${thankyouPage==true}">
<jsp:include page="thankyou.jsp"></jsp:include>
</c:if>
  
</body>

<!-- FOOTER -->
<footer>
<jsp:include page="newfooter.jsp"></jsp:include>
</footer>

</html>