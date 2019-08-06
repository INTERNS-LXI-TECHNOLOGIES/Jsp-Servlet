<%@ page import= "com.lxisoft.contact.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<html>
<head>
	<title>contact</title>
</head>
<body>
<%
Contact contact=new Contact();

contact.setName(request.getParameter("Name"));
contact.setPhoneNumber(request.getParameter("PhoneNumber"));
RepositoryImpl repo=new RepositoryImpl();
repo.create(contact);
%>
<h5>Contact saved...</h5>
</body>
</html>