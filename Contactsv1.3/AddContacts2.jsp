<html>
	<head>
		<title>used for add contacts</title>
		<link rel="stylesheet" type="text/css" href="Them1.css"/>
		<%@  page import = "com.lxisoft.controller.*,com.lxisoft.model.*,java.io.*"%>
	</head>
	<style>
		body
		{
		background-color:green;
		}
		
	</style>
	<body>
	
	<div id="top"> 
	<h2 align="center"><i><%request.getParameter("result");%></i></h2></br>
	</div>

	<a href="Contacts.jsp"><img src="/Contactsv1.3/images/homeIcon.ico" height="50" width></a></br>

		<div id="top">
		Name   :<%out.println(request.getParameter("name"));%></br>
		</div></br>
		<div id="top">
		Phone :<%out.println(request.getParameter("phone"));%></br>
		</div>
	</body>
</html>