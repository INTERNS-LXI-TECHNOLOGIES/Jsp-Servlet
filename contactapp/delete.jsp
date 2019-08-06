<%@ page import= "com.lxisoft.contact.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<html>
<head>
	
</head>
<body>
<%
String data=request.getParameter("name");
RepositoryImpl re=new RepositoryImpl();
re.delete(data);
%>
<h5>Contact deleted...</h5>
</body>
</html>