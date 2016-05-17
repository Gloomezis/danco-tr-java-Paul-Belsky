<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Success Page</title>
</head>
<body>
<%
//allow access only if session exists
if(session.getAttribute("userLogin") == null){
  response.sendRedirect("index.jsp");
}
String userLogin = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
  if(cookie.getName().equals("user")) userLogin = cookie.getValue();
}
}
%>
<h3>Hi <%=userLogin %>, do the checkout.</h3>
<br>
<form action="LogOut" method="post">
<input type="submit" value="Logout" >
</form>
</body>
</html>