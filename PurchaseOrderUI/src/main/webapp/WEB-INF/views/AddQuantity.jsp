<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PO page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1 style="color: green;">Add Quantity</h1>
		<f:form action="updateProductQuantity" method="post">
		<table class="table table-borderless  table table-hover table-dark">
			<thead>
				<tr>
					<th>select the Items</th>
					<th>select the Quantity</th>

				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<select class="form-control" name="pId">
						<option value="0">Select your products</option>
						<c:forEach items="${productDetails}" var="obj">
						<option value="${obj.productId}"> 
						${obj.productName} 
						</option>
						</c:forEach>
						</select>
						
						</td>
					<td><input  type="number" min="0" pattern="\d*"  class="form-control" placeholder="Quantity" name="quantity" required/></td>

					
					
					
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><input type="submit" value="Add"	class="btn btn-primary" /></td>
				</tr>

			</tbody>
		</table>
		</f:form>
	</div>
	</body>
</html>