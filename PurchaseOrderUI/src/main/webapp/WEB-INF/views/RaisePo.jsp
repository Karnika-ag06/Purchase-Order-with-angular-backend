<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Raise PO Form</title>
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
	
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	
<script>
    $(document).ready(function(){
    	var productName;
        $(".add-row").click(function(){
            var items = $(".name option:selected").val();
            var quantity = $("#quantity").val();
            
            
           $.get("getProductNameById?productId="+items, function(data, status){
                productObj=data;
                
                
         var markup = "<tr><td><input type='checkbox' name='record'></td><td>"+items+"</td><td>" + productObj.productName + "</td><td>" + quantity + "</td></td>";
                $("table ").append(markup);
                
              });
        });
        
        // Find and remove selected table rows
        $(".delete-row").click(function(){
            $("table tbody").find('input[name="record"]').each(function(){
                if($(this).is(":checked")){
                    $(this).parents("tr").remove();
                }
            });
        });
       
        var purchaseOrderList = [];
        $("#raisePO").click(function() {
        	console.log('Hello 1');
        	var table = $("table tbody");
        	console.log('Hello 2');
        	 
        	table.find('tr').each(function (i, el) {
        		 console.log('Hello 3');
        		 
        	        var $tds = $(this).find('td'),  
        	        pId = $tds.eq(1).text(),
        	        Quantity = $tds.eq(3).text();
        	        
        	        // do something with productId, product, Quantity
        	        console.log('Hello 5');
        	        
        	        var myObj = {
        	        		  productId: pId,
        	        		  quantity:Quantity
        	        		  
        	        		};
        	        purchaseOrderList.push(myObj);
        	    });
        	console.log(purchaseOrderList);
        	
         
        $.ajax({
            type: "POST",
            url: "raisePO",
            data: JSON.stringify(purchaseOrderList),
            contentType: "application/json; charset=utf-8",
            dataType: "text",
            success: function(data){
                alert("Purchase Order raised successfully!");
                location.reload();
           },
            error: function(e) {
                console.log('i m error');
                
            	console.log(e);
            }
        });
	});
});    
</script>


</head>
<body>

	<div class="container">
	
<h1 style="color: green;">Raise Po</h1>
 		<form>
 	<select class="form-control name" name="items">
						<option value="">Select your products</option>
						<c:forEach items="${productDetails}" var="pObj">
						<option value="${pObj.productId}"> 
							${pObj.productName} 
						</option>
						</c:forEach>
						</select>
						<input type="number" min="0" pattern="\d*"  class="form-control" placeholder="Quantity" id="quantity" required/>
						<input type="button" value="Add"	class="btn btn-success add-row" />



		    <table class="table-responsive table-dark table table-hover">
        <thead>
            <tr>
                <th>Select</th>
                <th>Product Id</th>
                <th>Product Name</th>
                <th>quantity</th>
            </tr>
        </thead>
        <tbody>
        
        </tbody>
  </table>
			<div class="row">
			<div class="col">	<button type="button" class="delete-row">Delete Row</button>
			</div>		
	<div class="col"><input type="button" value="submit"	class="btn btn-primary" id="raisePO"/></div>
		</div>

	
	</form>
	</div>
	</body>
</html>

