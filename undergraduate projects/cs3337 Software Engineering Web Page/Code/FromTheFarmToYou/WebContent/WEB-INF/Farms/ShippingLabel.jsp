<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Shipping Information</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.credit-card-div  span {
	padding-top: 10px;
}

.credit-card-div img {
	padding-top: 30px;
}

.credit-card-div .small-font {
	font-size: 9px;
}

.credit-card-div .pad-adjust {
	padding-top: 10px;
}
</style>

</head>
<body>

	<div class="container">
		<center>
			<h2>Shipping Label</h2>
		</center>
		<!--   <hr>
  <p><H3>Enter Farmer Information</H3> GET FARMER INFO FROM DB
  <form class="form-horizontal" action="getLabel" method="post">
    
    <div class="form-group">
      <div class="col-sm-3"><label>First name</label><input type="text" class="form-control" placeholder="First name" name="firstName"></div>
      <div class="col-sm-3"><label>Last name</label><input type="text" class="form-control" placeholder="Last name" name="lastName"></div>
      <div class="col-sm-3"><label>Email</label><input type="email" class="form-control" placeholder="Email" name="email"></div>
    </div>
    
    
    <div class="form-group">
      <div class="col-sm-6"><label>Address</label><input type="text" class="form-control" placeholder="Address" name="address"></div>
      <div class="col-sm-3"><label>City</label><input type="text" class="form-control" placeholder="City" name="city"></div>
    </div>
   
   
    <div class="form-group">
      <div class="col-sm-3"><label>Zip/Postal Code</label><input type="text" class="form-control" placeholder="Zip/Postal code" name="zip"></div>
      <div class="col-sm-3"><label>Country</label><input type="text" class="form-control" placeholder="United States" value="United States" name="country"></div>
      <div class="col-sm-3"><label>State</label><input type="text" class="form-control" placeholder="State" name="state"></div>
    </div> -->

		<form class="form-horizontal" action="getLabel" method="post">
			<hr>
			<p>
			<H3>Enter Customer Information</H3>

			<div class="form-group">
				<div class="col-sm-3">
					<label>First name</label><input type="text" class="form-control"
						placeholder="First name" name="firstName">
				</div>
				<div class="col-sm-3">
					<label>Last name</label><input type="text" class="form-control"
						placeholder="Last name" name="lastName">
				</div>
				<div class="col-sm-3">
					<label>Email</label><input type="email" class="form-control"
						placeholder="Email" name="email">
				</div>
			</div>


			<div class="form-group">
				<div class="col-sm-6">
					<label>Address</label><input type="text" class="form-control"
						placeholder="Address" name="address">
				</div>
				<div class="col-sm-3">
					<label>City</label><input type="text" class="form-control"
						placeholder="City" name="city">
				</div>
			</div>


			<div class="form-group">
				<div class="col-sm-3">
					<label>Zip/Postal Code</label><input type="text"
						class="form-control" placeholder="Zip/Postal code" name="zip">
				</div>
				<div class="col-sm-3">
					<label>Country</label><input type="text" class="form-control"
						placeholder="United States" value="United States">
				</div>
				<div class="col-sm-3">
					<label>State</label><input type="text" class="form-control"
						placeholder="State" name="state">
				</div>
			</div>
			<hr>

			<!--     <p><H3>Enter Shipping Information</H3>
    
    <div class="form-group">
      <div class="col-sm-4"><label>Shipping Date</label><input type="date" class="form-control" placeholder="Shipping date" name="date"></div>
      
      <div class="col-sm-4"><label>Package Weight</label><input type="text" class="form-control" placeholder="Package weight" name="weight"></div>
    </div>
    <HR> -->
	</div>



	<div class="container">
		<div class="row">
			<div class="col-md-12 text-center">
				<!-- From bootsnipp http://bootsnipp.com/snippets/Qxlmm 
            <h2>Bootstrap Credit Card Form </h2>
            <h6>Based on original idea by  <a href="http://www.designbootstrap.com/">DesignBootstrap.com</a> </h6>
            <br /> -->
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="credit-card-div">
					<div class="panel panel-default">
						<div class="panel-heading">

							<div class="row">
								<div class="col-md-12 col-sm-12 col-xs-12">
									<h5 class="text-muted">Credit Card Number</h5>
								</div>
								<div class="col-md-3 col-sm-3 col-xs-3">
									<input type="text" class="form-control" placeholder="0000" />
								</div>
								<div class="col-md-3 col-sm-3 col-xs-3">
									<input type="text" class="form-control" placeholder="0000" />
								</div>
								<div class="col-md-3 col-sm-3 col-xs-3">
									<input type="text" class="form-control" placeholder="0000" />
								</div>
								<div class="col-md-3 col-sm-3 col-xs-3">
									<input type="text" class="form-control" placeholder="0000" />
								</div>
							</div>
							<div class="row ">
								<div class="col-md-3 col-sm-3 col-xs-3">
									<span class="help-block text-muted small-font"> Expiry
										Month</span> <input type="text" class="form-control" placeholder="MM" />
								</div>
								<div class="col-md-3 col-sm-3 col-xs-3">
									<span class="help-block text-muted small-font"> Expiry
										Year</span> <input type="text" class="form-control" placeholder="YY" />
								</div>
								<div class="col-md-3 col-sm-3 col-xs-3">
									<span class="help-block text-muted small-font"> CCV</span> <input
										type="text" class="form-control" placeholder="CCV" />
								</div>
								<div class="col-md-3 col-sm-3 col-xs-3">
									<img
										src="https://d30y9cdsu7xlg0.cloudfront.net/png/3994-200.png"
										height="75px" width="50px" class="img-rounded" />
								</div>
							</div>
							<div class="row ">
								<div class="col-md-12 pad-adjust">

									<input type="text" class="form-control"
										placeholder="Name On The Card" />
								</div>
							</div>
							<div class="row">
								<div class="col-md-12 pad-adjust"></div>
							</div>
							<div class="row "></div>

						</div>
					</div>
				</div>
				<!-- CREDIT CARD DIV END -->
			</div>
		</div>
	</div>
	<center>
		<input type="submit" value="Create Shipping Label">
	</center>
	</form>

</body>
</html>