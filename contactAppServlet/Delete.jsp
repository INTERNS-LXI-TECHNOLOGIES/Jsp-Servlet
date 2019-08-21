<%@page import="com.lxisoft.contact.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
	<title>ContactApp</title>
</head>
<body>
	<h1>Delete</h1>
	<form action="delete" method="post">
	Which one you want to delete:<input type="text" name="name">
	<input type="submit" name="submit" value="Submit">	
	</form>
	<%
	// out.println(request.getParameter("name"));
	%>
	
</body>
</html>