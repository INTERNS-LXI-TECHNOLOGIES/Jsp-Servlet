<html>

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
<%

 try{
		
        String name=request.getParameter("name"); 
		String phone=request.getParameter("phone");
		String oldName=request.getParameter("oldName"); 
		out.println(" "+name);
		out.println(" "+phone);
		Connection conn = null;
		Statement stmt = null;
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactssvlt", "root", "root");

		stmt = conn.createStatement();
		String sql = "update contactss set name='"+name+"',phone='"+phone+"' where name='"+oldName+"'";
	
		//out.println("Do you want to update this entry");
		int rs=stmt.executeUpdate(sql);
		
		String sql2 = "select * from contacts where name='"+oldName+"'";
		ResultSet rst = null;
		rst = stmt.executeQuery(sql2);
		while(rst.next())
		{
			out.println(" "+rst.getString("name"));
			out.println(" "+rst.getString("phone"));
		
		}
		
	}	
	catch(Exception e){
		System.out.println("Exception occurs"+e);
	}	

%>
</html>
	