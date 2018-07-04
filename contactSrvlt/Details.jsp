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

	<% try{
	String name=(String)request.getSession().getAttribute("e");%>
	<%	String phone=(String)request.getSession().getAttribute("f");%>
	<%	String place=(String)request.getSession().getAttribute("g");%>
	<%	String email=(String)request.getSession().getAttribute("h");%>

    
			
			<body>
<p align="left">
<a href="Contact.jsp"><img src="/ContactsApp/images/home.jpg" width="50" height="50"></a></br></br>
</p>

<h1>Details</h1>
<p align="center">
<img src="/ContactsApp/images/contact.jpg" width="140" height="150">
</p>

<div id="mid">
<a href="edit?name=<%=name%>"><img src="/ContactsApp/images/edit.jpg" width="50" height="50" title=editContact></a>
<a href="Delete.jsp?name=<%=name%>"><img src="/ContactsApp/images/delete.jpg" width="50" height="50" title=deleteContact></a>
<link rel="stylesheet" type="text/css" href="Sample.css"/>
</div>
			
				<%	out.println(" >>>"+name);%></br>
					<%out.println(" >>>"+phone);;%></br>
					<%out.println("*** "+place);%></br>
					<%out.println("//// "+email);%></br>
					
				
				
				<%
		}catch(Exception e){
				out.println(e);
		}
	
	%>
				

</body>


</html>