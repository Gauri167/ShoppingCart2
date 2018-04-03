    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
    

<ul> 

     <j:forEach var="category" items="${categories}">
     <li class="dropdown">
     <a href="<j:url value="products/${category.id}"/>" class="dropbtn">${category.name}</a>
          
     <j:forEach var="product" items="${category.products}"> 
     <div class="dropdown-content">
     <a href="product/get/?id=${product.id}">${product.name}</a>
     </div> 
     </j:forEach>
     
     </li>
     </j:forEach>
     
     </ul>
 
 
  
  
  

