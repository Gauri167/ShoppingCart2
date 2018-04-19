<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
 <link rel="stylesheet" href="assests/css/bootstrap.css">
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="Home.html">EZ Shopping</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  
  <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search">
      <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
    </form>
  
  <div class="collapse navbar-collapse navbar-right" id="navbarColor01">
    <ul class="navbar-nav mr-auto">
    
      <c:if test="${isUserClickedLogin==null}">
      <li class="nav-item ">
        <a class="nav-link" href="signUp"><span class="glyphicon glyphicon-user"></span> Sign Up</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a>
      </li>
      </c:if>
      
      <c:if test="${isUserClickedLogin==true}">
      <li class="nav-item">
        <a class="nav-link" href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="mycart"><span class="glyphicon glyphicon-shopping-cart"></span>MyCart(${size})</a>
      </li>
      <li class="nav-item">
      <a class="nav-link" href="myprofile"><span class="glyphicon glyphicon-user"></span>My Profile</a>
      </li>
      </c:if>
    
    </ul>
  </div>
</nav>

<script src="assests/js/jquery.js"></script>
<script src="assests/js/popper.js"></script>
<script src="assests/js/bootstrap.min.js"></script>
</body>