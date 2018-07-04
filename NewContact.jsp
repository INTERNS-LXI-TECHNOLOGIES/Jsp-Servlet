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
<a href="Contact.jsp"><img src="/ContactsApp/images/homePic.jpg" width="50" height="50"></a></br></br>
<p align="center">
<img src="/ContactsApp/images/contact.jpg" width="140" height="150"></br></br></br></br>
</p>
<link rel="stylesheet" type="text/css" href="Sample.css"/>
</div>

	
	<%@ page import="com.lxisoft.controller.*,java.util.*,com.lxisoft.model.*,java.sql.*" %>
	<form action="processing" method ="post">
<%

		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		//out.println("haihellooo");
		
		%>
		<input type="hidden" value="<%=name%>" name="name"/>
		<input type="hidden" value="<%=phone%>" name="phone"/>
		<input  type="submit" value="Proceed" >
		
		</form>

	<%out.println(" "+name);%></br>
	<%out.println(" "+phone);%></br>
	
	
	
</body>
</html>