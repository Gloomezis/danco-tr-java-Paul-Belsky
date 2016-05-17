
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success login</title>
</head>
<body>
<%
//allow access only if session exists
String user = null;
if(session.getAttribute("userLogin") == null){
    response.sendRedirect("/index.jsp");
}else user = (String) session.getAttribute("userLogin");
String userLogin = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
    if(cookie.getName().equals("user")) userLogin = cookie.getValue();
    if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
}
}
%>
	<h3>Hi <%=userLogin %>, Login successful. Your Session ID=<%=sessionID %></h3>
<br>
User=<%=user %>
<br>
<a href="checkoutPage.jsp">Checkout Page</a>
<form action="LogOut" method="post">
<input type="submit" value="Logout" >
</form>
</body>
</html>