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
	ArrayList<Contact> conlist=(ArrayList<Contact>)request.getAttribute("list");
	%>
	<%Object c=application.getAttribute("contacts"); %>
	<h1><i><%=c %></i></h1></br>
	<table>
	<tr><th>Name</th><th>Phone</th><th>Number</th><th>Email</th></tr>
	<%for(Contact con:conlist){
			%>
	
	
					<tr>
					<td><%=con.getFirstName()%><%=con.getLastName()%></td>
					<td><%=con.getPhone()%></td>
					<td><%=con.getNumber()%></td>
					<td><%=con.getEmail()%></td>
					<% pageContext.setAttribute("sName", con.getFirstName(), pageContext.SESSION_SCOPE);%>
					<td><a href=DeleteContact.jsp><img src="/contactappv1/images/delete.png" height="30" width></a></td>
					<td><a href="EditContact.jsp"><img src="/contactappv1/images/edit.jpg" height="30" width></a></td>
					</tr>
		<%
	}%>
	</form>
	
	
	<a href="AddContact.jsp"><center><img src="/contactappv1/images/add3.jpg" height="30" width></a>
	<a href="Home.jsp"><img src="/contactappv1/images/homeIcon.ico" height="30" width></a>
	
	
</body>

</html>