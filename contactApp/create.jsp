<html>
<body>
<%@ page import="com.lxisoft.contact.model.ContactModel,com.lxisoft.contact.repositoryimpl.RepositoryImpl"%>
<%
String uname=request.getParameter("username");
String pnumber=request.getParameter("phonenumber");
ContactModel c=new ContactModel();
c.setName(uname);
c.setNumber(pnumber);
RepositoryImpl repo=new RepositoryImpl();
String s=repo.add(c.getName(),c.getNumber());
out.println(s);
%>

</body>
</html>