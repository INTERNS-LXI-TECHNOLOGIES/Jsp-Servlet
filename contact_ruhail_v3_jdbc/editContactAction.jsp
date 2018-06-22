<html>
<body>
<%@ page import="com.lxisoft.controller.*,com.lxisoft.model.*,java.util.*"%>
<%
 String hidName=request.getParameter("nameHidden");
 String name=request.getParameter("name");
 String place=request.getParameter("place");
 String phone=request.getParameter("phoneNumber");
 String email=request.getParameter("email");
 ContactController contactController = new ContactController();
 Contact contact=new Contact();
 contact.setName(name);
 contact.setPlace(place);
 contact.setPhoneNumber(phone);
 contact.setEmail(email);
 contactController.editContact(contact,hidName);
 response.sendRedirect("viewContact.jsp");
%>
</body>
</html>