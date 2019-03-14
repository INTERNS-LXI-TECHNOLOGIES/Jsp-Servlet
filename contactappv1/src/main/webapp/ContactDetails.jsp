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
	

<%@  page import = "com.lxisoft.contactapp.web.*,java.util.*,com.lxisoft.contactapp.model.*,javax.servlet.ServletException,javax.servlet.http.* "%>

<body>
<%Object c=application.getAttribute("contacts"); %>
	<h1><i><%=c %></i></h1></br>
	
	<a href="Home.jsp"><img src="/contactappv1/images/homeIcon.ico" height="30" width></a>
	<a href="DeleteContact.jsp"><img src="/contactappv1/images/delete.png" height="30" width></a>
	<a href="EditContact.jsp"><img src="/contactappv1/images/edit.jpg" height="30" width></a><br>
	<form action="Search" method="Get"><input type="text" placeholder="Search Name" name= "searchName">
	<button type="submit"><img src="/contactappv1/images/search1.png" height="20" width></button> </form><br>
	<table><tr><th>Name</th><th>Number</th></tr>
			<% 
			ArrayList<Contact> contactList=(ArrayList<Contact>) request.getAttribute("contactList");
			for(Contact contact:contactList){
			 %>
			<tr><td>
			<% 
			out.println(contact.getFirstName());%>
			</td><td>
			<% out.println(contact.getNumber()); %>
			</td></tr>
		<%}%>
	
	</table>

</body>

</html>