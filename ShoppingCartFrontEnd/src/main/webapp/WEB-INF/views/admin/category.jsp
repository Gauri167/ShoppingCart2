<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
this is category page
<!-- create 3 text fields  -->
${categorySuccessMessage} ${categoryErrorMessage}
<%-- <form:form modelAttribute="category" action="saveCategory" method="post">
<form:input path="id" palaceholder="Id"/>
<form:input path="name" palaceholder="Name"/>
<form:input path="description" palaceholder="Description"/>
<input type="submit" value="Save Category"/>
</form:form> --%>

<form action="category/save/" method="post">
	<table>
		<tr>
			<td>Id:</td>
			<td><input type="text" name="id"></td>
		</tr>

		<tr>
			<td>Name:</td>
			<td><input type="text" name="name"></td>
		</tr>

		<tr>
			<td>Description:</td>
			<td><input type="text" name="description"></td>
		</tr>

	</table>

	<input type="submit" value='Create Category'>
</form>

<!-- display all the categories -->

<div>
	<table border="5" bgcolor="cyan">

		<tr>

			<td>Category Id</td>
			<td>Category Name</td>
			<td>Category Description</td>
			<td>Action</td>

		</tr>

		<c:forEach var="category" items="${categories}">

			<tr>

				<td>${category.id}</td>
				<td>${category.name}</td>
				<td>${category.description}</td>
				<td><a href="category/delete/?id=${category.id}"> DELETE /</a> 
				    <a href="category/update/"> EDIT</a> </td>
				
			</tr>

		</c:forEach>

	</table>
</div>


