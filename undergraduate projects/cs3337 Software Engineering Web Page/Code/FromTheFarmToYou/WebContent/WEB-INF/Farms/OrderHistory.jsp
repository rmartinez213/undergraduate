<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order History</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<script src="../ChickenPages/FarmersTemplate/script.js"></script>
</head>
<body>
	<sql:setDataSource var="history" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost/cs3220stu76" user="cs3220stu76"
		password="abcd" />

	<sql:query dataSource="${history}" var="result">SELECT * FROM orderhistory WHERE first_name = "${sFname}"  AND last_name = "${sLname}";</sql:query>

	<div class="container">
		<h2>Order History</h2>
		<table class="table">
			<thead>
				<tr>
					<th>id</th>
					<th>Name</th>
					<th>Eggs Bought</th>
					<th>Total Price</th>
					<th>Date Purchased</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${result.rows}">
					<tr>
						<td>${row.id}</td>
						<td>${row.first_name}${row.last_name}</td>
						<td>${row.eggsBought}</td>
						<td>${row.totalprice}</td>
						<td>${row.date}</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>




</body>
</html>