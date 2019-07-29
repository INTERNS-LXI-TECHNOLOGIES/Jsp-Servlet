<%@ page import="com.lxisoft.contact.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<html>
	<head>
		<link rel="stylesheet" href="tablestyle.css">
		<link rel="stylesheet" href="homestyle.css">
		<link rel="stylesheet" href="delete.css">
	</head>
	<body>
		
			<%
				ContactRepository contactRepo=new ContactRepository();
				ArrayList<Contact> contactList=contactRepo.searchContactFromDb(request.getParameter("firstName"));
				if(contactList.size()==0)
				{
			%>
					<div class="alert">
					<span class="closebtn">&times;</span>  
					<strong>Opps!</strong> Search not found.
					</div>
					<%
				}
				else
				{
					%>
					<div class="alert info">
					<span class="closebtn">&times;</span>  
					<strong>Success!</strong>Search found.
					</div>
					<table>
						<caption><h2>Search List</h2></caption>
						<tr>
							<th>Firstname</th>
							<th>Lastname</th>
							<th>WorkPlace</th>
							<th>Mobile</th>
						</tr>
					<%
						for(int i=0;i<contactList.size();i++)
						{
					%>
							<tr>
							<td><%out.println(contactList.get(i).getFirstName());%></td>
							<td><%out.println(contactList.get(i).getLastName());%></td>
							<td><%out.println(contactList.get(i).getWorkPlace());%></td>
							<td><%out.println(contactList.get(i).getPhoneNumber());%></td>
							</tr>
					<%
						}
					%>
			<%
				}
			%>
					
				
				
		</table>
		<br><a href="home.html">Back to Home</a><br>
	</body>
</html>
