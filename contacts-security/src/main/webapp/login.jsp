<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
	</head>
	
	<body>
		<form action="j_security_check" method="post">
			Enter your user name: <input type="text" name="j_username"/><br/>
			Enter your password: <input type="text" name="j_password"/>
		</form>
	</body>
</html>


