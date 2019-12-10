<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


 <title>Vendor Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

	<c:if test="${not empty msg}">
		<div class="alert alert-success">
		${msg}
		</div>
	</c:if>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="">Home</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="viewAllAvailableProducts">View All Available Products</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="viewAllProducts">View All Products</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="updateProductQuantity">Update Product Quantity</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="logout">More</a>
    </li>
  </ul>
</nav>




</body>
</html>