<!..Search Contact..>
<html>
<%@ page import = "com.lxisoft.controller.*"%> 
<%
String name = request.getParameter("search icon");

NewContactController searchContact = new NewContactController();
searchContact.searchContactName(name);

%>
</html>