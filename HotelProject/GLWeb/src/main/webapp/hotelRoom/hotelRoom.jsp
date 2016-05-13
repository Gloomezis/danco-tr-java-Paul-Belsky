<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="theme/theme.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel room operations</title>
</head>
<body>
	<h1>hotel room menu</h1>
	<div class="ex">
		<table style="with: 50%">
			<tr>
				<td>Create hotel room:</td>
				<td><a href='createHotelRoom.jsp'>Go</a></td>
			</tr>
			<tr>
				<td>Change price of hotel room:</td>
				<td><a href='changePriceOfHotelRoom.jsp'>Go</a></td>
			</tr>
			<tr>
				<td>Change status:</td>
				<td><a href='changeStatus.jsp'>Go</a></td>
			</tr>
			<tr>
				<td>Departure guest from hotel room:</td>
				<td><a href='departGuestFromHotelRoom.jsp'>Go</a></td>
			</tr>
			<tr>
				<td>Settle guest to hotel room:</td>
				<td><a href='settleGuestToHotelRoom.jsp'>Go</a></td>
			</tr>
			<tr>
				<td>Show all free rooms:</td>
				<td><a href='showAllFreeRooms.jsp'>Go</a></td>
			</tr>
			<tr>
				<td>Show all rooms:</td>
				<td><a href='showAllRooms.jsp'>Go</a></td>
			</tr>
			<tr>
				<td>Show detail of hotel room:</td>
				<td><a href='showDetailOfHotelRoom.jsp'>Go</a></td>
			</tr>

			<tr>
				<td>Show number of free hotel room:</td>
				<td><form action="ShowNumberOfFreeHotelRoom" method="get">
						<a href='result.jsp'>Go</a>
					</form></td>
			</tr>

		</table>
	</div>
</body>
</html>