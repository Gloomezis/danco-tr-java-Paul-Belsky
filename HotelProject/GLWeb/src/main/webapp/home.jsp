<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
div.ex {
	text-align: right width:300px;
	padding: 10px;
	border: 5px solid grey;
	margin: 0px
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>
</head>
<body>

<h1>Comand menu</h1>
	<div class="ex">
			<table style="with: 50%">
				<tr>
					<td>Guest operations:</td>
					<td><a href='guest/guest.jsp'>Go</a></td>
				</tr>
				<tr>
					<td>Hotel room operations</td>
					<td><a href='hotelRoom/hotelRoom.jsp'>Go</a></td>
				</tr>
				<tr>
					<td>Service operations:</td>
					<td><a href='service/service.jsp'>Go</a></td>
				</tr>
				<tr>
					<td>Export/Import:</td>
					<td><a href='csv/exportImport.jsp'>Go</a></td>
				</tr>
			</table>
	</div>

</body>
</html>