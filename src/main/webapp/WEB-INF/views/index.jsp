<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/journal/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ciphE0NCAlD2/N6NUApXAN2dAs/vcSAOTzyE202jJx3oS8n4tAQezRgnlHqcJ59C"
	crossorigin="anonymous">

</head>
<body>

	<h3>Register: </h3>
	<form action="add-user">
		<input type="text" name="FirstName" placeholder="First Name">
		<input type="text" name="LastName" placeholder="Last Name"> 
		<input class="btn btn-primary" type="submit" value="Register">

	</form>

	<table class="table">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Description</th>
			<th>Quantity</th>
			<th>Price</th>
		</tr>
		<br>
		<br>
		<h3>Product List: </h3>
		<c:forEach var="p" items="${productList }">
			<tr>
				<td>${p.id }</td>
				<td>${p.name }</td>
				<td>${p.description }</td>
				<td>${p.quantity }</td>
				<td>${p.price }</td>
			</tr>
		</c:forEach>
	</table>
	
	<br>
	<h3>Add a Product: </h3>
		<form action="add-product"> 
		<input type="text" name="name" placeholder="Product Name">
		<input type="text" name="description" placeholder="Product Description">
		<input type="number" name="quantity" placeholder="Quantity">
		<input type="number" name="price" placeholder="Price">
		<input class="btn btn-primary" type="submit" value="Add Product">
	</form>
	
	<br>
	<h3>Search for a Product: </h3>
		<form action="search-name" method="post">
			<input type="text" name="name" value="${productName}" placeholder="Search By Name">
			<input class="btn btn-primary" type="submit" value="Search">
			<c:if test="${not empty productName}">
			<a href="/" class="btn btn-primary">Clear</a>
			</c:if>
		</form>

</body>
</html>