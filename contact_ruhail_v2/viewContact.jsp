<%@ page import="com.lxisoft.controller.*,com.lxisoft.model.*,java.util.*"%>
<html>
<%
if(((String)session.getAttribute("sid"))!=null)
{
%>
<head></head>
<body>
<div style="width;100%;height:250px;background:lightblue">
<img style="align:center;width:200px;height:200px;margin-left:550px;margin-top:20px;" src="Android-Contacts-small.png"></img>
</div>


<table style="background: lightblue;margin-left: 170px;margin-top:40px; width: 70%; height: 100px; font-size: 24px; color: #fff; text-align: center;">
<tr><th>Name</th><th>Place</th><th>Phone Number</th><th>Email</th></tr>
<%
	ContactController cont=new ContactController();
	Set<Contact> contacts=cont.viewContact();
	for(Contact c:contacts)
	{
		String nam=c.getName();
%>
<tr><td><%=c.getName()%></td><td><%=c.getPlace()%></td><td><%=c.getPhoneNumber()%></td><td><%=c.getEmail()%></td><td><a href="editContact.jsp?name=<%=nam%>">Edit it</a></td><td><a href="deleteContact.jsp?name=<%=nam%>">Delete it</a></td></tr>

<%
	}
%>
</table>
</body>
<%
}
else
{
	response.sendRedirect("login.jsp");
}
	%>
</html>