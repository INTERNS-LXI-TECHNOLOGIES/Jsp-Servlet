<%@ page import = "com.lxisoft.model.ContactDetails" %>
<%@ page import = "java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="style.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<title>Contacts</title>
</head>
<body>

<h1 class ="h1"> ContactApp</h1>

<form action = "search" >
<input class = "search" type="text" name="search" placeholder="Search">
<button class = "searchb" type="submit" title = "Search"><i class="fa fa-search"></i></button>
</form>
<form action = "logout" >
<button class = "logb" type="submit" title = "LogOut"><i class="fa fa-sign-out"></i></button>
<%
    
%>
</form>
<form action = "AddContact.jsp" >
	<button class = "contactbutton" type = "submit" title = "Add Contact">+</button>
</form>
	<%
	
	List<ContactDetails> contacts =(List<ContactDetails>) request.getAttribute("contacts");
	%>
	<table>
		<tr>
			<th>Name</th>
			<th>Email Id</th>
			<th>Number</th>
		</tr>
		<%
			for(int i =0;i<contacts.size();i++){
			
		%>
		<tr>
			<td><%=contacts.get(i).getName()%></td>
			<td><%=contacts.get(i).getEmailid()%></td>
			<td><%=contacts.get(i).getNumber()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>