<%@page import="com.lxisoft.contact.* "%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
	<title>Search Contact</title>
	<link rel="stylesheet" href="Style.css">
</head>
<body>
	<table>
		<tr>
			<th>Id.</th>
			<th>Name</th>
			<th>Contact Number</th>
		</tr>
	<%
		String name=request.getParameter("Name");
		RepoImpl repoImpl=new RepoImpl();
		ArrayList<Contact> contactList=repoImpl.searchContact(name);

		for(int i=0;i<contactList.size();i++)
		{ 
	%>
			<tr>
				<td><%out.println(contactList.get(i).getId());%></td>
				<td><%out.println(contactList.get(i).getName());%></td>
				<td><%out.println(contactList.get(i).getNumber());%></td>
			</tr>
			<!-- System.out.println(contactList.get(i).getId()+"\t"+contactList.get(i).getName()+"\t"+contactList.get(i).getNumber()); -->
		<% }
	%>
</table>
<a href="Home.html">Back to Home</a>

</body>
</html>