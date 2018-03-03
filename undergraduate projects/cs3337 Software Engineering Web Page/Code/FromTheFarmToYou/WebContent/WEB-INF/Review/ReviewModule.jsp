<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Review</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<link type="text/css" rel="stylesheet" href="../css/ReviewModuleCSS.css">
<script src="../css/script.js"></script>
</head>
<body>

	<div class="jumbotron" id="HeaderTop">
		<div align="center">
			<h1>Review</h1>
		</div>
		<p></p>
	</div>


	<div align="center">
		<div class="container">
			<div class="row main">
				<div class="main-login main-center">
					<form action="ReviewModule" method="Post" align="center">
						Enter your name <br> <input type="text" name="name"
							id="NameBoxID"><br>
						<br> Pick the farm you bought from<br> <input
							type="radio" name="farm" value="Dixon">Dixon<br> <input
							type="radio" name="farm" value="Hesperia">Hesperia<br>
						<input type="radio" name="farm" value="Westwick Rooke">Westwick
						Rooke<br>
						<br> Enter your review here<br>
						<textarea cols="50" id="TextBoxID" name="comment" rows="5"></textarea>
						<br>
						<br> <input type="submit" value="Submit"
							style="color: #005A31"> <br>
						<br>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>