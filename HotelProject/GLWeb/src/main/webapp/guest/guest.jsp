<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="theme/theme.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guest operations</title>
</head>
<body>
<h1>guest menu</h1>
	<div class="ex">
			<table style="with: 50%">
				<tr>
					<td>Create guest:</td>
					<td><a href='createGuest.jsp'>Go</a></td>
				</tr>
				<tr>
					<td>Add service to guest:</td>
					<td><a href='addServiceToGuest.jsp'>Go</a></td>
				</tr>
				<tr>
					<td>Show all guest:</td>
					<td><a href='showAllGuest.jsp'>Go</a></td>
				</tr>
				<tr>
					<td>Show list of guest services:</td>
					<td><a href='showListServiceGuest.jsp'>Go</a></td>
				</tr>
				<tr>
					<td>Show summ to paid:</td>
					<td><a href='showSummToPaid.jsp'>Go</a></td>
				</tr>
				<tr>
					<td>Show all guest number:</td>
					<td><form action="ShowAllGuestNumber" method="get">
					<input type="button" value="Guest number">
					</form></td>
				</tr>
			</table>
	</div>
</body>
</html>