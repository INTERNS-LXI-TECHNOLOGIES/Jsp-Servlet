<html>
<head>


</head>
<body>
<%@page import="com.lxisoft.contact.model.ContactModel,com.lxisoft.contact.repositoryimpl.RepositoryImpl,java.util.*"%>
<%
  String delete=request.getParameter("deleteValue");
  out.println(".........."+delete);
  ContactModel c=new ContactModel();
  RepositoryImpl repo=new RepositoryImpl();
  repo.delete(delete);
%>
</body>
</html>