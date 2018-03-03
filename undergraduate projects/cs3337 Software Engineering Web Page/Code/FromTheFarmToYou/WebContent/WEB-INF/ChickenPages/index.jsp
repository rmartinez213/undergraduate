<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Some of the design was snipped from bootsipp
	 More specifically - http://bootsnipp.com/snippets/MRlbB, http://bootsnipp.com/snippets/featured/admin-navigation
 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>From The Farm To You</title>

<!-- Custom css  -->
<link rel="stylesheet" href="../css/indexStyle.css">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Jquery cdn -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous">
</script>
<!-- Font by google -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<script>
</script>


</head>

<body>

	<!-- Nav bar below modified from bootsnip -->
	<!-- i class="material-icons">face</i><!-- Can delete this with no prob -->

	<div class="hold">
		<div class="container">


			<nav class="navbar navbar-default" role="navigation">
				<!-- Brand and toggle get grouped for better mobile display -->
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
						<li class="active"><a href="#"><span
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
								<li><a href="../Login/Signin">Login</a></li>

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
				<!-- /.navbar-collapse -->
			</nav>
		</div>



		<!-- Below code is modified from bootsnipp -->
		<div class="container">
			<div id="myCarousel" class="carousel slide" data-ride="carousel">

				<!-- Wrapper for slides -->
				<div class="carousel-inner">

					<div class="item active">
						<div
							style="height: 522px; width: 100%; background-size: contain; background-image: url(../images/HomePic.jpg); background-position: center; background-size: cover;">
						</div>
						<div class="carousel-caption">
							<h4>
								<a href="../Farms/FarmController">Farm 1 (Dixon Farm)</a>
							</h4>
							<p>
								This farm has white, brown, and omega eggs. This farm
								specializes in white eggs. <a class="label label-primary"
									href="../Farms/FarmController">Farm 1</a>
							</p>
						</div>
					</div>
					<!-- End Item -->

					<div class="item">
						<div
							style="height: 522px; width: 100%; background-size: contain; background-image: url(../images/Farm2HomePic1.jpeg); background-position: center; background-size: cover;">
						</div>
						<div class="carousel-caption">
							<h4>
								<a href="../Farms/Farm2Controller">Farm 2 (Hesperia Farm)</a>
							</h4>
							<p>
								A family owned farm, that guarantees the freshness of their
								eggs. Caring about their livestock and customers, this farm
								offers a variety of eggs. Check them out here! <a
									class="label label-primary" href="../Farms/Farm2Controller">Farm
									2</a>
							</p>
						</div>
					</div>
					<!-- End Item -->

					<div class="item">
						<img src="../images/Farm3HomePic1.jpg">
						<div class="carousel-caption">
							<h4>
								<a href="../Farms/Farm3Controller">Farm 3 (Westwick Rooke
									Farm)</a>
							</h4>
							<p>
								After the battling and triumphing the recession, this family
								owned farm has grown together. This farm treats its chickens as
								part of the family. Check out the hens here, and maybe the
								owners! <a class="label label-primary"
									href="../Farms/Farm3Controller">Farm3</a>
							</p>
						</div>
					</div>
					<!-- End Item -->


				</div>
				<!-- End Carousel Inner -->


				<ul class="list-group col-sm-4">
					<li data-target="#myCarousel" data-slide-to="0"
						class="list-group-item"><h4>Farm 1 (Dixon Farm)</h4></li>
					<li data-target="#myCarousel" data-slide-to="1"
						class="list-group-item"><h4>Farm 2 (Hesperia Farm)</h4></li>
					<li data-target="#myCarousel" data-slide-to="2"
						class="list-group-item"><h4>Farm 3 (Westwick Rooke Farm)</h4></li>

				</ul>

				<!-- Controls -->
				<div class="carousel-controls">
					<a class="left carousel-control" href="#myCarousel"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span>
					</a> <a class="right carousel-control" href="#myCarousel"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span>
					</a>
				</div>


			</div>
			<!-- End Carousel -->
		</div>
	</div>


	<section id="sec">
		<div class="container">
			<div class="row">

				<div class="col-md-4">
					<!-- Bottom of page, includes webcam, and truck icon -->
					<div class="center-block">
						<div class="textOverImage"
							style="background-image: url('https://olimex.files.wordpress.com/2013/03/webcam.png')"
							data-text="Webcams
We offer a webcams for all the farms we partner with. 
You will see the hens in their home and view their lifestyle, 24/7.">
						</div>
					</div>
				</div>


				<div class="col-md-4">
					<div class="center-block">
						<div class="textOverImage"
							style="background-image: url(../images/chickenResize.png)"
							data-text="Natural
	Since the webcams are available for all farms, this ensures that all the chickens are cage free.
	">
						</div>
					</div>
				</div>


				<div class="col-md-4">
					<div class="center-block">
						<div class="textOverImage"
							style="background-image: url(../images/truckicon.png)"
							data-text="Shipping
Offering overnight shipping we guarantee that the eggs will be fresh upon arrival. ">
						</div>
					</div>
				</div>

			</div>
		</div>
</body>
</html>