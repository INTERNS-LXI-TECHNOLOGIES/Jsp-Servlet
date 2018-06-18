<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Contacts</title>
	</head>
	
	<body>
		<%
			response.setHeader("Cache-Control", "no-cache, no-Store, must-revalidate");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Expires", "0");
			if(session.getAttribute("id")==null){
				response.sendRedirect("login.jsp");
			}
		%>	
	
		CONTACTS.JSP
	</body>
</html>
