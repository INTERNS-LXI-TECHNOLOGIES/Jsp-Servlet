<!DOCTYPE html>
<html>
<head>
	<title>Contact App</title>
</head>
<%@ page import="java.util.Locale,java.util.ResourceBundle"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<body bgcolor="#ccffcc" align="center">
<%
	Locale l=null;
	if((String)request.getAttribute("lang")!=null){
		l=new Locale((String)request.getAttribute("lang"));
	}
	else{
		
		
		
		
		
		l=new Locale("eng");
	}
	ResourceBundle r=ResourceBundle.getBundle("lang",l);
%>

	<h1 align="center"><%=r.getString("ContactApp")%></h1>
	<img src="images/homeimg.jpg"><br><br>
	<p><b> {{<%=r.getString("AddContact")%>}}  {{<%=r.getString("ContactList")%>}}  {{<%=r.getString("SearchContact")%>}}</b></p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	<a href="AddContact.jsp"><img src="images/add.jpg" width="30px" height="30px"></a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	<a href="AddContact"><img src="images/contactlist.jpg" height="30px" width="30px"></a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	<a href="Search.jsp"><img src="images/search1.jpg" height="30px" width="30px"></a>
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<br><br>

<button  onclick="window.location.href='lang?l=eng'" >English</button>
<button  onclick="window.location.href='lang?l=mal'" >മലയാളം</button>
<button  onclick="window.location.href='lang?l=hin'" >हिंदी</button>
<br>
<br>
<% 
	Object rs=null;
	rs=session.getAttribute("result");
	if(rs=="update")
	{%>
		<b><% out.println("Updated Successfully");%></b>
	
	<%
	session.setAttribute("result",null);
}%>
<% if(rs=="delete")
{%>
<b><% out.println("Contact Deleted");%></b>

<%
session.setAttribute("result",null);
}%>
</body>
</html>