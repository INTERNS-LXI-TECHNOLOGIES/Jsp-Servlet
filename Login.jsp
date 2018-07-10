<html>
<head>
<title>Login</title>
	<link rel="stylesheet" type="text/css" href="Sample.css">
</head>
<div id="add">
<h1>Login</h1>
<p align="left">


<style>
.button{
	background-color:blue;
	color:red;
}
.button:hover{
	background-color:grey;
}
</style>

</p>
<body>

 <form action = "j_security_check" method = "post">
 
<table >
<tr>
	<td>UserName:</td>
	<td><input type="text" "First Name" placeholder="userName" name="j_username"/></td>
	
</tr>
<tr>
	<td>Password:</td>
	<td><input type="password" placeholder="password" name="j_password"/></td>
	
</tr>

<tr align="center">
	<td colspan="2">
		<input align="center" type="submit" value="Submit" class="button" >
		<input  type="reset" value="Cancel" class="button" >
		
	</td>
</tr>  
</table>
</form>
</body>
</div>
<style>
	body
	{
		background-color:pink;
		
	}
	h1
	{
		color:White;
		text-align:center;
	}
	
	
</style>

	
</html>	