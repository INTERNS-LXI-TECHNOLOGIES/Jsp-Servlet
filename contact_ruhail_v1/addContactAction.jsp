<html>
<head></head>
<body>
<%@ page import="com.lxisoft.controller.*,com.lxisoft.model.*" %>
<%
try
{
String name=request.getParameter("name");
String place=request.getParameter("place");
String phone=request.getParameter("phoneNumber");
String email=request.getParameter("email");
ContactController contactController = new ContactController();
String addResult=contactController.addContact(name,place,phone,email);
if(addResult=="success")
{
	response.sendRedirect("home.jsp?success");
}
else
{
	response.sendRedirect("home.jsp?failed");
}
}
catch(Exception ex)
{
	ex.printStackTrace();
}
%>
</body>
</html>