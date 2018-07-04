<html>
	<head>
			<title>Details</title>
			<%@ page import = "com.lxisoft.model.*,com.lxisoft.controller.*"%>
	</head>
	<style>
		body
		{
			background-color:skyblue;
		}
		#top{
			background-color:white;
		}
	</style>
	<body>
	</br></br>
	<h1 align="center">Details</h1>
	
			<% 
					ContactController cc=new ContactController();
					String name=request.getParameter("name");
					Contact contact=cc.search(name);
						%>
		
			<div id="top"><% out.print(contact.name);%></div></br></br>
			
			<div id="top"><% out.print(contact.phone);%></div></br></br>
			
			<a href="Delete.jsp?id=<%=contact.id%>" method="get"><img src="\Contactsv1.2\images\delete.png" height="50" width="50"></a>
			<a href="Edit.jsp?name=<%=contact.name%>" method="get"><img src="\Contactsv1.2\images\edit.jpg" height="50" width="50">
			<a href="Contacts.jsp"><img src="/Contactsv1.2/images/homeIcon.ico" height="50" width></a></br>
		
	</body>
</html>