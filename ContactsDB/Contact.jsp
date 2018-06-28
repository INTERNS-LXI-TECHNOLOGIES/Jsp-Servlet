<html>
<!--contacts app-->

<head>
	<title>Home</title>
	<%@ page import="com.lxisoft.controller.*,java.util.*,com.lxisoft.model.*,java.sql.*"%>
</head>
<style>
	body
	{ 
		background-color:lightblue;
	}
	h1
	{
		color:White;
		text-align:center;
	}
	
	
</style>

<body>
<div id="top">
<h1>Contacts</h1>
<p align="center">
<img src="/ContactsDB/images/contacts.jpg" width="140" height="150"></br></br></br></br>
</p>
<link rel="stylesheet" type="text/css" href="Sample.css"/>
</div>

<!--
<form>-->
	
	
	
	<!--input type="text"/-->
	<a href="AddContact.jsp"><img src="/ContactsDB/images/addContact.jpg" width="50" height="50" title=addContact></a></br></br>
	
	<!--<a href="Result.jsp"><img src="/ContactsApp/images/images.jpg" width="30" height="30"></a>
	<input type="text" placeholder="search here"/>
	
</form>	-->
<form action="Details.jsp" >


<input type="text" name="name" placeholder="search here">
<input type="submit" value="go"></br>
</form>



<div id="contact">
		
		<%
		
		try{
			Connection conn = null;
			Statement stmt = null;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact", "root", "root");
				stmt = conn.createStatement();
				
				//List<Contact> contacts = new ArrayList<Contact>();
			String sql = "SELECT * FROM contable";
		   ResultSet rs = null;
		   
			rs = stmt.executeQuery(sql);
			
			
				while (rs.next()) {%>
					
					<a href="Details.jsp?name=<%=rs.getString("name")%>"><%out.println(rs.getString("name"));%></br></a>
				<%   //Contact contact = new Contact(name,number,place,email);
				   
				  /* contact.setName(rs.getString("name"));
				   contact.setNumber(rs.getString("phoneNumber"));
				   contact.setPlace(rs.getString("place"));
				   contact.setPlace(rs.getString("email"));*/
				  // contacts.add(contact);
				  
				}
			} catch (Exception e) {
			System.out.println(e);
			}
			conn.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
			
		
		%>
			
		
		
			
		
		
</div>
</body>
</html>