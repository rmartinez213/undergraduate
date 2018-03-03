<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Relationship Management</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>

	<div class="jumbotron">
		<h1 align='center'>Customers</h1>
	</div>
	
	
	<div align="center">
		
		<form action="Main" method="post">
			<input type="text" name="searchNameQuery" placeholder="Enter a search quary" value="${param.searchNameQuery}"><br>
			<input type="submit" name="search" value="Search">
		</form>
		
		<form action="Main" method="get">
			<input type="submit" name="tests" value="View Table">
		</form>
	</div>

<table border="1" align="center">
  <tr><th>Id</th><th>Name</th><th>Description</th><th>Functions</th></tr>
<c:forEach items="${RegisteredCustomers}" var="entry">
  <tr>
    <td>${entry.id}</td>
    <td>${entry.name}</td>
    <td><c:out value="${entry.description}" escapeXml="true" /></td>
    <td><a href="EditCustomer?id=${entry.id}">Edit </a><a href="DeleteCustomer?id=${entry.id}">Delete</a></td>
  </tr>
</c:forEach>
</table>

<p align="center"><a href="AddCustomer">Add Customer</a></p>


</body>
</html>