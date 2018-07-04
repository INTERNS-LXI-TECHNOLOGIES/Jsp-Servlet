<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>My Contact</title>
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
		<table border="1" cellpadding="5" width="500">
			<tr>
				<th>Name</th>
				<td>
					<c:out value="${contact.name}"/>
				</td>
			</tr>
			<tr>
				<th>Phone</th>
				<td>
					<c:out value='${contact.phone}'/>
				</td>
			</tr>
		</table>
		<form action="edit" method="post">
			<input type="submit" value="EDIT"/>
		</form>
		<form action="delete" method="post">
			<input type="submit" value="DELETE"/>
		</form>
	</body>
</html>