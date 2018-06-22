<%@ page import="com.lxisoft.controller.*,java.util.*"%>
<%
String searchValue=request.getParameter("search");
ContactController contactController=new ContactController();
Set c=contactController.searchContact(searchValue);
request.setAttribute("contacts",c);
RequestDispatcher rd=request.getRequestDispatcher("searchContact.jsp");
rd.forward(request,response);
%>