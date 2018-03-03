<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
</head>
<body>
	<form action="EditCustomer" method="post">
		Name: <input type="text" name="name" value="${List.name}" /> <br />
		Description: <textarea name="description">${List.description}</textarea> 
		<br /> <input type="hidden" name="id" value="${List.id}" /> 
		<input type="submit" name="save" value="Save" />
	</form>
</body>
</html>