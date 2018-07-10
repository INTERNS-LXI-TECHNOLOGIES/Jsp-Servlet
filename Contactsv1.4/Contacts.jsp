<html>
<head>
<title>contacts</title>
<link rel="stylesheet" type="text/css" href="Them1.css"/>
<%@ page import=" com.lxisoft.controller.*,java.util.*,com.lxisoft.model.*,java.io.*"%>
</head>
	<style>
	body{
		
		background-color:lightgreen;
		
	}
	h1
	{
			
		color:black;
		text-align:center;
		
	}
	#top
		{
			background-color:white;
		}
	</style>
	
	<body>
	<div id="top">
	<h1><i>Contacts</i></h1>
	<p align="center">
	<img src="\Contactsv1.3\images\61755-200.png" height="50" width="50"></br>
	</p></br></br>
	</div>
		<a href="AddContacts.jsp">
			</br><img src="\Contactsv1.4\images\add2.png" height="50" width="50"></a>
			<form action="Find" method="get"></br></br>
			Search:<input type="text" name="name">
			
			<input type="submit" value="ok"></br>
			</form>
			<form action="Find?showAll=true" method="get">
			<input type="submit" value="Show All Contacts">
			</form>

			 <% 
				
				
					ArrayList<Contact>contacts=(ArrayList<Contact>)request.getSession().getAttribute("contacts");
					request.getSession().removeAttribute("contacts");
					if(contacts!=null)
					{
						for(Contact contact:contacts){%>
							
						<div id="top">
							<a href="Find?name=<%=contact.name%>&phone=<%=contact.phone%>&id=<%=contact.id%>"><% out.println("Name:"+contact.name);%></a></br>
							<%out.println("Phone:"+contact.phone);%>
						</div></br>
							
						<%
						
						}
					}
					
		%>
		
		
	</body>
</html>