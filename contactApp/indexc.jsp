<%@page import="com.lxisoft.contact.Contact"%>
<%@page import="com.lxisoft.contact.ContactRepository"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.*"%>
<html>
<head>
<title>ContactApp jsp page</title>
</head>
<body>
	<%
	Contact contact=new Contact();
	contact.setName(request.getParameter("name"));
	contact.setNum(request.getParameter("cnumber"));
	ContactRepository contactR=new ContactRepository();
	contactR.createContact(contact);
	%>

</body>
<a href="Index.html">Back to html</a>
</html>

