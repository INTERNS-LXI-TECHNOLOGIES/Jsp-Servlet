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
<a href="Contact.jsp"><img src="/ContactsDB/images/home.jpg" width="50" height="50"></a></br></br>
<p align="center">
<img src="/ContactsDB/images/contacts.jpg" width="140" height="150"></br></br></br></br>
</p>
<link rel="stylesheet" type="text/css" href="Sample.css"/>
</div>

	
	<%@ page import="com.lxisoft.controller.*,java.util.*,com.lxisoft.model.*,java.sql.*"%>
<form action="save" method="post">
<%

 try{
		
        String name=request.getParameter("name"); 
		String phone=request.getParameter("phoneNumber");
		String place=request.getParameter("place");
		String emailId=request.getParameter("email");
		
		request.getSession().setAttribute("a",name);
		request.getSession().setAttribute("b",phone);
		request.getSession().setAttribute("c",place);
		request.getSession().setAttribute("d",emailId);
		
		//out.println("<<<<<<<<<<<<<<"+(String)request.getAttribute("c"));
		
		
		
		
		%>
		<%out.println(" "+name);%></br>
		<%out.println(" "+phone);%></br>
		<%out.println(" "+place);%></br>
		<%out.println(" "+emailId);%></br>
<% }	
	catch(Exception e){
		System.out.println("Exception occurs"+e);
	}
	
	
	%>
	
	<input type="hidden" placeholder="name" name="name"/>
	<input type="hidden" placeholder="phone"  name="phone"/>
	<input type="hidden" placeholder="place"  name="place"/>
	<input type="hidden" placeholder="emailId"  name="emailId"/>
	<input align="center" type="submit" value="Submit" >
	</form>
	
</body>
</html>