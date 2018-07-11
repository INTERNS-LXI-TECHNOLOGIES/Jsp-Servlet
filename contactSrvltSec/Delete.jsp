<html>
<!--contacts app-->

<head>
	<title>Delete</title>
	<%@ page import="com.lxisoft.controller.*,com.lxisoft.model.*,java.util.*,java.sql.*" %>
</head>
<h1>Delete Contact<h1>
<style>
	body    
	{
		background-color:lightpink;
	}
	h1
	{
		color:White;
		text-align:center;
	}
	.button{
	background-color:cornflowerblue;
	color:white;
}
.button:hover{
	background-color:green;
}
	
</style>

<body>
<p align="left">
<a href="Contact.jsp"><img src="/ContactsApp/images/home.jpg" width="50" height="50"></a></br></br>
</p>
<form action="Contact.jsp" method="get">

<% String name=request.getParameter("name");
try{
			
			
		   out.println("are you sure you want to delete this contact");
						
		}catch(Exception e){
				out.println(e);
		}
	
	%>
		
		<input align="center" type="submit" value="Submit" class="button" >
		<input  type="reset" value="Cancel" class="button" >	
			</form>
		
</body>

</html>