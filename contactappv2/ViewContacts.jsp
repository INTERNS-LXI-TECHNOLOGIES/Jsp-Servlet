<!DOCTYPE html>
<html>
<head>
<title> Add Contact </title>
</head>
	<style>
		body
			{
			background-color:cyan;
			}
	</style>	

<%@  page import = "com.lxisoft.contactapp.web.*,java.util.*,com.lxisoft.contactapp.model.*,javax.servlet.ServletException,javax.servlet.http.* "%>

<body>
	<h1 align="center"><i>Contacts</i></h1></br>
	<form action ="Add" method="post">
	<% 
	Object rs=session.getAttribute("contactList");
	out.println(rs);
	%>
	
	</form>
</body>

</html>