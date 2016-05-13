<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="theme/theme.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create hotel room</title>
</head>

<body>
<div class="ex">
	<form action="HotelRoomCRUD" method="post">
		<table style="with: 50%">
		
			<tr>
				<td>Hotel room number</td>
				<td><input type="text" name="number" /></td>
			</tr>
			<tr>
				<td>Room price</td>
				<td><input type="text" name="price" /></td>
			</tr>
			<tr>
				<td>Sleeping numbers</td>
				<td><input type="text" name="sNumber" /></td>
			</tr>
			<tr>
				<td>Star category</td>
				<td><input type="text" name="starCategory" /></td>
			</tr>
		</table>
		<p>
			<input type="submit" value="ok">
		</p>
	</form>
	</div>
</body>
</html>