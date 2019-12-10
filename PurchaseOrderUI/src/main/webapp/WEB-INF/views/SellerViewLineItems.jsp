<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seller Page</title>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

   <link href="${css}/style.css" rel="stylesheet">

</head>
<body>

>

<div align="center">
	<div class="ListPO">
		<div align="center">
			<table border=1>
				<tr>
					<th>Product Name</th>				
					<th>Quantity </th>
					<th>Product Id </th>
				</tr>
			
				<c:forEach items="${poitemslist}" var="obj">
				<tr>	
					<td>${obj.productObj.productName}</td>
					<td>${obj.quantity}</td>
					<td>${obj.productObj.productId}</td>
				</tr>
				
				</c:forEach>
			</table>
		</div>
</div>
	</div>	

</body>
</html>