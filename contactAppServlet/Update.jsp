<%@page import="com.lxisoft.contact.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
	<title>ContactApp</title>
</head>
<body>
	<h1>Update</h1>
	<form action="update" method="post">
	Which one you want to edit:<input type="text" name="name">
	New name:<input type="text" name="nname">
	<input type="submit" name="submit" value="Submit">	
	</form>
	<%
	//out.println(request.getParameter("a"));
	 out.println(request.getParameter("name"));
	if(session!=null)
	{
		if(session.getAttribute("value")!=null)
		{
			int value=(int)session.getAttribute("value");
			out.println("<br>"+value);
		}
	}
	%>
	<a href="index.jsp">back to home</a>
</body>
</html>