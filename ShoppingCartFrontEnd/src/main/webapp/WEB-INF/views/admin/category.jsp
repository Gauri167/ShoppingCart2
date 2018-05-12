<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

${categorySuccessMessage} 
${categoryErrorMessage}

<form action="category/save/" method="post">
	<table>
		<tr>
			<td>Id:</td>
			<!-- write it in if condition -->
			
			<td><input type="text" name="id" value="${selectedCategory.id}" <c:if test="${editCategories==true}"> disabled</c:if>></td>
		</tr>

		<tr>
			<td>Name:</td>
			<td><input type="text" name="name" value="${selectedCategory.name}"></td>
		</tr>

		<tr>
			<td>Description:</td>
			<td><input type="text" name="description" value="${selectedCategory.description}"></td>
		</tr>

	</table>

	<input type="submit" value='Create Category'>
</form>

<!-- display all the categories -->

<div>
	<table border="5px">

		<tr bgcolor="cyan">

			<td>Category Id</td>
			<td>Category Name</td>
			<td>Category Description</td>
			<td>Action</td>

		</tr>

		<c:forEach var="category" items="${categories}">

			<tr bgcolor="cyan">

				<td>${category.id}</td>
				<td>${category.name}</td>
				<td>${category.description}</td>
				<td><a href="category/delete/?id=${category.id}"> DELETE /</a> <a href="category/edit/?id=${category.id}"> EDIT</a> </td>
				
			</tr>

		</c:forEach>

	</table>
</div>


