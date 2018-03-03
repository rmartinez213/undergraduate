<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%-- Declares classes and methods --%>
<%@ page import= "Lab4.*" %>
<%@ page import= "java.util.ArrayList"%>
<%@ page import= "java.util.List" %>

		<%-- Start of HTML --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Homework 2</title>
	<link src="registerCss.css" rel="stylesheet">
	<link rel="stylesheet" href="https://bootswatch.com/paper/bootstrap.min.css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

	
	<%
		String InputName = request.getParameter("name");
		String InputUserName = request.getParameter("username");
		String InputPassword1 = request.getParameter("password1");
		String InputPassword2 = request.getParameter("password2");
	%>

			<%-- Creates Jumbotron Header --%>
	<div class="jumbotron">
		<h1 align="center">Registration</h1>
		<p></p>
	</div>

			<%-- Creates Registration form --%>
	<div>
		<form action="Register.jsp" method="post">
			<p align="center">
				
				<%-- NAME --%>
				<%-- Checks to see if there is anything in the parameter --%>
				<% if(request.getParameter("name") == null){ %>
				 	<span class="glyphicon glyphicon-user"> 
					Name: <br> <input type="text" name="name" />
					</span>
				<%}else{%>
					
				<%}%>
				
				
				<%-- Checks to see if the user entered a value, then prints error message --%>
				<%if(request.getParameterMap().containsKey("name") && (request.getParameter("name") != null) && request.getParameter("name").equals("")){%>
					<font color="red">Please enter a name.</font><br><br>
					<span class="glyphicon glyphicon-user"> 
					Name: <br> <input type="text" name="name" />
					</span>
				<%}%>

				<%-- Checks to see if user submitted box and if they did then it creates input box and adds value entered previously--%>				
				<%if(request.getParameter("name") != null && request.getParameter("name").isEmpty() != true){%>
					<span class="glyphicon glyphicon-user"> 
					Name: <br> <input type="text" name="name" value= <%=InputName%> />
					</span>
				<%}%>


				<%-- USERNAME --%>
				<br><br>
				<%-- Checks to see if there is anything in the parameter --%>
				<% if(request.getParameter("username") == null){ %>
				 	<span class="glyphicon glyphicon-user"> 
					Username: <br> <input type="text" name="username" />
					</span>
				<%}else{%>
					
				<%}%>
				
				
				<%-- Checks to see if the user entered a value, then prints error message --%>
				<%if(request.getParameterMap().containsKey("username") && (request.getParameter("username") != null) && request.getParameter("username").equals("")){%>
					<font color="red">Please enter a username.</font><br><br>
					<span class="glyphicon glyphicon-user"> 
					Username: <br> <input type="text" name="username" />
					</span>
				<%}%>

				<%-- Checks to see if user submitted box and if they did then it creates input box and adds value entered previously--%>				
				<%if(request.getParameter("username") != null && request.getParameter("username").isEmpty() != true){%>
					<span class="glyphicon glyphicon-user"> 
					Username: <br> <input type="text" name="username" value= <%=InputUserName%> />
					</span>
				<%}%>
				
				
				<br>
				<%-- CHECK TO SEE IF PASSWORDS DON'T MATCH --%>
				<br>
				<%if(request.getParameterMap().containsKey("password1") && request.getParameterMap().containsKey("password2") &&  (request.getParameter("password1").equals(request.getParameter("password2"))) != true){%>
					<font color="red">Password's don't match.</font><br><br>
				<%}%>
				
				
				<%-- PASSWORD --%>
				
				<%-- Checks to see if there is anything in the parameter --%>
				<% if(request.getParameter("password1") == null){ %>
				 	<span class="glyphicon glyphicon-user"> 
					Password: <br> <input type="password" name="password1" />
					</span>
				<%}else{%>
					
				<%}%>
				
				
				<%-- Checks to see if the user entered a value, then prints error message --%>
				<%if(request.getParameterMap().containsKey("password1") && (request.getParameter("password1") != null) && request.getParameter("password1").equals("")){%>
					<font color="red">Please enter a password.</font><br><br>
					<span class="glyphicon glyphicon-user"> 
					Password: <br> <input type="password" name="password1" />
					</span>
				<%}%>

				<%-- Checks to see if user submitted box and if they did then it creates input box and adds value entered previously--%>				
				<%if(request.getParameter("password1") != null && request.getParameter("password1").isEmpty() != true){%>
					<span class="glyphicon glyphicon-user"> 
					Password: <br> <input type="password" name="password1" value= <%=InputPassword1%> />
					</span>
				<%}%>
				


				<%-- PASSWORD2 --%>
				<br><br>
				<%-- Checks to see if there is anything in the parameter --%>
				<% if(request.getParameter("password2") == null){ %>
				 	<span class="glyphicon glyphicon-user"> 
					Re-Enter Password: <br> <input type="password" name="password2" />
					</span>
				<%}else{%>
					
				<%}%>
				
				
				<%-- Checks to see if the user entered a value, then prints error message --%>
				<%if(request.getParameterMap().containsKey("password2") && (request.getParameter("password2") != null) && request.getParameter("password2").equals("")){%>
					<font color="red">Please enter a password.</font><br><br>
					<span class="glyphicon glyphicon-user"> 
					Re-Enter Password: <br> <input type="password" name="password2" />
					</span>
				<%}%>

				<%-- Checks to see if user submitted box and if they did then it creates input box and adds value entered previously--%>				
				<%if(request.getParameter("password2") != null && request.getParameter("password2").isEmpty() != true){%>
					<span class="glyphicon glyphicon-user"> 
					Re-Enter Password: <br> <input type="password" name="password2" value= <%=InputPassword2%> />
					</span>
				<%}%>
				
				<% if(request.getParameter("name") != null && request.getParameter("username") != null 
				&& request.getParameter("password1").equals(request.getParameter("password2")) 
				&& request.getParameter("password1") != ""
				&& request.getParameter("password2") != ""
				&& request.getParameter("password1") != null && request.getParameter("password2") != null 
				&& request.getParameterMap().containsKey("password1") && request.getParameterMap().containsKey("password2")){
					
					ArrayList<Lab4User> UserList = (ArrayList<Lab4User>) getServletContext().getAttribute("registeredUsers");
					UserList.add(new Lab4User(InputName, InputUserName, InputPassword1));
					response.sendRedirect("../Lab4/Login");		
					}%>
				
				
				<br><br><input type="submit" value="Register" />
			</p>
		</form>
		
	</div>
</body>
</html>