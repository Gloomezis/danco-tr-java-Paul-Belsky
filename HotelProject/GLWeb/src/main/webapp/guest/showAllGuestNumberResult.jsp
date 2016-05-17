<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>all guest number</title>
</head>
<body>
<h2>Hotel Administrator</h2>
	<div class="menu">
		<ul>
			<li><a href="home.jsp">Home</a></li>
		</ul>
	</div>
	<h2>Hotel Administrator</h2>
	<div class="menu">
		<ul>
			<li><a href="main/home.jsp">Home</a></li>
		</ul>
	</div>
	<table>
		<thead >
			<tr>
				<th>All guest number:</th>
			</tr>
		</thead>
		<tbody>
	<tr>
		<td><c:out value="${result}" /></td>
		<td></td>
	</tr>
	</table>
</body>
</html>