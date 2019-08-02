<html>
<head>
</head>
<body>
<%@page import="com.lxisoft.contact.model.ContactModel,com.lxisoft.contact.repositoryimpl.RepositoryImpl,java.util.*"%>
<%
ContactModel cm=new ContactModel();
RepositoryImpl rimpl=new RepositoryImpl();
ArrayList<ContactModel> s=rimpl.read(); 
out.println("\n"+s+"\n");
%>
</body>
</html>