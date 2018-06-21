<html>
<!--contacts app-->

<head>
	<title>Edit</title>
	<%@ page import="com.lxisoft.controller.*,com.lxisoft.model.*,java.util.*" %>
</head>
<h1>Edit Contact<h1>
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
	
	
</style>

<body>
<p align="left">
<a href="Contact.jsp"><img src="/ContactsApp/images/home.jpg" width="50" height="50"></a></br></br>
</p>


<body>
    <% String name=request.getParameter("name");
	
	Set<Contact> contactList=ContactController.getContacts();
	loop1:
	for(Contact contact:contactList){
		if(contact.getName().equals(name)){
			String phone = contact.getPhoneNumber();
			String place= contact.getPlace();
			String email=contact.getEmailId();
			%>


 <form action  ="" method = "post">
 
<table>
<tr>
	<td>Name:</td>
	<td><input type="text" "First Name"  value="<%=name%>" name="name"/></td>
	<td>
	
</tr>
<tr>
	<td>Phone:</td>
	<td><input type="text" value="<%=phone%>" name="phoneNumber"/></td>
	
</tr>
<tr>
	<td>Place:</td>
	<td><input type="text" value="<%=place%>" name="place"/></td>
	
</tr>

<tr>
	<td>e-mail:</td>
	<td><input type="text" value=<%=email%>" name="e-mail"/></td>
	
</tr>
<tr align="center">
	<td colspan="2">
		<input align="center" type="submit" value="Submit" class="button" >
		<input  type="reset" value="Cancel" class="button" >
		
	</td>
</tr>  
</table>
</form>
	<%}
	break loop1;	
	
	}

	%>	
</body>
</html>