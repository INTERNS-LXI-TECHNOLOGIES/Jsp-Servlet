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
<%@ page import="com.lxisoft.controller.*,java.util.*,com.lxisoft.model.*" %>
<%

 try{
		
        String name=request.getParameter("name"); 
		String phone=request.getParameter("phoneNumber");
		String place=request.getParameter("place");
		String emailId=request.getParameter("e-mail");
		
		
		ContactController cc = new ContactController();
		int id=cc.contactList.size();
		cc.addContact(id,name,phone,place,emailId);
		//Set<Contact> sets  = cc.getContacts();
		out.println(" "+name);
		out.println(" "+phone);
		out.println(" "+place);
		out.println(" "+emailId);
 }	
	catch(Exception e){
		System.out.println("Exception occurs"+e);
	}	
	
	%>
	
	
	
</body>
</html>