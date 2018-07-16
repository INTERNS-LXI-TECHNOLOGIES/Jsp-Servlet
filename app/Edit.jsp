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
	
	for(Contact contact:contactList){
		if(contact.getName().equals(name)){
			String phone = contact.getPhoneNumber();
			String place= contact.getPlace();
			String email=contact.getEmailId();
			int id=contact.id;
			String sId=String.valueOf(id);
			out.println(" >>>>>>>>>>>>>>>>>>>>>>>"+id);
			out.println(">>>>>>>>>>>>>>>>>>>>>>>"+sId);
			%>


 <form action="EditContact.jsp" method="get">

<table>
 
<tr>
	<td>Name:</td>
	<td><input type="text" "First Name"  value="<%=name%>" name="name"/></td>
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
	<td><input type="text" value="<%=email%>" name="e-mail"/></td>
	
</tr>
<input type="hidden" value="<%=sId%>" name="id"/>
<tr align="center">
	<td colspan="2">
		<input align="center" type="submit" value="Submit" class="button" >
		<input  type="reset" value="Cancel" class="button" >
		
	</td>
</tr>  
</table>
</form>
	<%}
		
	
	}

	%>	
</body>
</html>