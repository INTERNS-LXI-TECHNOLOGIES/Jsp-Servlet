<html>
<!Security login page...>
<head><title>Login</title></head>
<style>
body{
	background-color :lightblue;
}

</style>
<body>
<font size='5' color = 'blue'>Please Login..</font><hr>
<form action = "j_security_check" method = "post">

<tr><td>Name:</td>
<td><input type = "text" name = "j_username"></td></tr>
<tr> <td>Password:</td>
<td><input type = "password" name = "j_password" size = '8'></td></tr>
<br>
<input type="submit" value = "Login">
</form></body>

</html>