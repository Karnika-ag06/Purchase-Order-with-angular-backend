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

<%-- <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
   <li class="nav-item active">
      <h2 class="nav-link" >Hello ${uObj.userName}</h2>
    </li>
    <li class="nav-item active">
      <a class="nav-link" href="homeSeller">Home</a>
    </li> 
  </ul>
</nav> --%>

<div align="center">
	<div class="ListPO">
		<div align="center">
			<table border=1>
				
				<tr>
		        	<th>Purchase Order Id </th>				
					<th>Buyer Id </th>
					<th > Seller Id </th>
					
					
				</tr>
			
				<c:forEach items="${list}" var="obj">
				<tr>	
					<td>${obj.purchaseOrderId}</td>
					<td>${obj.userObj.userId}</td>
					<td>${obj.sellerObj.userId}</td>
					<td><a href="viewLineItems?viewId=${obj.purchaseOrderId}">View</a></td> 
				</tr>
				
				</c:forEach>
			</table>
		</div>
</div>
	</div>	

</body>
</html>
