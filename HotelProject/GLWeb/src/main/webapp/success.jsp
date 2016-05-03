 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display</title>
<style>
table#nat{
	width: 50%;
	background-color: #c48ec5;
}
</style>
</head>
<body>  
Registration is Successful.
<% String name =  request.getParameter("name");
	String mail = request.getParameter("email");
	String pass = request.getParameter("password");%>
	 
<table id ="nat">
<tr>
	<td>Full Name</td>
	<td><%= name %></td>
</tr>
<tr>
	<td>Email</td>
	<td><%= mail %></td>
</tr>
<tr>
	<td>Password</td>
	<td><%= pass %></td>
</tr>
</table>

Please Login Here <a href='index.jsp'>Go to Login</a>
</body>
</html>