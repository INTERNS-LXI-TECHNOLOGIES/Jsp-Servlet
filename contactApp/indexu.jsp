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
	String editName=request.getParameter("ename");
	String newName=request.getParameter("nname");
	contactR.updateContact(editName,newName);
	%>

</body>
<a href="Index.html">Back to html</a>
</html>