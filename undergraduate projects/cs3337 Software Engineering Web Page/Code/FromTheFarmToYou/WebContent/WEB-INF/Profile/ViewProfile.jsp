<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<link rel="stylesheet" href="../css/ViewProfileCSS.css">

<!-- Jquery cdn -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<!-- Font by google -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">


<title>Profile</title>
</head>
<body>


	<div class="jumbotron" id="HeaderTop">
		<div align="center">
			<h1>View Profile</h1>
		</div>
		<p></p>


		<div class="hold">
			<div class="container">
				<nav class="navbar navbar-default" role="navigation"> <!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span><span class="icon-bar"></span><span
							class="icon-bar"></span>
					</button>
					<!--<a class="navbar-brand" href="#">Brand</a>-->
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a href="../ChickenPages/index"><span
								class="glyphicon glyphicon-home"></span>Home</a></li>
						<li><a href="../chickenPages/AboutUs"><span
								class="glyphicon glyphicon-book"></span>About Us</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><span
								class="glyphicon glyphicon-list-alt"></span>Farms <b
								class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="../Farms/FarmController">Dixon Farm</a></li>
								<li><a href="../Farms/Farm2Controller">Hesperia Farm</a></li>
								<li><a href="../Farms/Farm3Controller">Westwick Rooke
										Farm</a></li>
								<li class="divider"></li>
								<li><a href="../Review/CustomerReviews">Reviews</a></li>
							</ul></li>
						<li class=""><a href="../ContactUs/ContactUsModule"><span
								class="glyphicon glyphicon-pencil"></span>Contact Us</a></li>

					</ul>
					<ul class="nav navbar-nav navbar-right">


						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><span class="glyphicon glyphicon-cog"></span>Sign
								Up </a>
							<ul class="dropdown-menu">
								<li><a href="../Login/Registration">Register Now!</a></li>
								<li><a href="../Login/Signin"> Login</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><span
								class="glyphicon glyphicon-user disabled"></span>User <c:forEach
									items="${UserList}" var="entry">
									<tr>
										<td>${entry.username}</td>


									</tr>
								</c:forEach> <b class="caret"></b></a> <!-- ADD JSP HERE THAT REFLECTS USER STATUS AND/OR NAME -->
							<ul class="dropdown-menu">
								<li><a href="../chickenPages/Profile"><span
										class="glyphicon glyphicon-user"></span>Profile</a></li>


								<c:forEach items="${UserList}" var="entry">
									<tr>
										<li><a href="../Farms/OrderHistory"><span
												class="glyphicon glyphicon-time"></span>Order History</a></li>
									</tr>


									<tr>
										<c:if test="${sessionScope.farmNum  == 1}">
											<li><a href="../Farms/EditFarm1"><span
													class="glyphicon glyphicon-cog"></span>Edit Your Farm1</a></li>
										</c:if>
									<tr>
									<tr>
										<c:if test="${sessionScope.farmNum  == 2}">
											<li><a href="../Farms/EditFarm2"><span
													class="glyphicon glyphicon-cog"></span>Edit Your Farm2</a></li>
										</c:if>
									<tr>
								</c:forEach>

								<li class="divider"></li>
								<li><a href="../chickenPages/Logout"><span
										class="glyphicon glyphicon-off"></span>Logout</a></li>
							</ul></li>

						<li><a href="../Farms/ShoppingCartController"><span
								class="glyphicon glyphicon-shopping-cart"></span>Cart</a></li>


					</ul>
				</div>
				<!-- /.navbar-collapse --> </nav>
			</div>
		</div>
	</div>


	<div align="center">
		<c:forEach items="${UserList}" var="entry">

			<h2>First name:</h2>
			<h3>${entry.first_name}</h3>
			<br>
			<h2>Last name:</h2>
			<h3>${entry.last_name}</h3>
			<br>
			<h2>Username:</h2>
			<h3>${entry.username}</h3>
			<br>
			<h2>Email:</h2>
			<h3>${entry.email}</h3>

		</c:forEach>
	</div>



</body>
</html>