<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 ${productSuccessMessage} 
 ${productErrorMessage}
 ${uploadMessage}

<form action="product/save/" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>Id:</td>
			<!-- write it in if condition -->

			<td><input type="text" name="id" value="${selectedProduct.id}"
				<c:if test="${editProduct==true}"> disabled</c:if>></td>
		</tr>

		<tr>
			<td>Name:</td>
			<td><input type="text" name="name"
				value="${selectedProduct.name}"></td>
		</tr>

		<tr>
			<td>Description:</td>
			<td><input type="text" name="description"
				value="${selectedProduct.description}"></td>
		</tr>
		
		<tr>
			<td>Price:</td>
			<td><input type="text" name='price'
				value="${selectedProduct.price}">  </td>
		</tr>

        <tr>
			<td>Category</td>
			<td>
			
			<input type="text" name='categoryId'
				value="${selectedProduct.categoryId}">
			
			</td>
		</tr>
		
		<tr>
			<td>Supplier</td>
			<td>
			
			<input type="text" name='supplierId'
				value="${selectedProduct.supplierId}">
			
			</td>
		</tr>
		
		<tr>
		<td>
		Product Image:<input type="file" name="file">
		</td>
		</tr>
		
	</table>

	<input type="submit" value='Create Product'>
</form>

<!-- display all the products -->

<div>
	<table border="5px" bgcolor="cyan">

		<tr>

			<td>Product Id</td>
			<td>Product Name</td>
			<td>Product Description</td>
			<td>Category Id</td>
			<td>Supplier Id </td>
			<td>Price</td>
			<td>Action</td>

		</tr>

		<c:forEach var="product" items="${products}">

			<tr>

				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.description}</td>
				<td>${product.categoryId}</td>
				<td>${product.supplierId}</td>
				<td>${product.price}</td>
				<td><a href="product/delete/?id=${product.id}"> DELETE /</a> <a href="product/edit/?id=${product.id}"> EDIT</a> </td>
				
			</tr>

		</c:forEach>

	</table>
</div>


		