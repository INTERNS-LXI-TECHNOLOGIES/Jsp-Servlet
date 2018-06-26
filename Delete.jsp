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
<a href="Contact.jsp"><img src="/ContactsApp/images/homePic.jpg" width="50" height="50"></a></br></br>
</p>
<form action="Contact.jsp" method="post">

<% String name=request.getParameter("name");
String sid=request.getParameter("id");
int id=Integer.parseInt(sid);
ArrayList<Contact> contactList=ContactController.getContacts();
ContactController cc=new ContactController();
Contact rc=null;
	for(Contact contact:contactList){
		g:
		if(contact.getName().equals(name)){
			 rc=contact;
			break g;
		}
	}
	cc.remove(id);
	
	out.println("Are you sure you want to delete this contact");%>
		<input align="center" type="submit" value="Submit" class="button" >
		<input  type="reset" value="Cancel" class="button" >	
			</form>
</body>

</html>