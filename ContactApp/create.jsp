<%@page import="com.lxisoft.contact.* "%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<html>
<head>
	<title>Create Page</title>
	<link rel="stylesheet" href="Style.css">
</head>
<body>
	<%
		Contact contact=new Contact();
	
		contact.setName(request.getParameter("Name"));
		contact.setNumber(request.getParameter("ContactNumber"));
	
		RepoImpl repoImpl=new RepoImpl();
		repoImpl.createContact(contact);
	%>
	<br><br>
		<div class="container">
			<br>
			<strong>Success!</strong> Contact inserted sucessfully.<br><br>
		</div>

		<button type="button">Crete More</button><br><br>
	<!-- <a href="create.html">Create More</a> -->
	<a href="Home.html">Back to Home</a>
</body>
</html>
