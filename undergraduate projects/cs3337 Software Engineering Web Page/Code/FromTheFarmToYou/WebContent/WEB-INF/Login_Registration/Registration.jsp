<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<link rel="stylesheet"
	href="https://bootswatch.com/paper/bootstrap.min.css">
<link href="RegisterCss.css" rel="stylesheet" />

<title>Registration</title>
</head>
<body>
	<div class="container">
		<div class="row main">
			<div class="main-login main-center">
				<h2 align="center">Account Registration</h2>
				<form method="post" action="Registration">

					<div align="center">
						<c:if test="${not empty nameError}">
							<p style="color: red;">${nameError}</p>
						</c:if>

						<span class="glyphicon glyphicon-user"> FirstName: <br>
							<input type="text" name="firstname" />
						</span>

					</div>
					<br>
					<div align="center">
						<c:if test="${not empty nameError}">
							<p style="color: red;">${nameError}</p>
						</c:if>

						<span class="glyphicon glyphicon-user"> LastName: <br>
							<input type="text" name="lastname" />
						</span>
					</div>
					<br>


					<div align="center">
						<c:if test="${not empty emailError}">
							<p style="color: red;">${emailError}</p>
						</c:if>


						<span class="glyphicon glyphicon-envelope"> Email: <br>
							<input type="text" name="email" />
						</span>
					</div>
					<br>


					<div align="center">
						<c:if test="${not empty usernameError}">
							<p style="color: red;">${usernameError}</p>
						</c:if>


						<span class="glyphicon glyphicon-user"> Username: <br>
							<input type="text" name="username" />
						</span>
					</div>
					<br>


					<div align="center">
						<c:if test="${not empty passwordError}">
							<p style="color: red;">${passwordError}</p>
						</c:if>

						<c:if test="${not empty failsameError}">
							<p style="color: red;">${failsameError}</p>
						</c:if>

						<span class="glyphicon glyphicon-lock"> Password: <br>
							<input type="password" name="password" />
						</span>
					</div>
					<br>


					<div align="center">
						<c:if test="${not empty password2Error}">
							<p style="color: red;">${password2Error}</p>
						</c:if>


						<span class="glyphicon glyphicon-lock"> Password: <br>
							<input type="password" name="password2" />
						</span>
					</div>
					<br>

					<div class="form-group " align="center">
						<input type="submit" value="Register!">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>