<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Westwick Rooke Farm</title>
<link type="text/css" rel="stylesheet"
	href="../ChickenPages/FarmersTemplate/FarmersTemplate3Css.css">
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

	<header id="cartNum">
	<div class="nav">

		<!-- NavBar -->
		<ul class="main-nav-bar">
			<li><a href="#">User</a></li>
			<li><a href="#OurService">Our Service</a></li>
			<li><a href="#Webcam">Webcam</a></li>
			<li><a href="#Products">Products</a></li>
			<li><a href="#Reviews">Reviews</a></li>
			<li><a href="/cart"><i class="fa fa-2x fa-shopping-cart"></i></a>
				<label id="cart-badge" class="badge badge-warning"><font
					id="num">0</font></label></li>
		</ul>
	</div>

	<!--Displays Page Welcome-->
	<div class="Header">
		<h1>
			Welcome to,<br>Westwick Rooke Farm
		</h1>
	</div>
	</header>


	<!-- Our Service Portion -->
	<section class="OurService" id="OurService">
	<h3 class="text-center">Our Service</h3>

	<p class="ServiceText">We are new farm that was established in
		2014. After the recession we slowly began building a farm and buying
		cattle and as well as live stock. We slowly progressed through the
		years and eventually bought machinery so we can provide and sell wheat
		to locals in the area. Upon last year, we had exchanged some goods for
		hens. Eventually our hen live stock has increased significantly where
		to the point we had too many eggs! We want to give back to the
		community that helped us grow as a farm, so here we are selling you
		the best quality eggs to you!</p>

	<!-- The "<div class="col-md-3">" contains each individual section Our Service column -->
	<div class="container">
		<div class="row">

			<div class="col-md-3">
				<span class="glyphicon glyphicon-cutlery"></span>
				<h4>Organic Eggs</h4>
				<p class="arranging">The hens are provided the most comfortable
					living, which means that we treat our hens just like family. They
					eat organically and are caged free. These eggs are unpasteurized as
					well. Forget eating GMO eggs and enjoy the organic taste of eggs.</p>
			</div>

			<div class="col-md-3">
				<span class="glyphicon glyphicon-usd"></span> <br>
				<h4>Affordable</h4>
				<p class="arranging">As a farm that wants to give back to the
					community, we are dedicated to providing the lowest price possible
					for the communities around us. We are willing to give the community
					the opportunity to enjoy the eggs with the low price!</p>
			</div>

			<div class="col-md-3">
				<span class="glyphicon glyphicon-certificate"></span>
				<h4>Fresh Quality</h4>
				<p class="arranging">We are here to serve you! We want the best
					quality eggs leaving our farm. All of our hens have been raised
					through organic methods. Our goal is to have you taste the fresh
					premium quality eggs that leave you wanting more.</p>
			</div>

			<div class="col-md-3">
				<span class="glyphicon glyphicon-thumbs-up"></span>
				<h4>Satisfied Customers</h4>
				<p class="arranging">We have satisfied the locals from around
					our farm and we are continuing our best to expand and deliver some
					of the best premium quality eggs to other cities around us!</p>
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

			<!-- Each indivudual product picture and product info and product name -->
			<div class="col-md-6">
				<img src="../ChickenPages/FarmersTemplate/img/BrownEgg3.jpg"
					align="center">
				<h4 class="text-center">Brown Eggs</h4>
				<p class="text-center">These eggs contain the highest quality
					protein you can buy. Egg yolks are one of the few foods that are
					naturally good source of vitamin D, especially the brown eggs (get
					this one). We ensure that the brown egg will be straight from the
					hen and deliver the best food source.</p>
				<div align="center">
					<button type="button" class="btn btn-primary" id="countnum1">
						<span class="glyphicon glyphicon-shopping-cart"></span>Add to cart
					</button>
				</div>
			</div>

			<div class="col-md-6">
				<img src="../ChickenPages/FarmersTemplate/img/WhiteEgg3.jpg"
					align="center">
				<h4 class="text-center">White Eggs</h4>
				The hens have been producing so many eggs recently that we have been
				selling eggs at a cheaper price, so that you the customers can enjoy
				a few great eggs for breakfast. If you are ever in need of white
				eggs, don't hesitate to come to us for this low price bargain!
				<p class="text-center"></p>
				<div align="center">
					<button type="button" class="btn btn-primary" id="countnum2">
						<span class="glyphicon glyphicon-shopping-cart"></span>Add to cart
					</button>
				</div>
			</div>

		</div>
	</div>

	</section>

	<section class="Reviews" id="Reviews">

	<h3 class="text-center">See what our customers are saying</h3>

	<div class="container">
		<div class="row">

			<div class="col-md-6">
				<blockquote>
					<p>"The eggs are delicious and the packaging was so nice! It
						seems like they farmers care about the products and how they
						arrive to your home. I give them a thumbs up for keeping it
						simple." - Murdock Kwang</p>
				</blockquote>
			</div>

			<div class="col-md-6">
				<blockquote>
					<p>"Me and my wife have supported these local farmers since
						2014. Everyday we see them in the field working hard to achieve a
						new level of success and spirit!" - The Molera Family</p>
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
