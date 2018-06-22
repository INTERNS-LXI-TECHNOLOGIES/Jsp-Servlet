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
contactController.addContact(name,place,phone,email);
response.sendRedirect("home.jsp?success");
}
catch(Exception ex)
{
	ex.printStackTrace();
}
%>
</body>
</html>