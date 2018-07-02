<html>
<!..addContact..>
<head>
<title>New Contact</title>
<link rel="stylesheet" type ="text/css" href = "sample.css"/>
</head>

<style>
.button
{
	background-color:cornflowerBlue;
	color:white;
	border:none;
	padding:10px 15px;
	text-align:center;
	font-size:15px;
	
}
.button:hover
{
	background-color:green;
}
#test
{
	background-color:SlateBlue;
}
body
{
	background-color:green;
}

</style>

<body>
<div id = "image">
<h1 background = "red">Add Contact<h1/>
<img src = "images/add1.jpg" alt = "Add contacts" width="150px"/>
</div>
<div id = "">

<div id = "test" align = "center">
<form action= "ContactsAppServlet" method = "post">
<table>
<tr>
	<td>
		<label for  = "Name">Name:</label>
	</td>
	<td>
		<input name = "Name" type = "text"/>
	</td>
</tr>
<tr>
	<td>
		<label for = "Place">Place:</label>
	</td>
	<td>
		<input name = "Place" type = "text"/>
	</td>
</tr>
<tr>
	<td>
		<label for = "Phn_no">Phone Number:</label>
	</td>
	<td>
		<input name = "Phn_no" type = "text"/>
	</td>
</tr>
<tr>
	<td>
		<label for = "email">Email:</label>
	</td>
	<td>
		<input name = "Email" type = "text"/>
	</td>
	
	</tr>
	
</table>


</br>	
	<input type = "submit" class = "button" name = "submit" value= "submit" />
	<input type = "reset" class = "button" name = "cancel" value ="Cancel">
	

</form>
</div>


</body>
</html>