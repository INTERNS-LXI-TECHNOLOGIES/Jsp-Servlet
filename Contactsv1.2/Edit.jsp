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
		
		<h1 align="center">Edit</h1><p align="center"><img src="\Contactsv1.2\images\edit.jpg" height="50" width="50">
			
		<%
			String name=request.getParameter("name");
			System.out.println("1Edit/name=="+name);
			ContactController cc=new ContactController();
			Contact contact=cc.search(name);
			System.out.println("2Edit/name=="+contact.name);
			if(contact==null)
			{
				contact=new Contact(0,"not found","not found");
			}
			System.out.println("2Edit/name=="+contact.id);
		%>
		</br>
		<form action="AddContacts2.jsp" method="post">
		Name:<input type="text" value="<%=contact.name%>" name="name"/></br>
		Phone:<input type="text" value="<%=contact.phone%>" name="phone"/></br>
		<input type="hidden" value="<%=contact.id%>" name="id"/>
		<input type="submit" value="ok"><input type="reset" value="clear"></br>
		</form>
	</body>
</html>
		