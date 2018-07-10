<html>
<!--contacts app-->

<head>
	<title>Details</title>
	
</head>
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

<%@ page import="java.util.*,com.lxisoft.controller.*,com.lxisoft.model.*,java.sql.*"%>
 
 
 
 <body>
<p align="left">
<a href="Contact.jsp"><img src="/ContactsApp/images/homePic.jpg" width="50" height="50"></a></br></br>
</p>
<h1>Details</h1>
<p align="center">
<img src="/ContactsApp/images/contact.jpg" width="140" height="150">
</p>

<div id="mid">

</div>
<%
ArrayList<Contact>contacts=(ArrayList<Contact>) request.getSession().getAttribute("Contact");
for(Contact tc:contacts){%>
</br><%out.println("<>"); out.println(" "+tc.getName());%></br>
<%out.println("       "+tc.getPhoneNumber());}
out.println("{{{{{{{{{{{{{}}}}}}}}}}}");%></br>



		
	
</body>
			

</html>