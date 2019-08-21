<%@page import="com.lxisoft.contact.* "%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<html>
<head>
	<title>Edit Page</title>
	<link rel="stylesheet" href="Style.css">
</head>
<body>
	<%
		Contact contact=new Contact();
		int id=Integer.parseInt(request.getParameter("id"));
		contact.setName(request.getParameter("Name"));
		contact.setNumber(request.getParameter("ContactNumber"));
	
		RepoImpl repoImpl=new RepoImpl();
		repoImpl.updateContact(id,contact);
	%>
	<br><br>
		<div class="container">
			<br>
			<strong>Success!</strong> Contact updated sucessfully.<br><br>
		</div>
		
		<a href="Home.html">Back to Home</a>
</body>
</html>
