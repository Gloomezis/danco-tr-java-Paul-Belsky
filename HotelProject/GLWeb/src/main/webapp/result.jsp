<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Hotel Administrator</h2>
	<div class="menu">
		<ul>
			<li><a href="home.jsp">Home</a></li>
		</ul>
	</div>
	<table>
		<thead>
			<tr>
				<th>Result</th>
			</tr>
		</thead>
		<tbody>
		<%
			String result=(String)request.getAttribute("results");
		   
		%>
			<tr>
				<td><%=result%>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>