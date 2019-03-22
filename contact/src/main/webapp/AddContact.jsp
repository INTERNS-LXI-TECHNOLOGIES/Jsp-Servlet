<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Add Contact</title>
</head>
<body>
	<form name = "addc" class = "cform" onsubmit="return validateForm()" action = "addcontact">
	<h1 class ="h1"> ContactApp</h1>
		<input class = "search" type="text" name="name" placeholder="Contact Name">
		
		<br>
		<br>
		<input class = "search" type="text" name="emailid" placeholder="Email ID">
		<br>
		<br>
		<input class = "search" type="text" name="number" placeholder="Phone Number">
		<br>
		<br>
		<button class = "addcb" type = "submit" title = "Add Contact">Add Contact</button>
	</form>
</body>
</html>