<html>
<!--contacts app-->

<head>
	<title>Details</title>
	
</head>
<style>
	body
	{
		background-color:skyblue;
	}
	h1
	{
		color:White;
		text-align:center;
	}
	
	
</style>

<%@ page import="java.util.*,com.lxisoft.controller.*,com.lxisoft.model.*,java.sql.*"%>
    <% String name=request.getParameter("name");
	//out.println(""+name);
	
	
	try{
		Connection conn = null;
		Statement stmt = null;
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcontact", "root", "root");

		stmt = conn.createStatement();
		String sql = "select name,phone from contacts where name='"+name+"'";
		
		ResultSet rs = null;
		rs = stmt.executeQuery(sql);

        while (rs.next()) {
			%>
			
	


    <body>
<p align="left">
<a href="Contact.jsp"><img src="/ContactsApp/images/homePic.jpg" width="50" height="50"></a></br></br>
</p>

<h1>Details</h1>
<p align="center">
<img src="/ContactsApp/images/contact.jpg" width="140" height="150">
</p>

<div id="mid">
<a href="Edit.jsp?name=<%=rs.getString("name")%>"><img src="/ContactsApp/images/editPic.jpg" width="50" height="50" title=editContact></a>
<a href="Delete.jsp?name=<%=rs.getString("name")%>"><img src="/ContactsApp/images/deletePic.jpg" width="50" height="50" title=deleteContact></a>
<link rel="stylesheet" type="text/css" href="Sample.css"/>
</div>

			<%out.println(" "+rs.getString("name"));%></br>
			<%out.println(" "+rs.getString("phone"));%></br>
			<%
		}
		
	}
	catch(Exception e){
		
		System.out.println(e);
	}
		%>
        
	
</body>
			

</html>