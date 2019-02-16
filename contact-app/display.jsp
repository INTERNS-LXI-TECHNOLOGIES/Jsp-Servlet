<!DOCTYPE html>
<html>
<head>
	<title>displaying</title>
</head>
<%@ page import="java.util.*,com.lxisoft.controller.*,com.lxisoft.model.*"%>
    <% 
	{
	Contact contact;
			
		
		%>
<body>

	<% out.println(contact.getName());%>
	<% out.println(contact.getPhno());%>
	<%
}
%>



</body>
</html>