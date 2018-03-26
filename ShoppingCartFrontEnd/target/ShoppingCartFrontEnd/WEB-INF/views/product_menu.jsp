    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
    

<ul> 

     <j:forEach var="category" items="${categories}">
     <li class="dropdown">
     <a href="javascript:void(0)" class="dropbtn">${category.name}</a>
     </li>
     <j:forEach var="product" items="${category.products}"> 
     <div class="dropdown-content">
     <a href=#>${product.name}</a>
     </div> 
     </j:forEach>
     </j:forEach>
 
  <!-- <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Electronics</a>
    <div class="dropdown-content">
      <a href="#">TV</a>
      <a href="#">Mobile</a>
      <a href="#">Laptop</a>
    </div>
  </li>
  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Books</a>
    <div class="dropdown-content">
      <a href="#">Java</a>
      <a href="#">HTML</a>
      <a href="#">JS</a>
    </div>
  </li>
  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Furniture</a>
    <div class="dropdown-content">
      <a href="#">Table</a>
      <a href="#">Chair</a>
      <a href="#"></a>
    </div>
  </li> -->
  
  
</ul>
