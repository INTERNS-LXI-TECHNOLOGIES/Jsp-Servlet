<html>
	<head>
		<title>used for add contacts</title>
		<link rel="stylesheet" type="text/css" href="them1.css">
		<%@  page import = "com.lxisoft.controller.*,java.util.*,com.lxisoft.model.*"%>
	</head>
	<style>
		body
		{
		background-color:green;
		}
	</style>
	<body>
	
	<div id="top">
	
		<h2 align="center"><i>Add Contact</i></h2></br>
		
	</div>

	<a href="Contacts.jsp"><img src="/Contactsv1.3/images/homeIcon.ico" height="50" width></a>
	<form action ="controller" method="post">
		Name   :<input type="text" name= "name"></br>
		Phone :<input type="text" name = "phone"></br></br>
	   <input align="left" type="submit"/><input type="reset"/>
	</form>
		
	</body>
	
</html>