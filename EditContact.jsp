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

<%@ page import="com.lxisoft.controller.*,java.util.*,com.lxisoft.model.*" %>
<%

 try{
		
        String name=request.getParameter("name"); 
		String phone=request.getParameter("phoneNumber");
		
		String id=request.getParameter("id");
	
		
		int pId=Integer.parseInt(id);
		
		ContactController cc = new ContactController();
		
			
out.println(" "+name);
		out.println(" "+phone);
		cc.edit(pId,name,phone);
		//Set<Contact> sets  = cc.getContacts();
		
		
		
 }	
	catch(Exception e){
		System.out.println("Exception occurs"+e);
	}	

%>
</html>
	