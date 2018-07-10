<html>
<!--contacts app-->

<head>
	<title>Home</title>
	<%@ page import="com.lxisoft.controller.*,java.util.*,com.lxisoft.model.*,java.sql.*"%>
</head>
<style>
	body
	{ 
		background-color:lightblue;
	}
	h1
	{
		color:White;
		text-align:center;
	}
	
	
</style>

<body>
<div id="top">
<h1>Contacts</h1>
<p align="center">
<img src="/ContactsApp/images/contact.jpg" width="140" height="150"></br></br></br></br>
</p>
<link rel="stylesheet" type="text/css" href="Sample.css"/>
</div>


	<a href="AddContact.jsp"><img src="/ContactsApp/images/addContacts.jpg" width="50" height="50" title=addContact></a></br></br>
	
	

<form action="search" method="get">
<input type="text" name="name" placeholder="search here">
<input type="submit" value="go"></br>
</form>


<form action="processing" method ="get">
<input type="submit" value="showAllContacts" >
</form>

<div id="contact">

		

	
	
				
</div>
</body>
</html>