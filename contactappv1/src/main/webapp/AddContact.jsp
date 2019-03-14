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
	

<%@  page import = "com.lxisoft.contactapp.web.*,java.util.*,com.lxisoft.contactapp.model.*,javax.servlet.ServletException,javax.servlet.http.* "%>

<body>

		<h1 align="center"><i>Add Contact</i></h1></br>
		<table>
		<form action ="Add" method="post">
		<tr>First Name:<input type="text"   placeholder="First Name" name= "first_Name"></tr></br></br>
		<tr>Last Name:<input type="text"   placeholder="Last Name" name= "last_Name"></tr></br></br>
		<tr>Phone:
		<select name="phone">  
		<option>Land-Line</option>  
		<option>Mobile</option>  
		<option>Other</option>  
		</select></tr></br></br>
		<tr>Number:<input type="tel"   placeholder="Phone Number" name="number"/></tr></br></br>
		<tr>Email Id:<input type="email"  placeholder="abc@example.com" name="email"/></tr></br></br>
		<button class=buttonStyle type="submit">Save</button><input type="reset"/><br><br>

	   
	   	<% 
	Object rs=session.getAttribute("result");
	if(rs=="Save")
	{%>
		<b><% out.println("Saved Successfully");%></b>
	
	<%}
	session.setAttribute("result",null);
	%>

	</form>

<a href="Home.jsp"><center><img src="/contactappv1/images/homeIcon.ico" height="70" width></a>

</body>

</html>