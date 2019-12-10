<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><html>
    <c:set var="css" value="${pageContext.request.contextPath}/resources/css" scope="application"/>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	 	<link href="${css}/style1.css" rel="stylesheet">
	 	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login Form</title>
	</head>
	<body style="background:url('https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSLMbN64D6I7FRKFF2uGEt3mcfY00_zwQIdct-wonBFsgz_SHUk')";>
	
		<div align="center">
		<hr/>
		
		<!-- <h1>Login Form</h1>-->
		<form action="validate" method="post">
				
				<div class="overlay">
</div>
<div class="leftcontent">
  <span class="ltitle">Purchase Order Login Page</span>
  <br>
  
</div>
<div class="sidebar">
  <span class="rtitle">Login</span>
  <br>
  <br>
  <form>
    <input class="textinput" type="text" name="email" autofocus="autofocus" placeholder="Enter your Email">
    <br>
    <br>
    <input class="textinput" type="password" name="pass" placeholder="Enter your Password">
    <br>
    <br>
    <button class="submit" type="submit">
      <img src="http://www.yachtsale.se/wp-content/themes/Yachtsales/images/arrow-right.png" height="24px" />
    </button>
  </form>
</div>


	</form>
	</div>
		</form>
		</div>
	</body>
</html>