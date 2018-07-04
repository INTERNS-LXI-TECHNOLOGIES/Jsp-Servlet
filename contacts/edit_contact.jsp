<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
	
		<form action="update" method="post">
			<p>Name</p>
			<input type="text" name="name" value="<c:out value="${contact.name}"/>"/>
			<p>Phone</p> 
			<input type="text" name="phone" value="<c:out value='${contact.phone}'/>"/>
			<input type="submit" value="UPDATE"/>
		</form>
	</body>
</html>
