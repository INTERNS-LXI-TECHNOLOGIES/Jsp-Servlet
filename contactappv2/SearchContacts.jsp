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
	<form action ="Add" method="post">
	
	<input type="text" placeholder="Search name" name= "searchName">
	
	<a href="DeleteServlet"><img src="/contactappv2/images/search1.png" height="20" width></a> <br><br>
	
	<a href="Home.jsp"><center><img src="/contactappv2/images/homeIcon.ico" height="70" width></a>
	
	</form>
</body>

</html>