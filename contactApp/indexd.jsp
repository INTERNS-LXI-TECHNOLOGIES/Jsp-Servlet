<%@page import="com.lxisoft.contact.Contact"%>
<%@page import="com.lxisoft.contact.ContactRepository"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.*"%>
<html>
<head>
<title>ContactApp jsp page</title>
</head>
<body>
	<%
	ContactRepository contactR=new ContactRepository();
	contactR.deleteContact(request.getParameter("dname"));
	%>

</body>
<a href="Index.html">Back to html</a>
</html>