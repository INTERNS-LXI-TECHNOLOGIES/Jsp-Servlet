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
/* CSS */
.buttonStyle {
  color: #FFF;
  background: #999;
  font-weight: bold;
  border: 1px solid #900;
}
 
.buttonStyle:hover {
  color: #FFF;
  background: #900;
}
	</style>
	

<%@  page import = "com.lxisoft.contactapp.web.*,com.lxisoft.contactapp.service.*,java.util.*,com.lxisoft.contactapp.model.*,javax.servlet.ServletException,javax.servlet.http.* "%>

<body>

	<h1 align="center"><i>Delete Contact</i></h1></br>
	<form action ="Delete" method="Get">

		Name:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text"  name= "deleteName"></br></br>
	<button type="submit">Delete</button><input type="reset" value="Cancel"/><br><br>

	</form>

<a href="Home.jsp"><center><img src="/contactappv2/images/homeIcon.ico" height="70" width></a>

</body>

</html>