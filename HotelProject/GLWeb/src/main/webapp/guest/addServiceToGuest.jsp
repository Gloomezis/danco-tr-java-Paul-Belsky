<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="theme/theme.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add service to guest</title>
</head>
<body>
<h1>Form</h1>
	<div class="ex">
		<form action="AddServiceToGuest" method="post">
			<table style="with: 50%">
				<tr>
					<td>Guest id</td>
					<td><input type="text" name="guestId" /></td>
				</tr>
				<tr>
					<td>Service id</td>
					<td><input type="text" name="serviceId" /></td>
				</tr>
			</table>
			<input type="submit" value="confirm" /> 
			<input type="reset" value="reset" />
		</form>
	</div>
</body>
</html>