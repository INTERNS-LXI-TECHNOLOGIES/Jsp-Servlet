<!DOCTYPE html>
<html>
<head>
	<title>Contact List</title>
	<style>
		table,th,td{
		border: 1px solid black;
		}
		h1{
		color:  #191970;
		}
		</style>
		<%@ page import="com.lxisoft.web.*,java.util.*,com.lxisoft.model.*,com.lxisoft.service.*" 
		
		%>
</head>
<body bgcolor=#87CEFA><a href=Home.jsp>Home</a><center><h1>Contact List</h1></center>
<%int i=1; %>
		<center><table><tr><th>Sl.No</th><th>Name</th><th>Phno</th></tr>
			<% 
			ArrayList<Contact> contactList=(ArrayList<Contact>) request.getAttribute("contactList");
			
			 %>
			<% for(Contact contact:contactList){

			 %>
			<tr><td>
			<%out.println(i);%>
			</td><td>
			<% 
			out.println(contact.getName());%>
			</td><td>
			<% out.println(contact.getPhno()); %>
			</td></tr>
		<% i++;}%>
		</table><a href=Deletecontact.jsp>Delete</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<a href=Editcontact.jsp>Edit</a><br><br>
		
</center>

</body>
</html>