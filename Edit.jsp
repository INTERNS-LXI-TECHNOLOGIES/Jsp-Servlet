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
<a href="Contact.jsp"><img src="/ContactsApp/images/homePic.jpg" width="50" height="50"></a></br></br>
</p>


<body>
    <%
try{	
		String name=request.getParameter("name");
		ContactController cc=new ContactController();
		ArrayList<Contact> contactList=cc.getContacts();
		
			Contact contact=new Contact(0,"not found","not found");
			 contact=cc.search(name);
			System.out.println("2Edit/name=="+contact.getName());
			System.out.println("2Edit/name=="+contact.id);
	
			%>


 <form action="EditContact.jsp" method="get">

<table>
 
<tr>
	<td>Name:</td>
	<td><input type="text" "First Name"  value="<%=contact.getName()%>" name="name"/></td>
<tr>
	<td>Phone:</td>
	<td><input type="text" value="<%=contact.getPhoneNumber()%>" name="phoneNumber"/></td>
	
</tr>

<input type="hidden" value="<%=contact.id%>" name="id"/>
			
<tr align="center">
	<td colspan="2">
		<input align="center" type="submit" value="Submit" class="button" >
		<input  type="reset" value="Cancel" class="button" >
		
	</td>
</tr>  
</table>
</form>
	<%}
			catch(Exception e)
			{
				System.out.println(e);
			}
			%>	
</body>
</html>