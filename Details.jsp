<html>
<!--contacts app-->

<head>
	<title>Contacts Details</title>
	
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
	
	ArrayList<Contact> contactList=ContactController.getContacts();
	
	for(Contact contact:contactList){
		
			
		if(contact.getName().equals(name)){
		%>

<body>
<p align="left">
<a href="Contact.jsp"><img src="/ContactsApp/images/homePic.jpg" width="50" height="50"></a></br></br>
</p>

<h1>Contact Details</h1>
<p align="center">
<img src="/ContactsApp/images/contact.jpg" width="140" height="150">
</p>

<div id="mid">
<a href="Edit.jsp?name=<%=contact.getName()%>&id=<%=contact.id%>"><img src="/ContactsApp/images/editPic.jpg" width="50" height="50" title=editContact></a>
<a href="Delete.jsp?name=<%=contact.getName()%>&id=<%=contact.id%>"><img src="/ContactsApp/images/deletePic.jpg" width="50" height="50" title=deleteContact></a>
<link rel="stylesheet" type="text/css" href="Sample.css"/>
</div>


   

    
	
		
			<%out.println(" "+contact.getName());%></br>
			<%out.println(" "+contact.getPhoneNumber());%></br>
		
	<%	
	}
		
	
		
	}

	%>

</html>