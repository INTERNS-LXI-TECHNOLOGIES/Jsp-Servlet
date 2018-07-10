<html>
<!--contacts app-->

<head>
	<title>Search</title>
	
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
 
 
 
 <body>
<p align="left">
<a href="Contact.jsp"><img src="/ContactsApp/images/homePic.jpg" width="50" height="50"></a></br></br>
</p>
<h1>Search</h1>
<p align="center">
<img src="/ContactsApp/images/contact.jpg" width="140" height="150">
</p>

<div id="mid">
<!--<a href="Edit.jsp"><img src="/ContactsApp/images/editPic.jpg" width="50" height="50" title=editContact></a>-->
<%
Contact contact=null;
ArrayList<Contact>contacts=(ArrayList<Contact>) request.getSession().getAttribute("Contact");
for(Contact tc:contacts){
	contact=tc;
	%>
</br><%out.println("<>"); out.println(" "+tc.getName());%></br>
<%out.println("       "+tc.getPhoneNumber());}
out.println("{{{{{{{{{{{{{}}}}}}}}}}}");%></br>

	<form action="delete" method ="post">
<%
		
		request.getSession().setAttribute("contact",contact);
		
		%>
	
		<input  type="submit" value="Delete" >
		
		</form>
<form action="EditContact.jsp" method="get">

<table>
 
<tr>
	<td>Name:</td>
	<td><input type="text" "First Name"  value="<%=contacts.getName()%>" name="name"/></td>
<tr>
	<td>Phone:</td>
	<td><input type="text" value="<%=contacts.getPhoneNumber()%>" name="phone"/></td>
	
</tr>

			
<tr align="center">
	<td colspan="2">
		<input align="center" type="submit" value="Submit" class="button" >
		<input  type="reset" value="Cancel" class="button" >
		
	</td>
</tr>  

</table>
</form>
		
		

<!--<a href="Delete.jsp"><img src="/ContactsApp/images/deletePic.jpg" width="50" height="50" title=deleteContact></a>-->
<link rel="stylesheet" type="text/css" href="Sample.css"/>
</div>




		
	
</body>
			

</html>