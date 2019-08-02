<%@page import="com.lxisoft.contact.Contact"%>
<%@page import="com.lxisoft.contact.ContactRepository"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<html>
<head>
<title>ContactApp jsp page</title>
</head>
<style>
table { 
  display: table;
  border-collapse: separate;
  border-spacing: 2px;
  border-color: gray;
}
</style>
<body>

	<%
	ArrayList<Contact> contacts=new ArrayList<Contact>();
	ContactRepository contactR=new ContactRepository();
	// out.println(contactR.readContact());
	contacts=contactR.readContact();%>
	<table>
		<tr>
			<th>Contact Name   </th>
			<th>Contact Number</th>
		</tr>

	<%
	for(int i=0;i<contacts.size();i++)
	{%>
		<tr>
			<td><%out.println(contacts.get(i).getName()); %> </td>
			<td><%out.println(contacts.get(i).getNum());%></td>
		</tr>

	
	<%}

	%>
</table>
</body>
<a href="Index.html">Back to html</a>
</html>