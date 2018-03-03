<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Email User?</title>
</head>
<body>
	<form action="../Farms/MailDispatcher" method="POST">
		<table>
			<tr>
				<td align="right"><b>To: </b></td>
				<td><input type="text" name="email" size="75"></td>
			</tr>

			<tr>
				<td align="right"><b>Subject: </b></td>
				<td><input type="text" name="subject" size="75"></td>

			</tr>

			<tr>
				<td align="right"><b>Message: </b></td>
				<td><textarea name="message" cols="75" rows="6"></textarea></td>
			</tr>

			<tr>
				<td align="right"><b></b></td>
				<td><input type="submit" value="send"></td>
			</tr>




		</table>


	</form>


</body>
</html>