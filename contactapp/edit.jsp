<%@ page import= "com.lxisoft.contact.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<html>
<head>
	
</head>
<body>
<%
String n=request.getParameter("name");
String f=request.getParameter("field");
String d=request.getParameter("data");
RepositoryImpl re=new RepositoryImpl();
re.edit(d,n,f);
%>
<h5>Contact updated...</h5>
</body>
</html>
