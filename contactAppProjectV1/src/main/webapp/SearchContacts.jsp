<!DOCTYPE html>
<html>
<head>
<title> Add Contact </title>
</head>
	<style>
		body
			{
			background-color:cyan;
			}
		table, th, td {
			background-color: #f1f1c1;
			border: 1px solid black;
			border-collapse: collapse;
			}
			th {
				text-align: left;
				}
	</style>	

<%@  page import = "com.lxisoft.web.*,java.util.*,com.lxisoft.model.*,javax.servlet.ServletException,javax.servlet.http.* "%>

<body>

	<%
	ArrayList<Contact> conlist=(ArrayList<Contact>)request.getAttribute("list");
	%>
	<h1><i>Contacts</i></h1>
	<table>
	<tr><th>Name</th><th>Phone</th><th>Number</th><th>Email</th></tr>
	<%for(Contact con:conlist){
			%>
	
	
					<tr>
					<td><%=con.getFirstName()%><%=con.getLastName()%></td>
					<td><%=con.getPhone()%></td>
					<td><%=con.getNumber()%></td>
					<td><%=con.getEmail()%></td>
					</tr>
		<%
	}%>
	</form>
	
	<a href="DeleteContact.jsp"><img src="/contactAppProjectV1/images/delete.png" height="30" width></a>
	<a href="EditContact.jsp"><img src="/contactAppProjectV1/images/edit.jpg" height="30" width></a><br>
	<a href="Home.jsp"><img src="/contactAppProjectV1/images/homeIcon.ico" height="30" width></a>
	
	
</body>

</html>