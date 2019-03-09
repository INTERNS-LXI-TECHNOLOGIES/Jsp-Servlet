<!DOCTYPE html>
<html>
<head>
<title> Add Contact </title>
</head>
	<style>
	
		body
			{
			background-color:cyan;
			}			
/* CSS */
.buttonStyle {
  color: #FFF;
  background: #999;
  font-weight: bold;
  border: 1px solid #900;
}
 
.buttonStyle:hover {
  color: #FFF;
  background: #900;
}

table, th, td {
	background-color: #f1f1c1;
    border: 1px solid black;
    border-collapse: collapse;
}
th {
  text-align: left;
}

	</style>
	

<%@  page import = "com.lxisoft.contactapp.web.*,com.lxisoft.contactapp.service.*,java.util.*,com.lxisoft.contactapp.model.*,javax.servlet.ServletException,javax.servlet.http.* "%>

<body>

<%
	ArrayList<Contact> conlist=new ArrayList<Contact>();
	conlist=(ArrayList<Contact>)request.getAttribute("contactList");%>
	
	<h1><i>Contacts</i></h1></br>
	<table>
	
	<a href="Home.jsp"><img src="/contactApp/images/homeIcon.ico" height="40" width></a>
	<a href="DeleteContact.jsp"><img src="/contactApp/images/delete.png" height="40" width></a>
	<a href="EditContact.jsp"><img src="/contactApp/images/edit.jpg" height="40" width></a><br>
	<form action="Search" method="Get"><input type="text" placeholder="Search Name" name= "searchName">
	<button type="submit"><img src="/contactApp/images/search1.png" height="40" width></button> </form><br><br>
	
	
	
	<tr><th>Name</th><th>Phone</th></tr>
	<%for(Contact contact:conlist){%>
		<tr>
		<td><%out.println(contact.getName());%></td>
		<td><%out.println(contact.getNumber());%></td>
		</tr>
		<%}%>
	
	</table>

</body>

</html>