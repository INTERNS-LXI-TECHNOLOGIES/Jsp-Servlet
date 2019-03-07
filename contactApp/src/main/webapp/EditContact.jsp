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

	<h1><i>Edit Contact</i></h1></br>
	<form action ="GetAll" method="Get">
	
	Name:<input type="text"  name= "editName"></br></br>
	<button class="buttonStyle" type="submit">Edit</button><br><br>
	
		   	<% 
			
	Object rs=null;
	
	rs=session.getAttribute("result");
	if(rs=="update")
	{%>
		<b><% out.println("Updated Successfully");%></b>
	
	<%}
	session.setAttribute("result",null);
	%>
	<a href="Home.jsp"><img src="/contactappv3/images/homeIcon.ico" height="30" width></a>
	</form>
</body>

</html>