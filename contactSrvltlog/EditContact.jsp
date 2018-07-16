	<html>
<!--String redirect="Contact.jsp";-->
		<!--response.sendRedirect(redirect);-->

<head>
	<title></title>
</head>
<body>

<div id="top">
<h1>Contacts</h1>
<p align="left">
<a href="Contact.jsp"><img src="/ContactsApp/images/home.jpg" width="50" height="50"></a></br></br>
<p align="center">
<img src="/ContactsApp/images/contacts.jpg" width="140" height="150"></br></br></br></br>
</p>
<link rel="stylesheet" type="text/css" href="Sample.css"/>
</div>

<%@ page import="com.lxisoft.controller.*,java.util.*,com.lxisoft.model.*,java.sql.*" %>

<form action="delete" method="post">

<%
try{
 
		
        String name=request.getParameter("name"); 
		String phone=request.getParameter("phoneNumber");
		String place=request.getParameter("place");
		String emailId=request.getParameter("e-mail");
		String oldName=request.getParameter("oldName");%>
		
		
		
		
		
		<%out.println(""+name);%></br>
		<%out.println(""+phone);%></br>
		<%out.println(""+place);%></br>
		<%out.println(""+emailId);%></br>
		
		
		<%request.getSession().setAttribute("i",name);
		request.getSession().setAttribute("j",phone);
		request.getSession().setAttribute("k",place);
		request.getSession().setAttribute("l",emailId);
		request.getSession().setAttribute("m",oldName);
		
}
catch(Exception e){
	out.println(e);
}
		
		%>
	
<input align="center" type="submit" value="Submit" class="button" >
		<input  type="reset" value="Cancel" class="button" >
		</form>
</html>
	