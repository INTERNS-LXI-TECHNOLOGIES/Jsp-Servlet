<%@page import="com.lxisoft.contact.* "%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<html>
<head>
	<title>Edit Page</title>
	<link rel="stylesheet" href="Style.css">
</head>
<body>
<h2>Contact List</h2>
	<table>
		<tr>
			<th>Id.</th>
			<th>Name</th>
			<th>Contact Number</th>
		</tr>

	<%
		RepoImpl repoImpl=new RepoImpl();
		ArrayList<Contact> contactList=repoImpl.viewContact();
		
		for(int i=0;i<contactList.size();i++)
		{ 
	%>
			<tr>
				<td><%out.println(contactList.get(i).getId());%></td>
				<td><%out.println(contactList.get(i).getName());%></td>
				<td><%out.println(contactList.get(i).getNumber());%></td>
			</tr>
			<!-- System.out.println(contactList.get(i).getId()+"\t"+contactList.get(i).getName()+"\t"+contactList.get(i).getNumber()); -->
		<% }%>
</table>
	
	
	<form action="edit" method="post">
		<div class="container">

			Enter id for updation:<input type="text" placeholder="Enter id" name="id"></br></br>
			
			New name		:<input type="text" placeholder="Enter New Name" name="Name"></br></br>
			New Contact Number:<input type="text" placeholder="Enter New Number" name="ContactNumber"></br>
			<button type="submit" value="Submit">Submit</button>
			<button type="reset" value="Reset">Reset</button>
		</div>
	</form>
	<a href="Home.html">Back to Home</a>
</body>
</html>
