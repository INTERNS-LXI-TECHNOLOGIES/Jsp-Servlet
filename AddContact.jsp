<html>
<head>
<title>Add Contact</title>
	<link rel="stylesheet" type="text/css" href="Sample.css">
</head>
<div id="add">
<h1>Add Contacts</h1>
<p align="left">
<a href="Contact.jsp"><img src="/ContactsApp/images/homePic.jpg" width="50" height="50"></a></br></br>

<style>
.button{
	background-color:cornflowerblue;
	color:white;
}
.button:hover{
	background-color:green;
}
</style>

</p>
<body>

 <form action  ="NewContact.jsp" method = "post">
 
<table >
<tr>
	<td>Name:</td>
	<td><input type="text" "First Name" placeholder="name" name="name"/></td>
	
</tr>
<tr>
	<td>Phone:</td>
	<td><input type="text" placeholder="phone" name="phone"/></td>
	
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
		background-color:skyblue;
		
	}
	h1
	{
		color:White;
		text-align:center;
	}
	
	
</style>

	
</html>	