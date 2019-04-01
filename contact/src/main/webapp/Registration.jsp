<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
<body class="bgbody">
	
		<h1>&nbsp; &nbsp; &nbsp;ContactApp</h1>
		<div>
		<form action = "login" method = "post">
		<input type="text" name = "username" placeholder="Username" required>	
		<br>
		<br>
		<input type="password" name = "password" placeholder="Password" required>	
		<br>
		<br>
		<button class = "loginbutton" type="submit">Register</button> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		
		</form>
		<form action = "logout" >
		<button class = "loginbutton" type="submit">Cancel</button>

</form>
		</div>
	</body>
</body>
</html>