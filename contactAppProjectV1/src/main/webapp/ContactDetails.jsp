<!DOCTYPE html>
<html>
<head>
<title> Add Contact </title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
	
<%@  page import = "com.lxisoft.web.*,java.util.*,com.lxisoft.model.*,javax.servlet.ServletException,javax.servlet.http.* "%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<body class="body">

	<%
	ArrayList<Contact> contacts=new ArrayList<Contact>();
	contacts=(ArrayList<Contact>)request.getAttribute("contacts");

	 
   
%>
	
	<%Object c=application.getAttribute("contactapp"); %>
	<h1 class="h1"><b><%=c %></i></h1></br>	
	<h3><i>Contacts</i></h3></br>
	<table  width=100% class=".table .td .tr">
	
	<a href="Home.jsp"><img src="/contactAppProjectV1/images/homeIcon.ico" height="40" width></a></br>
	<form action="Search" method="Get"><input type="text" placeholder="Search Name" name= "searchName">
	<button type="submit"><img src="/contactAppProjectV1/images/search1.png" height="30" width></button> </form><br><br>
	
	<%//request.setAttribute("contacts",conlist);%>
	<table>
		<tr>
			<th>Name</th>
			<th>Phone Number</th>
		</tr>
		<%
			for(int i =0;i<contacts.size();i++){
			
		%>
		<tr>
			<td><%=contacts.get(i).getFirstName()%></td>

			<td><%=contacts.get(i).getNumber()%></td>
			<td><a href="Edit?id=<%=contacts.get(i).getFirstName()%>"><button  class = "cbutton" type="submit"><img src="/contactAppProjectV1/images/edit.jpg" height="30" width="40"></button></a>
			<a href="Delete?id=<%=contacts.get(i).getFirstName()%>"><button  class = "cbutton" type="submit"><img src="/contactAppProjectV1/images/delete.png" height="30" width="40"></button></a></td>
		</tr>
		<%
			}
		%>
	</table>
	<button class = "prev" onclick="window.location.href='Add?prev=true'"></button>
	<button class = "next" onclick="window.location.href='Add?next=true'"></button>
  	
</body>

</html>