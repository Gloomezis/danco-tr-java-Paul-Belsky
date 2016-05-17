<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="theme/theme.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create service</title>
</head>
<body>
<div class="ex">
	<form action="ServiceCRUD" method="post">
		<table style="with: 50%">
			<tr>
				<td>Order id</td>
				<td><input type="text" name="orderId" /></td>
			</tr>
			<tr>
				<td>Service name</td>
				<td><input type="text" name="serviceName" /></td>
			</tr>
			<tr>
				<td>Service price</td>
				<td><input type="text" name="servicePrice" /></td>
			</tr>
		</table>
		<p>
			<input type="submit" value="ok">
		</p>
	</form>
	</div>
</body>
</html>