<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add Contact</title>
	</head>
	
	<body>	
	
		<form action="update" method="post">
			<p>Name</p>
			<input type="text" name="name" value="<c:out value="${contact.name}"/>"/>
			<p>Phone</p> 
			<input type="text" name="phone" value="<c:out value='${contact.phone}'/>"/>
			<input type="submit" value="UPDATE"/>
		</form>
	</body>
</html>
