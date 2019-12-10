<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:set var="css"
	value="${pageContext.request.contextPath}/resources/css"
	scope="application" />
<c:set var="images"
	value="${pageContext.request.contextPath}/resources/images"
	scope="application" />

<html>
<head>
<link href="${css}/style2.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Yourself</title>
</head>

<style>
#error {
	color: red;
	font-size: 20px;
}
</style>
<body style="background:url('${images}/edited.jpg');">
	<f:errors path="*" />
	<div align="center" style="font-color: white">
		<h1>Register Yourself</h1>
	</div>

	<div class="dim">
		<div class="prominent">
			<f:form class="bright-form register-form" method="post"
				action="registerUser" modelAttribute="userObj">
				

					<table>
						<tr>
							<td><f:input path="userName" id="name"
									placeholder="user name" /></td>
							<td><f:errors path="userName" id="error" /></td>
						</tr>
						<tr>
							<td><f:input path="userAddress" id="address"
									placeholder="User Address" /></td>
							<td><f:errors path="userAddress" id="error" /></td>
						</tr>

						<tr>
							<td><f:input path="userMobile" id="phone"
									placeholder="mobile Number" /></td>
							<td><f:errors path="userMobile" id="error" /></td>
						</tr>

						<tr>
							<td><f:input path="userEmail" id="email"
									placeholder="Email Id" /></td>
							<td><f:errors path="userEmail" id="error" /></td>
						</tr>
						<tr>
							<td><f:input path="userPassword" id="password"
									placeholder="Password" /></td>
							<td><f:errors path="userPassword" id="error" /></td>
						</tr>

						<tr>
							<td></td>
							<td>
								<div class="group">
									<input type="submit" value="Register" />
								</div>
							</td>
						</tr>


					</table>
			</f:form>


			<div class="group">
				<a href="getLoginForm">Already have an account? Sign in.</a>
			</div>
		</div>
	</div>


</body>
</html>






