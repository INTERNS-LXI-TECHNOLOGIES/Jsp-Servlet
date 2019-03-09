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

<%@  page import = "com.lxisoft.contactapp.web.*,java.util.*,com.lxisoft.contactapp.model.*,javax.servlet.ServletException,javax.servlet.http.* "%>

<body>

	<%
	ArrayList<Contact> conlist=new ArrayList<Contact>();
	conlist=(ArrayList<Contact>)request.getAttribute("list");
	%>
	<h1><i>Contacts</i></h1>
	<table>
	<tr><th>Name</th><th>Phone</th><th>Number</th><th>Email</th></tr>
	<%for(Contact con:conlist){
			%>
	
	
					<tr>
					<td><%=con.getName()%></td>
					<td><%=con.getPhone()%></td>
					<td><%=con.getNumber()%></td>
					<td><%=con.getEmail()%></td>
					</tr>
		<%
	}%>
	</form>
	
	<a href="DeleteContact.jsp"><img src="/contactApp/images/delete.png" height="40" width></a>
	<a href="EditContact.jsp"><img src="/contactApp/images/edit.jpg" height="40" width></a><br>
	<a href="Home.jsp"><img src="/contactApp/images/homeIcon.ico" height="40" width></a>
	
	
</body>

</html>