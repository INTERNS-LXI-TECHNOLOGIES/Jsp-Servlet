<%@ page import="com.lxisoft.controller.*,com.lxisoft.model.*,java.util.*"%>
<html>
<head></head>
<body>
<table style="background: lightblue;margin-left: 130px;margin-top:100px; width: 70%; height: 100px; font-size: 24px; color: #fff; text-align: center;">
<tr><th>Name</th><th>Place</th><th>Phone Number</th><th>Email</th></tr>
<%
	ContactController cont=new ContactController();
	Set<Contact> contacts=cont.viewContact();
	for(Contact c:contacts)
	{
%>
<tr><td><%=c.getName()%></td><td><%=c.getPlace()%></td><td><%=c.getPhoneNumber()%></td><td><%=c.getEmail()%></td></tr>

<%
	}
%>
</table>
</body>
</html>