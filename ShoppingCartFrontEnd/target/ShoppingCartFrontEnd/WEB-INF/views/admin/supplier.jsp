<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

This is supplier Page

${supplierSuccessMessage}
${supplierErrorMessage}

<form action="supplier/save/" method="post">
	<table>
		<tr>
			<td>Id:</td>
			<!-- write it in if condition -->
			
			<td><input type="text" name="id" value="${selectedSupplier.id}" <c:if test="${editSupplier==true}"> disabled</c:if>></td>
		</tr>

		<tr>
			<td>Name:</td>
			<td><input type="text" name="name" value="${selectedSupplier.name}"></td>
		</tr>

		<tr>
			<td>Address:</td>
			<td><input type="text" name="address" value="${selectedSupplier.address}"></td>
		</tr>

	</table>

	<input type="submit" value='Create Supplier'>
</form>

<!-- display all the suppliers -->

<div>
	<table border="5" bgcolor="cyan">

		<tr>

			<td>Supplier Id</td>
			<td>Supplier Name</td>
			<td>Supplier Description</td>
			<td>Action</td>

		</tr>

		<c:forEach var="supplier" items="${suppliers}">

			<tr>

				<td>${supplier.id}</td>
				<td>${supplier.name}</td>
				<td>${supplier.address}</td>
				<td><a href="supplier/delete/?id=${supplier.id}"> DELETE /</a> <a href="supplier/edit/?id=${supplier.id}"> EDIT</a> </td>
				
			</tr>

		</c:forEach>

	</table>
</div>
