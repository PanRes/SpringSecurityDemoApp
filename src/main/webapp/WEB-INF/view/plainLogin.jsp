<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pressos
  Date: 22/8/2018
  Time: 1:42 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>Login Page</title>

		<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

		<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

		<link rel="stylesheet" type="text/css"
			  href="${pageContext.request.contextPath}/resources/css/style.css">
	</head>
	<body>
		<h3>My custom Login Page</h3>
		<c:if test="${param.error != null}">
			<i class="failLogin">Sorry! Wrong credentials dufus</i>
		</c:if>
		<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">
			<p>User Name: <input type="text" name="username"></p>
			<p>Password: <input type="password" name="password"></p>

			<input type="submit" value="Login">
		</form:form>
	</body>
</html>
