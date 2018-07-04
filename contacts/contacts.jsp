<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Contacts</title>
	</head>
	
	<body>
		<table border="1" cellpadding="5" align="center">
		<tr>
			<th>Name</th>
			<th>Phone</th>
		</tr>	
		<c:forEach items="${contactList}" var="contact">
		<tr>
			<td> <c:out value="${contact.name}"/></td>
			<td><c:out value="${contact.phone}"/></td>
		</tr>
		</c:forEach>
	</table>
	</body>
</html>
