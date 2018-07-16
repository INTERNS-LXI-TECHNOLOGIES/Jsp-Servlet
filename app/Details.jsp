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

<%@ page import="java.util.*,com.lxisoft.controller.*,com.lxisoft.model.*"%>
    <% String name=request.getParameter("name");
	
	Set<Contact> contactList=ContactController.getContacts();
	
	for(Contact contact:contactList){
		
			
		if(contact.getName().equals(name)){
		%>

<body>
<p align="left">
<a href="Contact.jsp"><img src="/ContactsApp/images/home.jpg" width="50" height="50"></a></br></br>
</p>

<h1>Details</h1>
<p align="center">
<img src="/ContactsApp/images/contacts.jpg" width="140" height="150">
</p>

<div id="mid">
<a href="Edit.jsp?name=<%=contact.getName()%>"><img src="/ContactsApp/images/edit.jpg" width="50" height="50" title=editContact></a>
<a href="Delete.jsp?name=<%=contact.getName()%>"><img src="/ContactsApp/images/delete.jpg" width="50" height="50" title=deleteContact></a>
<link rel="stylesheet" type="text/css" href="Sample.css"/>
</div>


   

    
	
		
			<%out.println(" "+contact.getName());%></br>
			<%out.println(" "+contact.getPhoneNumber());%></br>
			<%out.println(" "+contact.getPlace());%></br>
			<%out.println(" "+contact.getEmailId());%></br>
	<%	
	}
		
	
		
	}

	%>

</html>