<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping Cart</title>
</head>
<body>


	<div class="container">
		<div class="row">
			<div class="col-sm-12 col-md-10 col-md-offset-1">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Product</th>
							<th>Quantity</th>
							<th class="text-center">Price</th>
							<th class="text-center">Total</th>
							<th> </th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${productList}" var="entry">
							<%-- 
					    <td>${entry.name}</td>
					    <td>${entry.quantity}</td>
					    <td><c:out value="${entry.price}" escapeXml="true" /></td>
					<td>
				    	<a href="EditComment?id=${entry.id}">Edit</a> PUT THESE BELOW THE HFREF
				    	<a href = "DeleteComment?id=${entry.id}">Delete</a>
   						</td> --%>
							<tr>
								<td class="col-sm-8 col-md-6">
									<div class="media">
										<a class="thumbnail pull-left" href="#"> <img
											class="media-object"
											src="http://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/72/product-icon.png"
											style="width: 72px; height: 72px;">
										</a>
										<div class="media-body">
											<h4 class="media-heading">
												<a href="#"></a>
											</h4>
											<h5 class="media-heading">
												by <a href="#">${entry.name}</a>
											</h5>
											<span>Status: </span><span class="text-success"><strong>In
													Stock</strong></span>
										</div>
									</div>
								</td>
								<td class="col-sm-1 col-md-1" style="text-align: center"><input
									type="number" class="form-control" name="quantity"
									value="${entry.quantity}" min="0"></td>
								<td class="col-sm-1 col-md-1 text-center"><strong>${entry.price}</strong></td>
								<td class="col-sm-1 col-md-1 text-center"><strong>$${entry.totalPrice}</strong></td>
								<td class="col-sm-1 col-md-1">
									<form>
										<button type="button" class="btn btn-danger">
											<a href="DeleteEgg?id=${entry.id}">Delete </a>
											<!-- Works, now implement controller -->
										</button>
									</form>
								</td>
							</tr>

						</c:forEach>

						<tr>
							<td> </td>
							<td> </td>
							<td> </td>
							<td><h5>Subtotal</h5></td>
							<!-- HERE, ADD THE TOTAL OF ALL THE EGGS SELECTED, VIA FOREACH LOOP -->




							<td class="text-right"><h5>
									<strong>${sessionScope.totalSum}</strong>
								</h5></td>
						</tr>
						<tr>
							<td> </td>
							<td> </td>
							<td> </td>
							<td><h5>Estimated shipping</h5></td>
							<td class="text-right"><h5>
									<strong>$5.00</strong>
								</h5></td>
						</tr>
						<tr>
							<td> </td>
							<td> </td>
							<td> </td>
							<td><h3>Total</h3></td>
							<td class="text-right"><h3>
									<strong>${sessionScope.sumTax}</strong>
								</h3></td>
						</tr>



						<tr>
							<td></td>
							<td> </td>
							<td> </td>
							<td>
								<form>
									<button type="submit" class="btn btn-default"
										formaction="${sessionScope.previousURL}">
										<span class="glyphicon glyphicon-shopping-cart"></span>
										Continue Shopping
									</button>
								</form>
							</td>
							<td>
								<form>
									<button type="submit" class="btn btn-success"
										formaction="ShippingLabel">
										Checkout <span class="glyphicon glyphicon-play"></span>
									</button>
								</form>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<c:forEach items="${productList}" var="entry">
		<tr>
			<td>${entry.name}</td>
			<td>${entry.quantity}</td>
			<td><c:out value="${entry.price}" escapeXml="true" /></td>
			<%-- 					<td>
				    	<a href="EditComment?id=${entry.id}">Edit</a> PUT THESE BELOW THE HFREF
				    	<a href = "DeleteComment?id=${entry.id}">Delete</a>
   						</td> --%>

		</tr>
	</c:forEach>


	<%-- 	<form action="${sessionScope.previousURL}">
	  Go back
	  <input type="submit" value="Submit">
	</form>
	<br><br>

	<form action="ShippingLabel">
	  Go To Shipping label
	  <input type="submit" value="Submit">
	</form>
 --%>

</body>
</html>