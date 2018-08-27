<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: pressos
  Date: 22/8/2018
  Time: 12:33 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>Udemy Spring Security Demo</title>

		<link rel="stylesheet"
			  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

		<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

		<style>
			hr {
				border: none;
				height: 1px;
				color: black;
			}

			.inline {
				display: inline;
			}
		</style>
	</head>
	<body>
		<h2>Udemy Spring Security Demo</h2>
		<hr style="color: black">

		Welcome to Panagiotis Ressos' Udemy Spring Security Demo
		<br>
		
		<hr style="color: black">
		
		<p>
			User: <security:authentication property="principal.username"/>
			<br><br>
			Role (s): <security:authentication property="principal.authorities"/>
		</p>
		
		<hr>

		<div class="inline">
			<security:authorize access="hasRole('OVERLORD')">
				<p class="inline">
    				<a class="btn btn-success" href="${pageContext.request.contextPath}/overLords">Only Overlords</a>
    			</p>
			</security:authorize>
			<security:authorize access="hasRole('PLEB')">
			    <p class="inline">
    				<a class="btn btn-danger" href="${pageContext.request.contextPath}/plebs">Plebs go here</a>
    			</p>
			</security:authorize>
			<security:authorize access="hasRole('Awesome')">
			    <p class="inline">
    				<a class="btn btn-primary" href="${pageContext.request.contextPath}/castle">Only Awesome dudes</a>
    			</p>
			</security:authorize>
		</div>

		<hr>
		
		<form:form method="post" action="${pageContext.request.contextPath}/logout">

			<input type="submit" class="btn btn-primary" value="Logout">
		</form:form>

	</body>
</html>
