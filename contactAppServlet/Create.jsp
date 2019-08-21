<%@page import="com.lxisoft.contact.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
	<title>ContactApp</title>
</head>
<body>
	<h1>Create</h1>
	<form action="create" method="post">
	Contact Name:<input type="text" name="name">
	Contact Number:<input type="text" name="num">
	<input type="submit" name="submit" value="Submit">	
	</form>
	<%
	// out.println(request.getParameter("name"));
	%>
	
</body>
</html>