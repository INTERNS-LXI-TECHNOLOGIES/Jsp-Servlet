<html>
<body>
<%@page import="com.lxisoft.contact.model.ContactModel,com.lxisoft.contact.repositoryimpl.RepositoryImpl"%>
<%
String oldName=request.getParameter("oldValue");
String newName=request.getParameter("newValue");
ContactModel c=new ContactModel();
RepositoryImpl repo=new RepositoryImpl();
repo.updateName(oldName,newName);
out.println("update the data from MYSQL");
%>
</body>
</html>