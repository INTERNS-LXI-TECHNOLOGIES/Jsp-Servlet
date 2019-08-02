<html>
<body>
<%@page import="com.lxisoft.contact.model.ContactModel,com.lxisoft.contact.repositoryimpl.RepositoryImpl"%>
<%
String oldNumber=request.getParameter("oldNumber");
String newNumber=request.getParameter("newNumber");
ContactModel c=new ContactModel();
RepositoryImpl repo=new RepositoryImpl();
repo.updateNumber(oldNumber,newNumber);
out.println("update the data from MYSQL");
%>