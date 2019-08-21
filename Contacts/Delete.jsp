<%@ page import ="com.lxisoft.contact.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
	<title>Delete Contact</title>
	<link rel="stylesheet" href="Style.css">
</head>
<body>
	<%
		int id=Integer.parseInt(request.getParameter("id"));
		RepoImpl repoImpl=new RepoImpl();
		repoImpl.deleteContact(id);
	%>
	<br><br>
		<div class="container">
			<br>
			<strong>Success!</strong> Contact deleted sucessfully.<br><br>
		</div>
		
		<a href="Home.html">Back to Home</a>
</body>
</html>