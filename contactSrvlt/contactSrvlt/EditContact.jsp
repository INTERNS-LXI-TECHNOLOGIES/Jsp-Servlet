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
<%

 try{
		
        String name=request.getParameter("name"); 
		String phone=request.getParameter("phoneNumber");
		String place=request.getParameter("place");
		String emailId=request.getParameter("e-mail");
		String oldName=request.getParameter("oldName");%>
	
		
		
		
		
		
		
		<%	Connection conn = null;
			Statement stmt = null;
			
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact", "root", "root");
				stmt = conn.createStatement();
				
				//List<Contact> contacts = new ArrayList<Contact>();
			String sql = "UPDATE contable SET name='"+name+"', phoneNumber='"+phone+"',place='"+place+"',emailID='"+emailId+"' where name='"+oldName+"'";
		 //  ResultSet rs = null;
		   
		int	rs = stmt.executeUpdate(sql);
		
		
		
		String sql2="select * from contable where name='"+name+"'";
		ResultSet rst=null;
		rst=stmt.executeQuery(sql2);
		
		while(rst.next()){%>
			<%out.println(""+rst.getString("name"));%></br>
		<%out.println(""+rst.getString("phoneNumber"));%></br>
		<%out.println(""+rst.getString("place"));%></br>
		<%out.println(""+rst.getString("emailId"));%></br>
		<%}
			%>
		
		
		
 <%}	
	catch(Exception e){
		System.out.println("Exception occurs"+e);
	}	

%>
</html>
	