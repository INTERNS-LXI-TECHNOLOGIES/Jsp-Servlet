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
		ArrayList<Contact> ct =(ArrayList<Contact>)request.getSession().getAttribute("contact");
		for(Contact cnts:ct){%>
		
		
	

    
			
			<body>
<p align="left">
<a href="Contact.jsp"><img src="/ContactsApp/images/home.jpg" width="50" height="50"></a></br></br>
</p>

<h1>Details</h1>
<p align="center">
<img src="/ContactsApp/images/contact.jpg" width="140" height="150">
</p>

<div id="mid">
<a href="Edit.jsp?name=<%=name%>"><img src="/ContactsApp/images/edit.jpg" width="50" height="50" title=editContact></a>
<a href="delete?name=<%=name%>"><img src="/ContactsApp/images/delete.jpg" width="50" height="50" title=deleteContact></a>
<link rel="stylesheet" type="text/css" href="Sample.css"/>
</div>
			
				<%out.println(">>>>>"+cnts.getName());%></br>
		<%out.println(">>>>>"+cnts.getPhoneNumber());%></br>
		<%out.println(">>>>>"+cnts.getPlace());%></br>
		<%out.println(">>>>>"+cnts.getEmailId());%></br>
					
				
				
				<%}
		}catch(Exception e){
				out.println(e);
		}
	
	%>
				

</body>


</html>