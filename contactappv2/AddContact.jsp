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

	<h1 align="center"><i>Add Contact</i></h1></br>

	<form action ="Add" method="post">
		Name:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text"   placeholder="Name" name= "name"></br></br>
		Phone:&nbsp&nbsp&nbsp&nbsp&nbsp
		<select name="phone">  
		<option>Land-Line</option>  
		<option>Mobile</option>  
		<option>Other</option>  
		</select> </br></br>
		Number:&nbsp&nbsp&nbsp <input type="tel"   placeholder="Phone Number" name="number"/> </br></br>
		Email Id:&nbsp&nbsp<input type="email"  placeholder="abc@example.com" name="email"/> 
		
		
		</br></br>
	   <input align="left" type="submit"/> <input type="reset"/><br><br>
	   
	   	<% 
	Object rs=null;
	rs=session.getAttribute("result");
	if(rs=="save")
	{%>
		<b><% out.println("Saved Successfully");%></b>
	
	<%}
	session.setAttribute("result",null);
	%>

	</form>

<a href="Home.jsp"><center><img src="/contactappv2/images/homeIcon.ico" height="70" width></a>

</body>

</html>