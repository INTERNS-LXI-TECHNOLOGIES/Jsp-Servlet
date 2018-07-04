<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add Contact</title>
	</head>
	
	<body>
		<%
			response.setHeader("Cache-Control", "no-cache, no-Store, must-revalidate");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Expires", "0");
			if(session.getAttribute("userId")==null){
				response.sendRedirect("login.jsp");
			}
		%>	
		<form action="logout" method="post">
			<input type="submit" value="LOGOUT"/>
		</form>
		<form action="create" method="post">
			<p>Name</p>
			<input type="text" name="name" />
			<p>Phone</p> 
			<input type="text" name="phone" />
			<input type="submit" value="SAVE"/>
		</form>
	</body>
</html>
