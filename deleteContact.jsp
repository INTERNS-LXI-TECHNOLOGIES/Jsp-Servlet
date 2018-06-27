
<html>
<body>
<%@ page import="com.lxisoft.controller.*,com.lxisoft.model.*,java.util.*"%>
<%
 String name=request.getParameter("name");
 ContactController contactController = new ContactController();
 Set<Contact> contacts=contactController.viewContact();
 for(Contact c:contacts)
 {
	if(name.equals(c.getName()))
	{
		contactController.deleteContact(c);
	}
 }
 response.sendRedirect("viewContact.jsp");
%>
</body>
</html>