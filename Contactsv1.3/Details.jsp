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
					String name=request.getParameter("name");
					Contact contact=(Contact)request.getSession().getAttribute("contact");
					request.getSession().removeAttribute("contact");
					request.getSession().setAttribute("contact",contact);
						%>
		
			<div id="top"><% out.print(contact.name);%></div></br></br>
			
			<div id="top"><% out.print(contact.phone);%></div></br></br>
			
			<!-- <a href="delete?id=<%=contact.id%>" method="delete"><img src="\Contactsv1.3\images\delete.png" height="50" width="50"></a>-->
			
			<form action="Delete" method="get">
			<%request.getSession().setAttribute("contact",contact);%>
			<input type="submit" value="Delete">
			</form>
			
			<a href="Edit.jsp" method="get"><img src="\Contactsv1.3\images\edit.jpg" height="50" width="50">
			
			<a href="Contacts.jsp"><img src="/Contactsv1.3/images/homeIcon.ico" height="50" width></a></br>
		
	</body>
</html>