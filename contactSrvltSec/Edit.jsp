<html>
<!--contacts app-->

<head>
	<title>Edit</title>
	<%@ page import="com.lxisoft.controller.*,com.lxisoft.model.*,java.util.*,java.sql.*" %>
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
    <% 
	
	
	
	
	
	
	try{
	
	Contact contact=(Contact)request.getSession().getAttribute("Contact");%>
	


 <form action="EditContact.jsp" method="post">

<table>
 
<tr>
	<td>Name:</td>
	<td><input type="text"  value="<%=contact.getName()%>" name="name"/></td>
<tr>
	<td>Phone:</td>
	<td><input type="text" value="<%=contact.getPhoneNumber()%>" name="phoneNumber"/></td>
	
</tr>
<tr>
	<td>Place:</td>
	<td><input type="text" value="<%=contact.getPlace()%>" name="place"/></td>
	
</tr>

<tr>
	<td>e-mail:</td>
	<td><input type="text" value="<%=contact.getEmailId()%>" name="e-mail"/></td>
	
</tr>

<tr align="center">
	<td colspan="2">
		<input align="center" type="submit" value="Submit" class="button" >
		<input  type="reset" value="Cancel" class="button" >
		
	</td>
</tr>  
<input type="hidden" value="<%=contact.getName()%>" name="oldName"/> 
</table>
</form>
	<%
					
	}catch(Exception e){
				out.println(e);
		}
	
	
		
	

	%>	
</body>
</html>