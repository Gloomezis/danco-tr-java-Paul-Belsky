<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="theme/theme.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Service operations</title>
</head>
<body>
<h1>service room menu</h1>
	<div class="ex">
			<table style="with: 50%">
				<tr>
					<td>Create service:</td>
					<td><a href='createService.jsp'>Go</a></td>
				</tr>
				<tr>
					<td>Change price of service:</td>
					<td><a href='changePriceService.jsp'>Go</a></td>
				</tr>
				<tr>
					<td>Show price service and hotel room:</td>
					<td>
					<form action="ShowPriceServiceAndHotelRoom" method="get">
					<a href='result.jsp'>Go</a>
					</form>
					</td>
				</tr>
			</table>
	</div>

</body>
</html>