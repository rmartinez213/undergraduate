<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://bootswatch.com/paper/bootstrap.min.css">
<link href="SigninCss.css" rel="stylesheet" />
<title>Sign in</title>
</head>
<body>
	<h2 align="center">Login</h2>
	<form class="" method="post" action="Signin">
		<!-- Username Validation -->
		<div align="center">
			<c:if test="${not empty usernameError}">
				<p style="color: red;">${usernameError}</p>
			</c:if>
			<c:if test="${not empty incorrectusernameError}">
				<p style="color: red;">${incorrectusernameError}</p>
			</c:if>
			<span class="glyphicon glyphicon-user"> Name: <br> <input
				type="text" name="username" />
			</span>
		</div>
		<br>

		<!-- Password Validation -->
		<div align="center">
			<c:if test="${not empty passwordError}">
				<p style="color: red;">${passwordError}</p>
			</c:if>
			<c:if test="${not empty incorrectpasswordError}">
				<p style="color: red;">${incorrectpasswordError}</p>
			</c:if>
			<span class="glyphicon glyphicon-lock"> Password: <br> <input
				type="password" name="password" />
			</span>
			<div align="center">
				Don't have an account!? <a href="Registration">Sign up here!</a>
			</div>
			<div class="form-group " align="center">
				<input type="submit" value="Login!">
			</div>
		</div>
	</form>
</body>
</html>