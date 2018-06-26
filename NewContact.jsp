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
		String sid=request.getParameter("id");
		int id;
		ContactController cc = ContactController.getInstance();
		if(sid==null)
			{
				id=(cc.getContacts().size()+1);
			}
			else
			{
				id=Integer.parseInt(sid);
			}
			
			
			System.out.println("add2/id=="+id);
			if(id!=0){
			cc.save(id,name,phone);
			}
		
		//cc.addContact(id,name,phone);
		List<Contact> sets  = cc.getContacts();
		
		//for(Contact contact:sets)
		//out.println("Setttttttttttt "+contact.getName());
		%>
		<%out.println(" "+name);%></br>
		<%out.println(" "+phone);%></br>
		
		
<% }	
	catch(Exception e){
		System.out.println("Exception occurs"+e);
	}	
	
	%>
	
</body>
</html>