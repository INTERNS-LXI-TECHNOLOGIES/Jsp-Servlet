<html>
<!--contacts app-->

<head>
	<title>Delete</title>
	<%@ page import="com.lxisoft.controller.*,com.lxisoft.model.*,java.util.*" %>
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
<form action="contact.jsp" method="post">

<% String name=request.getParameter("name");
Set<Contact> contactList=ContactController.getContacts();
Contact rc=null;
	for(Contact contact:contactList){
		g:
		if(contact.getName().equals(name)){
			 rc=contact;
			break g;
		}
	}contactList.remove(rc);
	
	out.println("Are you sure you want to delete this contact");%>
		<input align="center" type="submit" value="Submit" class="button" >
		<input  type="reset" value="Cancel" class="button" >	
			</form>
</body>

</html>