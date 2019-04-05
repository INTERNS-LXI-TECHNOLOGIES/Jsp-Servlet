<!DOCTYPE html>
<html>
<head>
	<title>Search Contact</title>
	<%@ page import="java.util.*" %>
</head>
<body bgcolor=#98FB98><a href=Home.jsp>Home</a><center><h1>Search Contact</h1>
<form method=get action=SearchContact>Name :<input type=text name=name><br><br>
	<button type=submit><image src=images/search.jpg height=30px width=30px></button></form></center>

		<%
		 ArrayList<String> list=(ArrayList<String>) request.getAttribute("list");
		 if(list!=null){
		String name=list.get(0);
		String phno=list.get(1);
		%>
		<center><% out.println(name+"  "+phno);

		} %></center>
</body>
</html>