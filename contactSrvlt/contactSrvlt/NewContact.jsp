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

	
	<%@ page import="com.lxisoft.controller.*,java.util.*,com.lxisoft.model.*,java.sql.*"%>
<form action="save" method="get">
<%

 try{
		
        String name=request.getParameter("name"); 
		String phone=request.getParameter("phoneNumber");
		String place=request.getParameter("place");
		String emailId=request.getParameter("email");

		request.setAttribute("a",name);
		request.setAttribute("b",phone);
		request.setAttribute("c",place);
		request.setAttribute("d",emailId);
		
		out.println("<<<<<<<<<<<<<<"+(String)request.getAttribute("a"));
		
		
		
		
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
	
<!--	<input type="hidden" placeholder="name" name="name"/>
	<input type="hidden" placeholder="phone"  name="phone"/>
	<input type="hidden" placeholder="place"  name="place"/>
	<input type="hidden" placeholder="emailId"  name="emailId"/>-->
	<input align="center" type="submit" value="Submit" class="button" >
	</form>
	
</body>
</html>