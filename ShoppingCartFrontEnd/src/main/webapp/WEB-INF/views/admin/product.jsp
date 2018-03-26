<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

this is product page
 ${productSuccessMessage} 
 ${productErrorMessage}

<form action="product/save/" method="post">
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
			<td>Category Id:</td>
			<td><input type="text" name='categoryId'
				value="${selectedProduct.categoryId}" <c:if test="${editProduct==true}"> disabled</c:if> required>  </td>
		</tr>

		<tr>
			<td>Supplier Id:</td>
			<td><input type="text" name='supplierId'
				value="${selectedProduct.supplierId}" <c:if test="${editProduct==true}"> disabled</c:if> required>  </td>
		</tr>

	</table>

	<input type="submit" value='Create Product'>
</form>

<!-- display all the products -->

<div>
	<table border="5" bgcolor="cyan">

		<tr>

			<td>Product Id</td>
			<td>Product Name</td>
			<td>Product Description</td>
			<td>Category Id</td>
			<td>Supplier Id </td>
			<td>Action</td>

		</tr>

		<c:forEach var="product" items="${products}">

			<tr>

				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.description}</td>
				<td>${product.categoryId}</td>
				<td>${product.supplierId}</td>
				<td><a href="product/delete/?id=${product.id}"> DELETE /</a> <a href="product/edit/?id=${product.id}"> EDIT</a> </td>
				
			</tr>

		</c:forEach>

	</table>
</div>


