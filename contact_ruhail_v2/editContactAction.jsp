<html>
<body>
<%@ page import="com.lxisoft.controller.*,com.lxisoft.model.*,java.util.*"%>
<%
 String name=request.getParameter("name");
 String place=request.getParameter("place");
 String phone=request.getParameter("phoneNumber");
 String email=request.getParameter("email");
 ContactController contactController = new ContactController();
 Set<Contact> contacts=contactController.viewContact();
 for(Contact c:contacts)
 {
	if(name.equals(c.getName()))
	{
		contactController.editContact(c,name,place,phone,email);
	}
 }
 response.sendRedirect("viewContact.jsp");
%>
</body>
</html>