<%@ page import= "com.lxisoft.contact.ContactModel"%>
<%@ page import= "com.lxisoft.contact.RepositoryImpl"%>
<%@ page import="java.sql.*"%>

<%
	RepositoryImpl ri=new RepositoryImpl();

%>
<html>
    <head>
    <title> Remove </title>
</head>
<body>
	<%
String b=request.getParameter("Mobile Number");
String d=request.getParameter("Updated Number");
String c="mobileNumber";
ri.updateContact(c,b,d);
%>



	<a href="index.html"><tr>go back</tr></br></br></a>
</body>
</html>