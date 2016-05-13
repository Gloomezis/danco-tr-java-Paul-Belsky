<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
div.ex {
width: 300px; 
margin: 7px; 
border: 4px solid black; 
padding: 10px; 
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>

<body>
	<h1>Login Form</h1>
	<div class="ex">
		<form action="LoginController" method="post">
			<table style="with: 50%">
				<tr>
					<td>Full Name</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="password" /></td>
				</tr>
			</table>
			<input type="submit" value="login" /> <input type="reset"
				value="reset" />
		</form>
		<form action="registration.jsp">
			<input type="submit" value="register" />
		</form>
	</div>
</body>
</html>