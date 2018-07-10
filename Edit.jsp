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
<%@ page import="java.util.*,com.lxisoft.controller.*,com.lxisoft.model.*,java.sql.*"%>

<%Contact contact=null;
ArrayList<Contact>contacts=(ArrayList<Contact>) request.getSession().getAttribute("Contact");
String oldName=null;
for(Contact tc:contacts){
	contact=tc;
	oldName=tc.getName();
	
	
}
	%>
	

 <form action="edit" method="post">

<table>
 
<tr>
	<td>Name:</td>
	<td><input type="text" "First Name" value=<%=contact.getName()%>  name="name"/></td>
<tr>
	<td>Phone:</td>
	<td><input type="text" value=<%=contact.getPhoneNumber()%>  name="phone"/></td>
	
</tr>

			
<tr align="center">
	<td colspan="2">
		<input align="center" type="submit" value="Submit" class="button" >
		<input  type="reset" value="Cancel" class="button" >
		
	</td>
</tr>  
<input type="hidden" value=<%=oldName%> name="oldName"/>
</table>
<%
		
		request.getSession().setAttribute("contact",contact);
		
		%>
</form>

</body>
</html>