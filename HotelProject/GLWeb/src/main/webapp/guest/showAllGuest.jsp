<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="theme/theme.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show all guest</title>
</head>
<body>
<h1>Form</h1>
<div class="ex">
<form action="ShowAllGuest" method="get">
   <p><select   name="sortCondition">
    <option disabled>Select sort condition</option>
    <option selected value="name">name</option>
    <option value="id">id</option>
   </select></p>
   <p><input type="submit" value="ok"></p>
  </form>
  </div>
</body>
</html>