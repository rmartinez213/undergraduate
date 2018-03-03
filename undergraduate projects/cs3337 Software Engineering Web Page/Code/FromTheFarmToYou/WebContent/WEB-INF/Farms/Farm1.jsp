<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dixon Farm</title>
<link type="text/css" rel="stylesheet"
	href="../ChickenPages/FarmersTemplate/FarmersTemplateCss.css">
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
	<sql:setDataSource var="farmedit" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost/cs3220stu76" user="cs3220stu76"
		password="abcd" />

	<sql:query dataSource="${farmedit}" var="result">SELECT * from farmerInfo WHERE id = 1; </sql:query>
	<sql:query dataSource="${farmedit}" var="egg1">SELECT * from inventory WHERE id = 1; </sql:query>
	<sql:query dataSource="${farmedit}" var="egg2">SELECT * from inventory WHERE id = 2; </sql:query>
	<sql:query dataSource="${farmedit}" var="egg3">SELECT * from inventory WHERE id = 3; </sql:query>
	<sql:query dataSource="${farmedit}" var="egg4">SELECT * from inventory WHERE id = 4;</sql:query>




	<header id="cartNum">
	<div class="nav">
		<!-- NavBar -->
		<ul class="main-nav-bar">
			<li><a href="../ChickenPages/index">Home</a></li>
			<li><a href="#OurService">Our Service</a></li>
			<li><a href="#Webcam">Webcam</a></li>
			<li><a href="#Products">Products</a></li>
			<li><a href="#Reviews">Reviews</a></li>
			<li><a href="../Farms/ShoppingCartController"><i
					class="fa fa-2x fa-shopping-cart"></i></a> <label id="cart-badge"
				class="badge badge-warning"><font id="num">0</font></label></li>
		</ul>
	</div>

	<!--Displays Page Welcome-->
	<div class="Header">
		<h1>
			<c:forEach var="row" items="${result.rows}">
					${row.h1_header}
				</c:forEach>
		</h1>
		<h href=""></h>
	</div>
	</header>


	<!-- Our Service Portion -->
	<section class="OurService" id="OurService">
	<h3 class="text-center">Our Service</h3>

	<p class="ServiceText">
		<c:forEach var="row" items="${result.rows}">
				${row.service_text}
			</c:forEach>
	</p>

	<!-- The "<div class="col-md-3">" contains each individual section Our Service column -->
	<div class="container">
		<div class="row">

			<div class="col-md-3">
				<span class="glyphicon glyphicon-heart-empty"></span>
				<h4>
					<c:forEach var="row" items="${result.rows}">
							${row.first_h4}
						</c:forEach>
				</h4>
				<p class="arranging">
					<c:forEach var="row" items="${result.rows}">
							${row.arranging_text}
						</c:forEach>
				</p>
			</div>

			<div class="col-md-3">
				<span class="glyphicon glyphicon-certificate"></span> <br>
				<h4>
					<c:forEach var="row" items="${result.rows}">
						${row.second_h4}
						</c:forEach>
				</h4>
				<p class="arranging">
					<c:forEach var="row" items="${result.rows}">
							${row.arranging2_text}<br>
					</c:forEach>
				</p>
			</div>

			<div class="col-md-3">
				<span class="glyphicon glyphicon-grain"></span>
				<h4>
					<c:forEach var="row" items="${result.rows}">
						${row.third_h4}
						</c:forEach>
				</h4>
				<p class="arranging">
					<c:forEach var="row" items="${result.rows}">
							${row.arranging3_text}<br>
					</c:forEach>
				</p>
			</div>

			<div class="col-md-3">
				<span class="glyphicon glyphicon-road"></span>
				<h4>
					<c:forEach var="row" items="${result.rows}">
						${row.fourth_h4}
						</c:forEach>
				</h4>
				<p class="arranging">
					<c:forEach var="row" items="${result.rows}">
							${row.arranging4_text}<br>
					</c:forEach>
				</p>
			</div>
		</div>
	</div>

	</section>


	<!-- Webcam Potion -->
	<section class="webcam" id="Webcam">
	<h3 class="text-center">
		<a href="http://172.91.8.97:81" target="_blank">Live Webcam </a>
	</h3>

	<div align="center">
		<iframe width="853" height="480" src="http://172.91.8.97:81"
			frameborder="0" allowfullscreen></iframe>
	</div>
	</section>


	<!-- Products -->
	<section class="Products">

	<h3 class="text-center" id="Products">Products</h3>


	<div class="container">
		<div class="row">

			<!--  Start of egg 1  -->
			<div class="col-md-3">
				<img src="../ChickenPages/FarmersTemplate/img/WhiteEgg1.png"
					align="center">
				<h4 class="text-center">
					<c:forEach var="row" items="${egg1.rows}">
							${row.name} <br>
					</c:forEach>
				</h4>

				<p class="text-center">
					<c:forEach var="row" items="${egg1.rows}">
							${row.description}<br>
						<h4>
							<span class="label label-default">${row.price}</span>
						</h4>

						<form action="ShoppingCartController" method="POST">
							<div align="center">
								<input type="number" name="quantity" min="0"
									max="${row.quantity}" value="0">
								<button type="submit" class="btn btn-primary" id="countnum1"
									formaction="ShoppingCartController">
									<span class="glyphicon glyphicon-shopping-cart"></span>Add to
									cart
								</button>
							</div>
							<input type="hidden" name="name" value="${row.name}"> <input
								type="hidden" name="price" value="${row.price}"> <input
								type="hidden" name="id" value="${row.id}">

						</form>
					</c:forEach>
				</p>
			</div>



			<!--  Start of egg 2  -->
			<div class="col-md-3">
				<img src="../ChickenPages/FarmersTemplate/img/BrownEgg1.jpg"
					align="center">
				<h4 class="text-center">
					<c:forEach var="row" items="${egg2.rows}">
							${row.name} <br>
					</c:forEach>
				</h4>

				<p class="text-center">
					<c:forEach var="row" items="${egg2.rows}">
							${row.description}<br>
						<h4>
							<span class="label label-default">${row.price}</span>
						</h4>

						<form action="ShoppingCartController" method="POST">
							<div align="center">
								<input type="number" name="quantity" min="0"
									max="${row.quantity}" value="0">
								<button type="submit" class="btn btn-primary" id="countnum2"
									formaction="ShoppingCartController">
									<span class="glyphicon glyphicon-shopping-cart"></span>Add to
									cart
								</button>
							</div>
							<input type="hidden" name="name" value="${row.name}"> <input
								type="hidden" name="price" value="${row.price}"> <input
								type="hidden" name="id" value="${row.id}">
						</form>
					</c:forEach>
				</p>
			</div>



			<!-- Start of Egg 3 -->
			<div class="col-md-3">
				<img src="../ChickenPages/FarmersTemplate/img/Omega1.jpg"
					align="center">
				<h4 class="text-center">
					<c:forEach var="row" items="${egg3.rows}">
							${row.name} <br>
					</c:forEach>
				</h4>

				<p class="text-center">
					<c:forEach var="row" items="${egg3.rows}">
							${row.description}<br>
						<h4>
							<span class="label label-default">${row.price}</span>
						</h4>

						<form action="ShoppingCartController" method="POST">
							<div align="center">
								<input type="number" name="quantity" min="0"
									max="${row.quantity}" value="0">
								<button type="submit" class="btn btn-primary" id="countnum3"
									formaction="ShoppingCartController">
									<span class="glyphicon glyphicon-shopping-cart"></span>Add to
									cart
								</button>
							</div>
							<input type="hidden" name="name" value="${row.name}"> <input
								type="hidden" name="price" value="${row.price}"> <input
								type="hidden" name="id" value="${row.id}">
						</form>

						<!-- ENCLOSE EVERYTHING UNDER A FORM, THAT WAY U CAN GET MULTIPLE QUANTITY, NAME, AND PRICE. ENCLOSE SINCE TOP TO BOTTOM -->
					</c:forEach>
				</p>

			</div>



			<!--  Start of egg 4  -->
			<div class="col-md-3">
				<img src="../ChickenPages/FarmersTemplate/img/FreeRange1.png"
					align="center">
				<h4 class="text-center">
					<c:forEach var="row" items="${egg4.rows}">
							${row.name} <br>
					</c:forEach>
				</h4>

				<p class="text-center">
					<c:forEach var="row" items="${egg4.rows}">
							${row.description}<br>
						<h4>
							<span class="label label-default">${row.price}</span>
						</h4>

						<form action="ShoppingCartController" method="POST">
							<div align="center">
								<input type="number" name="quantity" min="0"
									max="${row.quantity}" value="0">
								<button type="submit" class="btn btn-primary" id="countnum4"
									formaction="ShoppingCartController">
									<span class="glyphicon glyphicon-shopping-cart"></span>Add to
									cart
								</button>
							</div>
							<input type="hidden" name="name" value="${row.name}"> <input
								type="hidden" name="price" value="${row.price}"> <input
								type="hidden" name="id" value="${row.id}">
						</form>
					</c:forEach>
				</p>
			</div>

		</div>
	</div>

	</section>


	<section class="Reviews" id="Reviews">

	<h3 class="text-center">See what our customers are saying</h3>

	<div class="container">
		<div class="row">

			<div class="col-md-4">
				<blockquote>
					<p>"The eggs arrived on time and it was delicately handled by
						the farmers." - Jill Valentine</p>
				</blockquote>
			</div>

			<div class="col-md-4">
				<blockquote>
					<p>"The website was easy to use and my eggs came in with
						hours!" - Bob Renolds</p>
				</blockquote>
			</div>

			<div class="col-md-4">
				<blockquote>
					<p>"I really recommend there premium white egg, because of how
						fresh it was!" - Amanda Winchester</p>
				</blockquote>
			</div>

		</div>
	</div>
	</section>

	<!-- 
    <section>
        <iframe src="https://www.google.com/maps/embed?pb=!1m10!1m8!1m3!1d13209.27002674189!2d-118.05343232575291!3d34.13821819134137!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sen!2sus!4v1492009553375" width="100%" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
    </section>
-->

</body>
</html>