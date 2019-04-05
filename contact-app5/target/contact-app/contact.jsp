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
		<%@ page import="com.lxisoft.web.*,java.util.*,com.lxisoft.model.*,com.lxisoft.service.*" %>
		<%@page import="java.util.ResourceBundle,java.util.Locale" %>
	<%@page contentType="text/html" pageEncoding="UTF-8"%>
</head>
<%
	Locale l=null;
	if((String)request.getAttribute("lang")!=null){
		l=new Locale((String)request.getAttribute("lang"));
	}
	else{
		l=new Locale("eng");
	}
	ResourceBundle r=ResourceBundle.getBundle("lang",l);
%>

<body bgcolor=#87CEFA><a href=Home.jsp><%=r.getString("Home")%></a><center><h1><%=r.getString("ContactList")%></h1></center>
		<center><table><tr><th><%=r.getString("Name")%></th><th><%=r.getString("PhoneNumber")%></th></tr>
			<% 
			ArrayList<Contact> contactList=(ArrayList<Contact>) request.getAttribute("contactList");
			
			 %>
			<% for(Contact contact:contactList){

			 %>
			<tr><td>
			<% 
			out.println(contact.getName());%>
			</td><td>
			<% out.println(contact.getPhno()); %>
			</td>
			<td><a href="DeleteContact?id=<%=contact.getName()%>"><button class="cbutton" type="submit">Delete</button></a></td>
		<td><a href="EditContact?id=<%=contact.getName()%>"><button class="cbutton" type="submit">Edit</button></a></td></tr>
		<%}%>
		
		
</center>
</table>
<button class = "prev" onclick="window.location.href='AddContact?prev=true'">Prev</button>
	<button class = "next" onclick="window.location.href='AddContact?next=true'">Next</button>
	
</body>
</html>