<html>
	<head>
		<title>Editing page</title>
		<%@ page import ="com.lxisoft.controller.*,com.lxisoft.model.*"%>
	</head>
	<style>
		body
		{
			background-color:green;
		}
	</style>
	<body>
		
		<h1 align="center">Edit</h1><p align="center"><img src="\Contactsv1.4\images\edit.jpg" height="50" width="50">
			
		<%
			Contact contact=(Contact)request.getSession().getAttribute("contact");
			request.getSession().removeAttribute("contact");
		%>
		</br>
		<form action="Edit" method="post">
		Name:<input type="text" value="<%=contact.name%>" name="name"/></br>
		Phone:<input type="text" value="<%=contact.phone%>" name="phone"<%=contact.phone%>/></br>
		<input type="hidden" value="<%=contact.id%>" name="id"/>
		<input type="submit" value="ok"><input type="reset" value="clear"></br>
		</form>
	</body>
</html>
		