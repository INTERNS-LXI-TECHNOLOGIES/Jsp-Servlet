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
	conlist=(ArrayList<Contact>)request.getAttribute("contacts");
	String searchName=request.getParameter("searchName");
	%>
	<h1><i>Contacts</i></h1>
	<table>
	<tr><th>Name</th><th>Phone</th><th>Number</th><th>Email</th></tr>
	<%for(Contact con:conlist){
		if(con.getName().equals(searchName)){
			%>
	
	
					<tr>
					<td><%=con.getName()%></td>
					<td><%=con.getPhone()%></td>
					<td><%=con.getNumber()%></td>
					<td><%=con.getEmail()%></td>
					</tr>
		<%}
	}%>
	</form>
	
	<a href="DeleteContact.jsp"><img src="/contactappv2/images/delete.png" height="30" width></a>
	<a href="EditContact.jsp"><img src="/contactappv2/images/edit.jpg" height="30" width></a><br>
	<a href="Home.jsp"><img src="/contactappv2/images/homeIcon.ico" height="30" width></a>
	
	
</body>

</html>