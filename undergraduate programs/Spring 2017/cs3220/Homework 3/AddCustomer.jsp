<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Customer</title>
</head>
<body>

<form action="AddCustomer" method="post">

    <c:if test="${not empty nameError}">
        <p style="color: red;">${nameError}</p>
    </c:if>
    
    Name: <input type="text" name="name" value="${param.name}" /> <br />
    
    <c:if test="${not empty descriptionError}">
        <p style="color: red;">${descriptionError}</p>
    </c:if>
    
    <textarea name="description">${param.description}</textarea> <br />
    
    <input type="submit" name="add" value="Add" />
</form>

</body>
</html>