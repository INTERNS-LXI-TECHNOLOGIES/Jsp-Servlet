<%@ page import= "com.lxisoft.contact.ContactModel"%>
<%@ page import= "com.lxisoft.contact.RepositoryImpl"%>
<%@ page import="java.sql.*"%>

<%
	RepositoryImpl ri=new RepositoryImpl();

%>
<html>
    <head>
    <title> Remove </title>
</head>
<body>
<%
int id=Integer.parseInt(request.getParameter("Id"));
//out.println("$"+id);
ri.deleteContact(id);
%>
<a href="Delete.jsp"><tr>go back</tr></br></br></a>
</body>
</html>