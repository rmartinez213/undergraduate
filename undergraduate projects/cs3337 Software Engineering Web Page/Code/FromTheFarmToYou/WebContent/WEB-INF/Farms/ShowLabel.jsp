<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>Show label</title>
</head>

<body bgcolor="#f0f0f0">
	<h1 align=center>Show shipping label</h1>
	<br>
	<br>
	<center>
		<img style="vertical-align: right;" width="100px" height="75px"
			src="../images/chick.png">
	</center>
	<br>
	<center>
		<table border="7">
			<thead>
				<tr>
					<th>To: ${currentUser.first_name} ${currentUser.last_name}</th>
				</tr>
			</thead>
			<tr>
				<td>Address: ${address}</td>
			</tr>
			<tr>
				<td>${city},${state}, ${zip}</td>
			<tr>
				<th>FROM: Daryl Dixon</th>
			</tr>
			<!-- get farmer first, and last name -->
			<tr>
				<td>Address: 123 Sesame street</td>
				<!-- Get address from farmer -->
			</tr>
			<tr>
				<td>Los Angeles, CA, 90123</td>
				<!-- Get city, state, zip from farmer -->
			</tr>
			<tr>
				<td>United States</td>
			</tr>
			<!-- Inser ran num here -->
			<tr>
				<td><img style="vertical-align: bottom;" width="274px"
					height="50px" src="../images/barcode.jpg"></td>
			</tr>
		</table>
	</center>
	<center>
		<form method="GET" action="../ChickenPages/index">
			<input type="submit" value="Go Home">
		</form>

	</center>

</body>
</html>




</body>
</html>