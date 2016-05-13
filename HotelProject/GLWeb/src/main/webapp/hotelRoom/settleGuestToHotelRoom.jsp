<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>







<script>
	$(function() {
		$(".datepicker").datepicker();
	});
</script>




<link rel="stylesheet" href="theme/theme.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Settle guest to hotel room</title>
</head>
<body>
	<div class="ex">
		<form action="SettleGuestToHotelRoom" method="post">
			<table style="with: 50%">
				<tr>
					<td>Guest room id</td>
					<td><input type="text" name="guestId" /></td>
				</tr>
				<tr>
					<td>Hotel room id</td>
					<td><input type="text" name="hotelRoomId" /></td>
				</tr>
				<tr>
					<td>Date arrive</td>
					<td><input type="text" class="datepicker" name="dArrive" /></td>
				</tr>
				<tr>
					<td>Date departure</td>

					<td><input type="text" class="datepicker" name="dDeparture"/></td>
				</tr>
			</table>
			<p>
				<input type="submit" value="ok">
			</p>
		</form>
	</div>

</body>
</html>