<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LOGIN</title>
</head>
	<style>
	.bgbody {
	
	position: absolute;
  	top: 25%;
  	left: 35%;
  	border: 2px solid grey;
	border-radius: 50px;
	width: 270px;
	height : 300px;
	padding: 20px 45px;
	
}
	input {
	border-radius: 40px;
	text-align: center;
	cursor :text;
	padding: 10px 45px;
	border: 2px solid grey;
	
}

.loginbutton {
	background: linear-gradient(21deg, #10abff, #1beabd);
	color : white;
	border: 2px solid grey;
	border-radius: 40px;
	text-align: center;
	cursor :pointer;
	width: 96%;
	height : 40px;
	font-weight:bold;
}
h1{
	color: white;
	font-family:arial;
	border: 2px solid grey;
	text-align: center;
	background-color: grey;
	border-radius: 50px;
	background: linear-gradient(21deg, #10abff, #1beabd);
  	width: 96%;
}
</style>

	<!--<link rel="stylesheet" type="text/css" href="style.css"/>-->
	<body class="bgbody">
	
		<h1>&nbsp; &nbsp; &nbsp;ContactApp</h1>
		<div>
		<form action = "j_security_check" method = "post">
		<input type="text" name = "j_username" placeholder="Username" required>	
		<br>
		<br>
		<input type="password" name = "j_password" placeholder="Password" required>	
		<br>
		<br>
		<button class = "loginbutton" type="submit" name="action" value="login">Login</button> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		
		</form>
		</div>
	</body>
</html>